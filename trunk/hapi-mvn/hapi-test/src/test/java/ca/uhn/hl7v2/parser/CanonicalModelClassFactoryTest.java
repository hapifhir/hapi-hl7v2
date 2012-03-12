package ca.uhn.hl7v2.parser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

public class CanonicalModelClassFactoryTest {

	@Test
	public void testAckVersion() throws EncodingNotSupportedException, HL7Exception, IOException {
		
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
	
}
