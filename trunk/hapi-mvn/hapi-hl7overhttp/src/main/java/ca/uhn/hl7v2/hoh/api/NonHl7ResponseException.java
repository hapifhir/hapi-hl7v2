package ca.uhn.hl7v2.hoh.api;

public class NonHl7ResponseException extends DecodeException {

	private String myContentType;
	private String myResponseBody;

	public NonHl7ResponseException(String theMessage, String theContentType, String theResponseBody) {
		super(theMessage);
		myContentType = theContentType;
		myResponseBody = theResponseBody;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return myContentType;
	}

	/**
	 * @return the responseBody
	 */
	public String getResponseBody() {
		return myResponseBody;
	}

	private static final long serialVersionUID = 1L;

}
