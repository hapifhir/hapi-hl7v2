package ca.uhn.hl7v2.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v24.datatype.CE;
import ca.uhn.hl7v2.model.v26.datatype.AD;
import ca.uhn.hl7v2.model.v26.datatype.CD;
import ca.uhn.hl7v2.model.v26.datatype.ST;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.OBX;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * A JUnit test harness for Varies
 * 
 * @author Bryan Tripp
 */
public class VariesTest {

	public static final String MSH_TEXT = "MSH|^~\\&|QVDX|WP|CCG-PDC-Workflow|CCG-PDC-Workflow|19990927110328||ORU^R01|19990927110328|P|2.4\r";
	private static final Logger ourLog = LoggerFactory.getLogger(VariesTest.class);
	private static EncodingCharacters encoders;
	private static Message mshOnly;

	@BeforeClass
	public static void setup() throws EncodingNotSupportedException, HL7Exception {
		mshOnly = new PipeParser().parse(MSH_TEXT);
		mshOnly.setParser(new GenericParser());
		encoders = EncodingCharacters.getInstance(mshOnly);
	}

	/**
	 * AD = ST, ST,...
	 */
	@Test
	public void testObx5WithExpectedComponentExpectedComponent() throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||AD|||F1C1^F2C1\r";

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

		Varies observationValue = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION()
				.getOBX().getObx5_ObservationValue(0);
		AD obx5 = (AD) observationValue.getData();
		assertEquals("F1C1", obx5.getAd1_StreetAddress().getValue());
		assertEquals("F2C1", obx5.getAd2_OtherDesignation().getValue());

		assertEquals(msgString.trim(), encode.trim());

	}

	/**
	 * CD = WVI, WVS,...<br/>
	 * WVI = NM, ST
	 */
	@Test
	public void testObx5WithExpectedComponentExpectedSubcomponent() throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||CD|||F1C1&F1C2\r";

		ORU_R01 msg = new ORU_R01();
		msg.setParser(new PipeParser(
				new DefaultHapiContext(ValidationContextFactory.noValidation())));
		msg.parse(msgString);

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

		Varies observationValue = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION()
				.getOBX().getObx5_ObservationValue(0);
		CD obx5 = (CD) observationValue.getData();
		assertEquals("F1C1", obx5.getCd1_ChannelIdentifier().getWvi1_ChannelNumber().getValue());
		assertEquals("F1C2", obx5.getCd1_ChannelIdentifier().getWvi2_ChannelName().getValue());

		assertEquals(msgString.trim(), encode.trim());

	}

	/**
	 * AD = ST, ST,...
	 */
	@Test
	public void testObx5WithExpectedComponentUnpexpectedSubcomponentExpectedComponent()
			throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||AD|||F1C1&F1C2^F2C1\r";

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

		Varies observationValue = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION()
				.getOBX().getObx5_ObservationValue(0);
		AD obx5 = (AD) observationValue.getData();
		assertEquals("F1C1", obx5.getAd1_StreetAddress().getValue());
		assertEquals("F1C2", obx5.getAd1_StreetAddress().getExtraComponents().getComponent(0)
				.encode());
		assertEquals("F2C1", obx5.getAd2_OtherDesignation().getValue());

		assertEquals(msgString.trim(), encode.trim());

	}

	/**
	 * AD = ST, ST,...
	 */
	@Test
	public void testObx5WithExpectedComponentUnpexpectedSubcomponentWithinPrimitive()
			throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||ST|||F1C1&F1C2\r";

		System.setProperty(Varies.ESCAPE_SUBCOMPONENT_DELIM_IN_PRIMITIVE, "TRUE");

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

		Varies observationValue = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION()
				.getOBX().getObx5_ObservationValue(0);
		ST obx5 = (ST) observationValue.getData();
		assertEquals("F1C1&F1C2", obx5.getValue());

		String expected = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||ST|||F1C1\\T\\F1C2\r";

		assertEquals(expected.trim(), encode.trim());

	}

	/**
	 * AD = ST, ST,...
	 */
	@Test
	public void testObx5WithExpectedComponentUnpexpectedSubcomponentWithinPrimitiveWithoutEscaping()
			throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||ST|||F1C1&F1C2\r";

		System.setProperty(Varies.ESCAPE_SUBCOMPONENT_DELIM_IN_PRIMITIVE, "FALSE");

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

		Varies observationValue = msg.getPATIENT_RESULT(0).getORDER_OBSERVATION(0).getOBSERVATION()
				.getOBX().getObx5_ObservationValue(0);
		ST obx5 = (ST) observationValue.getData();
		String actual = obx5.getValue();
		assertEquals("F1C1", actual);

		actual = obx5.encode();
		ourLog.debug("Actual: " + actual);
		assertEquals("F1C1^F1C2", actual);

		String expected = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||ST|||F1C1^F1C2\r";

		String trim = encode.trim();
		ourLog.debug("Encoded: " + trim.replace("\r", "\n"));

		assertEquals(expected.trim(), trim);

	}

	@Test
	public void testParse() throws HL7Exception {
		Varies varies = new Varies(null);
		CE data = new CE(null);
		data.getIdentifier().setValue("foo");
		varies.setData(data);

		// existing primitive will NOT copy over "foo" as of Nov 2002
		assertEquals("foo", ((CE) varies.getData()).getIdentifier().getValue());
		data.getIdentifier().setValue("foo");
		assertEquals("foo", ((CE) varies.getData()).getIdentifier().getValue());
	}

	@Test
	public void testParser_VariesCompositeSecondField() throws HL7Exception {
		final Varies variesField = new Varies(mshOnly);
		final Parser parser = mshOnly.getParser();
		final String hl7Text = "^A3456&2Rozwick&don&FURTHER&JR&MR&DR^200701010933^200702031022";
		parser.parse(variesField, hl7Text, encoders);
		final Composite data = (Composite) variesField.getData();
		assertEquals(4, data.getComponents().length);

		final Varies component = (Varies) data.getComponent(1);
		assertEquals(GenericComposite.class, component.getData().getClass());
		assertEquals(7, ((Composite) component.getData()).getComponents().length);
		assertEquals(hl7Text, PipeParser.encode(variesField, encoders));
	}

	@Test
	public void testParserParse_VariesCompositeFirstComponent() throws HL7Exception {

		final Varies variesField = new Varies(mshOnly);
		final Parser parser = mshOnly.getParser();
		final String hl7Text = "A3456&2Rozwick&don&FURTHER&JR&MR&DR^200701010933^200702031022";
		parser.parse(variesField, hl7Text, encoders);
		final Composite data = (Composite) variesField.getData();
		assertEquals(3, data.getComponents().length);

		final Varies component = (Varies) data.getComponent(0);
		assertEquals(GenericComposite.class, component.getData().getClass());
		assertEquals(7, ((Composite) component.getData()).getComponents().length);
		assertEquals(hl7Text, PipeParser.encode(variesField, encoders));
	}

	@Test
	public void testTerserGetPrimitive_VariesCompositeFirstComponent() throws HL7Exception {
		final Varies variesField = new Varies(mshOnly);
		final Primitive comp1Sub1 = Terser.getPrimitive(variesField, 1, 1);
		comp1Sub1.setValue("comp1Sub1");
		final Primitive comp1Sub2 = Terser.getPrimitive(variesField, 1, 2);
		comp1Sub2.setValue("comp1Sub2");
		final Primitive comp2Sub1 = Terser.getPrimitive(variesField, 2, 1);
		comp2Sub1.setValue("comp2Sub1");

		assertEquals(GenericComposite.class, variesField.getData().getClass());

		final GenericComposite field = (GenericComposite) variesField.getData();
		final Type typeComp1 = field.getComponent(0);
		assertEquals(typeComp1.getClass(), Varies.class);

		final Varies variesComp1 = (Varies) typeComp1;
		assertEquals(GenericComposite.class, variesComp1.getData().getClass());

		final GenericComposite comp1 = (GenericComposite) variesComp1.getData();
		final Type typeSub1 = comp1.getComponent(1);
		assertEquals(typeSub1.getClass(), Varies.class);

		final Varies variesSub1 = (Varies) typeSub1;
		assertEquals(GenericPrimitive.class, variesSub1.getData().getClass());

		assertEquals("comp1Sub1&comp1Sub2^comp2Sub1", PipeParser.encode(variesField, encoders));
	}

	@Test
	public void testTerserGetPrimitive_VariesCompositeSecondComponent() throws HL7Exception {
		final Varies variesField = new Varies(mshOnly);
		final Primitive comp1Sub1 = Terser.getPrimitive(variesField, 1, 1);
		comp1Sub1.setValue("comp1Sub1");
		final Primitive comp2Sub1 = Terser.getPrimitive(variesField, 2, 1);
		comp2Sub1.setValue("comp2Sub1");
		final Primitive comp2Sub2 = Terser.getPrimitive(variesField, 2, 2);
		comp2Sub2.setValue("comp2Sub2");

		assertEquals(GenericComposite.class, variesField.getData().getClass());

		final GenericComposite field = (GenericComposite) variesField.getData();
		final Type typeComp1 = field.getComponent(0);
		assertEquals(typeComp1.getClass(), Varies.class);

		final Varies variesComp1 = (Varies) typeComp1;
		assertEquals(GenericPrimitive.class, variesComp1.getData().getClass());

		assertEquals("comp1Sub1^comp2Sub1&comp2Sub2", PipeParser.encode(variesField, encoders));
	}

	/**
	 * This is from a reported message that was kind of malformed to begin with, but became more
	 * malformed in processing.
	 * 
	 * Parse method should clear all existing data including extra components.
	 */
	@Test
	public void testVariesParseMethodClearsExistingExtraComponents() throws HL7Exception {

		// Message is stripped down
		String msgString = "MSH|^~\\&\r" // -
				+ "OBR|\r" // -
				+ "OBX||FN|||OF1C1^OF2C1&OF2C2\r";

		ORU_R01 msg = new ORU_R01();
		msg.parse(msgString);

		OBX obx = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX();
		Varies varies = obx.getObx5_ObservationValue(0);
		varies.parse("NF1^NF2");

		String encode = msg.encode();
		ourLog.debug("\n\n" + encode);

		assertEquals("NF1^NF2", varies.encode());

	}

	/**
	 * Checking a problem that was reported by email
	 */
	@Test
	public void testMultipleValuesInObx5() throws HL7Exception, IOException {

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");

		String input = "OBX|10|FT|2239^Opm."
				+ "fundus^L^OPFU^FUFOFA||TEKST\\\\E\\\\.br\\\\E\\\\Unclear; niet te"
				+ "beoordelen.&line 2&line 3|\\\"\\\"|\\\"\\\"|\\\"\\\"|||F";
		OBX obx = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX();
		obx.parse(input);

		String encoded = obx.encode();
		ourLog.debug("Encoded: \n{}", encoded);

	}

}
