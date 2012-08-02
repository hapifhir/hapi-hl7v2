package ca.uhn.hl7v2.validation.impl.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.util.ReadOnlyMessageIterator;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * Defines message rules
 * 
 */
@SuppressWarnings("serial")
public class MessageRuleBuilder extends RuleTypeBuilder<MessageRule> {

	private String messageType;
	private String triggerEvent;

	protected MessageRuleBuilder(List<RuleBinding<? extends Rule>> rules, Version[] versions,
			String messageType, String triggerEvent) {
		super(rules, versions);
		this.messageType = messageType;
		this.triggerEvent = triggerEvent;
	}

	public MessageRuleBuilder terser(String spec, Predicate predicate) {
		return test(new TerserMessageRule(spec, predicate));
	}


	/**
	 * @return a {@link MessageRule} that disallows the existence of
	 *         {@link GenericSegment}s, i.e. segments that are not defined in
	 *         the structure of a message.
	 */
	public MessageRuleBuilder onlyKnownSegments() {
		return test(ONLY_KNOWN_SEGMENTS);
	}

	public MessageRuleBuilder conformance() {
		return conformance(null);
	}

	public MessageRuleBuilder conformance(String profileId) {
		return description("Unknown segments found in message")
				.test(new ConformanceProfileRule(profileId));
	}

	public MessageRuleBuilder test(MessageRule rule) {
		addRuleBindings(rule);
		return this;
	}

	/**
	 * Adds a description to a rule
	 */
	public MessageRuleBuilder description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Adds a HL7 section reference to a rule
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

		TerserMessageRule(final String terserExpression, Predicate predicate) {
			super(predicate, new Expression() {
				
				public Object evaluate(Message msg) throws HL7Exception {
					return new Terser(msg).get(terserExpression);
				}
			});
		}

	}

	private static final MessageRule ONLY_KNOWN_SEGMENTS = new OnlyKnownSegmentsRule();

	private static class OnlyKnownSegmentsRule extends AbstractMessageRule {

		public ValidationException[] test(Message msg) {
			List<ValidationException> exceptions = new ArrayList<ValidationException>();
			for (Iterator<Structure> iter = ReadOnlyMessageIterator
					.createPopulatedSegmentIterator(msg); iter.hasNext();) {
				Segment s = (Segment) iter.next();
				if (s instanceof GenericSegment) {
					exceptions
							.add(new ValidationException("Found unknown segment; " + s.getName()));
				}
			}
			return exceptions.toArray(new ValidationException[exceptions.size()]);
		}

	}

}
