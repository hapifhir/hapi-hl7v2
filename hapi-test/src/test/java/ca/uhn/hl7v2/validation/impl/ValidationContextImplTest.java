/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * Unit tests for ValidationContextImpl. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr 
 */
public class ValidationContextImplTest {
    
    private ValidationContextImpl myContext;
    
    @Before
    public void setUp() throws Exception {
        myContext = new ValidationContextImpl();        
    }

    @Test
    public void testGetPrimitiveRules() {
        PrimitiveTypeRule rule1 = new SizeRule(10);
        PrimitiveTypeRule rule2 = new SizeRule(20);
        
        myContext.getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5", "ST", rule1));
        myContext.getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5", "FT", rule2));
        
        PrimitiveTypeRule[] rules = myContext.getPrimitiveRules("2.5", "ST", null);
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    @Test    
    public void testGetMessageRules() {
        MessageRule rule1 = new MockMessageRule();
        MessageRule rule2 = new MockMessageRule();
        
        myContext.getMessageRuleBindings().add(new MessageRuleBinding("2.5", "ADT", "A01", rule1));
        myContext.getMessageRuleBindings().add(new MessageRuleBinding("2.5", "ADT", "A04", rule2));
        
        MessageRule[] rules = myContext.getMessageRules("2.5", "ADT", "A01");
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    @Test    
    public void testGetEncodingRules() {
        EncodingRule rule1 = new MockEncodingRule();
        
        myContext.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("2.5", "XML", rule1));
        myContext.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("2.5", "ER7", rule1));
        
        EncodingRule[] rules = myContext.getEncodingRules("2.5", "XML");
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    
    @SuppressWarnings("serial")
	private class MockMessageRule extends AbstractMessageRule {

        /**
         * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
         */
        public ValidationException[] apply(Message arg0) {
            return passed();
        }

        
    }
    
    @SuppressWarnings("serial")
	private class MockEncodingRule extends AbstractEncodingRule {

        /** 
         * @see ca.uhn.hl7v2.validation.EncodingRule#test(java.lang.String)
         */
        public ValidationException[] apply(String arg0) {
            return passed();
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        
    }

}
