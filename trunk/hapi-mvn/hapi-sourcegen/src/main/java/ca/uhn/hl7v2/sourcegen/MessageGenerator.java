/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MessageGenerator.java".  Description:
 * "Creates source code for HL7 Message objects, using the normative DB"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s):  Eric Poiseau. 
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.sourcegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.database.NormativeDatabase;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Creates source code for HL7 Message objects, using the normative DB. HL7
 * Group objects are also created as a byproduct.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class MessageGenerator extends Object {

    /**
     * If the system property by this name is true, groups are generated to use
     * a ModelClassFactory for segment class lookup. This makes segment creation
     * more flexible, but may slow down parsing substantially.
     */
    public static String MODEL_CLASS_FACTORY_KEY = "ca.uhn.hl7v2.sourcegen.modelclassfactory";

    private static final HapiLog log = HapiLogFactory.getHapiLog(MessageGenerator.class);

    private static String groupName;

    /** Creates new MessageGenerator */
    public MessageGenerator() {
    }

    /**
     * Creates and writes source code for all Messages and Groups.
     */
    public static void makeAll(String baseDirectory, String version, boolean failOnError, String theTemplatePackage, String theFileExt) throws Exception {
        // get list of messages ...
        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
        Statement stmt = conn.createStatement();
        String sql = getMessageListQuery(version);
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList messages = new ArrayList();
        ArrayList chapters = new ArrayList();
        while (rs.next()) {
            String name = rs.getString(1);
            if ("0".equals(name)) {
                continue;
            }
            messages.add(name);
            chapters.add(rs.getString(2));
        }
        stmt.close();
        normativeDatabase.returnConnection(conn);

        if (messages.size() == 0) {
            log.warn("No version " + version + " messages found in database " + System.getProperty("ca.on.uhn.hl7.database.url"));
        }

        for (int i = 0; i < messages.size(); i++) {
            String message = (String) messages.get(i);
            try {
                make(message, baseDirectory, (String) chapters.get(i), version, theTemplatePackage, theFileExt);
            } catch (HL7Exception e) {
                if (failOnError) {
                    throw e;
                } else {
                    log.error("Failed to generate message " + message + ": ", e);
                }
            }
        }
    }

    /**
     * Returns an SQL query with which to get a list of messages from the
     * normative database.
     */
    private static String getMessageListQuery(String version) {
        // UNION because the messages are defined in different tables for
        // different versions.
        // ACCESS return
        // "SELECT distinct  [message_type]+'_'+[event_code] AS msg_struct, '?'"
        // //no chapters in DB
        return "SELECT distinct  message_type + '_' + event_code AS msg_struct, '?'" // no
                                                                                     // chapters
                                                                                     // in
                                                                                     // DB
                + " FROM HL7Versions RIGHT JOIN HL7EventMessageTypeSegments ON HL7EventMessageTypeSegments.version_id = HL7Versions.version_id "
                + "WHERE HL7Versions.hl7_version ='"
                + version
                + "' and Not (message_type='ACK') "
                + "UNION "
                + "select distinct HL7MsgStructIDs.message_structure, section from HL7Versions RIGHT JOIN (HL7MsgStructIDSegments "
                + " inner join HL7MsgStructIDs on HL7MsgStructIDSegments.message_structure = HL7MsgStructIDs.message_structure "
                + " and HL7MsgStructIDSegments.version_id = HL7MsgStructIDs.version_id) "
                + " ON HL7MsgStructIDSegments.version_id = HL7Versions.version_id "
                + " where HL7Versions.hl7_version = '" + version + "' and HL7MsgStructIDs.message_structure not like 'ACK_%'"; // note:
                                                                                                                               // allows
                                                                                                                               // "ACK"
                                                                                                                               // itself
    }

    /**
     * Creates source code for a specific message structure and writes it under
     * the specified directory. throws IllegalArgumentException if there is no
     * message structure for this message in the normative database
     */
    public static void make(String message, String baseDirectory, String chapter, String version, String theTemplatePackage, String theFileExt) throws Exception {

        // Make sure this structure has a corresponding definition in the
        // structure map
        // Parser.getMessageStructureForEvent(message, version);

        try {
            SegmentDef[] segments = getSegments(message, version);
            // System.out.println("Making: " + message + " with " +
            // segments.length +
            // " segments (not writing message code - just groups)");

            GroupDef group = GroupGenerator.getGroupDef(segments, null, baseDirectory, version, message, theTemplatePackage, theFileExt);
            StructureDef[] contents = group.getStructures();

            // make base directory
            if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) {
                baseDirectory = baseDirectory + "/";
            }
            File targetDir = SourceGenerator.makeDirectory(baseDirectory + DefaultModelClassFactory.getVersionPackagePath(version) + "message");
            System.out.println("Writing " + message + " to " + targetDir.getPath());
            String fileName = targetDir.getPath() + "/" + message + "." + theFileExt;

            writeMessage(fileName, contents, message, chapter, version, group, DefaultModelClassFactory.getVersionPackageName(version), true, theTemplatePackage);

        } catch (SQLException e) {
            throw new HL7Exception(e);
        } catch (IOException e) {
            throw new HL7Exception(e);
        }
        // catch (Exception e) {
        // log.error("Error while creating source code", e);
        //
        // log.warn("Warning: could not write source code for message structure "
        // + message
        // + " - "
        // + e.getClass().getName()
        // + ": "
        // + e.getMessage());
        // }
    }

    /**
     * Queries the normative database for a list of segments comprising the
     * message structure. The returned list may also contain strings that denote
     * repetition and optionality. Choice indicators (i.e. begin choice, next
     * choice, end choice) for alternative segments are ignored, so that the
     * class structure allows all choices. The matter of enforcing that only a
     * single choice is populated can't be handled by the class structure, and
     * should be handled elsewhere.
     * 
     * @param theJdbcUrl
     */
    private static SegmentDef[] getSegments(String message, String version) throws SQLException {
        /*
         * String sql =
         * "select HL7Segments.seg_code, repetitional, optional, description " +
         * "from (HL7MsgStructIDSegments inner join HL7Segments on HL7MsgStructIDSegments.seg_code = HL7Segments.seg_code "
         * + "and HL7MsgStructIDSegments.version_id = HL7Segments.version_id) "
         * + "where HL7Segments.version_id = 6 and message_structure = '" +
         * message + "' order by seq_no";
         */
        String sql = getSegmentListQuery(message, version);
        // System.out.println(sql.toString());
        SegmentDef[] segments = new SegmentDef[200]; // presumably there won't
                                                     // be more than 200
        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int c = -1;
        while (rs.next()) {
            String name = SegmentGenerator.altSegName(rs.getString(1));
            boolean repeating = rs.getBoolean(2);
            boolean optional = rs.getBoolean(3);
            String desc = rs.getString(4);
            String groupName = version.equalsIgnoreCase("2.3.1") ? null : rs.getString(6); // group
                                                                                           // names
                                                                                           // are
                                                                                           // defined
                                                                                           // in
                                                                                           // DB
                                                                                           // for
                                                                                           // 2.3.1
                                                                                           // but
                                                                                           // not
                                                                                           // used
                                                                                           // in
                                                                                           // the
                                                                                           // schema

            if (groupName != null) {
                groupName = groupName.replaceAll(" ", "_"); // Don't allow
                                                            // spaces in the
                                                            // names
                groupName = groupName.replaceAll("/", "_"); // Don't allow
                                                            // spaces in the
                                                            // names
            }

            // ignore the "choice" directives ... the message class structure
            // has to include all choices ...
            // if this is enforced (i.e. exception thrown if >1 choice
            // populated) this will have to be done separately.
            if (!(name.equals("<") || name.equals("|") || name.equals(">"))) {
                c++;
                segments[c] = new SegmentDef(name, groupName, !optional, repeating, desc);
            }
        }
        SegmentDef[] ret = new SegmentDef[c + 1];
        System.arraycopy(segments, 0, ret, 0, c + 1);

        normativeDatabase.returnConnection(conn);

        return ret;
    }

    /**
     * Returns an SQL query with which to get a list of the segments that are
     * part of the given message from the normative database. The query varies
     * with different versions. The fields returned are as follows:
     * segment_code, repetitional, optional, description
     */
    private static String getSegmentListQuery(String message, String version) {
        String sql = null;

        sql = "SELECT HL7Segments.seg_code, repetitional, optional, HL7Segments.description, seq_no, groupname "
                + "FROM HL7Versions RIGHT JOIN (HL7Segments INNER JOIN HL7EventMessageTypeSegments ON (HL7Segments.version_id = HL7EventMessageTypeSegments.version_id) "
                + "AND (HL7Segments.seg_code = HL7EventMessageTypeSegments.seg_code)) " + "ON HL7Segments.version_id = HL7Versions.version_id "
                + "WHERE (((HL7Versions.hl7_version)= '"
                + version
                + "') "
                // ACCESS + "AND (([message_type]+'_'+[event_code])='"
                + "AND ((message_type + '_' + event_code)='"
                + message
                + "')) order by seq_no UNION "
                // + "')) UNION "
                + "select HL7Segments.seg_code, repetitional, optional, HL7Segments.description, seq_no, groupname  "
                + "from HL7Versions RIGHT JOIN (HL7MsgStructIDSegments inner join HL7Segments on HL7MsgStructIDSegments.seg_code = HL7Segments.seg_code "
                + "and HL7MsgStructIDSegments.version_id = HL7Segments.version_id) " + "ON HL7Segments.version_id = HL7Versions.version_id " + "where HL7Versions.hl7_version = '"
                + version + "' and message_structure = '" + message + "' order by seq_no";
        return sql;
    }

   
    /**
     * Returns source code for the contructor for this Message class.
     */
    public static String makeConstructor(StructureDef[] structs, String messageName, String version) {
        boolean useFactory = System.getProperty(MODEL_CLASS_FACTORY_KEY, "FALSE").equalsIgnoreCase("TRUE");

        StringBuffer source = new StringBuffer();

        source.append("\t/** \r\n");
        source.append("\t * Creates a new ");
        source.append(messageName);
        source.append(" Group with custom ModelClassFactory.\r\n");
        source.append("\t */\r\n");
        source.append("\tpublic ");
        source.append(messageName);
        source.append("(ModelClassFactory factory) {\r\n");
        source.append("\t   super(factory);\r\n");
        source.append("\t   init(factory);\r\n");
        source.append("\t}\r\n\r\n");
        source.append("\t/**\r\n");
        source.append("\t * Creates a new ");
        source.append(messageName);
        source.append(" Group with DefaultModelClassFactory. \r\n");
        source.append("\t */ \r\n");
        source.append("\tpublic ");
        source.append(messageName);
        source.append("() { \r\n");
        source.append("\t   super(new DefaultModelClassFactory());\r\n");
        source.append("\t   init(new DefaultModelClassFactory());\r\n");
        source.append("\t}\r\n\r\n");
        source.append("\tprivate void init(ModelClassFactory factory) {\r\n");
        source.append("\t   try {\r\n");
        int numStructs = structs.length;
        for (int i = 0; i < numStructs; i++) {
            StructureDef def = structs[i];
            if (useFactory) {
                source.append("\t      this.add(factory.get");
                source.append((def instanceof GroupDef) ? "Group" : "Segment");
                source.append("Class(\"");
                source.append(def.getName());
                source.append("\", \"");
                source.append(version);
                source.append("\"), ");
            } else {
                source.append("\t      this.add(");
                source.append(def.getName());
                source.append(".class, ");
            }
            source.append(def.isRequired());
            source.append(", ");
            source.append(def.isRepeating());
            source.append(");\r\n");
        }
        source.append("\t   } catch(HL7Exception e) {\r\n");
        source.append("\t      HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected error creating ");
        source.append(messageName);
        source.append(" - this is probably a bug in the source code generator.\", e);\r\n");
        source.append("\t   }\r\n");
        source.append("\t}\r\n\r\n");
        return source.toString();
    }


    public static void writeMessage(String fileName, StructureDef[] contents, String message, String chapter, String version, GroupDef group, String basePackageName,
            boolean haveGroups, String theTemplatePackage) throws Exception {

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false), SourceGenerator.ENCODING));

        theTemplatePackage = theTemplatePackage.replace(".", "/");
        String template2 = theTemplatePackage + "/messages.vsm";
        
//        InputStream resis = MessageGenerator.class.getClassLoader().getResourceAsStream(template2);
//        System.out.println(resis);
//        System.out.println(resis);
//        System.out.println(resis);
//
//        URL resUrl = MessageGenerator.class.getClassLoader().getResource(template2);
//        System.out.println(resUrl);
//        System.out.println(resUrl);
//        System.out.println(resUrl);
//        
//        Template template = new Template();
        
		Template template = VelocityFactory.getClasspathTemplateInstance(template2);
        Context ctx = new VelocityContext();
        ctx.put("message", message);
        ctx.put("specVersion", version);
        ctx.put("chapter", chapter);
        ctx.put("haveGroups", haveGroups);
        ctx.put("basePackageName", basePackageName);
        ctx.put("segments", Arrays.asList(contents));
        template.merge(ctx, out);

        out.flush();
        out.close();
    }

}
