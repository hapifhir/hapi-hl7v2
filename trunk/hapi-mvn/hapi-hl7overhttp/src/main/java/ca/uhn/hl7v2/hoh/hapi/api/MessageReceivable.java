package ca.uhn.hl7v2.hoh.hapi.api;

import ca.uhn.hl7v2.hoh.api.AbstractReceivable;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.model.Message;

public class MessageReceivable extends AbstractReceivable<Message> implements IReceivable<Message> {

	private final Message myMessage;

	public MessageReceivable(Message theMessage) {
		myMessage = theMessage;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Message getMessage() {
		return myMessage;
	}

}
