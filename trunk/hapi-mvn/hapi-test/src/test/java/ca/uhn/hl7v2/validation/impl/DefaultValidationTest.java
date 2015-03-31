/*
 * Created on 13-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.fail;

import ca.uhn.hl7v2.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v24.datatype.TN;
import ca.uhn.hl7v2.model.v25.datatype.DT;
import ca.uhn.hl7v2.model.v25.datatype.DTM;
import ca.uhn.hl7v2.model.v25.datatype.NM;
import ca.uhn.hl7v2.model.v25.datatype.SI;
import ca.uhn.hl7v2.model.v25.datatype.TM;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * Test cases for various default validation rules.  
 * 
 * @author Bryan Tripp
 * @author Leslie Mann
 * @author Christian Ohr 
 */
public class DefaultValidationTest {

    private static HapiContext context;
    private static Message myMessage;
    
    @Rule public IndexedErrorCollector collector = new IndexedErrorCollector();
    

    @BeforeClass
    public static void setUp() throws Exception {
        context = new DefaultHapiContext(new DefaultValidation());
        context.setModelClassFactory(new CanonicalModelClassFactory());
        myMessage = context.newMessage(GenericMessage.V25.class);
    }
    
    
    /**
     * https://sourceforge.net/tracker/?func=detail&aid=3471934&group_id=38899&atid=423835
     */
    @Ignore("Disabled until new HL7 structure libraries are in place")
    @Test
    public void testPhoneExceptionMessage() {
    	
    	String messageString = "MSH|^~\\&|ABCDEFG&1.23.4&ISO|CDS|LABADT|MCM|20120109|SECURITY|ADT^A04|MSG00001|P|2.4\r"+
    			"EVN|A01|198808181123\r"+
    			"PID|||R2D002^^^BADFAC&1.2.8.9.3.4.2.8&ISO||Smith^Michael^^^Mr||19800930|M||2106-3|1205 S Main STREET^^San Jose^CA^27401-1020|GL|(919)379-1212|(919)271-3434~(919)277-3114||S||ADT_PID18^2^M10|123456789|9-87654^NC\r"+
    			"NK1|1|JONES^BARBARA^K|SPO|||||20011105\r"+
    			"NK1|1|JONES^MICHAEL^A|FTH\r";

		PipeParser p = context.getPipeParser();

		try {
			p.parse(messageString);
			fail();
		} catch (EncodingNotSupportedException e) {
			fail(e.getMessage());
		} catch (HL7Exception e) {
			if (!e.getMessage().contains("(919)379-1212")) {
				fail(e.getMessage());
			}
		}

    	messageString = "MSH|^~\\&|ABCDEFG&1.23.4&ISO|CDS|LABADT|MCM|20120109|SECURITY|ADT^A04|MSG00001|P|2.4\r"+
    			"EVN|A01|198808181123\r"+
    			"PID|\r"+
    			"PID|||R2D002^^^BADFAC&1.2.8.9.3.4.2.8&ISO||Smith^Michael^^^Mr||19800930|M||2106-3|1205 S Main STREET^^San Jose^CA^27401-1020|GL|(919)379-1212|(919)271-3434~(919)277-3114||S||ADT_PID18^2^M10|123456789|9-87654^NC\r"+
    			"NK1|1|JONES^BARBARA^K|SPO|||||20011105\r"+
    			"NK1|1|JONES^MICHAEL^A|FTH\r";

		try {
			p.parse(messageString);
			fail();
		} catch (EncodingNotSupportedException e) {
			fail(e.getMessage());
		} catch (HL7Exception e) {
			if (!e.getMessage().contains("(919)379-1212")) {
				fail(e.getMessage());
			}
		}

    }
    
    public static class DTTestSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            DT dt = new DT(myMessage);
            dt.setValue(input);
            return dt.getValue();
        }
        
    }
    
    @Test
    public void testDT() throws Exception {
        
        TestSpecBuilder.<String, String>buildSpecs(DTTestSpec.class, DataTypeException.class)
            .accept((String)null, 
                    "", 
                    "\"\"")
            .reject(" ",
                    "2",
                    "20",
                    "200",
                    "999")
            //year
            .accept("1000", 
                    "1987", 
                    "2002", 
                    "9999")
            .reject("10000")
            //month
            .reject("20021")
            //.reject("200200")
            .accept("200201",
                    "200207",
                    "200211",
                    "200212")
            //.reject("200213"),
            //day
            .reject("2002010")
            //.reject("20020100"),
            .accept("20020101",
                    "20020107",
                    "20020121",
                    "20020131")
            //.add("20020132", DataTypeException.class),
            .executeTests(collector);
    }
    
    public static class TMTestSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            TM tm = new TM(myMessage);
            tm.setValue(input);
            return tm.getValue();
        }
        
    }
    
    @Test
    public void testTM() throws Exception {

        TestSpecBuilder.<String, String>buildSpecs(TMTestSpec.class, DataTypeException.class)
            .accept((String)null)
            .accept("\"\"", "\"\"")
            .reject("0")
            .accept("08")
            .reject("080")
            .accept("0800", "0800")
            .reject("08000")
            .accept("080005")
            .reject("0800051")
            .accept("080005.1",
                    "080005.14", 
                    "080005.147", 
                    "080005.1479")
            .reject("080005.14793", 
                    "0+0600")
            .accept("08-0100")
            .reject("080-0500")
            .accept("0800-0500", 
                    "080005-1300")
            .reject("0800051")
            .accept("080005.1+0100", 
                    "080005.14+1000", 
                    "080005.147-1200", 
                    "080005.1479+0340", 
                    "080005.1479+0330", 
                    "080005.1479+1234")
            .executeTests(collector);
    }

    public static class TSTestSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            DTM ts = new DTM(myMessage);
            ts.setValue(input);
            return ts.getValue();
        }
        
    }
    
    @Test    
    public void testTS() throws Exception {
            
        TestSpecBuilder.<String, String>buildSpecs(TSTestSpec.class, DataTypeException.class)
            .accept((String)null, 
                    "",
                    "\"\"")
            //year
            .add("0", DataTypeException.class)
            .add("1", DataTypeException.class)
            .add("19", DataTypeException.class)
            .add("198", DataTypeException.class)
            .add("1984", "1984")
            //year & time zone
            .add("1984-1", DataTypeException.class)
            .add("1984-11", DataTypeException.class)
            .add("1984-111", DataTypeException.class)
            //.add("1984-0060", DataTypeException.class)
            .add("1984-0059", "1984-0059")
            .add("1984-0001", "1984-0001")
            //.add("1984-0000", "1984+0000"),
            .add("1984+0000", "1984+0000")
            .add("1984+0001", "1984+0001")
            .add("1984+0059", "1984+0059")
            //.add("1984+0060", DataTypeException.class)
            .add("1984+11111", DataTypeException.class)
            //month
            .add("19840", DataTypeException.class)
            //.add("198400", DataTypeException.class)
            .add("198401", "198401")
            .add("198412", "198412" )
            //.add("198413", DataTypeException.class)
            //month & time zone
            .add("198401-1", DataTypeException.class)
            .add("198401-11", DataTypeException.class)
            .add("198401-111", DataTypeException.class)
            //.add("198401-0060", DataTypeException.class)
            .add("198401-0059", "198401-0059")
            .add("198401-0001", "198401-0001")
            //.add("198401-0000", "198401+0000")
            .add("198401+0000", "198401+0000")
            .add("198401+0001", "198401+0001")
            .add("198401+0059", "198401+0059")
            //.add("198401+0060", DataTypeException.class)
            .add("198401+11111", DataTypeException.class)
            //day
            .add("1984010", DataTypeException.class)
            //.add("19840100", DataTypeException.class)
            .add("19840101", "19840101")
            .add("19840131", "19840131")
            //.add("19840132", DataTypeException.class)
            //day & time zone
            .add("19840101-1", DataTypeException.class)
            .add("19840101-11", DataTypeException.class)
            .add("19840101-111", DataTypeException.class)
            //.add("19840101-0060", DataTypeException.class)
            .add("19840101-0059", "19840101-0059")
            .add("19840101-0001", "19840101-0001")
            //.add("19840101-0000", "19840101+0000")
            .add("19840101+0000", "19840101+0000")
            .add("19840101+0001", "19840101+0001")
            .add("19840101+0059", "19840101+0059")
            //.add("19840101+0060", DataTypeException.class)
            .add("19840101+11111", DataTypeException.class)
            //hour
            .add("198401011", DataTypeException.class)
            .add("1984010111", "1984010111")
            .add("19840101111", DataTypeException.class)
            .add("198401010000", "198401010000")
            .add("198401010100", "198401010100")
            .add("198401012300", "198401012300")
            //.add("198401012400", DataTypeException.class)
            .add("1984010123001", DataTypeException.class)
            //minute
            .add("19840101000", DataTypeException.class)
            .add("198401010000", "198401010000")
            .add("198401010001", "198401010001")
            .add("198401010059", "198401010059")
            //.add("198401010060", DataTypeException.class)
            //hour/minute & time zone
            .add("198401010000-1", DataTypeException.class)
            .add("198401010000-11", DataTypeException.class)
            .add("198401010000-111", DataTypeException.class)
            //.add("198401010000-0060", DataTypeException.class)
            .add("198401010000-0059", "198401010000-0059")
            .add("198401010000-0001", "198401010000-0001")
            //.add("198401010000-0000", "198401010000+0000")
            .add("198401010000+0000", "198401010000+0000")
            .add("198401010000+0001", "198401010000+0001")
            .add("198401010000+0059", "198401010000+0059")
            //.add("198401010000+0060", DataTypeException.class)
            .add("198401010000+11111", DataTypeException.class)
            //seconds
            .add("1984010100000", DataTypeException.class)
            .add("19840101000000", "19840101000000")
            .add("19840101000001", "19840101000001")
            .add("19840101000059", "19840101000059")
            //.add("19840101000060", DataTypeException.class)
            //seconds & time zone
            .add("19840101000000-1", DataTypeException.class)
            .add("19840101000000-11", DataTypeException.class)
            .add("19840101000000-111", DataTypeException.class)
            //.add("19840101000000-0060", DataTypeException.class)
            .add("19840101000000-0059", "19840101000000-0059")
            .add("19840101000000-0001", "19840101000000-0001")
            //.add("19840101000000-0000", "19840101000000+0000")
            .add("19840101000000+0000", "19840101000000+0000")
            .add("19840101000000+0001", "19840101000000+0001")
            .add("19840101000000+0059", "19840101000000+0059")
            //.add("19840101000000+0060", DataTypeException.class)
            .add("19840101000000+11111", DataTypeException.class)
            //milliseconds
            .add("19840101000000.", DataTypeException.class)
            .add("19840101000000.0", "19840101000000.0")
            .add("19840101000000.00", "19840101000000.00")
            .add("19840101000000.000", "19840101000000.000")
            .add("19840101000000.0000", "19840101000000.0000")
            .add("19840101000000.0001", "19840101000000.0001")
            .add("19840101000000.9999", "19840101000000.9999")
            .add("19840101000000.00000", DataTypeException.class)
            //milliseconds & time zone
            .add("19840101000000.0-1", DataTypeException.class)
            .add("19840101000000.0-11", DataTypeException.class)
            .add("19840101000000.0-111", DataTypeException.class)
            //.add("19840101000000.0-0060", DataTypeException.class)
            .add("19840101000000.0-0059", "19840101000000.0-0059")
            .add("19840101000000.0-0001", "19840101000000.0-0001")
            //.add("19840101000000.0-0000", "19840101000000.0+0000")
            .add("19840101000000.0+0000", "19840101000000.0+0000")
            .add("19840101000000.00+0000", "19840101000000.00+0000")
            .add("19840101000000.000+0000", "19840101000000.000+0000")
            .add("19840101000000.0000+0000", "19840101000000.0000+0000")
            .add("19840101000000.0+0001", "19840101000000.0+0001")
            .add("19840101000000.0+0059", "19840101000000.0+0059")
            //.add("19840101000000.0+0060", DataTypeException.class)
            .add("19840101000000.0+11111", DataTypeException.class)
            .executeTests(collector);

    }
    
    public static class TNTestSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            TN tn = new TN(myMessage);
            tn.setValue(input);
            return tn.getValue();
        }
        
    }    

    @Test    
    public void testTN() throws Exception {
        TestSpecBuilder.<String, String>buildSpecs(TNTestSpec.class)
            .add(null,(String)null)
            .add("", "")
            .add("\"\"","\"\"")
            .add("(", DataTypeException.class)
            .add("(7", DataTypeException.class)
            .add("(70", DataTypeException.class)
            .add("(705", DataTypeException.class)
            .add("(705)", DataTypeException.class)
            .add("(705)2", DataTypeException.class)
            .add("(705)26", DataTypeException.class)
            .add("(705)267", DataTypeException.class)
            .add("(705)267-", DataTypeException.class)
            .add("(705)267-2", DataTypeException.class)
            .add("(705)267-21", DataTypeException.class)
            .add("(705)267-213", DataTypeException.class)
            .add("(705)267-2131", "(705)267-2131")
            .add("(705)267-21312", DataTypeException.class)
            .add("1 (705)267-2131", "1 (705)267-2131")
            .add("12 (705)267-2131", "12 (705)267-2131")
            //.add("123 (705)267-2131", "123 (705)267-2131"),
            .add("123 (705)267-2131", DataTypeException.class)
            .add("1234 (705)267-2131", DataTypeException.class)
            //extensions
            .add("(705)267-2131X", DataTypeException.class)
            .add("1 (705)267-2131X2", "1 (705)267-2131X2")
            .add("12 (705)267-2131X2", "12 (705)267-2131X2")
            //.add("123 (705)267-2131X2", "123 (705)267-2131X2")
            .add("1234 (705)267-2131X2", DataTypeException.class)
            .add("(705)267-2131X23", "(705)267-2131X23")
            .add("(705)267-2131X234", "(705)267-2131X234")
            .add("(705)267-2131X2345", "(705)267-2131X2345")
            .add("(705)267-2131X23456", "(705)267-2131X23456")
            .add("(705)267-2131X234567", DataTypeException.class)
            .add("1 (705)267-2131X23456", "1 (705)267-2131X23456")
            .add("12 (705)267-2131X23456", "12 (705)267-2131X23456")
            //.add("123 (705)267-2131X23456", "123 (705)267-2131X23456")
            .add("1234 (705)267-2131X23456", DataTypeException.class)
            //beeper
            .add("(705)267-2131B", DataTypeException.class)
            .add("(705)267-2131B1", "(705)267-2131B1")
            .add("1 (705)267-2131B1", "1 (705)267-2131B1")
            .add("12 (705)267-2131B1", "12 (705)267-2131B1")
            //.add("123 (705)267-2131B1", "123 (705)267-2131B1")
            .add("1234 (705)267-2131B1", DataTypeException.class)
            .add("(705)267-2131B12", "(705)267-2131B12")
            .add("(705)267-2131B123", "(705)267-2131B123")
            .add("(705)267-2131B1234", "(705)267-2131B1234")
            .add("(705)267-2131B123456", DataTypeException.class)
            .add("1 (705)267-2131B12345", "1 (705)267-2131B12345")
            .add("12 (705)267-2131B12345", "12 (705)267-2131B12345")
            //.add("123 (705)267-2131B12345", "123 (705)267-2131B12345")
            .add("1234 (705)267-2131B12345", DataTypeException.class)
            //comment
            //.add("(705)267-2131C", DataTypeException.class),
            .add("(705)267-2131C Test", "(705)267-2131C Test")
            .add("(705)267-2131CRreally long text", "(705)267-2131CRreally long text")
            .add("1 (705)267-2131C Test", "1 (705)267-2131C Test")
            .add("12 (705)267-2131C Test", "12 (705)267-2131C Test")
            //.add("123 (705)267-2131C Test", "123 (705)267-2131C Test")
            .add("1234 (705)267-2131C Test", DataTypeException.class)
            //extension and beeper
            .add("(705)267-2131X2345B", DataTypeException.class)
            .add("(705)267-2131X2345B1", "(705)267-2131X2345B1")
            .add("1 (705)267-2131X2345B1", "1 (705)267-2131X2345B1")
            .add("12 (705)267-2131X2345B1", "12 (705)267-2131X2345B1")
            //.add("123 (705)267-2131X2345B1", "123 (705)267-2131X2345B1")
            .add("1234 (705)267-2131X2345B1", DataTypeException.class)
            .add("(705)267-2131X2345B12", "(705)267-2131X2345B12")
            .add("(705)267-2131X2345B123", "(705)267-2131X2345B123")
            .add("(705)267-2131X2345B1234", "(705)267-2131X2345B1234")
            .add("(705)267-2131X2345B123456", DataTypeException.class)
            .add("1 (705)267-2131X2345B12345", "1 (705)267-2131X2345B12345")
            .add("12 (705)267-2131X2345B12345", "12 (705)267-2131X2345B12345")
            //.add("123 (705)267-2131X2345B12345", "123 (705)267-2131X2345B12345")
            .add("1234 (705)267-2131X2345B12345", DataTypeException.class)
            //extension and comment
            //.add("(705)267-2131X2345C", DataTypeException.class)
            .add("(705)267-2131X2345C Test", "(705)267-2131X2345C Test")
            .add("(705)267-2131X2345CRreally long text", "(705)267-2131X2345CRreally long text")
            .add("1 (705)267-2131X2345C Test", "1 (705)267-2131X2345C Test")
            .add("12 (705)267-2131X2345C Test", "12 (705)267-2131X2345C Test")
            //.add("123 (705)267-2131X2345C Test", "123 (705)267-2131X2345C Test")
            .add("1234 (705)267-2131X2345C Test", DataTypeException.class)
            //beeper and comment
            //.add("(705)267-2131B1234C", DataTypeException.class),
            .add("(705)267-2131B1234C Test", "(705)267-2131B1234C Test")
            .add("(705)267-2131B1234CRreally long text", "(705)267-2131B1234CRreally long text")
            .add("1 (705)267-2131B1234C Test", "1 (705)267-2131B1234C Test")
            .add("12 (705)267-2131B1234C Test", "12 (705)267-2131B1234C Test")
            //.add("123 (705)267-2131B1234C Test", "123 (705)267-2131B1234C Test")
            .add("1234 (705)267-2131B1234C Test", DataTypeException.class)
            //extension, beeper, and comment
            //.add("(705)267-2131X2345B1234C", DataTypeException.class),
            .add("(705)267-2131X2345B1234C Test", "(705)267-2131X2345B1234C Test")
            .add("(705)267-2131X2345B1234CRreally long text", "(705)267-2131X2345B1234CRreally long text")
            .add("1 (705)267-2131X2345B1234C Test", "1 (705)267-2131X2345B1234C Test")
            .add("12 (705)267-2131X2345B1234C Test", "12 (705)267-2131X2345B1234C Test")
            //.add("123 (705)267-2131X2345B1234C Test", "123 (705)267-2131X2345B1234C Test")
            .add("1234 (705)267-2131X2345B1234C Test", DataTypeException.class)
            .executeTests(collector);
    }

    public static class NMTestSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            NM nm = new NM(myMessage);
            nm.setValue(input);
            return nm.getValue();
        }
        
    }   
    
    /**
     * @throws Exception ... 
     */
    @Test    
    public void testNM() throws Exception {
        TestSpecBuilder.<String, String>buildSpecs(NMTestSpec.class)
                .add(null, (String)null)
                .add("", "")
                .add("\"\"", "\"\"")
                .add("\"\"","\"\"")
                .add("-1234567.8901", "-1234567.8901")
                .add("-1234567.890", "-1234567.890")
                .add("-1234567.89", "-1234567.89")
                .add("-1234567.8", "-1234567.8")
                .add("-1234567.", "-1234567.")
                .add("-1234567", "-1234567")
                .add("-123456", "-123456")
                .add("-12345", "-12345")
                .add("-1234", "-1234")
                .add("-123", "-123")
                .add("-12", "-12")
                .add("-1", "-1")
                .add("-0", "-0")
                .add("+0", "+0")
                .add("0", "0")
                .add("+1", "+1")
                .add("12", "12")
                .add("123", "123")
                .add("1234", "1234")
                .add("12345", "12345")
                .add("123456", "123456")
                .add("1234567", "1234567")
                .add("1234567.", "1234567.")
                .add("1234567.8", "1234567.8")
                .add("1234567.89", "1234567.89")
                .add("1234567.890", "1234567.890")
                .add("1234567.8901", "1234567.8901")
                .add("+1234567.8901", "+1234567.8901")
                .add("-12.a34", DataTypeException.class)
                .add("TEST", DataTypeException.class)
                .executeTests(collector);
    }
    
    public static class SITestSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            SI si = new SI(myMessage);
            si.setValue(input);
            return si.getValue();
        }
        
    }
    
    @Test    
    public void testSI() throws Exception {
        TestSpecBuilder.<String, String>buildSpecs(SITestSpec.class)
        .add(null, (String)null)
        .add("", "")
        .add("1", "1")
        .add("12", "12")
        .add("123", "123")
        .add("-1", DataTypeException.class)
        .add("-2", DataTypeException.class)
        .add("1.1", DataTypeException.class)
        .add("-1.1", DataTypeException.class)
        .add("NaN", DataTypeException.class)
        .executeTests(collector);
    }
    
    
    /**
     * Make sure invalid DTs fail correctly, in response to a report from Serbulent Unsal.
     * @throws HL7Exception 
     * @throws EncodingNotSupportedException 
     */
    @Ignore("Disabled until new HL7 structure libraries are in place")
    @Test(expected=HL7Exception.class)
    public void testValidateTSComponentOne() throws HL7Exception {
        String validMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|something wrong here ||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
             + "EVN|A31|200903230934\r\n"
             + "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";
        
        PipeParser pipeParser = context.getPipeParser();
        pipeParser.parse(validMessage);
    }
    
}
