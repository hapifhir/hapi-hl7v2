/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "PredicateMessageRule.java".  Description: 
"MessageRule that validates using predicates" 

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

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;

/**
 * Abstract base class for message rules that are evaluated using predicates
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public abstract class PredicateMessageRule extends AbstractMessageRule implements
		PredicateRuleSupport<Message> {

	private Predicate testPredicate;
	private Expression<Message> testExpression;

    /**
     * Create a new message rule
     * @param predicate the predicate to be used for the test
     * @param expression the expression to be used to extract the message part
     *                   to be tested
     */
	public PredicateMessageRule(Predicate predicate, Expression<Message> expression) {
		this.testPredicate = predicate;
		this.testExpression = expression;
        setDescription(testExpression.getDescription() + " '%s' requires to be "
                + testPredicate.getDescription());
	}

	public ValidationException[] apply(Message msg) {
		try {
			Object subject = testExpression.evaluate(msg);
			boolean passed = getPredicate().evaluate(subject);
			return passed ? passed() : failedWithValue(subject, testExpression.getLocation(msg));
		} catch (Exception e) {
			return failed(e);
		}
	}

	public Predicate getPredicate() {
		return testPredicate;
	}


}
