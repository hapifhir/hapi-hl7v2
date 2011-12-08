package ca.uhn.hl7v2.conf.check;

/**
 * An element that a profile defines as "not used" (X) is present in the 
 * message.  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class XElementPresentException extends ProfileNotFollowedException {        
    
    /**
     * Constructs an instance of <code>XElementPresentException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public XElementPresentException(String msg) {
        super(msg);
    }

}
