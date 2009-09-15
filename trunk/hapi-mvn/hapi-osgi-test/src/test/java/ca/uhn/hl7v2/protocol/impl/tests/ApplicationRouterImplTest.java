/*
 * Created on 18-May-2004
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

import java.util.Map;

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
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;
import ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;

/**
 * Unit tests for <code>ApplicationRouterImpl</code>.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author:
 *          jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ApplicationRouterImplTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ApplicationRouterImplTest.class);
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
    
    private ApplicationRouter myRouter;
    
    
    @Before
    public void BeforeTheTest() {
	logger.info("*****************************BeforeTheTest******************************************");
	myRouter = new ApplicationRouterImpl();
    }
    
    @After
    public void AfterTheTest() {
	logger.info("*****************************AfterTheTest******************************************");
	myRouter = null;
    }
    
    @Test
    public void testProcessMessage() throws Exception {
	AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A01", "P", "2.4");
	MockApplication app = new MockApplication("a");
	String message1 = "MSH|^~\\&|||||||ADT^A01|a|P|2.4\rNTE||foo\r";
	String response = "MSH|^~\\&|||||||ACK|b|P|2.4||||||UNICODE\rMSA|AA|a\r";
	String message2 = "MSH|^~\\&|||||||ADT^A14|a|P|2.4\rNTE||foo\r";
	String message3 = "MSH|^~\\&|||||||ADT^A14|a|P|2.4\rNTE|foo\r"; // NumberFormatException
									// in
									// NTE-1
	
	myRouter.bindApplication(rd, app);
	PipeParser parser = new PipeParser();
	app.setNextResponse(parser.parse(response));
	
	Transportable result = myRouter.processMessage(new TransportableImpl(message1));
	assertTrue(result.getMessage(), result.getMessage().indexOf("MSA|AA|a") > 0);
	assertEquals("UNICODE", result.getMetadata().get("MSH-18"));
	
	// note that this test assumes DefaultApplication is being used and
	// returns a certain message
	result = myRouter.processMessage(new TransportableImpl(message2));
	assertTrue(result.getMessage().indexOf("No appropriate destination") > 0);
	
	result = myRouter.processMessage(new TransportableImpl(message3));
	assertTrue(result.getMessage().indexOf("MSA|AE|a|") > 0);
    }
    
    @Test
    public void testHasActiveBinding() {
	AppRoutingDataImpl rdA = new AppRoutingDataImpl("ADT", "A01", "P", "2.4");
	ReceivingApplication appA = new MockApplication("a");
	assertEquals(false, myRouter.hasActiveBinding(rdA));
	
	myRouter.bindApplication(rdA, appA);
	assertEquals(true, myRouter.hasActiveBinding(rdA));
	
	AppRoutingDataImpl test1 = new AppRoutingDataImpl("foo", "A01", "P", "2.4");
	AppRoutingDataImpl test2 = new AppRoutingDataImpl("ADT", "foo", "P", "2.4");
	AppRoutingDataImpl test3 = new AppRoutingDataImpl("ADT", "A01", "foo", "2.4");
	AppRoutingDataImpl test4 = new AppRoutingDataImpl("ADT", "A01", "P", "foo");
	assertEquals(false, myRouter.hasActiveBinding(test1));
	assertEquals(false, myRouter.hasActiveBinding(test2));
	assertEquals(false, myRouter.hasActiveBinding(test3));
	assertEquals(false, myRouter.hasActiveBinding(test4));
	
	myRouter.disableBinding(rdA);
	assertEquals(false, myRouter.hasActiveBinding(rdA));
    }
    
    /**
     * Tests that wildcards in routing data work. This is largely tested by
     * testMatches(), but we check it again quickly here.
     */
    @Test
    public void testWildcards() {
	AppRoutingDataImpl rd = new AppRoutingDataImpl("*", "A01", "P", "2.4");
	ReceivingApplication app = new MockApplication("1");
	myRouter.bindApplication(rd, app);
	assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A01", "P", "2.4")));
	assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("foo", "A01", "P", "2.4")));
	assertEquals(false, myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "foo", "P", "2.4")));
    }
    
    /**
     * Tests that regex in routing data work. This is largely tested by
     * testRegexMatches(), but we check it again quickly here.
     */
    @Test
    public void testRegex() {
	AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A0.", "P", "2.4");
	ReceivingApplication app = new MockApplication("1");
	myRouter.bindApplication(rd, app);
	assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A01", "P", "2.4")));
	assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A02", "P", "2.4")));
	assertEquals(false, myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A14", "P", "2.4")));
    }
    
    @Test
    public void testRegexMatches() {
	AppRoutingDataImpl ref1 = new AppRoutingDataImpl("ADT", "A0.", "P", "2.4");
	AppRoutingDataImpl ref2 = new AppRoutingDataImpl("ADT", "A0[12]", "P", "2.4");
	AppRoutingDataImpl ref3 = new AppRoutingDataImpl(".*", "A01", "P", "2.4");
	AppRoutingDataImpl ref4 = new AppRoutingDataImpl("ADT", "A01", ".", "2.4");
	AppRoutingDataImpl ref5 = new AppRoutingDataImpl("ADT", "A01", "P", ".*");
	
	AppRoutingDataImpl msg1 = new AppRoutingDataImpl("ADT", "A01", "P", "2.4");
	AppRoutingDataImpl msg2 = new AppRoutingDataImpl("ADT", "A02", "P", "2.4");
	AppRoutingDataImpl msg3 = new AppRoutingDataImpl("ADT", "A03", "P", "2.4");
	
	assertTrue(ApplicationRouterImpl.matches(msg1, ref1));
	assertTrue(ApplicationRouterImpl.matches(msg2, ref1));
	assertTrue(ApplicationRouterImpl.matches(msg3, ref1));
	assertTrue(ApplicationRouterImpl.matches(msg1, ref2));
	assertTrue(ApplicationRouterImpl.matches(msg2, ref2));
	assertEquals(false, ApplicationRouterImpl.matches(msg3, ref2));
	assertTrue(ApplicationRouterImpl.matches(msg1, ref3));
	assertTrue(ApplicationRouterImpl.matches(msg1, ref4));
	assertTrue(ApplicationRouterImpl.matches(msg1, ref5));
    }
    
    @Test
    public void testMatches() {
	AppRoutingDataImpl one = new AppRoutingDataImpl("a", "b", "b", "d");
	
	AppRoutingDataImpl d1 = new AppRoutingDataImpl("-", "b", "b", "d");
	AppRoutingDataImpl d2 = new AppRoutingDataImpl("a", "-", "b", "d");
	AppRoutingDataImpl d3 = new AppRoutingDataImpl("a", "b", "-", "d");
	AppRoutingDataImpl d4 = new AppRoutingDataImpl("a", "b", "b", "-");
	
	AppRoutingDataImpl w1 = new AppRoutingDataImpl("*", "b", "b", "d");
	AppRoutingDataImpl w2 = new AppRoutingDataImpl("a", "*", "b", "d");
	AppRoutingDataImpl w3 = new AppRoutingDataImpl("a", "b", "*", "d");
	AppRoutingDataImpl w4 = new AppRoutingDataImpl("a", "b", "b", "*");
	
	assertEquals(true, ApplicationRouterImpl.matches(one, one));
	assertEquals(false, ApplicationRouterImpl.matches(one, d1));
	assertEquals(false, ApplicationRouterImpl.matches(one, d2));
	assertEquals(false, ApplicationRouterImpl.matches(one, d3));
	assertEquals(false, ApplicationRouterImpl.matches(one, d4));
	
	assertEquals(true, ApplicationRouterImpl.matches(one, w1));
	assertEquals(true, ApplicationRouterImpl.matches(one, w2));
	assertEquals(true, ApplicationRouterImpl.matches(one, w3));
	assertEquals(true, ApplicationRouterImpl.matches(one, w4));
	
	assertEquals(false, ApplicationRouterImpl.matches(w1, one));
	assertEquals(false, ApplicationRouterImpl.matches(w2, one));
	assertEquals(false, ApplicationRouterImpl.matches(w3, one));
	assertEquals(false, ApplicationRouterImpl.matches(w4, one));
    }
    
    /**
     * Mock Application for testing purposes. Use getId() as a handy way to
     * check which application the router is routing to.
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by
     *          $Author: jamesagnew $
     */
    private class MockApplication implements ReceivingApplication {
	
	private Message myNextResponse;
	private final String myId;
	
	public MockApplication(String theId) {
	    myId = theId;
	}
	
	public Message processMessage(Message arg0, Map arg1) throws ReceivingApplicationException, HL7Exception {
	    return myNextResponse;
	}
	
	public boolean canProcess(Message arg0) {
	    return true;
	}
	
	public String getId() {
	    return myId;
	}
	
	public void setNextResponse(Message theResponse) {
	    myNextResponse = theResponse;
	}
    }
    
}
