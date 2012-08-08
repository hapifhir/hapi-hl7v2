package ca.uhn.hl7v2.validation.builder.support;

import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;


@SuppressWarnings("serial")
public class NoValidationBuilder extends ValidationRuleBuilder {

	public void configure() {
		forAllVersions()
			.primitive("FT", "ST", "TX").trimmed();
	}
}
