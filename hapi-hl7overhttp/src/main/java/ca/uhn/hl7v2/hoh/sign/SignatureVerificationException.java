package ca.uhn.hl7v2.hoh.sign;


public class SignatureVerificationException extends Exception {

	private static final long serialVersionUID = 1L;

	public SignatureVerificationException() {
	}

	public SignatureVerificationException(Exception theE) {
		super(theE);
	}

	public SignatureVerificationException(String theMessage) {
		super(theMessage);
	}

}
