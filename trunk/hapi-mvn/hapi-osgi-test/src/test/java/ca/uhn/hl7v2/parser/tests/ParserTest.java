/*
 * ParserTest.java
 *
 * Created on March 15, 2002, 9:57 AM
 */

package ca.uhn.hl7v2.parser.tests;

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

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.NoValidation;

/**
 * JUnit test harness for Parser
 * 
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ParserTest {
    // you get that because you "installed" a log profile in configuration.
    public Log ourLog = LogFactory.getLog(ParserTest.class);
    
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
    public void testMakeControlMSH() throws HL7Exception {
	ModelClassFactory factory = new DefaultModelClassFactory();
	Segment msh = Parser.makeControlMSH("2.4", factory);
	assertTrue(msh instanceof ca.uhn.hl7v2.model.v24.segment.MSH);
	msh = Parser.makeControlMSH("2.2", factory);
	assertTrue(msh instanceof ca.uhn.hl7v2.model.v22.segment.MSH);
	try {
	    msh = Parser.makeControlMSH("1", factory);
	    fail("should have thrown exception with version = 1");
	} catch (Exception e) {
	}
    }
    
    @Test
    public void testEventMap() throws Exception {
	String message = "MSH|^~\\&|||||||ADT^A04|1|D|2.4\r";
	PipeParser p = new PipeParser();
	Message m = p.parse(message);
	assertEquals("ADT_A01", m.getName());
	
	// shouldn't be a map entry, so should return an ACK
	message = "MSH|^~\\&|||||||ACK|1|D|2.4\r";
	p = new PipeParser();
	m = p.parse(message);
	assertEquals("ACK", m.getName());
	
	// no maps for v2.1 so should map to self
	message = "MSH|^~\\&|||||||ADT^A01|1|D|2.1\r";
	p = new PipeParser();
	m = p.parse(message);
	assertEquals("ADT_A01", m.getName());
    }
    
    @Test
    public void testGenericMessage() throws Exception {
	// a valid ORU_R01 message in which MSH-9 has been changed
	String message = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ZZZ^ZZZ|LABGL1199510021852632|P|2.2\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r" + "OBR|1||09527539437000040|7000040^ETHANOL^^^ETOH|||19951002180500|||||||19951002182500||||1793561||0952753943||19951002185200||100|F||^^^^^RT\r" + "OBX||NM|7000040^ETHANOL^^^ETOH|0001|224|mg/dL|||||F|||19951002185200||182\r" + "NTE|||          Reference Ranges\r" + "NTE|||          ****************\r" + "NTE|||           Normal:              Negative\r" + "NTE|||           Toxic Concentration: >80 mg/dL\r";
	
	PipeParser p = new PipeParser();
	Message m = p.parse(message);
	p.encode(m);
	p.encode(m);
	p.encode(m);
	p.encode(m);
	p.encode(m);
	p.encode(m);
	
	assertEquals(GenericMessage.V22.class, m.getClass());
	Terser t = new Terser(m);
	assertEquals("DMCRES", t.get("/MSH-5"));
	assertEquals("NM", t.get("/OBX-2"));
    }
    
    @Test
    public void testUnknownVersionMessage() throws Exception {
	// a valid ORU_R01 message in which MSH-9 has been changed
	String message = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ORU^R01|LABGL1199510021852632|P|2.6\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r" + "OBR|1||09527539437000040|7000040^ETHANOL^^^ETOH|||19951002180500|||||||19951002182500||||1793561||0952753943||19951002185200||100|F||^^^^^RT\r" + "OBX||NM|7000040^ETHANOL^^^ETOH|0001|224|mg/dL|||||F|||19951002185200||182\r" + "NTE|||          Reference Ranges\r" + "NTE|||          ****************\r" + "NTE|||           Normal:              Negative\r" + "NTE|||           Toxic Concentration: >80 mg/dL\r";
	
	PipeParser p = new PipeParser();

	Message m = p.parse(message);
	p.encode(m);
	
	assertEquals(GenericMessage.V22.class, m.getClass());
	Terser t = new Terser(m);
	assertEquals("DMCRES", t.get("/MSH-5"));
	assertEquals("NM", t.get("/OBX-2"));
    }
    
    @Test
    public void testGenericMessageAllVersions() throws Exception {
	List versions = Parser.getValidVersions();
	for (Iterator iterator = versions.iterator(); iterator.hasNext();) {
	    String next = (String) iterator.next();
	    if (next.startsWith("2.0")) {
		continue; // generic messages in 2.0 aren't handled
	    }
	    if (next.startsWith("2.1")) {
		continue; // generic messages in 2.0 aren't handled
	    }
	    
	    // a valid ORU_R01 message in which MSH-9 has been changed
	    String message = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ZZZ^ZZZ|LABGL1199510021852632|P|" + next + "\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r" + "OBR|1||09527539437000040|7000040^ETHANOL^^^ETOH|||19951002180500|||||||19951002182500||||1793561||0952753943||19951002185200||100|F||^^^^^RT\r" + "OBX||NM|7000040^ETHANOL^^^ETOH|0001|224|mg/dL|||||F|||19951002185200||182\r" + "NTE|||          Reference Ranges\r" + "NTE|||          ****************\r" + "NTE|||           Normal:              Negative\r" + "NTE|||           Toxic Concentration: >80 mg/dL\r";
	    
	    ourLog.info("Parsing generic for version " + next);
	    PipeParser p = new PipeParser();
	    Message m;
	    try {
		m = p.parse(message);
	    } catch (HL7Exception e) {
		ourLog.error("Failed to parse: ", e);
		fail("Failed to parse message for version " + next + ". Possibly GenericMessage needs to be modified: " + e.getMessage());
		return;
	    }
	    Terser t = new Terser(m);
	    assertEquals("DMCRES", t.get("/MSH-5"));
	    assertEquals("NM", t.get("/OBX-2"));
	    
	}
    }
    
}
