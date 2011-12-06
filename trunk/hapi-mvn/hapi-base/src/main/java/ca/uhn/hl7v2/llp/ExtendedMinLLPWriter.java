package ca.uhn.hl7v2.llp;

import static ca.uhn.hl7v2.llp.MinLLPReader.END_MESSAGE;
import static ca.uhn.hl7v2.llp.MinLLPReader.LAST_CHARACTER;
import static ca.uhn.hl7v2.llp.MinLLPReader.START_MESSAGE;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.preparser.PreParser;

/**
 * MLLP writer which uses the charset from the message being transmitted
 */
public class ExtendedMinLLPWriter implements HL7Writer {

	private static final Logger ourLog = LoggerFactory.getLogger(ExtendedMinLLPWriter.class);
	private OutputStream myOutputStream;

	public ExtendedMinLLPWriter(OutputStream theOut) {
		myOutputStream = theOut;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void writeMessage(String theMessage) throws LLPException, IOException {
		Charset javaCs;
		String[] fields;
		try {
			fields = PreParser.getFields(theMessage, "MSH-18(0)");
			String charset = fields[0];
			try {
				javaCs = CharSetUtil.convertHL7CharacterEncodingToCharSetvalue(charset);
			} catch (EncodingNotSupportedException e) {
				ourLog.warn("Nonvalid charset \"" + charset + "\"- defaulting to US-ASCII", e);
				javaCs = Charset.forName("US-ASCII");
			}
		} catch (HL7Exception e1) {
			ourLog.warn("Could not detect charset - defaulting to US-ASCII", e1);
			javaCs = Charset.forName("US-ASCII");
		}

		OutputStreamWriter writer = new OutputStreamWriter(myOutputStream, javaCs);
		
//		writer.write(START_MESSAGE);
//		writer.append(theMessage);
//		writer.write(END_MESSAGE);
//		writer.write(LAST_CHARACTER);
//		writer.flush();

		myOutputStream.write(START_MESSAGE);
		myOutputStream.flush();
		
		writer.append(theMessage);
		writer.flush();
		
		myOutputStream.write(END_MESSAGE);
		myOutputStream.write(LAST_CHARACTER);
		myOutputStream.flush();
		
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void setOutputStream(OutputStream theOut) throws IOException {
		myOutputStream = theOut;
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void close() throws IOException {
		myOutputStream.close();
	}

}
