/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;

/**
 * <p>A convenient way for the initiator of a message exchange to send a 
 * message to a remote server and await the response in the same thread.</p>  
 * 
 * <p>Acknowledgements, threading, and accept-level retries are handled by 
 * an associated <code>Processor</code>.</p>
 * 
 * <p>Recall that acknowledgement requirements are specified in MSH fields 15 
 * and 16 (see HL7 v2.5 chapter 2), so the sender has control.  If no response is 
 * needed, and you would like this call to return right away, specify that no 
 * acknowledgements are required.</p> 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface Initiator {
    
    /**
     * Encodes a message, sends it to a remote system, awaits the response, 
     * parses it, and returns it.  The response may be null if the message doesn't 
     * require an application-level acknowledgement.   
     *  
     * @param theMessage the message to send to the remote system
     * @return the response from the remote system 
     */
    public Message sendAndReceive(Message theMessage) throws HL7Exception;
    
    /**
     * @return the <code>Parser</code> that is used to encode outbound messages
     * and parse inbound ones.  It may be of interest to set certain parameters 
     * of this parser, for example whether to use XML encoding.   
     */
    public Parser getParser();
    
    /**
     * @return the <code>Processor</code> instance that is used to perform the message
     * exchange   
     */
    public Processor getUnderlyingProcessor();
    
    /**
     * @return the list of fields that will be included as metadata when a <code>Message</code>
     * is converted to a <code>Transportable</code>.  Each field is a <code>Terser</code>
     * path (type String).  
     */
    public List<String> getMetadataFields();
        
}
