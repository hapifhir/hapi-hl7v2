/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AcceptorThread.java".  Description: 
"A TCP/IP-based HL7 Service that uses separate ports for inbound and outbound messages." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.concurrent.Service;

/**
 * A Runnable that accepts connections on a ServerSocket and adds them to a
 * {@link BlockingQueue}, so that they can be handled asynchronously. After
 * stop() is called, the ServerSocket is closed.
 */
class AcceptorThread extends Service {

	static final int TIMEOUT = 500;
	private static final Logger log = LoggerFactory
			.getLogger(AcceptorThread.class);
	private int port;
	private boolean tls = false;
	private ServerSocket ss;
	private final BlockingQueue<AcceptedSocket> queue;

	public AcceptorThread(int port, ExecutorService service,
			BlockingQueue<AcceptedSocket> queue) throws IOException,
			SocketException {
		this(port, false, service, queue);
	}

	public AcceptorThread(int port, boolean tls, ExecutorService service,
			BlockingQueue<AcceptedSocket> queue) throws IOException,
			SocketException {
		super("Socket Acceptor", service);
		this.port = port;
		this.queue = queue;
		this.tls = tls;
	}

	@Override
	protected void afterStartup() {
		try {
			ss = createServerSocket(port);
			ss.setSoTimeout(TIMEOUT);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void handle() {
		try {
			Socket s = ss.accept();
			s.setSoTimeout(TIMEOUT);
			if (!queue.offer(new AcceptedSocket(s))) {
				log.error("Denied enqueuing server-side socket {}", s);
				s.close();
			} else
				log.debug("Enqueued server-side socket {}", s);
		} catch (SocketTimeoutException e) { /* OK - just timed out */
			log.trace("No connection established in recent {} ms.", TIMEOUT);
		} catch (IOException e) {
			log.error("Error while accepting connections", e);
		}
	}

	@Override
	protected void afterTermination() {
		try {
			if (ss != null && !ss.isClosed())
				ss.close();
		} catch (IOException e) {
			log.warn("Error during stopping the thread", e);
		}
	}

	protected ServerSocket createServerSocket(int port) throws IOException {
		ServerSocketFactory socketFactory = tls ? SSLServerSocketFactory
				.getDefault() : ServerSocketFactory.getDefault();
		return socketFactory.createServerSocket(port);
	}

	class AcceptedSocket {
		Socket socket;
		AcceptorThread origin;

		public AcceptedSocket(Socket socket) {
			if (socket == null)
				throw new IllegalArgumentException("Socket must not be null");
			this.socket = socket;
			this.origin = AcceptorThread.this;
		}

	}

}