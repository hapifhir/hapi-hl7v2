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

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.TestSpec;
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

public class CommonDTTest {
    private static final int year = 2002;
    private static final int month = 2;
    private static final int day = 24;
    private static final String dateString = "20020224";


    /**
     * Testing default constructor
     */
    @Test
    public void testConstructor() {
        assertNotNull("Should have a valid CommonDT object", new CommonDT());
    }

    /**
     * Testing string constructor with a HL7 date string.
     */
    @Test
    public void testStringConstructor() throws DataTypeException {
        CommonDT commonDT = new CommonDT(dateString);
        assertNotNull("Should have a valid CommonDT object", commonDT);
    }

    /**
     * Testing string constructor with delete value "".
     */
    @Test
    public void testStringConstructor2() throws DataTypeException {
        CommonDT commonDT = new CommonDT("\"\"");
        assertNotNull("Should have a valid CommonDT object", commonDT);
    }

    public static class SetGetSpec extends TestSpec<String, String> {
        
        @Override
        protected String transform(String input) throws Throwable {
            CommonDT dt = new CommonDT();
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
            .add(null, (String) null)
            .add("", "")
            .add("\"\"", "\"\"")
            .add(" ", DataTypeException.class)
            .add("2", DataTypeException.class)
            .add("20", DataTypeException.class)
            .add("200", DataTypeException.class)
            .add("999", DataTypeException.class)
            // year
            .add("1000", "1000")
            .add("1987", "1987")
            .add("2002", "2002")
            .add("9999", "9999")
            .add("10000", DataTypeException.class)
            // month
            .add("20021", DataTypeException.class)
            .add("200200", DataTypeException.class)
            .add("200201", "200201")
            .add("200207", "200207")
            .add("200211", "200211")
            .add("200212", "200212")
            .add("200213", DataTypeException.class)
            // day
            .add("2002010", DataTypeException.class)
            .add("20020100", DataTypeException.class)
            .add("20020101", "20020101")
            .add("20020107", "20020107")
            .add("20020121", "20020121")
            .add("20020131", "20020131")
            .add("20020132", DataTypeException.class)
                
            .executeTests();

    }

    @Test
    public void testNativeJavaAccessorsAndMutators() throws DataTypeException, ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:ss");
        Date date = format.parse("20100609 12:40");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        CommonDT commonDT = new CommonDT();
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

    public static class SetYSpec extends TestSpec<Integer, String> {

        @Override
        protected String transform(Integer input) throws Throwable {
            CommonDT dt = new CommonDT();
            dt.setYearPrecision(input);
            return dt.getValue();
        }

    }
    
    /**
     * Testing setYearPrecision() with various year values
     */
    @Test
    public void testSetYearPrecision() throws DataTypeException {
        buildSpecs(SetYSpec.class)
            .add(-2000, DataTypeException.class)
            .add(9, DataTypeException.class)
            .add(99, DataTypeException.class)
            .add(999, DataTypeException.class)
            .add(1000, "1000")
            .add(1987, "1987")
            .add(2001, "2001")
            .add(9999, "9999")
            .add(10000, DataTypeException.class)
            
            .executeTests();

    }

    public static class SetYMSpec extends TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            CommonDT dt = new CommonDT();
            dt.setYearMonthPrecision(input[0], input[1]);
            return dt.getValue();
        }

    }
    
    /**
     * Testing setYearMonthPrecision() with various year, month values
     */
    @Test
    public void testSetYearMonthPrecision() throws DataTypeException {
        buildSpecs(SetYMSpec.class)
            .add(ints(2001, -1), DataTypeException.class)
            .add(ints(9, 1 ), DataTypeException.class)
            .add(ints( 99, 1 ), DataTypeException.class)
            .add(ints( 999, 1 ), DataTypeException.class)
            .add(ints( 2001, 0 ), DataTypeException.class)
            .add(ints( 2001, 1 ), "200101")
            .add(ints( 1000, 1 ), "100001")
            .add(ints( 1987, 1 ), "198701")
            .add(ints( 2001, 1 ), "200101")
            .add(ints( 2001, 7 ), "200107")
            .add(ints( 2001, 12 ), "200112")
            .add(ints( 2001, 13 ), DataTypeException.class)
            .add(ints( 9999, 1 ), "999901")
            .add(ints( 10000, 1 ), DataTypeException.class)
                
            .executeTests();
    }

    public static class SetYMDSpec extends TestSpec<int[], String> {

        @Override
        protected String transform(int[] input) throws Throwable {
            CommonDT dt = new CommonDT();
            dt.setYearMonthDayPrecision(input[0], input[1], input[2]);
            return dt.getValue();
        }

    }
    
    /**
     * Testing setYearMonthDayPrecision() with various year, month, day values
     */
    @Test
    public void testSetYearMonthDayPrecision() throws DataTypeException {
        buildSpecs(SetYMDSpec.class)
            .add(ints( 2001, 1, -1 ), DataTypeException.class)
            .add(ints( 9, 1, 1 ), DataTypeException.class)
            .add(ints( 99, 1, 1 ), DataTypeException.class)
            .add(ints( 999, 1, 1 ), DataTypeException.class)
            .add(ints( 2001, 1, 0 ), DataTypeException.class)
            .add(ints( 2001, 1, 1 ), "20010101")
            .add(ints( 1000, 1, 1 ), "10000101")
            .add(ints( 1987, 1, 1 ), "19870101")
            .add(ints( 2001, 1, 1 ), "20010101")
            .add(ints( 2001, 1, 7 ), "20010107")
            .add(ints( 2001, 1, 12 ), "20010112")
            .add(ints( 2001, 1, 25 ), "20010125")
            .add(ints( 2001, 1, 31 ), "20010131")
            .add(ints( 2001, 1, 32 ), DataTypeException.class)
            .add(ints( 9999, 1, 1 ), "99990101")
            .add(ints( 10000, 1, 1 ), DataTypeException.class)
            .add(ints( 2001, 1, 1 ), "20010101")
            .add(ints( 2001, -1, 21 ), DataTypeException.class) 
            
            .executeTests();
    }

    /**
     * Testing toHl7DTFormat() with a calendar
     */
    @Test
    public void testConvertCalToHL7DateFormat() throws DataTypeException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.clear();
        cal.setLenient(false);
        cal.set(2002, 5, 24);
        String convertedDate = CommonDT.toHl7DTFormat(cal);
        assertEquals("20020624", convertedDate);
    }

    /**
     * Testing ability to retrieve year value
     */
    @Test
    public void testGetYear() throws DataTypeException {
        CommonDT commonDT = new CommonDT(dateString);
        assertEquals("Should get year back", year, commonDT.getYear());
    }

    /**
     * Testing ability to retrieve month value
     */
    @Test
    public void testGetMonth() throws DataTypeException {
        CommonDT commonDT = new CommonDT(dateString);
        assertEquals("Should get month back", month, commonDT.getMonth());
    }

    /**
     * Testing ability to retrieve day value
     */
    @Test
    public void testGetDay() throws DataTypeException {
        CommonDT commonDT = new CommonDT(dateString);
        assertEquals("Should get day back", day, commonDT.getDay());
    }

    @Test
    public void testGetDTAsDate() throws EncodingNotSupportedException, HL7Exception {

        String msgS = "MSH|^~\\&|IHE|EU-CAT2011|||20110307194153||RDE^O11|MSG00003|P|2.6||||||UTF-8\r"
                + "PID|||A9283923889^^^^||Doe^John||19680306|M\r"
                + "PV1||I|Cardiology^4^01^CATEUR_WARDS&&L||||||||||||||||V00001\r"
                + "IN1|s|ID001^Full Insurance|XXXX|INSURANCE_Ltd.\r"
                + "ORC|NW|PL001||P001|||||20110414153220|||00000999^Strangelove^Peter^^^Dr.|||||||P0343874^Jansen^Patricia||Connectathon Europe 2011^^^^^^^^^CATEUR2011|Casa della Cittˆ Leopolda, Piazza Guerrazzi, 56125 Pisa|0039 50 48587||P3;V3\r"
                + "TQ1|1|2^Tab&Tablets&99FCS|TID\r"
                + "RXO|S0002^Paracetamol^99SCS|500||mg^milligram^99UCS|Tab^Tablets^99FCS||||G|||||||||||J00.0^Cold^I10\r"
                + "NTE|1||TAKE WITH WATER\r"
                + "RXR|PO|MOUTH|\r"
                + "RXC|B|N02BE01^Paracetamol^ATC|500|mg^milligram^ANS+\r"
                + "RXE||054565^Dafalgan 500 mg tablets^99LCN|2|||Tab^Tablets^99FCS|01^Take with Water|||||||P0343874^Jansen^Patricia|P001\r"
                + "NTE|1||Prescription Item OK|IA^Prescription item Advice notes\r"
                + "NTE|2||Prescription OK|PA^Prescription-wide Advice notes\r"
                + "TQ1|1|1^Tab&Tablets&99FCS||070000~150000~230000|||20110307\r" + "RXR|PO|MOUTH|";

        PipeParser parser = PipeParser.getInstanceWithNoValidation();
        RDE_O11 msg = (RDE_O11) parser.parse(msgS);
        PID pid = msg.getPATIENT().getPID();
        Date dt = pid.getPid7_DateTimeOfBirth().getValueAsDate();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        assertEquals(1968, cal.get(Calendar.YEAR));
        assertEquals(2, cal.get(Calendar.MONTH));
        assertEquals(6, cal.get(Calendar.DAY_OF_MONTH));

    }
    
    private int[] ints(int... values) {
        return values;
    }

}
