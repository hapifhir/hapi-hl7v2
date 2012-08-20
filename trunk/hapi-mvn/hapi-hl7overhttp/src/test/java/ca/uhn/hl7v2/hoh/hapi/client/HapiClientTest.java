package ca.uhn.hl7v2.hoh.hapi.client;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.llp.ServerSocketThreadForTesting;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.PipeParser;

public class HapiClientTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HapiClientTest.class);
	private static int ourPort;
	private static SingleCredentialServerCallback ourServerCallback;
	private static ServerSocketThreadForTesting ourServerSocketThread;

	@Test
	public void testSendMessageSimple() throws Exception {
		setUpTest();
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		HohClientSimple client = new HohClientSimple("localhost", ourPort, "/someuri", PipeParser.getInstanceWithNoValidation());
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		client.setAutoClose(true);
	
		IReceivable<Message> response = client.sendAndReceiveMessage(new MessageSendable(msg));
		ourLog.info("Received response");

		assertEquals(message, ourServerSocketThread.getMessage());
		assertEquals(ourServerSocketThread.getReply().encode(), response.getMessage().encode());

	}



	@After
	public void after() throws InterruptedException {
		ourLog.info("Marking done as true");
		ourServerSocketThread.done();
	}

	@Before
	public void before() {
		//nothing
	}
	
	private void setUpTest() throws InterruptedException {
		ourPort = RandomServerPortProvider.findFreePort();
		ourLog.info("Port is: {}", ourPort);

		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		ourServerSocketThread = new ServerSocketThreadForTesting(ourPort, ourServerCallback);
		ourServerSocketThread.start();
		ourServerSocketThread.getLatch().await();
		
	}

}
