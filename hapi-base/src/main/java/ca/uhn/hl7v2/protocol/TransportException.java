/*
 * Created on 15-Apr-2004
 */
package ca.uhn.hl7v2.protocol;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Represents a problem that has occured during transport of a 
 * message string to / from some other server.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public class TransportException extends HL7Exception {

    /**
     * @param message
     * @param cause
     */
    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public TransportException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     */
    public TransportException(String message) {
        super(message);
    }

}
