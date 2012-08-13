package ca.uhn.hl7v2.hoh.raw.client;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.sockets.TlsSocketFactory;

/**
 * <p>
 * Simple raw message sender using the HL7 over HTTP specification.
 * </p>
 * <p>
 * This connector uses no external threads, so it is suitable for use within
 * J2EE containers.
 * </p>
 */
public class HohRawClientSimple extends AbstractRawClient {

	private boolean myAutoClose = true;
	private Socket mySocket;

	/**
	 * Constructor
	 * 
	 * @param theUrl
	 *            The URL to connect to
	 */
	public HohRawClientSimple(URL theUrl) {
		super(theUrl);
	}

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
	public HohRawClientSimple(String theHost, int thePort, String theUri) {
		super(theHost, thePort, theUri);
	}

	/**
	 * If a socket exists and it is connected, closes the socket. Only required
	 * if {@link #isAutoClose() auto close} mode is false
	 */
	public void close() {
		if (mySocket != null) {
			closeSocket(mySocket);
		}
	}

	/**
	 * @return Should the socket auto-close
	 * @see #setAutoClose(boolean)
	 */
	public boolean isAutoClose() {
		return myAutoClose;
	}

	/**
	 * @return Returns true if there is a socket, and it appears to be connected
	 *         and not shut down
	 */
	public boolean isConnected() {
		return mySocket != null && !mySocket.isClosed() && !mySocket.isInputShutdown() && !mySocket.isOutputShutdown();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Socket provideSocket() throws IOException {
		if (mySocket == null || mySocket.isClosed() || mySocket.isInputShutdown() || mySocket.isOutputShutdown()) {
			mySocket = connect();
		}
		return mySocket;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void returnSocket(Socket theSocket) {
		if (isAutoClose()) {
			close();
		}
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
	public IReceivable<String> sendAndReceive(ISendable theMessageToSend) throws DecodeException, IOException, EncodeException {
		return super.doSendAndReceive(theMessageToSend);
	}

	/**
	 * <p>
	 * Sets the auto-close property. If set to true (which is the default), the
	 * client will close the socket between each request. If set to
	 * <code>false</code>, the client will keep the socket open between
	 * requests.
	 * </p>
	 * <p>
	 * If auto-close is disabled, sockets will never automatically disconnect,
	 * which some servers may not like. The socket can still be closed by
	 * calling {@link #close()}.
	 * </p>
	 */
	public void setAutoClose(boolean theAutoClose) {
		myAutoClose = theAutoClose;
	}

	public static void main(String[] args) {
		
		/*
		 * http://localhost:8080/AppContext
		 */
		String host = "localhost";
		int port = 8080;
		String uri = "/AppContext";
		
		// Create a client
		HohRawClientSimple client = new HohRawClientSimple(host, port, uri);

		// Set the socket factory to use TLS
		client.setSocketFactory(new TlsSocketFactory());
		
		// Optionally, if credentials should be sent, they 
		// can be provided using a credential callback
		IAuthorizationClientCallback authCalback = new SingleCredentialClientCallback("ausername", "somepassword");
		client.setAuthorizationCallback(authCalback);
		
		// The ISendable defines the object that provides the actual
		// message to send
		String message = 
			"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + 
			"EVN||200803051509\r" + 
			"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";
		ISendable sendable = new RawSendable(message);
		
		try {
			// sendAndReceive actually sends the message
			IReceivable<String> receivable = client.sendAndReceive(sendable);
			
			// receivavle.getRawMessage() provides the response
			System.out.println("Response was:\n" + receivable.getMessage());
			
			// IReceivable also stores metadata about the message
			String remoteHostIp = (String) receivable.getMetadata().get(MessageMetadataKeys.REMOTE_HOST_ADDRESS);
			System.out.println("From:\n" + remoteHostIp);
			
		} catch (DecodeException e) {
			// Thrown if the response can't be read
			e.printStackTrace();
		} catch (IOException e) {
			// Thrown if communication fails
			e.printStackTrace();
		} catch (EncodeException e) {
			// Thrown if the message can't be encoded (generally a programming bug)
			e.printStackTrace();
		}
		
	}
	
}
