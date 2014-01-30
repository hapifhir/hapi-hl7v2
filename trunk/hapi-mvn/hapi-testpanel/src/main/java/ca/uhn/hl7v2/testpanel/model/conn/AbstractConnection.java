/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.model.conn;

import static org.apache.commons.lang.StringUtils.*;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.SwingUtilities;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialClientCallback;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSigner;
import ca.uhn.hl7v2.hoh.sockets.CustomCertificateTlsSocketFactory;
import ca.uhn.hl7v2.hoh.sockets.TlsSocketFactory;
import ca.uhn.hl7v2.hoh.util.HapiSocketTlsFactoryWrapper;
import ca.uhn.hl7v2.hoh.util.KeystoreUtils;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.ExtendedMinLowerLayerProtocol;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.api.WorkingStatusBean;
import ca.uhn.hl7v2.testpanel.controller.Controller;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.model.ActivityBase;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingBytes;
import ca.uhn.hl7v2.testpanel.model.ActivityInfo;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingBytes;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.util.CollectionUtils;
import ca.uhn.hl7v2.testpanel.util.llp.ByteCapturingMinLowerLayerProtocolWrapper;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractConnection")
public abstract class AbstractConnection extends AbstractModelClass implements IDestroyable {
	public static final String HOH_SIGNATURE_KEYSTORE_STATUS = AbstractConnection.class.getName() + "_HOH_SIGNATURE_KEYSTORE_STATUS";
	public static final String HOH_SIGNER_AVAILABLE_ALIASES_PROPERTY = AbstractConnection.class.getName() + "_HOH_SIGNER_AVAILABLE_ALIASES";
	public static final String NAME_PROPERTY = AbstractConnection.class.getName() + "_NAME";
	public static final String NEW_MESSAGES_PROPERTY = InboundConnection.class.getName() + "_NEW_MESSAGES_PROP";
	private static final Logger ourLog = LoggerFactory.getLogger(AbstractConnection.class);
	public static final String PERSISTENT_PROPERTY = AbstractConnection.class.getName() + "_PERSISTENT";
	public static final String RECENT_ACTIVITY_PROPERTY = AbstractConnection.class.getName() + "_RECENT_ACTIVITY";
	public static final String STATUS_LINE_PROPERTY = AbstractConnection.class.getName() + "_STATUS_LINE";
	public static final String STATUS_PROPERTY = AbstractConnection.class.getName() + "_STATUS";
	public static final String TLS_KEYSTORE_STATUS = AbstractConnection.class.getName() + "_TLS_KEYSTORE_STATUS";
	public static final String TRANSPORT_PROPERTY = AbstractConnection.class.getName() + "_TRANSPORT";

	@XmlAttribute(required = true)
	private boolean myCaptureBytes;

	@XmlAttribute(required = true)
	private String myCharSet;

	private transient Controller myController;

	@XmlAttribute(required = true)
	private boolean myDetectCharSetInMessage;

	@XmlAttribute(required = true)
	private boolean myDualPort;

	@XmlAttribute(required = true)
	private Hl7V2EncodingTypeEnum myEncoding;

	@XmlAttribute(name = "hoh_authentication")
	private boolean myHohAuthenticationEnabled;

	@XmlAttribute(name = "hoh_auth_pass")
	private String myHohAuthenticationPassword;

	@XmlAttribute(name = "hoh_auth_user")
	private String myHohAuthenticationUsername;

	private boolean myHohSecurityKeystoreCheckIsScheduled;

	private transient List<String> myHohSignatureAvailableAliases;

	@XmlAttribute(name = "hoh_signature_enabled")
	private boolean myHohSignatureEnabled;
	@XmlAttribute(name = "hoh_signature_key")
	private String myHohSignatureKey;

	@XmlAttribute(name = "hoh_signature_key_password")
	private String myHohSignatureKeyPassword;

	@XmlAttribute(name = "hoh_signature_keystore")
	private String myHohSignatureKeystore;
	private transient KeyStore myHohSignatureKeystore_;
	private boolean myHohSignatureKeystoreCheckIsScheduled;
	@XmlAttribute(name = "hoh_signature_keystore_password")
	private String myHohSignatureKeystorePassword;
	private WorkingStatusBean myHohSignatureKeystoreStatus;
	@XmlAttribute(required = true)
	private String myHost;
	@XmlAttribute(name = "httpUriPath", required = false)
	private String myHttpUriPath;
	@XmlAttribute(required = true)
	private String myId;
	@XmlAttribute(required = true)
	private int myIncomingOrSinglePort;
	@XmlAttribute(required = true)
	private String myName;

	@XmlAttribute(required = true)
	private boolean myNameIsExplicitlySet;

	private transient int myNewMessages;

	@XmlAttribute(required = true)
	private int myOutgoingPort;

	@XmlAttribute(required = true)
	private boolean myPersistent;

	private transient ByteArrayOutputStream myReaderCapture = new ByteArrayOutputStream();

	private transient List<ActivityBase> myRecentActivity = new ArrayList<ActivityBase>();

	private transient StatusEnum myStatus = StatusEnum.STOPPED;

	private transient String myStatusLine;

	private transient StreamWatcherThread myStreamWatcherThread;

	@XmlAttribute(required = true)
	private boolean myTls;

	private transient KeyStore myTlsKeystore;

	@XmlAttribute(required = false)
	private String myTlsKeystoreLocation;

	@XmlAttribute(required = false)
	private String myTlsKeystorePassword;
	private transient WorkingStatusBean myTlsKeystoreStatus;
	@XmlAttribute(name = "transport", required = true)
	private TransportStyleEnum myTransport;
	private transient ByteArrayOutputStream myWriterCapture = new ByteArrayOutputStream();

	public AbstractConnection() {
		myId = UUID.randomUUID().toString();
	}

	protected void addActivity(ActivityBase theActivity) {
		myRecentActivity.add(theActivity);
		if (myRecentActivity.size() > 100) {
			myRecentActivity.remove(0);
		}
		firePropertyChange(RECENT_ACTIVITY_PROPERTY, null, null);
	}

	SocketFactory getSocketFactory() {
		return new SocketFactory() {

			@Override
			public Socket createTlsSocket() throws IOException {
				try {
					if (getTransport() == TransportStyleEnum.HL7_OVER_HTTP && getTlsKeystore() != null) {
						return createHohSocketFactory().createClientSocket();
					}
				} catch (KeyStoreException e) {
					throw new IOException(e.getMessage(), e);
				}
				return SSLSocketFactory.getDefault().createSocket();
			}

			@Override
			public ServerSocket createTlsServerSocket() throws IOException {
				try {
					if (getTransport() == TransportStyleEnum.HL7_OVER_HTTP && getHohSignatureKeystore_() != null) {
						return createHohSocketFactory().createServerSocket();
					}
				} catch (KeyStoreException e) {
					throw new IOException(e.getMessage(), e);
				}
				return SSLServerSocketFactory.getDefault().createServerSocket();
			}

			private CustomCertificateTlsSocketFactory createHohSocketFactory() throws KeyStoreException {
				KeyStore keystore = getTlsKeystore();
				String keystorePassword = getTlsKeystorePassword();
				CustomCertificateTlsSocketFactory sf = new CustomCertificateTlsSocketFactory(keystore, keystorePassword);
				return sf;
			}

			@Override
			public Socket createSocket() throws IOException {
				return javax.net.SocketFactory.getDefault().createSocket();
			}

			@Override
			public ServerSocket createServerSocket() throws IOException {
				return ServerSocketFactory.getDefault().createServerSocket();
			}

			@Override
			public void configureNewAcceptedSocket(Socket theSocket) throws SocketException {
				// nothing
			}
		};
	}

	public void addNewMessage() {
		int oldValue = myNewMessages;
		int newValue = myNewMessages + 1;

		try {
			fireVetoableChange(NEW_MESSAGES_PROPERTY, oldValue, newValue);
		} catch (PropertyVetoException e) {
			ourLog.debug("Property {} vetoed", NEW_MESSAGES_PROPERTY);
			return;
		}

		myNewMessages = newValue;
		firePropertyChange(NEW_MESSAGES_PROPERTY, oldValue, myNewMessages);
	}

	protected void beforeProcessingNewMessageIn() {
		if (isCaptureBytes()) {
			checkInboundCapture();
		}
	}

	protected void beforeProcessingNewMessageOut() {
		if (isCaptureBytes()) {
			checkOutboundCapture();
		}
	}

	private void checkInboundCapture() {
		synchronized (myReaderCapture) {
			byte[] inboundBytes = myReaderCapture.toByteArray();
			if (inboundBytes.length > 0) {
				addActivity(new ActivityIncomingBytes(new Date(), inboundBytes));
				myReaderCapture.reset();
			}
		}
	}

	protected void addActivityInfoInSwingThread(final String msg) {
		final ActivityBase activity = new ActivityInfo(new Date(), msg);
		addActivityInSwingThread(activity);
	}

	protected void addActivityInSwingThread(final ActivityBase theActivity) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				addActivity(theActivity);
			}
		});
	}

	private void checkOutboundCapture() {
		synchronized (myWriterCapture) {
			byte[] outboundBytes = myWriterCapture.toByteArray();
			if (outboundBytes.length > 0) {
				addActivity(new ActivityOutgoingBytes(new Date(), outboundBytes));
				myWriterCapture.reset();
			}
		}
	}

	public void clearNewMessages() {
		int oldValue = myNewMessages;

		try {
			fireVetoableChange(NEW_MESSAGES_PROPERTY, oldValue, 0);
		} catch (PropertyVetoException e) {
			ourLog.debug("Property {} vetoed", NEW_MESSAGES_PROPERTY);
			return;
		}

		myNewMessages = 0;
		firePropertyChange(NEW_MESSAGES_PROPERTY, oldValue, myNewMessages);
	}

	/**
	 * Remove all entries from the recent activity list
	 */
	public void clearRecentActivity() {
		myRecentActivity.clear();
		firePropertyChange(RECENT_ACTIVITY_PROPERTY, null, null);
	}

	protected String createDescription() {
		StringBuilder retVal = new StringBuilder();
		if (StringUtils.isNotBlank(myHost)) {
			retVal.append(myHost);
		} else {
			retVal.append("Unknown");
		}

		retVal.append(":");
		if (myIncomingOrSinglePort > 0) {
			retVal.append(myIncomingOrSinglePort);
		} else {
			retVal.append("Unknown");
		}

		if (myOutgoingPort > 0) {
			retVal.append(":");
			retVal.append(myOutgoingPort);
		}
		String name = retVal.toString();
		return name;
	}

	protected LowerLayerProtocol createLlp() throws LLPException {
		LowerLayerProtocol llpClass;
		if (getTransport() == TransportStyleEnum.HL7_OVER_HTTP) {

			ServerRoleEnum role = isInbound() ? ServerRoleEnum.SERVER : ServerRoleEnum.CLIENT;
			Hl7OverHttpLowerLayerProtocol hohLlp = new Hl7OverHttpLowerLayerProtocol(role);
			if (isHohAuthenticationEnabled()) {
				if (isInbound()) {
					hohLlp.setAuthorizationCallback(new SingleCredentialServerCallback(getHohAuthenticationUsername(), getHohAuthenticationPassword()));
				} else {
					hohLlp.setAuthorizationCallback(new SingleCredentialClientCallback(getHohAuthenticationUsername(), getHohAuthenticationPassword()));
				}
			}
			if (isHohSignatureEnabled()) {
				BouncyCastleCmsMessageSigner signer = new BouncyCastleCmsMessageSigner();
				try {
					signer.setKeyStore(getHohSignatureKeystore_());
				} catch (KeyStoreException e) {
					throw new LLPException(e.getMessage(), e);
				}
				signer.setKeyAlias(getHohSignatureKey());
				signer.setAliasPassword(getHohSignatureKeyPassword());
				hohLlp.setSigner(signer);
			}
			hohLlp.setUriPath(getHttpUriPath());

			llpClass = hohLlp;
		} else if (isDetectCharSetInMessage()) {
			llpClass = new ExtendedMinLowerLayerProtocol();
		} else {
			MinLowerLayerProtocol llp = new MinLowerLayerProtocol();
			llp.setCharset(Charset.forName(getCharSet()));
			llpClass = llp;
		}

		if (isCaptureBytes()) {
			llpClass = new ByteCapturingMinLowerLayerProtocolWrapper(llpClass, myReaderCapture, myWriterCapture);
		}

		return llpClass;
	}

	protected HapiContext createHapiContext() throws IOException {
		try {

			SocketFactory serverSocket;
			if (!isTls()) {
				serverSocket = new ca.uhn.hl7v2.util.StandardSocketFactory();
			} else if (getTlsKeystore() == null) {
				serverSocket = new HapiSocketTlsFactoryWrapper(new TlsSocketFactory());
			} else {
				serverSocket = new HapiSocketTlsFactoryWrapper(new CustomCertificateTlsSocketFactory(getTlsKeystore(), getTlsKeystorePassword()));
			}

			HapiContext ctx = new DefaultHapiContext(new NoValidationBuilder());
			ctx.setLowerLayerProtocol(createLlp());
			ctx.setSocketFactory(serverSocket);
			
			if (getEncoding() == Hl7V2EncodingTypeEnum.ER_7) {
				ctx.getGenericParser().setPipeParserAsPrimary();
			} else {
				ctx.getGenericParser().setXMLParserAsPrimary();
			}

			return ctx;

		} catch (Exception e) {
			throw new IOException(e.getMessage(), e);
		}
	}

	protected Parser createParser() {
		Parser parser;
		if (getEncoding() == Hl7V2EncodingTypeEnum.ER_7) {
			parser = new PipeParser();
		} else {
			parser = new DefaultXMLParser();
		}
		parser.setValidationContext(new ValidationContextImpl());
		return parser;
	}

	public void destroy() {
		stop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object theObj) {
		return (theObj instanceof AbstractConnection) && ((AbstractConnection) theObj).myId.equals(myId);
	}

	/**
	 * @return the charSet
	 */
	public String getCharSet() {
		return myCharSet;
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return myController;
	}

	/**
	 * @return the encoding
	 */
	public Hl7V2EncodingTypeEnum getEncoding() {
		return myEncoding;
	}

	/**
	 * @return the hohAuthenticationPassword
	 */
	public String getHohAuthenticationPassword() {
		return myHohAuthenticationPassword;
	}

	/**
	 * @return the hohAuthenticationUsername
	 */
	public String getHohAuthenticationUsername() {
		return myHohAuthenticationUsername;
	}

	/**
	 * @return the hohSignatureAvailableAliases
	 */
	public List<String> getHohSignatureAvailableAliases() {
		List<String> retVal;
		if (myHohSignatureAvailableAliases != null) {
			retVal = myHohSignatureAvailableAliases;
		} else {
			retVal = Collections.emptyList();
		}
		return retVal;
	}

	/**
	 * @return the hohSignatureKey
	 */
	public String getHohSignatureKey() {
		return myHohSignatureKey;
	}

	/**
	 * @return the hohSignatureKeyPassword
	 */
	public String getHohSignatureKeyPassword() {
		return myHohSignatureKeyPassword;
	}

	/**
	 * @return the hohSignatureKeystore
	 */
	public String getHohSignatureKeystore() {
		return myHohSignatureKeystore;
	}

	/**
	 * TODO: rename
	 */
	public KeyStore getHohSignatureKeystore_() throws KeyStoreException {
		if (isBlank(getHohSignatureKeystore())) {
			return null;
		}
		if (myHohSignatureKeystore_ != null) {
			return myHohSignatureKeystore_;
		}

		File jksFile = new File(getHohSignatureKeystore());
		if (!jksFile.exists() || !jksFile.canRead()) {
			throw new KeyStoreException("File does not exist or can not be read: " + jksFile.getAbsolutePath());
		}

		char[] password = null;
		if (isNotBlank(myHohSignatureKeystorePassword)) {
			password = myHohSignatureKeystorePassword.toCharArray();
		}

		KeyStore keystore;
		try {
			keystore = KeystoreUtils.loadKeystore(jksFile, password);
		} catch (NoSuchAlgorithmException e) {
			ourLog.error("Failed to load keystore!", e);
			throw new KeyStoreException("Failed to load keystore: " + e.getMessage());
		} catch (CertificateException e) {
			ourLog.error("Failed to load keystore!", e);
			throw new KeyStoreException("Failed to load keystore: " + e.getMessage());
		} catch (IOException e) {
			ourLog.error("Failed to load keystore!", e);
			if (e.getCause() instanceof UnrecoverableKeyException) {
				throw new KeyStoreException("Keystore password appears to be incorrect");
			}
			throw new KeyStoreException("Failed to load keystore: " + e.getMessage());
		}

		if (this instanceof InboundConnection) {
			if (!KeystoreUtils.validateKeystoreForSignatureVerifying(keystore)) {
				throw new KeyStoreException("Keystore contains no keys appropriate for receiving data");
			}
		} else if (this instanceof OutboundConnection) {
			if (!KeystoreUtils.validateKeystoreForSignatureSigning(keystore)) {
				throw new KeyStoreException("Keystore contains no keys appropriate for receiving data");
			}
		}

		myHohSignatureKeystore_ = keystore;
		return myHohSignatureKeystore_;
	}

	/**
	 * @return the hohSignatureKeystorePassword
	 */
	public String getHohSignatureKeystorePassword() {
		return myHohSignatureKeystorePassword;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return myHost;
	}

	/**
	 * @return the httpUriPath
	 */
	public String getHttpUriPath() {
		return myHttpUriPath;
	}

	public String getId() {
		return myId;
	}

	/**
	 * @return the incomingOrSinglePort
	 */
	public int getIncomingOrSinglePort() {
		return myIncomingOrSinglePort;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		updateName();
		return myName;
	}

	/**
	 * @return the newMessages
	 */
	public int getNewMessages() {
		return myNewMessages;
	}

	/**
	 * @return the outgoingPort
	 */
	public int getOutgoingPort() {
		return myOutgoingPort;
	}

	/**
	 * @return the recentActivity
	 */
	public List<ActivityBase> getRecentActivity() {
		return myRecentActivity;
	}

	@SuppressWarnings("unchecked")
	public <T extends ActivityBase> List<T> getRecentActivityEntriesOfType(Class<T> theClass) {
		ArrayList<T> retVal = new ArrayList<T>();
		for (Object next : getRecentActivity()) {
			if (theClass.isAssignableFrom(next.getClass())) {
				retVal.add((T) next);
			}
		}
		return retVal;
	}

	/**
	 * @return the status
	 */
	public StatusEnum getStatus() {
		return myStatus;
	}

	/**
	 * @return the statusLine
	 */
	public String getStatusLine() {
		return myStatusLine;
	}

	public KeyStore getTlsKeystore() throws KeyStoreException {
		if (isBlank(myTlsKeystoreLocation) || isTls() == false) {
			return null;
		}
		if (myTlsKeystore != null) {
			return myTlsKeystore;
		}

		File jksFile = new File(myTlsKeystoreLocation);
		if (!jksFile.exists() || !jksFile.canRead()) {
			throw new KeyStoreException("File does not exist or can not be read: " + jksFile.getAbsolutePath());
		}

		char[] password = null;
		if (isNotBlank(myTlsKeystorePassword)) {
			password = myTlsKeystorePassword.toCharArray();
		}

		KeyStore keystore;
		try {
			keystore = KeystoreUtils.loadKeystore(jksFile, password);
		} catch (NoSuchAlgorithmException e) {
			ourLog.error("Failed to load keystore!", e);
			throw new KeyStoreException("Failed to load keystore: " + e.getMessage());
		} catch (CertificateException e) {
			ourLog.error("Failed to load keystore!", e);
			throw new KeyStoreException("Failed to load keystore: " + e.getMessage());
		} catch (IOException e) {
			ourLog.error("Failed to load keystore!", e);
			if (e.getCause() instanceof UnrecoverableKeyException) {
				throw new KeyStoreException("Keystore password appears to be incorrect");
			}
			throw new KeyStoreException("Failed to load keystore: " + e.getMessage());
		}

		if (this instanceof InboundConnection) {
			if (!KeystoreUtils.validateKeystoreForTlsReceiving(keystore)) {
				throw new KeyStoreException("Keystore contains no keys appropriate for receiving data");
			}
		} else if (this instanceof OutboundConnection) {
			if (!KeystoreUtils.validateKeystoreForTlsSending(keystore)) {
				throw new KeyStoreException("Keystore contains no keys appropriate for receiving data");
			}
		}

		myTlsKeystore = keystore;
		return myTlsKeystore;
	}

	/**
	 * @return the tlsKeystoreLocation
	 */
	public String getTlsKeystoreLocation() {
		return myTlsKeystoreLocation;
	}

	/**
	 * @return the tlsKeystorePassword
	 */
	public String getTlsKeystorePassword() {
		return myTlsKeystorePassword;
	}

	/**
	 * @return the transport
	 */
	public TransportStyleEnum getTransport() {
		if (myTransport == null) {
			if (myDualPort) {
				myTransport = TransportStyleEnum.DUAL_PORT_MLLP;
			} else {
				myTransport = TransportStyleEnum.SINGLE_PORT_MLLP;
			}
		}
		return myTransport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return myId.hashCode();
	}

	/**
	 * @return the captureBytes
	 */
	public boolean isCaptureBytes() {
		return myCaptureBytes;
	}

	/**
	 * @return the detectCharSetInMessage
	 */
	public boolean isDetectCharSetInMessage() {
		return myDetectCharSetInMessage;
	}

	/**
	 * @return the dualPort
	 */
	public boolean isDualPort() {
		return myDualPort;
	}

	/**
	 * @return the hohAuthenticationEnabled
	 */
	public boolean isHohAuthenticationEnabled() {
		return myHohAuthenticationEnabled;
	}

	/**
	 * @return the hohSignatureEnabled
	 */
	public boolean isHohSignatureEnabled() {
		return myHohSignatureEnabled;
	}

	private boolean isInbound() {
		return this instanceof InboundConnection;
	}

	/**
	 * @return the nameIsExplicitlySet
	 */
	public boolean isNameIsExplicitlySet() {
		return myNameIsExplicitlySet;
	}

	/**
	 * @return the persistent
	 */
	public boolean isPersistent() {
		return myPersistent;
	}

	/**
	 * @return the tls
	 */
	public boolean isTls() {
		return myTls;
	}

	private void scheduleHohSecurityKeystoreCheck() {
		synchronized (this) {
			if (myHohSecurityKeystoreCheckIsScheduled == false) {
				setTlsKeystoreStatus(new WorkingStatusBean("Working...", WorkingStatusBean.StatusEnum.WORKING));
			}
			myHohSecurityKeystoreCheckIsScheduled = true;
			if (myController != null) {
				myController.invokeInBackground(new CheckHohSecurityKeystoreRunnable());
			}
		}
	}

	private void scheduleHohSignatureKeystoreCheck() {
		synchronized (this) {
			if (myHohSignatureKeystoreCheckIsScheduled == false) {
				setHohSignatureKeystoreStatus(new WorkingStatusBean("Working...", WorkingStatusBean.StatusEnum.WORKING));
			}
			myHohSignatureKeystoreCheckIsScheduled = true;
			if (myController != null) {
				myController.invokeInBackground(new CheckHohSignatureKeystoreRunnable());
			}
		}
	}

	/**
	 * @param theCaptureBytes
	 *            the captureBytes to set
	 */
	public void setCaptureBytes(boolean theCaptureBytes) {
		myCaptureBytes = theCaptureBytes;
	}

	/**
	 * @param theCharSet
	 *            the charSet to set
	 */
	public void setCharSet(String theCharSet) {
		myCharSet = theCharSet;
	}

	/**
	 * @param theController
	 *            the controller to set
	 */
	public void setController(Controller theController) {
		myController = theController;
		scheduleHohSecurityKeystoreCheck();
		scheduleHohSignatureKeystoreCheck();
	}

	/**
	 * @param theDetectCharSetInMessage
	 *            the detectCharSetInMessage to set
	 */
	public void setDetectCharSetInMessage(boolean theDetectCharSetInMessage) {
		myDetectCharSetInMessage = theDetectCharSetInMessage;
	}

	/**
	 * @param theDualPort
	 *            the dualPort to set
	 */
	public void setDualPort(boolean theDualPort) {
		myDualPort = theDualPort;
		updateName();
	}

	/**
	 * @param theEncoding
	 *            the encoding to set
	 */
	public void setEncoding(Hl7V2EncodingTypeEnum theEncoding) {
		myEncoding = theEncoding;
	}

	/**
	 * @param theHohAuthenticationEnabled
	 *            the hohAuthenticationEnabled to set
	 */
	public void setHohAuthenticationEnabled(boolean theHohAuthenticationEnabled) {
		myHohAuthenticationEnabled = theHohAuthenticationEnabled;
	}

	/**
	 * @param theHohAuthenticationPassword
	 *            the hohAuthenticationPassword to set
	 */
	public void setHohAuthenticationPassword(String theHohAuthenticationPassword) {
		myHohAuthenticationPassword = theHohAuthenticationPassword;
	}

	/**
	 * @param theHohAuthenticationUsername
	 *            the hohAuthenticationUsername to set
	 */
	public void setHohAuthenticationUsername(String theHohAuthenticationUsername) {
		myHohAuthenticationUsername = theHohAuthenticationUsername;
	}

	/**
	 * @param theList
	 *            the hohSignatureAvailableAliases to set
	 */
	public void setHohSignatureAvailableAliases(List<String> theList) {
		List<String> oldValue = myHohSignatureAvailableAliases;
		myHohSignatureAvailableAliases = theList;
		firePropertyChange(HOH_SIGNER_AVAILABLE_ALIASES_PROPERTY, oldValue, theList);
	}

	/**
	 * @param theHohSignatureEnabled
	 *            the hohSignatureEnabled to set
	 */
	public void setHohSignatureEnabled(boolean theHohSignatureEnabled) {
		myHohSignatureEnabled = theHohSignatureEnabled;
		scheduleHohSignatureKeystoreCheck();
	}

	/**
	 * @param theHohSignatureKey
	 *            the hohSignatureKey to set
	 */
	public void setHohSignatureKey(String theHohSignatureKey) {
		myHohSignatureKey = theHohSignatureKey;
		scheduleHohSignatureKeystoreCheck();
	}

	/**
	 * @param theHohSignatureKeyPassword
	 *            the hohSignatureKeyPassword to set
	 */
	public void setHohSignatureKeyPassword(String theHohSignatureKeyPassword) {
		myHohSignatureKeyPassword = theHohSignatureKeyPassword;
		scheduleHohSignatureKeystoreCheck();
	}

	/**
	 * @param theHohSignatureKeystore
	 *            the hohSignatureKeystore to set
	 */
	public void setHohSignatureKeystore(String theHohSignatureKeystore) {
		myHohSignatureKeystore = theHohSignatureKeystore;
		scheduleHohSignatureKeystoreCheck();
	}

	/**
	 * @param theHohSignatureKeystorePassword
	 *            the hohSignatureKeystorePassword to set
	 */
	public void setHohSignatureKeystorePassword(String theHohSignatureKeystorePassword) {
		myHohSignatureKeystorePassword = theHohSignatureKeystorePassword;
		scheduleHohSignatureKeystoreCheck();
	}

	private void setHohSignatureKeystoreStatus(final WorkingStatusBean theStatusBean) {
		final WorkingStatusBean oldValue = myHohSignatureKeystoreStatus;
		myHohSignatureKeystoreStatus = theStatusBean;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				firePropertyChange(HOH_SIGNATURE_KEYSTORE_STATUS, oldValue, theStatusBean);
			}
		});
	}

	/**
	 * @param theHost
	 *            the host to set
	 */
	public void setHost(String theHost) {
		myHost = theHost;
		updateName();
	}

	/**
	 * @param theHttpUriPath
	 *            the httpUriPath to set
	 */
	public void setHttpUriPath(String theHttpUriPath) {
		myHttpUriPath = theHttpUriPath;
	}

	/**
	 * @param theIncomingOrSinglePort
	 *            the incomingOrSinglePort to set
	 */
	public void setIncomingOrSinglePort(int theIncomingOrSinglePort) {
		myIncomingOrSinglePort = theIncomingOrSinglePort;
		updateName();
	}

	/**
	 * @param theName
	 *            the name to set
	 */
	public void setName(String theName) {
		String oldValue = myName;
		myName = theName;
		firePropertyChange(NAME_PROPERTY, oldValue, myName);
	}

	/**
	 * @param theName
	 *            the name to set
	 */
	public void setNameExplicitly(String theName) {
		if (theName == null) {
			return;
		}
		String oldValue = myName;
		myName = theName;
		if (StringUtils.equals(oldValue, theName) == false) {
			myNameIsExplicitlySet = true;
		}
		firePropertyChange(NAME_PROPERTY, oldValue, myName);
	}

	/**
	 * @param theNameIsExplicitlySet
	 *            the nameIsExplicitlySet to set
	 */
	public void setNameIsExplicitlySet(boolean theNameIsExplicitlySet) {
		myNameIsExplicitlySet = theNameIsExplicitlySet;
	}

	/**
	 * @param theOutgoingPort
	 *            the outgoingPort to set
	 */
	public void setOutgoingPort(int theOutgoingPort) {
		myOutgoingPort = theOutgoingPort;
	}

	/**
	 * @param thePersistent
	 *            the persistent to set
	 */
	public void setPersistent(boolean thePersistent) {
		boolean oldValue = myPersistent;
		myPersistent = thePersistent;
		firePropertyChange(PERSISTENT_PROPERTY, oldValue, myPersistent);
	}

	protected void setStatus(StatusEnum theTryingToStart) {
		StatusEnum oldValue = myStatus;
		myStatus = theTryingToStart;
		firePropertyChange(STATUS_PROPERTY, oldValue, myStatus);
	}

	/**
	 * @param theStatusLine
	 *            the statusLine to set
	 */
	public void setStatusLine(String theStatusLine) {
		String oldValue = myStatusLine;
		myStatusLine = theStatusLine;
		firePropertyChange(STATUS_LINE_PROPERTY, oldValue, theStatusLine);
	}

	public void setTls(boolean theSelected) {
		boolean oldValue = myTls;
		myTls = theSelected;
		if (oldValue != myTls) {
			myTlsKeystore = null;
		}
	}

	public void setTlsKeystoreLocation(String theTlsKeystoreLocation) {
		String oldValue = myTlsKeystoreLocation;
		myTlsKeystoreLocation = theTlsKeystoreLocation;
		if (StringUtils.equals(oldValue, theTlsKeystoreLocation) == false) {
			myTlsKeystore = null;
		}
		scheduleHohSecurityKeystoreCheck();
	}

	public void setTlsKeystorePassword(String theTlsKeystorePassword) {
		String oldValue = myTlsKeystorePassword;
		myTlsKeystorePassword = theTlsKeystorePassword;
		if (StringUtils.equals(oldValue, theTlsKeystorePassword) == false) {
			myTlsKeystore = null;
		}
		scheduleHohSecurityKeystoreCheck();
	}

	private void setTlsKeystoreStatus(final WorkingStatusBean theStatusBean) {
		final WorkingStatusBean oldValue = myTlsKeystoreStatus;
		myTlsKeystoreStatus = theStatusBean;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				firePropertyChange(TLS_KEYSTORE_STATUS, oldValue, theStatusBean);
			}
		});
	}

	/**
	 * @param theTransport
	 *            the transport to set
	 */
	public void setTransport(TransportStyleEnum theTransport) {
		TransportStyleEnum oldValue = myTransport;
		myTransport = theTransport;
		firePropertyChange(TRANSPORT_PROPERTY, oldValue, myTransport);
	}

	public void start() {
		if (isCaptureBytes()) {
			myStreamWatcherThread = new StreamWatcherThread();
			myStreamWatcherThread.start();
		}
	}

	public void stop() {
		if (myStreamWatcherThread != null) {
			StreamWatcherThread streamWatcherThread = myStreamWatcherThread;
			myStreamWatcherThread = null;
			streamWatcherThread.interrupt();
		}
	}

	private void updateName() {
		if (myName != null && isNameIsExplicitlySet()) {
			return;
		}

		String name = createDescription();
		setName(name);
	}

	private final class CheckHohSecurityKeystoreRunnable implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// wait a bit
			}

			synchronized (AbstractConnection.this) {
				if (!myHohSecurityKeystoreCheckIsScheduled) {
					return;
				}
				myHohSecurityKeystoreCheckIsScheduled = false;
			}

			KeyStore keystore;
			try {
				keystore = getTlsKeystore();
				if (keystore == null) {
					if (isTls()) {
						setTlsKeystoreStatus(new WorkingStatusBean("Using system keystore", WorkingStatusBean.StatusEnum.OK));
					} else {
						setTlsKeystoreStatus(new WorkingStatusBean("", WorkingStatusBean.StatusEnum.OK));
					}
				} else {
					setTlsKeystoreStatus(new WorkingStatusBean("Keystore appears good", WorkingStatusBean.StatusEnum.OK));
				}
			} catch (KeyStoreException e) {
				ourLog.error("Keystore problem", e);
				setTlsKeystoreStatus(new WorkingStatusBean(e.getMessage(), WorkingStatusBean.StatusEnum.ERROR));
			}
		}

	}

	private final class CheckHohSignatureKeystoreRunnable implements Runnable {
		@Override
		public void run() {

			if (!isHohSignatureEnabled()) {
				setHohSignatureKeystoreStatus(new WorkingStatusBean("", WorkingStatusBean.StatusEnum.OK));
				return;
			}

			if (isBlank(getHohSignatureKeystore())) {
				setHohSignatureKeystoreStatus(new WorkingStatusBean("Select a KeyStore", WorkingStatusBean.StatusEnum.ERROR));
				return;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// wait a bit
			}

			synchronized (AbstractConnection.this) {
				if (!myHohSignatureKeystoreCheckIsScheduled) {
					return;
				}
				myHohSignatureKeystoreCheckIsScheduled = false;
			}

			KeyStore keystore;
			try {
				keystore = getHohSignatureKeystore_();
				if (keystore == null) {
					setHohSignatureKeystoreStatus(new WorkingStatusBean("No keystore selected", WorkingStatusBean.StatusEnum.ERROR));
					setHohSignatureAvailableAliases(new ArrayList<String>());
				} else {

					List<String> aliases = CollectionUtils.enumerationToList(keystore.aliases());
					if (aliases.size() > 0) {
						if (isBlank(myHohSignatureKey)) {
							myHohSignatureKey = aliases.get(0);
						}
					} else {
						setHohSignatureKeystoreStatus(new WorkingStatusBean("Keystore contains no suitable keys/aliases", WorkingStatusBean.StatusEnum.ERROR));
						return;
					}

					setHohSignatureAvailableAliases(aliases);

					if (!isInbound()) {
						if (isBlank(myHohSignatureKeyPassword)) {
							setHohSignatureKeystoreStatus(new WorkingStatusBean("Key password not specified", WorkingStatusBean.StatusEnum.ERROR));
							return;
						}
						if (!KeystoreUtils.canRecoverKey(getHohSignatureKeystore_(), getHohSignatureKey(), getHohSignatureKeyPassword())) {
							setHohSignatureKeystoreStatus(new WorkingStatusBean("Key password is incorrect", WorkingStatusBean.StatusEnum.ERROR));
							return;
						}
						if (!KeystoreUtils.validateKeyForSignatureSigning(getHohSignatureKeystore_(), getHohSignatureKey(), getHohSignatureKeyPassword())) {
							setHohSignatureKeystoreStatus(new WorkingStatusBean("Key is not appropriate for signing", WorkingStatusBean.StatusEnum.ERROR));
							return;
						}
					}

					Certificate cert = keystore.getCertificate(myHohSignatureKey);
					if (cert instanceof X509Certificate) {
						String signer = ((X509Certificate) cert).getSubjectX500Principal().getName();
						setHohSignatureKeystoreStatus(new WorkingStatusBean("Key belongs to: " + signer, WorkingStatusBean.StatusEnum.OK));
					} else {
						setHohSignatureKeystoreStatus(new WorkingStatusBean("Keystore appears good", WorkingStatusBean.StatusEnum.OK));
					}

					// TODO: verify that key alias is usable
					// TODO: verify whether separate key password is needed

				}
			} catch (KeyStoreException e) {
				ourLog.error("Keystore problem", e);
				setHohSignatureKeystoreStatus(new WorkingStatusBean(e.getMessage(), WorkingStatusBean.StatusEnum.ERROR));
				setHohSignatureAvailableAliases(new ArrayList<String>());
			}
		}

	}

	public enum StatusEnum {
		FAILED(false), STARTED(true), STOPPED(false), TRYING_TO_START(true);

		private boolean myRunning;

		private StatusEnum(boolean theRunning) {
			myRunning = theRunning;
		}

		public boolean isRunning() {
			return myRunning;
		}
	}

	private class StreamWatcherThread extends Thread {

		@Override
		public void run() {
			while (myStreamWatcherThread == this) {
				checkInboundCapture();
				checkOutboundCapture();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// ignore
				}
			}
		}

	}

}
