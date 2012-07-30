package ca.uhn.hl7v2.hoh;

public class Hl7OverHttpResponseEncoder extends AbstractHl7OverHttpEncoder {

	@Override
	protected void setActionLineAppropriately() {
		ResponseCode resp = ResponseCode.detect(getMessage());
		setActionLine("HTTP/1.1 " + resp.getCode() + " " + resp.getMessage());
	}

	@Override
	protected void addSpecificHeaders() {
		getHeaders().put("Server", "HAPI (HL7 over HTTP) Server " + VersionLogger.getVersion());
	}


}
