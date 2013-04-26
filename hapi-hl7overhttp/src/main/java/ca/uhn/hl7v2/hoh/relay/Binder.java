package ca.uhn.hl7v2.hoh.relay;

import org.springframework.beans.factory.InitializingBean;

import ca.uhn.hl7v2.hoh.relay.listener.IRelayListener;
import ca.uhn.hl7v2.hoh.relay.sender.IRelaySender;
import ca.uhn.hl7v2.hoh.util.Validate;
import ca.uhn.hl7v2.hoh.util.VersionLogger;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;

public class Binder implements InitializingBean {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Binder.class);

    private static final String ourProductName = "HAPI HL7 over HTTP Relay " + VersionLogger.getVersion();

	private String myMessageType = "*";
	private String myProcessingId = "*";
	private IRelayListener myRelayListener;
	private IRelaySender myRelaySender;
	private String myTriggerEvent = "*";
	private String myVersionId = "*";
	
	/**
	 * {@inheritDoc}
	 */
	public void afterPropertiesSet() throws Exception {
		Validate.propertySet(myRelayListener, "listener");
		Validate.propertySet(myRelaySender, "sender");

		ourLog.info("Binding sender[{}] to listener[{}] for messages with profile[MsgType:{} / MsgTrigger:{} / Version:{} / Processing:{}]", new Object[] { myRelaySender.getBeanName(), myRelayListener.getBeanName(), myMessageType, myTriggerEvent, myVersionId, myProcessingId });

		AppRoutingDataImpl appRoutingData = new AppRoutingDataImpl(myMessageType, myTriggerEvent, myProcessingId, myVersionId);
		myRelayListener.registerApplication(appRoutingData, myRelaySender);
	}

	public void setListener(IRelayListener theRelayListener) {
		myRelayListener = theRelayListener;
	}

	/**
	 * @param theRelaySender
	 *            the sender to set
	 */
	public void setSender(IRelaySender theRelaySender) {
		myRelaySender = theRelaySender;
	}

	/**
	 * Returns the product name
	 */
	public static String getProductname() {
		return ourProductName;
	}

}
