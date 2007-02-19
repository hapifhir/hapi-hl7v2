package ca.uhn.hl7v2.util;

import junit.framework.*;
import ca.uhn.hl7v2.model.v24.message.*;
import ca.uhn.hl7v2.model.*;

/**
 * JUnit tests for MessageIterator.  
 * @author bryan
 */
public class MessageIteratorTest extends TestCase {
    
    public MessageIteratorTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(MessageIteratorTest.class);
        return suite;
    }
    
    /**
     * Test cases include: 
     * - false if doesn't contain 
     * - true if contains as first child 
     * - true if contains as first grandchild 
     * - false if contains as child after 1st required child if this flag is set
     */
    public void testContains() throws Exception {
        ADT_A01 msg = new ADT_A01();
        assertEquals(false, MessageIterator.contains(msg, "BOO", false, false));
        assertTrue(MessageIterator.contains(msg, "MSH", true, true));
        assertTrue(MessageIterator.contains(msg.getINSURANCE(), "IN1", true, true));
        assertTrue(MessageIterator.contains(msg, "IN1", false, false));
        assertEquals(false, MessageIterator.contains(msg, "IN2", false, true));
        assertEquals(true, MessageIterator.contains(msg, "IN2", false, false));
    }
    
    /**
     * Test cases include: 
     * - correct index of a child 
     * - null if child isn't there
     */
    public void testGetIndex() throws Exception {
        ADT_A01 msg = new ADT_A01();
        MessageIterator.Index i = MessageIterator.getIndex(msg, msg.getDB1(0));
        assertEquals(i, new MessageIterator.Index("DB1", 0));
        assertEquals(null, MessageIterator.getIndex(msg, msg.getPROCEDURE().getROL()));        
    }
    
    /**
     * Positive and negative test. 
     */
    public void testIsLast() throws Exception {
        ADT_A01 msg = new ADT_A01();
        MessageIterator.Position last = new MessageIterator.Position(msg, "PDA", 0);
        MessageIterator.Position notLast = new MessageIterator.Position(msg, "ACC", 0);        
        assertTrue(MessageIterator.isLast(last));
        assertTrue(!MessageIterator.isLast(notLast));
    }

    /**
     * Test cases include: 
     * - false if not there at all  
     * - false if earlier in message
     * - true if in current repeating group 
     * - true if in later sibling of parent 
     * Wish list: 
     * - true if in repeating grandparent 
     * - false if earlier in current non-repeating group
     */
    public void testMatchExistsAfterPosition() throws Exception {
        ADT_A01 msg = new ADT_A01();
        MessageIterator.Position start = new MessageIterator.Position(msg.getINSURANCE(), "IN2", 0);
        assertEquals(false, MessageIterator.matchExistsAfterPosition(start, "FOO", false, true));
        assertEquals(false, MessageIterator.matchExistsAfterPosition(start, "MSH", false, false));
        assertEquals(true, MessageIterator.matchExistsAfterPosition(start, "IN1", true, true));
        assertEquals(true, MessageIterator.matchExistsAfterPosition(start, "IN2", false, false));
        assertEquals(false, MessageIterator.matchExistsAfterPosition(start, "IN2", true, true));
        assertEquals(true, MessageIterator.matchExistsAfterPosition(start, "ACC", true, true));        
    }
    
    /** 
     * Test cases include: 
     * - true if not at end of message
     * - false if at end of message 
     */
    public void testHasNext() throws Exception {
        ADT_A01 msg = new ADT_A01();
        MessageIterator it = new MessageIterator(msg.getUB2(), "PDA", false);
        assertEquals(true, it.hasNext());
        it = new MessageIterator(msg.getPDA(), "PDA", false);
        assertEquals(false, it.hasNext());
    }
    
    /**
     * Test cases include: 
     * - to next rep if direction matches current repeating segment 
     * - from one sibling to the next if direction doesn't match current repeating segment
     * - from group to 1st child 
     * - from end of group to next rep of group if group contains direction as first child
     * - from end of group to next sibling if group doesn't contain direction
     * - from end of group to next sibling if group contains direction after another required child 
     * - fail if at end of message 
     * - new segment if there are no matching structures 
     */
    public void testNext() throws Exception {
        ADT_A01 msg = new ADT_A01();
        MessageIterator it = new MessageIterator(msg.getROL(), "ROL", false);
        assertEquals("next rep if dir matches repeating segment", msg.getROL(1), it.next());
        it.setDirection("PDA");
        assertEquals("next sibling if dir doesn't match repeating segment", msg.getNK1(), it.next());
        System.out.println(it.next());
        it.setDirection("PV1");
        assertEquals("next sibling if dir matches non-repeating segment", msg.getPV2(), it.next());
        
        it = new MessageIterator(msg.getPROCEDURE(), "PDA", false);
        assertEquals("group to child", msg.getPROCEDURE().getPR1(), it.next());
        it.setDirection("PR1");
        System.out.println(it.next());
        assertEquals("next rep of group if 1st child matches dir", msg.getPROCEDURE(1), it.next());
        
        it = new MessageIterator(msg.getPROCEDURE().getROL(), "PDA", false);
        assertEquals("next sibling of parent if group doesn't contain direction", msg.getGT1(), it.next());
        
        it = new MessageIterator(msg.getINSURANCE().getROL(), "IN3", false);
        assertEquals("next sib of parent if contains dir after required child", msg.getACC(), it.next());
        
        it = new MessageIterator(msg.getPDA(), "FOO", false);
        try {
            it.next();
            fail("should have thrown no such element exception on attempt to iterate past end of message");
        } catch (java.util.NoSuchElementException e) { /* OK */  } 
            
        it = new MessageIterator(msg.getPDA(), "FOO", true);
        Segment s = (Segment) it.next();
        assertEquals("FOO", s.getName());
        
        it = new MessageIterator(msg.getINSURANCE().getROL(), "BAR", true);
        s = (Segment) it.next();
        assertEquals("BAR", s.getName());
        assertEquals("BAR added as a child of IN1 group", 5, msg.getINSURANCE().getNames().length);
        
    }
    
    
}
