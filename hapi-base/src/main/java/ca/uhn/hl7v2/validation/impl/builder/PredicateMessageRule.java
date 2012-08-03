package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;

@SuppressWarnings("serial")
public abstract class PredicateMessageRule extends AbstractMessageRule implements PredicateRuleSupport<Message> {

	private Predicate testPredicate;
	private Expression testExpression;

	PredicateMessageRule(Predicate predicate, Expression expression) {
		this.testPredicate = predicate;
		this.testExpression = expression;
	}

	public ValidationException[] apply(Message msg) {
		try {
			Object subject = testExpression.evaluate(msg);
			return result(getPredicate().evaluate(subject));
		} catch (Exception e) {
			return failed(e);
		}
	}

	public Predicate getPredicate() {
		return testPredicate;
	}


}
