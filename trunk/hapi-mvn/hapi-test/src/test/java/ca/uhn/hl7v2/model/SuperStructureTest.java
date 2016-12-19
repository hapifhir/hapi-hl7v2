package ca.uhn.hl7v2.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;
import java.util.TreeSet;

import ca.uhn.hl7v2.model.v25.segment.MSH;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.v25.message.ADT_AXX;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.ReflectionUtil;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class SuperStructureTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(SuperStructureTest.class);

	@Test
	public void testParseTwoPidA01() throws HL7Exception {
		ADT_AXX msg = new ADT_AXX();

		String message = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A01|Q123456789T123456789X123456|P|2.3\r\n"
				+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n"
				+ "PID|2||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n";

		msg.parse(message);
		assertEquals("ADT_A01", msg.getName());

		assertEquals("1", msg.getPID().getPid1_SetIDPID().getValue());
		assertEquals(null, msg.getPID2().getPid1_SetIDPID().getValue());

		Segment pid3 = (Segment) msg.get("PID3");
		assertEquals("2", pid3.getField(1, 0).encode());

	}

	@Test
	public void testEncodeWithZSegment() throws HL7Exception {
		ADT_AXX msg = new ADT_AXX();

		String message = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A01|Q123456789T123456789X123456|P|2.3\r\n"
				+ "PID|2||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n";

		msg.parse(message);
		
		msg.addNonstandardSegment("ZZZ");
		GenericSegment zzz = (GenericSegment) msg.get("ZZZ");
		zzz.parse("ZZZ|1|2");

		DefaultHapiContext ctx = new DefaultHapiContext();
//		ctx.setValidationContext(new ValidationContextImpl());
		
		String out = ctx.getPipeParser().encode(msg);
		ourLog.info(out);
		
		assertThat(out, containsString("ZZZ|1|2"));
	}

	
	@Test
	public void testParseTwoPidA17() throws HL7Exception {
		ADT_AXX msg = new ADT_AXX();

		String message = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A17|Q123456789T123456789X123456|P|2.3\r\n"
				+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n"
				+ "PID|2||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n";

		msg.parse(message);
		assertEquals("ADT_A17", msg.getName());

		assertEquals("1", msg.getPID().getPid1_SetIDPID().getValue());
		assertEquals("2", msg.getPID2().getPid1_SetIDPID().getValue());

	}

	@Test
	public void testSetNameCorrectlyPipe() throws HL7Exception {
		ADT_AXX msg = new ADT_AXX();

		String message = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r\n" + "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r\n"
				+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n"
				+ "NK1|1|PEACH^PRINCESS^^^^|SO|ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-1234|(123)555-2345|NOK|||||||||||||\r\n" + "NK1|2|TOADSTOOL^PRINCESS^^^^|SO|YET ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-3456|(123)555-4567|EMC|||||||||||||\r\n"
				+ "PV1|1|O|ABCD^EFGH^|||^^|123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|^DOG^DUCKHUNT^^^^^^^CURRENT||CRD|||||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|AO|0123456789|1|||||||||||||||||||MSH||A|||20010101000000";
		msg.parse(message);
		assertEquals("ADT_A04", msg.getName());

		DefaultHapiContext ctx = new DefaultHapiContext(new CanonicalModelClassFactory(ADT_AXX.class));
		msg = (ADT_AXX) ctx.getPipeParser().parse(message);
		assertEquals("ADT_A04", msg.getName());

	}

	@Test
	public void testSetNameCorrectlyXml() throws HL7Exception {
		ADT_AXX msg = new ADT_AXX();

		String message = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r\n" + "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r\n"
				+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n"
				+ "NK1|1|PEACH^PRINCESS^^^^|SO|ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-1234|(123)555-2345|NOK|||||||||||||\r\n" + "NK1|2|TOADSTOOL^PRINCESS^^^^|SO|YET ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-3456|(123)555-4567|EMC|||||||||||||\r\n"
				+ "PV1|1|O|ABCD^EFGH^|||^^|123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|^DOG^DUCKHUNT^^^^^^^CURRENT||CRD|||||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|AO|0123456789|1|||||||||||||||||||MSH||A|||20010101000000";
		msg.parse(message);

		DefaultHapiContext ctx = new DefaultHapiContext(new CanonicalModelClassFactory(ADT_AXX.class));
		String convertToXml = ctx.getXMLParser().encode(msg);

		msg = new ADT_AXX();
		msg.setParser(ctx.getXMLParser());
		msg.parse(convertToXml);
		assertEquals("ADT_A04", msg.getName());

		msg = (ADT_AXX) ctx.getXMLParser().parse(convertToXml);
		assertEquals("ADT_A04", msg.getName());

	}

	@Test
	public void testValidationForCreateMessage() throws HL7Exception, IOException {
		ADT_AXX msg = new ADT_AXX();
		msg.initQuickstart("ADT", "A01", "T");

		PipeParser p = new DefaultHapiContext().getPipeParser();

		// Should not throw exception
		p.encode(msg);

		msg.getPID2().parse("PID|2");

		try {
			p.encode(msg);
			fail();
		} catch (HL7Exception e) {
			// good!
		}

	}

	@Test
	public void testVersionsLoadCorrectly() throws HL7Exception, IOException {
		DefaultModelClassFactory mcf = new DefaultModelClassFactory();
		Map<String, String> evtMap = mcf.getEventMapForVersion(Version.V25);
		
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.addAll(evtMap.keySet());
		treeSet.addAll(evtMap.values());
		
		for (String nextStruct : treeSet) {
			if (!nextStruct.startsWith("ADT_")) {
				continue;
			}

			ourLog.info("Testing structure {}", nextStruct);

			Class<? extends Message> clazz = mcf.getMessageClass(nextStruct, "2.5", false);
			AbstractMessage normalMsg = (AbstractMessage) ReflectionUtil.instantiateMessage(clazz, mcf);
			String[] split = nextStruct.split("_");
			normalMsg.initQuickstart(split[0], split[1], "T");

			for (String nextName : normalMsg.getNames()) {

				if (nextName.equals("MSH")) {
					continue;
				}
				
				if (!normalMsg.isGroup(nextName)) {
					Segment seg = (Segment) normalMsg.get(nextName);
					seg.parse(nextName.substring(0, 3));
				}
			}

			ourLog.info("Structure:\n{}", normalMsg.printStructure());

			String encode = normalMsg.encode();

			ADT_AXX axx = new ADT_AXX();
			axx.parse(encode);

			ourLog.info("Message:\n{}", encode.replace('\r', '\n'));

			ourLog.info("Structure:\n{}", axx.printStructure());

			for (String nextName : normalMsg.getNames()) {

				if (nextName.equals("MSH")) {
					continue;
				}

				if (normalMsg.isGroup(nextName) == false) {
					Segment seg = (Segment) axx.get(nextName);
					String expected = (nextName.substring(0, 3));
					String actual = seg.encode();
					assertEquals(expected, actual);
				}
			}

		}

	}

}
