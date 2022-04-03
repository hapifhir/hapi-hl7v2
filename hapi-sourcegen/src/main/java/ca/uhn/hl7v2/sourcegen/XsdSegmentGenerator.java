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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create HAPI segment model classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p/>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdSegmentGenerator extends AbstractXsdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdSegmentGenerator.class);
    static final String ANY_HL7_SEGMENT = "anyHL7Segment";
    static final String ANY_Z_SEGMENT = "anyZSegment";
    static final String HXX = "Hxx";
    private static final String[] EXCLUDE_SEGMENTS = {ANY_HL7_SEGMENT, ANY_Z_SEGMENT};

    public XsdSegmentGenerator(String templatePackage, String targetDirectory) {
        super(templatePackage, targetDirectory);
    }

    @Override
    protected void doParse(XSSchema schema, Version version) {
        parseSegments(schema, version);
    }

    private void parseSegments(XSSchema schema, Version version) {

        Template template = VelocityFactory.getClasspathTemplateInstance(templatePackage + "/segment.vsm");
        String basePackageName;
        try {
            basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
        } catch (HL7Exception e) {
            throw new RuntimeException(e);
        }
        String[] datatypePackages = {basePackageName + "datatype"};

        asStream(schema.iterateElementDecls())
                .filter(segmentDecl -> isRealSegment(segmentDecl.getName()))
                .forEach(segmentDecl -> {
                    List<SegmentElement> segmentsElements = new ArrayList<>();
                    XSComplexType complexType = segmentDecl.getType().asComplexType();
                    // Find and iterate over the fields of the segment
                    XSParticle[] children = complexType
                            .getContentType()
                            .asParticle()
                            .getTerm()
                            .asModelGroup()
                            .getChildren();
                    LOG.debug("Creating segment {}, having {} children", segmentDecl.getName(), children.length);
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

                            SegmentElement se = new SegmentElement(fixSegmentName(segmentDecl.getName()), version.getVersion(), i);
                            se.field = i;
                            if (children[i].getMaxOccurs().intValue() == XSParticle.UNBOUNDED) {
                                se.rep = "Y";
                                se.repetitions = 0;
                            } else {
                                se.rep = "N";
                                se.repetitions = 1;
                            }
                            se.opt = children[i].getMinOccurs().intValue() > 0 ? "R" : "O";
                            se.withdrawn = children[i].getMaxOccurs().intValue() == 0;
                            se.desc = attrGroup.getAttributeUse("", "LongName").getFixedValue().toString();
                            XSAttributeUse fieldTable = attrGroup.getAttributeUse("", "Table");
                            se.table = fieldTable != null ? Integer.parseInt(fieldTable.getFixedValue().toString().substring(3)) : 0;
                            se.type = se.withdrawn ? "NULLDT" : attrGroup.getAttributeUse("", "Type").getFixedValue().toString();
                            XSAttributeUse fieldLength = attrGroup.getAttributeUse("", "maxLength");
                            se.length = fieldLength != null ? Integer.parseInt(fieldLength.getFixedValue().toString()) : 0;
                            segmentsElements.add(fixSegmentElement(i + 1, version, se));
                        }
                    }
                    // Custom extension: get segment description from LongName attribute of segment, if available
                    String segmentDescription = segmentDecl.getName();
                    if (!complexType.getAttGroups().isEmpty()) {
                        XSAttGroupDecl attrGroup = complexType.getAttGroups().iterator().next();
                        segmentDescription = attrGroup.getAttributeUse("", "LongName").getFixedValue().toString();
                    }

                    writeSegment(template, basePackageName, datatypePackages,
                            segmentDecl.getName(), segmentDescription, version, segmentsElements);

                });

    }

    private String fixSegmentName(String name) {
        return "CON".equals(name) ? "CON_" : name;
    }

    private void writeSegment(Template template, String basePackageName, String[] datatypePackages,
                              String segmentName, String segmentDescription, Version version,
                              List<SegmentElement> segmentsElements) {
        String source = makeSegment(template, basePackageName, datatypePackages,
                segmentName, segmentDescription, version.getVersion(), segmentsElements);
        if (source != null) {
            String dirName = String.format("model/%s/segment", version.getPackageVersion());
            String fileName = String.format("%s.java", segmentName);
            try {
                writeFile(source, dirName, fileName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This method can be used to circumvent errors in the XSDs without the need to
     * modify the XSD.
     */
    private static SegmentElement fixSegmentElement(int index, Version version, SegmentElement se) {
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
        return se;
    }

    private boolean isRealSegment(String dataTypeName) {
        return Arrays.binarySearch(EXCLUDE_SEGMENTS, dataTypeName) < 0 &&
                dataTypeName.indexOf('.') < 0;
    }

    private String makeSegment(Template template, String normalBasePackageName, String[] datatypePackages,
                               String segmentName, String description, String version, List<SegmentElement> elements) {
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

    public static void generateSegments(String templatePackage, String sourceDirectory, String targetDirectory, String version) throws Exception {
        XsdSegmentGenerator xsg = new XsdSegmentGenerator(templatePackage, targetDirectory);
        LOG.info("Creating segments for {}", version);
        xsg.parse(Version.versionOf(version), sourceDirectory, "segments.xsd");
    }

}
