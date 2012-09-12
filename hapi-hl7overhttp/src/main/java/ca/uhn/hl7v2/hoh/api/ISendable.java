package ca.uhn.hl7v2.hoh.api;

import java.io.IOException;
import java.io.Writer;

import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;

public interface ISendable<T> {

	void writeMessage(Writer theWriter) throws IOException;
	
	EncodingStyle getEncodingStyle();

	T getMessage();
	
}
