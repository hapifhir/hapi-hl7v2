package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.validation.MessageRule;

@SuppressWarnings("serial")
public abstract class AbstractMessageRule implements MessageRule {

	private String description;
	private String sectionReference;

	public String getDescription() {
		return description;
	}

	public String getSectionReference() {
		return sectionReference;
	}

}
