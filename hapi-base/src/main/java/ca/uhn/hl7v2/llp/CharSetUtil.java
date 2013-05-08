/**
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2001.  All Rights Reserved.

 Contributor(s): Jens Kristian Villadsen from Cetrea A/S

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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.preparser.PreParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Charset utility class
 *
 * @author Jens Kristian Villadsen from Cetrea A/S
 * @author Christian Ohr
 */
public class CharSetUtil {

    private static final Logger LOG = LoggerFactory.getLogger(CharSetUtil.class);

    static Charset checkCharset(String message, Charset defaultCharset) {
        Charset charset = defaultCharset;
        try {
            String[] fields = PreParser.getFields(message, "MSH-18(0)");
            String hl7CharsetName = stripNonLowAscii(fields[0]);
            if (hl7CharsetName != null && hl7CharsetName.length() > 0)
                charset = HL7Charsets.getCharsetForHL7Encoding(hl7CharsetName);
            LOG.trace("Detected MSH-18 value \"{}\" so using charset {}", hl7CharsetName, charset.displayName());
        } catch (EncodingNotSupportedException e) {
            LOG.warn("Invalid or unsupported charset in MSH-18. Defaulting to {}", charset.displayName());
        } catch (HL7Exception e) {
            LOG.warn("Failed to parse MSH segment. Defaulting to {}", charset.displayName(), e);
        }
        return charset;
    }

    static Charset checkCharset(byte[] message, Charset defaultCharset) {
        String guessMessage = BOM.skipBOM(message);
        return checkCharset(guessMessage, defaultCharset);
    }

    private static String stripNonLowAscii(String theString) {
        if (theString == null) return "";
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < theString.length(); i++) {
            char next = theString.charAt(i);
            if (next > 0 && next < 127) {
                b.append(next);
            }
        }

        return b.toString();
    }

    public static byte[] withoutBOM(byte[] bytes) {
        BOM bom = BOM.getBOM(bytes);
        byte[] withoutBOM = new byte[bytes.length - bom.bytes.length];
        System.arraycopy(bytes, bom.bytes.length, withoutBOM, 0, bytes.length - bom.bytes.length);
        return withoutBOM;
    }

    private enum BOM {

        UTF_8(new byte[]{
                (byte) 0xEF,
                (byte) 0xBB,
                (byte) 0xBF}, "UTF-8"),
        UTF_16_LE(new byte[]{
                (byte) 0xFF,
                (byte) 0xFE}, "UTF-16LE"),
        UTF_16_BE(new byte[]{
                (byte) 0xFE,
                (byte) 0xFF}, "UTF-16BE"),
        UTF_32_LE(new byte[]{
                (byte) 0xFF,
                (byte) 0xFE,
                (byte) 0x00,
                (byte) 0x00}, "UTF-32LE"),
        UTF_32_BE(new byte[]{
                (byte) 0x00,
                (byte) 0x00,
                (byte) 0xFE,
                (byte) 0xFF}, "UTF-32BE"),
        NONE(new byte[]{},    "US-ASCII");

        private byte[] bytes;
        private Charset charset;

        BOM(byte[] bytes, String charset) {
            this.bytes = bytes;
            this.charset = Charset.forName(charset);
        }

        public static BOM getBOM(byte[] bytes) {
            for (BOM bom : BOM.values()) {
                byte[] bytesToCompare = new byte[bom.bytes.length];
                System.arraycopy(bytes, 0, bytesToCompare, 0, bom.bytes.length);
                if (Arrays.equals(bom.bytes, bytesToCompare)) return bom;
            }
            return BOM.NONE;
        }

        public static String skipBOM(byte[] bytes) {
            try {
                BOM bom = getBOM(bytes);
                return new String(bytes, bom.bytes.length, bytes.length - bom.bytes.length, bom.charset.toString());
            } catch (UnsupportedEncodingException e) {
                // does not happen
                return null;
            }
        }




    }
}
