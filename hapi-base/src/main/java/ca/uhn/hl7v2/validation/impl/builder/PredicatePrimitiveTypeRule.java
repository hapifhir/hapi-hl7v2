package ca.uhn.hl7v2.validation.impl.builder;

import java.util.regex.Pattern;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public class PredicatePrimitiveTypeRule implements PredicateRuleSupport, PrimitiveTypeRule {

	private static final Pattern LEADING_WHITESPACE = Pattern.compile("^\\s+");

	private Predicate predicate;
	private boolean trimLeadingWhitespace;

	public PredicatePrimitiveTypeRule(Predicate predicate) {
		this(predicate, false);
	}

	public PredicatePrimitiveTypeRule(Predicate predicate, boolean trimLeadingWhitespace) {
		this.predicate = predicate;
		this.trimLeadingWhitespace = trimLeadingWhitespace;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public String getDescription() {
		return "primitive value requires to be " + predicate.getDescription();
	}

	public String getSectionReference() {
		return null;
	}

	public String correct(String value) {
		return trimLeadingWhitespace && value != null ? LEADING_WHITESPACE.matcher(value)
				.replaceAll("") : value;
	}

	public boolean test(String value) {
		try {
			return getPredicate().evaluate(value);
		} catch (ValidationException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return getDescription();
	}
	
	

}
