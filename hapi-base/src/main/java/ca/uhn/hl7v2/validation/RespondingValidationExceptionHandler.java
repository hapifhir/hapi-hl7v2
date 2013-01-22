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
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Severity;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.util.DeepCopy;

/**
 * ValidationExceptionHandler that generates response messages as statically
 * configured and based on the outcome of a validation process. Aspects of
 * creating and populating the response message can be overwritten in
 * subclasses.
 * <p>
 * This handler (or a subclass thereof) can be used for validation if a
 * response message must be generated upon the validation result.
 * 
 * @author Christian Ohr
 */
public class RespondingValidationExceptionHandler extends
        CollectingValidationExceptionHandler<Message> implements
        ValidationExceptionHandlerFactory<Message> {

    private AcknowledgmentCode successAcknowledgementCode = AcknowledgmentCode.AA;
    private AcknowledgmentCode errorAcknowledgementCode = AcknowledgmentCode.AE;

    /**
     * @param context Hapi context
     */
    public RespondingValidationExceptionHandler(HapiContext context) {
        super(context);
    }

    /**
     * Returns the generated response message.
     * 
     * @return the generated response
     * @throws HL7Exception if no response could be generated
     * @see {@link #generateResponseMessage(Object)}
     * @see {@link #populateResponseMessage(ca.uhn.hl7v2.model.Message)}
     * 
     */
    public final Message result() throws HL7Exception {
        Object validationSubject = getValidationSubject();
        if (validationSubject == null) {
            throw new HL7Exception("Need non-null validation subject");
        }
        Message response = generateResponseMessage(validationSubject);
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
     * Set acknowledgment code (AR, AE ,CR, CE) in case validation passes.
     * 
     * @param errorAcknowledgementCode (AR, AE ,CR, CE)
     */
    public void setErrorAcknowledgementCode(AcknowledgmentCode errorAcknowledgementCode) {
        this.errorAcknowledgementCode = errorAcknowledgementCode;
    }

    /**
     * @return the acknowledgement code if validation has succeeded. Default is AA.
     */
    public AcknowledgmentCode getSuccessAcknowledgementCode() {
        return successAcknowledgementCode;
    }

    /**
     * @return the acknowledgement code if validation has failed. Default is AE.
     */
    public AcknowledgmentCode getErrorAcknowledgementCode() {
        return errorAcknowledgementCode;
    }

    /**
     * Generates an empty response message. This class generates an
     * ACKnowledgement using the code returned by {@link #getSuccessAcknowledgementCode()}.
     * 
     * @param request request message, either a {@link String} or a
     *            {@link Message}
     * @return acknowledgment to the request
     * @throws HL7Exception
     */
    protected Message generateResponseMessage(Object request) throws HL7Exception {
        try {
            Message in;
            if (request instanceof String) {
                Segment s = getHapiContext().getGenericParser().getCriticalResponseData(
                        (String)request);
                in = s.getMessage();
                DeepCopy.copy(s, (Segment) in.get("MSH"));
            } else if (request instanceof Message) {
                in = (Message) request;
            } else {
                throw new HL7Exception("Validated message must be either Message or String");
            }
            return in.generateACK(getSuccessAcknowledgementCode(), null);

        } catch (IOException e) {
            throw new HL7Exception(e);
        }
    }

    /**
     * Populates the generated response based on the collected
     * {@link ValidationException}s. In case of exceptions, each exception will
     * cause an entry in one or more ERR segments.
     * 
     * @param response response message to be populated
     * @throws HL7Exception
     */
    protected void populateResponseMessage(Message response) throws HL7Exception {
        if (response == null)
            return;
        List<ValidationException> exceptions = getExceptions();
        for (int i = 0; i < exceptions.size(); i++) {
            ValidationException ve = exceptions.get(i);
            // TODO respect minimumSeverity here?
            if (ve.getSeverity() == Severity.ERROR) {
               ve.populateResponse(response, getErrorAcknowledgementCode(), i);
            }
        }
    }

    public ValidationExceptionHandler<Message> getNewInstance(HapiContext context) {
        return new RespondingValidationExceptionHandler(context);
    }

}
