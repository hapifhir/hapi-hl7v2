package ca.uhn.hl7v2.hoh;

import static org.apache.commons.lang.StringUtils.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

/**
 * Base class that creates HL7 over HTTP requests. This class is intended to be
 * single use, so please create a new instance for each message.
 */
public class Hl7OverHttpEncoder {
	private static final Charset ourDefaultCharset;
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7OverHttpEncoder.class);

	static {
		ourDefaultCharset = Charset.forName("ISO-8859-1");
	}

	private Charset myCharset = ourDefaultCharset;
	private byte[] myData;
	private LinkedHashMap<String, String> myHeaders = new LinkedHashMap<String, String>();
	private String myMessage;
	private MessageMode myMode;
	private String myPassword;
	private ISigner mySigner;
	private String myUsername;
	private boolean myUsed;

	/**
	 * Constructor
	 */
	public Hl7OverHttpEncoder() {
		myCharset = ourDefaultCharset;
	}

	public void decode() {
		verifyNotUsed();
		
		
	}
	
	public void encode() {
		verifyNotUsed();
		
		if (isBlank(myMessage)) {
			throw new IllegalStateException("Message must be set");
		}
		if (myMode == null) {
			throw new IllegalStateException("Mode must be set");
		}
		
		StringBuilder ctBuilder = new StringBuilder();
		if (isXml()) {
			ctBuilder.append("application/hl7-v2+xml");
		} else {
			ctBuilder.append("application/hl7-v2");
		}
		ctBuilder.append("; charset=");
		ctBuilder.append(myCharset.name());
		myHeaders.put("Content-Type", ctBuilder.toString());

		myHeaders.put("Content-Length", Integer.toString(myMessage.length()));

		if (myMode == MessageMode.REQUEST && isNotBlank(myUsername) && isNotBlank(myPassword)) {
			String authorizationUnescaped = defaultString(myUsername) + ":" + defaultString(myPassword);
			String encoded;
			try {
				encoded = Base64.encodeBase64String(authorizationUnescaped.getBytes("US-ASCII"));
			} catch (UnsupportedEncodingException e) {
				throw new Error("Could not find US-ASCII encoding. This shouldn't happen!");
			}
			myHeaders.put("Authorization", "Basic " + encoded);
		}

		myData = myMessage.getBytes(myCharset);

		if (mySigner != null) {
			myHeaders.put("HL7-Signature", mySigner.sign(myData));
		}
	}

	private boolean isXml() {
		for (int i = 0; i < myMessage.length(); i++) {
			char nextChar = myMessage.charAt(i);
			if (Character.isLetter(nextChar)) {
				return false;
			}
			if (Character.isWhitespace(nextChar)) {
				continue;
			}
			if (nextChar == '<') {
				return true;
			}
		}
		return false;
	}

	private void verifyNotUsed() {
		if (myUsed) {
			throw new IllegalStateException(getClass().getSimpleName() + " may not be reused");
		}
		myUsed = true;
	}

	/**
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return myHeaders;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return myMessage;
	}

	/**
	 * @param theCharset
	 *            The encoding charset to use (default is UTF-8)
	 */
	public void setCharset(Charset theCharset) {
		myCharset = theCharset;
	}

	/**
	 * @param theMessage
	 *            The raw message text
	 */
	public void setMessage(String theMessage) {
		myMessage = theMessage;
	}

	/**
	 * @param theMode
	 *            Is this encoder being used to encode a request or a response
	 *            to a request
	 */
	public void setMode(MessageMode theMode) {
		myMode = theMode;
	}

	/**
	 * @param thePassword
	 *            The authorization password
	 */
	public void setPassword(String thePassword) {
		myPassword = thePassword;
	}

	/**
	 * Optionally may be used to provide a signer implementation which signs HL7
	 * content.
	 * 
	 * @see ISigner
	 * @see StandardMessageSigner
	 */
	public void setSigner(ISigner theSigner) {
		mySigner = theSigner;
	}

	/**
	 * @param theUsername
	 *            The authorization username
	 */
	public void setUsername(String theUsername) {
		if (isNotBlank(theUsername)) {
			if (theUsername.contains(":")) {
				throw new IllegalArgumentException("Username contains illegal characters");
			}
		}
		myUsername = theUsername;
	}

}
