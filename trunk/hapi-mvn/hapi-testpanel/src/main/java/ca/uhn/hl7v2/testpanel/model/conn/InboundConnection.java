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

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionListener;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.app.TwoPortService;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityValidationOutcome;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup.Entry;
import ca.uhn.hl7v2.util.Terser;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InboundConnection")
public class InboundConnection extends AbstractConnection {

	public static final String CONNECTIONS_PROPERTY = InboundConnection.class.getName() + "_CONNECTIONS_PROP";

	private static final Logger ourLog = LoggerFactory.getLogger(InboundConnection.class);
	public static final String PROP_VALIDATE_INCOMING = InboundConnection.class.getName() + "_VALIDATE_INCOMING";
	private transient List<Connection> myConnections = new ArrayList<Connection>();
	private transient Handler myHandler = new Handler();
	private transient MonitorThread myMonitorThread;
	private transient Parser myParser;
	private transient HL7Service myService;

	@XmlAttribute(name="validateIncomingUsingProfileGroupId")
	private String myValidateIncomingUsingProfileGroupId;

	
	@Override
	public String exportConfigToXml() {
		StringWriter writer = new StringWriter();
		JAXB.marshal(this, writer);
		return writer.toString();
	}
	
	
	/**
	 * @return the connections
	 */
	public List<Connection> getConnections() {
		return myConnections;
	}


	/**
	 * @return the validateIncomingUsingProfileGroupId
	 */
	public String getValidateIncomingUsingProfileGroupId() {
		return myValidateIncomingUsingProfileGroupId;
	}
	
	/**
	 * @param theValidateIncomingUsingProfileGroupId the validateIncomingUsingProfileGroupId to set
	 */
	public void setValidateIncomingUsingProfileGroupId(String theValidateIncomingUsingProfileGroupId) {
		String oldValue = myValidateIncomingUsingProfileGroupId;
		myValidateIncomingUsingProfileGroupId = theValidateIncomingUsingProfileGroupId;
		firePropertyChange(PROP_VALIDATE_INCOMING, oldValue, theValidateIncomingUsingProfileGroupId);
	}

	@Override
	public void start() {
		super.start();
		
		if (myService != null) {
			return;
		}

		myParser = createParser();
		
		if (isDualPort()) {
			myService = new TwoPortService(myParser, createLlp(), getIncomingOrSinglePort(), getOutgoingPort(), isTls());
		} else {
			myService = new SimpleServer(getIncomingOrSinglePort(), createLlp(), myParser, isTls());
		}

		myService.registerApplication("*", "*", myHandler);
		myService.registerConnectionListener(myHandler);

		myService.start();

		myMonitorThread = new MonitorThread();
		myMonitorThread.start();

		updateStatus();
	}
	
	@Override
	public void stop() {
		super.stop();

		if (myService != null) {
			myService.stop();
		}
		myService = null;

		MonitorThread monitorThread = myMonitorThread;
		myMonitorThread = null;
		
		if (myMonitorThread != null) {
			monitorThread.interrupt();
		}
		
		setStatus(StatusEnum.STOPPED);
		setStatusLine("Stopped");

	}

	private void updateStatus() {
		if (myMonitorThread == null) {
			if (getStatus() != StatusEnum.FAILED) {
				setStatus(StatusEnum.STOPPED);
				setStatusLine("");
			}
		} else if (myConnections.size() > 1) {
			setStatus(StatusEnum.STARTED);
			setStatusLine("Listening on " + createDescription() + ", " + myConnections.size() + " connections");
		} else if (myConnections.size() > 0) {
			setStatus(StatusEnum.STARTED);
			setStatusLine("Listening on " + createDescription() + ", 1 connection");
		} else {
			setStatus(StatusEnum.TRYING_TO_START);
			setStatusLine("Listening on " + createDescription() + ", no connections");
		}
	}

	public static InboundConnection fromXml(String theXml) {
		return JAXB.unmarshal(new StringReader(theXml), InboundConnection.class);
	}

	/**
	 * Listens to the service for updates
	 */
	private class Handler implements Application, ConnectionListener {

		public boolean canProcess(Message theIn) {
			return true;
		}

		public void connectionDiscarded(Connection theC) {
			ourLog.info("Connection lost from " + theC.getRemoteAddress().toString());

			ArrayList<Connection> oldConnections = new ArrayList<Connection>(myConnections);
			myConnections.remove(theC);

			updateStatus(oldConnections);
		}

		public void connectionReceived(Connection theC) {
			ourLog.info("New connection received from " + theC.getRemoteAddress().toString());

			ArrayList<Connection> oldConnections = new ArrayList<Connection>(myConnections);
			myConnections.add(theC);

			updateStatus(oldConnections);
		}

		public Message processMessage(Message theIn) throws ApplicationException, HL7Exception {
			try {
				beforeProcessingNewMessageIn();
				
				addActivity(new ActivityIncomingMessage(new Date(), getEncoding(), myParser.encode(theIn), EncodingCharacters.getInstance(theIn)));
				
				final Message response = theIn.generateACK();

				if (getValidateIncomingUsingProfileGroupId() != null) {
					ProfileGroup profileGroup = getController().getProfileFileList().getProfile(getValidateIncomingUsingProfileGroupId());
					Terser t = new Terser(theIn);
					String evtType = t.get("/MSH-9-1");
					String evtTrigger = t.get("/MSH-9-2");
					try {
						Entry profileEntry = profileGroup.getProfileForMessage(evtType, evtTrigger);
						RuntimeProfile profile = profileEntry.getProfileProxy().getProfile();
						
						DefaultValidator validator = new DefaultValidator();
						if (profileEntry.getTablesId() != null) {
							validator.setCodeStore(getController().getTableFileList().getTableFile(profileEntry.getTablesId()));
						}
						HL7Exception[] problems = validator.validate(theIn, profile.getMessage());
						addActivity(new ActivityValidationOutcome(new Date(), problems));
						
					} catch (ProfileException e) {
						ourLog.error("Failed to load profile", e);
					}
				}
				
				
				addActivity(new ActivityOutgoingMessage(new Date(), getEncoding(), myParser.encode(response), EncodingCharacters.getInstance(response)));

				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						addNewMessage();
					}
				});
				
				return response;
			} catch (IOException e) {
				throw new HL7Exception(e);
			}
		}

		private void updateStatus(final ArrayList<Connection> theOldConnections) {
			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					InboundConnection.this.updateStatus();

					firePropertyChange(CONNECTIONS_PROPERTY, theOldConnections, myConnections);
				}
			});
		}

	}

	
	private class MonitorThread extends Thread {

		@Override
		public void run() {

			boolean done = false;
			while (myMonitorThread == this && !done) {

				final Throwable exception = myService.getServiceExitedWithException();
				if (exception != null) {
					done = true;
					
					SwingUtilities.invokeLater(new Runnable() {

						public void run() {
							InboundConnection.this.stop();

							if (exception instanceof BindException) {
								setStatusLine("Could not bind, " + createDescription() + " already in use");
							} else {
								setStatusLine(exception.getMessage());
							}
							setStatus(StatusEnum.FAILED);
						}
					});
				}

				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// ignore
				}
			}

		}

	}

}
