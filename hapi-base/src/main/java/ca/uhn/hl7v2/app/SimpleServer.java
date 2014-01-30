/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "SimpleServer.java".  Description:
 * "A simple TCP/IP-based HL7 server."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): Kyle Buza
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.app;

import java.io.File;
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
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.SocketFactory;

/**
 * <p>
 * A simple TCP/IP-based HL7 server. This server listens for connections on a
 * particular port, and creates a ConnectionManager for each incoming
 * connection.
 * </p>
 * <p>
 * A single SimpleServer can only service requests that use a single class of
 * LowerLayerProtocol (specified at construction time).
 * </p>
 * <p>
 * The ConnectionManager uses a {@link PipeParser} of the version specified in
 * the constructor
 * </p>
 * <p>
 * ConnectionManagers currently only support original mode processing.
 * </p>
 * <p>
 * The ConnectionManager routes messages to various {@link Application}s based
 * on message type. From the HL7 perspective, an {@link Application} is
 * something that does something with a message.
 * </p>
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class SimpleServer extends HL7Service {

	/**
	 * Socket timeout for simple server
	 */
	public static final int SO_TIMEOUT = AcceptorThread.TIMEOUT;

	private static final Logger log = LoggerFactory.getLogger(SimpleServer.class);
	
	private int port;
	private boolean tls;
	private final BlockingQueue<AcceptedSocket> queue;
	private AcceptorThread acceptor;
	private HapiContext hapiContext;

	/**
	 * Creates a new instance of SimpleServer that listens on the given port,
	 * using the {@link MinLowerLayerProtocol} and a standard {@link PipeParser}.
	 */
	public SimpleServer(int port) {
		this(port, new MinLowerLayerProtocol(), new PipeParser(), false);
	}
	
	/**
	 * Creates a new instance of SimpleServer that listens on the given port,
	 * using the {@link MinLowerLayerProtocol} and a standard {@link PipeParser}.
	 */
	public SimpleServer(int port, boolean tls) {
		this(port, new MinLowerLayerProtocol(), new PipeParser(), tls);
	}	

	/**
	 * Creates a new instance of SimpleServer that listens on the given port.
	 */
	public SimpleServer(int port, LowerLayerProtocol llp, Parser parser) {
		this(port, llp, parser, false);
	}
	
	/**
	 * Creates a new instance of SimpleServer that listens on the given port.
	 */
	public SimpleServer(int port, LowerLayerProtocol llp, Parser parser, boolean tls) {
		this(port, llp, parser, tls, DefaultExecutorService.getDefaultService());
	}

	/**
	 * Creates a new instance of SimpleServer using a custom {link
	 * {@link ExecutorService}. This {@link ExecutorService} instance will
	 * <i>not</i> be shut down after the server stops!
	 */
	public SimpleServer(int port, LowerLayerProtocol llp, Parser parser, boolean tls,
			ExecutorService executorService) {
		super(parser, llp, executorService);
		this.port = port;
		this.tls = tls;
		this.hapiContext = new DefaultHapiContext();
		this.queue = new LinkedBlockingQueue<AcceptedSocket>(100);
	}

	/**
	 * Creates a new instance of SimpleServer that listens on a given server socket.
	 * SimpleServer will bind the socket when it is started, so the server socket 
	 * must not already be bound. 
	 * 
	 * @since 2.1
	 * @throws IllegalStateException If serverSocket is already bound
	 */
	public SimpleServer(HapiContext hapiContext, int port, boolean tls) {
		super(hapiContext);
		this.hapiContext = hapiContext;
		this.port = port;
		this.tls = tls;
		this.queue = new LinkedBlockingQueue<AcceptedSocket>(100);
	}

	/**
	 * Prepare server by initializing the server socket
	 * 
	 * @see ca.uhn.hl7v2.app.HL7Service#afterStartup()
	 */
	@Override
	protected void afterStartup() {
		try {
			super.afterStartup();
			log.info("Starting SimpleServer running on port {}", port);
			SocketFactory ss = this.hapiContext.getSocketFactory();
			acceptor = new AcceptorThread(port, tls, getExecutorService(), queue, ss);
			acceptor.start();
		} catch (Exception e) {
			log.error("Failed starting SimpleServer on port", port);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Loop that waits for a connection and starts a ConnectionManager when it
	 * gets one.
	 */
	@Override
	protected void handle() {
		if (acceptor.getServiceExitedWithException() != null) {
			setServiceExitedWithException(acceptor.getServiceExitedWithException());
		}
		
		try {
			// Wait some period of time for connections
			AcceptedSocket newSocket = queue.poll(500, TimeUnit.MILLISECONDS);
			if (newSocket != null) {
				log.info("Accepted connection from {}:{} on local port {}", 
						new Object[] { newSocket.socket.getInetAddress().getHostAddress(), newSocket.socket.getPort(), port });
				ActiveConnection c = new ActiveConnection(getParser(), getLlp(), newSocket.socket,
						getExecutorService());
				newConnection(c);
			}
		} catch (InterruptedException ie) { 
			// just timed out
		} catch (Exception e) {
			log.error("Error while accepting connections: ", e);
		}
	}

	/**
	 * Close down socket
	 */
	@Override
	protected void afterTermination() {
		super.afterTermination();
		acceptor.stop();
	}

	/**
	 * Run server from command line. Port number should be passed as an
	 * argument, and a file containing a list of Applications to use can also be
	 * specified as an optional argument (as per
	 * <code>loadApplicationsFromFile(...)</code>). Uses the default
	 * LowerLayerProtocol.
	 */
	public static void main(String args[]) {
		if (args.length < 1 || args.length > 2) {
			System.out
					.println("Usage: ca.uhn.hl7v2.app.SimpleServer port_num [application_spec_file_name]");
			System.exit(1);
		}

		int port = 0;
		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.err.println("The given port (" + args[0]
					+ ") is not an integer.");
			System.exit(1);
		}

		File appFile = null;
		if (args.length == 2) {
			appFile = new File(args[1]);
		}

		try {
			SimpleServer server = new SimpleServer(port);
			if (appFile != null)
				server.loadApplicationsFromFile(appFile);
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
