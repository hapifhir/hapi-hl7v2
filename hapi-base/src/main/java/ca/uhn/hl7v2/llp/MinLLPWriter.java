/**
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MinLLPWriter.java".  Description:
 "Writes HL7 messages to an OutputStream"

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

package ca.uhn.hl7v2.llp;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Writes HL7 messages to an OutputStream.  The character set defaults to US-ASCII.
 * It can be changed by setting the system property ca.uhn.hl7v2.llp.charset to another value that
 * is the name of a valid java.nio.charset.Charset.  If this property is set to "default", then
 * the system default is used.
 *
 * <p/>
 *
 * @author Damian Horton; mods by Bryan Tripp
 * @author Christian Ohr
 */

public class MinLLPWriter extends HL7EncoderWriter<MllpEncoder> {

    public MinLLPWriter() {
    }

    public MinLLPWriter(OutputStream out) throws IOException {
        super(out);
    }

    public MinLLPWriter(OutputStream out, Charset charset) throws IOException {
        this(out, charset, false);
    }

    public MinLLPWriter(OutputStream out, Charset charset, boolean omitBOM) throws IOException {
        super(out, charset, omitBOM);
    }

    @Override
    protected MllpEncoder initEncoder() {
        return new MllpEncoder(getCharset(), omitBOM);
    }


}