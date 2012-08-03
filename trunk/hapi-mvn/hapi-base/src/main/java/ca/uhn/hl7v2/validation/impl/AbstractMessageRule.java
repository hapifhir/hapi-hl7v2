package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public abstract class AbstractMessageRule extends RuleSupport<Message> implements MessageRule {

	protected String description;
	protected String sectionReference;

	public ValidationException[] test(Message msg) {
		return apply(msg);
	}

	public String getDescription() {
		return description;
	}

	public String getSectionReference() {
		return sectionReference;
	}

}
