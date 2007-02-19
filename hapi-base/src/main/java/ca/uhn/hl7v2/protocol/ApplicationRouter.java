/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.Parser;  

/**
 * Routes messages to the appropriate application.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface ApplicationRouter {

    /** 
     * Attempts to route the given message to the associated <code>Application</code>  
     * and obtain a response.  
     * 
     * @param theMessage the message to route 
     * @return the response message (this may be null, for example if the given 
     *      message doesn't require an application ACK)
     */
    public Transportable processMessage(Transportable theMessage) throws HL7Exception;
    
    /**
     * @param theRoutingData message fields used in determining the appropriate destination  
     * @return true if there is a destination application for messages with the given
     *      characteristics  
     */
    public boolean hasActiveBinding(AppRoutingData theRoutingData);  
        
    /**
     * <p>Associates the given application with the given message parameters, so that messages
     * with matching parameters will be sent there.  Only one application can be registered 
     * for a given set of parameters: repeated registration for a particular combination 
     * over-writes the previous one.</p>  
     * 
     * <p>Because of wildcards, there may be multiple registrations that match a given message.  
     * In this case, the first registered wins.</p>  
     * 
     * @param theRoutingData message fields used in determining the appropriate destination  
     * @param theApplication the application to which messages with these parameters should be 
     *      sent 
     */
    public void bindApplication(AppRoutingData theRoutingData, ReceivingApplication theApplication);
    
    /**
     * Temporarily deactivates the binding on the given field data, if present.  
     * @param theRoutingData the fields that define a set of messages that are bound to 
     *      some <code>Application</code>  
     */
    public void disableBinding(AppRoutingData theRoutingData);
    
    /**
     * Undoes <code>disableBinding(AppRoutingData theRoutingData)</code>.    
     * @param theRoutingData the fields that define a set of messages that are bound to 
     *      some <code>Application</code>  
     */
    public void enableBinding(AppRoutingData theRoutingData);
    
    /**
     * @return the <code>Parser</code> that is used to parse inbound messages
     * and encode outbound ones.  It may be of interest to set certain parameters 
     * of this parser.     
     */
    public Parser getParser();
        
    /**
     * <p>Encapsulates the message fields used for routing of messages from the 
     * HL7 protocol to the appropriate <code>Application</code>. </p>   
     * 
     * <p>The wildcard "*" in any member indicates all values of the associated parameter.  For 
     * example the conbination "ADT", "*", "*", "*" means all ADT messages.  Each value can also
     * be a regular expression that is matched against the corresponding field.  </p>
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
     */
    public static interface AppRoutingData {

        /**
         * @return MSH-9-1
         */        
        public String getMessageType(); 
        
        /**
         * @return MSH-9-2
         */        
        public String getTriggerEvent();
        
        /**
         * @return MSH-11-1
         */        
        public String getProcessingId();
        
        /**
         * @return MSH-12
         */                
        public String getVersion();
    }

}
