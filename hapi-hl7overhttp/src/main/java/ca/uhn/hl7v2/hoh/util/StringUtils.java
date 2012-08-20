package ca.uhn.hl7v2.hoh.util;

public class StringUtils {

	/**
	 * Null safe equals comparison
	 */
	public static boolean equals(String theString1, String theString2) {
		if (theString1 == null && theString2 == null) {
			return true;
		}
		if (theString1 == null || theString2 == null) {
			return false;
		}
		return theString1.equals(theString2);
	}

	public static boolean isNotBlank(String theString) {
		return !isBlank(theString);
	}

	public static boolean isBlank(String theString) {
		int strLen;
		if (theString == null || (strLen = theString.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(theString.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	
	public static String defaultString(String theString) {
		if (theString == null) {
			return "";
		}
		return theString;
	}

}
