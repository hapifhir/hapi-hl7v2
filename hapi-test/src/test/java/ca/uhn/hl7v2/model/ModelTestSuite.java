package ca.uhn.hl7v2.model;

import junit.framework.*;
import ca.uhn.hl7v2.model.primitive.*;

/**
 * JUnit test suite for model package
 * @author bryan
 */
public class ModelTestSuite extends TestCase {
    
    public ModelTestSuite(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(VariesTest.class);
        suite.addTestSuite(AbstractGroupTest.class);
        suite.addTestSuite(AbstractMessageTest.class);
        suite.addTestSuite(AbstractSegmentTest.class);
        suite.addTestSuite(GenericCompositeTest.class);
        suite.addTestSuite(GenericPrimitiveTest.class);
        suite.addTestSuite(CommonDTTest.class);
        suite.addTestSuite(CommonIDTest.class);
        suite.addTestSuite(CommonISTest.class);
        suite.addTestSuite(CommonTMTest.class);
        suite.addTestSuite(CommonTSTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    
    
}
