package ca.uhn.hl7v2.validation.app;

import org.apache.log4j.NDC;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

/**
 * An application intended for testing messages.  The intended use is to route a copy 
 * of (selected) messages to a test application, which identifies and acts on problems independently 
 * of the normal error acknowledgement path (for example by notifying an administrator).  
 * This makes the most sense when used within an interface engine, for example if the 
 * sending nor receiving system use HAPI, but it is desired to route messages to HAPI in 
 * parallel so that they can be fully validated.  
 * @author Bryan Tripp
 * @deprecated
 */
public abstract class TestApplication implements ca.uhn.hl7v2.app.Application {
       
    private PipeParser parser; 
    
    /** Creates a new instance of TestApplication */
    public TestApplication() {
        parser = new PipeParser();
    }
    
    /**
     * Returns true if this Application wishes to accept the message.  By returning
     * true, this Application declares itself the recipient of the message, accepts
     * responsibility for it, and must be able to respond appropriately to the sending system.
     */
    public abstract boolean canProcess(Message in); 

    
    /** 
     * <p>Calls test(Message in), routes resulting exceptions to configured destinations, and 
     * returns an ack (which should not normally be used since the test app is intended 
     * to operate in parallel with system-to-system communication).  </p>
     * <p>Notification routing is performed using log4j, so you need appropriate settings in a log4j 
     * config file (by default, ./log4j.properties).  Different types of exceptions 
     * are all given the same severity (ERROR) but they have different loggers, based 
     * on the exception class name.  Specifically, the loggers will be named 
     * ca.uhn.hl7v2.validation.error.{exception class name}.  For example: 
     * "ca.uhn.hl7v2.validation.error.DataTypeException".  Note that this allows default 
     * settings for all validation errors using the logger "ca.uhn.hl7v2.validation.error".  
     * The intent is for different exceptions to result in different actions, e.g. a 
     * ProfileNotHL7CompliantException should probably just be logged or ignored, while a
     * ProfileNotFollowedException should probably be emailed to an administrator. </p>
     */
    public Message processMessage(Message in) throws HL7Exception {
        String context = null;
        try {
            context = this.parser.encode(in);
        } catch (HL7Exception e) {
            context = "message not encodable";
        }
        //update logging context with message text
        NDC.push(context);
        
        LoggerFactory.getLogger("ca.uhn.hl7v2.validation.error").info("Testing message");
        
        HL7Exception[] problems = test(in);        
        sendNotifications(problems);
        
        NDC.pop();
        
        try {
        	Message ack = in.generateACK();
            addProblemsToACK(ack, problems);
            return ack;
        } catch (java.io.IOException e) {
            throw new HL7Exception(e);
        }
    }
    
    /**
     * <p>Send notification of problems to specified destinations (e.g. log file, email).  
     */
    private void sendNotifications(HL7Exception[] problems) {
        for (int i = 0; i < problems.length; i++) {
            String exName = problems[i].getClass().getName();
            String logName = "ca.uhn.hl7v2.validation.error" + exName.substring(exName.lastIndexOf('.'));
            LoggerFactory.getLogger(logName).error("message validation failure", problems[i]);
        }
    }
    
    private void addProblemsToACK(Message ack, HL7Exception[] problems) throws HL7Exception {
        Terser t = new Terser(ack);
        
        if (problems.length > 0) {
            t.set("MSA-1", "AE");        
            t.set("MSA-3", "Errors were encountered while testing the message");
        }
        /*
        Segment err = (Segment) ack.get("ERR");
        for (int i = 0; i < problems.length; i++) {
            // problems[i].populate(err); FIXME: broken! needs database
        }
        */
    }
    
    /**
     * Tests the message in some way (as defined by implementing class).  
     * @return exceptions that describe any identified problems with the message 
     * @throws HL7Exception if the message can't be tested (not for errors disovered
     *      during testing)
     */
    public abstract HL7Exception[] test(Message in) throws HL7Exception;
        
}
