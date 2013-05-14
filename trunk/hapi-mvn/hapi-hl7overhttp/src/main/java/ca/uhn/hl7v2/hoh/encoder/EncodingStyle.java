package ca.uhn.hl7v2.hoh.encoder;

import java.util.HashMap;
import java.util.Map;

public enum EncodingStyle {

	/**
	 * <p>
	 * ER7 (Pipe and Hat, or Vertical Bar encoding)
	 * </p>
	 * <p>
	 * Content type: <code>application/hl7-v2</code>
	 * </p>
	 */
	ER7("application/hl7-v2"),

	/**
	 * <p>
	 * XML encoding
	 * </p>
	 * <p>
	 * Content type: <code>application/hl7-v2+xml</code>
	 * </p>
	 */
	XML("application/hl7-v2+xml");

	private static final Map<String, EncodingStyle> ourContentTypeToEncodingStyles = new HashMap<String, EncodingStyle>();

	static {
		for (EncodingStyle next : values()) {
			ourContentTypeToEncodingStyles.put(next.myContentType, next);
		}
	}

	private String myContentType;

	EncodingStyle(String theContentType) {
		myContentType = theContentType;
	}

	/**
	 * Returns the encoding style (e.g. ER7) for a given content type (e.g.
	 * application/hl7-v2), or <code>null</code> if content type does not match
	 * an HL7 definition.
	 * 
	 * @param theContentType
	 *            The content type (case insensitive)
	 * @return Returns null if no matching
	 * @throws NullPointerException
	 *             If theContentType is null
	 */
	public static EncodingStyle getEncodingStyleForContentType(String theContentType) {
		return ourContentTypeToEncodingStyles.get(theContentType.toLowerCase());
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
