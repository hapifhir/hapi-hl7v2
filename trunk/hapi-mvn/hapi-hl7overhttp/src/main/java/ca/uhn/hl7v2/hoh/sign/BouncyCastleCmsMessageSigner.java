package ca.uhn.hl7v2.hoh.sign;

import static ca.uhn.hl7v2.hoh.util.StringUtils.*;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSSignerDigestMismatchException;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.SignerInformationVerifier;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;

import ca.uhn.hl7v2.hoh.util.repackage.Base64;

public class BouncyCastleCmsMessageSigner implements ISigner {

	static final String MSG_KEY_IS_NOT_A_PRIVATE_KEY = "Key is not a private key: ";
	static final String MSG_KEY_IS_NOT_A_PUBLIC_KEY = "Key is not a public key: ";
	static final String MSG_KEYSTORE_DOES_NOT_CONTAIN_KEY_WITH_ALIAS = "Keystore does not contain key with alias: ";

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(BouncyCastleCmsMessageSigner.class);

	private String myAlgorithm = "SHA512withRSA";
	private String myAliasPassword;
	private String myKeyAlias;
	private KeyStore myKeyStore;
	private PrivateKey myPrivateKey;
	private PublicKey myPublicKey;

	/**
	 * Constructor
	 */
	public BouncyCastleCmsMessageSigner() {
		super();
	}
	
	private PrivateKey getPrivateKey() throws GeneralSecurityException, SignatureFailureException {
		if (myKeyStore == null) {
			throw new SignatureFailureException("Keystore is not set");
		}
		if (isBlank(myKeyAlias)) {
			throw new SignatureFailureException("Key alias is not set");
		}
		if (isBlank(myAliasPassword)) {
			throw new SignatureFailureException("Key alias password is not set");
		}

		if (this.myPrivateKey == null) {

			myPrivateKey = (PrivateKey) myKeyStore.getKey(myKeyAlias, myAliasPassword.toCharArray());
			if (myPrivateKey == null) {
				if (myKeyStore.containsAlias(myKeyAlias)) {
					if (myKeyStore.isCertificateEntry(myKeyAlias)) {
						throw new SignatureFailureException(MSG_KEY_IS_NOT_A_PRIVATE_KEY + myKeyAlias);
					}
				} else {
					throw new SignatureFailureException(MSG_KEYSTORE_DOES_NOT_CONTAIN_KEY_WITH_ALIAS + myKeyAlias);
				}
			}
		}
		return this.myPrivateKey;
	}

	private PublicKey getPublicKey() throws SignatureFailureException {
		if (myKeyStore == null) {
			throw new SignatureFailureException("Keystore is not set");
		}
		if (isBlank(myKeyAlias)) {
			throw new SignatureFailureException("Key alias is not set");
		}

		if (myPublicKey == null) {
			try {
				Certificate pubCert = myKeyStore.getCertificate(myKeyAlias);
				myPublicKey = pubCert != null ? pubCert.getPublicKey() : null;
				if (myPublicKey == null) {
					if (myKeyStore.containsAlias(myKeyAlias)) {
						if (myKeyStore.isKeyEntry(myKeyAlias)) {
							throw new SignatureFailureException(MSG_KEY_IS_NOT_A_PUBLIC_KEY + myKeyAlias);
						}
					} else {
						throw new SignatureFailureException(MSG_KEYSTORE_DOES_NOT_CONTAIN_KEY_WITH_ALIAS + myKeyAlias);
					}
				}
			} catch (KeyStoreException e) {
				throw new SignatureFailureException("Failed to retrieve key with alias " + myKeyAlias + " from keystore", e);
			}

		}
		return myPublicKey;
	}

	/**
	 * @param theAliasPassword
	 *            the aliasPassword to set
	 */
	public void setAliasPassword(String theAliasPassword) {
		myAliasPassword = theAliasPassword;
	}

	/**
	 * @param theKeyAlias
	 *            the keyAlias to set
	 */
	public void setKeyAlias(String theKeyAlias) {
		myKeyAlias = theKeyAlias;
	}

	/**
	 * @param theKeyStore
	 *            the keyStore to set
	 */
	public void setKeyStore(KeyStore theKeyStore) {
		if (theKeyStore == null) {
			throw new NullPointerException("Keystore can not be null");
		}
		myKeyStore = theKeyStore;
	}

	/**
	 * {@inheritDoc}
	 */
	public String sign(byte[] theBytes) throws SignatureFailureException {
		try {
			Security.addProvider(new BouncyCastleProvider());

			List<X509Certificate> certList = new ArrayList<X509Certificate>();
			CMSTypedData msg = new CMSProcessableByteArray(theBytes);

			X509Certificate signCert = (X509Certificate) myKeyStore.getCertificate(myKeyAlias);
			certList.add(signCert);

			Store certs = new JcaCertStore(certList);

			CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
			ContentSigner sha1Signer = new JcaContentSignerBuilder(myAlgorithm).setProvider("BC").build(getPrivateKey());

			gen.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC").build()).build(sha1Signer, signCert));

			gen.addCertificates(certs);

			CMSSignedData sigData = gen.generate(msg, false);
			return myAlgorithm + ' ' + Base64.encodeBase64String(sigData.getEncoded());
//			return Base64.encodeBase64String(sigData.getEncoded());

		} catch (Exception e) {
			throw new SignatureFailureException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void verify(byte[] theBytes, String theSignature) throws SignatureVerificationException, SignatureFailureException {
		PublicKey pubKey = getPublicKey();

		try {

			int spaceIndex = theSignature.indexOf(' ');
			if (spaceIndex == -1) {
				throw new SignatureVerificationException("No algorithm found in signature block: " + theSignature);
			}

			theSignature = theSignature.substring(spaceIndex + 1);

			CMSProcessable content = new CMSProcessableByteArray(theBytes);
			CMSSignedData s = new CMSSignedData(content, Base64.decodeBase64(theSignature));

			ourLog.debug("Verifying message against public key with alias[{}]", myKeyAlias);

			SignerInformationVerifier vib = new JcaSimpleSignerInfoVerifierBuilder().build(pubKey);

			SignerInformationStore signers = s.getSignerInfos();
			boolean verified = false;

			for (Iterator<?> i = signers.getSigners().iterator(); i.hasNext();) {
				SignerInformation signer = (SignerInformation) i.next();
				try {

					ourLog.debug("Signer: {}", signer.getSID());

					if (signer.verify(vib)) {
						verified = true;
					}
				} catch (CMSSignerDigestMismatchException e) {
					throw new SignatureVerificationException(e);
				}

			}

			if (verified == false) {
				throw new SignatureVerificationException();
			}

		} catch (SignatureVerificationException e) {
			throw e;
		} catch (Exception e) {
			throw new SignatureFailureException(e);
		}

	}

}
