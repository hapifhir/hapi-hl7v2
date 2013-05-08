/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MllpDecoder.java".  Description:
 "Decodes an MLLP input stream into a string"

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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * MllpDecoder decodes an InputStream into a String.
 *
 * @author Christian Ohr
 */
class MllpDecoder {

    protected Charset charset;

    MllpDecoder(Charset charset) {
        this.charset = charset;
    }

    /**
     * Returns a HL7 message string extracted from the MLLP stream
     *
     * @param in MLLP input stream
     * @return HL7 message string
     * @throws IOException
     * @throws LLPException
     */
    public String getMessage(InputStream in) throws IOException, LLPException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MllpDecoderState state = MllpDecoderState.START;
        while (state != MllpDecoderState.END) {
            state = state.read(in, out);
        }
        return out.size() > 0 ? toString(out.toByteArray()) : null;
    }

    /**
     * Converts the extract byte sequence into a String. This method must respect
     * a Charset, which is either statically configured or may be obtained at runtime.
     *
     * @param data HL7 message as byte sequence
     * @return HL7 message String using correct charset
     */
    protected String toString(byte[] data) {
        return asString(data, charset);
    }

    protected static String asString(byte[] data, Charset charset) {
        try {
            return new String(data, charset.name()); // remain 1.5 compatible
        } catch (UnsupportedEncodingException e) {
            // never happens
            return null;
        }
    }
}
