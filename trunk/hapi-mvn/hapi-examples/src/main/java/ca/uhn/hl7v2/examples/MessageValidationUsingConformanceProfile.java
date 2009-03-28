/*
 * Created on Mar 23, 2009
 */
package ca.uhn.hl7v2.examples;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

/**
 * TODO: add!
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-03-28 17:18:02 $ by $Author:
 *          jamesagnew $
 */
public class MessageValidationUsingConformanceProfile {

	/**
	 * @param args
	 * @throws HL7Exception
	 * @throws IOException 
	 * @throws ProfileException 
	 * @throws HL7Exception 
	 */
	public static void main(String[] args) throws ProfileException, IOException, HL7Exception {

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
		String validMessageString = "MSH|^~\\&|MedSeries|CAISI_1-2|PLS|3910|200903230934||ADT^A31^ADT_A05|75535037-1237815294895|P^T|2.4\r\n"
				+ "EVN|A31|200903230934\r\n"
				+ "PID|1||29^^CAISI_1-2^PI~\"\"||Test300^Leticia^^^^^L||19770202|M||||||||||||||||||||||";
		Message validMessage = new PipeParser().parse(validMessageString);

		// Load a conformance profile
		ProfileParser profileParser = new ProfileParser(false);
		RuntimeProfile profile = profileParser.parseClasspath("ca/uhn/hl7v2/examples/profiles/ADT_A31.xml");

		// Create a conformance validator, and validate
		DefaultValidator validator = new DefaultValidator();
		HL7Exception[] exceptions = validator.validate(validMessage, profile.getMessage());
		
		System.out.println("Found " + exceptions.length + " problems");
		for (int i = 0; i < exceptions.length; i++) {
			HL7Exception exception = exceptions[i];
			System.out.println(" * " + exception.getClass().getSimpleName() + " - " + exception.getMessage());
		}
		
		/*
		 * Prints:
		 * 
		 * Found 10 problems
		 * ProfileNotHL7CompliantException - HL7 datatype ST doesn't match profile datatype NM: Segment: MSH Field #7
		 * ProfileNotHL7CompliantException - HL7 datatype MSG doesn't match profile datatype CM_MSG: Segment: MSH Field #9
		 * ProfileNotHL7CompliantException - HL7 datatype ST doesn't match profile datatype NM: Segment: EVN Field #2
		 * XElementPresentException - Field 1 in EVN appears in the message but not in the profile: Segment: EVN
		 * XElementPresentException - Element code identifying the check digit scheme employed is present but specified as not used (X): Segment: PID Field #3
		 * ProfileNotFollowedException - Required element identifier type code (ID) is missing: Segment: PID Field #3
		 * ProfileNotFollowedException - Required element assigning authority is missing: Segment: PID Field #3
		 * ProfileNotFollowedException - Required element identifier type code (ID) is missing: Segment: PID Field #3
		 * ProfileNotHL7CompliantException - HL7 datatype ST doesn't match profile datatype NM: Segment: PID Field #7
		 * XElementPresentException - Field 1 in PID appears in the message but not in the profile: Segment: PID
		 */
		
	}

}
