package ca.uhn.hl7v2.hoh.relay.listener;

import org.springframework.beans.factory.NamedBean;

import ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

public interface IListener extends NamedBean {

	void registerApplication(AppRoutingData theAppRouting, ReceivingApplication theReceivingApplication);
	
}
