/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "ChoiceElementsRespectedRule.java ".  Description:
 "Message rule enforcing that one choice element is present"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

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

					if (nextIsChoiceElement && !nextStruct.isEmpty()) {
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
