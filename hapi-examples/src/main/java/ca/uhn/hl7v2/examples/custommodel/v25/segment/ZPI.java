/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uhn.hl7v2.examples.custommodel.v25.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v25.datatype.NM;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * ZPI custom segment example
 *
 * Note that custom segments extend from {@link AbstractSegment}
 */
public class ZPI extends AbstractSegment {

    /**
     * Adding a serial UID is always a good idea, but optional
     */
    private static final long serialVersionUID = 1;

    public ZPI(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        init(factory);
     }

     private void init(ModelClassFactory factory) {
        try {
        	add(ST.class, true, 0, 100, new Object[]{ getMessage() }, "Pet Name(s)");
        	add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Shoe Size");
        } catch (HL7Exception e) {
            log.error("Unexpected error creating ZPI - this is probably a bug in the source code generator.", e);
        }
     }

    /**
     * This method must be overridden. The easiest way is just to return null.
     */
    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        return null;
    }

    /**
     * Create an accessor for each field
     */
    public ST[] getPetName() throws HL7Exception {
    	return getTypedField(1, new ST[0]);
    }

    /**
     * Create an accessor for each field
     */
    public NM getShoeSize() throws HL7Exception {
    	return getTypedField(2, 0);
    }

}
