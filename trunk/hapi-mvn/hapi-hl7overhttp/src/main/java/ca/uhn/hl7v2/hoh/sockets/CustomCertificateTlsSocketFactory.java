package ca.uhn.hl7v2.hoh.sockets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 * Socket Factory which creates a TLS/SSL socket using a custom keystore and
 * certificate.
 */
public class CustomCertificateTlsSocketFactory implements ISocketFactory {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(CustomCertificateTlsSocketFactory.class);
	private KeyStore myKeystore;
	private String myKeystoreFilename;
	private String myKeystorePassphrase;
	private String myKeystoreType = "JKS";
	private SSLServerSocketFactory myServerSocketFactory;

	private SSLSocketFactory mySocketFactory = null;

	/**
	 * Constructor
	 */
	public CustomCertificateTlsSocketFactory() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @throws NullPointerException
	 *             If theKeystore is null
	 */
	public CustomCertificateTlsSocketFactory(KeyStore theKeystore, String theKeystorePass) {
		if (theKeystore == null) {
			throw new NullPointerException("KeyStore can not be null");
		}
		myKeystore = theKeystore;
		myKeystorePassphrase = theKeystorePass;
	}

	/**
	 * Constructor
	 * 
	 * @param theKeystoreType
	 *            The keystore type, e.g. "JKS"
	 * @param theKeystoreFilename
	 *            The path to the keystore
	 * @param theKeystorePassphrase
	 *            The password for the keystore
	 */
	public CustomCertificateTlsSocketFactory(String theKeystoreType, String theKeystoreFilename, String theKeystorePassphrase) {
		super();
		myKeystoreType = theKeystoreType;
		myKeystoreFilename = theKeystoreFilename;
		myKeystorePassphrase = theKeystorePassphrase;
	}

	/**
	 * {@inheritDoc}
	 */
	public Socket createClientSocket() throws IOException {
		initialize();
		ourLog.debug("Creating client socket");
		return mySocketFactory.createSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket() throws IOException {
		initialize();
		ourLog.debug("Creating server socket");
		return myServerSocketFactory.createServerSocket();
	}

	private void initialize() throws IOException {
		if (mySocketFactory != null) {
			return;
		}

		try {
			char[] passphrase = myKeystorePassphrase != null ? myKeystorePassphrase.toCharArray() : null;
			if (myKeystore == null) {

				myKeystore = KeyStore.getInstance(myKeystoreType);

				try {
					myKeystore.load(new FileInputStream(myKeystoreFilename), passphrase);
				} catch (IOException e) {
					throw new IOException("Failed to load keystore: " + myKeystoreFilename, e);
				}
			}

			SSLContext ctx = SSLContext.getInstance("TLS");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");

			kmf.init(myKeystore, passphrase);
			tmf.init(myKeystore);
			TrustManager[] trustManagers = tmf.getTrustManagers();
			KeyManager[] keyManagers = kmf.getKeyManagers();
			ctx.init(keyManagers, trustManagers, null);

			mySocketFactory = ctx.getSocketFactory();
			myServerSocketFactory = ctx.getServerSocketFactory();

		} catch (NoSuchAlgorithmException e) {
			throw new IOException("Failed to initialize socket factory: " + e.getMessage(), e);
		} catch (CertificateException e) {
			throw new IOException("Failed to initialize socket factory: " + e.getMessage(), e);
		} catch (FileNotFoundException e) {
			throw new IOException("Failed to initialize socket factory: " + e.getMessage(), e);
		} catch (UnrecoverableKeyException e) {
			throw new IOException("Failed to initialize socket factory: " + e.getMessage(), e);
		} catch (KeyStoreException e) {
			throw new IOException("Failed to initialize socket factory: " + e.getMessage(), e);
		} catch (KeyManagementException e) {
			throw new IOException("Failed to initialize socket factory: " + e.getMessage(), e);
		}

	}

	/**
	 * The filename to load as a keystore
	 */
	public void setKeystoreFilename(String theKeystoreFilename) {
		myKeystoreFilename = theKeystoreFilename;
	}

	/**
	 * The passphrase for the keystore
	 */
	public void setKeystorePassphrase(String theKeystorePassphrase) {
		myKeystorePassphrase = theKeystorePassphrase;
	}

	/**
	 * Sets the keystore type (e.g. JKS, JCEKS)
	 */
	public void setKeystoreType(String theKeystoreType) {
		myKeystoreType = theKeystoreType;
	}

}
