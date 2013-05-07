package ca.uhn.hl7v2.hoh.encoder;

import ca.uhn.hl7v2.hoh.util.VersionLogger;

public class Hl7OverHttpResponseEncoder extends AbstractHl7OverHttpEncoder {

	/**
	 * Should response be GZipped?
	 */
	@Override
	public void setGzipData(boolean theGzipData) {
		super.setGzipData(theGzipData);
	}

	@Override
	protected void addSpecificHeaders() {
		getHeaders().put("Server", "HAPI (HL7 over HTTP) Server " + VersionLogger.getVersion());
		if (isGzipData()) {
			getHeaders().put("Content-Encoding", "gzip");
		}
	}

	@Override
	protected void setActionLineAppropriately() {
		ResponseCode resp = ResponseCode.detect(getMessage());
		setActionLine("HTTP/1.1 " + resp.getCode() + " " + resp.getMessage());
	}

}
