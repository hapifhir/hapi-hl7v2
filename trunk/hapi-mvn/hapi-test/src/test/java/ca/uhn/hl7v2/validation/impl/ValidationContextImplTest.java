/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.ValidationException;
import junit.framework.TestCase;

/**
 * Unit tests for ValidationContextImpl. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:32 $ by $Author: jamesagnew $
 */
public class ValidationContextImplTest extends TestCase {
    
    private ValidationContextImpl myContext;
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myContext = new ValidationContextImpl();        
    }

    /**
     * Constructor for ValidationContextImplTest.
     * @param arg0
     */
    public ValidationContextImplTest(String arg0) {
        super(arg0);
    }

    public void testGetPrimitiveRules() {
        PrimitiveTypeRule rule1 = new SizeRule(10);
        PrimitiveTypeRule rule2 = new SizeRule(20);
        
        myContext.getPrimitiveRuleBindings().add(new RuleBinding("2.5", "ST", rule1));
        myContext.getPrimitiveRuleBindings().add(new RuleBinding("2.5", "FT", rule2));
        
        PrimitiveTypeRule[] rules = myContext.getPrimitiveRules("2.5", "ST", null);
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    public void testGetMessageRules() {
        MessageRule rule1 = new MockMessageRule();
        MessageRule rule2 = new MockMessageRule();
        
        myContext.getMessageRuleBindings().add(
                new MessageRuleBinding("2.5", "ADT", "A01", rule1));
        myContext.getMessageRuleBindings().add(
                new MessageRuleBinding("2.5", "ADT", "A04", rule2));
        
        MessageRule[] rules = myContext.getMessageRules("2.5", "ADT", "A01");
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    public void testGetEncodingRules() {
        EncodingRule rule1 = new MockEncodingRule();
        EncodingRule rule2 = new MockEncodingRule();
        
        myContext.getEncodingRuleBindings().add(
                new RuleBinding("2.5", "XML", rule1));
        myContext.getEncodingRuleBindings().add(
                new RuleBinding("2.5", "ER7", rule1));
        
        EncodingRule[] rules = myContext.getEncodingRules("2.5", "XML");
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

//    public void testGetCheckPrimitivesOnSet() {
//        assertEquals(true, myContext.getCheckPrimitivesOnSet());
//        myContext.setCheckPrimitivesOnSet(false);
//        assertEquals(false, myContext.getCheckPrimitivesOnSet());
//    }
    
    private class MockMessageRule implements MessageRule {

        /**
         * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
         */
        public ValidationException[] test(Message arg0) {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
         */
        public String getSectionReference() {
            return null;
        }
        
    }
    
    private class MockEncodingRule implements EncodingRule {

        /** 
         * @see ca.uhn.hl7v2.validation.EncodingRule#test(java.lang.String)
         */
        public ValidationException[] test(String arg0) {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
         */
        public String getSectionReference() {
            return null;
        }
        
    }

}
