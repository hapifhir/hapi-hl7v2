package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.util.Terser;

public interface Expression<T extends Structure> {

	Object evaluate(T value) throws HL7Exception;

}

class TerserExpression implements Expression<Message> {

	private String expression;

	public TerserExpression(String expression) {
		super();
		this.expression = expression;
	}

	public Object evaluate(Message msg) throws HL7Exception {
		return new Terser(msg).get(expression);
	}
}



