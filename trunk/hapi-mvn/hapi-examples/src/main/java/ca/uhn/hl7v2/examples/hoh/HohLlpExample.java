package ca.uhn.hl7v2.examples.hoh;

import java.io.IOException;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

public class HohLlpExample {

	public void receiveMessage() {
		
// START SNIPPET: server 
/*
 * Sending a message with HAPI and HL7 over HTTP. First
 * an LLP instance is created. Note that you must tell
 * the LLP class whether it will be used in a client
 * or a server.
 */
LowerLayerProtocol llp;
llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.SERVER);

/* 
 * Create the server, and pass in the HoH LLP instance
 * 
 * Note that the HoH LLP implementation will not
 * work in two-socket servers
 */
PipeParser parser = PipeParser.getInstanceWithNoValidation();
int port = 8080;
SimpleServer server = new SimpleServer(port, llp, parser);

// Register an application to the server, and start it
// You are now ready to receive HL7 messages!
server.registerApplication("*", "*", (ReceivingApplication)new DefaultApplication());
server.start();
// END SNIPPET: server 

		
	}
	
	@SuppressWarnings("unused")
   public void sendMessage() throws HL7Exception, IOException, LLPException {
		
// START SNIPPET: client 
/*
 * Sending a message with HAPI and HL7 over HTTP. First
 * an LLP instance is created. Note that you must tell
 * the LLP class whether it will be used in a client
 * or a server.
 */
DefaultHapiContext ctx = new DefaultHapiContext();

// Create an HoH LLP for the context
LowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
ctx.setLowerLayerProtocol(llp);

// Use the LLP in a HapiContext to get a client connection
String host = "localhost";
int port = 8080;
boolean tls = false;
Connection connection = ctx.newClient(host, port, tls);

// Create a message to send
ADT_A01 message = new ADT_A01();
message.initQuickstart("ADT", "A01", "P");
// ... populate message ...

// Send the message
Message response = connection.getInitiator().sendAndReceive(message);
// END SNIPPET: client 
	
	}
	
}
