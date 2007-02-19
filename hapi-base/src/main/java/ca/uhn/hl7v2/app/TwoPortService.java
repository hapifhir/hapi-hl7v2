/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "TwoPortService.java".  Description: 
"A TCP/IP-based HL7 Service that uses separate ports for inbound and outbound messages." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.app;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * A TCP/IP-based HL7 Service that uses separate ports for inbound and outbound messages.
 * A connection is only activated when the same remote host connects to both the 
 * inbound and outbound ports.  
 * @author Bryan Tripp
 */
public class TwoPortService extends HL7Service {

    private static final HapiLog log = HapiLogFactory.getHapiLog(TwoPortService.class);

    private Vector inSockets; //Vector because it's synchronized 
    private Vector outSockets;
    private int inboundPort;
    private int outboundPort;

    /** Creates a new instance of TwoPortService */
    public TwoPortService(Parser parser, LowerLayerProtocol llp, int inboundPort, int outboundPort) {
        super(parser, llp);
        inSockets = new Vector(20);
        outSockets = new Vector(20);
        this.inboundPort = inboundPort;
        this.outboundPort = outboundPort;
    }

    /** 
     * Initially sets up server sockets and starts separate threads to accept connections 
     * on them.  Then loops, calling this.accept() super.newConnection().   
     */
    public void run() {
        try {
            AcceptThread inAccept = new AcceptThread(inboundPort, inSockets);
            AcceptThread outAccept = new AcceptThread(outboundPort, outSockets);
            Thread inThread = new Thread(inAccept);
            Thread outThread = new Thread(outAccept);
            inThread.start();
            outThread.start();
            log.info("TwoPortService running on ports " + inboundPort + " and " + outboundPort);

            while (keepRunning()) {
                Connection conn = accept(3000);
                if (conn != null) {
                    newConnection(conn);
                    log.info("Accepted connection from " + conn.getRemoteAddress().getHostAddress());
                }
            }

            inAccept.stop();
            outAccept.stop();
        }
        catch (Exception e) {
            log.error("Error while accepting connections: ", e);
        }
    }

    /** 
     * Returns a Connection based on an inbound and outbound connection pair from 
     * the same remote host.  This is done by looping through all the connections
     * trying to match the host addresses of all posible inbound and outbound 
     * pairs.  When a matching pair is found, both sockets are removed from the 
     * pending sockets lists, so there should normally be a very small number of 
     * sockets to search through.  This method will return null if the specified 
     * number of milliseconds has passed, otherwise will wait until a single remote 
     * host has connected to both the inbound and outbound ports.  
     */
    private Connection accept(long timeoutMillis) throws LLPException, IOException {
        long startTime = System.currentTimeMillis();
        Connection conn = null;
        while (conn == null && System.currentTimeMillis() < startTime + timeoutMillis) {
            int i = 0;
            while (conn == null && i < inSockets.size()) {
                Socket in = (Socket) inSockets.get(i);
                int j = 0;
                while (conn == null && j < outSockets.size()) {
                    Socket out = (Socket) outSockets.get(j);
                    if (out.getInetAddress().getHostAddress().equals(in.getInetAddress().getHostAddress())) {
                        conn = new Connection(parser, llp, in, out);
                        inSockets.remove(i);
                        outSockets.remove(j);
                    }
                    j++;
                }
                i++;
            }
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
            }
        }
        return conn;
    }

    /** 
     * A Runnable that accepts connections on a ServerSocket and adds them to 
     * a Vector, so that they can be matched later.  After stop() is called, the 
     * ServerSocket is closed.
     */
    private class AcceptThread implements Runnable {

        private ServerSocket ss;
        private Vector sockets;
        private boolean keepRunning = true;

        public AcceptThread(int port, Vector sockets) throws IOException, SocketException {
            ss = new ServerSocket(port);
            ss.setSoTimeout(3000);
            this.sockets = sockets;
        }

        public void run() {
            try {
                while (keepRunning) {
                    try {
                        Socket s = ss.accept();
                        sockets.add(s);
                    }
                    catch (InterruptedIOException e) { /* OK - just timed out */
                    }
                }
                ss.close();
            }
            catch (Exception e) {
                log.error("Problem running connection accept thread", e);
            }
        }

        public void stop() {
            keepRunning = false;
        }
    }

    /**
     * Run server from command line.  Inbound and outbound port numbers should be provided as arguments,
     * and a file containing a list of Applications to use can also be specified
     * as an optional argument (as per <code>super.loadApplicationsFromFile(...)</code>).
     * Uses the default LowerLayerProtocol.
     */
    public static void main(String args[]) {
        if (args.length < 2 || args.length > 3) {
            System.out.println(
                "Usage: ca.uhn.hl7v2.app.TwoPortService inbound_port outbound_port [application_spec_file_name]");
            System.exit(1);
        }

        int inPort = 0;
        int outPort = 0;
        try {
            inPort = Integer.parseInt(args[0]);
            outPort = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e) {
            System.err.println("One of the given ports (" + args[0] + " or " + args[1] + ") is not an integer.");
            System.exit(1);
        }

        File appFile = null;
        if (args.length == 3) {
            appFile = new File(args[2]);
        }

        try {
            TwoPortService server = new TwoPortService(new PipeParser(), LowerLayerProtocol.makeLLP(), inPort, outPort);
            if (appFile != null)
                server.loadApplicationsFromFile(appFile);
            server.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
