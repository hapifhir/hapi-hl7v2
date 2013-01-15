/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "OnlyKnownSegmentsRule.java".  Description: 
"Validation rule for detecting unknown Segments in a message" 

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
package ca.uhn.hl7v2.validation.builder.support;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.SuperStructure;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;

/**
 * Validation rule for detecting populated elements in a {@link SuperStructure}
 * which do not belong to the given message type
 * 
 * @author James Agnew
 */
@SuppressWarnings("serial")
public class OnlyAllowableSegmentsInSuperstructureRule extends AbstractMessageRule {

	public static final MessageRule ONLY_ALLOWABLE_SEGMENTS = new OnlyAllowableSegmentsInSuperstructureRule();
	
	public ValidationException[] apply(Message msg) {
		List<ValidationException> exceptions = new ArrayList<ValidationException>();
		
		if (msg instanceof SuperStructure) {
			checkStructure((SuperStructure)msg, exceptions);
		}
		
		return exceptions.toArray(new ValidationException[exceptions.size()]);
	}

	private void checkStructure(SuperStructure theMsg, List<ValidationException> theExceptions) {
		String messageStructure = theMsg.getMessage().getName();

		FORNAME:
		for (String name : theMsg.getNames()) {
			
			try {
				for (Structure rep : theMsg.getAll(name)) {
					
					if (!rep.isEmpty()) {
						if (!theMsg.getStructuresWhichChildAppliesTo(name).contains(messageStructure)) {
							String msgSimpleName = theMsg.getMessage().getClass().getSimpleName();
							theExceptions.add(new ValidationException("Message (superstructure " + msgSimpleName + ") of type " + messageStructure + " must not have content in " + name));
						}
						continue FORNAME;
					}
					
				}
			} catch (HL7Exception e) {
				// should not happen
				throw new Error("Can't get rep of structure " + name + ". This is probably a HAPI bug");
			}
			
		}
	}

}