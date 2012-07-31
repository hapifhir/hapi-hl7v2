package ca.uhn.hl7v2.hoh.api;

import java.util.Map;

public interface IReceivable<T> {

	/**
	 * Returns the message itself
	 */
	T getRawMessage();
	
	/**
	 * Returns a map containing other metadata about the message.
	 */
	Map<String, Object> getMetadata();
	
}
