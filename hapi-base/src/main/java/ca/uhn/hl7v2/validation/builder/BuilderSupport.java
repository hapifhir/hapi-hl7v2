/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "BuilderSupport.java".  Description: 
"Abstract base class for Validation Rules" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.validation.builder;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.validation.ValidationException;

/**
 * 
 * Abstract base class for Validation Rule building that provides factory methods for
 * {@link Predicate}s.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public abstract class BuilderSupport implements Serializable {

	private Predicate predicate;

	protected BuilderSupport() {
	}

	protected Predicate getPredicate() {
		return predicate;
	}

	/**
	 * @param expected expected value
	 * @return a predicate that evaluates to <code>true</code> if the expected value equals the
	 *         actual value
	 */
	public Predicate isEqual(Object expected) {
		return new EqualsPredicate(expected);
	}

	/**
	 * @param expected expected value
	 * @return a predicate that evaluates to <code>true</code> if the expected value
	 *         case-insensitively equals the actual value
	 */
	public Predicate isEqualIgnoreCase(Object expected) {
		return new EqualsPredicate(expected, true);
	}

	/**
	 * @param expected expected value
	 * @return a predicate that evaluates to <code>true</code> if the actual value is null, has zero
	 *         length or is explicitly "empty" as HL7 defines it ("").
	 */
	public Predicate empty() {
		return new EmptyPredicate();
	}

	/**
	 * @param predicate
	 * @return a predicate that evaluates to <code>true</code> if the actual value is empty or the
	 *         passed predicate evaluates to true.
	 */
	public Predicate emptyOr(Predicate predicate) {
		return anyOf(empty(), predicate);
	}

	/**
	 * @param regex regular expression
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches the
	 *         regular expression
	 */
	public Predicate matches(String regex) {
		return new MatchesPredicate(regex);
	}

	/**
	 * @param prefix
	 * @return a predicate that evaluates to <code>true</code> if the actual value starts with the
	 *         specified prefix.
	 */
	public Predicate startsWith(String prefix) {
		return matches("^" + prefix + ".*");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value can be parsed
	 *         into a non-negative integer.
	 */
	public Predicate nonNegativeInteger() {
		return matches("\\d*");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value can be parsed
	 *         into a number with optional decimal digits.
	 */
	public Predicate number() {
		return matches("(\\+|\\-)?\\d*\\.?\\d*");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches a HL7
	 *         date pattern (YYYY[MM[DD]])
	 */
	public Predicate date() {
		return matches("(\\d{4}([01]\\d(\\d{2})?)?)?");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches a HL7
	 *         time pattern
	 */
	public Predicate time() {
		return matches("([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?([\\+\\-]\\d{4})?");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches a HL7
	 *         datetime pattern
	 */
	public Predicate dateTime() {
		return matches("(\\d{4}([01]\\d(\\d{2}([012]\\d[0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches a HL7
	 *         datetime pattern
	 */
	public Predicate dateTime25() {
		return matches("(\\d{4}([01]\\d(\\d{2}([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches a US
	 *         phone number pattern
	 */
	public Predicate usPhoneNumber() {
		return matches("(\\d{1,2} )?(\\(\\d{3}\\))?\\d{3}-\\d{4}(X\\d{1,5})?(B\\d{1,5})?(C.*)?");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches an ISO
	 *         OID pattern
	 */
	public Predicate oid() {
		return matches("[0-2](\\.(0|([1-9][0-9]*)))+");
	}

	/**
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches a UUID
	 *         pattern
	 */
	public Predicate uuid() {
		return matches("\\p{XDigit}{8}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{12}");
	}

	/**
	 * @param regex
	 * @param flags
	 * @return a predicate that evaluates to <code>true</code> if the actual value matches the
	 *         regular expression
	 */
	public Predicate matches(String regex, int flags) {
		return new MatchesPredicate(regex, flags);
	}

	/**
	 * Equivalent with allOf(isEqual(allowed[0]), ..., isEqual(allowed[n-1])
	 * 
	 * @param allowed
	 * @return a predicate that evaluates to <code>true</code> if the actual value occurs in he
	 *         specified array of objects
	 */
	public Predicate in(Object... allowed) {
		return new InPredicate(Arrays.asList(allowed));
	}

	/**
	 * @param allowed
	 * @return a predicate that evaluates to <code>true</code> if the actual value occurs in he
	 *         specified collection of objects
	 */
	public Predicate in(Collection<?> allowed) {
		return new InPredicate(allowed);
	}

	/**
	 * @param predicates
	 * @return a predicate that evaluates to <code>true</code> if any of the specified predicates
	 *         evaluates to <code>true</code>
	 */
	public Predicate anyOf(Iterable<Predicate> predicates) {
		return new AnyOfPredicate(predicates);
	}

	/**
	 * @param predicates
	 * @return a predicate that evaluates to <code>true</code> if all of the specified predicates
	 *         evaluate to <code>true</code>
	 */
	public Predicate allOf(Iterable<Predicate> predicates) {
		return new AllOfPredicate(predicates);
	}

	/**
	 * @param predicates
	 * @return a predicate that evaluates to <code>true</code> if any of the specified predicates
	 *         evaluates to <code>true</code>
	 */
	public Predicate anyOf(Predicate... predicates) {
		return anyOf(Arrays.asList(predicates));
	}

	/**
	 * @param predicates
	 * @return a predicate that evaluates to <code>true</code> if all of the specified predicates
	 *         evaluate to <code>true</code>
	 */
	public Predicate allOf(Predicate... predicates) {
		return allOf(Arrays.asList(predicates));
	}

	/**
	 * @param predicate
	 * @return a predicate that evaluates to <code>true</code> if the specified predicate evaluate
	 *         to <code>false</code>
	 */
	public Predicate not(Predicate delegate) {
		return new NotPredicate(delegate);
	}

	/**
	 * @param maxSize
	 * @return a predicate that evaluates to <code>true</code> if the length of the actual value is
	 *         equal or shorter than the specified length
	 */
	public Predicate maxLength(int maxSize) {
		return new MaxLengthPredicate(maxSize);
	}

	/**
	 * @return a predicate that evaluates to <code>false</code> giving the reason that the message
	 *         element has been withdrawn and should not be used anymore.
	 */
	public Predicate withdrawn() {
		return new WithdrawnPredicate();
	}

	/**
	 * @return a predicate that evaluates to the specified boolean value
	 */
	public Predicate always(boolean b) {
		return new AlwaysPredicate(b);
	}

	/**
	 * @return a predicate that evaluates to <code>false</code>
	 */
	public Predicate alwaysFails() {
		return always(false);
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
			return "not " + delegate.getDescription();
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
						|| (data != null && data.toString().equalsIgnoreCase(expected.toString()));
			return (data == null && expected == null) || (data != null && data.equals(expected));
		}

		public String getDescription() {
			return "equal to " + String.valueOf(expected);
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
			return "matching with " + String.valueOf(p.pattern());
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
