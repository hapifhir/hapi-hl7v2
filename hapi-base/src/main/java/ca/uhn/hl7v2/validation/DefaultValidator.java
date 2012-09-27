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

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.HapiContextSupport;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.util.ReadOnlyMessageIterator;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * Default implementation of a message validator. If uses a {@link ValidationContext} to validate
 * the parsed or encoded message against.
 * 
 * @author Christian Ohr
 */
public class DefaultValidator extends HapiContextSupport implements Validator {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultValidator.class);
	private static final MessageRule[] EMPTY_MESSAGE_RULES_ARRAY = new MessageRule[0];
	private static final EncodingRule[] EMPTY_ENCODING_RULES_ARRAY = new EncodingRule[0];
	private static final PrimitiveTypeRule[] EMPTY_PRIMITIVE_RULES_ARRAY = new PrimitiveTypeRule[0];

	public DefaultValidator(HapiContext context) {
		super(context);
	}

	public DefaultValidator(ValidationContext validationContext) {
		this(new DefaultHapiContext(validationContext));
	}

	public DefaultValidator(ValidationRuleBuilder builder) {
		this(new DefaultHapiContext(builder));
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
		handler.setValidationSubject(message);
		testPrimitiveRules(message, handler); // also test primitives?
		testMessageRules(message, handler);
		return handler.validationPassed();
	}

	private void testMessageRules(Message message, ValidationExceptionHandler handler)
			throws HL7Exception {
		Terser t = new Terser(message);
		String messageType = t.get("MSH-9-1");
		String triggerEvent = t.get("MSH-9-2");
		MessageRule[] rules = EMPTY_MESSAGE_RULES_ARRAY;
		if (getValidationContext() != null) {
			rules = getValidationContext().getMessageRules(message.getVersion(), messageType,
					triggerEvent);
		}
		LOG.debug("Validating message against {} message rules", rules.length);
		for (MessageRule rule : rules) {
			ValidationException[] ex = rule.apply(message);
			if (ex != null && ex.length > 0) {
				handler.onValidationExceptions(ex);
			}
		}
	}

	private void testPrimitiveRules(Message message, ValidationExceptionHandler handler)
			throws HL7Exception {
		LOG.debug("Validating message against primitive type rules");
		for (Iterator<Structure> iter = ReadOnlyMessageIterator
				.createPopulatedSegmentIterator(message); iter.hasNext();) {
			Segment s = (Segment) iter.next();
			for (int field = 1; field <= s.numFields(); field++) {
				Type[] t = s.getField(field);
				for (int rep = 0; rep < t.length; rep++) {
					Location location = new Location();
					location.setSegmentName(s.getName());
					location.setField(field);
					location.setFieldRepetition(rep);
					testType(t[rep], handler, location);
				}
			}
		}
	}

	private void testType(Type type, ValidationExceptionHandler handler, Location l) {
		if (type instanceof Composite) {
			Type[] components = ((Composite) type).getComponents();
			for (int comp = 0; comp < components.length; comp++) {
				Location location = new Location(l);
				location.setComponent(comp + 1);
				testComponent(components[comp], handler, location);
			}
		} else if (type instanceof Varies) {
			testType(((Varies) type).getData(), handler, l);
		} else {
			testPrimitive((Primitive) type, handler, l);
		}
	}

	private void testComponent(Type type, ValidationExceptionHandler handler, Location l) {
		if (type instanceof Composite) {
			Type[] component = ((Composite) type).getComponents();
			for (int sub = 0; sub < component.length; sub++) {
				Location location = new Location(l);
				location.setSubcomponent(sub + 1);
				testSubComponent(component[sub], handler, location);
			}
		} else if (type instanceof Varies) {
			testComponent(((Varies) type).getData(), handler, l);
		} else {
			testPrimitive((Primitive) type, handler, l);
		}
	}

	private void testSubComponent(Type type, ValidationExceptionHandler handler, Location l) {
		if (type instanceof Primitive) {
			testPrimitive((Primitive) type, handler, l);
		} else if (type instanceof Varies) {
			testSubComponent(((Varies) type).getData(), handler, l);
		}
	}

	private void testPrimitive(Primitive p, ValidationExceptionHandler handler, Location l) {
		PrimitiveTypeRule[] rules = EMPTY_PRIMITIVE_RULES_ARRAY;
		Message m = p.getMessage();
		if (getValidationContext() != null) {
			rules = getValidationContext().getPrimitiveRules(m.getVersion(), p.getName(), p);
		}
		for (PrimitiveTypeRule rule : rules) {
			ValidationException[] ex = rule.apply(p.getValue());
			for (int i = 0; i < ex.length; i++) {
				ex[i].setLocation(l);
			}
			if (ex != null && ex.length > 0) {
				handler.onValidationExceptions(ex);
			}
		}
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
		handler.setValidationSubject(message);
		EncodingRule[] rules = EMPTY_ENCODING_RULES_ARRAY;
		if (getValidationContext() != null) {
			rules = getValidationContext().getEncodingRules(version, isXML ? "XML" : "ER7");
		}
		LOG.debug("Validating message against {} encoding rules", rules.length);
		for (EncodingRule rule : rules) {
			ValidationException[] ex = rule.apply(message);
			if (ex != null && ex.length > 0) {
				handler.onValidationExceptions(ex);
			}
		}
		return handler.validationPassed();
	}

	public ValidationContext getValidationContext() {
		return getHapiContext().getValidationContext();
	}

	/**
	 * @return a new instance of a default {@link ValidationExceptionHandler} as specified in the
	 *         {@link HapiContext}. Only called when no explicit {@link ValidationExceptionHandler}
	 *         has been provided for validation using
	 *         {@link #validate(Message, ValidationExceptionHandler)}.
	 */
	protected ValidationExceptionHandler initializeHandler() {
		return getHapiContext().getValidationExceptionHandler();
	}

}
