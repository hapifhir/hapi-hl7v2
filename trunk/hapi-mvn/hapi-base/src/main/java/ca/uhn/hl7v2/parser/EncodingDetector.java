/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Original Code is "GroupPointer.java".  Description:
"A GroupPointer is used when parsing traditionally encoded HL7 messages"

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

Contributor(s): ______________________________________.

Alternatively, the contents of this file may be used under the terms of the
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
applicable instead of those above.  If you wish to allow use of your version of this
file only under the terms of the GPL and not to allow others to use your version
of this file under the MPL, indicate your decision by deleting  the provisions above
and replace  them with the notice and other provisions required by the GPL License.
If you do not delete the provisions above, a recipient may use your version of
this file under either the MPL or the GPL.

*/

package ca.uhn.hl7v2.parser;

import java.util.StringTokenizer;

/**
 * Detects message encoding (ER7 / XML) without relying on any
 * external dependencies
 */
public final class EncodingDetector {

	/**
	 * Non instantiable
	 */
	private EncodingDetector() {
		// nothing
	}

    /**
     * Throws an exception if the message is not ER7 encoded
     *
     * @param theMessage message to be examined
     * @throws RuntimeException if message is not ER7-encoded
     */
	public static void assertEr7Encoded(String theMessage) {
        // quit if the string is too short
        if (theMessage.length() < 4)
            throw new RuntimeException("The message is less than 4 characters long");

        // string should start with "MSH"
        if (!theMessage.startsWith("MSH"))
            throw new RuntimeException("The message does not start with MSH");

        // 4th character of each segment should be field delimiter
        char fourthChar = theMessage.charAt(3);
        StringTokenizer st = new StringTokenizer(theMessage, String.valueOf(PipeParser.SEGMENT_DELIMITER), false);
        while (st.hasMoreTokens()) {
            String x = st.nextToken();
            if (x.length() > 0) {
                if (Character.isWhitespace(x.charAt(0)))
                    x = PipeParser.stripLeadingWhitespace(x);
                if (x.length() >= 4 && x.charAt(3) != fourthChar)
                    throw new RuntimeException(String.format(
                            "The 4th character should have been a %c, but it was a %c", x.charAt(3), fourthChar));
            }
        }

        // should be at least 11 field delimiters (because MSH-12 is required)
        int nextFieldDelimLoc = 0;
        for (int i = 0; i < 11; i++) {
            nextFieldDelimLoc = theMessage.indexOf(fourthChar, nextFieldDelimLoc + 1);
            if (nextFieldDelimLoc < 0)
                throw new RuntimeException("Expected to find required field MSH-12");
        }
	    
	}
	
	/**
	 * Returns true if the message is ER7 (pipe-and-hat) encoded
     *
     * @param theMessage message to be examined
     * @return true if message is ER7-encoded
     */
    public static boolean isEr7Encoded(String theMessage) {
        try {
            assertEr7Encoded(theMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

    /**
     * Throws an exception if the message is not XML encoded
     *
     * @param theMessage message to be examined
     * @throws RuntimeException if message is not XML-encoded
     */
    public static void assertXmlEncoded(String theMessage) {
        if (!theMessage.contains("MSH.1>")) throw new RuntimeException("Expected to find MSH.1");
        if (!theMessage.contains("MSH.2>")) throw new RuntimeException("Expected to find MSH.2");
    }

    /**
     * Returns true if the message is XML encoded. Note that this 
     * message does not perform a very robust check, and does not
     * validate for well-formedness. It is only intended to perform
     * a simple check for XML vs. ER7 messages.
     *
     * @param theMessage message to be examined
     * @return true if message is XML-encoded
     */
	public static boolean isXmlEncoded(String theMessage) {
        try {
            assertXmlEncoded(theMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	
}
