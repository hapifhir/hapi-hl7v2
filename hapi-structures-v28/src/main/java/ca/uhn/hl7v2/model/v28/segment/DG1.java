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
 *<p>Represents an HL7 DG1 message segment (Diagnosis). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DG1-1: Set ID - DG1 (SI) <b> </b>
     * <li>DG1-2: Diagnosis Coding Method (NULLDT) <b>optional </b>
     * <li>DG1-3: Diagnosis Code - DG1 (CWE) <b> </b>
     * <li>DG1-4: Diagnosis Description (NULLDT) <b>optional </b>
     * <li>DG1-5: Diagnosis Date/Time (DTM) <b>optional </b>
     * <li>DG1-6: Diagnosis Type (CWE) <b> </b>
     * <li>DG1-7: Major Diagnostic Category (CNE) <b>optional </b>
     * <li>DG1-8: Diagnostic Related Group (CNE) <b>optional </b>
     * <li>DG1-9: DRG Approval Indicator (ID) <b>optional </b>
     * <li>DG1-10: DRG Grouper Review Code (CWE) <b>optional </b>
     * <li>DG1-11: Outlier Type (CWE) <b>optional </b>
     * <li>DG1-12: Outlier Days (NM) <b>optional </b>
     * <li>DG1-13: Outlier Cost (CP) <b>optional </b>
     * <li>DG1-14: Grouper Version And Type (NULLDT) <b>optional </b>
     * <li>DG1-15: Diagnosis Priority (NM) <b>optional </b>
     * <li>DG1-16: Diagnosing Clinician (XCN) <b>optional repeating</b>
     * <li>DG1-17: Diagnosis Classification (CWE) <b>optional </b>
     * <li>DG1-18: Confidential Indicator (ID) <b>optional </b>
     * <li>DG1-19: Attestation Date/Time (DTM) <b>optional </b>
     * <li>DG1-20: Diagnosis Identifier (EI) <b>optional </b>
     * <li>DG1-21: Diagnosis Action Code (ID) <b>optional </b>
     * <li>DG1-22: Parent Diagnosis (EI) <b>optional </b>
     * <li>DG1-23: DRG CCL Value Code (CWE) <b>optional </b>
     * <li>DG1-24: DRG Grouping Usage (ID) <b>optional </b>
     * <li>DG1-25: DRG Diagnosis Determination Status (CWE) <b>optional </b>
     * <li>DG1-26: Present On Admission (POA) Indicator (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DG1 extends AbstractSegment {

    /** 
     * Creates a new DG1 segment
     */
    public DG1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - DG1");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnosis Coding Method");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Diagnosis Code - DG1");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnosis Description");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnosis Date/Time");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Diagnosis Type");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Major Diagnostic Category");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnostic Related Group");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "DRG Approval Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "DRG Grouper Review Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Days");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Cost");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Grouper Version And Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnosis Priority");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Diagnosing Clinician");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnosis Classification");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Confidential Indicator");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Attestation Date/Time");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnosis Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(206) }, "Diagnosis Action Code");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Parent Diagnosis");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "DRG CCL Value Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "DRG Grouping Usage");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "DRG Diagnosis Determination Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Present On Admission (POA) Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DG1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DG1-1: "Set ID - DG1" - creates it if necessary
     */
    public SI getSetIDDG1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-1: "Set ID - DG1" - creates it if necessary
     */
    public SI getDg11_SetIDDG1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-2: "Diagnosis Coding Method" - creates it if necessary
     */
    public NULLDT getDiagnosisCodingMethod() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-2: "Diagnosis Coding Method" - creates it if necessary
     */
    public NULLDT getDg12_DiagnosisCodingMethod() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-3: "Diagnosis Code - DG1" - creates it if necessary
     */
    public CWE getDiagnosisCodeDG1() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-3: "Diagnosis Code - DG1" - creates it if necessary
     */
    public CWE getDg13_DiagnosisCodeDG1() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-4: "Diagnosis Description" - creates it if necessary
     */
    public NULLDT getDiagnosisDescription() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-4: "Diagnosis Description" - creates it if necessary
     */
    public NULLDT getDg14_DiagnosisDescription() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-5: "Diagnosis Date/Time" - creates it if necessary
     */
    public DTM getDiagnosisDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-5: "Diagnosis Date/Time" - creates it if necessary
     */
    public DTM getDg15_DiagnosisDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-6: "Diagnosis Type" - creates it if necessary
     */
    public CWE getDiagnosisType() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-6: "Diagnosis Type" - creates it if necessary
     */
    public CWE getDg16_DiagnosisType() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-7: "Major Diagnostic Category" - creates it if necessary
     */
    public CNE getMajorDiagnosticCategory() { 
		CNE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-7: "Major Diagnostic Category" - creates it if necessary
     */
    public CNE getDg17_MajorDiagnosticCategory() { 
		CNE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-8: "Diagnostic Related Group" - creates it if necessary
     */
    public CNE getDiagnosticRelatedGroup() { 
		CNE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-8: "Diagnostic Related Group" - creates it if necessary
     */
    public CNE getDg18_DiagnosticRelatedGroup() { 
		CNE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-9: "DRG Approval Indicator" - creates it if necessary
     */
    public ID getDRGApprovalIndicator() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-9: "DRG Approval Indicator" - creates it if necessary
     */
    public ID getDg19_DRGApprovalIndicator() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-10: "DRG Grouper Review Code" - creates it if necessary
     */
    public CWE getDRGGrouperReviewCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-10: "DRG Grouper Review Code" - creates it if necessary
     */
    public CWE getDg110_DRGGrouperReviewCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-11: "Outlier Type" - creates it if necessary
     */
    public CWE getOutlierType() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-11: "Outlier Type" - creates it if necessary
     */
    public CWE getDg111_OutlierType() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-12: "Outlier Days" - creates it if necessary
     */
    public NM getOutlierDays() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-12: "Outlier Days" - creates it if necessary
     */
    public NM getDg112_OutlierDays() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-13: "Outlier Cost" - creates it if necessary
     */
    public CP getOutlierCost() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-13: "Outlier Cost" - creates it if necessary
     */
    public CP getDg113_OutlierCost() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-14: "Grouper Version And Type" - creates it if necessary
     */
    public NULLDT getGrouperVersionAndType() { 
		NULLDT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-14: "Grouper Version And Type" - creates it if necessary
     */
    public NULLDT getDg114_GrouperVersionAndType() { 
		NULLDT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-15: "Diagnosis Priority" - creates it if necessary
     */
    public NM getDiagnosisPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-15: "Diagnosis Priority" - creates it if necessary
     */
    public NM getDg115_DiagnosisPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Diagnosing Clinician (DG1-16).
     */
    public XCN[] getDiagnosingClinician() {
    	XCN[] retVal = this.getTypedField(16, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Diagnosing Clinician (DG1-16).
     */
    public XCN[] getDg116_DiagnosingClinician() {
    	XCN[] retVal = this.getTypedField(16, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Diagnosing Clinician (DG1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDiagnosingClinicianReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * DG1-16: "Diagnosing Clinician" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getDiagnosingClinician(int rep) { 
		XCN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DG1-16: "Diagnosing Clinician" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getDg116_DiagnosingClinician(int rep) { 
		XCN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Diagnosing Clinician (DG1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDg116_DiagnosingClinicianReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * DG1-16: "Diagnosing Clinician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertDiagnosingClinician(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * DG1-16: "Diagnosing Clinician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertDg116_DiagnosingClinician(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * DG1-16: "Diagnosing Clinician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeDiagnosingClinician(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * DG1-16: "Diagnosing Clinician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeDg116_DiagnosingClinician(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * DG1-17: "Diagnosis Classification" - creates it if necessary
     */
    public CWE getDiagnosisClassification() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-17: "Diagnosis Classification" - creates it if necessary
     */
    public CWE getDg117_DiagnosisClassification() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-18: "Confidential Indicator" - creates it if necessary
     */
    public ID getConfidentialIndicator() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-18: "Confidential Indicator" - creates it if necessary
     */
    public ID getDg118_ConfidentialIndicator() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-19: "Attestation Date/Time" - creates it if necessary
     */
    public DTM getAttestationDateTime() { 
		DTM retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-19: "Attestation Date/Time" - creates it if necessary
     */
    public DTM getDg119_AttestationDateTime() { 
		DTM retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-20: "Diagnosis Identifier" - creates it if necessary
     */
    public EI getDiagnosisIdentifier() { 
		EI retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-20: "Diagnosis Identifier" - creates it if necessary
     */
    public EI getDg120_DiagnosisIdentifier() { 
		EI retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-21: "Diagnosis Action Code" - creates it if necessary
     */
    public ID getDiagnosisActionCode() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-21: "Diagnosis Action Code" - creates it if necessary
     */
    public ID getDg121_DiagnosisActionCode() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-22: "Parent Diagnosis" - creates it if necessary
     */
    public EI getParentDiagnosis() { 
		EI retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-22: "Parent Diagnosis" - creates it if necessary
     */
    public EI getDg122_ParentDiagnosis() { 
		EI retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-23: "DRG CCL Value Code" - creates it if necessary
     */
    public CWE getDRGCCLValueCode() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-23: "DRG CCL Value Code" - creates it if necessary
     */
    public CWE getDg123_DRGCCLValueCode() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-24: "DRG Grouping Usage" - creates it if necessary
     */
    public ID getDRGGroupingUsage() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-24: "DRG Grouping Usage" - creates it if necessary
     */
    public ID getDg124_DRGGroupingUsage() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-25: "DRG Diagnosis Determination Status" - creates it if necessary
     */
    public CWE getDRGDiagnosisDeterminationStatus() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-25: "DRG Diagnosis Determination Status" - creates it if necessary
     */
    public CWE getDg125_DRGDiagnosisDeterminationStatus() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-26: "Present On Admission (POA) Indicator" - creates it if necessary
     */
    public CWE getPresentOnAdmissionIndicator() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-26: "Present On Admission (POA) Indicator" - creates it if necessary
     */
    public CWE getDg126_PresentOnAdmissionIndicator() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new NULLDT(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new NULLDT(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CNE(getMessage());
          case 7: return new CNE(getMessage());
          case 8: return new ID(getMessage(), new Integer( 136 ));
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CP(getMessage());
          case 13: return new NULLDT(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new XCN(getMessage());
          case 16: return new CWE(getMessage());
          case 17: return new ID(getMessage(), new Integer( 136 ));
          case 18: return new DTM(getMessage());
          case 19: return new EI(getMessage());
          case 20: return new ID(getMessage(), new Integer( 206 ));
          case 21: return new EI(getMessage());
          case 22: return new CWE(getMessage());
          case 23: return new ID(getMessage(), new Integer( 136 ));
          case 24: return new CWE(getMessage());
          case 25: return new CWE(getMessage());
          default: return null;
       }
   }


}

