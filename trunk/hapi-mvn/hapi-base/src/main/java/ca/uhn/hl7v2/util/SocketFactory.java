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
	
}
