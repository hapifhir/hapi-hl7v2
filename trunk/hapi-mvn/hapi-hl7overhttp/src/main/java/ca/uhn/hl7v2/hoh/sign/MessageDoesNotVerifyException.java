package ca.uhn.hl7v2.hoh.sign;


public class MessageDoesNotVerifyException extends Exception {

	private static final long serialVersionUID = 1L;

	public MessageDoesNotVerifyException() {
	}

	public MessageDoesNotVerifyException(Exception theE) {
		super(theE);
	}

}
