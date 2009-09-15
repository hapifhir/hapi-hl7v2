/*
 * Created on 25-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.provision;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.scanDir;

import java.io.IOException;
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
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;
import ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl;
import ca.uhn.hl7v2.protocol.impl.ClientSocketStreamSource;
import ca.uhn.hl7v2.protocol.impl.HL7Server;
import ca.uhn.hl7v2.protocol.impl.MLLPTransport;
import ca.uhn.hl7v2.protocol.impl.NullSafeStorage;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;
import ca.uhn.hl7v2.protocol.tests.MockApp;

/**
 * Unit tests for <code>HL7Server</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class HL7ServerTest {

    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(HL7ServerTest.class);
    
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
    public void listBundles()
    {
        for( Bundle b : bundleContext.getBundles() )
        {
            System.out.println( "Bundle " + b.getBundleId() + " : " + b.getSymbolicName() );
        }

    }

    
    
    /*
     * ********************************************************* Test Cases
     * *********************************************************
     */
    
    /**
     * Test the response of a HL7 Server
     * @throws Exception
     */
    @Test
    public void testResponse() throws Exception {
        int port = 9992;
        String localhost = "127.0.0.1";
        ServerSocket ss = new ServerSocket(port);
        SafeStorage storage = new NullSafeStorage();
        ApplicationRouter router = new ApplicationRouterImpl();
        router.bindApplication(new AppRoutingDataImpl("*", "*", "*", "*"), new MockApp());

        HL7Server server = new HL7Server(ss, router, storage);
        server.start(localhost);
        
        try {
            Thread.sleep(1000); //give it time to start before we stop it
        } catch (InterruptedException e) {}
        server.stop();
        
        StreamSource sender = new ClientSocketStreamSource(new InetSocketAddress(localhost, port));
        MLLPTransport transport = new MLLPTransport(sender);
        transport.connect();
        
        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.2\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
        transport.send(new TransportableImpl(message));
        Transportable inbound = transport.receive();
        
        assertTrue(inbound.getMessage().indexOf("mock") > -1);     
        
        transport.disconnect();
        
        if(ss != null) {
            try{
        	ss.close(); 
            }catch(IOException ex) {
        	
            }
        }
          
    }
    
//    /**
//     * Test the main of the HL7Server
//     * @throws Exception
//     */
//    @Test
//    public void testMain() throws Exception {
//        HL7Server.main(new String[] {"9996", "classpath:ca/uhn/hl7v2/protocol/impl/tests/mock_apps"});
//
//        StreamSource sender = new ClientSocketStreamSource(new InetSocketAddress("127.0.0.1", 9996));
//        MLLPTransport transport = new MLLPTransport(sender);
//        transport.connect();
//        
//        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.2\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
//        transport.send(new TransportableImpl(message));
//        Transportable inbound = transport.receive();
//        
//        assertTrue(inbound.getMessage().indexOf("mock") > -1);     
//        
//        transport.disconnect();        
//    }
}
