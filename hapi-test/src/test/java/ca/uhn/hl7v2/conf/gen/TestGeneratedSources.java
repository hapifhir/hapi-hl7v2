package ca.uhn.hl7v2.conf.gen;

import ca.uhn.hl7v2.test.tblnms.conf.message.ACK;
import ca.uhn.hl7v2.test.tblnms.conf.segment.MSH;
import junit.framework.TestCase;

public class TestGeneratedSources extends TestCase {

	public void testTableNamespaces() {
		
		ACK ack = new ACK();
		MSH msh = ack.getMSH();
		assertEquals(155, msh.getAcceptAcknowledgmentType().getTable());
		assertEquals("IHE", msh.getAcceptAcknowledgmentType().getTableNamespace());
		
		assertEquals(155, msh.getApplicationAcknowledgmentType().getTable());
		
	}
	
	
}
