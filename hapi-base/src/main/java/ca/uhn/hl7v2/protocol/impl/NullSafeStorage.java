/*
 * Created on 19-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * A non-functional implementation of <code>SafeStorage</code>.  This is 
 * intended as a placeholder pending release of UHN's Simple Record Store
 * project.   
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class NullSafeStorage implements SafeStorage {

    /** 
     * Does nothing. 
     */
    public void store(Transportable theMessage) throws HL7Exception {
    }

    /** 
     * Does nothing. 
     */
    public void discard(Transportable theMessage) throws HL7Exception {
     }

    /** 
     * Returns an empty array. 
     */
    public Transportable[] restore() throws HL7Exception {
        return new Transportable[0];
    }

}
