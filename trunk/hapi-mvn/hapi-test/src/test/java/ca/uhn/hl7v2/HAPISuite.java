package ca.uhn.hl7v2;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import ca.uhn.hl7v2.parser.EscapeTest;
import ca.uhn.hl7v2.parser.FastParserTest;
import ca.uhn.hl7v2.parser.ParserTest;
import ca.uhn.hl7v2.preparser.PreParserER7Test;
import ca.uhn.hl7v2.preparser.PreParserXMLTest;
import ca.uhn.hl7v2.protocol.impl.ApplicationLoaderTest;
import ca.uhn.hl7v2.protocol.impl.DualTransportConnectorTest;
import ca.uhn.hl7v2.util.MessageLibraryTest;
import ca.uhn.hl7v2.util.ReadOnlyMessageIteratorTest;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRuleTest;
import ca.uhn.hl7v2.validation.impl.XMLSchemaRuleTest;

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
        suite.addTestSuite(XMLSchemaRuleTest.class);
        suite.addTestSuite(ConformanceProfileRuleTest.class);
        suite.addTestSuite(EscapeTest.class);
        suite.addTestSuite(FastParserTest.class);
        suite.addTestSuite(ParserTest.class);
        suite.addTestSuite(ApplicationLoaderTest.class);
        suite.addTestSuite(DualTransportConnectorTest.class);
        suite.addTestSuite(MessageLibraryTest.class);
        suite.addTestSuite(ReadOnlyMessageIteratorTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    
    
}
