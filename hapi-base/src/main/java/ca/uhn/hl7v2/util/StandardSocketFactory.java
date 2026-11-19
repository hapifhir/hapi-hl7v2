package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class StandardSocketFactory implements SocketFactory {

	/**
	 * Default value for {@link #getAcceptedSocketTimeout()}
	 */
	public static final int DEFAULT_ACCEPTED_SOCKET_TIMEOUT = 500;

	private int myAcceptedSocketTimeout = DEFAULT_ACCEPTED_SOCKET_TIMEOUT;
	private int myConnectTimeout = 0;

	/**
	 * Gets the value for {@link Socket#setSoTimeout(int)} to be set on newly accepted sockets in server applications. Default is {@link #DEFAULT_ACCEPTED_SOCKET_TIMEOUT}
	 */
	public int getAcceptedSocketTimeout() {
		return myAcceptedSocketTimeout;
	}

	/**
	 * Sets the value for {@link Socket#setSoTimeout(int)} to be set on newly accepted sockets in server applications
	 */
	public void setAcceptedSocketTimeout(int theAcceptedSocketTimeout) {
		if (theAcceptedSocketTimeout < 0) {
			throw new IllegalArgumentException("Timeout can't be negative");
		}
		myAcceptedSocketTimeout = theAcceptedSocketTimeout;
	}

	/**
	 * {@inheritDoc}
	 * Default is 0 (no timeout).
	 */
	@Override
	public int getConnectTimeout() {
		return myConnectTimeout;
	}

	/**
	 * Sets the timeout in milliseconds used when client connections connect a socket created by
	 * this factory to the remote host. If the connection is not established within this time,
	 * the connect attempt fails with a {@link java.net.SocketTimeoutException}. A value of 0
	 * (the default) means no timeout.
	 */
	public void setConnectTimeout(int theConnectTimeout) {
		if (theConnectTimeout < 0) {
			throw new IllegalArgumentException("Timeout can't be negative");
		}
		myConnectTimeout = theConnectTimeout;
	}

	/**
	 * {@inheritDoc}
	 */
	public Socket createSocket() throws IOException {
		Socket retVal = javax.net.SocketFactory.getDefault().createSocket();
		retVal.setKeepAlive(true);
		retVal.setTcpNoDelay(true);
		retVal.setSoTimeout(myAcceptedSocketTimeout);
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 */
	public Socket createTlsSocket() throws IOException {
		Socket retVal = javax.net.ssl.SSLSocketFactory.getDefault().createSocket();
		retVal.setKeepAlive(true);
		retVal.setTcpNoDelay(true);
		retVal.setSoTimeout(myAcceptedSocketTimeout);
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket() throws IOException {
		return javax.net.ServerSocketFactory.getDefault().createServerSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createTlsServerSocket() throws IOException {
		return javax.net.ssl.SSLServerSocketFactory.getDefault().createServerSocket();
	}

	public void configureNewAcceptedSocket(Socket theSocket) throws SocketException {
		theSocket.setSoTimeout(myAcceptedSocketTimeout);
	}

}
