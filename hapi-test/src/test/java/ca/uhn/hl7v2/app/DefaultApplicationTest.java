package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.util.Terser;

/**
 * 
 * @author Bryan Tripp
 */
public class DefaultApplicationTest {

    Segment inbound;
    Segment outbound;
    Message in;
    DefaultApplication app; 
    
    @Before
    public void setUp() throws Exception {
        app = new DefaultApplication();
        in = new ca.uhn.hl7v2.model.v24.message.ACK();
        Terser t = new Terser(in);
        t.set("/MSH-1", "|");
        t.set("/MSH-2", "^~\\&");
        t.set("/MSH-11", "D");
        t.set("/MSH-12", "2.4");
        t.set("/MSH-10", "boo");
        inbound = (Segment) in.get("MSH");
        /*inbound.controlEncodingCharacters().setValue("^~\\&");
        inbound.controlFieldSeparator().setValue("|");
        inbound.controlProcessingID().setValue("D");
        inbound.controlVersionID().setValue("2.4");
        inbound.controlMessageControlID().setValue("boo");*/
    }
    
    @Test
    public void testFillResponseHeader() throws HL7Exception, IOException {
        Segment outbound = new ca.uhn.hl7v2.model.v24.segment.MSH(
                new GenericMessage.V24(new DefaultModelClassFactory()), new DefaultModelClassFactory());
        DefaultApplication.fillResponseHeader(inbound, outbound);        
        assertEquals(Terser.get(outbound, 2, 0, 1, 1), "^~\\&");
        assertEquals(Terser.get(outbound, 1, 0, 1, 1), "|");
        assertEquals(Terser.get(outbound, 11, 0, 1, 1), "D");
        //TS messTime = (TS) outbound.controlDateTimeOfMessage();     
        String id1 = Terser.get(outbound, 10, 0, 1, 1);
        DefaultApplication.fillResponseHeader(inbound, outbound);
        String id2 = Terser.get(outbound, 10, 0, 1, 1);
        assertTrue(!id1.equals(id2));
    }
    
    @Test
    public void testMakeACK() throws Exception {
        Message ack = DefaultApplication.makeACK(inbound);
        Terser t = new Terser(ack);
        assertEquals("2.4", t.get("/MSH-12"));
        assertEquals(ack.getClass(), ca.uhn.hl7v2.model.v24.message.ACK.class);
        assertEquals("AA", t.get("/MSA-1"));
        assertEquals("boo", t.get("/MSA-2"));
    }
    
    @Test
    public void testProcessMessage() throws Exception {
        Message out = app.processMessage(in);
        Terser t = new Terser(out);
        assertEquals("AR", t.get("/MSA-1"));
        assertEquals("207", t.get("/ERR-1(0)-4-1"));
        //Parser parser = new PipeParser();
        //System.out.println(parser.encode(out));
    }
}
