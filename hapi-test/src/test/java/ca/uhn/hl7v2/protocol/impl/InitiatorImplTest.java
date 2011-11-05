/*
 * Created on 19-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.util.Terser;
import junit.framework.TestCase;

/**
 * Unit tests for <code>InitiatorImpl</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class InitiatorImplTest extends TestCase {

    private InitiatorImpl myInitiator;
    private MockProcessor myProcessor; 
    
    private String AA = "MSH|^~\\&|||||||ACK^A01|b|P|2.4\rMSA|AA|a\r";
    private String AE = "MSH|^~\\&|||||||ACK^A01|b|P|2.4\rMSA|AE|a\r";
    
    /**
     * Constructor for InitiatorImplTest.
     * @param arg0
     */
    public InitiatorImplTest(String arg0) {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myProcessor = new MockProcessor();
        myInitiator = new InitiatorImpl(myProcessor);
    }

    public void testAck() throws Exception {
        myProcessor.setNextMessage(AA);
        
        ADT_A01 message = new ADT_A01();
        message.getMSH().getFieldSeparator().setValue("|");
        message.getMSH().getEncodingCharacters().setValue("^~\\&");
        message.getMSH().getApplicationAcknowledgmentType().setValue("AL");
        myInitiator.setReceiveTimeout(0);
        Message response = myInitiator.sendAndReceive(message);
        Terser t = new Terser(response);
        assertEquals("b", t.get("/MSH-10"));
    }

    public void testNoAck() throws Exception {
        myProcessor.setNextMessage(AA);
        
        ADT_A01 message = new ADT_A01();
        message.getMSH().getFieldSeparator().setValue("|");
        message.getMSH().getEncodingCharacters().setValue("^~\\&");
        message.getMSH().getApplicationAcknowledgmentType().setValue("NE");

        myInitiator.setReceiveTimeout(0);
        Message response = myInitiator.sendAndReceive(message);
        assertEquals(null, response);
    }
    
    public void testTimeout() throws Exception {        
        ADT_A01 message = new ADT_A01();
        message.getMSH().getFieldSeparator().setValue("|");
        message.getMSH().getEncodingCharacters().setValue("^~\\&");
        message.getMSH().getApplicationAcknowledgmentType().setValue("AL");
        myInitiator.setReceiveTimeout(1000); //other params don't matter because we're using mock processor
        long start = System.currentTimeMillis();
        Message response = myInitiator.sendAndReceive(message);
        long end = System.currentTimeMillis();
        assertEquals(null, response);
        assertTrue(end - start >= 1000);
    }
    
    public void testError() throws Exception {
        myProcessor.setNextMessage(AE);
        
        ADT_A01 message = new ADT_A01();
        message.getMSH().getFieldSeparator().setValue("|");
        message.getMSH().getEncodingCharacters().setValue("^~\\&");
        message.getMSH().getApplicationAcknowledgmentType().setValue("ER");
        myInitiator.setReceiveTimeout(0);
        Message response = myInitiator.sendAndReceive(message);
        Terser t = new Terser(response);
        assertEquals("b", t.get("/MSH-10")); 
    }
    
    public void testCharset() throws Exception {
        MockProcessor p = new MockProcessor();
        InitiatorImpl i = new InitiatorImpl(p);
        ADT_A01 a01 = new ADT_A01();
        Terser t = new Terser(a01);
        t.set("MSH-1", "|");
        t.set("MSH-2", "^~\\&");
        t.set("MSH-18", "UNICODE");
        i.sendAndReceive(a01);
        assertEquals("UNICODE", p.getSent().getMetadata().get("MSH-18"));
    }

    /**
     * A skeletal mock implementation of <code>Processor</code> with which you 
     * can control messages returned via receive(). 
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
     */    
    private class MockProcessor implements Processor {
        
        private String myNextMessage;
        private Transportable mySent;
        
        public void setNextMessage(String theMessage) {
            myNextMessage = theMessage;
        }

        public void send(Transportable arg0, int arg1, long arg2) throws HL7Exception {
            mySent = arg0;
        }
        
        public Transportable getSent() {
            return mySent;
        }

        public void reserve(String arg0, long arg1) {
        }

        public void cycle(boolean arg0) throws HL7Exception {
        }

        public boolean isAvailable(String arg0) {
            return true;
        }

        /**
         * Returns the message specified with setNextMessage() at the end of the 
         * specified timeout period.  
         */
        public Transportable receive(String arg0, long arg1) throws HL7Exception {
            try {
                Thread.sleep(arg1);
            } catch (InterruptedException e) {
                throw new HL7Exception("Interrupted while sleeping -- may return before timeout");
            }
            return new TransportableImpl(myNextMessage);
        }

        public ProcessorContext getContext() {
            return null;
        }

		public void stop() {
		}
        
    }
    
    
}
