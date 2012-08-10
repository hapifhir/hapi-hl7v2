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

import ca.uhn.hl7v2.hoh.api.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpRequestDecoder;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpResponseEncoder;
import ca.uhn.hl7v2.hoh.util.HTTPUtils;
import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;

public class ServerSocketThreadForTesting extends Thread {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ServerSocketThreadForTesting.class);
	
	private boolean myDone;
	private CountDownLatch myLatch = new CountDownLatch(1);
	private String myMessage;
	private Message myReply;
	private ServerSocket myServerSocket;
	private IAuthorizationServerCallback myServerAuthCallback;

	private int myPort;
	
	public ServerSocketThreadForTesting(int thePort, IAuthorizationServerCallback theServerAuthCallback) {
		myPort = thePort;
		myServerAuthCallback = theServerAuthCallback;
	}
	
	public ServerSocketThreadForTesting(int thePort) {
		myPort = thePort;
	}

	public void done() {
		myDone = true;
	}

	/**
	 * @return the latch
	 */
	public CountDownLatch getLatch() {
		return myLatch;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return myMessage;
	}

	/**
	 * @return the reply
	 */
	public Message getReply() {
		return myReply;
	}

	@Override
	public void run() {

		ourLog.info("Starting server on {}", myPort);

		Exception ex = null;
		try {
			myServerSocket = new ServerSocket(myPort);
			myServerSocket.setSoTimeout(1000);

			while (!myDone) {
				try {
					ourLog.info("Going to accept()");
					Socket newSocket = myServerSocket.accept();
					newSocket.setSoTimeout(1000);
					ourLog.info("New socket: {}", newSocket.getInetAddress().toString());
					TestSocketThread t = new TestSocketThread(newSocket);
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

		ourLog.info("Shutting down, done is {}", myDone);

		try {
			myServerSocket.close();
		} catch (IOException e) {
			ourLog.error("Failed to close", e);
		}

		if (ex != null) {
			fail(ex.getMessage());
		}

	}

	/**
	 * @param theMessage
	 *            the message to set
	 */
	public void setMessage(String theMessage) {
		myMessage = theMessage;
	}

	/**
	 * @param theReply
	 *            the reply to set
	 */
	public void setReply(Message theReply) {
		myReply = theReply;
	}

	public class TestSocketThread extends Thread {

		private Socket mySocket;

		public TestSocketThread(Socket theSocket) {
			mySocket = theSocket;
		}

		@Override
		public void run() {

			ourLog.info("Starting socket reader");
			try {
				InputStream is = mySocket.getInputStream();
				OutputStream os = mySocket.getOutputStream();
				while (!myDone) {

					if (is.available() > 0) {
						ourLog.info("Socket reader has data");

						byte[] bis = IOUtils.readInputStreamIntoByteArraWhileDataAvailable(is);
						ourLog.info("Received input:\n" + new String(bis, HTTPUtils.DEFAULT_CHARSET));

						Hl7OverHttpRequestDecoder d = new Hl7OverHttpRequestDecoder();
						d.setAuthorizationCallback(myServerAuthCallback);
						d.readHeadersAndContentsFromInputStreamAndDecode(new ByteArrayInputStream(bis));
						myMessage = d.getMessage();

						Message parsedMessage = PipeParser.getInstanceWithNoValidation().parse(myMessage);
						myReply = parsedMessage.generateACK();

						Hl7OverHttpResponseEncoder e = new Hl7OverHttpResponseEncoder();
						e.setMessage(myReply.encode());

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