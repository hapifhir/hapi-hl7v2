package ca.uhn.hl7v2.hoh.raw.client;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.api.IClientSimple;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.sockets.TlsSocketFactory;

/**
 * <p>
 * Simple raw message sender using the HL7 over HTTP specification. This implementation 
 * makes use of a single connection so it is simple, but may only be used to send
 * one message at time (per instance).
 * </p>
 * <p>
 * This client uses no external threads, so it is suitable for use within
 * J2EE containers.
 * </p>
 */
public class HohRawClientSimple extends AbstractRawClient implements IClientSimple {

	private boolean myAutoClose = true;
	private Socket mySocket;

	/**
	 * Constructor
	 * 
	 * @param theHost
	 *            The HOST (name/address). E.g. "192.168.1.1"
	 * @param thePort
	 *            The PORT. E.g. "8080"
	 * @param theUriPath
	 *            The URI path being requested (must either be blank or start with
	 *            '/' and contain a path). E.g. "/Apps/Receiver.jsp"
	 */
	public HohRawClientSimple(String theHost, int thePort, String theUriPath) {
		super(theHost, thePort, theUriPath);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized IReceivable<String> sendAndReceive(ISendable<?> theMessageToSend) throws DecodeException, IOException, EncodeException {
		// **** Overridden to add synchronization
		return super.sendAndReceive(theMessageToSend);
	}

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
	 * {@inheritDoc}
	 */
	public void close() {
		if (mySocket != null) {
			closeSocket(mySocket);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAutoClose() {
		return myAutoClose;
	}

	/* (non-Javadoc)
	 * @see ca.uhn.hl7v2.hoh.raw.client.IClientSimple#isConnected()
	 */
	public boolean isConnected() {
		return isSocketConnected(mySocket);
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
	 * {@inheritDoc}
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
		String message = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + "EVN||200803051509\r" + "PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";
		ISendable<?> sendable = new RawSendable(message);

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
			// Thrown if the message can't be encoded (generally a programming
			// bug)
			e.printStackTrace();
		}

	}

}
