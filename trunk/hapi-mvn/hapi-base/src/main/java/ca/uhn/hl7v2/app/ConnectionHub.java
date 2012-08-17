/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConnectionHub.java".  Description: 
"Provides access to shared HL7 Connections" 

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

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.SocketFactory;

/**
 * <p>
 * Provides access to shared HL7 Connections. The ConnectionHub has at most one
 * connection to any given address at any time.
 * </p>
 * <p>
 * <b>Synchronization Note:</b> This class should be safe to use in a
 * multithreaded environment. A synchronization mutex is maintained for any
 * given target host and port, so that if two threads are trying to connect to
 * two separate destinations neither will block, but if two threads are trying
 * to connect to the same destination, one will block until the other has
 * finished trying. Use caution if this class is to be used in an environment
 * where a very large (over 1000) number of target host/port destinations will
 * be accessed at the same time.
 * </p>
 * 
 * @author Bryan Tripp
 */
public class ConnectionHub {

	private static ConnectionHub instance = null;
	private static final Logger log = LoggerFactory
			.getLogger(ConnectionHub.class);
	/**
	 * Set a system property with this key to a string containing an integer
	 * larger than the default ("1000") if you need to connect to a very large
	 * number of targets at the same time in a multithreaded environment.
	 */
	public static final String MAX_CONCURRENT_TARGETS = ConnectionHub.class
			.getName() + ".maxSize";
	private final ConcurrentMap<String, String> connectionMutexes = new ConcurrentHashMap<String, String>();
	private final CountingMap<ConnectionData, Connection> connections;
	private final ExecutorService executorService;
	
	/** Creates a new instance of ConnectionHub */
	private ConnectionHub(ExecutorService executorService) {
		this.executorService = executorService;
		connections = new CountingMap<ConnectionData, Connection>() {

			@Override
			protected void dispose(Connection connection) {
				connection.close();
			}

			@Override
			protected Connection open(ConnectionData connectionData)
					throws Exception {
				return ConnectionFactory.open(connectionData,
						ConnectionHub.this.executorService);
			}

		};
	}

	public Set<? extends ConnectionData> allConnections() {
		return connections.keySet();
	}

	public Connection attach(ConnectionData data) throws HL7Exception {
		try {
			Connection conn = null;
			// Disallow establishing same connection targets concurrently
			connectionMutexes.putIfAbsent(data.toString(), data.toString());
			String mutex = connectionMutexes.get(data.toString());
			synchronized (mutex) {
				discardConnectionIfStale(connections.get(data));
				// Create connection or increase counter
				conn = connections.put(data);
			}
			return conn;
		} catch (Exception e) {
			log.error("Failed to attach", e);
			throw new HL7Exception("Cannot open connection to "
					+ data.getHost() + ":" + data.getPort() + "/"
					+ data.getPort2(), e);
		}
	}

	public Connection attach(String host, int outboundPort, int inboundPort,
			Parser parser, Class<? extends LowerLayerProtocol> llpClass)
			throws HL7Exception {
		return attach(host, outboundPort, inboundPort, parser, llpClass, false);
	}

	public Connection attach(String host, int outboundPort, int inboundPort,
			Parser parser, Class<? extends LowerLayerProtocol> llpClass,
			boolean tls) throws HL7Exception {
		try {
			LowerLayerProtocol llp = llpClass.newInstance();
			return attach(host, outboundPort, inboundPort, parser, llp, tls);
		} catch (InstantiationException e) {
			throw new HL7Exception("Cannot open connection to " + host + ":"
					+ outboundPort, e);
		} catch (IllegalAccessException e) {
			throw new HL7Exception("Cannot open connection to " + host + ":"
					+ outboundPort, e);
		}
	}

	public Connection attach(String host, int outboundPort, int inboundPort, Parser parser, LowerLayerProtocol llp, boolean tls) throws HL7Exception {
		return attach(host, outboundPort, inboundPort, parser, llp, tls, null);
	}

	public Connection attach(String host, int outboundPort, int inboundPort, Parser parser, LowerLayerProtocol llp, boolean tls, SocketFactory socketFactory) throws HL7Exception {
		return attach(new ConnectionData(host, outboundPort, inboundPort,
				parser, llp, tls, socketFactory));
	}

	/**
	 * Returns a Connection to the given address, opening this Connection if
	 * necessary. The given Parser will only be used if a new Connection is
	 * opened, so there is no guarantee that the Connection returned will be
	 * using the Parser you provide. If you need explicit access to the Parser
	 * the Connection is using, call <code>Connection.getParser()</code>.
	 */
	public Connection attach(String host, int port, Parser parser,
			Class<? extends LowerLayerProtocol> llpClass) throws HL7Exception {
		return attach(host, port, parser, llpClass, false);
	}

	public Connection attach(String host, int port, Parser parser,
			Class<? extends LowerLayerProtocol> llpClass, boolean tls)
			throws HL7Exception {
		return attach(host, port, 0, parser, llpClass, tls);
	}

	public Connection attach(String host, int port, Parser parser,
			LowerLayerProtocol llp)
			throws HL7Exception {
		return attach(host, port, 0, parser, llp, false);
	}

	public Connection attach(String host, int port, Parser parser,
			LowerLayerProtocol llp, boolean tls)
			throws HL7Exception {
		return attach(host, port, 0, parser, llp, tls);
	}

	public Connection attach(String host, int port, Parser parser,
			LowerLayerProtocol llp, boolean tls, SocketFactory socketFactory)
			throws HL7Exception {
		return attach(host, port, 0, parser, llp, tls, socketFactory);
	}

	/**
	 * Informs the ConnectionHub that you are done with the given Connection -
	 * if no other code is using it, it will be closed, so you should not
	 * attempt to use a Connection after detaching from it. If the connection is
	 * not enlisted, this method does nothing.
	 */
	public void detach(Connection c) {
		ConnectionData cd = connections.find(c);
		if (cd != null)
			connections.remove(cd);
	}

	
	/**
	 * Closes and discards the given Connection so that it can not be returned
	 * in subsequent calls to attach(). This method is to be used when there is
	 * a problem with a Connection, e.g. socket connection closed by remote
	 * host.
	 */
	public void discard(Connection c) {
		ConnectionData cd = connections.find(c);
		if (cd != null)
			connections.removeAllOf(cd);
	}

	public void discardAll() {
		for (ConnectionData cd : allConnections()) {
			connections.removeAllOf(cd);
		}
	}

	private void discardConnectionIfStale(Connection conn) {
		if (conn != null && !conn.isOpen()) {
			log.info(
					"Discarding connection which appears to be closed. Remote addr: {}",
					conn.getRemoteAddress());
			discard(conn);
			conn = null;
		}
	}

	public Connection getKnownConnection(ConnectionData key) {
		return connections.get(key);
	}

	public boolean isOpen(ConnectionData key) {
		return getKnownConnection(key).isOpen();
	}

	/** 
	 * Returns the singleton instance of ConnectionHub 
	 * @deprecated Use {@link HapiContext#getConnectionHub()} to get an instance of ConnectionHub. See {@link http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html this example page} for an example of how to use ConnectionHub.
	 */
	public static ConnectionHub getInstance() {
		return getInstance(DefaultExecutorService.getDefaultService());
	}

	/** 
	 * Returns the singleton instance of ConnectionHub.
	 * 
	 * @deprecated Use {@link HapiContext#getConnectionHub()} to get an instance of ConnectionHub. See {@link http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html this example page} for an example of how to use ConnectionHub.
	 */
	public synchronized static ConnectionHub getInstance(ExecutorService service) {
		if (instance == null || service.isShutdown()) {
			instance = new ConnectionHub(service);
		}
		return instance;
	}

	/**
	 * <p>
	 * Returns a new (non-singleton) instance of the ConnectionHub which uses the
	 * given executor service.
	 * </p>
	 * <p>
	 * See {@link http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html this example page} for an example of how to use ConnectionHub.
	 * </p>
	 */
	public synchronized static ConnectionHub getNewInstance(ExecutorService service) {
		return new ConnectionHub(service);
	}


	/**
	 * @deprecated default executor service is shut down automatically
	 */
	public static void shutdown() {
		ConnectionHub hub = getInstance();
		if (DefaultExecutorService.isDefaultService(hub.executorService)) {
			hub.executorService.shutdown();
			instance = null;
		}
	}


	/**
	 * Helper class that implements a map that increases/decreases a counter
	 * when an entry is added/removed. It is furthermore intended that an
	 * entry's value is derived from its key.
	 * 
	 * @param <K>
	 *            key class
	 * @param <D>
	 *            managed value class
	 */
	private abstract class CountingMap<K, D> {
		private Map<K, Count> content;

		public CountingMap() {
			super();
			content = new ConcurrentHashMap<K, Count>();
		}

		protected abstract void dispose(D value);

		public K find(D value) {
			for (Map.Entry<K, Count> entry : content.entrySet()) {
				if (entry.getValue().getValue().equals(value)) {
					return entry.getKey();
				}
			}
			return null;
		}

		public D get(K key) {
			return content.containsKey(key) ? content.get(key).getValue()
					: null;
		}

		public Set<K> keySet() {
			return Collections.unmodifiableSet(content.keySet());
		}

		protected abstract D open(K key) throws Exception;

		/**
		 * If the key exists, the counter is increased. Otherwise, a value is
		 * created, and the key/value pair is added to the map.
		 */
		public D put(K key) throws Exception {
			if (content.containsKey(key)) {
				return content.put(key, content.get(key).increase()).getValue();
			} else {
				Count c = new Count(open(key));
				content.put(key, c);
				return c.getValue();
			}
		}

		/**
		 * If the counter of the key/value is greater than one, the counter is
		 * decreased. Otherwise, the entry is removed and the value is cleaned
		 * up.
		 */
		public D remove(K key) {
			Count pair = content.get(key);
			if (pair == null)
				return null;
			if (pair.isLast()) {
				return removeAllOf(key);
			}
			return content.put(key, content.get(key).decrease()).getValue();
		}

		/**
		 * The key/value entry is removed and the value is cleaned up.
		 */
		public D removeAllOf(K key) {
			D removed = content.remove(key).value;
			dispose(removed);
			return removed;
		}

		private class Count {
			private int count;
			private D value;

			public Count(D value) {
				this(value, 1);
			}

			private Count(D value, int number) {
				this.value = value;
				this.count = number;
			}

			Count decrease() {
				return !isLast() ? new Count(value, count - 1) : null;
			}

			public D getValue() {
				return value;
			}

			Count increase() {
				return new Count(value, count + 1);
			}

			boolean isLast() {
				return count == 1;
			}

		}

	}

}
