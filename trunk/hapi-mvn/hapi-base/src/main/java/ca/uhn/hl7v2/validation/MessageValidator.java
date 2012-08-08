/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MessageValidator.java".  Description: 
"Validates parsed message against MessageRules that are enabled according to runtime 
 configuration information."
 
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
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * Validation utilities for parsed and encoded messages. The default
 * {@link ValidationExceptionHandler} logs all {@link ValidationException}s and throws a
 * {@link HL7Exception} if {@link #throwOnError} has been set to <code>true</code>.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class MessageValidator extends DefaultValidator {

	private static final Logger LOG = LoggerFactory.getLogger(MessageValidator.class);
	private boolean throwOnError = false;

	
	public MessageValidator(HapiContext context) {
		super(context);
	}

	public MessageValidator(ValidationContext context) {
		this(context, false);
	}
	
	public MessageValidator(ValidationRuleBuilder builder) {
		super(builder);
	}
	
	public MessageValidator(ValidationRuleBuilder builder, boolean theFailOnErrorFlag) {
		this(builder);
		throwOnError = theFailOnErrorFlag;
	}	

	/**
	 * @param theContext context that determines which validation rules apply
	 * @param theFailOnErrorFlag
	 */
	public MessageValidator(ValidationContext theContext, boolean theFailOnErrorFlag) {
		super(theContext);
		throwOnError = theFailOnErrorFlag;
	}

	@Override
	protected ValidationExceptionHandler initializeHandler() {
		return new FirstExceptionThrowingHandler();
	}

	private class FirstExceptionThrowingHandler implements ValidationExceptionHandler {

		private ValidationException firstException;

		public void onValidationExceptions(ValidationException[] exceptions) {
			for (ValidationException ve : exceptions) {
				LOG.error("Invalid message", ve);
				if (firstException == null) {
					firstException = ve;
				}
			}
		}

		public boolean validationPassed() throws HL7Exception {
			if (failed() && throwOnError) {
				throw new HL7Exception(firstException.getMessage(), firstException);
			}
			return !failed();
		}

		private boolean failed() {
			return firstException != null;
		}

	}
}
