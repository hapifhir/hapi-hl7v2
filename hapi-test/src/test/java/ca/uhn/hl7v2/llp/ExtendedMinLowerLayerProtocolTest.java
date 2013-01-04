package ca.uhn.hl7v2.llp;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.app.TestUtils;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

public class ExtendedMinLowerLayerProtocolTest implements Application {

	private int myMsgCount;
	private PipeParser parser;
	private XMLParser xmlParser;

	private static final Logger LOG = LoggerFactory.getLogger(ExtendedMinLowerLayerProtocol.class);

	@Before
	public void setup() {
		DefaultHapiContext ctx = new DefaultHapiContext(new NoValidationBuilder());
		parser = ctx.getPipeParser();
		xmlParser = ctx.getXMLParser();
	}

	@Test
	public void testMinLowerLayerProtocolReaderAndWriter() throws HL7Exception, IOException, LLPException {

		ADT_A01 a01 = new ADT_A01();
		a01.setParser(parser);
		
		a01.initQuickstart("ADT", "A01", "T");
		a01.getPID().getSetIDPID().setValue("√á√ò¬ß");

		String hl7Cs = "8859/1";
		String javaCs = "ISO-8859-1";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "?á?ò¬ß");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "?á?ò¬ß");

		a01.getPID().getSetIDPID().setValue("√á√òЉЛ");

		hl7Cs = "8859/5";
		javaCs = "ISO-8859-5";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "????ЉЛ");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "????ЉЛ");

		a01.getPID().getSetIDPID().setValue("√á√ò¬ß");

		hl7Cs = "UNICODE UTF-8";
		javaCs = "UTF-8";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "√á√ò¬ß");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "√á√ò¬ß");

		hl7Cs = "UNICODE UTF-16";
		javaCs = "UTF-16";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "√á√ò¬ß");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "√á√ò¬ß");

	}

	private void verifyWriterForCodeSystem(ADT_A01 a01, String hl7Cs, String javaCs, String theString) throws HL7Exception, LLPException, IOException {
		a01.getMSH().getMsh18_CharacterSet(0).setValue(hl7Cs);

		a01.setParser(parser);
		String encodedString = a01.encode();
		LOG.debug("Message is:\n" + encodedString.replace("\r", "\n"));

		byte[] expectedBytes = encodedString.getBytes(javaCs);
		LOG.debug("Encoded " + encodedString.length() + " chars in " + hl7Cs + " is " + expectedBytes.length + " bytes");

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ExtendedMinLLPWriter writer = new ExtendedMinLLPWriter(bos);
		writer.writeMessage(encodedString);

		byte[] actualBytesTemp = bos.toByteArray();
		byte[] actualBytes = new byte[actualBytesTemp.length - 3];
		System.arraycopy(actualBytesTemp, 1, actualBytes, 0, actualBytesTemp.length - 3);

		Assert.assertEquals(expectedBytes.length, actualBytes.length);
		Assert.assertEquals(toList(expectedBytes), toList(actualBytes));
	}

	private List<Byte> toList(byte[] theActualBytes) {
		ArrayList<Byte> retVal = new ArrayList<Byte>();
		for (byte b : theActualBytes) {
			retVal.add(b);
		}
		return retVal;
	}

	private void verifyReaderForCodeSystem(ADT_A01 a01, String hl7Cs, String javaCs, String theString) throws DataTypeException, HL7Exception, UnsupportedEncodingException, IOException, LLPException {
		a01.getMSH().getMsh18_CharacterSet(0).setValue(hl7Cs);

		/*
		 * Test using ER7 encoding
		 */

		a01.setParser(parser);
		String encodedString = a01.encode();
		LOG.debug("Message is:\n" + encodedString.replace("\r", "\n"));

		byte[] encodedBytes = encodedString.getBytes(javaCs);
		LOG.debug("Encoded " + encodedString.length() + " chars in " + hl7Cs + " is " + encodedBytes.length + " bytes");

		byte[] llpWrappedBytes = new byte[encodedBytes.length + 3];
		llpWrappedBytes[0] = MinLLPReaderTest.START_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 2] = MinLLPReaderTest.END_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 1] = MinLLPReaderTest.LAST_CHARACTER;
		System.arraycopy(encodedBytes, 0, llpWrappedBytes, 1, encodedBytes.length);

		InputStream is = new ByteArrayInputStream(llpWrappedBytes);
		ExtendedMinLLPReader reader = new ExtendedMinLLPReader(is);

		String actual = reader.getMessage();
		String originalValue = a01.getPID().getSetIDPID().getValue();
		String expected = encodedString.replace(originalValue, theString);
		assertEquals(expected, actual);
		assertEquals(Charset.forName(javaCs), reader.getLastCharset());

		// Try with the endian reversed
		if ("UTF-16".equals(javaCs)) {

			for (int i = 1; i < llpWrappedBytes.length - 2; i += 2) {
				byte b0 = llpWrappedBytes[i];
				byte b1 = llpWrappedBytes[i + 1];
				llpWrappedBytes[i] = b1;
				llpWrappedBytes[i + 1] = b0;
			}

			is = new ByteArrayInputStream(llpWrappedBytes);
			reader = new ExtendedMinLLPReader(is);

			actual = reader.getMessage();
			assertEquals(encodedString.replace("√á√ò¬ß", theString), actual);
			assertEquals(Charset.forName(javaCs), reader.getLastCharset());

		}

		/*
		 * Test using XML encoding
		 */

		a01.setParser(xmlParser);
		encodedString = a01.encode();
		// System.out.println("Message is:\n" + encodedString.replace("\r",
		// "\n"));

		encodedBytes = encodedString.getBytes(javaCs);
		LOG.debug("Encoded " + encodedString.length() + " chars in " + hl7Cs + " is " + encodedBytes.length + " bytes");

		llpWrappedBytes = new byte[encodedBytes.length + 3];
		llpWrappedBytes[0] = MinLLPReaderTest.START_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 2] = MinLLPReaderTest.END_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 1] = MinLLPReaderTest.LAST_CHARACTER;
		System.arraycopy(encodedBytes, 0, llpWrappedBytes, 1, encodedBytes.length);

		is = new ByteArrayInputStream(llpWrappedBytes);
		reader = new ExtendedMinLLPReader(is);

		actual = reader.getMessage();
		assertEquals(encodedString.replace(originalValue, theString), actual);
		assertEquals(Charset.forName(javaCs), reader.getLastCharset());

	}

	@Test
	public void testReceiveWithDelayInBetween() throws Exception {

		int port = RandomServerPortProvider.findFreePort();
		SimpleServer server = new SimpleServer(port, new ExtendedMinLowerLayerProtocol(), PipeParser.getInstanceWithNoValidation());
		server.registerApplication("*", "*", this);
		server.start();

		Socket socket = TestUtils.acquireClientSocket(port);
		MinLLPWriter w = new MinLLPWriter(socket.getOutputStream());
		MinLLPReader r = new MinLLPReader(socket.getInputStream());

		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		w.writeMessage(msg.encode());
		String resp = r.getMessage();
		ourLog.debug(resp.replace("\r", "\n"));

		Thread.sleep(SimpleServer.SO_TIMEOUT + 500);

		msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		w.writeMessage(msg.encode());
		resp = r.getMessage();
		ourLog.debug(resp.replace("\r", "\n"));

		assertEquals(2, myMsgCount);

		assertFalse(server.getRemoteConnections().isEmpty());

		socket.close();

		Thread.sleep(SimpleServer.SO_TIMEOUT + 500);

		assertTrue(server.getRemoteConnections().isEmpty());

	}

	private static final Logger ourLog = LoggerFactory.getLogger(ExtendedMinLowerLayerProtocolTest.class);

	@Before
	public void setUp() {
		myMsgCount = 0;
	}

	public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {
		try {
			Message ack = theIn.generateACK();
			myMsgCount++;
			return ack;
		} catch (IOException e) {
			throw new HL7Exception(e);
		}
	}

	public boolean canProcess(Message theIn) {
		return true;
	}

}
