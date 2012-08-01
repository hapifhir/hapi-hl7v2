package ca.uhn.hl7v2.hoh.sign;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSSignerDigestMismatchException;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BouncyCastleCmsMessageSigner implements ISigner {

	private KeyStore myKeyStore;
	private String myKeyAlias;

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

	private String myAliasPassword;
	private PrivateKey myPrivateKey;

	public String sign(byte[] theBytes) throws SignatureFailureException {
		try {
			Security.addProvider(new BouncyCastleProvider());
			CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

			X509Certificate cert = (X509Certificate) myKeyStore.getCertificate(myKeyAlias);
			generator.addSigner(getPrivateKey(), cert, CMSSignedDataGenerator.ENCRYPTION_RSA, CMSSignedDataGenerator.DIGEST_SHA1);
			generator.addCertificatesAndCRLs(getCertStore());
			CMSProcessable content = new CMSProcessableByteArray(theBytes);

			CMSSignedData signedData = generator.generate(content, false, "BC");
			return Base64.encodeBase64String(signedData.getEncoded());

		} catch (Exception e) {
			throw new SignatureFailureException(e);
		}
	}

	private CertStore getCertStore() throws GeneralSecurityException {
		ArrayList<Certificate> list = new ArrayList<Certificate>();
		Certificate[] certificates = myKeyStore.getCertificateChain(this.myKeyAlias);
		for (int i = 0, length = certificates == null ? 0 : certificates.length; i < length; i++) {
			list.add(certificates[i]);
		}
		return CertStore.getInstance("Collection", new CollectionCertStoreParameters(list), "BC");
	}

	private PrivateKey getPrivateKey() throws GeneralSecurityException {
		if (this.myPrivateKey == null) {
			this.myPrivateKey = initalizePrivateKey();
		}
		return this.myPrivateKey;
	}

	private PrivateKey initalizePrivateKey() throws GeneralSecurityException {
		return (PrivateKey) myKeyStore.getKey(myKeyAlias, myAliasPassword.toCharArray());
	}

	public void verify(byte[] theBytes, String theSignature) throws MessageDoesNotVerifyException, SignatureFailureException {
		try {
			CMSProcessable content = new CMSProcessableByteArray(theBytes);
			CMSSignedData s = new CMSSignedData(content, Base64.decodeBase64(theSignature));
			CertStore certs = s.getCertificatesAndCRLs("Collection", "BC");
			SignerInformationStore signers = s.getSignerInfos();
			boolean verified = false;

			for (Iterator i = signers.getSigners().iterator(); i.hasNext();) {
				SignerInformation signer = (SignerInformation) i.next();
				Collection<? extends Certificate> certCollection = certs.getCertificates(signer.getSID());
				if (!certCollection.isEmpty()) {
					X509Certificate cert = (X509Certificate) certCollection.iterator().next();
					try {
						if (signer.verify(cert.getPublicKey(), "BC")) {
							verified = true;
						}
					} catch (CMSSignerDigestMismatchException e) {
						throw new MessageDoesNotVerifyException(e);
					}
				}
			}
		} catch (MessageDoesNotVerifyException e) {
			throw e;
		} catch (Exception e) {
			throw new SignatureFailureException(e);
		}

	}

}
