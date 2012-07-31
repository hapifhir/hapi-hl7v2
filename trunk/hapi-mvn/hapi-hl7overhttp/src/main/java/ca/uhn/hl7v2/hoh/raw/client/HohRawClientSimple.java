package ca.uhn.hl7v2.hoh.raw.client;

import java.io.IOException;
import java.net.Socket;

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
	 * If a socket exists and it is connected, closes the socket. Only required
	 * if {@link #isAutoClose() auto close} mode is false
	 */
	public void close() {
		if (mySocket != null) {
			closeSocket(mySocket);
		}
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

}
