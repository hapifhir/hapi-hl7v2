package ca.uhn.hl7v2.validation.impl.builder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * Defines the type of rule to be built.
 */
@SuppressWarnings("serial")
public class RuleTypeBuilder<T extends Rule<?>> extends ValidationRuleBuilder {

	protected Version[] versions;
	protected String description;
	protected String sectionReference;

	protected RuleTypeBuilder(List<RuleBinding<? extends Rule<?>>> rules, Version... versions) {
		super(rules);
		if (versions.length == 0)
			throw new IllegalArgumentException("Must specify a version");
		this.versions = versions;
	}

	public PrimitiveRuleBuilder primitive(String... type) {
		return new PrimitiveRuleBuilder(rules, versions, type);
	}

	public MessageRuleBuilder message(String messageType, String triggerEvent) {
		return new MessageRuleBuilder(rules, versions, messageType, triggerEvent);
	}

	public EncodingRuleBuilder encoding(String encoding) {
		return new EncodingRuleBuilder(rules, versions, encoding);
	}

	protected void addRuleBindings(T rule) {
		for (Version version : versions) {
			rules.addAll(getRuleBindings(rule, version.getVersion()));
		}
	}

	/**
	 * Builder implementation must overwrite this method to return all
	 * {@link RuleBinding}s for rules that have been built.
	 * 
	 * @param rule
	 * @param version
	 * @return a collection of {@link RuleBinding}s
	 */
	@SuppressWarnings("unchecked")
	protected Collection<RuleBinding<T>> getRuleBindings(T rule, String version) {
		return (Collection<RuleBinding<T>>)Collections.EMPTY_LIST;
	}


}
