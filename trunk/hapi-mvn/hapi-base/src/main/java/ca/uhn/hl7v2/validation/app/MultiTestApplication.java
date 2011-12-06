package ca.uhn.hl7v2.validation.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.HL7Exception;

/**
 * A composite test application that delegates to multiple other test applications 
 * and returns a combined list of problems.  
 * @author Bryan Tripp
 */
public class MultiTestApplication extends TestApplication {
    
    private List<TestApplication> tests;
    
    /** Creates a new instance of MultiTestApplication */
    public MultiTestApplication() {
        tests = new ArrayList<TestApplication>(20);
    }
    
    /**
     * Returns true if ANY of the delegates can accept the message.  
     */
    public boolean canProcess(Message in) {
        boolean can = false;
        for (int i = 0; !can && i < tests.size(); i++) {
            can = tests.get(i).canProcess(in);
        }
        return can;
    }
    
    /** Tests the message by passing it to all test apps that have been registered 
     * using addTest().  
     * @return exceptions that describe any identified problems with the message
     */
    public HL7Exception[] test(Message in) throws HL7Exception {
        List<HL7Exception> problems = new ArrayList<HL7Exception>(40);
        for (int i = 0; i < tests.size(); i++) {
            TestApplication app = (TestApplication) tests.get(i);
            HL7Exception[] shortList = app.test(in);
            problems.addAll(Arrays.asList(shortList));
        }
        return problems.toArray(new HL7Exception[0]);
    }
    
    /**
     * Registers a test app so that messages will be tested against it.
     */
    public void addTest(TestApplication test) {
        tests.add(test);
    }
    
}
