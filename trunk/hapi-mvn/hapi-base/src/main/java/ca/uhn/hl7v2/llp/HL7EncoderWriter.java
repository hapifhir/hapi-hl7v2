/**
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "HL7EncoderWriter.java".  Description:
 ""

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2001.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.

 */

package ca.uhn.hl7v2.llp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import static ca.uhn.hl7v2.llp.MllpConstants.CHARSET_KEY;

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

abstract class HL7EncoderWriter<T extends MllpEncoder> implements HL7Writer {

    private OutputStream out;
    private T encoder;
    private Charset charset;
    protected boolean omitBOM;

    /**
     * Creates a HL7EncoderWriter with no output stream specified - <code>setOutputStream</code>
     * must be called before attempting to write any messages.
     */
    public HL7EncoderWriter() {
        encoder = initEncoder();
    }

    /**
     * Creates a HL7EncoderWriter, specifying the underlying output stream.
     */
    public HL7EncoderWriter(OutputStream out) throws IOException {
        setOutputStream(out);
        encoder = initEncoder();
    }

    /**
     * Creates a HL7EncoderWriter, specifying the underlying output stream.
     */
    public HL7EncoderWriter(OutputStream out, Charset charset, boolean omitBOM) throws IOException {
        this.out = out;
        this.charset = charset;
        this.omitBOM = omitBOM;
        encoder = initEncoder();
    }

    protected abstract T initEncoder();

    /**
     * Sets the underlying output stream to which messages are written.
     */
    public synchronized void setOutputStream(OutputStream out) throws IOException {
        if (out == null) throw new NullPointerException("OutputStream must not be null");
        this.out = new BufferedOutputStream(out);
    }

    /**
     * Sends a complete message to the underlying output stream, delimited
     * according to the minimal lower layer protocol.
     */
    public synchronized void writeMessage(String message) throws LLPException, IOException {
        if (message == null) {
            throw new NullPointerException("Message must not be null");
        }
        encoder.putMessage(message, out);
    }

    /**
     * Sends a complete message to the underlying output stream, delimited
     * according to the minimal lower layer protocol, using the specified character set.
     */
    public synchronized void writeMessage(String message, String charset) throws LLPException, IOException {
        if (message == null) {
            throw new NullPointerException("Message may not be null");
        }
        OutputStreamWriter writer = new OutputStreamWriter(out, charset);
        writer.write(MllpConstants.START_BYTE);
        writer.write(message);
        writer.write(MllpConstants.END_BYTE1);
        writer.write(MllpConstants.END_BYTE2);
        writer.flush();
    }

    public synchronized void close() throws IOException {
        if (out != null) out.close();
    }

    protected Charset getCharset() {
        if (charset == null) {
            String charsetString = System.getProperty(CHARSET_KEY, "US-ASCII");
            if (charsetString.equals("default")) {
                charset = Charset.defaultCharset();
            } else {
                charset = Charset.forName(charsetString);
            }
        }
        return charset;
    }
}