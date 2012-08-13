package ca.uhn.hl7v2.examples.hoh;

import ca.uhn.hl7v2.hoh.api.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.api.IMessageHandler;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.api.MessageProcessingException;
import ca.uhn.hl7v2.hoh.auth.SingleCredentialServerCallback;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.raw.server.HohRawServlet;

/**
 * This class illustrates an example HL7 over HTTP
 * raw message servlet for receiving and responding to messages
 */
public class ExampleRawHl7OverHttpServlet extends HohRawServlet {

	/**
	 * Constructor
	 */
	public ExampleRawHl7OverHttpServlet() {
		
		/*
		 * The servlet must be provided an implementation
		 * of IMessageHandler<String>, such as the one which
		 * is nested below
		 */
		setMessageHandler(new ExampleMessageHandler());
		
		/* 
		 * Optionally, if we want to verify HTTP authentication,
		 * we can specify an authorization callback
		 */
		IAuthorizationServerCallback callback = 
			  new SingleCredentialServerCallback("someusername", "apassword");
		setAuthorizationCallback(callback);
		
	}

	/**
	 * IMessageHandler defines the interface for the class which receives
	 * and processes messages which come in
	 */
	private static class ExampleMessageHandler implements IMessageHandler<String> {

		/**
		 * This method is fired every time a message is received. The return value
		 * contains the HL7 response value 
		 */
		public IResponseSendable<String> messageReceived(IReceivable<String> theReceived) 
				   throws MessageProcessingException {
			
			String incomingRawMsg = theReceived.getMessage();
			System.out.println("Received message:\n" + incomingRawMsg);
			
			// ... do some processing ...
			
			/*
			 * Your application should generate an appropriate 
			 * HL7 ACK message here
			 */
			String ack = "MSH|....."; 
			
			/*
			 * If something goes horribly wrong, you can throw an 
			 * exception and an HTTP 500 error will be generated.
			 * However, it is preferable to return a normal HL7 ACK 
			 * message with an "AE" response code to note an error. 
			 */
			boolean somethingFailed = false;
			if (somethingFailed) {
				throw new MessageProcessingException("");
			}
			
			// Return the raw response message
			return new RawSendable(ack);
		}
		
	}
	
}
