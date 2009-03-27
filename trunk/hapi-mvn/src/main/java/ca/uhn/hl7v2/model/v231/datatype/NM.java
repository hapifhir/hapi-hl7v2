package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractPrimitive;

/**
 * <p>Represents the HL7 NM (numeric) datatype.  A NM contains a single String value.
 */
public class NM extends AbstractPrimitive  {

	/**
	 * Constructs an uninitialized NM.
	 * @param message the Message to which this Type belongs
	 */
	public NM(Message message) {
		super(message);
	}

	/**
	 * @return "2.3.1"
	 */
	public String getVersion() {
	    return "2.3.1";
	}

}
