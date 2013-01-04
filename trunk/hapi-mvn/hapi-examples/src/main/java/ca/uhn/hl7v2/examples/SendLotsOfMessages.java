package ca.uhn.hl7v2.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
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
		
		// Create a HapiContext
		HapiContext context = new DefaultHapiContext();
		
		Connection conn = null;
		while (iter.hasNext()) {
			
			/* If we don't already have a connection, create one.
			 * Note that unless something goes wrong, it's very common
			 * to keep reusing the same connection until we are done
			 * sending messages. Many systems keep a connection open
			 * even if a long period will pass between messages being
			 * sent. This is good practice, as it is much faster than
			 * creating a new connection each time. 
			 */ 
			if (conn == null) {
				boolean useTls = false;
				int port = 8888;
				conn = context.newClient("localhost", port, useTls);
			}
			
			try {
				Message next = iter.next();
				Message response = conn.getInitiator().sendAndReceive(next);
				System.out.println("Sent message. Response was " + response.encode());
			} catch (IOException e) {
				System.out.println("Didn't send out this message!");
				e.printStackTrace();
				
				// Since we failed, close the connection
				conn.close();
				conn = null;
				
			}
			
		}
		
	}

}
