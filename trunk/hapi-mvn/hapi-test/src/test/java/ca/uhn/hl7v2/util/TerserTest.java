package ca.uhn.hl7v2.util;

import junit.framework.TestCase;
import ca.uhn.hl7v2.model.v24.message.SIU_S12;
import ca.uhn.hl7v2.model.v24.datatype.CE;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.parser.*;

/**
 * JUnit tests for Terser
 * @author Bryan Tripp
 */
public class TerserTest extends TestCase {
    
    private SIU_S12 msg;
    private Terser t;
    
    /** Creates a new instance of TerserTest */
    public TerserTest(String arg) {
        super(arg);       
    }

    public void setUp() throws Exception {
        msg = new SIU_S12();
        msg.getMSH().getMessageType().getTriggerEvent().setValue("a");
        msg.getPATIENT().getPID().getBirthPlace().setValue("b");
        msg.getRESOURCES().getGENERAL_RESOURCE().getAIG().getResourceGroup(0).getIdentifier().setValue("c");
        msg.getRESOURCES().getGENERAL_RESOURCE().getAIG().getResourceGroup(1).getIdentifier().setValue("d");        
        msg.getRESOURCES(1).getGENERAL_RESOURCE().getAIG().getResourceGroup(0).getIdentifier().setValue("e"); 
        msg.getSCH().getPlacerContactPerson(0).getAssigningAuthority().getUniversalID().setValue("subcomp");
        t = new Terser(msg);
    }
    
    public void testMultiArg() throws Exception {
        Segment s = msg.getMSH();
        String test = Terser.get(s, 9, 0, 2, 1);
        assertEquals("a", test);
    }
    
    public void testSpec() throws Exception {
        String test = null;
        test = t.get("MSH-9-2");
        assertEquals("a", test);
        test = t.get("/MSH-9-2");
        assertEquals("a", test);
        test = t.get("/*H-9-2");
        assertEquals("a", test);

        test = t.get("/.PID-23");
        assertEquals("b", test);
        test = t.get("/.*ID-23-1-1");
        assertEquals("b", test);
        
        test = t.get("/.AIG-5-1");
        assertEquals("c", test);      
        test = t.get("/*RES*/GENERAL_RESOURCE/AIG-5-1");
        assertEquals("c", test);
        test = t.get("/*RES*/GENERAL_RESOURCE/AIG-5(1)-1");
        assertEquals("d", test);

        test = t.get("/*RES*(1)/GENERAL_RESOURCE/AIG-5(0)-1");
        assertEquals("e", test);

        t.set("/*RES*(1)/GENERAL_RESOURCE/AIG-5-1", "foo");
        test = t.get("/*RES*(1)/GENERAL_RESOURCE/AIG-5(0)-1");
        assertEquals("foo", test);

        //test subcomponent
        test = t.get("/SCH-12-9-2");
        assertEquals("subcomp", test);
        //ca.uhn.hl7v2.view.TreePanel.showInNewWindow(msg);        
    }
    
    public void testVaries() throws Exception {
        setUp();
        int n = this.msg.getMSH().numFields() + 1;
        Varies v = (Varies) this.msg.getMSH().getField(n, 0);
        Primitive p = (Primitive) v.getData(); //will be generic primitive 
        p.setValue("x");
        assertEquals("x", t.get("MSH-" + n));
        v.setData(new CE(this.msg));
        assertEquals("x", t.get("MSH-" + n));
        ((CE) v.getData()).getText().setValue("text");
        assertEquals("text", t.get("MSH-" + n + "-2"));
    }
    
    public void testExtraComponents() throws Exception {
        setUp();
        t.set("/MSH-9-4", "foo");
        assertEquals("foo", t.get("/MSH-9-4"));
        t.set("/MSH-9-4-2", "bar");
        assertEquals("bar", t.get("/MSH-9-4-2"));
        assertEquals("foo", t.get("/MSH-9-4-1"));
    }
    
    public void testWildcards() throws Exception {
        setUp();
        String test = t.get("MSH-9-2");
        assertEquals("a", test);
        test = t.get("*MSH-9-2");
        assertEquals("a", test);
        test = t.get("*SH-9-2");
        assertEquals("a", test);
        test = t.get("*S*-9-2");
        assertEquals("a", test);
        test = t.get("*H-9-2");
        assertEquals("a", test);
        test = t.get("MS*-9-2");
        assertEquals("a", test);
        test = t.get("*-9-2");
        assertEquals("a", test);

        try {
            test = t.get("*QQQ-9-2");
            fail("Should have thrown exception -- no structure has QQQ in its name.");
        } catch (Exception e) {}

        test = t.get("?SH-9-2");
        assertEquals("a", test);
        test = t.get("?S?-9-2");
        assertEquals("a", test);
        test = t.get("?S*-9-2");
        assertEquals("a", test);
        try {
            test = t.get("?MSH-9-2");
            fail("Should have thrown exception -- no structure has a single char followed by 'MSH'.");
        } catch (Exception e) {}                
    }

    /**
     * These test cases are from Phil Trewhella (bug report submitted to list 
     * on 31/08/2003) ... 
     */
    public void testSearch() throws Exception {
        String msg = "MSH|^~\\&|POW|100||100|200012171800||RDE^O11|14718|P|2.4|||AL|NE|0\r" + 
            "PID|0001|99999|2000006|000077777|Possible^Kim^||195002220000|F||1|100 E San Marcos Blvd^^San Marcos^CA^92069^USA^^^San Diego|||||M||2000006|123-45-6789|A0012345^CA||1|||||||||\r" + 
            "ORC|NW|RX1|RX1||IP||^BID^X001^200012171800^200308200600|2045&OE^123&PH|200012171800|Nurse1|Nurse2|1^Order MD|||200012171800||||\r" + 
            "RXR|XXX\r" + 
            "RXE|^BID^X001^200012171800^200308200600|99089^DIGOXIN (LANOXIN) -- 0.25 mg|0.2500|0.2500|mg|TA|111^||||||||||||||222^||||0.0000|||||\r" + 
            "RXR|PO||\r"; 
        
        PipeParser pipeParser = new PipeParser();
        
        /*
         * Note, these test cases assume the old behaviour of handling
         * unexpected segments
         */
        pipeParser.setLegacyMode(true);
        
        Message message = pipeParser.parse(msg); 
        Terser terser = new Terser(message); 
        //ca.uhn.hl7v2.view.TreePanel.showInNewWindow(message);
        //Thread.sleep(30000);

        String value = terser.get("/.ORC-2");                    
        assertEquals("RX1", value);
        value = terser.get("/ORDER*/RXR-1");    
        assertEquals("PO", value);
        value = terser.get("/*ORDER*/RXR-1");    
        assertEquals("PO", value);
        value = terser.get("/ORDER*/RXE-1-2");                    
        assertEquals("BID", value);        
        value = terser.get("/.ORC-1-1");      
        assertEquals("NW", value);
        value = terser.get("/.RXE-1-2");      // fixed ... original error: yields HL7Exception: End of message reached -- this is a peer to ORC, which does work with same syntax 
        assertEquals("BID", value);
        value = terser.get("/.RXR-1");                            // makes sense ... value is in 2nd RXR ... adding segment before RXE to test this ... original error: yields "null" instead of "PO" 
        assertEquals("XXX", value);
        //value = terser.get("/.RDE_O11_RXR/RXR-1");            // makes sense ... value is in 2nd RXR ... original error: yields "null" instead of "PO" 
        //assertEquals("XXX", value);
        value = terser.get("/ORDER*/.RXR(0)-1");        // as above 
        assertEquals("XXX", value);
        value = terser.get("/ORDER*/.RXR-1");            // as above 
        assertEquals("XXX", value);
        //value = terser.get("/RDE_O11_ORC*/.RXR-1");            // try getting to the PO value 
        //assertEquals("PO", value);

        //value = terser.get("/RDE_O11_ORC*/*/RXR-1");            // OK (* finds first structure): yields NoSuchElementException 
        //value = terser.get("/*/RDE_O11_RXR/RXR-1");            // OK (* finds first structure): yields NoSuchElementException 
    }
    
    public void testEnumerators() throws Exception {
        setUp();
        Segment s = t.getSegment("MSH");
        assertEquals(3, Terser.numComponents(s.getField(9, 0)));
        s.getField(9, 0).getExtraComponents().getComponent(0);
        assertEquals(4, Terser.numComponents(s.getField(9, 0)));
        s.getField(9, 0).getExtraComponents().getComponent(1);
        assertEquals(5, Terser.numComponents(s.getField(9, 0)));
        
        s.getField(2, 0).getExtraComponents().getComponent(0);
        assertEquals(2, Terser.numComponents(s.getField(2, 0)));
        
        ((Primitive) ((Composite) s.getField(9, 0)).getComponent(0).getExtraComponents().getComponent(0).getData()).setValue("xxx");
        assertEquals(2, Terser.numSubComponents(s.getField(9, 0), 1));
                
    }   
}
