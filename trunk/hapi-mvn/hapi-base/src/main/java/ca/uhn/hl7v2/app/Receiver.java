/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "Receiver.java".  Description:
 * "Listens for incoming messages on a certain input stream, and
 * sends them to the appropriate location."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): _____________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.concurrent.Service;
import ca.uhn.hl7v2.llp.HL7Reader;

/**
 * Listens for incoming messages on a certain input stream, and sends them to
 * the appropriate location.
 * 
 * @author Bryan Tripp
 */
public class Receiver extends Service {

	private static final Logger log = LoggerFactory.getLogger(Receiver.class);

	private ActiveConnection conn;
	private HL7Reader in;

	/** Creates a new instance of Receiver, associated with the given Connection */
	public Receiver(ActiveConnection c, HL7Reader in) {
		super("Receiver", c.getExecutorService());
		this.conn = c;
		this.in = in;
	}


	@Override
	protected void handle() {
		try {
			String message = in.getMessage();
			if (message == null) {
				log.debug("Failed to read a message");
			} else {
				processMessage(message);
			}
		} catch (SocketException e)  {
			// This probably means that the client closed the server connection normally
			conn.close();
			log.info("SocketException: closing Connection from " + describeRemoteConnection() + ", will no longer read messages with this Receiver: " + e.getMessage());
		} catch (IOException e) {
			conn.close();
			log.warn("IOException: closing Connection from " + describeRemoteConnection() + ", will no longer read messages with this Receiver. ", e);
		} catch (Exception e) {
			conn.close();
			log.error("Unexpected error, closing connection from " + describeRemoteConnection() + " - ", e);
		}

	}


	private String describeRemoteConnection() {
		return conn.getRemoteAddress().getHostAddress() + ":" + conn.getRemotePort();
	}


	/**
	 * Processes a single incoming message by sending it to the appropriate
	 * internal location. If an incoming message contains an MSA-2 field, it is
	 * assumed that this message is meant as a reply to a message that has been
	 * sent earlier. In this case an attempt is give the message to the object
	 * that sent the corresponding outbound message. If the message contains an
	 * MSA-2 but there are no objects that appear to be waiting for it, it is
	 * discarded and an exception is logged. If the message does not contain an
	 * MSA-2 field, it is concluded that the message has arrived unsolicited. In
	 * this case it is sent to the Responder (in a new Thread).
	 */
	protected void processMessage(String message) {
		String ackID = conn.getParser().getAckID(message);
		if (ackID == null) {
			log.debug("Unsolicited Message Received: {}", message);
			getExecutorService().submit(new Grunt(conn, message));
		} else {
			if (!conn.isRecipientWaiting(ackID, message)) {
				log.info("Unexpected Message Received. This message appears to be an acknowledgement (MSA-2 has a value) so it will be ignored: {}", message);
			} else {
				log.debug("Response Message Received: {}", message);
			}
		}
	}

	/** Independent thread for processing a single message */
	private class Grunt implements Runnable {

		private ActiveConnection conn;
		private String m;

		public Grunt(ActiveConnection conn, String message) {
			this.conn = conn;
			this.m = message;
		}

		public void run() {
			try {
				String response = conn.getResponder().processMessage(m);
				if (response != null) {
					conn.getAckWriter().writeMessage(response);
				} else {
					log.debug("Not responding to incoming message");
				}
			} catch (Exception e) {
				log.error("Error while processing message: ", e);
			}
		}
	}

}
