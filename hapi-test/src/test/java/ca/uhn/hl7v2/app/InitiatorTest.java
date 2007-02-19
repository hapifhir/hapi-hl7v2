/*
 * Created on 4-Jan-2005
 */
package ca.uhn.hl7v2.app;

import java.net.Socket;

import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import junit.framework.TestCase;

/**
 * Unit tests for Initiator. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class InitiatorTest extends TestCase {

    /**
     * @param arg0
     */
    public InitiatorTest(String arg0) {
        super(arg0);
    }

    public void testSendAndReceive() throws Exception {
        int port = 5678;
        Parser parser = new PipeParser();
        MinLowerLayerProtocol protocol = new MinLowerLayerProtocol();
        
        SimpleServer ss = new SimpleServer(port, protocol, parser);
        ss.start();
        Socket socket = new Socket("localhost", port);
        Connection conn = new Connection(parser, protocol, socket);
        
        String msgText = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.4\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
        Message out = parser.parse(msgText);
        Message in = conn.getInitiator().sendAndReceive(out);
        
        assertTrue(in != null);
    }

}
