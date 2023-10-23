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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ODS message segment (Dietary Orders, Supplements, and Preferences). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ODS-1: Type (ID) <b> </b>
     * <li>ODS-2: Service Period (CWE) <b>optional repeating</b>
     * <li>ODS-3: Diet, Supplement, or Preference Code (CWE) <b> repeating</b>
     * <li>ODS-4: Text Instruction (ST) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ODS extends AbstractSegment {

    /** 
     * Creates a new ODS segment
     */
    public ODS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(159) }, "Type");
                                  this.add(CWE.class, false, 10, 0, new Object[]{ getMessage() }, "Service Period");
                                  this.add(CWE.class, true, 20, 0, new Object[]{ getMessage() }, "Diet, Supplement, or Preference Code");
                                  this.add(ST.class, false, 2, 0, new Object[]{ getMessage() }, "Text Instruction");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ODS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ODS-1: "Type" - creates it if necessary
     */
    public ID getType() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ODS-1: "Type" - creates it if necessary
     */
    public ID getOds1_Type() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Service Period (ODS-2).
     */
    public CWE[] getServicePeriod() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Service Period (ODS-2).
     */
    public CWE[] getOds2_ServicePeriod() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Service Period (ODS-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getServicePeriodReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * ODS-2: "Service Period" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getServicePeriod(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ODS-2: "Service Period" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOds2_ServicePeriod(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Service Period (ODS-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOds2_ServicePeriodReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * ODS-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertServicePeriod(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * ODS-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOds2_ServicePeriod(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ODS-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeServicePeriod(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ODS-2: "Service Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOds2_ServicePeriod(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Diet, Supplement, or Preference Code (ODS-3).
     */
    public CWE[] getDietSupplementOrPreferenceCode() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Diet, Supplement, or Preference Code (ODS-3).
     */
    public CWE[] getOds3_DietSupplementOrPreferenceCode() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Diet, Supplement, or Preference Code (ODS-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDietSupplementOrPreferenceCodeReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * ODS-3: "Diet, Supplement, or Preference Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getDietSupplementOrPreferenceCode(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ODS-3: "Diet, Supplement, or Preference Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOds3_DietSupplementOrPreferenceCode(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Diet, Supplement, or Preference Code (ODS-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOds3_DietSupplementOrPreferenceCodeReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * ODS-3: "Diet, Supplement, or Preference Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertDietSupplementOrPreferenceCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * ODS-3: "Diet, Supplement, or Preference Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOds3_DietSupplementOrPreferenceCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ODS-3: "Diet, Supplement, or Preference Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeDietSupplementOrPreferenceCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * ODS-3: "Diet, Supplement, or Preference Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOds3_DietSupplementOrPreferenceCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Text Instruction (ODS-4).
     */
    public ST[] getTextInstruction() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Text Instruction (ODS-4).
     */
    public ST[] getOds4_TextInstruction() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Text Instruction (ODS-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTextInstructionReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * ODS-4: "Text Instruction" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getTextInstruction(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ODS-4: "Text Instruction" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOds4_TextInstruction(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Text Instruction (ODS-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOds4_TextInstructionReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * ODS-4: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertTextInstruction(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * ODS-4: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOds4_TextInstruction(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * ODS-4: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeTextInstruction(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * ODS-4: "Text Instruction" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOds4_TextInstruction(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 159 ));
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new ST(getMessage());
          default: return null;
       }
   }


}

