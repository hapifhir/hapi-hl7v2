/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MllpConstants.java".  Description:
 "Some constants for MLLP"

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

/**
 * Some constants for MLLP
 *
 * @author Christian Ohr
 */
public interface MllpConstants {

    public static final char START_BYTE = 0x0b;
    public static final char END_BYTE1 = 0x1c;
    public static final char END_BYTE2 = 0x0d;

    /**
     *<p>
     * System property: If a value is set for this property, the value
     * is interpreted as a character set, and this characterset is
     * used. A possible example is "UTF-8" if you are receiving messages
     * from a system that transmits in UTF-8.
     * </p>
     * <p>
     * If the system property is set to a value of "default" (in other words, a
     * string containing only the word default), then the platform default
     * is used.
     * </p>
     * <p>
     * If the system property is not set, US-ASCII encoding is used.
     * </p>
     */
    public static final String CHARSET_KEY = "ca.uhn.hl7v2.llp.charset";
}
