package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static ca.uhn.hl7v2.TestSpecBuilder.ints;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for ca.uhn.hl7v2.model.v24.datatype.DT
 * 
 * @author Leslie Mann, Elmar Hinz
 */

public class DTTest {
    private static final int year = 2002;
    private static int month = 2;
    private static int day = 24;
    private static String dateString = "20020224";

    private static HapiContext context;

    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();

    @BeforeClass
    public static void setupBefore() {
        context = new DefaultHapiContext(ValidationContextFactory.defaultValidation());
    }
	 
    /**
     * Testing default constructor
     */
    @Test
    public void testConstructor() throws HL7Exception {
        DT dt = new DT(context.newMessage(GenericMessage.V24.class));
        assertNotNull("Should have a valid DT object", dt);
    }

    public static class SetGetSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            Message message = context.newMessage(GenericMessage.V24.class);
            DT dt = new DT(message);
            dt.setValue(input);
            return dt.getValue();
        }
        
    }

    /**
     * Testing set/getValue() with various date strings
     */
    @Test
    public void testSetGetValue() throws DataTypeException {
        buildSpecs(SetGetSpec.class)
    	    .add(null, (String)null)
    	    .add("", "")
    	    .add(" ", DataTypeException.class)
    	    .add("2", DataTypeException.class)
    	    .add("20", DataTypeException.class)
    	    .add("200", DataTypeException.class)
    	    .add("999", DataTypeException.class)
    	    //year
    	    .add("1000", "1000")
    	    .add("1987", "1987")
    	    .add("2002", "2002")
    	    .add("9999", "9999")
    	    .add("10000", DataTypeException.class)
    	    //month
    	    .add("20021", DataTypeException.class)
    	    //.add("200200", DataTypeException.class),
    	    .add("200201", "200201")
    	    .add("200207", "200207")
    	    .add("200211", "200211")
    	    .add("200212", "200212")
    	    //.add("200213", DataTypeException.class),
    	    //day
    	    .add("2002010", DataTypeException.class)
    	    //.add("20020100", DataTypeException.class),
    	    .add("20020101", "20020101")
    	    .add("20020107", "20020107")
    	    .add("20020121", "20020121")
    	    .add("20020131", "20020131")
    	    //new TestSpec("20020132", DataTypeException.class)
    	    .executeTests(collector);
    }

    public static class SetYearPrecisionSpec extends TestSpec<Integer, String> {

        @Override
        protected String transform(Integer input) throws Throwable {
            Message message = context.newMessage(GenericMessage.V24.class);

            DT dt = new DT(message);
            dt.setYearPrecision(input);
            return dt.getValue();       
        }
        
    }
    /**
     * Testing setYearPrecision() with various year values
     */
    @Test    
    public void testSetYearPrecision() throws DataTypeException {  	
        buildSpecs(SetYearPrecisionSpec.class)
    	    .add(-2000, DataTypeException.class)
    	    .add(9, DataTypeException.class)
    	    .add(99, DataTypeException.class)
    	    .add(999, DataTypeException.class)
    	    .add(1000, "1000")
    	    .add(1987, "1987")
    	    .add(2001, "2001")
    	    .add(9999, "9999")
    	    .add(10000, DataTypeException.class)
    	    .executeTests(collector);
    }
    
    public static class SetYearMonthPrecisionSpec extends TestSpec<int[], String> {
        @Override
        protected String transform(int[] input) throws Throwable {
            Message message = context.newMessage(GenericMessage.V24.class);
    
            DT dt = new DT(message);
            dt.setYearMonthPrecision(input[0], input[1]);
            return dt.getValue();           
        }
    }
    
    /**
     * Testing setYearMonthPrecision() with various year, month values
     */
    @Test    
    public void testSetYearMonthPrecision() throws DataTypeException {	
        buildSpecs(SetYearMonthPrecisionSpec.class)
    	    .add(ints(2001, -1), DataTypeException.class)
    	    .add(ints(9, 1), DataTypeException.class)
    	    .add(ints(99, 1), DataTypeException.class)
    	    .add(ints(999, 1), DataTypeException.class)
    	    .add(ints(2001, 0), DataTypeException.class)
    	    .add(ints(2001, 1), "200101")
    	    .add(ints(1000, 1), "100001")
    	    .add(ints(1987, 1), "198701")
    	    .add(ints(2001, 1), "200101")
    	    .add(ints(2001, 7), "200107")
    	    .add(ints(2001, 12), "200112")
    	    .add(ints(2001, 13), DataTypeException.class)
    	    .add(ints(9999, 1), "999901")
    	    .add(ints(10000, 1), DataTypeException.class)
    	    .executeTests(collector);
    }

    public static class SetYearMonthDayPrecisionSpec extends TestSpec<int[], String> {
        @Override
        protected String transform(int[] input) throws Throwable {
            Message message = context.newMessage(GenericMessage.V24.class);
            DT dt = new DT(message);
            dt.setYearMonthDayPrecision(input[0], input[1], input[2]);
            return dt.getValue();           
        }
    }
    
    /**
     * Testing setYearMonthDayPrecision() with various year, month, day values
     */
    @Test    
    public void testSetYearMonthDayPrecision() throws DataTypeException {  	
        buildSpecs(SetYearMonthDayPrecisionSpec.class)
    	    .add(ints(2001, 1, -1), DataTypeException.class)
    	    .add(ints(9, 1, 1), DataTypeException.class)
    	    .add(ints(99, 1, 1), DataTypeException.class)
    	    .add(ints(999, 1, 1), DataTypeException.class)
    	    .add(ints(2001, 1, 0), DataTypeException.class)
    	    .add(ints(2001, 1, 1), "20010101")
    	    .add(ints(1000, 1, 1), "10000101")
    	    .add(ints(1987, 1, 1), "19870101")
    	    .add(ints(2001, 1, 1), "20010101")
    	    .add(ints(2001, 1, 7), "20010107")
    	    .add(ints(2001, 1, 12), "20010112")
    	    .add(ints(2001, 1, 25), "20010125")
    	    .add(ints(2001, 1, 31), "20010131")
    	    .add(ints(2001, 1, 32), DataTypeException.class)
    	    .add(ints(9999, 1, 1), "99990101")
    	    .add(ints(10000, 1, 1), DataTypeException.class)
    	    .add(ints(2001, 1, 1), "20010101")
    	    .add(ints(2001, -1, 21), DataTypeException.class)
    	    .executeTests(collector);
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
    public void testGetYear() throws HL7Exception {
        Message message = context.newMessage(GenericMessage.V24.class);
        DT dt = new DT(message);
        dt.setValue(dateString);
    	assertEquals("Should get year back", year, dt.getYear());
    }
    
    /**
     * Testing ability to retrieve month value
     */
    @Test
    public void testGetMonth() throws HL7Exception {
        DT dt = new DT(context.newMessage(GenericMessage.V24.class));
        dt.setValue(dateString);
	    assertEquals("Should get month back", month, dt.getMonth());
    }
    
    /**
     * Testing ability to retrieve day value
     */
    @Test
    public void testGetDay() throws HL7Exception {
        DT dt = new DT(context.newMessage(GenericMessage.V24.class));
        dt.setValue(dateString);
        assertEquals("Should get day back", day, dt.getDay());
    }

}


