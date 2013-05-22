/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ActiveConnection.java".  Description:
"A TCP/IP connection to a remote HL7 server." 

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
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.concurrent.BlockingMap;
import ca.uhn.hl7v2.concurrent.BlockingHashMap;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;

/**
 * A TCP/IP connection to a remote HL7 server.
 * 
 * @author Bryan Tripp
 */
public class ActiveConnection implements Connection {

	private static final Logger log = LoggerFactory.getLogger(ActiveConnection.class);

	private Initiator initiator;
	private Responder responder;
	private List<Socket> sockets;
	private HL7Writer ackWriter;
	private HL7Writer sendWriter;
	private Parser parser;
	private BlockingMap<String, String> responses;
	private List<Receiver> receivers;
	private boolean open = true;
	private ExecutorService executorService;

	/**
	 * Creates a new instance of Connection, with inbound and outbound
	 * communication on a single port.
	 */
	public ActiveConnection(Parser parser, LowerLayerProtocol llp,
                            Socket bidirectional) throws LLPException, IOException {
		this(parser, llp, bidirectional, DefaultExecutorService
				.getDefaultService());
	}

	public ActiveConnection(Parser parser, LowerLayerProtocol llp,
                            Socket bidirectional, ExecutorService executorService)
			throws LLPException, IOException {
		init(parser, executorService, bidirectional);
		ackWriter = llp.getWriter(bidirectional.getOutputStream());
		sendWriter = ackWriter;
		this.executorService = executorService;
		sockets.add(bidirectional);
		receivers.add(new Receiver(this, llp.getReader(bidirectional
				.getInputStream())));
		this.initiator = new ActiveInitiator(this);
	}

	/**
	 * Creates a new instance of Connection, with inbound communication on one
	 * port and outbound on another.
	 */
	public ActiveConnection(Parser parser, LowerLayerProtocol llp, Socket inbound,
                            Socket outbound) throws LLPException, IOException {
		this(parser, llp, inbound, outbound, DefaultExecutorService
				.getDefaultService());
	}

	/**
	 * Creates a new instance of Connection, with inbound communication on one
	 * port and outbound on another.
	 */
	public ActiveConnection(Parser parser, LowerLayerProtocol llp, Socket inbound,
                            Socket outbound, ExecutorService executorService)
			throws LLPException, IOException {
		init(parser, executorService, inbound);
		ackWriter = llp.getWriter(inbound.getOutputStream());
		sendWriter = llp.getWriter(outbound.getOutputStream());
		sockets.add(outbound); // always add outbound first ... see getRemoteAddress()
		sockets.add(inbound);

		receivers.add(new Receiver(this,
				llp.getReader(inbound.getInputStream())));
		receivers.add(new Receiver(this, llp.getReader(outbound
				.getInputStream())));
		this.initiator = new ActiveInitiator(this);
	}

	/** Common initialization tasks */
	private void init(Parser parser, ExecutorService executorService, Socket inboundSocket)
			throws LLPException {
		this.parser = parser;
		this.executorService = executorService;
		sockets = new ArrayList<Socket>();
		responses = new BlockingHashMap<String, String>(executorService);
		receivers = new ArrayList<Receiver>(2);
		responder = new Responder(inboundSocket);
	}

	/**
	 * Start the receiver thread(s)
	 */
	public void activate() {
		if (receivers != null) {
			for (Receiver receiver : receivers) {
				receiver.start();
			}
		}
	}

	public ExecutorService getExecutorService() {
		return executorService;
	}

	/**
	 * Returns the address of the remote host to which this Connection is
	 * connected. If separate inbound and outbound sockets are used, the address
	 * of the outbound socket is returned (the addresses should normally be the
	 * same, but this isn't checked).
	 */
	public InetAddress getRemoteAddress() {
		Socket s = sockets.get(0);
		return s.getInetAddress();
	}

	/**
	 * Returns the remote port on the remote host to which this Connection is
	 * connected. If separate inbound and outbound sockets are used, the port of
	 * the outbound socket is returned.
	 */
	public Integer getRemotePort() {
		Socket s = sockets.get(0);
		return s.getPort();
	}

	/** Returns the Initiator associated with this connection */
	public Initiator getInitiator() {
		return this.initiator;
	}

	/** Returns the Responder associated with this connection */
	public Responder getResponder() {
		return this.responder;
	}

	public boolean isSecure() {
		if (isOpen() && sockets.size() > 0) {
			return (sockets.get(0) instanceof SSLSocket);
		} else {
			throw new IllegalStateException(
					"Can't determine status on closed socket");
		}
	}

	/**
	 * Returns the HL7Writer through which unsolicited outbound messages should
	 * be sent.
	 */
	protected HL7Writer getSendWriter() {
		return this.sendWriter;
	}

	/**
	 * Returns the HL7Writer through which responses to inbound messages should
	 * be sent.
	 */
	protected HL7Writer getAckWriter() {
		return this.ackWriter;
	}

	public Parser getParser() {
		return this.parser;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(getRemoteAddress().getHostName());
		buf.append(":");
		for (Iterator<Socket> iter = sockets.iterator(); iter.hasNext();) {
			Socket socket = iter.next();
			buf.append(socket.getPort());
			if (iter.hasNext())
				buf.append(",");
		}
		return buf.toString();
	}

	/**
	 * Reserves a future incoming message by ack ID. When the incoming message
	 * with the given ack ID arrives, the message will be returned.
	 */
	protected Future<String> waitForResponse(final String messageID,
			long timeout) throws InterruptedException {
		return responses.asyncPoll(messageID, timeout, TimeUnit.MILLISECONDS);
	}

	/**
	 * Given the ack ID (MSA-2) of a message, notifies a waiting consumer thread
	 * about a received response.
	 */
	protected boolean isRecipientWaiting(String ackID, String message) {
		return responses.give(ackID, message);
	}

	/** Stops running Receiver threads and closes open sockets */
	public void close() {
		// Mark all running receiver threads to be stopped
		for (Receiver receiver : receivers) {
			if (receiver.isRunning())
				receiver.stop();
		}
		// Forces open sockets to be closed. This causes the Receiver threads to
		// eventually terminate
		for (Socket socket : sockets) {
			try {
				if (!socket.isClosed())
					socket.close();
			} catch (Exception e) {
				log.error("Error while stopping threads and closing sockets", e);
			}
		}

		open = false;
	}

	public boolean isOpen() {
		return open;
	}

}
