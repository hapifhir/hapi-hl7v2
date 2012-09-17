package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.util.RandomServerPortProvider;

public class SimpleServerTest implements ConnectionListener {

	private CountDownLatch connectLatch;
	private CountDownLatch disconnectLatch;
	
	private static final Logger LOG = LoggerFactory.getLogger(SimpleServerTest.class);
	
	@Before
	public void setup() {
		connectLatch = new CountDownLatch(1);
		disconnectLatch = new CountDownLatch(1);
	}

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
		SimpleTestServer ss = new SimpleTestServer(port);
		ss.registerConnectionListener(this);
		ss.startAndWait();
		assertTrue("Server did not start up", ss.waitUntilRunning());
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
	
	
	/**
	 * Little test server that provides a hook to determine if
	 * everything is up and running.
	 */
	private class SimpleTestServer extends SimpleServer {

		private CountDownLatch upAndRunning = new CountDownLatch(1);
		
		public SimpleTestServer(int port) {
			super(port);
		}

		@Override
		protected void afterStartup() {
			super.afterStartup();
			LOG.info("Server is up and running");
			upAndRunning.countDown();
		}
		
		public boolean waitUntilRunning() throws InterruptedException {
			return upAndRunning.await(2000, TimeUnit.MILLISECONDS);
		}
		
	}

}
