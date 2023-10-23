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
 *<p>Represents an HL7 UB1 message segment (). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>UB1-1: Set ID - UB1 (SI) <b>optional </b>
     * <li>UB1-2: Blood Deductible (NULLDT) <b>optional </b>
     * <li>UB1-3: Blood Furnished-Pints (NULLDT) <b>optional </b>
     * <li>UB1-4: Blood Replaced-Pints (NULLDT) <b>optional </b>
     * <li>UB1-5: Blood Not Replaced-Pints (NULLDT) <b>optional </b>
     * <li>UB1-6: Co-Insurance Days (NULLDT) <b>optional </b>
     * <li>UB1-7: Condition Code (NULLDT) <b>optional repeating</b>
     * <li>UB1-8: Covered Days (NULLDT) <b>optional </b>
     * <li>UB1-9: Non Covered Days (NULLDT) <b>optional </b>
     * <li>UB1-10: Value Amount & Code (NULLDT) <b>optional repeating</b>
     * <li>UB1-11: Number Of Grace Days (NULLDT) <b>optional </b>
     * <li>UB1-12: Special Program Indicator (NULLDT) <b>optional </b>
     * <li>UB1-13: PSRO/UR Approval Indicator (NULLDT) <b>optional </b>
     * <li>UB1-14: PSRO/UR Approved Stay-Fm (NULLDT) <b>optional </b>
     * <li>UB1-15: PSRO/UR Approved Stay-To (NULLDT) <b>optional </b>
     * <li>UB1-16: Occurrence (NULLDT) <b>optional repeating</b>
     * <li>UB1-17: Occurrence Span (NULLDT) <b>optional </b>
     * <li>UB1-18: Occur Span Start Date (NULLDT) <b>optional </b>
     * <li>UB1-19: Occur Span End Date (NULLDT) <b>optional </b>
     * <li>UB1-20: UB-82 Locator 2 (NULLDT) <b>optional </b>
     * <li>UB1-21: UB-82 Locator 9 (NULLDT) <b>optional </b>
     * <li>UB1-22: UB-82 Locator 27 (NULLDT) <b>optional </b>
     * <li>UB1-23: UB-82 Locator 45 (NULLDT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class UB1 extends AbstractSegment {

    /** 
     * Creates a new UB1 segment
     */
    public UB1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - UB1");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Blood Deductible");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Blood Furnished-Pints");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Blood Replaced-Pints");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Blood Not Replaced-Pints");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Co-Insurance Days");
                                  this.add(NULLDT.class, false, 5, 0, new Object[]{ getMessage() }, "Condition Code");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Covered Days");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Non Covered Days");
                                  this.add(NULLDT.class, false, 8, 0, new Object[]{ getMessage() }, "Value Amount & Code");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Number Of Grace Days");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Special Program Indicator");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "PSRO/UR Approval Indicator");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "PSRO/UR Approved Stay-Fm");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "PSRO/UR Approved Stay-To");
                                  this.add(NULLDT.class, false, 5, 0, new Object[]{ getMessage() }, "Occurrence");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Occurrence Span");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Occur Span Start Date");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Occur Span End Date");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "UB-82 Locator 2");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "UB-82 Locator 9");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "UB-82 Locator 27");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "UB-82 Locator 45");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating UB1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * UB1-1: "Set ID - UB1" - creates it if necessary
     */
    public SI getSetIDUB1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-1: "Set ID - UB1" - creates it if necessary
     */
    public SI getUb11_SetIDUB1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-2: "Blood Deductible" - creates it if necessary
     */
    public NULLDT getBloodDeductible() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-2: "Blood Deductible" - creates it if necessary
     */
    public NULLDT getUb12_BloodDeductible() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-3: "Blood Furnished-Pints" - creates it if necessary
     */
    public NULLDT getBloodFurnishedPints() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-3: "Blood Furnished-Pints" - creates it if necessary
     */
    public NULLDT getUb13_BloodFurnishedPints() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-4: "Blood Replaced-Pints" - creates it if necessary
     */
    public NULLDT getBloodReplacedPints() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-4: "Blood Replaced-Pints" - creates it if necessary
     */
    public NULLDT getUb14_BloodReplacedPints() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-5: "Blood Not Replaced-Pints" - creates it if necessary
     */
    public NULLDT getBloodNotReplacedPints() { 
		NULLDT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-5: "Blood Not Replaced-Pints" - creates it if necessary
     */
    public NULLDT getUb15_BloodNotReplacedPints() { 
		NULLDT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-6: "Co-Insurance Days" - creates it if necessary
     */
    public NULLDT getCoInsuranceDays() { 
		NULLDT retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-6: "Co-Insurance Days" - creates it if necessary
     */
    public NULLDT getUb16_CoInsuranceDays() { 
		NULLDT retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Condition Code (UB1-7).
     */
    public NULLDT[] getConditionCode() {
    	NULLDT[] retVal = this.getTypedField(7, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Condition Code (UB1-7).
     */
    public NULLDT[] getUb17_ConditionCode() {
    	NULLDT[] retVal = this.getTypedField(7, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Condition Code (UB1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getConditionCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * UB1-7: "Condition Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getConditionCode(int rep) { 
		NULLDT retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-7: "Condition Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getUb17_ConditionCode(int rep) { 
		NULLDT retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Condition Code (UB1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb17_ConditionCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * UB1-7: "Condition Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertConditionCode(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-7: "Condition Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertUb17_ConditionCode(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB1-7: "Condition Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeConditionCode(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB1-7: "Condition Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeUb17_ConditionCode(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * UB1-8: "Covered Days" - creates it if necessary
     */
    public NULLDT getCoveredDays() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-8: "Covered Days" - creates it if necessary
     */
    public NULLDT getUb18_CoveredDays() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-9: "Non Covered Days" - creates it if necessary
     */
    public NULLDT getNonCoveredDays() { 
		NULLDT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-9: "Non Covered Days" - creates it if necessary
     */
    public NULLDT getUb19_NonCoveredDays() { 
		NULLDT retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Value Amount & Code (UB1-10).
     */
    public NULLDT[] getValueAmountCode() {
    	NULLDT[] retVal = this.getTypedField(10, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Value Amount & Code (UB1-10).
     */
    public NULLDT[] getUb110_ValueAmountCode() {
    	NULLDT[] retVal = this.getTypedField(10, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Value Amount & Code (UB1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValueAmountCodeReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * UB1-10: "Value Amount & Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getValueAmountCode(int rep) { 
		NULLDT retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-10: "Value Amount & Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getUb110_ValueAmountCode(int rep) { 
		NULLDT retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Value Amount & Code (UB1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb110_ValueAmountCodeReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * UB1-10: "Value Amount & Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertValueAmountCode(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-10: "Value Amount & Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertUb110_ValueAmountCode(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB1-10: "Value Amount & Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeValueAmountCode(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB1-10: "Value Amount & Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeUb110_ValueAmountCode(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * UB1-11: "Number Of Grace Days" - creates it if necessary
     */
    public NULLDT getNumberOfGraceDays() { 
		NULLDT retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-11: "Number Of Grace Days" - creates it if necessary
     */
    public NULLDT getUb111_NumberOfGraceDays() { 
		NULLDT retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-12: "Special Program Indicator" - creates it if necessary
     */
    public NULLDT getSpecialProgramIndicator() { 
		NULLDT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-12: "Special Program Indicator" - creates it if necessary
     */
    public NULLDT getUb112_SpecialProgramIndicator() { 
		NULLDT retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-13: "PSRO/UR Approval Indicator" - creates it if necessary
     */
    public NULLDT getPSROURApprovalIndicator() { 
		NULLDT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-13: "PSRO/UR Approval Indicator" - creates it if necessary
     */
    public NULLDT getUb113_PSROURApprovalIndicator() { 
		NULLDT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-14: "PSRO/UR Approved Stay-Fm" - creates it if necessary
     */
    public NULLDT getPSROURApprovedStayFm() { 
		NULLDT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-14: "PSRO/UR Approved Stay-Fm" - creates it if necessary
     */
    public NULLDT getUb114_PSROURApprovedStayFm() { 
		NULLDT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-15: "PSRO/UR Approved Stay-To" - creates it if necessary
     */
    public NULLDT getPSROURApprovedStayTo() { 
		NULLDT retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-15: "PSRO/UR Approved Stay-To" - creates it if necessary
     */
    public NULLDT getUb115_PSROURApprovedStayTo() { 
		NULLDT retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Occurrence (UB1-16).
     */
    public NULLDT[] getOccurrence() {
    	NULLDT[] retVal = this.getTypedField(16, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Occurrence (UB1-16).
     */
    public NULLDT[] getUb116_Occurrence() {
    	NULLDT[] retVal = this.getTypedField(16, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Occurrence (UB1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOccurrenceReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * UB1-16: "Occurrence" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getOccurrence(int rep) { 
		NULLDT retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-16: "Occurrence" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getUb116_Occurrence(int rep) { 
		NULLDT retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Occurrence (UB1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb116_OccurrenceReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * UB1-16: "Occurrence" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertOccurrence(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-16: "Occurrence" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertUb116_Occurrence(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB1-16: "Occurrence" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeOccurrence(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB1-16: "Occurrence" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeUb116_Occurrence(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * UB1-17: "Occurrence Span" - creates it if necessary
     */
    public NULLDT getOccurrenceSpan() { 
		NULLDT retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-17: "Occurrence Span" - creates it if necessary
     */
    public NULLDT getUb117_OccurrenceSpan() { 
		NULLDT retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-18: "Occur Span Start Date" - creates it if necessary
     */
    public NULLDT getOccurSpanStartDate() { 
		NULLDT retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-18: "Occur Span Start Date" - creates it if necessary
     */
    public NULLDT getUb118_OccurSpanStartDate() { 
		NULLDT retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-19: "Occur Span End Date" - creates it if necessary
     */
    public NULLDT getOccurSpanEndDate() { 
		NULLDT retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-19: "Occur Span End Date" - creates it if necessary
     */
    public NULLDT getUb119_OccurSpanEndDate() { 
		NULLDT retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-20: "UB-82 Locator 2" - creates it if necessary
     */
    public NULLDT getUB82Locator2() { 
		NULLDT retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-20: "UB-82 Locator 2" - creates it if necessary
     */
    public NULLDT getUb120_UB82Locator2() { 
		NULLDT retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-21: "UB-82 Locator 9" - creates it if necessary
     */
    public NULLDT getUB82Locator9() { 
		NULLDT retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-21: "UB-82 Locator 9" - creates it if necessary
     */
    public NULLDT getUb121_UB82Locator9() { 
		NULLDT retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-22: "UB-82 Locator 27" - creates it if necessary
     */
    public NULLDT getUB82Locator27() { 
		NULLDT retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-22: "UB-82 Locator 27" - creates it if necessary
     */
    public NULLDT getUb122_UB82Locator27() { 
		NULLDT retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-23: "UB-82 Locator 45" - creates it if necessary
     */
    public NULLDT getUB82Locator45() { 
		NULLDT retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-23: "UB-82 Locator 45" - creates it if necessary
     */
    public NULLDT getUb123_UB82Locator45() { 
		NULLDT retVal = this.getTypedField(23, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new NULLDT(getMessage());
          case 2: return new NULLDT(getMessage());
          case 3: return new NULLDT(getMessage());
          case 4: return new NULLDT(getMessage());
          case 5: return new NULLDT(getMessage());
          case 6: return new NULLDT(getMessage());
          case 7: return new NULLDT(getMessage());
          case 8: return new NULLDT(getMessage());
          case 9: return new NULLDT(getMessage());
          case 10: return new NULLDT(getMessage());
          case 11: return new NULLDT(getMessage());
          case 12: return new NULLDT(getMessage());
          case 13: return new NULLDT(getMessage());
          case 14: return new NULLDT(getMessage());
          case 15: return new NULLDT(getMessage());
          case 16: return new NULLDT(getMessage());
          case 17: return new NULLDT(getMessage());
          case 18: return new NULLDT(getMessage());
          case 19: return new NULLDT(getMessage());
          case 20: return new NULLDT(getMessage());
          case 21: return new NULLDT(getMessage());
          case 22: return new NULLDT(getMessage());
          default: return null;
       }
   }


}

