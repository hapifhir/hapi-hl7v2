package ca.uhn.hl7v2;

import ca.uhn.hl7v2.preparser.PreParserER7Test;
import ca.uhn.hl7v2.preparser.PreParserXMLTest;
import junit.framework.*;

/**
 * JUnit test suite for all HAPI test cases
 * @author bryan
 */
public class HAPISuite extends TestCase {
    
    public HAPISuite(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(ca.uhn.hl7v2.app.AppTestSuite.suite());
        suite.addTest(ca.uhn.hl7v2.conf.ConfTestSuite.suite());
        //llp not included -- not working 
        suite.addTest(ca.uhn.hl7v2.model.ModelTestSuite.suite());
        suite.addTest(ca.uhn.hl7v2.parser.ParserTestSuite.suite());
        suite.addTestSuite(ca.uhn.hl7v2.sourcegen.SourceGeneratorTest.class);
        suite.addTestSuite(ca.uhn.hl7v2.sourcegen.GroupGeneratorTest.class);
        suite.addTest(ca.uhn.hl7v2.util.UtilTestSuite.suite());
        suite.addTestSuite(PreParserER7Test.class);
        suite.addTestSuite(PreParserXMLTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    
    
}
