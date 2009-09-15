/*
 * Created on 17-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.NullSafeStorage;
import ca.uhn.hl7v2.protocol.impl.ProcessorContextImpl;
import ca.uhn.hl7v2.protocol.impl.ProcessorImpl;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;
import ca.uhn.hl7v2.protocol.tests.MockApplicationRouter;
import ca.uhn.hl7v2.protocol.tests.MockTransport;

/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ProcessorImplTest {

    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ProcessorImplTest.class);
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    }
    
    private Processor myProcessor;
    private MockTransport myTransport;
    private MockTransport myRemotelyDrivenTransport;
    private MockApplicationRouter myRouter;
     

    /**
     * 
     * @throws TransportException
     */
    @Before
    public void BeforeTheTest() throws TransportException {
	logger.info("*****************************BeforeTheTest******************************************");
        myTransport = new MockTransport();
        myTransport.connect();
        myRemotelyDrivenTransport = new MockTransport();
        myRouter = new MockApplicationRouter();
        NullSafeStorage storage = new NullSafeStorage(); 
        ProcessorContext context = 
            new ProcessorContextImpl(myRouter, myTransport, myRemotelyDrivenTransport, storage);
        myProcessor = new ProcessorImpl(context, true);
    }
    
    @Test
    public void testSendNoAcceptAck() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||NE\rNTE|\r";
        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
    } 
    
    @Test
    public void testSendWithAcceptAck() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||AL\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CA|msg-a\r";
        myTransport.setNextReceived(new TransportableImpl(b));

        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
    }
    
    @Test
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
    
    @Test
    public void testSendRetryOnNoAnswer() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||AL\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CA|msg-a\r";
        receiveLater(myTransport, b, 1500);
        
        myProcessor.send(new TransportableImpl(a), 3, 1000);
        assertEquals(a, myTransport.getLastSent().getMessage());
        assertTrue(myTransport.getSentMessages().size() > 1); 
    }
    
    @Test
    public void testSendAckOnErrorNoError() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||ER\rNTE|\r";
        myProcessor.send(new TransportableImpl(a), 3, 1000); //should return because no response received in time 
        assertEquals(a, myTransport.getLastSent().getMessage());        
    }
    
    @Test
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
    
    @Test
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
    
    @Test
    public void testSendNeverAckWithError() throws Exception {
        String a = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-a|P|2.2|||NE\rNTE|\r";
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|CE|msg-a|foo\r";
        receiveLater(myTransport, b, 200);
        myProcessor.send(new TransportableImpl(a), 3, 1000); //no error because we don't wait for the ACK  
    }
    
    @Test
    public void testReceive() throws Exception {
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r";
        receiveLater(myRemotelyDrivenTransport, b, 200);
        Transportable got = myProcessor.receive("msg-a", 2000);
        assertEquals(b, got.getMessage());
    }
    
    @Test
    public void testReceiveNotAvailable() throws Exception {
        Transportable got = myProcessor.receive("msg-a", 2000);
        assertEquals(null, got); 
    }
    
    @Test
    public void testReceiveNonMatchingAckId() throws Exception {
        //Prevents NullPointerException (AppRouter will try to respond to unsolicited message) ... 
        myRouter.setNextReply(new TransportableImpl("MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r"));  
        
        String b = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|msg-b|P|2.2\rMSA|AA|msg-a\r";
        receiveLater(myRemotelyDrivenTransport, b, 1000);
        Transportable got = myProcessor.receive("doesn't exist", 2000);
        assertEquals(null, got);        
    }

    @Test
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
