package ca.uhn.hl7v2.conf.store;
import ca.uhn.hl7v2.conf.ProfileException;

/**
 * Created on 27-Aug-2003
 * @author Neal Acharya
 * Interface used retreiving and validating codes from user defined and HL7 specific tables
 * that correspond to a conformance profile.
 */
public interface CodeStore {
    
    /**
     * @param codeSystem a table of codes (for example, HL70001 for administrative sex)
     *      valid tables are defined in the HL7 table 0396
     * @return a list of valid codes 
     * @throws ProfileException
     *
     * Retreives all codes for a given conformance profile and codeSystem.
     */
    public String[] getValidCodes(String codeSystem) throws ProfileException;
    
    /**
     * @param codeSystem
     * @return boolean
     * boolean
     *
     * Validates the codeSystem against the input conformance profile. If valid then
     * output is 'true' else 'false'.
     */
    public boolean knowsCodes(String codeSystem);
    
    /**
     * @param codeSystem
     * @param code
     * @return boolean
     * boolean
     *
     * Validates the input code value against the input conformance profile and corresponding input
     * codeSystem. Returns true if the code is valid and false if it isn't.
     */
    public boolean isValidCode(String codeSystem, String code);
    
}//end interface
