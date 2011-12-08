/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HL7Server.java".  Description: 
"A TCP/IP based server." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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

package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;

/**
 * A TCP/IP based server. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-06-30 13:30:45 $ by $Author: jamesagnew $
 */
public class HL7Server {

    private static Logger log = LoggerFactory.getLogger(HL7Server.class);
    
    private final ServerSocket myServerSocket;
    private ServerSocket myServerSocket2;
    private final ApplicationRouter myRouter;
    private final SafeStorage myStorage;
    
    private boolean myIsRunning = false;
    private List<Processor> myProcessors;
    
    /**
     * @param theServerSocket a ServerSocket on which to listen for connections that will
     *      be used for both locally-driven and remotely-driven message exchanges
     * @param theRouter used to send incoming messages to appropriate <code>Application</code>s
     * @param theStorage used to commit incoming messages to safe storage before returning 
     *      an accept ACK 
     */
    public HL7Server(ServerSocket theServerSocket, ApplicationRouter theRouter, SafeStorage theStorage) {
        myServerSocket = theServerSocket;
        myRouter = theRouter;
        myStorage = theStorage;
        initProcessorList();
    }
    
    /**
     * @param theLocallyDriven a ServerSocket on which to listen for connections that will
     *      be used for locally-initiated message exchanges
     * @param theRemotelyDriven a ServerSocket on which to listen for connections that will
     *      be used for remotely-initiated message exchanges
     * @param theRouter used to send incoming messages to appropriate <code>Application</code>s
     * @param theStorage used to commit incoming messages to safe storage before returning 
     *      an accept ACK 
     */
    public HL7Server(ServerSocket theLocallyDriven, ServerSocket theRemotelyDriven, 
        ApplicationRouter theRouter, SafeStorage theStorage) {
    
        myServerSocket = theLocallyDriven;
        myServerSocket2 = theRemotelyDriven;
        myRouter = theRouter;
        myStorage = theStorage;  
        initProcessorList();       
    }

    //creates list and starts thread to clean dead processors from it     
    private void initProcessorList() {
        myProcessors = new ArrayList<Processor>();
        
        final List<Processor> processors = myProcessors; 
        Thread cleaner = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                
                synchronized (processors) {
                    Iterator<Processor> it = processors.iterator();
                    while (it.hasNext()) {
                        Processor proc = it.next();
                        if (!proc.getContext().getLocallyDrivenTransportLayer().isConnected() 
                                || !proc.getContext().getRemotelyDrivenTransportLayer().isConnected()) {
                            it.remove();
                        }
                    }
                }
            }
        };
        cleaner.start();
    }
        
    /**
     * Accepts a single inbound connection if the same ServerSocket is used for 
     * all message exchanges, or a connection from each if two ServerSockets are 
     * being used. 
     *  
     * @param theAddress the IP address from which to accept connections (null means 
     *      accept from any address).  Connection attempts from other addresses will 
     *      be ignored.  
     * @return a <code>Processor</code> connected to the given address  
     * @throws TransportException
     */
    public Processor accept(String theAddress) throws TransportException {
        TransportLayer transport = getTransport(myServerSocket, theAddress);
        ProcessorContext context = null;
        
        if (myServerSocket2 == null) { //we're doing inbound & outbound on the same port
            transport.connect();
            context = new ProcessorContextImpl(myRouter, transport, myStorage);
        } else {
            TransportLayer transport2 = getTransport(myServerSocket2, theAddress);
            DualTransportConnector connector = new DualTransportConnector(transport, transport2);
            connector.connect();
            
            context = new ProcessorContextImpl(myRouter, transport, transport2, myStorage);
        }
        return new ProcessorImpl(context, true);        
    }
    
    private static TransportLayer getTransport(ServerSocket theServerSocket, String theAddress) throws TransportException {
        ServerSocketStreamSource ss = new ServerSocketStreamSource(theServerSocket, theAddress);
        return new MLLPTransport(ss);
    }
    
    /**
     * Starts accepting connections in a new Thread.  Note that this can be 
     * called multiple times with separate addresses.  The stop() method ends
     * all Threads started here.  
     * 
     * @param theAddress IP address from which connections are accepted (null 
     *  means any address is OK) 
     */
    public void start(final String theAddress) {  
        final HL7Server server = this;      
        Runnable acceptor = new Runnable() {
            public void run() {
                while (server.isRunning()) {
                    try {
                        Processor p = server.accept(theAddress);
                        if (!myIsRunning) {
                        	p.stop();
                        } else {
                            server.newProcessor(p); 
                            Thread.sleep(1);
                        }
                    } catch (TransportException e) {
                        log.error(e.getMessage(), e);
                    } catch (InterruptedException e) {
                    } 
                }
            }
        };
        
        myIsRunning = true;
        
        Thread thd = new Thread(acceptor);
        thd.start();
    }
    
    private void newProcessor(Processor theProcessor) {
        synchronized (myProcessors) {
            myProcessors.add(theProcessor);
        }
    }
    
    /**
     * Stops running after the next connection is made. 
     */
    public void stop() {
        myIsRunning = false;
        synchronized (myProcessors) {
            for (Processor next : myProcessors) {
            	next.stop();
            }
        }
    }
    
    /**
     * Returns <code>true</code> between when start() returns and when stop() is called.
     * 
     * Note that this is not the same as checking whether there are any active connections to
     * this server. To determine this, call {@link #getProcessors()} and check whether the array
     * returned is non-empty.
     * 
     * @return true between when start() returns and when stop() is called.  
     */
    public boolean isRunning() {
        return myIsRunning;
    }
    
    /**
     * @return <code>Processor</code>s arising from connections to this server 
     */
    public Processor[] getProcessors() {
        synchronized (myProcessors) {
            return (Processor[]) myProcessors.toArray(new Processor[0]);
        }
    }
    
    /**
     * 
     * @param theUrlSpec a string specifying an URL, which can optionally begin with "classpath:" 
     * @return the resource specified after "classpath:", if that's how it starts, otherwise 
     *      new URL(theUrlSpec) 
     * @throws MalformedURLException
     */
    private static URL getURL(String theUrlSpec) throws MalformedURLException {
        URL url = null;
        if (theUrlSpec.startsWith("classpath:")) {
            StringTokenizer tok = new StringTokenizer(theUrlSpec, ":", false);
            tok.nextToken();
            String resource = tok.nextToken();
            url = Thread.currentThread().getContextClassLoader().getResource(resource);
        } else {
            url = new URL(theUrlSpec);
        }
        return url;
    }
    
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 3) {
            System.out.println("Usage: HL7Server (shared_port | (locally_driven_port remotely_driven_port)) app_binding_URL");
            System.exit(1);
        }
        
        SafeStorage storage = new NullSafeStorage();
        ApplicationRouter router = new ApplicationRouterImpl();
        
        try {
            HL7Server server = null;
            String appURL = null;
            if (args.length == 2) {
                int port = Integer.parseInt(args[0]);
                server = new HL7Server(new ServerSocket(port), router, storage);
                appURL = args[1];                
            } else {
                int localPort = Integer.parseInt(args[0]);
                int remotePort = Integer.parseInt(args[1]);
                server = new HL7Server(new ServerSocket(localPort), new ServerSocket(remotePort), router, storage);
                appURL = args[2];
            }
            
            ApplicationLoader.loadApplications(router, getURL(appURL));
            
            server.start(null); //any address OK            
            
        } catch (NumberFormatException e) {
            System.out.println("Port arguments must be integers");
            System.exit(2);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(3);
        } catch (HL7Exception e) {
            e.printStackTrace();
            System.exit(4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(5);
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(6);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(7);
        } 

    }
}
