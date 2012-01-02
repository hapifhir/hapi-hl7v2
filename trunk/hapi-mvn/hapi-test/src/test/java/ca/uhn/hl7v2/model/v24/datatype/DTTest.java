package ca.uhn.hl7v2.model.v24.datatype;

import java.util.ArrayList;

import junit.framework.TestCase;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

/**
 * Unit test class for ca.uhn.hl7v2.model.v24.datatype.DT
 * 
 * @author Leslie Mann, Elmar Hinz
 */

public class DTTest extends TestCase {
    private int year;
    private int month;
    private int day;
    private String dateString;
    private DT DT;

    /**
     * Constructor for DTTest.
     * @param testName
     */
    public DTTest(String testName) {
	super(testName);
    }

    public static void main(String[] args) {
	junit.textui.TestRunner.run(DTTest.class);
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
	DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
    }

    /**
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
	super.tearDown();
	DT = null;
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
	assertNotNull("Should have a valid DT object", DT);
    }

    /**
     * Testing string constructor with a HL7 date string.
     */
//    public void testStringConstructor() throws DataTypeException {
//	DT = new DT(dateString);
//	assertNotNull("Should have a valid DT object", DT);
//    }

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
        Message message = new GenericMessage.V25(new DefaultModelClassFactory());  
        message.setValidationContext(new DefaultValidation());

		DT dt = new DT(message);
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
	    //new TestSpec("200200", DataTypeException.class),
	    new TestSpec("200201", "200201"),
	    new TestSpec("200207", "200207"),
	    new TestSpec("200211", "200211"),
	    new TestSpec("200212", "200212"),
	    //new TestSpec("200213", DataTypeException.class),
	    //day
	    new TestSpec("2002010", DataTypeException.class),
	    //new TestSpec("20020100", DataTypeException.class),
	    new TestSpec("20020101", "20020101"),
	    new TestSpec("20020107", "20020107"),
	    new TestSpec("20020121", "20020121"),
	    new TestSpec("20020131", "20020131"),
	    //new TestSpec("20020132", DataTypeException.class),
	};
		
	ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

	for (int i = 0; i < tests.length ; i++) {
	    if ( ! tests[ i ].executeTest() ) 
		failedTests.add( tests[ i ] );
	}

	assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
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
		DT dt = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
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
		DT dt = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
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
		DT dt = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
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
//    public void testConvertCalToHL7DateFormat() throws DataTypeException {
//	GregorianCalendar cal = new GregorianCalendar();
//        cal.clear();
//        cal.setLenient(false);
//	cal.set(2002,5,24);
//	String convertedDate = DT.toHl7DTFormat(cal);
//	assertEquals("20020624", convertedDate);
//    }

    /**
     * Testing ability to retrieve year value
     */
    public void testGetYear() throws DataTypeException {
    	DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
        DT.setValue(dateString);
    	assertEquals("Should get year back", year, DT.getYear());
    }
    
    /**
     * Testing ability to retrieve month value
     */
    public void testGetMonth() throws DataTypeException {
        DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
        DT.setValue(dateString);
	    assertEquals("Should get month back", month, DT.getMonth());
    }
    
    /**
     * Testing ability to retrieve day value
     */
    public void testGetDay() throws DataTypeException {
        DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
        DT.setValue(dateString);
        assertEquals("Should get day back", day, DT.getDay());
    }

}


