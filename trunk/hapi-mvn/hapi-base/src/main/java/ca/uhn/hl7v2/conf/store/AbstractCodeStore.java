package ca.uhn.hl7v2.conf.store;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Created on 27-Aug-2003
 * @author Neal Acharya
 * Abstract class for used retreiving and validating codes from user defined and HL7 specific tables
 * that correspond to a conformance profile.
 */
public abstract class AbstractCodeStore implements CodeStore {

	private static HapiLog log = HapiLogFactory.getHapiLog(AbstractCodeStore.class);
	private WildcardPattern[] wildcards;

	/**
	 * @param codeSystem
	 * @param code
	 * @return boolean
	 * @see ca.uhn.hl7v2.conf.store.CodeStore#isValidCode(java.lang.String, java.lang.String, java.lang.String)
	 *
	 * Validates the input code value against the input conformance profile and corresponding input
	 * codeSystem. Returns true if the code is valid and false if it isn't.
	 */
	public boolean isValidCode(String codeSystem, String code) {
		try {
			String[] validCodes = getValidCodes(codeSystem);
			boolean found = false;
			for (int i = 0; i < validCodes.length && !found; i++) {
				if (checkCode(code, validCodes[i])) {
					found = true;
				} //end if
			} //end for
			return found;
		} //end try
		catch (Exception e) {
			log.error("Error checking code " + code + " in code system " + codeSystem, e);
			return false;
		} //end catch
	} //end method

	/**
	 * Checks a code for an exact match, and using certain sequences where some 
	 * characters are wildcards (e.g. HL7nnnn).  If the pattern contains one of 
	 * " or ", " OR ", or "," each operand is checked.
	 */
	private boolean checkCode(String code, String pattern) {
		boolean match = false;
		//mod by Neal acharya - Do full match on with the pattern.  If code matches pattern then return true
        //else parse pattern to look for wildcard characters
		if (code.equals(pattern)) {
			match = true;
		} //end if 
		else {
			if (pattern.indexOf(' ') >= 0 || pattern.indexOf(',') >= 0) {
				StringTokenizer tok = new StringTokenizer(pattern, ", ", false);
				while (tok.hasMoreTokens() && !match) {
					String t = tok.nextToken();
					if (!t.equalsIgnoreCase("or"))
						match = checkCode(code, t);
				}//end while
			}//end if
			else {
				if (code.equals(pattern)) {
					match = true;
				}//end if
				else {
					WildcardPattern[] wc = getWildcards();
					for (int i = 0; i < wc.length && !match; i++) {
						if (pattern.equals(wc[i].pattern))
							match = wc[i].regex.matcher(code).matches();
					}//end for
				}//end else
			}//end else
		} //end else 
		return match;
	}//end method

	/** Returns a list of wildcard-containing patterns and corresponding regular expressions */
	private synchronized WildcardPattern[] getWildcards() {
		if (wildcards == null) {
			wildcards = new WildcardPattern[4];
			wildcards[0] = new WildcardPattern("ISOnnnn", "ISO\\d\\d\\d\\d");
			wildcards[1] = new WildcardPattern("HL7nnnn", "HL7\\d\\d\\d\\d");
			wildcards[2] = new WildcardPattern("99zzz", "99[\\w]*");
			wildcards[3] = new WildcardPattern("NNxxx", "99[\\w]*");
		}
		return wildcards;
	}

	/** A struct of a wildcard-containing code pattern and corresponding regex */
	private static class WildcardPattern {
		public String pattern;
		public Pattern regex;
		public WildcardPattern(String p, String r) {
			pattern = p;
			regex = Pattern.compile(r);
		}
	}

} //end class
