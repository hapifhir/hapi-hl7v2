package ca.uhn.hl7v2.model;

import junit.framework.*;

/**
 * JUnit test cases for AbstractMessage
 * @author bryan
 */
public class AbstractMessageTest extends TestCase {
    
    public AbstractMessageTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(AbstractMessageTest.class);
        return suite;
    }
    
    public void testGetVersion() {
        Message msg = new ca.uhn.hl7v2.model.v22.message.ADT_A01();
        assertEquals("2.2", msg.getVersion());
        msg = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
        assertEquals("2.3", msg.getVersion());
        msg = new ca.uhn.hl7v2.model.v231.message.ADT_A01();
        assertEquals("2.3.1", msg.getVersion());
        msg = new ca.uhn.hl7v2.model.v24.message.ADT_A01();
        assertEquals("2.4", msg.getVersion());        
    }
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    
    
}
