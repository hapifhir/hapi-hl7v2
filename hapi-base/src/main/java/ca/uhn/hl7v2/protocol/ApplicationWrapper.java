package ca.uhn.hl7v2.protocol;

import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.model.Message;

/**
 * Wraps a legacy HAPI {@link Application} to convert it to a new
 * style {@link ReceivingApplication}
 */
public class ApplicationWrapper implements ReceivingApplication {

	private final Application application;

	/**
	 * Constructor
	 * 
	 * @param theApplication The application to wrap
	 */
	public ApplicationWrapper(Application theApplication) {
		this.application = theApplication;
	}

	/**
	 * {@inheritDoc}
	 */
	public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
		try {
			return this.application.processMessage(theMessage);
		} catch (ApplicationException e) {
			throw new ReceivingApplicationException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canProcess(Message theMessage) {
		return this.application.canProcess(theMessage);
	}

}
