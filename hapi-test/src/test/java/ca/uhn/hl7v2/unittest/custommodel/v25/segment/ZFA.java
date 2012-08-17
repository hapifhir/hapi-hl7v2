/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uhn.hl7v2.unittest.custommodel.v25.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.datatype.NM;
import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * ZPI custom segment example
 *
 * Note that custom segments extend from {@link AbstractSegment}
 */
public class ZFA extends AbstractSegment {

    /**
     * Adding a serial UID is always a good idea, but optional
     */
    private static final long serialVersionUID = 1;

    /**
     * Custom segments need a constructor with exactly these arguments
     */
    public ZFA(Group parent, ModelClassFactory modelClassFactory) throws HL7Exception {
        super(parent, modelClassFactory);

        Message message = getMessage();

        // For each in the segment, call this.add()

        // ZPI-1 - Pet Name(s)
        Class<? extends Type> type = ST.class;
        boolean required = true;
        int maxReps = 0; // unlimited
        int maxLength = 100;
        Object[] constructorArgs = new Object[]{message};
        String fieldName = "Pet Name(s)";
        this.add(type, required, maxReps, maxLength, constructorArgs, fieldName);

        // ZPI-2 - Shoe Size
        type = NM.class;
        required = false;
        maxReps = 1; // only 1 rep
        maxLength = 4;
        constructorArgs = new Object[]{message};
        fieldName = "Shoe Size";
        this.add(type, required, maxReps, maxLength, constructorArgs, fieldName);

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
        return (ST[]) super.getField(1); // 1 - field num( numbered from 1)
    }

    /**
     * Create an accessor for each field
     */
    public NM getShoeSize() throws HL7Exception {
        return (NM) super.getField(1, 0); // 1=field num(numbered from 1) 0=repetition(numbered from 0)
    }

}
