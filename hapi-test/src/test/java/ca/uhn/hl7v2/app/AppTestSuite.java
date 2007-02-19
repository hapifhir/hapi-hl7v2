package ca.uhn.hl7v2.app;

import junit.framework.*;

/**
 * JUnit test suite for app package
 * @author bryan
 */
public class AppTestSuite extends TestCase {
    
    public AppTestSuite(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new TestSuite(ConnectionHubTest.class));
        suite.addTest(new TestSuite(DefaultApplicationTest.class));
        suite.addTest(new TestSuite(MessageTypeRouterTest.class));
        suite.addTest(new TestSuite(InitiatorTest.class));
        return suite;
    }
    
}
