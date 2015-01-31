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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.concurrent.Service;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;
import ca.uhn.hl7v2.protocol.impl.AppWrapper;
import ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * <p>
 * An HL7 service. Accepts incoming TCP/IP connections and creates Connection
 * objects. Uses a single ApplicationRouter object (for all Connections) to
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

    private final List<Connection> connections;
    private final Parser parser;
    private final LowerLayerProtocol llp;
    private final List<ConnectionListener> listeners;
    private final ConnectionCleaner cleaner;
    private final ApplicationRouterImpl applicationRouter;

    /**
     * @param theHapiContext HapiContext
     */
    public HL7Service(HapiContext theHapiContext) {
        this(theHapiContext.getGenericParser(), theHapiContext.getLowerLayerProtocol(), theHapiContext.getExecutorService());
    }

    /**
     * @param parser parser to be used
     * @param llp    LowerLayerProtocol
     */
    public HL7Service(final Parser parser, final LowerLayerProtocol llp) {
        this(parser, llp, DefaultExecutorService.getDefaultService());
    }

    /**
     * Creates a new instance of Server
     *
     * @param parser          parser to be used
     * @param llp             LowerLayerProtocol
     * @param executorService executor used for starting threads
     */
    public HL7Service(Parser parser, LowerLayerProtocol llp,
                      ExecutorService executorService) {
        super("HL7 Server", executorService);
        this.connections = new ArrayList<Connection>();
        this.listeners = new ArrayList<ConnectionListener>();
        this.parser = parser;
        this.llp = llp;
        this.applicationRouter = new ApplicationRouterImpl(parser);
        this.cleaner = new ConnectionCleaner(this);

        // 960101
        assert !this.cleaner.isRunning();
    }

    /**
     * Called after startup before the thread enters its main loop. This
     * implementation launches a cleaner thread that removes stale connections
     * from the connection list. Override to initialize resources for the
     * running thread, e.g. opening {@link java.net.ServerSocket}s etc.
     */
    @Override
    protected void afterStartup() {
        // Fix for bug 960101: Don't start the cleaner thread until the
        // server is started.
        cleaner.start();
    }

    /**
     * Called after the thread has left its main loop. This implementation stops
     * the connection cleaner thread and closes any open connections. Override
     * to clean up additional resources from the running thread, e.g. closing
     * {@link java.net.ServerSocket}s.
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

    LowerLayerProtocol getLlp() {
        return llp;
    }

    Parser getParser() {
        return parser;
    }

    /**
     * Called by subclasses when a new Connection is made. Registers the
     * ApplicationRouter with the given Connection and stores it.
     *
     * @param c existing connection
     */
    public synchronized void newConnection(ActiveConnection c) {
        c.getResponder().setApplicationRouter(applicationRouter);
        c.activate();
        connections.add(c); // keep track of connections
        notifyListeners(c);
    }

    /**
     * Returns a connection to a remote host that was initiated by the given
     * remote host. If the connection has not been made, this method blocks
     * until the remote host connects.
     *
     * @param ipAddress IP Address
     * @return connection that was initiated by the given address
     */
    public Connection getRemoteConnection(String ipAddress) {
        Connection conn = null;
        while (conn == null) {
            // check all connections ...
            int c = 0;
            synchronized (this) {
                while (conn == null && c < connections.size()) {
                    Connection nextConn = connections.get(c);
                    if (nextConn.getRemoteAddress().getHostAddress().equals(ipAddress))
                        conn = nextConn;
                    c++;
                }
            }

            if (conn == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // don't care
                }
            }
        }
        return conn;
    }

    /**
     * Returns all currently active connections.
     *
     * @return list of active remote connections
     */
    public synchronized List<Connection> getRemoteConnections() {
        return connections;
    }

    /**
     * Registers the given ConnectionListener with the HL7Service - when a
     * remote host makes a new Connection, all registered listeners will be
     * notified.
     *
     * @param listener connection listener to be called
     */
    public synchronized void registerConnectionListener(
            ConnectionListener listener) {
        listeners.add(listener);
    }

    /**
     * Notifies all listeners that a Connection is new or discarded.
     */
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
     *
     * @deprecated use {@link #registerApplication(String, String, ca.uhn.hl7v2.protocol.ReceivingApplication)} and
     * {@link ca.uhn.hl7v2.protocol.impl.AppWrapper}
     */
    public synchronized void registerApplication(String messageType,
                                                 String triggerEvent, Application handler) {
        ReceivingApplication<Message> handlerWrapper = new AppWrapper(handler);
        applicationRouter.bindApplication(new AppRoutingDataImpl(messageType, triggerEvent, "*", "*"), handlerWrapper);
    }

    /**
     * Registers the given application to handle messages corresponding to the
     * given type and trigger event. Only one application can be registered for
     * a given message type and trigger event combination. A repeated
     * registration for a particular combination of type and trigger event
     * over-writes the previous one. Note that the wildcard "*" for messageType
     * or triggerEvent means any type or event, respectively.
     */
    public void registerApplication(String messageType, String triggerEvent, ReceivingApplication handler) {
        applicationRouter.bindApplication(new AppRoutingDataImpl(messageType, triggerEvent, "*", "*"), handler);
    }

    /**
     * Registers the given application to handle messages corresponding to ALL
     * message types and trigger events.
     */
    public synchronized void registerApplication(AppRoutingData appRouting, ReceivingApplication<? extends Message> application) {
        if (appRouting == null) {
            throw new NullPointerException("appRouting must not be null");
        }
        applicationRouter.bindApplication(appRouting, application);
    }

    /**
     * Registers the given application to handle messages corresponding to ALL
     * message types and trigger events.
     */
    public synchronized void registerApplication(ReceivingApplication<? extends Message> application) {

        registerApplication(new AppRoutingDataImpl("*", "*", "*", "*"), application);
    }

    /**
     * Unregisteres the first application that matches the routing data
     *
     * @param appRouting
     * @return true if an application was unregistered, false otherwise
     */
    public synchronized boolean unregisterApplication(AppRoutingData appRouting) {
        if (appRouting == null) {
            throw new NullPointerException("appRouting must not be null");
        }
        return applicationRouter.unbindApplication(appRouting);
    }

    /**
     * Unregisteres the passed application
     *
     * @param application receiving application
     * @return true if an application was unregistered, false otherwise
     */
    public synchronized boolean unregisterApplication(ReceivingApplication<? extends Message> application) {
        if (application == null) {
            throw new NullPointerException("application must not be null");
        }
        return applicationRouter.unbindApplication(application);
    }

    /**
     * Sets an exception handler which will be invoked in the event of a
     * failure during parsing, processing, or encoding of an
     * incoming message or its response.
     */
    public synchronized void setExceptionHandler(ReceivingApplicationExceptionHandler exHandler) {
        applicationRouter.setExceptionHandler(exHandler);
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
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                // parse application registration information
                StringTokenizer tok = new StringTokenizer(line, "\t", false);
                String type, event, className;

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
                                        + "' is not of the form: message_type [tab] trigger_event [tab] application_class.");
                    }

                    try {
                        @SuppressWarnings("unchecked")
                        Class<? extends Application> appClass = (Class<? extends Application>) Class
                                .forName(className); // may throw
                        // ClassNotFoundException
                        Application app = appClass.newInstance();
                        registerApplication(type, event, new AppWrapper(app));
                    } catch (ClassCastException cce) {
                        throw new HL7Exception("The specified class, " + className
                                + ", doesn't implement Application.");
                    }

                }
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // don't care
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
     * <p/>
     * Note: this could be started as daemon, so we don't need to care about
     * termination.
     */
    private static class ConnectionCleaner extends Service {

        private final HL7Service service;

        public ConnectionCleaner(HL7Service service) {
            super("ConnectionCleaner", service.getExecutorService());
            this.service = service;
        }

        @Override
        public void start() {
            log.info("Starting ConnectionCleaner service");
            super.start();
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
                // don't care
            }
        }

    }

}
