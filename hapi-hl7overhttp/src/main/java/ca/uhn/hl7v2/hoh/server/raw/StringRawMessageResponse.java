package ca.uhn.hl7v2.hoh.server.raw;

import java.io.IOException;
import java.io.Writer;

import ca.uhn.hl7v2.hoh.EncodingStyle;
import ca.uhn.hl7v2.hoh.ResponseCode;

public class StringRawMessageResponse implements IRawMessageResponse {

	private final String myRawMessage;
	private final EncodingStyle myEncodingStyle;
	private final ResponseCode myResponseCode;

	/**
	 * Constructor
	 * 
	 * @param theRawMessage The message to return
	 */
	public StringRawMessageResponse(String theRawMessage) {
		if (theRawMessage == null) {
			throw new NullPointerException("Raw Message may not be null");
		}
		myRawMessage = theRawMessage;
		myEncodingStyle = EncodingStyle.detect(myRawMessage);
		myResponseCode = ResponseCode.detect(myRawMessage);
	}

	public void writeMessage(Writer theWriter) throws IOException {
		theWriter.write(myRawMessage);
	}

	public EncodingStyle getEncodingStyle() {
		return myEncodingStyle;
	}
	
	public ResponseCode getResponseCode() {
		return myResponseCode;
	}

	
}
