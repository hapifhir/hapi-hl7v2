package ca.uhn.hl7v2.validation.builder;

import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ORM_O01;
import ca.uhn.hl7v2.parser.PipeParser;

public class ChoiceElementsRespectedRuleTest {

	@Test
	public void testOneObr() throws HL7Exception, IOException {
		
		ORM_O01 msg = new ORM_O01();
		msg.initQuickstart("ORM", "O01", "T");
		msg.getORDER().getORDER_DETAIL().getOBR().parse("OBR|1");
		
		new PipeParser().encode(msg);
		
	}
	
	// TODO seems to fail
	@Test(expected=HL7Exception.class)
	public void testMultipleWithContent() throws HL7Exception, IOException {
		
		ORM_O01 msg = new ORM_O01();
		msg.initQuickstart("ORM", "O01", "T");
		msg.getORDER().getORDER_DETAIL().getOBR().parse("OBR|1");
		msg.getORDER().getORDER_DETAIL().getRXO().parse("RXO|1");
		
		new PipeParser().encode(msg);
		
	}

}
