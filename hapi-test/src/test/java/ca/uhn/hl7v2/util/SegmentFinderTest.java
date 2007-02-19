package ca.uhn.hl7v2.util;

import junit.framework.TestCase;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.ROL;
import ca.uhn.hl7v2.model.Segment;

/**
 * JUnit tests for SegmentFinder
 * @author  bryan
 */
public class SegmentFinderTest extends TestCase {
    
    private SegmentFinder finder; 
    
    /** Creates a new instance of SegmentFinderTest */
    public SegmentFinderTest(String arg) {
        super(arg);
    }
    
    public void setUp() throws Exception {
        ADT_A01 msg = new ADT_A01();
        msg.getROL().getActionCode().setValue("a");
        msg.getROL2().getActionCode().setValue("b");
        msg.getPROCEDURE().getROL().getActionCode().setValue("c");
        msg.getINSURANCE().getROL().getActionCode().setValue("d");
        finder = new SegmentFinder(msg);
    }
    
    public void testFind() throws Exception {
        Segment s = finder.findSegment("ROL", 0);
        assertEquals("a", getTestVal(s));
        s = finder.findSegment("ROL", 0);   
        assertEquals("b", getTestVal(s));
        s = finder.findSegment("ROL", 0);
        assertEquals("c", getTestVal(s));
        s = finder.findSegment("ROL", 0);
        assertEquals("d", getTestVal(s));        
    }
    
    private String getTestVal(Segment s) {
        ROL rol = (ROL) s;
        return rol.getActionCode().getValue();
    }
}
