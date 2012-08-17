package ca.uhn.hl7v2.hoh.llp;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSignerTest;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.PipeParser;

public class LlpClientTest {

	private static Hl7OverHttpLowerLayerProtocol ourLlp;
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(LlpClientTest.class);
	private static int ourPort;
	private static SingleCredentialServerCallback ourServerCallback;
	private static ServerSocketThreadForTesting ourServerSocketThread;
	private static ExecutorService ourExecutor;

	// TODO: add test to ensure that XML encoding works

	@Test
	public void testSendMessageSimple() throws Exception {
		setUpTest();
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		Connection conn;
		try {
			DefaultHapiContext context = new DefaultHapiContext();
			context.setExecutorService(ourExecutor);
			ConnectionHub connectionHub = context.getConnectionHub();
			PipeParser pipeParser = PipeParser.getInstanceWithNoValidation();
			conn = connectionHub.attach("localhost", ourPort, pipeParser, ourLlp, false);
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " - " + RandomServerPortProvider.list().toString(), e);
		}
		Initiator initiator = conn.getInitiator();
		Message response = initiator.sendAndReceive(msg);

		ourLog.info("Received response");

		assertEquals(message, ourServerSocketThread.getMessage());
		assertEquals(ourServerSocketThread.getReply().encode(), response.encode());

	}

	@Test
	public void testSendMessageSimpleWithClientSigner() throws Exception {
//		ourLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
//		ourLlp.setSigner(BouncyCastleCmsMessageSignerTest.createSigner());
//		ourLlp.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));

		setUpTest();
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		Connection conn;
		try {
			DefaultHapiContext context = new DefaultHapiContext();
			context.setExecutorService(ourExecutor);
			ConnectionHub connectionHub = context.getConnectionHub();
			PipeParser pipeParser = PipeParser.getInstanceWithNoValidation();
			conn = connectionHub.attach("localhost", ourPort, pipeParser, ourLlp, false);
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " - " + RandomServerPortProvider.list().toString(), e);
		}
		Initiator initiator = conn.getInitiator();
		Message response = initiator.sendAndReceive(msg);

		ourLog.info("Received response");

		assertEquals(message, ourServerSocketThread.getMessage());
		assertEquals(ourServerSocketThread.getReply().encode(), response.encode());

	}

	@After
	public void after() throws InterruptedException {
		ourLog.info("Marking done as true");
		ourServerSocketThread.done();
		ourExecutor.shutdown();
	}

	@Before
	public void before() {
		ourLlp = null;
	}
	
	private void setUpTest() throws InterruptedException {
		ourPort = RandomServerPortProvider.findFreePort();
		ourLog.info("Port is: {}", ourPort);

		if (ourLlp == null) {
			ourLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
			ourLlp.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		}
		
		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		ourServerSocketThread = new ServerSocketThreadForTesting(ourPort, ourServerCallback);
		ourServerSocketThread.start();
		ourServerSocketThread.getLatch().await();
		
		ourExecutor = Executors.newCachedThreadPool();
		
	}

}
