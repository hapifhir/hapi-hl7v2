/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MessageRuleBuilder.java".  Description: 
"Rule Builder for MessageRules." 

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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.util.ReadOnlyMessageIterator;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * Rule Builder for MessageRules
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class MessageRuleBuilder extends RuleTypeBuilder<MessageRule> {

	private String messageType;
	private String triggerEvent;

	protected MessageRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules, Version[] versions,
			String messageType, String triggerEvent) {
		super(rules, versions);
		this.messageType = messageType;
		this.triggerEvent = triggerEvent;
	}

	/**
	 * Builds a {@link MessageRule} that extracts a primitive value using a {@link Terser}
	 * expression and evaluates the specified {@link Predicate}.
	 * 
	 * @param spec Terser expression
	 * @param predicate Predicate to evaluate against the value
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder terser(String spec, Predicate predicate) {
		return test(new TerserMessageRule(spec, predicate));
	}

	/**
	 * Builds a {@link MessageRule} that disallows the existence of {@link GenericSegment}s, i.e.
	 * segments that are not defined in the structure of a message.
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder onlyKnownSegments() {
		return test(ONLY_KNOWN_SEGMENTS);
	}

	/**
	 * Builds a {@link MessageRule} that evaluates the message against the Conformance Profile
	 * referred to in MSH-21.
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder conformance() {
		return conformance(null);
	}

	/**
	 * Builds a {@link MessageRule} that evaluates the message against the Conformance Profile
	 * referred to by the profileId parameter
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder conformance(String profileId) {
		return description("Unknown segments found in message").test(
				new ConformanceProfileRule(profileId));
	}

	/**
	 * Adds the specified rule to the set of rules.
	 * 
	 * @param rule
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder test(MessageRule rule) {
		addRuleBindings(rule);
		return this;
	}

	/**
	 * Adds a description to the rule
	 * 
	 * @param description
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Adds a HL7 section reference to a rule
	 * 
	 * @param sectionReference
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder refersToSection(String sectionReference) {
		this.sectionReference = sectionReference;
		return this;
	}

	@Override
	protected Collection<RuleBinding<MessageRule>> getRuleBindings(MessageRule rule, String version) {
		RuleBinding<MessageRule> binding = new MessageRuleBinding(version, messageType,
				triggerEvent, rule);
		return Collections.singletonList(binding);
	}

	private class TerserMessageRule extends PredicateMessageRule {

		TerserMessageRule(String terserExpression, Predicate predicate) {
			super(predicate, new TerserExpression(terserExpression));
		}

	}

	private static final MessageRule ONLY_KNOWN_SEGMENTS = new OnlyKnownSegmentsRule();

	private static class OnlyKnownSegmentsRule extends AbstractMessageRule {

		public ValidationException[] apply(Message msg) {
			List<ValidationException> exceptions = new ArrayList<ValidationException>();

			for (Iterator<Structure> iter = ReadOnlyMessageIterator
					.createPopulatedStructureIterator(msg, GenericSegment.class); iter.hasNext();) {
				exceptions.add(new ValidationException("Found unknown segment; "
						+ iter.next().getName()));
			}
			return exceptions.toArray(new ValidationException[exceptions.size()]);
		}

	}

}
