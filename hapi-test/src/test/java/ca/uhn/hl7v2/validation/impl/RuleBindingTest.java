/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;

/**
 * Unit tests for RuleBinding.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr 
 */
@SuppressWarnings("deprecation")
public class RuleBindingTest {

    RuleBinding<PrimitiveTypeRule> myBinding1;
    RuleBinding<PrimitiveTypeRule> myBinding2;
    PrimitiveTypeRule myRule;
    
    @Before
    public void setUp() throws Exception {
        myRule = new SizeRule(10);
        myBinding1 = new RuleBinding<PrimitiveTypeRule>("*", "*", myRule);
        myBinding2 = new RuleBinding<PrimitiveTypeRule>("2.5", "ST", myRule);
    }

    @Test
    public void testGetActive() {
        assertTrue(myBinding1.getActive());
        myBinding1.setActive(false);
        assertFalse(myBinding1.getActive());        
    }

    @Test
    public void testGetVersion() {
        assertEquals("2.5", myBinding2.getVersion());
    }

    @Test
    public void testGetScope() {
        assertEquals("ST", myBinding2.getScope());
    }

    @Test
    public void testGetRule() {
        assertEquals(myRule, myBinding2.getRule());
    }

    @Test
    public void testAppliesToVersion() {
        assertTrue(myBinding1.appliesToVersion("2.1"));        
        assertTrue(myBinding1.appliesToVersion("2.5"));        
        assertFalse(myBinding2.appliesToVersion("2.1"));        
        assertTrue(myBinding2.appliesToVersion("2.5"));        
    }

    @Test
    public void testAppliesToScope() {
        assertTrue(myBinding1.appliesToScope("ST"));        
        assertTrue(myBinding1.appliesToScope("DT"));        
        assertTrue(myBinding2.appliesToScope("ST"));        
		assertFalse(myBinding2.appliesToScope("DT"));        
    }

}
