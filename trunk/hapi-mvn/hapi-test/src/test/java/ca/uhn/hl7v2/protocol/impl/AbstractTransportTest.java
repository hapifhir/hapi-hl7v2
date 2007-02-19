/*
 * Created on 19-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;
import junit.framework.TestCase;

/**
 * Unit tests for <code>AbstractTransport</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class AbstractTransportTest extends TestCase {

    /**
     * Constructor for AbstractTransportTest.
     * @param arg0
     */
    public AbstractTransportTest(String arg0) {
        super(arg0);
    }

    public void testReceive() throws Exception {
        TransportLayer transport = new AbstractTransport() {
            public void doConnect() throws TransportException {}

            public Transportable doReceive() throws TransportException {
                return new TransportableImpl("mock message");
            }

            public void doSend(Transportable arg0) throws TransportException {}
            
            public void doDisconnect() {}
        };
        transport.connect();
        
        transport.getCommonMetadata().put("test", "testval");
        
        Transportable result = transport.receive();
        assertEquals("testval", result.getMetadata().get("test"));
    }
    

}
