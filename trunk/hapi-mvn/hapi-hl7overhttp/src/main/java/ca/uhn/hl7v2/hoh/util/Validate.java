package ca.uhn.hl7v2.hoh.util;

/**
 * Utility class for parameter validation
 * 
 */
public abstract class Validate {

	/**
	 * @throws IllegalArgumentException
	 *             If theObject is null
	 */
	public static void notNull(Object theObject, String theName) {
		assert theName != null;

		if (theObject == null) {
			throw new IllegalArgumentException(theName + " can not be null");
		}
	}

	/**
	 * @throws IllegalArgumentException
	 *             If theObject is null or contains no non-whitespace characters
	 */
	public static void notBlank(String theObject, String theName) {
		assert theName != null;

		if (theObject == null) {
			throw new IllegalArgumentException(theName + " can not be null");
		}

		if (theObject.trim().length() == 0) {
			throw new IllegalArgumentException(theName + " can not be empty");
		}
	}

	public static void propertySet(Object theValue, String theName) {
		if (theValue == null) {
			throw new IllegalStateException("Property \"" + theName + "\" is not set");
		}
	}

}
