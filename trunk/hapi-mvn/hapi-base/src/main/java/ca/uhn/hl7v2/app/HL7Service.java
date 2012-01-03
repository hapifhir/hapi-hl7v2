/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HL7Service.java".  Description: 
"Accepts incoming TCP/IP connections and creates Connection objects" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): Kyle Buza 

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.concurrent.Service;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;

/**
 * <p>
 * An HL7 service. Accepts incoming TCP/IP connections and creates Connection
 * objects. Uses a single MessageTypeRouter object (for all Connections) to
 * define the Applications to which message are sent. To configure, use
 * registerApplication() or loadApplicationsFromFile().
 * </p>
 * </p>A separate thread looks for Connections that have been closed (locally or
 * remotely) and discards them. </p>
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public abstract class HL7Service extends Service {

	private static final Logger log = LoggerFactory.getLogger(HL7Service.class);

	private List<Connection> connections;
	protected Parser parser;
	protected LowerLayerProtocol llp;
	private MessageTypeRouter router;
	private List<ConnectionListener> listeners;
	private ConnectionCleaner cleaner;

	/** Creates a new instance of Server using a default thread pool */
	public HL7Service(Parser parser, LowerLayerProtocol llp) {
		this(parser, llp, DefaultExecutorService.getDefaultService());
	}

	/** Creates a new instance of Server */
	public HL7Service(Parser parser, LowerLayerProtocol llp,
			ExecutorService executorService) {
		super("HL7 Server", executorService);
		connections = new ArrayList<Connection>();
		listeners = new ArrayList<ConnectionListener>();
		this.parser = parser;
		this.llp = llp;
		this.router = new MessageTypeRouter();
	}

	/**
	 * Called after startup before the thread enters its main loop. This
	 * implementation launches a cleaner thread that removes stale connections
	 * from the connection list. Override to initialize resources for the
	 * running thread, e.g. opening {@link ServerSocket}s etc.
	 * 
	 * @throws IOException
	 */
	@Override
	protected void afterStartup() {
		// Fix for bug 960101: Don't start the cleaner thread until the
		// server is started.
		cleaner = new ConnectionCleaner(this);
		getExecutorService().submit(cleaner);
	}

	/**
	 * Called after the thread has left its main loop. This implementation stops
	 * the connection cleaner thread and closes any open connections. Override
	 * to clean up additional resources from the running thread, e.g. closing
	 * {@link ServerSocket}s.
	 */
	@Override
	protected void afterTermination() {
		super.afterTermination();
		cleaner.stopAndWait();
		for (Connection c : connections) {
			c.close();
		}
	}

	/**
	 * Returns true if the thread should continue to run, false otherwise (ie if
	 * stop() has been called).
	 * 
	 * @deprecated Use {@link #isRunning()}. Deprecated as of version 0.6.
	 */
	protected boolean keepRunning() {
		return isRunning();
	}

	/**
	 * Called by subclasses when a new Connection is made. Registers the
	 * MessageTypeRouter with the given Connection and stores it.
	 */
	public synchronized void newConnection(Connection c) {
		c.getResponder().registerApplication(router);
		connections.add(c); // keep track of connections
		notifyListeners(c);
	}

	/**
	 * Returns a connection to a remote host that was initiated by the given
	 * remote host. If the connection has not been made, this method blocks
	 * until the remote host connects. TODO currently nobody calls this...
	 */
	public Connection getRemoteConnection(String IP) {
		Connection conn = null;
		while (conn == null) {
			// check all connections ...
			int c = 0;
			synchronized (this) {
				while (conn == null && c < connections.size()) {
					Connection nextConn = (Connection) connections.get(c);
					if (nextConn.getRemoteAddress().getHostAddress().equals(IP))
						conn = nextConn;
					c++;
				}
			}

			if (conn == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
		return conn;
	}

	/** Returns all currently active connections. */
	public synchronized List<Connection> getRemoteConnections() {
		return connections;
	}

	/**
	 * Registers the given ConnectionListener with the HL7Service - when a
	 * remote host makes a new Connection, all registered listeners will be
	 * notified.
	 */
	public synchronized void registerConnectionListener(
			ConnectionListener listener) {
		listeners.add(listener);
	}

	/** Notifies all listeners that a Connection is new or discarded. */
	private void notifyListeners(Connection c) {
		for (ConnectionListener cl : listeners) {
			if (c.isOpen()) {
				cl.connectionReceived(c);
			} else {
				cl.connectionDiscarded(c);
			}
		}
	}

	/**
	 * Registers the given application to handle messages corresponding to the
	 * given type and trigger event. Only one application can be registered for
	 * a given message type and trigger event combination. A repeated
	 * registration for a particular combination of type and trigger event
	 * over-writes the previous one. Note that the wildcard "*" for messageType
	 * or triggerEvent means any type or event, respectively.
	 */
	public synchronized void registerApplication(String messageType,
			String triggerEvent, Application handler) {
		router.registerApplication(messageType, triggerEvent, handler);
	}

	/**
	 * <p>
	 * A convenience method for registering applications (using
	 * <code>registerApplication()
	 * </code>) with this service. Information about which Applications should
	 * handle which messages is read from the given text file. Each line in the
	 * file should have the following format (entries tab delimited):
	 * </p>
	 * <p>
	 * message_type &#009; trigger_event &#009; application_class
	 * </p>
	 * <p>
	 * message_type &#009; trigger_event &#009; application_class
	 * </p>
	 * <p>
	 * Note that message type and event can be the wildcard "*", which means
	 * any.
	 * </p>
	 * <p>
	 * For example, if you write an Application called
	 * org.yourorganiztion.ADTProcessor that processes several types of ADT
	 * messages, and another called org.yourorganization.ResultProcessor that
	 * processes result messages, you might have a file that looks like this:
	 * </p>
	 * <p>
	 * ADT &#009; * &#009; org.yourorganization.ADTProcessor<br>
	 * ORU &#009; R01 &#009; org.yourorganization.ResultProcessor
	 * </p>
	 * <p>
	 * Each class listed in this file must implement Application and must have a
	 * zero-argument constructor.
	 * </p>
	 */
	public void loadApplicationsFromFile(File f) throws IOException,
			HL7Exception, ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		BufferedReader in = new BufferedReader(new FileReader(f));
		String line = null;
		while ((line = in.readLine()) != null) {
			// parse application registration information
			StringTokenizer tok = new StringTokenizer(line, "\t", false);
			String type = null, event = null, className = null;

			if (tok.hasMoreTokens()) { // skip blank lines
				try {
					type = tok.nextToken();
					event = tok.nextToken();
					className = tok.nextToken();
				} catch (NoSuchElementException ne) {
					throw new HL7Exception(
							"Can't register applications from file "
									+ f.getName()
									+ ". The line '"
									+ line
									+ "' is not of the form: message_type [tab] trigger_event [tab] application_class.",
							HL7Exception.APPLICATION_INTERNAL_ERROR);
				}

				try {
					@SuppressWarnings("unchecked")
					Class<? extends Application> appClass = (Class<? extends Application>) Class
							.forName(className); // may throw
													// ClassNotFoundException
					Application app = appClass.newInstance();
					registerApplication(type, event, app);
				} catch (ClassCastException cce) {
					throw new HL7Exception("The specified class, " + className
							+ ", doesn't implement Application.",
							HL7Exception.APPLICATION_INTERNAL_ERROR);
				}

			}
		}
	}

	/**
	 * Runnable that looks for closed Connections and discards them. It would be
	 * nice to find a way to externalize this safely so that it could be re-used
	 * by (for example) TestPanel. It could take a Vector of Connections as an
	 * argument, instead of an HL7Service, but some problems might arise if
	 * other threads were iterating through the Vector while this one was
	 * removing elements from it.
	 * 
	 * Note: this could be started as daemon, so we don't need to care about
	 * termination.
	 */
	private class ConnectionCleaner extends Service {

		HL7Service service;

		public ConnectionCleaner(HL7Service service) {
			super("ConnectionCleaner", service.getExecutorService());
			this.service = service;
		}

		public void handle() {
			try {
				Thread.sleep(500);
				synchronized (service) {
					Iterator<Connection> it = service.getRemoteConnections()
							.iterator();
					while (it.hasNext()) {
						Connection conn = it.next();
						if (!conn.isOpen()) {
							log.debug(
									"Removing connection from {} from connection list",
									conn.getRemoteAddress().getHostAddress());
							it.remove();
							service.notifyListeners(conn);
						}
					}
				}
			} catch (InterruptedException e) {
			}
		}

	}

}
