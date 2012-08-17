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

import java.awt.EventQueue;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.testpanel.model.ActivityIncomingMessage;
import ca.uhn.hl7v2.testpanel.model.ActivityInfo;
import ca.uhn.hl7v2.testpanel.model.ActivityInfoError;
import ca.uhn.hl7v2.testpanel.model.ActivityOutgoingMessage;
import ca.uhn.hl7v2.testpanel.model.msg.AbstractMessage;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageBase;
import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;
import ca.uhn.hl7v2.testpanel.ui.IDestroyable;
import ca.uhn.hl7v2.testpanel.util.IProgressCallback;
import ca.uhn.hl7v2.testpanel.util.IProgressCallback.OperationCancelRequestedException;
import ca.uhn.hl7v2.util.SocketFactory;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutboundConnection")
public class OutboundConnection extends AbstractConnection implements IDestroyable {

	private static final Logger ourLog = LoggerFactory.getLogger(OutboundConnection.class);

	private transient Connection myConnection;
	private transient ConnectionMonitorThread myConnectionMonitorThread;
	private transient Parser myParser;
	private transient MessageSenderThread myMessageSenderThread;

	public OutboundConnection() {
	}

	@Override
	public String exportConfigToXml() {
		StringWriter writer = new StringWriter();
		JAXB.marshal(this, writer);
		return writer.toString();
	}

	public static OutboundConnection fromXml(String theXml) {
		return JAXB.unmarshal(new StringReader(theXml), OutboundConnection.class);
	}

	public synchronized void sendMessages(Hl7V2MessageCollection theMessages, IProgressCallback theTransmissionCallback) {
		if (myMessageSenderThread != null) {
			throw new IllegalStateException("Already sending messages");
		}
		myMessageSenderThread = new MessageSenderThread(theMessages, theTransmissionCallback);
		myMessageSenderThread.start();
	}

	public void start() {
		super.start();

		if (myConnectionMonitorThread != null) {
			return;
		}

		myParser = createParser();

		ourLog.info("Starting up outgoing interface {}", getName());

		myConnectionMonitorThread = new ConnectionMonitorThread();
		setStatus(StatusEnum.TRYING_TO_START);
		myConnectionMonitorThread.start();
	}

	public void stop() {
		super.stop();

		ourLog.info("Shutting down outgoing interface {}", getName());

		ConnectionMonitorThread thread = myConnectionMonitorThread;
		myConnectionMonitorThread = null;

		if (thread != null) {
			thread.interrupt();
		}

	}

	private class ConnectionMonitorThread extends Thread {

		private CountDownLatch myStartupLatch = new CountDownLatch(1);

		private void doRun() throws LLPException {
			LowerLayerProtocol llpClass = null;
			llpClass = createLlp();

			boolean tls = isTls();

			String desc = OutboundConnection.this.isNameIsExplicitlySet() ? OutboundConnection.this.getName() + " (" + OutboundConnection.this.createDescription() + ")" : OutboundConnection.this.createDescription();
			ourLog.info("Starting outbound interface " + desc);

			Connection connection = null;
			while (myConnectionMonitorThread == this) {

				if (getStatus() == StatusEnum.TRYING_TO_START) {
					ourLog.info("Attempting outbound connection to " + desc);

					try {
						
						SocketFactory socketFactory = getSocketFactory();
						
						if (isDualPort()) {
							connection = ConnectionHub.getInstance().attach(getHost(), getOutgoingPort(), getIncomingOrSinglePort(), myParser, llpClass, tls, socketFactory);
						} else {
							connection = ConnectionHub.getInstance().attach(getHost(), getIncomingOrSinglePort(), myParser, llpClass, tls, socketFactory);
						}

						myConnection = connection;

						ourLog.info("Successfully connected to " + createDescription());
						myStartupLatch.countDown();

					} catch (HL7Exception e) {
						Throwable ex = e;
						if (e.getCause() != null) {
							ex = e.getCause();
						}

						ourLog.warn("Failed to connect to " + createDescription() + " - Message was " + ex.getMessage());
						addActivity(new ActivityInfoError(new Date(), "Failed to connect to " + createDescription() + " - " + ex.getMessage()));
					}

					if (myConnection != null) {
						if (myConnection.isOpen()) {
							setStatus(StatusEnum.STARTED);
							setStatusLine("Connected");
						} else {
							setStatus(StatusEnum.TRYING_TO_START);
							setStatusLine("Lost connection, retrying...");
						}
					}
					if (myConnection == null) {
						setStatus(StatusEnum.TRYING_TO_START);
						setStatusLine("Trying to connect...");
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// ignore
					}

				}

				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// ignore
				}

			}

		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void run() {
			setStatusLine("Trying to connect...");

			try {

				doRun();
				setStatusLine("Connection stopped");

			} catch (Throwable e) {
				ourLog.error("Connection failed with an unexpected error!", e);
				setStatusLine("Failed with an error: " + e.getMessage());
			} finally {
				if (myConnection != null) {
					ConnectionHub.getInstance().discard(myConnection);
				}
				myConnectionMonitorThread = null;
				setStatus(StatusEnum.STOPPED);
			}
		}

		/**
		 * @return Returns true if we got a connection
		 */
		public boolean waitUntilWeHaveAConnection() {
			try {
				return myStartupLatch.await(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				return false;
			}
		}

	}

	public class MessageSenderThread extends Thread {

		private Hl7V2MessageCollection myMessages;
		private IProgressCallback myTransmissionCallback;
		private boolean myCancelled;
		private long myStartTime;
		private StatusEnum myInitialStatus;
		private int myTotalMessages;
		private int mySentMessages;

		public MessageSenderThread(Hl7V2MessageCollection theMessages, IProgressCallback theTransmissionCallback) {
			myMessages = theMessages;
			myTransmissionCallback = theTransmissionCallback;
		}

		@Override
		public void run() {

			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					myTransmissionCallback.activityStarted();
				}
			});

			try {
				
				if (!doStart()) {
					return;
				}
				
				int sendNumberOfTimes = myMessages.getSendNumberOfTimes();
				
				myTotalMessages = myMessages.countMessagesOfType(Hl7V2MessageBase.class) * sendNumberOfTimes;
				mySentMessages = 0;
				
				myStartTime = System.currentTimeMillis();
				for (int curRep = 1; curRep <= sendNumberOfTimes; curRep++) {
					doSend();
				}

				doStop();
				
			} finally {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						myTransmissionCallback.activityStopped();
					}
				});
				synchronized (OutboundConnection.this) {
					myMessageSenderThread = null;
				}
				
				ourLog.info("Transmission thread shutting down");
			}

		}

		private void doStop() {
			long delay = System.currentTimeMillis() - myStartTime;
			int i = myTotalMessages;
			
			StringBuilder b = new StringBuilder();
			b.append("Sent ");
			b.append(i);
			b.append(" message");
			b.append((i != 1 ? "s" : ""));
			b.append(" in ");
			b.append(delay);
			b.append("ms");
			b.append('\n');
			b.append("Average: ");
			b.append(delay / myTotalMessages);
			b.append("ms / message");
			
			addActivity(new ActivityInfo(new Date(), b.toString()));

			if (myInitialStatus != StatusEnum.STARTED) {
				OutboundConnection.this.stop();
			}
		}

		private boolean doStart() {
			myInitialStatus = getStatus();
			if (myInitialStatus != StatusEnum.STARTED) {
				OutboundConnection.this.start();
			}

			if (myConnectionMonitorThread == null) {
				throw new IllegalStateException("Interface not started");
			}

			if (getStatus() != StatusEnum.STARTED) {
				ourLog.info("Waiting for interface {} to start...", OutboundConnection.this.getName());
				addActivity(new ActivityInfo(new Date(), "Starting interface \"" + OutboundConnection.this.getName() + "\"..."));

				boolean gotConnection = myConnectionMonitorThread.waitUntilWeHaveAConnection();
				if (!gotConnection) {
					ourLog.info("Failed to connect to {}, shutting down interface and aborting send", createDescription());
					addActivity(new ActivityInfoError(new Date(), "Failed to connect to interface. Aborting send."));
					OutboundConnection.this.stop();
					return false;
				}
			}
			
			return true;
		}

		private void doSend() {
			int i = 0;
			for (AbstractMessage<?> abstractMessage : myMessages.getMessages()) {
				if (myCancelled) {
					return;
				}
				
				final double complete = (((double)mySentMessages) / myTotalMessages);
				if (myTotalMessages < 100 || i % 10 == 0) {
						EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								try {
									myTransmissionCallback.progressUpdate(complete);
								} catch (OperationCancelRequestedException e) {
									ourLog.info("Detected that transmission cancel was requested");
									myCancelled = true;
								}
							}
						});
				}
				
				i++;

				if (abstractMessage instanceof Hl7V2MessageBase) {
					mySentMessages++;

					Message msg = ((Hl7V2MessageBase) abstractMessage).getParsedMessage();
					ourLog.info("Sending message " + i + "/" + myTotalMessages + " of type " + msg.getClass());
					try {

						beforeProcessingNewMessageOut();
						addActivity(new ActivityOutgoingMessage(new Date(), getEncoding(), myParser.encode(msg), EncodingCharacters.getInstance(msg)));

						Message response = myConnection.getInitiator().sendAndReceive(msg);

						beforeProcessingNewMessageIn();
						addActivity(new ActivityIncomingMessage(new Date(), getEncoding(), myParser.encode(response), EncodingCharacters.getInstance(response)));

					} catch (HL7Exception e) {
						ourLog.error("Failed to transmit message. ", e);
						addActivity(new ActivityInfoError(new Date(), "Failed to transmit message. " + e.getMessage()));
					} catch (LLPException e) {
						ourLog.error("Failed to transmit message. ", e);
						addActivity(new ActivityInfoError(new Date(), "Failed to transmit message. " + e.getMessage()));
					} catch (IOException e) {
						ourLog.error("Failed to transmit message. Shutting down interface. ", e);
						addActivity(new ActivityInfoError(new Date(), "Failed to transmit message. Shutting down interface. " + e.getMessage()));
						OutboundConnection.this.stop();
					}

				} else {

					ourLog.info("Skipping unknown message");

				}

			}

		}

	}

}
