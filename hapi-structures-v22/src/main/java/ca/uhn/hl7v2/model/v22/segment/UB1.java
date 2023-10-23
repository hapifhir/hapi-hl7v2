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
 *<p>Represents an HL7 UB1 message segment (UB82 DATA). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>UB1-1: Set ID - UB82 (SI) <b>optional </b>
     * <li>UB1-2: Blood deductible (43) (NM) <b>optional </b>
     * <li>UB1-3: Blood furnished pints of (40) (NM) <b>optional </b>
     * <li>UB1-4: Blood replaced pints (41) (NM) <b>optional </b>
     * <li>UB1-5: Blood not replaced pints (42) (NM) <b>optional </b>
     * <li>UB1-6: Co-insurance days (25) (NM) <b>optional </b>
     * <li>UB1-7: Condition code (35-39) (ID) <b>optional repeating</b>
     * <li>UB1-8: Covered days (23) (NM) <b>optional </b>
     * <li>UB1-9: Non-covered days (24) (NM) <b>optional </b>
     * <li>UB1-10: Value amount and code (46-49) (CM_UVC) <b>optional repeating</b>
     * <li>UB1-11: Number of grace days (90) (NM) <b>optional </b>
     * <li>UB1-12: Special program indicator (44) (ID) <b>optional </b>
     * <li>UB1-13: PSRO / UR approval indicator (87) (ID) <b>optional </b>
     * <li>UB1-14: PSRO / UR approved stay - from (88) (DT) <b>optional </b>
     * <li>UB1-15: PSRO / UR approved stay - to (89) (DT) <b>optional </b>
     * <li>UB1-16: Occurrence (28-32) (CM_OCD) <b>optional repeating</b>
     * <li>UB1-17: Occurrence span (33) (ID) <b>optional </b>
     * <li>UB1-18: Occurrence span start date (33) (DT) <b>optional </b>
     * <li>UB1-19: Occurrence span end date (33) (DT) <b>optional </b>
     * <li>UB1-20: UB-82 locator 2 (ST) <b>optional </b>
     * <li>UB1-21: UB-82 locator 9 (ST) <b>optional </b>
     * <li>UB1-22: UB-82 locator 27 (ST) <b>optional </b>
     * <li>UB1-23: UB-82 locator 45 (ST) <b>optional </b>
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
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - UB82");
                                  this.add(NM.class, false, 1, 1, new Object[]{ getMessage() }, "Blood deductible (43)");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Blood furnished pints of (40)");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Blood replaced pints (41)");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Blood not replaced pints (42)");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Co-insurance days (25)");
                                              this.add(ID.class, false, 5, 2, new Object[]{ getMessage(), new Integer(43) }, "Condition code (35-39)");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Covered days (23)");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Non-covered days (24)");
                                  this.add(CM_UVC.class, false, 8, 12, new Object[]{ getMessage() }, "Value amount and code (46-49)");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Number of grace days (90)");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "Special program indicator (44)");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "PSRO / UR approval indicator (87)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "PSRO / UR approved stay - from (88)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "PSRO / UR approved stay - to (89)");
                                  this.add(CM_OCD.class, false, 5, 20, new Object[]{ getMessage() }, "Occurrence (28-32)");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "Occurrence span (33)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Occurrence span start date (33)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Occurrence span end date (33)");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "UB-82 locator 2");
                                  this.add(ST.class, false, 1, 7, new Object[]{ getMessage() }, "UB-82 locator 9");
                                  this.add(ST.class, false, 1, 8, new Object[]{ getMessage() }, "UB-82 locator 27");
                                  this.add(ST.class, false, 1, 17, new Object[]{ getMessage() }, "UB-82 locator 45");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating UB1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * UB1-1: "Set ID - UB82" - creates it if necessary
     */
    public SI getSetIDUB82() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-1: "Set ID - UB82" - creates it if necessary
     */
    public SI getUb11_SetIDUB82() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-2: "Blood deductible (43)" - creates it if necessary
     */
    public NM getBloodDeductible() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-2: "Blood deductible (43)" - creates it if necessary
     */
    public NM getUb12_BloodDeductible() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-3: "Blood furnished pints of (40)" - creates it if necessary
     */
    public NM getBloodFurnishedPintsOf() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-3: "Blood furnished pints of (40)" - creates it if necessary
     */
    public NM getUb13_BloodFurnishedPintsOf() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-4: "Blood replaced pints (41)" - creates it if necessary
     */
    public NM getBloodReplacedPints() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-4: "Blood replaced pints (41)" - creates it if necessary
     */
    public NM getUb14_BloodReplacedPints() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-5: "Blood not replaced pints (42)" - creates it if necessary
     */
    public NM getBloodNotReplacedPints() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-5: "Blood not replaced pints (42)" - creates it if necessary
     */
    public NM getUb15_BloodNotReplacedPints() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-6: "Co-insurance days (25)" - creates it if necessary
     */
    public NM getCoInsuranceDays() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-6: "Co-insurance days (25)" - creates it if necessary
     */
    public NM getUb16_CoInsuranceDays() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Condition code (35-39) (UB1-7).
     */
    public ID[] getConditionCode3539() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Condition code (35-39) (UB1-7).
     */
    public ID[] getUb17_ConditionCode3539() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Condition code (35-39) (UB1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getConditionCode3539Reps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * UB1-7: "Condition code (35-39)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getConditionCode3539(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-7: "Condition code (35-39)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUb17_ConditionCode3539(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Condition code (35-39) (UB1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb17_ConditionCode3539Reps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * UB1-7: "Condition code (35-39)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertConditionCode3539(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-7: "Condition code (35-39)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUb17_ConditionCode3539(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB1-7: "Condition code (35-39)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeConditionCode3539(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB1-7: "Condition code (35-39)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUb17_ConditionCode3539(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * UB1-8: "Covered days (23)" - creates it if necessary
     */
    public NM getCoveredDays() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-8: "Covered days (23)" - creates it if necessary
     */
    public NM getUb18_CoveredDays() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-9: "Non-covered days (24)" - creates it if necessary
     */
    public NM getNonCoveredDays() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-9: "Non-covered days (24)" - creates it if necessary
     */
    public NM getUb19_NonCoveredDays() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Value amount and code (46-49) (UB1-10).
     */
    public CM_UVC[] getValueAmountAndCode4649() {
    	CM_UVC[] retVal = this.getTypedField(10, new CM_UVC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Value amount and code (46-49) (UB1-10).
     */
    public CM_UVC[] getUb110_ValueAmountAndCode4649() {
    	CM_UVC[] retVal = this.getTypedField(10, new CM_UVC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Value amount and code (46-49) (UB1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValueAmountAndCode4649Reps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * UB1-10: "Value amount and code (46-49)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_UVC getValueAmountAndCode4649(int rep) { 
		CM_UVC retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-10: "Value amount and code (46-49)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_UVC getUb110_ValueAmountAndCode4649(int rep) { 
		CM_UVC retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Value amount and code (46-49) (UB1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb110_ValueAmountAndCode4649Reps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * UB1-10: "Value amount and code (46-49)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC insertValueAmountAndCode4649(int rep) throws HL7Exception { 
        return (CM_UVC) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-10: "Value amount and code (46-49)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC insertUb110_ValueAmountAndCode4649(int rep) throws HL7Exception { 
        return (CM_UVC) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB1-10: "Value amount and code (46-49)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC removeValueAmountAndCode4649(int rep) throws HL7Exception { 
        return (CM_UVC) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB1-10: "Value amount and code (46-49)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_UVC removeUb110_ValueAmountAndCode4649(int rep) throws HL7Exception { 
        return (CM_UVC) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * UB1-11: "Number of grace days (90)" - creates it if necessary
     */
    public NM getNumberOfGraceDays() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-11: "Number of grace days (90)" - creates it if necessary
     */
    public NM getUb111_NumberOfGraceDays() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-12: "Special program indicator (44)" - creates it if necessary
     */
    public ID getSpecialProgramIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-12: "Special program indicator (44)" - creates it if necessary
     */
    public ID getUb112_SpecialProgramIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-13: "PSRO / UR approval indicator (87)" - creates it if necessary
     */
    public ID getPSROURApprovalIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-13: "PSRO / UR approval indicator (87)" - creates it if necessary
     */
    public ID getUb113_PSROURApprovalIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-14: "PSRO / UR approved stay - from (88)" - creates it if necessary
     */
    public DT getPSROURApprovedStayFrom() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-14: "PSRO / UR approved stay - from (88)" - creates it if necessary
     */
    public DT getUb114_PSROURApprovedStayFrom() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-15: "PSRO / UR approved stay - to (89)" - creates it if necessary
     */
    public DT getPSROURApprovedStayTo() { 
		DT retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-15: "PSRO / UR approved stay - to (89)" - creates it if necessary
     */
    public DT getUb115_PSROURApprovedStayTo() { 
		DT retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Occurrence (28-32) (UB1-16).
     */
    public CM_OCD[] getOccurrence2832() {
    	CM_OCD[] retVal = this.getTypedField(16, new CM_OCD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Occurrence (28-32) (UB1-16).
     */
    public CM_OCD[] getUb116_Occurrence2832() {
    	CM_OCD[] retVal = this.getTypedField(16, new CM_OCD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Occurrence (28-32) (UB1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOccurrence2832Reps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * UB1-16: "Occurrence (28-32)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_OCD getOccurrence2832(int rep) { 
		CM_OCD retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-16: "Occurrence (28-32)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_OCD getUb116_Occurrence2832(int rep) { 
		CM_OCD retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Occurrence (28-32) (UB1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb116_Occurrence2832Reps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * UB1-16: "Occurrence (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD insertOccurrence2832(int rep) throws HL7Exception { 
        return (CM_OCD) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-16: "Occurrence (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD insertUb116_Occurrence2832(int rep) throws HL7Exception { 
        return (CM_OCD) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB1-16: "Occurrence (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD removeOccurrence2832(int rep) throws HL7Exception { 
        return (CM_OCD) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB1-16: "Occurrence (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_OCD removeUb116_Occurrence2832(int rep) throws HL7Exception { 
        return (CM_OCD) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * UB1-17: "Occurrence span (33)" - creates it if necessary
     */
    public ID getOccurrenceSpan() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-17: "Occurrence span (33)" - creates it if necessary
     */
    public ID getUb117_OccurrenceSpan() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-18: "Occurrence span start date (33)" - creates it if necessary
     */
    public DT getOccurrenceSpanStartDate() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-18: "Occurrence span start date (33)" - creates it if necessary
     */
    public DT getUb118_OccurrenceSpanStartDate() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-19: "Occurrence span end date (33)" - creates it if necessary
     */
    public DT getOccurrenceSpanEndDate() { 
		DT retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-19: "Occurrence span end date (33)" - creates it if necessary
     */
    public DT getUb119_OccurrenceSpanEndDate() { 
		DT retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-20: "UB-82 locator 2" - creates it if necessary
     */
    public ST getUB82Locator2() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-20: "UB-82 locator 2" - creates it if necessary
     */
    public ST getUb120_UB82Locator2() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-21: "UB-82 locator 9" - creates it if necessary
     */
    public ST getUB82Locator9() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-21: "UB-82 locator 9" - creates it if necessary
     */
    public ST getUb121_UB82Locator9() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-22: "UB-82 locator 27" - creates it if necessary
     */
    public ST getUB82Locator27() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-22: "UB-82 locator 27" - creates it if necessary
     */
    public ST getUb122_UB82Locator27() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-23: "UB-82 locator 45" - creates it if necessary
     */
    public ST getUB82Locator45() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-23: "UB-82 locator 45" - creates it if necessary
     */
    public ST getUb123_UB82Locator45() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new ID(getMessage(), new Integer( 43 ));
          case 7: return new NM(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new CM_UVC(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new ID(getMessage(), new Integer( 0 ));
          case 12: return new ID(getMessage(), new Integer( 0 ));
          case 13: return new DT(getMessage());
          case 14: return new DT(getMessage());
          case 15: return new CM_OCD(getMessage());
          case 16: return new ID(getMessage(), new Integer( 0 ));
          case 17: return new DT(getMessage());
          case 18: return new DT(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new ST(getMessage());
          case 22: return new ST(getMessage());
          default: return null;
       }
   }


}

