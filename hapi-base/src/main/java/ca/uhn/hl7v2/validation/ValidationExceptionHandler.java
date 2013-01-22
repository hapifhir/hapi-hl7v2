/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationExceptionHandler.java".  Description: 
"Interface for handling violations during the validation process." 

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
package ca.uhn.hl7v2.validation;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Handler that is called for every violation during a message validation.
 * <p>
 * Instances of this class are NOT thread safe as they collect data during the
 * validation process.
 * 
 * @author Christian Ohr
 */
public interface ValidationExceptionHandler<R> {

    /**
     * Called in case of validation rule violations.
     * @param exceptions the exceptions that describe the validatin errors
     */
    void onExceptions(ValidationException... exceptions);

    /**
     * Returns an overall validation result based on an aggregation of all
     * exceptions thrown during the validation process. Often, this is a simple
     * value indicating if any ValidationException has been thrown, but it can
     * also be a complete response message that reflects the validation results.
     *
     * @return the validation result
     * @throws HL7Exception if an error occurred during calculating the result
     */
    R result() throws HL7Exception;

	/**
	 * Should be called before validation starts. Some ValidationHandler implementations
	 * may need context information of the subject being validated
	 * 
	 * @param subject subject to be validated
	 */
	void setValidationSubject(Object subject);

    /**
     * Returns a boolean flag indicating whether a validation was successful or not.
     * This is independent of {@link #result()} which may return a more complex
     * object.
     * @return true if the validation is considered to be failed.
     */
	boolean hasFailed();

}
