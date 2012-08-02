package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public abstract class PredicateMessageRule extends AbstractMessageRule implements PredicateRuleSupport {

	static final ValidationException[] PASSED = new ValidationException[0];

	private Predicate testPredicate;
	private Expression testExpression;

	PredicateMessageRule(Predicate predicate, Expression expression) {
		this.testPredicate = predicate;
		this.testExpression = expression;
	}

	public ValidationException[] test(Message msg) {
		try {
			Object subject = testExpression.evaluate(msg);
			return getPredicate().evaluate(subject) ? PASSED : defaultExceptions(getDescription());
		} catch (HL7Exception e) {
			return exceptions(new ValidationException(e));
		} catch (ValidationException e) {
			return exceptions(e);
		}
	}

	public Predicate getPredicate() {
		return testPredicate;
	}

	private static ValidationException[] exceptions(ValidationException e) {
		return new ValidationException[] { e };
	}

	ValidationException[] defaultExceptions(String reason) {
		return exceptions(new ValidationException("Validation failed: " + reason));
	}

}
