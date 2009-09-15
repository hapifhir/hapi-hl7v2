/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonTMTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.tests.CommonTM
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.primitive.CommonDT;
import ca.uhn.hl7v2.model.primitive.CommonTM;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.tests.CommonTM
 * 
 * Problems:
 * setOffset - does not check for minimum length
 * setOffset - how do you get an integer like 0024
 * after setHour, etc unable to get the value out
 *
 * @author Leslie Mann
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class CommonTMTest {
	
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(CommonTMTest.class);
    
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
    
    	final String baseTime = "154638";
	final String baseTimePrecision = baseTime + ".4321";
	final String baseTimePrecisionOffset = baseTimePrecision + "-2345";
	private CommonTM commonTM;

	@Before
	public void BeforeTheTest() {
		commonTM = new CommonTM();
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
		assertNotNull("Should have a valid CommonTM object", commonTM);
	}

	/**
	 * Test for string constructor
	 */
	@Test
	public void testStringConstructor() throws DataTypeException {
		commonTM = new CommonTM(baseTime);
		assertNotNull("Should have a valid CommonTM object", commonTM);
	}
    
    /**
     * Testing string constructor with delete value "". 
     */
	@Test
    public void testStringConstructor2() throws DataTypeException {
        commonTM = new CommonTM("\"\"");
        assertNotNull("Should have a valid CommonTM object", commonTM);
        assertEquals("Should have a value of \"\" ", "\"\"", commonTM.getValue());
    }

	/**
	 * Test set/get value with various time strings
	 */
	@Test
	public void testSetGetValue() {
		class TestSpec {
			String time;
			Object outcome;
                        String retval;
			Exception exception = null;
			
			TestSpec(String time, Object outcome) {
				this.time = time;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + (time != null ? time : "null") + " : "
					+ (outcome != null ? outcome : "null") + " : "
					+ (retval != null ? retval : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonTM tm = new CommonTM();
				try {
					tm.setValue(time);
					retval = tm.getValue();
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
		}//inner class
    		
		TestSpec [] tests = {
			new TestSpec(null, null),
			new TestSpec("\"\"", "\"\""), 
			new TestSpec("0", DataTypeException.class),
			new TestSpec("08", "08"), //note: default time zone has been removed in case parser in different zone than sender
			new TestSpec("080", DataTypeException.class),
			new TestSpec("0800", "0800"),
			new TestSpec("08000", DataTypeException.class),
			new TestSpec("080005", "080005"),
			new TestSpec("0800051", DataTypeException.class),
			new TestSpec("080005.1", "080005.1"),
			new TestSpec("080005.14", "080005.14"),
			new TestSpec("080005.147", "080005.147"),
			new TestSpec("080005.1479", "080005.1479"),
			new TestSpec("080005.14793", DataTypeException.class),
			new TestSpec("0+0600", DataTypeException.class),
			new TestSpec("08-0100", "08-0100"),
			new TestSpec("080-0500", DataTypeException.class),
			new TestSpec("0800-0500", "0800-0500"),
			new TestSpec("080005-1300", "080005-1300"),
			new TestSpec("0800051", DataTypeException.class),
			new TestSpec("080005.1+0100", "080005.1+0100"),
			new TestSpec("080005.14+1000", "080005.14+1000"),
			new TestSpec("080005.147-1200", "080005.147-1200"),
			new TestSpec("080005.1479+0340", "080005.1479+0340"),
			new TestSpec("080005.1479+0330", "080005.1479+0330"),
			new TestSpec("080005.1479+1234", "080005.1479+1234")
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	@Test
	public void testSetHourPrecision() {
		class TestSpec {
			int hour;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int hour, Object outcome) {
				this.hour = hour;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(hour) + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonTM tm = new CommonTM();
				try {
					tm.setHourPrecision(hour);
					String retval = tm.getValue();
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
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(-1, DataTypeException.class),
			new TestSpec(0, "00"),
			new TestSpec(8, "08"),
			new TestSpec(13, "13"),
			new TestSpec(23, "23"),
			new TestSpec(24, DataTypeException.class)
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	@Test
	public void testSetHourMinutePrecision() {
		class TestSpec {
			int hour;
			int minute;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int hour, int minute, Object outcome) {
				this.hour = hour;
				this.minute = minute;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(hour) + " " + Integer.toString(minute) + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonTM tm = new CommonTM();
				try {
					tm.setHourMinutePrecision(hour, minute);
					String retval = tm.getValue();
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
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(-1,0, DataTypeException.class),
			new TestSpec(0, -1, DataTypeException.class),
			new TestSpec(0, 0, "0000"),
			new TestSpec(0, 30, "0030"),
			new TestSpec(0, 59, "0059"),
			new TestSpec(0, 60, DataTypeException.class),
			new TestSpec(8, 15, "0815"),
			new TestSpec(13, 27, "1327"),
			new TestSpec(24, 59, DataTypeException.class)
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	@Test
	public void testSetHourMinSecondPrecision() {
		class TestSpec {
			int hour;
			int minute;
			int second;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int hour, int minute, int second, Object outcome) {
				this.hour = hour;
				this.minute = minute;
				this.second = second;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(hour) + " " + Integer.toString(minute) 
					+ " " + Integer.toString(minute) + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonTM tm = new CommonTM();
				try {
					tm.setHourMinSecondPrecision(hour, minute, second);
					String retval = tm.getValue();
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
		}//inner class
    	
		TestSpec [] tests = {
			new TestSpec(-1, 0, 0, DataTypeException.class),
			new TestSpec(0, -1, 0, DataTypeException.class),
			new TestSpec(0, 0, -1, DataTypeException.class),
			new TestSpec(0, 0, 0, "000000"),
			new TestSpec(1, 1, 1, "010101"),
			new TestSpec(0, 30, 47, "003047"),
			new TestSpec(8, 15, 59, "081559"),
			new TestSpec(8, 15, 60, DataTypeException.class),
			new TestSpec(13, 27, 0, "132700"),
			new TestSpec(23, 59, 59, "235959"),
			new TestSpec(24, 59, 59, DataTypeException.class),
			new TestSpec(23, 60, 59, DataTypeException.class),
			new TestSpec(23, 59, 60, DataTypeException.class),
			new TestSpec(24, 60, 60, DataTypeException.class)
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Test set/getOffset.  Testspec constructor sets up a value
	 * of "154638" so we can get a value back
	 */
	@Test
	public void testSetGetOffset() {
		
		class TestSpec {
			int offset;
			Object outcome;
                        String retval;
			Exception exception = null;
			
			TestSpec(int offset, Object outcome) {
				this.offset = offset;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(offset) + " : "
					+ (outcome != null ? outcome : "null") + " : "
					+ (retval != null ? retval : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				try {
					CommonTM tm = new CommonTM(baseTime);
					tm.setOffset(offset);
					retval = tm.getValue();
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
		}//inner class
    		
		TestSpec [] tests = {
			new TestSpec(-0000, baseTime + "+0000"),
			new TestSpec(-24, baseTime + "-0024"),  
			new TestSpec(-1160, DataTypeException.class),
			new TestSpec(-1159, baseTime + "-1159"),
			new TestSpec(800, baseTime + "+0800"),
			new TestSpec(1300, baseTime + "+1300"),
			new TestSpec(2400, DataTypeException.class),
			new TestSpec(2300, baseTime + "+2300"),
			new TestSpec(2106, baseTime + "+2106"),
			new TestSpec(21064, DataTypeException.class)
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	@Test
	public void testGetHour() throws DataTypeException {
		commonTM = new CommonTM(baseTime);
		int hour = commonTM.getHour();
		assertEquals("Should get hour back", Integer.parseInt(baseTime.substring(0,2)), hour);
	}

	@Test
	public void testGetMinute() throws DataTypeException {
		commonTM = new CommonTM(baseTime);
		int minute = commonTM.getMinute();
		assertEquals("Should get minute back", Integer.parseInt(baseTime.substring(2,4)), minute);
	}

	@Test
	public void testGetSecond() throws DataTypeException {
		commonTM = new CommonTM(baseTime);
		int second = commonTM.getSecond();
		assertEquals("Should get second back", Integer.parseInt(baseTime.substring(4,6)), second);
	}

	@Test
	public void testGetFractSecond() throws DataTypeException {
		float delta = .0001f;
		commonTM = new CommonTM(baseTimePrecision);
		float fractSecond = commonTM.getFractSecond();
		assertEquals("Should get fractional second back", Float.parseFloat(baseTimePrecision.substring(6,11)),
			fractSecond, delta);
	}

	@Test
	public void testGetGMTOffset() throws DataTypeException {
		commonTM = new CommonTM(baseTimePrecisionOffset);
		int offset = commonTM.getGMTOffset();
		assertEquals("Should get GMT offset back", Integer.parseInt(baseTimePrecisionOffset.substring(11,16)),
			offset);
	}

	@Test
	public void testToHl7TMFormat() throws DataTypeException, ParseException {
        //new tests related to bug 1173074 ...
        //case 1: Paris time, date in winter 
        java.util.Date date = new SimpleDateFormat("yyyyMMddHHmmssZ").parse("19950305000000+0000");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        assertEquals("19950305010000+0100", CommonDT.toHl7DTFormat(cal) + CommonTM.toHl7TMFormat(cal));

        //case 2: Paris time, date in summer 
        date = new SimpleDateFormat("yyyyMMddHHmmssZ").parse("19950805000000+0000");
        cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        assertEquals("19950805020000+0200", CommonDT.toHl7DTFormat(cal) + CommonTM.toHl7TMFormat(cal));

        //case 3: New York time, date in winter 
        date = new SimpleDateFormat("yyyyMMddHHmmssZ").parse("19950305000000+0000");
        cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        cal.setTime(date);
        assertEquals("19950304190000-0500", CommonDT.toHl7DTFormat(cal) + CommonTM.toHl7TMFormat(cal));

        //case 4: New York time, date in summer 
        date = new SimpleDateFormat("yyyyMMddHHmmssZ").parse("19950805000000+0000");
        cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        cal.setTime(date);
        assertEquals("19950804200000-0400", CommonDT.toHl7DTFormat(cal) + CommonTM.toHl7TMFormat(cal));        
	}
}
