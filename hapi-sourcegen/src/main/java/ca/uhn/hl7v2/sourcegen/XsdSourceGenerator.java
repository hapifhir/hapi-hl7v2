/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 * <p>
 * The Original Code is "SourceGenerator.java".  Description:
 * "Manages automatic generation of HL7 API source code for all data types,
 * segments, groups, and message structures"
 * <p>
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 * <p>
 * Contributor(s): ______________________________________.
 * <p>
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.sourcegen;

import ca.uhn.hl7v2.HL7Exception;
import net.lingala.zip4j.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class XsdSourceGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(XsdSourceGenerator.class);

    /**
     * Generates source code for all data types, segments, groups, and messages.
     */
    public static void makeAll(String templatePackage, String targetSourceDirectory, String targetResourceDirectory, String version, char[] pwd) throws HL7Exception {
        String unpackFolder = null;
        try {
            unpackFolder = unpack(version, pwd);
            XsdEventMapGenerator.generateEventMap(unpackFolder, targetResourceDirectory, version);
            XsdMessageGenerator.generateMessagesAndGroups(templatePackage, unpackFolder, targetSourceDirectory, version);
            XsdSegmentGenerator.generateSegments(templatePackage, unpackFolder, targetSourceDirectory, version);
            XsdDataTypeGenerator.generateDataTypes(templatePackage, unpackFolder, targetSourceDirectory, version);
        } catch (Exception e) {
            throw new HL7Exception(e);
        } finally {
            if (unpackFolder != null) {
                deleteFolder(new File(unpackFolder));
            }
        }
    }

    private static String unpack(String version, char[] pwd) throws Exception {
        File zipFile = new File(version + ".zip");
        LOG.debug("Unpacking {}", zipFile.getAbsolutePath());
        ZipFile zip = new ZipFile(zipFile, pwd);
        String tmpDir = System.getProperty("java.io.tmpdir");
        zip.extractAll(tmpDir);
        return tmpDir;
    }

    private static void deleteFolder(File folder) {
        LOG.debug("Deleting {}", folder.getAbsolutePath());
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
    }

}
