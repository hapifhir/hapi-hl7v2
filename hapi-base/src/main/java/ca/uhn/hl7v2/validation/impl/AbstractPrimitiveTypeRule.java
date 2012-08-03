package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public abstract class AbstractPrimitiveTypeRule extends RuleSupport<String> implements PrimitiveTypeRule {

	public boolean test(String value) {
		ValidationException[] exceptions = apply(value);
		return exceptions == null || exceptions.length == 0;
	}

	public String correct(String value) {
		return value;
	}

}
