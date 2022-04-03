package ca.uhn.hl7v2.hoh.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLServerSocket;

import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CustomCertificateTlsSocketFactoryTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(CustomCertificateTlsSocketFactoryTest.class);

	private int myPort;

	@Before
	public void before() {
		myPort = RandomServerPortProvider.findFreePort();
	}

	@Test
	public void testConnectToNonTrustedSocket() throws IOException, InterruptedException {

		CustomCertificateTlsSocketFactory badServer = createTrustedServerSocketFactory();
		Receiver receiver = new Receiver(badServer);
		receiver.start();
		Thread.sleep(500);

		try {

			CustomCertificateTlsSocketFactory goodClient = createNonTrustedClientSocketFactory();
			Socket client = goodClient.createClientSocket();
			client.connect(new InetSocketAddress("localhost", myPort));

			client.getOutputStream().write("HELLO WORLD".getBytes());
			fail();

		} catch (SSLHandshakeException ignored) {

		}
	}

	@Test
	public void testConnectToTrustedSocket() throws IOException, InterruptedException {

		CustomCertificateTlsSocketFactory goodServer = createTrustedServerSocketFactory();
		Receiver receiver = new Receiver(goodServer);
		receiver.start();
		Thread.sleep(500);

		CustomCertificateTlsSocketFactory goodClient = new CustomCertificateTlsSocketFactory();
		goodClient.setKeystoreFilename("src/test/resources/truststore.jks");
		// goodClient.setKeystorePassphrase("changeit");
		Socket client = goodClient.createClientSocket();
		client.connect(new InetSocketAddress("localhost", myPort));

		client.getOutputStream().write("HELLO WORLD".getBytes());
		client.close();

		Thread.sleep(500);
		String expected = "HELLO WORLD";
		String actual = receiver.myString;
		assertEquals(expected, actual);

	}

	public static CustomCertificateTlsSocketFactory createNonTrustedClientSocketFactory() {
		CustomCertificateTlsSocketFactory goodClient = new CustomCertificateTlsSocketFactory();
		goodClient.setKeystoreFilename("src/test/resources/truststore2.jks");
		goodClient.setKeystorePassphrase("trustpassword");
		return goodClient;
	}

	public static StandardSocketFactory createNonSslServerSocketFactory() {
		return new StandardSocketFactory();
	}
	
	public static CustomCertificateTlsSocketFactory createTrustedClientSocketFactory() {
		CustomCertificateTlsSocketFactory goodClient = new CustomCertificateTlsSocketFactory();
		goodClient.setKeystoreFilename("src/test/resources/truststore.jks");
//		goodClient.setKeystorePassphrase("trustpassword");
		return goodClient;
	}

	public static CustomCertificateTlsSocketFactory createTrustedServerSocketFactory() {
		CustomCertificateTlsSocketFactory goodServer = new CustomCertificateTlsSocketFactory();
		goodServer.setKeystoreFilename("src/test/resources/keystore.jks");
		goodServer.setKeystorePassphrase("changeit");
		return goodServer;
	}

	public static void main(String[] args) throws Exception {

		Server s = new Server();

		// The HTTP configuration object.
		HttpConfiguration httpConfig = new HttpConfiguration();
		// Add the SecureRequestCustomizer because we are using TLS.
		httpConfig.addCustomizer(new SecureRequestCustomizer());

		// The ConnectionFactory for HTTP/1.1.
		HttpConnectionFactory http11 = new HttpConnectionFactory(httpConfig);

		SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
		sslContextFactory.setKeyStorePath("src/test/resources/keystore.jks");
		sslContextFactory.setKeyStorePassword("changeit");

// The ConnectionFactory for TLS.
		SslConnectionFactory tls = new SslConnectionFactory(sslContextFactory, http11.getProtocol());

// The ServerConnector instance.
		ServerConnector connector = new ServerConnector(s, tls, http11);
		connector.setPort(8443);

		s.addConnector(connector);
		s.start();
	}

	private class Receiver extends Thread {

		private final ISocketFactory myFactory;
		private ServerSocket myServer;
		private String myString;

		public Receiver(ISocketFactory theFactory) {
			myFactory = theFactory;
		}

		@Override
		public void run() {
			try {

				ourLog.info("Listening on port {}", myPort);

				myServer = myFactory.createServerSocket();
				myServer.bind(new InetSocketAddress(myPort));
				myServer.setSoTimeout(3000);

				if (myServer instanceof SSLServerSocket) {
					SSLServerSocket ss = (SSLServerSocket) myServer;
					ourLog.info(Arrays.asList(ss.getEnabledCipherSuites()).toString());
				}
				
				Socket socket = myServer.accept();
				socket.setSoTimeout(2000);

				InputStream is = socket.getInputStream();
				StringBuilder b = new StringBuilder();
				for (;;) {
					int next = is.read();
					if (next == -1) {
						break;
					} else {
						b.append((char) next);
						ourLog.info("Received: " + b);
					}
				}

				myString = b.toString();
			} catch (Throwable e) {
				ourLog.error("Failed", e);
				fail(e.getMessage());
			} finally {
				if (myServer != null) {
					try {
						myServer.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
