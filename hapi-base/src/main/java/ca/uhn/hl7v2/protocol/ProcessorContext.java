/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import java.util.List;

/**
 * The operational context of a <code>Processor</code>.  This defines 
 * certain resources that are not part of the <code>Processor</code>, 
 * but are needed in order to implement it, and may vary between  
 * deployments.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface ProcessorContext {

    /**
     * @return the router that directs unsolicited inbound messages to 
     *      the appropriate <code>Application</code>  
     */
    public ApplicationRouter getRouter();

    /**
     * @return the object responsible for transport of remotely initiated message 
     *      exchanges (normally with a remote server)
     */    
    public TransportLayer getRemotelyDrivenTransportLayer();
    
    
    /**
     * @return the object responsible for transport of locally initiated message 
     *      exchanges (normally with a remote server)
     */    
    public TransportLayer getLocallyDrivenTransportLayer();

    /**
     * @return the validators that determine whether a message can be 
     *      accepted for routing to the appropriate application 
     */    
    public AcceptValidator[] getValidators();
    
    /**
     * Adds a new validator to the list of those returned by 
     * <code>getValidators()</code>.  
     *  
     * @param theValidator the validator to add 
     */
    public void addValidator(AcceptValidator theValidator);    
    
    /**
     * @return a store for messages while they are being routed to the 
     *      appropriate application 
     */
    public SafeStorage getSafeStorage();
    
    /**
     * Returns the list of fields that are to be included as metadata whenever a <code>Message</code>
     * is converted to a <code>Transportable</code>.  Each field is a String <code>Terser</code>
     * path.  
     *  
     * @param theMetadataFields list of <code>Terser</code> paths of metadata fields 
     */
    public List<String> getMetadataFields();
    
}
