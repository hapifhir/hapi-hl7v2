/**
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "Escapin.java".  Description:
 "Interface for handling "escaping" and "unescaping" of text according to the HL7 escape sequence rules
 defined in section 2.10 of the standard (version 2.4)"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2001.  All Rights Reserved.

 Contributor(s): Mark Lee (Skeva Technologies); Elmar Hinz

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

/**
 * Handles "escaping" and "unescaping" of text according to the HL7 escape
 * sequence rules defined in section 2.10 of the standard (version 2.4).
 *
 * @author Christian Ohr
 */
public interface Escaping {

    /**
     * @param text string to be escaped
     * @param encChars encoding characters to be used
     * @return the escaped string
     */
    String escape(String text, EncodingCharacters encChars);

    /**
     * @param text string to be unescaped
     * @param encChars encoding characters to be used
     * @return the unescaped string
     */
    String unescape(String text, EncodingCharacters encChars);
}
