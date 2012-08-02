package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

public interface Expression {

	Object evaluate(Message msg) throws HL7Exception;
	
}
