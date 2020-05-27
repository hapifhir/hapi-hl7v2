package ca.uhn.hl7v2.hoh.sign;


public interface ISigner {

	String sign(byte[] theBytes) throws SignatureFailureException;
	
	void verify(byte[] theBytes, String theSignature) throws SignatureVerificationException, SignatureFailureException;
	
	
}
