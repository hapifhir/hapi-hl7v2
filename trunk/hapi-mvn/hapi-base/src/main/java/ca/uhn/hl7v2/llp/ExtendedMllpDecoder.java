/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "ExtendedMllpDecoder.java".  Description:
 "Decodes an InputStream into a String, but respects a potentially populated field MSH-18"

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ExtendedMllpDecoder decodes an InputStream into a String, but obeys a potentially
 * populated field MSH-18 to determine the character set. If the field is not populated
 * or an unknown charset name is given or MSH-18 cannot be parsed at all, a log
 * is written and the default charset is used instead.
 *
 * @author Christian Ohr
 */
class ExtendedMllpDecoder extends MllpDecoder {

    private static final Logger LOG = LoggerFactory.getLogger(ExtendedMllpDecoder.class);

    // for test purposes only
    private Charset lastCharset;

    ExtendedMllpDecoder(Charset charset) {
        super(charset);
    }

    /**
     * Use the charset as specified in MSH-18, fallback to configured charset
     * and eventually to ASCII.
     *
     * @param data HL7 message as byte sequence
     * @return decoded message
     */
    @Override
    protected String toString(byte[] data) {
        Charset charset = CharSetUtil.checkCharset(data, this.charset);
        lastCharset = charset;
        return asString(data, charset);
    }

    // for test purposes only
    Charset getLastCharset() {
        return lastCharset;
    }
}
