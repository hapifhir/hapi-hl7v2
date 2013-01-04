package ca.uhn.hl7v2.hoh.api;

/**
 * Provides callback methods for providing credentials
 */
public interface IAuthorizationClientCallback {

	/**
 	 * Provides a username
	 * 
	 * @param theUriPath
	 * @return
	 */
	String provideUsername(String theUriPath);
	
	/**
	 * Provides a password
	 * 
	 * @param theUriPath
	 * @return
	 */
	String providePassword(String theUriPath);
	
}
