package ca.uhn.hl7v2.hoh.relay.sender;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContextSupport;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.llp.ServerSocketThreadForTesting;
import ca.uhn.hl7v2.hoh.relay.Launcher;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactoryTest;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;

public class HttpSenderTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HttpSenderTest.class);
	private int myOutPort;
	private ServerSocketThreadForTesting myServerSocketThread;
	private SingleCredentialServerCallback ourServerCallback;
	private int myInPort;
	
	@After
	public void after() throws InterruptedException {
		ourLog.info("Marking done as true");
		myServerSocketThread.done();
	}

	@Before
	public void before() throws InterruptedException {
//		System.setProperty("javax.net.debug", "ssl");

		myOutPort = RandomServerPortProvider.findFreePort();
		myInPort = RandomServerPortProvider.findFreePort();
		System.setProperty("relay.port.out", Integer.toString(myOutPort));
		System.setProperty("relay.port.in", Integer.toString(myInPort));

		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		myServerSocketThread = new ServerSocketThreadForTesting(myOutPort, ourServerCallback);
	}

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
			c.getInitiator().setTimeoutMillis(10000000);
			Message response = c.getInitiator().sendAndReceive(adt);
			
			ourLog.info("Response was:\n{}", response.encode().replace('\r', '\n'));
			
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
	

}
