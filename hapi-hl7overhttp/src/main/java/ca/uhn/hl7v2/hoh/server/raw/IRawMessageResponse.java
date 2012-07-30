package ca.uhn.hl7v2.hoh.server.raw;

import java.io.IOException;
import java.io.Writer;

import ca.uhn.hl7v2.hoh.EncodingStyle;
import ca.uhn.hl7v2.hoh.ResponseCode;

/**
 * <p>
 * Response message to be returned by a server application.
 * </p>
 */
public interface IRawMessageResponse {

	void writeMessage(Writer theWriter) throws IOException;
	
	EncodingStyle getEncodingStyle();

	ResponseCode getResponseCode();
	
}
