/*
 * Created on 22-Feb-2005
 */
package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;
import junit.framework.TestCase;

/**
 * Unit tests for Receiver.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ReceiverTest extends TestCase {

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Constructor for ReceiverTest.
     * @param arg0
     */
    public ReceiverTest(String arg0) {
        super(arg0);
    }
    
    public void testCloseConnectionOnNullMessage() throws LLPException, IOException, InterruptedException {
        int port = 9873;
        final ServerSocket ss = new ServerSocket(port);
        Runnable acceptor = new Runnable() {
            public void run() {
                try {
                    Socket s = ss.accept();
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread acceptorThread = new Thread(acceptor);
        acceptorThread.start();
        
        Socket clientSocket = new Socket("localhost", port);
        final Properties flagHolder = new Properties();
        flagHolder.setProperty("closed", "no");
        Connection conn = new Connection(new PipeParser(), new MinLowerLayerProtocol(), clientSocket) {
            public void close() {
                super.close();
                flagHolder.setProperty("closed", "yes");
            }
        };
        
        Thread.sleep(200);
        
        assertEquals("yes", flagHolder.getProperty("closed"));
        ss.close();
    }

    public void testCloseConnectionOnNullMessage2() throws LLPException, IOException, InterruptedException {
        //this time the client closes the socket
        int port = 9873;
        final ServerSocket ss = new ServerSocket(port);
        Runnable acceptor = new Runnable() {
            public void run() {
                try {
                    Socket s = ss.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread acceptorThread = new Thread(acceptor);
        acceptorThread.start();
        
        Socket clientSocket = new Socket("localhost", port);
        final Properties flagHolder = new Properties();
        flagHolder.setProperty("closed", "no");
        Connection conn = new Connection(new PipeParser(), new MinLowerLayerProtocol(), clientSocket) {
            public void close() {
                super.close();
                flagHolder.setProperty("closed", "yes");
            }
        };

        clientSocket.close();
        
        Thread.sleep(200);
        
        assertEquals("yes", flagHolder.getProperty("closed"));
        ss.close();
    }
}
