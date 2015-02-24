/*
 * Created on 20-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.TransportException;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ClientSocketStreamSourceTest extends Assert {

    @Test
    public void testConnect() throws Exception {
        int port = 19876; 
        StreamSource source 
            = new ClientSocketStreamSource(new InetSocketAddress("127.0.0.1", port));
        
        final ServerSocket ss = new ServerSocket(port);
        Thread thd = new Thread() {
            public void run() {
                try {
                    ss.accept(); 
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
