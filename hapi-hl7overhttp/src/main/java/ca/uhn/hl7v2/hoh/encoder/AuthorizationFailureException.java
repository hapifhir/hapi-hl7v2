package ca.uhn.hl7v2.hoh.encoder;

public class AuthorizationFailureException extends DecodeException {
	private static final long serialVersionUID = 1L;

	public AuthorizationFailureException(String theMessage) {
		super(theMessage);
	}

	public AuthorizationFailureException(String theMessage, Throwable theCause) {
		super(theMessage, theCause);
	}

}
