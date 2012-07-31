package ca.uhn.hl7v2.hoh.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Enum containing keys for message metadata
 */
public enum MessageMetadataKeys {

	
	
	/**
	 * The host address from which the message was sent. Value
	 * will be a {@link String} containing a raw IP address.
	 * 
	 *  @see javax.servlet.http.HttpServletRequest#getRemoteAddr()
	 */
	REMOTE_HOST_ADDRESS(String.class),
	;
	
	
	private static final Set<String> ourStringKeySetImm;
	
	static {
		HashSet<String> stringKeySet = new HashSet<String>();
		ourStringKeySetImm = Collections.unmodifiableSet(stringKeySet);
		for (MessageMetadataKeys next : values()) {
			stringKeySet.add(next.name());
		}
	}
	
	private Class<?> myValueType;

	MessageMetadataKeys(Class<?> theValueType) {
		myValueType = theValueType;
	}

	/**
	 * @return The type for the value which is associated with this key
	 */
	public Class<?> getValueType() {
		return myValueType;
	}

	/**
	 * @return Returns a set containing the string equivalent to all
	 * entries in the map
	 */
	public static Set<String> keyStringSet() {
		return ourStringKeySetImm;
	}
	
}
