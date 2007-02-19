/*
 * Created on 21-Apr-2005
 */
package ca.uhn.hl7v2.parser;

import java.io.Serializable;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Looks up classes for message model components (e.g. concrete implementations of 
 * Message, Group, Segment).  A custom factory can be used to point to custom model 
 * components. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:31 $ by $Author: jamesagnew $
 */
public interface ModelClassFactory extends Serializable {

    /**
     * @param theName name of message 
     * @param theVersion HL7 version 
     * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it 
     *      was inferred from MSH-9-1 and MSH-9-2.  If false, a lookup may be performed to find 
     *      an alternate structure corresponding to that message type and event.   
     * @return a class that implements the specified message
     * @throws HL7Exception if the version if not recognized or an appropriate class can not be found
     */
    public Class getMessageClass(String theName, String theVersion, boolean isExplicit) throws HL7Exception;
    
    /**
     * @param theName name of group 
     * @param theVersion HL7 version 
     * @return a class that implements the specified group
     * @throws HL7Exception if the version if not recognized or an appropriate class can not be found
     */
    public Class getGroupClass(String theName, String theVersion) throws HL7Exception;
    
    /**
     * @param theName name of segment 
     * @param theVersion HL7 version 
     * @return a class that implements the specified segment
     * @throws HL7Exception if the version if not recognized or an appropriate class can not be found
     */
    public Class getSegmentClass(String theName, String theVersion) throws HL7Exception;
    
    /**
     * @param theName name of type
     * @param theVersion HL7 version 
     * @return a class that implements the specified type
     * @throws HL7Exception if the version if not recognized or an appropriate class can not be found
     */
    public Class getTypeClass(String theName, String theVersion) throws HL7Exception;
    
}
