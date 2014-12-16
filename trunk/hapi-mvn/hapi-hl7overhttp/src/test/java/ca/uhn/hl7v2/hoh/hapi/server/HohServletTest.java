package ca.uhn.hl7v2.hoh.hapi.server;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

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
		myPort = RandomServerPortProvider.findFreePort();
		myServer = new Server(myPort);
		Context context = new Context(myServer, "/", Context.SESSIONS);
		context.addServlet(new ServletHolder(theServlet), "/*");

		myServer.start();

		while (myServer.isStarting()) {
			ourLog.info("Waiting for server to start...");
			Thread.sleep(100);
		}

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
		llp.setPreferredCharset(Charset.forName("UTF-8"));
		Connection conn = ourConnectionHub.attach("localhost", myPort, PipeParser.getInstanceWithNoValidation(), llp, false);
		Message response;
		try {
			conn.getInitiator().setTimeout(20000, TimeUnit.SECONDS);
			response = conn.getInitiator().sendAndReceive(msg);
		} catch (Exception e) {
			throw e;
		}
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
		llp.setPreferredCharset(Charset.forName("UTF-8"));
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
		llp.setPreferredCharset(Charset.forName("UTF-8"));
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
		llp.setPreferredCharset(Charset.forName("UTF-8"));
		Connection conn = ourConnectionHub.attach("localhost", myPort, DefaultXMLParser.getInstanceWithNoValidation(), llp, false);
		Message response = conn.getInitiator().sendAndReceive(msg);

		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);

		Assert.assertEquals(new DefaultXMLParser().encode(myResponse), responseStr);
		Assert.assertEquals(new DefaultXMLParser().encode(msg), myMessage);

	}

	@AfterClass
	public static void afterClass() throws InterruptedException {
		// Thread.sleep(1000000);
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

		public boolean canProcess(Message theMessage) {
			return true;
		}

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
