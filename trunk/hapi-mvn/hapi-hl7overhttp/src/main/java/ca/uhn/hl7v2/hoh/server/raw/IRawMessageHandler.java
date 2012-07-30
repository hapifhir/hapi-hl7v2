package ca.uhn.hl7v2.hoh.server.raw;

import ca.uhn.hl7v2.hoh.server.MessageProcessingException;

/**
 * <p>
 * Service interface which can be implemented by an application to
 * process incoming messages received by {@link Hl7OverHttpRawMessageServlet}.
 * </p>
 * <p>
 * 
 * </p>
 * 
 */
public interface IRawMessageHandler {

	IRawMessageResponse messageReceived(IRawMessage theMessage) throws MessageProcessingException;
	
}
