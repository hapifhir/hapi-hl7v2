/*
 * Created on 19-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.HashMap;
import java.util.Map;

import ca.uhn.hl7v2.protocol.Transportable;

/**
 * Default implementation of <code>Transportable</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class TransportableImpl implements Transportable {

    private final String myMessageText;
    private final Map<String, Object> myMetadata;
    
    /**
     * Creates a new instance with no associated metadata (metadata can 
     * be added later using <code>getMetadata()</code>. 
     * 
     * @param theMessageText the text of an HL7 message 
     */
    public TransportableImpl(String theMessageText) {
        myMessageText = theMessageText;
        myMetadata = new HashMap<String, Object>();
    }
    
    /**
     * Creates a new instance with specified metadata (further metadata can   
     * be added later using <code>getMetadata()</code>. 
     * 
     * @param theMessageText the text of an HL7 message 
     * @param theMetadata metadata associated with the message (typical examples 
     *      would be selected field values for routing) 
     */
    public TransportableImpl(String theMessageText, Map<String, Object> theMetadata) {
        myMessageText = theMessageText;
        myMetadata = theMetadata;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Transportable#getMessage()
     */
    public String getMessage() {
        return myMessageText;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Transportable#getMetadata()
     */
    public Map<String, Object> getMetadata() {
        return myMetadata;
    }

}
