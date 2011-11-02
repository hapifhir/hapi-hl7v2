/*
 * Created on 21-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.app.Responder;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>A default implementation of <code>ApplicationRouter</code> </p>  
 * 
 * <p>Note that ParseChecker is used for each inbound message, iff the system
 * property ca.uhn.hl7v2.protocol.impl.check_parse = "TRUE".  </p>
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-01 00:22:23 $ by $Author: jamesagnew $
 */
public class ApplicationRouterImpl implements ApplicationRouter {

    private static final HapiLog log = HapiLogFactory.getHapiLog(ApplicationRouterImpl.class);
    
    /**
     * Key under which raw message text is stored in metadata Map sent to 
     * <code>ReceivingApplication</code>s. 
     */
    public static String RAW_MESSAGE_KEY = "raw-message"; 

    private List<Binding> myBindings;
    private Parser myParser;
    

    /**
     * Creates an instance that uses a <code>GenericParser</code>. 
     */
    public ApplicationRouterImpl() {
        init(new GenericParser());
    }
    
    /**
     * Creates an instance that uses the specified <code>Parser</code>. 
     * @param theParser the parser used for converting between Message and 
     *      Transportable
     */
    public ApplicationRouterImpl(Parser theParser) {
        init(theParser);
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
            response.getMetadata().put("MSH-18", result[1]);
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
        HapiLog rawOutbound = HapiLogFactory.getHapiLog("ca.uhn.hl7v2.raw.outbound");
        HapiLog rawInbound = HapiLogFactory.getHapiLog("ca.uhn.hl7v2.raw.inbound");
        
        log.info( "ApplicationRouterImpl got message: " + incomingMessageString );
        rawInbound.info(incomingMessageString);
        
        Message incomingMessageObject = null;
        String outgoingMessageString = null;
        String outgoingMessageCharset = null;
        try {
            incomingMessageObject = myParser.parse(incomingMessageString);
        }
        catch (HL7Exception e) {
            outgoingMessageString = Responder.logAndMakeErrorMessage(e, myParser.getCriticalResponseData(incomingMessageString), myParser, myParser.getEncoding(incomingMessageString));
        }
        
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
                
                if (log.isDebugEnabled()) {
                	log.debug("Sending message to application: " + app.toString());
                }
                Message response = app.processMessage(incomingMessageObject, theMetadata);
                
                //Here we explicitly use the same encoding as that of the inbound message - this is important with GenericParser, which might use a different encoding by default
                outgoingMessageString = myParser.encode(response, myParser.getEncoding(incomingMessageString));
                
                Terser t = new Terser(response);
                outgoingMessageCharset = t.get("MSH-18"); 
            }
            catch (Exception e) {
                outgoingMessageString = Responder.logAndMakeErrorMessage(e, (Segment) incomingMessageObject.get("MSH"), myParser, myParser.getEncoding(incomingMessageString));
            }
        }
        
        log.info( "ApplicationRouterImpl sending message: " + outgoingMessageString );
        rawOutbound.info(outgoingMessageString);
        
        return new String[] {outgoingMessageString, outgoingMessageCharset};
    }
    

    /**
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#hasActiveBinding(ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData)
     */
    public boolean hasActiveBinding(AppRoutingData theRoutingData) {
        boolean result = false;
        ReceivingApplication app = findDestination(theRoutingData);
        if (app != null) {
            result = true;
        }
        return result;
    }
    
    /**
     * @param theRoutingData
     * @return the application from the binding with a WILDCARD match, if one exists
     */
    private ReceivingApplication findDestination(AppRoutingData theRoutingData) {
        ReceivingApplication result = null;
        for (int i = 0; i < myBindings.size() && result == null; i++) {
            Binding binding = (Binding) myBindings.get(i);
            if (matches(theRoutingData, binding.routingData) && binding.active) {
                result = binding.application;
            }
        }
        return result;        
    }
    
    /**
     * @param theRoutingData
     * @return the binding with an EXACT match on routing data if one exists 
     */
    private Binding findBinding(AppRoutingData theRoutingData) {
        Binding result = null;
        for (int i = 0; i < myBindings.size() && result == null; i++) {
            Binding binding = (Binding) myBindings.get(i);
            if ( theRoutingData.equals(binding.routingData) ) {
                result = binding;
            }
        }
        return result;        
        
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.ApplicationRouter#bindApplication(
     *      ca.uhn.hl7v2.protocol.ApplicationRouter.AppRoutingData, ca.uhn.hl7v2.protocol.ReceivingApplication)
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
     * @param theMessageData routing data related to a particular message
     * @param theReferenceData routing data related to a binding, which may include 
     *      wildcards 
     * @param exact if true, each field must match exactly
     * @return true if the message data is consist with the reference data, ie all 
     *      values either match or are wildcards in the reference
     */
    public static boolean matches(AppRoutingData theMessageData, 
                AppRoutingData theReferenceData) {
                    
        boolean result = false;
        
        ApplicationRouter.AppRoutingData ref = theReferenceData;
        ApplicationRouter.AppRoutingData msg = theMessageData;
        
        if (matches(msg.getMessageType(), ref.getMessageType()) 
            && matches(msg.getTriggerEvent(), ref.getTriggerEvent()) 
            && matches(msg.getProcessingId(), ref.getProcessingId()) 
            && matches(msg.getVersion(), ref.getVersion())) {
        
            result = true;
        }
        
        return result;        
    }

    //support method for matches(AppRoutingData theMessageData, AppRoutingData theReferenceData)
    private static boolean matches(String theMessageData, String theReferenceData) {
        boolean result = false;
        if (theMessageData.equals(theReferenceData) || 
                theReferenceData.equals("*") || 
                Pattern.matches(theReferenceData, theMessageData)) {
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
            
        ReceivingApplication app = findDestination(msgData);
        
        //have to send back an application reject if no apps available to process
        if (app == null)
            app = new AppWrapper(new DefaultApplication());
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
    
}
