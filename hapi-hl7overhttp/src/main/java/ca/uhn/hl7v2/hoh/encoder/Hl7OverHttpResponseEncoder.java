package ca.uhn.hl7v2.hoh.encoder;

import ca.uhn.hl7v2.hoh.util.VersionLogger;

public class Hl7OverHttpResponseEncoder extends AbstractHl7OverHttpEncoder {

	private boolean myAddConnectionCloseHeader;

	@Override
	protected void addSpecificHeaders() {
		getHeaders().put("Server", "HAPI (HL7 over HTTP) Server " + VersionLogger.getVersion());
		if (isGzipData()) {
			getHeaders().put("Content-Encoding", "gzip");
		}
		if (myAddConnectionCloseHeader) {
			getHeaders().put("Connection", "close");
		}
	}

	@Override
	protected void setActionLineAppropriately() {
		ResponseCode resp = ResponseCode.detect(getMessage());
		setActionLine("HTTP/1.1 " + resp.getCode() + " " + resp.getMessage());
	}

	/**
	 * Adds a header to the HTTP response: "<code>Connection: close</code>". Note that setting this to true (default is false) will ONLY add the header, it does not actually close the connection. The
	 * caller is responsible for that.
	 */
	public void setAddConnectionCloseHeader(boolean theAddConnectionCloseHeader) {
		myAddConnectionCloseHeader = theAddConnectionCloseHeader;
	}

	/**
	 * Should response be GZipped?
	 */
	@Override
	public void setGzipData(boolean theGzipData) {
		super.setGzipData(theGzipData);
	}

}
