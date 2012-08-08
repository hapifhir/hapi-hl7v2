package ca.uhn.hl7v2.validation.builder.support;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

@SuppressWarnings("serial")
public class DefaultValidationWithoutTNBuilder extends ValidationRuleBuilder {

	/**
	 * @see ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder#configure()
	 */
	protected void configure() {
		forAllVersions()
			.primitive("FT").trimmed(maxLength(32000))
			.primitive("ST", "TX").trimmed()
			.primitive("ID", "IS").is(maxLength(200))
			.primitive("SI").is(emptyOr(nonNegativeInteger()))
			.primitive("NM").is(emptyOr(number()))
			.primitive("DT")
				.refersToSection("Version 2.5 Section 2.A.21")
				.is(emptyOr(date()))
			.primitive("TM")
				.refersToSection("Version 2.5 Section 2.A.75")
				.is(emptyOr(time()))
			.primitive("NULLDT").is(withdrawn());
		
		forVersion().before(Version.V25)
			.primitive("TSComponentOne")
				.refersToSection("Version 2.4 Section 2.9.47")
				.is(emptyOr(dateTime()));
		
		forVersion().asOf(Version.V25)
			.primitive("TSComponentOne", "DTM")
				.refersToSection("Version 2.5 Section 2.A.22")
				.is(emptyOr(dateTime25()));
	}
}
