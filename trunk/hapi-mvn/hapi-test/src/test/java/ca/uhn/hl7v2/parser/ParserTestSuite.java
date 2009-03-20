package ca.uhn.hl7v2.parser;

import junit.framework.*;

/**
 * JUnit test suite for parser package 
 * @author bryan
 */
public class ParserTestSuite extends TestCase {
    
    public ParserTestSuite(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(EscapeTest.class);
        suite.addTestSuite(ParserTest.class);
        suite.addTestSuite(PipeParserTest.class);
        suite.addTestSuite(XMLParserTest.class);
        suite.addTestSuite(ParserPackageLoadingTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    
    
}
