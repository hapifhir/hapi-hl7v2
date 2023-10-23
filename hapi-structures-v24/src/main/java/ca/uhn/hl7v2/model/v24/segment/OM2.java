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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 OM2 message segment (Numeric Observation). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM2-1: Sequence Number - Test/ Observation Master File (NM) <b>optional </b>
     * <li>OM2-2: Units of Measure (CE) <b>optional </b>
     * <li>OM2-3: Range of Decimal Precision (NM) <b>optional repeating</b>
     * <li>OM2-4: Corresponding SI Units of Measure (CE) <b>optional </b>
     * <li>OM2-5: SI Conversion Factor (TX) <b>optional </b>
     * <li>OM2-6: Reference (Normal) Range - Ordinal and Continuous Observations (RFR) <b>optional </b>
     * <li>OM2-7: Critical Range for Ordinal and Continuous Observations (NR) <b>optional </b>
     * <li>OM2-8: Absolute Range for Ordinal and Continuous Observations (RFR) <b>optional </b>
     * <li>OM2-9: Delta Check Criteria (DLT) <b>optional repeating</b>
     * <li>OM2-10: Minimum Meaningful Increments (NM) <b>optional </b>
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
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/ Observation Master File");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Units of Measure");
                                  this.add(NM.class, false, 0, 10, new Object[]{ getMessage() }, "Range of Decimal Precision");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Corresponding SI Units of Measure");
                                  this.add(TX.class, false, 1, 60, new Object[]{ getMessage() }, "SI Conversion Factor");
                                  this.add(RFR.class, false, 1, 250, new Object[]{ getMessage() }, "Reference (Normal) Range - Ordinal and Continuous Observations");
                                  this.add(NR.class, false, 1, 205, new Object[]{ getMessage() }, "Critical Range for Ordinal and Continuous Observations");
                                  this.add(RFR.class, false, 1, 250, new Object[]{ getMessage() }, "Absolute Range for Ordinal and Continuous Observations");
                                  this.add(DLT.class, false, 0, 250, new Object[]{ getMessage() }, "Delta Check Criteria");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Minimum Meaningful Increments");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM2-1: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-1: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getOm21_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-2: "Units of Measure" - creates it if necessary
     */
    public CE getUnitsOfMeasure() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-2: "Units of Measure" - creates it if necessary
     */
    public CE getOm22_UnitsOfMeasure() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Range of Decimal Precision (OM2-3).
     */
    public NM[] getRangeOfDecimalPrecision() {
    	NM[] retVal = this.getTypedField(3, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Range of Decimal Precision (OM2-3).
     */
    public NM[] getOm23_RangeOfDecimalPrecision() {
    	NM[] retVal = this.getTypedField(3, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Range of Decimal Precision (OM2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRangeOfDecimalPrecisionReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * OM2-3: "Range of Decimal Precision" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getRangeOfDecimalPrecision(int rep) { 
		NM retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM2-3: "Range of Decimal Precision" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getOm23_RangeOfDecimalPrecision(int rep) { 
		NM retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Range of Decimal Precision (OM2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm23_RangeOfDecimalPrecisionReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * OM2-3: "Range of Decimal Precision" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertRangeOfDecimalPrecision(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * OM2-3: "Range of Decimal Precision" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertOm23_RangeOfDecimalPrecision(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM2-3: "Range of Decimal Precision" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeRangeOfDecimalPrecision(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM2-3: "Range of Decimal Precision" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeOm23_RangeOfDecimalPrecision(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * OM2-4: "Corresponding SI Units of Measure" - creates it if necessary
     */
    public CE getCorrespondingSIUnitsOfMeasure() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-4: "Corresponding SI Units of Measure" - creates it if necessary
     */
    public CE getOm24_CorrespondingSIUnitsOfMeasure() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-5: "SI Conversion Factor" - creates it if necessary
     */
    public TX getSIConversionFactor() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-5: "SI Conversion Factor" - creates it if necessary
     */
    public TX getOm25_SIConversionFactor() { 
		TX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-6: "Reference (Normal) Range - Ordinal and Continuous Observations" - creates it if necessary
     */
    public RFR getReferenceNormalRangeOrdinalAndContinuousObservations() { 
		RFR retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-6: "Reference (Normal) Range - Ordinal and Continuous Observations" - creates it if necessary
     */
    public RFR getOm26_ReferenceNormalRangeOrdinalAndContinuousObservations() { 
		RFR retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-7: "Critical Range for Ordinal and Continuous Observations" - creates it if necessary
     */
    public NR getCriticalRangeForOrdinalAndContinuousObservations() { 
		NR retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-7: "Critical Range for Ordinal and Continuous Observations" - creates it if necessary
     */
    public NR getOm27_CriticalRangeForOrdinalAndContinuousObservations() { 
		NR retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OM2-8: "Absolute Range for Ordinal and Continuous Observations" - creates it if necessary
     */
    public RFR getAbsoluteRangeForOrdinalAndContinuousObservations() { 
		RFR retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-8: "Absolute Range for Ordinal and Continuous Observations" - creates it if necessary
     */
    public RFR getOm28_AbsoluteRangeForOrdinalAndContinuousObservations() { 
		RFR retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Delta Check Criteria (OM2-9).
     */
    public DLT[] getDeltaCheckCriteria() {
    	DLT[] retVal = this.getTypedField(9, new DLT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Delta Check Criteria (OM2-9).
     */
    public DLT[] getOm29_DeltaCheckCriteria() {
    	DLT[] retVal = this.getTypedField(9, new DLT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Delta Check Criteria (OM2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDeltaCheckCriteriaReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * OM2-9: "Delta Check Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DLT getDeltaCheckCriteria(int rep) { 
		DLT retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM2-9: "Delta Check Criteria" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DLT getOm29_DeltaCheckCriteria(int rep) { 
		DLT retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Delta Check Criteria (OM2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm29_DeltaCheckCriteriaReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * OM2-9: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DLT insertDeltaCheckCriteria(int rep) throws HL7Exception { 
        return (DLT) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * OM2-9: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DLT insertOm29_DeltaCheckCriteria(int rep) throws HL7Exception { 
        return (DLT) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * OM2-9: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DLT removeDeltaCheckCriteria(int rep) throws HL7Exception { 
        return (DLT) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * OM2-9: "Delta Check Criteria" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DLT removeOm29_DeltaCheckCriteria(int rep) throws HL7Exception { 
        return (DLT) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * OM2-10: "Minimum Meaningful Increments" - creates it if necessary
     */
    public NM getMinimumMeaningfulIncrements() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM2-10: "Minimum Meaningful Increments" - creates it if necessary
     */
    public NM getOm210_MinimumMeaningfulIncrements() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new TX(getMessage());
          case 5: return new RFR(getMessage());
          case 6: return new NR(getMessage());
          case 7: return new RFR(getMessage());
          case 8: return new DLT(getMessage());
          case 9: return new NM(getMessage());
          default: return null;
       }
   }


}

