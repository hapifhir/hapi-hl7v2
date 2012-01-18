package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.junit.Test;

import junit.framework.Assert;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

public class SimpleServerTest implements ConnectionListener {

	private int myConnects = 0;
	private int myDisconnects = 0;

	@Test
	public void testDetectConnectAndDisconnect() throws Throwable {

		int port = RandomServerPortProvider.findFreePort();
		SimpleServer ss = new SimpleServer(port);
		ss.registerConnectionListener(this);
		ss.start();
		Thread.sleep(1000);

		Assert.assertEquals(0, myConnects);
		Assert.assertEquals(0, myDisconnects);

		Socket con = new Socket();

		/*
		 * SimpleServer does most of its work in separate threads, so
		 * we retry things just in case there is some lag 
		 */
		int retries = 1000000;
		
		for (int i = 0;; i++) {
			try {
				con.connect(new InetSocketAddress("localhost", port), 2000);
				break;
			} catch (Throwable e) {
				if (i == retries) {
					throw e;
				} else {
					Thread.sleep(100);
				}
			}
		}

		for (int i = 0;; i++) {
			try {
				Assert.assertEquals(1, myConnects);
				Assert.assertEquals(0, myDisconnects);
				break;
			} catch (Throwable e) {
				if (i == retries) {
					throw e;
				} else {
					Thread.sleep(100);
				}
			}
		}

		con.close();

		for (int i = 0;; i++) {
			try {
				Assert.assertEquals(1, myConnects);
				Assert.assertEquals(1, myDisconnects);
				break;
			} catch (Throwable e) {
				if (i == retries) {
					throw e;
				} else {
					Thread.sleep(100);
				}
			}
		}

	}

	public void connectionReceived(Connection theC) {
		myConnects++;
	}

	public void connectionDiscarded(Connection theC) {
		myDisconnects++;
	}

}
