package ca.uhn.hl7v2.validation.app;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;

/**
 * <p>Tests messages against conformance profiles.  A constant profile
 * can be used, or each message can be tested against the profiles
 * that it declares.</p>
 * <p>Note that profiles are referenced by ID, and that the ca.uhn.hl7v2.conf.store
 * package is used to get the actual profiles. </p>
 * @author Bryan Tripp
 */
public class ProfileTestApplication extends TestApplication {
    
    private String profileID;
    private ConformanceProfileRule rule;
    
    /**
     * Creates a new instance of ProfileTestApplication that tests using profiles 
     * declared in each message (if any)
     */
    public ProfileTestApplication() {
        rule = new ConformanceProfileRule();
    }
    
    /**
     * Creates a new instance of ProfileTestApplication.
     * @param profileID the ID of the profile against which to test messages;
     *      null means use profiles declared in the message (if any)
     */
    public ProfileTestApplication(String profileID) {
        this.profileID = profileID;
        rule = new ConformanceProfileRule(profileID);
    }
    
    /**
     * Returns true if this Application wishes to accept the message.  By returning
     * true, this Application declares itself the recipient of the message, accepts
     * responsibility for it, and must be able to respond appropriately to the sending system.
     */
    public boolean canProcess(Message in) {
        return true;
    }
    
    /**
     * Tests the message against a profile or profiles.  A constant profile
     * is used if one was provided to the constructor, otherwise any profiles
     * declared in the message are used.
     */
    public HL7Exception[] test(Message in) throws HL7Exception {
        ValidationException[] errors = rule.test(in);
        
        HL7Exception[] result = new HL7Exception[errors.length];
        for (int i = 0; i < errors.length; i++) {
            Throwable t = errors[i].getCause();
            if ((t != null) && (t instanceof HL7Exception)) {
                result[i] = (HL7Exception) t;
            } else {
                result[i] = new HL7Exception(errors[i]);
            }            
        }
        
        return result;
    }
    
    public String getProfileID() {
        return this.profileID;
    }
}
