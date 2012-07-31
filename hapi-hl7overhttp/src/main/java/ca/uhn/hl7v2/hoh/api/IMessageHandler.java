package ca.uhn.hl7v2.hoh.api;

import ca.uhn.hl7v2.hoh.raw.server.HohRawServlet;

/**
 * <p>
 * Service interface which can be implemented by an application to
 * process incoming messages received by {@link HohRawServlet}.
 * </p>
 * <p>
 * 
 * </p>
 * 
 */
public interface IMessageHandler<T> {

	IResponseSendable<T> messageReceived(IReceivable<T> theMessage) throws MessageProcessingException;
	
}
