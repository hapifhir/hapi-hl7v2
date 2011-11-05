/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefinitionLoader.java".  Description: 
"Loads definitions for RIM classes, attributes, and data types from the RIM database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

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

package ca.uhn.hl7v3.sourcegen;

import java.sql.*;
import java.util.ArrayList;

/**
 * Loads definitions for RIM classes, attributes, and data types from the RIM database.  
 * The definition objects are used to generate source code for RIM classes.  
 * @author Bryan Tripp
 */ 
public class DefinitionLoader {
    
    Connection conn;
    
    /** Creates a new instance of DefinitionLoader */
    public DefinitionLoader(Connection conn) {
        this.conn = conn;
    }
    
    /** Looks up a list of RIM class names in the DB. */
    public String[] getRIMClassNames() throws SQLException {
        return getList("className", "RIM_class", null);
    }
    
    /** Looks up a list of RIM data type names in the DB. */
    public String[] getRIMDataTypeNames() throws SQLException {
        return getList("datatype", "DT_datatypes", "where (datatypeKind = 'Composite' or datatypeKind = 'Generic' or datatypeKind = 'Primitive' or datatypeKind = 'Instance')");        
    }
    
    /** 
     * Looks up a list of items from the given table and field in the DB, using the 
     * given where clause. The <code>where</code> argument should be null if there is 
     * no where clause. 
     */
    private String[] getList(String field, String table, String where) throws SQLException {
        String[] items = null;
        Statement stmt = conn.createStatement();
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append(field);
        sql.append(" from ");
        sql.append(table);
        sql.append(" ");
        if (where != null) sql.append(where);
        
        ResultSet rs = stmt.executeQuery(sql.toString());
        ArrayList<String> tmpList = new ArrayList<String>(150);
        while (rs.next()) {
            tmpList.add(rs.getString(field));
        }
        items = new String[tmpList.size()];
        for (int i = 0; i < items.length; i++) {
            items[i] = (String) tmpList.get(i);
        }
        return items;                
    }
    
    /** Creates a ClassDefinition for the given RIM class by looking up the required information in the DB. */
    public ClassDefinition getRIMClassDef(String className) throws SQLException {
        ClassDefinition def = new ClassDefinition();
        StringBuffer sql = new StringBuffer();
        sql.append("select description, isAbstractClass from RIM_class where className = '");
        sql.append(className);
        sql.append("'");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        if (rs.next()) {
            def.setName(className);
            def.setDescription(rs.getString("description"));
            def.setIsAbstract(rs.getBoolean("isAbstractClass"));
            def.setSuperClass(getRIMSuperClass(className));
        } else {
            stmt.close();
            throw new SQLException("RIM class " + className + " not found in database");
        }
        def.setAttributes(getRIMAttributes(className));
        return def;
    }
    
    /** Looks up a list of attributes for the given class and creates AttributeDefinitions by calling getRIMAttributeDef. */
    public AttributeDefinition[] getRIMAttributes(String className) throws SQLException {
        AttributeDefinition[] defs = null;
        StringBuffer sql = new StringBuffer();
        sql.append("select attName from RIM_attribute where className = '");
        sql.append(className);
        sql.append("'");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        ArrayList<String> attNames = new ArrayList<String>(20);
        while (rs.next()) {
            attNames.add(rs.getString("attName"));
        }
        stmt.close();
        
        defs = new AttributeDefinition[attNames.size()];
        for (int i = 0; i < defs.length; i++) {
            defs[i] = getRIMAttributeDef(className, (String) attNames.get(i));
        }
            
        return defs;
    }
    
    /** Creates an AttributeDefinition for the given attribute by looking up the required information in the DB. */
    public AttributeDefinition getRIMAttributeDef(String className, String attributeName) throws SQLException {
        AttributeDefinition def = new AttributeDefinition();
        StringBuffer sql = new StringBuffer();
        sql.append("select attDatatype, description from RIM_attribute where className = '");
        sql.append(className);
        sql.append("' and attName = '");
        sql.append(attributeName);
        sql.append("'");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        if (rs.next()) {        
            def.setDataType(rs.getString("attDatatype"));
            def.setName(attributeName);
            def.setDescription(rs.getString("description"));
        } else {
            stmt.close();
            throw new SQLException("Attribute " + attributeName + " of RIM class " + className + " not found in database");
        }
        stmt.close();
        return def;
    }
    
    /** Looks up and returns this RIM class' superclass. */
    public String getRIMSuperClass(String className) throws SQLException {
        String superClass = null;
        StringBuffer sql = new StringBuffer();
        sql.append("select sourceClassName from RIM_relationship where destClassName = '");
        sql.append(className);
        sql.append("' and relnName = 'generalizes'");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        if (rs.next()) {
            superClass = rs.getString("sourceClassName");
        }
        stmt.close();
        return superClass;
    }
    
    public DataTypeDefinition getDataTypeDef(String className) throws SQLException {
        DataTypeDefinition def = null;
        StringBuffer sql = new StringBuffer();
        sql.append("select datatypeName, description, datatypeKind from DT_datatypes where datatype = '");
        sql.append(className);
        sql.append("'");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        if (rs.next()) {
            def = new DataTypeDefinition();
            def.setName(className);
            def.setLongName(rs.getString("datatypeName"));
            def.setDescription(rs.getString("description"));
            def.setType(rs.getString("datatypeKind"));
            if (def.getType().equalsIgnoreCase("Composite")) {
                def.setComponents(getComponentDefs(className));
            }
            def.setSuperClass(getDTSuperClass(className));
        }
        stmt.close();
        
        return def;
    }
    
    public ComponentDefinition[] getComponentDefs(String className) throws SQLException {
        StringBuffer sql = new StringBuffer(); 
        sql.append("select componentName, componentDT, description from DT_component where parentDT = '");
        sql.append(className);
        sql.append("'");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        ArrayList<ComponentDefinition> list = new ArrayList<ComponentDefinition>();
        while (rs.next()) {
            ComponentDefinition def = new ComponentDefinition();
            def.setName(rs.getString("componentName"));
            def.setDataType(rs.getString("componentDT"));
            def.setDescription(rs.getString("description"));
            list.add(def);
        }

        ComponentDefinition[] defs = new ComponentDefinition[list.size()];        
        for (int i = 0; i < defs.length; i++) {
            defs[i] = (ComponentDefinition) list.get(i);
        }
        
        return defs; 
    }
    
    /** Looks up the superclass of the given RIM datatype, returns null if there isn't one. */
    public String getDTSuperClass(String dataType) throws SQLException {
        String superClass = null;
        StringBuffer sql = new StringBuffer();
        sql.append("select superDT from DT_generalization where subDT = '");
        sql.append(dataType);
        sql.append("'");
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        if (rs.next()) {
            superClass = rs.getString("superDT");
        }
        stmt.close();
        
        return superClass;
    }
        
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: DefinitionLoader RIM_class");
            System.exit(1);
        }
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:RIM");
            DefinitionLoader dl = new DefinitionLoader(conn);
            //CMPAttributeGenerator gen = new CMPAttributeGenerator();
            //AttributeDefinition def = dl.getRIMAttributeDef(args[0], args[1]);
            //System.out.println(gen.makeBeanCode(def));
            /*ClassDefinition cd = dl.getRIMClassDef(args[0]);
            CMPClassGenerator gen = new CMPClassGenerator();
            System.out.println(gen.makeRemoteCode(cd));
            System.out.println(gen.makeHomeCode(cd));
            System.out.println(gen.makeBeanCode(cd));
            */
            
            DataTypeDefinition def = dl.getDataTypeDef(args[0]);
            DataTypeGenerator gen = new DataTypeGenerator();
            System.out.println(gen.makeDataType(def));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
