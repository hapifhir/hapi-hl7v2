/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonIDTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.tests.CommonID"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  “GPL”), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.model.primitive.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.vmOption;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.primitive.ID;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.tests.CommonID
 * 
 * No TableRepository used yet
 *
 * @author Leslie Mann
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class CommonIDTest {
	
        // you get that because you "installed" a log profile in configuration.
        public Log logger = LogFactory.getLog(CommonIDTest.class);
        
        @Inject
        BundleContext bundleContext;
        
        @Configuration
        public static Option[] configure() {
    	return options(frameworks(equinox(), felix(), knopflerfish())
    		, logProfile()
    		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
    		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
    		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
    		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//    		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )
    
    
    	);
        }
    
    	private int table;
	private String value;
	private ID commonID;


	public void BeforeTheTest() throws Exception {
		table = 5;
		value = "test";
		commonID = new ID(new GenericMessage.V25(new DefaultModelClassFactory()), table) {
                    /**
		     * 
		     */
		    private static final long serialVersionUID = 1L;

		    public String getVersion() {
                        return "2.5";
                    }
		};
	}


	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */
	 
	 /**
	  * Test for default constructor
	  */
	@Test
	 public void testConstructor() {
	 	assertNotNull("Should have a valid CommonID object", commonID);
	 }

	 /**
	  * Test for table and value constructor
	  */
//	 public void testConstructorString() throws DataTypeException {
//		commonID = new CommonID(table, value);
//	 	assertNotNull("Should have a valid CommonID object", commonID);
//	 }

	/**
	 * Test for void set/getValue(int, String)
	 */
	@Test
	public void testSetGetValueStringAndTable() throws DataTypeException {
		class TestSpec {
			String value;
			int table;
			Object outcome;
			Exception exception = null;

			TestSpec(int table, String value, Object outcome) {
				this.value = value;
				this.table = table;
				this.outcome = outcome;
			}

			public String toString() {
				return "[ " + table + " " + value + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]"	: " ]");
			}

			public boolean executeTest() {
                Message message = new GenericMessage.V25(new DefaultModelClassFactory());
                message.setValidationContext(new DefaultValidation());
				ID id = new ca.uhn.hl7v2.model.v25.datatype.ID(message, table);
				try {
                    id.setTable(table);
					id.setValue(value);
					String retval = id.getValue();
					if (retval != null) {
						return retval.equals(outcome);
					} else {
						return outcome == null;
					}
				} catch (Exception e) {
					if (e.getClass().equals(outcome)) {
						return true;
					} else {
						this.exception = e;
						return (e.getClass().equals(outcome));
					}
				}
			}
		} //inner class

		TestSpec[] tests = {
			new TestSpec(2, null, null),
			new TestSpec(2, "", ""),
            new TestSpec(-1,"\"\"", "\"\""),
            new TestSpec(0,"\"\"", "\"\""),
			new TestSpec(2, "IDString", "IDString"),
			new TestSpec(2, getString(200, 'a'), getString(200, 'a')),
			new TestSpec(2, getString(201, 'a'), DataTypeException.class),
		};


		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length; i++) {
			if (!tests[i].executeTest())
				failedTests.add(tests[i]);
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size());
	}

	/**
	 * Test for void set/getValue(String)
	 * table set
	 */
	@Test
	public void testSetGetValueString() throws DataTypeException {
		class TestSpec {
			String value;
			Object outcome;
			ID commonID;
			Exception exception = null;

			TestSpec(String value, Object outcome) throws DataTypeException {
				this.value = value;
				this.outcome = outcome;
                Message message = new GenericMessage.V25(new DefaultModelClassFactory());
                message.setValidationContext(new DefaultValidation());
				this.commonID = new ca.uhn.hl7v2.model.v25.datatype.ID(message, 1);
                this.commonID.setValue("ID");
			}

			public String toString() {
				return "[ " + value + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]"	: " ]");
			}

			public boolean executeTest() {
				try {
					commonID.setValue(value);
					String retval = commonID.getValue();
					if (retval != null) {
						return retval.equals(outcome);
					} else {
						return outcome == null;
					}
				} catch (Exception e) {
					if (e.getClass().equals(outcome)) {
						return true;
					} else {
						this.exception = e;
						return (e.getClass().equals(outcome));
					}
				}
			}
		} //inner class

		TestSpec[] tests = {
			new TestSpec(null, null),
			new TestSpec("", ""),
            new TestSpec("\"\"", "\"\""),
			new TestSpec("IDString", "IDString"),
			new TestSpec(getString(200, 'a'), getString(200, 'a')),
			new TestSpec(getString(201, 'a'), DataTypeException.class),
		};

		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length; i++) {
			if (!tests[i].executeTest())
				failedTests.add(tests[i]);
		}

		assertEquals("Failures: " + failedTests, 0, failedTests.size());
	}

	/**
	 * Testing ability to return the code value
	 */
	@Test
	public void testGetValue() throws DataTypeException {
		commonID = new ID(new GenericMessage.V25(new DefaultModelClassFactory()), table) {
            public String getVersion() {
                return "2.5";
            }
        };
        commonID.setValue(value);
		assertEquals("Should get code value back.", value, commonID.getValue());
	}
	
	/**
	 * Testing ability to return the number of the HL7 code table
	 */
	@Test
	public void testGetTable() throws DataTypeException {
		commonID = new ID(new GenericMessage.V25(new DefaultModelClassFactory()), table) {
                    public String getVersion() {
                        return "2.5";
                    }
                };
                commonID.setValue(value);
		assertEquals("Should get table number back.", table, commonID.getTable());
	}

	/*
	 * Returns a string of character c repeated length times
	 */
	private String getString(int length, char c) {
		StringBuffer buf = new StringBuffer(length);
		
		for (int i=0;i<length;i++) {
			buf.append(c);
		}
		int l = buf.length();
		return buf.toString();
	}
}
