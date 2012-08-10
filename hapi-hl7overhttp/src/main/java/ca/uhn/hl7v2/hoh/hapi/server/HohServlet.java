package ca.uhn.hl7v2.hoh.hapi.server;

import java.util.HashMap;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.IMessageHandler;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.api.MessageProcessingException;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.raw.server.HohRawServlet;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.AppRoutingDataImpl;
import ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;

public class HohServlet extends HohRawServlet {

	private static final long serialVersionUID = 1L;
	private ApplicationRouter myApplicationRouter;

	/**
	 * Constructor
	 */
	public HohServlet() {
		super.setMessageHandler(new MessageHandlerImpl());
	}

	/**
	 * Route all messages to a single application
	 */
	public void setApplication(ReceivingApplication theApplication) {
		myApplicationRouter = new ApplicationRouterImpl();
		myApplicationRouter.bindApplication(AppRoutingDataImpl.withAll(), theApplication);
	}

	/**
	 * <p>
	 * Constructor which accepts an ApplicationRouter which may direct different
	 * types of messages to different applications
	 * </p>
	 * <p>
	 * Does not need to be provided if {@link setApplication()} has been called.
	 * </p>
	 */
	public void setApplicationRouter(ApplicationRouter theApplicationRouter) {
		myApplicationRouter = theApplicationRouter;
	}

	/**
	 * Must not be called
	 */
	@Override
	public void setMessageHandler(IMessageHandler<String> theMessageHandler) {
		throw new UnsupportedOperationException();
	}

	private class MessageHandlerImpl implements IMessageHandler<String> {

		public IResponseSendable<String> messageReceived(IReceivable<String> theMessage) throws MessageProcessingException {

			Transportable received = new TransportableImpl(theMessage.getMessage(), new HashMap<String, Object>(theMessage.getMetadata()));
			Transportable response;
			try {
				response = myApplicationRouter.processMessage(received);
			} catch (HL7Exception e) {
				throw new MessageProcessingException(e);
			}

			return new RawSendable(response.getMessage());
		}

	}

}
