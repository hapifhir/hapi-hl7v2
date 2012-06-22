package ca.uhn.hl7v2.model;

import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import static org.junit.Assert.*;

public class AbstractCompositeTest {

	@Test
	public void testParseNull() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		
		assertTrue(msg.getMSH().getMessageType().encode().length() > 0);
		
		msg.getMSH().getMessageType().parse(null);
		
		assertNull(msg.getMSH().getMessageType().getMessageCode().getValue());
		assertNull(msg.getMSH().getMessageType().getMessageStructure().getValue());

		
	}
	
}
