/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DataTypeGenerator.java".  Description: 
"Generates skeletal source code for Datatype classes based on the 
  HL7 database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s):  Eric Poiseau. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.sourcegen;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ca.uhn.hl7v2.NormativeDatabase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;


/**
 * Generates skeletal source code for Datatype classes based on the 
 * HL7 database.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class DataTypeGenerator extends Object {
    
    private static final HapiLog log = HapiLogFactory.getHapiLog(DataTypeGenerator.class);
    
    /**
     * <p>Creates skeletal source code (without correct data structure but no business
     * logic) for all data types found in the normative database.  For versions > 2.2, Primitive data types
     * are not generated, because they are coded manually (as of HAPI 0.3).  
     */
    public static void makeAll(String baseDirectory, String version) throws IOException, SQLException, HL7Exception {
        //make base directory
        if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) { 
            baseDirectory = baseDirectory + "/";
        }
        File targetDir = SourceGenerator.makeDirectory(baseDirectory + SourceGenerator.getVersionPackagePath(version) + "datatype"); 
        
        //get list of data types
        ArrayList types = new ArrayList();
        Connection conn = NormativeDatabase.getInstance().getConnection();
        Statement stmt = conn.createStatement();
        //get normal data types ... 
        ResultSet rs = stmt.executeQuery("select data_type_code from HL7DataTypes, HL7Versions where HL7Versions.version_id = HL7DataTypes.version_id and HL7Versions.hl7_version = '" + version + "'");
        while (rs.next()) {
            types.add(rs.getString(1));
        }
        
        //get CF, CK, CM, CN, CQ sub-types ... 
 
       rs = stmt.executeQuery("select data_structure from HL7DataStructures, HL7Versions where (" + 
            "data_type_code  = 'CF' or " + 
            "data_type_code  = 'CK' or " + 
            "data_type_code  = 'CM' or " + 
            "data_type_code  = 'CN' or " + 
            "data_type_code  = 'CQ') and " +
	    "HL7Versions.version_id = HL7DataStructures.version_id and  HL7Versions.hl7_version = '" + version + "'");
        while (rs.next()) {
            types.add(rs.getString(1));
        }
        
        stmt.close();
        NormativeDatabase.getInstance().returnConnection(conn);
        
        System.out.println("Generating " + types.size() + " datatypes for version " + version);
        if (types.size() == 0) { 
            log.warn("No version " + version + " data types found in database " + System.getProperty("ca.on.uhn.hl7.database.url"));
        }
                
        for (int i = 0; i < types.size(); i++) {
            try {
                make(targetDir, (String)types.get(i), version);
            } catch (DataTypeException dte) {
                log.warn(dte.getClass().getName() + " - " + dte.getMessage());
            } catch (Exception e) {
                log.error("Error creating source code for all data types", e);
            } 
        }
    }
    
    /**
     * Creates source code for a single data type in the HL7 normative
     * database. 
     * @param targetDirectory the directory into which the file will be written
     * @param datatype the name (e.g. ST, ID, etc.) of the data type to be created
     * @param version the HL7 version of the intended data type
     */
    public static void make(File targetDirectory, String dataType, String version) throws SQLException, DataTypeException, IOException, HL7Exception {
        //make sure that targetDirectory is a directory ... 
        if (!targetDirectory.isDirectory()) throw new IOException("Can't create file in " + 
            targetDirectory.toString() + " - it is not a directory.");
                
        //get any components for this data type
        Connection conn = NormativeDatabase.getInstance().getConnection();
        Statement stmt = conn.createStatement();
        StringBuffer sql = new StringBuffer();
        //this query is adapted from the XML SIG informative document
        sql.append("SELECT HL7DataStructures.data_structure, HL7DataStructureComponents.seq_no, HL7DataStructures.description, HL7DataStructureComponents.table_id,  ");
        sql.append("HL7Components.description, HL7Components.table_id, HL7Components.data_type_code, HL7Components.data_structure ");
        sql.append("FROM HL7Versions LEFT JOIN (HL7DataStructures LEFT JOIN (HL7DataStructureComponents LEFT JOIN HL7Components ");
        sql.append("ON HL7DataStructureComponents.comp_no = HL7Components.comp_no AND ");
        sql.append("HL7DataStructureComponents.version_id = HL7Components.version_id) ");
        sql.append("ON HL7DataStructures.version_id = HL7DataStructureComponents.version_id ");
        sql.append("AND HL7DataStructures.data_structure = HL7DataStructureComponents.data_structure) ");
        sql.append("ON HL7DataStructures.version_id = HL7Versions.version_id ");
        sql.append("WHERE HL7DataStructures.data_structure = '");
        sql.append(dataType);
        sql.append("' AND HL7Versions.hl7_version = '");
        sql.append(version);
        sql.append("' ORDER BY HL7DataStructureComponents.seq_no");
        //System.out.println(sql.toString());  //for debugging
        ResultSet rs = stmt.executeQuery(sql.toString());
        
        ArrayList dataTypes = new ArrayList(20);
        ArrayList descriptions = new ArrayList(20);
        ArrayList tables = new ArrayList(20);
        String description = null;
        while (rs.next()) {
            if (description == null) description = rs.getString(3);

            String de = rs.getString(5);
            String dt = rs.getString(8);
            int ta = rs.getInt(4);
            //trim all CE_x to CE
            if (dt != null) if (dt.startsWith("CE")) dt = "CE";
            //System.out.println("Component: " + de + "  Data Type: " + dt);  //for debugging
            dataTypes.add(dt);
            descriptions.add(de);
            tables.add(new Integer(ta));
        }
        stmt.close();
        NormativeDatabase.getInstance().returnConnection(conn);
        
        //if there is only one component make a Primitive, otherwise make a Composite
        String source = null;
        if (dataTypes.size() == 1) {
            if (dataType.equals("FT") || dataType.equals("ST") || dataType.equals("TX") 
                    || dataType.equals("NM") || dataType.equals("SI") || dataType.equals("TN")
                    || dataType.equals("GTS")) { 
                source = makePrimitive(dataType, description, version);                
            } else {
                source = null; //note: IS, ID, DT, DTM, and TM are coded manually
            }
        } else if (dataTypes.size() > 1) {
            int numComponents = dataTypes.size();
            //copy data into arrays ... 
            String[] type = new String[numComponents];
            String[] desc = new String[numComponents];
            int[] table = new int[numComponents];
            for (int i = 0; i < numComponents; i++) {
                type[i] = (String)dataTypes.get(i);
                desc[i] = (String)descriptions.get(i);
                table[i] = ((Integer) tables.get(i)).intValue();
            }
            source = makeComposite(dataType, description, type, desc, table, version);
        } else {
            //no components?  
            throw new DataTypeException("The data type " + dataType + " could not be found");
        }
        
        //System.out.println(source);
        
        //write to file ... 
        if (source != null) {
            String targetFile = targetDirectory.toString() + "/" + dataType + ".java";
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile, false));
            writer.write(source);
            writer.flush();
        }
    }
    
    /**
     * Returns a String containing the complete source code for a Primitive HL7 data
     * type.  Note: this method is no longer used, as all Primitives are now coded manually.  
     */
    private static String makePrimitive(String datatype, String description, String version) throws HL7Exception {
        //System.out.println("Making primitive: " + datatype);
        StringBuffer source = new StringBuffer();
        
        source.append("package ");
        source.append(SourceGenerator.getVersionPackageName(version));
        source.append("datatype;\r\n\r\n");
        source.append("import ca.uhn.hl7v2.model.Primitive;\r\n");
        source.append("import ca.uhn.hl7v2.model.DataTypeException;\r\n");
        source.append("import ca.uhn.hl7v2.model.Message;\r\n");
        source.append("import ca.uhn.hl7v2.model.Type;\r\n");
        source.append("import ca.uhn.hl7v2.model.AbstractPrimitive;\r\n\r\n");
        source.append("/**\r\n");
        source.append(" * <p>Represents the HL7 ");
        source.append(datatype);
        source.append(" (");
        source.append(description);
        source.append(") datatype.  A ");
        source.append(datatype);
        source.append(" contains a single String value.\r\n");
        source.append(" */\r\n");
        source.append("public class ");
        source.append(datatype);
        source.append(" extends AbstractPrimitive ");
        source.append(" {\r\n\r\n");
        //source.append("\tprotected String value;\r\n\r\n");
        source.append("\t/**\r\n");
        source.append("\t * Constructs an uninitialized ");
        source.append(datatype);
        source.append(".\r\n");
        source.append("\t * @param message the Message to which this Type belongs\r\n");
        source.append("\t */\r\n");
        source.append("\tpublic ");
        source.append(datatype);
        source.append("(Message message) {\r\n");
        source.append("\t\tsuper(message);\r\n");
        source.append("\t}\r\n\r\n");
        //source.append("\t/**\r\n");
        //source.append("\t * Constructs a ");
        //source.append(datatype);
        //source.append(" with the given value.\r\n");
        //source.append("\t */\r\n");
        //source.append("\tpublic ");
        //source.append(datatype);
        //source.append("(String value) {\r\n");
        //source.append("\t\tthis.value = value;\r\n");
        //source.append("\t}\r\n\r\n");
//        source.append("\t/**\r\n");
//        source.append("\t * Sets the value (a private field), which implementing classes should validate.\r\n");
//        source.append("\t */\r\n");
//        source.append("\tpublic void setValue(String value) throws DataTypeException { \r\n");
//        source.append("\t\tthis.value = value;\r\n\t}\r\n\r\n");
//        source.append("\t/**\r\n");
//        source.append("\t * Returns the value.\r\n");
//        source.append("\t */\r\n");
//        source.append("\tpublic String getValue() {\r\n");
//        source.append("\t\treturn this.value;\r\n");
//        source.append("\t}\r\n");
        /*if (correspondingControlInterface != null) {
            source.append(Control.getImplementation(correspondingControlInterface, version));
        }*/
        source.append("\t/**\r\n");
        source.append("\t * @return \"");
        source.append(version);
        source.append("\"\r\n");
        source.append("\t */\r\n");
        source.append("\tpublic String getVersion() {\r\n");
        source.append("\t    return \"");
        source.append(version);
        source.append("\";\r\n");
        source.append("\t}\r\n\r\n");
        source.append("}\r\n");
        
        return source.toString();
    }
    
    /**
     * Returns a String containing source code for a Composite data type. The 
     * dataTypes array contains the data type names (e.g. ST) of each component. 
     * The descriptions array contains the corresponding descriptions (e.g. string).
     */
    private static String makeComposite(String dataType, String description, String[] dataTypes, 
            String[] descriptions, int[] tables, String version) throws HL7Exception {
        StringBuffer source = new StringBuffer();
        source.append("package ");
        source.append(SourceGenerator.getVersionPackageName(version));
        source.append("datatype;\r\n\r\n");
        source.append("import ca.uhn.hl7v2.model.Composite;\r\n");
        source.append("import ca.uhn.hl7v2.model.DataTypeException;\r\n");
        source.append("import ca.uhn.hl7v2.model.Message;\r\n");
        source.append("import ca.uhn.hl7v2.model.Type;\r\n");
        source.append("import ca.uhn.hl7v2.model.AbstractType;\r\n");
        source.append("import ca.uhn.log.HapiLogFactory;\r\n\r\n");
        source.append("/**\r\n");
        source.append(" * <p>The HL7 ");
        source.append(dataType);
        source.append(" (");
        source.append(description);
        source.append(") data type.  Consists of the following components: </p><ol>\r\n");
        for (int i = 0; i < dataTypes.length; i++) {
            source.append(" * <li>");
            source.append(descriptions[i]);
            source.append(" (");
            source.append(dataTypes[i]);
            source.append(")</li>\r\n");
        }
        source.append(" * </ol>\r\n");
        source.append(" */\r\n");
        source.append("public class ");
        source.append(dataType);
        source.append(" extends AbstractType implements ");

        //implement interface from model.control package if required
        //Class correspondingControlInterface = Control.getInterfaceImplementedBy(dataType);
        //if (correspondingControlInterface == null) {
            source.append("Composite");
        //} else { 
	    //            source.append(correspondingControlInterface.getName());
        //}
        
        source.append(" {\r\n\r\n");        
        source.append("\tprivate Type[] data;\r\n\r\n");
        source.append("\t/**\r\n");
        source.append("\t * Creates a ");
        source.append(dataType);
        source.append(".\r\n");
        source.append("\t * @param message the Message to which this Type belongs\r\n");
        source.append("\t */\r\n");
        source.append("\tpublic ");
        source.append(dataType);
        source.append("(Message message) {\r\n");
        source.append("\t\tsuper(message);\r\n");
        source.append("\t\tdata = new Type[");
        source.append(dataTypes.length);
        source.append("];\r\n");
        for (int i = 0; i < dataTypes.length; i++) {
            source.append("\t\tdata[");
            source.append(i);
            source.append("] = new ");
            source.append(SourceGenerator.getAlternateType(dataTypes[i], version));
            if (dataTypes[i].equals("ID") || dataTypes[i].equals("IS")) {
                source.append("(message, ");                
                source.append(tables[i]); 
                source.append(")");                
            } else {
                source.append("(message)");                
            }
            source.append(";\r\n");
        }
        source.append("\t}\r\n\r\n");
        source.append("\t/**\r\n");
        source.append("\t * Returns an array containing the data elements.\r\n");
        source.append("\t */\r\n");
        source.append("\tpublic Type[] getComponents() { \r\n");
        source.append("\t\treturn this.data; \r\n");
        source.append("\t}\r\n\r\n");
        source.append("\t/**\r\n");        
        source.append("\t * Returns an individual data component.\r\n");        
        source.append("\t * @throws DataTypeException if the given element number is out of range.\r\n");        
        source.append("\t */\r\n");        
        source.append("\tpublic Type getComponent(int number) throws DataTypeException { \r\n\r\n");
        source.append("\t\ttry { \r\n");
        source.append("\t\t\treturn this.data[number]; \r\n");
        source.append("\t\t} catch (ArrayIndexOutOfBoundsException e) { \r\n");
        source.append("\t\t\tthrow new DataTypeException(\"Element \" + number + \" doesn't exist in ");
        source.append(dataTypes.length);
        source.append(" element ");
        source.append(dataType);
        source.append(" composite\"); \r\n");
        source.append("\t\t} \r\n");
        source.append("\t} \r\n");
        
        //make type-specific accessors ... 
        for (int i = 0; i < dataTypes.length; i++) {
            String dtName = SourceGenerator.getAlternateType(dataTypes[i], version);
            source.append("\t/**\r\n");
            source.append("\t * Returns ");
            source.append(descriptions[i]);
            source.append(" (component #");
            source.append(i);
            source.append(").  This is a convenience method that saves you from \r\n");
            source.append("\t * casting and handling an exception.\r\n");
            source.append("\t */\r\n");
            source.append("\tpublic ");
            source.append(dtName);
            source.append(" ");
            source.append(SourceGenerator.makeAccessorName(descriptions[i]));
            source.append("() {\r\n");
            source.append("\t   ");
            source.append(dtName);
            source.append(" ret = null;\r\n");
            source.append("\t   try {\r\n");
            source.append("\t      ret = (");
            source.append(dtName);
            source.append(")getComponent(");
            source.append(i);
            source.append(");\r\n");
            source.append("\t   } catch (DataTypeException e) {\r\n"); 
            source.append("\t      HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected problem accessing known data type component - this is a bug.\", e);\r\n");
            source.append("\t      throw new RuntimeException(e);\r\n");
            source.append("\t   }\r\n");
            source.append("\t   return ret;\r\n");
            source.append("\t}\r\n\r\n");
        }
        /*if (correspondingControlInterface != null) {
            source.append(Control.getImplementation(correspondingControlInterface, version));
        } */       
        source.append("}");
        
        return source.toString();
    }
    
    //test
    public static void main(String args[]) {
        //System.out.println(makePrimitive("ID", "identifier"));
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //System.setProperty("ca.on.uhn.hl7.database.url", "jdbc:odbc:hl7v25");        
            //make(new File("c:/testsourcegen"), args[0], args[1]);
            //make(new File("c:/testsourcegen"), "CE_0048", "2.3");
            makeAll("c:/testsourcegen", "2.5");
        } catch (Exception e) {
            e.printStackTrace();
        }
           
        //test directory maker
        /*try {
            makeDirectory(args[0]);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }*/
    }
}
