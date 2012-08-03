package ca.uhn.hl7v2.validation.impl.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.PrimitiveTypeRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

@SuppressWarnings("serial")
public class PrimitiveRuleBuilder extends RuleTypeBuilder<PrimitiveTypeRule> {

	private String[] types;

	protected PrimitiveRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules, Version[] versions,
			String... types) {
		super(rules, versions);
		this.types = types;
	}	

	public PrimitiveRuleBuilder is(Predicate predicate) {
		return test(new PredicatePrimitiveTypeRule(predicate));
	}

	public PrimitiveRuleBuilder trimmed(Predicate predicate) {
		return test(new PredicatePrimitiveTypeRule(predicate, true));
	}

	public PrimitiveRuleBuilder trimmed() {
		return trimmed(always(true));
	}

	public PrimitiveRuleBuilder test(PredicatePrimitiveTypeRule rule) {
		addRuleBindings(rule);
		return this;
	}
	
	/**
	 * Adds a description to a rule
	 */
	public PrimitiveRuleBuilder description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Adds a HL7 section reference to a rule
	 */
	public PrimitiveRuleBuilder refersToSection(String sectionReference) {
		this.sectionReference = sectionReference;
		return this;
	}	

	@Override
	protected Collection<RuleBinding<PrimitiveTypeRule>> getRuleBindings(PrimitiveTypeRule rule, String version) {
		List<RuleBinding<PrimitiveTypeRule>> bindings = new ArrayList<RuleBinding<PrimitiveTypeRule>>();
		for (String type : types) {
			bindings.add(new PrimitiveTypeRuleBinding(version, type, rule));
		}
		return bindings;
	}

}
