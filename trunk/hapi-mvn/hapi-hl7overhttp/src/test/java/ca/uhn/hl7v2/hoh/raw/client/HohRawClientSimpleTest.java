package ca.uhn.hl7v2.hoh.raw.client;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.llp.ServerSocketThreadForTesting;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;

public class HohRawClientSimpleTest {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohRawClientSimpleTest.class);
	private static int ourPort;
	private static Hl7OverHttpLowerLayerProtocol ourLlp;
	private static SingleCredentialServerCallback ourServerCallback;
	private static ServerSocketThreadForTesting ourServerSocketThread;
	
	@Test
	public void testSendMessageSimple() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		HohRawClientSimple client = new HohRawClientSimple("localhost", ourPort, "/theUri");
		client.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		IReceivable<String> response = client.doSendAndReceive(new RawSendable(message));
		
		ourLog.info("Received response");

		assertEquals(message, ourServerSocketThread.getMessage());
		assertEquals(ourServerSocketThread.getReply().encode(), response.getMessage());

	}

	@AfterClass
	public static void afterClass() throws InterruptedException {
		ourLog.info("Marking done as true");
		ourServerSocketThread.done();
	}

	@BeforeClass
	public static void beforeClass() throws InterruptedException {
		ourPort = RandomServerPortProvider.findFreePort();

		ourLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		ourLlp.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		ourServerSocketThread = new ServerSocketThreadForTesting(ourPort, ourServerCallback);
		ourServerSocketThread.start();
		ourServerSocketThread.getLatch().await();
	}
	
}
