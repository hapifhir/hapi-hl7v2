/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import junit.framework.TestCase;

/**
 * Unit tests for RegexPrimitiveRule. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:33 $ by $Author: jamesagnew $
 */
public class RegexPrimitiveRuleTest extends TestCase {

    private PrimitiveTypeRule myRule;
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myRule = new RegexPrimitiveRule("\\d{4}", "2");
    }

    /**
     * Constructor for RegexPrimitiveRuleTest.
     * @param arg0
     */
    public RegexPrimitiveRuleTest(String arg0) {
        super(arg0);
    }

    public void testTest() {
        assertEquals(true, myRule.test("5555"));
        assertEquals(false, myRule.test("55555"));
        assertEquals(false, myRule.test("555"));
        assertEquals(false, myRule.test("xxxx"));
    }

    public void testCorrect() {
        assertEquals("foo", myRule.correct("foo"));
    }

}
