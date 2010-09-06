package ca.uhn.hl7v2.sourcegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import ca.uhn.hl7v2.database.NormativeDatabase;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;

public class EventMapGenerator {

    public static void generateEventMap(String theOutputPath, String theVersion) throws SQLException, IOException {

        theOutputPath = theOutputPath + "/ca/uhn/hl7v2/parser/eventmap/";

        new File(theOutputPath).mkdirs();

        File file = new File(theOutputPath + theVersion + ".properties");
        file.delete();
        file.createNewFile();
        Writer writer = new FileWriter(file);
        writer = new BufferedWriter(writer);

        writer.append("#event -> structure map for HL7 " + theVersion + "\r\n");
        if ("2.1".equals(theVersion) || "2.2".equals(theVersion)) {
            writer.append("#note: no mappings are defined for 2.1 and 2.2");
            writer.close();
            return;
        }

        ResultSet rs = createStructureQuery(theVersion);
        while (rs.next()) {
            String messageType = rs.getString("message_typ_snd");
            String triggerCode = rs.getString("event_code");
            String trigger = messageType + "_" + triggerCode;
            String structure = rs.getString("message_structure_snd");

            if ("ACK".equals(messageType)) {
                continue;
            }
            if ("NUL".equals(structure)) {
                continue;
            }

            writer.append(trigger).append("\t").append(structure).append("\r\n");
        }

        rs.close();
        writer.close();
    }

    private static ResultSet createStructureQuery(String theVersion) throws SQLException {
        String query = "SELECT " + "   HL7EventMessageTypes.event_code, HL7EventMessageTypes.message_typ_snd, "
                + "   HL7Versions.hl7_version, HL7EventMessageTypes.message_structure_snd " + "FROM " + "   HL7Versions "
                + "INNER JOIN HL7EventMessageTypes ON HL7Versions.version_id = HL7EventMessageTypes.version_id " + "WHERE " + "   HL7Versions.hl7_version = '" + theVersion + "' "
                + "ORDER BY HL7EventMessageTypes.message_typ_snd, HL7EventMessageTypes.event_code;";

        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        normativeDatabase.returnConnection(conn);
        return rs;
    }

    public static void generateEventDesc(String theTargetDirectory, String theVersion, String theTemplatePackage) throws Exception {

        List<TriggerDesc> triggerDescs = getTriggers(theVersion);
        // Structures are not explicitly defined in 2.1 and 2.2
        if ("2.1".equals(theVersion) || "2.2".equals(theVersion)) {
            for (TriggerDesc next : triggerDescs) {
                next.setStructure(next.getType().replace("^", "_"));
            }
        }
        Collections.sort(triggerDescs);
        
        List<String> segments = SegmentGenerator.getSegmentNames(theVersion);
        Collections.sort(segments);
        
        List<String> dataTypes = DataTypeGenerator.getDataTypes(theVersion);
        Collections.sort(dataTypes);
        
        if (!(theTargetDirectory.endsWith("\\") || theTargetDirectory.endsWith("/"))) { 
            theTargetDirectory = theTargetDirectory + "/";
        }
        String fileName = theTargetDirectory + DefaultModelClassFactory.getVersionPackagePath(theVersion) + "available_structures.json";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false), SourceGenerator.ENCODING));
        
        theTemplatePackage = theTemplatePackage.replace(".", "/");
        Template template = VelocityFactory.getClasspathTemplateInstance(theTemplatePackage + "/available_structures.vsm");
        Context ctx = new VelocityContext();
        ctx.put("triggers", triggerDescs);
        ctx.put("segments", segments);
        ctx.put("datatypes", dataTypes);
        
        template.merge(ctx, out);
        
//      String string = createSegmentString(version, segmentName, elements, description, basePackage, datatypePackageString);
//      out.write(string);
        
        out.flush();
        out.close();
        
        
    }

    private static List<TriggerDesc> getTriggers(String theVersion) throws SQLException {
        String query = // 
        "SELECT HL7Versions.hl7_version, HL7EventMessageTypes.message_typ_snd, HL7Events.event_code, "
                + "       HL7EventMessageTypes.message_structure_snd, HL7Events.description,"
                + "        HL7EventMessageTypes.message_structure_return "
                + "FROM   HL7Versions "
                + "INNER JOIN (HL7Events INNER JOIN HL7EventMessageTypes ON (HL7Events.version_id = HL7EventMessageTypes.version_id) AND (HL7Events.event_code = HL7EventMessageTypes.event_code)) ON HL7Versions.version_id = HL7Events.version_id" +
                		" WHERE HL7Versions.hl7_version = '" + theVersion + "';";

        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
        List<TriggerDesc> triggerDescs = new ArrayList<TriggerDesc>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String version = rs.getString("hl7_version");
                String type = rs.getString("message_typ_snd") + "^" + rs.getString("event_code");
                String structure = rs.getString("message_structure_snd");
                String description = StringUtils.defaultString(rs.getString("description"));
                String returnStructure = rs.getString("message_structure_return");
            
                TriggerDesc td = new TriggerDesc();
                td.setVersion(version);
                td.setType(type);
                td.setStructure(structure);
                td.setDescription(description.replace("\"", "\\\""));
                td.setReturnStructure(returnStructure);

                triggerDescs.add(td);
                
            }

        } finally {
            normativeDatabase.returnConnection(conn);
        }
        return triggerDescs;
    }

}
