/*
 * Created on 19-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.InitiatorImpl;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;
import ca.uhn.hl7v2.util.Terser;

/**
 * Unit tests for <code>InitiatorImpl</code>.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author:
 *          jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class InitiatorImplTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(InitiatorImplTest.class);
    
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
    
    private InitiatorImpl myInitiator;
    private MockProcessor myProcessor;
    
    private String AA = "MSH|^~\\&|||||||ACK^A01|b|P|2.6\rMSA|AA|a\r";
    private String AE = "MSH|^~\\&|||||||ACK^A01|b|P|2.6\rMSA|AE|a\r";
    
    @Before
    public void BeforeTheTest() {
	logger.info("*****************************BeforeTheTest******************************************");
	myProcessor = new MockProcessor();
	myInitiator = new InitiatorImpl(myProcessor);
    }
    
    @After
    public void AfterTheTest() {
	logger.info("*****************************AfterTheTest******************************************");
	myProcessor = null;
	myInitiator = null;
    }

    /*
     * ********************************************************* Test Cases
     * *********************************************************
     */
    
    @Test
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
    
    @Test
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
    
    @Test
    public void testTimeout() throws Exception {
	ADT_A01 message = new ADT_A01();
	message.getMSH().getFieldSeparator().setValue("|");
	message.getMSH().getEncodingCharacters().setValue("^~\\&");
	message.getMSH().getApplicationAcknowledgmentType().setValue("AL");
	myInitiator.setReceiveTimeout(1000); // other params don't matter
					     // because we're using mock
					     // processor
	long start = System.currentTimeMillis();
	Message response = myInitiator.sendAndReceive(message);
	long end = System.currentTimeMillis();
	assertEquals(null, response);
	assertTrue(end - start >= 1000);
    }
    
    @Test
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
    
    @Test
    public void testCharset() throws Exception {
	MockProcessor p = new MockProcessor();
	InitiatorImpl i = new InitiatorImpl(p);
	ADT_A01 a01 = new ADT_A01();
	Terser t = new Terser(a01);
	t.set("MSH-1", "|");
	t.set("MSH-2", "^~\\&");
	t.set("MSH-18", "UNICODE");
	Message response = i.sendAndReceive(a01);
	assertEquals("UNICODE", p.getSent().getMetadata().get("MSH-18"));
    }
    
    /**
     * A skeletal mock implementation of <code>Processor</code> with which you
     * can control messages returned via receive().
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by
     *          $Author: jamesagnew $
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
	
    }
    
}
