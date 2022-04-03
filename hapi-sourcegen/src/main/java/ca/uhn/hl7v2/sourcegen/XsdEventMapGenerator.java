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
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroupDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Create HAPI message classes from XML Schema files. Download the files from
 * http://www.hl7.org/documentcenter/private/standards/V26/HL7-xml_v2.6_annotated.zip and
 * http://www.hl7.org/documentcenter/public/standards/V2/Sun_HL7v2xsd.zip
 * and unpack into src/main/resources/hl7v2xsd.
 * <p/>
 * This is an attempt to remove the need to have the HL7 database around because the
 * schema files can be downloaded by any who has access to the HL7 standards.
 */
public class XsdEventMapGenerator extends AbstractXsdGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdEventMapGenerator.class);

    public XsdEventMapGenerator(String targetDirectory) {
        super("", targetDirectory);
    }

    @Override
    protected void doParse(XSSchema schema, Version version) {
        parseTriggers(schema, version);
    }

    /**
     * Message (Structures) and Groups are both contained within the message structure files included from
     * messages.xsd, and although they are structured very similarly they e.g. inherit from different base
     * classes.
     *
     * @param schema XML schema
     * @param version HL7 version
     */
    private void parseTriggers(XSSchema schema, Version version) {
        XSModelGroupDecl allMessages = schema.getModelGroupDecl("ALLTRIGGERS.CONTENT");
        if (allMessages != null) {
            XSParticle[] triggers = allMessages.getModelGroup().getChildren();
            StringBuilder builder = new StringBuilder();
            builder.append("#event -> structure map for HL7 ").append(version.getVersion()).append("\n");
            Arrays.stream(triggers)
                    .map(trigger -> trigger.getTerm().asElementDecl())
                    .forEach(triggerElement -> {
                        XSElementDecl messageElement = triggerElement.getSubstAffiliation();
                        builder.append(triggerElement.getName()).append(" ").append(messageElement.getName()).append("\n");
                    });

            String dirName = "parser/eventmap";
            String fileName = String.format("%s.properties", version.getVersion());
            writeFile(builder.toString(), dirName, fileName);
        }
    }

    public static void generateEventMap(String sourceFolder, String targetResourceFolder, String version) throws Exception {
        XsdEventMapGenerator xdtg = new XsdEventMapGenerator(targetResourceFolder);
        LOG.info("Creating event map for " + version);
        xdtg.parse(Version.versionOf(version), sourceFolder, "triggers.xsd");
    }


}
