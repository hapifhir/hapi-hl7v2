package ca.uhn.hl7v2.hoh;

import static org.apache.commons.lang.StringUtils.*;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.uhn.hl7v2.hoh.sign.ISigner;
import ca.uhn.hl7v2.hoh.sign.StandardMessageSigner;

abstract class AbstractHl7OverHttp {

	protected static final Charset ourDefaultCharset;

	private Charset myCharset;

	private byte[] myData;
	private LinkedHashMap<String, String> myHeaders = new LinkedHashMap<String, String>();
	private String myMessage;
	private MessageMode myMode;
	private String myPassword;
	private ISigner mySigner;
	private boolean myUsed;
	private String myUsername;

	static {
		ourDefaultCharset = Charset.forName("ISO-8859-1");
	}


	/**
	 * Constructor
	 */
	public AbstractHl7OverHttp() {
		myCharset = ourDefaultCharset;
	}


	/**
	 * @return the charset
	 */
	public Charset getCharset() {
		return myCharset;
	}


	/**
	 * @return the data
	 */
	public byte[] getData() {
		return myData;
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
	 * @return the mode
	 */
	public MessageMode getMode() {
		return myMode;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return myPassword;
	}


	/**
	 * @return the signer
	 */
	public ISigner getSigner() {
		return mySigner;
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return myUsername;
	}


	protected boolean isXml() {
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


	/**
	 * @param theCharset
	 *            The encoding charset to use (default is UTF-8)
	 */
	public void setCharset(Charset theCharset) {
		myCharset = theCharset;
	}


	/**
	 * @param theData
	 *            the data to set
	 */
	public void setData(byte[] theData) {
		myData = theData;
	}


	/**
	 * @param theHeaders
	 *            the headers to set
	 */
	public void setHeaders(LinkedHashMap<String, String> theHeaders) {
		myHeaders = theHeaders;
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


	protected void verifyNotUsed() {
		if (myUsed) {
			throw new IllegalStateException(getClass().getSimpleName() + " may not be reused");
		}
		myUsed = true;
	}

}
