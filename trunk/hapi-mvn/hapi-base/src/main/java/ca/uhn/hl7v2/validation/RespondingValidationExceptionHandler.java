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

import static ca.uhn.hl7v2.Version.V25;
import static ca.uhn.hl7v2.Version.versionOf;

import java.io.IOException;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.ValidationException.ErrorCode;

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

	private String successAcknowledgementCode = "AA";
	private String errorAcknowledgementCode = "AE";

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
	public void setSuccessAcknowledgementCode(String successAcknowledgementCode) {
		this.successAcknowledgementCode = successAcknowledgementCode;
	}

	/**
	 * 
	 * Set acknowledgment code (AR, AE ,CR, CE) in case validation passes.
	 * 
	 * @param errorAcknowledgementCode (AR, AE ,CR, CE)
	 */
	public void setErrorAcknowledgementCode(String errorAcknowledgementCode) {
		this.errorAcknowledgementCode = errorAcknowledgementCode;
	}

	public String getSuccessAcknowledgementCode() {
		return successAcknowledgementCode;
	}

	public String getErrorAcknowledgementCode() {
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
		// Fill MSA/ERR segment
		if (V25.isGreaterThan(versionOf(response.getVersion()))) {
			fillSegmentsBefore25(response, exceptions);
		} else {
			fillSegmentsAsOf25(response, exceptions);
		}
	}

	/**
	 * Fill segments for HL7 versions 2.5 or newer.
	 * <p>
	 * HL7 versions before 2.5 require to set MSA-1. The ERR segment has various fields (ERR-2,
	 * ERR-3) containing details about the exception. ERR-1 is marked as obsolete.
	 * 
	 * @param response the raw response message
	 * @param exceptions exceptions encountered during validation
	 * @throws HL7Exception
	 */
	protected void fillSegmentsAsOf25(Message response, List<ValidationException> exceptions)
			throws HL7Exception {
		Segment msa = (Segment) response.get("MSA");
		Terser.set(msa, 1, 0, 1, 1, getErrorAcknowledgementCode());
		int repetition = 0;
		for (ValidationException exception : exceptions) {
			Segment err = (Segment) response.get("ERR", repetition);
			Location l = exception.getLocation();
			if (l.getSegmentName() != null)
				Terser.set(err, 2, 0, 1, 1, l.getSegmentName());
			if (l.getField() > 0)
				Terser.set(err, 2, 0, 3, 1, Integer.toString(l.getField()));
			if (l.getFieldRepetition() > 0)
				Terser.set(err, 2, 0, 4, 1, Integer.toString(l.getFieldRepetition()));
			if (l.getComponent() > 0)
				Terser.set(err, 2, 0, 5, 1, Integer.toString(l.getComponent()));
			if (l.getSubcomponent() > 0)
				Terser.set(err, 2, 0, 6, 1, Integer.toString(l.getSubcomponent()));
			Terser.set(err, 3, 0, 1, 1, Integer.toString(exception.getErrorCode().getCode()));
			Terser.set(err, 3, 0, 2, 1, exception.getErrorCode().getMessage());
			Terser.set(err, 3, 0, 3, 1, ErrorCode.errorCodeTable());
			Terser.set(err, 3, 0, 9, 1, exception.getMessage());
			repetition++;
		}
	}

	/**
	 * Fill segments for HL7 versions before 2.5.
	 * <p>
	 * HL7 versions before 2.5 require to set MSA-1 and MSA-3. The ERR segment only has one
	 * repeatable field (ERR-1) with components containing details about the exception.
	 * 
	 * @param response the raw response message
	 * @param exceptions exceptions encountered during validation
	 * @throws HL7Exception
	 */
	protected void fillSegmentsBefore25(Message response, List<ValidationException> exceptions)
			throws HL7Exception {
		Segment msa = (Segment) response.get("MSA");
		Terser.set(msa, 1, 0, 1, 1, getErrorAcknowledgementCode());
		Terser.set(msa, 3, 0, 1, 1, "Message validation failed");
		int repetition = 0;
		Segment err = (Segment) response.get("ERR");
		for (ValidationException exception : exceptions) {
			Location l = exception.getLocation();
			if (l.getSegmentName() != null)
				Terser.set(err, 1, repetition, 1, 1, l.getSegmentName());
			if (l.getField() > 0)
				Terser.set(err, 1, repetition, 3, 1, Integer.toString(l.getField()));
			Terser.set(err, 1, repetition, 4, 1,
					Integer.toString(exception.getErrorCode().getCode()));
			Terser.set(err, 1, repetition, 4, 2, exception.getErrorCode().getMessage());
			Terser.set(err, 1, repetition, 4, 3, ErrorCode.errorCodeTable());
			Terser.set(err, 1, repetition, 4, 5, exception.getMessage());
			repetition++;
		}
	}
}
