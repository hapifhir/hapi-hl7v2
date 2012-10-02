package ca.uhn.hl7v2.examples.hoh;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.hapi.server.HohServlet;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

/**
 * Example servlet implementation which receives HL7 messages
 * and uses HAPI to process them.
 */
public class ExampleHl7OverHttpServletWithOneApplication extends HohServlet {

	/**
	 * Initialise the servlet
	 */
	@Override
	public void init(ServletConfig theConfig) throws ServletException {
		
		/* Servlet should be initialized with an instance of
		 * ReceivingApplication, which handles incoming messages 
		 */
		setApplication(new MyApplication());
		
	}

	/**
	 * The application does the actual processing
	 */
	private class MyApplication implements ReceivingApplication
	{

		/**
		 * processMessage is fired each time a new message 
		 * arrives. 
		 * 
		 * @param theMessage The message which was received
		 * @param theMetadata A map containing additional information about
		 *                    the message, where it came from, etc.  
		 */
		public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
			System.out.println("Received message:\n" + theMessage.encode());

			// .. process the message ..
			
			/*
			 * Now reply to the message
			 */
			Message response;
			try {
				response = theMessage.generateACK();
			} catch (IOException e) {
				throw new ReceivingApplicationException(e);
			}
			
			/*
			 * If something goes horribly wrong, you can throw an 
			 * exception and an HTTP 500 error will be generated.
			 * However, it is preferable to return a normal HL7 ACK 
			 * message with an "AE" response code to note an error. 
			 */
			boolean somethingFailed = false;
			if (somethingFailed) {
				throw new ReceivingApplicationException("");
			}

			/*
			 * It is better to return an HL7 message with an AE response
			 * code. This will still be returned by the transport with
			 * an HTTP 500 status code, but an HL7 message will still 
			 * be propagated up. 
			 */
			if (somethingFailed) {
				try {
					response = theMessage.generateACK(AcknowledgmentCode.AE, 
							new HL7Exception("There was a problem!!"));
				} catch (IOException e) {
					throw new ReceivingApplicationException(e);
				}
			}
			
			return response;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean canProcess(Message theMessage) {
			return true;
		}
		
	}
	
}
