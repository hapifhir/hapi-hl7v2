/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/**
 * Unit tests for SizeRule. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr 
 */
@SuppressWarnings("deprecation")
public class SizeRuleTest {


	private SizeRule myRule;
    
    @Before
    public void setUp() throws Exception {
        myRule = new SizeRule(5);
    }

    @Test
    public void testCorrect() {
        String x = "xxxxxx";
        assertEquals(x, myRule.correct(x));
    }

    @Test    
    public void testTest() {
        assertTrue(myRule.test(null));
        assertTrue(myRule.test("foo"));
        assertTrue(myRule.test("foooo"));
        assertFalse(myRule.test("fooooo"));
    }

}
