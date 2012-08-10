package ca.uhn.hl7v2.hoh.raw.api;

import ca.uhn.hl7v2.hoh.api.AbstractReceivable;
import ca.uhn.hl7v2.hoh.api.IReceivable;

public class RawReceivable extends AbstractReceivable<String> implements IReceivable<String> {

	private final String myRawMessage;

	public RawReceivable(String theRawMessage) {
		myRawMessage = theRawMessage;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMessage() {
		return myRawMessage;
	}

}
