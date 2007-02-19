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
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.app;

import java.io.*;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.*;

/**
 * <p>An HL7 service.  Accepts incoming TCP/IP connections and creates Connection 
 * objects.  Uses a single MessageTypeRouter object (for all Connections) to define 
 * the Applications to which message are sent.  To configure, use registerApplication() 
 * or loadApplicationsFromFile().  </p>
 * </p>A separate thread looks for Connections that have been closed (locally or remotely) 
 * and discards them. </p>
 * @author Bryan Tripp
 */
public abstract class HL7Service implements Runnable {

    private Vector connections;
    private boolean keepRunning;
    protected Parser parser;
    protected LowerLayerProtocol llp;
    private MessageTypeRouter router;
    private ArrayList listeners;

    /** Creates a new instance of Server */
    public HL7Service(Parser parser, LowerLayerProtocol llp) {
        connections = new Vector();
        listeners = new ArrayList();
        this.parser = parser;
        this.llp = llp;
        this.router = new MessageTypeRouter();
    }

    /** 
     * Implemented by subclasses to accept remote connections, create Connection
     * objects, and call <code>newConnection()</code>.  Must stop running when 
     * <code>keepRunning()</code> returns false, and clean up all resources before
     * exiting.  If this method quits because of an exception, it must call 
     * HL7Service.stop() before exiting.  
     */
    public abstract void run();

    /** Returns true if the thread should continue to run, false otherwise (ie if stop() has been called). */
    protected boolean keepRunning() {
        return keepRunning;
    }

    /** 
     * Starts the server listening for connections in a new thread.  This continues 
     * until <code>stop()</code> is called.  
     */
    public void start() {
        Thread thd = new Thread(this);
        this.keepRunning = true;
        thd.start();
        //Fix for bug 960101:  Don't start the cleaner thread until the server is started.
        Thread cleaner = new Thread(new HL7Service.ConnectionCleaner(this));
        cleaner.start();
    }

    /**
     * Stops the server from listening for new connections, and closes all existing
     * Connections.  
     */
    public void stop() {
        this.keepRunning = false;
        for (int i = 0; i < connections.size(); i++) {
            ((Connection) connections.get(i)).close();
        }
    }

    /** 
     * Called by subclasses when a new Connection is made.  Registers the 
     * MessageTypeRouter with the given Connection and stores it. 
     */
    public synchronized void newConnection(Connection c) {
        c.getResponder().registerApplication(router);
        this.connections.add(c); //keep track of connections  
        notifyListeners(c);
    }

    private synchronized void discardConnection(Connection c) {
        this.connections.remove(c);
        notifyListeners(c);
    }

    /**
     * Returns a connection to a remote host that was initiated by the given remote host.  
     * If the connection has not been made, this method blocks until the remote host 
     * connects.  
     */
    public Connection getRemoteConnection(String IP) {
        Connection conn = null;
        while (conn == null) {
            //check all connections ...
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
                }
                catch (InterruptedException e) {
                }
            }
        }
        return conn;
    }

    /** Returns all currently active connections. */
    public synchronized Vector getRemoteConnections() {
        return connections;
    }

    /**
     * Registers the given ConnectionListener with the HL7Service - when a remote host
     * makes a new Connection, all registered listeners will be notified.  
     */
    public synchronized void registerConnectionListener(ConnectionListener listener) {
        this.listeners.add(listener);
    }

    /** Notifies all listeners that a Connection is new or discarded. */
    private void notifyListeners(Connection c) {
        for (int i = 0; i < listeners.size(); i++) {
            ConnectionListener cl = (ConnectionListener) listeners.get(i);
            if (c.isOpen()) {
                cl.connectionReceived(c);
            }
            else {
                cl.connectionDiscarded(c);
            }
        }
    }

    /**
     * Registers the given application to handle messages corresponding to the given type
     * and trigger event.  Only one application can be registered for a given message type
     * and trigger event combination.  A repeated registration for a particular combination 
     * of type and trigger event over-writes the previous one.  Note that the wildcard "*" 
     * for messageType or triggerEvent means any type or event, respectively.   
     */
    public synchronized void registerApplication(String messageType, String triggerEvent, Application handler) {
        this.router.registerApplication(messageType, triggerEvent, handler);
    }

    /**
     * <p>A convenience method for registering applications (using <code>registerApplication()
     * </code>) with this service.  Information about which Applications should handle which 
     * messages is read from the given text file.  Each line in the file should have the 
     * following format (entries tab delimited):</p>
     * <p>message_type &#009; trigger_event &#009; application_class</p>
     * <p>message_type &#009; trigger_event &#009; application_class</p>
     * <p>Note that message type and event can be the wildcard "*", which means any.</p>
     * <p>For example, if you write an Application called org.yourorganiztion.ADTProcessor
     * that processes several types of ADT messages, and another called 
     * org.yourorganization.ResultProcessor that processes result messages, you might have a 
     * file that looks like this: </p>
     * <p>ADT &#009; * &#009; org.yourorganization.ADTProcessor<br>
     * ORU &#009; R01 &#009; org.yourorganization.ResultProcessor</p>
     * <p>Each class listed in this file must implement Application and must have a zero-argument
     * constructor.</p>
     */
    public void loadApplicationsFromFile(File f)
        throws IOException, HL7Exception, ClassNotFoundException, InstantiationException, IllegalAccessException {
        BufferedReader in = new BufferedReader(new FileReader(f));
        String line = null;
        while ((line = in.readLine()) != null) {
            //parse application registration information 
            StringTokenizer tok = new StringTokenizer(line, "\t", false);
            String type = null, event = null, className = null;

            if (tok.hasMoreTokens()) { //skip blank lines 
                try {
                    type = tok.nextToken();
                    event = tok.nextToken();
                    className = tok.nextToken();
                }
                catch (NoSuchElementException ne) {
                    throw new HL7Exception(
                        "Can't register applications from file "
                            + f.getName()
                            + ". The line '"
                            + line
                            + "' is not of the form: message_type [tab] trigger_event [tab] application_class.",
                        HL7Exception.APPLICATION_INTERNAL_ERROR);
                }

                Class appClass = Class.forName(className); //may throw ClassNotFoundException 
                Object appObject = appClass.newInstance();
                Application app = null;
                try {
                    app = (Application) appObject;
                }
                catch (ClassCastException cce) {
                    throw new HL7Exception(
                        "The specified class, " + appClass.getName() + ", doesn't implement Application.",
                        HL7Exception.APPLICATION_INTERNAL_ERROR);
                }

                this.registerApplication(type, event, app);
            }
        }
    }

    /** 
     * Runnable that looks for closed Connections and discards them. 
     * It would be nice to find a way to externalize this safely so that it could be 
     * re-used by (for example) TestPanel.  It could take a Vector of Connections
     * as an argument, instead of an HL7Service, but some problems might arise if 
     * other threads were iterating through the Vector while this one was removing
     * elements from it.  
     */
    private class ConnectionCleaner implements Runnable {

        HL7Service service;

        public ConnectionCleaner(HL7Service service) {
            this.service = service;
        }

        public void run() {
            while (keepRunning()) {
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                }

                synchronized (service) {
                    Iterator it = service.getRemoteConnections().iterator();
                    while (it.hasNext()) {
                        Connection conn = (Connection) it.next();
                        if (!conn.isOpen()) {
                            it.remove();
                            service.notifyListeners(conn);
                        }
                    }
                    
                    //build list to discard (don't discard while iterating!)
                    /*ArrayList toDiscard = new ArrayList();
                    for (int i = 0; i < service.getRemoteConnections().size(); i++) {
                        Connection conn = (Connection) service.getRemoteConnections().get(i);
                        if (!conn.isOpen()) {
                            toDiscard.add(conn);
                        }
                    }
                    for (int i = 0; i < toDiscard.size(); i++) {
                        service.discardConnection((Connection) toDiscard.get(i));
                    }*/
                }
            }
        }

    }

}
