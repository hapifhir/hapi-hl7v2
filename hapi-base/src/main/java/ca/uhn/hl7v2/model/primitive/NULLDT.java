/*
 * Created on Mar 25, 2009
 */
package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.Message;

/**
 * Base class for "NULL" datatype. This is a special case datatype, used in fields which have been withdrawn and are
 * expected to be empty.
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.com">James Agnew</a>
 * @version $Revision: 1.1 $ updated on $Date: 2009-03-26 00:39:49 $ by $Author: jamesagnew $
 */
public class NULLDT extends AbstractPrimitive
{

    /**
     * Constructor
     * 
     * @param theMessage The message
     */
    public NULLDT(Message theMessage) {
        super(theMessage);
    }

    private static final long serialVersionUID = -2676962788248439865L;

}
