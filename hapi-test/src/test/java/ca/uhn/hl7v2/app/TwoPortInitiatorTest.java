/*
 * Created on 4-Jan-2005
 */
package ca.uhn.hl7v2.app;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import ca.uhn.hl7v2.util.Terser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static ca.uhn.hl7v2.concurrent.DefaultExecutorService.completionService;
import static ca.uhn.hl7v2.concurrent.DefaultExecutorService.getDefaultService;
import static org.junit.Assert.*;

/**
 * Unit tests for Initiator.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author:
 *          jamesagnew $
 */

public class TwoPortInitiatorTest implements ReceivingApplication<Message> {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(TwoPortInitiatorTest.class);
	
	private static TwoPortService tps;
	private static int port1;
	private static int port2;
	private static final String msgText = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.4\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";

	@Before
	public void before() throws Exception {
		port1 = RandomServerPortProvider.findFreePort();
		port2 = RandomServerPortProvider.findFreePort();
		tps = new TwoPortService(port1, port2);
		tps.registerApplication("*", "*", this);
		tps.start();
	}

	@After
	public void after() throws Exception {
		tps.stopAndWait();
		DefaultExecutorService.getDefaultService().shutdown();
		
		ourLog.debug("Finished test");
	}

	@Test
	public void testSendAndReceive() throws Exception {
		Parser parser = new PipeParser();
		MinLowerLayerProtocol protocol = new MinLowerLayerProtocol();
		
		Socket outsocket = TestUtils.acquireClientSocket(port1);
		Socket insocket = TestUtils.acquireClientSocket(port2);
		
		Connection conn = new ActiveConnection(parser, protocol, insocket, outsocket);
		conn.activate();
		Message out = parser.parse(msgText);
		Message in = conn.getInitiator().sendAndReceive(out);
		assertTrue(in != null);
		assertEquals(Terser.get((Segment) out.get("MSH"), 10, 0, 1, 1),
				Terser.get((Segment) in.get("MSA"), 2, 0, 1, 1));
		conn.close();
	}


	@Test
	public void testConcurrentSendAndReceive() throws Exception {
		int n = 50;
		final Parser parser = new PipeParser();
		Socket outsocket = TestUtils.acquireClientSocket(port1);
		Socket insocket = TestUtils.acquireClientSocket(port2);
		final Connection conn = new ActiveConnection(parser,
				new MinLowerLayerProtocol(), insocket, outsocket);
		conn.activate();
		final Random r = new Random(System.currentTimeMillis());
		Callable<Boolean> t = new Callable<Boolean>() {
			public Boolean call() {
				try {
					String id = Long.toString(r.nextLong());
					Message out = parser.parse(msgText);
					Terser.set((Segment) out.get("MSH"), 10, 0, 1, 1, id);
					ourLog.debug("Sending message with ID: {}", id);
					Message in = conn.getInitiator().sendAndReceive(out);
					return Terser.get((Segment) out.get("MSH"), 10, 0, 1, 1)
							.equals(Terser.get((Segment) in.get("MSA"), 2, 0,
									1, 1));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
		CompletionService<Boolean> completionService = completionService(getDefaultService());
		for (Callable<Boolean> callable : TestUtils.fill(t, n)) {
			completionService.submit(callable);
		}
		while (n > 0) {
			Future<Boolean> f = completionService.take();
			assertNotNull(f);
			try {
				assertTrue("Got FALSE response, " + n + " threads left",
						f.get());
			} catch (ExecutionException e) {
				ourLog.debug("Failed", e);
				fail(e.getMessage() + " " + n + " threads left");
			} finally {
				n--;
			}
		}
		conn.close();

	}

	public Message processMessage(Message theIn, Map<String, Object> metadata)
            throws ReceivingApplicationException, HL7Exception {
		
		ourLog.debug("Received message with ID {}", new Terser(theIn).get("/MSH-10"));
		
		try {
			return theIn.generateACK();
		} catch (IOException e) {
			throw new Error(e);
		}
	}

	public boolean canProcess(Message theIn) {
		return true;
	}

}
