package ca.uhn.hl7v2.hoh.sign;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.security.KeyStore;

import org.junit.Test;

import ca.uhn.hl7v2.hoh.sign.MessageDoesNotVerifyException;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSigner;

public class BouncyCastleCmsMessageSignerTest {
	
	private static final String HELLO_WORLD = "HELLO WORLD!!!!!aa";
	
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(BouncyCastleCmsMessageSignerTest.class);

	@Test
	public void testEncode() throws Exception {

		KeyStore keyStore = KeyStore.getInstance("JKS");
		InputStream ksStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/keystore.jks");
		keyStore.load(ksStream, "changeit".toCharArray());

		BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(keyStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");
		String signed = signer.sign(HELLO_WORLD.getBytes("US-ASCII"));

		ourLog.info("Signed ({} bytes): {}", signed.length(), signed);

		// Now verify

		KeyStore trustStore = KeyStore.getInstance("JKS");
		InputStream trustStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/truststore.jks");
		trustStore.load(trustStream, "changeit".toCharArray());

		signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(trustStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");
		signer.verify(HELLO_WORLD.getBytes("US-ASCII"), signed);

		StandardMessageSigner signer2 = new StandardMessageSigner();
		signer2.setKeyStore(trustStore);
		signer2.setKeyAlias("testcert");
		signer2.setAliasPassword("changeit");
		signer2.verify(HELLO_WORLD.getBytes("US-ASCII"), "SHA512withRSA " + signed);
		
		// Now verify that non-matching fails

		signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(trustStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");

		try {
			signer.verify("HELLO WORLD....".getBytes("US-ASCII"), signed);
			fail();
		} catch (MessageDoesNotVerifyException e) {

		}

		signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(trustStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");

		// Change one letter in the signature
		
		try {
			switch (signed.charAt(20)) {
			case 'q':
				signed = signed.substring(0, 20) + "r" + signed.substring(21, signed.length());
				break;
			default:
				signed = signed.substring(0, 20) + "q" + signed.substring(21, signed.length());
			}
			signer.verify(HELLO_WORLD.getBytes("US-ASCII"), signed);
			fail();
		} catch (SignatureFailureException e) {

		}
	}

}
