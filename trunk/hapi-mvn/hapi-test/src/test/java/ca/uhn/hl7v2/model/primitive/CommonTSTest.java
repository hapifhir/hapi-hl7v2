/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "CommonTSTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.model.primitive.CommonTS"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
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

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.IndexedErrorCollector;
import ca.uhn.hl7v2.TestSpec;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.DataTypeUtil;

/**
 * Unit test class for ca.uhn.hl7v2.model.primitive.CommonTS
 * 
 * @author Leslie Mann
 */
public class CommonTSTest {
    static String offsetStr;
    static String timeStamp;
    static String baseTime;
    static Integer offset;
    static int year;
    static int month;
    static int day;
    static int hour;
    static int minute;
    static int second;
    static float fractionalSecond;
    
    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();    

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

    /**
     * @see TestCase#setUp()
     */
    @BeforeClass
    public static void setUp() throws Exception {
        year = 2002;
        month = 11;
        day = 30;
        hour = 11;
        minute = 23;
        second = 15;
        fractionalSecond = .1234F;

        offset = DataTypeUtil.getLocalGMTOffset();
        offsetStr = DataTypeUtil.preAppendZeroes(Math.abs(offset), 4);
        if (offset >= 0) {
            offsetStr = "+" + offsetStr;
        } else {
            offsetStr = "-" + offsetStr;
        }
        timeStamp = Integer.toString(year) + Integer.toString(month) + Integer.toString(day)
                + Integer.toString(hour) + Integer.toString(minute) + Integer.toString(second)
                + Float.toString(fractionalSecond).substring(1) + offsetStr;
        baseTime = Integer.toString(year) + Integer.toString(month) + Integer.toString(day)
                + Integer.toString(hour) + Integer.toString(minute) + Integer.toString(second)
                + Float.toString(fractionalSecond).substring(1);
    }

    /**
     * See bug 3545328
     * 
     * This bug has not yet been evaluated, so the test will fail.
     */
    @Test
    public void testOffsetProblem() throws HL7Exception {
        GregorianCalendar hapiTestCalendar = (GregorianCalendar) GregorianCalendar
                .getInstance(TimeZone.getTimeZone("CET"));
        hapiTestCalendar.set(2012, 1, 1);
        hapiTestCalendar = (GregorianCalendar) DateUtils.truncate(hapiTestCalendar, Calendar.DATE);

        assertEquals("20120201000000+0100", CommonTS.toHl7TSFormat(hapiTestCalendar));
        hapiTestCalendar.set(2012, 7, 1);

        assertEquals("20120801000000+0200", CommonTS.toHl7TSFormat(hapiTestCalendar));
    }

    @Test
    public void testGetCalendarRespectsDaylightSavings() throws DataTypeException, ParseException {

        SimpleDateFormat utcFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

        CommonTS ts = new CommonTS();
        ts.setValue("19840601080102-0400");

        Calendar asCalendar = ts.getValueAsCalendar();
        assertEquals(8, asCalendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(1, asCalendar.get(Calendar.MINUTE));
        assertEquals(2, asCalendar.get(Calendar.SECOND));
        assertEquals(-4, asCalendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000));

        Date asDate = ts.getValueAsDate();
        assertEquals(asCalendar.getTime(), asDate);
        assertEquals(asCalendar.getTimeInMillis(), asDate.getTime());

        Date midnightUtc = utcFmt.parse("1984-06-01 12:01:02 +0000");
        assertEquals(midnightUtc, ts.getValueAsDate());

        // Make sure it reverses correctly as well
        CommonTS ts2 = new CommonTS();
        ts2.setValue(asCalendar);
        assertEquals(ts.getValue(), ts2.getValue());

        /*
         * We try this once on Jun 1 and once on Jan 1 so that we cover the case
         * of parsing a non-DST date during DST, as well as a DST date outside
         * of DST.
         */

        ts = new CommonTS();
        ts.setValue("19840101070102-0500");

        asCalendar = ts.getValueAsCalendar();
        assertEquals(7, asCalendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(1, asCalendar.get(Calendar.MINUTE));
        assertEquals(2, asCalendar.get(Calendar.SECOND));
        assertEquals(-5, asCalendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000));

        asDate = ts.getValueAsDate();
        assertEquals(asCalendar.getTime(), asDate);
        assertEquals(asCalendar.getTimeInMillis(), asDate.getTime());

        midnightUtc = utcFmt.parse("1984-01-01 12:01:02 +0000");

        assertEquals(midnightUtc, ts.getValueAsDate());

        // Make sure it reverses correctly as well
        ts2 = new CommonTS();
        ts2.setValue(asCalendar);
        assertEquals(ts.getValue(), ts2.getValue());

    }

    /**
     * Test for http://sourceforge.net/support/tracker.php?aid=3410095
     */
    @Test
    public void testSetCalendarUsingHighValueTimeZoneOffset() throws ParseException,
            DataTypeException {

        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss Z").parse("20110102 12:00:00 -0000"));
        c.set(Calendar.ZONE_OFFSET, 12 * 60 * 60 * 1000);
        CommonTS commonTS = new CommonTS();
        commonTS.setValue(c);
        String val = commonTS.getValue();
        assertEquals("20110102070000+1200", val);
    }

    /**
     * Test for default constructor
     */
    @Test
    public void testConstructor() {
        assertNotNull("Should have a valid CommonTS object", new CommonTS());
    }

    /**
     * Test for string constructor
     */
    @Test
    public void testStringConstructor() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertNotNull("Should have a valid CommonTS object", commonTS);
    }

    /**
     * Testing string constructor with delete value "".
     */
    @Test
    public void testStringConstructor2() throws DataTypeException {
        CommonTS commonTS = new CommonTS("\"\"");
        assertNotNull("Should have a valid CommonTS object", commonTS);
    }

    @Test
    public void testNativeJavaAccessorsAndMutators() throws DataTypeException, ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = format.parse("20100609 12:40:05");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        CommonTS commonTS = new CommonTS();
        commonTS.setValueToMinute(cal);
        assertEquals("201006091240", commonTS.getValue());

        commonTS = new CommonTS();
        commonTS.setValueToMinute(date);
        assertEquals("201006091240", commonTS.getValue());

        commonTS = new CommonTS();
        commonTS.setValueToSecond(cal);
        assertEquals("20100609124005", commonTS.getValue());

        commonTS = new CommonTS();
        commonTS.setValueToSecond(date);
        assertEquals("20100609124005", commonTS.getValue());

        commonTS = new CommonTS();
        cal.set(Calendar.MILLISECOND, 250);
        cal.set(Calendar.ZONE_OFFSET, -4 * 1000 * 60 * 60);
        commonTS.setValue(cal);
        String value = commonTS.getValue();
        assertEquals("20100609124005.25-0400", value);

        // 3410095 : proof to avoid overflow
        commonTS = new CommonTS();
        cal.set(Calendar.ZONE_OFFSET, 12 * 1000 * 60 * 60);
        commonTS.setValue(cal);
        value = commonTS.getValue();
        assertEquals("20100609124005.25+1200", value);

        // 3410095-related : proof to cover time zones not at the full hour,
        // e.g. India
        commonTS = new CommonTS();
        cal.set(Calendar.ZONE_OFFSET, (int) (5.5 * 1000 * 60 * 60));
        commonTS.setValue(cal);
        value = commonTS.getValue();
        assertEquals("20100609124005.25+0530", value);

        commonTS = new CommonTS();
        commonTS.setValue("201006091240");
        assertEquals("201006091240", commonTS.getValue());
        String formatted = format.format(commonTS.getValueAsDate());
        assertEquals("20100609 12:40:00", formatted);

        commonTS = new CommonTS();
        commonTS.setValue("201006091240");
        assertEquals("20100609 12:40:00", format.format(commonTS.getValueAsCalendar().getTime()));

        // Check millis and offset
        commonTS = new CommonTS();
        commonTS.setValue("20100609124005.25-0400");
        cal = commonTS.getValueAsCalendar();
        assertEquals(250, cal.get(Calendar.MILLISECOND));
        assertEquals(-4 * 1000 * 60 * 60, cal.get(Calendar.ZONE_OFFSET));

    }

    public static class SetGetSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            CommonTS ts = new CommonTS();
            ts.setValue(input);
            return ts.getValue();       
        }
    }
    
    /**
     * Test set/getValue with various inputs
     */
    @Test
    public void testSetGetValue() {
        Class<? extends Throwable> dte = DataTypeException.class;
        buildSpecs(SetGetSpec.class)
                .add(null, (String)null)
                .add("", "")
                .add("\"\"", "\"\"")
                // year
                .add("0", dte)
                .add("1", dte)
                .add("19", dte)
                .add("198", dte)
                .add("1984", "1984")
                // year & time zone
                .add("1984-1", dte)
                .add("1984-11", dte)
                .add("1984-111", dte)
                .add("1984-0060", dte)
                .add("1984-0059", "1984-0059")
                .add("1984-0001", "1984-0001")
                .add("1984-0000", "1984+0000")
                .add("1984+0000", "1984+0000")
                .add("1984+0001", "1984+0001")
                .add("1984+0059", "1984+0059")
                .add("1984+0060", dte)
                .add("1984+11111", dte)
                // month
                .add("19840", dte)
                .add("198400", dte)
                .add("198401", "198401")
                .add("198412", "198412")
                .add("198413", dte)
                // month & time zone
                .add("198401-1", dte)
                .add("198401-11", dte)
                .add("198401-111", dte)
                .add("198401-0060", dte)
                .add("198401-0059", "198401-0059")
                .add("198401-0001", "198401-0001")
                .add("198401-0000", "198401+0000")
                .add("198401+0000", "198401+0000")
                .add("198401+0001", "198401+0001")
                .add("198401+0059", "198401+0059")
                .add("198401+0060", dte)
                .add("198401+11111", dte)
                // day
                .add("1984010", dte)
                .add("19840100", dte)
                .add("19840101", "19840101")
                .add("19840131", "19840131")
                .add("19840132", dte)
                // day & time zone
                .add("19840101-1", dte)
                .add("19840101-11", dte)
                .add("19840101-111", dte)
                .add("19840101-0060", dte)
                .add("19840101-0059", "19840101-0059")
                .add("19840101-0001", "19840101-0001")
                .add("19840101-0000", "19840101+0000")
                .add("19840101+0000", "19840101+0000")
                .add("19840101+0001", "19840101+0001")
                .add("19840101+0059", "19840101+0059")
                .add("19840101+0060", dte)
                .add("19840101+11111", dte)
                // hour
                .add("198401011", dte)
                .add("1984010111", "1984010111") // allowed as of v2.5
                .add("19840101111", dte)
                .add("198401010000", "198401010000")
                .add("198401010100", "198401010100")
                .add("198401012300", "198401012300")
                .add("198401012400", dte)
                .add("1984010123001", dte)
                // minute
                .add("19840101000", dte)
                .add("198401010000", "198401010000")
                .add("198401010001", "198401010001")
                .add("198401010059", "198401010059")
                .add("198401010060", dte)
                // hour/minute & time zone
                .add("198401010000-1", dte)
                .add("198401010000-11", dte)
                .add("198401010000-111", dte)
                .add("198401010000-0060", dte)
                .add("198401010000-0059", "198401010000-0059")
                .add("198401010000-0001", "198401010000-0001")
                .add("198401010000-0000", "198401010000+0000")
                .add("198401010000+0000", "198401010000+0000")
                .add("198401010000+0001", "198401010000+0001")
                .add("198401010000+0059", "198401010000+0059")
                .add("198401010000+0060", dte)
                .add("198401010000+11111", dte)
                // seconds
                .add("1984010100000", dte)
                .add("19840101000000", "19840101000000")
                .add("19840101000001", "19840101000001")
                .add("19840101000059", "19840101000059")
                .add("19840101000060", dte)
                // seconds & time zone
                .add("19840101000000-1", dte)
                .add("19840101000000-11", dte)
                .add("19840101000000-111", dte)
                .add("19840101000000-0060", dte)
                .add("19840101000000-0059", "19840101000000-0059")
                .add("19840101000000-0001", "19840101000000-0001")
                .add("19840101000000-0000", "19840101000000+0000")
                .add("19840101000000+0000", "19840101000000+0000")
                .add("19840101000000+0001", "19840101000000+0001")
                .add("19840101000000+0059", "19840101000000+0059")
                .add("19840101000000+0060", dte)
                .add("19840101000000+11111", dte)
                // milliseconds
                .add("19840101000000.", dte)
                .add("19840101000000.0", "19840101000000.0")
                .add("19840101000000.00", "19840101000000.00")
                .add("19840101000000.000", "19840101000000.000")
                .add("19840101000000.0000", "19840101000000.0000")
                .add("19840101000000.0001", "19840101000000.0001")
                .add("19840101000000.9999", "19840101000000.9999")
                .add("19840101000000.00000", dte)
                // milliseconds & time zone
                .add("19840101000000.0-1", dte)
                .add("19840101000000.0-11", dte)
                .add("19840101000000.0-111", dte)
                .add("19840101000000.0-0060", dte)
                .add("19840101000000.0-0059", "19840101000000.0-0059")
                .add("19840101000000.0-0001", "19840101000000.0-0001")
                .add("19840101000000.0-0000", "19840101000000.0+0000")
                .add("19840101000000.0+0000", "19840101000000.0+0000")
                .add("19840101000000.00+0000", "19840101000000.00+0000")
                .add("19840101000000.000+0000", "19840101000000.000+0000")
                .add("19840101000000.0000+0000", "19840101000000.0000+0000")
                .add("19840101000000.0+0001", "19840101000000.0+0001")
                .add("19840101000000.0+0059", "19840101000000.0+0059")
                .add("19840101000000.0+0060", dte)
                .add("19840101000000.0+11111", dte)
                .executeTests(collector);
    }

    public static class SetDatePrecisionSpec extends TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            CommonTS ts = new CommonTS();
            ts.setDatePrecision(input[0], input[1], input[2]);
            return ts.getValue();
        }
        
    }
    
    @Test
    public void testSetDatePrecision() {
        Class<? extends Throwable> dte = DataTypeException.class;
        buildSpecs(SetDatePrecisionSpec.class)
                .add(ints(-2001, 1, 1), dte)
                .add(ints(2001, -1, -1), dte)
                .add(ints(2001, 1, -1), dte)
                .add(ints(9, 1, 1), dte)
                .add(ints(99, 1, 1), dte)
                .add(ints(999, 1, 1), dte)
                .add(ints(2001, 0, 1), dte)
                .add(ints(2001, 1, 0), dte)
                .add(ints(2001, 1, 1), "20010101")
                .add(ints(1000, 1, 1), "10000101")
                .add(ints(1987, 1, 1), "19870101")
                .add(ints(2001, 1, 1), "20010101")
                .add(ints(2001, 1, 7), "20010107")
                .add(ints(2001, 1, 12), "20010112")
                .add(ints(2001, 1, 25), "20010125")
                .add(ints(2001, 1, 31), "20010131")
                .add(ints(2001, 1, 32), dte)
                .add(ints(9999, 1, 1), "99990101")
                .add(ints(10000, 1, 1), dte)
                .add(ints(2001, 1, 1), "20010101")
                .add(ints(2001, -1, 21), dte)
                .executeTests(collector);
    }

    public static class SetDateMinutePrecisionSpec extends TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            CommonTS ts = new CommonTS();
            ts.setDateMinutePrecision(input[0], input[1], input[2], input[3], input[4]);
            return ts.getValue();
        }
        
    }
    
    @Test
    public void testSetDateMinutePrecision() {
        Class<? extends Throwable> dte = DataTypeException.class;
        buildSpecs(SetDateMinutePrecisionSpec.class)
                .add(ints(-2001, 1, 1, 1, 1), dte)
                .add(ints(2001, -1, 1, 1, 1), dte)
                .add(ints(2001, 1, -1, 1, 1), dte)
                .add(ints(2001, 1, 1, -1, 1), dte)
                .add(ints(2001, 1, 1, 1, -1), dte)
                .add(ints(9, 1, 1, 1, 1), dte)
                .add(ints(99, 1, 1, 1, 1), dte)
                .add(ints(999, 1, 1, 1, 1), dte)
                .add(ints(1000, 1, 1, 1, 1), "100001010101")
                .add(ints(1987, 1, 1, 0, 30), "198701010030")
                .add(ints(2001, 0, 1, 1, 1), dte)
                .add(ints(2001, 1, 0, 1, 1), dte)
                .add(ints(2001, 1, 1, 1, 1), "200101010101")
                .add(ints(2001, 1, 1, 0, 0), "200101010000")
                .add(ints(2001, 1, 1, 8, 15), "200101010815")
                .add(ints(2001, 1, 7, 13, 27), "200101071327")
                .add(ints(2001, 1, 12, 23, 59), "200101122359")
                .add(ints(2001, 1, 12, 23, 59), "200101122359")
                .add(ints(2001, 1, 12, 23, 60), dte)
                .add(ints(2001, 1, 12, 24, 59), dte)
                .add(ints(2001, 1, 12, 24, 60), dte)
                .add(ints(2001, 1, 25, 1, 1), "200101250101")
                .add(ints(2001, 1, 31, 1, 1), "200101310101")
                .add(ints(2001, 1, 32, 1, 1), dte)
                .add(ints(9999, 1, 1, 1, 1), "999901010101")
                .add(ints(10000, 1, 1, 1, 1), dte)
                .add(ints(2001, 1, 1, 1, 1), "200101010101")
                .add(ints(2001, -1, 21, 1, 1), dte)
                .executeTests(collector);
    }

    static private class Params {
        int[] ints;
        float second;
    }
    
    static Params params(int[] ints, float second) {
        Params p = new Params();
        p.ints = ints;
        p.second = second;
        return p;
    }
    
    public static class SetDateSecondPrecisionSpec extends TestSpec<Params, String> {

        @Override
        protected String transform(Params input) throws Throwable {
            CommonTS ts = new CommonTS();
            int[] ints = input.ints;
            ts.setDateSecondPrecision(ints[0], ints[1], ints[2], ints[3], ints[4], input.second);
            return ts.getValue();
        }
        
    }
    
    @Test
    public void testSetDateSecondPrecision() {
        Class<? extends Throwable> dte = DataTypeException.class;
        buildSpecs(SetDateSecondPrecisionSpec.class)
                .add(params(ints(2001, -1, 1, 1, 1), 1.0F), dte)
                .add(params(ints(2001, 1, -1, 1, 1), 1.0F), dte)
                .add(params(ints(2001, 1, 1, -1, 1), 1.0F), dte)
                .add(params(ints(2001, 1, 1, 1, -1), 1.0F), dte)
                .add(params(ints(2001, 1, 1, 1, 1), -1.0F), dte)
                .add(params(ints(9, 1, 1, 1, 1), 1.0F), dte)
                .add(params(ints(99, 1, 1, 1, 1), 1.0F), dte)
                .add(params(ints(999, 1, 1, 1, 1), 1.0F), dte)
                .add(params(ints(1000, 1, 1, 1, 1), 1.0F), "10000101010101")
                .add(params(ints(1987, 1, 1, 0, 30), 1.1234F), "19870101003001.1234")
                .add(params(ints(2001, 0, 1, 1, 1), 1.0F), dte)
                .add(params(ints(2001, 1, 0, 1, 1), 1.0F), dte)
                .add(params(ints(2001, 1, 1, 1, 1), 0.0F), "20010101010100")
                .add(params(ints(2001, 1, 1, 1, 1), 1.12F), "20010101010101.12")
                .add(params(ints(2001, 1, 1, 1, 1), 12.12F), "20010101010112.12")
                .add(params(ints(2001, 1, 1, 1, 1), 123.12F), dte)
                .add(params(ints(2001, 1, 1, 1, 1), 12.123F), "20010101010112.123")
                .add(params(ints(2001, 1, 1, 1, 1), 12.1234F), "20010101010112.1234")
                .add(params(ints(2001, 1, 1, 1, 1), 12.12345F), "20010101010112.1235")
                .add(params(ints(2001, 1, 1, 1, 1), 59.1234F), "20010101010159.1234")
                .add(params(ints(2001, 1, 1, 1, 1), 59.9999F), "20010101010159.9999")
                .add(params(ints(2001, 1, 1, 1, 1), 59.99999F), dte)
                .add(params(ints(2001, 1, 1, 1, 1), 60.0F), dte)
                .add(params(ints(2001, 1, 1, 1, 1), 1.12F), "20010101010101.12")
                .add(params(ints(2001, 1, 1, 0, 0), 23.456F), "20010101000023.456")
                .add(params(ints(2001, 1, 1, 8, 15), 1.0F), "20010101081501")
                .add(params(ints(2001, 1, 7, 13, 27), 1.0F), "20010107132701")
                .add(params(ints(2001, 1, 12, 23, 59), 1.0F), "20010112235901")
                .add(params(ints(2001, 1, 12, 23, 59), 1.0F), "20010112235901")
                .add(params(ints(2001, 1, 12, 23, 60), 1.0F), dte)
                .add(params(ints(2001, 1, 12, 24, 59), 1.0F), dte)
                .add(params(ints(2001, 1, 12, 24, 60), 1.0F), dte)
                .add(params(ints(2001, 1, 25, 1, 1), 1.0F), "20010125010101")
                .add(params(ints(2001, 1, 31, 1, 1), 1.0F), "20010131010101")
                .add(params(ints(2001, 1, 32, 1, 1), 1.0F), dte)
                .add(params(ints(9999, 1, 1, 1, 1), 1.0F), "99990101010101")
                .add(params(ints(10000, 1, 1, 1, 1), 1.0F), dte)
                .add(params(ints(2001, 1, 1, 1, 1), 1.0F), "20010101010101")
                .add(params(ints(2001, -1, 21, 1, 1), 1.0F), dte)
                .executeTests(collector);
    }

    public static class SetOffsetSpec extends TestSpec<Integer, String> {

        @Override
        protected String transform(Integer input) throws Throwable {
            CommonTS ts = new CommonTS(timeStamp);
            ts.setOffset(input);
            return ts.getValue();
        }
        
    }
    
    /**
     * Test set/getOffset. Testspec constructor sets up a value of "154638" so
     * we can get a value back
     */
    @Test
    public void testSetGetOffset() {

        buildSpecs(SetOffsetSpec.class)
                .add(-0000, baseTime + "+0000")
                .add(-1160, DataTypeException.class)
                .add(-1159, baseTime + "-1159")
                .add(2106, baseTime + "+2106")
                .add(21064, DataTypeException.class)
                .add(-24, baseTime + "-0024")
                .add(800, baseTime + "+0800")
                .add(1300, baseTime + "+1300")
                // .add(24, DataTypeException.class)
                .add(2300, baseTime + "+2300")
                .executeTests(collector);
    }

    /**
     * Testing ability to retrieve year value
     */
    @Test
    public void testGetYear() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get year back", year, commonTS.getYear());
    }

    /**
     * Testing ability to retrieve month value
     */
    @Test
    public void testGetMonth() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get month back", month, commonTS.getMonth());
    }

    /**
     * Testing ability to retrieve day value
     */
    @Test
    public void testGetDay() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get day back", day, commonTS.getDay());
    }

    /**
     * Testing ability to retrieve hour value
     */
    @Test
    public void testGetHour() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get hour back", hour, commonTS.getHour());
    }

    /**
     * Testing ability to retrieve minute value
     */
    @Test
    public void testGetMinute() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get minute back", minute, commonTS.getMinute());
    }

    /**
     * Testing ability to retrieve second value
     */
    @Test
    public void testGetSecond() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get seconds back", second, commonTS.getSecond());
    }

    /**
     * Testing ability to retrieve fractional second value
     */
    @Test
    public void testGetFractSecond() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get fractional seconds back", fractionalSecond,
                commonTS.getFractSecond(), 0.0001);
    }

    /**
     * Testing ability to retrieve GMT offset value
     */
    @Test
    public void testGetGMTOffset() throws DataTypeException {
        CommonTS commonTS = new CommonTS(timeStamp);
        assertEquals("Should get GMT offset back", offset, commonTS.getGMTOffset());
        commonTS  = new CommonTS("19990909+0500");
        assertEquals(500, commonTS.getGMTOffset().intValue());
    }

    @Test
    public void testToHl7TMFormat() throws DataTypeException {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("America/Toronto"));
        cal.clear();
        cal.setLenient(false);
        cal.set(Calendar.HOUR_OF_DAY, 20);
        cal.set(Calendar.MINUTE, 6);
        cal.set(Calendar.SECOND, 24);
        cal.set(Calendar.MILLISECOND, 528);
        String convertedDate = CommonTM.toHl7TMFormat(cal);
        assertEquals("Should get a HL7 formatted date back", "200624.528-0500", convertedDate);
    }
}
