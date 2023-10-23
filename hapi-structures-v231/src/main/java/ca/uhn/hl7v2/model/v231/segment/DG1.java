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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 DG1 message segment (DG1 - diagnosis segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DG1-1: Set ID - DG1 (SI) <b> </b>
     * <li>DG1-2: Diagnosis Coding Method (ID) <b>optional </b>
     * <li>DG1-3: Diagnosis Code - DG1 (CE) <b>optional </b>
     * <li>DG1-4: Diagnosis Description (ST) <b>optional </b>
     * <li>DG1-5: Diagnosis Date/Time (TS) <b>optional </b>
     * <li>DG1-6: Diagnosis Type (IS) <b> </b>
     * <li>DG1-7: Major Diagnostic Category (CE) <b>optional </b>
     * <li>DG1-8: Diagnostic Related Group (CE) <b>optional </b>
     * <li>DG1-9: DRG Approval Indicator (ID) <b>optional </b>
     * <li>DG1-10: DRG Grouper Review Code (IS) <b>optional </b>
     * <li>DG1-11: Outlier Type (CE) <b>optional </b>
     * <li>DG1-12: Outlier Days (NM) <b>optional </b>
     * <li>DG1-13: Outlier Cost (CP) <b>optional </b>
     * <li>DG1-14: Grouper Version And Type (ST) <b>optional </b>
     * <li>DG1-15: Diagnosis Priority (ID) <b>optional </b>
     * <li>DG1-16: Diagnosing Clinician (XCN) <b>optional repeating</b>
     * <li>DG1-17: Diagnosis Classification (IS) <b>optional </b>
     * <li>DG1-18: Confidential Indicator (ID) <b>optional </b>
     * <li>DG1-19: Attestation Date/Time (TS) <b>optional </b>
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
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(53) }, "Diagnosis Coding Method");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Diagnosis Code - DG1");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Diagnosis Description");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Diagnosis Date/Time");
                                              this.add(IS.class, true, 1, 2, new Object[]{ getMessage(), new Integer(52) }, "Diagnosis Type");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Major Diagnostic Category");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Diagnostic Related Group");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "DRG Approval Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(56) }, "DRG Grouper Review Code");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Outlier Type");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Outlier Days");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Outlier Cost");
                                  this.add(ST.class, false, 1, 4, new Object[]{ getMessage() }, "Grouper Version And Type");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(359) }, "Diagnosis Priority");
                                  this.add(XCN.class, false, 0, 60, new Object[]{ getMessage() }, "Diagnosing Clinician");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(228) }, "Diagnosis Classification");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Confidential Indicator");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Attestation Date/Time");
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
    public ID getDiagnosisCodingMethod() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-2: "Diagnosis Coding Method" - creates it if necessary
     */
    public ID getDg12_DiagnosisCodingMethod() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-3: "Diagnosis Code - DG1" - creates it if necessary
     */
    public CE getDiagnosisCodeDG1() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-3: "Diagnosis Code - DG1" - creates it if necessary
     */
    public CE getDg13_DiagnosisCodeDG1() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-4: "Diagnosis Description" - creates it if necessary
     */
    public ST getDiagnosisDescription() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-4: "Diagnosis Description" - creates it if necessary
     */
    public ST getDg14_DiagnosisDescription() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-5: "Diagnosis Date/Time" - creates it if necessary
     */
    public TS getDiagnosisDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-5: "Diagnosis Date/Time" - creates it if necessary
     */
    public TS getDg15_DiagnosisDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-6: "Diagnosis Type" - creates it if necessary
     */
    public IS getDiagnosisType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-6: "Diagnosis Type" - creates it if necessary
     */
    public IS getDg16_DiagnosisType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-7: "Major Diagnostic Category" - creates it if necessary
     */
    public CE getMajorDiagnosticCategory() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-7: "Major Diagnostic Category" - creates it if necessary
     */
    public CE getDg17_MajorDiagnosticCategory() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-8: "Diagnostic Related Group" - creates it if necessary
     */
    public CE getDiagnosticRelatedGroup() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-8: "Diagnostic Related Group" - creates it if necessary
     */
    public CE getDg18_DiagnosticRelatedGroup() { 
		CE retVal = this.getTypedField(8, 0);
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
    public IS getDRGGrouperReviewCode() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-10: "DRG Grouper Review Code" - creates it if necessary
     */
    public IS getDg110_DRGGrouperReviewCode() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-11: "Outlier Type" - creates it if necessary
     */
    public CE getOutlierType() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-11: "Outlier Type" - creates it if necessary
     */
    public CE getDg111_OutlierType() { 
		CE retVal = this.getTypedField(11, 0);
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
    public ST getGrouperVersionAndType() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-14: "Grouper Version And Type" - creates it if necessary
     */
    public ST getDg114_GrouperVersionAndType() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * DG1-15: "Diagnosis Priority" - creates it if necessary
     */
    public ID getDiagnosisPriority() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-15: "Diagnosis Priority" - creates it if necessary
     */
    public ID getDg115_DiagnosisPriority() { 
		ID retVal = this.getTypedField(15, 0);
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
    public IS getDiagnosisClassification() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-17: "Diagnosis Classification" - creates it if necessary
     */
    public IS getDg117_DiagnosisClassification() { 
		IS retVal = this.getTypedField(17, 0);
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
    public TS getAttestationDateTime() { 
		TS retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DG1-19: "Attestation Date/Time" - creates it if necessary
     */
    public TS getDg119_AttestationDateTime() { 
		TS retVal = this.getTypedField(19, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 53 ));
          case 2: return new CE(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new IS(getMessage(), new Integer( 52 ));
          case 6: return new CE(getMessage());
          case 7: return new CE(getMessage());
          case 8: return new ID(getMessage(), new Integer( 136 ));
          case 9: return new IS(getMessage(), new Integer( 56 ));
          case 10: return new CE(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CP(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ID(getMessage(), new Integer( 359 ));
          case 15: return new XCN(getMessage());
          case 16: return new IS(getMessage(), new Integer( 228 ));
          case 17: return new ID(getMessage(), new Integer( 136 ));
          case 18: return new TS(getMessage());
          default: return null;
       }
   }


}

