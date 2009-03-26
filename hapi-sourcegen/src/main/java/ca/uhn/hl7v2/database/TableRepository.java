/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "TableRepository.java".  Description: 
"A place where table keys and values are stored" 

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

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ca.uhn.hl7v2.LookupException;
import ca.uhn.hl7v2.UndefinedTableException;
import ca.uhn.hl7v2.UnknownValueException;

/**
 * A place where table keys and values are stored.  This may be implemented
 * with a database, an LDAP directory, local RAM, etc.  At a minimum, any
 * underlying repository must supply the values for standard HL7 tables.
 * Site-defined tables may also be supported.
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class TableRepository {

  private static Map reps = new HashMap();

  /**
   * Returns a TableRepository object.
   */
  public static TableRepository getInstance(String jdbcUrl) throws SQLException {
      if (reps.containsKey(jdbcUrl) == false) {
          reps.put(jdbcUrl, new DBTableRepository(jdbcUrl));
      }
      
    return (TableRepository)reps.get(jdbcUrl);
  }

  /**
   * Returns a list of HL7 tables.  
   */  
  public abstract int[] getTables() throws LookupException;
  
  /**
   * Returns true if the given value exists in the given table.
   */
  public abstract boolean checkValue(int table, String value) throws UndefinedTableException, LookupException;
 
  /**
   * Returns a list of the values in the given table. 
   */ 
  public abstract String[] getValues(int table) throws LookupException, UndefinedTableException;
  
  /**
   * Returns the value corresponding to the given table and key.
   * @throws UnknownValueException if the value can not be found.  This may be an UnknownTableException.  
   */
  public abstract String getDescription(int table, String value) throws LookupException, UnknownValueException;
  
  //test
  /*
  public static void main(String[] args) {
      
      if (args.length != 2) {
          System.out.println("Usage: TableRepository table value");
          System.exit(1);
      }
      int table = Integer.parseInt(args[0]);
      String value = args[1];
      
      try {
        //needed by normative DB ... 
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        System.setProperty("ca.on.uhn.hl7.database.url", "jdbc:odbc:hl7");
        System.out.println("Description: " + TableRepository.getInstance().getDescription(table, value));
      } catch (UnknownValueException e) {
          e.printStackTrace();
          Log.tryToLog(e, "");
      } catch (ClassNotFoundException cne) {
          cne.printStackTrace();
      }
  }*/
  
} 