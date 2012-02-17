package ca.uhn.hl7v2.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Reads from an {@link InputStream} containing a stream of encoded HL7 messages
 * and iterates over those messages. This class is geared towards reading from
 * files, and tries to be very lenient about the format of the stream,
 * specifically concerning control characters and line endings. It should be
 * safe to provide a stream containing Windows or Unix line endings (which will
 * be treated as segment delimiters). It is also safe to provide a stream
 * containing MLLP control blocks before and after each message (although these
 * will not be validated! Do not use this class to read MLLP messages from a
 * socket stream!)
 * </p>
 * <p>
 * The input stream could, for example, be a FileInputStream reading from a text
 * file containing a number of HL7 messages in plain text format.
 * </p>
 * <p>
 * Usage note: If an IOException occurs while reading from the stream or a
 * message parsing exception occurs, it will be thrown as an unchecked
 * {@link ParseFailureError}
 * </p>
 */
public class Hl7InputStreamMessageStringIterator implements Iterator<String> {

	@SuppressWarnings("unused")
	private static final Logger ourLog = LoggerFactory.getLogger(Hl7InputStreamMessageStringIterator.class);
	
	private StringBuilder myBuffer = new StringBuilder();
	private boolean myFoundMessageInBuffer = false;
	private Boolean myHasNext;
	private boolean myIgnoreComments;
	private String myNext;
	private Reader myReader;

	/**
	 * Constructor
	 * 
	 * @param theInputStream
	 *            The input stream to read from
	 */
	public Hl7InputStreamMessageStringIterator(InputStream theInputStream) {
		this(new InputStreamReader(theInputStream));
	}

	/**
	 * Constructor
	 * 
	 * @param theReader
	 *            The reader to read from
	 */
	public Hl7InputStreamMessageStringIterator(Reader theReader) {
		myReader = new PushbackReader(theReader);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasNext() {
		if (myHasNext == null) {

			int next;
			int prev = -1;
			int endOfBuffer = -1;
			boolean inComment = false;
			
			while (true) {
				try {
					next = myReader.read();
				} catch (IOException e) {
					throw new ParseFailureError("IOException reading from input", e);
				}

				if (next == -1) {
					break;
				}

				char nextChar = (char) next;
				if (nextChar == '#' && myIgnoreComments && (prev == -1 || prev == '\n' || prev == '\r')) {
					inComment = true;
					continue;
				}
				
				// Convert '\n' or "\r\n" to '\r'
				if (nextChar == 10) {
					if (myBuffer.length() > 0) {
						if (myBuffer.charAt(myBuffer.length() - 1) == 13) {
							// don't append
						} else {
							myBuffer.append((char) 13);
						}
					}
				} else if (inComment) {
					if (nextChar == 10 || nextChar == 13) {
						inComment = false;
					}
				} else {
					myBuffer.append(nextChar);
				}
				
				prev = next;
				
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

			myNext = msgString;
			myHasNext = Boolean.TRUE;

		}
		return myHasNext;
	}

	/**
	 * {@inheritDoc}
	 */
	public String next() {
		if (!hasNext()) {
			throw new IllegalStateException();
		}
		String retVal = myNext;
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

	/**
	 * If set to true, any lines beginning with a hash (#) will be ignored. This
	 * allows you to place comments in a file to be read if needed.
	 */
	public void setIgnoreComments(boolean theIgnoreComments) {
		myIgnoreComments = theIgnoreComments;
	}

	public static class ParseFailureError extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ParseFailureError(String theMessage, Exception theCause) {
			super(theMessage, theCause);
		}

	}

}
