/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonISTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.tests.CommonIS"
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

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.junit.Assert.*;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import junit.framework.TestCase;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.primitive.IS;
import ca.uhn.hl7v2.model.v24.datatype.tests.IDTest;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.tests.CommonIS
 *
 * No TableRepository used yet
 * 
 * @author Leslie Mann
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class CommonISTest {
	
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(CommonISTest.class);
    
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
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    }
    
    	private int table;
	private String value;
	private IS commonIS;
	


	@Before
	public void BeforeTheTest() throws Exception {
	    table = 2;
	    commonIS = new IS(new GenericMessage.V25(new DefaultModelClassFactory()), table) {
                public String getVersion() {
                    return "2.5";
                }
            };
		value = "CodedValue";
	}


	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */

	/**
	 * Test default constructor 
	 */
	@Test
	public void testConstructor() {
		assertNotNull("Should have a CommonIS object", commonIS);
	}

	 /**
	  * Test for table and value constructor
	  */
//	 public void testConstructorString() throws DataTypeException {
//		commonIS = new CommonIS(table, value);
//	 	assertNotNull("Should have a valid CommonIS object", commonIS);
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
				IS is = new ca.uhn.hl7v2.model.v25.datatype.IS(message, 0);
				try {
                    is.setTable(table);
					is.setValue(value);
					String retval = is.getValue();
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
			new TestSpec(2, "ISString", "ISString"),
			//new TestSpec(-1, "ISString", DataTypeException.class),
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
			IS commonIS;
			Exception exception = null;

			TestSpec(String value, Object outcome) throws DataTypeException {
				this.value = value;
				this.outcome = outcome;
                Message message = new GenericMessage.V25(new DefaultModelClassFactory());
                message.setValidationContext(new DefaultValidation());
				this.commonIS = new ca.uhn.hl7v2.model.v25.datatype.IS(message, 1);
                this.commonIS.setValue("IS");
			}

			public String toString() {
				return "[ " + value + " : "
					+ (outcome != null ? outcome : "null")
					+ (exception != null ? " [ " + exception.toString() + " ]"	: " ]");
			}

			public boolean executeTest() {
				try {
					commonIS.setValue(value);
					String retval = commonIS.getValue();
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
            new TestSpec("ISString", "ISString"),
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
		commonIS = new IS(new GenericMessage.V25(new DefaultModelClassFactory()), table) {
                public String getVersion() {
                    return "2.5";
                }
        };
        	commonIS.setValue(value);
			assertEquals("Should get code value back.", value, commonIS.getValue());
	}
	
	/**
	 * Testing ability to return the number of the HL7 code table
	 */
	@Test
	public void testGetTable() throws DataTypeException {
        commonIS = new IS(new GenericMessage.V25(new DefaultModelClassFactory()), table) {
                public String getVersion() {
                    return "2.5";
                }
            };
            commonIS.setValue(value);
    		assertEquals("Should get table number back.", table, commonIS.getTable());
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
