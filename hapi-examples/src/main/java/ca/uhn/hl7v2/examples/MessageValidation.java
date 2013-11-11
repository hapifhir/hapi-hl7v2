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
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * Message Validation using the provided ValidationContext implementations
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @version $Revision: 1.3 $ updated on $Date: 2009-08-09 13:59:46 $ by $Author:
 *          jamesagnew $
 */
public class MessageValidation {

	/**
	 * @param args
	 * @throws HL7Exception
	 * @throws ca.uhn.hl7v2.parser.EncodingNotSupportedException
	 */
	public static void main(String[] args) throws HL7Exception {

		/*
		 * In this example, we are looking at a few aspects of message
		 * validation using HAPI.
		 * 
		 * The following message will be used in the examples:
		 * 
		 * MSH|^~\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4
		 * EVN|A31|200903230934
		 * PID|1||29^^CAISI_1-2^PI~""||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||
		 */
		String validMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
				+ "EVN|A31|200903230934\r\n"
				+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";

		/*
		 * Let's start by constructing a parser using default settings. By
		 * default, a parser has certain validation settings, as defined by the
		 * DefaultValidation class.
		 */
		HapiContext context = new DefaultHapiContext();
		
		/*
		 * This is actually redundant, since this is the default
		 * validator. The default validation includes a number of sensible
		 * defaults including maximum lengths on string types, formats for
		 * telephone numbers and timestamps, etc.
		 */
		context.setValidationContext(ValidationContextFactory.defaultValidation());	

		// Let's try parsing the valid message:
		PipeParser parser = context.getPipeParser();
		try {
			parser.parse(validMessage);
			System.out.println("Successfully parsed valid message");
		} catch (HL7Exception e) {
			// This shouldn't happen!
			System.out.println("Something went wrong!");
			System.exit(-1);
		}

		/*
		 * Next, let's set EVN-2 to a string that is longer than 200 chars.
		 * DefaultValidation specified that ID datatypes must not exceed this
		 *length
		 */
		String invalidMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
				+ "EVN|0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789|200903230934\r\n"
				+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";

		// Let's try parsing the valid message:
		try {
			parser.parse(invalidMessage);
		} catch (HL7Exception e) {
			// This time, we are expecting an exception, because the message
			// should fail validation.
			System.out.println("As expected, the message did not validate: "
					+ e.getMessage());
			/*
			 * Prints: 
			 * As expected, the message did not validate: Failed validation rule: Maxumim size <= 200 characters: Segment: EVN (rep 0) Field #1
			 */
		}

        /*
         * The ValidationContext is used during parsing and well as during
         * validation using {@link ca.uhn.hl7v2.validation.Validator} objects.
         * Sometimes we want parsing without validation followed by a
         * separate validation step. We can still use a single HapiContext.
         */

        context.getParserConfiguration().setValidating(false);
        try {
            parser.parse(invalidMessage);
            System.out.println("Successfully parsed valid message");
        } catch (HL7Exception e) {
            // This shouldn't happen!
            System.out.println("Something went wrong!");
            System.exit(-1);
        }

		/*
		 * Now, suppose we want to throw caution to the wind, and not do 
		 * any validation. This is fairly common practice in the real
		 * world, since sending systems don't always behave as nicely as
		 * we might want.
		 */
		context.setValidationContext(ValidationContextFactory.noValidation());
		
		try {
			parser.parse(invalidMessage);
			System.out.println("Successfully parsed invalid message");
		} catch (HL7Exception e) {
			// This shouldn't happen!
			System.out.println("Something went wrong!");
			System.exit(-1);
		}
		
		/*
		 * One important thing to note is that NoValidation still includes one
		 * rule: A rule which strips leading space from FT, ST, and trailing
		 * space from TX fields.
		 * 
		 * Let's add some leading space to MSH-10 (this isn't something you would 
		 * want to do normally, but it does demonstrate leading space trimming from
		 * ST datatypes) 
		 */
		invalidMessage = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|             CONTROLID|P^T|2.4\r\n"
			+ "EVN|A03|200903230934\r\n"
			+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";
		try {
			Message parsedMessage = parser.parse(invalidMessage);
			
			// Print the message back out
			System.out.println(parser.encode(parsedMessage));
			
			/*
			 * MSH|^~\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|CONTROLID|P^T|2.4
             * EVN|A03|200903230934
			 * PID|1||29^^CAISI_1-2^PI~""||Test300^Leticia^^^^^L||19770202|M
			 */
			
		} catch (HL7Exception e) {
			e.printStackTrace();
		}
				
	}

}
