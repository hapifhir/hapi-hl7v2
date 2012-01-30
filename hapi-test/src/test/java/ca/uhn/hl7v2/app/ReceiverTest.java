/*
 * Created on 22-Feb-2005
 */
package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertTrue;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import ca.uhn.hl7v2.app.AcceptorThread.AcceptedSocket;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

/**
 * Unit tests for Receiver.  
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class ReceiverTest {

    @Test
    public void testCloseConnectionOnClosingServerSocket() throws Exception {
        int port = RandomServerPortProvider.findFreePort();
        @SuppressWarnings("serial")
        // This queue denies any received connection, and immediately closes the server socket 
		BlockingQueue<AcceptedSocket> queue = new ArrayBlockingQueue<AcceptedSocket>(10) {

			@Override
			public boolean offer(AcceptedSocket e) {
				return false;
			}
        	
        };
        AcceptorThread at = new AcceptorThread(port, false, DefaultExecutorService.getDefaultService(), queue);
        at.start();
        
        Socket clientSocket = new Socket("localhost", port);
        final CountDownLatch latch = new CountDownLatch(1);
        new Connection(new PipeParser(), new MinLowerLayerProtocol(), clientSocket) {
            public void close() {
                super.close();
                latch.countDown();
            }
        }.activate();
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        at.stopAndWait();
    }

    @Test
    public void testCloseConnectionOnClosingClientSocket() throws Exception {
        int port = RandomServerPortProvider.findFreePort();
        BlockingQueue<AcceptedSocket> queue = new ArrayBlockingQueue<AcceptedSocket>(10);
        AcceptorThread at = new AcceptorThread(port, false, DefaultExecutorService.getDefaultService(), queue);
        at.start();
        
        Socket clientSocket = new Socket("localhost", port);
        final CountDownLatch latch = new CountDownLatch(1);
        new Connection(new PipeParser(), new MinLowerLayerProtocol(), clientSocket) {
            public void close() {
                super.close();
                latch.countDown();
            }
        }.activate();

        clientSocket.close();
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        at.stopAndWait();
    }
}
