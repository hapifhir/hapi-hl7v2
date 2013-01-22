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

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.SuperStructure;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.builder.support.ChoiceElementsRespectedRule;
import ca.uhn.hl7v2.validation.builder.support.OnlyAllowableSegmentsInSuperstructureRule;
import ca.uhn.hl7v2.validation.builder.support.OnlyKnownSegmentsRule;
import ca.uhn.hl7v2.validation.builder.support.TerserMessageRule;
import ca.uhn.hl7v2.validation.builder.support.WrongVersionRule;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * Rule Builder for MessageRules
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class MessageRuleBuilder extends RuleTypeBuilder<MessageRuleBuilder, MessageRule> {

	private String messageType;
	private String triggerEvent;

	protected MessageRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules, Set<Version> versions,
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
		return test(prepareRule(new TerserMessageRule(spec, predicate)));
	}

	/**
	 * Builds a {@link MessageRule} that disallows the existence of {@link GenericSegment}s, i.e.
	 * segments that are not defined in the structure of a message.
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder onlyKnownSegments() {
		return test(prepareRule(OnlyKnownSegmentsRule.ONLY_KNOWN_SEGMENTS));
	}

	/**
	 * Builds a {@link MessageRule} that disallows the existence of segments which
	 * are not alowed in a given message type when the message is an instance
	 * of {@link SuperStructure} (e.g. PID2 within an ADT^A01)
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder onlyAllowableSegmentsInSuperStructure() {
		return test(prepareRule(OnlyAllowableSegmentsInSuperstructureRule.ONLY_ALLOWABLE_SEGMENTS));
	}

	/**
	 * Builds a {@link MessageRule} that enforces choice elements. This means that
	 * if several segments are listed as being a possible choice for the first segment
	 * in a group, only one of them may have content.
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder choiceElementsRespected() {
		return test(prepareRule(ChoiceElementsRespectedRule.CHOICE_ELEMENTS_RESPECTED));
	}

	/**
	 * Builds a {@link MessageRule} that disallows the selected HL7 version(s). It is basically
	 * equivalent with:
	 * 
	 * <pre>
	 *    forAllVersions().message(....).terser("MSH-12", in(allowedVersions))
	 * </pre>
	 * 
	 * However, when using this specific rule the builder expression and the resulting exception
	 * message is more specific:
	 * 
	 * <pre>
	 * 	  forVersion().except(allowedVersions).message(...).wrongVersion()
	 * </pre>
	 * 
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder wrongVersion() {
		return test(prepareRule(WrongVersionRule.WRONG_VERSION));
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
     * @param profileId conformance profile id (file name)
	 * @return this instance to build more rules
	 */
	public MessageRuleBuilder conformance(String profileId) {
		return test(prepareRule(new ConformanceProfileRule(profileId)));
	}

	// for tests only
	String getMessageType() {
		return messageType;
	}

	// for tests only
	String getTriggerEvent() {
		return triggerEvent;
	}

	@Override
	protected Collection<RuleBinding<MessageRule>> getRuleBindings(MessageRule rule, String version) {
		RuleBinding<MessageRule> binding = new MessageRuleBinding(version, messageType,
				triggerEvent, rule);
		return activate(Collections.singletonList(binding));
	}

}
