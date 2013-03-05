package ca.uhn.hl7v2.hoh.util;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class StringUtils {

	public static final String LINE_SEP = System.getProperty("line.separator");

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

	public static String asciiEscape(byte[] theBytes, Charset theCharset) {
		StringBuilder b = new StringBuilder();

		try {
			InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(theBytes), theCharset);
			while (reader.ready()) {
				char read = (char) reader.read();
				if (read < 32) {
					b.append('[').append((int) read).append(']');
				} else {
					b.append(read);
				}
			}
		} catch (Exception e) {
			b.append("ERROR: ").append(e.toString());
		}
		return b.toString();
	}

}
