/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;

/**
 * Routes messages to the appropriate application.
 *
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 */
public interface ApplicationRouter {
    /**
     * {@link Transportable#getMetadata() Metadata} key:
     * Charset (MSH-18)
     */
    String METADATA_KEY_MESSAGE_CHARSET = "MSH-18";

    /**
     * {@link Transportable#getMetadata() Metadata} key:
     * Message control ID (MSH-10)
     */
    String METADATA_KEY_MESSAGE_CONTROL_ID = MetadataKeys.IN_MESSAGE_CONTROL_ID;

    /**
     * {@link Transportable#getMetadata() Metadata} key:
     * Provides the IP of the sending system for a given message
     */
    String METADATA_KEY_SENDING_IP = MetadataKeys.IN_SENDING_IP;

    /**
     * {@link Transportable#getMetadata() Metadata} key:
     * Provides the port of the sending system for a given message
     */
    String METADATA_KEY_SENDING_PORT = MetadataKeys.IN_SENDING_PORT;


    /**
     * Attempts to route the given message to the associated <code>Application</code>
     * and obtain a response.
     *
     * @param theMessage the message to route
     * @return the response message (this may be null, for example if the given
     * message doesn't require an application ACK)
     */
    Transportable processMessage(Transportable theMessage) throws HL7Exception;

    /**
     * @param theRoutingData message fields used in determining the appropriate destination
     * @return true if there is a destination application for messages with the given
     * characteristics
     */
    boolean hasActiveBinding(AppRoutingData theRoutingData);

    /**
     * <p>Associates the given application with the given message parameters, so that messages
     * with matching parameters will be sent there.  Only one application can be registered
     * for a given set of parameters: repeated registration for a particular combination
     * over-writes the previous one.</p>
     * <p/>
     * <p>Because of wildcards, there may be multiple registrations that match a given message.
     * In this case, the first registered wins.</p>
     *
     * @param theRoutingData message fields used in determining the appropriate destination
     * @param theApplication the application to which messages with these parameters should be
     *                       sent
     */
    void bindApplication(AppRoutingData theRoutingData, ReceivingApplication<? extends Message> theApplication);

    /**
     * Removes the binding for the given message parameters
     *
     * @param theRoutingData
     * @return true if an application was unbound, false otherwise
     */
    boolean unbindApplication(AppRoutingData theRoutingData);

    /**
     * Removes the binding for the given message parameters
     *
     * @param theApplication
     * @return true if an application was unbound, false otherwise
     */
    boolean unbindApplication(ReceivingApplication<? extends Message> theApplication);

    /**
     * Temporarily deactivates the binding on the given field data, if present.
     *
     * @param theRoutingData the fields that define a set of messages that are bound to
     *                       some <code>Application</code>
     */
    void disableBinding(AppRoutingData theRoutingData);

    /**
     * Undoes <code>disableBinding(AppRoutingData theRoutingData)</code>.
     *
     * @param theRoutingData the fields that define a set of messages that are bound to
     *                       some <code>Application</code>
     */
    void enableBinding(AppRoutingData theRoutingData);

    /**
     * @return the <code>Parser</code> that is used to parse inbound messages
     * and encode outbound ones.  It may be of interest to set certain parameters
     * of this parser.
     */
    Parser getParser();

    /**
     * Sets an exception handler which will be invoked in the event of a
     * failure during parsing, processing, or encoding of an
     * incoming message or its response.
     */
    void setExceptionHandler(ReceivingApplicationExceptionHandler exceptionHandler);

    /**
     * <p>Encapsulates the message fields used for routing of messages from the
     * HL7 protocol to the appropriate <code>Application</code>. </p>
     * <p/>
     * <p>The wildcard "*" in any member indicates all values of the associated parameter.  For
     * example the conbination "ADT", "*", "*", "*" means all ADT messages.  Each value can also
     * be a regular expression that is matched against the corresponding field.  </p>
     *
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     */
    interface AppRoutingData {

        /**
         * @return MSH-9-1
         */
        String getMessageType();

        /**
         * @return MSH-9-2
         */
        String getTriggerEvent();

        /**
         * @return MSH-11-1
         */
        String getProcessingId();

        /**
         * @return MSH-12
         */
        String getVersion();
    }

}
