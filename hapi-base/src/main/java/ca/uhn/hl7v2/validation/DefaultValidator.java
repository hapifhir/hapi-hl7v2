/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultValidator.java".  Description: 
"Default implementation of a message validator." 

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
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * Default implementation of a message validator.
 * 
 * @param <R> The type parameter R denotes the result type of the validation
 *            process.
 * 
 * @author Christian Ohr
 */
public class DefaultValidator<R> extends AbstractValidator<R> {

    private HapiContext context;

    public DefaultValidator(HapiContext context) {
        super();
        this.context = context;
    }

    public DefaultValidator(ValidationContext validationContext) {
        this(new DefaultHapiContext(validationContext));
    }

    public DefaultValidator(ValidationRuleBuilder builder) {
        this(new DefaultHapiContext(builder));
    }

    public ValidationContext getValidationContext() {
        return context.getValidationContext();
    }

    /**
     * Returns a new instance of a default {@link ValidationExceptionHandler}
     * created by the {@link ValidationExceptionHandlerFactory} as returned by
     * {@link HapiContext}. Only called when no explicit
     * {@link ValidationExceptionHandler} has been provided for validation using
     * {@link #validate(Message, ValidationExceptionHandler)}.
     * 
     * @return a new instance of a {@link ValidationExceptionHandler}
     */
    protected ValidationExceptionHandler<R> initializeHandler() {
        ValidationExceptionHandlerFactory<R> validationExceptionHandlerFactory = context
                .getValidationExceptionHandlerFactory();
        return validationExceptionHandlerFactory.getNewInstance(context);
    }

}
