/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MessageValidation.java".  Description:
 * "Example Code"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): James Agnew
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.DefaultValidationExceptionHandler;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.ValidationExceptionHandler;
import ca.uhn.hl7v2.validation.Validator;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * Developing and using custom Message Validation rules and applying them to messages.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class CustomMessageValidation {

	/**
	 * @param args
	 * @throws EncodingNotSupportedException
	 */
	public static void main(String[] args) throws EncodingNotSupportedException {

		/*
		 * In this example, we are looking at a few aspects of custom message validation using HAPI.
		 * 
		 * The following message will be used in the examples:
		 * 
		 * MSH|^~\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895
		 * |P^T|2.4 EVN|A31|200903230934
		 * PID|1||29^^CAISI_1-2^PI~""||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||
		 */
		String message1 = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r"
				+ "EVN|A31|200903230934\r"
				+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";

		/*
		 * Let's start by adding a validation rule to the default validation that disallows PID-2 to
		 * be empty. Normally you would write this in its own .java file instead of as anonymous
		 * class.
		 */

		ValidationRuleBuilder builder = new DefaultValidationBuilder() {

			@Override
			protected void configure() {
				super.configure();
				forVersion(Version.V24)
				    .message("ADT", "*")
				    .terser("PID-2", not(empty()));
			}

		};

		// Set up a parser using the validation rules
		HapiContext context = new DefaultHapiContext();
		context.setValidationRuleBuilder(builder);
		PipeParser parser = context.getPipeParser();

		// Let's try parsing the message:
		try {
			parser.parse(message1);
			// This should not happen
			System.out.println("Something went wrong!");
			System.exit(-1);
		} catch (HL7Exception e) {
			System.out.println("As expected, the message did not validate: " + e.getMessage());
		}

		/*
		 * In the next example, we reject a message with "unknown" segments, but this time not
		 * during parsing but in a separate step.
		 */
		String message2 = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r"
				+ "EVN|A31|200903230934\r"
				+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||\r"
				+ "Z04|bogus segment";

		// Change validation context for all dependent parsers
		context.setValidationContext(ValidationContextFactory.noValidation());

		Message message = null;
		try {
			message = parser.parse(message2);
			System.out.println("Parsing succeeded, but ... ");
		} catch (HL7Exception e) {
			// This should not happen
			System.out.println("Something went wrong!");
			System.exit(-1);
		}

		/*
		 * Let's add a validation rule that rejects custom segments
		 */
		ValidationRuleBuilder builder2 = new NoValidationBuilder() {

			@Override
			protected void configure() {
				super.configure();
				forVersion(Version.V24)
				    .message("ADT", "*")
				    .onlyKnownSegments();
			}

		};
		context.setValidationRuleBuilder(builder2);

		try {
			context.getMessageValidator().validate(message);
			// This should not happen
			System.out.println("Something went wrong!");
			System.exit(-1);
		} catch (HL7Exception e) {
			System.out.println("as expected, the message did not validate: " + e.getMessage());
		}

		/*
		 * Instead of throwing an HL7 Exception, the Validator can also be used in
		 * conjunction with a custom ValidationExceptionHandler, which would normally be defined in
		 * its own class file.
		 */
		ValidationExceptionHandler<Boolean> customHandler = new DefaultValidationExceptionHandler(context) {

		    @Override
			public void onExceptions(ValidationException... exceptions) {
				super.onExceptions(exceptions);
				for (ValidationException e : exceptions) {
					System.out.println("Found Validation issues: " + e.getMessage());
				}
			}
		};

		try {
		    Validator<Boolean> validator = context.getMessageValidator();
			boolean result = validator.validate(message, customHandler);
			System.out.println("The validator returned " + result);
		} catch (HL7Exception e) {
			// This should not happen
			System.out.println("Something went wrong!");
			System.exit(-1);
		}
	}

}
