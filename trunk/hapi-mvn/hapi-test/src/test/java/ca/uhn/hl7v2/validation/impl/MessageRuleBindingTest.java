/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Unit tests for MessageRuleBinding.
 *
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr
 */
public class MessageRuleBindingTest {

    @Test
    public void testAppliesToAllScope() {
        MessageRuleBinding binding1 = new MessageRuleBinding("*", "*", "*", null);
        assertTrue(binding1.appliesToVersion("2.1"));
        assertTrue(binding1.appliesToVersion("2.5"));
        assertTrue(binding1.appliesToScope("ADT^A01"));
        assertTrue(binding1.appliesToScope("ORU^R01"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidScope() {
        MessageRuleBinding binding1 = new MessageRuleBinding("*", "*", "*", null);
        binding1.appliesToScope("foo");
    }

    @Test
    public void testAppliesToSingleScope() {
        MessageRuleBinding binding2 = new MessageRuleBinding("2.5", "ADT", "A01", null);
        assertTrue(binding2.appliesToVersion("2.5"));
        assertFalse(binding2.appliesToVersion("2.1"));
        assertTrue(binding2.appliesToScope("ADT^A01"));
        assertFalse(binding2.appliesToScope("ADT^A04"));
    }

}
