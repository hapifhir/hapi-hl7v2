package ca.uhn.hl7v2.conf.check;

/**
 * An exception indicating that some message contents don't reflect a static profile.   
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class ProfileNotFollowedException extends ca.uhn.hl7v2.HL7Exception {
    
    /**
     * Constructs an instance of <code>ProfileNotFollowedException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ProfileNotFollowedException(String msg) {
        super(msg);
    }


}
