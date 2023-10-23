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
 *<p>Represents an HL7 DRG message segment (Diagnosis Related Group). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DRG-1: Diagnostic Related Group (CNE) <b>optional </b>
     * <li>DRG-2: DRG Assigned Date/Time (DTM) <b>optional </b>
     * <li>DRG-3: DRG Approval Indicator (ID) <b>optional </b>
     * <li>DRG-4: DRG Grouper Review Code (CWE) <b>optional </b>
     * <li>DRG-5: Outlier Type (CWE) <b>optional </b>
     * <li>DRG-6: Outlier Days (NM) <b>optional </b>
     * <li>DRG-7: Outlier Cost (CP) <b>optional </b>
     * <li>DRG-8: DRG Payor (CWE) <b>optional </b>
     * <li>DRG-9: Outlier Reimbursement (CP) <b>optional </b>
     * <li>DRG-10: Confidential Indicator (ID) <b>optional </b>
     * <li>DRG-11: DRG Transfer Type (CWE) <b>optional </b>
     * <li>DRG-12: Name of Coder (XPN) <b>optional </b>
     * <li>DRG-13: Grouper Status (CWE) <b>optional </b>
     * <li>DRG-14: PCCL Value Code (CWE) <b>optional </b>
     * <li>DRG-15: Effective Weight (NM) <b>optional </b>
     * <li>DRG-16: Monetary Amount (MO) <b>optional </b>
     * <li>DRG-17: Status Patient (CWE) <b>optional </b>
     * <li>DRG-18: Grouper Software Name (ST) <b>optional </b>
     * <li>DRG-19: Grouper Software Version (ST) <b>optional </b>
     * <li>DRG-20: Status Financial Calculation (CWE) <b>optional </b>
     * <li>DRG-21: Relative Discount/Surcharge (MO) <b>optional </b>
     * <li>DRG-22: Basic Charge (MO) <b>optional </b>
     * <li>DRG-23: Total Charge (MO) <b>optional </b>
     * <li>DRG-24: Discount/Surcharge (MO) <b>optional </b>
     * <li>DRG-25: Calculated Days (NM) <b>optional </b>
     * <li>DRG-26: Status Gender (CWE) <b>optional </b>
     * <li>DRG-27: Status Age (CWE) <b>optional </b>
     * <li>DRG-28: Status Length of Stay (CWE) <b>optional </b>
     * <li>DRG-29: Status Same Day Flag (CWE) <b>optional </b>
     * <li>DRG-30: Status Separation Mode (CWE) <b>optional </b>
     * <li>DRG-31: Status Weight at Birth (CWE) <b>optional </b>
     * <li>DRG-32: Status Respiration Minutes (CWE) <b>optional </b>
     * <li>DRG-33: Status Admission (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DRG extends AbstractSegment {

    /** 
     * Creates a new DRG segment
     */
    public DRG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Diagnostic Related Group");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "DRG Assigned Date/Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "DRG Approval Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "DRG Grouper Review Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Days");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Cost");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "DRG Payor");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Outlier Reimbursement");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Confidential Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "DRG Transfer Type");
                                  this.add(XPN.class, false, 1, 0, new Object[]{ getMessage() }, "Name of Coder");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Grouper Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "PCCL Value Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Effective Weight");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Monetary Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Patient");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Grouper Software Name");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Grouper Software Version");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Financial Calculation");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Relative Discount/Surcharge");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Basic Charge");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Total Charge");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Discount/Surcharge");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Calculated Days");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Gender");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Age");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Length of Stay");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Same Day Flag");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Separation Mode");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Weight at Birth");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Respiration Minutes");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Status Admission");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DRG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DRG-1: "Diagnostic Related Group" - creates it if necessary
     */
    public CNE getDiagnosticRelatedGroup() { 
		CNE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-1: "Diagnostic Related Group" - creates it if necessary
     */
    public CNE getDrg1_DiagnosticRelatedGroup() { 
		CNE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-2: "DRG Assigned Date/Time" - creates it if necessary
     */
    public DTM getDRGAssignedDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-2: "DRG Assigned Date/Time" - creates it if necessary
     */
    public DTM getDrg2_DRGAssignedDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-3: "DRG Approval Indicator" - creates it if necessary
     */
    public ID getDRGApprovalIndicator() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-3: "DRG Approval Indicator" - creates it if necessary
     */
    public ID getDrg3_DRGApprovalIndicator() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-4: "DRG Grouper Review Code" - creates it if necessary
     */
    public CWE getDRGGrouperReviewCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-4: "DRG Grouper Review Code" - creates it if necessary
     */
    public CWE getDrg4_DRGGrouperReviewCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-5: "Outlier Type" - creates it if necessary
     */
    public CWE getOutlierType() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-5: "Outlier Type" - creates it if necessary
     */
    public CWE getDrg5_OutlierType() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-6: "Outlier Days" - creates it if necessary
     */
    public NM getOutlierDays() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-6: "Outlier Days" - creates it if necessary
     */
    public NM getDrg6_OutlierDays() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-7: "Outlier Cost" - creates it if necessary
     */
    public CP getOutlierCost() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-7: "Outlier Cost" - creates it if necessary
     */
    public CP getDrg7_OutlierCost() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-8: "DRG Payor" - creates it if necessary
     */
    public CWE getDRGPayor() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-8: "DRG Payor" - creates it if necessary
     */
    public CWE getDrg8_DRGPayor() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-9: "Outlier Reimbursement" - creates it if necessary
     */
    public CP getOutlierReimbursement() { 
		CP retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-9: "Outlier Reimbursement" - creates it if necessary
     */
    public CP getDrg9_OutlierReimbursement() { 
		CP retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-10: "Confidential Indicator" - creates it if necessary
     */
    public ID getConfidentialIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-10: "Confidential Indicator" - creates it if necessary
     */
    public ID getDrg10_ConfidentialIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-11: "DRG Transfer Type" - creates it if necessary
     */
    public CWE getDRGTransferType() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-11: "DRG Transfer Type" - creates it if necessary
     */
    public CWE getDrg11_DRGTransferType() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-12: "Name of Coder" - creates it if necessary
     */
    public XPN getNameOfCoder() { 
		XPN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-12: "Name of Coder" - creates it if necessary
     */
    public XPN getDrg12_NameOfCoder() { 
		XPN retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-13: "Grouper Status" - creates it if necessary
     */
    public CWE getGrouperStatus() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-13: "Grouper Status" - creates it if necessary
     */
    public CWE getDrg13_GrouperStatus() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-14: "PCCL Value Code" - creates it if necessary
     */
    public CWE getPCCLValueCode() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-14: "PCCL Value Code" - creates it if necessary
     */
    public CWE getDrg14_PCCLValueCode() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-15: "Effective Weight" - creates it if necessary
     */
    public NM getEffectiveWeight() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-15: "Effective Weight" - creates it if necessary
     */
    public NM getDrg15_EffectiveWeight() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-16: "Monetary Amount" - creates it if necessary
     */
    public MO getMonetaryAmount() { 
		MO retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-16: "Monetary Amount" - creates it if necessary
     */
    public MO getDrg16_MonetaryAmount() { 
		MO retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-17: "Status Patient" - creates it if necessary
     */
    public CWE getStatusPatient() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-17: "Status Patient" - creates it if necessary
     */
    public CWE getDrg17_StatusPatient() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-18: "Grouper Software Name" - creates it if necessary
     */
    public ST getGrouperSoftwareName() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-18: "Grouper Software Name" - creates it if necessary
     */
    public ST getDrg18_GrouperSoftwareName() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-19: "Grouper Software Version" - creates it if necessary
     */
    public ST getGrouperSoftwareVersion() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-19: "Grouper Software Version" - creates it if necessary
     */
    public ST getDrg19_GrouperSoftwareVersion() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-20: "Status Financial Calculation" - creates it if necessary
     */
    public CWE getStatusFinancialCalculation() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-20: "Status Financial Calculation" - creates it if necessary
     */
    public CWE getDrg20_StatusFinancialCalculation() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-21: "Relative Discount/Surcharge" - creates it if necessary
     */
    public MO getRelativeDiscountSurcharge() { 
		MO retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-21: "Relative Discount/Surcharge" - creates it if necessary
     */
    public MO getDrg21_RelativeDiscountSurcharge() { 
		MO retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-22: "Basic Charge" - creates it if necessary
     */
    public MO getBasicCharge() { 
		MO retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-22: "Basic Charge" - creates it if necessary
     */
    public MO getDrg22_BasicCharge() { 
		MO retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-23: "Total Charge" - creates it if necessary
     */
    public MO getTotalCharge() { 
		MO retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-23: "Total Charge" - creates it if necessary
     */
    public MO getDrg23_TotalCharge() { 
		MO retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-24: "Discount/Surcharge" - creates it if necessary
     */
    public MO getDiscountSurcharge() { 
		MO retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-24: "Discount/Surcharge" - creates it if necessary
     */
    public MO getDrg24_DiscountSurcharge() { 
		MO retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-25: "Calculated Days" - creates it if necessary
     */
    public NM getCalculatedDays() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-25: "Calculated Days" - creates it if necessary
     */
    public NM getDrg25_CalculatedDays() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-26: "Status Gender" - creates it if necessary
     */
    public CWE getStatusGender() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-26: "Status Gender" - creates it if necessary
     */
    public CWE getDrg26_StatusGender() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-27: "Status Age" - creates it if necessary
     */
    public CWE getStatusAge() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-27: "Status Age" - creates it if necessary
     */
    public CWE getDrg27_StatusAge() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-28: "Status Length of Stay" - creates it if necessary
     */
    public CWE getStatusLengthOfStay() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-28: "Status Length of Stay" - creates it if necessary
     */
    public CWE getDrg28_StatusLengthOfStay() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-29: "Status Same Day Flag" - creates it if necessary
     */
    public CWE getStatusSameDayFlag() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-29: "Status Same Day Flag" - creates it if necessary
     */
    public CWE getDrg29_StatusSameDayFlag() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-30: "Status Separation Mode" - creates it if necessary
     */
    public CWE getStatusSeparationMode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-30: "Status Separation Mode" - creates it if necessary
     */
    public CWE getDrg30_StatusSeparationMode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-31: "Status Weight at Birth" - creates it if necessary
     */
    public CWE getStatusWeightAtBirth() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-31: "Status Weight at Birth" - creates it if necessary
     */
    public CWE getDrg31_StatusWeightAtBirth() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-32: "Status Respiration Minutes" - creates it if necessary
     */
    public CWE getStatusRespirationMinutes() { 
		CWE retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-32: "Status Respiration Minutes" - creates it if necessary
     */
    public CWE getDrg32_StatusRespirationMinutes() { 
		CWE retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-33: "Status Admission" - creates it if necessary
     */
    public CWE getStatusAdmission() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-33: "Status Admission" - creates it if necessary
     */
    public CWE getDrg33_StatusAdmission() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CNE(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new ID(getMessage(), new Integer( 136 ));
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CP(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new CP(getMessage());
          case 9: return new ID(getMessage(), new Integer( 136 ));
          case 10: return new CWE(getMessage());
          case 11: return new XPN(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new MO(getMessage());
          case 16: return new CWE(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new CWE(getMessage());
          case 20: return new MO(getMessage());
          case 21: return new MO(getMessage());
          case 22: return new MO(getMessage());
          case 23: return new MO(getMessage());
          case 24: return new NM(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new CWE(getMessage());
          case 29: return new CWE(getMessage());
          case 30: return new CWE(getMessage());
          case 31: return new CWE(getMessage());
          case 32: return new CWE(getMessage());
          default: return null;
       }
   }


}

