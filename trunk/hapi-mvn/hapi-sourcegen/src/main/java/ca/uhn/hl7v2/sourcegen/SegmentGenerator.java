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

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.database.NormativeDatabase;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;


/**
 * This class is responsible for generating source code for HL7 segment objects.
 * Each automatically generated segment inherits from AbstractSegment.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class SegmentGenerator extends java.lang.Object {
    
    private static final HapiLog log = HapiLogFactory.getHapiLog(SegmentGenerator.class);

    /**
     * <p>Creates skeletal source code (without correct data structure but no business
     * logic) for all segments found in the normative database.  </p>
     */
    public static void makeAll(String baseDirectory, String version) throws IOException, SQLException, HL7Exception {
        //make base directory
        if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) {
            baseDirectory = baseDirectory + "/";
        }
        File targetDir = SourceGenerator.makeDirectory(baseDirectory + DefaultModelClassFactory.getVersionPackagePath(version) + "segment");
        
        //get list of data types
        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT seg_code, section from HL7Segments, HL7Versions where HL7Segments.version_id = HL7Versions.version_id AND hl7_version = '" + version + "'";
        //System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList segments = new ArrayList();
        while (rs.next()) {
            String segName = rs.getString(1);
            if (Character.isLetter(segName.charAt(0))) segments.add(altSegName(segName));
        }
        stmt.close();
        normativeDatabase.returnConnection(conn);
        
        if (segments.size() == 0) { 
            log.warn("No version " + version + " segments found in database " + System.getProperty("ca.on.uhn.hl7.database.url"));
        }
        
        for (int i = 0; i < segments.size(); i++) {
            try {
                String seg = (String)segments.get(i);
                String source = makeSegment(seg, version, normativeDatabase);
                BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetDir.toString() + "/" + seg + ".java", false), SourceGenerator.ENCODING));
                w.write(source);
                w.flush();
                w.close();
            } catch (Exception e) {
                System.err.println("Error creating source code for all segments: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * <p>Returns an alternate segment name to replace the given segment name.  Substitutions
     * made include:  </p>
     * <ul><li>Replacing Z.. with Z</li>
     *<li>Replacing ??? with ???</li></ul>
     */
    public static String altSegName(String segmentName) {
        String ret = segmentName;
        if (ret.equals("Z..")) ret = "Z";
        if (ret.equals("CON")) ret = "CON_";
        return ret;
    }
    
    /**
     * Returns the Java source code for a class that represents the specified segment.
     */
    public static String makeSegment(String name, String version, NormativeDatabase normativeDatabase) throws HL7Exception {
        
        StringBuffer source = new StringBuffer();
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
            ArrayList elements = new ArrayList();
            String segDesc = null;
            SegmentElement se;
            
            List usedFieldDescs = new ArrayList();
            while (rs.next()) {
                if (segDesc == null) segDesc = rs.getString(9);
                se = new SegmentElement();
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
                if (se.type.startsWith("CE")) se.type = "CE";
                
                if (se.type.equals("-") || se.type.equals("NUL")) {
                    se.type.equals("NULLDT");
                }
                
                elements.add(se);
                /*System.out.println("Segment: " + name + " Field: " + se.field + " Rep: " + se.rep +
                    " Repetitions: " + se.repetitions + " Desc: " + se.desc + " Length: " + se.length +
                    " Table: " + se.table + " Segment Desc: " + segDesc);*/
            }
            stmt.close();
            normativeDatabase.returnConnection(conn);
            
            //write imports, class documentation, etc ...
            source.append("package ");
            source.append(DefaultModelClassFactory.getVersionPackageName(version));
            source.append("segment;\r\n\r\n");
            source.append("import ca.uhn.hl7v2.model.*;\r\n");
            source.append("import ");
            source.append(DefaultModelClassFactory.getVersionPackageName(version));
            source.append("datatype.*;\r\n\r\n");
            source.append("import ca.uhn.log.HapiLogFactory;\r\n");
            source.append("import ca.uhn.hl7v2.parser.ModelClassFactory;\r\n");
            source.append("import ca.uhn.hl7v2.HL7Exception;\r\n\r\n");
            source.append("/**\r\n");
            source.append(" * <p>Represents an HL7 ");
            source.append(name);
            source.append(" message segment. \r\n");
            source.append(" * This segment has the following fields:</p><p>\r\n");
            for (int i = 0; i < elements.size(); i++) {
                se = (SegmentElement)elements.get(i);
                source.append(" * ");
                source.append(name);
                source.append("-");
                source.append(se.field);
                source.append(": ");
                source.append(se.desc);
                source.append(" (");
                source.append(se.type);
                source.append(")<br> \r\n");
            }
            source.append(" * </p><p>The get...() methods return data from individual fields.  These methods \r\n");
            source.append(" * do not throw exceptions and may therefore have to handle exceptions internally.  \r\n");
            source.append(" * If an exception is handled internally, it is logged and null is returned.  \r\n");
            source.append(" * This is not expected to happen - if it does happen this indicates not so much \r\n");
            source.append(" * an exceptional circumstance as a bug in the code for this class.</p>    \r\n");
            source.append(" */\r\n");
            source.append("public class ");
            source.append(name);
            source.append(" extends AbstractSegment ");
            
            //implement interface from model.control package if required
            /*Class correspondingControlInterface = Control.getInterfaceImplementedBy(name);
            if (correspondingControlInterface != null) {
                source.append("implements ");
                source.append(correspondingControlInterface.getName());
            } */           
            
            source.append(" {\r\n\r\n");
            source.append("  /**\r\n");
            source.append("   * Creates a ");
            source.append(name);
            source.append(" (");
            source.append(segDesc);
            source.append(") segment object that belongs to the given \r\n");
            source.append("   * message.  \r\n");
            source.append("   */\r\n");
            
            //write constructor
            source.append("  public ");
            source.append(name);
            source.append("(Group parent, ModelClassFactory factory) {\r\n");
            source.append("    super(parent, factory);\r\n");
            source.append("    Message message = getMessage();\r\n");
            if (elements.size() > 0) {
                source.append("    try {\r\n");
                for (int i = 0; i < elements.size(); i++) {
                    se = (SegmentElement)elements.get(i);
                    String type = SourceGenerator.getAlternateType(se.type, version);
                    source.append("       this.add(");
                    source.append(type);
                    source.append(".class");
                    source.append(", ");
                    if (se.opt == null) {
                        source.append("false");
                    } else {
                        if (se.opt.equalsIgnoreCase("R")) {
                            source.append("true");
                        } else {
                            source.append("false");
                        }
                    }
                    source.append(", ");
                    source.append(se.repetitions);
                    source.append(", ");
                    source.append(se.length);
                    source.append(", ");  
                    if (se.type.equals("ID") || se.type.equals("IS")) {
                        source.append("new Object[]{message, new Integer(");
                        source.append(se.table);
                        source.append(")}");
                    } else {
                        source.append("new Object[]{message}");                          
                    }
                    source.append(", \"").append(se.desc.replace("\"", "\\\"")).append("\"");
                    source.append(");\r\n");  
                }
                source.append("    } catch (HL7Exception he) {\r\n");
                source.append("        HapiLogFactory.getHapiLog(this.getClass()).error(\"Can't instantiate \" + this.getClass().getName(), he);\r\n");
                source.append("    }\r\n");
            }
            source.append("  }\r\n\r\n");
            
            //write a datatype-specific accessor for each field
            for (int i = 0; i < elements.size(); i++) {  
              se = (SegmentElement)elements.get(i);
              makeFieldAccessor(name, version, source, se, SourceGenerator.makeAccessorName(se.desc, name));
              makeFieldAccessor(name, version, source, se, SourceGenerator.makeAlternateAccessorName(se.desc, name, i+1));
            }
            
            //add adapter method code for control package if it exists
            //source.append(Control.getImplementation(correspondingControlInterface, version));
            
            // CreatNewType method - To avoid reflection
            source.append("   protected Type createNewTypeWithoutReflection(int field) {\r\n");
            source.append("      switch (field) {\r\n");
            for (int i = 0; i < elements.size(); i++) {
                se = (SegmentElement)elements.get(i);
                String type = SourceGenerator.getAlternateType(se.type, version);
                source.append("         case " + i + ": return new ");
                if ("Varies".equals(type)) {
                	source.append("Varies(getMessage());\r\n");
                } else {
	                source.append(DefaultModelClassFactory.getVersionPackageName(version));
	                source.append("datatype.");
	                source.append(type);
	                source.append("(getMessage()");
	                if (se.type.equals("ID") || se.type.equals("IS")) {
	                    source.append(", new Integer(");
	                    source.append(se.table);
	                    source.append(")");
	                }
	                source.append(");\r\n");
                }
            }
            source.append("         default: return null;\r\n");
            source.append("      }\r\n");
            source.append("   }\r\n");
            source.append("\r\n");
            
            source.append("}");
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
        return source.toString();
    }

	private static void makeFieldAccessor(String name, String version, StringBuffer source, SegmentElement se, Object accessorName) {
		if (!se.desc.equalsIgnoreCase("UNUSED")) {  //some entries in 2.1 DB say "unused"
		    String type = SourceGenerator.getAlternateType(se.type, version);
		    source.append("  /**\r\n");
		    source.append("   * Returns ");
		    if (se.repetitions != 1) source.append("a single repetition of ");
		    source.append(se.desc);
		    source.append(" (");
		    source.append(name);
		    source.append("-");
		    source.append(se.field);
		    source.append(").\r\n");
		    if (se.repetitions != 1) {
		        source.append("   * @param rep the repetition number (this is a repeating field)\r\n");
		        source.append("   * @throws HL7Exception if the repetition number is invalid.\r\n");
		    }
		    source.append("   */\r\n");
		    source.append("  public ");
		    source.append(type);
		    source.append(" ");
		    source.append(accessorName);
		    source.append("(");
		    if (se.repetitions != 1) source.append("int rep");
		    source.append(") ");
		    if (se.repetitions != 1) source.append("throws HL7Exception");
		    source.append(" {\r\n");
		    source.append("    ");
		    source.append(type);
		    source.append(" ret = null;\r\n");
		    source.append("    try {\r\n");
		    source.append("        Type t = this.getField(");
		    source.append(se.field);
		    source.append(", ");
		    if (se.repetitions == 1) {
		        source.append("0");
		    } else {
		        source.append("rep");
		    }
		    source.append(");\r\n");
		    source.append("        ret = (");
		    source.append(type);
		    source.append(")t;\r\n");
		    
		    source.append("    } catch (ClassCastException cce) {\r\n");
		    source.append("        HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected problem obtaining field value.  This is a bug.\", cce);\r\n");
		    source.append("        throw new RuntimeException(cce);\r\n");
		    if (se.repetitions == 1) {
		        source.append("    } catch (HL7Exception he) {\r\n");
		        source.append("        HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected problem obtaining field value.  This is a bug.\", he);\r\n");
		        source.append("        throw new RuntimeException(he);\r\n");
		    }
		    source.append("    }\r\n");
		    source.append("    return ret;\r\n");
		    source.append("  }\r\n\r\n");
		    
		    //add an array accessor as well for repeating fields
		    if (se.repetitions != 1) {
		        source.append("  /**\r\n");
		        source.append("   * Returns all repetitions of ");
		        source.append(se.desc);
		        source.append(" (");
		        source.append(name);
		        source.append("-");
		        source.append(se.field);
		        source.append(").\r\n");
		        source.append("   */\r\n");
		        source.append("  public ");
		        source.append(type);
		        source.append("[] ");
		        source.append(accessorName);
		        source.append("() {\r\n");
		        source.append("     ");
		        source.append(type);
		        source.append("[] ret = null;\r\n");
		        source.append("    try {\r\n");
		        source.append("        Type[] t = this.getField(");
		        source.append(se.field);
		        source.append(");  \r\n");
		        source.append("        ret = new ");
		        source.append(type);
		        source.append("[t.length];\r\n");
		        source.append("        for (int i = 0; i < ret.length; i++) {\r\n");
		        source.append("            ret[i] = (");
		        source.append(type);
		        source.append(")t[i];\r\n");
		        source.append("        }\r\n");
		        source.append("    } catch (ClassCastException cce) {\r\n");
		        source.append("        HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected problem obtaining field value.  This is a bug.\", cce);\r\n");
		        source.append("        throw new RuntimeException(cce);\r\n");
		        source.append("    } catch (HL7Exception he) {\r\n");
		        source.append("        HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected problem obtaining field value.  This is a bug.\", he);\r\n");
		        source.append("        throw new RuntimeException(he);\r\n");
		        source.append("    }\r\n");
		        source.append("    return ret;\r\n");
		        source.append("  }\r\n\r\n");
		    }
		  }
	}
    
    
    public static void main(String args[]) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
            if (args.length == 1) {
                makeAll("tmp", "2.5.1");
            } else {
                String source = makeSegment(args[1], "2.5.1", normativeDatabase);
                BufferedWriter w = new BufferedWriter(new FileWriter(args[0] + "/" + args[1] + ".java", false));
                w.write(source);
                w.flush();
                w.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
