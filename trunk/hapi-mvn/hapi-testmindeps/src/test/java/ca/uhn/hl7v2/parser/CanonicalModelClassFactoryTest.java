package ca.uhn.hl7v2.parser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

public class CanonicalModelClassFactoryTest {

	/**
	 * https://sourceforge.net/p/hl7api/bugs/182/
	 */
	@Test
	public void testUnexpectedStructureInCanonicalMessage() throws HL7Exception {
		
		String messageText = "MSH|^~\\&|QRYIE|MDS|UHN|1.3.6.1.4.1.12201|20130402180011||OSR^Q06^OSR_Q06|35141|T|2.4\r" +
				"MSA|AA|35141|Successfully Processed\r" + 
				"PID||1112223332|1M1240053||Huckleberry^Lin||19650813000000-0500|M\r" + 
				"PV1|1|U|||||||||||||||||SE50771||||||||||||||||||||||No_Match_Found|||20090504|||||||V\r" + 
				"ZTC|0|145^INR (PROTHROMBIN TIME)|F|1^HEMATOLOGY/CHEMISTRY|100\r";

		CanonicalModelClassFactory mcf = new CanonicalModelClassFactory(ca.uhn.hl7v2.model.v25.message.OSR_Q06.class);
		PipeParser parser = new PipeParser(mcf);
		
		// Make sure this doesn't throw an exception
		parser.parse(messageText);
		new ca.uhn.hl7v2.model.v25.message.OSR_Q06(mcf).parse(messageText);
		
		
	}
	
	
}
