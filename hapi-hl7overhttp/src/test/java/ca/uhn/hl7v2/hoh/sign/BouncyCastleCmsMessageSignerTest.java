package ca.uhn.hl7v2.hoh.sign;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.security.KeyStore;

import org.junit.Test;

public class BouncyCastleCmsMessageSignerTest {

	private static final String HELLO_WORLD = "HELLO WORLD!!!!!aa";

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(BouncyCastleCmsMessageSignerTest.class);

	@Test
	public void testSignAndVerify() throws Exception {

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

		// Now verify that non-matching fails

		signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(trustStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");

		try {
			signer.verify("HELLO WORLD....".getBytes("US-ASCII"), signed);
			fail();
		} catch (SignatureVerificationException e) {

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

	@Test
	public void testTryToSignWithPublicKey() throws Exception {
		KeyStore trustStore = KeyStore.getInstance("JKS");
		InputStream trustStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/truststore.jks");
		trustStore.load(trustStream, "changeit".toCharArray());

		BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(trustStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");

		try {
			signer.sign(HELLO_WORLD.getBytes("US-ASCII"));
			fail();
		} catch (SignatureFailureException e) {
			assertTrue(e.toString(), e.getMessage().contains(BouncyCastleCmsMessageSigner.MSG_KEY_IS_NOT_A_PRIVATE_KEY));
		}
	}

	@Test
	public void testSignAndVerifyStringChanged() throws Exception {

		KeyStore keyStore = KeyStore.getInstance("JKS");
		InputStream ksStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/keystore.jks");
		keyStore.load(ksStream, "changeit".toCharArray());

		BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(keyStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");
		String signed = signer.sign(HELLO_WORLD.getBytes("US-ASCII"));

		ourLog.info("Signed ({} bytes): {}", signed.length(), signed);

		KeyStore trustStore = KeyStore.getInstance("JKS");
		InputStream trustStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/truststore.jks");
		trustStore.load(trustStream, "changeit".toCharArray());

		// Now verify that non-matching fails

		signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(trustStore);
		signer.setKeyAlias("testcert");
		signer.setAliasPassword("changeit");

		try {
			signer.verify("HELLO WORLD....".getBytes("US-ASCII"), signed);
			fail();
		} catch (SignatureVerificationException e) {

		}

	}

	@Test
	public void testSignAndVerifySignatureChanged() throws Exception {

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
