package ca.uhn.hl7v2.hoh.hapi.server;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HohServletTest {

	private static DefaultHapiContext ourHapiContext;

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohServletTest.class);
	private static ConnectionHub ourConnectionHub;
	private String myMessage;
	private Message myResponse;
	private int myPort;
	private Server myServer;

	@After
	public void after() throws Exception {
		myServer.stop();
	}

	// TODO: Add test to make sure that client encoding and charset get respected in response
	

	@Before
	public void before() {
		myMessage = null;
		myResponse = null;
	}

	private void startServer(HohServlet theServlet) throws Exception {
		myServer = new Server(0);

		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(new ServletHolder(theServlet), "/*");

		myServer.setHandler(handler);
		myServer.start();

		while (myServer.isStarting()) {
			ourLog.info("Waiting for server to start...");
			Thread.sleep(100);
		}

		Connector[] connectors = myServer.getConnectors();
		assert connectors.length == 1;
		myPort = ((ServerConnector) (connectors[0])).getLocalPort();

	}

	@Test
	public void testServlet() throws Exception {
		ReceivingApplication<Message> app = new MyReceivingApp();
		HohServlet servlet = new HohServlet();
		servlet.setApplication(app);
		startServer(servlet);

		ADT_A05 msg = new ADT_A05();
		msg.initQuickstart("ADT", "A05", "T");
		msg.getPID().getPid5_PatientName(0).getXpn1_FamilyName().getFn1_Surname().setValue("I♥HAPI"); // needs
																										// utf-8
		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		llp.setHost("localhost");
		llp.setPreferredCharset(StandardCharsets.UTF_8);
		Connection conn = ourConnectionHub.attach("localhost", myPort, PipeParser.getInstanceWithNoValidation(), llp, false);
		Message response;
		conn.getInitiator().setTimeout(20000, TimeUnit.SECONDS);
		response = conn.getInitiator().sendAndReceive(msg);
		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);

		Assert.assertEquals(myResponse.encode(), responseStr);
		String expected = msg.encode();
		Assert.assertEquals(expected, myMessage);

	}

	@Test
	public void testServletAE() throws Exception {
		ReceivingApplication<Message> app = new MyReceivingApp();
		HohServlet servlet = new HohServlet();
		servlet.setApplication(app);
		startServer(servlet);

		ADT_A05 msg = new ADT_A05();
		msg.initQuickstart("ADT", "A05", "T");
		msg.getPID().getPid5_PatientName(0).getXpn1_FamilyName().getFn1_Surname().setValue("I♥HAPI"); // needs
																										// utf-8
		myResponse = msg.generateACK(AcknowledgmentCode.AE, new HL7Exception("dsfasfs"));
		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		llp.setHost("localhost");
		llp.setPreferredCharset(StandardCharsets.UTF_8);
		Connection conn = ourConnectionHub.attach("localhost", myPort, PipeParser.getInstanceWithNoValidation(), llp, false);
		Message response = conn.getInitiator().sendAndReceive(msg);

		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);

		Assert.assertEquals(myResponse.encode(), responseStr);
		Assert.assertEquals(msg.encode(), myMessage);

	}

	@Test
	public void testServletAR() throws Exception {
		ReceivingApplication<Message> app = new MyReceivingApp();
		HohServlet servlet = new HohServlet();
		servlet.setApplication(app);
		startServer(servlet);

		ADT_A05 msg = new ADT_A05();
		msg.initQuickstart("ADT", "A05", "T");
		msg.getPID().getPid5_PatientName(0).getXpn1_FamilyName().getFn1_Surname().setValue("I♥HAPI"); // needs
																										// utf-8
		myResponse = msg.generateACK(AcknowledgmentCode.AR, new HL7Exception("dsfasfs"));
		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		llp.setHost("localhost");
		llp.setPreferredCharset(StandardCharsets.UTF_8);
		Connection conn = ourConnectionHub.attach("localhost", myPort, PipeParser.getInstanceWithNoValidation(), llp, false);
		Message response = conn.getInitiator().sendAndReceive(msg);

		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);

		Assert.assertEquals(myResponse.encode(), responseStr);
		Assert.assertEquals(msg.encode(), myMessage);

	}

	@Test
	public void testServletXml() throws Exception {
		ReceivingApplication<Message> app = new MyReceivingApp();
		HohServlet servlet = new HohServlet();
		servlet.setApplication(app);
		startServer(servlet);

		ADT_A05 msg = new ADT_A05();
		msg.initQuickstart("ADT", "A05", "T");
		msg.getPID().getPid5_PatientName(0).getXpn1_FamilyName().getFn1_Surname().setValue("I♥HAPI"); // needs
																										// utf-8
		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		llp.setHost("localhost");
		llp.setPreferredCharset(StandardCharsets.UTF_8);
		Connection conn = ourConnectionHub.attach("localhost", myPort, DefaultXMLParser.getInstanceWithNoValidation(), llp, false);
		Message response = conn.getInitiator().sendAndReceive(msg);

		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);

		Assert.assertEquals(new DefaultXMLParser().encode(myResponse), responseStr);
		Assert.assertEquals(new DefaultXMLParser().encode(msg), myMessage);

	}

	@AfterClass
	public static void afterClass() {
		ourHapiContext.getExecutorService().shutdown();
	}

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("DEBUG", "true");

		ourHapiContext = new DefaultHapiContext();
		ourHapiContext.setValidationContext(ValidationContextFactory.noValidation());
		ourConnectionHub = ourHapiContext.getConnectionHub();
	}

	public class MyReceivingApp implements ReceivingApplication<Message> {

		@Override
		public boolean canProcess(Message theMessage) {
			return true;
		}

		@Override
		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			myMessage = theMessage.encode();

			ACK response;
			try {
				response = (ACK) theMessage.generateACK();
			} catch (IOException e) {
				throw new ReceivingApplicationException(e);
			}
			
			response.getMSA().getMsa3_TextMessage().setValue("I♥HAPI"); // needs utf-8
			
			if (myResponse == null) {
				myResponse = response;
			}

			myResponse.setParser(PipeParser.getInstanceWithNoValidation());
			
			return myResponse;
		}

	}

}
