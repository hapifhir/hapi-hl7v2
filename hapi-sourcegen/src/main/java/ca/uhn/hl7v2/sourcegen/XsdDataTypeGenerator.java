/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "XsdDataTypeGenerator.java".  Description:
 "Create HAPI datatype model classes from XSD"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.sourcegen;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;
import com.sun.xml.xsom.*;
import com.sun.xml.xsom.parser.XSOMParser;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

/**
 * Create HAPI datatype model classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdDataTypeGenerator {

    private static final String[] PRIMITIVES = {"FT", "GTS", "NM", "SI", "ST", "TN",  "TX"};
    private static final String[] EXCLUDE_COMPOSITES = {"TX_CHALLENGE", "escapeType", "varies"};

    public static final String URN_HL7_ORG_V2XML = "urn:hl7-org:v2xml";

    private String templatePackage;
    private String targetDirectory;

    public XsdDataTypeGenerator(String dir, String templatePackage) throws IOException {
        File f = new File(dir);
        if (!f.isDirectory())
            throw new IOException("Can't create file in " +
                    dir.toString() + " - it is not a directory.");
        this.targetDirectory = dir;
        this.templatePackage = templatePackage.replace(".", "/");
    }

    public void parse(Version version) throws Exception {

        XSOMParser parser = new XSOMParser();
        String dir = String.format("/hl7v2xsd/%s/datatypes.xsd", version.getVersion());
        InputStream is = getClass().getResourceAsStream(dir);
        parser.parse(is);
        XSSchemaSet result = parser.getResult();
        Iterator<XSSchema> iter = result.iterateSchema();
        while (iter.hasNext()) {
            XSSchema schema = iter.next();
            if (URN_HL7_ORG_V2XML.equals(schema.getTargetNamespace())) {
                parsePrimitives(schema, version);
                parseComposites(schema, version);
            }
        }
    }

    private void parsePrimitives(XSSchema schema, Version version) throws Exception {
        List<DatatypeDef> primitiveTypes = new ArrayList<DatatypeDef>();
        Iterator<XSType> types = schema.iterateTypes();
        while (types.hasNext()) {
            XSType type = types.next();
            String dataTypeName = type.getName();
            if (Arrays.binarySearch(PRIMITIVES, dataTypeName) >= 0)
                primitiveTypes.add(new DatatypeDef(dataTypeName, dataTypeName));
        }

        Template template = VelocityFactory.getClasspathTemplateInstance(templatePackage + "/datatype_primitive.vsm");
        String basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
        String normalBasePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());

        for (DatatypeDef def : primitiveTypes) {
            String source = make(template, basePackageName, normalBasePackageName, def, version.getVersion());
            if (source != null) {
                writeFile(source, def, version);
            }
        }
    }

    private void parseComposites(XSSchema schema, Version version) throws Exception {
        List<DatatypeDef> compositeTypes = new ArrayList<DatatypeDef>();
        Iterator<XSComplexType> types = schema.iterateComplexTypes();
        while (types.hasNext()) {
            XSComplexType complexType = types.next();
            String dataTypeName = complexType.getName();

            // Omit CE_X types
            if (dataTypeName.startsWith("CE_")) dataTypeName = "CE";

            if (isRealComposite(dataTypeName)) {
                DatatypeDef compositeType = new DatatypeDef(dataTypeName, dataTypeName);
                XSParticle[] children = complexType
                        .getContentType()
                        .asParticle()
                        .getTerm()
                        .asModelGroup()
                        .getChildren();
                for (int i = 0; i < children.length; i++) {
                    XSAttGroupDecl attrGroup = children[i]
                            .getTerm()
                            .asElementDecl()
                            .getType()
                            .asComplexType()
                            .getAttGroups().iterator().next();
                    String componentType = attrGroup.getAttributeUse("", "Type").getFixedValue().toString();
                    String componentDescription = attrGroup.getAttributeUse("", "LongName").getFixedValue().toString();
                    XSAttributeUse componentTable = attrGroup.getAttributeUse("", "Table");
                    int table = 0;
                    if (componentTable != null)
                        table = Integer.parseInt(componentTable.getFixedValue().toString().substring(3));

                    compositeType.addSubcomponentDef(
                            new DatatypeComponentDef(
                                    dataTypeName,
                                    i,
                                    fixTypeName(dataTypeName, componentType),
                                    componentDescription,
                                    table));
                }
                compositeTypes.add(compositeType);
            }

        }

        Template template = VelocityFactory.getClasspathTemplateInstance(templatePackage + "/datatype_composite.vsm");
        String basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
        String normalBasePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());

        for (DatatypeDef def : compositeTypes) {
            String source = make(template, basePackageName, normalBasePackageName, def, version.getVersion());
            if (source != null) {
                writeFile(source, def, version);
            }
        }
    }

    // Really need all of this?
    private static String fixTypeName(String parentName, String dataTypeName) {
        if (dataTypeName.equals("ST") && parentName.equals("TS")) return "TSComponentOne";
        //convert to varies to Varies
        if (dataTypeName.equals("varies")) return "Varies";

        // Null/withdrawn
        if (dataTypeName.equals("NUL")) return "NULLDT";
        if (dataTypeName.equals("-")) return "NULLDT";

        return dataTypeName;
    }

    private boolean isRealComposite(String dataTypeName) {
        return Arrays.binarySearch(PRIMITIVES, dataTypeName) < 0 &&
                Arrays.binarySearch(EXCLUDE_COMPOSITES, dataTypeName) < 0 &&
                dataTypeName.indexOf('.') < 0;
    }

    private void writeFile(String source, DatatypeDef def, Version version) throws IOException {
        // TODO must be more robust
        String dirName = String.format("%s/ca/uhn/hl7v2/model/%s/datatype/", targetDirectory, version.getPackageVersion());
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String targetFile = String.format("%s/%s.java", dirName, def.getType());

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile, false), "UTF-8"));
            writer.write(source);
            writer.flush();
        } finally {
            if (writer != null) writer.close();
        }
    }

    private String make(Template template, String basePackageName, String normalBasePackageName,
                        DatatypeDef def, String version) throws Exception {
        StringWriter out = new StringWriter();
        Context ctx = new VelocityContext();
        ctx.put("datatype", def);
        ctx.put("datatypeName", def.getType());
        ctx.put("version", version);
        ctx.put("basePackageName", basePackageName);
        ctx.put("normalBasePackageName", normalBasePackageName);
        ctx.put("components", def.getSubComponentDefs());
        ctx.put("desc", def.getName());

        template.merge(ctx, out);
        return out.toString();
    }


    public static void main(String... args) {
        try {
            XsdDataTypeGenerator xdtg = new XsdDataTypeGenerator("C:/temp", "/ca.uhn.hl7v2.sourcegen.templates");
            long start = System.currentTimeMillis();
            for (Version version : Version.values()) {
                System.out.println("Creating data types for " + version);
                xdtg.parse(version);
            }
            System.out.println("Done in " + (System.currentTimeMillis() - start) + " ms.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
