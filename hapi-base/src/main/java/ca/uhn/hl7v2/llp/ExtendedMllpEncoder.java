/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "ExtendedMllpEncoder.java".  Description:
 "Encodes a String into an OutputStream, but respects a potentially populated field MSH-18"

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
 * ExtendedMllpEncoder encodes a String into an OutputStream, but obeys a potentially
 * populated field MSH-18 to determine the character set. If the field is not populated
 * or an unknown charset name is given or MSH-18 cannot be parsed at all, a log
 * is written and the default charset is used instead.
 *
 * @author Christian Ohr
 */
class ExtendedMllpEncoder extends MllpEncoder {

    private static final Logger LOG = LoggerFactory.getLogger(ExtendedMllpEncoder.class);

    public ExtendedMllpEncoder(Charset charset, boolean omitBOM) {
        super(charset, omitBOM);
    }

    /**
     * Use the charset as specified in MSH-18, fallback to configured charset
     * or ASCII.
     *
     * @param message
     * @return encoded message
     */
    @Override
    protected byte[] toByteArray(String message) {
        Charset charset = CharSetUtil.checkCharset(message, this.charset);
        return asByteArray(message, charset, omitBOM);
    }
}
