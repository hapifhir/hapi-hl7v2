package ca.uhn.hl7v2.hoh.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
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


	public static boolean validateKeyForSignatureSigning(KeyStore theKeystore, String theKeyAlias, String theKeyPassword) {
		Validate.notNull(theKeystore, "Keystore");
		Validate.notBlank(theKeyAlias, "Key Alias");
		Validate.notNull(theKeyPassword, "Key Password");
		
		Key key;
		try {
			key = theKeystore.getKey(theKeyAlias, theKeyPassword.toCharArray());
		} catch (UnrecoverableKeyException e) {
			ourLog.debug("Failed to recover key", e);
			return false;
		} catch (KeyStoreException e) {
			ourLog.debug("Failed to recover key", e);
			return false;
		} catch (NoSuchAlgorithmException e) {
			ourLog.debug("Failed to recover key", e);
			return false;
		}
		
		if (key == null) {
			ourLog.debug("Key is null");
			return false;
		} else if (!(key instanceof PrivateKey)) {
			ourLog.debug("Key is of type: {}", key.getClass());
			return false;
		}
		
		return true;
	}

	/**
	 * Returns <code>true</code> if the key can be recovered using the given password
	 */
	public static boolean canRecoverKey(KeyStore theKeystore, String theKeyAlias, String theKeyPassword) {
		Validate.notNull(theKeystore, "Keystore");
		Validate.notBlank(theKeyAlias, "Key Alias");
		Validate.notNull(theKeyPassword, "Key Password");

		try {
			Key key = theKeystore.getKey(theKeyAlias, theKeyPassword.toCharArray());
			return key != null;
		} catch (UnrecoverableKeyException e) {
			ourLog.debug("Failed to recover key", e);
			return false;
		} catch (KeyStoreException e) {
			ourLog.debug("Failed to recover key", e);
			return false;
		} catch (NoSuchAlgorithmException e) {
			ourLog.debug("Failed to recover key", e);
			return false;
		}
		
	}

}
