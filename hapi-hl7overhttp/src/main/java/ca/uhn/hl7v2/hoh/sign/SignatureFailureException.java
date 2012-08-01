package ca.uhn.hl7v2.hoh.sign;

public class SignatureFailureException extends Exception {

	public SignatureFailureException(Exception theE) {
		super(theE);
	}

}
