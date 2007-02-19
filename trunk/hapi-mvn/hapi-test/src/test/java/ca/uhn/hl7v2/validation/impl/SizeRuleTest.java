/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import junit.framework.TestCase;

/**
 * Unit tests for SizeRule. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:33 $ by $Author: jamesagnew $
 */
public class SizeRuleTest extends TestCase {

    private SizeRule myRule;
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myRule = new SizeRule(5);
    }

    /**
     * Constructor for SizeRuleTest.
     * @param arg0
     */
    public SizeRuleTest(String arg0) {
        super(arg0);
    }

    public void testCorrect() {
        String x = "xxxxxx";
        assertEquals(x, myRule.correct(x));
    }

    public void testTest() {
        assertEquals(true, myRule.test(null));
        assertEquals(true, myRule.test("foo"));
        assertEquals(true, myRule.test("foooo"));
        assertEquals(false, myRule.test("fooooo"));
    }

}
