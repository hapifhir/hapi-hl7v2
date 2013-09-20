package ca.uhn.hl7v2.hoh.raw.client;

import static ca.uhn.hl7v2.hoh.util.StringUtils.isBlank;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.api.IClient;
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
import ca.uhn.hl7v2.hoh.sockets.TlsSocketFactory;

public abstract class AbstractRawClient implements IClient {

	/**
	 * The default charset encoding (UTF-8)
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	/**
	 * The default connection timeout in milliseconds: 10000
	 */
	public static final int DEFAULT_CONNECTION_TIMEOUT = 10000;

	/**
	 * The default number of milliseconds to wait before timing out waiting for
	 * a response: 60000
	 */
	public static final int DEFAULT_RESPONSE_TIMEOUT = 60000;

	private static final StandardSocketFactory DEFAULT_SOCKET_FACTORY = new StandardSocketFactory();

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohRawClientSimple.class);

	private IAuthorizationClientCallback myAuthorizationCallback;
	private Charset myCharset = DEFAULT_CHARSET;
	private int myConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
	private String myHost;
	private BufferedInputStream myInputStream;
	private boolean myKeepAlive = true;
	private OutputStream myOutputStream;
	private String myPath;
	private int myPort;
	private long myResponseTimeout = DEFAULT_RESPONSE_TIMEOUT;
	private ISigner mySigner;
	private ISocketFactory mySocketFactory = DEFAULT_SOCKET_FACTORY;
	/**
	 * Socket so_timeout value for newly created sockets
	 */
	private int mySoTimeout = 5000;
	private URL myUrl;
	/**
	 * Constructor
	 */
	public AbstractRawClient() {
		// nothing
	}
	/**
	 * Constructor
	 * 
	 * @param theHost
	 *            The HOST (name/address). E.g. "192.168.1.1"
	 * @param thePort
	 *            The PORT. E.g. "8080"
	 * @param thePath
	 *            The path being requested (must either be blank or start with
	 *            '/' and contain a path). E.g. "/Apps/Receiver.jsp"
	 */
	public AbstractRawClient(String theHost, int thePort, String thePath) {
		setHost(theHost);
		setPort(thePort);
		setUriPath(thePath);
	}
	/**
	 * Constructor
	 * 
	 * @param theUrl
	 *            The URL to connect to. Note that if the URL refers to the
	 *            "https" protocol, a {@link #setSocketFactory(ISocketFactory)
	 *            SocketFactory} which uses TLS will be set. If custom
	 *            certificates are used, a different factory may need to be
	 *            provided manually.
	 */
	public AbstractRawClient(URL theUrl) {
		setUrl(theUrl);
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
		ourLog.debug("Creating new connection to {}:{} for URI {}", new Object[] { myHost, myPort, myPath });

		Socket socket = mySocketFactory.createClientSocket();
		socket.connect(new InetSocketAddress(myHost, myPort), myConnectionTimeout);
		socket.setSoTimeout(mySoTimeout);
		socket.setKeepAlive(myKeepAlive);
		ourLog.trace("Connection established to {}:{}", myHost, myPort);
		myOutputStream = new BufferedOutputStream(socket.getOutputStream());
		myInputStream = new BufferedInputStream(socket.getInputStream());
		return socket;
	}

	private IReceivable<String> doSendAndReceiveInternal(ISendable<?> theMessageToSend, Socket socket) throws IOException, DecodeException, SignatureVerificationException, EncodeException {
		ourLog.trace("Entering doSendAndReceiveInternal()");
		
		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setPath(myPath);
		enc.setHost(myHost);
		enc.setPort(myPort);
		enc.setCharset(myCharset);
		if (myAuthorizationCallback != null) {
			enc.setUsername(myAuthorizationCallback.provideUsername(myPath));
			enc.setPassword(myAuthorizationCallback.providePassword(myPath));
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
				d.setReadTimeout(myResponseTimeout);
				d.readHeadersAndContentsFromInputStreamAndDecode(myInputStream);

				response = new RawReceivable(d.getMessage());
				InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String hostAddress = remoteSocketAddress.getAddress() != null ? remoteSocketAddress.getAddress().getHostAddress() : null;
				response.addMetadata(MessageMetadataKeys.REMOTE_HOST_ADDRESS.name(), hostAddress);

				if (d.isConnectionCloseHeaderPresent()) {
					ourLog.debug("Found Connection=close header, closing socket");
					closeSocket(socket);
				}
				
			} catch (NoMessageReceivedException ex) {
				ourLog.debug("No message received yet");
			} catch (IOException e) {
				throw new DecodeException("Failed to read response from remote host", e);
			}
		} while (response == null && System.currentTimeMillis() < endTime);

		ourLog.trace("Leaving doSendAndReceiveInternal()");
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uhn.hl7v2.hoh.raw.client.IClient#getHost()
	 */
	public String getHost() {
		return myHost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uhn.hl7v2.hoh.raw.client.IClient#getPort()
	 */
	public int getPort() {
		return myPort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uhn.hl7v2.hoh.raw.client.IClient#getSocketFactory()
	 */
	public ISocketFactory getSocketFactory() {
		return mySocketFactory;
	}

	public int getSoTimeout() {
		return mySoTimeout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uhn.hl7v2.hoh.raw.client.IClient#getUri()
	 */
	public String getUriPath() {
		return myPath;
	}

	/**
	 * {@inheritDoc}
	 */
	public URL getUrl() {
		return myUrl;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUrlString() {
		return getUrl().toExternalForm();
	}

	public boolean isKeepAlive() {
		return myKeepAlive;
	}

	boolean isSocketConnected(Socket socket) {
		return socket != null && !socket.isClosed() && !socket.isInputShutdown() && !socket.isOutputShutdown();
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
	public synchronized IReceivable<String> sendAndReceive(ISendable<?> theMessageToSend) throws DecodeException, IOException, EncodeException {

		Socket socket = provideSocket();
		try {
			return doSendAndReceiveInternal(theMessageToSend, socket);
		} catch (DecodeException e) {
			ourLog.debug("Decode exception, going to close socket", e);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uhn.hl7v2.hoh.raw.client.IClient#setAuthorizationCallback(ca.uhn.hl7v2
	 * .hoh.api.IAuthorizationClientCallback)
	 */
	public void setAuthorizationCallback(IAuthorizationClientCallback theAuthorizationCallback) {
		myAuthorizationCallback = theAuthorizationCallback;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setCharset(Charset theCharset) {
		if (theCharset == null) {
			throw new NullPointerException("Charset can not be null");
		}
		myCharset = theCharset;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHost(String theHost) {
		myHost = theHost;
		if (isBlank(theHost)) {
			throw new IllegalArgumentException("Host can not be blank/null");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setKeepAlive(boolean theKeepAlive) {
		myKeepAlive = theKeepAlive;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setPort(int thePort) {
		myPort = thePort;
		if (thePort <= 0) {
			throw new IllegalArgumentException("Port must be a positive integer");
		}
	}


	/**
	 * {@inheritDoc}
	 */
	public void setResponseTimeout(long theResponseTimeout) {
		if (theResponseTimeout <= 0) {
			throw new IllegalArgumentException("Timeout can not be <= 0");
		}
		myResponseTimeout = theResponseTimeout;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSigner(ISigner theSigner) {
		mySigner = theSigner;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSocketFactory(ISocketFactory theSocketFactory) {
		if (theSocketFactory == null) {
			throw new NullPointerException("Socket factory can not be null");
		}
		mySocketFactory = theSocketFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSoTimeout(int theSoTimeout) {
		mySoTimeout = theSoTimeout;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUriPath(String thePath) {
		myPath = thePath;

		if (isBlank(thePath)) {
			myPath = "/";
		}
		if (!thePath.startsWith("/")) {
			throw new IllegalArgumentException("Invalid URI (must start with '/'): " + thePath);
		} else if (thePath.contains(" ")) {
			throw new IllegalArgumentException("Invalid URI: " + thePath);
		}
		
		// Validate for syntax
		try {
			new URI("http://localhost" + thePath);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Invalid URI: " + thePath);
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUrl(URL theUrl) {
		setHost(extractHost(theUrl));
		setPort(extractPort(theUrl));
		setUriPath(extractUri(theUrl));

		myUrl = theUrl;

		if (getSocketFactory() == DEFAULT_SOCKET_FACTORY && theUrl.getProtocol().toLowerCase().equals("https")) {
			setSocketFactory(new TlsSocketFactory());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUrlString(String theString) {
		try {
			URL url = new URL(theString);
			setUrl(url);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("URL is not valid. Must be in the form http[s]:");
		}
		String protocol = myUrl.getProtocol().toLowerCase();
		if (!protocol.equals("http") && !protocol.equals("https")) {
			throw new IllegalStateException("URL protocol must be http or https");
		}

	}

	private static String extractHost(URL theUrl) {
		return theUrl.getHost();
	}

	private static int extractPort(URL theUrl) {
		return theUrl.getPort() != -1 ? theUrl.getPort() : theUrl.getDefaultPort();
	}

	private static String extractUri(URL theUrl) {
		return theUrl.getPath();
	}
}
