package ca.uhn.hl7v2.validation.impl.builder;

import java.io.Serializable;

import ca.uhn.hl7v2.validation.ValidationException;

public interface Predicate extends Serializable {

	boolean evaluate(Object data) throws ValidationException;
	
	String getDescription();

}
