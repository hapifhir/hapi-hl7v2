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

import java.util.HashMap;
import java.util.Map;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;

/**
 * Message Validation using the provided ValidationContext implementations
 *
 */
public class CustomMessageValidationWithValidatingVisitor {

	public static void main(String[] args) throws HL7Exception {

		/*
		 * In this example, we are looking at a more advanced aspect of message
		 * validation using HAPI. We will use a MessageVisitor instead of a Terser
		 * to validate our message during parsing.
		 * 
		 * The following message will be used in the example:
		 * 
		 * MSH|^~\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4
		 * EVN|A31|200903230934
		 * PID|1||29^^CAISI_1-2^PI~""||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||
		 */
		String message = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
				+ "EVN|A31|200903230934\r\n"
				+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";


		HapiContext context = new DefaultHapiContext();

		/*
		 * Define the mandatory fields and visitor factory
		 */
		final Map<String, Integer[]> map = new HashMap<String, Integer[]>();
        map.put("MSH", new Integer[] {2, 3, 4, 5, 6, 7, 9, 10, 12});
        map.put("PID", new Integer[] {2, 3, 5, 6, 7});
        final MandatoryFields mandatoryFields = new MandatoryFields(map);

        /*
         * Extend the default validation context by a message rule that uses the
         * MandatoryFields visitor to check if the mandatory fields are actually
         * present.
         */
        ValidationRuleBuilder builder = new DefaultValidationBuilder() {

            @Override
            protected void configure() {
                super.configure();
                forVersion(Version.V24)
                        .message("ADT", "*")
                        .inspect(mandatoryFields);
            }

        };
		context.setValidationRuleBuilder(builder);
        context.getParserConfiguration().setValidating(true);

		// Let's parse and validate the message:
		PipeParser parser = context.getPipeParser();
		try {
            parser.parse(message);
            System.out.println("Something went wrong!");
		} catch (HL7Exception e) {
            System.out.println("As expected we found a problem:");
            System.out.println(e.getMessage());
		}
				
	}

}
