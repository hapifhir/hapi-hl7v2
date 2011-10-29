/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "JMSQueueTransport.java".  Description: 
"A TransportLayer that uses a JMS Queue" 

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

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import ca.uhn.hl7v2.protocol.TransportException;

/**
 * A <code>TransportLayer</code> that uses a JMS Queue.
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class JMSQueueTransport extends AbstractJMSTransport {

    private QueueSession mySendingSession;
    private QueueSession myReceivingSession; 
    private QueueSender mySender;
    private QueueReceiver myReceiver;
    private QueueConnection myConnection;
    private Queue myQueue;
    
    /**
     * @param theConnection
     * @param theDestination
     */
    public JMSQueueTransport(QueueConnection theConnection, Queue theDestination) {
        myConnection = theConnection;
        myQueue = theDestination;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.impl.AbstractJMSTransport#getDestinationName()
     */
    protected String getDestinationName() throws JMSException {
        return myQueue.getQueueName();
    }

    /**
     * @see ca.uhn.hl7v2.protocol.impl.AbstractJMSTransport#getConnection()
     */
    public Connection getConnection() {
        return myConnection;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.impl.AbstractJMSTransport#getMessage()
     */
    protected Message getMessage() throws JMSException {        
        return mySendingSession.createTextMessage();
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.impl.AbstractJMSTransport#send(javax.jms.Message)
     */
    protected void sendJMS(Message theMessage) throws JMSException {
        mySender.send(theMessage);
    }

    /**
     * @see ca.uhn.hl7v2.protocol.impl.AbstractJMSTransport#receive()
     */
    protected Message receiveJMS() throws JMSException {
        return myReceiver.receive();
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.impl.AbstractJMSTransport#connect()
     */
    public void doConnect() throws TransportException {
        boolean transacted = false;
        int ackMode = Session.AUTO_ACKNOWLEDGE;

        doDisconnect();
        try {
            mySendingSession = myConnection.createQueueSession(transacted, ackMode);
            mySender = mySendingSession.createSender(myQueue);

            myReceivingSession = myConnection.createQueueSession(transacted, ackMode);
            myReceiver = myReceivingSession.createReceiver(myQueue);
        } catch (JMSException e) {
            throw new TransportException(e);
        }
    }

    /**
     * @see ca.uhn.hl7v2.protocol.impl.AbstractTransport#doDisconnect()
     */
    public void doDisconnect() throws TransportException {
        try {
            if (mySendingSession != null) {
                mySendingSession.close();
            }
            if (myReceivingSession != null) {
                myReceivingSession.close();
            }
        } catch (JMSException e) {
            throw new TransportException(e);
        }        
    }

}
