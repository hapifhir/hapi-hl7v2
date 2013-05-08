/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MllpEncoder.java".  Description:
 "Encodes a message string into an MLLP output stream"

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

import java.io.*;
import java.nio.charset.Charset;

/**
 * MllpEncoder encodes a String into an OutputStream
 *
 * @author Christian Ohr
 */
class MllpEncoder {

    protected Charset charset;
    protected boolean omitBOM;

    MllpEncoder(Charset charset, boolean omitBOM) {
        this.charset = charset;
        this.omitBOM = omitBOM;
    }

    /**
     * Returns a HL7 message string extracted from the MLLP stream
     *
     * @param in MLLP input stream
     * @return HL7 message string
     * @throws java.io.IOException
     * @throws ca.uhn.hl7v2.llp.LLPException
     */
    public void putMessage(String message, OutputStream out) throws IOException, LLPException {
        // Try to enforce sending the message in one frame. Multiple calls to write()
        // may cause multiple frames being sent.
        byte[] bytes = toByteArray(message);
        byte[] outBytes = new byte[bytes.length + 3];
        outBytes[0] = MllpConstants.START_BYTE;
        System.arraycopy(bytes, 0, outBytes, 1, bytes.length);
        outBytes[outBytes.length - 2] = MllpConstants.END_BYTE1;
        outBytes[outBytes.length - 1] = MllpConstants.END_BYTE2;

        out.write(outBytes);
        out.flush();
    }

    /**
     * Converts the extract byte sequence into a String. This method must respect
     * a Charset, which is either statically configured or may be obtained at runtime.
     *
     * @param data HL7 message as byte sequence
     * @return HL7 message String using correct charset
     */
    protected byte[] toByteArray(String message) {
        return asByteArray(message, charset, omitBOM);
    }

    protected static byte[] asByteArray(String message, Charset charset, boolean omitBOM) {
        try {
            byte[] b = message.getBytes(charset.name());
            return omitBOM ? CharSetUtil.withoutBOM(b) : b;
        } catch (UnsupportedEncodingException e) {
            // never happens
            return null;
        }
    }

}
