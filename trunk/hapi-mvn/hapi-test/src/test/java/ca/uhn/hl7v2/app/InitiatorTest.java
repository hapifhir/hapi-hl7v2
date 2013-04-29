/*
 * Created on 4-Jan-2005
 */
package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import ca.uhn.hl7v2.util.Terser;

/**
 * Unit tests for Initiator.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author:
 *          jamesagnew $
 */

public class InitiatorTest {

	private static HL7Service ss;
	private static int port;
	private static HapiContext context;
	private static final String msgText = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.4\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";

	@BeforeClass
	public static void beforeClass() throws Exception {
		port = RandomServerPortProvider.findFreePort();
		context = new DefaultHapiContext();
		ss = context.newServer(port, false);
		ss.startAndWait();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		ss.stopAndWait();
		DefaultExecutorService.getDefaultService().shutdown();
	}

	@Test
	public void testSendAndReceive() throws Exception {
		Parser parser = context.getPipeParser();
		MinLowerLayerProtocol protocol = new MinLowerLayerProtocol();
		Socket socket = TestUtils.acquireClientSocket(port);
		Connection conn = new ActiveConnection(parser, protocol, socket);
		conn.activate();
		Message out = parser.parse(msgText);
		Message in = conn.getInitiator().sendAndReceive(out);
		assertTrue(in != null);
		assertEquals(Terser.get((Segment) out.get("MSH"), 10, 0, 1, 1),
				Terser.get((Segment) in.get("MSA"), 2, 0, 1, 1));
	}

	
	@Test
	public void testConcurrentSendAndReceive() throws Exception {
		int n = 50; // TODO fails with 100
		final Parser parser = context.getPipeParser();
		final Connection conn = new ActiveConnection(parser, new MinLowerLayerProtocol(), new Socket("localhost", port));
		conn.activate();
		final Random r = new Random(System.currentTimeMillis());
		Callable<Boolean> t = new Callable<Boolean>() {
			public Boolean call() {
				try {
					String id = Long.toString(r.nextLong());
					Message out = parser.parse(msgText);
					Terser.set((Segment)out.get("MSH"), 10, 0, 1, 1, id);
					Message in = conn.getInitiator().sendAndReceive(out);
					return Terser.get((Segment) out.get("MSH"), 10, 0, 1, 1).equals(
							Terser.get((Segment) in.get("MSA"), 2, 0, 1, 1));
				} catch (Exception e) {
				}
				return false;
			}
		};
		List<Future<Boolean>> results = DefaultExecutorService.getDefaultService()
				.invokeAll(TestUtils.fill(t, n));
		for (Future<Boolean> future : results) {
			assertTrue(future.get());
		}

	}	

}
