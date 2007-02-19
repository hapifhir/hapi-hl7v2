/*
 * Created on 15-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.TransportException;

/**
 * A base implementation of <code>StreamSource</code> based on sockets. 
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public abstract class SocketStreamSource implements StreamSource {
    
    /**
     * @return a socket from which input and output streams for message exchages 
     *      are to be obtained    
     */
    public abstract Socket getSocket();
    
    /** 
     * Gets fresh instance of socket, which is subsequently available 
     * from <code>getSocket()</code>.  
     */
    public abstract void connect() throws TransportException;

    /**
     * Closes streams and underlying socket. 
     * @see ca.uhn.hl7v2.protocol.StreamSource#disconnect()
     */
    public void disconnect() throws TransportException {
        try {
            if (isConnected()) {
                getOutboundStream().close();
                getInboundStream().close();
                getSocket().close();
            }            
        } catch (IOException e) {
            throw new TransportException(e);
        }
    }
    
    /**
     * @return the stream to which we write outbound messages.   
     */
    public OutputStream getOutboundStream() throws TransportException {
        checkConnected();
        try {
            return getSocket().getOutputStream();
        } catch (IOException e) {
            throw new TransportException(e); 
        }
    }
    
    private void checkConnected() throws TransportException {
        if (!isConnected()) {
            throw new TransportException("The socket is not connected");
        }
    }
    
    private boolean isConnected() {
        boolean is = false;
        if (getSocket() != null && getSocket().isConnected() && !getSocket().isClosed()) {
            is = true;
        }
        return is;
    }

    /**
     * @return the stream to which we expect the remote server to send messages.  
     */
    public InputStream getInboundStream() throws TransportException {
        checkConnected();
        try {
            return getSocket().getInputStream();
        } catch (IOException e) {
            throw new TransportException(e); 
        }
    }
    
}
