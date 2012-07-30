package ca.uhn.hl7v2.hoh.llp;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.CountDownLatch;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.hoh.AbstractHl7OverHttpDecoder;
import ca.uhn.hl7v2.hoh.Hl7OverHttpRequestDecoder;
import ca.uhn.hl7v2.hoh.Hl7OverHttpResponseEncoder;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.util.HTTPUtils;
import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.PipeParser;

public class LlpClientTest {

	private static boolean ourDone;
	private static Hl7OverHttpLowerLayerProtocol ourLlp;
	private static String ourMessage;
	private static int ourPort;
	private static Message ourReply;
	private static MyServerSocketThread ourServerSocketThread;
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(LlpClientTest.class);

	private static SingleCredentialServerCallback ourServerCallback;

	@Test
	public void testSendMessageSimple() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		Connection conn = ConnectionHub.getInstance().attach("localhost", ourPort, PipeParser.getInstanceWithNoValidation(), ourLlp, false);
		Initiator initiator = conn.getInitiator();
		Message response = initiator.sendAndReceive(msg);

		ourLog.info("Received response");

		assertEquals(message, ourMessage);
		assertEquals(ourReply.encode(), response.encode());

	}

	@AfterClass
	public static void afterClass() throws InterruptedException {
		ourLog.info("Marking done as true");
		ourDone = true;
	}

	@BeforeClass
	public static void beforeClass() throws InterruptedException {
		ourPort = RandomServerPortProvider.findFreePort();

		ourLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		ourLlp.setAuthorizationCallback(new SingleCredentialClientCallback("hello", "hapiworld"));
		ourServerCallback = new SingleCredentialServerCallback("hello", "hapiworld");

		ourMessage = (String) null;
		ourServerSocketThread = new MyServerSocketThread();
		ourServerSocketThread.start();
		ourServerSocketThread.myLatch.await();
	}

	private static class MyServerSocketThread extends Thread {
		private CountDownLatch myLatch = new CountDownLatch(1);
		private ServerSocket myServerSocket;

		@Override
		public void run() {

			ourLog.info("Starting server on {}", ourPort);

			Exception ex = null;
			try {
				myServerSocket = new ServerSocket(ourPort);
				myServerSocket.setSoTimeout(1000);

				while (!ourDone) {
					try {
						ourLog.info("Going to accept()");
						Socket newSocket = myServerSocket.accept();
						newSocket.setSoTimeout(1000);
						ourLog.info("New socket: {}", newSocket.getInetAddress().toString());
						MySocketThread t = new MySocketThread(newSocket);
						t.start();
					} catch (SocketTimeoutException e) {
						ourLog.info("No new connection");
					}
					myLatch.countDown();
				}

			} catch (Exception e) {
				ourLog.error("Weird exception!", e);
				ex = e;
			}

			ourLog.info("Shutting down, done is {}", ourDone);

			try {
				myServerSocket.close();
			} catch (IOException e) {
				ourLog.error("Failed to close", e);
			}

			if (ex != null) {
				fail(ex.getMessage());
			}

		}

	}

	private static class MySocketThread extends Thread {

		private Socket mySocket;

		public MySocketThread(Socket theSocket) {
			mySocket = theSocket;
		}

		@Override
		public void run() {

			ourLog.info("Starting socket reader");
			try {
				InputStream is = mySocket.getInputStream();
				OutputStream os = mySocket.getOutputStream();
				while (!ourDone) {

					if (is.available() > 0) {
						ourLog.info("Socket reader has data");

						byte[] bis = IOUtils.readInputStreamIntoByteArraWhileDataAvailable(is);
						ourLog.info("Received input:\n" + new String(bis, HTTPUtils.DEFAULT_CHARSET));

						AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();
						d.setAuthorizationCallback(ourServerCallback);
						d.readHeadersAndContentsFromInputStreamAndDecode(new ByteArrayInputStream(bis));
						ourMessage = d.getMessage();

						Message parsedMessage = PipeParser.getInstanceWithNoValidation().parse(ourMessage);
						ourReply = parsedMessage.generateACK();

						Hl7OverHttpResponseEncoder e = new Hl7OverHttpResponseEncoder();
						e.setMessage(ourReply.encode());

						e.encodeToOutputStream(os);

					} else {
						ourLog.info("Socket reader has NO data");
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							// ignore
						}
					}

				}
			} catch (Exception e) {
				ourLog.info("Failed!", e);
				fail(e.getMessage());
			}

			ourLog.info("Shutting down socket reader");

		}

	}
}
