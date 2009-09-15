package ca.uhn.hl7v2.app.tests;

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

import java.io.IOException;

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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

/**
 * 
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 * 
 * 
 */
@RunWith(JUnit4TestRunner.class)
public class DefaultApplicationTest  {

    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(DefaultApplicationTest.class);
    
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

    
    Segment inbound;
    Segment outbound;
    Message in;
    DefaultApplication app; 
    
    @Before
    public void BeforeTheTest() throws HL7Exception {
	app = new DefaultApplication();
        in = new ca.uhn.hl7v2.model.v24.message.ACK();
        Terser t = new Terser(in);
        t.set("/MSH-1", "|");
        t.set("/MSH-2", "^~\\&");
        t.set("/MSH-11", "D");
        t.set("/MSH-12", "2.4");
        t.set("/MSH-10", "boo");
        inbound = (Segment) in.get("MSH");
        /*inbound.controlEncodingCharacters().setValue("^~\\&");
        inbound.controlFieldSeparator().setValue("|");
        inbound.controlProcessingID().setValue("D");
        inbound.controlVersionID().setValue("2.4");
        inbound.controlMessageControlID().setValue("boo");*/

    }
    
   @Test
    public void testFillResponseHeader() throws HL7Exception, IOException {
        Segment outbound = new ca.uhn.hl7v2.model.v24.segment.MSH(
                new GenericMessage.V24(new DefaultModelClassFactory()), new DefaultModelClassFactory());
        DefaultApplication.fillResponseHeader(inbound, outbound);        
        assertEquals(Terser.get(outbound, 2, 0, 1, 1), "^~\\&");
        assertEquals(Terser.get(outbound, 1, 0, 1, 1), "|");
        assertEquals(Terser.get(outbound, 11, 0, 1, 1), "D");
        //TS messTime = (TS) outbound.controlDateTimeOfMessage();     
        String id1 = Terser.get(outbound, 10, 0, 1, 1);
        DefaultApplication.fillResponseHeader(inbound, outbound);
        String id2 = Terser.get(outbound, 10, 0, 1, 1);
        assertTrue(!id1.equals(id2));
    }
    
   @Test
    public void testMakeACK() throws Exception {
        Message ack = DefaultApplication.makeACK(inbound);
        Terser t = new Terser(ack);
        assertEquals("2.4", t.get("/MSH-12"));
        assertEquals(ack.getClass(), ca.uhn.hl7v2.model.v24.message.ACK.class);
        assertEquals("AA", t.get("/MSA-1"));
        assertEquals("boo", t.get("/MSA-2"));
    }
    
   @Test
    public void testProcessMessage() throws Exception {
        Message out = app.processMessage(in);
        Terser t = new Terser(out);
        assertEquals("AR", t.get("/MSA-1"));
        assertEquals("207", t.get("/ERR-1(0)-4-1"));
        Parser parser = new PipeParser();
        System.out.println(parser.encode(out));
    }
}