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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 OM3 message segment (Categorical Service/Test/Observation). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM3-1: Sequence Number - Test/Observation Master File (NM) <b>optional </b>
     * <li>OM3-2: Preferred Coding System (CE) <b>optional </b>
     * <li>OM3-3: Valid Coded "Answers" (CE) <b>optional </b>
     * <li>OM3-4: Normal Text/Codes for Categorical Observations (CE) <b>optional repeating</b>
     * <li>OM3-5: Abnormal Text/Codes for Categorical Observations (CE) <b>optional repeating</b>
     * <li>OM3-6: Critical Text/Codes for Categorical Observations (CE) <b>optional repeating</b>
     * <li>OM3-7: Value Type (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OM3 extends AbstractSegment {

    /** 
     * Creates a new OM3 segment
     */
    public OM3(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/Observation Master File");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Preferred Coding System");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Valid Coded \"Answers\"");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Normal Text/Codes for Categorical Observations");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Abnormal Text/Codes for Categorical Observations");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Critical Text/Codes for Categorical Observations");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(125) }, "Value Type");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM3 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM3-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getOm31_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM3-2: "Preferred Coding System" - creates it if necessary
     */
    public CE getPreferredCodingSystem() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-2: "Preferred Coding System" - creates it if necessary
     */
    public CE getOm32_PreferredCodingSystem() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OM3-3: "Valid Coded "Answers"" - creates it if necessary
     */
    public CE getValidCodedAnswers() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-3: "Valid Coded "Answers"" - creates it if necessary
     */
    public CE getOm33_ValidCodedAnswers() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     */
    public CE[] getNormalTextCodesForCategoricalObservations() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     */
    public CE[] getOm34_NormalTextCodesForCategoricalObservations() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getNormalTextCodesForCategoricalObservations(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm34_NormalTextCodesForCategoricalObservations(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Normal Text/Codes for Categorical Observations (OM3-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm34_NormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertNormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm34_NormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeNormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM3-4: "Normal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm34_NormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     */
    public CE[] getAbnormalTextCodesForCategoricalObservations() {
    	CE[] retVal = this.getTypedField(5, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     */
    public CE[] getOm35_AbnormalTextCodesForCategoricalObservations() {
    	CE[] retVal = this.getTypedField(5, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAbnormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getAbnormalTextCodesForCategoricalObservations(int rep) { 
		CE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm35_AbnormalTextCodesForCategoricalObservations(int rep) { 
		CE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Abnormal Text/Codes for Categorical Observations (OM3-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm35_AbnormalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertAbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm35_AbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeAbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM3-5: "Abnormal Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm35_AbnormalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     */
    public CE[] getCriticalTextCodesForCategoricalObservations() {
    	CE[] retVal = this.getTypedField(6, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     */
    public CE[] getOm36_CriticalTextCodesForCategoricalObservations() {
    	CE[] retVal = this.getTypedField(6, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCriticalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCriticalTextCodesForCategoricalObservations(int rep) { 
		CE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm36_CriticalTextCodesForCategoricalObservations(int rep) { 
		CE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Critical Text/Codes for Categorical Observations (OM3-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm36_CriticalTextCodesForCategoricalObservationsReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm36_CriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * OM3-6: "Critical Text/Codes for Categorical Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm36_CriticalTextCodesForCategoricalObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * OM3-7: "Value Type" - creates it if necessary
     */
    public ID getValueType() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM3-7: "Value Type" - creates it if necessary
     */
    public ID getOm37_ValueType() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new ID(getMessage(), new Integer( 125 ));
          default: return null;
       }
   }


}

