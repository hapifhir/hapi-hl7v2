package ca.uhn.hl7v2.hoh.sockets;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import javax.net.ssl.SSLServerSocket;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;

public class CustomCertificateTlsSocketFactoryTest {

	private int myPort;

	@Before
	public void before() {
		myPort = RandomServerPortProvider.findFreePort();

	}

	@Test
	public void testConnectToTeustedocket() throws IOException, InterruptedException {
		
//		CustomCertificateTlsSocketFactory badServer = new CustomCertificateTlsSocketFactory();
//		badServer.setKeystoreFilename("src/test/resources/symmetrickey.jks");
//		badServer.setKeystorePassphrase("thestorepass");
//		badServer.setKeystoreType("JCEKS");
//		Receiver receiver = new Receiver(badServer);
//		receiver.start();
//		Thread.sleep(500);
//		
//		CustomCertificateTlsSocketFactory goodClient = new CustomCertificateTlsSocketFactory();
//		goodClient.setKeystoreFilename("src/test/resources/symmetrickey.jks");
//		goodClient.setKeystorePassphrase("thestorepass");
//		goodClient.setKeystoreType("JCEKS");
//		Socket client = goodClient.createClientSocket();
//		client.connect(new InetSocketAddress("localhost", myPort));
//		
//		client.getOutputStream().write("HELLO WORLD".getBytes());
//		client.close();
//		
//		Thread.sleep(500);
//		assertNotSame("HELLO WORLD", receiver.myString);
		
	}

	@Test
	public void testConnectToNonTrustedSocket() throws IOException, InterruptedException {
		
//		TlsSocketFactory badServer = new TlsSocketFactory();
//		Receiver receiver = new Receiver(badServer);
//		receiver.start();
//		Thread.sleep(500);
//		
//		CustomCertificateTlsSocketFactory goodClient = new CustomCertificateTlsSocketFactory();
//		goodClient.setKeystoreFilename("src/test/resources/symmetrickey.jks");
//		goodClient.setKeystorePassphrase("thestorepass");
//		goodClient.setKeystoreType("JCEKS");
//		Socket client = goodClient.createClientSocket();
//		client.setSoTimeout(1000);
//		client.connect(new InetSocketAddress("localhost", myPort));
//		
//		client.getOutputStream().write("HELLO WORLD".getBytes());
//		client.close();
//		
//		Thread.sleep(500);
//		assertNotSame("HELLO WORLD", receiver.myString);
		
	}

	
	private class Receiver extends Thread {

		private ISocketFactory myFactory;
		private Throwable myException;
		private ServerSocket myServer;
		private String myString;

		public Receiver(ISocketFactory theFactory) {
			myFactory = theFactory;
		}

		@Override
		public void run() {
			try {

				myServer = myFactory.createServerSocket();
				myServer.bind(new InetSocketAddress(myPort));
				myServer.setSoTimeout(3000);
				
				SSLServerSocket ss = (SSLServerSocket)myServer;
				ourLog.info(Arrays.asList(ss.getEnabledCipherSuites()).toString());
				
				Socket socket = myServer.accept();
				socket.setSoTimeout(2000);
				
				InputStream is = socket.getInputStream();
				StringBuilder b = new StringBuilder();
				for (;;) {
					int next = is.read();
					if (next == -1) {
						break;
					} else {
						b.append((char)next);
						ourLog.info("Received: " + b);
					}
				}

				myString = b.toString();
			} catch (Throwable e) {
				ourLog.error("Failed", e);
				myException = e;
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

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(CustomCertificateTlsSocketFactoryTest.class);
}
