package ca.uhn.hl7v2.sourcegen;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ORM_O01;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * JUnit test cases for GroupGenerator
 * 
 * @author Bryan Tripp
 */
public class GroupGeneratorTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(GroupGeneratorTest.class);
	
	/** 
	 * See
	 * https://sourceforge.net/p/hl7api/bugs/159/
	 */
	@Test
	public void testParseGroupWithMultiplePossibleStartSegments() throws HL7Exception {
		PipeParser p = PipeParser.getInstanceWithNoValidation();

		// With an OBR
		
		String msgS = "MSH|^~\\&|SINUS|1030101^AMARES|PDS|PDS|20120712145441.837+0100||ORM^O01|MSG00001|P|2.5||||||UNICODE UTF-8\r" + // -
				"PID|||193661868||ANTONIO^LOPES^GOMES||19421220|M|||Rua do Bom Jardim^^Porto^^4420-554^PT||+351965546354|||||3\r" + // -
				"ORC|RE|0|75430^MED_MEDICACAO_CRONICA||||1^^^20070228^20120411||20120712145441.837+0100|39389^MELO^CLAUDIA^^^^MD|||||||1030101^AMARES\r" + // -
				"OBR|5869\r" + // -
				"NTE|1|P|C09AA09~FOSINOPRIL~WC|PI^Patient Instructions^^1^ATC_CODE"; // -

		ORM_O01 msg = (ORM_O01) p.parse(msgS);
		assertEquals("5869", msg.getORDER().getORDER_DETAIL().getOBR().getObr1_SetIDOBR().getValue());
		assertEquals("C09AA09", msg.getORDER().getORDER_DETAIL().getNTE().getNte3_Comment(0).encode());
		
		// Now with an RXO
		
		msgS = "MSH|^~\\&|SINUS|1030101^AMARES|PDS|PDS|20120712145441.837+0100||ORM^O01|MSG00001|P|2.5||||||UNICODE UTF-8\r" + // -
				"PID|||193661868||ANTONIO^LOPES^GOMES||19421220|M|||Rua do Bom Jardim^^Porto^^4420-554^PT||+351965546354|||||3\r" + // -
				"ORC|RE|0|75430^MED_MEDICACAO_CRONICA||||1^^^20070228^20120411||20120712145441.837+0100|39389^MELO^CLAUDIA^^^^MD|||||||1030101^AMARES\r" + // -
				"RXO|5869\r" + // -
				"NTE|1|P|C09AA09~FOSINOPRIL~WC|PI^Patient Instructions^^1^ATC_CODE"; // -

		msg = (ORM_O01) p.parse(msgS);
		assertEquals("5869", msg.getORDER().getORDER_DETAIL().getRXO().getRxo1_RequestedGiveCode().encode());
		assertEquals("C09AA09", msg.getORDER().getORDER_DETAIL().getNTE().getNte3_Comment(0).encode());

	}
	
	@Test
	public void testPrintStructureWorksForChoice() throws HL7Exception, IOException {
		
		ORM_O01 msg = new ORM_O01();
		msg.initQuickstart("ORM", "O01", "T");
		
		String ps = msg.printStructure();
		assertTrue(ps, ps.contains("<"));
		
		ourLog.info("Structure: \n{}", ps);
	}

	@Test
	public void testRepGetter() throws Exception {
		ADT_A01 a01 = new ADT_A01();
		a01.getROL(0);
		a01.getROL(1);
		assertEquals(2, a01.getROLReps());
	}
}
