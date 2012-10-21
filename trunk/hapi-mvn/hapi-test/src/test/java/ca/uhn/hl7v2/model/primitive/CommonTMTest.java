/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonTMTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.CommonTM
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.model.primitive;

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static ca.uhn.hl7v2.TestSpecBuilder.ints;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.TestSpec;
import ca.uhn.hl7v2.model.DataTypeException;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.CommonTM
 * 
 * Problems:
 * setOffset - does not check for minimum length
 * setOffset - how do you get an integer like 0024
 * after setHour, etc unable to get the value out
 *
 * @author Leslie Mann
 */
public class CommonTMTest {
	static final String baseTime = "154638";
	static final String baseTimePrecision = baseTime + ".4321";
	static final String baseTimePrecisionOffset = baseTimePrecision + "-2345";

	private static TimeZone tz;

	@BeforeClass
	public static void setUpBeforeClass() {
		tz = TimeZone.getDefault();
		TimeZone.setDefault(TimeZone.getTimeZone("Canada/Eastern"));
    }
	
	@AfterClass
	public static void tearDownBeforeClass() {
		TimeZone.setDefault(tz);
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
	    CommonTM commonTM = new CommonTM();
		assertNotNull("Should have a valid CommonTM object", commonTM);
	}

	/**
	 * Test for http://sourceforge.net/support/tracker.php?aid=3410095
	 */
	@Test
	public void testSetCalendarUsingHighValueTimeZoneOffset() throws ParseException, DataTypeException {

		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss Z").parse("20110102 12:00:00 -0000"));	
		// System.out.println(c.getTime());	
		c.set(Calendar.ZONE_OFFSET, 12 * 60 * 60 * 1000);
		// System.out.println(c.getTime());
		CommonTM commonTM = new CommonTM();
		commonTM.setValue(c);
		String val = commonTM.getValue();
		assertEquals("070000+1200", val);
	}
	
	
	@Test
    public void testNativeJavaAccessorsAndMutators() throws DataTypeException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ssZ");
        Date date = format.parse("20100609 12:40:05-0400");
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        cal.setTime(date);
        
        CommonTM commonTM = new CommonTM();
        commonTM.setValueToMinute(cal);
        assertEquals("1240", commonTM.getValue());

        commonTM = new CommonTM();
        commonTM.setValueToMinute(date);
        assertEquals("1240", commonTM.getValue());

        commonTM = new CommonTM();
        commonTM.setValueToSecond(cal);
        assertEquals("124005", commonTM.getValue());

        commonTM = new CommonTM();
        commonTM.setValueToSecond(date);
        assertEquals("124005", commonTM.getValue());

        commonTM = new CommonTM();
        cal.set(Calendar.MILLISECOND, 250);
        cal.set(Calendar.ZONE_OFFSET, -4 * 1000 * 60 * 60);
        commonTM.setValue(cal);
        String value = commonTM.getValue();
        assertEquals("124005.25-0400", value);

        commonTM = new CommonTM();
        cal.set(Calendar.ZONE_OFFSET, 12 * 1000 * 60 * 60);
        commonTM.setValue(cal);
        value = commonTM.getValue();
        assertEquals("124005.25+1200", value);

        commonTM = new CommonTM();
        cal.set(Calendar.ZONE_OFFSET, (int)(5.5 * 1000 * 60 * 60));
        commonTM.setValue(cal);
        value = commonTM.getValue();
        assertEquals("124005.25+0530", value);
        
        commonTM = new CommonTM();
        cal.set(Calendar.MILLISECOND, 250);
        cal.set(Calendar.ZONE_OFFSET, 11 * 1000 * 60 * 60);
        commonTM.setValue(cal);
        value = commonTM.getValue();
        assertEquals("124005.25+1100", value); // TODO fails       
        
        format = new SimpleDateFormat("HH:mm:ss");
        
        commonTM = new CommonTM();
        commonTM.setValue("1240");
        String formatted = format.format(commonTM.getValueAsDate());
        assertEquals("12:40:00", formatted);
        
        commonTM = new CommonTM();
        commonTM.setValue("1240");
        assertEquals("12:40:00", format.format(commonTM.getValueAsCalendar().getTime()));

        commonTM = new CommonTM();
        commonTM.setValue("124005");
        formatted = format.format(commonTM.getValueAsDate());
        assertEquals("12:40:05", formatted);
        
        commonTM = new CommonTM();
        commonTM.setValue("124005");
        assertEquals("12:40:05", format.format(commonTM.getValueAsCalendar().getTime()));
        
        // Check millis and offset
        commonTM = new CommonTM();
        commonTM.setValue("124005.25-0400");
        cal = commonTM.getValueAsCalendar();
        assertEquals(250, cal.get(Calendar.MILLISECOND));
        assertEquals(-4 * 1000 * 60 * 60, cal.get(Calendar.ZONE_OFFSET));
    }
    
	/**
	 * Test for string constructor
	 */
	@Test
	public void testStringConstructor() throws DataTypeException {
	    CommonTM commonTM = new CommonTM(baseTime);
		assertNotNull("Should have a valid CommonTM object", commonTM);
	}
    
    /**
     * Testing string constructor with delete value "". 
     */
	@Test
	public void testStringConstructor2() throws DataTypeException {
	    CommonTM commonTM = new CommonTM("\"\"");
        assertNotNull("Should have a valid CommonTM object", commonTM);
        assertEquals("Should have a value of \"\" ", "\"\"", commonTM.getValue());
    }

	/**
	 * Test set/get value with various time strings
	 */
	
	public static class SetGetSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            CommonTM tm = new CommonTM();
            tm.setValue(input);
            return tm.getValue();
        }
	    
	}
	
    public void testSetGet() {
		buildSpecs(SetGetSpec.class)
			.add(null, (String)null)
			.add("\"\"", "\"\"")
			.add("0", DataTypeException.class)
			.add("08", "08") //note: default time zone has been removed in case parser in different zone than sender
			.add("080", DataTypeException.class)
			.add("0800", "0800")
			.add("08000", DataTypeException.class)
			.add("080005", "080005")
			.add("0800051", DataTypeException.class)
			.add("080005.1", "080005.1")
			.add("080005.14", "080005.14")
			.add("080005.147", "080005.147")
			.add("080005.1479", "080005.1479")
			.add("080005.14793", DataTypeException.class)
			.add("0+0600", DataTypeException.class)
			.add("08-0100", "08-0100")
			.add("080-0500", DataTypeException.class)
			.add("0800-0500", "0800-0500")
			.add("080005-1300", "080005-1300")
			.add("0800051", DataTypeException.class)
			.add("080005.1+0100", "080005.1+0100")
			.add("080005.14+1000", "080005.14+1000")
			.add("080005.147-1200", "080005.147-1200")
			.add("080005.1479+0340", "080005.1479+0340")
			.add("080005.1479+0330", "080005.1479+0330")
			.add("080005.1479+1234", "080005.1479+1234")
			.executeTests();	
	}

    public static class SetHourPrecisionSpec extends TestSpec<Integer, String> {

        @Override
        protected String transform(Integer input) throws Throwable {
            CommonTM tm = new CommonTM();
            tm.setHourPrecision(input);
            return tm.getValue();       
        }  
    }
    
	@Test
	public void testSetHourPrecision() {
		buildSpecs(SetHourPrecisionSpec.class)
			.add(-1, DataTypeException.class)
			.add(0, "00")
			.add(8, "08")
			.add(13, "13")
			.add(23, "23")
			.add(24, DataTypeException.class)
			.executeTests();
	}

    public static class SetHourMinutePrecisionSpec extends TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            CommonTM tm = new CommonTM();
            tm.setHourMinutePrecision(input[0], input[1]);
            return tm.getValue();       
        }  
    }
    
	@Test
	public void testSetHourMinutePrecision() {
		buildSpecs(SetHourMinutePrecisionSpec.class)
			.add(ints(-1,0), DataTypeException.class)
			.add(ints(0, -1), DataTypeException.class)
			.add(ints(0, 0), "0000")
			.add(ints(0, 30), "0030")
			.add(ints(0, 59), "0059")
			.add(ints(0, 60), DataTypeException.class)
			.add(ints(8, 15), "0815")
			.add(ints(13, 27), "1327")
			.add(ints(24, 59), DataTypeException.class)
			.executeTests();
	}

    public static class SetHourMinuteSecondPrecisionSpec extends TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            CommonTM tm = new CommonTM();
            tm.setHourMinSecondPrecision(input[0], input[1], input[2]);
            return tm.getValue();       
        }  
    }
    
	@Test
	public void testSetHourMinSecondPrecision() {
		buildSpecs(SetHourMinuteSecondPrecisionSpec.class)
			.add(ints(-1, 0, 0), DataTypeException.class)
			.add(ints(0, -1, 0), DataTypeException.class)
			.add(ints(0, 0, -1), DataTypeException.class)
			.add(ints(0, 0, 0), "000000")
			.add(ints(1, 1, 1), "010101")
			.add(ints(0, 30, 47), "003047")
			.add(ints(8, 15, 59), "081559")
			.add(ints(8, 15, 60), DataTypeException.class)
			.add(ints(13, 27, 0), "132700")
			.add(ints(23, 59, 59), "235959")
			.add(ints(24, 59, 59), DataTypeException.class)
			.add(ints(23, 60, 59), DataTypeException.class)
			.add(ints(23, 59, 60), DataTypeException.class)
			.add(ints(24, 60, 60), DataTypeException.class)
			.executeTests();
	}

    public static class SetOffsetSpec extends TestSpec<Integer, String> {

        @Override
        protected String transform(Integer signedOffset) throws Throwable {
            CommonTM tm = new CommonTM(baseTime);
            tm.setOffset(signedOffset);
            return tm.getValue();       
        }  
    }
	/**
	 * Test set/getOffset.  Testspec constructor sets up a value
	 * of "154638" so we can get a value back
	 */
	@Test
	public void testSetGetOffset() {
    		
		buildSpecs(SetOffsetSpec.class)
			.add(-0000, baseTime + "+0000")
			.add(-24, baseTime + "-0024")
			.add(-1160, DataTypeException.class)
			.add(-1159, baseTime + "-1159")
			.add(800, baseTime + "+0800")
			.add(1300, baseTime + "+1300")
			.add(2400, DataTypeException.class)
			.add(2300, baseTime + "+2300")
			.add(2106, baseTime + "+2106")
			.add(21064, DataTypeException.class)
			.executeTests();
	}

	@Test
	public void testGetHour() throws DataTypeException {
	    CommonTM commonTM = new CommonTM(baseTime);
		int hour = commonTM.getHour();
		assertEquals("Should get hour back", Integer.parseInt(baseTime.substring(0,2)), hour);
	}

	@Test
	public void testGetMinute() throws DataTypeException {
	    CommonTM commonTM = new CommonTM(baseTime);
		int minute = commonTM.getMinute();
		assertEquals("Should get minute back", Integer.parseInt(baseTime.substring(2,4)), minute);
	}

	@Test
	public void testGetSecond() throws DataTypeException {
	    CommonTM commonTM = new CommonTM(baseTime);
		int second = commonTM.getSecond();
		assertEquals("Should get second back", Integer.parseInt(baseTime.substring(4,6)), second);
	}

	@Test
	public void testGetFractSecond() throws DataTypeException {
		float delta = .0001f;
		CommonTM commonTM = new CommonTM(baseTimePrecision);
		float fractSecond = commonTM.getFractSecond();
		assertEquals("Should get fractional second back", Float.parseFloat(baseTimePrecision.substring(6,11)),
			fractSecond, delta);
	}

	@Test
	public void testGetGMTOffset() throws DataTypeException {
	    CommonTM commonTM = new CommonTM(baseTimePrecisionOffset);
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
