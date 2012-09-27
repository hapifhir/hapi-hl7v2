/*
 * Created on 13-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
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
    
    private Message myMessage;

    @Before
    public void setUp() throws Exception {
        myMessage = new GenericMessage.V25(new DefaultModelClassFactory());
        myMessage.setValidationContext(new DefaultValidation());
    }
    
    /**
     * https://sourceforge.net/tracker/?func=detail&aid=3471934&group_id=38899&atid=423835
     */
    @Test
    public void testPhoneExceptionMessage() {
    	
    	String messageString = "MSH|^~\\&|ABCDEFG&1.23.4&ISO|CDS|LABADT|MCM|20120109|SECURITY|ADT^A04|MSG00001|P|2.4\r"+
    			"EVN|A01|198808181123\r"+
    			"PID|||R2D002^^^BADFAC&1.2.8.9.3.4.2.8&ISO||Smith^Michael^^^Mr||19800930|M||2106-3|1205 S Main STREET^^San Jose^CA^27401-1020|GL|(919)379-1212|(919)271-3434~(919)277-3114||S||ADT_PID18^2^M10|123456789|9-87654^NC\r"+
    			"NK1|1|JONES^BARBARA^K|SPO|||||20011105\r"+
    			"NK1|1|JONES^MICHAEL^A|FTH\r";

		CanonicalModelClassFactory c = new CanonicalModelClassFactory();
		PipeParser p = new PipeParser(c);

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
    
    
    /**
     * @throws Exception ... 
     */
    @Test
    public void testDT() throws Exception {
        //adapted from CommonDTTest ... 
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
                DT dt = new DT(myMessage);
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
        
        ArrayList<Object> failedTests = new ArrayList<Object>();

        for (int i = 0; i < tests.length ; i++) {
            if ( ! tests[ i ].executeTest() ) 
                failedTests.add( tests[ i ] );
        }

        assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }
    
    /**
     * @throws Exception ... 
     */
    @Test
    public void testTM() throws Exception {
        //adapted from CommonTMTest ... 
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
                TM tm = new TM(myMessage);
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
            new TestSpec("08", "08"), 
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
        
        ArrayList<Object> failedTests = new ArrayList<Object>();

        for (int i = 0; i < tests.length ; i++) {
            if ( ! tests[ i ].executeTest() ) 
                failedTests.add( tests[ i ] );
        }

        assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }

    /**
     * @throws Exception ... 
     */
    @Test    
    public void testTS() throws Exception {
        class TestSpec {
            String value;
            Object outcome;
            Exception exception = null;
            
            TestSpec(String value, Object outcome) {
                this.value = value;
                this.outcome = outcome;
            }
            
            public String toString() {
                return "[ " + (value != null ? value : "null") + " : "
                    + (outcome != null ? outcome : "null")
                    + (exception != null ? " [ " + exception.toString() + " ]":" ]");
            }
            
            public boolean executeTest() {
                DTM ts = new DTM(myMessage);
                try {
                    ts.setValue(value);
                    String retval = ts.getValue();
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
            new TestSpec("\"\"","\"\""),
            //year
            new TestSpec("0", DataTypeException.class),
            new TestSpec("1", DataTypeException.class),
            new TestSpec("19", DataTypeException.class),
            new TestSpec("198", DataTypeException.class),
            new TestSpec("1984", "1984"),
            //year & time zone
            new TestSpec("1984-1", DataTypeException.class),
            new TestSpec("1984-11", DataTypeException.class),
            new TestSpec("1984-111", DataTypeException.class),
            //new TestSpec("1984-0060", DataTypeException.class),
            new TestSpec("1984-0059", "1984-0059"),
            new TestSpec("1984-0001", "1984-0001"),
            //new TestSpec("1984-0000", "1984+0000"),
            new TestSpec("1984+0000", "1984+0000"),
            new TestSpec("1984+0001", "1984+0001"),
            new TestSpec("1984+0059", "1984+0059"),
            //new TestSpec("1984+0060", DataTypeException.class),
            new TestSpec("1984+11111", DataTypeException.class),
            //month
            new TestSpec("19840", DataTypeException.class),
            //new TestSpec("198400", DataTypeException.class),
            new TestSpec("198401", "198401"),
            new TestSpec("198412", "198412" ),
            //new TestSpec("198413", DataTypeException.class),
            //month & time zone
            new TestSpec("198401-1", DataTypeException.class),
            new TestSpec("198401-11", DataTypeException.class),
            new TestSpec("198401-111", DataTypeException.class),
            //new TestSpec("198401-0060", DataTypeException.class),
            new TestSpec("198401-0059", "198401-0059"),
            new TestSpec("198401-0001", "198401-0001"),
            //new TestSpec("198401-0000", "198401+0000"),
            new TestSpec("198401+0000", "198401+0000"),
            new TestSpec("198401+0001", "198401+0001"),
            new TestSpec("198401+0059", "198401+0059"),
            //new TestSpec("198401+0060", DataTypeException.class),
            new TestSpec("198401+11111", DataTypeException.class),
            //day
            new TestSpec("1984010", DataTypeException.class),
            //new TestSpec("19840100", DataTypeException.class),
            new TestSpec("19840101", "19840101"),
            new TestSpec("19840131", "19840131"),
            //new TestSpec("19840132", DataTypeException.class),
            //day & time zone
            new TestSpec("19840101-1", DataTypeException.class),
            new TestSpec("19840101-11", DataTypeException.class),
            new TestSpec("19840101-111", DataTypeException.class),
            //new TestSpec("19840101-0060", DataTypeException.class),
            new TestSpec("19840101-0059", "19840101-0059"),
            new TestSpec("19840101-0001", "19840101-0001"),
            //new TestSpec("19840101-0000", "19840101+0000"),
            new TestSpec("19840101+0000", "19840101+0000"),
            new TestSpec("19840101+0001", "19840101+0001"),
            new TestSpec("19840101+0059", "19840101+0059"),
            //new TestSpec("19840101+0060", DataTypeException.class),
            new TestSpec("19840101+11111", DataTypeException.class),
            //hour
            new TestSpec("198401011", DataTypeException.class),
            new TestSpec("1984010111", "1984010111"),
            new TestSpec("19840101111", DataTypeException.class),
            new TestSpec("198401010000", "198401010000"),
            new TestSpec("198401010100", "198401010100"),
            new TestSpec("198401012300", "198401012300"),
            //new TestSpec("198401012400", DataTypeException.class),
            new TestSpec("1984010123001", DataTypeException.class),
            //minute
            new TestSpec("19840101000", DataTypeException.class),
            new TestSpec("198401010000", "198401010000"),
            new TestSpec("198401010001", "198401010001"),
            new TestSpec("198401010059", "198401010059"),
            //new TestSpec("198401010060", DataTypeException.class),
            //hour/minute & time zone
            new TestSpec("198401010000-1", DataTypeException.class),
            new TestSpec("198401010000-11", DataTypeException.class),
            new TestSpec("198401010000-111", DataTypeException.class),
            //new TestSpec("198401010000-0060", DataTypeException.class),
            new TestSpec("198401010000-0059", "198401010000-0059"),
            new TestSpec("198401010000-0001", "198401010000-0001"),
            //new TestSpec("198401010000-0000", "198401010000+0000"),
            new TestSpec("198401010000+0000", "198401010000+0000"),
            new TestSpec("198401010000+0001", "198401010000+0001"),
            new TestSpec("198401010000+0059", "198401010000+0059"),
            //new TestSpec("198401010000+0060", DataTypeException.class),
            new TestSpec("198401010000+11111", DataTypeException.class),
            //seconds
            new TestSpec("1984010100000", DataTypeException.class),
            new TestSpec("19840101000000", "19840101000000"),
            new TestSpec("19840101000001", "19840101000001"),
            new TestSpec("19840101000059", "19840101000059"),
            //new TestSpec("19840101000060", DataTypeException.class),
            //seconds & time zone
            new TestSpec("19840101000000-1", DataTypeException.class),
            new TestSpec("19840101000000-11", DataTypeException.class),
            new TestSpec("19840101000000-111", DataTypeException.class),
            //new TestSpec("19840101000000-0060", DataTypeException.class),
            new TestSpec("19840101000000-0059", "19840101000000-0059"),
            new TestSpec("19840101000000-0001", "19840101000000-0001"),
            //new TestSpec("19840101000000-0000", "19840101000000+0000"),
            new TestSpec("19840101000000+0000", "19840101000000+0000"),
            new TestSpec("19840101000000+0001", "19840101000000+0001"),
            new TestSpec("19840101000000+0059", "19840101000000+0059"),
            //new TestSpec("19840101000000+0060", DataTypeException.class),
            new TestSpec("19840101000000+11111", DataTypeException.class),
            //milliseconds
            new TestSpec("19840101000000.", DataTypeException.class),
            new TestSpec("19840101000000.0", "19840101000000.0"),
            new TestSpec("19840101000000.00", "19840101000000.00"),
            new TestSpec("19840101000000.000", "19840101000000.000"),
            new TestSpec("19840101000000.0000", "19840101000000.0000"),
            new TestSpec("19840101000000.0001", "19840101000000.0001"),
            new TestSpec("19840101000000.9999", "19840101000000.9999"),
            new TestSpec("19840101000000.00000", DataTypeException.class),
            //milliseconds & time zone
            new TestSpec("19840101000000.0-1", DataTypeException.class),
            new TestSpec("19840101000000.0-11", DataTypeException.class),
            new TestSpec("19840101000000.0-111", DataTypeException.class),
            //new TestSpec("19840101000000.0-0060", DataTypeException.class),
            new TestSpec("19840101000000.0-0059", "19840101000000.0-0059"),
            new TestSpec("19840101000000.0-0001", "19840101000000.0-0001"),
            //new TestSpec("19840101000000.0-0000", "19840101000000.0+0000"),
            new TestSpec("19840101000000.0+0000", "19840101000000.0+0000"),
            new TestSpec("19840101000000.00+0000", "19840101000000.00+0000"),
            new TestSpec("19840101000000.000+0000", "19840101000000.000+0000"),
            new TestSpec("19840101000000.0000+0000", "19840101000000.0000+0000"),
            new TestSpec("19840101000000.0+0001", "19840101000000.0+0001"),
            new TestSpec("19840101000000.0+0059", "19840101000000.0+0059"),
            //new TestSpec("19840101000000.0+0060", DataTypeException.class),
            new TestSpec("19840101000000.0+11111", DataTypeException.class),
        };
        
        ArrayList<Object> failedTests = new ArrayList<Object>();

        for (int i = 0; i < tests.length ; i++) {
            if ( ! tests[ i ].executeTest() ) 
                failedTests.add( tests[ i ] );
        }

        assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }
    
    /**
     * @throws Exception ... 
     */
    @Test    
    public void testTN() throws Exception {
        //adapted from CommonTNTest ... 
        class TestSpec {
            String value;
            Object outcome;
            Exception exception = null;
            
            TestSpec(String value, Object outcome) {
                this.value = value;
                this.outcome = outcome;
            }
            
            public String toString() {
                return "[ " + (value != null ? value : "null") + " : "
                    + (outcome != null ? outcome : "null")
                    + (exception != null ? " [ " + exception.toString() + " ]":" ]");
            }
            
            public boolean executeTest() {
                try {
                    TN tn = new TN(myMessage);
                    tn.setValue(value);
                    String retval = tn.getValue();
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
            //number
            new TestSpec(null,null),
            new TestSpec("", ""),
            new TestSpec("\"\"","\"\""),
            new TestSpec("(", DataTypeException.class),
            new TestSpec("(7", DataTypeException.class),
            new TestSpec("(70", DataTypeException.class),
            new TestSpec("(705", DataTypeException.class),
            new TestSpec("(705)", DataTypeException.class),
            new TestSpec("(705)2", DataTypeException.class),
            new TestSpec("(705)26", DataTypeException.class),
            new TestSpec("(705)267", DataTypeException.class),
            new TestSpec("(705)267-", DataTypeException.class),
            new TestSpec("(705)267-2", DataTypeException.class),
            new TestSpec("(705)267-21", DataTypeException.class),
            new TestSpec("(705)267-213", DataTypeException.class),
            new TestSpec("(705)267-2131", "(705)267-2131"),
            new TestSpec("(705)267-21312", DataTypeException.class),
            new TestSpec("1 (705)267-2131", "1 (705)267-2131"),
            new TestSpec("12 (705)267-2131", "12 (705)267-2131"),
            //new TestSpec("123 (705)267-2131", "123 (705)267-2131"),
            new TestSpec("123 (705)267-2131", DataTypeException.class),
            new TestSpec("1234 (705)267-2131", DataTypeException.class),
            //extensions
            new TestSpec("(705)267-2131X", DataTypeException.class),
            new TestSpec("1 (705)267-2131X2", "1 (705)267-2131X2"),
            new TestSpec("12 (705)267-2131X2", "12 (705)267-2131X2"),
            //new TestSpec("123 (705)267-2131X2", "123 (705)267-2131X2"),
            new TestSpec("1234 (705)267-2131X2", DataTypeException.class),
            new TestSpec("(705)267-2131X23", "(705)267-2131X23"),
            new TestSpec("(705)267-2131X234", "(705)267-2131X234"),
            new TestSpec("(705)267-2131X2345", "(705)267-2131X2345"),
            new TestSpec("(705)267-2131X23456", "(705)267-2131X23456"),
            new TestSpec("(705)267-2131X234567", DataTypeException.class),
            new TestSpec("1 (705)267-2131X23456", "1 (705)267-2131X23456"),
            new TestSpec("12 (705)267-2131X23456", "12 (705)267-2131X23456"),
            //new TestSpec("123 (705)267-2131X23456", "123 (705)267-2131X23456"),
            new TestSpec("1234 (705)267-2131X23456", DataTypeException.class),
            //beeper
            new TestSpec("(705)267-2131B", DataTypeException.class),
            new TestSpec("(705)267-2131B1", "(705)267-2131B1"),
            new TestSpec("1 (705)267-2131B1", "1 (705)267-2131B1"),
            new TestSpec("12 (705)267-2131B1", "12 (705)267-2131B1"),
            //new TestSpec("123 (705)267-2131B1", "123 (705)267-2131B1"),
            new TestSpec("1234 (705)267-2131B1", DataTypeException.class),
            new TestSpec("(705)267-2131B12", "(705)267-2131B12"),
            new TestSpec("(705)267-2131B123", "(705)267-2131B123"),
            new TestSpec("(705)267-2131B1234", "(705)267-2131B1234"),
            new TestSpec("(705)267-2131B123456", DataTypeException.class),
            new TestSpec("1 (705)267-2131B12345", "1 (705)267-2131B12345"),
            new TestSpec("12 (705)267-2131B12345", "12 (705)267-2131B12345"),
            //new TestSpec("123 (705)267-2131B12345", "123 (705)267-2131B12345"),
            new TestSpec("1234 (705)267-2131B12345", DataTypeException.class),
            //comment
            //new TestSpec("(705)267-2131C", DataTypeException.class),
            new TestSpec("(705)267-2131C Test", "(705)267-2131C Test"),
            new TestSpec("(705)267-2131CRreally long text", "(705)267-2131CRreally long text"),
            new TestSpec("1 (705)267-2131C Test", "1 (705)267-2131C Test"),
            new TestSpec("12 (705)267-2131C Test", "12 (705)267-2131C Test"),
            //new TestSpec("123 (705)267-2131C Test", "123 (705)267-2131C Test"),
            new TestSpec("1234 (705)267-2131C Test", DataTypeException.class),
            //extension and beeper
            new TestSpec("(705)267-2131X2345B", DataTypeException.class),
            new TestSpec("(705)267-2131X2345B1", "(705)267-2131X2345B1"),
            new TestSpec("1 (705)267-2131X2345B1", "1 (705)267-2131X2345B1"),
            new TestSpec("12 (705)267-2131X2345B1", "12 (705)267-2131X2345B1"),
            //new TestSpec("123 (705)267-2131X2345B1", "123 (705)267-2131X2345B1"),
            new TestSpec("1234 (705)267-2131X2345B1", DataTypeException.class),
            new TestSpec("(705)267-2131X2345B12", "(705)267-2131X2345B12"),
            new TestSpec("(705)267-2131X2345B123", "(705)267-2131X2345B123"),
            new TestSpec("(705)267-2131X2345B1234", "(705)267-2131X2345B1234"),
            new TestSpec("(705)267-2131X2345B123456", DataTypeException.class),
            new TestSpec("1 (705)267-2131X2345B12345", "1 (705)267-2131X2345B12345"),
            new TestSpec("12 (705)267-2131X2345B12345", "12 (705)267-2131X2345B12345"),
            //new TestSpec("123 (705)267-2131X2345B12345", "123 (705)267-2131X2345B12345"),
            new TestSpec("1234 (705)267-2131X2345B12345", DataTypeException.class),
            //extension and comment
            //new TestSpec("(705)267-2131X2345C", DataTypeException.class),
            new TestSpec("(705)267-2131X2345C Test", "(705)267-2131X2345C Test"),
            new TestSpec("(705)267-2131X2345CRreally long text", "(705)267-2131X2345CRreally long text"),
            new TestSpec("1 (705)267-2131X2345C Test", "1 (705)267-2131X2345C Test"),
            new TestSpec("12 (705)267-2131X2345C Test", "12 (705)267-2131X2345C Test"),
            //new TestSpec("123 (705)267-2131X2345C Test", "123 (705)267-2131X2345C Test"),
            new TestSpec("1234 (705)267-2131X2345C Test", DataTypeException.class),
            //beeper and comment
            //new TestSpec("(705)267-2131B1234C", DataTypeException.class),
            new TestSpec("(705)267-2131B1234C Test", "(705)267-2131B1234C Test"),
            new TestSpec("(705)267-2131B1234CRreally long text", "(705)267-2131B1234CRreally long text"),
            new TestSpec("1 (705)267-2131B1234C Test", "1 (705)267-2131B1234C Test"),
            new TestSpec("12 (705)267-2131B1234C Test", "12 (705)267-2131B1234C Test"),
            //new TestSpec("123 (705)267-2131B1234C Test", "123 (705)267-2131B1234C Test"),
            new TestSpec("1234 (705)267-2131B1234C Test", DataTypeException.class),
            //extension, beeper, and comment
            //new TestSpec("(705)267-2131X2345B1234C", DataTypeException.class),
            new TestSpec("(705)267-2131X2345B1234C Test", "(705)267-2131X2345B1234C Test"),
            new TestSpec("(705)267-2131X2345B1234CRreally long text", "(705)267-2131X2345B1234CRreally long text"),
            new TestSpec("1 (705)267-2131X2345B1234C Test", "1 (705)267-2131X2345B1234C Test"),
            new TestSpec("12 (705)267-2131X2345B1234C Test", "12 (705)267-2131X2345B1234C Test"),
            //new TestSpec("123 (705)267-2131X2345B1234C Test", "123 (705)267-2131X2345B1234C Test"),
            new TestSpec("1234 (705)267-2131X2345B1234C Test", DataTypeException.class),
        };
        
        ArrayList<Object> failedTests = new ArrayList<Object>();

        for (int i = 0; i < tests.length ; i++) {
            if ( ! tests[ i ].executeTest() ) 
                failedTests.add( tests[ i ] );
        }

        assertEquals("Failures: " + failedTests, 0, failedTests.size()); 
    }
    
    /**
     * @throws Exception ... 
     */
    @Test    
    public void testNM() throws Exception {
        //adapted from CommonNMTest ...  

        class TestSpec {
            String value;
            Object outcome;
            Exception exception = null;

            TestSpec(String value, Object outcome) {
                this.value = value;
                this.outcome = outcome;
            }

            public String toString() {
                return "[ " + value + " : "
                    + (outcome != null ? outcome : "null")
                    + (exception != null ? " [ " + exception.toString() + " ]" : " ]");
            }

            public boolean executeTest() {
                NM nm = new NM(myMessage);
                try {
                    nm.setValue(value);
                    String retval = nm.getValue();
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
        } //inner class

        TestSpec[] tests =
            {
                new TestSpec(null, null),
                new TestSpec("", ""),
                new TestSpec("\"\"", "\"\""),
                new TestSpec("\"\"","\"\""),
                new TestSpec("-1234567.8901", "-1234567.8901"),
                new TestSpec("-1234567.890", "-1234567.890"),
                new TestSpec("-1234567.89", "-1234567.89"),
                new TestSpec("-1234567.8", "-1234567.8"),
                new TestSpec("-1234567.", "-1234567."),
                new TestSpec("-1234567", "-1234567"),
                new TestSpec("-123456", "-123456"),
                new TestSpec("-12345", "-12345"),
                new TestSpec("-1234", "-1234"),
                new TestSpec("-123", "-123"),
                new TestSpec("-12", "-12"),
                new TestSpec("-1", "-1"),
                new TestSpec("-0", "-0"),
                new TestSpec("+0", "+0"),
                new TestSpec("0", "0"),
                new TestSpec("+1", "+1"),
                new TestSpec("12", "12"),
                new TestSpec("123", "123"),
                new TestSpec("1234", "1234"),
                new TestSpec("12345", "12345"),
                new TestSpec("123456", "123456"),
                new TestSpec("1234567", "1234567"),
                new TestSpec("1234567.", "1234567."),
                new TestSpec("1234567.8", "1234567.8"),
                new TestSpec("1234567.89", "1234567.89"),
                new TestSpec("1234567.890", "1234567.890"),
                new TestSpec("1234567.8901", "1234567.8901"),
                new TestSpec("+1234567.8901", "+1234567.8901"),
                new TestSpec("-12.a34", DataTypeException.class),
                new TestSpec("TEST", DataTypeException.class),
                };

        ArrayList<Object> failedTests = new ArrayList<Object>();

        for (int i = 0; i < tests.length; i++) {
            if (!tests[i].executeTest())
                failedTests.add(tests[i]);
        }

        assertEquals("Failures: " + failedTests, 0, failedTests.size());
        
    }
    
    /**
     * @throws Exception ... 
     */
    @Test    
    public void testSI() throws Exception {
        assertSIOK(null);
        assertSIOK("");
        assertSIOK("\"\"");
        assertSIOK("1");
        assertSIOK("12");
        assertSIOK("123");
        
        assertSIBad("-1");
        assertSIBad("-2");
        assertSIBad("1.1");
        assertSIBad("-1.1");
        assertSIBad("NaN");
    }
    
    private void assertSIOK(String value) throws Exception {
        SI si = new SI(myMessage);
        si.setValue(value);
    }
    
    private void assertSIBad(String value) throws Exception {
        try {
            SI si = new SI(myMessage);
            si.setValue(value);         
            fail("Should fail with value " + value);
        } catch (DataTypeException e) {}
    }
    
    /**
     * Make sure invalid DTs fail correctly, in response to a report from Serbulent Unsal.
     */
    @Test    
    public void testValidateTSComponentOne() {
        String validMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|something wrong here ||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
             + "EVN|A31|200903230934\r\n"
             + "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";
        
        PipeParser pipeParser = new DefaultHapiContext().getPipeParser();
        try {
            pipeParser.parse(validMessage);
            fail("Parsed successfully despite invalid date");
        } catch (EncodingNotSupportedException e) {
            // expected
        } catch (HL7Exception e) {
            // expected
        }
        
        
    }
    
}
