package ca.uhn.hl7v2.hoh.encoder;

import ca.uhn.hl7v2.hoh.api.DecodeException;

public class AuthorizationFailureException extends DecodeException {
	private static final long serialVersionUID = 1L;

	public AuthorizationFailureException(String theMessage) {
		super(theMessage);
	}

	public AuthorizationFailureException(String theMessage, Throwable theCause) {
		super(theMessage, theCause);
	}

}
