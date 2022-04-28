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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;
import com.sun.xml.xsom.XSAttGroupDecl;
import com.sun.xml.xsom.XSAttributeUse;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create HAPI datatype model classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdDataTypeGenerator extends AbstractXsdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdDataTypeGenerator.class);
    private static final String[] PRIMITIVES = {"FT", "GTS", "NM", "SI", "ST", "TN", "TX"};
    private static final String[] EXCLUDE_COMPOSITES = {"TX_CHALLENGE", "escapeType", "varies"};

    public XsdDataTypeGenerator(String templatePackage, String targetDirectory) {
        super(templatePackage, targetDirectory);
    }


    @Override
    protected void doParse(XSSchema schema, Version version) {
        parsePrimitives(schema, version);
        parseComposites(schema, version);
    }

    private void parsePrimitives(XSSchema schema, Version version) {
        List<DatatypeDef> primitiveTypes = asStream(schema.iterateTypes())
                .filter(type -> Arrays.binarySearch(PRIMITIVES, type.getName()) >= 0)
                // TODO description of data type?
                .map(type -> new DatatypeDef(type.getName(), type.getName()))
                .collect(Collectors.toList());
        writeDatatype("/datatype_primitive.vsm", version, primitiveTypes);
    }

    private void parseComposites(XSSchema schema, Version version) {
        List<DatatypeDef> compositeTypes = asStream(schema.iterateComplexTypes())
                .filter(type -> isRealComposite(type.getName()))
                .map(this::makeComplexDataType)
                .collect(Collectors.toList());

        writeDatatype("/datatype_composite.vsm", version, compositeTypes);
    }

    private DatatypeDef makeComplexDataType(XSComplexType complexType) {
        // TODO description for complexTypes?
        DatatypeDef compositeType = new DatatypeDef(complexType.getName(), complexType.getName());
        // Extract list of components from the composite type
        XSParticle[] children = complexType
                .getContentType()
                .asParticle()
                .getTerm()
                .asModelGroup()
                .getChildren();
        // Iterate over all components
        for (int i = 0; i < children.length; i++) {
            XSComplexType type = children[i]
                    .getTerm()
                    .asElementDecl()
                    .getType()
                    .asComplexType();
            XSAttGroupDecl attrGroup = type.getAttGroups().iterator().next();
            // String componentType = attrGroup.getAttributeUse("", "Type").getFixedValue().toString();
            String componentType = type.getBaseType().getName();
            String componentDescription = attrGroup.getAttributeUse("", "LongName").getFixedValue().toString();
            XSAttributeUse componentTable = attrGroup.getAttributeUse("", "Table");
            int table = componentTable != null ?
                    Integer.parseInt(componentTable.getFixedValue().toString().substring(3)) :
                    0;
            compositeType.addSubcomponentDef(
                    new DatatypeComponentDef(
                            complexType.getName(),
                            i,
                            fixTypeName(complexType.getName(), componentType),
                            componentDescription,
                            table));
        }
        return compositeType;
    }

    private void writeDatatype(String x, Version version, List<DatatypeDef> primitiveTypes) {
        Template template = VelocityFactory.getClasspathTemplateInstance(templatePackage + x);

        String basePackageName, normalBasePackageName;
        try {
            basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
            normalBasePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
        } catch (HL7Exception e) {
            throw new RuntimeException(e);
        }

        for (DatatypeDef def : primitiveTypes) {
            String source = makeDatatype(template, basePackageName, normalBasePackageName, def, version.getVersion());
            if (source != null) {
                String dirName = String.format("model/%s/datatype", version.getPackageVersion());
                String fileName = String.format("%s.java", def.getType());
                writeFile(source, dirName, fileName);
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

    private static boolean isRealComposite(String dataTypeName) {
        return Arrays.binarySearch(PRIMITIVES, dataTypeName) < 0 &&
                Arrays.binarySearch(EXCLUDE_COMPOSITES, dataTypeName) < 0 &&
                dataTypeName.indexOf('.') < 0;
    }

    private static String makeDatatype(Template template, String basePackageName, String normalBasePackageName, DatatypeDef def, String version) {
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

    public static void generateDataTypes(String templatePackage, String sourceDirectory, String targetDirectory, String version) throws Exception {
        XsdDataTypeGenerator xdtg = new XsdDataTypeGenerator(templatePackage, targetDirectory);
        LOG.info("Creating data types for {}", version);
        xdtg.parse(Version.versionOf(version), sourceDirectory, "segments.xsd");
    }

}
