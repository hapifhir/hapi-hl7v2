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
 *<p>Represents an HL7 UB2 message segment (UB92 DATA). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>UB2-1: Set ID - UB92 (SI) <b>optional </b>
     * <li>UB2-2: Co-insurance days (9) (ST) <b>optional </b>
     * <li>UB2-3: Condition code (24-30) (ID) <b>optional repeating</b>
     * <li>UB2-4: Covered days (7) (ST) <b>optional </b>
     * <li>UB2-5: Non-covered days (8) (ST) <b>optional </b>
     * <li>UB2-6: Value amount and code (39-41) (CM_UVC) <b>optional repeating</b>
     * <li>UB2-7: Occurrence code and date (32-35) (CM_OCD) <b>optional repeating</b>
     * <li>UB2-8: Occurrence span code / dates (36) (CM_OSP) <b>optional repeating</b>
     * <li>UB2-9: UB92 locator 2 (state) (ST) <b>optional repeating</b>
     * <li>UB2-10: UB92 locator 11 (state) (ST) <b>optional repeating</b>
     * <li>UB2-11: UB92 locator 31 (national) (ST) <b>optional </b>
     * <li>UB2-12: Document control number (37) (ST) <b>optional repeating</b>
     * <li>UB2-13: UB92 locator 49 (national) (ST) <b>optional repeating</b>
     * <li>UB2-14: UB92 locator 56 (state) (ST) <b>optional repeating</b>
     * <li>UB2-15: UB92 locator 57 (national) (ST) <b>optional </b>
     * <li>UB2-16: UB92 Locator 78 (state) (ST) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class UB2 extends AbstractSegment {

    /** 
     * Creates a new UB2 segment
     */
    public UB2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - UB92");
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "Co-insurance days (9)");
                                              this.add(ID.class, false, 7, 2, new Object[]{ getMessage(), new Integer(43) }, "Condition code (24-30)");
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "Covered days (7)");
                                  this.add(ST.class, false, 1, 4, new Object[]{ getMessage() }, "Non-covered days (8)");
                                  this.add(CM_UVC.class, false, 12, 11, new Object[]{ getMessage() }, "Value amount and code (39-41)");
                                  this.add(CM_OCD.class, false, 8, 11, new Object[]{ getMessage() }, "Occurrence code and date (32-35)");
                                  this.add(CM_OSP.class, false, 2, 28, new Object[]{ getMessage() }, "Occurrence span code / dates (36)");
                                  this.add(ST.class, false, 2, 29, new Object[]{ getMessage() }, "UB92 locator 2 (state)");
                                  this.add(ST.class, false, 2, 12, new Object[]{ getMessage() }, "UB92 locator 11 (state)");
                                  this.add(ST.class, false, 1, 5, new Object[]{ getMessage() }, "UB92 locator 31 (national)");
                                  this.add(ST.class, false, 3, 23, new Object[]{ getMessage() }, "Document control number (37)");
                                  this.add(ST.class, false, 23, 4, new Object[]{ getMessage() }, "UB92 locator 49 (national)");
                                  this.add(ST.class, false, 5, 14, new Object[]{ getMessage() }, "UB92 locator 56 (state)");
                                  this.add(ST.class, false, 1, 27, new Object[]{ getMessage() }, "UB92 locator 57 (national)");
                                  this.add(ST.class, false, 2, 2, new Object[]{ getMessage() }, "UB92 Locator 78 (state)");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating UB2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * UB2-1: "Set ID - UB92" - creates it if necessary
     */
    public SI getSetIDUB92() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-1: "Set ID - UB92" - creates it if necessary
     */
    public SI getUb21_SetIDUB92() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * UB2-2: "Co-insurance days (9)" - creates it if necessary
     */
    public ST getCoInsuranceDays9() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-2: "Co-insurance days (9)" - creates it if necessary
     */
    public ST getUb22_CoInsuranceDays9() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Condition code (24-30) (UB2-3).
     */
    public ID[] getConditionCode2430() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Condition code (24-30) (UB2-3).
     */
    public ID[] getUb23_ConditionCode2430() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Condition code (24-30) (UB2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getConditionCode2430Reps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * UB2-3: "Condition code (24-30)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getConditionCode2430(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-3: "Condition code (24-30)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUb23_ConditionCode2430(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Condition code (24-30) (UB2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb23_ConditionCode2430Reps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * UB2-3: "Condition code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertConditionCode2430(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-3: "Condition code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUb23_ConditionCode2430(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * UB2-3: "Condition code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeConditionCode2430(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * UB2-3: "Condition code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUb23_ConditionCode2430(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * UB2-4: "Covered days (7)" - creates it if necessary
     */
    public ST getCoveredDays7() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-4: "Covered days (7)" - creates it if necessary
     */
    public ST getUb24_CoveredDays7() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * UB2-5: "Non-covered days (8)" - creates it if necessary
     */
    public ST getNonCoveredDays8() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-5: "Non-covered days (8)" - creates it if necessary
     */
    public ST getUb25_NonCoveredDays8() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Value amount and code (39-41) (UB2-6).
     */
    public CM_UVC[] getValueAmountAndCode3941() {
    	CM_UVC[] retVal = this.getTypedField(6, new CM_UVC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Value amount and code (39-41) (UB2-6).
     */
    public CM_UVC[] getUb26_ValueAmountAndCode3941() {
    	CM_UVC[] retVal = this.getTypedField(6, new CM_UVC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Value amount and code (39-41) (UB2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValueAmountAndCode3941Reps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * UB2-6: "Value amount and code (39-41)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_UVC getValueAmountAndCode3941(int rep) { 
		CM_UVC retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-6: "Value amount and code (39-41)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_UVC getUb26_ValueAmountAndCode3941(int rep) { 
		CM_UVC retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Value amount and code (39-41) (UB2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb26_ValueAmountAndCode3941Reps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * UB2-6: "Value amount and code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC insertValueAmountAndCode3941(int rep) throws HL7Exception { 
        return (CM_UVC) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-6: "Value amount and code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC insertUb26_ValueAmountAndCode3941(int rep) throws HL7Exception { 
        return (CM_UVC) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * UB2-6: "Value amount and code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC removeValueAmountAndCode3941(int rep) throws HL7Exception { 
        return (CM_UVC) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * UB2-6: "Value amount and code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC removeUb26_ValueAmountAndCode3941(int rep) throws HL7Exception { 
        return (CM_UVC) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Occurrence code and date (32-35) (UB2-7).
     */
    public CM_OCD[] getOccurrenceCodeAndDate3235() {
    	CM_OCD[] retVal = this.getTypedField(7, new CM_OCD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Occurrence code and date (32-35) (UB2-7).
     */
    public CM_OCD[] getUb27_OccurrenceCodeAndDate3235() {
    	CM_OCD[] retVal = this.getTypedField(7, new CM_OCD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Occurrence code and date (32-35) (UB2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOccurrenceCodeAndDate3235Reps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * UB2-7: "Occurrence code and date (32-35)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_OCD getOccurrenceCodeAndDate3235(int rep) { 
		CM_OCD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-7: "Occurrence code and date (32-35)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_OCD getUb27_OccurrenceCodeAndDate3235(int rep) { 
		CM_OCD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Occurrence code and date (32-35) (UB2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb27_OccurrenceCodeAndDate3235Reps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * UB2-7: "Occurrence code and date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD insertOccurrenceCodeAndDate3235(int rep) throws HL7Exception { 
        return (CM_OCD) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-7: "Occurrence code and date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD insertUb27_OccurrenceCodeAndDate3235(int rep) throws HL7Exception { 
        return (CM_OCD) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB2-7: "Occurrence code and date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD removeOccurrenceCodeAndDate3235(int rep) throws HL7Exception { 
        return (CM_OCD) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB2-7: "Occurrence code and date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD removeUb27_OccurrenceCodeAndDate3235(int rep) throws HL7Exception { 
        return (CM_OCD) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Occurrence span code / dates (36) (UB2-8).
     */
    public CM_OSP[] getOccurrenceSpanCodeDates() {
    	CM_OSP[] retVal = this.getTypedField(8, new CM_OSP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Occurrence span code / dates (36) (UB2-8).
     */
    public CM_OSP[] getUb28_OccurrenceSpanCodeDates() {
    	CM_OSP[] retVal = this.getTypedField(8, new CM_OSP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Occurrence span code / dates (36) (UB2-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOccurrenceSpanCodeDatesReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * UB2-8: "Occurrence span code / dates (36)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_OSP getOccurrenceSpanCodeDates(int rep) { 
		CM_OSP retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-8: "Occurrence span code / dates (36)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_OSP getUb28_OccurrenceSpanCodeDates(int rep) { 
		CM_OSP retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Occurrence span code / dates (36) (UB2-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb28_OccurrenceSpanCodeDatesReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * UB2-8: "Occurrence span code / dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OSP insertOccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (CM_OSP) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-8: "Occurrence span code / dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OSP insertUb28_OccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (CM_OSP) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * UB2-8: "Occurrence span code / dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OSP removeOccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (CM_OSP) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * UB2-8: "Occurrence span code / dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OSP removeUb28_OccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (CM_OSP) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of UB92 locator 2 (state) (UB2-9).
     */
    public ST[] getUB92Locator2State() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of UB92 locator 2 (state) (UB2-9).
     */
    public ST[] getUb29_UB92Locator2State() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of UB92 locator 2 (state) (UB2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUB92Locator2StateReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * UB2-9: "UB92 locator 2 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUB92Locator2State(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-9: "UB92 locator 2 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb29_UB92Locator2State(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of UB92 locator 2 (state) (UB2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb29_UB92Locator2StateReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * UB2-9: "UB92 locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUB92Locator2State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-9: "UB92 locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb29_UB92Locator2State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * UB2-9: "UB92 locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUB92Locator2State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * UB2-9: "UB92 locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb29_UB92Locator2State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of UB92 locator 11 (state) (UB2-10).
     */
    public ST[] getUB92Locator11State() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of UB92 locator 11 (state) (UB2-10).
     */
    public ST[] getUb210_UB92Locator11State() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of UB92 locator 11 (state) (UB2-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUB92Locator11StateReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * UB2-10: "UB92 locator 11 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUB92Locator11State(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-10: "UB92 locator 11 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb210_UB92Locator11State(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of UB92 locator 11 (state) (UB2-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb210_UB92Locator11StateReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * UB2-10: "UB92 locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUB92Locator11State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-10: "UB92 locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb210_UB92Locator11State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB2-10: "UB92 locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUB92Locator11State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB2-10: "UB92 locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb210_UB92Locator11State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * UB2-11: "UB92 locator 31 (national)" - creates it if necessary
     */
    public ST getUB92Locator31National() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-11: "UB92 locator 31 (national)" - creates it if necessary
     */
    public ST getUb211_UB92Locator31National() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Document control number (37) (UB2-12).
     */
    public ST[] getDocumentControlNumber() {
    	ST[] retVal = this.getTypedField(12, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Document control number (37) (UB2-12).
     */
    public ST[] getUb212_DocumentControlNumber() {
    	ST[] retVal = this.getTypedField(12, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Document control number (37) (UB2-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDocumentControlNumberReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * UB2-12: "Document control number (37)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getDocumentControlNumber(int rep) { 
		ST retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-12: "Document control number (37)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb212_DocumentControlNumber(int rep) { 
		ST retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Document control number (37) (UB2-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb212_DocumentControlNumberReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * UB2-12: "Document control number (37)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertDocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-12: "Document control number (37)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb212_DocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * UB2-12: "Document control number (37)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeDocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * UB2-12: "Document control number (37)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb212_DocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(12, rep);
    }



    /**
     * Returns all repetitions of UB92 locator 49 (national) (UB2-13).
     */
    public ST[] getUB92Locator49National() {
    	ST[] retVal = this.getTypedField(13, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of UB92 locator 49 (national) (UB2-13).
     */
    public ST[] getUb213_UB92Locator49National() {
    	ST[] retVal = this.getTypedField(13, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of UB92 locator 49 (national) (UB2-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUB92Locator49NationalReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * UB2-13: "UB92 locator 49 (national)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUB92Locator49National(int rep) { 
		ST retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-13: "UB92 locator 49 (national)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb213_UB92Locator49National(int rep) { 
		ST retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of UB92 locator 49 (national) (UB2-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb213_UB92Locator49NationalReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * UB2-13: "UB92 locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUB92Locator49National(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-13: "UB92 locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb213_UB92Locator49National(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * UB2-13: "UB92 locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUB92Locator49National(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * UB2-13: "UB92 locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb213_UB92Locator49National(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of UB92 locator 56 (state) (UB2-14).
     */
    public ST[] getUB92Locator56State() {
    	ST[] retVal = this.getTypedField(14, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of UB92 locator 56 (state) (UB2-14).
     */
    public ST[] getUb214_UB92Locator56State() {
    	ST[] retVal = this.getTypedField(14, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of UB92 locator 56 (state) (UB2-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUB92Locator56StateReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * UB2-14: "UB92 locator 56 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUB92Locator56State(int rep) { 
		ST retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-14: "UB92 locator 56 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb214_UB92Locator56State(int rep) { 
		ST retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of UB92 locator 56 (state) (UB2-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb214_UB92Locator56StateReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * UB2-14: "UB92 locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUB92Locator56State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-14: "UB92 locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb214_UB92Locator56State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * UB2-14: "UB92 locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUB92Locator56State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * UB2-14: "UB92 locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb214_UB92Locator56State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * UB2-15: "UB92 locator 57 (national)" - creates it if necessary
     */
    public ST getUB92Locator57National() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-15: "UB92 locator 57 (national)" - creates it if necessary
     */
    public ST getUb215_UB92Locator57National() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of UB92 Locator 78 (state) (UB2-16).
     */
    public ST[] getUB92Locator78State() {
    	ST[] retVal = this.getTypedField(16, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of UB92 Locator 78 (state) (UB2-16).
     */
    public ST[] getUb216_UB92Locator78State() {
    	ST[] retVal = this.getTypedField(16, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of UB92 Locator 78 (state) (UB2-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUB92Locator78StateReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * UB2-16: "UB92 Locator 78 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUB92Locator78State(int rep) { 
		ST retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-16: "UB92 Locator 78 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb216_UB92Locator78State(int rep) { 
		ST retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of UB92 Locator 78 (state) (UB2-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb216_UB92Locator78StateReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * UB2-16: "UB92 Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUB92Locator78State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-16: "UB92 Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb216_UB92Locator78State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB2-16: "UB92 Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUB92Locator78State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB2-16: "UB92 Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb216_UB92Locator78State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(16, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ID(getMessage(), new Integer( 43 ));
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new CM_UVC(getMessage());
          case 6: return new CM_OCD(getMessage());
          case 7: return new CM_OSP(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new ST(getMessage());
          default: return null;
       }
   }


}

