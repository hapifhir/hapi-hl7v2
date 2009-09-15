package ca.uhn.hl7v2.app.tests;

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

import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.app.MessageTypeRouter;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.tests.*;
import ca.uhn.hl7v2.util.*;

/**
 * JUnit test harness for MessageTypeRouter
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 * 
 * 
 */
@RunWith(JUnit4TestRunner.class)
public class MessageTypeRouterTest {

    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(MessageTypeRouterTest.class);
    
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
    
    private MessageTypeRouter router;
    
   @Before
   public void BeforeTheTest() {
       router = new MessageTypeRouter();
       DefaultApplication app = new DefaultApplication();
       router.registerApplication("ADT", "A01", app);
   }
   
    @Test
    public void testRegisterApplication() throws Exception {
        Message ack = new ca.uhn.hl7v2.model.v24.message.ACK();
        Terser t = new Terser(ack);
        t.set("/MSH-9-1", "ACK");
        assertEquals(false, router.canProcess(ack));
        t.set("/MSH-9-1", "ADT");
        t.set("/MSH-9-2-", "A01");
        assertEquals(true, router.canProcess(ack));
    }

    @Test
    public void testProcessMessage() throws Exception {
        Message in = new ca.uhn.hl7v2.model.v24.message.ACK();        
        Terser t = new Terser(in);
        t.set("/MSH-9-1", "ADT");
        t.set("/MSH-9-2", "A01");
        t.set("/MSH-12", "2.4");
        Message out = router.processMessage(in);
        Terser tout = new Terser(out);
        assertEquals("AR", tout.get("/MSA-1"));
    }
}
