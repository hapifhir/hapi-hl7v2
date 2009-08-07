/*
 * Created on Jul 23, 2009
 */
package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Specialized version of ModelClassFactory that always returns the same version. This is useful when designing
 * applications which are expected to handle multiple versions of HL7. The recommended approach is to
 * configure this factory to handle the newest version of HL7 you intend to support. Since HL7 is a backwards
 * compatible protocol, older versions should always be able to parse correctly into a newer message structure.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2009-08-07 22:41:07 $ by $Author: jamesagnew $
 * @author This ModelClassFactory implementation is modified by Niranjan.Sharma@med.ge.com on 27-Jul-2009 for CanonicalModel of V2.6
 */
public class CanonicalModelClassFactory extends DefaultModelClassFactory
{

    private static final long serialVersionUID = -1795680089524220526L;
    
    private String myVersion;

    /**
     * Constructor which selects the newest version of HAPI known to 
     * 
     * @param theVersion The version to always return (e.g. "2.6")
     */
    public CanonicalModelClassFactory() {
        myVersion = getHighestKnownVersion();
    }

    /**
     * Constructor
     * 
     * @param theVersion The version to always return (e.g. "2.6")
     */
    public CanonicalModelClassFactory(String theVersion) {
        myVersion = theVersion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class getGroupClass(String theName, String theVersion) throws HL7Exception {
        return super.getGroupClass(theName, myVersion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class getMessageClass(String theName, String theVersion, boolean theIsExplicit) throws HL7Exception {
        return super.getMessageClass(theName, myVersion, theIsExplicit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class getSegmentClass(String theName, String theVersion) throws HL7Exception {
        return super.getSegmentClass(theName, myVersion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class getTypeClass(String theName, String theVersion) throws HL7Exception {
        return super.getTypeClass(theName, myVersion);
    }
    
}
