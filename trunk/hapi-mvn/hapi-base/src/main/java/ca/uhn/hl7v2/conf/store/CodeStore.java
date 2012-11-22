package ca.uhn.hl7v2.conf.store;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * Interface used retrieving and validating codes from user defined and HL7 specific tables that
 * correspond to a conformance profile.
 * 
 * @author Neal Acharya
 */
public interface CodeStore {

    /**
     * Retrieves all codes for a given conformance profile and codeSystem.
     * 
     * @param codeSystem a table of codes (for example, HL70001 for administrative sex) valid tables
     *            are defined in the HL7 table 0396
     * @return a list of valid codes
     * @throws ProfileException
     */
    public String[] getValidCodes(String codeSystem) throws ProfileException;

    /**
     * Validates the codeSystem against the input conformance profile. If valid then output is
     * 'true' else 'false'.
     * 
     * @param codeSystem
     * @return <code>true</code> if CodeStore knows the codeSystem
     */
    public boolean knowsCodes(String codeSystem);

    /**
     * Validates the input code value against the input conformance profile and corresponding input
     * codeSystem. Returns true if the code is valid and false if it isn't.
     * 
     * @param codeSystem
     * @param code
     * @return <code>true</code> if code is valid for the codeSystem
     */
    public boolean isValidCode(String codeSystem, String code);

}
