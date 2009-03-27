package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractPrimitive;

/**
 * <p>Represents the HL7 TX (text data) datatype.  A TX contains a single String value.
 */
public class TX extends AbstractPrimitive  {

	/**
	 * Constructs an uninitialized TX.
	 * @param message the Message to which this Type belongs
	 */
	public TX(Message message) {
		super(message);
	}

	/**
	 * @return "2.2"
	 */
	public String getVersion() {
	    return "2.2";
	}

}
