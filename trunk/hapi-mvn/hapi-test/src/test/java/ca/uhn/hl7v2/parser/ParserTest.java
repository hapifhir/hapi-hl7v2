/*
 * ParserTest.java
 *
 * Created on March 15, 2002, 9:57 AM
 */

package ca.uhn.hl7v2.parser;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

/**
 * JUnit test harness for Parser
 * 
 * @author Bryan Tripp
 */
public class ParserTest
{
    private static final Logger ourLog = LoggerFactory.getLogger(ParserTest.class);

    @Test
    public void testMakeControlMSH() throws HL7Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        Segment msh = Parser.makeControlMSH("2.4", factory);
        assertTrue(msh instanceof ca.uhn.hl7v2.model.v24.segment.MSH);
        msh = Parser.makeControlMSH("2.2", factory);
        assertTrue(msh instanceof ca.uhn.hl7v2.model.v22.segment.MSH);

        msh = Parser.makeControlMSH("1", factory);
        assertTrue(msh.getClass().getName(), msh instanceof GenericSegment);
    }

    @Test
    public void testEventMap() throws HL7Exception {
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
    public void testGenericMessage() throws HL7Exception {
        // a valid ORU_R01 message in which MSH-9 has been changed
        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ZZZ^ZZZ|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r"
                + "OBR|1||09527539437000040|7000040^ETHANOL^^^ETOH|||19951002180500|||||||19951002182500||||1793561||0952753943||19951002185200||100|F||^^^^^RT\r"
                + "OBX||NM|7000040^ETHANOL^^^ETOH|0001|224|mg/dL|||||F|||19951002185200||182\r"
                + "NTE|||          Reference Ranges\r" + "NTE|||          ****************\r"
                + "NTE|||           Normal:              Negative\r"
                + "NTE|||           Toxic Concentration: >80 mg/dL\r";

        PipeParser p = new PipeParser();
        Message m = p.parse(message);
        p.encode(m);

        assertEquals(GenericMessage.V22.class, m.getClass());
        Terser t = new Terser(m);
        assertEquals("DMCRES", t.get("/MSH-5"));
        assertEquals("NM", t.get("/OBX-2"));
    }

    
    /**
     * Disabled- This might be nice to handle gracefully, but we don't, we never did,
     * and the spec doesn't say we need to.
     */
    @Ignore
    public void __tstUnknownVersionMessage() throws HL7Exception {
        // a valid ORU_R01 message in which MSH-9 has been changed
        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ORU^R01|LABGL1199510021852632|P|2.999\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r"
                + "OBR|1||09527539437000040|7000040^ETHANOL^^^ETOH|||19951002180500|||||||19951002182500||||1793561||0952753943||19951002185200||100|F||^^^^^RT\r"
                + "OBX||NM|7000040^ETHANOL^^^ETOH|0001|224|mg/dL|||||F|||19951002185200||182\r"
                + "NTE|||          Reference Ranges\r" + "NTE|||          ****************\r"
                + "NTE|||           Normal:              Negative\r"
                + "NTE|||           Toxic Concentration: >80 mg/dL\r";

        PipeParser p = new PipeParser();
        Message m = p.parse(message);
        p.encode(m);

        assertEquals(GenericMessage.V22.class, m.getClass());
        Terser t = new Terser(m);
        assertEquals("DMCRES", t.get("/MSH-5"));
        assertEquals("NM", t.get("/OBX-2"));
    }

    @Test
    public void testGenericMessageAllVersions() throws HL7Exception {
        for (Version versionEnum : Version.values()) {

        	String version = versionEnum.getVersion();
            if (version.startsWith("2.1")) {
                continue; // generic messages in 2.0 aren't handled
            }

            // a valid ORU_R01 message in which MSH-9 has been changed
            String message = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ZZZ^ZZZ|LABGL1199510021852632|P|"
                    + version
                    + "\r"
                    + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                    + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r"
                    + "OBR|1||09527539437000040|7000040^ETHANOL^^^ETOH|||19951002180500|||||||19951002182500||||1793561||0952753943||19951002185200||100|F||^^^^^RT\r"
                    + "OBX||NM|7000040^ETHANOL^^^ETOH|0001|224|mg/dL|||||F|||19951002185200||182\r"
                    + "NTE|||          Reference Ranges\r" + "NTE|||          ****************\r"
                    + "NTE|||           Normal:              Negative\r"
                    + "NTE|||           Toxic Concentration: >80 mg/dL\r";

            ourLog.debug("Parsing generic for version " + version);
            PipeParser p = new PipeParser();
            Message m;
            try {
                m = p.parse(message);
            } catch (HL7Exception e) {
                ourLog.error("Failed to parse: ", e);
                fail("Failed to parse message for version " + version + ". Possibly GenericMessage needs to be modified: " + e.getMessage());
                return;
            }
            Terser t = new Terser(m);
            assertEquals("DMCRES", t.get("/MSH-5"));
            assertEquals("NM", t.get("/OBX-2"));

        }
    }

    @Test
    public void testParseWithTruncationCharacter() throws HL7Exception {
        String message = "MSH|^~\\&#|Send App|Send Fac|Rec App|Rec Fac|20070504141816||ORM^O01||P|2.7\r" +
                "PID|||12345678||Lastname^^INI^^PREFIX||19340207|F|||Street 15^^S GRAVENHAGE^^2551HL^NEDERLAND|||||||||||||||NL\r" +
                "ORC|NW|8100088345^ORDERNR||LN1||C|^^^20070504080000||20070504141816|||0^Doctor\r" +
                "OBR|1|8100088345^ORDERNR||ADR^Something||||||||||||0^Doctor\r" +
                "OBX|1|ST|ADR^Something||item1^item2^item3^^item5||||||F\r";

        Parser p = new PipeParser();
        Message m = p.parse(message);
        String test = p.encode(m);
        assertEquals(message, test);
    }
    
    @Test
    public void test1714219() throws HL7Exception {

    	String message = "MSH|^~\\&|Send App|Send Fac|Rec App|Rec Fac|20070504141816||ORM^O01||P|2.2\r" +
    			"PID|||12345678||Lastname^^INI^^PREFIX||19340207|F|||Street 15^^S GRAVENHAGE^^2551HL^NEDERLAND|||||||||||||||NL\r" +
    			"ORC|NW|8100088345^ORDERNR||LN1||C|^^^20070504080000||20070504141816|||0^Doctor\r" +
    			"OBR|1|8100088345^ORDERNR||ADR^Something||||||||||||0^Doctor\r" +
    			"OBX|1|ST|ADR^Something||item1^item2^item3^^item5||||||F\r";
    	
    	Parser p = new PipeParser();
    	Message m = p.parse(message);
    	String test = p.encode(m);
    	assertEquals(message, test);
    }
    
    @Test
    public void test17142192() throws HL7Exception {

        String message = "MSH|^~\\&|Send App|Send Fac|Rec App|Rec Fac|20070504141816||ORM^O01||P|2.3\r" +
                "PID|||12345678||Lastname^^INI^^PREFIX||19340207|F|||Street 15^^S GRAVENHAGE^^2551HL^NEDERLAND|||||||||||||||NL\r" +
                "ORC|NW|8100088345^ORDERNR||LN1||C|^^^20070504080000||20070504141816|||0^Doctor\r" +
                "OBR|1|8100088345^ORDERNR||ADR^Something||||||||||||0^Doctor\r" +
                "OBX|1|RP|ADR^Something||http://TRACEMASTERVUE/TMVWebAPIClient/ShowTIFFImage.aspx?ECGID=0595f00-317e-11e2-4823-00201fe00029||||||F\r";
        
        Parser p = new PipeParser();
        Message m = p.parse(message);
        String test = p.encode(m);
        assertEquals(message, test);
    }    

    @Test
    public void testParserDoesntFailWithoutValidationExceptionHandlerFactory() throws HL7Exception, IOException {
    	DefaultHapiContext ctx = new DefaultHapiContext(new NoValidationBuilder());

    	ADT_A01 adt = new ADT_A01();
    	adt.initQuickstart("ADT", "A01", "T");
    	adt.setParser(ctx.getPipeParser());
    	
    	String msg = adt.encode();
    	adt.parse(msg);
    	
    	adt.setParser(ctx.getXMLParser());
    	msg = adt.encode();
    	adt.parse(msg);
    	
    }
    
}
