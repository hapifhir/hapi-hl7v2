package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Pluggable socket factory interface
 */
public interface SocketFactory {

	/**
	 * Create a standard client socket
	 */
	Socket createSocket() throws IOException;
	
	/**
	 * Create a TLS client socket
	 */
	Socket createTlsSocket() throws IOException;
	
	/**
	 * Create a standard server socket
	 */	
	ServerSocket createServerSocket() throws IOException;
	
	/**
	 * Create a TLS server socket
	 */
	ServerSocket createTlsServerSocket() throws IOException;

	/**
	 * Invoked by server processes each time a new server is {@link ServerSocket#accept() accepted}
	 * in order to set configuration settings on the new socket
	 */
	void configureNewAcceptedSocket(Socket theSocket) throws SocketException;

	/**
	 * Returns the timeout in milliseconds that client connections use when a socket created by
	 * {@link #createSocket()} or {@link #createTlsSocket()} is
	 * {@link Socket#connect(java.net.SocketAddress, int) connected} to the remote host.
	 * A value of zero means no timeout: the connect attempt blocks until it succeeds or
	 * the operating system gives up.
	 * <p>
	 * The default implementation returns zero, which keeps the previous behaviour.
	 * </p>
	 */
	default int getConnectTimeout() {
		return 0;
	}
	
}
