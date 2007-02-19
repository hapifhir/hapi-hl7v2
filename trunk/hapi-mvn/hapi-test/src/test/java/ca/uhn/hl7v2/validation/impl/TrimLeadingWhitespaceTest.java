/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import junit.framework.TestCase;

/**
 * Unit tests for TrimLeadingWhitespace. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:32 $ by $Author: jamesagnew $
 */
public class TrimLeadingWhitespaceTest extends TestCase {

    private PrimitiveTypeRule myRule;
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myRule = new TrimLeadingWhitespace();
    }

    /**
     * Constructor for TrimLeadingWhitespaceTest.
     * @param arg0
     */
    public TrimLeadingWhitespaceTest(String arg0) {
        super(arg0);
    }

    public void testCorrect() {
        assertEquals("foo", myRule.correct("  foo"));
        assertEquals("foo  ", myRule.correct(" \t  \t foo  "));
    }

    public void testTest() {
        assertTrue(myRule.test(" anything "));
    }

}
