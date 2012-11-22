/*
 * Created on 28-Apr-2004
 */
package ca.uhn.hl7v2.preparser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests of PreParser with ER7-encoded messages.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:52 $ by $Author:
 *          jamesagnew $
 */
public class PreParserER7Test  {

	private static final String myMessage = "MSH|^~\\&|x|x|x|x|199904140038||ADT^A01||P|2.2\r" + "PID|||||Smith&Booth&Jones^X^Y\r" + "NTE|a||one~two~three\r" + "NTE|b||four\r";

	@Test
	public void testFirstSegmentRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE(0)-1" });
		assertEquals("a", result[0]);
	}

    @Test
	public void testSecondSegmentRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE(1)-1" });
		assertEquals("b", result[0]);
	}

    @Test
	public void testFirstFieldRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE-3(0)" });
		assertEquals("one", result[0]);
	}

    @Test
	public void testSecondFieldRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE-3(1)" });
		assertEquals("two", result[0]);
	}

    @Test
	public void testFirstCompSubcompInexplicit() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "PID-5" });
		assertEquals("Smith", result[0]);
	}

    @Test
	public void testFirstCompSubcompExplicit() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "PID-5-1-1" });
		assertEquals("Smith", result[0]);
	}

    @Test
	public void testSecondComp() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "MSH-9-2" });
		assertEquals("A01", result[0]);
	}

    @Test
	public void testSecondSubcomp() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "PID-5-1-2" });
		assertEquals("Booth", result[0]);
	}

}
