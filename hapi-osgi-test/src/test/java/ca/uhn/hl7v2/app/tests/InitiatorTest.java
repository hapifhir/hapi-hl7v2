/*
 * Created on 4-Jan-2005
 */
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

import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;


/**
 * Unit tests for Initiator. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 * 
 * 
 */
@RunWith(JUnit4TestRunner.class)
public class InitiatorTest {


    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(InitiatorTest.class);
    
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


    @Test
    public void testSendAndReceive() throws Exception {
        int port = 5678;
        Parser parser = new PipeParser();
        MinLowerLayerProtocol protocol = new MinLowerLayerProtocol();
        
        SimpleServer ss = new SimpleServer(port, protocol, parser);
        ss.start();
        Socket socket = new Socket("localhost", port);
        Connection conn = new Connection(parser, protocol, socket);
        
        String msgText = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.4\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
        Message out = parser.parse(msgText);
        Message in = conn.getInitiator().sendAndReceive(out);    
        assertTrue(in != null);
    }

}
