package ca.uhn.hl7v2.hoh.relay;

import org.springframework.beans.factory.InitializingBean;

import ca.uhn.hl7v2.hoh.relay.listener.IListener;
import ca.uhn.hl7v2.hoh.relay.sender.ISender;
import ca.uhn.hl7v2.hoh.util.Validate;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;

public class Binder implements InitializingBean {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Binder.class);

	private IListener myListener;
	private String myMessageType = "*";
	private String myProcessingId = "*";
	private ISender mySender;
	private String myTriggerEvent = "*";
	private String myVersionId = "*";

	/**
	 * {@inheritDoc}
	 */
	public void afterPropertiesSet() throws Exception {
		Validate.propertySet(myListener, "listener");
		Validate.propertySet(mySender, "sender");

		ourLog.info("Binding sender[{}] to listener[{}] for messages with profile[{}/{}/{}/{}]", new Object[] { mySender.getBeanName(), myListener.getBeanName(), myMessageType, myTriggerEvent, myVersionId, myProcessingId });

		AppRoutingDataImpl appRoutingData = new AppRoutingDataImpl(myMessageType, myTriggerEvent, myProcessingId, myVersionId);
		myListener.registerApplication(appRoutingData, mySender);
	}

	public void setListener(IListener theListener) {
		myListener = theListener;
	}

	/**
	 * @param theSender
	 *            the sender to set
	 */
	public void setSender(ISender theSender) {
		mySender = theSender;
	}

}
