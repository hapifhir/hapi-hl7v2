/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MllpDecoderState.java".  Description:
 "State machine that handles reading MLLP frames"

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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ca.uhn.hl7v2.llp.MllpConstants.END_BYTE1;
import static ca.uhn.hl7v2.llp.MllpConstants.END_BYTE2;
import static ca.uhn.hl7v2.llp.MllpConstants.START_BYTE;

/**
 * MllpDecoderState implements a small state machine that handles reading bytes at the various
 * positions in the MLLP input stream, thereby promoting the state if the MLLP marker bytes
 * are encountered.
 *
 * @author Christian Ohr
 */
enum MllpDecoderState {

    START(START_BYTE, true) {
        @Override
        protected MllpDecoderState proceed() {
            return BODY;
        }

        @Override
        protected void handleEndOfStream() throws IOException {
            LOG.info("End of input stream reached.");
            throw new SocketException("End of input stream reached before message starts");
        }

    },
    BODY(END_BYTE1, false) {
        @Override
        protected MllpDecoderState proceed() {
            return PREPARE_END;
        }

        @Override
        protected void handleEndOfStream() throws IOException, LLPException {
            throw new LLPException("MLLP protocol violation - Stream ends in the message body");
        }

    },
    PREPARE_END(END_BYTE2, true) {
        @Override
        protected MllpDecoderState proceed() {
            return END;
        }

        @Override
        protected void handleEndOfStream() throws IOException, LLPException {
            throw new LLPException("MLLP protocol violation - Stream ends before LLP end byte");
        }
    },
    END(0, false) {
        @Override
        protected MllpDecoderState proceed() {
            return END;
        }

        @Override
        protected void handleEndOfStream() throws IOException, LLPException {
        }

        @Override
        MllpDecoderState read(InputStream in, OutputStream out) throws IOException, LLPException {
            throw new LLPException("Internal error - reading after end of message");
        }
    };

    private int nextStateByte; // byte required for state transition
    private boolean mustChangeState; // next byte must be nextStateByte

    private static final Logger LOG = LoggerFactory.getLogger(MllpDecoderState.class);


    MllpDecoderState(int nextStateByte, boolean mustChangeState) {
        this.nextStateByte = nextStateByte;
        this.mustChangeState = mustChangeState;
    }

    /**
     * Reads data from the input stream, records the actual payload and promtes the
     * state if applicable.
     *
     * @param in  input
     * @param out recorded data
     * @return next decoder state
     * @throws SocketTimeoutException If the socket times out
     * @throws IOException
     * @throws LLPException
     */
    MllpDecoderState read(InputStream in, OutputStream out) throws SocketTimeoutException, IOException, LLPException {
        int c;
        try {
            if ((c = in.read()) == -1) {
                handleEndOfStream();
            } else {
                LowerLayerProtocol.logCharacterReceived(c);
            }
            if (c == nextStateByte) {
            	return proceed();
            }
            if (mustChangeState) {
                throw new LLPException("MLLP protocol violation - Expected byte '" + nextStateByte +
                        "' in state " + this + " but was '" + c + "'");
            }
            out.write(c);
        } catch (SocketTimeoutException e) {
        	// Logged in the caller so we don't do it here
            throw e;
        } catch (SocketException e) {
            LOG.info("SocketException on read() attempt.  Socket appears to have been closed: " + e.getMessage());
            throw e;
        }
        return this;
    }

    /**
     * Proceed to the next state
     *
     * @return next decoder state
     */
    protected abstract MllpDecoderState proceed();

    /**
     * Handle occurences of unexpected ends of streams
     *
     * @throws IOException
     * @throws LLPException
     */
    protected abstract void handleEndOfStream() throws IOException, LLPException;

}
