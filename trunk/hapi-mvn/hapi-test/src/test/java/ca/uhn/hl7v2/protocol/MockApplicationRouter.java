/*
 * Created on 17-May-2004
 */
package ca.uhn.hl7v2.protocol;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;

/**
 * Minimal mock implementation of <code>ApplicationRouter</code>  
 * This is mainly for use in testing <code>ProtocolImpl</code>, so 
 * that bugs in <code>ApplicationRouterImpl</code> don't confuse us. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public class MockApplicationRouter implements ApplicationRouter {

    private Transportable myLastReceived;
    private Transportable myNextReply;
    
    /** 
     * Returns last message given through setNextReply(); arg is made available 
     * through getLastReceived(). 
     * 
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#processMessage(ca.uhn.hl7v2.protocol.Transportable)
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
    public void bindApplication(AppRoutingData arg0, ReceivingApplication<? extends Message> arg1) {
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

    /**
     * Does nothing.
     */
    public boolean unbindApplication(AppRoutingData theRoutingData) {
        return false;
    }

    /**
     * Does nothing.
     */
    public boolean unbindApplication(ReceivingApplication<? extends Message> theApplication) {
        return false;
    }

    public Parser getParser() {
        return null;
    }

	public void setExceptionHandler(ReceivingApplicationExceptionHandler theExceptionHandler) {
		throw new UnsupportedOperationException();
	}

}
