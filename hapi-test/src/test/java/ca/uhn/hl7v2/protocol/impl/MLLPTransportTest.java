/*
 * Created on 24-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;

import junit.framework.TestCase;

/**
 * Unit tests for MLLPTransport.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:39 $ by $Author: jamesagnew $
 */
public class MLLPTransportTest extends TestCase {

    /**
     * Constructor for MLLPTransportTest.
     * @param arg0
     */
    public MLLPTransportTest(String arg0) {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void test() throws Exception {
        String localhost = "127.0.0.1";
        int port = 5673;
        
        ServerSocket ss = new ServerSocket(port);
        StreamSource remoteSource = new ServerSocketStreamSource(ss, localhost);
        MLLPTransport remoteTransport = new MLLPTransport(remoteSource); 
        startConnect(remoteTransport);
        
        StreamSource localSource = new ClientSocketStreamSource(new InetSocketAddress(localhost, port));
        MLLPTransport localTransport = new MLLPTransport(localSource);
        startConnect(localTransport);
        
        Thread.sleep(1000);
        
        String message = "hello";
        localTransport.send(new TransportableImpl(message));
        Transportable in = remoteTransport.receive();
        assertEquals(message, in.getMessage());
        
        remoteTransport.send((new TransportableImpl(message)));
        in = localTransport.receive();
        assertEquals(message, in.getMessage());        
    }
    
    private void startConnect(final TransportLayer theTransport) {
        Thread thd = new Thread() {
            public void run() {
                try {
                    theTransport.connect();
                } catch (TransportException e) {
                    e.printStackTrace();
                }
            }
        };
        thd.start();
    }
    
    public void testCharset() throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamSource ss = new StreamSource() {
            public void connect() throws TransportException {}
            public void disconnect() throws TransportException {}
            public OutputStream getOutboundStream() throws TransportException {
                return out;
            }
            public InputStream getInboundStream() throws TransportException {
                return new ByteArrayInputStream("inbound message".getBytes());
            }
        };
        
        MLLPTransport transport = new MLLPTransport(ss);
        transport.connect();
        Transportable t = new TransportableImpl("outbound message");
        t.getMetadata().put("MSH-18", "UNICODE");
        transport.send(t);
        assertEquals(40, out.toByteArray().length);
    }

}
