package ca.uhn.hl7v2.conf.check;

/**
 * An exception indicating that a static profile doesn't correspond to HL7 rules.  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class ProfileNotHL7CompliantException extends ca.uhn.hl7v2.HL7Exception {
    
    /**
     * Constructs an instance of <code>ProfileNotHL7CompliantHL7Exception</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ProfileNotHL7CompliantException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>ProfileNotHL7CompliantHL7Exception</code> with the specified detail message.
     * @param msg the detail message.
     * @param cause an underlying exception 
     */
    public ProfileNotHL7CompliantException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
