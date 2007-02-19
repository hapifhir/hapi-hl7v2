/*
 * Created on 6-Jun-2005
 */
package ca.uhn.hl7v2.model.v21.datatype;

import ca.uhn.hl7v2.model.GenericComposite;
import ca.uhn.hl7v2.model.Message;

/**
 * Version 2.1 contains a number of unspecified CM datatypes, which we model as 
 * GenericComposites.  The type of each CM component can be set as needed, after 
 * parsing a message.  
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:37 $ by $Author: jamesagnew $
 */
public class CM extends GenericComposite {

    /**
     * @param message message to which this Type belongs
     */
    public CM(Message message) {
        super(message);
    }

    /** Returns the name of the type (used in XML encoding and profile checking)  */
    public String getName() {
        return "CM";
    }

}
