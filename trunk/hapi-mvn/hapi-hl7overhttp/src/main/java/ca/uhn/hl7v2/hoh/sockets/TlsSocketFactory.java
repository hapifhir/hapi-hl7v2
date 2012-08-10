package ca.uhn.hl7v2.hoh.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

/**
 * Socket Factory which creates an encrypted TLS/SSL socket
 */
public class TlsSocketFactory implements ISocketFactory {

	/**
	 * {@inheritDoc}
	 */
	public Socket createClientSocket() throws IOException {
		return SSLSocketFactory.getDefault().createSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket() throws IOException {
		return SSLServerSocketFactory.getDefault().createServerSocket();
	}


}
