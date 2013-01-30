/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "JMSTopicAdapter.java".  Description: 
"An implementation of JMSDestination that uses an underlying Topic." 

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
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import ca.uhn.hl7v2.protocol.JMSDestination;

/**
 * An implementation of <code>JMSDestination</code> that uses an underlying 
 * Topic.
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class JMSTopicAdapter implements JMSDestination {

    private TopicSession mySendingSession;
    private TopicSession myReceivingSession; 
    private TopicPublisher myPublisher;
    private TopicSubscriber mySubscriber;
    private TopicConnection myConnection;
    private Topic myTopic;
    private boolean myIsConnected;

    /**
     * @param theConnection the connection over which messages are written and read 
     * @param theDestination the destination to/from which messages are written/read
     */
    public JMSTopicAdapter(TopicConnection theConnection, Topic theDestination) {
        myConnection = theConnection;
        myTopic = theDestination;
    }

    /**
     * @param theConnection the connection over which messages are written and read 
     * @param theDestination the destination to/from which messages are written/read
     * @param theMessageSelector a JMS message selector which restricts the inbound 
     *      messages that are received (see JMS docs)
     */
    public JMSTopicAdapter(TopicConnection theConnection, Topic theDestination, String theMessageSelector) {
        myConnection = theConnection;
        myTopic = theDestination;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.JMSDestination#getName()
     */
    public String getName() throws JMSException {
        return myTopic.getTopicName();
    }

    /**
     * @see ca.uhn.hl7v2.protocol.JMSDestination#createMessage()
     */
    public TextMessage createMessage() throws JMSException {
        return mySendingSession.createTextMessage();
    }

    /**
     * @see ca.uhn.hl7v2.protocol.JMSDestination#connect()
     */
    public void connect() throws JMSException {
        boolean transacted = false;
        int ackMode = Session.AUTO_ACKNOWLEDGE;

        disconnect();
        
        mySendingSession = myConnection.createTopicSession(transacted, ackMode);
        myPublisher = mySendingSession.createPublisher(myTopic);

        myReceivingSession = myConnection.createTopicSession(transacted, ackMode);
        mySubscriber = myReceivingSession.createSubscriber(myTopic);
        
        myIsConnected = true;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.JMSDestination#disconnect()
     */
    public void disconnect() throws JMSException {
        myIsConnected = false;
        
        if (mySendingSession != null) {
            mySendingSession.close();
        }
        if (myReceivingSession != null) {
            myReceivingSession.close();
        }
    }

    /**
     * @see ca.uhn.hl7v2.protocol.JMSDestination#isConnected()
     */
    public boolean isConnected() {
        return myIsConnected;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.JMSDestination#send(javax.jms.Message)
     */
    public void send(Message theMessage) throws JMSException {
        myPublisher.publish(theMessage);
    }

    /**
     * @see ca.uhn.hl7v2.protocol.JMSDestination#receive()
     */
    public Message receive() throws JMSException {
        return mySubscriber.receive();
    }

    /**
     * @see ca.uhn.hl7v2.protocol.JMSDestination#getConnection()
     */
    public Connection getConnection() {
        return myConnection;
    }

}
