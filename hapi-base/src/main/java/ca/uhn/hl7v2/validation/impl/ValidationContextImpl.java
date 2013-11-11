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
import java.util.*;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * A default implementation of <code>ValidationContext</code>.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class ValidationContextImpl implements ValidationContext, Serializable {

	private List<RuleBinding<PrimitiveTypeRule>> myPrimitiveRuleBindings;
	private List<RuleBinding<MessageRule>> myMessageRuleBindings;
	private List<RuleBinding<EncodingRule>> myEncodingRuleBindings;

    protected Map<String, Collection<PrimitiveTypeRule>> primitiveRuleCache;
    protected Map<String, Collection<MessageRule>> messageRuleCache;
    protected Map<String, Collection<EncodingRule>> encodingRuleCache;

	public ValidationContextImpl() {
		myPrimitiveRuleBindings = new ArrayList<RuleBinding<PrimitiveTypeRule>>();
		myMessageRuleBindings = new ArrayList<RuleBinding<MessageRule>>();
		myEncodingRuleBindings = new ArrayList<RuleBinding<EncodingRule>>();
        initCaches();
	}
	
	ValidationContextImpl(ValidationRuleBuilder builder) {
		this();
		for (RuleBinding<? extends Rule<?>> ruleBinding : builder.initialize()) {
			if (ruleBinding instanceof MessageRuleBinding)
				myMessageRuleBindings.add((MessageRuleBinding)ruleBinding);
			else if (ruleBinding instanceof EncodingRuleBinding)
				myEncodingRuleBindings.add((EncodingRuleBinding)ruleBinding);
			else if (ruleBinding instanceof PrimitiveTypeRuleBinding)
				myPrimitiveRuleBindings.add((PrimitiveTypeRuleBinding)ruleBinding);
		}
	}

    /**
     * Initializes caches for the three rule types. Used to accelerate the identification
     * of the rules that apply to a message or primitive.
     *
     * @see #newRuleCache(int)
     * @see #primitiveRuleCache
     * @see #messageRuleCache
     * @see #encodingRuleCache
     */
    protected void initCaches() {
        primitiveRuleCache = newRuleCache(100);
        messageRuleCache = newRuleCache(100);
        encodingRuleCache = newRuleCache(10);
    }

    /**
	 * @see ValidationContext#getPrimitiveRules(String, String, Primitive)
	 * @param theType ignored
	 */
	public Collection<PrimitiveTypeRule> getPrimitiveRules(String theVersion, String theTypeName, Primitive theType) {
        Collection<PrimitiveTypeRule> rules = primitiveRuleCache.get(theVersion + theTypeName);
        if (rules == null) {
            rules = getRules(myPrimitiveRuleBindings, theVersion, theTypeName);
            primitiveRuleCache.put(theVersion + theTypeName, rules);
        }
        return rules;
	}

	/**
	 * @return a List of <code>RuleBinding</code>s for
	 *         <code>PrimitiveTypeRule</code>s.
	 */
	public List<RuleBinding<PrimitiveTypeRule>> getPrimitiveRuleBindings() {
		return myPrimitiveRuleBindings;
	}
		

	/**
	 * @see ValidationContext#getMessageRules(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Collection<MessageRule> getMessageRules(String theVersion, String theMessageType, String theTriggerEvent) {
        Collection<MessageRule> rules = messageRuleCache.get(theVersion + theMessageType + theTriggerEvent);
        if (rules == null) {
            rules = getRules(myMessageRuleBindings, theVersion, theMessageType + "^" + theTriggerEvent);
            messageRuleCache.put(theVersion + theMessageType + theTriggerEvent, rules);
        }
        return rules;
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
	public Collection<EncodingRule> getEncodingRules(String theVersion, String theEncoding) {
        Collection<EncodingRule> rules = encodingRuleCache.get(theVersion + theEncoding);
        if (rules == null) {
            rules = getRules(myEncodingRuleBindings, theVersion, theEncoding);
            encodingRuleCache.put(theVersion + theEncoding, rules);
        }
        return rules;
	}

	/**
	 * @return a List of <code>RuleBinding</code>s for <code>EncodingRule</code>s.
	 */
	public List<RuleBinding<EncodingRule>> getEncodingRuleBindings() {
		return myEncodingRuleBindings;
	}
	
	private <T extends Rule<?>> Collection<T> getRules(List<RuleBinding<T>> bindings, String version, String scope) {
		List<T> active = new ArrayList<T>(bindings.size());
		for (RuleBinding<T> binding : bindings) {
			if (applies(binding, version, scope))
				active.add(binding.getRule());
		}
		return active;
	}

	private boolean applies(RuleBinding<?> binding, String version, String scope) {
		return (binding.getActive() && binding.appliesToVersion(version) && binding.appliesToScope(scope));
	}


    /**
     * Simple cache implementation that keeps at most {@link #size} elements around
     *
     * @param <T>
     */
    private static class RuleCache<T extends Rule<?>> extends LinkedHashMap<String, Collection<T>> {

        private final int size;

        private RuleCache(int size) {
            super(size);
            this.size = size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Collection<T>> eldest) {
            return size() > size;
        }

    }

    protected static <T extends Rule<?>> Map<String, Collection<T>> newRuleCache(int size) {
        Map<String, Collection<T>> cache = new RuleCache<T>(size);
        return Collections.synchronizedMap(cache);
    }
}
