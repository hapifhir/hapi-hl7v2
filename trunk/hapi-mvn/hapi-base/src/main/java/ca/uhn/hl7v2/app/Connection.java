/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Connection.java".  Description: 
"A TCP/IP connection to a remote HL7 server." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * A TCP/IP connection to a remote HL7 server.  
 * @author Bryan Tripp
 */
public class Connection {

    private static final HapiLog log = HapiLogFactory.getHapiLog(Connection.class);

    private Initiator initiator;
    private Responder responder;
    private List<Socket> sockets;
    private HL7Writer ackWriter;
    private HL7Writer sendWriter;
    private Parser parser;
    private Map<String, MessageReceipt> receipts;
    private List<Receiver> receivers;
    private boolean open = true;

    /** 
     * Creates a new instance of Connection, with inbound and outbound 
     * communication on a single port. 
     */
    public Connection(Parser parser, LowerLayerProtocol llp, Socket bidirectional) throws LLPException, IOException {
        init(parser);
        ackWriter = llp.getWriter(bidirectional.getOutputStream());
        sendWriter = ackWriter;
        sockets.add(bidirectional);
        Receiver r = new Receiver(this, llp.getReader(bidirectional.getInputStream()));
        r.start();
        receivers.add(r);
        this.initiator = new Initiator(this);
    }

    /** 
     * Creates a new instance of Connection, with inbound communication on one 
     * port and outbound on another.
     */
    public Connection(Parser parser, LowerLayerProtocol llp, Socket inbound, Socket outbound)
        throws LLPException, IOException {
        init(parser);
        ackWriter = llp.getWriter(inbound.getOutputStream());
        sendWriter = llp.getWriter(outbound.getOutputStream());
        sockets.add(outbound); //always add outbound first ... see getRemoteAddress()
        sockets.add(inbound);
        Receiver inRec = new Receiver(this, llp.getReader(inbound.getInputStream()));
        Receiver outRec = new Receiver(this, llp.getReader(outbound.getInputStream()));
        inRec.start();
        outRec.start();
        receivers.add(inRec);
        receivers.add(outRec);
        this.initiator = new Initiator(this);
    }

    /** Common initialization tasks */
    private void init(Parser parser) throws LLPException {
        this.parser = parser;
        sockets = new ArrayList<Socket>();
        receipts = new HashMap<String, MessageReceipt>();
        receivers = new ArrayList<Receiver>();
        responder = new Responder(parser);
    }

    /** 
     * Returns the address of the remote host to which this Connection is connected. 
     * If separate inbound and outbound sockets are used, the address of the outbound
     * socket is returned (the addresses should normally be the same, but this isn't 
     * checked).  
     */
    public InetAddress getRemoteAddress() {
        Socket s = sockets.get(0);
        return s.getInetAddress();
    }

    /** Returns the Initiator associated with this connection */
    public Initiator getInitiator() {
        return this.initiator;
    }

    /** Returns the Responder associated with this connection */
    public Responder getResponder() {
        return this.responder;
    }

    /** Returns the HL7Writer through which unsolicited outbound messages should be sent. */
    protected HL7Writer getSendWriter() {
        return this.sendWriter;
    }

    /** Returns the HL7Writer through which responses to inbound messages should be sent. */
    protected HL7Writer getAckWriter() {
        return this.ackWriter;
    }

    public Parser getParser() {
        return this.parser;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(getRemoteAddress().getHostName());
        buf.append(":");
        for (Iterator<Socket> iter = sockets.iterator(); iter.hasNext();) {
			Socket socket = iter.next();
			buf.append(socket.getPort());
			if (iter.hasNext()) buf.append(",");
		}
        return buf.toString();
    }

    /** 
     * Reserves a future incoming message by ack ID.  When the incoming message 
     * with the given ack ID arrives, the message will be available through 
     * the returned MessageReceipt.  
     */
    protected MessageReceipt reserveResponse(String messageID) {
        MessageReceipt mr = new MessageReceipt();
        receipts.put(messageID, mr);
        return mr;
    }

    /** 
     * Given the ack ID (MSA-2) of a message, returns the corresponding 
     * MessageReceipt if one exists (ie if reserveResponse has been called for this 
     * ack ID).  Otherwise (i.e. if no object is waiting for this message), returns null. 
     * This method can only be called once per ackId (the record is dropped with the 
     * call).  
     */
    protected MessageReceipt findRecipient(String ackID) {
        //String ID = getParser().getAckID(message);
        MessageReceipt mr = null;
        if (ackID != null)
            mr = receipts.remove(ackID);
        return mr;
    }

    /** Stops running Receiver threads and closes open sockets */
    public void close() {
    	for (Receiver receiver : receivers) {
			receiver.stop();
		}
    	for (Socket socket : sockets) {
    		try {
    			socket.close();				
			} catch (Exception e) {
				log.error("Error while stopping threads and closing sockets",e);
			}

		}
        open = false;
    }

    /** Returns false if the Connection has been closed. */
    public boolean isOpen() {
        return open;
    }

}
