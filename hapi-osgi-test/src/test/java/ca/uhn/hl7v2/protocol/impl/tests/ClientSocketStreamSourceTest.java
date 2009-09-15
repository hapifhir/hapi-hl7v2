/*
 * Created on 20-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

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

import java.net.InetSocketAddress;
import java.net.ServerSocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.impl.ClientSocketStreamSource;


/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ClientSocketStreamSourceTest {

    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ClientSocketStreamSourceTest.class);
    
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
    public void testConnect() throws Exception {
        int port = 19876; 
        StreamSource source 
            = new ClientSocketStreamSource(new InetSocketAddress("127.0.0.1", port));
        
        final ServerSocket ss = new ServerSocket(port);
        Thread thd = new Thread() {
            public void run() {
                try {
                    ss.accept(); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thd.start();
        
        try {
            source.getInboundStream();
            fail("should have thrown exception if not connected");
        } catch (TransportException e) {
            //OK            
        }

        try {
            source.getOutboundStream();
            fail("should have thrown exception if not connected");
        } catch (TransportException e) {
            //OK            
        }
        
        source.connect();
        
        assertTrue(source.getInboundStream() != null);
        assertTrue(source.getOutboundStream() != null);
    }

}
