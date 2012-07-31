package ca.uhn.hl7v2.hoh.auth;

import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;


/**
 * Authorization Callback which validates a single username and password
 */
public class SingleCredentialClientCallback implements IAuthorizationClientCallback {

	private String myUsername;
	private String myPassword;

	public SingleCredentialClientCallback(String theUsername, String thePassword) {
		myUsername = theUsername;
		myPassword = thePassword;
	}

	public String provideUsername(String theUri) {
		return myUsername;
	}

	public String providePassword(String theUri) {
		return myPassword;
	}
	
}
