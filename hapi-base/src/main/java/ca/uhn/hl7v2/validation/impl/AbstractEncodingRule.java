package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public abstract class AbstractEncodingRule extends RuleSupport<String> implements EncodingRule {

	public ValidationException[] test(String value) {
		return apply(value);
	}

}
