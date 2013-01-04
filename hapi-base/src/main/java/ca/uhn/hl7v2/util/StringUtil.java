package ca.uhn.hl7v2.util;

/**
 * Various string utility methods
 */
public class StringUtil {

	/**
	 * Counts the number of lines in a string by counting the number of "\n" or
	 * "\r" or "\r\n" sequences which appear in it
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
	 * Removes any line separators (\r ot \n) from the end of a string and
	 * returns that string
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
	 * Throws an IllegalArgumentException if the value is an empty string or
	 * null
	 */
	public static void validateNotEmpty(String theValue) {
		if (theValue == null || theValue.length() == 0) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Search within a string and replace one substring with another. Based on
	 * the method within Commons-Lang StringUtils.
	 */
	public static String replace(String theString, String theMatch, String theReplacement) {
		StringBuffer buf = new StringBuffer(theString.length());
		int start = 0, end = 0;
		while ((end = theString.indexOf(theMatch, start)) != -1) {
			buf.append(theString.substring(start, end)).append(theReplacement);
			start = end + theMatch.length();
		}
		buf.append(theString.substring(start));
		return buf.toString();
	}
	
	public static String[] concatenate(String[] array1, String[] array2) {
		if (array1 == null) return array2;
		if (array2 == null) return array1;
        String[] result = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
	}

	/**
	 * Returns <code>true</code> if the string is null, or contains no non-whitespace characters
	 */
	public static boolean isBlank(String theString) {
		if (theString == null) {
			return true;
		}
		
		for (int i = 0; i < theString.length(); i++) {
			if (Character.isWhitespace(theString.charAt(i)) == false) {
				return false;
			}
		}
		
		return true;
	}

}
