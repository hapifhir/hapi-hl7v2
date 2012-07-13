package ca.uhn.hl7v2.sourcegen.conf;

import org.junit.Test;

import ca.uhn.hl7v2.model.v25.datatype.IS;
import ca.uhn.hl7v2.sourcegen.SegmentElement;
import junit.framework.TestCase;
import static org.junit.Assert.*;


public class ProfileSourceGeneratorTest {

	@Test
	public void testExtractTableNamespace() {
		
    	SegmentElement e = new SegmentElement("", "", 0);
    	e.type = "IS";
    	ProfileSourceGenerator.extractTableInfo(e, "ABC123");
    	assertEquals("ABC", e.tableNamespace);
    	assertEquals(123, e.table);
		
    	e = new SegmentElement("", "", 0);
    	e.type = "IS";
    	ProfileSourceGenerator.extractTableInfo(e, "123");
    	assertEquals(null, e.tableNamespace);
    	assertEquals(123, e.table);
		
	}
	
	@Test
	public void testGenerateSourceWithNamespace() {
		ca.uhn.hl7v2.test.withns.message.ADT_A01 msg = new ca.uhn.hl7v2.test.withns.message.ADT_A01();
		assertEquals(399, msg.getMSH().getCountryCode().getTable());
		assertEquals("TESTNS", msg.getMSH().getCountryCode().getTableNamespace());
		
		IS nsid = msg.getMSH().getSendingApplication().getHd1_NamespaceID();
	}
	
}
