package ca.uhn.hl7v2.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;

public class ParserConfigurationTest  {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ParserConfigurationTest.class);
	
	/**
	 * Test for
	 * http://sourceforge.net/tracker/?func=detail&aid=3472728&group_id=38899&atid=423835
	 */
	@Test
	public void testCheckFirstCharacterForcedEncode() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		msg.getPATIENT_RESULT().getPATIENT().getPID();
		
		PipeParser p = new PipeParser();
		p.getParserConfiguration().addForcedEncode("PATIENT_RESULT/PATIENT/PID-11-7");
		
		String encoded = p.encode(msg);
		ourLog.debug("Encoded:\n" + encoded.replace("\r", "\n"));
		assertTrue(encoded.contains("PID|||||||||||^^^^^^"));
		
	}

	@Test
	public void testAddForcedEncodeValidatesInput() {
		
		ParserConfiguration pc = new ParserConfiguration();
		pc.addForcedEncode("ORDER/RXR-22");
		
		assertIllegalArgument(pc, "A");
        assertIllegalArgument(pc, "AA");
        assertIllegalArgument(pc, "AAA/");
        assertIllegalArgument(pc, "AAA-A");
        assertIllegalArgument(pc, "AAA-123-");

	}
	
	private void assertIllegalArgument(ParserConfiguration pc, String forcedEncode) {
        try {
            pc.addForcedEncode(forcedEncode);
            fail();
        } catch (IllegalArgumentException e) {
            ourLog.debug(e.getMessage());
        }	    
	}
	
}
