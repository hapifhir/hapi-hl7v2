package ca.uhn.hl7v2.hoh;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.util.GZipUtils;

public class Hl7OverHttpDecoderTest {

	private static String ourSampleMessage;
	private static String ourSampleMessageWithMultibyte;


	@BeforeClass
	public static void beforeClass() {
		ourSampleMessage = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r"
				+ "EVN||200803051509\r"
				+ "PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";

		ourSampleMessageWithMultibyte = ourSampleMessage.replace("SSN", "I♥HAPI");
	}
	
	
	@Test
	public void testDecodeFromStream() throws Exception {
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" +
				"Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + 
				"Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + 
				"Authorization: Basic aGVsbG86d29ybGQ=\r\n" +
				"\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));
		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
		d.readHeadersAndContentsFromInputStreamAndDecode(byteArrayInputStream);
		
		assertEquals(0, byteArrayInputStream.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getUri());

	}
	
	@Test
	public void testDecodeFromStreamWithMultibyteSequences() throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" +
				"Content-Type: application/hl7-v2; charset=UTF-8\r\n" + 
				"Content-Length: " + ourSampleMessageWithMultibyte.getBytes("UTF-8").length + "\r\n" + 
				"Authorization: Basic aGVsbG86d29ybGQ=\r\n" +
				"\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessageWithMultibyte.getBytes("UTF-8"));
		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
		d.readHeadersAndContentsFromInputStreamAndDecode(byteArrayInputStream);
		
		assertEquals(0, byteArrayInputStream.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("UTF-8"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessageWithMultibyte, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getUri());

	}
	
	@Test
	public void testDecodeFromStreamWithCompression() throws Exception {
		byte[] sampleMessage = GZipUtils.compress(ourSampleMessageWithMultibyte.getBytes("UTF-8"));
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" +
				"Content-Type: application/hl7-v2; charset=UTF-8\r\n" + 
				"Content-Length: " + sampleMessage.length + "\r\n" +
				"Content-Coding: gzip\r\n" +
				"Authorization: Basic aGVsbG86d29ybGQ=\r\n" +
				"\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(sampleMessage);
		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
		d.readHeadersAndContentsFromInputStreamAndDecode(byteArrayInputStream);
		
		assertEquals(0, byteArrayInputStream.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("UTF-8"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessageWithMultibyte, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getUri());

	}

	@Test
	public void testDecodeFromStreaWithMultipleMessages() throws Exception {
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" +
				"Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + 
				"Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + 
				"Authorization: Basic aGVsbG86d29ybGQ=\r\n" +
				"\r\n";
		
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());

		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();
		d.readHeadersAndContentsFromInputStreamAndDecode(byteArrayInputStream);
		
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getUri());

		d = new Hl7OverHttpRequestDecoder();
		d.readHeadersAndContentsFromInputStreamAndDecode(byteArrayInputStream);
		
		assertEquals(0, byteArrayInputStream.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getUri());

	}

}
