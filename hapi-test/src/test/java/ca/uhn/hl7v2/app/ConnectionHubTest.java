package ca.uhn.hl7v2.app;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.MockitoTest;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A45;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.util.StandardSocketFactory;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static ca.uhn.hl7v2.app.TestUtils.fill;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * JUnit test harmess for ConnectionHub connecting to a SimpleServer
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class ConnectionHubTest extends MockitoTest {

    private static final Logger ourLog = LoggerFactory.getLogger(ConnectionHubTest.class);
	private static int port1;
	private static int port2;
	private static HL7Service ss1;
	private static HL7Service ss2;
	private static ConnectionHub hub;

	private static HapiContext context;
	private static Parser parser;
    public static final String A45 = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
            + "EVN|A45|201004141020|\r"
            + "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
            + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";

    @BeforeClass
	public static void beforeClass() throws Exception {
		context = new DefaultHapiContext();
		port1 = RandomServerPortProvider.findFreePort();
		port2 = RandomServerPortProvider.findFreePort();
		ss1 = context.newServer(port1, false);
		ss1.registerApplication("*", "*", new MyApp());
		ss1.startAndWait();
		ss2 = context.newServer(port2, false);
		ss2.registerApplication("*", "*", new MyApp());
		ss2.startAndWait();
		hub = context.getConnectionHub();
		parser = context.getPipeParser();
	}

	@After
	public void tearDown() {
		hub.discardAll();
	}

	@AfterClass
	public static void afterClass() {
		ss1.stopAndWait();
		ss2.stopAndWait();
		// ConnectionHub.shutdown();
	}

	@Test
	public void testConnectWithTlsSocketFactory() throws HL7Exception, IOException {
		HapiContext context = new DefaultHapiContext();
		context.setValidationContext(ValidationContextFactory.noValidation());

		SocketFactory socketFactory = mock(SocketFactory.class, withSettings().verboseLogging());
		context.setSocketFactory(socketFactory);
		when(socketFactory.createTlsSocket()).thenReturn(
				javax.net.SocketFactory.getDefault().createSocket());

		ConnectionHub connHub = context.getConnectionHub();
		Connection conn = connHub.attach("localhost", port1, true);
		conn.close();

		verify(socketFactory, times(1)).createTlsSocket();
		verify(socketFactory, times(1)).getConnectTimeout();
		verifyNoMoreInteractions(socketFactory);

	}

	@Test
	public void testConnectWithSocketFactory() throws HL7Exception, IOException {
		HapiContext context = new DefaultHapiContext();
		context.setValidationContext(ValidationContextFactory.noValidation());

		SocketFactory socketFactory = mock(SocketFactory.class);
		context.setSocketFactory(socketFactory);
		when(socketFactory.createSocket()).thenReturn(
				javax.net.SocketFactory.getDefault().createSocket());

		ConnectionHub connHub = context.getConnectionHub();
		Connection conn = connHub.attach("localhost", port1, false);
		conn.close();

		verify(socketFactory, times(1)).createSocket();
		verify(socketFactory, times(1)).getConnectTimeout();
		verifyNoMoreInteractions(socketFactory);

	}

	@Test
	public void testConnectWithTimeout_WithoutSocketFactory_appliesTimeout() throws Exception {
		int configuredTimeout = 1_385;

		ConnectionData connData = new ConnectionData("localhost", port1, parser, new MinLowerLayerProtocol(), configuredTimeout);
		try (Connection conn = ConnectionFactory.open(connData, Executors.newSingleThreadExecutor())) {
			validateTimeout(conn, configuredTimeout);
		}
	}

	@Test
	public void testConnectWithTimeout_UsingSocketFactory_appliesTimeout() throws Exception {
		int configuredTimeout = 1_385;

		StandardSocketFactory socketFactory = new StandardSocketFactory();
		socketFactory.setAcceptedSocketTimeout(configuredTimeout);

		ConnectionData connData = new ConnectionData("localhost", port1, 0, parser, new MinLowerLayerProtocol(), false, socketFactory, false);
		try (Connection conn = ConnectionFactory.open(connData, Executors.newSingleThreadExecutor())) {
			validateTimeout(conn, configuredTimeout);
		}
	}

	@Test
	public void testAttachRespectsConfiguredTimeout() throws Exception {
		int configuredTimeout = 1_385;

		ConnectionHub hub = ConnectionHub.getNewInstance(context);

		ConnectionData connData = new ConnectionData("localhost", port1, parser, new MinLowerLayerProtocol(), configuredTimeout);

		try (Connection conn = hub.attach(connData)) {
			validateTimeout(conn, configuredTimeout);
		}
	}

	void validateTimeout(Connection conn, int expectedTimeout) throws SocketException {
		assertNotNull(conn);
		assertTrue(conn instanceof ActiveConnection);
		ActiveConnection activeConnection = (ActiveConnection) conn;
		assertNotNull(activeConnection.getSockets());
		assertEquals(1, activeConnection.getSockets().size());
		Socket socket = activeConnection.getSockets().get(0);
		assertEquals(expectedTimeout, socket.getSoTimeout());
	}

	@Test
	public void testConnect_ConnectionDataTimeout_isUsedAsConnectTimeout() throws Exception {
		int configuredTimeout = 1_385;
		RecordingSocketFactory socketFactory = new RecordingSocketFactory();

		ConnectionData connData = new ConnectionData("localhost", port1, 0, parser, new MinLowerLayerProtocol(), false, socketFactory, false, configuredTimeout);
		try (Connection conn = hub.attach(connData)) {
			assertNotNull(conn);
		}

		assertEquals(Collections.singletonList(configuredTimeout), socketFactory.connectTimeouts);
	}

	@Test
	public void testConnect_SocketFactoryConnectTimeout_isUsedAsConnectTimeout() throws Exception {
		RecordingSocketFactory socketFactory = new RecordingSocketFactory();
		socketFactory.setConnectTimeout(1_385);

		HapiContext context = new DefaultHapiContext();
		context.setSocketFactory(socketFactory);
		try (Connection conn = context.newClient("localhost", port1, false)) {
			assertNotNull(conn);
		}

		assertEquals(Collections.singletonList(1_385), socketFactory.connectTimeouts);
	}

	@Test
	public void testConnect_ConnectionDataTimeoutAndSocketFactoryTimeout_connectionDataWins() throws Exception {
		RecordingSocketFactory socketFactory = new RecordingSocketFactory();
		socketFactory.setConnectTimeout(9_999);

		ConnectionData connData = new ConnectionData("localhost", port1, 0, parser, new MinLowerLayerProtocol(), false, socketFactory, false, 1_385);
		try (Connection conn = hub.attach(connData)) {
			assertNotNull(conn);
		}

		assertEquals(Collections.singletonList(1_385), socketFactory.connectTimeouts);
	}

	@Test
	public void testConnect_NoTimeoutConfigured_connectsWithoutTimeout() throws Exception {
		RecordingSocketFactory socketFactory = new RecordingSocketFactory();

		HapiContext context = new DefaultHapiContext();
		context.setSocketFactory(socketFactory);
		try (Connection conn = context.newClient("localhost", port2, false)) {
			assertNotNull(conn);
		}

		assertEquals(Collections.singletonList(0), socketFactory.connectTimeouts);
	}

	@Test(timeout = 30_000)
	public void testAttach_ConnectionDataTimeout_unresponsivePeer_failsWithinTimeout() throws Exception {
		try (UnresponsivePeer peer = UnresponsivePeer.start()) {
			ConnectionData connData = new ConnectionData(peer.getHost(), peer.getPort(), parser, new MinLowerLayerProtocol(), 500);
			assertConnectTimesOut(() -> ConnectionHub.getNewInstance(context).attach(connData));
		}
	}

	@Test(timeout = 30_000)
	public void testNewClient_SocketFactoryConnectTimeout_unresponsivePeer_failsWithinTimeout() throws Exception {
		try (UnresponsivePeer peer = UnresponsivePeer.start()) {
			HapiContext context = new DefaultHapiContext();
			StandardSocketFactory socketFactory = new StandardSocketFactory();
			socketFactory.setConnectTimeout(500);
			context.setSocketFactory(socketFactory);
			assertConnectTimesOut(() -> context.newClient(peer.getHost(), peer.getPort(), false));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetConnectTimeout_negative_throws() {
		new StandardSocketFactory().setConnectTimeout(-1);
	}

	private static void assertConnectTimesOut(Callable<Connection> connect) throws Exception {
		long start = System.nanoTime();
		try {
			connect.call().close();
			fail("Expected the connection attempt to time out");
		} catch (HL7Exception e) {
			long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
			Throwable cause = e;
			while (cause != null && !(cause instanceof SocketTimeoutException)) {
				cause = cause.getCause();
			}
			assertNotNull("Expected a SocketTimeoutException in the cause chain of " + e, cause);
			assertTrue("Connect attempt took " + elapsedMillis + " ms", elapsedMillis < 10_000);
		}
	}

	/**
	 * Socket factory that records the timeout passed to {@link Socket#connect(SocketAddress, int)}
	 * for every client socket it creates.
	 */
	private static class RecordingSocketFactory extends StandardSocketFactory {

		private final List<Integer> connectTimeouts = Collections.synchronizedList(new ArrayList<>());

		@Override
		public Socket createSocket() {
			return new Socket() {
				@Override
				public void connect(SocketAddress endpoint, int timeout) throws IOException {
					connectTimeouts.add(timeout);
					super.connect(endpoint, timeout);
				}
			};
		}
	}

	/**
	 * A listening socket whose accept backlog is full and which never accepts. Further connection
	 * attempts are neither accepted nor refused, as with a firewalled or unresponsive host, without
	 * depending on the network. If the operating system refuses connections when the backlog is
	 * full instead of ignoring them, the calling test is skipped.
	 */
	private static class UnresponsivePeer implements Closeable {

		private final ServerSocket serverSocket;
		private final List<Socket> fillers = new ArrayList<>();

		private UnresponsivePeer() throws IOException {
			serverSocket = javax.net.ServerSocketFactory.getDefault().createServerSocket(0, 1, InetAddress.getLoopbackAddress());
		}

		static UnresponsivePeer start() throws IOException {
			UnresponsivePeer peer = new UnresponsivePeer();
			boolean backlogFull = peer.fillBacklog();
			if (!backlogFull) {
				peer.close();
			}
			Assume.assumeTrue("OS does not leave connections pending when the backlog is full", backlogFull);
			return peer;
		}

		private boolean fillBacklog() throws IOException {
			for (int i = 0; i < 50; i++) {
				Socket filler = javax.net.SocketFactory.getDefault().createSocket();
				try {
					filler.connect(serverSocket.getLocalSocketAddress(), 200);
					fillers.add(filler);
				} catch (SocketTimeoutException e) {
					closeQuietly(filler);
					return true;
				} catch (IOException e) {
					closeQuietly(filler);
					return false;
				}
			}
			return false;
		}

		String getHost() {
			return serverSocket.getInetAddress().getHostAddress();
		}

		int getPort() {
			return serverSocket.getLocalPort();
		}

		@Override
		public void close() {
			fillers.forEach(UnresponsivePeer::closeQuietly);
			closeQuietly(serverSocket);
		}

		private static void closeQuietly(Closeable closeable) {
			try {
				closeable.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAttach() throws Exception {
		Connection i1 = hub.attach("localhost", port1, false);
		Connection i1again = hub.attach("localhost", port1, false);
		assertSame(i1, i1again);
		Connection i2 = hub.attach("localhost", port2, false);
		assertNotSame(i2, i1again);
		assertEquals(2, hub.allConnections().size());
		hub.allConnections().contains(i1);
		hub.allConnections().contains(i2);
		hub.detach(i1);
		assertTrue(i1again.isOpen());
		hub.allConnections().contains(i1again);
		hub.detach(i1again);
		assertFalse(i1again.isOpen());
		hub.detach(i2);
		assertEquals(0, hub.allConnections().size());
		Connection i1OnceMore = hub.attach("localhost", port1, false);
		assertNotSame(i1, i1OnceMore);
		hub.detach(i1OnceMore);
		assertEquals(0, hub.allConnections().size());
	}

	@Test
	public void testAttachSequentially() throws Exception {

		int n = 20;
		long now = System.currentTimeMillis();
		final int myfreePort = RandomServerPortProvider.findFreePort();

		Callable<Long> t = () -> {
			long time = 0;
			try {
				time = System.currentTimeMillis();
				hub.attach("localhost", myfreePort, false);
			} catch (HL7Exception e) {
				time = System.currentTimeMillis() - time;
			}
			return time;
		};
				
		List<Future<Long>> results = DefaultExecutorService.getDefaultService().invokeAll(fill(t, n));
		long total = 0;
		List<Long> resultsLongs = new ArrayList<>();
		for (Future<Long> future : results) {
			total += future.get();
			resultsLongs.add(future.get());
		}
				
		long elapsed = System.currentTimeMillis() - now;
		// Due to synchronization, the threads are executed almost sequentially

		Collections.sort(resultsLongs);
		ourLog.info("Elapsed: {}, Total: {}. Values: {}", elapsed, total, resultsLongs);
		
		assertTrue(elapsed < total);
		assertEquals(0, hub.allConnections().size());
	}

	@Test
	public void testAttachConcurrently() throws Exception {

		int n = 5;
		long now = System.currentTimeMillis();

		Callable<Long> t = () -> {
			long time = 0;
			try {
				time = System.currentTimeMillis();
				int port = RandomServerPortProvider.findFreePort();
				ourLog.info("Attaching to non-existent port {}.", port);
				hub.attach("localhost", port, false);
			} catch (HL7Exception e) {
				time = System.currentTimeMillis() - time;
			}
			return time;
		};
		List<Future<Long>> results = DefaultExecutorService.getDefaultService().invokeAll(
				fill(t, n));
		Future<Long> fastestResult = Collections.min(results, (o1, o2) -> {
			try {
				return o1.get().compareTo(o2.get());
			} catch (Exception e) {
				return 0; // should never happen
			}
		});
		long elapsed = System.currentTimeMillis() - now;

		// TODO find some portable way to check that the connection attempts happened concurrently
		ourLog.info("Elapsed test time was {} ms, the fastest connection time was {} ms.", elapsed,
				fastestResult.get());
		for (Future<Long> next : results) {
			ourLog.info("Elapsed thread connection time was {} ms.", next.get());
		}

		assertEquals(0, hub.allConnections().size());
	}

	@Test
	public void testAttachToExistingServer() throws Exception {

		int n = 100;

		Callable<Connection> t = () -> {
			try {
				return hub.attach("localhost", port1, false);
			} catch (HL7Exception e) {
				return null;
			}
		};
		List<Future<Connection>> results = DefaultExecutorService.getDefaultService().invokeAll(
				fill(t, n));
		assertEquals(n, results.size());
		Connection unique = results.iterator().next().get();
		assertNotNull(unique);
		for (Future<Connection> future : results) {
			assertSame(unique, future.get());
		}
		assertEquals(1, hub.allConnections().size());
	}

	@Test(expected = HL7Exception.class)
	public void testAttachToNonExistingServer() throws Exception {
		int freePort = RandomServerPortProvider.findFreePort();
        hub.attach("localhost", freePort, false);
	}

    @Test
    public void testLazilyAttach() throws Exception {

        // We can "open" a connection if the server does not run (yet)
        int freePort = RandomServerPortProvider.findFreePort();
        Connection c = hub.attachLazily("localhost", freePort, false);
        assertTrue(c instanceof LazyConnection);
        LazyConnection lc = (LazyConnection)c;
        assertFalse(lc.isEstablished());

        // We can also obtain an Initiator
        Initiator initiator = c.getInitiator();
        assertTrue(initiator instanceof LazyConnection.LazyInitiator);

        // Now start the server side
        HL7Service service = context.newServer(freePort, false);
        service.registerApplication("*", "*", new MyApp());
        service.startAndWait();
        assertFalse(lc.isEstablished());

        // Send a message. the physical connection is created on the fly
        ADT_A45 msg = new ADT_A45();
        msg.setParser(parser);
        msg.parse(A45);
        Message response = initiator.sendAndReceive(msg);
        assertTrue(lc.isEstablished());
        assertTrue(response instanceof ACK);

        // Close the connection
        c.close();
        assertFalse(lc.isEstablished());

        // Reopen transparently by sending a new message
        response = initiator.sendAndReceive(msg);
        assertTrue(lc.isEstablished());
        assertTrue(response instanceof ACK);
        c.close();
    }

	@Test
	public void testDetachTooOften() throws Exception {
		Connection i1 = hub.attach("localhost", port1, false);
		assertTrue(i1.isOpen());
		hub.detach(i1);
		assertFalse(i1.isOpen());
		hub.detach(i1); // just ignore
	}

	/**
	 * Make sure that connection hub doesn't try to reuse a connection which is already closed
	 * 
	 * @throws IOException
	 * @throws LLPException
	 */
	@Test
	public void testConnectionClosedExternally() throws HL7Exception, LLPException, IOException {

		Connection i1 = hub.attach("localhost", port1, false);

        ADT_A45 msg = new ADT_A45();
		msg.setParser(parser);
		msg.parse(A45);
		i1.getInitiator().sendAndReceive(msg);
		i1.close(); // PROBLEM: connection still in hub table
		System.out.println("Connection closed 1");

		Connection i1again = hub.attach("localhost", port1, false);
		assertNotSame(i1, i1again);
		i1again.getInitiator().sendAndReceive(msg);
		i1again.close();
		System.out.println("Connection closed 2");
	}

	@Test
	public void testDiscard() throws Exception {
		Connection i1 = hub.attach("localhost", port1, false);
		hub.attach("localhost", port1, false);
		hub.discard(i1);
		Connection i1thrice = hub.attach("localhost", port1, false);
		assertNotSame(i1thrice, i1);
		hub.discard(i1thrice);
	}

	@Test
	public void testDiscardAll() throws Exception {
		hub.attach("localhost", port1, false);
		hub.attach("localhost", port2, false);
		hub.discardAll();
		assertEquals(0, hub.allConnections().size());
	}

	public static class MyApp implements ReceivingApplication<Message> {

		public boolean canProcess(Message theIn) {
			return true;
		}

		public Message processMessage(Message theIn, Map<String, Object> theMetadata) throws HL7Exception {
			ourLog.info("Received: " + theIn.encode());
			try {
				return theIn.generateACK();
			} catch (IOException e) {
				throw new HL7Exception(e);
			}
		}

	}

}
