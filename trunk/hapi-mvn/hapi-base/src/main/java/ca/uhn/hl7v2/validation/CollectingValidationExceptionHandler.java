/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "CollectingValidationExceptionHandler.java".  Description: 
"ValidationExceptionHandler that collects exceptions" 

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Severity;

/**
 * ValidationExceptionHandler that collects all {@link ValidationException}s in a list.
 * Subclasses can then derive a overall {@link #result() result} from this list.
 *
 * @author Christian Ohr
 * 
 */
public abstract class CollectingValidationExceptionHandler<R> extends AbstractValidationExceptionHandler<R> {

	private List<ValidationException> exceptions = new ArrayList<ValidationException>();
    private Severity minimumSeverityToCollect = Severity.ERROR;

    /**
     * @param context Hapi context
     */
    public CollectingValidationExceptionHandler(HapiContext context) {
        super(context);
    }

    @Override
    public void error(ValidationException exception) {
        if (isSeverityAtLeast(Severity.ERROR)) exceptions.add(exception);
    }

    @Override
    public void info(ValidationException exception) {
        if (isSeverityAtLeast(Severity.INFO)) exceptions.add(exception);
    }

    @Override
    public void warning(ValidationException exception) {
        if (isSeverityAtLeast(Severity.WARNING)) exceptions.add(exception);
    }

    private boolean isSeverityAtLeast(Severity s) {
        return s.compareTo(getMinimumSeverityToCollect()) >= 0;
    }

    /**
	 * @return unmodifiable list of collected exceptions. If none have occurred, the list is empty.
	 */
	public List<ValidationException> getExceptions() {
		return Collections.unmodifiableList(exceptions);
	}

    /**
     * Set the minimum severity to be added to the list of exceptions. Default is ERROR.
     * @param minimumSeverityToCollect the minimum severity to be added to the list of exceptions
     */
    public void setMinimumSeverityToCollect(Severity minimumSeverityToCollect) {
        this.minimumSeverityToCollect = minimumSeverityToCollect;
    }

    /**
     * @return the minimum severity to be added to the list of exceptions. Default is ERROR.
     */
    public Severity getMinimumSeverityToCollect() {
        return minimumSeverityToCollect;
    }

    /**
     * @see ca.uhn.hl7v2.validation.ValidationExceptionHandler#hasFailed()
     */
    public boolean hasFailed() {
        for (ValidationException ve : exceptions) {
            if (ve.getSeverity() == Severity.ERROR) return true;
        }
        return false;
    }
	
	

}
