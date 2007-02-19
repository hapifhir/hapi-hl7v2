package ca.uhn.hl7v2.util;

import junit.framework.*;
import ca.uhn.hl7v2.model.v24.message.*;
import ca.uhn.hl7v2.model.v24.segment.*;

/**
 * JUnit tests for MessageNavigator. 
 * @author  bryan
 */
public class MessageNavigatorTest extends TestCase {
    
    MessageNavigator nav;
    ADT_A01 msg;
    
    /** Creates a new instance of MessageNavigatorTest */
    public MessageNavigatorTest(String val) {
        super(val);
    }
    
    public void setUp() throws Exception {
        this.msg = new ADT_A01();
        this.msg.getINSURANCE().getIN1().getCoverageType().setValue("a");
        this.msg.getMSH().getCountryCode().setValue("b");
        this.msg.getPD1().getHandicap().setValue("c");
        this.nav = new MessageNavigator(msg);        
    }
    
    public void testNavigate() throws Exception {
        nav.drillDown(16, 0);        
        IN1 in1 = (IN1) nav.getCurrentStructure(0);
        assertEquals("a", in1.getCoverageType().getValue());
        
        nav.reset();
        nav.nextChild();
        MSH msh = (MSH) nav.getCurrentStructure(0);
        assertEquals("b", msh.getCountryCode().getValue());
        
        nav.reset();
        nav.nextChild();
        nav.nextChild();
        nav.nextChild();
        nav.nextChild();
        PD1 pd1 = (PD1) nav.getCurrentStructure(0);
        assertEquals("c", pd1.getHandicap().getValue());
    }
    
    public void testIterator() throws Exception {
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        nav.iterate(true, false);
        IN1 in1 = (IN1) nav.getCurrentStructure(0);
        assertEquals("a", in1.getCoverageType().getValue());   
        
        nav.reset();
        nav.toChild(3);
        PD1 pd1 = (PD1) nav.getCurrentStructure(0);
        assertEquals("c", pd1.getHandicap().getValue());
    }
}
