package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractPrimitive;

/**
 * <p>Represents the HL7 TN (telephone number) datatype.  A TN contains a single String value.
 */
public class TN extends AbstractPrimitive  {

	/**
	 * Constructs an uninitialized TN.
	 * @param message the Message to which this Type belongs
	 */
	public TN(Message message) {
		super(message);
	}

	/**
	 * @return "2.4"
	 */
	public String getVersion() {
	    return "2.4";
	}

}
