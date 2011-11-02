/*
 * Created on 15-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import java.util.Map;

/**
 * Encapsulates the transport layer of a connection to another 
 * HL7 server.  This is the layer responsible for sending and receiving 
 * message strings.  The underlying protocol used is implementation
 * dependent, that is there may be transport layers that are implemented 
 * over email, or JMS, or HTTP.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface TransportLayer {

    /**
     * Sends a message to a remote HL7 service.
     *   
     * @param theMessage the message to send 
     * @throws TransportException
     */
    public void send(Transportable theMessage) throws TransportException;
    
    /**
     * Gets the next message from the remote system.  This call blocks until
     * the next message is available.  
     *  
     * @return the next available message 
     * @throws TransportException
     */
    public Transportable receive() throws TransportException;
    
    /**
     * @return metadata to be added to the metadata of all incoming messages.  
     *      This provides a way of associating connection information with  
     *      incoming messages (eg the IP address of the remote server).
     */
    public Map<String, Object> getCommonMetadata();    
    
    /**
     * Initializes a connection to the remote server.  This can be called after 
     * an exception is encountered, to refresh a dead connection.  
     * @throws TransportException
     */
    public void connect() throws TransportException;
    
    /**
     * @return true if connect() has completed successfully.  Note that true 
     *  may be returned even if a connection is dead (ie the implementation need 
     *  not test a connection during this call) but should return false if connect()
     *  has not been called, or if connect() has been called and is pending.  
     */
    public boolean isConnected();
    
    /**
     * Drops any existing connection to the remote server.  
     * @throws TransportException
     */
    public void disconnect() throws TransportException;
    
}