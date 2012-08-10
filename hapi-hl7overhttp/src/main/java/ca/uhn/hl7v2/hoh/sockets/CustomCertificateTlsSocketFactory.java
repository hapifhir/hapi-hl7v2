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
 * Socket Factory which creates a TLS/SSL socket using a custom
 * keystore and certificate.
 */
public class CustomCertificateTlsSocketFactory implements ISocketFactory {

	private String myKeystoreFilename;
	private String myKeystorePassphrase;
	private String myKeystoreType = "JKS";
	private SSLServerSocketFactory myServerSocketFactory;
	private SSLSocketFactory mySocketFactory = null;

	/**
	 * {@inheritDoc}
	 */
	public Socket createClientSocket() throws IOException {
		initialize();
		return mySocketFactory.createSocket();
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket() throws IOException {
		initialize();
		return myServerSocketFactory.createServerSocket();
	}

	private void initialize() throws IOException {
		try {
			SSLContext ctx;
			KeyManagerFactory kmf;
			KeyStore ks;
			TrustManagerFactory tmf;
			char[] passphrase = myKeystorePassphrase.toCharArray();

			ctx = SSLContext.getInstance("TLS");
			kmf = KeyManagerFactory.getInstance("SunX509");
			tmf = TrustManagerFactory.getInstance("SunX509");
			
			ks = KeyStore.getInstance(myKeystoreType);

			try {
				ks.load(new FileInputStream(myKeystoreFilename), passphrase);
			} catch (IOException e) {
				throw new IOException("Failed to load keystore: " + myKeystoreFilename, e);
			}

			kmf.init(ks, passphrase);
			tmf.init(ks);
			TrustManager[] trustManagers = tmf.getTrustManagers();
			KeyManager[] keyManagers = kmf.getKeyManagers();
			ctx.init(keyManagers, trustManagers, null);

			mySocketFactory = ctx.getSocketFactory();
			myServerSocketFactory = ctx.getServerSocketFactory();

		} catch (NoSuchAlgorithmException e) {
			throw new IOException("Failed to initialize socket factory", e);
		} catch (CertificateException e) {
			throw new IOException("Failed to initialize socket factory", e);
		} catch (FileNotFoundException e) {
			throw new IOException("Failed to initialize socket factory", e);
		} catch (UnrecoverableKeyException e) {
			throw new IOException("Failed to initialize socket factory", e);
		} catch (KeyStoreException e) {
			throw new IOException("Failed to initialize socket factory", e);
		} catch (KeyManagementException e) {
			throw new IOException("Failed to initialize socket factory", e);
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
