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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;

/**
 * Default implementation of a message validator. If uses a {@link ValidationContext} to validate
 * the parsed or encoded message against.
 * 
 * @author Christian Ohr
 */
public class DefaultValidator implements Validator {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultValidator.class);
	private static final MessageRule[] EMPTY_MESSAGE_RULES_ARRAY = new MessageRule[0];
	private static final EncodingRule[] EMPTY_ENCODING_RULES_ARRAY = new EncodingRule[0];

	private ValidationContext context;

	public DefaultValidator(HapiContext context) {
		this.context = context.getDefaultValidationContext();
	}
	
	public DefaultValidator(ValidationContext context) {
		this.context = context;
	}

	/**
	 * Calls {@link #initializeHandler()} to obtain a default instance of a
	 * {@link ValidationExceptionHandler} before starting the validation.
	 * 
	 * @see ca.uhn.hl7v2.validation.Validator#validate(ca.uhn.hl7v2.model.Message)
	 */
	public boolean validate(Message message) throws HL7Exception {
		return validate(message, initializeHandler());
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Validator#validate(ca.uhn.hl7v2.model.Message,
	 *      ca.uhn.hl7v2.validation.ValidationExceptionHandler)
	 */
	public boolean validate(Message message, ValidationExceptionHandler handler)
			throws HL7Exception {
		if (message == null) {
			throw new NullPointerException("Message may not be null");
		}
		if (handler == null) {
			throw new NullPointerException("ValidationExceptionHandler may not be null");
		}
		Terser t = new Terser(message);
		MessageRule[] rules = EMPTY_MESSAGE_RULES_ARRAY;
		if (context != null) {
			rules = context.getMessageRules(message.getVersion(), t.get("MSH-9-1"),
					t.get("MSH-9-2"));
		}
		LOG.debug("Validating message against {} message rules", rules.length);
		for (MessageRule rule : rules) {
			ValidationException[] ex = rule.test(message);
			if (ex != null && ex.length > 0) {
				handler.onValidationExceptions(ex);
			}
		}
		return handler.validationPassed();
	}

	/**
	 * Calls {@link #initializeHandler()} to obtain a default instance of a
	 * {@link ValidationExceptionHandler} before starting the validation.
	 * 
	 * @see ca.uhn.hl7v2.validation.Validator#validate(Message, ValidationExceptionHandler)
	 */
	public boolean validate(String message, boolean isXML, String version) throws HL7Exception {
		return validate(message, isXML, version, initializeHandler());
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Validator#validate(java.lang.String, boolean, java.lang.String,
	 *      ca.uhn.hl7v2.validation.ValidationExceptionHandler)
	 */
	public boolean validate(String message, boolean isXML, String version,
			ValidationExceptionHandler handler) throws HL7Exception {
		if (message == null) {
			throw new NullPointerException("Message may not be null");
		}
		if (handler == null) {
			throw new NullPointerException("ValidationExceptionHandler may not be null");
		}
		EncodingRule[] rules = EMPTY_ENCODING_RULES_ARRAY;
		if (context != null) {
			rules = context.getEncodingRules(version, isXML ? "XML" : "ER7");
		}
		LOG.debug("Validating message against {} encoding rules", rules.length);
		for (EncodingRule rule : rules) {
			ValidationException[] ex = rule.test(message);
			if (ex != null && ex.length > 0) {
				handler.onValidationExceptions(ex);
			}
		}
		return handler.validationPassed();
	}
	
	public ValidationContext getValidationContext() {
		return context;
	}

	/**
	 * @return a new instance of a default {@link ValidationExceptionHandler}. Only called when no
	 *         explicit {@link ValidationExceptionHandler} has been provided for validation.
	 */
	protected ValidationExceptionHandler initializeHandler() {
		return new DefaultValidationExceptionHandler();
	}

}
