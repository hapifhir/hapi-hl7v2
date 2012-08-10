package ca.uhn.hl7v2.hoh.raw.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;

import org.apache.commons.lang.StringUtils;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpRequestEncoder;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpResponseDecoder;
import ca.uhn.hl7v2.hoh.encoder.NoMessageReceivedException;
import ca.uhn.hl7v2.hoh.raw.api.RawReceivable;
import ca.uhn.hl7v2.hoh.sign.ISigner;
import ca.uhn.hl7v2.hoh.sign.SignatureVerificationException;
import ca.uhn.hl7v2.hoh.sockets.ISocketFactory;
import ca.uhn.hl7v2.hoh.sockets.StandardSocketFactory;

public abstract class AbstractRawClient {
	/**
	 * The default charset encoding (UTF-8)
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	/**
	 * The default connection timeout in milliseconds: 10000
	 */
	private static final int DEFAULT_CONNECTION_TIMEOUT = 10000;

	/**
	 * The default number of milliseconds to wait before timing out waiting for
	 * a response: 60000
	 */
	public static final int DEFAULT_RESPONSE_TIMEOUT = 60000;

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohRawClientSimple.class);

	private IAuthorizationClientCallback myAuthorizationCallback;
	private Charset myCharset = DEFAULT_CHARSET;
	private int myConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
	private String myHost;
	private BufferedInputStream myInputStream;
	private OutputStream myOutputStream;
	private int myPort;
	private long myResponseTimeout = DEFAULT_RESPONSE_TIMEOUT;
	private ISigner mySigner;
	private ISocketFactory mySocketFactory = new StandardSocketFactory();
	private String myUri;

	/**
	 * Constructor
	 * 
	 * @param theHost
	 *            The HOST (name/address). E.g. "192.168.1.1"
	 * @param thePort
	 *            The PORT. E.g. "8080"
	 * @param theUri
	 *            The URI being requested (must either be blank or start with
	 *            '/' and contain a path). E.g. "/Apps/Receiver.jsp"
	 */
	public AbstractRawClient(String theHost, int thePort, String theUri) {
		myHost = theHost;
		myPort = thePort;
		myUri = theUri;

		if (StringUtils.isBlank(theHost)) {
			throw new IllegalArgumentException("Host can not be blank/null");
		}
		if (StringUtils.isBlank(theUri)) {
			myUri = "/";
		}
		if (!theUri.startsWith("/") || theUri.contains(" ")) {
			// TODO check for other reserved chars, maybe also add this
			// validation
			// to encoder classes
			throw new IllegalArgumentException("Invalid URI");
		}
		if (thePort <= 0) {
			throw new IllegalArgumentException("Port must be a positive integer");
		}
	}

	protected void closeSocket(Socket theSocket) {
		ourLog.debug("Closing socket");
		try {
			theSocket.close();
		} catch (IOException e) {
			ourLog.warn("Problem closing socket", e);
		}
	}

	protected Socket connect() throws IOException {
		ourLog.debug("Creating new connection to {}:{} for URI {}", new Object[] { myHost, myPort, myUri });

		Socket socket = mySocketFactory.createClientSocket();
		socket.connect(new InetSocketAddress(myHost, myPort), myConnectionTimeout);
		socket.setSoTimeout(500);
		ourLog.trace("Connection established to {}:{}", myHost, myPort);
		myOutputStream = new BufferedOutputStream(socket.getOutputStream());
		myInputStream = new BufferedInputStream(socket.getInputStream());
		return socket;
	}

	/**
	 * Sends a message, waits for the response, and then returns the response if
	 * any
	 * 
	 * @param theMessageToSend
	 *            The message to send
	 * @return The returned message, as well as associated metadata
	 * @throws DecodeException
	 *             If a problem occurs (read error, socket disconnect, etc.)
	 *             during communication, or the response is invalid in some way.
	 *             Note that IO errors in trying to connect to the remote host
	 *             or sending the message are thrown directly (i.e. as
	 *             {@link IOException}), but IO errors in reading the response
	 *             are thrown as DecodeException
	 * @throws IOException
	 *             If the client is unable to connect to the remote host
	 * @throws EncodeException
	 *             If a failure occurs while encoding the message into a
	 *             sendable HTTP request
	 */
	protected IReceivable<String> doSendAndReceive(ISendable theMessageToSend) throws DecodeException, IOException, EncodeException {

		Socket socket = provideSocket();
		try {
			return doSendAndReceiveInternal(theMessageToSend, socket);
		} catch (DecodeException e) {
			closeSocket(socket);
			throw e;
		} catch (IOException e) {
			ourLog.debug("Caught IOException, going to close socket", e);
			closeSocket(socket);
			throw e;
		} catch (SignatureVerificationException e) {
			ourLog.debug("Failed to verify message signature", e);
			throw new DecodeException("Failed to verify message signature", e);
		} finally {
			returnSocket(socket);
		}

	}

	private IReceivable<String> doSendAndReceiveInternal(ISendable theMessageToSend, Socket socket) throws IOException, DecodeException, SignatureVerificationException, EncodeException {
		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setUri(myUri);
		enc.setHost(myHost);
		enc.setPort(myPort);
		enc.setCharset(myCharset);
		if (myAuthorizationCallback != null) {
			enc.setUsername(myAuthorizationCallback.provideUsername(myUri));
			enc.setPassword(myAuthorizationCallback.providePassword(myUri));
		}
		enc.setSigner(mySigner);
		enc.setDataProvider(theMessageToSend);

		ourLog.debug("Writing message to OutputStream");
		enc.encodeToOutputStream(myOutputStream);
		myOutputStream.flush();

		ourLog.debug("Reading response from OutputStream");

		RawReceivable response = null;
		long endTime = System.currentTimeMillis() + myResponseTimeout;
		do {
			try {
				Hl7OverHttpResponseDecoder d = new Hl7OverHttpResponseDecoder();
				d.setSigner(mySigner);
				d.readHeadersAndContentsFromInputStreamAndDecode(myInputStream);

				response = new RawReceivable(d.getMessage());
				InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String hostAddress = remoteSocketAddress.getAddress() != null ? remoteSocketAddress.getAddress().getHostAddress() : null;
				response.addMetadata(MessageMetadataKeys.REMOTE_HOST_ADDRESS.name(), hostAddress);

			} catch (NoMessageReceivedException ex) {
				ourLog.debug("No message received yet");
			} catch (IOException e) {
				throw new DecodeException("Failed to read response from remote host", e);
			}
		} while (response == null && System.currentTimeMillis() < endTime);

		return response;
	}

	/**
	 * Returns the socket factory used by this client
	 */
	public ISocketFactory getSocketFactory() {
		return mySocketFactory;
	}

	/**
	 * Subclasses must override to provide a connected socket
	 */
	protected abstract Socket provideSocket() throws IOException;

	/**
	 * Returns the socket provided by {@link #provideSocket()}. This method will
	 * always be called after the request is finished.
	 */
	protected abstract void returnSocket(Socket theSocket);

	/**
	 * If set, provides a callback which will be used to se the username and
	 * password associated with the request
	 */
	public void setAuthorizationCallback(IAuthorizationClientCallback theAuthorizationCallback) {
		myAuthorizationCallback = theAuthorizationCallback;
	}

	/**
	 * <p>
	 * Sets the charset to use for requests from this client. May be changed at
	 * any time.
	 * </p>
	 * <p>
	 * Default is UTF-8
	 * </p>
	 */
	public void setCharset(Charset theCharset) {
		if (theCharset == null) {
			throw new NullPointerException("Charset can not be null");
		}
		myCharset = theCharset;
	}

	/**
	 * Sets the number of milliseconds before timing out. Default is
	 * {@link #DEFAULT_RESPONSE_TIMEOUT}
	 * 
	 * @param theResponseTimeout
	 *            The millis to wait before timeout.
	 * @see #DEFAULT_RESPONSE_TIMEOUT
	 */
	public void setResponseTimeout(long theResponseTimeout) {
		if (theResponseTimeout <= 0) {
			throw new IllegalArgumentException("Timeout can not be <= 0");
		}
		myResponseTimeout = theResponseTimeout;
	}

	/**
	 * @param theSigner
	 *            If provided, sets the Signature Profile signer implementation
	 *            to use. See <a href=
	 *            "http://hl7api.sourceforge.net/hapi-hl7overhttp/specification.html#SIGNATURE_PROFILE"
	 *            >http://hl7api.sourceforge.net/hapi-hl7overhttp/specification.
	 *            html#SIGNATURE_PROFILE</a>
	 */
	public void setSigner(ISigner theSigner) {
		mySigner = theSigner;
	}

	/**
	 * Sets the socket factory used by this client. Default is {@link StandardSocketFactory}.
	 * 
	 * @see ISocketFactory
	 */
	public void setSocketFactory(ISocketFactory theSocketFactory) {
		if (theSocketFactory == null) {
			throw new NullPointerException("Socket factory can not be null");
		}
		mySocketFactory = theSocketFactory;
	}
}
