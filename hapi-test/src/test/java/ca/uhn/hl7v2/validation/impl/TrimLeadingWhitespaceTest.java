/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;

/**
 * Unit tests for TrimLeadingWhitespace. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr 
 */
@SuppressWarnings("deprecation")
public class TrimLeadingWhitespaceTest {

    private PrimitiveTypeRule myRule;
    
    @Before
    public void setUp() throws Exception {
        myRule = new TrimLeadingWhitespace();
    }

    @Test
    public void testCorrect() {
        assertEquals("foo", myRule.correct("  foo"));
        assertEquals("foo  ", myRule.correct(" \t  \t foo  "));
    }

    @Test
    public void testTest() {
        assertTrue(myRule.test(" anything "));
    }

}
