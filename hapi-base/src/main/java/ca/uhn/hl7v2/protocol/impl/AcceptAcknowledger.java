/*
 * Created on 10-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.AcceptValidator;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.util.DeepCopy;

/**
 * Checks whether messages can be accepted and creates appropriate
 * ACK messages.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class AcceptAcknowledger {

    private static final Logger log = LoggerFactory.getLogger(AcceptAcknowledger.class);
    
    private static Parser ourParser = new GenericParser();
    
    /** 
     * Validates the given message against our accept validators, attempts to commit
     * the message to safe storage, and returns an ACK message indicating acceptance 
     * or rejection at the accept level (see enhanced mode processing rules in HL7 
     * chapter 2, v2.5).  
     */
    public static AcceptACK validate(ProcessorContext theContext, Transportable theMessage) throws HL7Exception {
        AcceptACK ruling = null;
        
        AcceptValidator[] validators = theContext.getValidators();
        for (int i = 0; i < validators.length && ruling == null; i++) {
            AcceptValidator.AcceptRuling vr = validators[i].check(theMessage);            
            if (!vr.isAcceptable()) {
                String description = (vr.getReasons().length > 0) ? vr.getReasons()[0] : null;
                Transportable ack = makeAcceptAck(theMessage, vr.getAckCode(), ErrorCode.errorCodeFor(vr.getErrorCode()), description);
                ruling = new AcceptACK(false, ack);
            }
        }
        
        if (ruling == null) {
            try {
                theContext.getSafeStorage().store(theMessage);
                Transportable ack = makeAcceptAck(theMessage, Processor.CA, ErrorCode.MESSAGE_ACCEPTED, "");
                ruling = new AcceptACK(true, ack);
            } catch (HL7Exception e) {
                log.error(e.getMessage(), e);
                Transportable ack = makeAcceptAck(theMessage, Processor.CR, ErrorCode.APPLICATION_INTERNAL_ERROR, e.getMessage());
                ruling = new AcceptACK(false, ack);
            }
        }        
        
        return ruling;
    }


    private static Transportable makeAcceptAck(Transportable theMessage, String theAckCode, ErrorCode theErrorCode, String theDescription) throws HL7Exception {        
        Segment header = ourParser.getCriticalResponseData(theMessage.getMessage());
        Message dummy = header.getMessage();
        // MSH header refers to dummy, but not the other way round!
        DeepCopy.copy(header, (Segment)dummy.get("MSH"));

        try {
            HL7Exception hl7e = new HL7Exception(theDescription, theErrorCode);
            AcknowledgmentCode code = theAckCode == null ?
            		AcknowledgmentCode.CR :
            		AcknowledgmentCode.valueOf(theAckCode);
        	Message out = dummy.generateACK(code, hl7e);
            String originalEncoding = ourParser.getEncoding(theMessage.getMessage());
            String ackText = ourParser.encode(out, originalEncoding);
            return new TransportableImpl(ackText);
        } catch (IOException e) {
            throw new HL7Exception(e);
        }
        
    }    
    
    
    /**
     * A structure for decisions as to whether a message can be accepted, 
     * along with a corresponding accept or reject acknowlegement message. 
     *  
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
     */
    public static class AcceptACK {
        private Transportable myAck;
        private boolean myIsAcceptable;
        
        public AcceptACK(boolean isAcceptable, Transportable theAck) {
            myIsAcceptable = isAcceptable;
            myAck = theAck;
        }
        
        public boolean isAcceptable() {
            return myIsAcceptable;
        }
        
        public Transportable getMessage() {
            return myAck;
        }
    }

}
