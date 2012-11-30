/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "PrimitiveRuleBuilder.java".  Description: 
"Rule Builder for PrimitiveTypeRules."

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.builder.PredicatePrimitiveTypeRule.Trimmer;
import ca.uhn.hl7v2.validation.impl.PrimitiveTypeRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * Rule builder for {@link PrimitiveTypeRule}s
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class PrimitiveRuleBuilder extends RuleTypeBuilder<PrimitiveRuleBuilder, PrimitiveTypeRule>  {

	private Set<String> types;

	protected PrimitiveRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules, Set<Version> versions,
			Set<String> types) {
		super(rules, versions);
		this.types = types;
	}

	/**
	 * Builds a {@link PrimitiveTypeRule} that evaluates the specified {@link Predicate} against the
	 * primitive value.
	 * 
	 * @param predicate predicate to evaluate the primitive value against
	 * 
	 * @return this instance to build more rules
	 */
	public PrimitiveRuleBuilder is(Predicate predicate) {
		return test(new PredicatePrimitiveTypeRule(predicate));
	}

	/**
	 * Builds a {@link PrimitiveTypeRule} that evaluates the specified {@link Predicate} against the
	 * primitive value with leading whitespaces trimmed.
	 * 
	 * @param predicate predicate to evaluate the primitive value against
	 * 
	 * @return this instance to build more rules
	 */
	public PrimitiveRuleBuilder leftTrim(Predicate predicate) {
		return test(new PredicatePrimitiveTypeRule(predicate, Trimmer.LEFT));
	}

    /**
     * Builds a {@link PrimitiveTypeRule} that always evaluates to <code>true</code> and trims
     * leading whitespaces.
     * 
     * @return this instance to build more rules
     */
    public PrimitiveRuleBuilder leftTrim() {
        return leftTrim(always(true));
    }
    
	/**
	 * Builds a {@link PrimitiveTypeRule} that always evaluates to <code>true</code> and trims
	 * trailing whitespaces.
	 * 
	 * @return this instance to build more rules
	 */
	public PrimitiveRuleBuilder rightTrim() {
		return rightTrim(always(true));
	}
	
    /**
     * Builds a {@link PrimitiveTypeRule} that evaluates the specified {@link Predicate} against the
     * primitive value with trailing whitespaces trimmed.
     * 
     * @param predicate predicate to evaluate the primitive value against
     * 
     * @return this instance to build more rules
     */
    public PrimitiveRuleBuilder rightTrim(Predicate predicate) {
        return test(new PredicatePrimitiveTypeRule(predicate, Trimmer.RIGHT));
    }
    
    /**
     * Builds a {@link PrimitiveTypeRule} that always evaluates to <code>true</code> and trims
     * leading and trailing whitespaces.
     * 
     * @return this instance to build more rules
     */
    public PrimitiveRuleBuilder allTrim() {
        return allTrim(always(true));
    }
    
    /**
     * Builds a {@link PrimitiveTypeRule} that evaluates the specified {@link Predicate} against the
     * primitive value with leading and trailing whitespaces trimmed.
     * 
     * @param predicate predicate to evaluate the primitive value against
     * 
     * @return this instance to build more rules
     */
    public PrimitiveRuleBuilder allTrim(Predicate predicate) {
        return test(new PredicatePrimitiveTypeRule(predicate, Trimmer.ALL));
    }    

	@Override
	protected Collection<RuleBinding<PrimitiveTypeRule>> getRuleBindings(PrimitiveTypeRule rule,
			String version) {
		List<RuleBinding<PrimitiveTypeRule>> bindings = new ArrayList<RuleBinding<PrimitiveTypeRule>>();
		for (String type : types) {
			bindings.add(new PrimitiveTypeRuleBinding(version, type, rule));
		}
		return activate(bindings);
	}

	// for tests only
	Set<String> getTypes() {
		return types;
	}

	
}
