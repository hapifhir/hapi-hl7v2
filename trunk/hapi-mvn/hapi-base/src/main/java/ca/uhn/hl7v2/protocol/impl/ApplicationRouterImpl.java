/*
 * Created on 21-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.*;
import ca.uhn.hl7v2.util.DeepCopy;
import ca.uhn.hl7v2.util.Terser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>A default implementation of <code>ApplicationRouter</code> </p>
 *
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-01 00:22:23 $ by $Author: jamesagnew $
 */
public class ApplicationRouterImpl implements ApplicationRouter {

    /**
     * The default acknowledgment code used in MSA-1 when generating a NAK (negative ACK) message
     * as a result of a processing exception.
     */
    public static final AcknowledgmentCode DEFAULT_EXCEPTION_ACKNOWLEDGEMENT_CODE = AcknowledgmentCode.AE;

    private static final Logger log = LoggerFactory.getLogger(ApplicationRouterImpl.class);

    /**
     * Key under which raw message text is stored in metadata Map sent to
     * <code>ReceivingApplication</code>s.
     */
    public static String RAW_MESSAGE_KEY = MetadataKeys.IN_RAW_MESSAGE;

    private List<Binding> myBindings;
    private Parser myParser;
    private ReceivingApplicationExceptionHandler myExceptionHandler;
    private HapiContext myContext;


    /**
     * Creates an instance that uses a <code>GenericParser</code>.
     */
    @Deprecated
    public ApplicationRouterImpl() {
        this(new GenericParser());
    }

    /**
     * Creates an instance that uses the specified <code>Parser</code>.
     *
     * @param theParser the parser used for converting between Message and
     *                  Transportable
     */
    public ApplicationRouterImpl(Parser theParser) {
        this(theParser.getHapiContext(), theParser);
    }

    public ApplicationRouterImpl(HapiContext theContext) {
        this(theContext, theContext.getGenericParser());
    }

    /**
     * Creates an instance that uses the specified <code>Parser</code>.
     *
     * @param theContext HAPI context
     * @param theParser  the parser used for converting between Message and
     *                   Transportable
     */
    public ApplicationRouterImpl(HapiContext theContext, Parser theParser) {
        init(theParser);
        myContext = theContext;
    }

    private void init(Parser theParser) {
        myBindings = new ArrayList<Binding>(20);
        myParser = theParser;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#processMessage(ca.uhn.hl7v2.protocol.Transportable)
     */
    public Transportable processMessage(Transportable theMessage) throws HL7Exception {
        String[] result = processMessage(theMessage.getMessage(), theMessage.getMetadata());
        Transportable response = new TransportableImpl(result[0]);

        if (result[1] != null) {
            response.getMetadata().put(METADATA_KEY_MESSAGE_CHARSET, result[1]);
        }

        return response;
    }

    /**
     * Processes an incoming message string and returns the response message string.
     * Message processing consists of parsing the message, finding an appropriate
     * Application and processing the message with it, and encoding the response.
     * Applications are chosen from among those registered using
     * <code>bindApplication</code>.
     *
     * @return {text, charset}
     */
    private String[] processMessage(String incomingMessageString, Map<String, Object> theMetadata) throws HL7Exception {
        Logger rawOutbound = LoggerFactory.getLogger("ca.uhn.hl7v2.raw.outbound");
        Logger rawInbound = LoggerFactory.getLogger("ca.uhn.hl7v2.raw.inbound");

        // TODO: add a way to register an application handler and
        // invoke it any time something goes wrong

        log.debug("ApplicationRouterImpl got message: {}", incomingMessageString);
        rawInbound.debug(incomingMessageString);

        Message incomingMessageObject = null;
        String outgoingMessageString = null;
        String outgoingMessageCharset = null;
        try {
            incomingMessageObject = myParser.parse(incomingMessageString);

            Terser inTerser = new Terser(incomingMessageObject);
            theMetadata.put(MetadataKeys.IN_MESSAGE_CONTROL_ID, inTerser.get("/.MSH-10"));

        } catch (HL7Exception e) {
            try {
                outgoingMessageString = logAndMakeErrorMessage(e, myParser.getCriticalResponseData(incomingMessageString), myParser, myParser.getEncoding(incomingMessageString));
            } catch (HL7Exception e2) {
                outgoingMessageString = null;
            }
            if (myExceptionHandler != null) {
                outgoingMessageString = myExceptionHandler.processException(incomingMessageString, theMetadata, outgoingMessageString, e);
                if (outgoingMessageString == null) {
                    throw new HL7Exception("Application exception handler may not return null");
                }
            }
        }

        // At this point, no exception has occurred and the message is processed normally
        if (outgoingMessageString == null) {
            try {
                //optionally check integrity of parse
                String check = System.getProperty("ca.uhn.hl7v2.protocol.impl.check_parse");
                if (check != null && check.equals("TRUE")) {
                    ParseChecker.checkParse(incomingMessageString, incomingMessageObject, myParser);
                }

                //message validation (in terms of optionality, cardinality) would go here ***

                ReceivingApplication app = findApplication(incomingMessageObject);
                theMetadata.put(RAW_MESSAGE_KEY, incomingMessageString);

                log.debug("Sending message to application: {}", app.toString());
                Message response = app.processMessage(incomingMessageObject, theMetadata);

                //Here we explicitly use the same encoding as that of the inbound message - this is important with GenericParser, which might use a different encoding by default
                outgoingMessageString = myParser.encode(response, myParser.getEncoding(incomingMessageString));

                Terser t = new Terser(response);
                outgoingMessageCharset = t.get(METADATA_KEY_MESSAGE_CHARSET);
            } catch (Exception e) {
                outgoingMessageString = handleProcessMessageException(incomingMessageString, theMetadata, incomingMessageObject, e);
            } catch (Error e) {
                log.debug("Caught runtime exception of type {}, going to wrap it as HL7Exception and handle it", e.getClass());
                HL7Exception wrapped = new HL7Exception(e);
                outgoingMessageString = handleProcessMessageException(incomingMessageString, theMetadata, incomingMessageObject, wrapped);
            }
        }

        log.debug("ApplicationRouterImpl sending message: {}", outgoingMessageString);
        rawOutbound.debug(outgoingMessageString);

        return new String[]{outgoingMessageString, outgoingMessageCharset};
    }

    private String handleProcessMessageException(String incomingMessageString, Map<String, Object> theMetadata, Message incomingMessageObject, Exception e) throws HL7Exception {
        String outgoingMessageString;
        Segment inHeader = incomingMessageObject != null ? (Segment) incomingMessageObject.get("MSH") : null;
        outgoingMessageString = logAndMakeErrorMessage(e, inHeader, myParser, myParser.getEncoding(incomingMessageString));
        if (outgoingMessageString != null && myExceptionHandler != null) {
            outgoingMessageString = myExceptionHandler.processException(incomingMessageString, theMetadata, outgoingMessageString, e);
        }
        return outgoingMessageString;
    }


    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#hasActiveBinding(ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData)
     */
    public boolean hasActiveBinding(AppRoutingData theRoutingData) {
        boolean result = false;
        ReceivingApplication app = findDestination(null, theRoutingData);
        if (app != null) {
            result = true;
        }
        return result;
    }

    /**
     * @param theMessage     message for which a destination is looked up
     * @param theRoutingData routing data
     * @return the application from the binding with a WILDCARD match, if one exists
     */
    private ReceivingApplication findDestination(Message theMessage, AppRoutingData theRoutingData) {
        ReceivingApplication result = null;
        for (int i = 0; i < myBindings.size() && result == null; i++) {
            Binding binding = myBindings.get(i);
            if (matches(theRoutingData, binding.routingData) && binding.active) {
                if (theMessage == null || binding.application.canProcess(theMessage)) {
                    result = binding.application;
                }
            }
        }
        return result;
    }

    /**
     * @param theRoutingData routing data
     * @return the binding with an EXACT match on routing data if one exists
     */
    private Binding findBinding(AppRoutingData theRoutingData) {
        Binding result = null;
        for (int i = 0; i < myBindings.size() && result == null; i++) {
            Binding binding = myBindings.get(i);
            if (theRoutingData.equals(binding.routingData)) {
                result = binding;
            }
        }
        return result;

    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#bindApplication(
     *ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData, ca.uhn.hl7v2.protocol.ReceivingApplication)
     */
    public void bindApplication(AppRoutingData theRoutingData, ReceivingApplication theApplication) {
        Binding binding = new Binding(theRoutingData, true, theApplication);
        myBindings.add(binding);
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#disableBinding(ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData)
     */
    public void disableBinding(AppRoutingData theRoutingData) {
        Binding b = findBinding(theRoutingData);
        if (b != null) {
            b.active = false;
        }
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#enableBinding(ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData)
     */
    public void enableBinding(AppRoutingData theRoutingData) {
        Binding b = findBinding(theRoutingData);
        if (b != null) {
            b.active = true;
        }
    }

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#getParser()
     */
    public Parser getParser() {
        return myParser;
    }

    /**
     * {@inheritDoc}
     */
    public void setExceptionHandler(ReceivingApplicationExceptionHandler theExceptionHandler) {
        this.myExceptionHandler = theExceptionHandler;
    }

    /**
     * @param theMessageData   routing data related to a particular message
     * @param theReferenceData routing data related to a binding, which may include
     *                         wildcards
     * @return true if the message data is consist with the reference data, ie all
     * values either match or are wildcards in the reference
     */
    public static boolean matches(AppRoutingData theMessageData,
                                  AppRoutingData theReferenceData) {

        boolean result = false;

        if (matches(theMessageData.getMessageType(), theReferenceData.getMessageType())
                && matches(theMessageData.getTriggerEvent(), theReferenceData.getTriggerEvent())
                && matches(theMessageData.getProcessingId(), theReferenceData.getProcessingId())
                && matches(theMessageData.getVersion(), theReferenceData.getVersion())) {

            result = true;
        }

        return result;
    }

    //support method for matches(AppRoutingData theMessageData, AppRoutingData theReferenceData)
    private static boolean matches(String theMessageData, String theReferenceData) {
        boolean result = false;

        String messageData = theMessageData;
        if (messageData == null) {
            messageData = "";
        }

        if (messageData.equals(theReferenceData) ||
                theReferenceData.equals("*") ||
                Pattern.matches(theReferenceData, messageData)) {
            result = true;
        }
        return result;
    }

    /**
     * Returns the first Application that has been bound to messages of this type.
     */
    private ReceivingApplication findApplication(Message theMessage) throws HL7Exception {
        Terser t = new Terser(theMessage);
        AppRoutingData msgData =
                new AppRoutingDataImpl(t.get("/MSH-9-1"), t.get("/MSH-9-2"), t.get("/MSH-11-1"), t.get("/MSH-12"));

        ReceivingApplication app = findDestination(theMessage, msgData);

        //have to send back an application reject if no apps available to process
        if (app == null) {
            app = new DefaultApplication();
        }

        return app;
    }

    /**
     * A structure for bindings between routing data and applications.
     */
    private static class Binding {
        public AppRoutingData routingData;
        public boolean active;
        public ReceivingApplication application;

        public Binding(AppRoutingData theRoutingData, boolean isActive, ReceivingApplication theApplication) {
            routingData = theRoutingData;
            active = isActive;
            application = theApplication;
        }
    }

    /**
     * Logs the given exception and creates an error message to send to the
     * remote system.
     *
     * @param e        exception
     * @param inHeader MSH segment of incoming message
     * @param p        parser to be used
     * @param encoding The encoding for the error message. If <code>null</code>, uses
     *                 default encoding
     * @return error message as string
     * @throws ca.uhn.hl7v2.HL7Exception if an error occured during generation of the error message
     */
    public String logAndMakeErrorMessage(Exception e, Segment inHeader,
                                         Parser p, String encoding) throws HL7Exception {

        switch (myContext.getServerConfiguration().getApplicationExceptionPolicy()) {
            case DO_NOT_RESPOND:
                log.error("Application exception detected, not going to send a response back to the client", e);
                return null;
            case DEFAULT:
            default:
                log.error("Attempting to send error message to remote system.", e);
                break;
        }

        HL7Exception hl7e = e instanceof HL7Exception ?
                (HL7Exception) e :
                new HL7Exception(e.getMessage(), e);

        try {
            Message out = hl7e.getResponseMessage();
            if (out == null) {
                Message in = getInMessage(inHeader);
                out = in.generateACK(DEFAULT_EXCEPTION_ACKNOWLEDGEMENT_CODE, hl7e);
            }
            return encoding != null ? p.encode(out, encoding) : p.encode(out);

        } catch (IOException ioe) {
            throw new HL7Exception(
                    "IOException creating error response message: "
                            + ioe.getMessage());
        }

    }

    private Message getInMessage(Segment inHeader) throws HL7Exception, IOException {
        Message in;
        if (inHeader != null) {
            in = inHeader.getMessage();
            // the message may be a dummy message, whose MSH segment is incomplete
            DeepCopy.copy(inHeader, (Segment) in.get("MSH"));
        } else {
            in = Version.highestAvailableVersionOrDefault().newGenericMessage(myParser.getFactory());
            ((GenericMessage) in).initQuickstart("ACK", "", "");
        }
        return in;
    }


}
