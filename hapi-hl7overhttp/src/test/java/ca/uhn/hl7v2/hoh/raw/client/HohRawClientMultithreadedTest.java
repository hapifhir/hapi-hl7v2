package ca.uhn.hl7v2.hoh.raw.client;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.llp.ServerSocketThreadForTesting;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;

public class HohRawClientMultithreadedTest {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohRawClientMultithreadedTest.class);
	private static int myPort;
	private static Hl7OverHttpLowerLayerProtocol myLlp;
	private static SingleCredentialServerCallback ourServerCallback;
	private static ServerSocketThreadForTesting myServerSocketThread;

	@Test
	public void testSendMessageSimple() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientMultithreaded client = new HohRawClientMultithreaded("localhost", myPort, "/theUri");
		client.setSocketTimeout(500);
		
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));

		/*
		 * Send one message
		 */
		ourLog.info("*** Send message #1");
		
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(1, myServerSocketThread.getConnectionCount());
		
		
		/*
		 * Send a second message
		 */
		ourLog.info("*** Send message #2");
		
		response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(1, myServerSocketThread.getConnectionCount());

		Thread.sleep(1000);
		
		/*
		 * Send a third message
		 */
		ourLog.info("*** Send message #3");
		
		response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(2, myServerSocketThread.getConnectionCount());

	}

	@Test
	public void testSendMessageAndRespectCloseHeaderInResponse() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientMultithreaded client = new HohRawClientMultithreaded("localhost", myPort, "/theUri");
		client.setSocketTimeout(500);
		
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));

		myServerSocketThread.setCloseNormallyWithHeaderAfterEachMessage();
		
		/*
		 * Send one message
		 */
		ourLog.info("*** Send message #1");
		
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(1, myServerSocketThread.getConnectionCount());
		
		
		/*
		 * Send a second message
		 */
		ourLog.info("*** Send message #2");
		
		response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(2, myServerSocketThread.getConnectionCount());

		Thread.sleep(1000);
		
		/*
		 * Send a third message
		 */
		ourLog.info("*** Send message #3");
		
		response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(3, myServerSocketThread.getConnectionCount());

	}

	@Test
	public void testSendMessageWithNoTimeout() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientMultithreaded client = new HohRawClientMultithreaded("localhost", myPort, "/theUri");
		client.setSocketTimeout(-1);
		
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));

		/*
		 * Send one message
		 */
		ourLog.info("*** Send message #1");
		
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(1, myServerSocketThread.getConnectionCount());
		
		Thread.sleep(1000);
		
		/*
		 * Send a third message
		 */
		ourLog.info("*** Send message #2");
		
		response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(1, myServerSocketThread.getConnectionCount());

	}

	@Test
	public void testReconnectAutomaticallyAfterUnexpectedClose() throws Exception {
		myServerSocketThread.setCloseUnexpectedlyAfterEachMessage();
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientMultithreaded client = new HohRawClientMultithreaded("localhost", myPort, "/theUri");
		client.setSocketTimeout(1000);
		
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));

		/*
		 * Send one message
		 */
		ourLog.info("*** Send message #1");
		
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(1, myServerSocketThread.getConnectionCount());
		
		Thread.sleep(100);
		
		/*
		 * Send a third message
		 */
		ourLog.info("*** Send message #2");
		
		try {
			response = client.sendAndReceive(new RawSendable(message));
		} catch (Exception e) {
			// We're allowed to fail once
		}
		
		// This try should succeed again
		response = client.sendAndReceive(new RawSendable(message));
		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());
		assertEquals(2, myServerSocketThread.getConnectionCount());

	}
	@After
	public void after() throws InterruptedException {
		ourLog.info("Marking done as true");
		myServerSocketThread.done();
	}

	@Before
	public void before() throws InterruptedException {
		myPort = RandomServerPortProvider.findFreePort();

		myLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		myLlp.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		myServerSocketThread = new ServerSocketThreadForTesting(myPort, ourServerCallback);
		myServerSocketThread.start();
		myServerSocketThread.getLatch().await();
	}

}
