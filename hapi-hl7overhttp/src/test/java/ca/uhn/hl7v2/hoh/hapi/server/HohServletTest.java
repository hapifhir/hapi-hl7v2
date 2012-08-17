package ca.uhn.hl7v2.hoh.hapi.server;

import java.io.IOException;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.api.MessageProcessingException;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

public class HohServletTest {

	private static DefaultHapiContext ourHapiContext;

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohServletTest.class);
	private static ConnectionHub ouronnectionHub;
	private String myExpectedPassword;
	private String myExpectedUri;
	private String myExpectedUsername;
	private String myLastMessage;
	private String myLastResponse;
	private int myPort;
	private Server myServer;
	@After
	public void after() throws Exception {
		myServer.stop();
	}

	// TODO: Add test to make sure that client encoding and charset get respected in response
	

	public IResponseSendable<String> messageReceived(IReceivable<String> theMessage) throws MessageProcessingException {
		
		myLastMessage = theMessage.getMessage();
		try {
			myLastResponse = PipeParser.getInstanceWithNoValidation().parse(myLastMessage).generateACK().encode();
			return new RawSendable(myLastResponse);
		} catch (EncodingNotSupportedException e) {
			throw new MessageProcessingException(e);
		} catch (HL7Exception e) {
			throw new MessageProcessingException(e);
		} catch (IOException e) {
			throw new MessageProcessingException(e);
		}
		
	}
	
	
	public void startServer(HohServlet theServlet) throws Exception {
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
		ReceivingApplication app = new MyReceivingApp();
		HohServlet servlet = new HohServlet();
		servlet.setApplication(app);
		startServer(servlet);
		
		ADT_A05 msg = new ADT_A05();
		msg.initQuickstart("ADT", "A05", "T");
		Connection conn = ouronnectionHub.attach("localhost", myPort, PipeParser.getInstanceWithNoValidation(), new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT), false);
		Message response = conn.getInitiator().sendAndReceive(msg);
		
		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);
		
		Assert.assertEquals(myLastResponse, responseStr);
		Assert.assertEquals(msg.encode(), myLastMessage);
		
	}
	
	@AfterClass
	public static void afterClass() throws InterruptedException {
//		Thread.sleep(1000000);
		ourHapiContext.getExecutorService().shutdown();
	}

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("DEBUG", "true");
		
		ourHapiContext = new DefaultHapiContext();
		ouronnectionHub = ourHapiContext.getConnectionHub();
	}

	public class MyReceivingApp implements ReceivingApplication {

		public boolean canProcess(Message theMessage) {
			return true;
		}

		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			myLastMessage = theMessage.encode();
			
			Message response;
			try {
				response = theMessage.generateACK();
			} catch (IOException e) {
				throw new ReceivingApplicationException(e);
			}
			myLastResponse = response.encode();
			
			return response;
		}

	}

}
