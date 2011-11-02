/*
 * Created on 15-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import java.util.Map;

/**
 * An HL7 message in text form, with optional metadata, which can 
 * be handled in a transport layer. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface Transportable {

    /**
     * @return the text of an HL7 message (either ER7 or XML encoding).
     */
    public String getMessage();
    
    /**
     * @return metadata associated with the message.  If the message is being 
     * sent to a <code>TransportLayer</code>, this may include selected message fields
     * (eg to facilitate routing based on MSH fields without re-parsing the   
     * message).  If the message is being received, this may include 
     * information such as the IP address of the server from which the message 
     * was received (this depends on the underlying <code>TransportLayer</code> used).  
     * Message fields are keyed with <code>Terser</code> path names.  
     */
    public Map<String, Object> getMetadata();
    
}
