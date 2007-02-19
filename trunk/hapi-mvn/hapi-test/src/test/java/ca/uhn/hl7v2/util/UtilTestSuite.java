package ca.uhn.hl7v2.util;

import junit.framework.*;

/**
 * JUnit test suite for util package
 * @author bryan
 */
public class UtilTestSuite extends TestCase {
    
    public UtilTestSuite(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(DeepCopyPosTest.class);
        suite.addTestSuite(MessageNavigatorTest.class);
        suite.addTestSuite(SegmentFinderTest.class);
        suite.addTestSuite(MessageIteratorTest.class);
        suite.addTestSuite(TerserTest.class);
        suite.addTestSuite(EncodedMessageComparatorTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    
    
}
