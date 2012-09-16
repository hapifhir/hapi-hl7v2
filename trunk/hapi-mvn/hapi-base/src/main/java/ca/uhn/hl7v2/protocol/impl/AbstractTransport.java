/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstactTransport.java".  Description: 
"A base implementation of TransportLayer." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.protocol.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * A base implementation of <code>TransportLayer</code> which looks after the 
 * addition of common metadata to each inbound <code>Transportable</code>.
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public abstract class AbstractTransport implements TransportLayer {
    
    private static Logger log = LoggerFactory.getLogger(AbstractTransport.class);
    
    private Map<String, Object> myCommonMetadata;
    private boolean myIsConnected = false;
    
    public AbstractTransport() {
        myCommonMetadata = new HashMap<String, Object>();
    }
        
    /**
     * @see ca.uhn.hl7v2.protocol.TransportLayer#getCommonMetadata()
     */
    public Map<String, Object> getCommonMetadata() {
        return myCommonMetadata;
    }

    /**
     * Delegates to <code>doReceive()</code> and adds common metadata
     * to the resulting <code>Transportable</code> before it is returned.
     */
    public Transportable receive() throws TransportException {
        if (!isConnected()) {
            throw new TransportException("Can't receive because TransportLayer is not connected");
        }
        
        Transportable message = doReceive();
        if (message != null) {
            message.getMetadata().putAll(myCommonMetadata);
        }
        
        log.debug("Received: {} ", (message == null ? null : message.getMessage()));
             
        return message;
    }

    /**
     * Called by receive(), which then adds common metadata.   
     * 
     * @return Transportable the next available message 
     * @throws TransportException
     */    
    public abstract Transportable doReceive() throws TransportException;
    
    /**
     * Delegates to <code>doSend()</code> after checking that we are connected. 
     * 
     * @see ca.uhn.hl7v2.protocol.TransportLayer#send(Transportable) 
     */
    public void send(Transportable theMessage) throws TransportException {
        if (!isConnected()) {
            throw new TransportException("Can't send because TransportLayer is not connected");
        }
        
        doSend(theMessage);
        
        log.debug("Sent: {}", (theMessage == null ? null : theMessage.getMessage()));
    }
    
    /**
     * The method send() delegates to this method after checking whether we are 
     * connected.   
     * @param theMessage
     * @throws TransportException
     */
    public abstract void doSend(Transportable theMessage) throws TransportException;
    
    /**
     * Sets isConnected() to false, then calls doConnect(), then sets isConnected() to 
     * true. 
     * @see ca.uhn.hl7v2.protocol.TransportLayer#connect()  
     */
    public void connect() throws TransportException {
        myIsConnected = false;
        doConnect();
        myIsConnected = true;
    }
    
    /**
     * Performs connection as described in TransportLayer.connect().  The 
     * connect() method of this class delegates to doConnect() after some
     * internal housekeeping.
     *   
     * @throws TransportException
     */
    public abstract void doConnect() throws TransportException;
    
    /**
     * @see ca.uhn.hl7v2.protocol.TransportLayer#isConnected()  
     */
    public boolean isConnected() {
        return myIsConnected;
    }
    
    /**
     * @see ca.uhn.hl7v2.protocol.TransportLayer#disconnect()
     */
    public void disconnect() throws TransportException {
        myIsConnected = false;
        doDisconnect();
    }
    
    /**
     * Performs disconnection as described in TransportLayer.disconnect().  The 
     * disconnect() method of this class delegates to doDisconnect() after some
     * internal housekeeping.
     *   
     * @throws TransportException
     */
    public abstract void doDisconnect() throws TransportException;
    
}
