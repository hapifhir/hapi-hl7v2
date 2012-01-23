package ca.uhn.hl7v2.model;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.segment.MSA;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.impl.NoValidation;

/**
 * JUnit test cases for AbstractMessage
 * @author bryan
 */
public class AbstractMessageTest extends TestCase {

    public AbstractMessageTest(java.lang.String testName) {
        super(testName);
    }

    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(AbstractMessageTest.class);
        return suite;
    }

    public void testGetVersion() {
        Message msg = new ca.uhn.hl7v2.model.v22.message.ADT_A01();
        assertEquals("2.2", msg.getVersion());
        msg = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
        assertEquals("2.3", msg.getVersion());
        msg = new ca.uhn.hl7v2.model.v231.message.ADT_A01();
        assertEquals("2.3.1", msg.getVersion());
        msg = new ca.uhn.hl7v2.model.v24.message.ADT_A01();
        assertEquals("2.4", msg.getVersion());
    }
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}

    public void testGenerateAck() throws HL7Exception, IOException {

        String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";
        Message message = new PipeParser().parse(string);
        Message ack = message.generateACK();

        MSA msa = (MSA)ack.get("MSA");
        assertEquals("LABGL1199510021852632", msa.getMsa2_MessageControlID().encode());

        System.out.println(ack.encode());
        // MSH|^~\&|||||20090926173004.067-0500||ACK|225|P|2.2
        // MSA|AA|LABGL1199510021852632

        Message nak = message.generateACK("AR", new HL7Exception("Error Message", HL7Exception.ACK_AE));
        msa = (MSA)nak.get("MSA");
        assertEquals("LABGL1199510021852632", msa.getMsa2_MessageControlID().encode());

        System.out.println(nak.encode());
        // MSH|^~\&|||||20090926180218.494-0500||ACK|231|P|2.2
        // MSA|AR|LABGL1199510021852632
        // ERR|^^^2&ERROR&hl70357&&Error Message
    }
    
    public void testGenerateAckWithCanonicalFactory() throws HL7Exception, IOException {

        String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";
        ModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
        Parser p = new PipeParser(mcf);
        p.setValidationContext(new NoValidation());
        Message message = p.parse(string);
        Message ack = message.generateACK();

        ca.uhn.hl7v2.model.v26.segment.MSH msh = (ca.uhn.hl7v2.model.v26.segment.MSH)ack.get("MSH");
        assertEquals("2.2", msh.getVersionID().encode());

    }    


    public void testParseAndEncode() throws HL7Exception, IOException {

        String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

        ADT_A01 a01 = new ADT_A01();
        a01.parse(string);

        String pid = a01.getPID().encode();
        assertEquals("PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456", pid);

        String messageType = a01.getMSH().getMessageType().encode();
        assertEquals("ADT^A01", messageType);

        a01.getMSH().getMessageType().parse("ADT^A04");

        messageType = a01.getMSH().getMessageType().encode();
        assertEquals("ADT^A04", messageType);

        a01.getMSH().getMessageType().parse("");

        messageType = a01.getMSH().getMessageType().encode();
        assertEquals("", messageType);


    }

    public void testNumberedAccessor() throws HL7Exception, IOException {

        String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

        ADT_A01 a01 = new ADT_A01();
        a01.parse(string);
        a01.getPID().getPid3_PatientIDInternalID(0).parse("1234");
    }

}
