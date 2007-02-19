package ca.uhn.hl7v2.model;

import junit.framework.*;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.v24.message.*;
import ca.uhn.hl7v2.model.v24.segment.*;

/**
 * JUnit test cases for AbstractGroup
 * @author bryan
 */
public class AbstractGroupTest extends TestCase {
    
    public AbstractGroupTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(AbstractGroupTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    public void testAddNonstandardSegment() throws Exception {
        ADT_A01 message = new ADT_A01();

        //test known segment
        message.addNonstandardSegment("ARQ");
        Structure arq0 = message.get("ARQ", 0);
        Structure arq1 = message.get("ARQ", 1);
        assertEquals(ARQ.class.getName(), arq1.getClass().getName());
        
        //test unknown segment
        message.addNonstandardSegment("ZZZ");
        Structure z = message.get("ZZZ");
        assertEquals(GenericSegment.class.getName(), z.getClass().getName());
    }
    
}
