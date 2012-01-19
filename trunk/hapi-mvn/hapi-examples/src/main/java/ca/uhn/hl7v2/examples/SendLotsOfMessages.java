package ca.uhn.hl7v2.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;

public class SendLotsOfMessages {

	public static void main(String[] args) throws FileNotFoundException, HL7Exception, LLPException {
		
		/*
		 * This example shows how to send lots of messages. Specifically it
		 * reads from a file, but that is not the only way to do this.
		 */

		/*
		 * First set up a reader. 
		 *  
		 * message_file.txt is a file containing lots of ER7 encoded messages we are going to
		 * send out. 
		 */
		FileReader reader = new FileReader("message_file.txt");
		
		// Create an iterator to iterate over all the messages
		Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(reader);
		
		ConnectionHub connectionHub = ConnectionHub.getInstance();
		Connection conn = null;
		
		while (iter.hasNext()) {
			
			Message next = iter.next();
			
			/* If we don't already have a connection, create one.
			 * Note that unless something goes wrong, it's very common
			 * to keep reusing the same connection until we are done
			 * sending messages. Many systems keep a connection open
			 * even if a long period will pass between messages being
			 * sent. This is good practice, as it is much faster than
			 * creating a new connection each time. 
			 */ 
			if (conn == null) {
				conn = connectionHub.attach("localhost", 8888, new PipeParser(), MinLowerLayerProtocol.class);
			}
			
			Message response;
			try {
				response = conn.getInitiator().sendAndReceive(next);
			} catch (IOException e) {
				System.out.println("Didn't send out this message!");
				e.printStackTrace();
				
				// Since we failed, return the connection to the ConnectionHub so that it can
				// discard it, and make sure we're going to create a new one next time around
				connectionHub.discard(conn);
				conn = null;
				continue;
			}
			
			System.out.println("Sent message. Response was " + response.encode());
			
		}
		
		// When we're totally done, give the connection back. This allows the
		// connection hub to either give it to someone else, or close it.
		if (conn != null) {
			connectionHub.detach(conn);
		}
		ConnectionHub.shutdown();
		
	}

}
