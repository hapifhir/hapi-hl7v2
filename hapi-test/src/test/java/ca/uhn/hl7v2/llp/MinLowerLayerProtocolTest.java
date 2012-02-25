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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.app.TestUtils;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MinLowerLayerProtocol
 * 
 * @author Leslie Mann
 */
public class MinLowerLayerProtocolTest implements Application {
	private static final Logger ourLog = LoggerFactory.getLogger(MinLowerLayerProtocolTest.class);
	
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
	private int myMsgCount;


	/**
	 * @see TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		System.setProperty("ca.uhn.hl7v2.llp.logBytesRead", "FALSE");
		System.setProperty("ca.uhn.hl7v2.util.status.out", "");
		minLowerLayerProtocol = new MinLowerLayerProtocol();
		message = "This is a test HL7 message";
		llpEncodedMessage = (START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER).getBytes();
		inputStream = new ByteArrayInputStream(llpEncodedMessage);
		outputStream = new ByteArrayOutputStream();
		myMsgCount = 0;
	}

	/**
	 * @see TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
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
	@Test
	public void testConstructor() {
		assertNotNull("Should have a MinLowerLayerProtocol object", minLowerLayerProtocol);
	}

	/**
	 * Testing getReader
	 */
	@Test
	public void testGetReader() throws LLPException {
		HL7Reader reader = minLowerLayerProtocol.getReader(inputStream);
		assertNotNull("Should have a valid HL7Reader object", reader);
	}

	/**
	 * Testing getWriter
	 */
	@Test
	public void testGetWriter() throws LLPException {
		HL7Writer writer = minLowerLayerProtocol.getWriter(outputStream);
		assertNotNull("Should have a valid HL7Writer object", writer);
	}

	/**
	 * Testing subclass MakeLLP() method
	 */
	@Test
	public void testMakeLLP() {
		LowerLayerProtocol lowerLayerProtocol = MinLowerLayerProtocol.makeLLP();
		assertNotNull("Should have a valid LowerLayerProtocol object", lowerLayerProtocol);
	}
	
	@Test
	public void testReceiveWithDelayInBetween() throws Exception {

		int port = RandomServerPortProvider.findFreePort();
		SimpleServer server = new SimpleServer(port, new MinLowerLayerProtocol(), PipeParser.getInstanceWithNoValidation());
		server.registerApplication("*", "*", this);
		server.start();
		
		Socket socket = TestUtils.acquireClientSocket(port);
		MinLLPWriter w = new MinLLPWriter(socket.getOutputStream());
		MinLLPReader r = new MinLLPReader(socket.getInputStream());
		
		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		w.writeMessage(msg.encode());
		String resp = r.getMessage();
		ourLog.info(resp.replace("\r", "\n"));
		
		Thread.sleep(SimpleServer.SO_TIMEOUT + 500);
		
		msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		w.writeMessage(msg.encode());
		resp = r.getMessage();
		ourLog.info(resp.replace("\r", "\n"));
		
		assertEquals(2, myMsgCount);
		assertFalse(server.getRemoteConnections().isEmpty());

		socket.close();
		Thread.sleep(SimpleServer.SO_TIMEOUT + 500);
		assertTrue(server.getRemoteConnections().isEmpty());
	}
	
	public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {
		try {
			Message ack = theIn.generateACK();
			myMsgCount++;
			return ack;
		} catch (IOException e) {
			throw new HL7Exception(e);
		}
	}

	public boolean canProcess(Message theIn) {
		return true;
	}
	
	
	// Disabled, as we now use commons-logging
//	/**
//	 * Testing subclass LogCharacterReceived() method
//	 */
//	public void testLogCharacterReceived() {
//		int c = 'A';
//		
//		// Set properties to generate a status message
//		System.setProperty("ca.uhn.hl7v2.llp.logBytesRead", "TRUE");
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
//		MinLowerLayerProtocol.logCharacterReceived(c);
//
//		// reset System.out
//		System.setOut(oldOut);
//		// trim to remove \n at end of logging message
//		String statusMessage = statusMsgStream.toString().trim();
//
//		assertEquals("Should have character logging message", 
//     					"Char received: " + c + " (" + (char) c + ")", statusMessage);
//	}

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
