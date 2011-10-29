/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "Receiver.java".  Description:
 * "Listens for incoming messages on a certain input stream, and
 * sends them to the appropriate location."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): _____________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.app;

import java.io.IOException;

import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Listens for incoming messages on a certain input stream, and
 * sends them to the appropriate location.  
 * @author Bryan Tripp
 */
public class Receiver implements Runnable {

    private static final HapiLog log = HapiLogFactory.getHapiLog(Receiver.class);

    private Connection conn;
    private HL7Reader in;
    private boolean running;

    /** Creates a new instance of Receiver, associated with the given Connection  */
    public Receiver(Connection c, HL7Reader in) {
        this.conn = c;
        this.in = in;
    }

    /**
     * Loops continuously, reading messages and calling processMessage() until
     * stop() is called.
     */
    public void run() {
        while (running) {
            Thread.yield();
            try {
                String message = in.getMessage();
                if (message == null) {
                    log.info("Closing connection (no more messages available).");
                    conn.close();
                } else {
                    processMessage(message);
                }
            }
            catch (IOException e) {
                conn.close();
                log.error("IOException: closing Connection, will no longer read messages with this Receiver. ", e);
            }
            catch (Exception e) {
                log.error("Error while closing connection: ", e);
            }
        }
    }

    /**
     * Processes a single incoming message by sending it to the appropriate
     * internal location.  If an incoming message contains
     * an MSA-2 field, it is assumed that this message is meant as a reply to a message that has been sent
     * earlier.  In this case an attempt is give the message to the object
     * that sent the corresponding outbound message.  If the message contains an MSA-2 but there are no objects that
     * appear to be waiting for it, it is discarded and an exception is logged. If the message does not
     * contain an MSA-2 field, it is concluded that the message has arrived unsolicited.  In this case
     * it is sent to the Responder (in a new Thread).
     */
    protected void processMessage(String message) {
        String ackID = conn.getParser().getAckID(message);
        if (ackID == null) {
            Grunt g = new Grunt(conn, message);
            g.start();
        }
        else {
            MessageReceipt mr = conn.findRecipient(ackID);
            if (mr == null) {
                log.info( "Unexpected Message Received: " + message );
            }
            else {
                mr.setMessage(message);
            }
        }
    }
    
    /** Independent thread for processing a single message */ 
    private class Grunt extends Thread {
        
        private Connection conn;
        private String m;
        
        public Grunt(Connection conn, String message) {
            this.conn = conn;
            this.m = message;
        }
        
        public void run() {
            try {
                String response = conn.getResponder().processMessage(m);
                conn.getAckWriter().writeMessage(response);
            }
            catch (Exception e) {
                log.error("Error while processing message: ", e );
            }
        }
    }

    /** Starts the Receiver in a new thread */
    public void start() {
        running = true;
        Thread thd = new Thread(this);
        thd.start();
    }

    /** Stops the Receiver after the next message is read. */
    public void stop() {
        running = false;
    }

}
