/*
 * Created on 22-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.impl.DualTransportConnector;
import ca.uhn.hl7v2.protocol.impl.MLLPTransport;
import ca.uhn.hl7v2.protocol.impl.ServerSocketStreamSource;



/**
 * Unit tests for <code>DualTransportConnector</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */

@RunWith(JUnit4TestRunner.class)
public class DualTransportConnectorTest {

 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(DualTransportConnectorTest.class);
    
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
    
    private String localhost = "127.0.0.1";        
    private int portOne = 25678;
    private int portTwo = 15679;
    
    ServerSocket myOne;
    ServerSocket myTwo;
    
    private DualTransportConnector myConnector;
    
    @Before
    public void BeforeTheTest() throws TransportException, IOException {
	logger.info("*****************************BeforeTheTest******************************************");
        myOne = new ServerSocket(portOne);
        myTwo = new ServerSocket(portTwo);        
        
        ServerSocketStreamSource ss1 = new ServerSocketStreamSource(myOne, localhost);
        ServerSocketStreamSource ss2 = new ServerSocketStreamSource(myTwo, localhost);
        
        TransportLayer t1 = new MLLPTransport(ss1);
        TransportLayer t2 = new MLLPTransport(ss2);
        
        myConnector = new DualTransportConnector(t1, t2);
    }
    
    @After
    public void AfterTheTest() throws TransportException, IOException {
	logger.info("*****************************AfterTheTest******************************************");
        myConnector.disconnect();
        myOne.close();
        myTwo.close();
    }
    
    @Test
    public void testConnectInOrder() throws Exception {
        startConnect();
        Socket s1 = new Socket(localhost, portOne);
        Socket s2 = new Socket(localhost, portTwo);

        Thread.sleep(1000);
        assertTrue(myConnector.getTransportA().isConnected());
        assertTrue(myConnector.getTransportB().isConnected());
    }
    
    @Test
    public void testConnectOutOfOrder() throws Exception {
        startConnect();
        Socket s2 = new Socket(localhost, portTwo);
        Socket s1 = new Socket(localhost, portOne);

        Thread.sleep(1000);
        assertTrue(myConnector.getTransportA().isConnected());
        assertTrue(myConnector.getTransportB().isConnected());
    }
    
    
    private void startConnect() {
        final DualTransportConnector c = myConnector;
        Thread thd = new Thread() {
            public void run() {
                try {
                    c.connect();
                } catch (TransportException e) {
                    e.printStackTrace();
                }
            }
        };
        thd.start();
    }

}
