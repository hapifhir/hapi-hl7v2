package ca.uhn.hl7v2.hoh.auth;

import org.apache.commons.lang.StringUtils;

/**
 * Authorization Callback which validates a single username and password
 */
public class SingleCredentialServerCallback implements IAuthorizationServerCallback {

	private String myUsername;
	private String myPassword;

	public SingleCredentialServerCallback(String theUsername, String thePassword) {
		myUsername = theUsername;
		myPassword = thePassword;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean authorize(String theUri, String theUsername, String thePassword) {
		return StringUtils.equals(myUsername, theUsername) && StringUtils.equals(myPassword, thePassword);
	}

}
