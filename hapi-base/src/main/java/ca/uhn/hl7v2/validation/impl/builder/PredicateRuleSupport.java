package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.validation.Rule;

public interface PredicateRuleSupport<T> extends Rule<T> {

	Predicate getPredicate();
	
}
