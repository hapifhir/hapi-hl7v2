package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StandardSocketFactory implements SocketFactory {

	/**
	 * {@inheritDoc}
	 */
	public Socket createSocket() throws IOException {
		Socket retVal = javax.net.SocketFactory.getDefault().createSocket();
		retVal.setKeepAlive(true);
		retVal.setTcpNoDelay(true);
		return retVal;
	}

	/**
	 * {@inheritDoc} 
	 */
	public Socket createTlsSocket() throws IOException {
		Socket retVal = javax.net.ssl.SSLSocketFactory.getDefault().createSocket();
		retVal.setKeepAlive(true);
        retVal.setTcpNoDelay(true);
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

}
