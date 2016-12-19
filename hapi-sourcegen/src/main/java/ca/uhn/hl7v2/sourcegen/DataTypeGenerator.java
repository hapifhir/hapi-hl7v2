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
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.sourcegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.database.NormativeDatabase;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;


/**
 * Generates skeletal source code for Datatype classes based on the 
 * HL7 database.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class DataTypeGenerator extends Object {
    
    private static final Logger log = LoggerFactory.getLogger(DataTypeGenerator.class);
    private static boolean ourMakeAll;
    
    /**
     * <p>Creates skeletal source code (without correct data structure but no business
     * logic) for all data types found in the normative database.  For versions > 2.2, Primitive data types
     * are not generated, because they are coded manually (as of HAPI 0.3).  
    * @param theTemplatePackage 
     */
    public static void makeAll(String baseDirectory, String version, String theTemplatePackage, String theFileExt) throws IOException, SQLException, HL7Exception {
        //make base directory
        if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) { 
            baseDirectory = baseDirectory + "/";
        }
        File targetDir = SourceGenerator.makeDirectory(baseDirectory + DefaultModelClassFactory.getVersionPackagePath(version) + "datatype"); 
        
        //get list of data types
        
        ArrayList<String> types = getDataTypes(version);
        
        System.out.println("Generating " + types.size() + " datatypes for version " + version);
        if (types.size() == 0) { 
            log.warn("No version {} data types found in database {}", 
            		version, System.getProperty("ca.on.uhn.hl7.database.url"));
        }
                
        for (int i = 0; i < types.size(); i++) {
            try {
                String basePackage = DefaultModelClassFactory.getVersionPackageName(version);
                String dataType = (String)types.get(i);
                
				String hapiTestGenType = System.getProperty("hapi.test.gentype");
				if (hapiTestGenType != null && !hapiTestGenType.contains(dataType)) {
					continue;
				}
                
				make(targetDir, dataType, version, basePackage, theTemplatePackage, theFileExt);
            } catch (DataTypeException dte) {
                log.warn("{} - {}", dte.getClass().getName(), dte.getMessage());
            } catch (Exception e) {
                log.error("Error creating source code for all data types", e);
            } 
        }
    }

    public static ArrayList<String> getDataTypes(String version) throws SQLException {
        ArrayList<String> types = new ArrayList<String>();
        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
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
            String string = rs.getString(1);
            if (string.equals("-")) {
                continue;
            }
            
            types.add(string);
        }
        
        stmt.close();
        normativeDatabase.returnConnection(conn);
        return types;
    }
    
    /**
     * Creates source code for a single data type in the HL7 normative
     * database. 
     * @param targetDirectory the directory into which the file will be written
     * @param datatype the name (e.g. ST, ID, etc.) of the data type to be created
     * @param version the HL7 version of the intended data type
     * @param theFileExt 
     */
    public static void make(File targetDirectory, String dataType, String version, String basePackage, String theTemplatePackage, String theFileExt) throws Exception {
        //make sure that targetDirectory is a directory ... 
        if (!targetDirectory.isDirectory()) throw new IOException("Can't create file in " + 
            targetDirectory.toString() + " - it is not a directory.");
                
        //get any components for this data type
        NormativeDatabase normativeDatabase = NormativeDatabase.getInstance();
        Connection conn = normativeDatabase.getConnection();
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
        
        ArrayList<String> dataTypes = new ArrayList<String>(20);
        ArrayList<String> descriptions = new ArrayList<String>(20);
        ArrayList<Integer> tables = new ArrayList<Integer>(20);
        String description = null;
        while (rs.next()) {
            if (description == null) description = rs.getString(3);

            String de = rs.getString(5);
            String dt = rs.getString(8);
            int ta = rs.getInt(4);
            //trim all CE_x to CE
            if (dt != null) if (dt.startsWith("CE")) dt = "CE";
            //System.out.println("Component: " + de + "  Data Type: " + dt);  //for debugging

            // Prior to HL7 2.5, the first component of a TS was
            // an undefined component HAPI knows as TSComponentOne, but the
            // database knows it as an ST
            if (dataType.equals("TS") && "ST".equals(dt) && dataTypes.isEmpty()) {
                dt = "TSComponentOne";
            }

            dataTypes.add(dt);
            descriptions.add(de);
            tables.add(new Integer(ta));
        }
        stmt.close();
        normativeDatabase.returnConnection(conn);
        
        //if there is only one component make a Primitive, otherwise make a Composite
        String source = null;
        if (dataTypes.size() == 1) {
            if (ourMakeAll || dataType.equals("FT") || dataType.equals("ST") || dataType.equals("TX") 
                    || dataType.equals("NM") || dataType.equals("SI") || dataType.equals("TN")
                    || dataType.equals("GTS")) { 
                source = makePrimitive(new DatatypeDef(dataType, description), version, basePackage, theTemplatePackage);                
            } else {
                source = null; //note: IS, ID, DT, DTM, and TM are coded manually
            }
        } else if (dataTypes.size() > 1) {
            int numComponents = dataTypes.size();
            //copy data into arrays ... 
            String[] type = new String[numComponents];
            String[] desc = new String[numComponents];
            int[] table = new int[numComponents];
            DatatypeComponentDef[] componentDefs = new DatatypeComponentDef[numComponents];
            Set<String> names = new HashSet<String>();
            for (int i = 0; i < numComponents; i++) {
                type[i] = (String)dataTypes.get(i);
                String componentName = (String)descriptions.get(i);
                
                if (names.contains(componentName)) {
               	 for (int j = 2; ; j++) {
               		 if (!names.contains(componentName + j)) {
               			 componentName = componentName + j;
               			 break;
               		 }
               	 }
                }
                names.add(componentName);
                
                desc[i] = componentName;
                table[i] = ((Integer) tables.get(i)).intValue();
                
                String typeName = (String)dataTypes.get(i);
                typeName = SourceGenerator.getAlternateType(typeName, version);
                
                componentDefs[i] = new DatatypeComponentDef(dataType, i, typeName, componentName, ((Integer) tables.get(i)).intValue());
            }
            
            source = makeComposite(dataType, description, componentDefs, type, desc, table, version, basePackage, theTemplatePackage);
        } else {
            if (dataType.equals("var")) {
                return; // Varies isn't actually a type
            }
            
            //no components?  
            throw new DataTypeException("The data type " + dataType + " could not be found");
        }
        
        //System.out.println(source);
        
        //write to file ... 
        if (source != null) {
            String targetFile = targetDirectory.toString() + "/" + dataType + "." + theFileExt;
            BufferedWriter writer = null;
            try {
	            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile, false), SourceGenerator.ENCODING));
	            writer.write(source);
	            writer.flush();
            } finally {
            	if (writer != null) writer.close();
            }
        }
    }

    
    /**
     * Returns a String containing the complete source code for a Primitive HL7 data
     * type.  Note: this method is no longer used, as all Primitives are now coded manually.  
     */
    private static String makePrimitive(DatatypeDef theDatatype, String version, String basePackage, String theTemplatePackage) throws Exception {

            StringWriter out = new StringWriter();

            theTemplatePackage = theTemplatePackage.replace(".", "/");
            Template template = VelocityFactory.getClasspathTemplateInstance(theTemplatePackage + "/datatype_primitive.vsm");
            Context ctx = new VelocityContext();
            ctx.put("datatype", theDatatype);
            ctx.put("version", version);
            ctx.put("basePackageName", basePackage);
            ctx.put("normalBasePackageName", DefaultModelClassFactory.getVersionPackageName(version));
            
            template.merge(ctx, out);
            return out.toString();
            
    }
    
    /**
     * Returns a String containing source code for a Composite data type. The 
     * dataTypes array contains the data type names (e.g. ST) of each component. 
     * The descriptions array contains the corresponding descriptions (e.g. string).
     */
    private static String makeComposite(String dataType, String description, DatatypeComponentDef[] componentDefs, String[] dataTypes, 
            String[] descriptions, int[] tables, String version, String basePackage, String theTemplatePackage) throws Exception {
        
            StringWriter out = new StringWriter();

            for (int i = 0; i < dataTypes.length; i++) {
               if (dataTypes[i].equals(dataType)) {
                  log.warn("Datatype {} has a child also of type {}! Can not recurse like this", dataType, dataType);
                  dataTypes[i] = "ST";
               }
            }
            
            theTemplatePackage = theTemplatePackage.replace(".", "/");
            Template template = VelocityFactory.getClasspathTemplateInstance(theTemplatePackage + "/datatype_composite.vsm");
            Context ctx = new VelocityContext();
            ctx.put("datatypeName", dataType);
            ctx.put("version", version);
            ctx.put("basePackageName", basePackage);
            ctx.put("components", Arrays.asList(componentDefs));
            ctx.put("desc", description);
            
            template.merge(ctx, out);
            return out.toString();
            
    }
    
    //test
    public static void main(String args[]) {
        //System.out.println(makePrimitive("ID", "identifier"));
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //System.setProperty("ca.on.uhn.hl7.database.url", "jdbc:odbc:hl7v25");        
            //make(new File("c:/testsourcegen"), args[0], args[1]);
            //make(new File("c:/testsourcegen"), "CE_0048", "2.3");
            makeAll("c:/testsourcegen", "2.5", "", "java");
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

    public static void writeDatatype(String theFileName, String theVersion, DatatypeDef theFieldDef, String theBasePackage, String theTemplatePackage) throws Exception {
        
        String text;
        if (theFieldDef.getSubComponentDefs().isEmpty()) {
            text = makePrimitive(theFieldDef, theVersion, theBasePackage, theTemplatePackage);
        } else {
            text = makeComposite(theFieldDef.getType(), theFieldDef.getName(), theFieldDef.getSubComponentDefs().toArray(new DatatypeComponentDef[0]), null, null, null, theVersion, theBasePackage, theTemplatePackage);
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(theFileName, false), SourceGenerator.ENCODING));
        writer.write(text);
        writer.flush();
        writer.close();
        
    }
    
    /**
     * Set to true if all data types should be made, including types which are normally
     * not generated because they are special cases. Defaults to false.
     */
    public static void setMakeAll(boolean theMakeAll) {
        ourMakeAll = theMakeAll;
    }
    
}
