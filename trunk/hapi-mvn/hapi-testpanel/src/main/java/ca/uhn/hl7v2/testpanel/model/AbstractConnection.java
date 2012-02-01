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
package ca.uhn.hl7v2.testpanel.model;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.llp.ExtendedMinLowerLayerProtocol;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.util.llp.ByteCapturingMinLowerLayerProtocolWrapper;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractConnection")
public abstract class AbstractConnection extends AbstractModelClass implements IDestroyable {
	public static final String NAME_PROPERTY = AbstractConnection.class.getName() + "_NAME";
	@SuppressWarnings("unused")
	private static final Logger ourLog = LoggerFactory.getLogger(AbstractConnection.class);
	public static final String PERSISTENT_PROPERTY = AbstractConnection.class.getName() + "_PERSISTENT";
	public static final String RECENT_ACTIVITY_PROPERTY = AbstractConnection.class.getName() + "_RECENT_ACTIVITY";
	public static final String STATUS_LINE_PROPERTY = AbstractConnection.class.getName() + "_STATUS_LINE";
	public static final String STATUS_PROPERTY = AbstractConnection.class.getName() + "_STATUS";

	@XmlAttribute(required = true)
	private boolean myCaptureBytes;
	@XmlAttribute(required = true)
	private String myCharSet;
	@XmlAttribute(required = true)
	private boolean myDetectCharSetInMessage;
	@XmlAttribute(required = true)
	private boolean myDualPort;
	@XmlAttribute(required = true)
	private Hl7V2EncodingTypeEnum myEncoding;
	@XmlAttribute(required = true)
	private String myHost;
	@XmlAttribute(required = true)
	private String myId;
	@XmlAttribute(required = true)
	private int myIncomingOrSinglePort;
	@XmlAttribute(required = true)
	private String myName;
	@XmlAttribute(required = true)
	private boolean myNameIsExplicitlySet;
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

	private void checkOutboundCapture() {
		synchronized (myWriterCapture) {
			byte[] outboundBytes = myWriterCapture.toByteArray();
			if (outboundBytes.length > 0) {
				addActivity(new ActivityOutgoingBytes(new Date(), outboundBytes));
				myWriterCapture.reset();
			}
		}
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

	protected LowerLayerProtocol createLlp() {
		LowerLayerProtocol llpClass;
		if (isDetectCharSetInMessage()) {
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
	 * @return the encoding
	 */
	public Hl7V2EncodingTypeEnum getEncoding() {
		return myEncoding;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return myHost;
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
	 * @param theHost
	 *            the host to set
	 */
	public void setHost(String theHost) {
		myHost = theHost;
		updateName();
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
		myTls = theSelected;
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

	public enum StatusEnum {
		FAILED, STARTED, STOPPED, TRYING_TO_START
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
