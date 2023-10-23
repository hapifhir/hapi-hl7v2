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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 FT1 message segment (Financial transaction). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FT1-1: Set ID - Financial Transaction (SI) <b>optional </b>
     * <li>FT1-2: Transaction ID (ST) <b>optional </b>
     * <li>FT1-3: Transaction Batch ID (ST) <b>optional </b>
     * <li>FT1-4: Transaction Date (TS) <b> </b>
     * <li>FT1-5: Transaction Posting Date (TS) <b>optional </b>
     * <li>FT1-6: Transaction Type (ID) <b> </b>
     * <li>FT1-7: Transaction Code (CE) <b> </b>
     * <li>FT1-8: Transaction Description (ST) <b>optional </b>
     * <li>FT1-9: Transaction Description - alternate (ST) <b>optional </b>
     * <li>FT1-10: Transaction Quantity (NM) <b>optional </b>
     * <li>FT1-11: Transaction Amount - Extended (CP) <b>optional </b>
     * <li>FT1-12: Transaction Amount - Unit (CP) <b>optional </b>
     * <li>FT1-13: Department Code (CE) <b>optional </b>
     * <li>FT1-14: Insurance Plan ID (CE) <b>optional </b>
     * <li>FT1-15: Insurance Amount (CP) <b>optional </b>
     * <li>FT1-16: Assigned Patient Location (PL) <b>optional </b>
     * <li>FT1-17: Fee Schedule (ID) <b>optional </b>
     * <li>FT1-18: Patient Type (ID) <b>optional </b>
     * <li>FT1-19: Diagnosis Code (CE) <b>optional repeating</b>
     * <li>FT1-20: Performed By Code (XCN) <b>optional </b>
     * <li>FT1-21: Ordered By Code (XCN) <b>optional </b>
     * <li>FT1-22: Unit Cost (NM) <b>optional </b>
     * <li>FT1-23: Filler Order Number (EI) <b>optional </b>
     * <li>FT1-24: Entered By Code (XCN) <b>optional </b>
     * <li>FT1-25: Procedure Code (CE) <b>optional </b>
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
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - Financial Transaction");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction ID");
                                  this.add(ST.class, false, 1, 10, new Object[]{ getMessage() }, "Transaction Batch ID");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Transaction Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Transaction Posting Date");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(17) }, "Transaction Type");
                                  this.add(CE.class, true, 1, 80, new Object[]{ getMessage() }, "Transaction Code");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Transaction Description");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Transaction Description - alternate");
                                  this.add(NM.class, false, 1, 6, new Object[]{ getMessage() }, "Transaction Quantity");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction Amount - Extended");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction Amount - Unit");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Department Code");
                                  this.add(CE.class, false, 1, 8, new Object[]{ getMessage() }, "Insurance Plan ID");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Insurance Amount");
                                  this.add(PL.class, false, 1, 12, new Object[]{ getMessage() }, "Assigned Patient Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(24) }, "Fee Schedule");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(18) }, "Patient Type");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Diagnosis Code");
                                  this.add(XCN.class, false, 1, 120, new Object[]{ getMessage() }, "Performed By Code");
                                  this.add(XCN.class, false, 1, 120, new Object[]{ getMessage() }, "Ordered By Code");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Unit Cost");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(XCN.class, false, 1, 120, new Object[]{ getMessage() }, "Entered By Code");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Procedure Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FT1-1: "Set ID - Financial Transaction" - creates it if necessary
     */
    public SI getSetIDFinancialTransaction() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-1: "Set ID - Financial Transaction" - creates it if necessary
     */
    public SI getFt11_SetIDFinancialTransaction() { 
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
    public TS getTransactionDate() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-4: "Transaction Date" - creates it if necessary
     */
    public TS getFt14_TransactionDate() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-5: "Transaction Posting Date" - creates it if necessary
     */
    public TS getTransactionPostingDate() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-5: "Transaction Posting Date" - creates it if necessary
     */
    public TS getFt15_TransactionPostingDate() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-6: "Transaction Type" - creates it if necessary
     */
    public ID getTransactionType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-6: "Transaction Type" - creates it if necessary
     */
    public ID getFt16_TransactionType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-7: "Transaction Code" - creates it if necessary
     */
    public CE getTransactionCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-7: "Transaction Code" - creates it if necessary
     */
    public CE getFt17_TransactionCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-8: "Transaction Description" - creates it if necessary
     */
    public ST getTransactionDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-8: "Transaction Description" - creates it if necessary
     */
    public ST getFt18_TransactionDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-9: "Transaction Description - alternate" - creates it if necessary
     */
    public ST getTransactionDescriptionAlternate() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-9: "Transaction Description - alternate" - creates it if necessary
     */
    public ST getFt19_TransactionDescriptionAlternate() { 
		ST retVal = this.getTypedField(9, 0);
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
     * FT1-12: "Transaction Amount - Unit" - creates it if necessary
     */
    public CP getTransactionAmountUnit() { 
		CP retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-12: "Transaction Amount - Unit" - creates it if necessary
     */
    public CP getFt112_TransactionAmountUnit() { 
		CP retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-13: "Department Code" - creates it if necessary
     */
    public CE getDepartmentCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-13: "Department Code" - creates it if necessary
     */
    public CE getFt113_DepartmentCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-14: "Insurance Plan ID" - creates it if necessary
     */
    public CE getInsurancePlanID() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-14: "Insurance Plan ID" - creates it if necessary
     */
    public CE getFt114_InsurancePlanID() { 
		CE retVal = this.getTypedField(14, 0);
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
    public ID getFeeSchedule() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-17: "Fee Schedule" - creates it if necessary
     */
    public ID getFt117_FeeSchedule() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-18: "Patient Type" - creates it if necessary
     */
    public ID getPatientType() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-18: "Patient Type" - creates it if necessary
     */
    public ID getFt118_PatientType() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Diagnosis Code (FT1-19).
     */
    public CE[] getDiagnosisCode() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Diagnosis Code (FT1-19).
     */
    public CE[] getFt119_DiagnosisCode() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Diagnosis Code (FT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDiagnosisCodeReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * FT1-19: "Diagnosis Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getDiagnosisCode(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-19: "Diagnosis Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getFt119_DiagnosisCode(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Diagnosis Code (FT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt119_DiagnosisCodeReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * FT1-19: "Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-19: "Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertFt119_DiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * FT1-19: "Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * FT1-19: "Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeFt119_DiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * FT1-20: "Performed By Code" - creates it if necessary
     */
    public XCN getPerformedByCode() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-20: "Performed By Code" - creates it if necessary
     */
    public XCN getFt120_PerformedByCode() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-21: "Ordered By Code" - creates it if necessary
     */
    public XCN getOrderedByCode() { 
		XCN retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-21: "Ordered By Code" - creates it if necessary
     */
    public XCN getFt121_OrderedByCode() { 
		XCN retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-22: "Unit Cost" - creates it if necessary
     */
    public NM getUnitCost() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-22: "Unit Cost" - creates it if necessary
     */
    public NM getFt122_UnitCost() { 
		NM retVal = this.getTypedField(22, 0);
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
     * Returns
     * FT1-24: "Entered By Code" - creates it if necessary
     */
    public XCN getEnteredByCode() { 
		XCN retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-24: "Entered By Code" - creates it if necessary
     */
    public XCN getFt124_EnteredByCode() { 
		XCN retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-25: "Procedure Code" - creates it if necessary
     */
    public CE getProcedureCode() { 
		CE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-25: "Procedure Code" - creates it if necessary
     */
    public CE getFt125_ProcedureCode() { 
		CE retVal = this.getTypedField(25, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new ID(getMessage(), new Integer( 17 ));
          case 6: return new CE(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new CP(getMessage());
          case 11: return new CP(getMessage());
          case 12: return new CE(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new CP(getMessage());
          case 15: return new PL(getMessage());
          case 16: return new ID(getMessage(), new Integer( 24 ));
          case 17: return new ID(getMessage(), new Integer( 18 ));
          case 18: return new CE(getMessage());
          case 19: return new XCN(getMessage());
          case 20: return new XCN(getMessage());
          case 21: return new NM(getMessage());
          case 22: return new EI(getMessage());
          case 23: return new XCN(getMessage());
          case 24: return new CE(getMessage());
          default: return null;
       }
   }


}

