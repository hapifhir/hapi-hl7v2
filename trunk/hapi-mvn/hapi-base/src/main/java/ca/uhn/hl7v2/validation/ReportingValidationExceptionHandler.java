/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ReportingValidationExceptionHandler.java".  Description: 
"ValidationExceptionHandler that logs exceptions" 

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;

/**
 * ValidationExceptionHandler that logs all {@link ValidationException}s and
 * optionally throws the first one wrapped in a {@link HL7Exception}.
 * <p>
 * The mimics the behavior of the {@link MessageValidator} of previous releases.
 * 
 * @author Christian Ohr
 * 
 */
public class ReportingValidationExceptionHandler implements ValidationExceptionHandler<Boolean>,
        ValidationExceptionHandlerFactory<Boolean> {

    private static final Logger LOG = LoggerFactory
            .getLogger(ReportingValidationExceptionHandler.class);
    private boolean throwFirstException;
    private ValidationException firstException;

    /**
     * @param throwFirstException true if first exception shall be thrown
     */
    public ReportingValidationExceptionHandler(boolean throwFirstException) {
        this.throwFirstException = throwFirstException;
    }

    /**
     * Logs all exceptions
     * 
     * @see ca.uhn.hl7v2.validation.CollectingValidationExceptionHandler#onExceptions(ca.uhn.hl7v2.validation.ValidationException[])
     */
    public void onExceptions(ValidationException... exceptions) {
        if (firstException == null)
            firstException = exceptions[0];
        for (ValidationException ve : exceptions) {
            switch (ve.getSeverity()) {
                case ERROR : LOG.error("Invalid message", ve);
                case WARNING: LOG.warn("Message with warnings", ve);
                case INFO: LOG.info("Message with comments", ve);
            }
        }
    }

    /**
     * If the validation failed, throws Exception or returns <code>false</code>,
     * depending on {link {@link #throwFirstException}.
     * 
     * @throws HL7Exception if validation has failed and
     *             {@link #throwFirstException} is true
     * @see ca.uhn.hl7v2.validation.DefaultValidationExceptionHandler#result()
     */
    public Boolean result() throws HL7Exception {
        if (hasFailed() && throwFirstException)
            throw new HL7Exception(firstException.getMessage(), firstException);
        return !hasFailed();
    }

    public boolean hasFailed() {
        return firstException != null;
    }

    public ValidationExceptionHandler<Boolean> getNewInstance(HapiContext context) {
        return new ReportingValidationExceptionHandler(throwFirstException);
    }

    /**
     * Does nothing
     */
    public void setValidationSubject(Object subject) {
    }
    
    

}