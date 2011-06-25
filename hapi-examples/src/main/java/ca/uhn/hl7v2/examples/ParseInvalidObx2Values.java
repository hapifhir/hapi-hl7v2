package ca.uhn.hl7v2.examples;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;

/**
 * Example code which illustrates how to handle OBX segments
 * with an invalid or missing OBX-2 value.
 */
public class ParseInvalidObx2Values {

	public static void main(String[] args) throws HL7Exception {

		/*
		 * The following is a message in which the OBX segment is missing the
		 * mandatory OBX-2 value
		 */
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
			+ "PID|||7005728\r"
			+ "OBR|1\r"
			+ "OBX|||||Sample Value\r";

		ORU_R01 msg = new ORU_R01();
		try {
			// This throws an exception
			msg.parse(string);
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * Prints:
			 * ca.uhn.hl7v2.HL7Exception: OBX-5 is valued, but OBX-2 is not.  A datatype for OBX-5 must be specified using OBX-2. See JavaDoc for Varies#fixOBX5(Segment, ModelClassFactory)
			 * at ca.uhn.hl7v2.model.Varies.fixOBX5(Varies.java:189)
			 * at ca.uhn.hl7v2.parser.PipeParser.parse(PipeParser.java:377)
			 * at ca.uhn.hl7v2.parser.PipeParser.parse(PipeParser.java:1009)
			 * at ca.uhn.hl7v2.model.AbstractMessage.parse(AbstractMessage.java:189)
			 * at ca.uhn.hl7v2.examples.ParseInvalidObx2Values.main(ParseInvalidObx2Values.java:28)
			 */
		}
		
		/* 
		 * Setting the following system property allows you to specify a default
		 * value to assume if OBX-2 is missing. 
		 */		
		System.setProperty(Varies.DEFAULT_OBX2_TYPE_PROP, "ST");

		// Parsing now succeeds
		msg = new ORU_R01();
		msg.parse(string);

		
		
		/*
		 * The following message has an invalid value in OBX-2 
		 */
		string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
			+ "PID|||7005728\r"
			+ "OBR|1\r"
			+ "OBX||BAD|||Sample Value\r";
		
		msg = new ORU_R01();
		try {
			// This throws an exception
			msg.parse(string);
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * Prints:
			 * ca.uhn.hl7v2.HL7Exception: 'BAD' in record null is invalid for version 2.6. See JavaDoc for Varies#fixOBX5(Segment, ModelClassFactory): Segment: OBX Field #2
			 * at ca.uhn.hl7v2.model.Varies.fixOBX5(Varies.java:212)
			 * at ca.uhn.hl7v2.parser.PipeParser.parse(PipeParser.java:377)
			 * at ca.uhn.hl7v2.parser.PipeParser.parse(PipeParser.java:1009)
			 * at ca.uhn.hl7v2.model.AbstractMessage.parse(AbstractMessage.java:189)
			 * at ca.uhn.hl7v2.examples.ParseInvalidObx2Values.main(ParseInvalidObx2Values.java:62)
			 */
		}
		
		/* 
		 * Setting the following system property allows you to specify a default
		 * value to assume if OBX-2 is missing. 
		 */		
		System.setProperty(Varies.INVALID_OBX2_TYPE_PROP, "ST");

		// Parsing now succeeds
		msg = new ORU_R01();
		msg.parse(string);
		
		
	}

}
