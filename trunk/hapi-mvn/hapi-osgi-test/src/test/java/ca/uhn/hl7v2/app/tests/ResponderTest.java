/*
 * Created on Dec 12, 2006
 */
package ca.uhn.hl7v2.app.tests;

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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;
/**
 * Test case for responder
 * 
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 * 
 * 
 */
@RunWith(JUnit4TestRunner.class)
public class ResponderTest
{
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ReceiverTest.class);
    
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

    

    private static int ourPort = 22222;
    
    private SimpleServer server;
    private Socket socket;
    private MinLLPWriter writer;
    private MinLLPReader reader;
    
    @Before
    public void BeforeTheTest() throws Exception {
        server = new SimpleServer(ourPort, new MinLowerLayerProtocol(), new GenericParser());
        server.registerApplication("*", "*", new DummyApplication());
        server.start();
        
        socket = new Socket("localhost", ourPort);
        
        writer = new MinLLPWriter(socket.getOutputStream());
        reader = new MinLLPReader(socket.getInputStream());

        ourPort++;
    }

    @After
    public void AfterTheTest() throws Exception {
        
        server.stop();
        socket.close();
    }
    
     
    @Test
    public void testResponseEncoding() throws HL7Exception, LLPException, IOException {
        
        String outMsg = "MSH|^~\\&|||||20061212094425.814-0500||ACK|2059434|P|2.2\r\n" + 
                "MAS|AA|20167098";
        
        writer.writeMessage(outMsg);
        String inMsg = reader.getMessage();
        
        assertTrue(inMsg.indexOf("MSH|") == 0);
        
    }

    @Test
    public void testResponseEncodingXml() throws LLPException, IOException {
        String outMsg = "<?xml version=\"1.0\"?>\r\n" + 
                "<ACK xmlns=\"urn:hl7-org:v2xml\">\r\n" + 
                "    <MSH>\r\n" + 
                "        <MSH.1>|</MSH.1>\r\n" + 
                "        <MSH.2>^~\\&amp;</MSH.2>\r\n" + 
                "        <MSH.7>\r\n" + 
                "            <TS.1>20061212094425.814-0500</TS.1>\r\n" + 
                "        </MSH.7>\r\n" + 
                "        <MSH.9>\r\n" + 
                "            <CM_MSG.1>ACK</CM_MSG.1>\r\n" + 
                "        </MSH.9>\r\n" + 
                "        <MSH.10>2059434</MSH.10>\r\n" + 
                "        <MSH.11>P</MSH.11>\r\n" + 
                "        <MSH.12>2.2</MSH.12>\r\n" + 
                "    </MSH>\r\n" + 
                "    <MSA/>\r\n" + 
                "    <ERR/>\r\n" + 
                "    <MAS>\r\n" + 
                "        <MAS.1>AA</MAS.1>\r\n" + 
                "        <MAS.2>20167098</MAS.2>\r\n" + 
                "    </MAS>\r\n" + 
                "</ACK>";
        
        writer.writeMessage(outMsg);
        String inMsg = reader.getMessage();
        
        assertTrue(inMsg.indexOf("<?xml") == 0);

    }
    
    
    /**
     * Application which always throws an HL7 exception
     * 
     * @author <a href="mailto:james.agnew@uhn.on.ca">James Agnew</a>
     * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
     */
    public class DummyApplication implements Application
    {

        /**
         * {@inheritDoc}
         */
        public boolean canProcess(Message theIn) {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {
            throw new HL7Exception("Test error");
        }
        
    }


    
}
