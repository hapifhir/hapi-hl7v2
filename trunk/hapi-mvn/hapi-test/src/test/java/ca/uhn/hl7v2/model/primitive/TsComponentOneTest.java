package ca.uhn.hl7v2.model.primitive;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v25.datatype.DTM;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;

public class TsComponentOneTest {

	private SimpleDateFormat myFormat;
	private ORU_R01 myMsg;
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
	
	
	@Before
	public void setUp() throws Exception {
		myFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

		TimeZone timeZone = TimeZone.getTimeZone("Canada/Eastern");
		myFormat.setTimeZone(timeZone);
		
		myMsg = new ORU_R01();
		myMsg.initQuickstart("ORU", "R01", "P");
	}

	@Test
	public void testCalendarOperations() throws HL7Exception {
		
		// DTM extends TSComponentOne
		DTM time = new DTM(new ORU_R01());
		
		time.setValue("20110201121233");
		
		Date date = time.getValueAsDate();
		String formatted = myFormat.format(date);
		// System.out.println(formatted);
		assertEquals("2011-02-01T12:12:33.000-0500", formatted);
		// Tue Feb 01 12:12:33 EST 2011

	}

	@Test
	public void testGetOperationsOnNull() throws DataTypeException {
		
		DTM dtm = myMsg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx14_DateTimeOfTheObservation().getTs1_Time();
		Assert.assertEquals(null, dtm.getValueAsCalendar());
		Assert.assertEquals(null, dtm.getValueAsDate());
		Assert.assertEquals(null, dtm.getValue());
		
	}
	
	/**
	 * This caused an exception at one point
	 */
	@Test(expected=DataTypeException.class)
	public void testSetWithInvalid() throws HL7Exception {
		DTM dtm = myMsg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx14_DateTimeOfTheObservation().getTs1_Time();
		dtm.setValue("HELP I'M A BUG");
		dtm.setValue(new Date());
	}

	/**
	 * This caused an exception at one point
	 */
	@Test(expected=DataTypeException.class)
	public void testGetWithInvalid1() throws HL7Exception {
		DTM dtm = myMsg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx14_DateTimeOfTheObservation().getTs1_Time();
		dtm.setValue("HELP I'M A BUG");
		dtm.getValueAsCalendar();
	}
	
    @Test(expected=DataTypeException.class)
    public void testGetWithInvalid2() throws HL7Exception {
        DTM dtm = myMsg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx14_DateTimeOfTheObservation().getTs1_Time();
        dtm.setValue("HELP I'M A BUG");
        dtm.getValueAsDate();
    }

	@Test
	public void testSetValueAsCalendar() throws HL7Exception {

		// DTM extends TSComponentOne
		DTM time = new DTM(myMsg);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 22);
		cal.set(Calendar.MILLISECOND, 333);
		int zoneOffset = -5 * 60 * 60 * 1000;
		cal.set(Calendar.ZONE_OFFSET, zoneOffset);
		time.setValue(cal);
		
		// System.out.println((zoneOffset*100) / (60 * 60 * 1000));
		// System.out.println(cal.getTime());
		
		String encoded = time.encode();
		// System.out.println(encoded);
		assertEquals("20100129125922.333-0500", encoded);
		// 201001291259

		cal = time.getValueAsCalendar();
		String formatted = myFormat.format(cal.getTime());
		// System.out.println(formatted);
		assertEquals("2010-01-29T12:59:22.333-0500", formatted);
		
		
	}

	@Test
	public void testSetValueAsCalendarToMinute() throws HL7Exception {

		// DTM extends TSComponentOne
		DTM time = new DTM(myMsg);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		time.setValueToMinute(cal);
		
		String encoded = time.encode();
		// System.out.println(encoded);
		assertEquals("201001291259", encoded);
		// 201001291259

		cal = time.getValueAsCalendar();
		String formatted = myFormat.format(cal.getTime());
		// System.out.println(formatted);
		assertEquals("2010-01-29T12:59:00.000-0500", formatted);
		
		
	}
	
	@Test
	public void testSetValueAsCalendarWithSeconds() throws HL7Exception {

		// DTM extends TSComponentOne
		DTM time = new DTM(myMsg);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 33);
		time.setValueToSecond(cal);
		
		String encoded = time.encode();
		// System.out.println(encoded);
		assertEquals("20100129125933", encoded);
		// 201001291259

		cal = time.getValueAsCalendar();
		String formatted = myFormat.format(cal.getTime());
		// System.out.println(formatted);
		assertEquals("2010-01-29T12:59:33.000-0500", formatted);
		
		
	}

	@Test
	public void testSetValueAsDate() throws HL7Exception {

		// DTM extends TSComponentOne
		DTM time = new DTM(myMsg);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 22);
		cal.set(Calendar.MILLISECOND, 333);
		int zoneOffset = -5 * 60 * 60 * 1000;
		cal.set(Calendar.ZONE_OFFSET, zoneOffset);
		time.setValue(cal.getTime());
		
		// System.out.println((zoneOffset*100) / (60 * 60 * 1000));
		
		// System.out.println(cal.getTime());
		
		String encoded = time.encode();
		// System.out.println(encoded);
		assertEquals("20100129125922.333-0500", encoded);
		// 201001291259

		Date date = time.getValueAsDate();
		String formatted = myFormat.format(date);
		// System.out.println(formatted);
		assertEquals("2010-01-29T12:59:22.333-0500", formatted);
		
		
	}

	@Test
	public void testSetValueAsDateToMinute() throws HL7Exception {

		// DTM extends TSComponentOne
		DTM time = new DTM(myMsg);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		time.setValueToMinute(cal.getTime());
		
		String encoded = time.encode();
		// System.out.println(encoded);
		assertEquals("201001291259", encoded);
		// 201001291259

		Date date = time.getValueAsDate();
		String formatted = myFormat.format(date);
		// System.out.println(formatted);
		assertEquals("2010-01-29T12:59:00.000-0500", formatted);
		
		
	}
	
	@Test
	public void testSetValueAsDateWithSeconds() throws HL7Exception {

		// DTM extends TSComponentOne
		DTM time = new DTM(myMsg);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, 2010);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 29);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 33);
		time.setValueToSecond(cal.getTime());
		
		String encoded = time.encode();
		// System.out.println(encoded);
		assertEquals("20100129125933", encoded);
		// 201001291259

		Date date = time.getValueAsDate();
		String formatted = myFormat.format(date);
		// System.out.println(formatted);
		assertEquals("2010-01-29T12:59:33.000-0500", formatted);
		
		
	}

    @Test
    public void testIsEmptyAndClear() throws HL7Exception {
        DTM time = new DTM(myMsg);
        Calendar cal = new GregorianCalendar();
        time.setValueToMinute(cal.getTime());

        assertFalse(time.isEmpty());

        time.clear();
        assertTrue(time.isEmpty());
    }

}
