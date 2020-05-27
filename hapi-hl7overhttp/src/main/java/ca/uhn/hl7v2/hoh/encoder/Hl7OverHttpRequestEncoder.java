package ca.uhn.hl7v2.hoh.encoder;

import static ca.uhn.hl7v2.hoh.util.StringUtils.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import ca.uhn.hl7v2.hoh.util.VersionLogger;
import ca.uhn.hl7v2.hoh.util.repackage.Base64;

public class Hl7OverHttpRequestEncoder extends AbstractHl7OverHttpEncoder {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7OverHttpRequestEncoder.class);
	private String myHost;
	private int myPort;

	public void setHost(String theHost) {
		myHost = theHost;
	}

	public void setPort(int thePort) {
		myPort = thePort;
	}
	private final boolean myAcceptGzip = false;

	@Override
	protected void addSpecificHeaders() {
		if (isNotBlank(getUsername()) && isNotBlank(getPassword())) {
			String authorizationUnescaped = defaultString(getUsername()) + ":" + defaultString(getPassword());
			String encoded;
            encoded = Base64.encodeBase64String(authorizationUnescaped.getBytes(StandardCharsets.ISO_8859_1));
            getHeaders().put("Authorization", "Basic " + encoded);
		}

		if (myAcceptGzip) {
			getHeaders().put("Accept-Encoding", "gzip");
		}
		getHeaders().put("User-Agent", "HAPI (HL7 over HTTP) Client " + VersionLogger.getVersion());

		StringBuilder hostBuilder = new StringBuilder();
		if (isNotBlank(myHost)) {
			hostBuilder.append(myHost);
			if (myPort > 0) {
				hostBuilder.append(":");
				hostBuilder.append(myPort);
			} else {
				ourLog.warn("Host has been set, but port has not");
			}
		} else {
			ourLog.warn("Host has not been set");
		}
		getHeaders().put("Host", hostBuilder.toString());
	}

	@Override
	protected void setActionLineAppropriately() {
		setActionLine("POST " + getPath() + " HTTP/1.1");
	}

}
