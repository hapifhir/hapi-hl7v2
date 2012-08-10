package ca.uhn.hl7v2.hoh.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket Factory which returns a normal, non encrypted TCP socket
 */
public class StandardSocketFactory implements ISocketFactory {

	public Socket createClientSocket() {
		return new Socket();
	}

	public ServerSocket createServerSocket() throws IOException {
		return new ServerSocket();
	}

}
