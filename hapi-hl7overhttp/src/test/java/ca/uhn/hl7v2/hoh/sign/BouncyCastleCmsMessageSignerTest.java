package ca.uhn.hl7v2.hoh.sign;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.junit.Test;

public class BouncyCastleCmsMessageSignerTest {

	private static final String HELLO_WORLD = "HELLO WORLD!!!!!aa";

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(BouncyCastleCmsMessageSignerTest.class);

	@Test
	public void testSignAndVerify() throws Exception {

		BouncyCastleCmsMessageSigner signer = createSigner();
		String signed = signer.sign(HELLO_WORLD.getBytes("US-ASCII"));

		ourLog.info("Signed ({} bytes): {}", signed.length(), signed);

		// Now verify
		signer = createVerifier();
		signer.verify(HELLO_WORLD.getBytes("US-ASCII"), signed);

	}

	public static BouncyCastleCmsMessageSigner createVerifier() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		BouncyCastleCmsMessageSigner signer;
		signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(loadTrustStore());
		signer.setKeyAlias(getKeystoreKeyAlias());
		signer.setAliasPassword(getKeystoreKeyAliasPassword());
		return signer;
	}

	public static BouncyCastleCmsMessageSigner createSigner() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
		signer.setKeyStore(getKeystore());
		signer.setKeyAlias(getKeystoreKeyAlias());
		signer.setAliasPassword(getKeystoreKeyAliasPassword());
		return signer;
	}

	private static KeyStore loadTrustStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
		KeyStore trustStore = KeyStore.getInstance("JKS");
		InputStream trustStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/truststore.jks");
		trustStore.load(trustStream, getKeystoreKeyAliasPassword().toCharArray());
		return trustStore;
	}

	private static String getKeystoreKeyAliasPassword() {
		return "changeit";
	}

	private static String getKeystoreKeyAlias() {
		return "testcert";
	}

	private static KeyStore getKeystore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
		KeyStore keyStore = KeyStore.getInstance("JKS");
		InputStream ksStream = BouncyCastleCmsMessageSignerTest.class.getResourceAsStream("/keystore.jks");
		keyStore.load(ksStream, getKeystoreKeyAliasPassword().toCharArray());
		return keyStore;
	}

	@Test
	public void testTryToSignWithPublicKey() throws Exception {
		BouncyCastleCmsMessageSigner signer = createSigner();
		signer.setKeyStore(loadTrustStore());

		try {
			signer.sign(HELLO_WORLD.getBytes("US-ASCII"));
			fail();
		} catch (SignatureFailureException e) {
			assertTrue(e.toString(), e.getMessage().contains(BouncyCastleCmsMessageSigner.MSG_KEY_IS_NOT_A_PRIVATE_KEY));
		}
	}

	@Test
	public void testSignAndVerifyStringChanged() throws Exception {
		BouncyCastleCmsMessageSigner signer = createSigner();
		String signed = signer.sign(HELLO_WORLD.getBytes("US-ASCII"));

		ourLog.info("Signed ({} bytes): {}", signed.length(), signed);

		// Now verify that non-matching fails
		signer = createVerifier();

		try {
			signer.verify("HELLO WORLD....".getBytes("US-ASCII"), signed);
			fail();
		} catch (SignatureVerificationException e) {

		}

	}

}
