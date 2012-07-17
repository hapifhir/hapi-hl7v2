package ca.uhn.hl7v2.parser;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Provides server ports
 */
public class RandomServerPortProvider {

	public static int findFreePort() {
		ServerSocket server;
		try {
			server = new ServerSocket(0);
			int port = server.getLocalPort();
			server.close();
			return port;
		} catch (IOException e) {
			throw new Error(e);
		}
	}

}
