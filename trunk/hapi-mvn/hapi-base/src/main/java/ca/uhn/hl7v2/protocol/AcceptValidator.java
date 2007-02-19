/*
 * Created on 16-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

/**
 * <p>Determines whether messages are acceptable for storage.  See HL7 
 * v2.5 chapter 2 for relevant specifications.  In original-mode 
 * processing, validation at this level includes checking whether 
 * MSH-9, 11, and 12 have appropriate values.</p>  
 * 
 * <p>In enhanced mode, the above checks are optional.  Checking for 
 * syntactical correctness is also optional.  However storage availability 
 * and interface status must be checked.</p>   
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface AcceptValidator {

    /**
     * Returns a ruling regarding whether the given message can be accepted  
     * for further processing (ie determines CE, CR, or CA for enhanced mode, 
     * and AR for original mode).  
     *   
     * @param theMessage the message to check for acceptability.  
     * @return
     */
    public AcceptRuling check(Transportable theMessage);

    /**
     * Represents a decision regarding whether a message can be initially 
     * accepted for further processing.  As per HL7 specs, for original-mode
     * messages, a message should be accepted at this stage if the system thinks it can handle 
     * the message based on MSH-9, 11, and 12 values (assuming these can be parsed). 
     * 
     * In enhanced mode, the above checks are optional.  Also optional is a check for 
     * syntactical correctness.  Mandatory checks include availability of safe storage
     * and "interface status".  
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
     */
    public interface AcceptRuling {
        
        public static final String ACK_AR = "AR";
        public static final String ACK_CA = "CA";
        public static final String ACK_CE = "CE";
        public static final String ACK_CR = "CR";

        /**
         * @return true if the message can be accepted at the protocol stage.
         */
        public boolean isAcceptable();

        /**
         * @return the ACK code corresponding to the ruling, if any.  Ie "AR", 
         * "CE", "CR", or "CA".  If in original mode, null is returned for non-"AR" 
         * situations.  This is because only the application layer can tell whether the 
         * answer is "AE" or "AA". 
         */
        public String getAckCode();
        
        /**
         * @return an error code from among the static fields of HL7Exception 
         *      (if no error, HL7Exception.MESSAGE_ACCEPTED)
         */
        public int getErrorCode();

        /**
         * @return zero or more reasons for rejecting a message (suitable for inclusion
         * in a reply).  
         */
        public String[] getReasons();
    }

}
