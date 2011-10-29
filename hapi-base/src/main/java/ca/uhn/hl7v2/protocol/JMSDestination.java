/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "JMSDestination.java".  Description: 
"A facade for a JMS Queue or Topic." 

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
package ca.uhn.hl7v2.protocol;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * A facade for a JMS Queue or Topic.    
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface JMSDestination {

    /**
     * @return the name of the Queue or Topic 
     * @throws JMSException
     */
    public String getName() throws JMSException; 
    
    /**
     * @return a new JMS Message object.  
     * @throws JMSException
     */
    public TextMessage createMessage() throws JMSException;

    /**
     * Creates a new session, sender/publisher, and receiver/subscriber.  
     * @throws JMSException
     */    
    public void connect() throws JMSException;
    
    /**
     * Closes the JMS session.  
     * @throws JMSException
     */
    public void disconnect() throws JMSException;
    
    /**
     * @return true if connected.  
     */
    public boolean isConnected(); 
    
    /**
     * @return the JMS Connection underlying this destination
     */
    public Connection getConnection();

    /**
     * Sends the given message to the JMS destination.  
     * @param theMessage message to send
     * @throws JMSException
     */
    public void send(Message theMessage) throws JMSException;

    /**
     * @return a message received from the JMS destination. 
     * @throws JMSException
     */
    public Message receive() throws JMSException;
    
}
