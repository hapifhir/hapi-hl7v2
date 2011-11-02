/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Escape.java".  Description: 
"Handles "escaping" and "unescaping" of text according to the HL7 escape sequence rules
defined in section 2.10 of the standard (version 2.4)" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): Mark Lee (Skeva Technologies); Elmar Hinz 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.parser;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Handles "escaping" and "unescaping" of text according to the HL7 escape
 * sequence rules defined in section 2.10 of the standard (version 2.4).
 * Currently, escape sequences for multiple character sets are unsupported. The
 * highlighting, hexademical, and locally defined escape sequences are also
 * unsupported.
 * 
 * @author Bryan Tripp
 * @author Mark Lee (Skeva Technologies)
 * @author Elmar Hinz
 * @author Christian Ohr
 */
public class Escape {

    /**
     * limits the size of variousEncChars to 1000, can be overridden by system property.
     */
    private static Map<EncodingCharacters, EncLookup> variousEncChars = Collections.synchronizedMap(new LinkedHashMap<EncodingCharacters, EncLookup>(5, 0.75f, true) {

        private static final long serialVersionUID = 1L;
        final int maxSize = new Integer(System.getProperty(Escape.class.getName() + ".maxSize", "1000"));

        @Override
        protected boolean removeEldestEntry(Map.Entry<EncodingCharacters, EncLookup> eldest) {
            return this.size() > maxSize;
        }
    });

    /** Creates a new instance of Escape */
    public Escape() {
    }

    public static String escape(String text, EncodingCharacters encChars) {
        EncLookup esc = getEscapeSequences(encChars);
        int textLength = text.length();

        StringBuilder result = new StringBuilder(textLength);
        for (int i = 0; i < textLength; i++) {
            boolean charReplaced = false;
            char c = text.charAt(i);

            FORENCCHARS:
			for (int j = 0; j < 6; j++) {
                if (text.charAt(i) == esc.characters[j]) {

					// Formatting escape sequences such as /.br/ should be left alone
					if (j == 4) {
						
						if (i+1 < textLength) {
							
							// Check for \.br\
							char nextChar = text.charAt(i + 1);
							switch (nextChar) {
							case '.':
							case 'C':
							case 'M':
							case 'X':
							case 'Z':
							{
								int nextEscapeIndex = text.indexOf(esc.characters[j], i + 1);
								if (nextEscapeIndex > 0) {
									result.append(text.substring(i, nextEscapeIndex + 1));
									charReplaced = true;
									i = nextEscapeIndex;
									break FORENCCHARS;
								}
								break;
							}
							case 'H':
							case 'N':
							{
								if (i+2 < textLength && text.charAt(i+2) == '\\') {
									int nextEscapeIndex = i + 2;
									if (nextEscapeIndex > 0) {
										result.append(text.substring(i, nextEscapeIndex + 1));
										charReplaced = true;
										i = nextEscapeIndex;
										break FORENCCHARS;
									}
								}
								break;
							}
							}
							
						}
						
					}

                    result.append(esc.encodings[j]);
                    charReplaced = true;
                    break;
                }
            }
            if (!charReplaced) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String unescape(String text, EncodingCharacters encChars) {

        // If the escape char isn't found, we don't need to look for escape sequences
        char escapeChar = encChars.getEscapeCharacter();
        boolean foundEscapeChar = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == escapeChar) {
                foundEscapeChar = true;
                break;
            }
        }
        if (foundEscapeChar == false) {
            return text;
        }

        int textLength = text.length();
        StringBuilder result = new StringBuilder(textLength + 20);
        EncLookup esc = getEscapeSequences(encChars);
        char escape = esc.characters[4];
        int encodingsCount = esc.characters.length;
        int i = 0;
        while (i < textLength) {
            char c = text.charAt(i);
            if (c != escape) {
                result.append(c);
                i++;
            } else {
                boolean foundEncoding = false;

				// Test against the standard encodings
				for (int j = 0; j < encodingsCount; j++) {
                    String encoding = esc.encodings[j];
					int encodingLength = encoding.length();
					if ((i + encodingLength <= textLength) && text.substring(i, i + encodingLength)
                            .equals(encoding)) {
                        result.append(esc.characters[j]);
                        i += encodingLength;
                        foundEncoding = true;
                        break;
                    }
                }

                if (!foundEncoding) {
					
					// If we haven't found this, there is one more option. Escape sequences of /.XXXXX/ are
					// formatting codes. They should be left intact
					if (i + 1 < textLength) {
						char nextChar = text.charAt(i + 1);
						switch (nextChar) {
							case '.':
							case 'C':
							case 'M':
							case 'X':
							case 'Z':
							{
								int closingEscape = text.indexOf(escape, i + 1);
								if (closingEscape > 0) {
									String substring = text.substring(i, closingEscape + 1);
									result.append(substring);
									i += substring.length();
								} else {
									i++;
								}
								break;
							}
							case 'H':
							case 'N':
							{
								int closingEscape = text.indexOf(escape, i + 1);
								if (closingEscape == i + 2) {
									String substring = text.substring(i, closingEscape + 1);
									result.append(substring);
									i += substring.length();
								} else {
									i++;
								}
								break;
							}
							default:
							{
								i++;
							}
						}
						
					} else {
						i++;
					}
                }


            }
        }
        return result.toString();
    }

    /**
     * Returns a HashTable with escape sequences as keys, and corresponding
     * Strings as values.
     */
    private static EncLookup getEscapeSequences(EncodingCharacters encChars) {
        EncLookup escapeSequences = variousEncChars.get(encChars);
        if (escapeSequences == null) {
            // this means we haven't got the sequences for these encoding
            // characters yet - let's make them
            escapeSequences = new EncLookup(encChars);
            variousEncChars.put(encChars, escapeSequences);
        }
        return escapeSequences;
    }




    /**
     * A performance-optimized replacement for using when
     * mapping from HL7 special characters to their respective
     * encodings
     *
     * @author Christian Ohr
     */
    private static class EncLookup {

        char[] characters = new char[6];
        String[] encodings = new String[6];

        EncLookup(EncodingCharacters ec) {
            characters[0] = ec.getFieldSeparator();
            characters[1] = ec.getComponentSeparator();
            characters[2] = ec.getSubcomponentSeparator();
            characters[3] = ec.getRepetitionSeparator();
            characters[4] = ec.getEscapeCharacter();
            characters[5] = '\r';
            char[] codes = {'F', 'S', 'T', 'R', 'E'};
            for (int i = 0; i < codes.length; i++) {
                StringBuffer seq = new StringBuffer();
                seq.append(ec.getEscapeCharacter());
                seq.append(codes[i]);
                seq.append(ec.getEscapeCharacter());
                encodings[i] = seq.toString();
            }
            encodings[5] = "\\X000d\\";
        }
    }
}
