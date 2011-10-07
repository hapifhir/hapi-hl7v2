/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "SimpleServer.java".  Description:
 * "A simple TCP/IP-based HL7 server."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): Kyle Buza
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.app;

import java.io.File;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;

import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>A simple TCP/IP-based HL7 server.  This server listens for connections
 * on a particular port, and creates a ConnectionManager for each incoming
 * connection.  </p>
 * <p>A single SimpleServer can only service requests that use a
 * single class of LowerLayerProtocol (specified at construction time).</p>
 * <p>The ConnectionManager uses a PipeParser of the version specified in
 * the constructor</p>
 * <p>ConnectionManagers currently only support original mode processing.</p>
 * <p>The ConnectionManager routes messages to various "Application"s based on
 * message type.  From the HL7 perspective, an Application is something that
 * does something with a message.</p>
 * @author  Bryan Tripp
 */
public class SimpleServer extends HL7Service {

    /**
     * Socket timeout for simple server
     */
    public static final int SO_TIMEOUT = 3000;

    private static final HapiLog log = HapiLogFactory.getHapiLog(SimpleServer.class);

    private int port;

    /**
     * Creates a new instance of SimpleServer that listens
     * on the given port.  Exceptions are logged using ca.uhn.hl7v2.Log;
     */
    public SimpleServer(int port, LowerLayerProtocol llp, Parser parser) {
        super(parser, llp);
        this.port = port;
    }

    /**
     * Loop that waits for a connection and starts a ConnectionManager
     * when it gets one.
     */
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(port);
            ss.setSoTimeout(SO_TIMEOUT);
            log.info("SimpleServer running on port " + ss.getLocalPort());
            while (isRunning()) {
                try {
                    Socket newSocket = ss.accept();
                    log.info("Accepted connection from " + newSocket.getInetAddress().getHostAddress());
                    Connection conn = new Connection(parser, this.llp, newSocket);
                    newConnection(conn);
                }
                catch (InterruptedIOException ie) {
                    //ignore - just timed out waiting for connection
                }
                catch (Exception e) {
                    log.error( "Error while accepting connections: ", e);
                }
            }

            ss.close();
        }
        catch (Exception e) {
            log.error(e);
        }
        finally {
            //Bug 960113:  Make sure HL7Service.stop() is called to stop ConnectionCleaner thread.
            this.stop();
        }
    }

    /**
     * Run server from command line.  Port number should be passed as an argument,
     * and a file containing a list of Applications to use can also be specified
     * as an optional argument (as per <code>loadApplicationsFromFile(...)</code>).
     * Uses the default LowerLayerProtocol.
     */
    public static void main(String args[]) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: ca.uhn.hl7v2.app.SimpleServer port_num [application_spec_file_name]");
            System.exit(1);
        }

        int port = 0;
        try {
            port = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            System.err.println("The given port (" + args[0] + ") is not an integer.");
            System.exit(1);
        }

        File appFile = null;
        if (args.length == 2) {
            appFile = new File(args[1]);
        }

        try {
            SimpleServer server = new SimpleServer(port, LowerLayerProtocol.makeLLP(), new PipeParser());
            if (appFile != null)
                server.loadApplicationsFromFile(appFile);
            server.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
