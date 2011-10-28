package ca.uhn.hl7v2.llp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ExtendedMinLowerLayerProtocolTest extends TestCase {

	public void testMinLowerLayerProtocolReaderAndWriter() throws HL7Exception, IOException, LLPException {
		
		ADT_A01 a01 = new ADT_A01();
		a01.getParser().setValidationContext(new ValidationContextImpl());
		a01.initQuickstart("ADT", "A01", "T");
		a01.getPID().getSetIDPID().setValue("ÇØ§");
		
		String hl7Cs = "8859/1";
		String javaCs = "ISO-8859-1";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "ÇØ§");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "ÇØ§");

		hl7Cs = "8859/5";
		javaCs = "ISO-8859-5";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "??§");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "??§");

		hl7Cs = "UNICODE UTF-8";
		javaCs = "UTF-8";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "ÇØ§");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "ÇØ§");

		hl7Cs = "UNICODE UTF-16";
		javaCs = "UTF-16";
		verifyReaderForCodeSystem(a01, hl7Cs, javaCs, "ÇØ§");
		verifyWriterForCodeSystem(a01, hl7Cs, javaCs, "ÇØ§");

	}

	private void verifyWriterForCodeSystem(ADT_A01 a01, String hl7Cs, String javaCs, String theString) throws HL7Exception, LLPException, IOException {
		a01.getMSH().getMsh18_CharacterSet(0).setValue(hl7Cs);

		a01.setParser(new PipeParser());
		String encodedString = a01.encode();
		System.out.println("Message is:\n" + encodedString.replace("\r", "\n"));

		byte[] expectedBytes = encodedString.getBytes(javaCs);
		System.out.println("Encoded " + encodedString.length() + " chars in " + hl7Cs + " is " + expectedBytes.length + " bytes");

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
		
		a01.setParser(new PipeParser());
		String encodedString = a01.encode();
		System.out.println("Message is:\n" + encodedString.replace("\r", "\n"));

		byte[] encodedBytes = encodedString.getBytes(javaCs);
		System.out.println("Encoded " + encodedString.length() + " chars in " + hl7Cs + " is " + encodedBytes.length + " bytes");
		
		byte[] llpWrappedBytes = new byte[encodedBytes.length + 3];
		llpWrappedBytes[0] = MinLLPReaderTest.START_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 2] = MinLLPReaderTest.END_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 1] = MinLLPReaderTest.LAST_CHARACTER;
		System.arraycopy(encodedBytes, 0, llpWrappedBytes, 1, encodedBytes.length);
		
		InputStream is = new ByteArrayInputStream(llpWrappedBytes);
		ExtendedMinLLPReader reader = new ExtendedMinLLPReader(is);
		
		String actual = reader.getMessage();
		assertEquals(encodedString.replace("ÇØ§", theString), actual);
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
			assertEquals(encodedString.replace("ÇØ§", theString), actual);
			assertEquals(Charset.forName(javaCs), reader.getLastCharset());

		}

		/*
		 * Test using XML encoding
		 */
		
		a01.setParser(new DefaultXMLParser());
		encodedString = a01.encode();
//		System.out.println("Message is:\n" + encodedString.replace("\r", "\n"));

		encodedBytes = encodedString.getBytes(javaCs);
		System.out.println("Encoded " + encodedString.length() + " chars in " + hl7Cs + " is " + encodedBytes.length + " bytes");
		
		llpWrappedBytes = new byte[encodedBytes.length + 3];
		llpWrappedBytes[0] = MinLLPReaderTest.START_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 2] = MinLLPReaderTest.END_MESSAGE;
		llpWrappedBytes[llpWrappedBytes.length - 1] = MinLLPReaderTest.LAST_CHARACTER;
		System.arraycopy(encodedBytes, 0, llpWrappedBytes, 1, encodedBytes.length);
		
		is = new ByteArrayInputStream(llpWrappedBytes);
		reader = new ExtendedMinLLPReader(is);
		
		actual = reader.getMessage();
		assertEquals(encodedString.replace("ÇØ§", theString), actual);
		assertEquals(Charset.forName(javaCs), reader.getLastCharset());
		
		
	}
	
	
}
