package ca.uhn.hl7v2.hoh;

import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;

public class StandardMessageSigner implements ISigner {

	private KeyStore myKeyStore;
	private String myKeyAlias;
	private String myAliasPassword;
	private String mySignatureAlgorithm = "SHA512withRSA";
	
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(StandardMessageSigner.class);

	/**
	 * @param theKeyStore
	 *            the keyStore to set
	 */
	public void setKeyStore(KeyStore theKeyStore) {
		myKeyStore = theKeyStore;
	}

	/**
	 * @param theKeyAlias
	 *            the keyAlias to set
	 */
	public void setKeyAlias(String theKeyAlias) {
		myKeyAlias = theKeyAlias;
	}

	/**
	 * @param theAliasPassword
	 *            the aliasPassword to set
	 */
	public void setAliasPassword(String theAliasPassword) {
		myAliasPassword = theAliasPassword;
	}


	/**
	 * {@inheritDoc}
	 */
	public String sign(byte[] theBytes) {

		if (ourLog.isDebugEnabled()) {
			Set<String> signatureAlgorithms = Security.getAlgorithms("Signature");
			ourLog.debug("The following signature algorithms are supported: {}", signatureAlgorithms);
		}
		
		PrivateKey pk;
		try {
			pk = (PrivateKey) myKeyStore.getKey(myKeyAlias, myAliasPassword.toCharArray());
		} catch (UnrecoverableKeyException e) {
			throw new Error("Failed to recover key", e);
		} catch (KeyStoreException e) {
			throw new Error("Failed to recover key", e);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("Failed to recover key", e);
		}

		try {
			Signature signature = Signature.getInstance(mySignatureAlgorithm);
			signature.initSign(pk);
			signature.update(theBytes);
			byte[] signatureValue = signature.sign();
			return mySignatureAlgorithm + " " + Base64.encodeBase64String(signatureValue);
		} catch (NoSuchAlgorithmException e1) {
			throw new Error("Failed to sign", e1);
		} catch (InvalidKeyException e1) {
			throw new Error("Failed to sign", e1);
		} catch (SignatureException e1) {
			throw new Error("Failed to sign", e1);
		}

	}

	public void verify(byte[] theBytes, String theSignature) throws MessageDoesNotVerifyException {

		PublicKey pk;
		try {
			pk = (PublicKey) myKeyStore.getCertificate(myKeyAlias).getPublicKey();
		} catch (KeyStoreException e) {
			throw new Error("Failed to recover key", e);
		}

		String[] signatureParts = theSignature.split(" ");
		byte[] signatureBytes = Base64.decodeBase64(signatureParts[1]);

		try {

			Signature signature = Signature.getInstance(mySignatureAlgorithm);
			signature.initVerify(pk);
			signature.update(theBytes);
			boolean ok = signature.verify(signatureBytes);
			if (ok) {
				return;
			} else {
				throw new MessageDoesNotVerifyException();
			}

		} catch (SignatureException e) {
			throw new Error("Failed to sign", e);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("Failed to sign", e);
		} catch (InvalidKeyException e) {
			throw new Error("Failed to sign", e);
		}

	}
}
