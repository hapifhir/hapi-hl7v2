/*
 * Created on 25-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.InetSocketAddress;
import java.net.ServerSocket;

import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.MockApp;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.Transportable;

import junit.framework.TestCase;

/**
 * Unit tests for <code>HL7Server</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class HL7ServerTest extends TestCase {

    /**
     * Constructor for HL7ServerTest.
     * @param arg0
     */
    public HL7ServerTest(String arg0) {
        super(arg0);
    }
    
    public void testResponse() throws Exception {
        int port = 9877;
        String localhost = "127.0.0.1";
        ServerSocket ss = new ServerSocket(port);
        SafeStorage storage = new NullSafeStorage();
        ApplicationRouter router = new ApplicationRouterImpl();
        router.bindApplication(new AppRoutingDataImpl("*", "*", "*", "*"), new MockApp());

        HL7Server server = new HL7Server(ss, router, storage);
        server.start(localhost);
        
        try {
            Thread.sleep(100); //give it time to start before we stop it
        } catch (InterruptedException e) {}
        server.stop();
        
        StreamSource sender = new ClientSocketStreamSource(new InetSocketAddress(localhost, port));
        MLLPTransport transport = new MLLPTransport(sender);
        transport.connect();
        
        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.2\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
        transport.send(new TransportableImpl(message));
        Transportable inbound = transport.receive();
        
        assertTrue(inbound.getMessage().indexOf("mock") > -1);     
        
        transport.disconnect();
        ss.close();   
    }
    
    public void testMain() throws Exception {
        HL7Server.main(new String[] {"9999", "classpath:ca/uhn/hl7v2/protocol/impl/mock_apps"});

        StreamSource sender = new ClientSocketStreamSource(new InetSocketAddress("127.0.0.1", 9999));
        MLLPTransport transport = new MLLPTransport(sender);
        transport.connect();
        
        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.2\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
        transport.send(new TransportableImpl(message));
        Transportable inbound = transport.receive();
        
        assertTrue(inbound.getMessage().indexOf("mock") > -1);     
        
        transport.disconnect();        
    }
}
