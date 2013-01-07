package ca.uhn.hl7v2.validation.builder.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;

/**
 * Message rule which enforces that only one "choice element" within any groups
 * in the message must only have content within one of the possible choices.
 */
public class ChoiceElementsRespectedRule extends AbstractMessageRule {

	/** Singleton instance */
	public static final MessageRule CHOICE_ELEMENTS_RESPECTED = new ChoiceElementsRespectedRule();

	public ValidationException[] apply(Message theValue) {
		List<ValidationException> exceptions = new ArrayList<ValidationException>();
		apply(theValue, exceptions);
		return exceptions.toArray(new ValidationException[exceptions.size()]);
	}

	private void apply(Group theStructure, List<ValidationException> theExceptions) {
		Set<String> choicesWithContent = null;

		for (String nextName : theStructure.getNames()) {
			try {
				boolean nextIsChoiceElement = theStructure.isChoiceElement(nextName);
				for (Structure nextStruct : theStructure.getAll(nextName)) {

					if (nextIsChoiceElement && nextStruct.isEmpty() == false) {
						if (choicesWithContent == null) {
							choicesWithContent = new HashSet<String>();
						}
						choicesWithContent.add(nextName);
					}

					if (nextStruct instanceof Group) {
						apply((Group) nextStruct, theExceptions);
					}
				}
			} catch (HL7Exception e) {
				throw new Error("Failed to find " + nextName + " in structure. This is probably a HAPI bug.");
			}
		}

		if (choicesWithContent != null && choicesWithContent.size() > 1) {
			theExceptions.add(new ValidationException("Structure '" + theStructure.getName() + "' must have content only in one of the following choices: " + choicesWithContent.toString()));
		}

	}

}
