/*
 * Created on 17-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.protocol.MockApplicationRouter;
import ca.uhn.hl7v2.protocol.MockTransport;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:39 $ by $Author: jamesagnew $
 */
public class ProcessorImplTest extends TestCase {

    private ProcessorImpl myProcessor;
    private MockTransport myTransport;
    private MockTransport myRemotelyDrivenTransport;
    private MockApplicationRouter myRouter;
     
    /**
     * Constructor for ProcessorImplTest.
     * @param arg0
     */
    public ProcessorImplTest(String arg0) {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myTransport = new MockTransport();
        myTransport.connect();
        myRemotelyDrivenTransport = new MockTransport();
        myRouter = new MockApplicationRouter();
        NullSafeStorage storage = new NullSafeStorage(); 
        ProcessorContext context = 
            new ProcessorContextImpl(myRouter, myTransport, myRemotelyDrivenTransport, storage);
        myProcessor = new ProcessorImpl(context, true);
    }
    
    
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		
		myProcessor.stop();
		
	}

	public void testSendNoAcceptAck() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||NE\rNTE|\r";
        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
    } 
    
    public void testSendWithAcceptAck() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||AL\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CA|msg-a\r";
        myTransport.setNextReceived(new TransportableImpl(b));

        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
    }
    
    public void testSendRetryOnReject() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||AL\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CR|msg-a\r";
        String c = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CA|msg-a\r";
        myTransport.setNextReceived(new TransportableImpl(b));
        receiveLater(myTransport, c, 1000);

        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
        assertTrue(myTransport.getSentMessages().size() > 1);        
    }
    
    public void testSendRetryOnNoAnswer() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||AL\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CA|msg-a\r";
        receiveLater(myTransport, b, 1500);
        
        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
        assertTrue(myTransport.getSentMessages().size() > 1); 
    }
    
    public void testSendAckOnErrorNoError() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||ER\rNTE|\r";
        myProcessor.send(new TransportableImpl(a), 3, 1000); //should return because no response received in time 
        assertEquals(a, myTransport.getLastSent().getMessage());        
    }
    
    public void testSendAckOnErrorWithError() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||ER\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CE|msg-a|foo\r";
        receiveLater(myTransport, b, 200);
        try {
            myProcessor.send(new TransportableImpl(a), 3, 1000);  
            fail("should have thrown exception when error message received");
        } catch (HL7Exception e) {
            assertTrue(e.getMessage().indexOf("foo") > -1); 
        }
    }
    
    public void testSendAlwaysAckWithError() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||AL\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CE|msg-a|foo\r";
        receiveLater(myTransport, b, 200);
        try {
            myProcessor.send(new TransportableImpl(a), 3, 1000);  
            fail("should have thrown exception when error message received");
        } catch (HL7Exception e) {
            assertTrue(e.getMessage().indexOf("foo") > -1); 
        }        
    }
    
    public void testSendNeverAckWithError() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||NE\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CE|msg-a|foo\r";
        receiveLater(myTransport, b, 200);
        myProcessor.send(new TransportableImpl(a), 3, 1000); //no error because we don't wait for the ACK  
    }
    
    public void testReceive() throws Exception {
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r";
        receiveLater(myRemotelyDrivenTransport, b, 200);
        Transportable got = myProcessor.receive("msg-a", 2000);
        assertEquals(b, got.getMessage());
    }

    public void testReceiveWithInvalid() throws Exception {
        String b = "MSH{{{{{|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r";
        receiveLater(myRemotelyDrivenTransport, b, 200);
        Transportable got = myProcessor.receive("msg-a", 2000);
        assertEquals(null, got);
    }

    public void testReceiveNotAvailable() throws Exception {
        Transportable got = myProcessor.receive("msg-a", 2000);
        assertEquals(null, got); 
    }
    
    public void testReceiveNonMatchingAckId() throws Exception {
        //Prevents NullPointerException (AppRouter will try to respond to unsolicited message) ... 
        myRouter.setNextReply(new TransportableImpl("MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r"));  
        
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r";
        receiveLater(myRemotelyDrivenTransport, b, 1000);
        Transportable got = myProcessor.receive("doesn't exist", 2000);
        assertEquals(null, got);        
    }

    public void receiveLater(final MockTransport theTransport, final String theMessage, final long theTimeMillis) {
        Thread sender = new Thread() {
            public void run() {
                try {
                    Thread.sleep(theTimeMillis);
                } catch (InterruptedException e) {
                }                
                theTransport.setNextReceived(new TransportableImpl(theMessage));
            }
        };
        sender.start();
    }

}
