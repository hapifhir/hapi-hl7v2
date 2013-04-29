/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "TwoPortService.java".  Description: 
"A TCP/IP-based HL7 Service that uses separate ports for inbound and outbound messages." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

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

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.AcceptorThread.AcceptedSocket;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.SocketFactory;

/**
 * A TCP/IP-based HL7 Service that uses separate ports for inbound and outbound
 * messages. A connection is only activated when the same remote host connects
 * to both the inbound and outbound ports.
 * 
 * @author Bryan Tripp
 */
public class TwoPortService extends HL7Service {

	private static final Logger log = LoggerFactory
			.getLogger(TwoPortService.class);

	private Map<String, AcceptedSocket> waitingForSecondSocket = new HashMap<String, AcceptedSocket>();
	private int inboundPort;
	private int outboundPort;
	private boolean tls;
	private BlockingQueue<AcceptedSocket> queue;
	private AcceptorThread inboundAcceptor, outboundAcceptor;
	private final HapiContext hapiContext;

	public TwoPortService(int inboundPort, int outboundPort) {
		this(new PipeParser(), new MinLowerLayerProtocol(), inboundPort,
				outboundPort, false);
	}

	public TwoPortService(int inboundPort, int outboundPort, boolean tls) {
		this(new PipeParser(), new MinLowerLayerProtocol(), inboundPort,
				outboundPort, tls);
	}

	/** Creates a new instance of TwoPortService */
	public TwoPortService(Parser parser, LowerLayerProtocol llp,
			int inboundPort, int outboundPort, boolean tls) {
		this(parser, llp, inboundPort, outboundPort, tls,
				DefaultExecutorService.getDefaultService());
	}

	/** Creates a new instance of TwoPortService */
	public TwoPortService(HapiContext hapiContext, 
			int inboundPort, int outboundPort, boolean tls) {
		super(hapiContext);
		this.hapiContext = hapiContext;
		this.queue = new LinkedBlockingQueue<AcceptedSocket>();
		this.inboundPort = inboundPort;
		this.outboundPort = outboundPort;
		this.tls = tls;
		
		if (inboundPort == outboundPort) {
			throw new IllegalArgumentException("Inbound port and outbound port can not be the same");
		}
		if (inboundPort < 1) {
			throw new IllegalArgumentException("Invalid inbound port");
		}
		if (outboundPort < 1) {
			throw new IllegalArgumentException("Invalid outbound port");
		}
		
	}

	/** Creates a new instance of TwoPortService */
	public TwoPortService(Parser parser, LowerLayerProtocol llp,
			int inboundPort, int outboundPort, boolean tls,
			ExecutorService executorService) {
		super(parser, llp, executorService);
		this.hapiContext = new DefaultHapiContext();
		this.queue = new LinkedBlockingQueue<AcceptedSocket>();
		this.inboundPort = inboundPort;
		this.outboundPort = outboundPort;
		this.tls = tls;
	}

	/**
	 * Launches two threads that concurrently listen on the inboundPort and
	 * outboundPort.
	 * 
	 * @see ca.uhn.hl7v2.app.HL7Service#afterStartup()
	 */
	@Override
	protected void afterStartup() {
		try {
			super.afterStartup();
			inboundAcceptor = createAcceptThread(inboundPort);
			outboundAcceptor = createAcceptThread(outboundPort);
			inboundAcceptor.start();
			outboundAcceptor.start();
			log.info("TwoPortService running on ports {} and {}", inboundPort,
					outboundPort);
		} catch (IOException e) {
			log.error("Could not run TwoPortService on ports {} and {}",
					inboundPort, outboundPort);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Terminate the two acceptor threads
	 * 
	 * @see ca.uhn.hl7v2.app.HL7Service#afterTermination()
	 */
	@Override
	protected void afterTermination() {
		super.afterTermination();
		inboundAcceptor.stop();
		outboundAcceptor.stop();
	}

	/**
	 * Polls for accepted sockets
	 */
	protected void handle() {
		if (inboundAcceptor.getServiceExitedWithException() != null) {
			setServiceExitedWithException(inboundAcceptor.getServiceExitedWithException());
		}
		if (outboundAcceptor.getServiceExitedWithException() != null) {
			setServiceExitedWithException(outboundAcceptor.getServiceExitedWithException());
		}
		
		try {
			ActiveConnection conn = acceptConnection(queue.poll(2, TimeUnit.SECONDS));
			if (conn != null) {
				log.info("Accepted connection from "
						+ conn.getRemoteAddress().getHostAddress());
				newConnection(conn);
			}
		} catch (Exception e) {
			log.error("Error while accepting connections: ", e);
		}
	}

	/**
	 * Helper method that checks whether the newSocket completes a two-port
	 * connection or not. If yes, the {@link ActiveConnection} object is created and
	 * returned.
	 */
	private ActiveConnection acceptConnection(AcceptedSocket newSocket)
			throws LLPException, IOException {
		ActiveConnection conn = null;
		if (newSocket != null) {
			String address = newSocket.socket.getInetAddress().getHostAddress();
			AcceptedSocket otherSocket = waitingForSecondSocket.remove(address);
			if (otherSocket != null && otherSocket.origin != newSocket.origin) {
				log.debug("Socket {} completes a two-port connection",
						newSocket.socket);
				Socket in = getInboundSocket(newSocket, otherSocket);
				Socket out = getOutboundSocket(newSocket, otherSocket);
				conn = new ActiveConnection(getParser(), getLlp(), in, out,
						getExecutorService());
			} else {
				log.debug(
						"Registered {} Still waiting for second socket for two-port connection",
						newSocket.socket);
				waitingForSecondSocket.put(address, newSocket);
			}
		}
		return conn;
	}

	private Socket getInboundSocket(AcceptedSocket socket1,
			AcceptedSocket socket2) {
		return socket1.origin == inboundAcceptor ? socket1.socket
				: socket2.socket;
	}

	private Socket getOutboundSocket(AcceptedSocket socket1,
			AcceptedSocket socket2) {
		return socket1.origin == outboundAcceptor ? socket1.socket
				: socket2.socket;
	}

	protected AcceptorThread createAcceptThread(int port)
			throws SocketException, IOException {
		SocketFactory ss = this.hapiContext.getSocketFactory();
		return new AcceptorThread(port, tls, getExecutorService(), queue, ss);
	}

	/**
	 * Run server from command line. Inbound and outbound port numbers should be
	 * provided as arguments, and a file containing a list of Applications to
	 * use can also be specified as an optional argument (as per
	 * <code>super.loadApplicationsFromFile(...)</code>). Uses the default
	 * LowerLayerProtocol.
	 */
	public static void main(String args[]) {
		if (args.length < 2 || args.length > 3) {
			System.out
					.println("Usage: ca.uhn.hl7v2.app.TwoPortService inbound_port outbound_port [application_spec_file_name]");
			System.exit(1);
		}

		int inPort = 0;
		int outPort = 0;
		try {
			inPort = Integer.parseInt(args[0]);
			outPort = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("One of the given ports (" + args[0] + " or "
					+ args[1] + ") is not an integer.");
			System.exit(1);
		}

		File appFile = null;
		if (args.length == 3) {
			appFile = new File(args[2]);
		}

		try {
			TwoPortService server = new TwoPortService(inPort, outPort);
			if (appFile != null)
				server.loadApplicationsFromFile(appFile);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
