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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 FT1 message segment (Financial Transaction). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FT1-1: Set ID - FT1 (SI) <b>optional </b>
     * <li>FT1-2: Transaction ID (ST) <b>optional </b>
     * <li>FT1-3: Transaction Batch ID (ST) <b>optional </b>
     * <li>FT1-4: Transaction Date (DR) <b> </b>
     * <li>FT1-5: Transaction Posting Date (DTM) <b>optional </b>
     * <li>FT1-6: Transaction Type (IS) <b> </b>
     * <li>FT1-7: Transaction Code (CWE) <b> </b>
     * <li>FT1-8: Transaction Description (NULLDT) <b>optional </b>
     * <li>FT1-9: Transaction Description - Alt (NULLDT) <b>optional </b>
     * <li>FT1-10: Transaction Quantity (NM) <b>optional </b>
     * <li>FT1-11: Transaction Amount - Extended (CP) <b>optional </b>
     * <li>FT1-12: Transaction amount - unit (CP) <b>optional </b>
     * <li>FT1-13: Department Code (CWE) <b>optional </b>
     * <li>FT1-14: Insurance Plan ID (CWE) <b>optional </b>
     * <li>FT1-15: Insurance Amount (CP) <b>optional </b>
     * <li>FT1-16: Assigned Patient Location (PL) <b>optional </b>
     * <li>FT1-17: Fee Schedule (IS) <b>optional </b>
     * <li>FT1-18: Patient Type (IS) <b>optional </b>
     * <li>FT1-19: Diagnosis Code - FT1 (CWE) <b>optional repeating</b>
     * <li>FT1-20: Performed By Code (XCN) <b>optional repeating</b>
     * <li>FT1-21: Ordered By Code (XCN) <b>optional repeating</b>
     * <li>FT1-22: Unit Cost (CP) <b>optional </b>
     * <li>FT1-23: Filler Order Number (EI) <b>optional </b>
     * <li>FT1-24: Entered By Code (XCN) <b>optional repeating</b>
     * <li>FT1-25: Procedure Code (CNE) <b>optional </b>
     * <li>FT1-26: Procedure Code Modifier (CNE) <b>optional repeating</b>
     * <li>FT1-27: Advanced Beneficiary Notice Code (CWE) <b>optional </b>
     * <li>FT1-28: Medically Necessary Duplicate Procedure Reason (CWE) <b>optional </b>
     * <li>FT1-29: NDC Code (CWE) <b>optional </b>
     * <li>FT1-30: Payment Reference ID (CX) <b>optional </b>
     * <li>FT1-31: Transaction Reference Key (SI) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class FT1 extends AbstractSegment {

    /** 
     * Creates a new FT1 segment
     */
    public FT1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - FT1");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction ID");
                                  this.add(ST.class, false, 1, 10, new Object[]{ getMessage() }, "Transaction Batch ID");
                                  this.add(DR.class, true, 1, 53, new Object[]{ getMessage() }, "Transaction Date");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Transaction Posting Date");
                                              this.add(IS.class, true, 1, 8, new Object[]{ getMessage(), new Integer(17) }, "Transaction Type");
                                  this.add(CWE.class, true, 1, 250, new Object[]{ getMessage() }, "Transaction Code");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction Description");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction Description - Alt");
                                  this.add(NM.class, false, 1, 6, new Object[]{ getMessage() }, "Transaction Quantity");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction Amount - Extended");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction amount - unit");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Department Code");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Insurance Plan ID");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Insurance Amount");
                                  this.add(PL.class, false, 1, 80, new Object[]{ getMessage() }, "Assigned Patient Location");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(24) }, "Fee Schedule");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(18) }, "Patient Type");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Diagnosis Code - FT1");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Performed By Code");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Ordered By Code");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Unit Cost");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Entered By Code");
                                  this.add(CNE.class, false, 1, 705, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(CNE.class, false, 0, 705, new Object[]{ getMessage() }, "Procedure Code Modifier");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Advanced Beneficiary Notice Code");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Medically Necessary Duplicate Procedure Reason");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "NDC Code");
                                  this.add(CX.class, false, 1, 250, new Object[]{ getMessage() }, "Payment Reference ID");
                                  this.add(SI.class, false, 0, 4, new Object[]{ getMessage() }, "Transaction Reference Key");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FT1-1: "Set ID - FT1" - creates it if necessary
     */
    public SI getSetIDFT1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-1: "Set ID - FT1" - creates it if necessary
     */
    public SI getFt11_SetIDFT1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-2: "Transaction ID" - creates it if necessary
     */
    public ST getTransactionID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-2: "Transaction ID" - creates it if necessary
     */
    public ST getFt12_TransactionID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-3: "Transaction Batch ID" - creates it if necessary
     */
    public ST getTransactionBatchID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-3: "Transaction Batch ID" - creates it if necessary
     */
    public ST getFt13_TransactionBatchID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-4: "Transaction Date" - creates it if necessary
     */
    public DR getTransactionDate() { 
		DR retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-4: "Transaction Date" - creates it if necessary
     */
    public DR getFt14_TransactionDate() { 
		DR retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-5: "Transaction Posting Date" - creates it if necessary
     */
    public DTM getTransactionPostingDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-5: "Transaction Posting Date" - creates it if necessary
     */
    public DTM getFt15_TransactionPostingDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-6: "Transaction Type" - creates it if necessary
     */
    public IS getTransactionType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-6: "Transaction Type" - creates it if necessary
     */
    public IS getFt16_TransactionType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-7: "Transaction Code" - creates it if necessary
     */
    public CWE getTransactionCode() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-7: "Transaction Code" - creates it if necessary
     */
    public CWE getFt17_TransactionCode() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-8: "Transaction Description" - creates it if necessary
     */
    public NULLDT getTransactionDescription() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-8: "Transaction Description" - creates it if necessary
     */
    public NULLDT getFt18_TransactionDescription() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-9: "Transaction Description - Alt" - creates it if necessary
     */
    public NULLDT getTransactionDescriptionAlt() { 
		NULLDT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-9: "Transaction Description - Alt" - creates it if necessary
     */
    public NULLDT getFt19_TransactionDescriptionAlt() { 
		NULLDT retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-10: "Transaction Quantity" - creates it if necessary
     */
    public NM getTransactionQuantity() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-10: "Transaction Quantity" - creates it if necessary
     */
    public NM getFt110_TransactionQuantity() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-11: "Transaction Amount - Extended" - creates it if necessary
     */
    public CP getTransactionAmountExtended() { 
		CP retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-11: "Transaction Amount - Extended" - creates it if necessary
     */
    public CP getFt111_TransactionAmountExtended() { 
		CP retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-12: "Transaction amount - unit" - creates it if necessary
     */
    public CP getTransactionAmountUnit() { 
		CP retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-12: "Transaction amount - unit" - creates it if necessary
     */
    public CP getFt112_TransactionAmountUnit() { 
		CP retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-13: "Department Code" - creates it if necessary
     */
    public CWE getDepartmentCode() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-13: "Department Code" - creates it if necessary
     */
    public CWE getFt113_DepartmentCode() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-14: "Insurance Plan ID" - creates it if necessary
     */
    public CWE getInsurancePlanID() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-14: "Insurance Plan ID" - creates it if necessary
     */
    public CWE getFt114_InsurancePlanID() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-15: "Insurance Amount" - creates it if necessary
     */
    public CP getInsuranceAmount() { 
		CP retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-15: "Insurance Amount" - creates it if necessary
     */
    public CP getFt115_InsuranceAmount() { 
		CP retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-16: "Assigned Patient Location" - creates it if necessary
     */
    public PL getAssignedPatientLocation() { 
		PL retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-16: "Assigned Patient Location" - creates it if necessary
     */
    public PL getFt116_AssignedPatientLocation() { 
		PL retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-17: "Fee Schedule" - creates it if necessary
     */
    public IS getFeeSchedule() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-17: "Fee Schedule" - creates it if necessary
     */
    public IS getFt117_FeeSchedule() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-18: "Patient Type" - creates it if necessary
     */
    public IS getPatientType() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-18: "Patient Type" - creates it if necessary
     */
    public IS getFt118_PatientType() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Diagnosis Code - FT1 (FT1-19).
     */
    public CWE[] getDiagnosisCodeFT1() {
    	CWE[] retVal = this.getTypedField(19, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Diagnosis Code - FT1 (FT1-19).
     */
    public CWE[] getFt119_DiagnosisCodeFT1() {
    	CWE[] retVal = this.getTypedField(19, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Diagnosis Code - FT1 (FT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDiagnosisCodeFT1Reps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * FT1-19: "Diagnosis Code - FT1" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getDiagnosisCodeFT1(int rep) { 
		CWE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-19: "Diagnosis Code - FT1" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getFt119_DiagnosisCodeFT1(int rep) { 
		CWE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Diagnosis Code - FT1 (FT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt119_DiagnosisCodeFT1Reps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * FT1-19: "Diagnosis Code - FT1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertDiagnosisCodeFT1(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-19: "Diagnosis Code - FT1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertFt119_DiagnosisCodeFT1(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * FT1-19: "Diagnosis Code - FT1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeDiagnosisCodeFT1(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * FT1-19: "Diagnosis Code - FT1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeFt119_DiagnosisCodeFT1(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(19, rep);
    }



    /**
     * Returns all repetitions of Performed By Code (FT1-20).
     */
    public XCN[] getPerformedByCode() {
    	XCN[] retVal = this.getTypedField(20, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Performed By Code (FT1-20).
     */
    public XCN[] getFt120_PerformedByCode() {
    	XCN[] retVal = this.getTypedField(20, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Performed By Code (FT1-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPerformedByCodeReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * FT1-20: "Performed By Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPerformedByCode(int rep) { 
		XCN retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-20: "Performed By Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getFt120_PerformedByCode(int rep) { 
		XCN retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Performed By Code (FT1-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt120_PerformedByCodeReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * FT1-20: "Performed By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPerformedByCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-20: "Performed By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertFt120_PerformedByCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * FT1-20: "Performed By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePerformedByCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * FT1-20: "Performed By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeFt120_PerformedByCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Ordered By Code (FT1-21).
     */
    public XCN[] getOrderedByCode() {
    	XCN[] retVal = this.getTypedField(21, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordered By Code (FT1-21).
     */
    public XCN[] getFt121_OrderedByCode() {
    	XCN[] retVal = this.getTypedField(21, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordered By Code (FT1-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderedByCodeReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * FT1-21: "Ordered By Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrderedByCode(int rep) { 
		XCN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-21: "Ordered By Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getFt121_OrderedByCode(int rep) { 
		XCN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordered By Code (FT1-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt121_OrderedByCodeReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * FT1-21: "Ordered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrderedByCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-21: "Ordered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertFt121_OrderedByCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * FT1-21: "Ordered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrderedByCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * FT1-21: "Ordered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeFt121_OrderedByCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * FT1-22: "Unit Cost" - creates it if necessary
     */
    public CP getUnitCost() { 
		CP retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-22: "Unit Cost" - creates it if necessary
     */
    public CP getFt122_UnitCost() { 
		CP retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-23: "Filler Order Number" - creates it if necessary
     */
    public EI getFillerOrderNumber() { 
		EI retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-23: "Filler Order Number" - creates it if necessary
     */
    public EI getFt123_FillerOrderNumber() { 
		EI retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Entered By Code (FT1-24).
     */
    public XCN[] getEnteredByCode() {
    	XCN[] retVal = this.getTypedField(24, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Entered By Code (FT1-24).
     */
    public XCN[] getFt124_EnteredByCode() {
    	XCN[] retVal = this.getTypedField(24, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Entered By Code (FT1-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEnteredByCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * FT1-24: "Entered By Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getEnteredByCode(int rep) { 
		XCN retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-24: "Entered By Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getFt124_EnteredByCode(int rep) { 
		XCN retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Entered By Code (FT1-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt124_EnteredByCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * FT1-24: "Entered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertEnteredByCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-24: "Entered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertFt124_EnteredByCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * FT1-24: "Entered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeEnteredByCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * FT1-24: "Entered By Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeFt124_EnteredByCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * FT1-25: "Procedure Code" - creates it if necessary
     */
    public CNE getProcedureCode() { 
		CNE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-25: "Procedure Code" - creates it if necessary
     */
    public CNE getFt125_ProcedureCode() { 
		CNE retVal = this.getTypedField(25, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (FT1-26).
     */
    public CNE[] getProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(26, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (FT1-26).
     */
    public CNE[] getFt126_ProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(26, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (FT1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeModifierReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * FT1-26: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-26: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getFt126_ProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (FT1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt126_ProcedureCodeModifierReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * FT1-26: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-26: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertFt126_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * FT1-26: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * FT1-26: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeFt126_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(26, rep);
    }




    /**
     * Returns
     * FT1-27: "Advanced Beneficiary Notice Code" - creates it if necessary
     */
    public CWE getAdvancedBeneficiaryNoticeCode() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-27: "Advanced Beneficiary Notice Code" - creates it if necessary
     */
    public CWE getFt127_AdvancedBeneficiaryNoticeCode() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-28: "Medically Necessary Duplicate Procedure Reason" - creates it if necessary
     */
    public CWE getMedicallyNecessaryDuplicateProcedureReason() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-28: "Medically Necessary Duplicate Procedure Reason" - creates it if necessary
     */
    public CWE getFt128_MedicallyNecessaryDuplicateProcedureReason() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-29: "NDC Code" - creates it if necessary
     */
    public CWE getNDCCode() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-29: "NDC Code" - creates it if necessary
     */
    public CWE getFt129_NDCCode() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-30: "Payment Reference ID" - creates it if necessary
     */
    public CX getPaymentReferenceID() { 
		CX retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-30: "Payment Reference ID" - creates it if necessary
     */
    public CX getFt130_PaymentReferenceID() { 
		CX retVal = this.getTypedField(30, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Transaction Reference Key (FT1-31).
     */
    public SI[] getTransactionReferenceKey() {
    	SI[] retVal = this.getTypedField(31, new SI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Transaction Reference Key (FT1-31).
     */
    public SI[] getFt131_TransactionReferenceKey() {
    	SI[] retVal = this.getTypedField(31, new SI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Transaction Reference Key (FT1-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTransactionReferenceKeyReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * FT1-31: "Transaction Reference Key" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SI getTransactionReferenceKey(int rep) { 
		SI retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-31: "Transaction Reference Key" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SI getFt131_TransactionReferenceKey(int rep) { 
		SI retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Transaction Reference Key (FT1-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt131_TransactionReferenceKeyReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * FT1-31: "Transaction Reference Key" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI insertTransactionReferenceKey(int rep) throws HL7Exception { 
        return (SI) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-31: "Transaction Reference Key" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI insertFt131_TransactionReferenceKey(int rep) throws HL7Exception { 
        return (SI) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * FT1-31: "Transaction Reference Key" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI removeTransactionReferenceKey(int rep) throws HL7Exception { 
        return (SI) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * FT1-31: "Transaction Reference Key" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SI removeFt131_TransactionReferenceKey(int rep) throws HL7Exception { 
        return (SI) super.removeRepetition(31, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new DR(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new IS(getMessage(), new Integer( 17 ));
          case 6: return new CWE(getMessage());
          case 7: return new NULLDT(getMessage());
          case 8: return new NULLDT(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new CP(getMessage());
          case 11: return new CP(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new CP(getMessage());
          case 15: return new PL(getMessage());
          case 16: return new IS(getMessage(), new Integer( 24 ));
          case 17: return new IS(getMessage(), new Integer( 18 ));
          case 18: return new CWE(getMessage());
          case 19: return new XCN(getMessage());
          case 20: return new XCN(getMessage());
          case 21: return new CP(getMessage());
          case 22: return new EI(getMessage());
          case 23: return new XCN(getMessage());
          case 24: return new CNE(getMessage());
          case 25: return new CNE(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new CWE(getMessage());
          case 29: return new CX(getMessage());
          case 30: return new SI(getMessage());
          default: return null;
       }
   }


}

