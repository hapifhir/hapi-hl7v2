/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;

/**
 * Unit tests for RegexPrimitiveRule. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr 
 */
@SuppressWarnings("deprecation")
public class RegexPrimitiveRuleTest {

    private PrimitiveTypeRule myRule;
    
   
	@Before
    public void setUp() throws Exception {
        myRule = new RegexPrimitiveRule("\\d{4}", "2");
    }

	@Test
    public void testTest() {
        assertTrue(myRule.test("5555"));
        assertFalse(myRule.test("55555"));
        assertFalse(myRule.test("555"));
        assertFalse(myRule.test("xxxx"));
    }

    @Test
    public void testCorrect() {
        assertEquals("foo", myRule.correct("foo"));
    }

}
