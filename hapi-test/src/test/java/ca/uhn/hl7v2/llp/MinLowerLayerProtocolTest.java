/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MinLowerLayerProtocolTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.llp.MinLowerLayerProtocol"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  “GPL”), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.llp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MinLowerLayerProtocol
 * 
 * @author Leslie Mann
 */
public class MinLowerLayerProtocolTest extends TestCase {
    // NB: Per the minimal lower layer protocol.
	// character indicating the termination of an HL7 message
    private static final char END_MESSAGE = '\u001c'; 
    // character indicating the start of an HL7 message
    private static final char START_MESSAGE = '\u000b';
     // the final character of a message: a carriage return
    private static final char LAST_CHARACTER = 13;

	private MinLowerLayerProtocol minLowerLayerProtocol;
	private ByteArrayInputStream inputStream;
	private ByteArrayOutputStream outputStream;
	private String message;
	private byte [] llpEncodedMessage;


	/**
	 * Constructor for MinLowerLayerProtocolTest.
	 * @param testName
	 */
	public MinLowerLayerProtocolTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(MinLowerLayerProtocolTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		System.setProperty("ca.uhn.hl7v2.llp.logBytesRead", "FALSE");
		System.setProperty("ca.uhn.hl7v2.util.status.out", "");
		minLowerLayerProtocol = new MinLowerLayerProtocol();
		message = "This is a test HL7 message";
		llpEncodedMessage = (START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER).getBytes();
		inputStream = new ByteArrayInputStream(llpEncodedMessage);
		outputStream = new ByteArrayOutputStream();
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		minLowerLayerProtocol = null;
		message = null;
		llpEncodedMessage = null;
		inputStream = null;
		outputStream = null;
	}

	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */

	/**
	 * Testing default constructor
	 */
	public void testConstructor() {
		assertNotNull("Should have a MinLowerLayerProtocol object", minLowerLayerProtocol);
	}

	/**
	 * Testing getReader
	 */
	public void testGetReader() throws LLPException {
		HL7Reader reader = minLowerLayerProtocol.getReader(inputStream);
		assertNotNull("Should have a valid HL7Reader object", reader);
	}

	/**
	 * Testing getWriter
	 */
	public void testGetWriter() throws LLPException {
		HL7Writer writer = minLowerLayerProtocol.getWriter(outputStream);
		assertNotNull("Should have a valid HL7Writer object", writer);
	}

	/**
	 * Testing subclass MakeLLP() method
	 */
	public void testMakeLLP() {
		LowerLayerProtocol lowerLayerProtocol = MinLowerLayerProtocol.makeLLP();
		assertNotNull("Should have a valid LowerLayerProtocol object", lowerLayerProtocol);
	}

	/**
	 * Testing subclass LogCharacterReceived() method
	 */
	public void xtestLogCharacterReceived() {
		int c = 'A';
		
		// Set properties to generate a status message
		System.setProperty("ca.uhn.hl7v2.llp.logBytesRead", "TRUE");
		System.setProperty("ca.uhn.hl7v2.util.status.out", "");
	
		minLowerLayerProtocol = new MinLowerLayerProtocol();

		// redirect System.out
		ByteArrayOutputStream statusMsgStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(statusMsgStream);
		PrintStream oldOut = System.out;
		System.setOut(ps);

		MinLowerLayerProtocol.logCharacterReceived(c);

		// reset System.out
		System.setOut(oldOut);
		// trim to remove \n at end of logging message
		String statusMessage = statusMsgStream.toString().trim();

		assertEquals("Should have character logging message", 
     					"Char received: " + c + " (" + (char) c + ")", statusMessage);
	}

	/**
	 * Testing subclass LogCharacterReceived() method after
	 * setting property logBytesRead = FALSE
	 */
//  This test won't work because other instances of LowerLayerProtocol have probably been created 
//  in the past (this may not be the best design, but it's not a bug either).  
//	public void testLogCharacterReceivedLogCharsFalse() {
//		int c = 'A';
//		
//		// Set properties to generate a status message
//		System.setProperty("ca.uhn.hl7v2.llp.logBytesRead", "FALSE");
//		System.setProperty("ca.uhn.hl7v2.util.status.out", "");
//	
//		minLowerLayerProtocol = new MinLowerLayerProtocol();
//
//		// redirect System.out
//		ByteArrayOutputStream statusMsgStream = new ByteArrayOutputStream();
//		PrintStream ps = new PrintStream(statusMsgStream);
//		PrintStream oldOut = System.out;
//		System.setOut(ps);
//
//		minLowerLayerProtocol.logCharacterReceived(c);
//
//		// reset System.out
//		System.setOut(oldOut);
//		// trim to remove \n at end of logging message
//		String statusMessage = statusMsgStream.toString().trim();
//
//		assertEquals("Should not have a character logging message", "", statusMessage);
//	}
}
