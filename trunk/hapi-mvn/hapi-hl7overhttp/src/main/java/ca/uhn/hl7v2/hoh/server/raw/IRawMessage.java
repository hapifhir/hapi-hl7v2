package ca.uhn.hl7v2.hoh.server.raw;

import java.util.Map;

public interface IRawMessage {

	/**
	 * Returns the message itself
	 */
	String getRawMessage();
	
	/**
	 * Returns a map containing other metadata about the message.
	 */
	Map<String, Object> getMetadata();
	
}
