package ca.uhn.hl7v2.util;

/**
 * Various string utility methods
 */
public class StringUtil {

	/**
	 * Counts the number of lines in a string by counting the
	 * number of "\n" or "\r" or "\r\n" sequences which appear in it
	 */
	public static int countLines(String theString) {
		int retVal = 1;
		
		for (int i = 0; i < theString.length(); i++) {
			char nextChar = theString.charAt(i);
			if (i > 0 && nextChar == '\n' && theString.charAt(i - 1) == '\r') {
				continue;
			}
			if (nextChar == '\r' | nextChar == '\n') {
				retVal++;
			}
		}
		
		return retVal;
	}

	/**
	 * Removes any line separators (\r ot \n) from the end of a string and returns that string
	 */
	public static String chomp(String theLine) {
		int i;
		int start = theLine.length() - 1;
		for (i = start; i >= 0; i--) {
			char nextChar = theLine.charAt(i);
			if (nextChar != '\r' && nextChar != '\n') {
				break;
			}
		}
		
		if (i == start) {
			return theLine;
		} else {
			return theLine.substring(0, i + 1);
		}
	}

	/**
	 * Throws an IllegalArgumentException if the value is an empty string or null
	 */
	public static void validateNotEmpty(String theValue) {
		if (theValue == null || theValue.length() == 0) {
			throw new IllegalArgumentException();
		}
	}
	
}
