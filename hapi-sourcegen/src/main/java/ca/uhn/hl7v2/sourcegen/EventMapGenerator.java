package ca.uhn.hl7v2.sourcegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ca.uhn.hl7v2.database.NormativeDatabase;

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

	private static ResultSet createStructureQuery(String theVersion)
			throws SQLException {
		String query = "SELECT " + 
				"   HL7EventMessageTypes.event_code, HL7EventMessageTypes.message_typ_snd, " + 
				"   HL7Versions.hl7_version, HL7EventMessageTypes.message_structure_snd " + 
				"FROM " + 
				"   HL7Versions " + 
				"INNER JOIN HL7EventMessageTypes ON HL7Versions.version_id = HL7EventMessageTypes.version_id " +
				"WHERE " +
				"   HL7Versions.hl7_version = '" + theVersion + "' " + 
				"ORDER BY HL7EventMessageTypes.message_typ_snd, HL7EventMessageTypes.event_code;";
		
        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        normativeDatabase.returnConnection(conn);
		return rs;
	}
	
}
