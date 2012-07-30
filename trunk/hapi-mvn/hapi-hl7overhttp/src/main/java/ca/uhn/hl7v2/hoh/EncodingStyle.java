package ca.uhn.hl7v2.hoh;

public enum EncodingStyle {

	/**
	 * ER7 (Pipe and Hat, or Vertical Bar encoding)
	 */
	ER7("application/hl7-v2"),
	
	/**
	 * XML encoding
	 */
	XML("application/hl7-v2+xml")
	;
	
	private String myContentType;

	EncodingStyle(String theContentType){
		myContentType = theContentType;
	}
	
	/**
	 * Detect the encoding style of a given message
	 * 
	 * @throws NullPointerException If theMessage is null
	 * @throws IllegalArgumentException If the message is not ER7 or XML
	 */
	public static EncodingStyle detect(String theMessage) {
		if (theMessage == null) {
			throw new NullPointerException("Message can not be null");
		}
		
		for (int i = 0; i < theMessage.length(); i++) {
			char nextChar = theMessage.charAt(i);
			if (Character.isLetter(nextChar)) {
				return ER7;
			}
			if (Character.isWhitespace(nextChar)) {
				continue;
			}
			if (nextChar == '<') {
				return XML;
			}
		}
		
		throw new IllegalArgumentException("Message does not appear to be ER7 or XML");

	}

	/**
	 * Returns the MIME type (content-type) associated with this encoding
	 */
	public String getContentType() {
		return myContentType;
	}
	
}
