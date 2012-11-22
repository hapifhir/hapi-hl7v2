package ca.uhn.hl7v2.conf;

/**
 * Represents something wrong with a profile.  This is distinguished from 
 * something that is wrong with a message according to a profile (in the latter
 * case, an HL7Exception might be thrown when the message is validated against 
 * the profile).  
 * 
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class ProfileException extends Exception {
    
    /**
     * Constructs an instance of <code>ProfileException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ProfileException(String msg) {
        super(msg);
    }
    
    
    /**
     * Constructs an instance of <code>ProfileException</code> with the specified 
     * cause and detail message.
     * @param msg the detail message.
     * @param cause the underlying cause of the exception 
     */
    public ProfileException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}
