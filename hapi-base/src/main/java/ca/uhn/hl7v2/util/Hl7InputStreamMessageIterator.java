package ca.uhn.hl7v2.util;

import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator.ParseFailureError;

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
 * Usage note: If an IOException occurs while reading from the stream or a
 * message parsing exception occurs, it will be thrown as an unchecked
 * {@link ParseFailureError}
 * </p>
 */
public class Hl7InputStreamMessageIterator implements Iterator<Message> {

	private Hl7InputStreamMessageStringIterator myWrapped;
	private PipeParser myParser;

	/**
	 * Constructor
	 * 
	 * @param theInputStream
	 *            The input stream to read from
	 */
	public Hl7InputStreamMessageIterator(InputStream theInputStream) {
		myWrapped = new Hl7InputStreamMessageStringIterator(theInputStream);
		init();
	}

	/**
	 * Constructor
	 * 
	 * @param theReader
	 *            The reader to read from
	 */
	public Hl7InputStreamMessageIterator(Reader theReader) {
		myWrapped = new Hl7InputStreamMessageStringIterator(theReader);
		init();
	}

	private void init() {
		myParser = PipeParser.getInstanceWithNoValidation();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasNext() {
		return myWrapped.hasNext();
	}

	/**
	 * {@inheritDoc}
	 */
	public Message next() {
		String nextString = myWrapped.next();
		Message retVal;
		try {
			retVal = myParser.parse(nextString);
		} catch (EncodingNotSupportedException e) {
			throw new Hl7InputStreamMessageStringIterator.ParseFailureError("Failed to parse message", e);
		} catch (HL7Exception e) {
			throw new Hl7InputStreamMessageStringIterator.ParseFailureError("Failed to parse message", e);
		}
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

}
