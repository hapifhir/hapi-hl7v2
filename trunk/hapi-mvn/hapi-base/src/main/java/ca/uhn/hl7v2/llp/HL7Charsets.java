/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "Table0211.java".  Description:
 "Content of HL7 table 0211 mapped to Java charsets"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.llp;

import java.nio.charset.Charset;

import ca.uhn.hl7v2.parser.EncodingNotSupportedException;

/**
 * HL7 Charsets from Table 0211 mapped to Java charsets
 *
 * @author Christian Ohr
 */
enum HL7Charsets {
    ASCII       ("ASCII",           "US-ASCII"),        // ASCII
    ISO_8859_1  ("8859/1",          "ISO-8859-1"),      // Western European Latin 1
    ISO_8859_2  ("8859/2",          "ISO-8859-2"),      // Middle European
    ISO_8859_3  ("8859/3",          "ISO-8859-3"),      // Southern European
    ISO_8859_4  ("8859/4",          "ISO-8859-4"),      // Northern European
    ISO_8859_5  ("8859/5",          "ISO-8859-5"),      // Cyrillic
    ISO_8859_6  ("8859/6",          "ISO-8859-6"),      // Arab
    ISO_8859_7  ("8859/7",          "ISO-8859-7"),      // Greek
    ISO_8859_8  ("8859/8",          "ISO-8859-8"),      // Hebrew
    ISO_8859_9  ("8859/9",          "ISO-8859-9"),      // Turk
    ISO_8859_15 ("8859/15",         "ISO-8859-15"),     // Western European Latin 9
    ISO_IR_6    ("ISO IR6",         "US-ASCII"),
    ISO_IR_14   ("ISO IR14",        "JIS_X0201"),       // Japanese
    ISO_IR_87   ("ISO IR87",        "x-JIS0208"),       // Japanese Kanji
    ISO_IR_159  ("ISO IR159",       "JIS_X0212-1990"),  // Japanese Kanji
    GB_18030    ("GB 18030-2000",   "GB18030"),         // Chinese
    KS_X_1001   ("KS X 1001",       "EUC-KR"),          // Korean
    CNS_11643   ("CNS 11643-1992",  "x-EUC-TW"),        // Chinese
    BIG_5       ("BIG-5",           "Big5"),            // Chinese/Taiwan
    UNICODE     ("UNICODE",         "UTF-8"),
    UTF_8       ("UNICODE UTF-8",   "UTF-8"),
    UTF_16      ("UNICODE UTF-16",  "UTF-16"),
    UTF_32      ("UNICODE UTF-32",  "UTF-32");


    private String hl7EncodingName;
    private Charset charset;

    private HL7Charsets(String hl7EncodingName, String charset) {
        this.hl7EncodingName = hl7EncodingName;
        this.charset = Charset.forName(charset);
    }

    /**
     * Returns the Java charset for the HL7 charset name
     * @param hl7EncodingName
     * @return Java charset
     * @throws EncodingNotSupportedException if encoding name is unknown
     */
    public static Charset getCharsetForHL7Encoding(String hl7EncodingName) throws EncodingNotSupportedException {
        if (hl7EncodingName == null || hl7EncodingName.length() == 0)
            return HL7Charsets.ASCII.charset;
        for (HL7Charsets encoding : HL7Charsets.values()) {
            if (hl7EncodingName.equals(encoding.hl7EncodingName))
                return encoding.charset;
        }

        throw new EncodingNotSupportedException(hl7EncodingName);
    }

    public static void main(String[] params) {
        for (HL7Charsets entry : HL7Charsets.values()) {
            Charset cs = entry.charset;
            System.out.print(cs.displayName());
            for (String alias : cs.aliases()) {
                System.out.print(" " + alias);
            }
            System.out.println();
        }
    }
}
