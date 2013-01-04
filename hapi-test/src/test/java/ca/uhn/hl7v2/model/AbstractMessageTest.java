package ca.uhn.hl7v2.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.segment.MSA;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * JUnit test cases for AbstractMessage
 * 
 * @author bryan
 */
public class AbstractMessageTest {

	@Test
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

	@Test
	public void testGenerateAck() throws HL7Exception, IOException {

		String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";
		Message message = new PipeParser().parse(string);
		Message ack = message.generateACK();

		MSA msa = (MSA) ack.get("MSA");
		assertEquals("LABGL1199510021852632", msa.getMsa2_MessageControlID().encode());

		// System.out.println(ack.encode());
		// MSH|^~\&|||||20090926173004.067-0500||ACK|225|P|2.2
		// MSA|AA|LABGL1199510021852632

		Message nak = message.generateACK(AcknowledgmentCode.AR, new HL7Exception("Error Message"));
		msa = (MSA) nak.get("MSA");
		assertEquals("LABGL1199510021852632", msa.getMsa2_MessageControlID().encode());

		// System.out.println(nak.encode());
		// MSH|^~\&|||||20090926180218.494-0500||ACK|231|P|2.2
		// MSA|AR|LABGL1199510021852632
		// ERR|^^^2&ERROR&hl70357&&Error Message
	}

	@Test
	public void testGenerateAckUsesCorrectVersion() throws HL7Exception, IOException {

		ADT_A01 adt = new ADT_A01();
		adt.initQuickstart("ADT", "A01", "T");

		adt.getMSH().getVersionID().parse("2.1");
		Terser t = new Terser(adt.generateACK());
		assertEquals("2.1", t.get("/.MSH-12"));

		adt.getMSH().getVersionID().parse("2.5");
		 t = new Terser(adt.generateACK());
		assertEquals("2.5", t.get("/.MSH-12"));

		adt.getMSH().getVersionID().parse("2.6");
		 t = new Terser(adt.generateACK());
		assertEquals("2.6", t.get("/.MSH-12"));

		adt.getMSH().getVersionID().parse("");
		t = new Terser(adt.generateACK());
		assertEquals(Version.highestAvailableVersionOrDefault().getVersion(), t.get("/.MSH-12"));

	}

	@Test
	public void testGenerateAckWithCanonicalFactory() throws HL7Exception, IOException {

		String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

		ModelClassFactory mcf = new CanonicalModelClassFactory("2.6");
		HapiContext hc = new DefaultHapiContext(mcf);
		hc.setValidationContext(ValidationContextFactory.noValidation());
		Parser p = hc.getPipeParser();

		Message message = p.parse(string);
		Message ack = message.generateACK();

		ca.uhn.hl7v2.model.v26.segment.MSH msh = (ca.uhn.hl7v2.model.v26.segment.MSH) ack.get("MSH");
		assertEquals("2.2", msh.getVersionID().encode());

	}

	@Test
	public void testParseAndEncode() throws HL7Exception, IOException {

		String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

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

	@Test
	public void testNumberedAccessor() throws HL7Exception, IOException {

		String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r" + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r" + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

		ADT_A01 a01 = new ADT_A01();
		a01.parse(string);
		a01.getPID().getPid3_PatientIDInternalID(0).parse("1234");
	}

	/**
	 * If a group contains two segments with the same name in different
	 * positions, they should be shown separately
	 */
	@Test
	public void testPrintMessageStructureCorrectlyShowsMultipleSegmentsWithSameName() throws HL7Exception, IOException {

		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "P");

		msg.addNonstandardSegment("ZZZ");
		((Segment) msg.get("ZZZ")).parse("ZZZ|1");

		msg.addNonstandardSegment("ZZZ");
		((Segment) msg.get("ZZZ2")).parse("ZZZ|2");

		String struct = msg.printStructure();
		Assert.assertTrue(struct.contains(" ZZZ "));
		Assert.assertTrue(struct.contains(" ZZZ2 "));

	}

	@Test
	// moved from DefaultApplicationTest
	public void testMakeACK() throws Exception {
		Message in = new ca.uhn.hl7v2.model.v24.message.ACK();
		Terser t = new Terser(in);
		t.set("/MSH-1", "|");
		t.set("/MSH-2", "^~\\&");
		t.set("/MSH-3", "senderapp");
		t.set("/MSH-4", "senderfac");
		t.set("/MSH-5", "receiverapp");
		t.set("/MSH-6", "receiverfac");
		t.set("/MSH-10", "boo");
		t.set("/MSH-11", "D");
		t.set("/MSH-12", "2.4");
		Message ack = in.generateACK();
		assertEquals(ack.getClass(), ca.uhn.hl7v2.model.v24.message.ACK.class);
		Terser to = new Terser(ack);
		assertEquals("|", to.get("/MSH-1"));
		assertEquals("^~\\&", to.get("/MSH-2"));
		assertEquals(t.get("/MSH-3"), to.get("/MSH-5"));
		assertEquals(t.get("/MSH-4"), to.get("/MSH-6"));
		assertEquals(t.get("/MSH-5"), to.get("/MSH-3"));
		assertEquals(t.get("/MSH-6"), to.get("/MSH-4"));
		assertEquals("D", to.get("/MSH-11"));
		assertEquals("2.4", to.get("/MSH-12"));
		assertEquals(AcknowledgmentCode.AA.name(), to.get("/MSA-1"));
		assertEquals("boo", to.get("/MSA-2"));
	}

}
