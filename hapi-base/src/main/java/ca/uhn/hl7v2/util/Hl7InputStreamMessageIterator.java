package ca.uhn.hl7v2.util;

import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.HapiContextSupport;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator.ParseFailureError;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

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
public class Hl7InputStreamMessageIterator extends HapiContextSupport implements Iterator<Message> {

	private Class<? extends Message> myMessageType;
	private Hl7InputStreamMessageStringIterator myWrapped;

	/**
	 * Constructor
	 * 
	 * @param theInputStream
	 *            The input stream to read from
	 */
	public Hl7InputStreamMessageIterator(InputStream theInputStream) {
        this(theInputStream, new DefaultHapiContext(ValidationContextFactory.noValidation()));
	}

	/**
	 * Constructor
	 * 
	 * @param theReader
	 *            The reader to read from
	 */
	public Hl7InputStreamMessageIterator(Reader theReader) {
		this(theReader, new DefaultHapiContext(ValidationContextFactory.noValidation()));
	}

	/**
	 * Constructor
	 * 
	 * @param theInputStream
	 *            The input stream to read from
	 * @param theHapiContext
	 * 			 The HapiContext from which to obtain the parser
	 */
	public Hl7InputStreamMessageIterator(InputStream theInputStream, HapiContext theHapiContext) {
	    super(theHapiContext);
		myWrapped = new Hl7InputStreamMessageStringIterator(theInputStream);
	}

	/**
	 * Constructor
	 * 
	 * @param theReader
	 *            The reader to read from
	 * @param theHapiContext
	 * 			 The HapiContext from which to obtain the parser
	 */
	public Hl7InputStreamMessageIterator(Reader theReader, HapiContext theHapiContext) {
        super(theHapiContext);
		myWrapped = new Hl7InputStreamMessageStringIterator(theReader);
	}

	/**
	 * Factory method which returns an instance which reads from a file on the
	 * classpath
	 */
	public static Hl7InputStreamMessageIterator getForClasspathResource(String theClasspath) {
		InputStream is = Hl7InputStreamMessageIterator.class.getResourceAsStream(theClasspath);
		if (is == null) {
			throw new IllegalArgumentException("Can't find resource: " + theClasspath);
		}
		return new Hl7InputStreamMessageIterator(is);
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
			if (myMessageType != null) {
				retVal = ReflectionUtil.instantiateMessage(myMessageType, getHapiContext().getModelClassFactory());
				retVal.parse(nextString);
			} else {
				retVal = getHapiContext().getPipeParser().parse(nextString);
			}
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

	/**
	 * If set to true, any lines beginning with a hash (#) will be ignored. This allows
	 * you to place comments in a file to be read if needed.
	 */
	public void setIgnoreComments(boolean theIgnoreComments) {
		myWrapped.setIgnoreComments(theIgnoreComments);
	}

	/**
	 * If set (default is <code>null</code>), all messages will be parsed into
	 * instances of this type. 
	 */
	public void setMessageType(Class<? extends Message> theMessageType) {
		myMessageType = theMessageType;
	}

}
