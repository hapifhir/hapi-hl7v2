package ca.uhn.hl7v2.hoh;

import static org.apache.commons.lang.StringUtils.*;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Hl7OverHttpRequestEncoder extends AbstractHl7OverHttpEncoder {

	@Override
	protected void setActionLineAppropriately() {
		setActionLine("POST " + getUri() + " HTTP/1.1");
	}

	@Override
	protected void addSpecificHeaders() {
		if (isNotBlank(getUsername()) && isNotBlank(getPassword())) {
			String authorizationUnescaped = defaultString(getUsername()) + ":" + defaultString(getPassword());
			String encoded;
			try {
				encoded = Base64.encodeBase64String(authorizationUnescaped.getBytes("ISO-8859-1"));
			} catch (UnsupportedEncodingException e) {
				throw new Error("Could not find US-ASCII encoding. This shouldn't happen!");
			}
			getHeaders().put("Authorization", "Basic " + encoded);
		}
		
		getHeaders().put("Accept-Encoding", "gzip");
		getHeaders().put("User-Agent", "HAPI (HL7 over HTTP) Client " + VersionLogger.getVersion());
		getHeaders().put("Host", "");
	}


}
