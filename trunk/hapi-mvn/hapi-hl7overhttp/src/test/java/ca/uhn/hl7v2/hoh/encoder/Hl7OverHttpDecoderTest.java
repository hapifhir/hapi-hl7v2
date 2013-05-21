package ca.uhn.hl7v2.hoh.encoder;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.encoder.AbstractHl7OverHttpDecoder;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpRequestDecoder;
import ca.uhn.hl7v2.hoh.util.GZipUtils;
import ca.uhn.hl7v2.hoh.util.SplitInputStream;

public class Hl7OverHttpDecoderTest {

	private static String ourSampleMessage;
	private static String ourSampleMessageWithMultibyte;

	@BeforeClass
	public static void beforeClass() {
		ourSampleMessage = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + 
				"EVN||200803051509\r" + 
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";

		ourSampleMessageWithMultibyte = ourSampleMessage.replace("SSN", "I♥HAPI");
	}

	// TODO: add test to make sure that a request with chunked encoding can be decoded
	
	@Test
	public void testDecodeFromStream() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + "Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
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
		assertEquals("/AppName", d.getPath());

	}

	/**
	 * Allow malformed client to be processed correctly, per
	 * http://www.w3.org/Protocols/rfc2616/rfc2616-sec19.html#sec19.3
	 */
	@Test
	public void testDecodeFromStreamWithHeaderLineEndingLF() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\n" + // -
				"Content-Type: application/hl7-v2; charset=ISO-8859-2\n" + // -
				"Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\n" + // -
				"Authorization: Basic aGVsbG86d29ybGQ=\n" + // -
				"\n";
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
		assertEquals("/AppName", d.getPath());

	}

	/**
	 * Allow malformed client to be processed correctly, per
	 * http://www.w3.org/Protocols/rfc2616/rfc2616-sec19.html#sec19.3
	 */
	@Test
	public void testDecodeFromStreamWithWeirdHeaderLineSpaces() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST  \t\t /AppName         \tHTTP/1.1\n" + // -
				"Content-Type:\t\t application/hl7-v2; charset=ISO-8859-2\n" + // -
				"Content-Length:            " + ourSampleMessage.getBytes("ISO-8859-1").length + "\n" + // -
				"Authorization:\t\t\t\t Basic aGVsbG86d29ybGQ=\n" + // -
				"\n";
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
		assertEquals("/AppName", d.getPath());

	}

	@Test
	public void testDecodeFromStreamWithTwoMessages() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + "Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));

		// Double the message
		bos.write(bos.toByteArray());

		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
		d.readHeadersAndContentsFromInputStreamAndDecode(byteArrayInputStream);

		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getPath());

		// Read a second

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
		assertEquals("/AppName", d.getPath());

	}

	@Test
	public void testDecodeFromStreamWithMultibyteSequences() throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=UTF-8\r\n" + "Content-Length: " + ourSampleMessageWithMultibyte.getBytes("UTF-8").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
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
		assertEquals("/AppName", d.getPath());

	}

	@Test
	public void testDecodeFromStreamWithCompression() throws Exception {
		byte[] sampleMessage = GZipUtils.compress(ourSampleMessageWithMultibyte.getBytes("UTF-8"));

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + 
				"Content-Type: application/hl7-v2; charset=UTF-8\r\n" + 
				"Content-Length: " + sampleMessage.length + "\r\n" + 
				"Content-Encoding: gzip\r\n" + 
				"Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
		
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
		assertEquals("/AppName", d.getPath());

	}

	@Test
	public void testDecodeFromStreamWithMultipleMessages() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + "Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";

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
		assertEquals("/AppName", d.getPath());

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
		assertEquals("/AppName", d.getPath());

	}

	/**
	 * Simulate a network blip causing a delay mid-message
	 */
	@Test
	public void testDecodeFromStreamWithPauseInTheMiddleOfMessage() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + "Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));
		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();

		ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
		SplitInputStream is = new SplitInputStream(bais, msg.length() + 10);

		d.readHeadersAndContentsFromInputStreamAndDecode(is);

		assertEquals(0, bais.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getPath());

	}

	/**
	 * Simulate a network blip causing a delay mid-message
	 */
	@Test
	public void testDecodeFromStreamWithPauseInStatusLine() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + "Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));
		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();

		ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
		SplitInputStream is = new SplitInputStream(bais, 5);

		d.readHeadersAndContentsFromInputStreamAndDecode(is);

		assertEquals(0, bais.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getPath());

	}

	/**
	 * Simulate a network blip causing a delay mid-message
	 */
	@Test
	public void testDecodeFromStreamWithPauseInMiddleOfHeaders() throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String msg = "POST /AppName HTTP/1.1\r\n" + "Content-Type: application/hl7-v2; charset=ISO-8859-2\r\n" + "Content-Length: " + ourSampleMessage.getBytes("ISO-8859-1").length + "\r\n" + "Authorization: Basic aGVsbG86d29ybGQ=\r\n" + "\r\n";
		bos.write(msg.getBytes("ISO-8859-1"));
		bos.write(ourSampleMessage.getBytes("ISO-8859-2"));
		AbstractHl7OverHttpDecoder d = new Hl7OverHttpRequestDecoder();

		ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
		SplitInputStream is = new SplitInputStream(bais, 30);

		d.readHeadersAndContentsFromInputStreamAndDecode(is);

		assertEquals(0, bais.available());
		assertTrue(d.getConformanceProblems().toString(), d.getConformanceProblems().isEmpty());
		assertEquals(Charset.forName("ISO-8859-2"), d.getCharset());
		assertTrue(d.isCharsetExplicitlySet());
		assertEquals("application/hl7-v2", d.getContentType());
		assertEquals(ourSampleMessage, d.getMessage());
		assertEquals("hello", d.getUsername());
		assertEquals("world", d.getPassword());
		assertEquals("/AppName", d.getPath());

	}
}
