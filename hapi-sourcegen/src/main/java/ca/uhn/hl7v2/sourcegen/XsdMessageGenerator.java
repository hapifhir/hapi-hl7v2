/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "XsdGroupGenerator.java".  Description:
 ""

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
import java.util.*;

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
 * Create HAPI message classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p/>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdMessageGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdMessageGenerator.class);
    public static final String URN_HL7_ORG_V2XML = "urn:hl7-org:v2xml";

    private String templatePackage;
    private String targetDirectory;
    private Template messageTemplate;
    private Template groupTemplate;


    public XsdMessageGenerator(String dir, String templatePackage) throws IOException {
        File f = new File(dir);
        if (!f.isDirectory())
            throw new IOException("Can't create file in " + dir + " - it is not a directory.");
        this.targetDirectory = dir;
        this.templatePackage = templatePackage.replace(".", "/");
    }

    public void parse(Version version) throws Exception {
        messageTemplate = VelocityFactory.getClasspathTemplateInstance(templatePackage + "/messages.vsm");
        groupTemplate = VelocityFactory.getClasspathTemplateInstance(templatePackage + "/group.vsm");
        XSOMParser parser = new XSOMParser();
        String dir = String.format("/hl7v2xsd/%s/messages.xsd", version.getVersion());
        URL url = getClass().getResource(dir);
        parser.setErrorHandler(new SimpleErrorHandler());
        parser.parse(url);
        XSSchemaSet result = parser.getResult();
        Iterator<XSSchema> iter = result.iterateSchema();
        while (iter.hasNext()) {
            XSSchema schema = iter.next();
            if (URN_HL7_ORG_V2XML.equals(schema.getTargetNamespace())) {
                parseMessages(schema, version);
            }
        }
    }


    /**
     * Message (Structures) and Groups are both contained within the message structure files included from
     * messages.xsd, and although they are structured very similarly they e.g. inherit from different base
     * classes.
     *
     * @param schema
     * @param version
     * @throws Exception
     */
    private void parseMessages(XSSchema schema, Version version) throws Exception {

        String basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());

        XSModelGroupDecl allMessages = schema.getModelGroupDecl("ALLMESSAGES.CONTENT");
        XSParticle[] messages = allMessages.getModelGroup().getChildren();
        for (XSParticle message : messages) {
            XSElementDecl messageElement = message.getTerm().asElementDecl();
            GroupDef messageDef = parseGroupOrMessage(messageElement.getName(), message, true, version, basePackageName, new HashMap<String, StructureDef>());
            String messageClass = makeMessage(messageDef, basePackageName, version.getVersion(), null);
            writeFile(messageClass, "message", messageElement.getName(), version);
        }
    }

    private GroupDef parseGroupOrMessage(String messageName, XSParticle groupParticle,
                                             boolean isMessage, Version version,
                                             String basePackageName,
                                             Map<String, StructureDef> structures) throws Exception {
        XSElementDecl groupDecl = groupParticle.getTerm().asElementDecl();
        XSComplexType complexType = groupDecl.getType().asComplexType();
        // Find the structures of the group
        XSParticle[] children = complexType
                .getContentType()
                .asParticle()
                .getTerm()
                .asModelGroup()
                .getChildren();
        LOG.debug("found {}, having {} children", groupDecl.getName(), children.length);

        GroupDef def = new GroupDef(
                messageName,
                // chop off message name from beginning of group
                messageName.equals(groupDecl.getName()) ?
                        messageName :
                        groupDecl.getName().substring(messageName.length() + 1),
                groupParticle.getMinOccurs().intValue() > 0,
                groupParticle.isRepeated(),
                "a Group object");
        structures.put(groupDecl.getName(), def);

        // Collect the substructures of the group
        for (XSParticle child : children) {
            XSElementDecl childDecl = child.getTerm().asElementDecl();

            // The type starts with the message structure name, if the structure is a group,
            if (childDecl.getName().startsWith(messageName)) {

                // Groups can be recursive, so watch out!
                if (structures.containsKey(childDecl.getName())) {
                    LOG.debug("{} has already been seen here", childDecl.getName());
                    def.addStructure(structures.get(childDecl.getName()));
                } else {
                    def.addStructure(parseGroupOrMessage(messageName, child, false, version, basePackageName, structures));
                }
            } else {
                // the structure is a segment
                def.addStructure(new SegmentDef(childDecl.getName(),
                        null,
                        child.getMinOccurs().intValue() > 0,
                        child.isRepeated(),
                        false,
                        // need to add better description here, but nothing is in XSD!
                        childDecl.getName()));
            }
        }

        if (!isMessage) {
            String groupClass = makeGroup(def, basePackageName, version.getVersion());
            writeFile(groupClass, "groups", def.getName(), version);
        }
        return def;
    }

    private void writeFile(String source, String type, String name, Version version) throws IOException {
        // TODO must be more robust
        String dirName = String.format("%s/ca/uhn/hl7v2/model/%s/%s/", targetDirectory, version.getPackageVersion(), type);
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String targetFile = String.format("%s/%s.java", dirName, name);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile, false), "UTF-8"));
            writer.write(source);
            writer.flush();
        } finally {
            if (writer != null) writer.close();
        }
    }

    private String makeMessage(GroupDef def, String normalBasePackageName,
                        String version, List<String> structureNameToChildNames) throws Exception {
        StringWriter out = new StringWriter();
        Context ctx = new VelocityContext();
        ctx.put("message", def.getRawGroupName());
        ctx.put("specVersion", version);
        ctx.put("chapter", ""); // missing in XSDs
        ctx.put("haveGroups", hasGroups(def));
        ctx.put("basePackageName", normalBasePackageName);
        ctx.put("segments", Arrays.asList(def.getStructures()));
        ctx.put("structureNameToChildNames", structureNameToChildNames);
        ctx.put("HASH", "#");

        messageTemplate.merge(ctx, out);
        return out.toString();
    }

    private String makeGroup(GroupDef def, String normalBasePackageName, String version) throws Exception {
        StringWriter out = new StringWriter();
        Context ctx = new VelocityContext();
        ctx.put("groupName", def.getName());
        ctx.put("specVersion", version);
        ctx.put("typeDescription", "a Group object");
        ctx.put("basePackageName", normalBasePackageName);
        ctx.put("groups", Arrays.asList(def.getStructures()));
        ctx.put("chapter", "");

        groupTemplate.merge(ctx, out);
        return out.toString();
    }


    private static boolean hasGroups(GroupDef def) {
        for (StructureDef structure : def.getStructures()) {
            if (structure.isGroup()) return true;
        }
        return false;
    }

    public static void main(String... args) {
        try {
            XsdMessageGenerator xdtg = new XsdMessageGenerator("C:/temp", "/ca.uhn.hl7v2.sourcegen.templates");
            long start = System.currentTimeMillis();
//            for (Version version : Version.values()) {
//                System.out.println("Creating messages and groups for " + version);
//                xdtg.parse(version);
//            }
            xdtg.parse(Version.V25);
            System.out.println("Done in " + (System.currentTimeMillis() - start) + " ms.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
