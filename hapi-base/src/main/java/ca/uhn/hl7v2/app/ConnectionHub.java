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

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>
 * Provides access to shared HL7 Connections.  The ConnectionHub 
 * has at most one connection to any given address at any time.  
 * </p>
 * <p>
 * <b>Synchronization Note:</b> This class should be safe to use in a multithreaded
 * environment. A synchronization mutex is maintained for any given target host and port,
 * so that if two threads are trying to connect to two separate destinations neither will
 * block, but if two threads are trying to connect to the same destination, one will block
 * until the other has finished trying. Use caution if this class is to be used in an 
 * environment where a very large (over 1000) number of target host/port destinations
 * will be accessed at the same time.
 * </p>
 * @author Bryan Tripp
 */
public class ConnectionHub {
    
	/**
	 * Set a system property with this key to a string containing an integer larger 
	 * than the default ("1000") if you need to connect to a very large number of
	 * targets at the same time in a multithreaded environment.
	 */
    public static final String MAX_CONCURRENT_TARGETS = ConnectionHub.class.getName() + ".maxSize";

	private static final HapiLog log = HapiLogFactory.getHapiLog(ConnectionHub.class);

    private static ConnectionHub instance = null;
    private final Map<String, Connection> connections;
    private final Map<String, Socket> sockets;
    private final Map<Integer, Integer> numRefs;
    private final Map<String, String> connectionMutexes;
    
    /** Creates a new instance of ConnectionHub */
    private ConnectionHub() {
        connections = new HashMap<String, Connection>(20);
        sockets = new HashMap<String, Socket>(20);
        numRefs = new HashMap<Integer, Integer>(20);
        connectionMutexes = Collections.synchronizedMap(new LinkedHashMap<String, String>(5, 0.75f, true) {

            private static final long serialVersionUID = 1L;
            final int maxSize = new Integer(System.getProperty(MAX_CONCURRENT_TARGETS, "1000"));

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return this.size() > maxSize;
            }
        });

    }
    
    /** Returns the singleton instance of ConnectionHub */
    public synchronized static ConnectionHub getInstance() {
        if (instance == null) {
            instance = new ConnectionHub();
        } 
        return instance;
    }
    
    /**
     * Returns a Connection to the given address, opening this 
     * Connection if necessary. The given Parser will only be used if a new Connection 
     * is opened, so there is no guarantee that the Connection returned will be using the 
     * Parser you provide.  If you need explicit access to the Parser the Connection 
     * is using, call <code>Connection.getParser()</code>. 
     */
    public Connection attach(String host, int port, Parser parser, Class<? extends LowerLayerProtocol> llpClass) throws HL7Exception {
        
    	// For every permutation of this
    	String connectionMutex = host + ":" + port;
    	synchronized (connectionMutexes) {
        	if (connectionMutexes.containsKey(connectionMutex)) {
        		connectionMutex = connectionMutexes.get(connectionMutex);
        	} else {
        		connectionMutexes.put(connectionMutex, connectionMutex);
        	}
        }
    	
    	Connection conn;
    	synchronized (connectionMutex) {
			conn = getExisting(host, port, parser.getClass(), llpClass);
	        if (conn != null && !conn.isOpen()) {
	            
	            if (log.isDebugEnabled()) {
	                log.debug("Discarding connection which appears to be closed. Remote addr: " + conn.getRemoteAddress());
	            }
	            
	            close(conn);
	            conn = null;
	        }
	        
	        if (conn == null) {
	            try {
	                //Parser p = (Parser) parserClass.newInstance();
	                LowerLayerProtocol llp = llpClass.newInstance();
	                conn = connect(host, port, parser, llp);
	            } catch (ClassCastException e) {
	                //Log.tryToLog(cce, "Problem opening new connection to " + host + " port " + port);
	                throw new HL7Exception( "ClassCastException - need a LowerLayerProtocol class to get an Inititator", 
	                                        HL7Exception.APPLICATION_INTERNAL_ERROR,
	                                        e);
	            } catch (Exception e) {
	                //Log.tryToLog(e, "Problem opening new connection to " + host + " port " + port);
	                throw new HL7Exception( "Can't connect to " + host + " port " + port + ": " + e.getClass().getName() + ": " + e.getMessage(), 
	                                        HL7Exception.APPLICATION_INTERNAL_ERROR,
	                                        e);
	            }
	        }
	        incrementRefs(conn);
	        
    	} // synchronized
    	
        return conn;
    }
    
    /** Returns an existing connection if one exists, null otherwise */    
    private Connection getExisting(String host, int port, Class parserClass, Class llpClass) {
        Connection existing = null;
        Object o = connections.get(makeHashKey(host, port, parserClass, llpClass));
        if (o != null) existing = (Connection) o;
        return existing;
    }
    
    /** 
     * Opens a connection to the given address, and stores it in the 
     * connections Hash. 
     */
    private Connection connect(String host, int port, Parser parser, LowerLayerProtocol llp) throws UnknownHostException, IOException, LLPException {
        Socket s = new Socket(host, port);
        Connection i = new Connection(parser, llp, s);
        connections.put(makeHashKey(host, port, parser.getClass(), llp.getClass()), i);
        sockets.put(makeHashKey(host, port, parser.getClass(), llp.getClass()), s);
        return i;
    }
    
    /**
     * Informs the ConnectionHub that you are done with the given Connection - 
     * if no other code is using it, it will be closed, so you should not 
     * attempt to use a Connection after detaching from it.  
     */
    public void detach(Connection c) {
        int refs = decrementRefs(c);
        if (refs == 0) {
            close(c);
        }
    }
    
    /**
     * Closes and discards the given Concection so that it can not be returned 
     * in subsequent calls to attach().  This method is to be used when there 
     * is a problem with a Connection, e.g. socket connection closed by remote host.  
     */
    public void discard(Connection c) {
        close(c);
    }
    
    /** Closes the given connection & removes from hash - to be called when there are 0 references to it */
    private void close(Connection c) {
        c.close();
        
        //remove from "connections"  
        Iterator keys = connections.keySet().iterator();
        boolean removed = false;
        while (keys.hasNext() && !removed) {
            Object key = keys.next();
            Object val = connections.get(key);
            if (val.hashCode() == c.hashCode()) { 
                connections.remove(key);
                numRefs.remove(new Integer(c.hashCode()));
                removed = true;
            }
        }
    }
    
    /**
     * This should be called to indicate that a new party is using the 
     * given Connection. 
     * @returns the number of times this Connection is referenced
     */
    private int incrementRefs(Connection c) {
        return updateRefs(c, 1);  
    }
    
    /**
     * This should be called to indicate that some party is ceasing use of the 
     * given Connection. 
     * @returns the number of times this Connection is referenced
     */
    private int decrementRefs(Connection c) {
        return updateRefs(c, -1);  
    }
    
    /** Updates the number of references to i - used by incrementRefs and decrementRefs */
    private synchronized int updateRefs(Connection c, int change) {
        Integer hashCode = new Integer(c.hashCode());
        Object o = numRefs.get(hashCode);
        int existingRefs = 0;
        if (o != null) {
            existingRefs = ((Integer)o).intValue();            
        }
        Integer newRefs = new Integer(existingRefs + change);
        numRefs.put(hashCode, newRefs);
        return newRefs.intValue();
    }

    /**
     * Creates a consistent hash key using a host (recommend use IP address, not host name),  
     * port number, and the class names of a Parser and LowerLayerProtocol.  In other words, 
     * allows us to store and retrieve remote connections using a hash map. 
     */
    private static String makeHashKey(String IP, int port, Class parserClass, Class llpClass) {
        StringBuffer key = new StringBuffer(); 
        key.append(IP);
        key.append(":");
        key.append(port);
        key.append(":");
        key.append(parserClass.getName());
        key.append(":");
        key.append(llpClass.getName());        
        return key.toString();
    }
}
