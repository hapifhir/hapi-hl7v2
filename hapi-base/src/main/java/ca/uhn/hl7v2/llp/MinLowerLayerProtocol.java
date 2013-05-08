/**
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MinLowerLayerProtocol.java".  Description:
 "Implements the "Minimal Lower Layer Protocol" from the HL7 Implementation
 Guide, Appendix C"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2001.  All Rights Reserved.

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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Implements the "Minimal Lower Layer Protocol" from the HL7 Implementation
 * Guide, Appendix C.  In other words, provides a reader and a writer that can be
 * used to communicate with a server that uses the minimal LLP.
 * <p>
 * Note:
 * </p>
 * <p>
 * The MLLP Block is framed by single-byte values. The characters transmitted within the MLLP Block
 * have to be encoded in such a way that the HL7 Content does not conflict with the byte values used
 * for framing. Some multi-byte character encodings (e.g. UTF-16, UTF-32) may result in byte values
 * equal to the MLLP framing characters or byte values lower than 0x1F, resulting in errors.
 * These character encodings are therefore not supported by MLLP.
 * MLLP supports all single-byte character encodings (e.g. iso-8859-x, cp1252) as well as UTF-8 and Shift_JIS.
 * The byte values used by UTF-8 do not conflict with the byte values used for MLLP framing.
 * </p>
 * <p>
 * HAPI still tries to support UTF-16 and UTF-32 as best as possible. To be able to detect per-message
 * encoding information in MSH-18 with these encodings, corresponding byte order marks (BOMs) are expected
 * at the beginning of the message payload (i.e. AFTER the MLLP start byte) to be able to decode the
 * message in order to read the MSH-18 field. This scheme is also followed when the MinLLPWriter
 * sends out UTF-16 or UTF-32-encoded MLLP messages unless {@link #setOmitBOM(boolean)} is explicitly
 * set to true.
 * </p>
 * <p>
 * In general, it is <b>NOT</b> recommended to use UTF-16 or UTF-32.
 * </p>
 *
 * @author Bryan Tripp
 * @author Christian Ohr
 *
 * @see MinLLPReader
 * @see MinLLPWriter
 */
public class MinLowerLayerProtocol extends LowerLayerProtocol {

    private final boolean respectMSH18;
    private final boolean omitBOM;


    public MinLowerLayerProtocol() {
        this(false, false);
    }

    public MinLowerLayerProtocol(boolean respectMSH18) {
        this(respectMSH18, false);
    }

    public MinLowerLayerProtocol(boolean respectMSH18, boolean omitBOM) {
        this.respectMSH18 = respectMSH18;
        this.omitBOM = omitBOM;
    }

    /**
     * Creates an HL7Reader that implements message reading according to
     * this protocol.
     */
    public HL7Reader getReader(InputStream in) throws LLPException {
        try {
            return respectMSH18 ?
                    new ExtendedMinLLPReader(in, charset) :
                    new MinLLPReader(in, charset);
        } catch (IOException e) {
            throw new LLPException("Can't create Reader with the given input stream: " + e.getMessage(), e);
        }
    }

    /**
     * Creates an HL7Writer that implements message writing according to
     * this protocol.
     */
    public HL7Writer getWriter(OutputStream out) throws LLPException {
        try {
            return respectMSH18 ?
                    new ExtendedMinLLPWriter(out, charset, omitBOM) :
                    new MinLLPWriter(out, charset, omitBOM);
        } catch (IOException e) {
            throw new LLPException("Can't create Writer with the given output stream: " + e.getMessage(), e);
        }
    }

}
