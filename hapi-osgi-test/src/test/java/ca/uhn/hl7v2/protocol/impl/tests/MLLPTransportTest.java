/*
 * Created on 24-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.ClientSocketStreamSource;
import ca.uhn.hl7v2.protocol.impl.MLLPTransport;
import ca.uhn.hl7v2.protocol.impl.ServerSocketStreamSource;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;

/**
 * Unit tests for MLLPTransport.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class MLLPTransportTest {
 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(MLLPTransportTest.class);
    
    //Pax Exam Configurations
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
    public void test() throws Exception {
        String localhost = "127.0.0.1";
        int port = 5673;
        
        ServerSocket ss = new ServerSocket(port);
        StreamSource remoteSource = new ServerSocketStreamSource(ss, localhost);
        MLLPTransport remoteTransport = new MLLPTransport(remoteSource); 
        startConnect(remoteTransport);
        
        StreamSource localSource = new ClientSocketStreamSource(new InetSocketAddress(localhost, port));
        MLLPTransport localTransport = new MLLPTransport(localSource);
        startConnect(localTransport);
        
        Thread.sleep(1000);
        
        String message = "hello";
        localTransport.send(new TransportableImpl(message));
        Transportable in = remoteTransport.receive();
        assertEquals(message, in.getMessage());
        
        remoteTransport.send((new TransportableImpl(message)));
        in = localTransport.receive();
        assertEquals(message, in.getMessage());        
    }
    
    
    private void startConnect(final TransportLayer theTransport) {
        Thread thd = new Thread() {
            public void run() {
                try {
                    theTransport.connect();
                } catch (TransportException e) {
                    e.printStackTrace();
                }
            }
        };
        thd.start();
    }
    
    @Test
    public void testCharset() throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamSource ss = new StreamSource() {
            public void connect() throws TransportException {}
            public void disconnect() throws TransportException {}
            public OutputStream getOutboundStream() throws TransportException {
                return out;
            }
            public InputStream getInboundStream() throws TransportException {
                return new ByteArrayInputStream("inbound message".getBytes());
            }
        };
        
        MLLPTransport transport = new MLLPTransport(ss);
        transport.connect();
        Transportable t = new TransportableImpl("outbound message");
        t.getMetadata().put("MSH-18", "UNICODE");
        transport.send(t);
        assertEquals(40, out.toByteArray().length);
    }

    //TODO add test for doConnect(), doDisconnect(), doReceive(), doSend(Transportable theMessage)  

}
