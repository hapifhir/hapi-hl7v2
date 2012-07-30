package ca.uhn.hl7v2.hoh;


public class DecodeException extends Exception {

	private static final long serialVersionUID = 1L;

	public DecodeException(String theMessage) {
		super(theMessage);
	}

	public DecodeException(String theMessage, Throwable theCause) {
		super(theMessage, theCause);
	}

}
