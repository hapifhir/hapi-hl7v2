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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 UB2 message segment (Uniform Billing Data). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>UB2-1: Set ID - UB2 (SI) <b>optional </b>
     * <li>UB2-2: Co-Insurance Days (9) (ST) <b>optional </b>
     * <li>UB2-3: Condition Code (24-30) (CWE) <b>optional repeating</b>
     * <li>UB2-4: Covered Days (7) (ST) <b>optional </b>
     * <li>UB2-5: Non-Covered Days (8) (ST) <b>optional </b>
     * <li>UB2-6: Value Amount & Code (39-41) (UVC) <b>optional repeating</b>
     * <li>UB2-7: Occurrence Code & Date (32-35) (OCD) <b>optional repeating</b>
     * <li>UB2-8: Occurrence Span Code/Dates (36) (OSP) <b>optional repeating</b>
     * <li>UB2-9: Uniform Billing Locator 2 (state) (ST) <b>optional repeating</b>
     * <li>UB2-10: Uniform Billing Locator 11 (state) (ST) <b>optional repeating</b>
     * <li>UB2-11: Uniform Billing Locator 31 (national) (ST) <b>optional </b>
     * <li>UB2-12: Document Control Number (ST) <b>optional repeating</b>
     * <li>UB2-13: Uniform Billing Locator 49 (national) (ST) <b>optional repeating</b>
     * <li>UB2-14: Uniform Billing Locator 56 (state) (ST) <b>optional repeating</b>
     * <li>UB2-15: Uniform Billing Locator 57 (sational) (ST) <b>optional </b>
     * <li>UB2-16: Uniform Billing Locator 78 (state) (ST) <b>optional repeating</b>
     * <li>UB2-17: Special Visit Count (NM) <b>optional </b>
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
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - UB2");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Co-Insurance Days (9)");
                                  this.add(CWE.class, false, 7, 0, new Object[]{ getMessage() }, "Condition Code (24-30)");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Covered Days (7)");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Non-Covered Days (8)");
                                  this.add(UVC.class, false, 12, 0, new Object[]{ getMessage() }, "Value Amount & Code (39-41)");
                                  this.add(OCD.class, false, 8, 0, new Object[]{ getMessage() }, "Occurrence Code & Date (32-35)");
                                  this.add(OSP.class, false, 2, 0, new Object[]{ getMessage() }, "Occurrence Span Code/Dates (36)");
                                  this.add(ST.class, false, 2, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 2 (state)");
                                  this.add(ST.class, false, 2, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 11 (state)");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 31 (national)");
                                  this.add(ST.class, false, 3, 0, new Object[]{ getMessage() }, "Document Control Number");
                                  this.add(ST.class, false, 23, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 49 (national)");
                                  this.add(ST.class, false, 5, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 56 (state)");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 57 (sational)");
                                  this.add(ST.class, false, 2, 0, new Object[]{ getMessage() }, "Uniform Billing Locator 78 (state)");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Special Visit Count");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating UB2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * UB2-1: "Set ID - UB2" - creates it if necessary
     */
    public SI getSetIDUB2() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-1: "Set ID - UB2" - creates it if necessary
     */
    public SI getUb21_SetIDUB2() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * UB2-2: "Co-Insurance Days (9)" - creates it if necessary
     */
    public ST getCoInsuranceDays9() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-2: "Co-Insurance Days (9)" - creates it if necessary
     */
    public ST getUb22_CoInsuranceDays9() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Condition Code (24-30) (UB2-3).
     */
    public CWE[] getConditionCode2430() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Condition Code (24-30) (UB2-3).
     */
    public CWE[] getUb23_ConditionCode2430() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Condition Code (24-30) (UB2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getConditionCode2430Reps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * UB2-3: "Condition Code (24-30)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getConditionCode2430(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-3: "Condition Code (24-30)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getUb23_ConditionCode2430(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Condition Code (24-30) (UB2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb23_ConditionCode2430Reps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * UB2-3: "Condition Code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertConditionCode2430(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-3: "Condition Code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertUb23_ConditionCode2430(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * UB2-3: "Condition Code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeConditionCode2430(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * UB2-3: "Condition Code (24-30)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeUb23_ConditionCode2430(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * UB2-4: "Covered Days (7)" - creates it if necessary
     */
    public ST getCoveredDays7() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-4: "Covered Days (7)" - creates it if necessary
     */
    public ST getUb24_CoveredDays7() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * UB2-5: "Non-Covered Days (8)" - creates it if necessary
     */
    public ST getNonCoveredDays8() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-5: "Non-Covered Days (8)" - creates it if necessary
     */
    public ST getUb25_NonCoveredDays8() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Value Amount & Code (39-41) (UB2-6).
     */
    public UVC[] getValueAmountCode3941() {
    	UVC[] retVal = this.getTypedField(6, new UVC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Value Amount & Code (39-41) (UB2-6).
     */
    public UVC[] getUb26_ValueAmountCode3941() {
    	UVC[] retVal = this.getTypedField(6, new UVC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Value Amount & Code (39-41) (UB2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValueAmountCode3941Reps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * UB2-6: "Value Amount & Code (39-41)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public UVC getValueAmountCode3941(int rep) { 
		UVC retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-6: "Value Amount & Code (39-41)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public UVC getUb26_ValueAmountCode3941(int rep) { 
		UVC retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Value Amount & Code (39-41) (UB2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb26_ValueAmountCode3941Reps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * UB2-6: "Value Amount & Code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public UVC insertValueAmountCode3941(int rep) throws HL7Exception { 
        return (UVC) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-6: "Value Amount & Code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public UVC insertUb26_ValueAmountCode3941(int rep) throws HL7Exception { 
        return (UVC) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * UB2-6: "Value Amount & Code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public UVC removeValueAmountCode3941(int rep) throws HL7Exception { 
        return (UVC) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * UB2-6: "Value Amount & Code (39-41)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public UVC removeUb26_ValueAmountCode3941(int rep) throws HL7Exception { 
        return (UVC) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Occurrence Code & Date (32-35) (UB2-7).
     */
    public OCD[] getOccurrenceCodeDate3235() {
    	OCD[] retVal = this.getTypedField(7, new OCD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Occurrence Code & Date (32-35) (UB2-7).
     */
    public OCD[] getUb27_OccurrenceCodeDate3235() {
    	OCD[] retVal = this.getTypedField(7, new OCD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Occurrence Code & Date (32-35) (UB2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOccurrenceCodeDate3235Reps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * UB2-7: "Occurrence Code & Date (32-35)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public OCD getOccurrenceCodeDate3235(int rep) { 
		OCD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-7: "Occurrence Code & Date (32-35)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public OCD getUb27_OccurrenceCodeDate3235(int rep) { 
		OCD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Occurrence Code & Date (32-35) (UB2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb27_OccurrenceCodeDate3235Reps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * UB2-7: "Occurrence Code & Date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OCD insertOccurrenceCodeDate3235(int rep) throws HL7Exception { 
        return (OCD) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-7: "Occurrence Code & Date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OCD insertUb27_OccurrenceCodeDate3235(int rep) throws HL7Exception { 
        return (OCD) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB2-7: "Occurrence Code & Date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OCD removeOccurrenceCodeDate3235(int rep) throws HL7Exception { 
        return (OCD) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB2-7: "Occurrence Code & Date (32-35)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OCD removeUb27_OccurrenceCodeDate3235(int rep) throws HL7Exception { 
        return (OCD) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Occurrence Span Code/Dates (36) (UB2-8).
     */
    public OSP[] getOccurrenceSpanCodeDates() {
    	OSP[] retVal = this.getTypedField(8, new OSP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Occurrence Span Code/Dates (36) (UB2-8).
     */
    public OSP[] getUb28_OccurrenceSpanCodeDates() {
    	OSP[] retVal = this.getTypedField(8, new OSP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Occurrence Span Code/Dates (36) (UB2-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOccurrenceSpanCodeDatesReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * UB2-8: "Occurrence Span Code/Dates (36)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public OSP getOccurrenceSpanCodeDates(int rep) { 
		OSP retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-8: "Occurrence Span Code/Dates (36)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public OSP getUb28_OccurrenceSpanCodeDates(int rep) { 
		OSP retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Occurrence Span Code/Dates (36) (UB2-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb28_OccurrenceSpanCodeDatesReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * UB2-8: "Occurrence Span Code/Dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OSP insertOccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (OSP) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-8: "Occurrence Span Code/Dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OSP insertUb28_OccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (OSP) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * UB2-8: "Occurrence Span Code/Dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OSP removeOccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (OSP) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * UB2-8: "Occurrence Span Code/Dates (36)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public OSP removeUb28_OccurrenceSpanCodeDates(int rep) throws HL7Exception { 
        return (OSP) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of Uniform Billing Locator 2 (state) (UB2-9).
     */
    public ST[] getUniformBillingLocator2State() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Uniform Billing Locator 2 (state) (UB2-9).
     */
    public ST[] getUb29_UniformBillingLocator2State() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 2 (state) (UB2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUniformBillingLocator2StateReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * UB2-9: "Uniform Billing Locator 2 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUniformBillingLocator2State(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-9: "Uniform Billing Locator 2 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb29_UniformBillingLocator2State(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 2 (state) (UB2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb29_UniformBillingLocator2StateReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * UB2-9: "Uniform Billing Locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUniformBillingLocator2State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-9: "Uniform Billing Locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb29_UniformBillingLocator2State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * UB2-9: "Uniform Billing Locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUniformBillingLocator2State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * UB2-9: "Uniform Billing Locator 2 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb29_UniformBillingLocator2State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Uniform Billing Locator 11 (state) (UB2-10).
     */
    public ST[] getUniformBillingLocator11State() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Uniform Billing Locator 11 (state) (UB2-10).
     */
    public ST[] getUb210_UniformBillingLocator11State() {
    	ST[] retVal = this.getTypedField(10, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 11 (state) (UB2-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUniformBillingLocator11StateReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * UB2-10: "Uniform Billing Locator 11 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUniformBillingLocator11State(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-10: "Uniform Billing Locator 11 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb210_UniformBillingLocator11State(int rep) { 
		ST retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 11 (state) (UB2-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb210_UniformBillingLocator11StateReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * UB2-10: "Uniform Billing Locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUniformBillingLocator11State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-10: "Uniform Billing Locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb210_UniformBillingLocator11State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB2-10: "Uniform Billing Locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUniformBillingLocator11State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB2-10: "Uniform Billing Locator 11 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb210_UniformBillingLocator11State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * UB2-11: "Uniform Billing Locator 31 (national)" - creates it if necessary
     */
    public ST getUniformBillingLocator31National() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-11: "Uniform Billing Locator 31 (national)" - creates it if necessary
     */
    public ST getUb211_UniformBillingLocator31National() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Document Control Number (UB2-12).
     */
    public ST[] getDocumentControlNumber() {
    	ST[] retVal = this.getTypedField(12, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Document Control Number (UB2-12).
     */
    public ST[] getUb212_DocumentControlNumber() {
    	ST[] retVal = this.getTypedField(12, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Document Control Number (UB2-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDocumentControlNumberReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * UB2-12: "Document Control Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getDocumentControlNumber(int rep) { 
		ST retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-12: "Document Control Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb212_DocumentControlNumber(int rep) { 
		ST retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Document Control Number (UB2-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb212_DocumentControlNumberReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * UB2-12: "Document Control Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertDocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-12: "Document Control Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb212_DocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * UB2-12: "Document Control Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeDocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * UB2-12: "Document Control Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb212_DocumentControlNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(12, rep);
    }



    /**
     * Returns all repetitions of Uniform Billing Locator 49 (national) (UB2-13).
     */
    public ST[] getUniformBillingLocator49National() {
    	ST[] retVal = this.getTypedField(13, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Uniform Billing Locator 49 (national) (UB2-13).
     */
    public ST[] getUb213_UniformBillingLocator49National() {
    	ST[] retVal = this.getTypedField(13, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 49 (national) (UB2-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUniformBillingLocator49NationalReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * UB2-13: "Uniform Billing Locator 49 (national)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUniformBillingLocator49National(int rep) { 
		ST retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-13: "Uniform Billing Locator 49 (national)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb213_UniformBillingLocator49National(int rep) { 
		ST retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 49 (national) (UB2-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb213_UniformBillingLocator49NationalReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * UB2-13: "Uniform Billing Locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUniformBillingLocator49National(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-13: "Uniform Billing Locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb213_UniformBillingLocator49National(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * UB2-13: "Uniform Billing Locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUniformBillingLocator49National(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * UB2-13: "Uniform Billing Locator 49 (national)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb213_UniformBillingLocator49National(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Uniform Billing Locator 56 (state) (UB2-14).
     */
    public ST[] getUniformBillingLocator56State() {
    	ST[] retVal = this.getTypedField(14, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Uniform Billing Locator 56 (state) (UB2-14).
     */
    public ST[] getUb214_UniformBillingLocator56State() {
    	ST[] retVal = this.getTypedField(14, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 56 (state) (UB2-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUniformBillingLocator56StateReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * UB2-14: "Uniform Billing Locator 56 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUniformBillingLocator56State(int rep) { 
		ST retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-14: "Uniform Billing Locator 56 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb214_UniformBillingLocator56State(int rep) { 
		ST retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 56 (state) (UB2-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb214_UniformBillingLocator56StateReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * UB2-14: "Uniform Billing Locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUniformBillingLocator56State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-14: "Uniform Billing Locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb214_UniformBillingLocator56State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * UB2-14: "Uniform Billing Locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUniformBillingLocator56State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * UB2-14: "Uniform Billing Locator 56 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb214_UniformBillingLocator56State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * UB2-15: "Uniform Billing Locator 57 (sational)" - creates it if necessary
     */
    public ST getUniformBillingLocator57Sational() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-15: "Uniform Billing Locator 57 (sational)" - creates it if necessary
     */
    public ST getUb215_UniformBillingLocator57Sational() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Uniform Billing Locator 78 (state) (UB2-16).
     */
    public ST[] getUniformBillingLocator78State() {
    	ST[] retVal = this.getTypedField(16, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Uniform Billing Locator 78 (state) (UB2-16).
     */
    public ST[] getUb216_UniformBillingLocator78State() {
    	ST[] retVal = this.getTypedField(16, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 78 (state) (UB2-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUniformBillingLocator78StateReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * UB2-16: "Uniform Billing Locator 78 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUniformBillingLocator78State(int rep) { 
		ST retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB2-16: "Uniform Billing Locator 78 (state)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUb216_UniformBillingLocator78State(int rep) { 
		ST retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Uniform Billing Locator 78 (state) (UB2-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb216_UniformBillingLocator78StateReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * UB2-16: "Uniform Billing Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUniformBillingLocator78State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * UB2-16: "Uniform Billing Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUb216_UniformBillingLocator78State(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB2-16: "Uniform Billing Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUniformBillingLocator78State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB2-16: "Uniform Billing Locator 78 (state)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUb216_UniformBillingLocator78State(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * UB2-17: "Special Visit Count" - creates it if necessary
     */
    public NM getSpecialVisitCount() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB2-17: "Special Visit Count" - creates it if necessary
     */
    public NM getUb217_SpecialVisitCount() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new UVC(getMessage());
          case 6: return new OCD(getMessage());
          case 7: return new OSP(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new ST(getMessage());
          case 16: return new NM(getMessage());
          default: return null;
       }
   }


}

