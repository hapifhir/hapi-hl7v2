package ca.uhn.hl7v2.app;

import static ca.uhn.hl7v2.app.TestUtils.fill;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A45;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

/**
 * JUnit test harmess for ConnectionHub connecting to a SimpleServer
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class TwoPortConnectionHubTest {

	private static final Logger ourLog = LoggerFactory.getLogger(TwoPortConnectionHubTest.class);
	private static int port1;
	private static int port2;
	private static HL7Service tps;
	private static ConnectionHub hub;
	private static HapiContext context;

	@BeforeClass
	public static void beforeClass() throws Exception {
		context = new DefaultHapiContext();
		port1 = RandomServerPortProvider.findFreePort();
		port2 = RandomServerPortProvider.findFreePort();
		tps = context.newServer(port1, port2, false);
		tps.registerApplication("*", "*", new MyApp());
		tps.startAndWait();
		hub = context.getConnectionHub();
	}

	@After
	public void tearDown() {
		hub.discardAll();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		tps.stopAndWait();
		// ConnectionHub.shutdown();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAttach() throws Exception {
		Connection i1 = TestUtils.acquireClientConnection(hub, port1, port2);
		Connection i1again = TestUtils.acquireClientConnection(hub, port1, port2);
		assertTrue(i1 == i1again);
		assertEquals(1, hub.allConnections().size());
		hub.allConnections().contains(i1);
		hub.detach(i1);
		assertTrue(i1again.isOpen());
		hub.allConnections().contains(i1again);
		hub.detach(i1again);
		assertFalse(i1again.isOpen());
		assertEquals(0, hub.allConnections().size());
		Connection i1OnceMore = TestUtils.acquireClientConnection(hub,
				port1, port2);
		assertTrue(i1 != i1OnceMore);
		hub.detach(i1OnceMore);
		assertEquals(0, hub.allConnections().size());
	}

	@Test
	public void testAttachToExistingServer() throws Exception {

		int n = 100;

		Callable<Connection> t = new Callable<Connection>() {
			public Connection call() {
				try {
					return hub.attach("localhost", port1, port2, false);
				} catch (HL7Exception e) {
					return null;
				}
			}
		};
		List<Future<Connection>> results = DefaultExecutorService.getDefaultService().invokeAll(
				fill(t, n));
		assertEquals(n, results.size());
		Connection unique = results.iterator().next().get();
		assertNotNull(unique);
		for (Future<Connection> future : results) {
			assertTrue(unique == future.get());
		}
		assertEquals(1, hub.allConnections().size());
	}

	@Test
	public void testAttachToNonexistingServer() throws Exception {
		int freePort = RandomServerPortProvider.findFreePort();
		try {
			hub.attach("localhost", RandomServerPortProvider.findFreePort(),
					RandomServerPortProvider.findFreePort(), false);
			fail("Shouldn't be a service running at " + freePort);
		} catch (Exception e) {
		}
	}

	@Test
	public void testDetachTooOften() throws Exception {
		Connection i1 = hub.attach("localhost", port1, port2, false);
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
	public void testConnectionClosedExternally() throws Exception {

		PipeParser pipeParser = new PipeParser();
		Connection i1 = hub.attach("localhost", port1, port2, false);

		String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
				+ "EVN|A45|201004141020|\r"
				+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
				+ "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";
		ADT_A45 msg = new ADT_A45();
		msg.setParser(pipeParser);
		msg.parse(messageText);
		i1.getInitiator().sendAndReceive(msg);
		i1.close();
		Thread.sleep(2000); // wait until connection has been cleaned up
		// Supposed to discard the closed connection and open a new one
		Connection i1again = hub.attach("localhost", port1, port2, false);
		assertTrue(i1 != i1again);
		Thread.sleep(1000);
		assertNotNull(i1again.getInitiator().sendAndReceive(msg));
		i1again.close();
	}

	@Test
	public void testDiscard() throws Exception {
		Connection i1 = hub.attach("localhost", port1, port2, false);
		hub.attach("localhost", port1, port2, false);
		hub.discard(i1);
		Connection i1thrice = hub.attach("localhost", port1, port2, false);
		assertTrue(i1thrice != i1);
		hub.discard(i1thrice);
	}

	@Test
	public void testDiscardAll() throws Exception {
		hub.attach("localhost", port1, port2, false);
		hub.discardAll();
		assertEquals(0, hub.allConnections().size());
	}

	public static class MyApp implements Application<Message> {

		public boolean canProcess(Message theIn) {
			return true;
		}

		public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {
			ourLog.info("Received: " + theIn.encode());
			try {
				return theIn.generateACK();
			} catch (IOException e) {
				throw new HL7Exception(e);
			}
		}

	}

}
