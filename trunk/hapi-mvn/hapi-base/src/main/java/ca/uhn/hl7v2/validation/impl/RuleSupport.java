package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public abstract class RuleSupport<T> implements Rule<T> {

	private static final ValidationException[] PASSED = new ValidationException[0];

	protected ValidationException[] result(boolean result, Object value) {
		return result ? passed() : failedWithValue(value);
	}
			
	protected ValidationException[] passed() {
		return PASSED;
	}

	protected ValidationException[] failedWithValue(Object value) {
		return failed("Validation failed: " + String.format(getDescription(), value));
	}

	protected ValidationException[] failed(String msg) {
		return new ValidationException[] { new ValidationException(msg) };
	}

	protected ValidationException[] failed(Exception e) {
		if (e instanceof ValidationException)
			return new ValidationException[] { (ValidationException) e };
		return new ValidationException[] { new ValidationException("Validation failed: "
				+ e.getMessage(), e) };
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
	 */
	public String getSectionReference() {
		return null;
	}
}
