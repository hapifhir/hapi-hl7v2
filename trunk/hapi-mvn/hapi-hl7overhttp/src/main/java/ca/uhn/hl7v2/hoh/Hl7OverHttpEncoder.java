package ca.uhn.hl7v2.hoh;

import static org.apache.commons.lang.StringUtils.*;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;


/**
 * Base class that creates HL7 over HTTP requests. This class is intended to be
 * single use, so please create a new instance for each message.
 */
public class Hl7OverHttpEncoder extends AbstractHl7OverHttp {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7OverHttpEncoder.class);

	/**
	 * Constructor
	 */
	public Hl7OverHttpEncoder() {
		super();
	}

	
	/**
	 * 
	 */
	public void encode() {
		verifyNotUsed();
		
		if (isBlank(getMessage())) {
			throw new IllegalStateException("Message must be set");
		}
		if (getMode() == null) {
			throw new IllegalStateException("Mode must be set");
		}
		
		StringBuilder ctBuilder = new StringBuilder();
		if (isXml()) {
			ctBuilder.append("application/hl7-v2+xml");
		} else {
			ctBuilder.append("application/hl7-v2");
		}
		ctBuilder.append("; charset=");
		ctBuilder.append(getCharset().name());
		getHeaders().put("Content-Type", ctBuilder.toString());

		getHeaders().put("Content-Length", Integer.toString(getMessage().length()));

		if (getMode() == MessageMode.REQUEST && isNotBlank(getUsername()) && isNotBlank(getPassword())) {
			String authorizationUnescaped = defaultString(getUsername()) + ":" + defaultString(getPassword());
			String encoded;
			try {
				encoded = Base64.encodeBase64String(authorizationUnescaped.getBytes("US-ASCII"));
			} catch (UnsupportedEncodingException e) {
				throw new Error("Could not find US-ASCII encoding. This shouldn't happen!");
			}
			getHeaders().put("Authorization", "Basic " + encoded);
		}

		setData(getMessage().getBytes(getCharset()));

		if (getSigner() != null) {
			getHeaders().put("HL7-Signature", getSigner().sign(getData()));
		}
	}

}
