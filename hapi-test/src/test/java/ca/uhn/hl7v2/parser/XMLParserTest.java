/*
 * XMLParserTest.java
 *
 * Created on March 15, 2002, 12:53 PM
 */

package ca.uhn.hl7v2.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// import hapi.on.olis.erp_z99.message.ERP_R09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v25.datatype.ED;
import ca.uhn.hl7v2.model.v25.datatype.FT;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.OMD_O03;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.util.Terser;

/**
 * JUnit test harness for XMLParser
 * 
 * @author Bryan Tripp
 */
public class XMLParserTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(XMLParserTest.class);
	private XMLParser parser;

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

    /*
	@Test
	public void testDisableWhitespaceTrimming() throws HL7Exception {
		
		ERP_R09 response = new ERP_R09();
		String erpr09xml = "<ERP_R09 xmlns=\"urn:hl7-org:v2xml\">\n" + 
			"    <MSH>\n" + 
			"        <MSH.1>|</MSH.1>\n" + 
			"        <MSH.2>^~\\&amp;</MSH.2>\n" + 
			"        <MSH.3>\n" + 
			"            <HD.2>O   L    I    S</HD.2>\n" + 
			"        </MSH.3>\n" + 
			"        <MSH.9>\n" + 
			"            <MSG.1>ERP</MSG.1>\n" + 
			"            <MSG.2>Z99</MSG.2>\n" + 
			"            <MSG.3>ERP_R09</MSG.3>\n" + 
			"        </MSH.9>\n" + 
			"    </MSH>" +
			"</ERP_R09>";
		
		DefaultXMLParser fromParser = new DefaultXMLParser();
		response.setParser(fromParser);
		response.parse(erpr09xml );
		assertEquals("O L I S", response.getMSH().getMsh3_SendingApplication().getHd2_UniversalID().getValue());
		
		fromParser = new DefaultXMLParser();
		response.setParser(fromParser);
		fromParser.getParserConfiguration().setXmlDisableWhitespaceTrimmingOnNodeNames("HD.2");
		response.parse(erpr09xml );
		assertEquals("O   L    I    S", response.getMSH().getMsh3_SendingApplication().getHd2_UniversalID().getValue());

		fromParser = new DefaultXMLParser();
		response.setParser(fromParser);
		fromParser.getParserConfiguration().setXmlDisableWhitespaceTrimmingOnAllNodes(true);
		response.parse(erpr09xml );
		assertEquals("O   L    I    S", response.getMSH().getMsh3_SendingApplication().getHd2_UniversalID().getValue());

	}
	*/
	
	/**
	 */
	@Test
	public void testParseExtraComponents() throws IOException, EncodingNotSupportedException,
			HL7Exception {
		InputStream stream = XMLParserTest.class.getClassLoader().getResourceAsStream(
				"ca/uhn/hl7v2/parser/extracmp_xml.xml");
		byte[] bytes = new byte[10000];
		StringBuffer buffer = new StringBuffer();
		int count;
		while ((count = stream.read(bytes)) > 0) {
			buffer.append(new String(bytes), 0, count);
		}

		String xmlMessage = buffer.toString();
		Message message = new DefaultXMLParser().parse(xmlMessage);

		String er7Message = new PipeParser().encode(message).replaceAll("\\r", "\r\n");
		ourLog.info(er7Message);

		// This string is contained in an extra component in the XML message
		assertTrue(er7Message.contains("HD.4"));
		
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
		String test2 = "blorg gablorg"; // bad: no <MSH>
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

    @Test
    public void testParseWithNamespaces() throws Exception {
        String xmlMessage = loadFile("/ca/uhn/hl7v2/parser/parse_and_encode_with_ns.xml");
        Message message = new DefaultXMLParser().parse(xmlMessage);
        assertEquals("2.2", message.getVersion());
        Terser t = new Terser(message);
        assertEquals("19951010134000", t.get("MSH-7"));
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
		ourLog.debug("Message:\n{}", textoXML);
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

    // FIXME: what is the expectation here??
	@Ignore
	public void testWeirdMessage() throws HL7Exception, IOException {
		String msg = loadFile("/ca/uhn/hl7v2/parser/weird_message.xml");
		XMLParser p = DefaultXMLParser.getInstanceWithNoValidation();
		p.parse(msg);
	}

	/**
	 * Test for 202
	 */
	@Test
	public void testEncodeMessageWithTrailingEncodedBackslash() throws EncodingNotSupportedException, HL7Exception, IOException {
		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		
		XMLParser p = DefaultXMLParser.getInstanceWithNoValidation();
		String encoded;

		msg.getMSH().getMessageControlID().setValue("1234");
		encoded = p.encode(msg);
		assertTrue(encoded, encoded.contains("<MSH.10>1234</MSH.10>"));

		msg.getMSH().getMessageControlID().setValue("1234\\E\\1234");
		encoded = p.encode(msg);
		assertTrue(encoded, encoded.contains("<MSH.10>1234\\E\\1234</MSH.10>"));

		msg.getMSH().getMessageControlID().setValue("1234\\E\\");
		encoded = p.encode(msg);
		assertTrue(encoded, encoded.contains("<MSH.10>1234\\E\\</MSH.10>"));

		msg.getMSH().getMessageControlID().setValue("1234\\E\\\\E\\");
		encoded = p.encode(msg);
		assertTrue(encoded, encoded.contains("<MSH.10>1234\\E\\\\E\\</MSH.10>"));

		msg.getMSH().getMessageControlID().setValue("1234\\E\\\\.BR\\");
		encoded = p.encode(msg);
		assertTrue(encoded, encoded.contains("<MSH.10>1234\\E\\<escape V=\".BR\"/>\n"));

	}


	@Test
	public void testMessageParseMethodAndEncodeMethod() throws HL7Exception, IOException {

		String message = loadFile("/ca/uhn/hl7v2/parser/parse_and_encode.xml");
		ca.uhn.hl7v2.model.v26.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v26.message.ORU_R01();
		XMLParser p = DefaultXMLParser.getInstanceWithNoValidation();
		msg.setParser(p);

		msg.parse(message);
		assertEquals("LABMI1199510101340007", msg.getMSH().getMessageControlID().getValue());

		String encoded = msg.encode();
		assertTrue(encoded, encoded.contains("<MSH.10>LABMI1199510101340007</MSH.10>"));

	}

	/**
	 * See http://sourceforge.net/tracker/?func=detail&atid=423835&aid=3566636&group_id=38899
	 */
	@Test
	public void testMessageParseOMD_O03() throws HL7Exception, IOException {

		String message = loadFile("/ca/uhn/hl7v2/parser/OMD_O03.xml");
		XMLParser p = DefaultXMLParser.getInstanceWithNoValidation();
		OMD_O03 msg = (OMD_O03) p.parse(message);

		ourLog.debug("Structure:\n{}", msg.printStructure());

		assertEquals("S", msg.getORDER_DIET().getDIET().getODS().getOds1_Type().getValue());
		
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


    /**
     * <p>
     *     Attempt to parse a {@link ca.uhn.hl7v2.model.GenericMessage}.  These objects have `$` in their class name, ex: `GenericMessage$V21`.
     *     The {@link DefaultXMLParser} will attempt to use the class name when constructing the {@link Document} when encoding.  The `$` is
     *     not a valid character within an element name.
     * </p>
     * <p>
     *     Construct a {@link GenericMessage} for each available version, and call {@link DefaultXMLParser#encode(Message)} on the message.
     *     We expect that a valid {@link Document} is returned, as the `$` is stripped out.
     * </p>
     */
	@Test
    public void test_encode_GenericMessage() throws Exception {

	    DefaultXMLParser xmlParser = new DefaultXMLParser();

        for (Version version : Version.values()) {

            Class<? extends Message> c = GenericMessage.getGenericMessageClass(version.getVersion());
            Message m = c.getConstructor(ModelClassFactory.class).newInstance(new GenericModelClassFactory());

            Document d = xmlParser.encodeDocument(m);
            Assert.assertNotNull(d);
            Assert.assertEquals("GenericMessage" + version.name(), d.getDocumentElement().getTagName());
        }
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
