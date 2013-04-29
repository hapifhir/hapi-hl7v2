/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ActiveInitiator.java".  Description:
"Performs the initiation role of a message exchange accorging to HL7's original 
 mode rules." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.util.idgenerator.IDGenerator;
import ca.uhn.hl7v2.util.idgenerator.InMemoryIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Performs the initiation role of a message exchange (i.e sender of the first
 * message; analogous to the client in a client-server interaction), according
 * to HL7's original mode processing rules.
 * </p>
 * <p>
 * The <code>sendAndReceive(...)</code> method blocks until either a response is
 * received with the matching message ID, or until a timeout period has passed.
 * The timeout defaults to 10000 ms (10 sec) but can be configured using
 * {@link #setTimeout(long, java.util.concurrent.TimeUnit)} or globally by setting
 * the system property "ca.uhn.hl7v2.app.initiator.timeout" to an long value
 * representing the number of ms after which to time out.
 * </p>
 * <p>
 * At the time of writing, enhanced mode, two-phase reply, continuation
 * messages, and batch processing are unsupported.
 * </p>
 * 
 * @author Bryan Tripp
 */
public class ActiveInitiator implements Initiator {

	private static final Logger log = LoggerFactory.getLogger(ActiveInitiator.class);
	private static final Logger rawOutbound = LoggerFactory
			.getLogger("ca.uhn.hl7v2.raw.outbound");
	private static final Logger rawInbound = LoggerFactory
			.getLogger("ca.uhn.hl7v2.raw.inbound");
	private ActiveConnection conn;
	private long timeoutMillis = 10000;

	/**
	 * Creates a new instance of ActiveInitiator.
	 * 
	 * @param conn
	 *            the Connection associated with this ActiveInitiator.
	 */
	ActiveInitiator(ActiveConnection conn) throws LLPException {
		this.conn = conn;

		// See if timeout has been set
		String timeout = System
				.getProperty("ca.uhn.hl7v2.app.initiator.timeout");
		if (timeout != null) {
			try {
				timeoutMillis = Long.parseLong(timeout);
				log.debug("Setting Initiator timeout to {} ms", timeout);
			} catch (NumberFormatException e) {
				log.warn(timeout
						+ " is not a valid long - Initiator is using default timeout");
			}
		}
	}

	/**
	 * Sends a message to a responder system, receives the reply, and returns
	 * the reply as a Message object. This method is thread-safe - multiple
	 * threads can share an Initiator and call this method. Responses are
	 * returned to the calling thread on the basis of message ID.
	 */
	public Message sendAndReceive(Message out) throws HL7Exception,
			LLPException, IOException {
		if (out == null) {
			throw new HL7Exception("Can't encode null message",
					ErrorCode.REQUIRED_FIELD_MISSING);
		}

		// register message with response Receiver(s) (by message ID)
		Terser t = new Terser(out);
		String messID = t.get("/MSH-10");

		if (messID == null || messID.length() == 0) {
			throw new HL7Exception(
					"MSH segment missing required field Control ID (MSH-10)",
					ErrorCode.REQUIRED_FIELD_MISSING);
		}

		// log and send message
		String outbound = conn.getParser().encode(out);
		rawOutbound.debug(outbound);
		Future<String> inbound = null;
		try {
			String message;
			inbound = conn.waitForResponse(messID, timeoutMillis);
			conn.getSendWriter().writeMessage(outbound);
			if (inbound != null && (message = inbound.get()) != null) {
				// log that we got the message
				log.debug("Initiator received message: {}", message);
				rawInbound.debug(message);
				Message response = conn.getParser().parse(message);
				log.debug("response parsed");
				return response;
			}
		} catch (IOException e) {
			if (inbound != null)
				inbound.cancel(true);
			conn.close();
			throw e;
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}

		throw new HL7Exception(
				"Timeout waiting for response to message with control ID "
						+ messID);
	}

	public void setTimeoutMillis(int timeout) {
		setTimeout(timeout, TimeUnit.MILLISECONDS);
	}

    public void setTimeout(long timeout, TimeUnit timeUnit) {
        this.timeoutMillis = timeUnit.toMillis(timeout);
    }

    /**
	 * Test harness
	 */
	public static void main(String args[]) {
		if (args.length != 2) {
			System.out.println("Usage: ca.uhn.hl7v2.app.ActiveInitiator host port");
		}

		try {

			// set up connection to server
			String host = args[0];
			int port = Integer.parseInt(args[1]);

			final Parser parser = new PipeParser();
			LowerLayerProtocol llp = new MinLowerLayerProtocol();
			Connection connection = new ActiveConnection(parser, llp, new Socket(
					host, port));
			final Initiator initiator = connection.getInitiator();
			connection.activate();
			final String outText = "MSH|^~\\&|||||||ACK^^ACK|||R|2.4|\rMSA|AA";
			final IDGenerator generator = new InMemoryIDGenerator();

			// get a bunch of threads to send messages
			for (int i = 0; i < 1000; i++) {
				Thread sender = new Thread(new Runnable() {
					
					public void run() {
						try {
							// get message ID
							String ID = generator.getID();
							Message out = parser.parse(outText);
							Terser tOut = new Terser(out);
							tOut.set("/MSH-10", ID);

							// send, get response
							Message in = initiator.sendAndReceive(out);
							// get ACK ID
							Terser tIn = new Terser(in);
							String ackID = tIn.get("/MSA-2");
							if (ID.equals(ackID)) {
								System.out.println("OK - ack ID matches");
							} else {
								throw new RuntimeException(
										"Ack ID for message " + ID + " is "
												+ ackID);
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				sender.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
