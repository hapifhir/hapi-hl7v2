package ca.uhn.hl7v2.app;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.llp.*;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A45;

/**
 * JUnit test harmess for ConnectionHub 
 * @author Bryan Tripp
 */
public class ConnectionHubTest extends TestCase {

    private static final Log ourLog = LogFactory.getLog(ConnectionHubTest.class);
    private SimpleServer ss1;
    private SimpleServer ss2;
    
    /** Creates a new instance of ConnectionHubTest */
    public ConnectionHubTest(String arg) {
        super(arg);
    }
    
    public void setUp() throws Exception {
        ss1 = new SimpleServer(9876, LowerLayerProtocol.makeLLP(), new PipeParser());
        ss1.registerApplication("*", "*", new MyApp());
        ss1.start();
        ss2 = new SimpleServer(5432, LowerLayerProtocol.makeLLP(), new PipeParser());
        ss2.registerApplication("*", "*", new MyApp());
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
    
    
    /**
     * Make sure that connection hub doesn't try to reuse a connection which is already closed
     * @throws IOException 
     * @throws LLPException 
     */
    public void testConnectionClosedExternally() throws HL7Exception, LLPException, IOException {
        
        PipeParser pipeParser = new PipeParser();
        Connection i1 = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);
        
        String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
            + "EVN|A45|201004141020|\r"
            + "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
            + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";
        ADT_A45 msg = new ADT_A45();
        msg.setParser(pipeParser);
        msg.parse(messageText);
        i1.getInitiator().sendAndReceive(msg);
        
        i1.close();
        i1 = ConnectionHub.getInstance().attach("localhost", 9876, pipeParser, MinLowerLayerProtocol.class);

        i1.getInitiator().sendAndReceive(msg);
        
        i1.close();
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
    
    
    public class MyApp implements Application {

        public boolean canProcess(Message theIn) {
            return true;
        }

        public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {
            ourLog.info("Received: " + theIn.encode());
            try {
                return theIn.generateACK();
            } catch (IOException e) {
                throw new HL7Exception(e);
            }
        }

    }

}
