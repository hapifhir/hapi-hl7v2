/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "RespondingValidationExceptionHandler.java".  Description: 
"ValidationExceptionHandler that generates response messages" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation;

import java.io.IOException;
import java.util.List;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

/**
 * ValidationExceptionHandler that generates response messages as statically configured and based on
 * the outcome of a validation process. Aspects of creating and populating the response message can
 * be overwritten in subclasses.
 * <p>
 * This handler (or a subclass thereof) should be used for validation if a response message must be
 * generated upon the validation result.
 * 
 * @author Christian Ohr
 */
public class RespondingValidationExceptionHandler extends CollectingValidationExceptionHandler {

	private AcknowledgmentCode successAcknowledgementCode = AcknowledgmentCode.AA;
	private AcknowledgmentCode errorAcknowledgementCode = AcknowledgmentCode.AE;

	/**
	 * Returns the generated response message.
	 * 
	 * @return the generated response
	 * 
	 * @see {@link #generateResponseMessage()}
	 * @see {@link #populateResponseMessage()}
	 * 
	 * @throws HL7Exception if no response could be generated
	 * @throws IOException if the response message could not be created due to failures in the
	 *             message id generation strategy
	 */
	public final Message getResponse() throws HL7Exception, IOException {
		if (subject == null || !(subject instanceof Message)) {
			throw new HL7Exception("Need valid " + Message.class.getName()
					+ " instance in order to generate a response");
		}
		Message response = generateResponseMessage((Message)subject);
		populateResponseMessage(response);
		return response;
	}

	/**
	 * Set acknowledgment code (AA,CA) in case validation passes.
	 * 
	 * @param successAcknowledgementCode (AA, CA)
	 */
	public void setSuccessAcknowledgementCode(AcknowledgmentCode successAcknowledgementCode) {
		this.successAcknowledgementCode = successAcknowledgementCode;
	}

	/**
	 * 
	 * Set acknowledgment code (AR, AE ,CR, CE) in case validation passes.
	 * 
	 * @param errorAcknowledgementCode (AR, AE ,CR, CE)
	 */
	public void setErrorAcknowledgementCode(AcknowledgmentCode errorAcknowledgementCode) {
		this.errorAcknowledgementCode = errorAcknowledgementCode;
	}

	public AcknowledgmentCode getSuccessAcknowledgementCode() {
		return successAcknowledgementCode;
	}

	public AcknowledgmentCode getErrorAcknowledgementCode() {
		return errorAcknowledgementCode;
	}

	/**
	 * Generates an empty response based on the {@link #getRequest() request} message. This class
	 * generates an ACKnowledgement using the code returned by
	 * {@link #getSuccessAcknowledgementCode()}.
	 * 
	 * @return acknowledgment to the request
	 * @throws HL7Exception
	 * @throws IOException
	 */
	protected Message generateResponseMessage(Message request) throws HL7Exception, IOException {
		return request.generateACK(getSuccessAcknowledgementCode(), null);
	}

	/**
	 * Populates the generated response based on the collected {@link ValidationException}s. In case
	 * of exceptions, each exception will cause an entry in one or more ERR segments.
	 * 
	 * @param response
	 * @throws HL7Exception
	 * @throws IOException
	 */
	protected void populateResponseMessage(Message response) throws HL7Exception, IOException {
		List<ValidationException> exceptions = getExceptions();
		// No exceptions - just return response, MSA-1 is already set
		if (exceptions.isEmpty()) {
			return;
		}
		for (int i = 0; i < exceptions.size(); i++) {
			exceptions.get(i).populateResponse(response, getErrorAcknowledgementCode(), i);
		}
	}

}
