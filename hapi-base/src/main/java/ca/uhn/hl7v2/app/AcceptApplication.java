package ca.uhn.hl7v2.app;

import ca.uhn.hl7v2.model.Message;

/**
 * An application that returns AA acknowledgements.  
 * @author Bryan Tripp
 */
public class AcceptApplication extends DefaultApplication {
    
    /** Creates a new instance of AcceptApplication */
    public AcceptApplication() {
    }
    
    /**
     * Supplies details of application accept (AA) acknowledgement. 
     * Actually this method does nothing, because DefaultApplication.makeACK() 
     * supplies the desired values (this is just here to override inclusion of the 
     * default error message).  
     */
    public void fillDetails(Message ack) throws ApplicationException {
        //do nothing -- no more information needed 
    }
    
}
