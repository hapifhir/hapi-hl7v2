/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Encapsulates both the client and server roles of the HL7-defined 
 * "original mode" and "enhanced mode" processing rules.  See 
 * HL7 v2.5 chapter 2 for specifications.    
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface Processor {
    
    /**
     * Always send acknowledgement (in MSH-15 and 16)
     */
    public static final String AL = "AL";
    
    /**
     * Never send acknowledgement (in MSH-15 and 16)
     */
    public static final String NE = "NE";

    /**
     * Send acknowledgement only on error / reject (in MSH-15 and 16)
     */
    public static final String ER = "ER";
    
    /**
     * Send acknowledgement only on successful receipt (in MSH-15 and 16)
     */
    public static final String SU = "SU";
        
    
    /**
     * Original mode: Application Accept - Enhanced mode: Application acknowledgment: Accept
     */
    public static final String AA = "AA"; 
    
    /**
     * Original mode: Application Error - Enhanced mode: Application acknowledgment: Error 
     */
    public static final String AE = "AE"; 
    /**
     * Original mode: Application Reject - Enhanced mode: Application acknowledgment: Reject
     */
    public static final String AR = "AR";
    
    /**
     * Enhanced mode: Accept acknowledgment: Commit Accept
     */
    public static final String CA = "CA"; 
    
    /**
     * Enhanced mode: Accept acknow ledgment: Commit Error
     */
    public static final String CE = "CE";
    
    /**
     * Enhanced mode: Accept acknowledgment: Commit Reject
     */
    public static final String CR = "CR";
    
    
    /**
     * Sends a message to a remote system via an underlying 
     * <code>TransportLayer</code>.  
     * 
     * If the message specifies that an accept ACK is required (under enhanced mode 
     * processing rules) then this method may retry if transmission does not appear 
     * to be successful.  The call to this method blocks while this is happening.  
     * Retries are attempted if a CR message is received, or if no message is received
     * in the specified time frame.  If a CE is received, an exception is thrown.  If 
     * a CA is received, the call returns quietly.  
     * 
     * If no accept ack is required, this method returns immediately after attempting to 
     * send a message, throwing an exception only if there is an immediate problem (eg the
     * server can't be contacted).  
     * 
     * If an accept ack is required only on error, the method waits for maxRetries * 
     * retryItervalMillis for an error to be returned, and assumes that there is no error
     * if none appears in that time.  The message is not actually resent while waiting for an 
     * error ACK. 
     * 
     * @param theMessage the message to send 
     * @param maxRetries note that this should be a small value if you demand an accept ack only
     *      on error
     * @param retryIntervalMillis note that this should be a small value if you demand an accept ack only
     *      on error
     * @throws TransportException if there is an immediate problem trying to send the 
     *      message.  
     */
    public void send(Transportable theMessage, int maxRetries, long retryIntervalMillis) throws HL7Exception;
    
    /**
     * Indicates that the calling thread expects a message with a certain ack
     * ID.  If this message arrives within the specified period of time, it will 
     * be held in an inbound list instead of being passed on to an 
     * <code>Application</code>.  If a message is in this list it <code>isAvailable()</code>
     * and can be had via <code>receive()</code>
     * 
     * @param theAckId the acknowledgement ID of the message 
     * @param thePeriodMillis time span during which the message should be kept if received
     */
    public void reserve(String theAckId, long thePeriodMillis);
    
    /**
     * <p>Performs a single iteration of the receiving-side 
     * of the HL7 original mode or enhanced mode processing rules
     * (see HL7 Standard v2.5 Chapter 2; the choice of rules
     * is determined by message values).  Steps in the process are 
     * as follows: </p>
     * 
     * 1. TransportLayer.receive() is called to get the next message <br> 
     * 2. Validation is performed and the message is stored locally. <br>
     * 2. If the message requires an accept ACK, then an accept, reject, 
     *   or error message is returned as appropriate  <br>
     * 3. If the message is an accept ack, it is added to a local list that 
     * can be accessed by the send() method <br>
     * 4. If the message has been reserved, it is added to the available message
     * list.  <br>
     * 5. Otherwise it is sent to an Application.   
     * 
     * @param expectingAck is passed to TransportLayer.receive(), and may determine 
     *      where the message is read from (eg different sockets may be used for 
     *      commit-level ACKs).  Note that this call blocks until a message is ready
     *      at the specified location, so to run the Processor continuously,  
     *      separate threads are needed to call cycle() with true and false args.   
     */
    public void cycle(boolean expectingAck) throws HL7Exception; 
        
    /**
     * @param theAckId the acknowledgement ID of an expected message 
     * @return true if the message has come in and has been saved in the 
     *      inbound message list 
     */
    public boolean isAvailable(String theAckId);
    
    /**
     * Gets the message with the given acknowledgement ID from 
     * the incoming message list.  This method blocks until the 
     * message appears on the list.  If you don't want to block, 
     * call <code>isAvailable()</code> to see if it is there.
     * 
     * Note also that the message has no way of arriving on the list 
     * during this call unless the <code>Processor</code> is running 
     * as a thread, or unless some other thread is calling cycle().   
     *      
     * @param theAckId
     * @param theTimeoutMillis milliseconds until the call times out
     *      and returns null if the desired message is not available. 
     * @return the incoming message with the given ack ID, or null 
     *      if the call times out. 
     */
    public Transportable receive(String theAckId, long theTimeoutMillis) throws HL7Exception;
    
    /**
     * @return the operational context of this protocol instance 
     */
    public ProcessorContext getContext();

    /**
     * Request that the processor stop running and clean up any resources and worker threads it has started
     */
    public void stop();

    
}
