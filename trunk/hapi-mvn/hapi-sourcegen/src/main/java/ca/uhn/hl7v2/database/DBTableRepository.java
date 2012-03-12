/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DBTableRepository.java".  Description: 
"Implements TableRepository by looking up values from the default HL7
  normative database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import ca.uhn.hl7v2.LookupException;
import ca.uhn.hl7v2.UndefinedTableException;
import ca.uhn.hl7v2.UnknownValueException;

/**
 * <p>
 * Implements TableRepository by looking up values from the default HL7
 * normative database.  Values are cached after they are looked up once. 
 * </p>
 * <p>
 * This can be used to provide vaidation of message coded values
 * agaist the official HL7 Database, although you will need 
 * a copy in order to use this.
 * </p>
 *  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @deprecated This has not been used in a long time. Please let us know if you are stil
 * using it, otherwise it will be removed in a future release.
 */
@SuppressWarnings("deprecation")
public class DBTableRepository extends TableRepository {

    private int[] tableList;
    private HashMap<Integer, String[]> tables;
    private final int bufferSize = 3000; //max # of tables or values that can be cached at a time
    private NormativeDatabase normativeDatabase;

    protected DBTableRepository(String jdbcUrl) throws SQLException {
        tableList = null;
        tables = new HashMap<Integer, String[]>();
        normativeDatabase = NormativeDatabase.getInstance();
    }

    /**
     * Returns a list of HL7 lookup tables that are defined in the normative database.  
     */
    public int[] getTables() throws LookupException {
        if (this.tableList == null) {
            try {
                Connection conn = normativeDatabase.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select distinct table_id from TableValues");
                int[] roomyList = new int[bufferSize];
                int c = 0;
                while (rs.next()) {
                    roomyList[c++] = rs.getInt(1);
                }
                stmt.close();
                normativeDatabase.returnConnection(conn);

                this.tableList = new int[c];
                System.arraycopy(roomyList, 0, this.tableList, 0, c);
            }
            catch (SQLException sqle) {
                throw new LookupException("Can't get table list from database: " + sqle.getMessage());
            }
        }
        return this.tableList;
    }

    /**
     * Returns true if the given value exists in the given table.
     */
    public boolean checkValue(int table, String value) throws UndefinedTableException, LookupException {
        boolean exists = false;

        String[] values = this.getValues(table);

        int c = 0;
        while (c < values.length && !exists) {
            if (value.equals(values[c++]))
                exists = true;
        }

        return exists;
    }

    /**
     * Returns a list of the values for the given table in the normative database. 
     */
	public String[] getValues(int table) throws LookupException, UndefinedTableException {
        Integer key = new Integer(table);
        String[] values = null;

        //see if the value list exists in the cache
        Object o = this.tables.get(key);

        if (o != null) {
            values = (String[]) o;
        }
        else {
            //not cached yet ...
            int c;
            String[] roomyValues = new String[bufferSize];

            try {
                Connection conn = normativeDatabase.getConnection();
                Statement stmt = conn.createStatement();
                StringBuffer sql = new StringBuffer("select table_value from TableValues where table_id = ");
                sql.append(table);
                ResultSet rs = stmt.executeQuery(sql.toString());

                c = 0;
                while (rs.next()) {
                    roomyValues[c++] = rs.getString(1);
                }

                stmt.close();
                normativeDatabase.returnConnection(conn);
            }
            catch (SQLException sqle) {
                throw new LookupException("Couldn't look up values for table " + table + ": " + sqle.getMessage());
            }

            if (c == 0)
                throw new UndefinedTableException("No values found for table " + table);

            values = new String[c];
            System.arraycopy(roomyValues, 0, values, 0, c);

            tables.put(key, values);
        }

        return values;
    }

    /**
     * Returns the description matching the table and value given.  As currently implemented
     * this method performs a database call each time - caching should probably be added,
     * although this method will probably not be used very often.   
     */
    public String getDescription(int table, String value) throws LookupException, UnknownValueException {
        String description = null;

        StringBuffer sql = new StringBuffer("select Description from TableValues where table_id = ");
        sql.append(table);
        sql.append(" and table_value = '");
        sql.append(value);
        sql.append("'");

        try {
            Connection conn = normativeDatabase.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());
            if (rs.next()) {
                description = rs.getString(1);
            }
            else {
                throw new UnknownValueException(
                    "The value " + value + " could not be found in the table " + table + " - SQL: " + sql.toString());
            }
            stmt.close();
            normativeDatabase.returnConnection(conn);
        }
        catch (SQLException e) {
            throw new LookupException( "Can't find value " + value + " in table " + table, e );
        }

        return description;
    }

    //test 
    /*
    public static void main(String args[]) {
        try {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          System.setProperty("ca.on.uhn.hl7.database.url", "jdbc:odbc:hl7");
            
          DBTableRepository rep = new DBTableRepository();
          
          int[] tables = rep.getTables();
          for (int i = 0; i < tables.length; i++) {
              //System.out.println("Table " + i + ": " + tables[i]);
          }
    
          for (int c = 0; c < 10; c++) {
              int table = 1;
              String val = "M";
              long before = System.currentTimeMillis();
              boolean yep = rep.checkValue(table, val);
              long after = System.currentTimeMillis();
              System.out.println(val + " exists in table " + table + "? " + yep + " - checking took " + (after-before) + " ms");
              
          }
          
          for (int h = 0; h < 2; h++) {
              int table = 1;
              long before = System.currentTimeMillis();
              String[] vals = rep.getValues(table);
              long after = System.currentTimeMillis();
              for (int i = 0; i < vals.length; i++) {
                  System.out.println("Value " + i + ": " + vals[i] + ": " + rep.getDescription(table, vals[i]));
              }
              
              System.out.println("That took " + (after-before) + " ms");
          }
          
          
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        } catch (LookupException le) {
            le.printStackTrace();
        } catch (UnknownValueException uve) {
            uve.printStackTrace();
        }
    }*/

}