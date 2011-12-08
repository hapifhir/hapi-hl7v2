/*
 * Created on 20-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;

/**
 * <p>A utility for connecting separate inbound and outbound 
 * <code>TransortLayer</code>s in a manner that avoids deadlock.</p>  
 * 
 * <p>It is not safe to call connect() on two <code>TransportLayer</code>
 * in the same thread, because it blocks, and the remote system may be doing 
 * the same thing, but in the opposite order.  This class provides a method  
 * that connects two layers in separate threads, and pends until they are
 * both connected.</p>
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class DualTransportConnector {

    private final TransportLayer myTransportA;
    private final TransportLayer myTransportB;
    private boolean isConnecting;
    
    /**
     * @param theTransportA one <code>TransportLayer</code> we will want to connect 
     * @param theTransportB another one
     */
    public DualTransportConnector(TransportLayer theTransportA, TransportLayer theTransportB) {
        myTransportA = theTransportA;
        myTransportB = theTransportB;
    }
    
    /**
     * @return one of the underlying <code>TransportLayer</code>s.  
     */
    public TransportLayer getTransportA() {
        return myTransportA;
    }
    
    /**
     * @return the other underlying <code>TransportLayer</code>.  
     */
    public TransportLayer getTransportB() {
        return myTransportB;
    }
    
    /**
     * Connects both <code>TransportLayer</code>s in separate threads,   
     * and returns when both have been connected, or when cancelConnect() 
     * is called. 
     */
    public void connect() throws TransportException {
        isConnecting = true;
        ConnectThread c1 = new ConnectThread(myTransportA);
        ConnectThread c2 = new ConnectThread(myTransportB);
        c1.start();
        c2.start();
            
        while (isConnecting 
            && (!c1.isConnected() || !c2.isConnected())
            && c1.getException() == null
            && c2.getException() == null) {
                
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
        }
        
        if (c1.getException() != null) throw c1.getException();
        if (c2.getException() != null) throw c2.getException();
    }
    
    public void disconnect() throws TransportException {
        myTransportA.disconnect();
        myTransportB.disconnect();
    }
    
    /**
     * Cancels a connect() in progress.  Since connect() blocks, this must 
     * be called from a separate thread.  
     */
    public void cancelConnect() {
        isConnecting = false;
    }
    
    /**
     * A class to facilitate connecting a <code>TransportLayer</code> in 
     * a separate thread.  This is needed when we want to perform two connections
     * that are initiated remotely, and we don't know the order in which the 
     * remote system will initiate the connections. 
     *   
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
     */
    private static class ConnectThread extends Thread {
        
        private TransportLayer myTransport;
        private TransportException myException;        
        
        public ConnectThread(TransportLayer theTransport) {
            myTransport = theTransport;
        }
        
        public boolean isConnected() {
            return myTransport.isConnected();
        }
        
        /**
         * @return an exception encountered during the last run, if any
         */
        public TransportException getException() {
            return myException;
        }
        
        public void run() {
            myException = null;
            try {
                myTransport.connect();
            } catch (TransportException e) {
                myException = e;
            }
        }
    }

}
