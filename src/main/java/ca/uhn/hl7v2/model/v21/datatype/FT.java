package ca.uhn.hl7v2.model.v21.datatype;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractPrimitive;

/**
 * <p>Represents the HL7 FT (formatted text data) datatype.  A FT contains a single String value.
 */
public class FT extends AbstractPrimitive  {

	/**
	 * Constructs an uninitialized FT.
	 * @param message the Message to which this Type belongs
	 */
	public FT(Message message) {
		super(message);
	}

	/**
	 * @return "2.1"
	 */
	public String getVersion() {
	    return "2.1";
	}

}
