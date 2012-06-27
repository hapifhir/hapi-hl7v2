/*
 * Created on 28-Apr-2004
 */
package ca.uhn.hl7v2.preparser;

import static org.junit.Assert.*;

/**
 * Unit tests of PreParser with ER7-encoded messages.
 */
public class PreParserER7MinDepsTest {

	@org.junit.Test
	public void testFirstSegmentRep() throws Exception {
		String msg = "MSH|^~\\&|x|x|x|x|199904140038||ADT^A01||P|2.2\r" + "PID|||||Smith&Booth&Jones^X^Y\r" + "NTE|a||one~two~three\r" + "NTE|b||four\r";
		String[] result = PreParser.getFields(msg, new String[] { "NTE(0)-1" });
		assertEquals("a", result[0]);
	}


}
