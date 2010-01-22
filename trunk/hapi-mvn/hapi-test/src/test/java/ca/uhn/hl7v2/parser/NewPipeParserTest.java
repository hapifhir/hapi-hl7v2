package ca.uhn.hl7v2.parser;

import java.io. IOException;
import java.io.InputStream;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v24.datatype.HD;
import ca.uhn.hl7v2.model.v24.datatype.SI;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.EVN;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v25.message.ADT_A03;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.SizeRule;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class NewPipeParserTest extends TestCase {
	private Parser parser;

	public void setUp() throws Exception {
		parser = new PipeParser();
	}

	public void testAL1Reps() throws IOException, EncodingNotSupportedException, HL7Exception {
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ca/uhn/hl7v2/parser/adt_a03.txt");
		byte[] bytes = new byte[10000];
		StringBuffer buffer = new StringBuffer();
		int count;
		while ((count = stream.read(bytes)) > 0) {
			buffer.append(new String(bytes), 0, count);
		}

		String er7Message = buffer.toString();

		ca.uhn.hl7v2.model.v25.message.ADT_A03 message = (ADT_A03) parser.parse(er7Message);

		System.out.println(message.getAL1Reps());
		System.out.println(parser.encode(message));
	}

	public void testGetVersion() throws Exception {
		String message = "MSH|^~\\&|3|4|5|6|7|8|9|10|11|12|13|||\rMSA|foo\rERR|bar|||";
		assertEquals("12", parser.getVersion(message));
		message = "MSH|^~\\&|STML|001|STML|001|20020307142717||ADT^A08|01501|T|2.2|||AL|NE\rEVN|A08|20020307142652";
		assertEquals("2.2", parser.getVersion(message));
		message = "MSH|^~\\&|STML|001|STML|001|20020307142717||ADT^A08|01501|T|2.2^x^x|||AL|NE\rEVN|A08|20020307142652";
		assertEquals("2.2", parser.getVersion(message));
	}

	public void testGetAckID() throws Exception {
		String message = "MSH|foo|foo";
		String ackID = parser.getAckID(message);
		assertEquals(null, ackID);
		message = "MSH|^~\\&|STML|001|STML|001|20020307142616||ADT^A05|01500|T|2.2|||AL|NE\rEVN|A05|20020307142547|200203081424\rPID|0001||000005222||TEST^BRIAN||19700623|M||C|30815 RAYBURN^^LIVONIA^MI^48154-0000^USA||(313)422-2182|||S||0001445|380-96-9087\rPV1|0001|O|PR|EL|T0468423||00410^KRISHNAN AMBA MD|||PRO||||1||||O||2||||||||||||||||||||||||||0000000.00|0000000.00|0000000.00|0000000.00\rPV2|||^IV THERAPY|||||20020308\rOBX|0001|ST|ADMIT DIAGNOSIS TEXT\rOBX|0002|ST|1010.1^WEIGHT(KG)^AS4\rOBX|0003|ST|1010.3^HEIGHT(CM)^AS4\rOBX|0004|ST|ALLERGY FREE TEXT\rGT1|0001|0003225|TEST^BRIAN||30815 RAYBURN^^LIVONIA^MI^48154-0000^USA|(313)422-2182||19700623|M||SE|380969087|||||^^^^^USA|||1\rIN1|0001|09|210|BCBSM BC OF MI|600 EAST LAFAYETTE^^DETROIT^MI^48226-0000^USA|||77777|FULL BC|||||||TEST^BRIAN|SE|19700623|30815 RAYBURN^^LIVONIA^MI^48154-0000^USA|Y|Y||||||Y|Y|20020307||||||21009|XYZ380969087||||||1|M|^^^^^USA\rIN2||380969087|||||||||||||||||||N|||||||SPR^LM^00677.00~ICU^LM^02068.00\rIN1|0002|09|211|BCBSM BS OF MI P/C PLAN|600 EAST LAFAYETTE^^DETROIT^MI^48226-0000^USA|||77777|FULL|||||||TEST^BRIAN|SE|19700623|30815 RAYBURN^^LIVONIA^MI^48154-0000^USA|Y|N||||||Y|Y|20020307||||||21109|XYZ380969087||||||1|M|^^^^^USA\rIN2||380969087|||||||||||||||||||N";
		ackID = parser.getAckID(message);
		assertEquals(null, ackID);
	}

	/**
	 * If there are multiple locations in a group that have the right type for a
	 * segment, it should be placed in the first location following the last
	 * location that was filled. It shouldn't be placed in a location preceding
	 * previously used locations.
	 */
	public void testCorrectSegmentOrderWithMultipleOptions() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
				"ORC|\r" + //
				"OBX|\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(0).getNTE(0).getComment(0).getValue();

		System.out.println(parser.encode(msg));
		assertEquals("test", val);
	}

	public void testNonStandardSegmentNearStart() throws EncodingNotSupportedException, HL7Exception {
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r";

		ca.uhn.hl7v2.model.v23.message.ORU_R01 message = (ca.uhn.hl7v2.model.v23.message.ORU_R01) parser.parse(string);

		String reEncoded = parser.encode(message);
		System.out.println(reEncoded);
		assertEquals(string, reEncoded);

		String pidMrn = message.getRESPONSE().getPATIENT().getPID().getPid3_PatientIDInternalID(0).getCx1_ID().getValue();
		assertEquals("7005728", pidMrn);
	}

	public void testNonStandardSegmentNearEnd() throws EncodingNotSupportedException, HL7Exception {
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r"
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

		Message message = parser.parse(string);

		String reEncoded = parser.encode(message);
		System.out.println(reEncoded);
		assertEquals(string, reEncoded);

	}

	public void testNonStandardSegmentAfterEnd() throws EncodingNotSupportedException, HL7Exception {
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r" + "DSC|1\r"
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

		Message message = parser.parse(string);

		String reEncoded = parser.encode(message);
		System.out.println(reEncoded);
		assertEquals(string, reEncoded);

	}

	/**
	 * Test repeating segment location
	 */
	public void testRepeatingSegment() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
				"ORC|\r" + //
				"OBX|1\r" + //
				"OBX|2\r" + //
				"OBX|3\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);

		assertEquals("1", msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
		assertEquals("2", msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(1).getOBX().getSetIDOBX().getValue());
		assertEquals("3", msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(2).getOBX().getSetIDOBX().getValue());

	}

	/**
	 * If a repeating group has an optional first child,
	 */
	public void testRepeatingGroupWithOptionalFirstSegment() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
				"ORC|\r" + // 
				"CTI|\r" + //
				"OBR|\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);

		System.out.println(parser.encode(msg));

		String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
		assertEquals(null, val);

		val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
		assertEquals("test", val);

		val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
		assertEquals(null, val);

		val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
		assertEquals(null, val);

	}

	/**
	 * If there is a location in a certain group that is the right type for a
	 * certain segment, and a later segment has already been populated, and the
	 * group is repeating, then a new group instance should be created and the
	 * segment should be placed there.
	 */
	public void testParseIntoNewGroupIfMisorderedInCurrentGroup() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
				"ORC|\r" + // 
				"CTI|\r" + //
				"ORC|\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);

		System.out.println(parser.encode(msg));

		String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
		assertEquals(null, val);

		val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
		assertEquals("test", val);

		val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(0).getNTE().getComment(0).getValue();
		assertEquals(null, val);

		val = msg.getPATIENT_RESULT(1).getORDER_OBSERVATION(1).getNTE().getComment(0).getValue();
		assertEquals(null, val);

	}

	/**
	 * Check that parsing an empty segment doesn't crash
	 */
	public void testParseEmptySegment() throws EncodingNotSupportedException, HL7Exception {
		String message = "MSH|^~\\&|||||20080627102031.292+0100||ADT^A31^ADT_A31|EJ557600005480760|P|2.3|||||BE|8859/1|FR\r\n" + "EVN||20080627101943+0100\r\n"
				+ "PID|||M07869D^^^ADMISSION^^ISSTLUC||DUPONT^JEAN||19701004000000+0100|M\r\n" + "PD1\r\n" + "PV1||N";
		parser.parse(message);
	}

	/**
	 * If there is a potential location for a segment in a certain group, but
	 * the entire group is out of order, the segment should not be placed there
	 * (in a current or subsequent repetition).
	 */
	public void testNotParseIntoNewGroupIfWholeGroupMisordered() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
				"DSC|\r" + // 
				"PID||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		verifyIDNull(msg.getPATIENT_RESULT(0).getPATIENT().getPID());
		verifyIDNull(msg.getPATIENT_RESULT(1).getPATIENT().getPID());
	}

	/** Make sure PID-2 not valued */
	private void verifyIDNull(PID pid) {
		String val = pid.getPatientID().getID().getValue();
		assertTrue(val == null || val.length() == 0);
	}

	public void testComponents() throws Exception {
		// test normal component, subcomponent
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|||||x&y^z|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		PID pid = msg.getPATIENT_RESULT().getPATIENT().getPID();
		assertEquals("x", pid.getPatientName(0).getFamilyName().getSurname().getValue());
		assertEquals("y", pid.getPatientName(0).getFamilyName().getOwnSurnamePrefix().getValue());
		assertEquals("z", pid.getPatientName(0).getGivenName().getValue());
	}

	public void testExtraComponents() throws Exception {
		// an extra subcomponent on a primitive field is treated as an
		// ExtraComponent of the Primitive
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|4&y\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		SI si = msg.getPATIENT_RESULT().getPATIENT().getPID().getSetIDPID();
		assertEquals("4", si.getValue());
		assertEquals("y", ((Primitive) si.getExtraComponents().getComponent(0).getData()).getValue());

		// an extra COMPONENT on a primitive field is also treated in this way,
		// and replaces the subcomp if both are present
		message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|4&y^x\r";
		msg = (ORU_R01) parser.parse(message);
		si = msg.getPATIENT_RESULT().getPATIENT().getPID().getSetIDPID();
		assertEquals("4", si.getValue());
		assertEquals("x", ((Primitive) si.getExtraComponents().getComponent(0).getData()).getValue());

		// subcomponents on extra components are recognized as such
		message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|4&y^x&z\r";
		msg = (ORU_R01) parser.parse(message);
		si = msg.getPATIENT_RESULT().getPATIENT().getPID().getSetIDPID();
		assertEquals("4", si.getValue());
		// assertEquals("z", ((Primitive)
		// si.getExtraComponents().getComponent(0).getExtraComponents().getComponent(0).getData()).getValue());
		Composite c = (Composite) si.getExtraComponents().getComponent(0).getData();
		assertEquals("z", ((Primitive) ((Varies) c.getComponent(1)).getData()).getValue());
	}

	public void testExtraFieldReps() throws Exception {
		String message = "MSH|^~\\&|one~two~three||||||ORU^R01|1|D|2.4\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		assertEquals("three", ((HD) msg.getMSH().getField(3, 2)).getNamespaceID().getValue());
	}

	public void testEscape() throws Exception {
		ACK ack = new ACK();
		ack.getMSH().getFieldSeparator().setValue("|");
		ack.getMSH().getEncodingCharacters().setValue("^~\\&");
		ack.getMSA().getAcknowledgementCode().setValue("|");
		String expected = "MSH|^~\\&\rMSA|\\F\\\r";
		String actual = this.parser.encode(ack);
		assertEquals(expected, actual);
	}

	public void testUnescape() throws Exception {
		String text = "MSH|^~\\&|\\F\\||||||ORU^R01|1|D|2.4\r";
		Message message = this.parser.parse(text);
		Terser t = new Terser(message);
		assertEquals("|", t.get("MSH-3"));
	}

	public void testEarlyNonStandard() throws EncodingNotSupportedException, HL7Exception {
		String message = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ADT^A03|263206|P|2.5\r\n"
				+ "EVN||200803051509||||200803031508\r\n"
				+ "ZZZ|aaa\r\n"
				+ "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r\n"
				+ "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r\n"
				+ "PR1|1||1111^Mastoplastica|Protesi|20090224|02|";

		Message parsed = parser.parse(message);
		// This caused a hang at one point in development

	}

	public void testValidation() throws Exception {
		ValidationContextImpl context = new ValidationContextImpl();
		context.getEncodingRuleBindings().add(new RuleBinding("*", "*", new FooEncodingRule()));
		context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new BarMessageRule()));
		context.getPrimitiveRuleBindings().add(new RuleBinding("*", "NM", new SizeRule(5)));
		parser.setValidationContext(context);

		String text = "MSH|^~\\&|bar|foo|||||ORU^R01|1|D|2.4|12345\r";
		Message m = parser.parse(text);

		try {
			text = "MSH|^~\\&|ba|foo|||||ORU^R01|1|D|2.4|12345\r";
			m = parser.parse(text);
			fail("Shoud have failed message rule");
		} catch (HL7Exception e) {
		}

		try {
			text = "MSH|^~\\&|bar|fo|||||ORU^R01|1|D|2.4|12345\r";
			m = parser.parse(text);
			fail("Shoud have failed encoding rule");
		} catch (HL7Exception e) {
		}

		try {
			text = "MSH|^~\\&|ba|foo|||||ORU^R01|1|D|2.4|123456\r";
			m = parser.parse(text);
			fail("Shoud have failed datatype rule on field 13");
		} catch (HL7Exception e) {
		}
	}

	/**
	 * If a non-repeating segment is found to be repeating, the extra should be
	 * added as a non standard segment.
	 */
	public void testDuplicateSegment() throws HL7Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ADT^A01|1|D|2.4\r" + //
				"EVN|R01\r" + //
				"EVN|R02\r" + //
				"PID|1\r";

		ADT_A01 parsed = (ADT_A01) parser.parse(message);
		System.out.println(parser.encode(parsed));

		assertEquals("R01", parsed.getEVN().getEventTypeCode().getValue());

		EVN group = (EVN) parsed.get("EVN2");
		assertNotNull(group);
		assertEquals("R02", group.getEventTypeCode().getValue());

		assertEquals("1", parsed.getPID().getSetIDPID().getValue());

		Structure rep2 = parsed.get("EVN2");

		assertTrue(rep2 instanceof EVN);
	}

	/**
	 * See http://sourceforge.net/tracker/index.php?func=detail&aid=1536200&
	 * group_id=38899&atid=423835
	 * 
	 * @throws EncodingNotSupportedException
	 *             -
	 * @throws HL7Exception
	 *             -
	 */
	public void testInvalidSegmentName() throws EncodingNotSupportedException, HL7Exception {

		String msg = "MSH|^~\\&||Big Laboratory^33D0123456^CLIA|GEN2|NYSDOH|20060802101649||ORU^R01|200608021016491003|D|2.3\r\n"
				+ "I|||13198751^^^^^Big Laboratory&33D0123456&CLIA||DREST^NATALIE^||19500101|F|||123 MAIN ST^^SPRINGFIELD^NY^12345||^^^^^518^1234567\r\n"
				+ "OBR|1||13198751|^^^207252^CULTURE,SALMONELLA/SHIG^L|||200607280943|||||||20060729101650|STOOL-STOOL&STOOL-STOOL|^HERTZ, JOHN Q|^^^^^518^5551212||||||||F\r\n"
				+ "ZLR|456 WASHINGTON BLVD^SUITE 100^ALBANY^NY^12345|HERTZ^JOHN^Q^^^MD|456 WASHINGTON BLVD^SUITE 100^ALBANY^NY^12345|^^^^^518^4567890\r\n"
				+ "OBX|1|CE|^^^60101058^CULTURE,SALMONELLA/SHIGELLA,STOOL^L|1|^^^SASP^Salmonella sp., not typhi^L||||||F|||200608011318|33D0123456^Big Laboratory^CLIA";
		Message message = parser.parse(msg);

	}

	public void testNonPipeDelimitor() throws EncodingNotSupportedException, HL7Exception {
		String msg = "MSH^~|\\&^HDRVTLS^552~DAYTDEV.FO-BAYPINES.MED.VA.GOV~DNS^GMRV VDEF IESIDE^200HD~HDR.MED.VA.GOV~DNS^20061006151615-0800^^ORU~R01^55253408603^T^2.4^^^AL^NE^US\r\n"
				+ "ORC^RE^^6240020~552_120.5^^^^^^^^^^OBS23~325~~~~~~~23 HOUR OBSERVATION^^^^552~DAYTON~L^^^^DAYTON\r\n"
				+ "OBR^^^6240020~552_120.5^4500635~PAIN~99VA120.51^^^200610061445-0800^20061006144607-0800^^^^^^^^^^^^^^20061006144607-0800^^^E^^^^^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n"
				+ "OBX^^ST^4500635~PAIN~99VA120.51^^3^~~L^^^^^W^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n"
				+ "OBX^^CE^Error Reasons^^4500627~INCORRECT READING~99VA8985.1^^^^^^W^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n" 
				+ "ZSC^^291^OBSERVATION SURGERY";

		parser.parse(msg);

	}

	public void testUnknownVersion() throws EncodingNotSupportedException, HL7Exception {

		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.999\r" + // 
				"ORC|ORC1\r" + //
				"OBX|1\r" + //
				"NTE|||NTE1|\r" + //
				"ZNT|ZNT1\r" + //
				"ORC|ORC2";

		ORU_R01 parsed = (ORU_R01) parser.parse(message);
		System.out.println(parser.encode(parsed));
	}

	public void testParseNonStandardSegment() throws EncodingNotSupportedException, HL7Exception {

		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
				"ORC|ORC1\r" + //
				"OBX|1\r" + //
				"NTE|||NTE1|\r" + //
				"ZNT|ZNT1\r" + //
				"ORC|ORC2";

		ORU_R01 parsed = (ORU_R01) parser.parse(message);
		System.out.println(parser.encode(parsed));

		assertEquals("ORC1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getORC().getOrderControl().getValue());
		assertEquals("1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
		assertEquals("NTE1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getNTE(0).getComment(0).getValue());
		assertEquals("ORC2", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(1).getORC().getOrderControl().getValue());
		Segment znt = (Segment) parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).get("ZNT");
		assertNotNull(znt);
		assertEquals("ZNT1", ((Primitive) ((Varies) znt.getField(1, 0)).getData()).getValue());

		message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + // 
				"ORC|ORC1\r" + //
				"OBX|1\r" + //
				"NTE|||NTE1|\r" + //
				"ZNT|ZNT1";

		parsed = (ORU_R01) parser.parse(message);
		System.out.println(parser.encode(parsed));

		assertEquals("ORC1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getORC().getOrderControl().getValue());
		assertEquals("1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
		assertEquals("NTE1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getNTE(0).getComment(0).getValue());
		znt = (Segment) parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).get("ZNT");
		assertNotNull(znt);
		assertEquals("ZNT1", ((Primitive) ((Varies) znt.getField(1, 0)).getData()).getValue());

	}

	public void testEmptySegment() throws EncodingNotSupportedException, HL7Exception {
		String msg = "MSH|^~\\&|1444-ADT|1444|S-ADT|SIMS|20071023160622||ADT^A03^ADT_A05|Q67084255T54052896X2|P^T|2.5|||NE|AL|CAN|8859/1\r\n"
				+ "EVN|A03|20071023160622\r\n"
				+ "PID|1||00J8804997^^^1444^MR~165640^^^CANON^JHN^^^^^WT||Aalan^Angus^^^^^L||19620404|F|||101 Ames Ave^^Toronto^CA- ON^M2N7J6^CAN^H||^PRN^PH^^1^416^5551545|^PRN^PH^^1^416^2227788|| C||||||||||||||N\r\n"
				+ "PV1";
		Message message = parser.parse(msg);
	}

	private static class FooEncodingRule implements EncodingRule {
		/**
		 * @see ca.uhn.hl7v2.validation.EncodingRule#test(java.lang.String)
		 */
		public ValidationException[] test(String arg0) {
			if (arg0.indexOf("foo") < 0) {
				return new ValidationException[] { new ValidationException("Not enough foo") };
			} else {
				return new ValidationException[] {};
			}
		}

		/**
		 * @see ca.uhn.hl7v2.validation.Rule#getDescription()
		 */
		public String getDescription() {
			return null;
		}

		/**
		 * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
		 */
		public String getSectionReference() {
			return null;
		}
	}

	private static class BarMessageRule implements MessageRule {

		/**
		 * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
		 */
		public ValidationException[] test(Message arg0) {
			Terser t = new Terser(arg0);
			String msh3;
			try {
				msh3 = t.get("/MSH-3");
			} catch (HL7Exception e) {
				return new ValidationException[] { new ValidationException("Bad bar") };
			}
			if (!msh3.equals("bar")) {
				return new ValidationException[] { new ValidationException("Not enough bar") };
			} else {
				return new ValidationException[] {};
			}
		}

		/**
		 * @see ca.uhn.hl7v2.validation.Rule#getDescription()
		 */
		public String getDescription() {
			return null;
		}

		/**
		 * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
		 */
		public String getSectionReference() {
			return null;
		}
	}

}
