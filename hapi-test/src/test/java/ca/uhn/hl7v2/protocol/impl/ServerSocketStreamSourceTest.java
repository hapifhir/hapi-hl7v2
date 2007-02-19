/*
 * Created on 20-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.ServerSocket;
import java.net.Socket;

import ca.uhn.hl7v2.protocol.TransportException;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ServerSocketStreamSourceTest extends TestCase {

    /**
     * Constructor for ServerSocketStreamSourceTest.
     * @param arg0
     */
    public ServerSocketStreamSourceTest(String arg0) {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testConnect() throws Exception {
        final int port = 17525;
        ServerSocket ss = new ServerSocket(port);
        ServerSocketStreamSource source = new ServerSocketStreamSource(ss, "127.0.0.1");
        
        Thread thd = new Thread() {
            public void run() {
                try {
                    Socket s = new Socket("127.0.0.1", port);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thd.start();
        
        try {
            source.getInboundStream();
            fail("should have thrown exception if not connected");
        } catch (TransportException e) {
            //OK            
        }

        try {
            source.getOutboundStream();
            fail("should have thrown exception if not connected");
        } catch (TransportException e) {
            //OK            
        }
        
        source.connect();
        
        assertTrue(source.getInboundStream() != null);
        assertTrue(source.getOutboundStream() != null);
        
    }

}
