package ca.uhn.hl7v2.hoh;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Map.Entry;

import org.junit.BeforeClass;
import org.junit.Test;

public class Hl7OverHttpEncoderTest {

	private static StandardMessageSigner mySigner;
	
	@Test
	public void testAck() {
		
		String message = "MSH|^~\\&|||||200803051508||ACK^A31|33|P|2.5\r"
				+ "MSA|AR|2\r";

		Hl7OverHttpEncoder enc = new Hl7OverHttpEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMode(MessageMode.REQUEST);
		enc.setSigner(mySigner);
		enc.setMessage(message);
		enc.encode();
		
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			System.out.println(next.getKey() + ": " + next.getValue());
		}

	}

	
	@Test
	public void testEncode() {
		
		String message = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r"
				+ "EVN||200803051509\r"
				+ "PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";

		Hl7OverHttpEncoder enc = new Hl7OverHttpEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMode(MessageMode.REQUEST);
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
		InputStream ksStream = StandardMessageSignerTest.class.getResourceAsStream("/keystore.jks");
		keyStore.load(ksStream, "changeit".toCharArray());

		mySigner = new StandardMessageSigner();
		mySigner.setKeyStore(keyStore);
		mySigner.setKeyAlias("testcert");
		mySigner.setAliasPassword("changeit");
	}
	
}
