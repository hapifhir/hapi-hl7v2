package ca.uhn.hl7v2.conf.gen;

import java.io.IOException;


import junit.framework.TestCase;

import org.junit.Ignore;

import ca.uhn.hl7v2.HL7Exception;
/*
import ca.uhn.hl7v2.test.singledt.conf.message.ADT_A01;
import ca.uhn.hl7v2.test.singledt.conf.segment.OBX;
import ca.uhn.hl7v2.test.tblnms.conf.message.ACK;
import ca.uhn.hl7v2.test.tblnms.conf.segment.MSH;
*/

/**
 * This test class is Ignored.
 * It is related to hapi's custom Maven plugin called CodeGen.
 * CodeGen is only pertinent when re-generating the hapi-structures libraries.. which we are not able to do ourselves as it
 * requires a copy of Windows-XP, MS-Access, a jdbc-odbc bridge driver and a DeLorean with flux-capacitor to travel back to the 90's.
 * Code has been left here but commented out for reference.
 *
 * We (like everyone else) rely on the officially generated hapi-structure-vXX libs that are publicly available
 * @deprecated
 */
@Ignore
public class TestGeneratedSources extends TestCase {

	public void testTableNamespaces() {
/*
		ACK ack = new ACK();
		MSH msh = ack.getMSH();
		assertEquals(155, msh.getAcceptAcknowledgmentType().getTable());
		assertEquals("IHE", msh.getAcceptAcknowledgmentType().getTableNamespace());
		
		assertEquals(155, msh.getApplicationAcknowledgmentType().getTable());
*/
	}
	
	
	public void testGetAllReps() throws HL7Exception, IOException {
/*
		ADT_A01 msg = new ADT_A01();
		msg.getOBX(0).getSetIDOBX().setValue("1");
		msg.getOBX(1).getSetIDOBX().setValue("2");
		
		List<OBX> all = msg.getOBXAll();
		Iterator<OBX> iter = all.iterator();
		
		assertEquals("1", iter.next().getSetIDOBX().getValue());
		assertEquals("2", iter.next().getSetIDOBX().getValue());
		assertFalse(iter.hasNext());
*/
	}
	
	
	public void testGetSegmentFieldReps() {
//		new ADT_A01().getDB1().getDb13_DisabledPersonIdentifierReps();
	}
	
	
}
