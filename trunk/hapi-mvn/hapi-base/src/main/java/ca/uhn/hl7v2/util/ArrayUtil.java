package ca.uhn.hl7v2.util;

/**
 * Utility methods for working with arrays
 */
public class ArrayUtil {

	/**
	 * Returns true if the array contains the given value, using
	 * {@link Object#equals(Object)}. Checks for a null value
	 * in the array if theValue is null.
     *
     * @param theArray the array to be checked
     * @param theValue value to be search for
	 */
	public static <T> boolean contains(T[] theArray, T theValue) {
		for (T next : theArray) {
			if (theValue == null) {
				if (next == null) {
					return true;
				}
			} else {
				if (theValue.equals(next)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
