package ca.uhn.hl7v2.app;

import junit.framework.TestCase;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.llp.*;

/**
 * JUnit test harmess for ConnectionHub 
 * @author Bryan Tripp
 */
public class ConnectionHubTest extends TestCase {

    private SimpleServer ss1;
    private SimpleServer ss2;
    
    /** Creates a new instance of ConnectionHubTest */
    public ConnectionHubTest(String arg) {
        super(arg);
    }

    public void setUp() throws Exception {
        ss1 = new SimpleServer(9876, LowerLayerProtocol.makeLLP(), new PipeParser());
        ss1.start();
        ss2 = new SimpleServer(5432, LowerLayerProtocol.makeLLP(), new PipeParser());
        ss2.start();
    }
    
    public void tearDown() {
        ss1.stop();
        ss2.stop();
        
        try {
            Thread.sleep(SimpleServer.SO_TIMEOUT + 1000);
        } catch (InterruptedException e) {
            // nothing
        }
    }
    
    
    public void testDiscard() throws Exception {
        PipeParser pipeParser = new PipeParser();
        Connection i1 = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        Connection i1again = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        ConnectionHub.getInstance().discard(i1);
        Connection i1thrice = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        assertTrue(i1thrice.hashCode() != i1.hashCode());
        
        ConnectionHub.getInstance().discard(i1thrice);
    }
    
    /**
     * 
     * @throws Exception
     */
    public void testAttach() throws Exception {
        PipeParser pipeParser = new PipeParser();
        Connection i1 = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        Connection i1again = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        assertEquals(i1.hashCode(), i1again.hashCode());
        Connection i2 = ConnectionHub.getInstance().attach("localhost", 5432, pipeParser, MinLowerLayerProtocol.class);
        try {
            ConnectionHub.getInstance().attach("localhost", 9090, pipeParser, MinLowerLayerProtocol.class);
            fail("Shouldn't be a service running at 9090");
        } catch (Exception e) {}
        ConnectionHub.getInstance().detach(i1);
        ConnectionHub.getInstance().detach(i1again);
        ConnectionHub.getInstance().detach(i2);
        Connection i1OnceMore = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        int onceMoreHashCode = i1OnceMore.hashCode();
        int i1HashCode = i1.hashCode();
        assertTrue(onceMoreHashCode != i1HashCode);
        ConnectionHub.getInstance().detach(i1OnceMore);        
    }

}
