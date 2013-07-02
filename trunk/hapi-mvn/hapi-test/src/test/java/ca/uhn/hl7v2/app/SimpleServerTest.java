package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.ServerConfiguration.ApplicationExceptionPolicy;
import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.protocol.MetadataKeys;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

public class SimpleServerTest implements ConnectionListener {

	private CountDownLatch connectLatch;
	private CountDownLatch disconnectLatch;
	private int port;
	private DefaultHapiContext ctx;

	private static final Logger LOG = LoggerFactory.getLogger(SimpleServerTest.class);


	@Before
	public void setup() {
		connectLatch = new CountDownLatch(1);
		disconnectLatch = new CountDownLatch(1);
	}


	@Test
	public void testStartAndWaitCatchesBusyPort() throws Exception {
		port = RandomServerPortProvider.findFreePort();

		ServerSocket ss = new ServerSocket(port);
		SimpleServer srv = null;
		try {
			ss.setSoTimeout(50); // very short
			ss.setReuseAddress(true);
			try {
				ss.accept();
			} catch (SocketTimeoutException e) {
				// ignore
			}

			ctx = new DefaultHapiContext();
			srv = ctx.newServer(port, false);
			srv.registerApplication(new DefaultApplication(AcknowledgmentCode.AA));
			srv.startAndWait();
			assertNotNull(srv.getServiceExitedWithException());

			LOG.error("Wanted this:", srv.getServiceExitedWithException());
			
		} finally {
			ss.close();
			if (srv != null) {
				srv.stop();
			}
		}
	}


	/**
	 * https://sourceforge.net/p/hl7api/bugs/136/
	 */
	@Test
	public void testNoResponseBadMsh2() throws LLPException, IOException, InterruptedException {

		String msg = "MSHABCDEFGHIJ"; // -

		port = RandomServerPortProvider.findFreePort();
		ctx = new DefaultHapiContext();
		ctx.setLowerLayerProtocol(new MinLowerLayerProtocol(true));

		SimpleServer srv = ctx.newServer(port, false);
		srv.registerApplication(new DefaultApplication(AcknowledgmentCode.AA));
		srv.startAndWait();

		Socket socket=null;
		try {

			socket = new Socket();
			socket.setSoTimeout(1000);
			socket.connect(new InetSocketAddress("localhost", port));

			MinLowerLayerProtocol mllp = new MinLowerLayerProtocol();
			mllp.setCharset("UTF-8");
			HL7Reader reader = mllp.getReader(socket.getInputStream());
			HL7Writer writer = mllp.getWriter(socket.getOutputStream());

			writer.writeMessage(msg);
			String resp = reader.getMessage();

			LOG.info("Response message:\n{}", resp);

		} finally {
			srv.stop();
			socket.close();
		}
	}


	@After
	public void after() {
		// nothing
	}


	@Test
	public void testRejectAttemptToStartTwice() throws InterruptedException, IOException {

		int port = RandomServerPortProvider.findFreePort();
		SimpleServer ss = new SimpleServer(port);

		ss.startAndWait();

		try {
			ss.startAndWait();
			fail();
		} catch (Exception e) {

		} finally {
			ss.stop();
		}

	}


	@SuppressWarnings("resource")
	@Test
	public void testShutdownCleanly() throws InterruptedException, IOException {

		int port = RandomServerPortProvider.findFreePort();
		SimpleServer ss = new SimpleServer(port);
		ss.start();

		Thread.sleep(1000);

		Socket s = new Socket();
		s.connect(new InetSocketAddress("127.0.0.1", port));

		assertTrue(s.isConnected());

		ss.stopAndWait();

	}


	@Test
	public void testDetectConnectAndDisconnect() throws IOException, InterruptedException {

		int port = RandomServerPortProvider.findFreePort();

		HL7Service ss = new DefaultHapiContext().newServer(port, false);
		ss.registerConnectionListener(this);
		ss.startAndWait();
		// assertTrue("Server did not start up", ss.waitUntilRunning());
		LOG.info("Received notification by server");

		assertEquals(1, connectLatch.getCount());
		assertEquals(1, disconnectLatch.getCount());

		LOG.info("Creating connection");
		Socket con = new Socket();
		con.connect(new InetSocketAddress("localhost", port), 2000);
		assertTrue(connectLatch.await(1000, TimeUnit.MILLISECONDS));
		assertEquals(1, disconnectLatch.getCount());

		LOG.info("Closing connection");
		con.close();
		assertTrue(disconnectLatch.await(1000, TimeUnit.MILLISECONDS));
		assertEquals(0, connectLatch.getCount());

		LOG.info("done");
	}


	public void connectionReceived(Connection theC) {
		LOG.info("Connection received by client");
		connectLatch.countDown();
	}


	public void connectionDiscarded(Connection theC) {
		LOG.info("Connection disposed by client");
		disconnectLatch.countDown();
	}


	@Test
	public void testMetadata() throws InterruptedException, HL7Exception, IOException, LLPException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		a01.getMSH().getMsh18_CharacterSet(0).parse("ISO-8859-2");

		port = RandomServerPortProvider.findFreePort();
		DefaultHapiContext ctx = new DefaultHapiContext();
		SimpleServer server = ctx.newServer(port, false);
		MyTestMetadataApplication app = new MyTestMetadataApplication();
		server.registerApplication(app);
		server.startAndWait();
		try {

			Connection client = ctx.newClient("127.0.0.1", port, false);

			ACK resp = (ACK) client.getInitiator().sendAndReceive(a01);

			LOG.info("Received:\n" + resp.encode().replace('\r', '\n'));

			assertEquals("AA", resp.getMSA().getAcknowledgmentCode().getValue());
			assertEquals("127.0.0.1", app.myReceivedSendingIp);
			assertEquals(a01.getMSH().getMsh10_MessageControlID().encode(), app.myReceivedControlId);

		} finally {
			server.stopAndWait();
		}
	}

	@Test
	public void testDontGenerateNakForError() throws InterruptedException, HL7Exception, IOException, LLPException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		a01.getMSH().getMsh18_CharacterSet(0).parse("ISO-8859-2");

		port = RandomServerPortProvider.findFreePort();
		DefaultHapiContext ctx = new DefaultHapiContext();
		ctx.getServerConfiguration().setApplicationExceptionPolicy(ApplicationExceptionPolicy.DO_NOT_RESPOND);
		SimpleServer server = ctx.newServer(port, false);
		server.registerApplication(new ErrorThrowingApplication());
		server.startAndWait();
		try {

			Connection client = ctx.newClient("127.0.0.1", port, false);

			client.getInitiator().setTimeout(1000, TimeUnit.MILLISECONDS);
			
			try {
				Message response = client.getInitiator().sendAndReceive(a01);
				fail("Received response: "+response.encode());
			} catch (HL7Exception e) {
				assertTrue(e.getMessage(), e.getMessage().contains("Timeout"));
				return;
			}

		} finally {
			server.stopAndWait();
		}
	}

	@Test
	public void testDontGenerateNakForHl7Exception() throws InterruptedException, HL7Exception, IOException, LLPException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		a01.getMSH().getMsh18_CharacterSet(0).parse("ISO-8859-2");

		port = RandomServerPortProvider.findFreePort();
		DefaultHapiContext ctx = new DefaultHapiContext();
		ctx.getServerConfiguration().setApplicationExceptionPolicy(ApplicationExceptionPolicy.DO_NOT_RESPOND);
		SimpleServer server = ctx.newServer(port, false);
		server.registerApplication(new HL7ExceptionThrowingApplication());
		server.startAndWait();
		try {

			Connection client = ctx.newClient("127.0.0.1", port, false);

			client.getInitiator().setTimeout(1000, TimeUnit.MILLISECONDS);
			
			try {
				Message response = client.getInitiator().sendAndReceive(a01);
				fail("Received response: "+response.encode());
			} catch (HL7Exception e) {
				assertTrue(e.getMessage(), e.getMessage().contains("Timeout"));
				return;
			}

		} finally {
			server.stopAndWait();
		}
	}

	@Test
	public void testRecoverFromError() throws InterruptedException, HL7Exception, IOException, LLPException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");

		port = RandomServerPortProvider.findFreePort();
		DefaultHapiContext ctx = new DefaultHapiContext();
		SimpleServer server = ctx.newServer(port, false);
		server.registerApplication(new ErrorThrowingApplication());
		server.startAndWait();
		try {

			Connection client = ctx.newClient("127.0.0.1", port, false);

			// client.getInitiator().setTimeoutMillis(600 * 1000);
			ACK resp = (ACK) client.getInitiator().sendAndReceive(a01);

			LOG.info("Received:\n" + resp.encode().replace('\r', '\n'));

			assertEquals("AE", resp.getMSA().getAcknowledgmentCode().getValue());

		} finally {
			server.stopAndWait();
		}
	}

	@SuppressWarnings("unused")
	private static class MyTestMetadataApplication implements ReceivingApplication {

		private Object myReceivedSendingIp;
		private Object myCharset;
		private Object myReceivedControlId;
		private Object myRawMessage;


		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {

			LOG.info("Metadata keys: " + new TreeSet<String>(theMetadata.keySet()));

			myReceivedSendingIp = theMetadata.get(MetadataKeys.IN_SENDING_IP);
			myReceivedControlId = theMetadata.get(MetadataKeys.IN_MESSAGE_CONTROL_ID);
			myRawMessage = theMetadata.get(MetadataKeys.IN_RAW_MESSAGE);

			try {
				return theMessage.generateACK();
			} catch (IOException e) {
				throw new HL7Exception(e);
			}
		}


		public boolean canProcess(Message theMessage) {
			return true;
		}

	}

	private static class ErrorThrowingApplication implements ReceivingApplication {

		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			throw new Error("ERROR MESSAGE");
		}


		public boolean canProcess(Message theMessage) {
			return true;
		}

	}

	private static class HL7ExceptionThrowingApplication implements ReceivingApplication {

		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			throw new HL7Exception("ERROR MESSAGE");
		}


		public boolean canProcess(Message theMessage) {
			return true;
		}

	}
	
}
