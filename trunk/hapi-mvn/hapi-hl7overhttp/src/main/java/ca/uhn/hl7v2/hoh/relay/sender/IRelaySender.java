package ca.uhn.hl7v2.hoh.relay.sender;

import ca.uhn.hl7v2.model.Message;
import org.springframework.beans.factory.NamedBean;

import ca.uhn.hl7v2.protocol.ReceivingApplication;

public interface IRelaySender<T extends Message> extends NamedBean, ReceivingApplication<T> {

}
