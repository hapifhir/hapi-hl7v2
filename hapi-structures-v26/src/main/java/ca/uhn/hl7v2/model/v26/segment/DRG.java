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
 *<p>Represents an HL7 DRG message segment (Diagnosis Related Group). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DRG-1: Diagnostic Related Group (CNE) <b>optional </b>
     * <li>DRG-2: DRG Assigned Date/Time (DTM) <b>optional </b>
     * <li>DRG-3: DRG Approval Indicator (ID) <b>optional </b>
     * <li>DRG-4: DRG Grouper Review Code (IS) <b>optional </b>
     * <li>DRG-5: Outlier Type (CWE) <b>optional </b>
     * <li>DRG-6: Outlier Days (NM) <b>optional </b>
     * <li>DRG-7: Outlier Cost (CP) <b>optional </b>
     * <li>DRG-8: DRG Payor (IS) <b>optional </b>
     * <li>DRG-9: Outlier Reimbursement (CP) <b>optional </b>
     * <li>DRG-10: Confidential Indicator (ID) <b>optional </b>
     * <li>DRG-11: DRG Transfer Type (IS) <b>optional </b>
     * <li>DRG-12: Name of Coder (XPN) <b>optional </b>
     * <li>DRG-13: Grouper Status (CWE) <b>optional </b>
     * <li>DRG-14: PCCL Value Code (CWE) <b>optional </b>
     * <li>DRG-15: Effective Weight (NM) <b>optional </b>
     * <li>DRG-16: Monetary Amount (MO) <b>optional </b>
     * <li>DRG-17: Status Patient (IS) <b>optional </b>
     * <li>DRG-18: Grouper Software Name (ST) <b>optional </b>
     * <li>DRG-19: Grouper Software Version (ST) <b>optional </b>
     * <li>DRG-20: Status Financial Calculation (IS) <b>optional </b>
     * <li>DRG-21: Relative Discount/Surcharge (MO) <b>optional </b>
     * <li>DRG-22: Basic Charge (MO) <b>optional </b>
     * <li>DRG-23: Total Charge (MO) <b>optional </b>
     * <li>DRG-24: Discount/Surcharge (MO) <b>optional </b>
     * <li>DRG-25: Calculated Days (NM) <b>optional </b>
     * <li>DRG-26: Status Gender (IS) <b>optional </b>
     * <li>DRG-27: Status Age (IS) <b>optional </b>
     * <li>DRG-28: Status Length of Stay (IS) <b>optional </b>
     * <li>DRG-29: Status Same Day Flag (IS) <b>optional </b>
     * <li>DRG-30: Status Separation Mode (IS) <b>optional </b>
     * <li>DRG-31: Status Weight at Birth (IS) <b>optional </b>
     * <li>DRG-32: Status Respiration Minutes (IS) <b>optional </b>
     * <li>DRG-33: Status Admission (IS) <b>optional </b>
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
                                  this.add(CNE.class, false, 1, 250, new Object[]{ getMessage() }, "Diagnostic Related Group");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "DRG Assigned Date/Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "DRG Approval Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(56) }, "DRG Grouper Review Code");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Outlier Type");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Outlier Days");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Outlier Cost");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(229) }, "DRG Payor");
                                  this.add(CP.class, false, 1, 9, new Object[]{ getMessage() }, "Outlier Reimbursement");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Confidential Indicator");
                                              this.add(IS.class, false, 1, 21, new Object[]{ getMessage(), new Integer(415) }, "DRG Transfer Type");
                                  this.add(XPN.class, false, 1, 1103, new Object[]{ getMessage() }, "Name of Coder");
                                  this.add(CWE.class, false, 1, 705, new Object[]{ getMessage() }, "Grouper Status");
                                  this.add(CWE.class, false, 1, 20, new Object[]{ getMessage() }, "PCCL Value Code");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Effective Weight");
                                  this.add(MO.class, false, 1, 20, new Object[]{ getMessage() }, "Monetary Amount");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(739) }, "Status Patient");
                                  this.add(ST.class, false, 1, 100, new Object[]{ getMessage() }, "Grouper Software Name");
                                  this.add(ST.class, false, 1, 100, new Object[]{ getMessage() }, "Grouper Software Version");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(742) }, "Status Financial Calculation");
                                  this.add(MO.class, false, 1, 20, new Object[]{ getMessage() }, "Relative Discount/Surcharge");
                                  this.add(MO.class, false, 1, 20, new Object[]{ getMessage() }, "Basic Charge");
                                  this.add(MO.class, false, 1, 20, new Object[]{ getMessage() }, "Total Charge");
                                  this.add(MO.class, false, 1, 20, new Object[]{ getMessage() }, "Discount/Surcharge");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Calculated Days");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(749) }, "Status Gender");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(749) }, "Status Age");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(749) }, "Status Length of Stay");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(749) }, "Status Same Day Flag");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(749) }, "Status Separation Mode");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(755) }, "Status Weight at Birth");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(757) }, "Status Respiration Minutes");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(759) }, "Status Admission");
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
    public IS getDRGGrouperReviewCode() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-4: "DRG Grouper Review Code" - creates it if necessary
     */
    public IS getDrg4_DRGGrouperReviewCode() { 
		IS retVal = this.getTypedField(4, 0);
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
    public IS getDRGPayor() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-8: "DRG Payor" - creates it if necessary
     */
    public IS getDrg8_DRGPayor() { 
		IS retVal = this.getTypedField(8, 0);
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
    public IS getDRGTransferType() { 
		IS retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-11: "DRG Transfer Type" - creates it if necessary
     */
    public IS getDrg11_DRGTransferType() { 
		IS retVal = this.getTypedField(11, 0);
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
    public IS getStatusPatient() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-17: "Status Patient" - creates it if necessary
     */
    public IS getDrg17_StatusPatient() { 
		IS retVal = this.getTypedField(17, 0);
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
    public IS getStatusFinancialCalculation() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-20: "Status Financial Calculation" - creates it if necessary
     */
    public IS getDrg20_StatusFinancialCalculation() { 
		IS retVal = this.getTypedField(20, 0);
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
    public IS getStatusGender() { 
		IS retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-26: "Status Gender" - creates it if necessary
     */
    public IS getDrg26_StatusGender() { 
		IS retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-27: "Status Age" - creates it if necessary
     */
    public IS getStatusAge() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-27: "Status Age" - creates it if necessary
     */
    public IS getDrg27_StatusAge() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-28: "Status Length of Stay" - creates it if necessary
     */
    public IS getStatusLengthOfStay() { 
		IS retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-28: "Status Length of Stay" - creates it if necessary
     */
    public IS getDrg28_StatusLengthOfStay() { 
		IS retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-29: "Status Same Day Flag" - creates it if necessary
     */
    public IS getStatusSameDayFlag() { 
		IS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-29: "Status Same Day Flag" - creates it if necessary
     */
    public IS getDrg29_StatusSameDayFlag() { 
		IS retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-30: "Status Separation Mode" - creates it if necessary
     */
    public IS getStatusSeparationMode() { 
		IS retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-30: "Status Separation Mode" - creates it if necessary
     */
    public IS getDrg30_StatusSeparationMode() { 
		IS retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-31: "Status Weight at Birth" - creates it if necessary
     */
    public IS getStatusWeightAtBirth() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-31: "Status Weight at Birth" - creates it if necessary
     */
    public IS getDrg31_StatusWeightAtBirth() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-32: "Status Respiration Minutes" - creates it if necessary
     */
    public IS getStatusRespirationMinutes() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-32: "Status Respiration Minutes" - creates it if necessary
     */
    public IS getDrg32_StatusRespirationMinutes() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-33: "Status Admission" - creates it if necessary
     */
    public IS getStatusAdmission() { 
		IS retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-33: "Status Admission" - creates it if necessary
     */
    public IS getDrg33_StatusAdmission() { 
		IS retVal = this.getTypedField(33, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CNE(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new ID(getMessage(), new Integer( 136 ));
          case 3: return new IS(getMessage(), new Integer( 56 ));
          case 4: return new CWE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CP(getMessage());
          case 7: return new IS(getMessage(), new Integer( 229 ));
          case 8: return new CP(getMessage());
          case 9: return new ID(getMessage(), new Integer( 136 ));
          case 10: return new IS(getMessage(), new Integer( 415 ));
          case 11: return new XPN(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new MO(getMessage());
          case 16: return new IS(getMessage(), new Integer( 739 ));
          case 17: return new ST(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new IS(getMessage(), new Integer( 742 ));
          case 20: return new MO(getMessage());
          case 21: return new MO(getMessage());
          case 22: return new MO(getMessage());
          case 23: return new MO(getMessage());
          case 24: return new NM(getMessage());
          case 25: return new IS(getMessage(), new Integer( 749 ));
          case 26: return new IS(getMessage(), new Integer( 749 ));
          case 27: return new IS(getMessage(), new Integer( 749 ));
          case 28: return new IS(getMessage(), new Integer( 749 ));
          case 29: return new IS(getMessage(), new Integer( 749 ));
          case 30: return new IS(getMessage(), new Integer( 755 ));
          case 31: return new IS(getMessage(), new Integer( 757 ));
          case 32: return new IS(getMessage(), new Integer( 759 ));
          default: return null;
       }
   }


}

