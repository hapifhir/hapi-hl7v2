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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 APR message segment (Appointment Preferences). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>APR-1: Time Selection Criteria (SCV) <b>optional repeating</b>
     * <li>APR-2: Resource Selection Criteria (SCV) <b>optional repeating</b>
     * <li>APR-3: Location Selection Criteria (SCV) <b>optional repeating</b>
     * <li>APR-4: Slot Spacing Criteria (NM) <b>optional </b>
     * <li>APR-5: Filler Override Criteria (SCV) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class APR extends AbstractSegment {

    /** 
     * Creates a new APR segment
     */
    public APR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SCV.class, false, 0, 0, new Object[]{ getMessage() }, "Time Selection Criteria");
                                  this.add(SCV.class, false, 0, 0, new Object[]{ getMessage() }, "Resource Selection Criteria");
                                  this.add(SCV.class, false, 0, 0, new Object[]{ getMessage() }, "Location Selection Criteria");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Slot Spacing Criteria");
                                  this.add(SCV.class, false, 0, 0, new Object[]{ getMessage() }, "Filler Override Criteria");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating APR - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Time Selection Criteria (APR-1).
     */
    public SCV[] getTimeSelectionCriteria() {
    	SCV[] retVal = this.getTypedField(1, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Time Selection Criteria (APR-1).
     */
    public SCV[] getApr1_TimeSelectionCriteria() {
    	SCV[] retVal = this.getTypedField(1, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Time Selection Criteria (APR-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTimeSelectionCriteriaReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * APR-1: "Time Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getTimeSelectionCriteria(int rep) { 
		SCV retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * APR-1: "Time Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getApr1_TimeSelectionCriteria(int rep) { 
		SCV retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Time Selection Criteria (APR-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getApr1_TimeSelectionCriteriaReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * APR-1: "Time Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertTimeSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * APR-1: "Time Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertApr1_TimeSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * APR-1: "Time Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeTimeSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * APR-1: "Time Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeApr1_TimeSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(1, rep);
    }



    /**
     * Returns all repetitions of Resource Selection Criteria (APR-2).
     */
    public SCV[] getResourceSelectionCriteria() {
    	SCV[] retVal = this.getTypedField(2, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Resource Selection Criteria (APR-2).
     */
    public SCV[] getApr2_ResourceSelectionCriteria() {
    	SCV[] retVal = this.getTypedField(2, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Resource Selection Criteria (APR-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getResourceSelectionCriteriaReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * APR-2: "Resource Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getResourceSelectionCriteria(int rep) { 
		SCV retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * APR-2: "Resource Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getApr2_ResourceSelectionCriteria(int rep) { 
		SCV retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Resource Selection Criteria (APR-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getApr2_ResourceSelectionCriteriaReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * APR-2: "Resource Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertResourceSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * APR-2: "Resource Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertApr2_ResourceSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * APR-2: "Resource Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeResourceSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * APR-2: "Resource Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeApr2_ResourceSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Location Selection Criteria (APR-3).
     */
    public SCV[] getLocationSelectionCriteria() {
    	SCV[] retVal = this.getTypedField(3, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Selection Criteria (APR-3).
     */
    public SCV[] getApr3_LocationSelectionCriteria() {
    	SCV[] retVal = this.getTypedField(3, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Selection Criteria (APR-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationSelectionCriteriaReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * APR-3: "Location Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getLocationSelectionCriteria(int rep) { 
		SCV retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * APR-3: "Location Selection Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getApr3_LocationSelectionCriteria(int rep) { 
		SCV retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Selection Criteria (APR-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getApr3_LocationSelectionCriteriaReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * APR-3: "Location Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertLocationSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * APR-3: "Location Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertApr3_LocationSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * APR-3: "Location Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeLocationSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * APR-3: "Location Selection Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeApr3_LocationSelectionCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * APR-4: "Slot Spacing Criteria" - creates it if necessary
     */
    public NM getSlotSpacingCriteria() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * APR-4: "Slot Spacing Criteria" - creates it if necessary
     */
    public NM getApr4_SlotSpacingCriteria() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Filler Override Criteria (APR-5).
     */
    public SCV[] getFillerOverrideCriteria() {
    	SCV[] retVal = this.getTypedField(5, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Filler Override Criteria (APR-5).
     */
    public SCV[] getApr5_FillerOverrideCriteria() {
    	SCV[] retVal = this.getTypedField(5, new SCV[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Filler Override Criteria (APR-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFillerOverrideCriteriaReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * APR-5: "Filler Override Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getFillerOverrideCriteria(int rep) { 
		SCV retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * APR-5: "Filler Override Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SCV getApr5_FillerOverrideCriteria(int rep) { 
		SCV retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Filler Override Criteria (APR-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getApr5_FillerOverrideCriteriaReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * APR-5: "Filler Override Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertFillerOverrideCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * APR-5: "Filler Override Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV insertApr5_FillerOverrideCriteria(int rep) throws HL7Exception { 
        return (SCV) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * APR-5: "Filler Override Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeFillerOverrideCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * APR-5: "Filler Override Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SCV removeApr5_FillerOverrideCriteria(int rep) throws HL7Exception { 
        return (SCV) super.removeRepetition(5, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SCV(getMessage());
          case 1: return new SCV(getMessage());
          case 2: return new SCV(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new SCV(getMessage());
          default: return null;
       }
   }


}

