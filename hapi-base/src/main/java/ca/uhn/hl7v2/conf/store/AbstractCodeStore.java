package ca.uhn.hl7v2.conf.store;

import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for used retrieving and validating codes from user defined and HL7 specific tables
 * that correspond to a conformance profile.
 * 
 * @author Neal Acharya
 */
public abstract class AbstractCodeStore implements CodeStore {

    private static Logger log = LoggerFactory.getLogger(AbstractCodeStore.class);
    
    private static final RegisteredPattern[] WILDCARDS = { 
            new RegisteredPattern("ISOnnnn", "ISO\\d\\d\\d\\d"),
            new RegisteredPattern("HL7nnnn", "HL7\\d\\d\\d\\d"), 
            new RegisteredPattern("99zzz", "99[\\w]*"),
            new RegisteredPattern("NNxxx", "99[\\w]*") 
            };

    /**
     * @see ca.uhn.hl7v2.conf.store.CodeStore#isValidCode(java.lang.String, java.lang.String)
     */
    public boolean isValidCode(String codeSystem, String code) {
        try {
            for (String validCode : getValidCodes(codeSystem)) {
                if (checkCode(code, validCode)) return true;
            }
            return false;
        }
        catch (Exception e) {
            log.error("Error checking code " + code + " in code system " + codeSystem, e);
            return false;
        } 
    }

    /**
     * Checks a code for an exact match, and using certain sequences where some characters are
     * wildcards (e.g. HL7nnnn). If the pattern contains one of " or ", " OR ", or "," each operand
     * is checked.
     */
    private boolean checkCode(String code, String pattern) {
        // mod by Neal acharya - Do full match on with the pattern. If code matches pattern then
        // return true
        // else parse pattern to look for wildcard characters
        if (code.equals(pattern)) return true;
        
        if (pattern.indexOf(' ') >= 0 || pattern.indexOf(',') >= 0) {
            StringTokenizer tok = new StringTokenizer(pattern, ", ", false);
            while (tok.hasMoreTokens()) {
                String t = tok.nextToken();
                if (!t.equalsIgnoreCase("or") && checkCode(code, t)) 
                    return true;
            }
        } else {
            for (RegisteredPattern wildcard : WILDCARDS) {
                if (wildcard.matches(pattern, code)) 
                    return true;
            }
        }
        
        return false;
    }

}
