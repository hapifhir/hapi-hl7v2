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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ODT message segment (DIET TRAY INSTRUCTION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ODT-1: Tray Type (CE) <b> </b>
     * <li>ODT-2: Service Period (CE) <b>optional repeating</b>
     * <li>ODT-3: Text Instruction (ST) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ODT extends AbstractSegment {

    /** 
     * Creates a new ODT segment
     */
    public ODT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Tray Type");
                                  this.add(CE.class, false, 10, 60, new Object[]{ getMessage() }, "Service Period");
                                  this.add(ST.class, false, 2, 80, new Object[]{ getMessage() }, "Text Instruction");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ODT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ODT-1: "Tray Type" - creates it if necessary
     */
    public CE getTrayType() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ODT-1: "Tray Type" - creates it if necessary
     */
    public CE getOdt1_TrayType() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Service Period (ODT-2).
     */
    public CE[] getServicePeriod() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Service Period (ODT-2).
     */
    public CE[] getOdt2_ServicePeriod() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Service Period (ODT-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getServicePeriodReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * ODT-2: "Service Period" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getServicePeriod(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ODT-2: "Service Period" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOdt2_ServicePeriod(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Service Period (ODT-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOdt2_ServicePeriodReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * ODT-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertServicePeriod(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * ODT-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOdt2_ServicePeriod(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ODT-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeServicePeriod(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ODT-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOdt2_ServicePeriod(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Text Instruction (ODT-3).
     */
    public ST[] getTextInstruction() {
    	ST[] retVal = this.getTypedField(3, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Text Instruction (ODT-3).
     */
    public ST[] getOdt3_TextInstruction() {
    	ST[] retVal = this.getTypedField(3, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Text Instruction (ODT-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTextInstructionReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * ODT-3: "Text Instruction" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getTextInstruction(int rep) { 
		ST retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ODT-3: "Text Instruction" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOdt3_TextInstruction(int rep) { 
		ST retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Text Instruction (ODT-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOdt3_TextInstructionReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * ODT-3: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertTextInstruction(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * ODT-3: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOdt3_TextInstruction(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ODT-3: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeTextInstruction(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ODT-3: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOdt3_TextInstruction(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(3, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ST(getMessage());
          default: return null;
       }
   }


}

