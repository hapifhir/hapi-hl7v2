package ca.uhn.hl7v2.hoh.llp;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import ca.uhn.hl7v2.hoh.api.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpRequestDecoder;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpResponseEncoder;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;

public class ServerSocketThreadForTesting extends Thread {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ServerSocketThreadForTesting.class);

	private String myContentType;
	private boolean myDone;
	private EncodingStyle myEncoding;
	private CountDownLatch myLatch = new CountDownLatch(1);
	private String myMessage;
	private int myPort;
	private Message myReply;
	private IAuthorizationServerCallback myServerAuthCallback;
	private ServerSocket myServerSocket;
	private boolean mySimulateOneSecondPauseInChunkedEncoding;
	private int myConnectionCount = 0;

	public ServerSocketThreadForTesting(int thePort) {
		myPort = thePort;
	}

	public ServerSocketThreadForTesting(int thePort, IAuthorizationServerCallback theServerAuthCallback) {
		myPort = thePort;
		myServerAuthCallback = theServerAuthCallback;
	}

	public void done() {
		myDone = true;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return myContentType;
	}

	/**
	 * @return the encoding
	 */
	public EncodingStyle getEncoding() {
		return myEncoding;
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

		myConnectionCount = 0;
		
		Exception ex = null;
		try {
			myServerSocket = new ServerSocket(myPort);
			myServerSocket.setSoTimeout(1000);

			while (!myDone) {
				try {
					ourLog.trace("Going to accept()");
					Socket newSocket = myServerSocket.accept();
					myConnectionCount++;
					newSocket.setSoTimeout(1000);
					ourLog.info("New socket: {}", newSocket.getInetAddress().toString());
					TestSocketThread t = new TestSocketThread(newSocket);
					t.start();
				} catch (SocketTimeoutException e) {
					ourLog.trace("No new connection");
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
	 * @return the connectionCount
	 */
	public int getConnectionCount() {
		return myConnectionCount;
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

	public void setSimulateOneSecondPauseInChunkedEncoding(boolean theB) {
		mySimulateOneSecondPauseInChunkedEncoding = theB;
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

//						byte[] bis = IOUtils.readInputStreamIntoByteArraWhileDataAvailable(is);
//						ourLog.info("Received input:\n" + new String(bis, HTTPUtils.DEFAULT_CHARSET));

						Hl7OverHttpRequestDecoder d = new Hl7OverHttpRequestDecoder();
						d.setAuthorizationCallback(myServerAuthCallback);
						d.readHeadersAndContentsFromInputStreamAndDecode(is);
						myMessage = d.getMessage();
						myContentType = d.getContentType();
						myEncoding = d.getEncodingStyle();

						Message parsedMessage = GenericParser.getInstanceWithNoValidation().parse(myMessage);
						myReply = parsedMessage.generateACK();

						Hl7OverHttpResponseEncoder e = new Hl7OverHttpResponseEncoder();
						e.setMessage(myReply.encode());

						if (mySimulateOneSecondPauseInChunkedEncoding) {
							e.encode();
							e.getHeaders().remove("Content-Length");
							e.getHeaders().put("Transfer-Encoding", "chunked");
							
							OutputStream tempOs = os;
							tempOs.write("HTTP/1.1 200 OK\r\n".getBytes("ISO-8859-1"));
							for (Map.Entry<String, String> next : e.getHeaders().entrySet()) {
								String nextHeader = next.getKey() + ": " + next.getValue();
								ourLog.debug("Sending response header - " + nextHeader);
								tempOs.write((nextHeader + "\r\n").getBytes("ISO-8859-1"));
							}
							
							tempOs.write("\r\n".getBytes("ISO-8859-1"));
							
							byte[] bytes = e.getData();
							int halfLength = bytes.length / 2;
							
							String chunkLength = Integer.toHexString(halfLength);
							ourLog.debug("Sending chunk length: {}", halfLength);
							
							tempOs.write(chunkLength.getBytes("ISO-8859-1"));
							tempOs.write("\r\n".getBytes("ISO-8859-1"));
							tempOs.write(bytes, 0, halfLength);
							tempOs.write("\r\n".getBytes("ISO-8859-1"));
							tempOs.flush();

							Thread.sleep(1000);
							
							int remaining = bytes.length - halfLength;
							
							String remChunkLength = Integer.toHexString(remaining);
							ourLog.debug("Sending chunk length: {}", remaining);
							tempOs.write(remChunkLength.getBytes("ISO-8859-1"));
							tempOs.write("\r\n".getBytes("ISO-8859-1"));
							tempOs.write(bytes, halfLength, remaining);
							tempOs.write("\r\n".getBytes("ISO-8859-1"));
							
							tempOs.write("0\r\n\r\n\r\n".getBytes("ISO-8859-1"));
							tempOs.flush();
							
						} else {
							
							e.encodeToOutputStream(os);
							
						}

					} else {
						ourLog.trace("Socket reader has NO data");
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