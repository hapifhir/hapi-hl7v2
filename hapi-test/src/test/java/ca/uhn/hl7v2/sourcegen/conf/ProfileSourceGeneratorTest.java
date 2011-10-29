package ca.uhn.hl7v2.sourcegen.conf;

import ca.uhn.hl7v2.sourcegen.SegmentElement;
import junit.framework.TestCase;

public class ProfileSourceGeneratorTest extends TestCase {

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
	
}
