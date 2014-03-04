/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ProcessorImpl.java".  Description: 
"A default implementation of Processor." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.protocol.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.preparser.PreParser;
import ca.uhn.hl7v2.protocol.Processor;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * A default implementation of <code>Processor</code>.  
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.4 $ updated on $Date: 2009-12-16 19:36:34 $ by $Author: jamesagnew $
 */
public class ProcessorImpl implements Processor {

    private static final Logger log = LoggerFactory.getLogger(ProcessorImpl.class);

    private ProcessorContext myContext;
    private final Map<String, ExpiringTransportable> myAcceptAcks;
    private final Map<String, Long> myReservations;
    private final Map<String, ExpiringTransportable> myAvailableMessages;
    private boolean myThreaded; //true if separate threads are calling cycle()  
    private Cycler ackCycler;
    private Cycler nonAckCycler;
    private ExecutorService myResponseExecutorService;
    
    /**
     * @param theContext source of supporting services 
     * @param isThreaded true if this class should create threads in which to call cycle(), and 
     *  in which to send responses from Applications.  This is the preferred mode.  Use false 
     *  if threading is not allowed, eg you are running the code in an EJB container.  In this case, 
     *  the send() and receive() methods will call cycle() themselves as needed.  However, cycle() 
     *  makes potentially blocking calls, so these methods may not return until the next message 
     *  is received from the remote server, regardless of timeout.  Probably the worst example of this
     *  would be if receive() was called to wait for an application ACK that was specified as "RE" (ie
     *  required on error).  No response will be returned if the message is processed without error, 
     *  and in a non-threaded environment, receive() will block forever.  Use true if you can, otherwise
     *  study this class carefully.
     *   
     * TODO: write a MLLPTransport with non-blocking IO  
     * TODO: reconnect transport layers on error and retry 
     */
    public ProcessorImpl(ProcessorContext theContext, boolean isThreaded) {
        myContext = theContext;
        myThreaded = isThreaded;
        myAcceptAcks = new HashMap<String, ExpiringTransportable>();
        myReservations = new HashMap<String, Long>();
        myAvailableMessages = new HashMap<String, ExpiringTransportable>();
        
        if (isThreaded) {
            myResponseExecutorService = Executors.newSingleThreadExecutor(); 

            TransportLayer local = theContext.getLocallyDrivenTransportLayer();
            TransportLayer remote = theContext.getRemotelyDrivenTransportLayer();
            
        	ackCycler = new Cycler(this, true);
            Thread ackThd = new Thread(ackCycler);
            ackThd.start();
            
            if (local != remote) {
	            nonAckCycler = new Cycler(this, false);
	            Thread nonAckThd = new Thread(nonAckCycler);
	            nonAckThd.start();
            }
            
        }
    }
    
    /**
     * If self-threaded, stops threads that have been created.  
     */
    public void stop() {
        if (myThreaded) {
            ackCycler.stop();
            if (nonAckCycler != null) {
            	nonAckCycler.stop();
            }
            
            myResponseExecutorService.shutdownNow();
        }
    }

    /**
     * @see ca.uhn.hl7v2.protocol.Processor#send(ca.uhn.hl7v2.protocol.Transportable, int, long)
     */
    public void send(Transportable theMessage, int maxRetries, long retryIntervalMillis) throws HL7Exception {
        String[] fieldPaths = {"MSH-10", "MSH-15", "MSH-16"};
        String[] fields = PreParser.getFields(theMessage.getMessage(), fieldPaths);
        String controlId = fields[0];
        String needAcceptAck = fields[1];
        String needAppAck = fields[2];
        
        checkValidAckNeededCode(needAcceptAck);
        
        trySend(myContext.getLocallyDrivenTransportLayer(), theMessage);
        
        boolean originalMode = (needAcceptAck == null && needAppAck == null); 
        if (originalMode || !NE.equals(needAcceptAck)) {
        
            Transportable response = null;
            int retries = 0;
            do {
                long until = System.currentTimeMillis() + retryIntervalMillis;
                while (response == null && System.currentTimeMillis() < until) {
                    synchronized (this) {
                        ExpiringTransportable et = myAcceptAcks.remove(controlId);
                        if (et == null) {
                            cycleIfNeeded(true);
                        } else {
                            response = et.transportable;
                        }
                    }
                    sleepIfNeeded();
                }
                
                if ((response == null && needAcceptAck != null && needAcceptAck.equals(AL))
                        || (response != null && isReject(response))) {
                    log.info("Resending message {}", controlId);
                    trySend(myContext.getLocallyDrivenTransportLayer(), theMessage);
                    response = null;                    
                }
                
                if (response != null && isError(response)) {
                    String[] errMsgPath = {"MSA-3"};
                    String[] errMsg = PreParser.getFields(response.getMessage(), errMsgPath);                    
                    throw new HL7Exception("Error message received: " + errMsg[0]);
                }
                
            } while (response == null && ++retries <= maxRetries);
        }
    }
    
    private void checkValidAckNeededCode(String theCode) throws HL7Exception {
        //must be one of the below ... 
        if ( !(theCode == null || theCode.equals("") 
                ||theCode.equals(AL) || theCode.equals(ER) 
                || theCode.equals(NE) || theCode.equals(SU)) ) {
            throw new HL7Exception("MSH-15 must be AL, ER, NE, or SU in the outgoing message");
        }            
    }
    
    /**
     * Calls cycle() if we do not expect another thread to be doing so
     * @param expectingAck as in cycle
     */
    private void cycleIfNeeded(boolean expectingAck) throws HL7Exception {
        if (!myThreaded) {
            cycle(expectingAck);
        }        
    }
    
    /**
     * Sleeps for 1 ms if externally threaded (this is to let the CPU idle).   
     */
    private void sleepIfNeeded() {
        if (myThreaded) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) { /* no problem */ }
        }                
    }
    
    /** Returns true if a CR or AR ACK */ 
    private static boolean isReject(Transportable theMessage) throws HL7Exception {
        boolean reject = false;
        String[] fieldPaths = {"MSA-1"};
        String[] fields = PreParser.getFields(theMessage.getMessage(), fieldPaths);
        if (fields[0] != null && (fields[0].equals(CR) || fields[0].equals(AR))) {
            reject = true;
        }        
        return reject;
    }

    /** Returns true if a CE or AE ACK */ 
    private static boolean isError(Transportable theMessage) throws HL7Exception {
        boolean error = false;
        String[] fieldPaths = {"MSA-1"};
        String[] fields = PreParser.getFields(theMessage.getMessage(), fieldPaths);
        if (fields[0] != null && (fields[0].equals(CE) || fields[0].equals(AE))) {
            error = true;
        }
        return error;
    }

    /**
     * @see ca.uhn.hl7v2.protocol.Processor#reserve(java.lang.String, long)
     */
    public synchronized void reserve(String theAckId, long thePeriodMillis) {
        Long expiry = new Long(System.currentTimeMillis() + thePeriodMillis);
        myReservations.put(theAckId, expiry);
    }
    
    /**
     * Tries to send the message, and if there is an error reconnects and tries again. 
     */
    private void trySend(TransportLayer theTransport, Transportable theTransportable) throws TransportException {
        try {
            theTransport.send(theTransportable);
        } catch (TransportException e) {
            theTransport.disconnect();
            theTransport.connect();
            theTransport.send(theTransportable);
        }
    }
    
    
    /**
     * Tries to receive a message, and if there is an error reconnects and tries again. 
     */
    private Transportable tryReceive(TransportLayer theTransport) throws TransportException {
        Transportable message = null;
        try {
            message = theTransport.receive();            
        } catch (TransportException e) {
            theTransport.disconnect();
            theTransport.connect();
            message = theTransport.receive();
        }
        return message;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Processor#cycle(boolean)
     */
    public void cycle(boolean expectingAck) throws HL7Exception {
        log.debug("In cycle({})", expectingAck);
    	
    	cleanReservations();
        cleanAcceptAcks();
        cleanReservedMessages();

        Transportable in = null;
        try {
            if (expectingAck) {
                in = tryReceive(myContext.getLocallyDrivenTransportLayer());
            } else {
                in = tryReceive(myContext.getRemotelyDrivenTransportLayer());
            }
        } catch (TransportException e) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {}
            throw e;
        }
        
        // log
        if (in != null) {
               log.debug("Received message: {}", in.getMessage());
        } else {
        	log.debug("Received no message");
        }
        
        // If we have a message, handle it
        if (in != null) { 
            String acceptAckNeeded = null;
//            String appAckNeeded = null;
            String ackCode = null;
            String ackId = null;
            
            try {
	            String[] fieldPaths = {"MSH-15", "MSH-16", "MSA-1", "MSA-2"};
	            String[] fields = PreParser.getFields(in.getMessage(), fieldPaths);         
				acceptAckNeeded = fields[0];
//				appAckNeeded = fields[1];
				ackCode = fields[2];
				ackId = fields[3];
            } catch (HL7Exception e) {
            	log.warn("Failed to parse accept ack fields in incoming message", e);
            }
            
            if (ackId != null && ackCode != null && ackCode.startsWith("C")) {
                long expiryTime = System.currentTimeMillis() + 1000 * 60;
                myAcceptAcks.put(ackId, new ExpiringTransportable(in, expiryTime));
            } else {
                AcceptAcknowledger.AcceptACK ack = AcceptAcknowledger.validate(getContext(), in);
            
                if ((acceptAckNeeded != null && acceptAckNeeded.equals(AL)) 
                    || (acceptAckNeeded != null && acceptAckNeeded.equals(ER) && !ack.isAcceptable()) 
                    || (acceptAckNeeded != null && acceptAckNeeded.equals(SU) && ack.isAcceptable())) {
                    trySend(myContext.getRemotelyDrivenTransportLayer(), ack.getMessage());    
                }
  
                if (ack.isAcceptable()) {
                    if (isReserved(ackId)) {
                    	
                    	log.debug("Received expected ACK message with ACK ID: {}", ackId);
                    	
                        removeReservation(ackId);
                        long expiryTime = System.currentTimeMillis() + 1000 * 60 * 5;                
                        myAvailableMessages.put(ackId, new ExpiringTransportable(in, expiryTime));
                        
                    } else {

                    	log.debug("Sending message to router");
                        Transportable out = myContext.getRouter().processMessage(in);
                        sendAppResponse(out);
                        
                    }
                } else {
                	// TODO: should we do something more here? Might be nice to 
                	// allow a configurable handler for this situation
                	log.warn("Incoming message was not acceptable");
                }
                
            }
        } else {
            String transport = expectingAck ? " Locally driven " : "Remotely driven";
            log.debug("{} TransportLayer.receive() returned null.", transport);
        }
        
        sleepIfNeeded();

        log.debug("Exiting cycle()");
    }
    
    /** Sends in a new thread if isThreaded, otherwise in current thread */
    private void sendAppResponse(final Transportable theResponse) {
        final ProcessorImpl processor = this;
        Runnable sender = new Runnable() {
            public void run() {
                try {
                	log.debug("Sending response: {}", theResponse);
                	
                    //TODO: make configurable 
                	processor.send(theResponse, 2, 3000);
                	
                } catch (HL7Exception e) {
                    log.error("Error trying to send response from Application", e);
                }
            }
        };
        
        if (myThreaded) {
            myResponseExecutorService.execute(sender);
        } else {
            sender.run();
        }
    }
    
    /**
     * Removes expired message reservations from the reservation list.  
     */
    private synchronized void cleanReservations() {
        Iterator<String> it = myReservations.keySet().iterator();
        while (it.hasNext()) {
            String ackId = it.next();
            Long expiry = myReservations.get(ackId);
            if (System.currentTimeMillis() > expiry.longValue()) {
                it.remove();
            }
        }
    }
    
    /**
     * Discards expired accept acknowledgements (these are used in retry protocol; see send()).   
     */
    private synchronized void cleanAcceptAcks() {
        Iterator<String> it = myAcceptAcks.keySet().iterator();
        while (it.hasNext()) {
            String ackId = it.next();
            ExpiringTransportable et = myAcceptAcks.get(ackId);
            if (System.currentTimeMillis() > et.expiryTime) {
                it.remove();
            }
        }        
    }
    
    private synchronized void cleanReservedMessages() throws HL7Exception {
        Iterator<String> it = myAvailableMessages.keySet().iterator();
        while (it.hasNext()) {
            String ackId = it.next();            
            ExpiringTransportable et = myAvailableMessages.get(ackId);
            if (System.currentTimeMillis() > et.expiryTime) {
                it.remove();
                
                //send to an Application 
                Transportable out = myContext.getRouter().processMessage(et.transportable);
                sendAppResponse(out);                
            }
        }  
    }
    
    private synchronized boolean isReserved(String ackId) {
        boolean reserved = false;
        if (myReservations.containsKey(ackId)) {
            reserved = true;
        }
        return reserved;
    }
    
    private synchronized void removeReservation(String ackId) {
        myReservations.remove(ackId);
    }
    

    /**
     * @see ca.uhn.hl7v2.protocol.Processor#isAvailable(java.lang.String)
     */
    public boolean isAvailable(String theAckId) {
        boolean available = false;
        if (myAvailableMessages.containsKey(theAckId)) {
            available = true;
        }
        return available;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Processor#receive(java.lang.String, long)
     */
    public Transportable receive(String theAckId, long theTimeoutMillis) throws HL7Exception {
        if (!isReserved(theAckId)) {
            reserve(theAckId, theTimeoutMillis);
        }
        
        Transportable in = null;
        long until = System.currentTimeMillis() + theTimeoutMillis;
        do {
            synchronized (this) {
                ExpiringTransportable et = myAvailableMessages.get(theAckId);                
                if (et == null) {
                    cycleIfNeeded(false);
                } else {
                    in = et.transportable;
                }
            }
            sleepIfNeeded();
        } while (in == null && System.currentTimeMillis() < until);
        return in;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.Processor#getContext()
     */
    public ProcessorContext getContext() {
        return myContext;
    }
    
    /**
     * A struct for Transportable collection entries that time out.  
     *  
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.4 $ updated on $Date: 2009-12-16 19:36:34 $ by $Author: jamesagnew $
     */
    class ExpiringTransportable {
        public Transportable transportable;
        public long expiryTime;
        
        public ExpiringTransportable(Transportable theTransportable, long theExpiryTime) {
            transportable = theTransportable;
            expiryTime = theExpiryTime;
        }
    }
    
    /**
     * A Runnable that repeatedly calls the cycle() method of this class.  
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.4 $ updated on $Date: 2009-12-16 19:36:34 $ by $Author: jamesagnew $
     */
    private static class Cycler implements Runnable {

        private Processor myProcessor;
        private boolean myExpectingAck;
        private boolean isRunning;
        
        /**
         * @param theProcessor the processor on which to call cycle()
         * @param isExpectingAck passed to cycle()
         */
        public Cycler(Processor theProcessor, boolean isExpectingAck) {
            myProcessor = theProcessor;
            myExpectingAck = isExpectingAck;
            isRunning = true;
        }
        
        /**
         * Execution will stop at the end of the next cycle.  
         */
        public void stop() {
            isRunning = false;
        }
        
        /** 
         * Calls cycle() repeatedly on the Processor given in the 
         * constructor, until stop() is called.  
         * 
         * @see java.lang.Runnable#run()
         */
        public void run() {
            while (isRunning) {
                try {
                    myProcessor.cycle(myExpectingAck);
                } catch (HL7Exception e) {
                    log.error("Error processing message", e);
                }
            }
        }        
    }

}
