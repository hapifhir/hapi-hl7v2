package ca.uhn.hl7v2.hoh.auth;

/**
 * Provides callback methods for providing credentials
 */
public interface IAuthorizationClientCallback {

	/**
 	 * Provides a username
	 * 
	 * @param theUri
	 * @return
	 */
	String provideUsername(String theUri);
	
	/**
	 * Provides a password
	 * 
	 * @param theUri
	 * @return
	 */
	String providePassword(String theUri);
	
}
