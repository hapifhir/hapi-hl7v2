package ca.uhn.hl7v2.hoh.raw.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.llp.ServerSocketThreadForTesting;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.PipeParser;

public class HohRawClientSimpleTest {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohRawClientSimpleTest.class);
	private static int myPort;
	private static Hl7OverHttpLowerLayerProtocol myLlp;
	private static SingleCredentialServerCallback ourServerCallback;
	private static ServerSocketThreadForTesting myServerSocketThread;
	private Level myExistingLogLevel;


	@Test
	public void testSendMessageSimple() throws Exception {
		LogManager.getRootLogger().setLevel((Level)Level.TRACE);

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientSimple client = new HohRawClientSimple("localhost", myPort, "/theUri");
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));

		ourLog.info("Received response");

		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());

	}

	
	@Test
	public void testSendMessageAndRespectCloseHeaderInResponse() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientSimple client = new HohRawClientSimple("localhost", myPort, "/theUri");
		
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
	public void testUnderstandsGzippedResponse() throws Exception {
		LogManager.getRootLogger().setLevel((Level)Level.TRACE);

		myServerSocketThread.setGZipResponse(true);
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientSimple client = new HohRawClientSimple("localhost", myPort, "/theUri");
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));

		ourLog.info("Received response");

		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());

	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidUriRejected1() throws Exception {
		new HohRawClientSimple("localhost", 9999, "/uri space");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidUriRejected2() throws Exception {
		new HohRawClientSimple("localhost", 9999, "uri_with_no_starting_slash");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidUriRejected3() throws Exception {
		new HohRawClientSimple("localhost", 9999, "/uri_with_%_bad_char");
	}

	// TODO: add test with chunked encoding and additional trailing headers

	/**
	 * Ensure that if chunked transfer encoding is used, and there is a pause in
	 * the middle of transmission, the whole message is still read
	 */
	@Test
	public void testSendMessageWithChunkedResponseAndPauseInMiddle() throws Exception {

		myServerSocketThread.setSimulateOneSecondPauseInChunkedEncoding(true);

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientSimple client = new HohRawClientSimple("localhost", myPort, "/theUri");
		client.setSoTimeout(500);
		client.setResponseTimeout(2000);
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));

		ourLog.info("Received response");

		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());

	}

	/**
	 * Ensure that if chunked transfer encoding is used, and there is a pause in
	 * the middle of transmission, the whole message is still read
	 */
	@Test
	public void testSendMessageWithChunkedResponseAndPauseInMiddleWithLongSoTimeout() throws Exception {

		myServerSocketThread.setSimulateOneSecondPauseInChunkedEncoding(true);

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509|||||||||||||||||||||||||||||||||||||||||\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientSimple client = new HohRawClientSimple("localhost", myPort, "/theUri");
		client.setSoTimeout(980);
		client.setKeepAlive(false);
		client.setResponseTimeout(2000);
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));

		ourLog.info("Received response");

		assertEquals(message, myServerSocketThread.getMessage());
		assertEquals(myServerSocketThread.getReply().encode(), response.getMessage());

		assertEquals(EncodingStyle.ER7.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.ER7, myServerSocketThread.getEncoding());

	}

	@Test
	public void testSendMessageSimpleXml() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		message = new DefaultXMLParser().encode(PipeParser.getInstanceWithNoValidation().parse(message));

		HohRawClientSimple client = new HohRawClientSimple("localhost", myPort, "/theUri");
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		IReceivable<String> response = client.sendAndReceive(new RawSendable(message));

		ourLog.info("Received response");

		assertEquals(message, myServerSocketThread.getMessage());
		String responseMessage = response.getMessage();
		assertTrue(responseMessage, responseMessage.contains("<MSH>"));
		assertEquals(myServerSocketThread.getReply().encode(), responseMessage);

		assertEquals(EncodingStyle.XML.getContentType(), myServerSocketThread.getContentType());
		assertEquals(EncodingStyle.XML, myServerSocketThread.getEncoding());
	}

	@Test
	public void testCreateUsingUrl() throws MalformedURLException {

		HohRawClientSimple c = new HohRawClientSimple(new URL("http://somehost/"));
		assertEquals("somehost", c.getHost());
		assertEquals("/", c.getUriPath());
		assertEquals(80, c.getPort());

		c = new HohRawClientSimple(new URL("http://somehost:8888/"));
		assertEquals("somehost", c.getHost());
		assertEquals("/", c.getUriPath());
		assertEquals(8888, c.getPort());

		c = new HohRawClientSimple(new URL("http://somehost:8888/someuri/path/test.jsp"));
		assertEquals("somehost", c.getHost());
		assertEquals("/someuri/path/test.jsp", c.getUriPath());
		assertEquals(8888, c.getPort());

		c = new HohRawClientSimple(new URL("https://somehost/someuri/path/test.jsp"));
		assertEquals("somehost", c.getHost());
		assertEquals("/someuri/path/test.jsp", c.getUriPath());
		assertEquals(443, c.getPort());

	}

	@After
	public void after() throws InterruptedException {
		ourLog.info("Marking done as true");
		myServerSocketThread.done();
		
		// Restore the log level
		LogManager.getRootLogger().setLevel(myExistingLogLevel);
	}

	@Before
	public void before() throws InterruptedException {
		myExistingLogLevel = LogManager.getRootLogger().getLevel();

		myPort = RandomServerPortProvider.findFreePort();

		myLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		myLlp.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		myServerSocketThread = new ServerSocketThreadForTesting(myPort, ourServerCallback);
		myServerSocketThread.start();
		myServerSocketThread.getLatch().await();
	}
	
	


}
