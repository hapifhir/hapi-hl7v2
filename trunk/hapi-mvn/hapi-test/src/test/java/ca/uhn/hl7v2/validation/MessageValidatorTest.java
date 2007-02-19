/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;
import junit.framework.TestCase;

/**
 * Unit tests for MessageValidator. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:52 $ by $Author: jamesagnew $
 */
public class MessageValidatorTest extends TestCase {

    private MessageValidator myFailingValidator; 
    private MessageValidator myNonFailingValidator; 
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        ValidationContextImpl context = new ValidationContextImpl();
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
        context.getEncodingRuleBindings().add(new RuleBinding("*", "*", new MockEncodingRule()));
        context.getEncodingRuleBindings().add(new RuleBinding("*", "*", new MockEncodingRule()));
        
        myFailingValidator = new MessageValidator(context, true);
        myNonFailingValidator = new MessageValidator(context, false);
    }

    /**
     * Constructor for MessageValidatorTest.
     * @param arg0
     */
    public MessageValidatorTest(String arg0) {
        super(arg0);
    }

    /*
     * Class under test for void validate(Message)
     */
    public void testValidateMessage() throws HL7Exception {
        ACK m = new ACK();
        Terser t = new Terser(m);
        t.set("MSH-9-1", "ACK");
        t.set("MSH-9-2", "A01");
        assertEquals(false, myNonFailingValidator.validate(m));
        try {
            myFailingValidator.validate(m);
            fail("Should throw exception on fail");
        } catch (HL7Exception e) {}
    }

    /*
     * Class under test for void validate(String, boolean, String)
     */
    public void testValidateString() throws HL7Exception {
        String m = "a message";
        assertEquals(false, myNonFailingValidator.validate(m, false, "2.5"));
        try {
            myFailingValidator.validate(m, false, "2.5");
            fail("Should throw exception on fail");            
        } catch (HL7Exception e) {}
    }
    
    private class MockMessageRule implements MessageRule {
        
        public ValidationException[] test(Message msg) {
            return new ValidationException[] {new ValidationException("testing validator")};
        }
        
        public String getDescription() {
            return null;
        }

        public String getSectionReference() {
            return null;
        }
    }
    
    private class MockEncodingRule implements EncodingRule {
        
        public boolean appliesToER7() {
            return true;
        }
        
        public boolean appliesToXML() {
            return true;
        }
        
        public ValidationException[] test(String msg) {
            return new ValidationException[] {new ValidationException("test validator")};
        }
        
        public String getDescription() {
            return null;
        }
        
        public String getSectionReference() {
            return null;
        }
    }

}
