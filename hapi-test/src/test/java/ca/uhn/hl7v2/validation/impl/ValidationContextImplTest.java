/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.MockitoTest;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * Unit tests for ValidationContextImpl. 
 * 
 * @author Bryan Tripp
 * @author Christian Ohr 
 */
public class ValidationContextImplTest extends MockitoTest {
    
    private ValidationContextImpl myContext;
    private static final ValidationException[] PASS = new ValidationException[0];
    
    @Before
    public void setUp() throws Exception {
        myContext = new ValidationContextImpl();        
    }

    @Test
    public void testGetPrimitiveRules() {       
        PrimitiveTypeRule rule1 = mockRule(String.class, PrimitiveTypeRule.class);
        PrimitiveTypeRule rule2 = mockRule(String.class, PrimitiveTypeRule.class);
        myContext.getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5", "ST", rule1));
        myContext.getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5", "FT", rule2));        
        assertOnlyElement(rule1, myContext.getPrimitiveRules("2.5", "ST", null));
    }

    @Test    
    public void testGetMessageRules() {
        MessageRule rule1 = mockRule(Message.class, MessageRule.class);
        MessageRule rule2 = mockRule(Message.class, MessageRule.class);
        myContext.getMessageRuleBindings().add(new MessageRuleBinding("2.5", "ADT", "A01", rule1));
        myContext.getMessageRuleBindings().add(new MessageRuleBinding("2.5", "ADT", "A04", rule2));
        assertOnlyElement(rule1, myContext.getMessageRules("2.5", "ADT", "A01"));
    }
    
    @Test    
    public void testGetWildcardMessageRules1() {
        MessageRule rule1 = mockRule(Message.class, MessageRule.class);
        myContext.getMessageRuleBindings().add(new MessageRuleBinding("2.5", "ADT", "*", rule1));
        assertOnlyElement(rule1, myContext.getMessageRules("2.5", "ADT", "A01"));
    }    

    @Test    
    public void testGetEncodingRules() {
    	EncodingRule rule1 = mockRule(String.class, EncodingRule.class);
        myContext.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("2.5", "XML", rule1));
        myContext.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("2.5", "ER7", rule1));
        assertOnlyElement(rule1, myContext.getEncodingRules("2.5", "XML"));
    }
    
    private <S, T extends Rule<S>> T mockRule(Class<S> testClass, Class<T> ruleClass) {
    	T rule = mock(ruleClass);
    	when(rule.apply(any(testClass))).thenReturn(PASS);
    	return rule;
    }
    
    private <T> void assertOnlyElement(T elem, Collection<T> c) {
    	assertNotNull(c);
    	assertEquals(1, c.size());
    	assertEquals(elem, c.iterator().next());
    }

}
