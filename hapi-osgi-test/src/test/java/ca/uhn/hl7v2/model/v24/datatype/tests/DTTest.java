package ca.uhn.hl7v2.model.v24.datatype.tests;

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
import ca.uhn.hl7v2.model.v24.datatype.DT;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

/**
 * Unit test class for ca.uhn.hl7v2.model.v24.datatype.tests.DT
 * 
 * @author Leslie Mann, Elmar Hinz
  * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class DTTest {
    
 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(DTTest.class);
    
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
    
    private int year;
    private int month;
    private int day;
    private String dateString;
    private DT DT;

@Before
public void BeforeTheTest() {
	year = 2002;
	month = 2;
	day = 24;
	dateString = "20020224";
	DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
    }



    /*
********************************************************** 
* Test Cases
********************************************************** 
*/
	 
    /**
     * Testing default constructor
     */
    @Test
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
    @Test
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
		
	ArrayList failedTests = new ArrayList();

	for (int i = 0; i < tests.length ; i++) {
	    if ( ! tests[ i ].executeTest() ) 
		failedTests.add( tests[ i ] );
	}

	assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }

    /**
     * Testing setYearPrecision() with various year values
     */
    @Test
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
		
	ArrayList failedTests = new ArrayList();

	for (int i = 0; i < tests.length ; i++) {
	    if ( ! tests[ i ].executeTest() ) 
		failedTests.add( tests[ i ] );
	}

	assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }

    /**
     * Testing setYearMonthPrecision() with various year, month values
     */
    @Test
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
		
	ArrayList failedTests = new ArrayList();

	for (int i = 0; i < tests.length ; i++) {
	    if ( ! tests[ i ].executeTest() ) 
		failedTests.add( tests[ i ] );
	}

	assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }

    /**
     * Testing setYearMonthDayPrecision() with various year, month, day values
     */
    @Test
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
		
	ArrayList failedTests = new ArrayList();

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
    @Test
    public void testGetYear() throws DataTypeException {
    	DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
        DT.setValue(dateString);
    	assertEquals("Should get year back", year, DT.getYear());
    }
    
    /**
     * Testing ability to retrieve month value
     */
    @Test
    public void testGetMonth() throws DataTypeException {
        DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
        DT.setValue(dateString);
	    assertEquals("Should get month back", month, DT.getMonth());
    }
    
    /**
     * Testing ability to retrieve day value
     */
    @Test
    public void testGetDay() throws DataTypeException {
        DT = new DT(new GenericMessage.V25(new DefaultModelClassFactory()));
        DT.setValue(dateString);
        assertEquals("Should get day back", day, DT.getDay());
    }

}


