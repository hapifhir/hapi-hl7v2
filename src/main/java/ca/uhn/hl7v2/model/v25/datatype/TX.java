package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractPrimitive;

/**
 * <p>Represents the HL7 TX (Text Data) datatype.  A TX contains a single String value.
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
	 * @return "2.5"
	 */
	public String getVersion() {
	    return "2.5";
	}

}
