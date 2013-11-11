/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "RuleSupport.java".  Description: 
"Generic methods for validation rules" 

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
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.Severity;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationException;

@SuppressWarnings("serial")
public abstract class RuleSupport<T> implements Rule<T> {

	private static final ValidationException[] PASSED = new ValidationException[0];
    private Severity severity = Severity.ERROR;
    private String description;
    private String sectionReference;
    private ErrorCode errorCode = ErrorCode.APPLICATION_INTERNAL_ERROR;

	protected ValidationException[] result(boolean result, Object value) {
		return result(result, value, Location.UNKNOWN);
	}
	
	protected ValidationException[] result(boolean result, Object value, Location location) {
		return result ? passed() : failedWithValue(value, location);
	}	

	protected ValidationException[] passed() {
		return PASSED;
	}

	protected ValidationException[] failedWithValue(Object value, Location location) {
		String description = getDescription();
		String msg = String.format(description, String.valueOf(value));
		return failed("Validation failed: " + msg, location);
	}

	protected ValidationException[] failed(String msg) {
		return failed(msg, Location.UNKNOWN);
	}

	
	protected ValidationException[] failed(String msg, Location location) {
		ValidationException ve = new ValidationException(msg, severity);
		ve.setError(getErrorCode());
		ve.setLocation(location);
		return new ValidationException[] { ve };
	}

	protected ValidationException[] failed(Exception e) {
		return failed(e, Location.UNKNOWN);
	}

	protected ValidationException[] failed(Exception e, Location location) {
		if (e instanceof ValidationException)
			return new ValidationException[] { (ValidationException) e };
		ValidationException ve = new ValidationException(e.getMessage(), e, severity);
		ve.setError(getErrorCode());
		ve.setLocation(location);
		return new ValidationException[] { ve };
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
	 */
	public String getSectionReference() {
		return sectionReference;
	}

    /**
     * @see ca.uhn.hl7v2.validation.Rule#getDescription()
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the severity if this rule fails
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
	 * @return the error code to be used in case the validation failed
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSectionReference(String sectionReference) {
        this.sectionReference = sectionReference;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
