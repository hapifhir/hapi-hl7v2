/*
 * Created on 28-Apr-2004
 */
package ca.uhn.hl7v2.preparser;

import java.io.UnsupportedEncodingException;

import ca.uhn.hl7v2.HL7Exception;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests of PreParser with ER7-encoded messages.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:52 $ by $Author:
 *          jamesagnew $
 */
public class PreParserER7Test extends TestCase {

	private String myMessage;

	/**
	 * Constructor for PreParserTest.
	 * 
	 * @param arg0
	 */
	public PreParserER7Test(String arg0) {
		super(arg0);
		myMessage = "MSH|^~\\&|x|x|x|x|199904140038||ADT^A01||P|2.2\r" + "PID|||||Smith&Booth&Jones^X^Y\r" + "NTE|a||one~two~three\r" + "NTE|b||four\r";
	}

	public static Test suite() {
		TestSuite suite = new TestSuite(PreParserER7Test.class);
		return suite;
	}

	public void testFirstSegmentRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE(0)-1" });
		assertEquals("a", result[0]);
	}

	public void testSecondSegmentRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE(1)-1" });
		assertEquals("b", result[0]);
	}

	public void testFirstFieldRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE-3(0)" });
		assertEquals("one", result[0]);
	}

	public void testSecondFieldRep() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "NTE-3(1)" });
		assertEquals("two", result[0]);
	}

	public void testFirstCompSubcompInexplicit() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "PID-5" });
		assertEquals("Smith", result[0]);
	}

	public void testFirstCompSubcompExplicit() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "PID-5-1-1" });
		assertEquals("Smith", result[0]);
	}

	public void testSecondComp() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "MSH-9-2" });
		assertEquals("A01", result[0]);
	}

	public void testSecondSubcomp() throws Exception {
		String[] result = PreParser.getFields(myMessage, new String[] { "PID-5-1-2" });
		assertEquals("Booth", result[0]);
	}

}
