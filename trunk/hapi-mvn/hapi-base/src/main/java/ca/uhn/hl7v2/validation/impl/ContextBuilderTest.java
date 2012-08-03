package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.impl.builder.ValidationRuleBuilder;

public class ContextBuilderTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("serial")
		final ValidationContextImpl context = new ValidationContextImpl(
			new ValidationRuleBuilder() {

			public void configure() {
				forVersion(Version.V22)
					.message("ADT", "*")
						.description("blorg gedönds")
						.terser("PID-2", allOf(maxLength(10), startsWith("A")))
						.terser("PID-3", not(empty()))
					.message("ORU", "R01")
						.terser("MSH-9-1", isEqual("ORU"));
				forVersion().asOf(Version.V23)
					.message("ADT", "*")
						.terser("PID-2", allOf(maxLength(10), startsWith("B")))
						.terser("PID-3", not(empty()));
			}

		});
	}
}
