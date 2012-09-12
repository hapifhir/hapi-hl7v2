package ca.uhn.hl7v2.hoh.raw.api;

import java.io.IOException;
import java.io.Writer;

import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.encoder.ResponseCode;

public class RawSendable implements IResponseSendable<String> {

	private final String myRawMessage;
	private final EncodingStyle myEncodingStyle;
	private ResponseCode myResponseCode;

	/**
	 * Constructor
	 * 
	 * @param theRawMessage
	 *            The message to return
	 */
	public RawSendable(String theRawMessage) {
		if (theRawMessage == null) {
			throw new NullPointerException("Raw Message may not be null");
		}
		myRawMessage = theRawMessage;
		myEncodingStyle = EncodingStyle.detect(myRawMessage);
	}

	public void writeMessage(Writer theWriter) throws IOException {
		theWriter.write(myRawMessage);
		theWriter.flush();
	}

	public EncodingStyle getEncodingStyle() {
		return myEncodingStyle;
	}

	public ResponseCode getResponseCode() {
		if (myResponseCode == null) {
			myResponseCode = ResponseCode.detect(myRawMessage);
		}
		return myResponseCode;
	}

	public String getMessage() {
		return myRawMessage;
	}

}
