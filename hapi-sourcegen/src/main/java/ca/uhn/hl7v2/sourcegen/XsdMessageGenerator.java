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

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSModelGroupDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static ca.uhn.hl7v2.sourcegen.XsdSegmentGenerator.ANY_HL7_SEGMENT;
import static ca.uhn.hl7v2.sourcegen.XsdSegmentGenerator.HXX;

/**
 * Create HAPI message classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p/>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdMessageGenerator extends AbstractXsdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdMessageGenerator.class);

    private final Template messageTemplate;
    private final Template groupTemplate;

    public XsdMessageGenerator(String templatePackage, String targetDirectory) {
        super(templatePackage, targetDirectory);
        this.messageTemplate = VelocityFactory.getClasspathTemplateInstance(this.templatePackage + "/messages.vsm");
        this.groupTemplate = VelocityFactory.getClasspathTemplateInstance(this.templatePackage + "/group.vsm");
    }

    @Override
    protected void doParse(XSSchema schema, Version version) {
        parseMessages(schema, version);
    }

    /**
     * Message (Structures) and Groups are both contained within the message structure files included from
     * messages.xsd, and although they are structured very similarly they e.g. inherit from different base
     * classes.
     */
    private void parseMessages(XSSchema schema, Version version) {
        XSModelGroupDecl allMessages = schema.getModelGroupDecl("ALLMESSAGES.CONTENT");
        XSParticle[] messages = allMessages.getModelGroup().getChildren();
        Arrays.stream(messages).forEach(message -> parseMessage(message, version));
    }

    private void parseMessage(XSParticle message, Version version) {
        String messageName = message.getTerm().asElementDecl().getName();
        parseGroupOrMessage(messageName, message, version, new HashMap<>(), groupDef -> writeMessageFile(version, messageName, groupDef));
    }

    private GroupDef parseGroupOrMessage(String messageName,
                                         XSParticle groupParticle,
                                         Version version,
                                         Map<String, StructureDef> structures,
                                         Consumer<GroupDef> classWriter) {
        String groupName = groupParticle.getTerm().asElementDecl().getName();
        XSModelGroup modelGroup = getModelGroup(groupParticle);
        LOG.debug("Generating {}, having {} children", groupName, modelGroup.getSize());

        String effectiveGroupName = messageName.equals(groupName) ?
                messageName :
                groupName.substring(messageName.length() + 1);
        GroupDef currentGroupDef = new GroupDef(
                messageName,
                effectiveGroupName,
                groupParticle.getMinOccurs().intValue() > 0,
                groupParticle.isRepeated(),
                // TODO description is missing in XSD, but this was done like this in DB-based generation, too
                "a Group object");
        currentGroupDef.setChoice(modelGroup.getCompositor() == XSModelGroup.Compositor.CHOICE);
        if (!currentGroupDef.isChoice()) {
            structures.put(groupName, currentGroupDef);
        }

        // Collect the substructures of the group
        for (XSParticle child : modelGroup.getChildren()) {
            String childName = child.getTerm().asElementDecl().getName();
            if (childName.startsWith(messageName)) {

                // The type starts with the message structure name if the structure is a group
                // Groups can be recursive, only parse them the first time
                if (structures.containsKey(childName)) {
                    currentGroupDef.addStructure(structures.get(childName));
                } else {
                    GroupDef childGroupDef = parseGroupOrMessage(messageName, child, version, structures, def -> writeGroupFile(version, def.getName(), def));
                    // Choice groups are flattened into the current group
                    if (childGroupDef.isChoice()) {
                        Arrays.stream(childGroupDef.getStructures()).forEach(currentGroupDef::addStructure);
                    } else {
                        currentGroupDef.addStructure(childGroupDef);
                    }
                }

            } else {
                // otherwise the structure is a segment
                SegmentDef segmentDef = new SegmentDef(fixSegmentName(childName),
                        null,
                        child.getMinOccurs().intValue() > 0,
                        child.isRepeated(),
                        currentGroupDef.isChoice(),
                        // TODO description is missing in XSD
                        childName);
                currentGroupDef.addStructure(segmentDef);
            }
        }

        // Don't write CHOICE groups, children will be flattened into parent
        if (!currentGroupDef.isChoice()) {
            classWriter.accept(currentGroupDef);
        }
        return currentGroupDef;
    }

    private XSModelGroup getModelGroup(XSParticle xsParticle) {
        XSElementDecl groupDecl = xsParticle.getTerm().asElementDecl();
        XSComplexType complexType = groupDecl.getType().asComplexType();
        // Find the kind of the group
        return complexType
                .getContentType()
                .asParticle()
                .getTerm()
                .asModelGroup();
    }

    private String fixSegmentName(String name) {
        return ANY_HL7_SEGMENT.equals(name) ? HXX : name;
    }

    private void writeMessageFile(Version version, String className, GroupDef messageDef) {
        try {
            String basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
            String messageClassContent = makeMessage(messageTemplate, messageDef, basePackageName, version.getVersion(), null);
            String dirName = String.format("model/%s/message", version.getPackageVersion());
            String fileName = String.format("%s.java", className);
            writeFile(messageClassContent, dirName, fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void writeGroupFile(Version version, String className, GroupDef groupDef) {
        try {
            String basePackageName = DefaultModelClassFactory.getVersionPackageName(version.getVersion());
            String groupClassContent = makeGroup(groupTemplate, groupDef, basePackageName, version.getVersion());
            String dirName = String.format("model/%s/group/", version.getPackageVersion());
            String fileName = String.format("%s.java", className);
            writeFile(groupClassContent, dirName, fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String makeMessage(Template template, GroupDef def, String normalBasePackageName,
                               String version, List<String> structureNameToChildNames) {
        StringWriter out = new StringWriter();
        Context ctx = new VelocityContext();
        ctx.put("message", def.getRawGroupName());
        ctx.put("specVersion", version);
        ctx.put("chapter", ""); // TODO missing in XSDs
        ctx.put("haveGroups", hasGroups(def));
        ctx.put("basePackageName", normalBasePackageName);
        ctx.put("segments", Arrays.asList(def.getStructures()));
        ctx.put("structureNameToChildNames", structureNameToChildNames);
        ctx.put("HASH", "#");

        template.merge(ctx, out);
        return out.toString();
    }

    private String makeGroup(Template template, GroupDef def, String normalBasePackageName, String version) {
        StringWriter out = new StringWriter();
        Context ctx = new VelocityContext();
        ctx.put("groupName", def.getName());
        ctx.put("specVersion", version);
        ctx.put("chapter", "");  // TODO missing in XSDs
        ctx.put("typeDescription", def.getDescription());
        ctx.put("basePackageName", normalBasePackageName);
        ctx.put("groups", Arrays.asList(def.getStructures()));

        template.merge(ctx, out);
        return out.toString();
    }

    private static boolean hasGroups(GroupDef def) {
        return Arrays.stream(def.getStructures()).anyMatch(StructureDef::isGroup);
    }

    public static void generateMessagesAndGroups(String templatePackage, String sourceDirectory, String targetDirectory, String version) throws Exception {
        XsdMessageGenerator xmg = new XsdMessageGenerator(templatePackage, targetDirectory);
        LOG.info("Creating messages and groups for {}", version);
        xmg.parse(Version.versionOf(version), sourceDirectory, "messages.xsd");
    }


}
