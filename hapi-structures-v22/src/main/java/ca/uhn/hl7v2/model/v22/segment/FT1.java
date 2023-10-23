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
 *<p>Represents an HL7 FT1 message segment (FINANCIAL TRANSACTION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FT1-1: Set ID - financial transaction (SI) <b>optional </b>
     * <li>FT1-2: Transaction ID (ST) <b>optional </b>
     * <li>FT1-3: Transaction batch ID (ST) <b>optional </b>
     * <li>FT1-4: Transaction date (DT) <b> </b>
     * <li>FT1-5: Transaction posting date (DT) <b>optional </b>
     * <li>FT1-6: Transaction type (ID) <b> </b>
     * <li>FT1-7: Transaction code (CE) <b> </b>
     * <li>FT1-8: Transaction description (ST) <b>optional </b>
     * <li>FT1-9: Transaction description - alternate (ST) <b>optional </b>
     * <li>FT1-10: Transaction quantity (NM) <b>optional </b>
     * <li>FT1-11: Transaction amount - extended (NM) <b>optional </b>
     * <li>FT1-12: Transaction amount - unit (NM) <b>optional </b>
     * <li>FT1-13: Department code (CE) <b>optional </b>
     * <li>FT1-14: Insurance plan ID (ID) <b> </b>
     * <li>FT1-15: Insurance amount (NM) <b>optional </b>
     * <li>FT1-16: Assigned Patient Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>FT1-17: Fee schedule (ID) <b>optional </b>
     * <li>FT1-18: Patient type (ID) <b>optional </b>
     * <li>FT1-19: Diagnosis code (CE) <b>optional repeating</b>
     * <li>FT1-20: Performed by code (CN) <b>optional </b>
     * <li>FT1-21: Ordered by code (CN) <b>optional </b>
     * <li>FT1-22: Unit cost (NM) <b>optional </b>
     * <li>FT1-23: Filler Order Number (CM_FILLER) <b>optional </b>
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
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - financial transaction");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction ID");
                                  this.add(ST.class, false, 1, 10, new Object[]{ getMessage() }, "Transaction batch ID");
                                  this.add(DT.class, true, 1, 8, new Object[]{ getMessage() }, "Transaction date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Transaction posting date");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(17) }, "Transaction type");
                                  this.add(CE.class, true, 1, 20, new Object[]{ getMessage() }, "Transaction code");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Transaction description");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Transaction description - alternate");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Transaction quantity");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction amount - extended");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Transaction amount - unit");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Department code");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "Insurance plan ID");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Insurance amount");
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Assigned Patient Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(24) }, "Fee schedule");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(18) }, "Patient type");
                                  this.add(CE.class, false, 0, 8, new Object[]{ getMessage() }, "Diagnosis code");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Performed by code");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Ordered by code");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Unit cost");
                                  this.add(CM_FILLER.class, false, 1, 75, new Object[]{ getMessage() }, "Filler Order Number");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FT1-1: "Set ID - financial transaction" - creates it if necessary
     */
    public SI getSetIDFinancialTransaction() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-1: "Set ID - financial transaction" - creates it if necessary
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
     * FT1-3: "Transaction batch ID" - creates it if necessary
     */
    public ST getTransactionBatchID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-3: "Transaction batch ID" - creates it if necessary
     */
    public ST getFt13_TransactionBatchID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-4: "Transaction date" - creates it if necessary
     */
    public DT getTransactionDate() { 
		DT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-4: "Transaction date" - creates it if necessary
     */
    public DT getFt14_TransactionDate() { 
		DT retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-5: "Transaction posting date" - creates it if necessary
     */
    public DT getTransactionPostingDate() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-5: "Transaction posting date" - creates it if necessary
     */
    public DT getFt15_TransactionPostingDate() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-6: "Transaction type" - creates it if necessary
     */
    public ID getTransactionType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-6: "Transaction type" - creates it if necessary
     */
    public ID getFt16_TransactionType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-7: "Transaction code" - creates it if necessary
     */
    public CE getTransactionCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-7: "Transaction code" - creates it if necessary
     */
    public CE getFt17_TransactionCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-8: "Transaction description" - creates it if necessary
     */
    public ST getTransactionDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-8: "Transaction description" - creates it if necessary
     */
    public ST getFt18_TransactionDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-9: "Transaction description - alternate" - creates it if necessary
     */
    public ST getTransactionDescriptionAlternate() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-9: "Transaction description - alternate" - creates it if necessary
     */
    public ST getFt19_TransactionDescriptionAlternate() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-10: "Transaction quantity" - creates it if necessary
     */
    public NM getTransactionQuantity() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-10: "Transaction quantity" - creates it if necessary
     */
    public NM getFt110_TransactionQuantity() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-11: "Transaction amount - extended" - creates it if necessary
     */
    public NM getTransactionAmountExtended() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-11: "Transaction amount - extended" - creates it if necessary
     */
    public NM getFt111_TransactionAmountExtended() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-12: "Transaction amount - unit" - creates it if necessary
     */
    public NM getTransactionAmountUnit() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-12: "Transaction amount - unit" - creates it if necessary
     */
    public NM getFt112_TransactionAmountUnit() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-13: "Department code" - creates it if necessary
     */
    public CE getDepartmentCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-13: "Department code" - creates it if necessary
     */
    public CE getFt113_DepartmentCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-14: "Insurance plan ID" - creates it if necessary
     */
    public ID getInsurancePlanID() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-14: "Insurance plan ID" - creates it if necessary
     */
    public ID getFt114_InsurancePlanID() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-15: "Insurance amount" - creates it if necessary
     */
    public NM getInsuranceAmount() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-15: "Insurance amount" - creates it if necessary
     */
    public NM getFt115_InsuranceAmount() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-16: "Assigned Patient Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getAssignedPatientLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-16: "Assigned Patient Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getFt116_AssignedPatientLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-17: "Fee schedule" - creates it if necessary
     */
    public ID getFeeSchedule() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-17: "Fee schedule" - creates it if necessary
     */
    public ID getFt117_FeeSchedule() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-18: "Patient type" - creates it if necessary
     */
    public ID getPatientType() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-18: "Patient type" - creates it if necessary
     */
    public ID getFt118_PatientType() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Diagnosis code (FT1-19).
     */
    public CE[] getDiagnosisCode() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Diagnosis code (FT1-19).
     */
    public CE[] getFt119_DiagnosisCode() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Diagnosis code (FT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDiagnosisCodeReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * FT1-19: "Diagnosis code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getDiagnosisCode(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FT1-19: "Diagnosis code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getFt119_DiagnosisCode(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Diagnosis code (FT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFt119_DiagnosisCodeReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * FT1-19: "Diagnosis code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * FT1-19: "Diagnosis code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertFt119_DiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * FT1-19: "Diagnosis code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * FT1-19: "Diagnosis code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeFt119_DiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * FT1-20: "Performed by code" - creates it if necessary
     */
    public CN getPerformedByCode() { 
		CN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-20: "Performed by code" - creates it if necessary
     */
    public CN getFt120_PerformedByCode() { 
		CN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-21: "Ordered by code" - creates it if necessary
     */
    public CN getOrderedByCode() { 
		CN retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-21: "Ordered by code" - creates it if necessary
     */
    public CN getFt121_OrderedByCode() { 
		CN retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-22: "Unit cost" - creates it if necessary
     */
    public NM getUnitCost() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-22: "Unit cost" - creates it if necessary
     */
    public NM getFt122_UnitCost() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-23: "Filler Order Number" - creates it if necessary
     */
    public CM_FILLER getFillerOrderNumber() { 
		CM_FILLER retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-23: "Filler Order Number" - creates it if necessary
     */
    public CM_FILLER getFt123_FillerOrderNumber() { 
		CM_FILLER retVal = this.getTypedField(23, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new DT(getMessage());
          case 4: return new DT(getMessage());
          case 5: return new ID(getMessage(), new Integer( 17 ));
          case 6: return new CE(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CE(getMessage());
          case 13: return new ID(getMessage(), new Integer( 72 ));
          case 14: return new NM(getMessage());
          case 15: return new CM_INTERNAL_LOCATION(getMessage());
          case 16: return new ID(getMessage(), new Integer( 24 ));
          case 17: return new ID(getMessage(), new Integer( 18 ));
          case 18: return new CE(getMessage());
          case 19: return new CN(getMessage());
          case 20: return new CN(getMessage());
          case 21: return new NM(getMessage());
          case 22: return new CM_FILLER(getMessage());
          default: return null;
       }
   }


}

