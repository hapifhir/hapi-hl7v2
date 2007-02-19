/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * A source of input and output streams for use with stream-based 
 * <code>TransportLayer</code>s.  Implementations should contain the 
 * necessary information for reconnecting streams as necessary.  For 
 * example a ServerSocket-based implementation should be able to listen  
 * for fresh connections and get new streams from them (this must be 
 * done when refresh() is called).  
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface StreamSource {

    /**
     * Gets new streams.  This should be called only if one of the streams 
     * is dead.  
     * @throws TransportException
     */
    public void connect() throws TransportException;
    
    /**
     * Closes streams and underlying connections.  
     * @throws TransportException
     */
    public void disconnect() throws TransportException;
    
    /**
     * @return the stream to which we write outbound messages.   
     * @throws TransportException
     */
    public OutputStream getOutboundStream() throws TransportException;

    /**
     * @return the stream to which we expect the remote server to send messages.  
     * @throws TransportException
     */
    public InputStream getInboundStream() throws TransportException;
    
}
