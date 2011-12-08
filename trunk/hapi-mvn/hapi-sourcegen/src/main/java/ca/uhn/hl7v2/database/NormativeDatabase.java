/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "NormativeDatabase.java".  Description: 
"Point of access to a copy of the HL7 normative database" 

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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Point of access to a copy of the HL7 normative database. A typical way of obtaining and using a
 * database connection would be ...
 * </p>
 * <p>
 * <code>Connection c = NormativeDatabase.getInstance().getConnection();<br>
 * // ... use the database ... <br>
 * NormativeDatabase.returnConnection(c);</code>
 * </p>
 * <p>
 * Since the database may be installed differently on different systems, certain system properties
 * must be set with the required connection information, as follows:
 * </p>
 * <p>
 * <code>ca.on.uhn.hl7.database.user</code> - the user ID needed to connect (if required)<br>
 * <code>ca.on.uhn.hl7.database.passsword</code> - the password associated with the above user (if
 * required)
 * </p>
 * <p>
 * The required JDBC driver must also be loaded (this can be done by ensuring that the required
 * driver appears in the classpath and appending the class name to the "jdbc.drivers" system
 * property.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public class NormativeDatabase
{
	/** User system property constant */
    public static final String PROP_DATABASE_USER = "ca.on.uhn.hl7.database.user";
	/** User system property constant */
    public static final String PROP_DATABASE_URL = "ca.on.uhn.hl7.database.url";
	/** User system property constant */
    public static final String PROP_DATABASE_PASSWORD = "ca.on.uhn.hl7.database.password";

	private static final Logger log = LoggerFactory.getLogger(NormativeDatabase.class);

    private static final NormativeDatabase INSTANCE = new NormativeDatabase();

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private Connection connection;
	private SQLException checkedOut;


    /**
     * Private constructor
     */
    private NormativeDatabase() {
    	// nothing
    }


    /**
     * Returns the singleton instance of NormativeDatabase.
     */
    public static NormativeDatabase getInstance() throws SQLException {
    	return INSTANCE;
    }


    /**
     * Provides a Connection to the normative database. A new connection may be created if none are
     * available.
     */
    public synchronized Connection getConnection() throws SQLException {
    	if (checkedOut != null) {
    		throw checkedOut;
    	}

		String user = System.getProperty(PROP_DATABASE_USER);
		String pass = System.getProperty(PROP_DATABASE_PASSWORD);
		String url = System.getProperty(PROP_DATABASE_URL);

		if (!url.equals(dbUrl) || !pass.equals(dbPassword) || !user.equals(dbUser)) {
			if (connection != null) {
				connection.close();
			}
			connection = DriverManager.getConnection(url, user, pass);
			dbUrl = url;
			dbPassword = pass;
			dbUser = user;
		}
		
		checkedOut = new SQLException("COnnection already checked out");
		return connection;
    }


    /**
     * Used to return an HL7 normative database connection to the connection pool. If the given
     * connection is not in fact a connection to the normative database, it is discarded.
     */
    public void returnConnection(Connection conn) {
    	checkedOut = null;
    }


    // test
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = NormativeDatabase.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from TableValues");
            while (rs.next()) {
                Object tabNum = rs.getObject(1);
                Object val = rs.getObject(3);
                Object desc = rs.getObject(4);
                System.out.println("Table: " + tabNum + " Value: " + val + " Description: " + desc);
            }
        } catch (SQLException e) {
            log.error("test msg!!", e);
        } catch (ClassNotFoundException e) {
            log.error("test msg!!", e);
        }
    }

}