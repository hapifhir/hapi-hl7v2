/*
 * Created on 16-May-2005
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

/**
 * Wraps a ca.uhn.hl7v2.app.Application as a ca.uhn.hl7v2.protocol.ReceivingApplication. 
 * ReceivingApplication replaces Application with HAPI 0.5.
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class AppWrapper implements ReceivingApplication {

    private Application myApplication;
    
    /**
     * @param theApplication an Application to wrap as a ReceivingApplication.  
     */
    public AppWrapper(Application theApplication) {
        myApplication = theApplication;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.ReceivingApplication#processMessage(ca.uhn.hl7v2.model.Message, java.util.Map)
     */
    public Message processMessage(Message theMessage, Map<String, Object> theMetadata) 
            throws ReceivingApplicationException, HL7Exception {
        Message result;
        try {
            result = myApplication.processMessage(theMessage);
        } catch (ApplicationException e) {
            throw new ReceivingApplicationException(e);
        }
        
        return result;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.ReceivingApplication#canProcess(ca.uhn.hl7v2.model.Message)
     */
    public boolean canProcess(Message theMessage) {
        return myApplication.canProcess(theMessage);
    }

}
