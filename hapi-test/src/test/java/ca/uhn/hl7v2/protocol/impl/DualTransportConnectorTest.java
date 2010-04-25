/*
 * Created on 22-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;

import junit.framework.TestCase;
import junitx.framework.Assert;

/**
 * Unit tests for <code>DualTransportConnector</code>.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2010-04-25 16:22:52 $ by $Author:
 *          jamesagnew $
 */
public class DualTransportConnectorTest extends TestCase {

    private String localhost = "127.0.0.1";
    private int portOne;
    private int portTwo;

    ServerSocket myOne;
    ServerSocket myTwo;

    private DualTransportConnector myConnector;
    private CountDownLatch myLatch;
    private Exception myFailed;

    /**
     * Constructor for DualTransportConnectorTest.
     * 
     * @param arg0
     */
    public DualTransportConnectorTest(String arg0) {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
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

    protected void tearDown() throws Exception {
        super.tearDown();

        try {
            myConnector.disconnect();
        } catch (Exception e) {
            // ignore this
        }

        myOne.close();
        myTwo.close();

        if (myFailed != null) {
            Assert.fail(myFailed);
        }
    }

    public void testConnectInOrder() throws Exception {
        startConnect();
        Socket s1 = new Socket(localhost, portOne);
        Socket s2 = new Socket(localhost, portTwo);

        myLatch.await();
        assertTrue(myConnector.getTransportA().isConnected());
        assertTrue(myConnector.getTransportB().isConnected());
    }

    public void testConnectOutOfOrder() throws Exception {
        startConnect();
        Socket s2 = new Socket(localhost, portTwo);
        Socket s1 = new Socket(localhost, portOne);

        myLatch.await();
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
