/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util.llp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;

public class ByteCapturingMinLowerLayerProtocolWrapper extends LowerLayerProtocol {

	private static final Logger ourLog = LoggerFactory.getLogger(ByteCapturingMinLowerLayerProtocolWrapper.class);
	
	private final LowerLayerProtocol myProtocolToWrap;
	private final ByteArrayOutputStream myReaderCapture;
	private final ByteArrayOutputStream myWriterCapture;

	public ByteCapturingMinLowerLayerProtocolWrapper(LowerLayerProtocol theProtocolToWrap) {
		myProtocolToWrap = theProtocolToWrap;
		myReaderCapture = new ByteArrayOutputStream();
		myWriterCapture = new ByteArrayOutputStream();
	}

	public ByteCapturingMinLowerLayerProtocolWrapper(LowerLayerProtocol theProtocolToWrap, ByteArrayOutputStream theReaderCapture, ByteArrayOutputStream theWriterCapture) {
		myProtocolToWrap = theProtocolToWrap;
		myReaderCapture = theReaderCapture;
		myWriterCapture = theWriterCapture;
	}

	@Override
	public HL7Reader getReader(InputStream theIn) throws LLPException {
		theIn = new InputStreamWrapper(theIn);
		return myProtocolToWrap.getReader(theIn);
	}

	@Override
	public HL7Writer getWriter(OutputStream theOut) throws LLPException {
		theOut = new OutputStreamWrapper(theOut);
		return myProtocolToWrap.getWriter(theOut);
	}

	/**
	 * @return the readerCapture
	 */
	public byte[] getReadBytes() {
		synchronized (myReaderCapture) {
			byte[] retVal = myReaderCapture.toByteArray();
			myReaderCapture.reset();
			return retVal;
		}
	}

	/**
	 * @return the readerCapture
	 */
	public byte[] getWriteBytes() {
		synchronized (myWriterCapture) {
			byte[] retVal = myWriterCapture.toByteArray();
			myWriterCapture.reset();
			return retVal;
		}
	}

	private class InputStreamWrapper extends InputStream {
		private InputStream myWrap;

		public InputStreamWrapper(InputStream theWrap) {
			myWrap = theWrap;
		}

		@Override
		public int available() throws IOException {
			int available = myWrap.available();
			ourLog.trace("Available bytes: {}", available);
			return available;
		}

		@Override
		public void close() throws IOException {
			ourLog.trace("Close");
			myWrap.close();
		}

		@Override
		public int read() throws IOException {
			ourLog.trace("read()");
			
			int retVal = myWrap.read();
			if (retVal == 65533) {
				retVal = -1;
			}
			
			if (retVal >= 0) {
				synchronized (myReaderCapture) {
					myReaderCapture.write(retVal);
				}
			}
			
			ourLog.trace("read() returned {}", retVal);
			
			return retVal;
		}

		@Override
		public long skip(long theN) throws IOException {
			ourLog.trace("skip {}", theN);
			return super.skip(theN);
		}

		@Override
		public synchronized void mark(int theReadlimit) {
			ourLog.trace("mark {}", theReadlimit);
			myWrap.mark(theReadlimit);
		}

		@Override
		public boolean markSupported() {
			ourLog.trace("markSupported");
			return myWrap.markSupported();
		}

		@Override
		public int read(byte[] theB) throws IOException {
			return read(theB, 0, theB.length);
		}

		@Override
		public int read(byte[] theB, int theOff, int theLen) throws IOException {
			ourLog.trace("ReadBAOL for offset {} and length {}", theOff, theLen);
		
			int read = 0;
			for (; read < Math.min(theLen, available()) || read == 0; read++) {
				theB[read + theOff] = (byte) read();
			}
			
			if (read == 1 && theB[theOff] == -1) {
				return -1;
			}
			
			ourLog.trace("ReadBAOL read {} bytes", read);
			return read;
		}

		@Override
		public synchronized void reset() throws IOException {
			ourLog.trace("Reset");
			myWrap.reset();
		}

	}

	private class OutputStreamWrapper extends OutputStream {
		private OutputStream myWrap;

		public OutputStreamWrapper(OutputStream theWrap) {
			myWrap = theWrap;
		}

		@Override
		public void write(int theB) throws IOException {
			ourLog.trace("write() {}", theB);
			
			synchronized (myWriterCapture) {
				myWriterCapture.write(theB);
			}
			myWrap.write(theB);
		}

		@Override
		public void flush() throws IOException {
			myWrap.flush();
		}

		@Override
		public void close() throws IOException {
			myWrap.close();
		}

	}

}
