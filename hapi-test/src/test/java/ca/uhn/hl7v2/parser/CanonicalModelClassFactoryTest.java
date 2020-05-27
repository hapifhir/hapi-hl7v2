package ca.uhn.hl7v2.parser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

public class CanonicalModelClassFactoryTest {

	@Test
	public void testAckVersion() throws HL7Exception, IOException {
		
		String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
				+ "EVN|A45|201004141020|\r"
				+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
				+ "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";

		CanonicalModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
		PipeParser parser = new PipeParser(mcf);
		Message message = parser.parse(messageText);
		
		Assert.assertEquals(ca.uhn.hl7v2.model.v26.message.ADT_A45.class, message.getClass());
		
		Message ack = message.generateACK();
		Assert.assertEquals(ca.uhn.hl7v2.model.v26.message.ACK.class, ack.getClass());
		
	}
	
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
