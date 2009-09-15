package ca.uhn.hl7v2.app.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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

import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * JUnit test harmess for ConnectionHub
 * 
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 * 
 * 
 */
@RunWith(JUnit4TestRunner.class)
public class ConnectionHubTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ConnectionHubTest.class);
    
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
    
    private SimpleServer ss1;
    private SimpleServer ss2;
    
    @Before
    public void BeforeTheTest() {
	ss1 = new SimpleServer(9999, LowerLayerProtocol.makeLLP(), new PipeParser());
	ss1.start();
	ss2 = new SimpleServer(8888, LowerLayerProtocol.makeLLP(), new PipeParser());
	ss2.start();
    }
    
    @After
    public void AfterTheTest() {
	ss1.stop();
	ss2.stop();
	
	try {
	    Thread.sleep(SimpleServer.SO_TIMEOUT + 1000);
	} catch (InterruptedException e) {
	    // nothing
	}
    }
    
    @Test
    public void testDiscard() throws Exception {
	PipeParser pipeParser = new PipeParser();
	Connection i1 = ConnectionHub.getInstance().attach("localhost", 9999, pipeParser, MinLowerLayerProtocol.class);
	Connection i1again = ConnectionHub.getInstance().attach("localhost", 9999, pipeParser, MinLowerLayerProtocol.class);
	ConnectionHub.getInstance().discard(i1);
	Connection i1thrice = ConnectionHub.getInstance().attach("localhost", 9999, pipeParser, MinLowerLayerProtocol.class);
	assertTrue(i1thrice.hashCode() != i1.hashCode());
	
	ConnectionHub.getInstance().discard(i1thrice);
    }
    
    /**
     * 
     * @throws Exception
     */
    @Test
    public void testAttach() throws Exception {
	PipeParser pipeParser = new PipeParser();
	Connection i1 = ConnectionHub.getInstance().attach("localhost", 9999, pipeParser, MinLowerLayerProtocol.class);
	Connection i1again = ConnectionHub.getInstance().attach("localhost", 9999, pipeParser, MinLowerLayerProtocol.class);
	assertEquals(i1.hashCode(), i1again.hashCode());
	Connection i2 = ConnectionHub.getInstance().attach("localhost", 8888, pipeParser, MinLowerLayerProtocol.class);
	try {
	    ConnectionHub.getInstance().attach("localhost", 9090, pipeParser, MinLowerLayerProtocol.class);
	    fail("Shouldn't be a service running at 9090");
	} catch (Exception e) {
	}
	ConnectionHub.getInstance().detach(i1);
	ConnectionHub.getInstance().detach(i1again);
	ConnectionHub.getInstance().detach(i2);
	Connection i1OnceMore = ConnectionHub.getInstance().attach("localhost", 9999, pipeParser, MinLowerLayerProtocol.class);
	int onceMoreHashCode = i1OnceMore.hashCode();
	int i1HashCode = i1.hashCode();
	assertTrue(onceMoreHashCode != i1HashCode);
	ConnectionHub.getInstance().detach(i1OnceMore);
    }
    
}
