package ca.uhn.hl7v2.hoh.util;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.junit.Test;

public class KeystoreUtilsTest {

	@Test
	public void testValidateKeystoreForTlsReceiving() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {

		KeyStore ks = KeystoreUtils.loadKeystore("src/test/resources/keystore.jks", "changeit");
		boolean found = KeystoreUtils.validateKeystoreForTlsReceiving(ks);
		assertTrue(found);
		
		ks = KeystoreUtils.loadKeystore("src/test/resources/truststore.jks", "changeit");
		found = KeystoreUtils.validateKeystoreForTlsReceiving(ks);
		assertFalse(found);
		
	}
	
	
	

}
