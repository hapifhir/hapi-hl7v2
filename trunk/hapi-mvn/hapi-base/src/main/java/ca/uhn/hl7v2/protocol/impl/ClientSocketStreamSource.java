/*
 * Created on 19-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

import ca.uhn.hl7v2.protocol.TransportException;

/**
 * A client-side <code>SocketStreamSource</code>.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class ClientSocketStreamSource extends SocketStreamSource {

    private SocketAddress myAddress;
    private Socket mySocket;

    /**
     * @param theAddress the address at which to connect sockets
     * @throws TransportException
     */
    public ClientSocketStreamSource(SocketAddress theAddress) throws TransportException {
        myAddress = theAddress;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.impl.SocketStreamSource#getSocket()
     */
    public Socket getSocket() {
        return mySocket;
    }

    /** 
     * Gets fresh instances of sockets.  
     */
    public void connect() throws TransportException {
        mySocket = getSocket(myAddress);
    }

    private Socket getSocket(SocketAddress theAddress) throws TransportException {
        Socket s = new Socket();        
        try {
            s.connect(theAddress);
        } catch (IOException e) {
            throw new TransportException(e);
        }
        return s;        
    }

}
