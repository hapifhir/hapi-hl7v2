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
 *<p>Represents an HL7 OM2 message segment (NUMERIC OBSERVATION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM2-1: Segment Type ID (ST) <b>optional </b>
     * <li>OM2-2: Sequence Number - Test/ Observation Master File (NM) <b>optional </b>
     * <li>OM2-3: Units of Measure (CE) <b>optional </b>
     * <li>OM2-4: Range of Decimal Precision (NM) <b>optional </b>
     * <li>OM2-5: Corresponding SI Units of Measure (CE) <b>optional </b>
     * <li>OM2-6: SI Conversion Factor (TX) <b> repeating</b>
     * <li>OM2-7: Reference (normal) range - ordinal & continuous observations (CM_RFR) <b>optional repeating</b>
     * <li>OM2-8: Critical range for ordinal and continuous observations (CM_RANGE) <b>optional </b>
     * <li>OM2-9: Absolute range for ordinal and continuous observations (CM_ABS_RANGE) <b>optional </b>
     * <li>OM2-10: Delta Check Criteria (CM_DLT) <b>optional repeating</b>
     * <li>OM2-11: Minimum Meaningful Increments (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OM2 extends AbstractSegment {

    /** 
     * Creates a new OM2 segment
     */
    public OM2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "Segment Type ID");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/ Observation Master File");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Units of Measure");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "Range of Decimal Precision");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Corresponding SI Units of Measure");
                                  this.add(TX.class, true, 0, 20, new Object[]{ getMessage() }, "SI Conversion Factor");
                                  this.add(CM_RFR.class, false, 0, 200, new Object[]{ getMessage() }, "Reference (normal) range - ordinal & continuous observations");
                                  this.add(CM_RANGE.class, false, 1, 200, new Object[]{ getMessage() }, "Critical range for ordinal and continuous observations");
                                  this.add(CM_ABS_RANGE.class, false, 1, 200, new Object[]{ getMessage() }, "Absolute range for ordinal and continuous observations");
                                  this.add(CM_DLT.class, false, 0, 200, new Object[]{ getMessage() }, "Delta Check Criteria");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Minimum Meaningful Increments");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM2-1: "Segment Type ID" - creates it if necessary
     */
    public ST getSegmentTypeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-1: "Segment Type ID" - creates it if necessary
     */
    public ST getOm21_SegmentTypeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-2: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-2: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getOm22_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-3: "Units of Measure" - creates it if necessary
     */
    public CE getUnitsOfMeasure() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-3: "Units of Measure" - creates it if necessary
     */
    public CE getOm23_UnitsOfMeasure() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-4: "Range of Decimal Precision" - creates it if necessary
     */
    public NM getRangeOfDecimalPrecision() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-4: "Range of Decimal Precision" - creates it if necessary
     */
    public NM getOm24_RangeOfDecimalPrecision() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-5: "Corresponding SI Units of Measure" - creates it if necessary
     */
    public CE getCorrespondingSIUnitsOfMeasure() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-5: "Corresponding SI Units of Measure" - creates it if necessary
     */
    public CE getOm25_CorrespondingSIUnitsOfMeasure() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of SI Conversion Factor (OM2-6).
     */
    public TX[] getSIConversionFactor() {
    	TX[] retVal = this.getTypedField(6, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of SI Conversion Factor (OM2-6).
     */
    public TX[] getOm26_SIConversionFactor() {
    	TX[] retVal = this.getTypedField(6, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of SI Conversion Factor (OM2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSIConversionFactorReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * OM2-6: "SI Conversion Factor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getSIConversionFactor(int rep) { 
		TX retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM2-6: "SI Conversion Factor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getOm26_SIConversionFactor(int rep) { 
		TX retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of SI Conversion Factor (OM2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm26_SIConversionFactorReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * OM2-6: "SI Conversion Factor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertSIConversionFactor(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * OM2-6: "SI Conversion Factor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertOm26_SIConversionFactor(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * OM2-6: "SI Conversion Factor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeSIConversionFactor(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * OM2-6: "SI Conversion Factor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeOm26_SIConversionFactor(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Reference (normal) range - ordinal & continuous observations (OM2-7).
     */
    public CM_RFR[] getReferenceNormalRangeOrdinalContinuousObservations() {
    	CM_RFR[] retVal = this.getTypedField(7, new CM_RFR[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reference (normal) range - ordinal & continuous observations (OM2-7).
     */
    public CM_RFR[] getOm27_ReferenceNormalRangeOrdinalContinuousObservations() {
    	CM_RFR[] retVal = this.getTypedField(7, new CM_RFR[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Reference (normal) range - ordinal & continuous observations (OM2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferenceNormalRangeOrdinalContinuousObservationsReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * OM2-7: "Reference (normal) range - ordinal & continuous observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_RFR getReferenceNormalRangeOrdinalContinuousObservations(int rep) { 
		CM_RFR retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM2-7: "Reference (normal) range - ordinal & continuous observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_RFR getOm27_ReferenceNormalRangeOrdinalContinuousObservations(int rep) { 
		CM_RFR retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Reference (normal) range - ordinal & continuous observations (OM2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm27_ReferenceNormalRangeOrdinalContinuousObservationsReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * OM2-7: "Reference (normal) range - ordinal & continuous observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RFR insertReferenceNormalRangeOrdinalContinuousObservations(int rep) throws HL7Exception { 
        return (CM_RFR) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * OM2-7: "Reference (normal) range - ordinal & continuous observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RFR insertOm27_ReferenceNormalRangeOrdinalContinuousObservations(int rep) throws HL7Exception { 
        return (CM_RFR) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * OM2-7: "Reference (normal) range - ordinal & continuous observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RFR removeReferenceNormalRangeOrdinalContinuousObservations(int rep) throws HL7Exception { 
        return (CM_RFR) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * OM2-7: "Reference (normal) range - ordinal & continuous observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RFR removeOm27_ReferenceNormalRangeOrdinalContinuousObservations(int rep) throws HL7Exception { 
        return (CM_RFR) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * OM2-8: "Critical range for ordinal and continuous observations" - creates it if necessary
     */
    public CM_RANGE getCriticalRangeForOrdinalAndContinuousObservations() { 
		CM_RANGE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-8: "Critical range for ordinal and continuous observations" - creates it if necessary
     */
    public CM_RANGE getOm28_CriticalRangeForOrdinalAndContinuousObservations() { 
		CM_RANGE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-9: "Absolute range for ordinal and continuous observations" - creates it if necessary
     */
    public CM_ABS_RANGE getAbsoluteRangeForOrdinalAndContinuousObservations() { 
		CM_ABS_RANGE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-9: "Absolute range for ordinal and continuous observations" - creates it if necessary
     */
    public CM_ABS_RANGE getOm29_AbsoluteRangeForOrdinalAndContinuousObservations() { 
		CM_ABS_RANGE retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Delta Check Criteria (OM2-10).
     */
    public CM_DLT[] getDeltaCheckCriteria() {
    	CM_DLT[] retVal = this.getTypedField(10, new CM_DLT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Delta Check Criteria (OM2-10).
     */
    public CM_DLT[] getOm210_DeltaCheckCriteria() {
    	CM_DLT[] retVal = this.getTypedField(10, new CM_DLT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Delta Check Criteria (OM2-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDeltaCheckCriteriaReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * OM2-10: "Delta Check Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_DLT getDeltaCheckCriteria(int rep) { 
		CM_DLT retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM2-10: "Delta Check Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_DLT getOm210_DeltaCheckCriteria(int rep) { 
		CM_DLT retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Delta Check Criteria (OM2-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm210_DeltaCheckCriteriaReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * OM2-10: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DLT insertDeltaCheckCriteria(int rep) throws HL7Exception { 
        return (CM_DLT) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * OM2-10: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DLT insertOm210_DeltaCheckCriteria(int rep) throws HL7Exception { 
        return (CM_DLT) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OM2-10: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DLT removeDeltaCheckCriteria(int rep) throws HL7Exception { 
        return (CM_DLT) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OM2-10: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DLT removeOm210_DeltaCheckCriteria(int rep) throws HL7Exception { 
        return (CM_DLT) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * OM2-11: "Minimum Meaningful Increments" - creates it if necessary
     */
    public NM getMinimumMeaningfulIncrements() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-11: "Minimum Meaningful Increments" - creates it if necessary
     */
    public NM getOm211_MinimumMeaningfulIncrements() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new TX(getMessage());
          case 6: return new CM_RFR(getMessage());
          case 7: return new CM_RANGE(getMessage());
          case 8: return new CM_ABS_RANGE(getMessage());
          case 9: return new CM_DLT(getMessage());
          case 10: return new NM(getMessage());
          default: return null;
       }
   }


}

