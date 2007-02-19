/*
 * Created on 22-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.ServerSocket;
import java.net.Socket;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;

import junit.framework.TestCase;

/**
 * Unit tests for <code>DualTransportConnector</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:39 $ by $Author: jamesagnew $
 */
public class DualTransportConnectorTest extends TestCase {

    private String localhost = "127.0.0.1";        
    private int portOne = 25678;
    private int portTwo = 15679;
    
    ServerSocket myOne;
    ServerSocket myTwo;
    
    private DualTransportConnector myConnector;
    
    /**
     * Constructor for DualTransportConnectorTest.
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
        myOne = new ServerSocket(portOne);
        myTwo = new ServerSocket(portTwo);        
        
        ServerSocketStreamSource ss1 = new ServerSocketStreamSource(myOne, localhost);
        ServerSocketStreamSource ss2 = new ServerSocketStreamSource(myTwo, localhost);
        
        TransportLayer t1 = new MLLPTransport(ss1);
        TransportLayer t2 = new MLLPTransport(ss2);
        
        myConnector = new DualTransportConnector(t1, t2);
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
        myConnector.disconnect();
        myOne.close();
        myTwo.close();
    }
    
    public void testConnectInOrder() throws Exception {
        startConnect();
        Socket s1 = new Socket(localhost, portOne);
        Socket s2 = new Socket(localhost, portTwo);

        Thread.sleep(1000);
        assertTrue(myConnector.getTransportA().isConnected());
        assertTrue(myConnector.getTransportB().isConnected());
    }
    
    public void testConnectOutOfOrder() throws Exception {
        startConnect();
        Socket s2 = new Socket(localhost, portTwo);
        Socket s1 = new Socket(localhost, portOne);

        Thread.sleep(1000);
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
                    e.printStackTrace();
                }
            }
        };
        thd.start();
    }

}
