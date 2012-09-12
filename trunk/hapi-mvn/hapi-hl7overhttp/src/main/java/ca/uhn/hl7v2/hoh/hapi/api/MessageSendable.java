package ca.uhn.hl7v2.hoh.hapi.api;

import java.io.IOException;
import java.io.Writer;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.encoder.ResponseCode;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.Terser;

public class MessageSendable implements IResponseSendable<Message> {
	
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(MessageSendable.class);

	private final Message myMessage;
	private final EncodingStyle myEncodingStyle;
	private ResponseCode myResponseCode;

	private String myRawMessage;

	/**
	 * Constructor
	 * 
	 * @param theMessage
	 *            The message to return
	 * @throws HL7Exception
	 *             If message could not be encoded
	 */
	public MessageSendable(Message theMessage) throws HL7Exception {
		this(theMessage, theMessage.getParser());
	}

	/**
	 * Constructor
	 * 
	 * @param theMessage
	 *            The message to return
	 * @param theParser
	 *            The parser to use to encode the message
	 * @throws HL7Exception
	 *             If message could not be encoded
	 */
	public MessageSendable(Message theMessage, Parser theParser) throws HL7Exception {
		if (theMessage == null) {
			throw new NullPointerException("Raw Message may not be null");
		}
		myMessage = theMessage;
		myEncodingStyle = detectEncodingStyle(theParser);
		myRawMessage = theParser.encode(myMessage);
	}

	private EncodingStyle detectEncodingStyle(Parser theParser) {
		if (theParser instanceof XMLParser) {
			return EncodingStyle.XML;
		} else if (theParser instanceof GenericParser && ((GenericParser) theParser).isPipeParserPrimary() == false) {
			return EncodingStyle.XML;
		} else {
			return EncodingStyle.ER7;
		}
	}

	public void writeMessage(Writer theWriter) throws IOException {
		theWriter.append(myRawMessage);
		theWriter.flush();
	}

	public EncodingStyle getEncodingStyle() {
		return myEncodingStyle;
	}

	public ResponseCode getResponseCode() {
		if (myResponseCode == null) {
			try {
				myResponseCode = ResponseCode.detect(new Terser(myMessage).get("/MSA-2"));
				if (myResponseCode == null) {
					throw new HL7Exception("No response code in message, this is probably an error");
				}
			} catch (HL7Exception e) {
				ourLog.info("Could not detect response code in message", e);
				myResponseCode = ResponseCode.HTTP_500_INTERNAL_SERVER_ERROR;
			}
		}
		return myResponseCode;
	}

	public Message getMessage() {
		return myMessage;
	}

}
