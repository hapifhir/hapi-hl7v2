/*
 * This class is an auto-generated source file for a HAPI
 * HL7 v2.x standard structure class.
 *
 * For more information, visit: http://hl7api.sourceforge.net/
 * 
 * The contents of this file are subject to the Mozilla Public License Version 1.1 
 * (the "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
 * Software distributed under the License is distributed on an "AS IS" basis, 
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
 * specific language governing rights and limitations under the License. 
 * 
 * The Original Code is "[file_name]".  Description: 
 * "[one_line_description]" 
 * 
 * The Initial Developer of the Original Code is University Health Network. Copyright (C) 
 * 2012.  All Rights Reserved. 
 * 
 * Contributor(s): ______________________________________. 
 * 
 * Alternatively, the contents of this file may be used under the terms of the 
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
 * applicable instead of those above.  If you wish to allow use of your version of this 
 * file only under the terms of the GPL and not to allow others to use your version 
 * of this file under the MPL, indicate your decision by deleting  the provisions above 
 * and replace  them with the notice and other provisions required by the GPL License.  
 * If you do not delete the provisions above, a recipient may use your version of 
 * this file under either the MPL or the GPL. 
 * 
 */


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ECR message segment (Equipment Command Response). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ECR-1: Command Response (CWE) <b> </b>
     * <li>ECR-2: Date/Time Completed (DTM) <b> </b>
     * <li>ECR-3: Command Response Parameters (TX) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ECR extends AbstractSegment {

    /** 
     * Creates a new ECR segment
     */
    public ECR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 705, new Object[]{ getMessage() }, "Command Response");
                                  this.add(DTM.class, true, 1, 24, new Object[]{ getMessage() }, "Date/Time Completed");
                                  this.add(TX.class, false, 0, 65536, new Object[]{ getMessage() }, "Command Response Parameters");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ECR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ECR-1: "Command Response" - creates it if necessary
     */
    public CWE getCommandResponse() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ECR-1: "Command Response" - creates it if necessary
     */
    public CWE getEcr1_CommandResponse() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ECR-2: "Date/Time Completed" - creates it if necessary
     */
    public DTM getDateTimeCompleted() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ECR-2: "Date/Time Completed" - creates it if necessary
     */
    public DTM getEcr2_DateTimeCompleted() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Command Response Parameters (ECR-3).
     */
    public TX[] getCommandResponseParameters() {
    	TX[] retVal = this.getTypedField(3, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Command Response Parameters (ECR-3).
     */
    public TX[] getEcr3_CommandResponseParameters() {
    	TX[] retVal = this.getTypedField(3, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Command Response Parameters (ECR-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCommandResponseParametersReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * ECR-3: "Command Response Parameters" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getCommandResponseParameters(int rep) { 
		TX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ECR-3: "Command Response Parameters" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getEcr3_CommandResponseParameters(int rep) { 
		TX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Command Response Parameters (ECR-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEcr3_CommandResponseParametersReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * ECR-3: "Command Response Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertCommandResponseParameters(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * ECR-3: "Command Response Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertEcr3_CommandResponseParameters(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ECR-3: "Command Response Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeCommandResponseParameters(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ECR-3: "Command Response Parameters" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeEcr3_CommandResponseParameters(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(3, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new TX(getMessage());
          default: return null;
       }
   }


}

