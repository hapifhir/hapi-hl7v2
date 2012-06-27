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
public class EncodingDetector {

	/**
	 * Non instantiable
	 */
	private EncodingDetector() {
		// nothing
	}
	
	/**
	 * Returns true if the message is ER7 (pipe-and-hat) encoded
	 */
    public static boolean isEr7Encoded(String theMessage) {
        // quit if the string is too short
        if (theMessage.length() < 4)
            return false;

        // see if it looks like this message is | encoded ...
        boolean ok = true;

        // string should start with "MSH"
        if (!theMessage.startsWith("MSH"))
            return false;

        // 4th character of each segment should be field delimiter
        char fourthChar = theMessage.charAt(3);
        StringTokenizer st = new StringTokenizer(theMessage, String.valueOf(PipeParser.SEGMENT_DELIMITER), false);
        while (st.hasMoreTokens()) {
            String x = st.nextToken();
            if (x.length() > 0) {
                if (Character.isWhitespace(x.charAt(0)))
                    x = PipeParser.stripLeadingWhitespace(x);
                if (x.length() >= 4 && x.charAt(3) != fourthChar)
                    return false;
            }
        }

        // should be at least 11 field delimiters (because MSH-12 is required)
        int nextFieldDelimLoc = 0;
        for (int i = 0; i < 11; i++) {
            nextFieldDelimLoc = theMessage.indexOf(fourthChar, nextFieldDelimLoc + 1);
            if (nextFieldDelimLoc < 0)
                return false;
        }
        
        return ok;
	}

    
	/**
	 * Returns true if the message is XML encoded. Note that this 
	 * message does not perform a very robust check, and does not
	 * validate for well-formedness. It is only intended to perform
	 * a simple check for XML vs. ER7 messages.
	 */
	public static boolean isXmlEncoded(String theMessage) {
        //check for a number of expected strings 
        String[] expected = { "<MSH.1", "<MSH.2", "</MSH>" };
        for (int i = 0; i < expected.length; i++) {
            if (theMessage.indexOf(expected[i]) < 0) {
                return false;
            }
        }
        
        return true;
	}

	
}
