/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.Rule;
import junit.framework.TestCase;

/**
 * Unit tests for RuleBinding.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:32 $ by $Author: jamesagnew $
 */
public class RuleBindingTest extends TestCase {

    RuleBinding myBinding1;
    RuleBinding myBinding2;
    Rule myRule;
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myRule = new SizeRule(10);
        myBinding1 = new RuleBinding("*", "*", myRule);
        myBinding2 = new RuleBinding("2.5", "ST", myRule);
    }

    /**
     * Constructor for RuleBindingTest.
     * @param arg0
     */
    public RuleBindingTest(String arg0) {
        super(arg0);
    }

    public void testGetActive() {
        assertEquals(true, myBinding1.getActive());
        myBinding1.setActive(false);
        assertEquals(false, myBinding1.getActive());        
    }

    public void testGetVersion() {
        assertEquals("2.5", myBinding2.getVersion());
    }

    public void testGetScope() {
        assertEquals("ST", myBinding2.getScope());
    }

    public void testGetRule() {
        assertEquals(myRule, myBinding2.getRule());
    }

    public void testAppliesToVersion() {
        assertEquals(true, myBinding1.appliesToVersion("2.1"));        
        assertEquals(true, myBinding1.appliesToVersion("2.5"));        
        assertEquals(false, myBinding2.appliesToVersion("2.1"));        
        assertEquals(true, myBinding2.appliesToVersion("2.5"));        
    }

    public void testAppliesToScope() {
        assertEquals(true, myBinding1.appliesToScope("ST"));        
        assertEquals(true, myBinding1.appliesToScope("DT"));        
        assertEquals(true, myBinding2.appliesToScope("ST"));        
        assertEquals(false, myBinding2.appliesToScope("DT"));        
    }

}
