package ca.uhn.hl7v2.hoh.api;

/**
 * Provides a callback for authorizing credentials found within HTTP requests
 */
public interface IAuthorizationServerCallback {

	/**
	 * Returns true if the username and password are accepted as valid for a given URI
	 */
	boolean authorize(String theUriPath, String theUsername, String thePassword);
	
}
