/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonDTTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.CommonDT"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  ï¿½GPLï¿½), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.model.primitive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v26.message.RDE_O11;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.CommonDT
 * 
 * @author Leslie Mann
 */

public class CommonDTTest extends TestCase {
    private int year;
    private int month;
    private int day;
	private String dateString;
	private CommonDT commonDT;

	/**
	 * Constructor for CommonDTTest.
	 * @param testName
	 */
	public CommonDTTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(CommonDTTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		year = 2002;
		month = 2;
		day = 24;
		dateString = "20020224";
		commonDT = new CommonDT();
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		commonDT = null;
	}

	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */
	 
	/**
	 * Testing default constructor
	 */
	public void testConstructor() {
		assertNotNull("Should have a valid CommonDT object", commonDT);
	}

	/**
	 * Testing string constructor with a HL7 date string.
	 */
	public void testStringConstructor() throws DataTypeException {
		commonDT = new CommonDT(dateString);
		assertNotNull("Should have a valid CommonDT object", commonDT);
	}
    
    /**
     * Testing string constructor with delete value "". 
     */
    public void testStringConstructor2() throws DataTypeException {
        commonDT = new CommonDT("\"\"");
        assertNotNull("Should have a valid CommonDT object", commonDT);
    }

	/**
	 * Testing set/getValue() with various date strings
	 */
	public void testSetGetValue() throws DataTypeException {
		class TestSpec {
			String dateString;
			Object outcome;
			Exception exception = null;
			
			TestSpec(String dateString, Object outcome) {
				this.dateString = dateString;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + dateString + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonDT dt = new CommonDT();
				try {
					dt.setValue(dateString);
					String retval = dt.getValue();
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
			new TestSpec("", ""),
            new TestSpec("\"\"", "\"\""),
			new TestSpec(" ", DataTypeException.class),
			new TestSpec("2", DataTypeException.class),
			new TestSpec("20", DataTypeException.class),
			new TestSpec("200", DataTypeException.class),
			new TestSpec("999", DataTypeException.class),
			//year
			new TestSpec("1000", "1000"),
			new TestSpec("1987", "1987"),
			new TestSpec("2002", "2002"),
			new TestSpec("9999", "9999"),
			new TestSpec("10000", DataTypeException.class),
			//month
			new TestSpec("20021", DataTypeException.class),
			new TestSpec("200200", DataTypeException.class),
			new TestSpec("200201", "200201"),
			new TestSpec("200207", "200207"),
			new TestSpec("200211", "200211"),
			new TestSpec("200212", "200212"),
			new TestSpec("200213", DataTypeException.class),
			//day
			new TestSpec("2002010", DataTypeException.class),
			new TestSpec("20020100", DataTypeException.class),
			new TestSpec("20020101", "20020101"),
			new TestSpec("20020107", "20020107"),
			new TestSpec("20020121", "20020121"),
			new TestSpec("20020131", "20020131"),
			new TestSpec("20020132", DataTypeException.class),
		};
		
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	
	public void testNativeJavaAccessorsAndMutators() throws DataTypeException, ParseException {
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:ss");
        Date date = format.parse("20100609 12:40");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    
	    commonDT = new CommonDT();
	    commonDT.setValue(cal);
	    assertEquals("20100609", commonDT.getValue());

        commonDT = new CommonDT();
        commonDT.setValue(date);
        assertEquals("20100609", commonDT.getValue());
	    
        commonDT = new CommonDT();
        commonDT.setValue("20100609");
        assertEquals("20100609 00:00", format.format(commonDT.getValueAsDate()));
        
        commonDT = new CommonDT();
        commonDT.setValue("20100609");
        assertEquals("20100609 00:00", format.format(commonDT.getValueAsCalendar().getTime()));
        
	}
	
	
	/**
	 * Testing setYearPrecision() with various year values
	 */
	public void testSetYearPrecision() throws DataTypeException {
		class TestSpec {
			int year;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int year, Object outcome) {
				this.year = year;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(year) + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonDT dt = new CommonDT();
				try {
					dt.setYearPrecision(year);
					String retval = dt.getValue();
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
			new TestSpec(-2000, DataTypeException.class),
			new TestSpec(9, DataTypeException.class),
			new TestSpec(99, DataTypeException.class),
			new TestSpec(999, DataTypeException.class),
			new TestSpec(1000, "1000"),
			new TestSpec(1987, "1987"),
			new TestSpec(2001, "2001"),
			new TestSpec(9999, "9999"),
			new TestSpec(10000, DataTypeException.class),
		};
		
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Testing setYearMonthPrecision() with various year, month values
	 */
	public void testSetYearMonthPrecision() throws DataTypeException {
		class TestSpec {
			int year;
			int month;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int year, int month, Object outcome) {
				this.year = year;
				this.month = month;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(year) + " " + Integer.toString(month) + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonDT dt = new CommonDT();
				try {
					dt.setYearMonthPrecision(year, month);
					String retval = dt.getValue();
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
			new TestSpec(2001, -1, DataTypeException.class),
			new TestSpec(9, 1, DataTypeException.class),
			new TestSpec(99, 1, DataTypeException.class),
			new TestSpec(999, 1, DataTypeException.class),
			new TestSpec(2001, 0, DataTypeException.class),
			new TestSpec(2001, 1, "200101"),
			new TestSpec(1000, 1, "100001"),
			new TestSpec(1987, 1, "198701"),
			new TestSpec(2001, 1, "200101"),
			new TestSpec(2001, 7, "200107"),
			new TestSpec(2001, 12, "200112"),
			new TestSpec(2001, 13, DataTypeException.class),
			new TestSpec(9999, 1, "999901"),
			new TestSpec(10000, 1, DataTypeException.class),
		};
		
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Testing setYearMonthDayPrecision() with various year, month, day values
	 */
	public void testSetYearMonthDayPrecision() throws DataTypeException {
		class TestSpec {
			int year;
			int month;
			int day;
			Object outcome;
			Exception exception = null;
			
			TestSpec(int year, int month, int day, Object outcome) {
				this.year = year;
				this.month = month;
				this.day = day;
				this.outcome = outcome;
			}
			
			public String toString() {
				return "[ " + Integer.toString(year) + " " + Integer.toString(month) + " : "
					+ Integer.toString(day) + " : "
					+ (outcome != null ? outcome : "null")
 			    	+ (exception != null ? " [ " + exception.toString() + " ]":" ]");
			}
			
			public boolean executeTest() {
				CommonDT dt = new CommonDT();
				try {
					dt.setYearMonthDayPrecision(year, month, day);
					String retval = dt.getValue();
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
			new TestSpec(2001, 1, -1, DataTypeException.class),
			new TestSpec(9, 1, 1, DataTypeException.class),
			new TestSpec(99, 1, 1, DataTypeException.class),
			new TestSpec(999, 1, 1, DataTypeException.class),
			new TestSpec(2001, 1, 0, DataTypeException.class),
			new TestSpec(2001, 1, 1, "20010101"),
			new TestSpec(1000, 1, 1, "10000101"),
			new TestSpec(1987, 1, 1, "19870101"),
			new TestSpec(2001, 1, 1, "20010101"),
			new TestSpec(2001, 1, 7, "20010107"),
			new TestSpec(2001, 1, 12, "20010112"),
			new TestSpec(2001, 1, 25, "20010125"),
			new TestSpec(2001, 1, 31, "20010131"),
			new TestSpec(2001, 1, 32, DataTypeException.class),
			new TestSpec(9999, 1, 1, "99990101"),
			new TestSpec(10000, 1, 1, DataTypeException.class),
			new TestSpec(2001, 1, 1, "20010101"),
			new TestSpec(2001, -1, 21, DataTypeException.class),
		};
		
		ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Testing toHl7DTFormat() with a calendar
	 */
	public void testConvertCalToHL7DateFormat() throws DataTypeException {
		GregorianCalendar cal = new GregorianCalendar();
        cal.clear();
        cal.setLenient(false);
		cal.set(2002,5,24);
		String convertedDate = CommonDT.toHl7DTFormat(cal);
		assertEquals("20020624", convertedDate);
	}

	/**
	 * Testing ability to retrieve year value
	 */
    public void testGetYear() throws DataTypeException {
		commonDT = new CommonDT(dateString);
		assertEquals("Should get year back", year, commonDT.getYear());
    }
    
	/**
	 * Testing ability to retrieve month value
	 */
    public void testGetMonth() throws DataTypeException {
		commonDT = new CommonDT(dateString);
		assertEquals("Should get month back", month, commonDT.getMonth());
    }
    
	/**
	 * Testing ability to retrieve day value
	 */
    public void testGetDay() throws DataTypeException {
		commonDT = new CommonDT(dateString);
		assertEquals("Should get day back", day, commonDT.getDay());
    }
    
    public void testGetDTAsDate() throws EncodingNotSupportedException, HL7Exception {
    	
    	String msgS = "MSH|^~\\&|IHE|EU-CAT2011|||20110307194153||RDE^O11|MSG00003|P|2.6||||||UTF-8\r" + 
    			"PID|||A9283923889^^^^||Doe^John||19680306|M\r" + 
    			"PV1||I|Cardiology^4^01^CATEUR_WARDS&&L||||||||||||||||V00001\r" + 
    			"IN1|s|ID001^Full Insurance|XXXX|INSURANCE_Ltd.\r" + 
    			"ORC|NW|PL001||P001|||||20110414153220|||00000999^Strangelove^Peter^^^Dr.|||||||P0343874^Jansen^Patricia||Connectathon Europe 2011^^^^^^^^^CATEUR2011|Casa della Cittˆ Leopolda, Piazza Guerrazzi, 56125 Pisa|0039 50 48587||P3;V3\r" + 
    			"TQ1|1|2^Tab&Tablets&99FCS|TID\r" + 
    			"RXO|S0002^Paracetamol^99SCS|500||mg^milligram^99UCS|Tab^Tablets^99FCS||||G|||||||||||J00.0^Cold^I10\r" + 
    			"NTE|1||TAKE WITH WATER\r" + 
    			"RXR|PO|MOUTH|\r" + 
    			"RXC|B|N02BE01^Paracetamol^ATC|500|mg^milligram^ANS+\r" + 
    			"RXE||054565^Dafalgan 500 mg tablets^99LCN|2|||Tab^Tablets^99FCS|01^Take with Water|||||||P0343874^Jansen^Patricia|P001\r" + 
    			"NTE|1||Prescription Item OK|IA^Prescription item Advice notes\r" + 
    			"NTE|2||Prescription OK|PA^Prescription-wide Advice notes\r" + 
    			"TQ1|1|1^Tab&Tablets&99FCS||070000~150000~230000|||20110307\r" + 
    			"RXR|PO|MOUTH|";
    	
    	PipeParser parser = PipeParser.getInstanceWithNoValidation();
    	RDE_O11 msg = (RDE_O11) parser.parse( msgS );
    	PID pid = msg.getPATIENT().getPID();
    	Date dt = pid.getPid7_DateTimeOfBirth().getValueAsDate();
    	
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(dt);
    	
    	assertEquals(1968, cal.get(Calendar.YEAR));
    	assertEquals(2, cal.get(Calendar.MONTH));
    	assertEquals(6, cal.get(Calendar.DAY_OF_MONTH));
    	
    	
    }
    
}
