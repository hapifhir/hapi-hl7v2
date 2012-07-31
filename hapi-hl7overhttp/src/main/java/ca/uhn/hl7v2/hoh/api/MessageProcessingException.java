package ca.uhn.hl7v2.hoh.api;


public class MessageProcessingException extends Exception {

	private static final long serialVersionUID = 1L;

	public MessageProcessingException(String theMessage) {
		super(theMessage);
	}
	
	public MessageProcessingException(String theMessage, Throwable theCause) {
		super(theMessage, theCause);
	}

	public MessageProcessingException(Throwable theCause) {
		super(theCause);
	}

	
}
