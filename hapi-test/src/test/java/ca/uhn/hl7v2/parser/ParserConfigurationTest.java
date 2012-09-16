package ca.uhn.hl7v2.parser;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import junit.framework.TestCase;

public class ParserConfigurationTest extends TestCase {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ParserConfigurationTest.class);
	
	/**
	 * Test for
	 * http://sourceforge.net/tracker/?func=detail&aid=3472728&group_id=38899&atid=423835
	 */
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
	
	public void testAddForcedEncodeValidatesInput() {
		
		ParserConfiguration pc = new ParserConfiguration();

		pc.addForcedEncode("ORDER/RXR-22");
		
		try {
			pc.addForcedEncode("A");
			fail();
		} catch (IllegalArgumentException e) {
			ourLog.debug(e.getMessage());
		}

		try {
			pc.addForcedEncode("AA");
			fail();
		} catch (IllegalArgumentException e) {
			ourLog.debug(e.getMessage());
		}

		try {
			pc.addForcedEncode("AAA/");
			fail();
		} catch (IllegalArgumentException e) {
			ourLog.debug(e.getMessage());
		}

		try {
			pc.addForcedEncode("AAA-A");
			fail();
		} catch (IllegalArgumentException e) {
			ourLog.debug(e.getMessage());
		}

		try {
			pc.addForcedEncode("AAA-123-");
			fail();
		} catch (IllegalArgumentException e) {
			ourLog.debug(e.getMessage());
		}
		
	}
	
}
