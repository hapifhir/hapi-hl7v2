/*
 * Created on 17-May-2004
 */
package ca.uhn.hl7v2.protocol.tests;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * Minimal mock implementation of <code>ApplicationRouter</code>  
 * This is mainly for use in testing <code>ProtocolImpl</code>, so 
 * that bugs in <code>ApplicationRouterImpl</code> don't confuse us. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 */
public class MockApplicationRouter implements ApplicationRouter {

    private Transportable myLastReceived;
    private Transportable myNextReply;
    
    /** 
     * Returns last message given through setNextReply(); arg is made available 
     * through getLastReceived(). 
     * 
     * @see ca.uhn.hl7v2.protocol.tests.ApplicationRouter#processMessage(ca.uhn.hl7v2.protocol.tests.Transportable)
     */
    public Transportable processMessage(Transportable arg0) throws HL7Exception {
        myLastReceived = arg0;
        return myNextReply;
    }
    
    public Transportable getLastReceived() {
        return myLastReceived;
    }
    
    public void setNextReply(Transportable theNext) {
        myNextReply = theNext;
    }

    /** 
     * Returns true. 
     */
    public boolean hasActiveBinding(AppRoutingData arg0) {
        return true;
    }

    /** 
     * Does nothing.  
     */
    public void bindApplication(AppRoutingData arg0, ReceivingApplication arg1) {
    }

    /** 
     * Does nothing.  
     */
    public void disableBinding(AppRoutingData arg0) {
    }

    /** 
     * Does nothing.  
     */
    public void enableBinding(AppRoutingData arg0) {
    }

    public Parser getParser() {
        return null;
    }

}
