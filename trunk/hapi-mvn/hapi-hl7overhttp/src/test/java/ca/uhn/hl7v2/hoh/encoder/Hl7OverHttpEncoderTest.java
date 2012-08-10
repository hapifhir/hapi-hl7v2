package ca.uhn.hl7v2.hoh.encoder;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Map.Entry;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSigner;

public class Hl7OverHttpEncoderTest {

	private static BouncyCastleCmsMessageSigner mySigner;
	
	// TODO: add a test to make sure that the date header matches the message timestamp
	
	@Test
	public void testContentLengthCalculatedCorrectly() throws EncodeException, UnsupportedEncodingException {
		
		// Contains a multi-byte sequence
		String message = "MSH|^~\\&|||||200803051508||ACK^A31|33|P|2.5\r"
				+ "MSA|AR|I♥HAPI\r";

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setCharset(Charset.forName("UTF-8"));
		enc.setMessage(message);
		enc.encode();
		
		assertEquals("" + message.getBytes("UTF-8").length, enc.getHeaders().get("Content-Length"));
	}

	@Test
	public void testContentLengthCalculation() throws EncodeException {
		
		String message = "MSH|^~\\&|||||200803051508||ACK^A31|33|P|2.5\r"
				+ "MSA|AR|2\r";

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setSigner(mySigner);
		enc.setMessage(message);
		enc.encode();
		
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			System.out.println(next.getKey() + ": " + next.getValue());
		}

	}

	
	@Test
	public void testEncode() throws EncodeException {
		
		String message = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r"
				+ "EVN||200803051509\r"
				+ "PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setSigner(mySigner);
		enc.setMessage(message);
		enc.encode();
		
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			System.out.println(next.getKey() + ": " + next.getValue());
		}

	}

	@BeforeClass
	public static void beforeClass() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
		KeyStore keyStore = KeyStore.getInstance("JKS");
		InputStream ksStream = BouncyCastleCmsMessageSigner.class.getResourceAsStream("/keystore.jks");
		keyStore.load(ksStream, "changeit".toCharArray());

		mySigner = new BouncyCastleCmsMessageSigner();
		mySigner.setKeyStore(keyStore);
		mySigner.setKeyAlias("testcert");
		mySigner.setAliasPassword("changeit");
	}
	
}
