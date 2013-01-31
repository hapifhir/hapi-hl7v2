package ca.uhn.hl7v2.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.IndexedErrorCollector;
import ca.uhn.hl7v2.TestSpec;
import ca.uhn.hl7v2.TestSpecBuilder;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v23.datatype.ST;
import ca.uhn.hl7v2.model.v23.message.ADT_A04;
import ca.uhn.hl7v2.model.v23.message.SIU_S12;
import ca.uhn.hl7v2.model.v231.message.ORM_O01;
import ca.uhn.hl7v2.model.v24.datatype.FT;
import ca.uhn.hl7v2.model.v24.datatype.HD;
import ca.uhn.hl7v2.model.v24.datatype.SI;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.EVN;
import ca.uhn.hl7v2.model.v24.segment.OBX;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v25.datatype.TS;
import ca.uhn.hl7v2.model.v25.message.ADT_A03;
import ca.uhn.hl7v2.model.v25.message.ADT_A45;
import ca.uhn.hl7v2.model.v25.message.REF_I12;
import ca.uhn.hl7v2.model.v25.segment.PV1;
import ca.uhn.hl7v2.model.v251.message.ADT_A17;
import ca.uhn.hl7v2.model.v251.message.OML_O21;
import ca.uhn.hl7v2.model.v251.message.ORL_O22;
import ca.uhn.hl7v2.model.v251.message.ORL_O34;
import ca.uhn.hl7v2.model.v251.message.OUL_R22;
import ca.uhn.hl7v2.parser.testmodel.MessageWithGroupWithRequiredFinalSegment;
import ca.uhn.hl7v2.parser.testmodel.MessageWithMandatorySegmentAfterSubgroup;
import ca.uhn.hl7v2.parser.testmodel.MessageWithMandatorySegmentBeforeSubgroup;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.impl.AbstractEncodingRule;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;

public class NewPipeParserTest {

	private static final Parser parser = new PipeParser();
	private static final Logger ourLog = LoggerFactory.getLogger(NewPipeParserTest.class);

	@Rule
	public IndexedErrorCollector collector = new IndexedErrorCollector();

	public static class InvalidMessageSpec1 extends TestSpec<String, Message> {

		private Message msg;

		public InvalidMessageSpec1() {
			msg = new ADT_A01();
		}

		@Override
		protected Message transform(String input) throws Throwable {
			msg.parse(input);
			return msg;
		}

	}

	public static class InvalidMessageSpec2 extends TestSpec<String, Message> {

		@Override
		protected Message transform(String input) throws Throwable {
			return parser.parse(input);
		}

	}

	/**
	 * See http://sourceforge.net/p/hl7api/bugs/171/
	 */
	@Test
	public void testGreedyMode() throws HL7Exception, IOException {
		OML_O21 msg = new OML_O21();
		msg.initQuickstart("OML", "O21", "T");

		for (int i = 0; i < 5; i++) {
			msg.getORDER(i).getORC().getOrc1_OrderControl().setValue("NW");
			msg.getORDER(i).getORC().getOrc2_PlacerOrderNumber().getEi1_EntityIdentifier().setValue("ORCID1");
			msg.getORDER(i).getORC().getOrc2_PlacerOrderNumber().getEi2_NamespaceID().setValue("HCE");
			msg.getORDER(i).getORC().getOrc4_PlacerGroupNumber().getEi1_EntityIdentifier().setValue("grupo");

			msg.getORDER(i).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue("STDIO1");
			msg.getORDER(i).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe3_NameOfCodingSystem().setValue("LOINC");
		}

		// Parse and encode
		PipeParser pp = new PipeParser();
		pp.getParserConfiguration().setNonGreedyMode(true);
		msg = (OML_O21) pp.parse(msg.encode());

		ourLog.info(msg.printStructure(false));

		for (int i = 0; i < 5; i++) {
			ourLog.info("Testing rep " + i);

			String actual = msg.getORDER(i).getORC().getOrc1_OrderControl().getValue();
			assertEquals("NW", actual);

			actual = msg.getORDER(i).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue();
			assertEquals("STDIO1", actual);
		}

		// Now turn off greedy mode
		pp.getParserConfiguration().setNonGreedyMode(false);
		msg = (OML_O21) pp.parse(msg.encode());

		{
			String actual = msg.getORDER(0).getORC().getOrc1_OrderControl().getValue();
			assertEquals("NW", actual);

			actual = msg.getORDER(0).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue();
			assertEquals("STDIO1", actual);
		}

		for (int i = 1; i < 5; i++) {
			ourLog.info("Testing rep " + i);

			String actual = msg.getORDER(i).getORC().getOrc1_OrderControl().getValue();
			assertEquals(null, actual);

			actual = msg.getORDER(i).getOBSERVATION_REQUEST().getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue();
			assertEquals(null, actual);
		}

	}

	/**
	 * See http://sourceforge.net/p/hl7api/bugs/171/
	 */
	@Test
	public void testGreedyModeMore() throws HL7Exception, IOException {

		DefaultHapiContext ctx = new DefaultHapiContext();
		ctx.getParserConfiguration().setNonGreedyMode(false);

		InputStream str = NewPipeParserTest.class.getResourceAsStream("/ca/uhn/hl7v2/parser/example_oml_o21.hl7");
		Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(str, ctx);
		while (iter.hasNext()) {
			Message msg = iter.next();
			if (msg instanceof OUL_R22) {
			} else if (msg instanceof ORL_O34) {
			} else if (msg instanceof ca.uhn.hl7v2.model.v251.message.ORU_R01) {
			} else if (msg instanceof ca.uhn.hl7v2.model.v25.message.OML_O21) {
			} else {
				OML_O21 next = (OML_O21) msg;
				assertTrue(next.getORDER().getOBSERVATION_REQUEST().getPRIOR_RESULTAll().size() == 0);
			}
		}

	}

	/**
	 * Make sure the appropriate exception is thrown
	 */
	@Test
	public void testInvalidShortMessages1() {

		Class<HL7Exception> c = HL7Exception.class;
		TestSpecBuilder.buildSpecs(InvalidMessageSpec1.class).add("", c).add("M", c).add("MS", c).add("MSH", c).add("MSH|", c).add("\r", c).add("M\r", c).add("MS\r", c).add("MSH\r", c).add("MSH|\r", c).executeTests(collector);
	}

	@Test
	public void testInvalidShortMessages2() {

		Class<EncodingNotSupportedException> c = EncodingNotSupportedException.class;
		TestSpecBuilder.buildSpecs(InvalidMessageSpec2.class).add("", c).add("M", c).add("MS", c).add("MSH", c).add("MSH|", c).add("\r", c).add("M\r", c).add("MS\r", c).add("MSH\r", c).add("MSH|\r", c).executeTests(collector);
	}

	/**
	 * http://sourceforge.net/p/hl7api/feature-requests/64/
	 */
	@Test
	public void testUnexpectedSegmentHintsNone() throws HL7Exception {

		String msgS = "MSH|^~\\&|DATASERVICES|CORPORATE|||20120711120510.2-0500||ADT^A01^ADT_A01|9c906177-dfca-4bbe-9abd-d8eb43df93a0|D|2.6\r\n" + // -
				"EVN||20120701000000-0500\r\n" + // -
				"PID|1||397979797^^^SN^SN~4242^^^BKDMDM^PI~1000^^^YARDI^PI||Williams^Rory^H^^^^A||19641028000000-0600|M||||||||||31592^^^YARDI^AN\r\n" + // -
				"NK1|1|Pond^Amelia^Q^^^^A|SPO|1234 Main St^^Sussex^WI^53089|^PRS^CP^^^^^^^^^555-1212||N\r\n" + // -
				"NK1|2|Smith^John^^^^^A~^The Doctor^^^^^A|FND|1234 S Water St^^New London^WI^54961||^WPN^PH^^^^^^^^^555-9999|C\r\n" + // -
				"PV1|2|I||R\r\n" + // -
				"GT1|1||Doe^John^A^^^^A||5678 Maple Ave^^Sussex^WI^53089|^PRS^PH^^^^^^^^^555-9999|||||OTH\r\n" + // -
				"IN1|1|CAP1000|YYDN|ACME HealthCare||||GR0000001|||||||HMO|||||||||||||||||||||PCY-0000042\r\n" + // -
				"IN1|2||||||||||||||Medicare|||||||||||||||||||||123-45-6789-A\r\n" + // -
				"IN1|3||||||||||||||Medicaid|||||||||||||||||||||987654321L\r\n" + // -
				"ZFA|6|31592|12345|YARDI|20120201000000-0600";// -

		DefaultHapiContext ctx = new DefaultHapiContext();
		PipeParser p = ctx.getPipeParser();

		ca.uhn.hl7v2.model.v26.message.ADT_A01 msg = (ca.uhn.hl7v2.model.v26.message.ADT_A01) p.parse(msgS);
		msg.getINSURANCE(2).get("ZFA");
		try {
			msg.get("ZFA");
			fail();
		} catch (HL7Exception e) {
			// good
		}

		ctx.getParserConfiguration().setUnexpectedSegmentBehaviour(UnexpectedSegmentBehaviourEnum.ADD_INLINE);

		msg = (ca.uhn.hl7v2.model.v26.message.ADT_A01) p.parse(msgS);
		msg.getINSURANCE(2).get("ZFA");
		try {
			msg.get("ZFA");
			fail();
		} catch (HL7Exception e) {
			// good
		}

		ctx.getParserConfiguration().setUnexpectedSegmentBehaviour(UnexpectedSegmentBehaviourEnum.DROP_TO_ROOT);

		msg = (ca.uhn.hl7v2.model.v26.message.ADT_A01) p.parse(msgS);
		msg.get("ZFA");
		try {
			msg.getINSURANCE(2).get("ZFA");
			fail();
		} catch (HL7Exception e) {
			// good
		}

	}

	/**
	 * http://sourceforge.net/p/hl7api/feature-requests/64/
	 */
	@Test
	public void testUnexpectedSegmentHintsInline() throws HL7Exception {

		String msgS = "MSH|^~\\&|DATASERVICES|CORPORATE|||20120711120510.2-0500||ADT^A01^ADT_A01|9c906177-dfca-4bbe-9abd-d8eb43df93a0|D|2.6\r\n" + // -
				"EVN||20120701000000-0500\r\n" + // -
				"PID|1||397979797^^^SN^SN~4242^^^BKDMDM^PI~1000^^^YARDI^PI||Williams^Rory^H^^^^A||19641028000000-0600|M||||||||||31592^^^YARDI^AN\r\n" + // -
				"NK1|1|Pond^Amelia^Q^^^^A|SPO|1234 Main St^^Sussex^WI^53089|^PRS^CP^^^^^^^^^555-1212||N\r\n" + // -
				"NK1|2|Smith^John^^^^^A~^The Doctor^^^^^A|FND|1234 S Water St^^New London^WI^54961||^WPN^PH^^^^^^^^^555-9999|C\r\n" + // -
				"PV1|2|I||R\r\n" + // -
				"GT1|1||Doe^John^A^^^^A||5678 Maple Ave^^Sussex^WI^53089|^PRS^PH^^^^^^^^^555-9999|||||OTH\r\n" + // -
				"IN1|1|CAP1000|YYDN|ACME HealthCare||||GR0000001|||||||HMO|||||||||||||||||||||PCY-0000042\r\n" + // -
				"IN1|2||||||||||||||Medicare|||||||||||||||||||||123-45-6789-A\r\n" + // -
				"IN1|3||||||||||||||Medicaid|||||||||||||||||||||987654321L\r\n" + // -
				"ZFA|6|31592|12345|YARDI|20120201000000-0600";// -

		DefaultHapiContext ctx = new DefaultHapiContext();
		PipeParser p = ctx.getPipeParser();

		ctx.getParserConfiguration().setUnexpectedSegmentBehaviour(UnexpectedSegmentBehaviourEnum.ADD_INLINE);

		ca.uhn.hl7v2.model.v26.message.ADT_A01 msg = (ca.uhn.hl7v2.model.v26.message.ADT_A01) p.parse(msgS);
		msg.getINSURANCE(2).get("ZFA");
		try {
			msg.get("ZFA");
			fail();
		} catch (HL7Exception e) {
			// good
		}

	}

	/**
	 * http://sourceforge.net/p/hl7api/feature-requests/64/
	 */
	@Test(expected = HL7Exception.class)
	public void testUnexpectedSegmentHintsException() throws HL7Exception {

		String msgS = "MSH|^~\\&|DATASERVICES|CORPORATE|||20120711120510.2-0500||ADT^A01^ADT_A01|9c906177-dfca-4bbe-9abd-d8eb43df93a0|D|2.6\r\n" + // -
				"EVN||20120701000000-0500\r\n" + // -
				"PID|1||397979797^^^SN^SN~4242^^^BKDMDM^PI~1000^^^YARDI^PI||Williams^Rory^H^^^^A||19641028000000-0600|M||||||||||31592^^^YARDI^AN\r\n" + // -
				"NK1|1|Pond^Amelia^Q^^^^A|SPO|1234 Main St^^Sussex^WI^53089|^PRS^CP^^^^^^^^^555-1212||N\r\n" + // -
				"NK1|2|Smith^John^^^^^A~^The Doctor^^^^^A|FND|1234 S Water St^^New London^WI^54961||^WPN^PH^^^^^^^^^555-9999|C\r\n" + // -
				"PV1|2|I||R\r\n" + // -
				"GT1|1||Doe^John^A^^^^A||5678 Maple Ave^^Sussex^WI^53089|^PRS^PH^^^^^^^^^555-9999|||||OTH\r\n" + // -
				"IN1|1|CAP1000|YYDN|ACME HealthCare||||GR0000001|||||||HMO|||||||||||||||||||||PCY-0000042\r\n" + // -
				"IN1|2||||||||||||||Medicare|||||||||||||||||||||123-45-6789-A\r\n" + // -
				"IN1|3||||||||||||||Medicaid|||||||||||||||||||||987654321L\r\n" + // -
				"ZFA|6|31592|12345|YARDI|20120201000000-0600";// -

		DefaultHapiContext ctx = new DefaultHapiContext();
		PipeParser p = ctx.getPipeParser();

		ctx.getParserConfiguration().setUnexpectedSegmentBehaviour(UnexpectedSegmentBehaviourEnum.THROW_HL7_EXCEPTION);

		ca.uhn.hl7v2.model.v26.message.ADT_A01 msg = (ca.uhn.hl7v2.model.v26.message.ADT_A01) p.parse(msgS);
		msg.getINSURANCE(2).get("ZFA");
		try {
			msg.get("ZFA");
			fail();
		} catch (HL7Exception e) {
			// good
		}

	}

	/**
	 * http://sourceforge.net/p/hl7api/feature-requests/64/
	 */
	@Test
	public void testUnexpectedSegmentHintsDropToRoot() throws HL7Exception {

		String msgS = "MSH|^~\\&|DATASERVICES|CORPORATE|||20120711120510.2-0500||ADT^A01^ADT_A01|9c906177-dfca-4bbe-9abd-d8eb43df93a0|D|2.6\r\n" + // -
				"ZZA|1" + // -
				"EVN||20120701000000-0500\r\n" + // -
				"PID|1||397979797^^^SN^SN~4242^^^BKDMDM^PI~1000^^^YARDI^PI||Williams^Rory^H^^^^A||19641028000000-0600|M||||||||||31592^^^YARDI^AN\r\n" + // -
				"NK1|1|Pond^Amelia^Q^^^^A|SPO|1234 Main St^^Sussex^WI^53089|^PRS^CP^^^^^^^^^555-1212||N\r\n" + // -
				"NK1|2|Smith^John^^^^^A~^The Doctor^^^^^A|FND|1234 S Water St^^New London^WI^54961||^WPN^PH^^^^^^^^^555-9999|C\r\n" + // -
				"PV1|2|I||R\r\n" + // -
				"GT1|1||Doe^John^A^^^^A||5678 Maple Ave^^Sussex^WI^53089|^PRS^PH^^^^^^^^^555-9999|||||OTH\r\n" + // -
				"IN1|1|CAP1000|YYDN|ACME HealthCare||||GR0000001|||||||HMO|||||||||||||||||||||PCY-0000042\r\n" + // -
				"IN1|2||||||||||||||Medicare|||||||||||||||||||||123-45-6789-A\r\n" + // -
				"IN1|3||||||||||||||Medicaid|||||||||||||||||||||987654321L\r\n" + // -
				"ZFA|6|31592|12345|YARDI|20120201000000-0600";// -

		DefaultHapiContext ctx = new DefaultHapiContext();
		PipeParser p = ctx.getPipeParser();

		ctx.getParserConfiguration().setUnexpectedSegmentBehaviour(UnexpectedSegmentBehaviourEnum.DROP_TO_ROOT);

		ca.uhn.hl7v2.model.v26.message.ADT_A01 msg = (ca.uhn.hl7v2.model.v26.message.ADT_A01) p.parse(msgS);
		msg.get("ZZA");
		msg.get("ZFA");
		try {
			msg.getINSURANCE(2).get("ZFA");
			fail();
		} catch (HL7Exception e) {
			// good
		}

	}

	/**
	 * See 1643780
	 */
	@Test
	public void testMisplacedAl1() throws Exception {

		// AIL is non-standard
		String msgText = "MSH|^~\\&|IDX|XXXX|COMMON|EXTERNAL|200608140653||ADT^A04|60491_4054_SC1|P|2.3\r" + "PID|||868063820614||||^003|F||1|^^^^84606|||||S\r" + "PV1||O||10||||||||||||||||||||||||||||||||||||||||200501091835\r" + "AIL|1||871|10|\r"
				+ "DG1||||RASH ON BACK AND RT LEG\r" + "IN1||||||||||||||||||||||||||||||||||||||||||||";

		ADT_A04 msg = new ADT_A04();
		msg.setParser(parser);
		msg.parse(msgText);

		ourLog.debug(msg.printStructure());

		assertEquals("RASH ON BACK AND RT LEG", msg.getDG1().getDg14_DiagnosisDescription().getValue());
	}

	/**
	 * ADT^A45 has the structure:
	 * 
	 * <pre>
	 * MSH 
	 * [ { SFT } ] 
	 * EVN 
	 * PID 
	 * [ PD1 ] 
	 *    MERGE_INFO 
	 *    {
	 *    MRG 
	 *    PV1 
	 *    } 
	 *    MERGE_INFO
	 * </pre>
	 * 
	 * This test checks for correct behaviour if a required segment at the tail
	 * of the message is missing
	 */
	@Test
	public void testMissingRequiredLastSegment() throws HL7Exception {

		String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r" + "EVN|A45|201004141020|\r"
				+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
				+ "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";

		ADT_A45 msg = new ADT_A45();
		msg.setParser(parser);
		msg.parse(messageText);

		assertEquals("7010226", msg.getPID().getPid3_PatientIdentifierList(0).getIDNumber().getValue());
		PV1 pv1 = (PV1) msg.get("PV1");
		assertEquals("I", pv1.getPv12_PatientClass().encode());

		ourLog.debug("\r\n" + msg.toString());

	}

	@Test
	public void testParseRepeatingNonRepeatableSegment() throws HL7Exception {
		String message = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r";

		ca.uhn.hl7v2.model.v23.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v23.message.ORU_R01();
		msg.setParser(parser);
		msg.parse(message);

		String encoded = msg.encode();
		assertEquals(message, encoded);

		ourLog.debug(msg.printStructure());
	}

	@Test
	public void testPreserveFormattingChars() throws HL7Exception {

		String msgString = "MSH|^~\\&|PHCN_ULTRA|2220|HSIE|2220|201106161233||ORU^R01|72313573|T|2.4|||AL|AL|AU\r\n" + "PID|\r" + "PV1||I|^DIS^DIS^2220|||||0129296H^BRAUN^GARY|7MPH^MPH-HL7-RESULT FEED|||||||||I|^^^2220\r\n"
				+ "ORC|RE|^HNAM_ORDERID|11-6879530-GAS-0^PHCN_ULTRA||RE\r\n" + "OBR|1|^HNAM_ORDERID|11-6879530-GAS-0^PHCN_ULTRA|GAS^GASES (BLOOD)|||201106161000|||||||||0129296H^BRAUN^GARY^^^DR^^^2220^^^^Provider Num||||1295102|7MPH|201106161233||GRP|F||^^^201106161203\r\n"
				+ "OBX|1|FT|GAS^^LN||Type Venous\\.br\\\\.br\\ Analysis pH : \\H\\ 7.28\\N\\ (7.38-7.43) ";

		ORU_R01 msg = new ORU_R01();
		msg.setParser(parser);
		msg.parse(msgString);

		OBX obx = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX();

		String obx5val = ((FT) obx.getObx5_ObservationValue(0).getData()).getValue();
		assertTrue(obx5val, obx5val.contains("Type Venous\\.br\\\\.br\\ Analysis"));
		assertTrue(obx5val, obx5val.contains("pH : \\H\\ 7.28\\N\\ (7.38-7.43) "));

		String obx5encoded = obx.getObx5_ObservationValue(0).encode();
		assertTrue(obx5encoded, obx5encoded.contains("Type Venous\\.br\\\\.br\\ Analysis"));
		assertTrue(obx5encoded, obx5encoded.contains("pH : \\H\\ 7.28\\N\\ (7.38-7.43) "));
	}

	/**
	 * http://sourceforge.net/tracker/?func=detail&aid=3212931&group_id=38899&
	 * atid=423835
	 * 
	 * Ensure that the correct class is parsed for 2.3.1 ORM^O01
	 */
	@Test
	public void testParseCorrectClass() throws EncodingNotSupportedException, HL7Exception {

		String sn = "MSH|^~\\&|RIS 2.0|KIR|InterRis 2.0|Receiving facility|20110309132505||ORM^O01|MSG00001|1|2.3.1|1||||SL|UNICODE UTF-8|SL\r" + "PID|||123^^^^^BIS~1234^^^^^HIS~12345^^^^^KZZZ||Lastname^Name^J^Mr|||M\r" + "PV1||E||||||2314^Novak&Janez^^^^Dr.|||||||||||123365\r"
				+ "ORC|AF|1123abc^marand||3|||1^once^^^^U\r" + "OBR|1|1123abc^marand||RDP_10^RDP Kljicnica|||||||||klinicno vprasanje?||^^^^L&Left|12345^Novak^Janez^^^^^^BPI_ZDR|||||||||||1^Once^^^^R\r";

		// java code for parsing,..
		Parser p = new PipeParser();
		final Message msg = p.parse(sn);
		ourLog.debug(msg.getClass().getName());

		assertEquals(msg.getClass(), ORM_O01.class);
	}

	/**
	 * Checking an issue reported by a user where an ampersand in OBx-5 causes
	 * the content after the ampersand to be repeated
	 */
	@Test
	public void testAmpersandInObx5() throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&|\r" + "OBX||ST|||Blood&Plasma - Bio (Green)||||||||||||\r\n";

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

	}

	/**
	 * Make sure mandatory segments are encoded, even if they are empty. This is
	 * required to give parsing applications a hint as to where the following
	 * segments belong.
	 */
	@Test
	public void testEncodeEmptySegmentsIfTheyAreMandatory() throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		String encode = msg.encode();

		assertEquals(msgString.trim(), encode.trim());

		msgString = "MSH|^~\\&\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";

		msg = new ORU_R01();
		msg.parse(msgString);

		encode = msg.encode();

		assertEquals(msgString.trim(), encode.trim());

		/*
		 * Optional segment at the start of group
		 */

		msgString = "MSH|^~\\&\r" // -
				+ "ORC|\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";

		msg = new ORU_R01();
		msg.parse(msgString);

		encode = msg.encode();

		String expected = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";
		assertEquals(expected.trim(), encode.trim());

		/*
		 * Try it with encoding optional segments disabled
		 */

		PipeParser parser2 = new PipeParser();
		parser2.getParserConfiguration().setEncodeEmptyMandatoryFirstSegments(false);
		encode = parser2.encode(msg);
		expected = "MSH|^~\\&\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";
		assertEquals(expected.trim(), encode.trim());

		/*
		 * Optional segment populated at the start of group
		 */

		msgString = "MSH|^~\\&\r" // -
				+ "ORC|1\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";

		msg = new ORU_R01();
		msg.parse(msgString);

		encode = msg.encode();

		assertEquals(msgString.trim(), encode.trim());

	}

	/**
	 * Ensure that incorrectly placed extra segment at end of message is in the
	 * same position when message is re-encoded. This is based on an issue found
	 * by UHN
	 */
	@Test
	public void testAddExtraSegmentToEnd() throws HL7Exception {

		String msgString = "MSH|^~\\&|REG|W|||201103230042||ADT^A06|32153168-A06|P|2.2\r" + "PV2||F||||||||||||||||||||N||AI|Emergency||||||N|||||||OTH^Self^03ZBrInBy\r" + "NK1||||^^^^^^M|||NK\r" + "DG1||IN|MISC|Transient Ischemic Attack / Stroke\r" + "MRG|2804019||11020086571";

		PipeParser p = PipeParser.getInstanceWithNoValidation();
		Message message = p.parse(msgString);

		String encoded = message.encode();

		ourLog.debug("Structure is: " + message.printStructure());

		assertEquals(msgString.trim(), encoded.trim());

	}

	@Test
	public void testTwoSegmentsWithSameName() throws HL7Exception {

		String messageText = "MSH|^~\\&|ULTRA|TML|TML||200903120021||ADT^A17|66239404|T|2.3.1||||||\r"
				+ "EVN|A17|201002130003||||201002130003|G^4265^L\r"
				+ "PID|1||3678347^^^UHN^MR^G^4265^^^^^~9635915532^vp^^CANON^JHN^G^4265^^^20120517^^~||LEIGHTON^RACHEL^DIAMOND^^^^U||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6H 2T9^CAN^H||^PRN^PH^^1^416^7676333|^WPN^PH^^1^905^7436333^6001||||\r"
				+ "PV1||E|Emerg^EmergAcute^Interview^G^4265^^^N^EmergAcute^Interview^Emerg^185 2 16^|||Emerg^Gen Wait^GenWait13^G^4265^^^^Gen Wait^GenWait13^Emerg^185 6 13^|141378^Rauchwerger^David^^^Dr.^MD^^^L^^^EI^^^^^^^^^^^^^|||||||A|||141378^Rauchwerger^David^^^Dr.^MD^^^L^^^EI^^^^^^^^^^^^^|EP^|292007135^^^UHN^VN^G^4265^^^^^||||||||||||||||||||G|||||200905030022|||||||V|\r"
				+ "PID|2||0877410^^^UHN^MR^^^^^^^~3135063059^^^CANON^JHN^^^^^^^~||Lex^Tamara^Christina^^Miss^^L^^^^^200905030044^^~||19801120|F|||441 Margueretta St^^Toronto^ON^M6H2S6^Can^H^^^^^^^~|1811|(416)533-5113^PRN^PH^^^^^^^^^~|(416)532-0206^WPN^PH^^^^^^^^^|eng^ English^03ZPtlang^^^|S^Single^03ZMtSt^^^|PDI^ Patient did not indicate^03ZRelgn^^^|292007138^^^UHN^VN^^^^^^^~||||||||||||N|||200905030044||||||\r"
				+ "ZZ1|TESTVALUE";

		ADT_A17 msg = new ADT_A17();
		msg.setParser(parser);
		msg.parse(messageText);

		ourLog.debug(msg.encode());

		assertEquals("2", msg.getPID2().getPid1_SetIDPID().encode());

	}

	@Test
	public void testLotsOfExtraSegments() throws HL7Exception {

		String messageText = "MSH|^~\\&|ULTRA|TML|TML||200903120021||ADT^A17|66239404|T|2.3.1\r" + "EVN|A17|201002130003||||201002130003|G^4265^L\r" + "PID|1\r" + "ZZA|ZZAVALUE\r" + "ZZA|ZZAVALUE\r" + "ZZB|ZZBVALUE\r" + "ZZB|ZZBVALUE\r" + "PV1||E\r" + "PID|2\r"
				+ "ZZA|ZZAVALUE\r" + "ZZA|ZZAVALUE\r" + "ZZB|ZZBVALUE\r" + "ZZB|ZZBVALUE\r" + "ZZC|ZZCVALUE\r";

		ADT_A17 msg = new ADT_A17();
		msg.setParser(parser);
		msg.parse(messageText);

		ourLog.debug(msg.encode());

		assertEquals("2", msg.getPID2().getPid1_SetIDPID().encode());

		String encoded = msg.encode();
		assertEquals(messageText, encoded);

	}

	/**
	 * This message is invalid, it should fail.. Maybe?
	 * 
	 * Test disabled for now (it never passed, this is potential new validation)
	 */
	public void testInvalidMessageFails() throws HL7Exception {

		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "OBX|8|ST|Test\r\r\rString||20090505||||||F\r";

		ca.uhn.hl7v2.model.v231.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v231.message.ORU_R01();
		msg.setParser(new PipeParser());
		msg.parse(string);

		assertEquals(string, msg.encode());

	}

	/**
	 * See https://sourceforge.net/p/hl7api/bugs/153/
	 */
	@Test
	public void testHelpfulErrorMessageWithBadLineEndings() throws HL7Exception {

		String msh = "MSH|^~\\&|SUPER_LONG_MSH_SEGMENT_00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3";
		String obx = "OBX|8|ST|Test\r\r\rString||20090505||||||F";
		String string = msh + '\r' + obx;

		try {
			new GenericParser().parse(string);
			fail();
		} catch (EncodingNotSupportedException e) {
			assertTrue(e.getMessage(), e.getMessage().contains(msh));
			assertTrue(e.getMessage(), !e.getMessage().contains(obx));
		}

	}

	@Test
	public void testDTInObx2() throws HL7Exception {

		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|8|DT|GDT-00108^Device Implant Date^GDT-LATITUDE||20090505||||||F||\r";

		ca.uhn.hl7v2.model.v231.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v231.message.ORU_R01();
		msg.setParser(new PipeParser());
		msg.parse(string);

		ourLog.debug(msg.encode());

	}

	@Test
	public void testInvalidLengthInObx2() throws HL7Exception {

		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.4\r" + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|8|MED|GDT-00108^Device Implant Date^GDT-LATITUDE||20090505||||||F||\r";

		ca.uhn.hl7v2.model.v24.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v24.message.ORU_R01();
		msg.setParser(new PipeParser());

		System.setProperty(Varies.INVALID_OBX2_TYPE_PROP, "ST");
		msg.parse(string);

		ourLog.debug(msg.encode());

		System.clearProperty(Varies.INVALID_OBX2_TYPE_PROP);
		try {
			msg.parse(string);
			fail();
		} catch (HL7Exception e) {

		}

	}

	@Test
	public void testUnexpectedSegmentAtEng() throws EncodingNotSupportedException, HL7Exception {
		String messageText = "MSH|^~\\&|REG|G|||201002220026||ADT^A14|33186452|P|2.2|||||\r" + "EVN|A14|201002220026|||14380\r" + "PID||^^|222^454554^HN637|324334244^^|TEST^PATIENT^Luis^^Mr.^Mr.|\r"
				+ "PV1||E|^^^^^^^^|^||^^^^^^^^|^^^^^^^|^^^^^^^||^^|||||||^^^^^^^|^|3243^|^|||||||||||||||||||G||||^^^^^^^^|43865896||||||\r" + "PV2||||||||||||||||||^||||N\r"
				+ "NK1|1|TEST^NKGuy^^^^|CHD^ Son|123 Fake Street^^Toronto^ON^M6J 3H2^Can^M|(416)123-4567|(416)123-4567|NK||||||\r" + "IN1|1||0012343001|  OHIP||||||||||||^^^^^|||^^^^^^M|||||||||||||||||||||||||^^^^^^M\r" + "IN2||||||2216\r" + "ZIN||||||||||||||||||";

		Parser parser = PipeParser.getInstanceWithNoValidation();
		parser.parse(messageText);
	}

	/**
	 * In SIU_S12, Groups begin with RGS and have nested subgroups as well
	 */
	@Test
	public void testNestedRepeatingGroups() throws EncodingNotSupportedException, HL7Exception {

		String messageText = "MSH|^~\\&|ORSOS|G|PRECASE^SCHEDULING||20100406132803||SIU^S14| 38762|P|2.3\r"
				+ // -
				"SCH|ADS|569576||||G014080|||379|MIN^MINUTES|^^^20100407161000|51873^AL-RADI OO||||ADS||||ADS\r" + "PID||990119205^^^R1^MR|990119205|000533921J^^^R1^VN|TEST MP3^TEST MP3|||||||||||||000533921J\r"
				+ "PV1|1|U|||||51873^AL-RADI OO|51873^AL-RADI OO|||||||||||569576^R1 caseno\r" + "DG1|1|||||U\r" + "RGS|1|1|abc\r" + "AIS|1|1|G014080^BYPASS AXILLOFEMORAL|20100406161000|||255|000000\r" + "AIG|1|1|51873|STAFF|||||20100407164000\r"
				+ "AIL|1|1|OR 4^OR 4||||||40800|0\r" + "AIP|1|1|51873^ALRADI^OSMAN|^1\r" + "RGS|2|2|abc\r" + "AIS|2|2|G11455^BYPASS AORTOCORONARY USING RADIAL ARTERY|20100406161000|||15\r" + "AIG|2|2|33043|STAFF|||||20100407212500\r" + "AIL|2|2|OR 4^OR 4|||||||0\r"
				+ "AIP|2|2|33043^AUNE^KELLY|^1\r" + "RGS|3|3|abc\r" + "AIS|3|3|G014045^ANGIOPLASTY|20100406161000|||5\r" + "AIG|3|3|102694|STAFF|||||20100407214000\r" + "AIL|3|3|OR 4^OR 4|||||||0\r" + "AIP|3|3|102694^ANGELINI^MARK|^1\r" + "RGS|4|4|abc\r"
				+ "AIS|4|4|G11045^BYPASS AORTOCORONARY LITA|20100406161000|||60\r" + "AIG|4|4|T1240UHN|STAFF|||||20100407214500\r" + "AIL|4|4|OR 4^OR 4|||||||0\r" + "AIP|4|4|T1240UHN^ASTA^JOHN|^1\r";

		SIU_S12 parsed = (SIU_S12) parser.parse(messageText);
		assertEquals("1", parsed.getRESOURCES(0).getRGS().getSetIDRGS().getValue());
		assertEquals("2", parsed.getRESOURCES(1).getRGS().getSetIDRGS().getValue());
		assertEquals("3", parsed.getRESOURCES(2).getRGS().getSetIDRGS().getValue());
		assertEquals("4", parsed.getRESOURCES(3).getRGS().getSetIDRGS().getValue());

	}

	@Test
	public void testAL1Reps() throws IOException, EncodingNotSupportedException, HL7Exception {
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ca/uhn/hl7v2/parser/adt_a03.txt");
		byte[] bytes = new byte[10000];
		StringBuffer buffer = new StringBuffer();
		int count;
		while ((count = stream.read(bytes)) > 0) {
			buffer.append(new String(bytes), 0, count);
		}

		String er7Message = buffer.toString();
		er7Message = er7Message.replaceAll("(\\r|\\n)+", "\r");

		ca.uhn.hl7v2.model.v25.message.ADT_A03 message = (ADT_A03) parser.parse(er7Message);

		ourLog.debug("{}", message.getAL1Reps());
		ourLog.debug(parser.encode(message));
	}

	@Test
	public void testGetVersion() throws Exception {
		String message = "MSH|^~\\&|3|4|5|6|7|8|9|10|11|12|13|||\rMSA|foo\rERR|bar|||";
		assertEquals("12", parser.getVersion(message));
		message = "MSH|^~\\&|STML|001|STML|001|20020307142717||ADT^A08|01501|T|2.2|||AL|NE\rEVN|A08|20020307142652";
		assertEquals("2.2", parser.getVersion(message));
		message = "MSH|^~\\&|STML|001|STML|001|20020307142717||ADT^A08|01501|T|2.2^x^x|||AL|NE\rEVN|A08|20020307142652";
		assertEquals("2.2", parser.getVersion(message));
	}

	@Test
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
	@Test
	public void testCorrectSegmentOrderWithMultipleOptions() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
				"ORC|\r" + //
				"OBX|\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		String val = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION().getOBSERVATION(0).getNTE(0).getComment(0).getValue();

		ourLog.debug(parser.encode(msg));
		assertEquals("test", val);
	}

	@Test
	public void testNonStandardSegmentNearStart() throws EncodingNotSupportedException, HL7Exception {
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r";

		ca.uhn.hl7v2.model.v23.message.ORU_R01 message = (ca.uhn.hl7v2.model.v23.message.ORU_R01) parser.parse(string);

		String reEncoded = parser.encode(message);
		ourLog.debug(reEncoded);
		assertEquals(string, reEncoded);

		String pidMrn = message.getRESPONSE().getPATIENT().getPID().getPid3_PatientIDInternalID(0).getCx1_ID().getValue();
		assertEquals("7005728", pidMrn);
	}

	@Test
	public void testNonStandardSegmentNearEnd() throws EncodingNotSupportedException, HL7Exception {
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r" + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

		Message message = parser.parse(string);

		String reEncoded = parser.encode(message);
		ourLog.debug(reEncoded);
		assertEquals(string, reEncoded);

	}

	@Test
	public void testNonStandardSegmentAfterEnd() throws EncodingNotSupportedException, HL7Exception {
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r" + "DSC|1\r" + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

		Message message = parser.parse(string);

		String reEncoded = parser.encode(message);
		ourLog.debug(reEncoded);
		assertEquals(string, reEncoded);

	}

	/**
	 * Test repeating segment location
	 */
	@Test
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
	@Test
	public void testRepeatingGroupWithOptionalFirstSegment() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
				"ORC|\r" + //
				"CTI|\r" + //
				"OBR|\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);

		ourLog.debug(parser.encode(msg));

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
	@Test
	public void testParseIntoNewGroupIfMisorderedInCurrentGroup() throws Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
				"ORC|\r" + //
				"CTI|\r" + //
				"ORC|\r" + //
				"NTE|||test|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);

		ourLog.debug(parser.encode(msg));

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
	@Test
	public void testParseEmptySegment() throws EncodingNotSupportedException, HL7Exception {
		String message = "MSH|^~\\&|||||20080627102031.292+0100||ADT^A31^ADT_A31|EJ557600005480760|P|2.3|||||BE|8859/1|FR\r\n" + "EVN||20080627101943+0100\r\n" + "PID|||M07869D^^^ADMISSION^^ISSTLUC||DUPONT^JEAN||19701004000000+0100|M\r\n" + "PD1\r\n" + "PV1||N";
		parser.parse(message);
	}

	/**
	 * If there is a potential location for a segment in a certain group, but
	 * the entire group is out of order, the segment should not be placed there
	 * (in a current or subsequent repetition).
	 */
	@Test
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

	@Test
	public void testComponents() throws Exception {
		// test normal component, subcomponent
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\rPID|||||x&y^z|\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		PID pid = msg.getPATIENT_RESULT().getPATIENT().getPID();
		assertEquals("x", pid.getPatientName(0).getFamilyName().getSurname().getValue());
		assertEquals("y", pid.getPatientName(0).getFamilyName().getOwnSurnamePrefix().getValue());
		assertEquals("z", pid.getPatientName(0).getGivenName().getValue());
	}

	@Test
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

	@Test
	public void testExtraFieldReps() throws Exception {
		String message = "MSH|^~\\&|one~two~three||||||ORU^R01|1|D|2.4\r";
		ORU_R01 msg = (ORU_R01) parser.parse(message);
		assertEquals("three", ((HD) msg.getMSH().getField(3, 2)).getNamespaceID().getValue());
	}

	@Test
	public void testEscape() throws Exception {
		ACK ack = new ACK();
		ack.getMSH().getFieldSeparator().setValue("|");
		ack.getMSH().getEncodingCharacters().setValue("^~\\&");
		ack.getMSA().getAcknowledgementCode().setValue("|");
		String expected = "MSH|^~\\&\rMSA|\\F\\\r";
		String actual = parser.encode(ack);
		assertEquals(expected, actual);
	}

	@Test
	public void testUnescape() throws Exception {
		String text = "MSH|^~\\&|\\F\\||||||ORU^R01|1|D|2.4\r";
		Message message = parser.parse(text);
		Terser t = new Terser(message);
		assertEquals("|", t.get("MSH-3"));
	}

	@Test
	public void testEarlyNonStandard() throws EncodingNotSupportedException, HL7Exception {
		String message = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ADT^A03|263206|P|2.5\r\n" + "EVN||200803051509||||200803031508\r\n" + "ZZZ|aaa\r\n"
				+ "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r\n"
				+ "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r\n"
				+ "PR1|1||1111^Mastoplastica|Protesi|20090224|02|";

		parser.parse(message);
		// This caused a hang at one point in development

	}

	@SuppressWarnings("serial")
	@Test
	public void testValidation() throws Exception {
		HapiContext hc = new DefaultHapiContext();
		hc.setValidationRuleBuilder(new ValidationRuleBuilder() {

			@Override
			protected void configure() {
				forAllVersions().encoding("*").test(new FooEncodingRule()).message("*", "*").test(new BarMessageRule()).primitive("NM").is(maxLength(5));
			}

		});
		Parser parser = hc.getPipeParser();

		String text = "MSH|^~\\&|bar|foo|||||ORU^R01|1|D|2.4|12345\r";
		parser.parse(text);

		try {
			text = "MSH|^~\\&|ba|foo|||||ORU^R01|1|D|2.4|12345\r";
			parser.parse(text);
			fail("Should have failed message rule");
		} catch (HL7Exception e) {
		}

		try {
			text = "MSH|^~\\&|bar|fo|||||ORU^R01|1|D|2.4|12345\r";
			parser.parse(text);
			fail("Should have failed encoding rule");
		} catch (HL7Exception e) {
		}

		try {
			text = "MSH|^~\\&|ba|foo|||||ORU^R01|1|D|2.4|123456\r";
			parser.parse(text);
			fail("Should have failed datatype rule on field 13");
		} catch (HL7Exception e) {
		}
	}

	/**
	 * If a non-repeating segment is found to be repeating, the extra should be
	 * added as a non standard segment.
	 */
	@Test
	public void testDuplicateSegment() throws HL7Exception {
		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ADT^A01|1|D|2.4\r" + //
				"EVN|R01\r" + //
				"EVN|R02\r" + //
				"PID|1\r" + //
				"IN1|1\r" + //
				"IN1|2\r" + //
				"PID|2\r";

		ADT_A01 parsed = (ADT_A01) parser.parse(message);
		ourLog.debug(parser.encode(parsed));
		ourLog.debug("\r\n" + parsed.toString());

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
	@Test
	public void testInvalidSegmentName() throws EncodingNotSupportedException, HL7Exception {

		String msg = "MSH|^~\\&||Big Laboratory^33D0123456^CLIA|GEN2|NYSDOH|20060802101649||ORU^R01|200608021016491003|D|2.3\r\n" + "I|||13198751^^^^^Big Laboratory&33D0123456&CLIA||DREST^NATALIE^||19500101|F|||123 MAIN ST^^SPRINGFIELD^NY^12345||^^^^^518^1234567\r\n"
				+ "OBR|1||13198751|^^^207252^CULTURE,SALMONELLA/SHIG^L|||200607280943|||||||20060729101650|STOOL-STOOL&STOOL-STOOL|^HERTZ, JOHN Q|^^^^^518^5551212||||||||F\r\n"
				+ "ZLR|456 WASHINGTON BLVD^SUITE 100^ALBANY^NY^12345|HERTZ^JOHN^Q^^^MD|456 WASHINGTON BLVD^SUITE 100^ALBANY^NY^12345|^^^^^518^4567890\r\n"
				+ "OBX|1|CE|^^^60101058^CULTURE,SALMONELLA/SHIGELLA,STOOL^L|1|^^^SASP^Salmonella sp., not typhi^L||||||F|||200608011318|33D0123456^Big Laboratory^CLIA";
		parser.parse(msg);

	}

	@Test
	public void testNonPipeDelimitor() throws EncodingNotSupportedException, HL7Exception {
		String msg = "MSH^~|\\&^HDRVTLS^552~DAYTDEV.FO-BAYPINES.MED.VA.GOV~DNS^GMRV VDEF IESIDE^200HD~HDR.MED.VA.GOV~DNS^20061006151615-0800^^ORU~R01^55253408603^T^2.4^^^AL^NE^US\r\n"
				+ "ORC^RE^^6240020~552_120.5^^^^^^^^^^OBS23~325~~~~~~~23 HOUR OBSERVATION^^^^552~DAYTON~L^^^^DAYTON\r\n"
				+ "OBR^^^6240020~552_120.5^4500635~PAIN~99VA120.51^^^200610061445-0800^20061006144607-0800^^^^^^^^^^^^^^20061006144607-0800^^^E^^^^^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n"
				+ "OBX^^ST^4500635~PAIN~99VA120.51^^3^~~L^^^^^W^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n" + "OBX^^CE^Error Reasons^^4500627~INCORRECT READING~99VA8985.1^^^^^^W^^^^^123456&NURSE&THREE&A&III&MS&RN&VistA200\r\n" + "ZSC^^291^OBSERVATION SURGERY";

		parser.parse(msg);

	}

	@Test
	public void testUnknownVersion() throws EncodingNotSupportedException, HL7Exception {

		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.999\r" + //
				"ORC|ORC1\r" + //
				"OBX|1\r" + //
				"NTE|||NTE1|\r" + //
				"ZNT|ZNT1\r" + //
				"ORC|ORC2";

		try {
			ORU_R01 parsed = (ORU_R01) parser.parse(message);
			fail(parser.encode(parsed));
		} catch (HL7Exception e) {
			assertEquals(ErrorCode.UNSUPPORTED_VERSION_ID, e.getError());
		}

	}

	@Test
	public void testParseNonStandardSegment() throws EncodingNotSupportedException, HL7Exception {

		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ORU^R01|1|D|2.4\r" + //
				"ORC|ORC1\r" + //
				"OBX|1\r" + //
				"NTE|||NTE1|\r" + //
				"ZNT|ZNT1\r" + //
				"ORC|ORC2";

		ORU_R01 parsed = (ORU_R01) parser.parse(message);
		ourLog.debug(parser.encode(parsed));

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
		ourLog.debug(parser.encode(parsed));

		assertEquals("ORC1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getORC().getOrderControl().getValue());
		assertEquals("1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getOBX().getSetIDOBX().getValue());
		assertEquals("NTE1", parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).getNTE(0).getComment(0).getValue());
		znt = (Segment) parsed.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION(0).get("ZNT");
		assertNotNull(znt);
		assertEquals("ZNT1", ((Primitive) ((Varies) znt.getField(1, 0)).getData()).getValue());

	}

	@Test
	public void testEmptySegment() throws EncodingNotSupportedException, HL7Exception {
		String msg = "MSH|^~\\&|1444-ADT|1444|S-ADT|SIMS|20071023160622||ADT^A03^ADT_A05|Q67084255T54052896X2|P^T|2.5|||NE|AL|CAN|8859/1\r\n" + "EVN|A03|20071023160622\r\n"
				+ "PID|1||00J8804997^^^1444^MR~165640^^^CANON^JHN^^^^^WT||Aalan^Angus^^^^^L||19620404|F|||101 Ames Ave^^Toronto^CA- ON^M2N7J6^CAN^H||^PRN^PH^^1^416^5551545|^PRN^PH^^1^416^2227788|| C||||||||||||||N\r\n" + "PV1";
		parser.parse(msg);
	}

	@SuppressWarnings("serial")
	private static class FooEncodingRule extends AbstractEncodingRule {
		/**
		 * @see ca.uhn.hl7v2.validation.EncodingRule#test(java.lang.String)
		 */
		public ValidationException[] apply(String arg0) {
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

	@SuppressWarnings("serial")
	private static class BarMessageRule extends AbstractMessageRule {

		/**
		 * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.Message)
		 */
		public ValidationException[] apply(Message arg0) {
			Terser t = new Terser(arg0);
			String msh3;
			try {
				msh3 = t.get("/MSH-3");
			} catch (HL7Exception e) {
				return failed("Bad bar");
			}
			if (!msh3.equals("bar")) {
				return failed("Not enough bar");
			} else {
				return passed();
			}
		}

	}

	/**
	 * Make sure IS and ID datatypes are supported as OBX-5 values
	 */
	@Test
	public void testParseObx5WithTypeRequiringTable() throws EncodingNotSupportedException, HL7Exception {

		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" // -
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" // -
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" // -
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r" // -
				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r";

		parser.parse(string);

	}

	@Test
	public void testMissingSegment() throws EncodingNotSupportedException, HL7Exception {

		String messageString = "MSH|^~\\&|BLAH|Default Facility|||20100604104559||REF^I12^REF_I12|||2.5\r\n" // -
				+ "SFT|BLAH|BLAH|BLAH|2010/06/04 10:44, branch : trunk\r\n" // -
				+ "RF1||||||15|20100601000000\r\n" // -
				+ "PRD|RP^Referring Provider|foo^doctor^^^DR|^^^^^^O||||999998\r\n" // -
				+ "PRD|RT^Referred to Provider|moto^moto^^^r6|^^^^^^O||^^^^^^^^^^^411||8\r\n" + "PID|1||^^^^^^20100525^21000101^ON||aaa^aaa^^^^^L||19000101|M|||^^^ON^^^H\r\n" // -
				+ "NTE|||asfd notes|^APPOINTMENT_NOTES\r\n" // -
				+ "NTE|||engine oil problem, and maybe needs new plugs|^REASON_FOR_CONSULTATION\r\n" // -
				+ "NTE|||86k km|^CLINICAL_INFORMATION\r\n" // -
				+ "NTE|||goes too slow|^CONCURRENT_PROBLEMS\r\n" + "NTE|||91 octane|^CURRENT_MEDICATIONS\r\n" // -
				+ "NTE|||scooters|^ALLERGIES";

		REF_I12 message = (REF_I12) parser.parse(messageString);

		ourLog.debug("Structure is: " + message.printStructure());

		ourLog.debug("Going to parse/encode");
		message.parse(message.encode());

		ourLog.debug("Structure is: " + message.printStructure());

	}

	@Test
	public void testEncodeHintSegmentAtStartOfMessage() throws HL7Exception, IOException {

		ca.uhn.hl7v2.model.v25.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		msg.getMSH().getMessageControlID().setValue("");
		TS ts = msg.getMSH().getDateTimeOfMessage();
		ts.parse("");

		msg.getPV1().parse("PV1|1");

		String actual = msg.encode();
		ourLog.debug("Message is: " + actual);

		String expected = "MSH|^~\\&|||||||ADT^A01^ADT_A01||T|2.5\r" + // -
				"PV1|1\r";
		assertEquals(expected, actual);

		msg.getPID().parse("PID|1");

		actual = msg.encode();
		ourLog.debug("Message is: " + actual);

		expected = "MSH|^~\\&|||||||ADT^A01^ADT_A01||T|2.5\r" + // -
				"PID|1\r" + // -
				"PV1|1\r";
		assertEquals(expected, actual);

		msg.getPID().parse("");

		actual = msg.encode();
		ourLog.debug("Message is: " + actual);

		expected = "MSH|^~\\&|||||||ADT^A01^ADT_A01||T|2.5\r" + // -
				"PV1|1\r";
		assertEquals(expected, actual);

	}

	/**
	 * Order observation group:
	 * <ul>
	 * <li>1: ORC (Common Order) <b>optional </b></li>
	 * <li>2: OBR (Observation Request) <b> </b></li>
	 * <li>3: NTE (Notes and Comments) <b>optional repeating</b></li>
	 * <li>4: ORU_R01_TIMING_QTY (a Group object) <b>optional repeating</b></li>
	 * <li>5: CTD (Contact Data) <b>optional </b></li>
	 * <li>6: ORU_R01_OBSERVATION (a Group object) <b>optional repeating</b></li>
	 * <li>7: FT1 (Financial Transaction) <b>optional repeating</b></li>
	 * <li>8: CTI (Clinical Trial Identification) <b>optional repeating</b></li>
	 * <li>9: ORU_R01_SPECIMEN (a Group object) <b>optional repeating</b></li>
	 * </ul>
	 * 
	 * @throws HL7Exception
	 * @throws IOException
	 */
	@Test
	public void testEncodeHintSegmentAtStartOfGroup() throws HL7Exception, IOException {

		ca.uhn.hl7v2.model.v25.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v25.message.ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		msg.getMSH().getMessageControlID().setValue("");
		msg.getMSH().getDateTimeOfMessage().parse("");

		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getORC().parse("ORC|1");
		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBR().parse("OBR|1");
		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getCTD().parse("CTD|1");

		String actual = msg.encode();
		ourLog.debug("Message is: " + actual);

		String expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.5\r" + // -
				"ORC|1\r" + // -
				"OBR|1\r" + // -
				"CTD|1\r";

		assertEquals(expected, actual);

		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getORC().parse("");

		actual = msg.encode();
		ourLog.debug("Message is: " + actual);

		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.5\r" + // -
				"OBR|1\r" + // -
				"CTD|1\r";

		assertEquals(expected, actual);

		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBR().parse("");

		actual = msg.encode();
		ourLog.debug("Message is: " + actual);

		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.5\r" + // -
				"OBR|\r" + // -
				"CTD|1\r";

		assertEquals(expected, actual);

	}

	@Test
	public void testDontEncodeHintSegmentForEmptyGroup() throws HL7Exception, IOException {

		MessageWithGroupWithRequiredFinalSegment msg = new MessageWithGroupWithRequiredFinalSegment();
		msg.initQuickstart("AAA", "A01", "P");
		msg.getMSH().getMessageControlID().setValue("");
		msg.getMSH().getDateTimeOfMessage().parse("");

		String expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		String actual = msg.encode();
		assertEquals(expected, actual);

		msg.getMyGroup();

		expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		actual = msg.encode();
		assertEquals(expected, actual);

		msg.getMyGroup().getOBX();

		expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		actual = msg.encode();
		assertEquals(expected, actual);

		msg.getMyGroup().getNTE();

		expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		actual = msg.encode();
		assertEquals(expected, actual);
	}

	@Test
	public void testEncodeHintSegmentForMandatorySegmentBeforeGroup() throws HL7Exception, IOException {

		MessageWithMandatorySegmentBeforeSubgroup msg = new MessageWithMandatorySegmentBeforeSubgroup();
		msg.initQuickstart("AAA", "A01", "P");
		msg.getMSH().getMessageControlID().setValue("");
		msg.getMSH().getDateTimeOfMessage().parse("");

		String expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		String actual = msg.encode();
		assertEquals(expected, actual);

		msg.getMyGroup();

		expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		actual = msg.encode();
		assertEquals(expected, actual);

		msg.getMyGroup().getMySubGroup().getOBX().parse("OBX|1");

		expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r" // -
				+ "EVN|\r" // -
				+ "OBX|1\r";
		actual = msg.encode();
		assertEquals(expected, actual);

	}

	@Test
	public void testEncodeHintSegmentForMandatorySegmentAfterGroup() throws HL7Exception, IOException {

		MessageWithMandatorySegmentAfterSubgroup msg = new MessageWithMandatorySegmentAfterSubgroup();
		msg.initQuickstart("AAA", "A01", "P");
		msg.getMSH().getMessageControlID().setValue("");
		msg.getMSH().getDateTimeOfMessage().parse("");

		// String expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		// String actual = msg.encode();
		// assertEquals(expected, actual);
		//
		// msg.getMyGroup();
		//
		// expected = "MSH|^~\\&|||||||AAA^A01||P|2.5\r";
		// actual = msg.encode();
		// assertEquals(expected, actual);

		msg.getMyGroup().getMySubGroup().getOBX().parse("OBX|1");

		String expected2 = "MSH|^~\\&|||||||AAA^A01||P|2.5\r" // -
				+ "OBX|1\r";
		String actual2 = msg.encode();
		assertEquals(expected2, actual2);

	}

	@Test
	public void testEncodeWithForceEncoding() throws HL7Exception, IOException {

		PipeParser pOn = PipeParser.getInstanceWithNoValidation();
		pOn.getParserConfiguration().addForcedEncode("PATIENT_RESULT/ORDER_OBSERVATION/ORC");

		PipeParser pOnOrc4 = PipeParser.getInstanceWithNoValidation();
		pOnOrc4.getParserConfiguration().addForcedEncode("PATIENT_RESULT/ORDER_OBSERVATION/ORC-4");

		PipeParser pOnOrc44 = PipeParser.getInstanceWithNoValidation();
		pOnOrc44.getParserConfiguration().addForcedEncode("PATIENT_RESULT/ORDER_OBSERVATION/ORC-44");

		PipeParser pOnOrc44_11 = PipeParser.getInstanceWithNoValidation();
		pOnOrc44_11.getParserConfiguration().addForcedEncode("PATIENT_RESULT/ORDER_OBSERVATION/ORC-44-11");

		PipeParser pOnOrc4_2 = PipeParser.getInstanceWithNoValidation();
		pOnOrc4_2.getParserConfiguration().addForcedEncode("PATIENT_RESULT/ORDER_OBSERVATION/ORC-4-2");

		PipeParser pOff = PipeParser.getInstanceWithNoValidation();

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		msg.getMSH().getMessageControlID().setValue("");
		msg.getMSH().getDateTimeOfMessage().parse("");

		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getORC();

		String encoded = pOnOrc44_11.encode(msg);
		String expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r" + //
				"ORC||||||||||||||||||||||||||||||||||||||||||||^^^^^^^^^^\r";
		ourLog.debug("EXP: " + expected);
		ourLog.debug("ACT: " + encoded);
		assertEquals(expected, encoded);

		encoded = pOff.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r";
		assertEquals(expected, encoded);

		encoded = pOn.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r" + //
				"ORC|\r";
		assertEquals(expected, encoded);

		encoded = pOnOrc4.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r" + //
				"ORC||||\r";
		assertEquals(expected, encoded);

		encoded = pOnOrc4_2.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r" + //
				"ORC||||^\r";
		assertEquals(expected, encoded);

		encoded = pOnOrc44.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r" + //
				"ORC||||||||||||||||||||||||||||||||||||||||||||\r";
		assertEquals(expected, encoded);

	}

	@Test
	public void testEncodeWithForceEncodingOnMSH() throws HL7Exception, IOException {

		PipeParser pOn = PipeParser.getInstanceWithNoValidation();
		pOn.getParserConfiguration().addForcedEncode("MSH");

		PipeParser pOnMSH19 = PipeParser.getInstanceWithNoValidation();
		pOnMSH19.getParserConfiguration().addForcedEncode("MSH-19");

		PipeParser pOnMSH19_2 = PipeParser.getInstanceWithNoValidation();
		pOnMSH19_2.getParserConfiguration().addForcedEncode("MSH-19-2");

		PipeParser pOff = PipeParser.getInstanceWithNoValidation();

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		msg.getMSH().getMessageControlID().setValue("");
		msg.getMSH().getDateTimeOfMessage().parse("");

		String encoded = pOff.encode(msg);
		String expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r";
		assertEquals(expected, encoded);

		encoded = pOn.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4\r";
		assertEquals(expected, encoded);

		encoded = pOnMSH19.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4|||||||\r";
		assertEquals(expected, encoded);

		encoded = pOnMSH19_2.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4|||||||^\r";
		ourLog.debug(encoded.replace("\r", "\r\n"));
		assertEquals(expected, encoded);

		PipeParser pOnMSH999 = PipeParser.getInstanceWithNoValidation();
		pOnMSH999.getParserConfiguration().addForcedEncode("MSH-99");
		encoded = pOnMSH999.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4" + StringUtils.leftPad("", 99 - 12, '|') + "\r";
		ourLog.debug(encoded.replace("\r", "\r\n"));
		assertEquals(expected, encoded);

		pOnMSH999 = PipeParser.getInstanceWithNoValidation();
		pOnMSH999.getParserConfiguration().addForcedEncode("MSH-999");
		encoded = pOnMSH999.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01||T|2.4" + StringUtils.leftPad("", 999 - 12, '|') + "\r";
		ourLog.debug(encoded.replace("\r", "\r\n"));
		assertEquals(expected, encoded);

		PipeParser pOnMSH9_99 = PipeParser.getInstanceWithNoValidation();
		pOnMSH9_99.getParserConfiguration().addForcedEncode("MSH-9-9");
		encoded = pOnMSH9_99.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01^^^^^^||T|2.4\r";
		ourLog.debug(encoded.replace("\r", "\r\n"));
		assertEquals(expected, encoded);

		pOnMSH9_99 = PipeParser.getInstanceWithNoValidation();
		pOnMSH9_99.getParserConfiguration().addForcedEncode("MSH-9-99");
		encoded = pOnMSH9_99.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01^^^^^^" + StringUtils.leftPad("", 90, '^') + "||T|2.4\r";
		assertEquals(expected, encoded);

		pOnMSH9_99 = PipeParser.getInstanceWithNoValidation();
		pOnMSH9_99.getParserConfiguration().addForcedEncode("MSH-9-999");
		encoded = pOnMSH9_99.encode(msg);
		expected = "MSH|^~\\&|||||||ORU^R01^ORU_R01^^^^^^" + StringUtils.leftPad("", 990, '^') + "||T|2.4\r";
		assertEquals(expected, encoded);

	}

	@Test
	public void testUnescapeComponents() throws HL7Exception {

		String message = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3\r\n" + "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT\r\n"
				+ "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO^^^^||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N\r\n"
				+ "NK1|1|PEACH^PRINCESS^^^^|SO|ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-1234|(123)555-2345|NOK|||||||||||||\r\n" + "NK1|2|TOADSTOOL^PRINCESS^^^^|SO|YET ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-3456|(123)555-4567|EMC|||||||||||||\r\n"
				+ "PV1|1|O|ABCD^EFGH^|||^^|123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|^DOG^DUCKHUNT^^^^^^^CURRENT||CRD|||||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR^|AO|0123456789|1|||||||||||||||||||MSH||A|||20010101000000";
		ca.uhn.hl7v2.model.v23.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
		msg.parse(message);

		ST st = msg.getPID().getPid11_PatientAddress(0).getXad2_OtherDesignation();
		String actual = st.getValue();
		String expected = "MARIO & LUIGI BROS PLACE";
		assertEquals(expected, actual);

		st.setValue(actual);
		actual = st.getValue();
		expected = "MARIO & LUIGI BROS PLACE";
		assertEquals(expected, actual);

		actual = st.encode();
		expected = "MARIO \\T\\ LUIGI BROS PLACE";
		assertEquals(expected, actual);

		st.parse(actual);
		actual = st.getValue();
		expected = "MARIO & LUIGI BROS PLACE";
		assertEquals(expected, actual);

		expected = "123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234";
		actual = msg.getPID().getPid11_PatientAddress(0).encode();
		assertEquals(expected, actual);

	}

	@Test
	public void testParsePrimitiveWithUnexpectedSubcomponents() throws HL7Exception, IOException {

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "P");

		ca.uhn.hl7v2.model.v24.datatype.ST controlID = msg.getMSH().getMessageControlID();
		controlID.parse("A^1");
		assertEquals("A", msg.getMSH().getMessageControlID().getValue());
		assertEquals("1", msg.getMSH().getMessageControlID().getExtraComponents().getComponent(0).encode());

		msg.getMSH().getPrincipalLanguageOfMessage().getAlternateText().parse("A&1");
		assertEquals("A", msg.getMSH().getPrincipalLanguageOfMessage().getAlternateText().getValue());
		assertEquals("1", msg.getMSH().getPrincipalLanguageOfMessage().getAlternateText().getExtraComponents().getComponent(0).encode());

	}

	@Test
	public void testParseTwice() throws HL7Exception {

		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" // -
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" // -
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" // -
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r" // -
				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r";

		ORU_R01 initialMessage = new ORU_R01();
		initialMessage.parse(string);

		GenericSegment zpi = (GenericSegment) initialMessage.get("ZPI");
		assertEquals("7005728^^^TML^MR", zpi.getField(3, 0).encode());

		string = string.replace("ZPI|||7005728", "ZPI|||7005729");
		initialMessage.parse(string);

		ourLog.debug(initialMessage.printStructure());

		// Make sure the same generic segment name is reused
		zpi = (GenericSegment) initialMessage.get("ZPI");
		assertEquals("7005729^^^TML^MR", zpi.getField(3, 0).encode());

	}

}
