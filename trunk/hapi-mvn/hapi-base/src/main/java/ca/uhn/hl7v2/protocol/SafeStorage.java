/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Represents a persistent store for incoming messages.  Messages 
 * may be stored here before an accept ACK is returned.  The local
 * side of the interface then takes on responsibility for delivering 
 * the message to the application.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface SafeStorage {

    /**
     * Stores a message so that it can be reliably retrieved and sent to 
     * the proper application, even if this service is restarted in the mean
     * time.
     *  
     * @param theMessage the message to store 
     * @throws HL7Exception if there is some problem accessing the store
     */
    public void store(Transportable theMessage) throws HL7Exception;
    
    /**
     * If the given message exists in the store, it is removed.
     *   
     * @param theMessage the message to discard
     * @throws HL7Exception if there is some problem accessing the store
     */
    public void discard(Transportable theMessage) throws HL7Exception;
    
    /**
     * Returns all messages that have been stored.  The store retains a copy 
     * of each one until discard() is called.  This method would be called 
     * after the HL7 server is restarted.
     *      
     * @return all messages in the store 
     * @throws HL7Exception if there is some problem accessing the store
     */
    public Transportable[] restore() throws HL7Exception;
    
}
