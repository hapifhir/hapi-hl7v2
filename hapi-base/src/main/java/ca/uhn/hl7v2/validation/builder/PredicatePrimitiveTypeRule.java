/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "PredicatePrimitiveTypeRule.java".  Description: 
"PrimitiveTypeRule that validates using predicates" 

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

import java.util.regex.Pattern;

import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.AbstractPrimitiveTypeRule;

/**
 * Abstract base class for PrimitiveTypeRules that validate using predicates
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class PredicatePrimitiveTypeRule extends AbstractPrimitiveTypeRule implements
		PredicateRuleSupport<String> {

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
		return "Primitive value '%s' requires to be " + predicate.getDescription();
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

	public ValidationException[] apply(String value) {
		try {
			return result(getPredicate().evaluate(correct(value)), value);
		} catch (ValidationException e) {
			return failed(e);
		}
	}

	@Override
	public String toString() {
		return getDescription();
	}

}
