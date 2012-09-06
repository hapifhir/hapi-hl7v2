package ca.uhn.hl7v2.app;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

	private static final int SLEEP = 1000;
	private static final int RETRIES = 10;

	public static <T> List<T> fill(T element, int amount) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < amount; i++) {
			list.add(element);
		}
		return list;
	}

	public static Socket acquireClientSocket(int port) throws Exception {
		Socket s = null;
		Exception ex = null;
		int i = 0;
		while (s == null && i < RETRIES) {
			try {
				s = new Socket("localhost", port);
			} catch (Exception e) {
				ex = e;
				Thread.sleep(SLEEP);
			}
		}
		if (s == null)
			throw ex;
		return s;
	}

	public static Connection acquireClientConnection(ConnectionHub hub, int port1,
			int port2) throws Exception {
		Connection c = null;
		Exception ex = null;
		int i = 0;
		while (c == null && i < RETRIES) {
			try {
				c = hub.attach("localhost", port1, port2, false);
			} catch (Exception e) {
				ex = e;
				Thread.sleep(SLEEP);
			}
		}
		if (c == null)
			throw ex;
		return c;
	}

}
