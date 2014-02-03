package ca.uhn.hl7v2.hoh.encoder;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.uhn.hl7v2.hoh.sign.ISigner;
import ca.uhn.hl7v2.hoh.util.StringUtils;
import ca.uhn.hl7v2.hoh.util.VersionLogger;

abstract class AbstractHl7OverHttp {
	public static final String HTTP_HEADER_HL7_SIGNATURE = "HL7-Signature";
	public static final String HTTP_HEADER_HL7_SIGNATURE_LC = HTTP_HEADER_HL7_SIGNATURE.toLowerCase();

	protected static final Charset ourDefaultCharset;

	static {
		ourDefaultCharset = Charset.forName("UTF-8");
		VersionLogger.init();
	}
	
	private Charset myCharset;
	private boolean myCharsetExplicitlySet;
	private byte[] myData;
	private LinkedHashMap<String, String> myHeaders;
	private String myMessage;
	private String myPassword;
	private ISigner mySigner;
	private String myPath;
	private boolean myUsed;
	private String myUsername;

	/**
	 * Constructor
	 */
	public AbstractHl7OverHttp() {
		myCharset = ourDefaultCharset;
	}

	/**
	 * Returns the charset associated with this message. Will not return <code>null</code>.
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
	 * @return the path
	 */
	public String getPath() {
		// TODO: un-url encode this
		return myPath;
	}

	/**
	 * @return the path
	 */
	public String getPathRaw() {
		return myPath;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return myUsername;
	}

	/**
	 * @return Returns <code>true</code> if the charset was explicitly set using
	 *         {@link #setCharset(Charset)}
	 */
	public boolean isCharsetExplicitlySet() {
		return myCharsetExplicitlySet;
	}

	/**
	 * @param theCharset
	 *            The encoding charset to use (default is UTF-8)
	 * @deprecated The HL7 over HTTP specification now mandates the use of UTF-8. <b>Using this method to set a value other than UTF-8 will lead to a non-conformant application</b> 
	 */
	@Deprecated
	public void setCharset(Charset theCharset) {
		if (theCharset == null) {
			throw new NullPointerException("Charset can not be null");
		}
		myCharsetExplicitlySet = true;
		myCharset = theCharset;
	}

	/**
	 * @param theData
	 *            the data to set
	 */
	protected void setData(byte[] theData) {
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
	 * @param thePath
	 *            the path to set
	 */
	public void setPath(String thePath) {
		myPath = thePath;
	}

	/**
	 * @param theUsername
	 *            The authorization username
	 */
	public void setUsername(String theUsername) {
		if (StringUtils.isNotBlank(theUsername)) {
			if (theUsername.contains(":")) {
				throw new IllegalArgumentException("Username contains illegal characters");
			}
		}
		myUsername = theUsername;
	}

	/**
	 * Throws an {@link IllegalStateException} if called more than once 
	 */
	protected void verifyNotUsed() {
		if (myUsed) {
			throw new IllegalStateException(getClass().getSimpleName() + " may not be reused");
		}
		myUsed = true;
	}

	/**
	 * @return Returns the ISO-8859-1 charset
	 */
	public static Charset getDefaultCharset() {
		return ourDefaultCharset;
	}

}
