/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultValidationExceptionHandler.java".  Description: 
"Basic implementation of a ValidationExceptionHandler." 

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

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;

/**
 * Simple implementation of a handler that just tracks if
 * {@link #onExceptions(ValidationException[])} has been called at least once.
 * 
 * @author Christian Ohr
 */
public class DefaultValidationExceptionHandler extends AbstractValidationExceptionHandler<Boolean> {

	private boolean result = true;

	public DefaultValidationExceptionHandler() {
        super(new DefaultHapiContext());
    }
	
    public DefaultValidationExceptionHandler(HapiContext context) {
        super(context);
    }

    /**
	 * If the validation process encounters a violation, this method is called.
	 * 
	 * @param exceptions a non-empty array of {@link ValidationException}s.
	 */
	public void onExceptions(ValidationException... exceptions) {
		result = false;
	}

	/**
	 * Called after the validation process. Should return an overall boolean validation result.
	 * 
	 * @return the overall assessment of the validation process. This method should usually return
	 *         <code>false</code> if {@link #onExceptions(ValidationException[])} has been
	 *         called at least once.
	 * @throws HL7Exception
	 * 
	 * @see {@link DefaultValidationExceptionHandler}
	 */
	public Boolean result() throws HL7Exception {
		return result;
	}

    public boolean hasFailed() {
        return !result;
    }
	
	
}