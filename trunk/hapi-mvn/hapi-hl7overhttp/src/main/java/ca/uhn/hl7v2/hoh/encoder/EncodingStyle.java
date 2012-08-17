package ca.uhn.hl7v2.hoh.encoder;

import java.util.HashMap;
import java.util.Map;

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
	private static final Map<String, EncodingStyle> ourContentTypes = new HashMap<String, EncodingStyle>();

	static {
		for (EncodingStyle next : values()) {
			ourContentTypes.put(next.getContentType(), next);
		}
	}
	
	EncodingStyle(String theContentType){
		myContentType = theContentType;
	}
	
	/**
	 * @throws NullPointerException if the name is null
	 */
	public static EncodingStyle withNameCaseInsensitive(String theName) {
		return ourContentTypes.get(theName.toLowerCase());
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
