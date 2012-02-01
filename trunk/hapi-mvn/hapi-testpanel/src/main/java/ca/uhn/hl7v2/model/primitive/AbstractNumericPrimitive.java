package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.Message;

public abstract class AbstractNumericPrimitive extends AbstractPrimitive {

	public AbstractNumericPrimitive(Message theMessage) {
		super(theMessage);
	}

	/**
	 * Returns true of the string contains only numbers
	 */
	public static boolean isInteger(String theString) {
		for (int i = 0; i < theString.length(); i++) {
			if (Character.isDigit(theString.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
}
