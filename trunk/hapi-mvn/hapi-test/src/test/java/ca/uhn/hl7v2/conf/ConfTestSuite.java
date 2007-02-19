package ca.uhn.hl7v2.conf;

import junit.framework.*;

/**
 * JUnit test sutie for conf package
 * @author bryan
 */
public class ConfTestSuite extends TestCase {
    
    public ConfTestSuite(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new TestSuite(ca.uhn.hl7v2.conf.parser.ProfileParserTest.class));
        suite.addTest(new TestSuite(ca.uhn.hl7v2.conf.check.DefaultValidatorTest.class));
        suite.addTest(new TestSuite(ca.uhn.hl7v2.conf.store.ProfileCodeStoreTest.class));
        suite.addTest(new TestSuite(ca.uhn.hl7v2.conf.store.ProfileStoreFactoryTest.class));
        suite.addTest(new TestSuite(ca.uhn.hl7v2.conf.store.URLProfileStoreTest.class));
        return suite;
    }
    
    
}
