/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "RuleTypeBuilder.java".  Description: 
"RuleBuilder that determines which kind of rule shall be built" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.Severity;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleSupport;

/**
 * Defines the type of rule to be built.
 * <p>
 * The recursive type parameter allows the builder methods common to all subclasses (e.g.
 * {@link #refersToSection}, {@link #active}, {@link #test}) to return their specific builder type.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class RuleTypeBuilder<S extends RuleTypeBuilder<S, T>, T extends Rule<?>> extends
		BuilderSupport {

	private List<RuleBinding<? extends Rule<?>>> rules = new ArrayList<RuleBinding<? extends Rule<?>>>();
	private Set<Version> versions;
	private String description;
	private String sectionReference;
	private boolean active = true;
    private Severity severity = Severity.ERROR;

	protected RuleTypeBuilder() {
		super();
	}
	
	protected RuleTypeBuilder(List<RuleBinding<? extends Rule<?>>> rules, Set<Version> versions) {
		super();
		if (versions.size() == 0)
			throw new IllegalArgumentException("Must specify a version");
		this.rules = rules;
		this.versions = versions;
	}

	protected RuleTypeBuilder(List<RuleBinding<? extends Rule<?>>> rules, Version... versions) {
		super();
		if (versions.length == 0)
			throw new IllegalArgumentException("Must specify a version");
		this.rules = rules;
		this.versions = new HashSet<Version>(Arrays.asList(versions));
	}

	@SuppressWarnings("unchecked")
	protected S instance() {
		return (S) this;
	}
	
	protected List<RuleBinding<? extends Rule<?>>> getRules() {
		return rules;
	}

    protected T prepareRule(T rule) {
        if (rule instanceof RuleSupport) {
            RuleSupport<?> rs = (RuleSupport<?>)rule;
            if (description != null) rs.setDescription(description);
            if (sectionReference != null) rs.setSectionReference(sectionReference);
            rs.setSeverity(severity);
        }
        return rule;
    }

	/**
	 * Adds a description to the rule
	 * 
	 * @param description description
	 * @return this instance to build more rules
	 */
	public S description(String description) {
		this.description = description;
		return instance();
	}

	/**
	 * Adds a HL7 section reference to a rule
	 * 
	 * @param sectionReference the section in the HL7 specification
	 * @return this instance to build more rules
	 */
	public S refersToSection(String sectionReference) {
		this.sectionReference = sectionReference;
		return instance();
	}

    /**
     * Sets the severity of the rule
     *
     * @param severity the the severity of the rule
     * @return this instance to build more rules
     */
    public S severity(Severity severity) {
        this.severity = severity;
        return instance();
    }

	/**
	 * Marks the rule as being active (default) or inactive
	 * 
	 * @param active true if this rule shall be active
	 * @return this instance to build more rules
	 */
	public S active(boolean active) {
		this.active = active;
		return instance();
	}

	/**
	 * Adds the specified rule to the set of rules.
	 * 
	 * @param rule the rule to be tested
	 * @return this instance to build more rules
	 */
	public S test(T rule) {
		addRuleBindings(rule);
		return instance();
	}

	/**
	 * Builds {@link PrimitiveTypeRule}s for the specified types
	 * 
	 * @param type an array of types
	 * @return this instance to continue building rules
	 */
	public PrimitiveRuleBuilder primitive(String... type) {
		if (type.length == 0) {
			throw new IllegalArgumentException("Must specify a type");
		}
		return new PrimitiveRuleBuilder(rules, versions, new HashSet<String>(Arrays.asList(type)));
	}

	/**
	 * Builds {@link MessageRule}s for the specified event types and triggers
	 * 
	 * @param eventType Event type, e.g. "ADT", or "*" for all types
	 * @param triggerEvent, e.g. "A01" or "*" for all trigger events
	 * @return this instance to continue building rules
	 */
	public MessageRuleBuilder message(String eventType, String triggerEvent) {
		return new MessageRuleBuilder(rules, versions, eventType, triggerEvent);
	}

    /**
     * Builds {@link MessageRule}s for event types and triggers to be specified
     * using the returned MessageExpressionBuilder.
     *
     * @return MessageExpressionBuilder instance to continue building rules
     */
	public MessageExpressionBuilder message() {
		return new MessageExpressionBuilder();
	}

	/**
	 * Builds {@link MessageRule}s for the specified encoding
	 * 
	 * @param encoding "XML" or "VB"
	 * @return this instance to continue building rules
	 */
	public EncodingRuleBuilder encoding(String encoding) {
		return new EncodingRuleBuilder(rules, versions, encoding);
	}

	/**
	 * Add {@link RuleBinding}s for the rule that have been built
	 * 
	 * @param rule the rule for which bindings shall be added
	 */
	protected void addRuleBindings(T rule) {
		if (Version.allVersions(versions)) {
			// Save some bindings when all HL7 versions are affected
			rules.addAll(getRuleBindings(rule, "*"));
		} else {
			for (Version version : versions) {
				rules.addAll(getRuleBindings(rule, version.getVersion()));
			}
		}
	}

	/**
	 * Builder implementation must overwrite this method to return all {@link RuleBinding}s for
	 * rules that have been built.
	 * 
	 * @param rule the rule for which bindings shall be retrieved
	 * @param version the HL7 version for which bindings shall be retrieved
	 * @return a collection of {@link RuleBinding}s
	 */
	@SuppressWarnings("unchecked")
	protected Collection<RuleBinding<T>> getRuleBindings(T rule, String version) {
		return (Collection<RuleBinding<T>>) Collections.EMPTY_LIST;
	}

	protected Collection<RuleBinding<T>> activate(Collection<RuleBinding<T>> bindings) {
		for (RuleBinding<T> ruleBinding : bindings) {
			ruleBinding.setActive(active);
		}
		return bindings;
	}

	// for tests only
	Set<Version> getVersions() {
		return versions;
	}

	/**
	 * Helper builder when the versions are not given explicitly but in form of an expression.
	 */
	public class MessageExpressionBuilder {

        /**
         * Applies {@link MessageRule}s for all event types and trigger events
         * @return rule builder
         */
		public MessageRuleBuilder all() {
			return new MessageRuleBuilder(rules, versions, "*", "*");
		}

        /**
         * Applies {@link MessageRule}s for all trigger events of a given event type
         * @param eventType  event type, e.g. "ADT"
         * @return rule builder
         */
		public MessageRuleBuilder allOfEventType(String eventType) {
			return new MessageRuleBuilder(rules, versions, eventType, "*");
		}

	}

}
