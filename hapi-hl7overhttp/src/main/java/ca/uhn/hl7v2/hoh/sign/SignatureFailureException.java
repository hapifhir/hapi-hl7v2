package ca.uhn.hl7v2.hoh.sign;


public class SignatureFailureException extends Exception {

	private static final long serialVersionUID = 1L;

	public SignatureFailureException(Exception theE) {
		super(theE);
	}

	public SignatureFailureException(String theMessage) {
		super(theMessage);
	}

	public SignatureFailureException(String theMessage, Exception theCause) {
		super(theMessage, theCause);
	}

}
