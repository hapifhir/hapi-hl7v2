package ca.uhn.hl7v2.sourcegen;

import junit.framework.*;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;

/**
 * JUnit test cases for GroupGenerator
 * @author Bryan Tripp
 */
public class GroupGeneratorTest extends TestCase {
    
    public GroupGeneratorTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(GroupGeneratorTest.class);
        return suite;
    }
    
    public void testRepGetter() throws Exception {
        ADT_A01 a01 = new ADT_A01();
        a01.getROL(0);
        a01.getROL(1);
        assertEquals(2, a01.getROLReps());
    }
    
}
