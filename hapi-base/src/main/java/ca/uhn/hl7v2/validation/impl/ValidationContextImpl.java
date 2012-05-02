/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationContextImpl.java".  Description: 
"A default implementation of ValidationContext." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.validation.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationContext;

/**
 * A default implementation of <code>ValidationContext</code>.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class ValidationContextImpl implements ValidationContext, Serializable {

	private List<RuleBinding<PrimitiveTypeRule>> myPrimitiveRuleBindings;
	private List<RuleBinding<MessageRule>> myMessageRuleBindings;
	private List<RuleBinding<EncodingRule>> myEncodingRuleBindings;

	public ValidationContextImpl() {
		myPrimitiveRuleBindings = new ArrayList<RuleBinding<PrimitiveTypeRule>>();
		myMessageRuleBindings = new ArrayList<RuleBinding<MessageRule>>();
		myEncodingRuleBindings = new ArrayList<RuleBinding<EncodingRule>>();
	}

	/**
	 * @see ca.uhn.hl7v2.validation.ValidationContext#getDataTypeRules(java.lang.String,
	 *      java.lang.String)
	 * @param theType ignored
	 */
	public PrimitiveTypeRule[] getPrimitiveRules(String theVersion, String theTypeName, Primitive theType) {
		return getRules(myPrimitiveRuleBindings, theVersion, theTypeName, PrimitiveTypeRule.class);
	}

	/**
	 * @return a List of <code>RuleBinding</code>s for
	 *         <code>PrimitiveTypeRule</code>s.
	 */
	public List<RuleBinding<PrimitiveTypeRule>> getPrimitiveRuleBindings() {
		return myPrimitiveRuleBindings;
	}
		

	/**
	 * @see ca.uhn.hl7v2.validation.ValidationContext
	 *      #getMessageRules(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public MessageRule[] getMessageRules(String theVersion, String theMessageType, String theTriggerEvent) {
		return getRules(myMessageRuleBindings, theVersion, theMessageType + "^" + theTriggerEvent, MessageRule.class);
	}

	/**
	 * @return a List of <code>RuleBinding</code>s for <code>MessageRule</code>s.
	 */
	public List<RuleBinding<MessageRule>> getMessageRuleBindings() {
		return myMessageRuleBindings;
	}

	/**
	 * @see ca.uhn.hl7v2.validation.ValidationContext#getEncodingRules(java.lang.String,
	 *      java.lang.String)
	 */
	public EncodingRule[] getEncodingRules(String theVersion, String theEncoding) {
		return getRules(myEncodingRuleBindings, theVersion, theEncoding, EncodingRule.class);
	}

	/**
	 * @return a List of <code>RuleBinding</code>s for <code>EncodingRule</code>s.
	 */
	public List<RuleBinding<EncodingRule>> getEncodingRuleBindings() {
		return myEncodingRuleBindings;
	}
	
	private <T extends Rule> T[] getRules(List<RuleBinding<T>> bindings, String version, String scope,
			Class<T> ruleClass) {
		List<T> active = new ArrayList<T>(bindings.size());
		for (RuleBinding<T> binding : bindings) {
			if (applies(binding, version, scope))
				active.add(binding.getRule());
		}
		return toArray(active, ruleClass);
	}

	private boolean applies(RuleBinding<?> binding, String version, String scope) {
		return (binding.getActive() && binding.appliesToVersion(version) && binding.appliesToScope(scope));
	}

	@SuppressWarnings("unchecked")
	private <T> T[] toArray(List<T> list, Class<T> c) {
		return list.toArray((T[]) java.lang.reflect.Array.newInstance(c, list.size()));
	}

}
