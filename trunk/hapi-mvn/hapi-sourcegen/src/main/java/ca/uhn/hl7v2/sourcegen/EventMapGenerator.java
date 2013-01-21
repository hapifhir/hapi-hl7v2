package ca.uhn.hl7v2.sourcegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

import ca.uhn.hl7v2.database.NormativeDatabase;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;

public class EventMapGenerator {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(EventMapGenerator.class);

	private static ResultSet createStructureQuery(String theVersion) throws SQLException {
		String query = "SELECT " + "   HL7EventMessageTypes.event_code, HL7EventMessageTypes.message_typ_snd, " + "   HL7Versions.hl7_version, HL7EventMessageTypes.message_structure_snd " + "FROM " + "   HL7Versions "
				+ "INNER JOIN HL7EventMessageTypes ON HL7Versions.version_id = HL7EventMessageTypes.version_id " + "WHERE " + "   HL7Versions.hl7_version = '" + theVersion + "' " + "ORDER BY HL7EventMessageTypes.message_typ_snd, HL7EventMessageTypes.event_code;";

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

		// String string = createSegmentString(version, segmentName, elements,
		// description, basePackage, datatypePackageString);
		// out.write(string);

		out.flush();
		out.close();

	}

	public static void generateEventMap(String theOutputPath, String theVersion) throws SQLException, IOException {

		ArrayList<String> messages = MessageGenerator.getMessages(theVersion).messages;

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
		Map<String, Set<String>> trigger2structure = new TreeMap<String, Set<String>>();
		while (rs.next()) {
			String messageType = rs.getString("message_typ_snd");
			String triggerCode = rs.getString("event_code");
			final String trigger = messageType + "_" + triggerCode;
			String structure = rs.getString("message_structure_snd");

			if (messages.contains(trigger)) {
				ourLog.info("Skipping Eventmap for trigger {} because a structure exists!", trigger);
				continue;
			}

			if ("ACK".equals(messageType)) {
				continue;
			}
			if ("NUL".equals(structure)) {
				continue;
			}

			/*
			 * This logic keeps the structure value which matches exactly the
			 * trigger value at the end of the list. This is desirable as
			 * sometimes multiple structures mark themselves as being associated
			 * with the same trigger event, so we want to favour the one with
			 * the matching name.
			 * 
			 * Example: for an ORM^R01, favour creating an ORM_O01 structure and
			 * not an OMD_O01 even though the latter also declares itself as
			 * being the structure for ORM^R01 in the database.
			 */

			if (!trigger2structure.containsKey(trigger)) {
				trigger2structure.put(trigger, new TreeSet<String>(new Comparator<String>() {

					public int compare(String theO1, String theO2) {
						if (theO1.equals(theO2)) {
							return 0;
						} else if (theO1.equals(trigger)) {
							return 1;
						} else if (theO2.equals(trigger)) {
							return -1;
						} else {
							return theO1.compareTo(theO2);
						}
					}
				}));
			}

			trigger2structure.get(trigger).add(structure);

		}

		for (Map.Entry<String, Set<String>> nextEntry : trigger2structure.entrySet()) {
			for (String nextStructure : nextEntry.getValue()) {
				writer.append(nextEntry.getKey()).append("\t").append(nextStructure).append("\r\n");
			}
		}

		rs.close();
		writer.close();
	}

	private static List<TriggerDesc> getTriggers(String theVersion) throws SQLException {
		String query = //
		"SELECT HL7Versions.hl7_version, HL7EventMessageTypes.message_typ_snd, HL7Events.event_code, " + "       HL7EventMessageTypes.message_structure_snd, HL7Events.description," + "        HL7EventMessageTypes.message_structure_return " + "FROM   HL7Versions "
				+ "INNER JOIN (HL7Events INNER JOIN HL7EventMessageTypes ON (HL7Events.version_id = HL7EventMessageTypes.version_id) AND (HL7Events.event_code = HL7EventMessageTypes.event_code)) ON HL7Versions.version_id = HL7Events.version_id"
				+ " WHERE HL7Versions.hl7_version = '" + theVersion + "';";

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
