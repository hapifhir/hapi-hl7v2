/*
 * Created on Mar 25, 2009
 */
package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.Message;

/**
 * Special datatype used in fields which have been withdrawn from the HL7
 * specification and should not contain a value.
 * 
 * @author <a href="mailto:james.agnew@uhn.on.ca">James Agnew</a>
 * @version $Revision: 1.1 $ updated on $Date: 2009-03-26 00:39:49 $ by $Author: jamesagnew $
 */
public class NULLDT extends ca.uhn.hl7v2.model.primitive.NULLDT
{

    private static final long serialVersionUID = 1368888406738419721L;

    /**
     * Constructor
     * 
     * @param theMessage The message
     */
    public NULLDT(Message theMessage) {
        super(theMessage);
    }

}
