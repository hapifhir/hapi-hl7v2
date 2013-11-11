/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ServerSocketStreamSource.java".  Description: 
"A StreamSource that gets streams from ServerSockets." 

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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.protocol.TransportException;

/**
 * A <code>StreamSource</code> that gets streams from ServerSockets.  This 
 * allows you to communicate over sockets that are established by the remote 
 * party (ie as a TCP/IP server).
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.4 $ updated on $Date: 2009-12-19 20:01:20 $ by $Author: jamesagnew $
 */
public class ServerSocketStreamSource extends SocketStreamSource {

	/** The default SO_TIMEOUT value for sockets returned by this class */
	public static final int TIMEOUT = 500;
	
    private ServerSocket myServerSocket;
    private String myExpectedAddress;
    private Socket mySocket;
    
    /**
     * @param theServerSocket a ServerSocket at which to listen for incoming connections  
     * @param theExpectedAddress the IP address from which to accept connections (null means 
     *      accept from any address) 
     * @throws TransportException
     */
    public ServerSocketStreamSource(ServerSocket theServerSocket, String theExpectedAddress) throws TransportException {
        myServerSocket = theServerSocket;
        myExpectedAddress = theExpectedAddress;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.impl.SocketStreamSource#getSocket()
     */
    public Socket getSocket() {
        return mySocket;
    }

    /** 
     * Accepts new connections on underlying ServerSocket, replacing 
     * any existing socket with the new one, blocking until a connection 
     * is available.  See {@link DualTransportConnector} for a method of 
     * connecting two <code>TransportLayer</code>s in a way that avoids deadlock.    
     * 
     * @see ca.uhn.hl7v2.protocol.StreamSource#connect()
     */
    public void connect() throws TransportException {
        Acceptor a = new Acceptor(myServerSocket, myExpectedAddress);                
        mySocket = a.waitForSocket();
    }
    
    /**
     * A thing with which waiting for inbound socket connections can 
     * be done in a separate thread.  This is needed because we may have to 
     * start waiting at two ports before pending on either.  Otherwise if 
     * we accept() in a different order than the remote system connects, 
     * we will deadlock.  
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.4 $ updated on $Date: 2009-12-19 20:01:20 $ by $Author: jamesagnew $
     */
    private static class Acceptor {
        
        private static final Logger log = LoggerFactory.getLogger(Acceptor.class);
        
        private Socket mySocket;
        
        /**
         * Starts waiting in a separate thread for connections to the given 
         * ServerSocket from the given IP address.  
         * @param theServer 
         * @param theAddress IP address from which to accept connections (null
         *      means any) 
         */
        public Acceptor(final ServerSocket theServer, final String theAddress) {
            final Acceptor a = this;
            if (theAddress != null) {
                log.info("Server socket is about to try to accept a connection from {}", theAddress);
            } else {
                log.info("Server socket is about to try to accept a connection from any addess");
            }

            Runnable r = new Runnable() {
                public void run() {
                    while (true) {

                        Socket s;
                        try {

                        	if (!theServer.isClosed()) {
	                            s = theServer.accept();
	                            s.setSoTimeout(TIMEOUT);
	                            String address = s.getInetAddress().getHostAddress();
	                            if (theAddress == null || address.equals(theAddress)) {
	                                a.setSocket(s);
	                                synchronized (a) {
	                                    a.notifyAll();
	                                }
	                            } else {
	                                log.info("Ignoring connection from {}: expecting ", address, theAddress);
	                            }
                        	}
                        	
                        } catch (SocketTimeoutException e) {
                            log.debug("Socket timed out without receiving a connection");
                        } catch (IOException e) {
                            log.error("Error accepting remote connection", e); 
                        } // try-catch

                        if (a.getSocket() != null) {
                            log.info("Accepted connection from address: {}", a.getSocket().getInetAddress());
                            return;
                        }

                        if (theServer.isClosed()) {
                            log.warn("Server socket closed, aborting");
                            return;
                        }

                        //if there's a problem, don't fill up the log at lightning speed
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e2) {}

                    }
                }
            };
            
            Thread thd = new Thread(r);
            thd.start();
        }
        
        public void setSocket(Socket theSocket) {
            mySocket = theSocket;
        }
        
        public Socket getSocket() {
            return mySocket;
        }
        
        /**
         * @return as getSocket(), but doesn't return until getSocket() returns 
         *  non-null.  
         */
        public Socket waitForSocket() {
            while (getSocket() == null) {
                try {
                    synchronized (this) {
                        this.wait(100);
                    }
                } catch (InterruptedException e) {}
            }
            return getSocket();
        }
        
    }


}
