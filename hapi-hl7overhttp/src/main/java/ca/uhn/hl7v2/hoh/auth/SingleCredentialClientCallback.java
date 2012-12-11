package ca.uhn.hl7v2.hoh.auth;

import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;

/**
 * Authorization Callback which validates a single username and password
 */
public class SingleCredentialClientCallback implements IAuthorizationClientCallback {

	private String myPassword;
	private String myUsername;

	public SingleCredentialClientCallback() {
	}

	public SingleCredentialClientCallback(String theUsername, String thePassword) {
		myUsername = theUsername;
		myPassword = thePassword;
	}

	public String providePassword(String theUri) {
		return myPassword;
	}

	public String provideUsername(String theUri) {
		return myUsername;
	}

	/**
	 * @param thePassword
	 *            the password to set
	 */
	public void setPassword(String thePassword) {
		myPassword = thePassword;
	}

	/**
	 * @param theUsername
	 *            the username to set
	 */
	public void setUsername(String theUsername) {
		myUsername = theUsername;
	}

}
