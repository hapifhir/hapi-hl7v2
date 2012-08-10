package ca.uhn.hl7v2.hoh.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Pluggable interface for creating new sockets
 */
public interface ISocketFactory {

	/**
	 * Creates a new client socket and returns it
	 */
	Socket createClientSocket() throws IOException;
	
	/**
	 * Creates a new server socket and returns it
	 * @throws IOException 
	 */
	ServerSocket createServerSocket() throws IOException;
	
}
