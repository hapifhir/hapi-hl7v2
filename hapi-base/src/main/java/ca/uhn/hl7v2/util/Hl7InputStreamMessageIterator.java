package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * <p>
 * Reads from an {@link InputStream} containing a stream of encoded HL7 messages
 * and iterates over those messages. This class is geared towards reading from
 * files, and tries to be very lenient about the format of the stream,
 * specifically concerning control characters and line endings. It should be
 * safe to provide a stream containing Windows or Unix line endings (which will
 * be treated as segment delimiters). It is also safe to provide a stream containing
 * MLLP control blocks before and after each message (although these will not be
 * validated! Do not use this class to read MLLP messages from a socket stream!)
 * </p>
 * <p>
 * The input stream could, for example, be a FileInputStream reading from a text
 * file containing a number of HL7 messages in plain text format.
 * </p>
 * <p>
 * Usage note: If an IOException occurs while reading from the streamor a
 * message parsing exception occurs, it will be thrown as an unchecked
 * {@link ParseFailureError}
 * </p>
 */
public class Hl7InputStreamMessageIterator implements Iterator<Message> {

	private static final Log ourLog = LogFactory.getLog(Hl7InputStreamMessageIterator.class);
	private Reader myReader;
	private Boolean myHasNext;
	private Message myNext;
	private Parser myParser;
	private StringBuilder myBuffer = new StringBuilder();
	private boolean myFoundMessageInBuffer = false;

	/**
	 * Constructor
	 * 
	 * @param theInputStream
	 *            The input stream to read from
	 */
	public Hl7InputStreamMessageIterator(InputStream theInputStream) {
		this(new InputStreamReader(theInputStream));
	}

	/**
	 * Constructor
	 * 
	 * @param theReader
	 *            The reader to read from
	 */
	public Hl7InputStreamMessageIterator(Reader theReader) {
		myReader = new PushbackReader(theReader);
		myParser = PipeParser.getInstanceWithNoValidation();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasNext() {
		if (myHasNext == null) {

			int next;
			int endOfBuffer = -1;
			while (true) {
				try {
					next = myReader.read();
				} catch (IOException e) {
					throw new ParseFailureError("IOException reading from input", e);
				}

				if (next == -1) {
					break;
				}

				// Convert '\n' or "\r\n" to '\r'
				char nextChar = (char) next;
				if (nextChar == 10) {
					if (myBuffer.length() > 0) {
						if (myBuffer.charAt(myBuffer.length() - 1) == 13) {
							// don't append
						} else {
							myBuffer.append((char) 13);
						}
					}
				} else {
					myBuffer.append(nextChar);
				}

				int bLength = myBuffer.length();
				if (nextChar == 'H' && bLength >= 3) {
					if (myBuffer.charAt(bLength - 2) == 'S') {
						if (myBuffer.charAt(bLength - 3) == 'M') {
							if (myFoundMessageInBuffer) {
								if (myBuffer.charAt(bLength - 4) < 32) {
									endOfBuffer = bLength - 3;
									break;
								}
							} else {
								// Delete any whitespace or other stuff before
								// the first message
								myBuffer.delete(0, bLength - 3);
								myFoundMessageInBuffer = true;
							}
						}
					}
				}

			} // while(true)

			if (!myFoundMessageInBuffer) {
				myHasNext = false;
				return myHasNext;
			}

			String msgString;
			if (endOfBuffer > -1) {
				msgString = myBuffer.substring(0, endOfBuffer);
				myBuffer.delete(0, endOfBuffer);
			} else {
				msgString = myBuffer.toString();
				myBuffer.setLength(0);
			}

			if (!msgString.startsWith("MSH")) {
				myHasNext = Boolean.FALSE;
				return myHasNext;
			}

			try {
				myNext = myParser.parse(msgString);
			} catch (HL7Exception e) {
				throw new ParseFailureError("Failed to parse message", e);
			}

			myHasNext = Boolean.TRUE;

		}
		return myHasNext;
	}

	/**
	 * {@inheritDoc}
	 */
	public Message next() {
		if (!hasNext()) {
			throw new IllegalStateException();
		}
		Message retVal = myNext;
		myNext = null;
		myHasNext = null;
		return retVal;
	}

	/**
	 * Unsupported method!
	 * 
	 * @throws UnsupportedOperationException
	 *             If called
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public static class ParseFailureError extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ParseFailureError(String theMessage, Exception theCause) {
			super(theMessage, theCause);
		}

	}

}
