package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.StringOutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
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
	@Ignore
	public void testNoResponseBadMsh2() throws LLPException, IOException, InterruptedException {

		String msg = "MSHABCDEFGHIJ"; // -

		port = RandomServerPortProvider.findFreePort();
		ctx = new DefaultHapiContext();
		ctx.setLowerLayerProtocol(new MinLowerLayerProtocol(true));

		SimpleServer srv = ctx.newServer(port, false);
		srv.registerApplication(new DefaultApplication(AcknowledgmentCode.AA));
		srv.startAndWait();

		Socket socket = null;
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
	
	@Test
	public void testNoResponseBadMsh2WithDoNotRespond() throws LLPException, IOException, InterruptedException {

		String msg = "MSH|^~\\&|EPR|G^2.16.840.1.113883.3.59.3:947^L|||201404160900||ORU^R01^" +  // -
				"ORU_R01|259759|T^|2.5^^||||||CAN||||^MPID|||7017799^^^UHN^MR^^^^^^^~^^^^JHN^^^^^^^~HN7256" +  // -
				"^^^UHN^PI^^^^^^^||IPhone^Surgery^^^^^L^^^^^201308211411^^~||19250808|M|||34 Bay^^TORONTO^" +  // -
				"ON^M5G 2C8^Can^H^^^^^^^~|1811|(416)967-1111^PRN^PH^^^^^^^^^~||OTH^   Other^03ZPtlang^^^||" +  // -
				"|11310000366^^^UHN^VN^^^^^^^~||||||||||||N|||201308211411||||||^MPV1||I|ES10 THOR^407^4^G" +  // -
				"^4265^^^N^ES 10 407^ES10 407 4^ES10 THOR^1457 3 4^|R||^^^G^4265^^^^^^^  ^|13546^Generic^P" +  // -
				"hysician^Moe^^Dr.^MD^^^L^^^EI^^^^^^^^^^^^^|153528^Iankova^Vesselina^^^Dr.^MD^^^L^^^EI^^^^" +  // - // -
				"^^^^^^^^^||||||D|||13546^Generic^Physician^Moe^^Dr.^MD^^^L^^^EI^^^^^^^^^^^^^|IP^|11310000" +  // -
				"366^^^UHN^VN^G^4265^^^^^||||Y||||||||||||||||G|||||201308211428|||||||V|^MORC|RE|GI103#vi" +  // -
				"talsigns_450BBB3B-6407-4B6A-9676-6D86BA7514AB^EPR^2.16.840.1.113883.3.59.3:947^|||CM||||2" +  // -
				"0140416090000||||||20140416090052||2.16.840.1.113883.3.59.3:947^TG^HL70396^^^||||TG^L^426" +  // -
				"5^^^2.16.840.1.113883.3.59.3:947^FI^^^^^||||||||I^Inpatient^HL70396^^^^^^|^MOBR||GI103#vi" +  // -
				"talsigns_450BBB3B-6407-4B6A-9676-6D86BA7514AB^EPR^2.16.840.1.113883.3.59.3:947^||13194^Vi" +  // -
				"tal Signs (iPhone Technology Trial-10ES)^HL70396^13194^^|||201404160900|||||||||||||||201" +  // -
				"404160900|||F|||~153528^Iankova^Vesselina^^^Dr.^MD^^2.16.840.1.113883.3.59.3:947^L^^^EI^^" +  // -
				"^^^^^^^^^^|||||||||||||||13194^Vital Signs (iPhone Technology Trial-10ES)^HL70396^^^|||29" +  // -
				"^Diagnostic/Monitoring^HL70396^13194^^||^MOBX||NM|VS006^O2 Saturation^HL70396^^^||99|%^^H" +  // -
				"L70396^^^||N|||F|||201404160900|||||^MOBX||ST|VS007^O2/Resp Delivery System^HL70396^^^||r" +  // -
				"oom air|||N|||F|||201404160900|||||^MOBX||ST|VS010^O2 Description^HL70396^^^||N/A|||N|||F" +  // -
				"|||201404160900|||||^MOBX||ST|07ZVS15^Resulted by^07ZObsIden^^^|||^^07ZUnits^^^||normal||" +  // -
				"|F|||201404160900||Debug_Build_EPR_ID|||^Mnormal^MOBX||ST|VS015^Special Note^HL70396^^^||" +  // -
				"These vital signs were recorded as part of a technology improvement trial taking place on" +  // -
				" 10 Eaton South during the first half of 2014. Please contact vitalsigns@ehealthinnovatio" +  // -
				"n.org for further details.|||N|||F|||201404160900|||||^MFT1||GI103#vitalsigns_450BBB3B-64" +  // -
				"07-4B6A-9676-6D86BA7514AB||201404160900||||||||||^^HL70072^^^||||I|||||||13194^Vital Sign" +  // -
				"s (iPhone Technology Trial-10ES)^HL70396^^^||||||^MZWA||||||||active|^M".replace("^M", "\r"); // -

		port = RandomServerPortProvider.findFreePort();
		ctx = new DefaultHapiContext();
		ctx.setLowerLayerProtocol(new MinLowerLayerProtocol(true));
		ctx.getServerConfiguration().setApplicationExceptionPolicy(ApplicationExceptionPolicy.DO_NOT_RESPOND);
		
		SimpleServer srv = ctx.newServer(port, false);
		srv.registerApplication(new DefaultApplication(AcknowledgmentCode.AA));
		srv.startAndWait();

		Socket socket = null;
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
		String encodedMessage = a01.encode();
		LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(false);
		ByteArrayOutputStream sos = new ByteArrayOutputStream();
		HL7Writer w = llp.getWriter(sos);
		w.writeMessage(encodedMessage);
		;
		byte[] messageBytes = sos.toByteArray();

		port = RandomServerPortProvider.findFreePort();
		DefaultHapiContext ctx = new DefaultHapiContext();
		ctx.getServerConfiguration().setApplicationExceptionPolicy(ApplicationExceptionPolicy.DO_NOT_RESPOND);
		SimpleServer server = ctx.newServer(port, false);
		server.registerApplication(new ErrorThrowingApplication());
		server.startAndWait();
		Socket socket = new Socket();
		try {

			socket.setSoTimeout(500);
			socket.connect(new InetSocketAddress("127.0.0.1", port));
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write(messageBytes);
			outputStream.flush();

			try {
				IOUtils.toString(socket.getInputStream());
				fail();
			} catch (SocketTimeoutException e) {
				// expected
			}

		} finally {
			server.stopAndWait();
			socket.close();
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
				fail("Received response: " + response.encode());
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
	private static class MyTestMetadataApplication implements ReceivingApplication<Message> {

		private Object myReceivedSendingIp;
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

	private static class ErrorThrowingApplication implements ReceivingApplication<Message> {

		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			throw new Error("ERROR MESSAGE");
		}

		public boolean canProcess(Message theMessage) {
			return true;
		}

	}

	private static class HL7ExceptionThrowingApplication implements ReceivingApplication<Message> {

		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			throw new HL7Exception("ERROR MESSAGE");
		}

		public boolean canProcess(Message theMessage) {
			return true;
		}

	}

}
