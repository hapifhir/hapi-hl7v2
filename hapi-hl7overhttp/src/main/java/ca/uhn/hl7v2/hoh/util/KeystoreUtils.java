package ca.uhn.hl7v2.hoh.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class KeystoreUtils {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(KeystoreUtils.class);

	/** non instantiable */
	private KeystoreUtils() {
		// nothing
	}

	public static KeyStore loadKeystore(File theFile, char[] thePassword) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(new BufferedInputStream(new FileInputStream(theFile)), thePassword);
		return keystore;
	}

	public static KeyStore loadKeystore(String theFile, String theKeystorePassword) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		char[] pass = theKeystorePassword != null ? theKeystorePassword.toCharArray() : null;
		return loadKeystore(new File(theFile), pass);
	}

	public static boolean validateKeystoreForTlsReceiving(KeyStore theKs) throws KeyStoreException {

		Enumeration<String> aliases = theKs.aliases();
		boolean foundPrivateKey = false;
		while (aliases.hasMoreElements()) {
			String nextAlias = aliases.nextElement();

			ourLog.debug("Checking keystore alias: {}", nextAlias);

			if (theKs.isKeyEntry(nextAlias)) {
				ourLog.debug("Found private key: " + nextAlias);
				foundPrivateKey = true;
			}

		}

		return foundPrivateKey;
	}

	public static boolean validateKeystoreForSignatureSigning(KeyStore theKs) throws KeyStoreException {

		Enumeration<String> aliases = theKs.aliases();
		boolean foundPrivateKey = false;
		while (aliases.hasMoreElements()) {
			String nextAlias = aliases.nextElement();

			ourLog.debug("Checking keystore alias: {}", nextAlias);

			if (theKs.isKeyEntry(nextAlias)) {
				ourLog.debug("Found private key: " + nextAlias);
				foundPrivateKey = true;
			}

		}

		return foundPrivateKey;
	}

	public static boolean validateKeystoreForTlsSending(KeyStore theKs) throws KeyStoreException {

		Enumeration<String> aliases = theKs.aliases();
		boolean foundPublicKey = false;
		while (aliases.hasMoreElements()) {
			String nextAlias = aliases.nextElement();

			ourLog.debug("Checking keystore alias: {}", nextAlias);

			if (theKs.isCertificateEntry(nextAlias)) {
				ourLog.debug("Found public key: " + nextAlias);
				foundPublicKey = true;
			}

		}

		return foundPublicKey;
	}

	public static boolean validateKeystoreForSignatureVerifying(KeyStore theKs) throws KeyStoreException {

		Enumeration<String> aliases = theKs.aliases();
		boolean foundPublicKey = false;
		while (aliases.hasMoreElements()) {
			String nextAlias = aliases.nextElement();

			ourLog.debug("Checking keystore alias: {}", nextAlias);

			if (theKs.isCertificateEntry(nextAlias)) {
				ourLog.debug("Found public key: " + nextAlias);
				foundPublicKey = true;
			}

		}

		return foundPublicKey;
	}

}
