package ca.uhn.hl7v2.validation.impl.builder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public class BuilderSupport implements Serializable {

	private Predicate predicate;

	protected BuilderSupport() {
	}

	protected Predicate getPredicate() {
		return predicate;
	}

	public Predicate isEqual(Object expected) {
		return new EqualsPredicate(expected);
	}

	public Predicate isEqualIgnoreCase(Object expected) {
		return new EqualsPredicate(expected, true);
	}

	public Predicate empty() {
		return new EmptyPredicate();
	}

	public Predicate emptyOr(Predicate predicate) {
		return anyOf(empty(), predicate);
	}

	public Predicate notEmpty() {
		return not(empty());
	}

	public Predicate matches(String regex) {
		return new MatchesPredicate(regex);
	}

	public Predicate startsWith(String regex) {
		return matches("^" + regex + ".*");
	}

	public Predicate nonNegativeInteger() {
		return matches("\\d*");
	}

	public Predicate number() {
		return matches("(\\+|\\-)?\\d*\\.?\\d*");
	}

	public Predicate date() {
		return matches("(\\d{4}([01]\\d(\\d{2})?)?)?");
	}

	public Predicate time() {
		return matches("([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?([\\+\\-]\\d{4})?");
	}

	public Predicate dateTime() {
		return matches("(\\d{4}([01]\\d(\\d{2}([012]\\d[0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?");
	}

	public Predicate dateTime25() {
		return matches("(\\d{4}([01]\\d(\\d{2}([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?");
	}
	
	public Predicate oid() {
		return matches("[0-2](\\.(0|([1-9][0-9]*)))+");
	}
	
	public Predicate uuid() {
		return matches("\\p{XDigit}]{8}-\\p{XDigit}]{4}-\\p{XDigit}]{4}-\\p{XDigit}]{4}-\\p{XDigit}]{12}");
	}	

	public Predicate matches(String regex, int flags) {
		return new MatchesPredicate(regex, flags);
	}
	
	public Predicate in(Object... allowed) {
		return new InPredicate(Arrays.asList(allowed));
	}
	
	public Predicate in(Collection<?> allowed) {
		return new InPredicate(allowed);
	}	

	public Predicate anyOf(Iterable<Predicate> predicates) {
		return new AnyOfPredicate(predicates);
	}

	public Predicate allOf(Iterable<Predicate> predicates) {
		return new AllOfPredicate(predicates);
	}

	public Predicate anyOf(Predicate... predicates) {
		return anyOf(Arrays.asList(predicates));
	}

	public Predicate allOf(Predicate... predicates) {
		return allOf(Arrays.asList(predicates));
	}

	public Predicate not(Predicate delegate) {
		return new NotPredicate(predicate);
	}

	public Predicate maxLength(int maxSize) {
		return new MaxLengthPredicate(maxSize);
	}

	public Predicate withdrawn() {
		return new WithdrawnPredicate();
	}

	public Predicate always(boolean b) {
		return new AlwaysPredicate(b);
	}

	static private String join(Iterable<?> list, String conjunction) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Object item : list) {
			if (first)
				first = false;
			else
				sb.append(conjunction);
			sb.append(item);
		}
		return sb.toString();
	}

	private class AlwaysPredicate implements Predicate {

		private boolean b;

		AlwaysPredicate(boolean b) {
			this.b = b;
		}

		public boolean evaluate(Object data) throws ValidationException {
			return b;
		}

		public String getDescription() {
			return b ? "anything" : "nothing";
		}

	}

	private class MaxLengthPredicate implements Predicate {

		private int maxLength = Integer.MAX_VALUE;

		public MaxLengthPredicate(int maxSize) {
			this.maxLength = maxSize;
		}

		public boolean evaluate(Object data) throws ValidationException {
			return (data == null || data.toString().length() <= maxLength);
		}

		public String getDescription() {
			return "shorter than " + maxLength + " characters";
		}

	}

	private class InPredicate implements Predicate {

		private Collection<?> allowed;

		InPredicate(Collection<?> allowed) {
			this.allowed = allowed;
		}

		public boolean evaluate(Object data) throws ValidationException {
			return allowed.contains(data);
		}

		public String getDescription() {
			return "in [" + join(allowed, ",") + "]";
		}

	}

	private class WithdrawnPredicate extends MaxLengthPredicate {

		public WithdrawnPredicate() {
			super(0);
		}

		@Override
		public String getDescription() {
			return "empty because it is withdrawn from the current HL7 version and should not be used";
		}

	}

	private class NotPredicate implements Predicate {

		private Predicate delegate;

		public NotPredicate(Predicate delegate) {
			this.delegate = delegate;
		}

		public boolean evaluate(Object data) throws ValidationException {
			try {
				return !delegate.evaluate(data);
			} catch (ValidationException e) {
				return true;
			}
		}

		public String getDescription() {
			return "not (" + predicate.getDescription() + ")";
		}

	}

	private class EqualsPredicate implements Predicate {

		private Object expected;
		private boolean ignoresCase;

		public EqualsPredicate(Object expected) {
			this(expected, false);
		}

		EqualsPredicate(Object expected, boolean ignoresCase) {
			super();
			this.expected = expected;
			this.ignoresCase = ignoresCase;
		}

		public boolean evaluate(Object data) throws ValidationException {
			if (ignoresCase)
				return (data == null && expected == null)
						|| (data.toString().equalsIgnoreCase(expected.toString()));
			return (data == null && expected == null) || (data.equals(expected));
		}

		public String getDescription() {
			return "equals to " + String.valueOf(expected);
		}

	}

	private class EmptyPredicate implements Predicate {

		public EmptyPredicate() {
		}

		public boolean evaluate(Object data) throws ValidationException {
			return data == null || "".equals(data) || "\"\"".equals(data);
		}

		public String getDescription() {
			return "empty";
		}

	}

	private class MatchesPredicate implements Predicate {

		private Pattern p;

		public MatchesPredicate(String regex) {
			p = Pattern.compile(regex);
		}

		public MatchesPredicate(String regex, int flags) {
			p = Pattern.compile(regex, flags);
		}

		public boolean evaluate(Object data) throws ValidationException {
			return (data != null && p.matcher(data.toString()).matches());
		}

		public String getDescription() {
			return "matches with " + String.valueOf(p.pattern());
		}

	}

	private class AnyOfPredicate implements Predicate {

		private Iterable<Predicate> predicates;

		public AnyOfPredicate(Iterable<Predicate> predicates) {
			super();
			this.predicates = predicates;
		}

		public boolean evaluate(Object data) throws ValidationException {
			for (Predicate p : predicates) {
				if (p.evaluate(data)) {
					return true;
				}
			}
			return false;
		}

		public String getDescription() {
			String or = " or ";
			StringBuffer b = new StringBuffer();
			for (Predicate p : predicates) {
				b.append(p.getDescription()).append(or);
			}
			return b.substring(0, b.length() - or.length());
		}

	}

	private class AllOfPredicate implements Predicate {

		private Iterable<Predicate> predicates;

		public AllOfPredicate(Iterable<Predicate> predicates) {
			super();
			this.predicates = predicates;
		}

		public boolean evaluate(Object data) throws ValidationException {
			for (Predicate p : predicates) {
				if (!p.evaluate(data)) {
					return false;
				}
			}
			return true;
		}

		public String getDescription() {
			String and = " and ";
			StringBuffer b = new StringBuffer();
			for (Predicate p : predicates) {
				b.append(p.getDescription()).append(and);
			}
			return b.substring(0, b.length() - and.length());
		}

	}

}
