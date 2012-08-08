package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * Provides server ports
 */
public class RandomServerPortProvider {

	public static int findFreePort() {
		ServerSocket server = null;
		try {
			server = new ServerSocket();
			// Allow the socket to be bound even if it is still in TIME_WAIT state
			server.setReuseAddress(true);
			server.bind(new InetSocketAddress(0));
			int port = server.getLocalPort();
			return port;
		} catch (IOException e) {
			throw new Error(e);
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {}
			}
		}
	}

}
