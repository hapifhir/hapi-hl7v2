package ca.uhn.hl7v2.hoh.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides server ports
 */
public class RandomServerPortProvider {

	private static final List<Integer> ourPorts = new ArrayList<>();
	
	public static int findFreePort() {
		ServerSocket server;
		try {
			server = new ServerSocket(0);
			int port = server.getLocalPort();
			ourPorts.add(port);
			server.close();
			Thread.sleep(500);
			return port;
		} catch (IOException | InterruptedException e) {
			throw new Error(e);
		}
	}

	public static List<Integer> list() {
		return ourPorts;
	}

}
 