/*
 * Created on 22-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for <code>DualTransportConnector</code>.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2010-04-25 16:22:52 $ by $Author:
 *          jamesagnew $
 */
public class DualTransportConnectorTest extends Assert {

    private String localhost = "127.0.0.1";
    private int portOne;
    private int portTwo;

    ServerSocket myOne;
    ServerSocket myTwo;

    private DualTransportConnector myConnector;
    private CountDownLatch myLatch;
    private Exception myFailed;

    /*
     * @see TestCase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        myOne = new ServerSocket(0);
        myTwo = new ServerSocket(0);

        ServerSocketStreamSource ss1 = new ServerSocketStreamSource(myOne, localhost);
        ServerSocketStreamSource ss2 = new ServerSocketStreamSource(myTwo, localhost);

        TransportLayer t1 = new MLLPTransport(ss1);
        TransportLayer t2 = new MLLPTransport(ss2);

        myConnector = new DualTransportConnector(t1, t2);
        portOne = myOne.getLocalPort();
        portTwo = myTwo.getLocalPort();

        myLatch = new CountDownLatch(1);
    }

    @After
    public void tearDown() throws Exception {

        try {
            myConnector.disconnect();
        } catch (Exception e) {
            // ignore this
        }

        myOne.close();
        myTwo.close();

        if (myFailed != null) {
            fail(myFailed.toString());
        }
    }

    @Test
    public void testConnectInOrder() throws Exception {
        startConnect();
        Socket s1 = new Socket(localhost, portOne);
        Socket s2 = new Socket(localhost, portTwo);

        assertTrue("Timed out", myLatch.await(2000L, TimeUnit.MILLISECONDS));
        assertTrue(myConnector.getTransportA().isConnected());
        assertTrue(myConnector.getTransportB().isConnected());
    }

    @Test
    public void testConnectOutOfOrder() throws Exception {
        startConnect();
        Socket s2 = new Socket(localhost, portTwo);
        Socket s1 = new Socket(localhost, portOne);

        assertTrue(myLatch.await(2000L, TimeUnit.MILLISECONDS));
        assertTrue(myConnector.getTransportA().isConnected());
        assertTrue(myConnector.getTransportB().isConnected());
    }

    private void startConnect() {
        final DualTransportConnector c = myConnector;
        Thread thd = new Thread() {

            public void run() {
                try {
                    c.connect();
                } catch (TransportException e) {
                    myFailed = e;
                } finally {
                    myLatch.countDown();
                }
            }
        };
        thd.start();
    }

}
