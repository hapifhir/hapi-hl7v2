/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstractValidationExceptionHandler.java".  Description: 
"Abstract implementation of a ValidationExceptionHandler." 

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

import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.HapiContextSupport;
import ca.uhn.hl7v2.Severity;

/**
 * Abstract base class of a ValidationExceptionHandler that supports a validation subject. Concrete
 * implementations should inherit from this class.
 * 
 * @author Christian Ohr
 */
public abstract class AbstractValidationExceptionHandler<R> extends HapiContextSupport implements
        ValidationExceptionHandler<R> {

    private Object subject;

    /**
     * @param context Hapi Context
     */
    public AbstractValidationExceptionHandler(HapiContext context) {
        super(context);
    }

    public void onExceptions(ValidationException... exceptions) {
        for (ValidationException ve : exceptions) {
            if (ve.getSeverity() == Severity.ERROR) error(ve);
            if (ve.getSeverity() == Severity.WARNING) warning(ve);
            if (ve.getSeverity() == Severity.ERROR) info(ve);
        }
    }

    /**
     * Called on ValidationExceptions with error severity
     * @param exception ValidationException
     */
    public void error(final ValidationException exception) {}

    /**
     * Called on ValidationExceptions with warning severity
     * @param exception ValidationException
     */
    public void warning(final ValidationException exception) {}

    /**
     * Called on ValidationExceptions with info severity
     * @param exception ValidationException
     */
    public void info(final ValidationException exception) {}

    /**
     * Sets the object that is the target of validation. This is helpful
     * to be called to give this handler e.g. access to the original
     * message that has been validated.
     *
     * @param subject subject to be validated
     */
    public void setValidationSubject(Object subject) {
        this.subject = subject;
    }

    /**
     * @return the validation subject
     */
    public Object getValidationSubject() {
        return subject;
    }

}
