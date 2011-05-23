package ca.uhn.hl7v2.util;

import java.io.StringReader;

import ca.uhn.hl7v2.HL7Exception;

import junit.framework.TestCase;

public class Hl7InputStreamMessageIteratorTest extends TestCase {

	public void testMultipleMessages() throws HL7Exception {
		
        String message1 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102416|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message2 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102417|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message3 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102418|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";

        String fullText = message1 + "\n" + message2 + "\n" + message3;
        Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(new StringReader(fullText));
        
        assertTrue(iter.hasNext());
        assertEquals(message1, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message2, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message3, iter.next().encode());

        assertFalse(iter.hasNext());
        
	}

	
	public void testMultipleMessagesWithLeadingAndTrailingSpace() throws HL7Exception {
		
        String message1 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102416|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message2 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102417|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message3 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102418|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";

        String fullText = "          \n     " + message1 + "\n" + message2 + "\n" + message3 + "          \n     ";
        Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(new StringReader(fullText));
        
        assertTrue(iter.hasNext());
        assertEquals(message1, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message2, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message3, iter.next().encode());

        assertFalse(iter.hasNext());
        
	}

	public void testMultipleMessagesWithWindowsLineEndings() throws HL7Exception {
		
        String message1 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102416|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message2 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102417|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message3 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102418|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";

        String fullText = "          \n     " + message1 + "\n" + message2 + "\n" + message3 + "          \n     ";
        fullText = fullText.replace("\r", "\r\n");
        Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(new StringReader(fullText));
        
        assertTrue(iter.hasNext());
        assertEquals(message1, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message2, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message3, iter.next().encode());

        assertFalse(iter.hasNext());
        
	}

	
	public void testMultipleMessagesWithUnixLineEndings() throws HL7Exception {
		
        String message1 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102416|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message2 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102417|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message3 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102418|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";

        String fullText = "          \n     " + message1 + "\n" + message2 + "\n" + message3 + "          \n     ";
        fullText = fullText.replace("\r", "\n");
        Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(new StringReader(fullText));
        
        assertTrue(iter.hasNext());
        assertEquals(message1, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message2, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message3, iter.next().encode());

        assertFalse(iter.hasNext());
        
	}

	
	public void testMultipleMessagesWithMllpSeparators() throws HL7Exception {
		
        String message1 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102416|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message2 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102417|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";
		
        String message3 = "MSH|^~\\&|||||201004141020||ADT^A45^ADT_A45|102418|T|2.5\r"
            + "EVN|A45|201004141020\r"
            + "PID|1||7010226^^^4265^MR||Park^Green^^^MS.^^L\r"
            + "PV1|1|I||||^^^WP^1469\r";

        String fullText = "\u000b" + message1 + "\u001c\r\u000b" + message2 + "\u001c\r\u000b" + message3 + "\u001c\r\u000b";
        Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(new StringReader(fullText));
        
        assertTrue(iter.hasNext());
        assertEquals(message1, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message2, iter.next().encode());

        assertTrue(iter.hasNext());
        assertEquals(message3, iter.next().encode());

        assertFalse(iter.hasNext());
        
	}
	
}
