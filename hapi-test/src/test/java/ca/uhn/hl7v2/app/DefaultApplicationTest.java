package ca.uhn.hl7v2.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;

/**
 * 
 * @author Bryan Tripp
 */
public class DefaultApplicationTest {  
    
    @Test
    public void testProcessMessage() throws Exception {
    	DefaultApplication app = new DefaultApplication();
    	Message in = new ca.uhn.hl7v2.model.v24.message.ACK();
        Message out = app.processMessage(in, null);
        Terser t = new Terser(out);
        assertEquals(AcknowledgmentCode.AR.name(), t.get("/MSA-1"));
        assertEquals("207", t.get("/ERR-1(0)-4-1"));
    }
}
