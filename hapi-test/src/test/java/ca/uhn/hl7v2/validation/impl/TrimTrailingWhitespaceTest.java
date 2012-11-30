package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;

/**
 * Unit tests for TrimTrailingWhitespace. 
 * 
 * @author Christian Ohr 
 */
@SuppressWarnings("deprecation")
public class TrimTrailingWhitespaceTest {

    private PrimitiveTypeRule myRule;
    
    @Before
    public void setUp() throws Exception {
        myRule = new TrimTrailingWhitespace();
    }

    @Test
    public void testCorrect() {
        assertEquals("foo", myRule.correct("foo  "));
        assertEquals(" foo", myRule.correct(" foo \t  \t  "));
    }

    @Test
    public void testTest() {
        assertTrue(myRule.test(" anything "));
    }

}
