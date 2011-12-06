/*
 * Created on 3-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.Initiator;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.util.Terser;

/**
 * Default implementation of <code>Initiator</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class InitiatorImpl implements Initiator {

    private final List<String> myMetadataFields;
    private final Parser myParser;
    private final Processor myProcessor;
    private int myMaxRetries;
    private long myRetryInterval;
    private long myReceiveTimeout;
    
    /**
     * Creates an instance that uses a <code>GenericParser</code>
     * @param theProcessor the <code>Processor</code> used to communicate 
     *  with the remote system
     */
    public InitiatorImpl(Processor theProcessor) {
        myMetadataFields = new ArrayList<String>(20);
        myMetadataFields.add("MSH-18"); //add character set by default
        myParser = new GenericParser();
        myProcessor = theProcessor;
        init();
    }
    
    /**
     * Creates an instance that uses the given <code>Parser</code>
     * @param theParser parser to use for parsing and encoding messages
     * @param theProcessor the <code>Processor</code> used to communicate 
     *  with the remote system
     */
    public InitiatorImpl(Parser theParser, Processor theProcessor) {
        myMetadataFields = new ArrayList<String>(20);
        myParser = theParser;
        myProcessor = theProcessor;
        init();
    }
    
    private void init() {
        myMaxRetries = 3;
        myRetryInterval = 3000;
        myReceiveTimeout = 10000;
    }
    
    
    /**
     * @param theMaxRetries max number of retries for initial message delivery 
     */
    public void setMaxRetries(int theMaxRetries) {
        myMaxRetries = theMaxRetries;
    }
    
    public int getMaxRetries() {
        return myMaxRetries;
    }
    
    /**
     * @param theRetryIntervalMillis milliseconds between retries of message delivery 
     */
    public void setRetryInterval(long theRetryIntervalMillis) {
        myRetryInterval = theRetryIntervalMillis;
    }
    
    public long getRetryInterval() {
        return myRetryInterval;
    }
    
    /**
     * @param theReceiveTimeout the length of time we wait for responses (defaults 
     *      to 10 seconds)
     */
    public void setReceiveTimeout(long theReceiveTimeout) {
        myReceiveTimeout = theReceiveTimeout;
    }
    
    public long getReceiveTimeout() {
        return myReceiveTimeout;
    }
    
    /**
     * @see ca.uhn.hl7v2.protocol.Initiator#sendAndReceive(ca.uhn.hl7v2.model.Message)
     */
    public Message sendAndReceive(Message theMessage) throws HL7Exception {
        Terser t = new Terser(theMessage);
        String appAckNeeded = t.get("/MSH-16");
        String msgId = t.get("/MSH-10");
        
        String messageText = getParser().encode(theMessage);
        Map<String, Object> metadata = getMetadata(theMessage);
        Transportable out = new TransportableImpl(messageText, metadata);
        
        if (needAck(appAckNeeded)) {
            myProcessor.reserve(msgId, getReceiveTimeout());
        }
        
        myProcessor.send(out, getMaxRetries(), getRetryInterval());
        
        Message in = null;
        if (needAck(appAckNeeded)) { 
            Transportable received = myProcessor.receive(msgId, getReceiveTimeout());
            if (received != null && received.getMessage() != null) {
                in = getParser().parse(received.getMessage());
            }
        }
        
        return in;
    }
    
    /**
     * @param theAckCode from MSH-16
     * @return true if the code indicates that we should wait for an ACK and try 
     *      to return it to the caller 
     */
    private boolean needAck(String theAckCode) {
        boolean need = false;
        if (theAckCode == null 
            || theAckCode.equals("") 
            || theAckCode.equals(Processor.AL) 
            || theAckCode.equals(Processor.ER)) 
        {
            need = true; 
        }        
        return need;
    }
    
    private Map<String, Object> getMetadata(Message theMessage) throws HL7Exception {
        Map<String, Object> md = new HashMap<String, Object>();
        Terser t = new Terser(theMessage);

        //snapshot so concurrent changes won't break our iteration
        String[] fields = getMetadataFields().toArray(new String[0]);
        
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i].toString();
            String val = t.get(field); 
            md.put(field, val);
        }
        
        return md;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Initiator#getParser()
     */
    public Parser getParser() {
        return myParser;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Initiator#getUnderlyingProcessor()
     */
    public Processor getUnderlyingProcessor() {
        return myProcessor;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.Initiator#getMetadataFields()
     */
    public List<String> getMetadataFields() {
        return myMetadataFields;
    }


}
