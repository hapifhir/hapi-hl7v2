package ca.uhn.hl7v2.hoh.server.raw;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.hoh.auth.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.server.MessageProcessingException;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;

public class Hl7OverHttpRawMessageServletTest implements IAuthorizationServerCallback, IRawMessageHandler {

	private static DefaultHapiContext ourHapiContext;
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7OverHttpRawMessageServletTest.class);
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
	
	public boolean authorize(String theUri, String theUsername, String thePassword) {
		if (myExpectedUsername == null) {
			return true;
		} else {
			if (!StringUtils.equals(myExpectedUri, theUri)) {
				return false;
			}
			if (!StringUtils.equals(myExpectedUsername, theUsername)) {
				return false;
			}
			if (!StringUtils.equals(myExpectedPassword, thePassword)) {
				return false;
			}
			return true;
		}
		
	}

	@Before
	public void before() throws Exception {
		myPort = RandomServerPortProvider.findFreePort();
		myServer = new Server(myPort);
		Context context = new Context(myServer, "/", Context.SESSIONS);
		Hl7OverHttpRawMessageServlet servlet = new Hl7OverHttpRawMessageServlet();
		servlet.setAuthorizationCallback(this);
		servlet.setMessageHandler(this);	
		context.addServlet(new ServletHolder(servlet), "/*");

		myServer.start();
		
		while (!myServer.isRunning()) {
			ourLog.info("Waiting for server to start...");
			Thread.sleep(100);
		}

	}

	public IRawMessageResponse messageReceived(IRawMessage theMessage) throws MessageProcessingException {
		
		myLastMessage = theMessage.getRawMessage();
		try {
			myLastResponse = PipeParser.getInstanceWithNoValidation().parse(myLastMessage).generateACK().encode();
			return new StringRawMessageResponse(myLastResponse);
		} catch (EncodingNotSupportedException e) {
			throw new MessageProcessingException(e);
		} catch (HL7Exception e) {
			throw new MessageProcessingException(e);
		} catch (IOException e) {
			throw new MessageProcessingException(e);
		}
		
	}
	
	@Test
	public void testServlet() throws Exception {

		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);
		
		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		Connection conn = ouronnectionHub.attach("localhost", myPort, PipeParser.getInstanceWithNoValidation(), llp);
		Message response = conn.getInitiator().sendAndReceive(msg);
		
		String responseStr = response.encode();
		ourLog.info("Got response: {}", responseStr);
		
		Assert.assertEquals(myLastResponse, responseStr);
		Assert.assertEquals(message, myLastMessage);
		
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

}
