/*
 * XMLParserTest.java
 *
 * Created on March 15, 2002, 12:53 PM
 */

package ca.uhn.hl7v2.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v25.datatype.ED;
import ca.uhn.hl7v2.model.v25.datatype.FT;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.v25.message.OMD_O03;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

/**
 * JUnit test harness for XMLParser
 * 
 * @author Bryan Tripp
 */
public class XMLParserTest {

	private XMLParser parser;
	private static final Logger ourLog = LoggerFactory.getLogger(XMLParserTest.class);

	@Before
	public void setUp() throws Exception {
		parser = new DummyXMLParser();
	}

	/**
	 * Tests a fix to bug 2164291
	 * 
	 * XML parsing of segments which appear twice in a message structure definition (e.g. the
	 * duplicate PID segments in a swap patient message) should be handled correctly.
	 */
	@Test
	public void testParseDuplicateSegment() throws IOException, EncodingNotSupportedException,
			HL7Exception {
		InputStream stream = XMLParserTest.class.getClassLoader().getResourceAsStream(
				"ca/uhn/hl7v2/parser/adt_a17.xml");
		byte[] bytes = new byte[10000];
		StringBuffer buffer = new StringBuffer();
		int count;
		while ((count = stream.read(bytes)) > 0) {
			buffer.append(new String(bytes), 0, count);
		}

		String xmlMessage = buffer.toString();
		Message message = new DefaultXMLParser().parse(xmlMessage);

		String er7Message = new PipeParser().encode(message).replaceAll("\\r", "\r\n");

		// System.out.println("Re-encoded:\r\n" + er7Message);

		// We should have only two reps of PID
		int firstIndex = er7Message.indexOf("PID");
		int secondIndex = er7Message.indexOf("PID", firstIndex + 1);
		int thirdIndex = er7Message.indexOf("PID", secondIndex + 1);
		assertTrue(firstIndex > 0);
		assertTrue(secondIndex > firstIndex);
		assertTrue("Found third PID " + firstIndex + " " + secondIndex + " " + thirdIndex + ":\r\n"
				+ er7Message, thirdIndex == -1);

	}

	@Test
	public void testGetAckID() throws HL7Exception, IOException {
		assertEquals(parser.getAckID("<MSA.2>12</MSA.2>"), "12");
		assertEquals(parser.getAckID("<thing<foo> help >>><msa.2> *** </i forget"), "***");
		String ackID = parser.getAckID("<there is no msa.2>x</msa.2>");
		assertEquals(null, ackID);
		ackID = parser.getAckID("<msa.2>x");
		assertEquals(null, ackID);
		ackID = parser.getAckID("<MSA.2>   12   \r</MSA.2>");
		assertEquals("12", ackID);
		ackID = parser.getAckID(loadFile("/ca/uhn/hl7v2/parser/get_ack_id.xml"));
		assertEquals("876", ackID);
	}

	@Test
	public void testGetEncoding() throws Exception {
		String test1 = "<MSH>\r<MSH.1>|</MSH.1>\r<MSH.2>^~\\&amp;</MSH.2>\r</MSH>";
		String test2 = "<MSH>\r<MSH.1>|</MSH.1>\r<MSH.2>^~\\&amp;</MSH.2>\r"; // bad: no </MSH>
		assertEquals("XML", parser.getEncoding(test1));
		assertEquals(null, parser.getEncoding(test2));
	}

	@Test
	public void testGetVersion() throws Exception {
		String message = loadFile("/ca/uhn/hl7v2/parser/get_version.xml");
		String ver = parser.getVersion(message);
		assertEquals("2.4", ver);
	}

	@Test
	public void testRemoveWhitespace() throws Exception {
		assertEquals("hello", parser.removeWhitespace("\t\r\nhello "));
		assertEquals("hello there", parser.removeWhitespace(" hello \t \rthere\r\n"));
	}

	/**
	 * -
	 * 
	 * @throws HL7Exception -
	 * @throws IOException
	 */
	@Test
	public void testGetCriticalResponseData() throws HL7Exception, IOException {
		String message = loadFile("/ca/uhn/hl7v2/parser/critical_response_data.xml");
		Segment data = parser.getCriticalResponseData(message);
		Type actual = data.getField(2, 0);
		String expected = "^~\\&";
		assertEquals(expected, actual.toString()); // Encoding
	}

	public class DummyXMLParser extends XMLParser {
		public DummyXMLParser() throws HL7Exception {
			super();
		}

		public Message parseDocument(Document XMLMessage, String version) throws HL7Exception {
			return null;
		}

		public Document encodeDocument(Message source) throws HL7Exception {
			return null;
		}

		@Override
		public void parse(Message theMessage, String theString) throws HL7Exception {
			throw new UnsupportedOperationException();
		}

	}

	@Test
	public void testEdIssue() throws EncodingNotSupportedException, HL7Exception, IOException {

		String messageText = loadFile("/ca/uhn/hl7v2/parser/ed_issue.xml");

		ORU_R01 message = (ORU_R01) new DefaultXMLParser().parse(messageText);
		ED obx5 = (ED) message.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION(1)
				.getOBX().getObx5_ObservationValue(0).getData();

		assertTrue(obx5.getData().getValue()
				.startsWith("JVBERi0xLjMKJeLjz9MKCjEgMCBvYmoKPDwgL1R5cG"));

	}

	/**
	 * Test for issue reported here:
	 * https://sourceforge.net/tracker/?func=detail&aid=3115671&group_id=38899&atid=423835
	 * 
	 * @throws IOException
	 */
	@Test
	public void testEncodeOmdO03() throws EncodingNotSupportedException, HL7Exception, IOException {
		String texto = loadFile("/ca/uhn/hl7v2/parser/omd_o03.txt", '\r');
		XMLParser xmlParser = new DefaultXMLParser();
		PipeParser pipeParser = new PipeParser();
		OMD_O03 msg = (OMD_O03) pipeParser.parse(texto);
		String textoXML = xmlParser.encode(msg);
		assertTrue(textoXML.contains("OMD_O03.DIET"));
	}

	/**
	 * See https://sourceforge.net/tracker/?func=detail&atid=423835&aid=3308845&group_id=38899
	 */
	@Test
	public void testEncodeLongValuesDoesntWrap() throws HL7Exception, IOException {

		// OBX-5 is a really really long string
		String obx5Value = "AAAABBBB CCCCDDDD ";
		obx5Value = obx5Value + obx5Value + obx5Value + obx5Value + obx5Value;
		obx5Value = obx5Value + obx5Value + obx5Value + obx5Value + obx5Value;
		obx5Value = obx5Value.trim();

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX()
				.getObx2_ValueType().parse("ST");
		msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX()
				.getObx5_ObservationValue(0).parse(obx5Value);

		DefaultXMLParser p = new DefaultXMLParser();
		String encoded = p.encode(msg);

		msg = (ORU_R01) p.parse(encoded);

		ST st = (ST) msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX()
				.getObx5_ObservationValue(0).getData();
		String actual = st.getValue();

		assertEquals(obx5Value, actual);

	}

	@Test
	public void testEncodeMessageWithEscape() throws HL7Exception, IOException {
		// OBX-5 is a really really long string
		String obx5Value = "ABC\\H\\highlighted\\N\\EFG";

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		OBX obx = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX();
		obx.getValueType().parse("FT");
		obx.getObservationValue(0).parse(obx5Value);

		// Test a couple of cases of escape sequences
		DefaultXMLParser p = new DefaultXMLParser();
		String encoded = p.encode(msg);
		assertTrue(encoded
				.contains("<OBX.5>ABC<escape V=\"H\"/>highlighted<escape V=\"N\"/>EFG</OBX.5>"));

		obx5Value = "\\H\\highlighted\\N\\EFG";
		obx.getObservationValue(0).parse(obx5Value);
		encoded = p.encode(msg);
		assertTrue(encoded.contains(" <escape V=\"H\"/>highlighted<escape V=\"N\"/>EFG</OBX.5>"));

		obx5Value = "ABC\\H\\highlighted\\N\\";
		obx.getObservationValue(0).parse(obx5Value);
		encoded = p.encode(msg);
		assertTrue(encoded.contains("<OBX.5>ABC<escape V=\"H\"/>highlighted<escape V=\"N\"/>\n"));

		obx5Value = "ABC\\E\\no escape sequence\\H\\highlighted\\N\\EFG";
		obx.getObservationValue(0).parse(obx5Value);
		encoded = p.encode(msg);
		assertTrue(encoded.contains("<OBX.5>ABC\\no escape sequence<escape"));

		obx5Value = "\\E\\no escape sequence";
		obx.getObservationValue(0).parse(obx5Value);
		encoded = p.encode(msg);
		assertTrue(encoded.contains("<OBX.5>\\no escape sequence</OBX.5>"));

	}

	@Test
	public void testWeirdMessage() throws EncodingNotSupportedException, HL7Exception, IOException {
		String msg = loadFile("/ca/uhn/hl7v2/parser/weird_message.xml");
		DefaultXMLParser p = new DefaultXMLParser();
		p.setValidationContext(new ValidationContextImpl());
		p.parse(msg);
	}

	@Test
	public void testMessageParseMethodAndEncodeMethod() throws HL7Exception, IOException {

		String message = loadFile("/ca/uhn/hl7v2/parser/parse_and_encode.xml");
		ca.uhn.hl7v2.model.v26.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v26.message.ORU_R01();
		DefaultXMLParser xmlParser = new DefaultXMLParser();
		xmlParser.setValidationContext(new ValidationContextImpl());
		msg.setParser(xmlParser);

		msg.parse(message);
		assertEquals("LABMI1199510101340007", msg.getMSH().getMessageControlID().getValue());

		String encoded = msg.encode();
		assertTrue(encoded, encoded.contains("<MSH.10>LABMI1199510101340007</MSH.10>"));

	}

	@Test
	public void testMessageParseMethodAndEncodeMethodWithEscapes() throws HL7Exception, IOException {

		String obx5Value = "CONTENT";

		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		OBX obx = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX();
		obx.getValueType().parse("FT");
		obx.getObservationValue(0).parse(obx5Value);

		DefaultXMLParser p = new DefaultXMLParser();
		String encoded = p.encode(msg);
		// Now manually tweak OBX.5
		encoded = encoded.replace(obx5Value, "<escape V=\"H\"/>" + obx5Value
				+ "<escape V=\".br\"/>" + obx5Value + "<escape V=\"N\"/>");

		msg = (ORU_R01) p.parse(encoded);
		FT ft = (FT) msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX()
				.getObservationValue(0).getData();
		String actual = ft.getValue();

		assertEquals("\\H\\" + obx5Value + "\\.br\\" + obx5Value + "\\N\\", actual);

	}

	private String loadFile(String name) throws IOException {
		return loadFile(name, '\n');
	}

	private String loadFile(String name, char linebreak) throws IOException {
		InputStream resourceInputStream = getClass().getResourceAsStream(name);
		StringBuilder sb = new StringBuilder();

		if (resourceInputStream != null) {
			BufferedReader in = new BufferedReader(new InputStreamReader(resourceInputStream));

			try {
				String line = in.readLine();
				while (line != null) {
					sb.append(line).append(linebreak);
					line = in.readLine();
				}
				return sb.toString();
			} finally {
				in.close();
			}
		} else {
			throw new IOException("File " + name + " not found");
		}
	}

}
