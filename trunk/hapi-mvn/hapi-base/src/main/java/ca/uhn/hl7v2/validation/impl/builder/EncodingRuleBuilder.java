package ca.uhn.hl7v2.validation.impl.builder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.EncodingRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

@SuppressWarnings("serial")
public class EncodingRuleBuilder extends RuleTypeBuilder<EncodingRule> {

	private String encoding;

	protected EncodingRuleBuilder(List<RuleBinding<? extends Rule>> rules, Version[] versions,
			String encoding) {
		super(rules, versions);
	}

	public EncodingRuleBuilder xsd() {
		// TODO add rule
		addRuleBindings(null);
		return this;
	}

	public EncodingRuleBuilder xsd(String schemaPath) {
		// TODO add rule
		addRuleBindings(null);
		return this;
	}

	/**
	 * Adds a description to a rule
	 */
	public EncodingRuleBuilder description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Adds a HL7 section reference to a rule
	 */
	public EncodingRuleBuilder refersToSection(String sectionReference) {
		this.sectionReference = sectionReference;
		return this;
	}	
	
	@Override
	protected Collection<RuleBinding<EncodingRule>> getRuleBindings(EncodingRule rule, String version) {
		RuleBinding<EncodingRule> binding =  new EncodingRuleBinding(version, encoding, rule);
		return Collections.singletonList(binding);
	}

}
