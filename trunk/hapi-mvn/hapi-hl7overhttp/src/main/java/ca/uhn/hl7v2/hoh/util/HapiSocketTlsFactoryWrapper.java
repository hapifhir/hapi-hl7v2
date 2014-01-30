package ca.uhn.hl7v2.hoh.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.net.ServerSocketFactory;

import ca.uhn.hl7v2.hoh.sockets.ISocketFactory;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.util.StandardSocketFactory;

/**
 * Wraps an HoH {@link ISocketFactory} instance for use in HAPI. Note that the
 * wrapped methods will only be used to create TLS socket instances.
 */
public class HapiSocketTlsFactoryWrapper implements SocketFactory {

	private ISocketFactory mySocketFactory;

	/**
	 * Constuctor
	 * 
	 * @param theSocketFactoryToWrap
	 *            The socket factory to wrap. This instance will only be used
	 *            for {@link #createTlsSocket()} and
	 *            {@link #createTlsServerSocket()}
	 */
	public HapiSocketTlsFactoryWrapper(ISocketFactory theSocketFactoryToWrap) {
		mySocketFactory = theSocketFactoryToWrap;
	}

	/**
	 * {@inheritDoc}
	 */
	public Socket createSocket() throws IOException {
		return javax.net.SocketFactory.getDefault().createSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public Socket createTlsSocket() throws IOException {
		return mySocketFactory.createClientSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket() throws IOException {
		return ServerSocketFactory.getDefault().createServerSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createTlsServerSocket() throws IOException {
		return mySocketFactory.createServerSocket();
	}

	public void configureNewAcceptedSocket(Socket theSocket) throws SocketException {
		theSocket.setSoTimeout(StandardSocketFactory.DEFAULT_ACCEPTED_SOCKET_TIMEOUT);
	}

}
