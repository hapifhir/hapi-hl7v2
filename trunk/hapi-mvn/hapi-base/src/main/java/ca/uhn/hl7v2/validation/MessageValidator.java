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

/**
 * Validation utilities for parsed and encoded messages. The
 * {@link ValidationExceptionHandler} logs all {@link ValidationException}s and
 * throws a {@link ca.uhn.hl7v2.HL7Exception HL7Exception} if {@link #theFailOnErrorFlag} has been set to
 * <code>true</code>.
 * <p>
 * This class is kept for backwards compatibility.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class MessageValidator extends AbstractValidator<Boolean> {

	private boolean theFailOnErrorFlag;
	private ValidationContext validationContext;

	public MessageValidator(ValidationContext context) {
		this(context, false);
	}

	/**
	 * @param theContext context that determines which validation rules apply
	 * @param theFailOnErrorFlag true if an exception shall be thrown on validation errors
	 */
	public MessageValidator(ValidationContext theContext, boolean theFailOnErrorFlag) {
		super();
		this.validationContext = theContext;
		this.theFailOnErrorFlag = theFailOnErrorFlag;
	}

	/**
	 * For backwards compatibility, always returns a new instance of
	 * {@link ReportingValidationExceptionHandler}
	 */
	@Override
	protected ValidationExceptionHandler<Boolean> initializeHandler() {
		return new ReportingValidationExceptionHandler(theFailOnErrorFlag);
	}

	@Override
	protected ValidationContext getValidationContext() {
		return validationContext;
	}

}
