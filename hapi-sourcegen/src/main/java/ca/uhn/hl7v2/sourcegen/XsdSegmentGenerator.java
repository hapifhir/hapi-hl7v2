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
import java.net.URL;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create HAPI segment model classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p/>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdSegmentGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdSegmentGenerator.class);
    private static final String[] EXCLUDE_SEGMENTS = {"anyHL7Segment", "anyZSegment"};

    public static final String URN_HL7_ORG_V2XML = "urn:hl7-org:v2xml";

    private String templatePackage;
    private String targetDirectory;

    public XsdSegmentGenerator(String dir, String templatePackage) throws IOException {
        File f = new File(dir);
        if (!f.isDirectory())
            throw new IOException("Can't create file in " + dir + " - it is not a directory.");
        this.targetDirectory = dir;
        this.templatePackage = templatePackage.replace(".", "/");
    }

    public void parse(Version version) throws Exception {
        XSOMParser parser = new XSOMParser();
        String dir = String.format("/hl7v2xsd/%s/segments.xsd", version.getVersion());
        URL url = getClass().getResource(dir);
        parser.parse(url);
        XSSchemaSet result = parser.getResult();
        Iterator<XSSchema> iter = result.iterateSchema();
        while (iter.hasNext()) {
            XSSchema schema = iter.next();
            if (URN_HL7_ORG_V2XML.equals(schema.getTargetNamespace())) {
                parseSegments(schema, version);
            }
        }
    }

    //<xsd:complexType name="PD1.CONTENT">
    //<xsd:sequence>
    //<xsd:any namespace="##other" processContents="lax" minOccurs="0"/>
    //</xsd:sequence>
    //</xsd:complexType>
    //<xsd:element name="PD1" type="PD1.CONTENT"/>

    private void parseSegments(XSSchema schema, Version version) throws Exception {

        Template template = VelocityFactory.getClasspathTemplateInstance(templatePackage + "/segment.vsm");
        String basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
        String[] datatypePackages = { basePackageName + "datatype" };

        Iterator<XSElementDecl> segmentDecls = schema.iterateElementDecls();
        while (segmentDecls.hasNext()) {
            XSElementDecl segmentDecl = segmentDecls.next();
            String segmentName = segmentDecl.getName();
            if (isRealSegment(segmentName)) {

                List<SegmentElement> segmentsElements = new ArrayList<SegmentElement>();
                XSComplexType complexType = segmentDecl.getType().asComplexType();
                // Find and iterate over the fields of the segment
                XSParticle[] children = complexType
                        .getContentType()
                        .asParticle()
                        .getTerm()
                        .asModelGroup()
                        .getChildren();
                LOG.debug("Creating segment {}, having {} children", segmentName, children.length);
                for (int i = 0; i < children.length; i++) {
                    // Navigate to the attributes
                    if (!children[i].getTerm().isWildcard()) {
                        XSAttGroupDecl attrGroup = children[i]
                                .getTerm()
                                .asElementDecl()
                                .getType()
                                .asComplexType()
                                .getAttGroups().iterator().next();
                        LOG.debug("Field {}", attrGroup.getName());
                        String fieldType = attrGroup.getAttributeUse("", "Type").getFixedValue().toString();
                        String fieldDescription = attrGroup.getAttributeUse("", "LongName").getFixedValue().toString();
                        XSAttributeUse fieldLength = attrGroup.getAttributeUse("", "maxLength");
                        int maxLength = 0;
                        if (fieldLength != null)
                            maxLength = Integer.parseInt(fieldLength.getFixedValue().toString());
                        XSAttributeUse fieldTable = attrGroup.getAttributeUse("", "Table");
                        int table = 0;
                        if (fieldTable != null)
                            table = Integer.parseInt(fieldTable.getFixedValue().toString().substring(3));
                        SegmentElement se = new SegmentElement(segmentName, version.getVersion(), i);
                        se.field = i;
                        if (children[i].getMaxOccurs().intValue() == XSParticle.UNBOUNDED) {
                            se.rep = "Y";
                            se.repetitions = 0;
                        } else {
                            se.rep = "N";
                            se.repetitions = 1;
                        }
                        se.opt = children[i].getMinOccurs().intValue() > 0 ? "R" : "O";
                        se.desc = fieldDescription;
                        se.table = table;
                        se.type = fieldType;
                        fixType(i + 1, version, se);
                        se.length = maxLength;
                        segmentsElements.add(se);
                    }
                }
                // need to add better segement description here, but nothing in XSD!
                writeSegment(template, basePackageName, datatypePackages,
                        segmentName, segmentName, version, segmentsElements);
            }

        }

    }

    private void writeSegment(Template template, String basePackageName, String[] datatypePackages,
                              String segmentName, String segmentDescription, Version version,
                              List<SegmentElement> segmentsElements) throws Exception {
        String source = make(template, basePackageName, datatypePackages,
                segmentName, segmentDescription, version.getVersion(), segmentsElements);
        if (source != null) {
            writeFile(source, segmentName, version);
        }
    }

    /**
     * This method can be used to circumvent errors in the XSDs without the need to
     * modify the XDS.
     *
     * @param index
     * @param version
     * @param se
     */
    private static void fixType(int index, Version version, SegmentElement se) {
        // Null/withdrawn
        if (se.type.equals("NUL") || se.type.equals("-")) {
            se.type = "NULLDT";

        // 3454369
        } else if (version == Version.V23 && se.type.equals("MRG") && index == 7) {
            se.type = "XPN";

        // https://sourceforge.net/p/hl7api/bugs/95/
        } else if (version == Version.V23 && se.type.equals("ORC") && index == 14) {
            se.type = "XTN";

        // 2864817
        } else if (version == Version.V23 && se.type.equals("PID") && index == 5) {
            se.rep = "Y";
            se.repetitions = -1;
        }
    }

    private boolean isRealSegment(String dataTypeName) {
        return Arrays.binarySearch(EXCLUDE_SEGMENTS, dataTypeName) < 0 &&
                dataTypeName.indexOf('.') < 0;
    }

    private void writeFile(String source, String segmentName, Version version) throws IOException {
        // TODO must be more robust
        String dirName = String.format("%s/ca/uhn/hl7v2/model/%s/segment/", targetDirectory, version.getPackageVersion());
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String targetFile = String.format("%s/%s.java", dirName, segmentName);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile, false), "UTF-8"));
            writer.write(source);
            writer.flush();
        } finally {
            if (writer != null) writer.close();
        }
    }

    private String make(Template template, String normalBasePackageName, String[] datatypePackages,
                        String segmentName, String description, String version, List<SegmentElement> elements) throws Exception {
        StringWriter out = new StringWriter();
        Context ctx = new VelocityContext();
        ctx.put("segmentName", segmentName);
        ctx.put("typeDescription", description);
        ctx.put("basePackageName", normalBasePackageName);
        ctx.put("elements", elements);
        ctx.put("datatypePackages", datatypePackages);
        ctx.put("hl7VersionInQuotes", '"' + version + '"');

        template.merge(ctx, out);
        return out.toString();
    }


    public static void main(String... args) {
        try {
            XsdSegmentGenerator xdtg = new XsdSegmentGenerator("C:/temp", "/ca.uhn.hl7v2.sourcegen.templates");
            long start = System.currentTimeMillis();
//            for (Version version : Version.values()) {
//                System.out.println("Creating segments for " + version);
//                xdtg.parse(version);
//            }
            xdtg.parse(Version.V25);
            System.out.println("Done in " + (System.currentTimeMillis() - start) + " ms.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
