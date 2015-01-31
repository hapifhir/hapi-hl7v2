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
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.llp;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import static ca.uhn.hl7v2.llp.MllpConstants.*;
import static org.junit.Assert.*;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MinLowerLayerProtocol
 * 
 * @author Leslie Mann
 */
public class MinLowerLayerProtocolTest implements ReceivingApplication<Message> {
	private static final Logger ourLog = LoggerFactory.getLogger(MinLowerLayerProtocolTest.class);


	private MinLowerLayerProtocol minLowerLayerProtocol;
	private ByteArrayInputStream inputStream;
	private ByteArrayOutputStream outputStream;
	private String message;
	private byte [] llpEncodedMessage;
	private int myMsgCount;


	@Before
	public void setUp() throws Exception {
		System.setProperty("ca.uhn.hl7v2.llp.logBytesRead", "FALSE");
		System.setProperty("ca.uhn.hl7v2.util.status.out", "");
		minLowerLayerProtocol = new MinLowerLayerProtocol();
		message = "This is a test HL7 message";
		llpEncodedMessage = (START_BYTE + message + END_BYTE1 + END_BYTE2).getBytes();
		inputStream = new ByteArrayInputStream(llpEncodedMessage);
		outputStream = new ByteArrayOutputStream();
		myMsgCount = 0;
	}

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
	
	@Test
	public void testReceiveWithDelayInBetween() throws Exception {

        HapiContext context = new DefaultHapiContext();
		int port = RandomServerPortProvider.findFreePort();
		HL7Service server = context.newServer(port, false);
		server.registerApplication("*", "*", this);
		server.startAndWait();

        Connection c = context.newClient("127.0.0.1", port, false);
        Initiator initiator = c.getInitiator();

        ADT_A01 msg = new ADT_A01();
        msg.initQuickstart("ADT", "A01", "T");
        Message resp = initiator.sendAndReceive(msg);
        ourLog.info(resp.encode());

        Thread.sleep(SimpleServer.SO_TIMEOUT + 500);

        msg.initQuickstart("ADT", "A01", "T");
        resp = initiator.sendAndReceive(msg);
        ourLog.info(resp.encode());
		
		assertEquals(2, myMsgCount);
		assertFalse(server.getRemoteConnections().isEmpty());

		c.close();
		Thread.sleep(SimpleServer.SO_TIMEOUT + 500);
		assertTrue(server.getRemoteConnections().isEmpty());
	}
	
	public Message processMessage(Message theIn, Map<String, Object> metadata)
            throws ReceivingApplicationException, HL7Exception {
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
	
}
