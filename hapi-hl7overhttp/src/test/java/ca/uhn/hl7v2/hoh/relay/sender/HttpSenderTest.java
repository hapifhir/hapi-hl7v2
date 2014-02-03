package ca.uhn.hl7v2.hoh.relay.sender;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.llp.ServerSocketThreadForTesting;
import ca.uhn.hl7v2.hoh.relay.Launcher;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactoryTest;
import ca.uhn.hl7v2.hoh.util.Holder;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;

public class HttpSenderTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HttpSenderTest.class);
	private int myOutPort;
	private ServerSocketThreadForTesting myServerSocketThread;
	private SingleCredentialServerCallback ourServerCallback;
	private int myInPort;
	private int myInPort2;

	@After
	public void after() throws InterruptedException {
		ourLog.info("Marking done as true");
		myServerSocketThread.done();
	}

	@Before
	public void before() throws InterruptedException {
		// System.setProperty("javax.net.debug", "ssl");

		myOutPort = RandomServerPortProvider.findFreePort();
		myInPort = RandomServerPortProvider.findFreePort();
		myInPort2 = RandomServerPortProvider.findFreePort();
		System.setProperty("relay.port.out", Integer.toString(myOutPort));
		System.setProperty("relay.port.in", Integer.toString(myInPort));
		System.setProperty("relay.port.in.2", Integer.toString(myInPort2));

		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		myServerSocketThread = new ServerSocketThreadForTesting(myOutPort, ourServerCallback);
	}

	@SuppressWarnings("resource")
	@Test
	public void testSenderWithTls() throws HL7Exception, IOException, LLPException, InterruptedException, DecodeException, EncodeException {

		CustomCertificateTlsSocketFactory serverSocketFactory = CustomCertificateTlsSocketFactoryTest.createTrustedServerSocketFactory();
		myServerSocketThread.setServerSockewtFactory(serverSocketFactory);
		myServerSocketThread.start();
		myServerSocketThread.getLatch().await();

		ADT_A01 adt = new ADT_A01();
		adt.initQuickstart("ADT", "A01", "T");

		Launcher l = new Launcher("src/test/resources/relay/MllpToHttpTlsMutualAuth.xml");

		ConnectionHub hub = new DefaultHapiContext().getConnectionHub();
		try {

			Connection c = hub.attach("localhost", myInPort, false);
			c.getInitiator().setTimeout(10000000, TimeUnit.MILLISECONDS);
			Message response = c.getInitiator().sendAndReceive(adt);

			ourLog.info("Response was:\n{}", response.encode().replace('\r', '\n'));

		} finally {
			l.shutdown();
		}
	}

	

	@SuppressWarnings("resource")
	@Test
	public void testErrorMessageReferencesRelay() throws HL7Exception, IOException, LLPException, InterruptedException, DecodeException, EncodeException {

		ADT_A01 adt = new ADT_A01();
		adt.initQuickstart("ADT", "A01", "T");

		Launcher l = new Launcher("src/test/resources/relay/MllpToHttp.xml");

		ConnectionHub hub = new DefaultHapiContext().getConnectionHub();
		try {

			Connection c = hub.attach("localhost", myInPort, false);
			c.getInitiator().setTimeout(10000000, TimeUnit.MILLISECONDS);
			Message response = c.getInitiator().sendAndReceive(adt);

			ourLog.info("Response was:\n{}", response.encode().replace('\r', '\n'));

			Assert.assertTrue(response.encode().contains("HAPI HL7 over HTTP Relay"));
			
		} finally {
			l.shutdown();
		}
	}
	
	
	@Test
	public void testSetUrl() throws Exception {

		RelayHttpSender s = new RelayHttpSender();
		s.setUrlString("http://localhost:8888/path");

		assertEquals("localhost", s.getHost());
		assertEquals(8888, s.getPort());
		assertEquals("/path", s.getUriPath());

		s.afterPropertiesSet();

	}

	@Test
	public void setMultipleConcurrentSenders() throws Throwable {
		Launcher l = new Launcher("src/test/resources/relay/MllpToHttpMultipleListeners.xml");
		try {

			myServerSocketThread.setResponseDelays(500L, 0L);
			myServerSocketThread.start();
			myServerSocketThread.getLatch().await();

			final ADT_A01 msg1 = new ADT_A01();
			msg1.initQuickstart("ADT", "A01", "T");

			final ADT_A01 msg2 = new ADT_A01();
			msg2.initQuickstart("ADT", "A01", "T");

			final Holder<ACK> resp1Holder = new Holder<ACK>();
			final Holder<ACK> resp2Holder = new Holder<ACK>();
			final Holder<Throwable> failHolder = new Holder<Throwable>();

			Thread t1 = new Thread() {
				@Override
				public void run() {
					try {
						Connection client1 = new DefaultHapiContext().newClient("localhost", myInPort, false);
						resp1Holder.myValue = (ACK) client1.getInitiator().sendAndReceive(msg1);
					} catch (Throwable e) {
						failHolder.myValue = e;
					}
				}
			};
			t1.start();

			Thread.sleep(100);
			
			Thread t2 = new Thread() {
				@Override
				public void run() {
					try {
						Connection client2 = new DefaultHapiContext().newClient("localhost", myInPort, false);
						resp2Holder.myValue = (ACK) client2.getInitiator().sendAndReceive(msg2);
					} catch (Throwable e) {
						failHolder.myValue = e;
					}
				}
			};
			t2.start();

			t1.join();
			t2.join();
			
			if (failHolder.myValue!=null) {
				throw failHolder.myValue;
			}
			
			ACK resp1 = resp1Holder.myValue;
			ACK resp2 = resp2Holder.myValue;
			assertEquals(msg1.getMSH().getMsh10_MessageControlID().getValue(), resp1.getMSA().getMsa2_MessageControlID().getValue());
			assertEquals(msg2.getMSH().getMsh10_MessageControlID().getValue(), resp2.getMSA().getMsa2_MessageControlID().getValue());

		} finally {
			l.shutdown();
		}
	}

}
