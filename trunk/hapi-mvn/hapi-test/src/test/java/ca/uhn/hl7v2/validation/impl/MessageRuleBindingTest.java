/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import junit.framework.TestCase;

/**
 * Unit tests for MessageRuleBinding. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:33 $ by $Author: jamesagnew $
 */
public class MessageRuleBindingTest extends TestCase {

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Constructor for MessageRuleBindingTest.
     * @param arg0
     */
    public MessageRuleBindingTest(String arg0) {
        super(arg0);
    }

    /**
     * ...
     */
    public void testAppliesToScope() {
        MessageRuleBinding binding1 = new MessageRuleBinding("*", "*", "*", null);
        assertTrue(binding1.appliesToVersion("2.1"));
        assertTrue(binding1.appliesToVersion("2.5"));
        assertTrue(binding1.appliesToScope("ADT^A01"));
        assertTrue(binding1.appliesToScope("ORU^R01"));
        try {
            binding1.appliesToScope("foo");
            fail("Invalid scope for MessageRule");
        } catch (IllegalArgumentException e) {}
        
        MessageRuleBinding binding2 = new MessageRuleBinding("2.5", "ADT", "A01", null);
        assertTrue(binding2.appliesToVersion("2.5"));
        assertEquals(false, binding2.appliesToVersion("2.1"));
        assertTrue(binding2.appliesToScope("ADT^A01"));
        assertEquals(false, binding2.appliesToScope("ADT^A04"));        
    }

}
