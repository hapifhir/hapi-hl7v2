package ca.uhn.hl7v2.conf.gen;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.test.singledt.conf.message.ADT_A01;
import ca.uhn.hl7v2.test.singledt.conf.segment.OBX;
import ca.uhn.hl7v2.test.tblnms.conf.message.ACK;
import ca.uhn.hl7v2.test.tblnms.conf.segment.MSH;

public class TestGeneratedSources extends TestCase {

	public void testTableNamespaces() {
		
		ACK ack = new ACK();
		MSH msh = ack.getMSH();
		assertEquals(155, msh.getAcceptAcknowledgmentType().getTable());
		assertEquals("IHE", msh.getAcceptAcknowledgmentType().getTableNamespace());
		
		assertEquals(155, msh.getApplicationAcknowledgmentType().getTable());
		
	}
	
	
	public void testGetAllReps() throws HL7Exception, IOException {

		ADT_A01 msg = new ADT_A01();
		msg.getOBX(0).getSetIDOBX().setValue("1");
		msg.getOBX(1).getSetIDOBX().setValue("2");
		
		List<OBX> all = msg.getOBXAll();
		Iterator<OBX> iter = all.iterator();
		
		assertEquals("1", iter.next().getSetIDOBX().getValue());
		assertEquals("2", iter.next().getSetIDOBX().getValue());
		assertFalse(iter.hasNext());
		
	}
	
	
	public void testGetSegmentFieldReps() {
		new ADT_A01().getDB1().getDb13_DisabledPersonIdentifierReps();
	}
	
	
}
