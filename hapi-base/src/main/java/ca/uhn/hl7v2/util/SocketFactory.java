package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
	
}
