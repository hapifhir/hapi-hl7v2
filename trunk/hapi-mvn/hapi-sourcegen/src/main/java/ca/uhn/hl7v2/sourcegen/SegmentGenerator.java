/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "SegmentGenerator.java".  Description:
 * "This class is responsible for generating source code for HL7 segment objects"
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.database.NormativeDatabase;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;

/**
 * This class is responsible for generating source code for HL7 segment objects.
 * Each automatically generated segment inherits from AbstractSegment.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class SegmentGenerator extends java.lang.Object {

	private static final Logger log = LoggerFactory.getLogger(SegmentGenerator.class);

	/**
	 * <p>Creates skeletal source code (without correct data structure but no business
	 * logic) for all segments found in the normative database.  </p>
	 */
	public static void makeAll(String baseDirectory, String version, String theTemplatePackage, String theFileExt) throws IOException, SQLException, HL7Exception {
		//make base directory
		if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) {
			baseDirectory = baseDirectory + "/";
		}
		File targetDir = SourceGenerator.makeDirectory(baseDirectory + DefaultModelClassFactory.getVersionPackagePath(version) + "segment");

		ArrayList<String> segments = getSegmentNames(version);

		if (segments.size() == 0) {
			log.warn("No version {} segments found in database {}", 
					version, System.getProperty("ca.on.uhn.hl7.database.url"));
		}

		for (int i = 0; i < segments.size(); i++) {
			try {
				String seg = (String) segments.get(i);
				makeSegment(seg, version, theTemplatePackage, targetDir, theFileExt);
			} catch (Exception e) {
				System.err.println("Error creating source code for all segments: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

    public static ArrayList<String> getSegmentNames(String version) throws SQLException {
        //get list of segments
		NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
		Connection conn = normativeDatabase.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "SELECT seg_code, section from HL7Segments, HL7Versions where HL7Segments.version_id = HL7Versions.version_id AND hl7_version = '" + version + "'";
		//System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<String> segments = new ArrayList<String>();
		while (rs.next()) {
			String segName = rs.getString(1);

            // The DB has an invalid segment with this name
            if ("ED".equals(segName)) {
                continue;
            }

			if (Character.isLetter(segName.charAt(0))) {
				segments.add(altSegName(segName));
			}
		}
		stmt.close();
		normativeDatabase.returnConnection(conn);
        return segments;
    }

	/**
	 * <p>Returns an alternate segment name to replace the given segment name.  Substitutions
	 * made include:  </p>
	 * <ul><li>Replacing Z.. with Z</li>
	 *<li>Replacing ??? with ???</li></ul>
	 */
	public static String altSegName(String segmentName) {
		String ret = segmentName;
		if (ret.equals("Z..")) {
			ret = "Z";
		}
		if (ret.equals("CON")) {
			ret = "CON_";
		}
		return ret;
	}

	/**
	 * Returns the Java source code for a class that represents the specified segment.
	 */
	public static void makeSegment(String name, String version, String theTemplatePackage, File theTargetDir, String theFileExt) throws Exception {

		ArrayList<SegmentElement> elements = new ArrayList<SegmentElement>();
		String segDesc = null;
		SegmentElement se = null;

        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
		try {
			Connection conn = normativeDatabase.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT HL7SegmentDataElements.seg_code, HL7SegmentDataElements.seq_no, ");
			sql.append("HL7SegmentDataElements.repetitional, HL7SegmentDataElements.repetitions, ");
			sql.append("HL7DataElements.description, HL7DataElements.length, HL7DataElements.table_id, ");
			sql.append("HL7SegmentDataElements.req_opt, HL7Segments.description, HL7DataElements.data_structure ");
			sql.append("FROM HL7Versions RIGHT JOIN (HL7Segments INNER JOIN (HL7DataElements INNER JOIN HL7SegmentDataElements ");
			sql.append("ON (HL7DataElements.version_id = HL7SegmentDataElements.version_id) ");
			sql.append("AND (HL7DataElements.data_item = HL7SegmentDataElements.data_item)) ");
			sql.append("ON (HL7Segments.version_id = HL7SegmentDataElements.version_id) ");
			sql.append("AND (HL7Segments.seg_code = HL7SegmentDataElements.seg_code)) ");
			sql.append("ON (HL7Versions.version_id = HL7Segments.version_id) ");
			sql.append("WHERE HL7SegmentDataElements.seg_code = '");
			sql.append(name);
			sql.append("' and HL7Versions.hl7_version = '");
			sql.append(version);
			sql.append("' ORDER BY HL7SegmentDataElements.seg_code, HL7SegmentDataElements.seq_no;");
			//System.out.println(sql.toString());  //for debugging
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());

			List<String> usedFieldDescs = new ArrayList<String>();
			int index = 0;
			while (rs.next()) {
				if (segDesc == null) {
					segDesc = rs.getString(9);
				}
				se = new SegmentElement(name, version, index++);
				se.field = rs.getInt(2);
				se.rep = rs.getString(3);
				se.repetitions = rs.getInt(4);
				if (se.repetitions == 0) {
					if (se.rep == null || !se.rep.equalsIgnoreCase("Y")) {
						se.repetitions = 1;
					}
				}
				se.desc = rs.getString(5);

				// If two fields have the same name, add "Rep 1" or "Rep 2" etc to the name
				String originalSeDesc = se.desc;
				if (usedFieldDescs.contains(se.desc)) {
					se.desc = se.desc + " Number " + (Collections.frequency(usedFieldDescs, originalSeDesc) + 1);
				}
				usedFieldDescs.add(originalSeDesc);

				se.length = rs.getInt(6);
				se.table = rs.getInt(7);
				se.opt = rs.getString(8);
				se.type = rs.getString(10);
				//shorten CE_x to CE
				if (se.type.startsWith("CE")) {
					se.type = "CE";
				}

				// Fix problems
				if (se.type.equals("-") || se.type.equals("NUL")) {
					se.type = "NULLDT";
				}
				
				// 3454369
				if (version.equals("2.3") && name.equals("MRG") && index == 7) {
					se.type = "XPN";
				}

				// 2864817
				if (version.equals("2.3") && name.equals("PID") && index == 5) {
					se.rep = "Y";
					se.repetitions = -1;
				}

				elements.add(se);
				/*System.out.println("Segment: " + name + " Field: " + se.field + " Rep: " + se.rep +
				" Repetitions: " + se.repetitions + " Desc: " + se.desc + " Length: " + se.length +
				" Table: " + se.table + " Segment Desc: " + segDesc);*/
			}
			stmt.close();
			normativeDatabase.returnConnection(conn);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return;
		}
		
		String fileName = theTargetDir.toString() + "/" + name + "." + theFileExt;
		
		String basePackageName = DefaultModelClassFactory.getVersionPackageName(version);
		String[] datatypePackages = { basePackageName + "datatype" };
        writeSegment(fileName, version, name, elements, segDesc, basePackageName, datatypePackages, theTemplatePackage);

	}



	public static void writeSegment(String fileName, String version, String segmentName, ArrayList<SegmentElement> elements, String description, String basePackage, String[] datatypePackages, String theTemplatePackage) throws Exception {
		log.info("Writing segment: {}", fileName);
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false), SourceGenerator.ENCODING));
		
        theTemplatePackage = theTemplatePackage.replace(".", "/");
        Template template = VelocityFactory.getClasspathTemplateInstance(theTemplatePackage + "/segment.vsm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("segmentName", segmentName);
        ctx.put("typeDescription", description);
        ctx.put("basePackageName", basePackage);
        ctx.put("elements", elements);
        ctx.put("datatypePackages", datatypePackages);
        ctx.put("hl7VersionInQuotes", '"' + version + '"');
        
        template.merge(ctx, out);
		
//      String string = createSegmentString(version, segmentName, elements, description, basePackage, datatypePackageString);
//      out.write(string);
		
		out.flush();
		out.close();
	}

}
