package ca.uhn.hl7v2.validation.impl.builder.support;


@SuppressWarnings("serial")
public class DefaultValidationBuilder extends DefaultValidationWithoutTNBuilder {

	@Override
	public void configure() {
		super.configure();

		forAllVersions()
			.primitive("TN")
				.refersToSection("Version 2.4 Section 2.9.45")
				.is(emptyOr(usPhoneNumber()));
	}

}
