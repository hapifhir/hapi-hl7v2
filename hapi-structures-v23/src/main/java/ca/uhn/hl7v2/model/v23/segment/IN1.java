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
 *<p>Represents an HL7 IN1 message segment (Insurance). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN1-1: Set ID - Insurance (SI) <b> </b>
     * <li>IN1-2: Insurance Plan ID (CE) <b>optional </b>
     * <li>IN1-3: Insurance Company ID (CX) <b> </b>
     * <li>IN1-4: Insurance Company Name (XON) <b>optional </b>
     * <li>IN1-5: Insurance Company Address (XAD) <b>optional </b>
     * <li>IN1-6: Insurance Co. Contact Ppers (XPN) <b>optional </b>
     * <li>IN1-7: Insurance Co Phone Number (XTN) <b>optional repeating</b>
     * <li>IN1-8: Group Number (ST) <b>optional </b>
     * <li>IN1-9: Group Name (XON) <b>optional </b>
     * <li>IN1-10: Insured's group employer ID (CX) <b>optional </b>
     * <li>IN1-11: Insured's Group Emp Name (XON) <b>optional </b>
     * <li>IN1-12: Plan Effective Date (DT) <b>optional </b>
     * <li>IN1-13: Plan Expiration Date (DT) <b>optional </b>
     * <li>IN1-14: Authorization Information (CM_AUI) <b>optional </b>
     * <li>IN1-15: Plan Type (IS) <b>optional </b>
     * <li>IN1-16: Name of Insured (XPN) <b>optional </b>
     * <li>IN1-17: Insured's Relationship to Patient (IS) <b>optional </b>
     * <li>IN1-18: Insured's Date of Birth (TS) <b>optional </b>
     * <li>IN1-19: Insured's Address (XAD) <b>optional </b>
     * <li>IN1-20: Assignment of Benefits (IS) <b>optional </b>
     * <li>IN1-21: Coordination of Benefits (IS) <b>optional </b>
     * <li>IN1-22: Coord of Ben. Priority (ST) <b>optional </b>
     * <li>IN1-23: Notice of Admission Code (ID) <b>optional </b>
     * <li>IN1-24: Notice of Admission Date (DT) <b>optional </b>
     * <li>IN1-25: Rpt of Eigibility Code (ID) <b>optional </b>
     * <li>IN1-26: Rpt of Eligibility Date (DT) <b>optional </b>
     * <li>IN1-27: Release Information Code (IS) <b>optional </b>
     * <li>IN1-28: Pre-Admit Cert (PAC) (ST) <b>optional </b>
     * <li>IN1-29: Verification Date/Time (TS) <b>optional </b>
     * <li>IN1-30: Verification By (XPN) <b>optional </b>
     * <li>IN1-31: Type of Agreement Code (IS) <b>optional </b>
     * <li>IN1-32: Billing Status (IS) <b>optional </b>
     * <li>IN1-33: Lifetime Reserve Days (NM) <b>optional </b>
     * <li>IN1-34: Delay before lifetime reserve days (NM) <b>optional </b>
     * <li>IN1-35: Company Plan Code (IS) <b>optional </b>
     * <li>IN1-36: Policy Number (ST) <b>optional </b>
     * <li>IN1-37: Policy Deductible (CP) <b>optional </b>
     * <li>IN1-38: Policy Limit - Amount (CP) <b>optional </b>
     * <li>IN1-39: Policy Limit - Days (NM) <b>optional </b>
     * <li>IN1-40: Room Rate - Semi-Private (CP) <b>optional </b>
     * <li>IN1-41: Room Rate - Private (CP) <b>optional </b>
     * <li>IN1-42: Insured's Employment Status (CE) <b>optional </b>
     * <li>IN1-43: Insured's Sex (IS) <b>optional </b>
     * <li>IN1-44: Insured's Employer Address (XAD) <b>optional </b>
     * <li>IN1-45: Verification Status (ST) <b>optional </b>
     * <li>IN1-46: Prior Insurance Plan ID (IS) <b>optional </b>
     * <li>IN1-47: Coverage Type (IS) <b>optional </b>
     * <li>IN1-48: Handicap (IS) <b>optional </b>
     * <li>IN1-49: Insured's ID Number (CX) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IN1 extends AbstractSegment {

    /** 
     * Creates a new IN1 segment
     */
    public IN1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - Insurance");
                                  this.add(CE.class, false, 1, 8, new Object[]{ getMessage() }, "Insurance Plan ID");
                                  this.add(CX.class, true, 1, 59, new Object[]{ getMessage() }, "Insurance Company ID");
                                  this.add(XON.class, false, 1, 130, new Object[]{ getMessage() }, "Insurance Company Name");
                                  this.add(XAD.class, false, 1, 106, new Object[]{ getMessage() }, "Insurance Company Address");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Insurance Co. Contact Ppers");
                                  this.add(XTN.class, false, 3, 40, new Object[]{ getMessage() }, "Insurance Co Phone Number");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Group Number");
                                  this.add(XON.class, false, 1, 130, new Object[]{ getMessage() }, "Group Name");
                                  this.add(CX.class, false, 1, 12, new Object[]{ getMessage() }, "Insured's group employer ID");
                                  this.add(XON.class, false, 1, 130, new Object[]{ getMessage() }, "Insured's Group Emp Name");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Plan Effective Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Plan Expiration Date");
                                  this.add(CM_AUI.class, false, 1, 55, new Object[]{ getMessage() }, "Authorization Information");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(86) }, "Plan Type");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Name of Insured");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(63) }, "Insured's Relationship to Patient");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Insured's Date of Birth");
                                  this.add(XAD.class, false, 1, 106, new Object[]{ getMessage() }, "Insured's Address");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(135) }, "Assignment of Benefits");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(173) }, "Coordination of Benefits");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "Coord of Ben. Priority");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Notice of Admission Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Notice of Admission Date");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Rpt of Eigibility Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Rpt of Eligibility Date");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(93) }, "Release Information Code");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Pre-Admit Cert (PAC)");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Verification Date/Time");
                                  this.add(XPN.class, false, 1, 60, new Object[]{ getMessage() }, "Verification By");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(98) }, "Type of Agreement Code");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(22) }, "Billing Status");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Lifetime Reserve Days");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Delay before lifetime reserve days");
                                              this.add(IS.class, false, 1, 8, new Object[]{ getMessage(), new Integer(42) }, "Company Plan Code");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Policy Number");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Policy Deductible");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Policy Limit - Amount");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Policy Limit - Days");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Room Rate - Semi-Private");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Room Rate - Private");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Insured's Employment Status");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Insured's Sex");
                                  this.add(XAD.class, false, 1, 106, new Object[]{ getMessage() }, "Insured's Employer Address");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "Verification Status");
                                              this.add(IS.class, false, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "Prior Insurance Plan ID");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(309) }, "Coverage Type");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(310) }, "Handicap");
                                  this.add(CX.class, false, 1, 12, new Object[]{ getMessage() }, "Insured's ID Number");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN1-1: "Set ID - Insurance" - creates it if necessary
     */
    public SI getSetIDInsurance() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-1: "Set ID - Insurance" - creates it if necessary
     */
    public SI getIn11_SetIDInsurance() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-2: "Insurance Plan ID" - creates it if necessary
     */
    public CE getInsurancePlanID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-2: "Insurance Plan ID" - creates it if necessary
     */
    public CE getIn12_InsurancePlanID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-3: "Insurance Company ID" - creates it if necessary
     */
    public CX getInsuranceCompanyID() { 
		CX retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-3: "Insurance Company ID" - creates it if necessary
     */
    public CX getIn13_InsuranceCompanyID() { 
		CX retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-4: "Insurance Company Name" - creates it if necessary
     */
    public XON getInsuranceCompanyName() { 
		XON retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-4: "Insurance Company Name" - creates it if necessary
     */
    public XON getIn14_InsuranceCompanyName() { 
		XON retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-5: "Insurance Company Address" - creates it if necessary
     */
    public XAD getInsuranceCompanyAddress() { 
		XAD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-5: "Insurance Company Address" - creates it if necessary
     */
    public XAD getIn15_InsuranceCompanyAddress() { 
		XAD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-6: "Insurance Co. Contact Ppers" - creates it if necessary
     */
    public XPN getInsuranceCoContactPpers() { 
		XPN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-6: "Insurance Co. Contact Ppers" - creates it if necessary
     */
    public XPN getIn16_InsuranceCoContactPpers() { 
		XPN retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insurance Co Phone Number (IN1-7).
     */
    public XTN[] getInsuranceCoPhoneNumber() {
    	XTN[] retVal = this.getTypedField(7, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance Co Phone Number (IN1-7).
     */
    public XTN[] getIn17_InsuranceCoPhoneNumber() {
    	XTN[] retVal = this.getTypedField(7, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance Co Phone Number (IN1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCoPhoneNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * IN1-7: "Insurance Co Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuranceCoPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-7: "Insurance Co Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn17_InsuranceCoPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance Co Phone Number (IN1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn17_InsuranceCoPhoneNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn17_InsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn17_InsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * IN1-8: "Group Number" - creates it if necessary
     */
    public ST getGroupNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-8: "Group Number" - creates it if necessary
     */
    public ST getIn18_GroupNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-9: "Group Name" - creates it if necessary
     */
    public XON getGroupName() { 
		XON retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-9: "Group Name" - creates it if necessary
     */
    public XON getIn19_GroupName() { 
		XON retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-10: "Insured's group employer ID" - creates it if necessary
     */
    public CX getInsuredSGroupEmployerID() { 
		CX retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-10: "Insured's group employer ID" - creates it if necessary
     */
    public CX getIn110_InsuredSGroupEmployerID() { 
		CX retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-11: "Insured's Group Emp Name" - creates it if necessary
     */
    public XON getInsuredSGroupEmpName() { 
		XON retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-11: "Insured's Group Emp Name" - creates it if necessary
     */
    public XON getIn111_InsuredSGroupEmpName() { 
		XON retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-12: "Plan Effective Date" - creates it if necessary
     */
    public DT getPlanEffectiveDate() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-12: "Plan Effective Date" - creates it if necessary
     */
    public DT getIn112_PlanEffectiveDate() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-13: "Plan Expiration Date" - creates it if necessary
     */
    public DT getPlanExpirationDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-13: "Plan Expiration Date" - creates it if necessary
     */
    public DT getIn113_PlanExpirationDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-14: "Authorization Information" - creates it if necessary
     */
    public CM_AUI getAuthorizationInformation() { 
		CM_AUI retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-14: "Authorization Information" - creates it if necessary
     */
    public CM_AUI getIn114_AuthorizationInformation() { 
		CM_AUI retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-15: "Plan Type" - creates it if necessary
     */
    public IS getPlanType() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-15: "Plan Type" - creates it if necessary
     */
    public IS getIn115_PlanType() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-16: "Name of Insured" - creates it if necessary
     */
    public XPN getNameOfInsured() { 
		XPN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-16: "Name of Insured" - creates it if necessary
     */
    public XPN getIn116_NameOfInsured() { 
		XPN retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-17: "Insured's Relationship to Patient" - creates it if necessary
     */
    public IS getInsuredSRelationshipToPatient() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-17: "Insured's Relationship to Patient" - creates it if necessary
     */
    public IS getIn117_InsuredSRelationshipToPatient() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-18: "Insured's Date of Birth" - creates it if necessary
     */
    public TS getInsuredSDateOfBirth() { 
		TS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-18: "Insured's Date of Birth" - creates it if necessary
     */
    public TS getIn118_InsuredSDateOfBirth() { 
		TS retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-19: "Insured's Address" - creates it if necessary
     */
    public XAD getInsuredSAddress() { 
		XAD retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-19: "Insured's Address" - creates it if necessary
     */
    public XAD getIn119_InsuredSAddress() { 
		XAD retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-20: "Assignment of Benefits" - creates it if necessary
     */
    public IS getAssignmentOfBenefits() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-20: "Assignment of Benefits" - creates it if necessary
     */
    public IS getIn120_AssignmentOfBenefits() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-21: "Coordination of Benefits" - creates it if necessary
     */
    public IS getCoordinationOfBenefits() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-21: "Coordination of Benefits" - creates it if necessary
     */
    public IS getIn121_CoordinationOfBenefits() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-22: "Coord of Ben. Priority" - creates it if necessary
     */
    public ST getCoordOfBenPriority() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-22: "Coord of Ben. Priority" - creates it if necessary
     */
    public ST getIn122_CoordOfBenPriority() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-23: "Notice of Admission Code" - creates it if necessary
     */
    public ID getNoticeOfAdmissionCode() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-23: "Notice of Admission Code" - creates it if necessary
     */
    public ID getIn123_NoticeOfAdmissionCode() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-24: "Notice of Admission Date" - creates it if necessary
     */
    public DT getNoticeOfAdmissionDate() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-24: "Notice of Admission Date" - creates it if necessary
     */
    public DT getIn124_NoticeOfAdmissionDate() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-25: "Rpt of Eigibility Code" - creates it if necessary
     */
    public ID getRptOfEigibilityCode() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-25: "Rpt of Eigibility Code" - creates it if necessary
     */
    public ID getIn125_RptOfEigibilityCode() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-26: "Rpt of Eligibility Date" - creates it if necessary
     */
    public DT getRptOfEligibilityDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-26: "Rpt of Eligibility Date" - creates it if necessary
     */
    public DT getIn126_RptOfEligibilityDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-27: "Release Information Code" - creates it if necessary
     */
    public IS getReleaseInformationCode() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-27: "Release Information Code" - creates it if necessary
     */
    public IS getIn127_ReleaseInformationCode() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-28: "Pre-Admit Cert (PAC)" - creates it if necessary
     */
    public ST getPreAdmitCert() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-28: "Pre-Admit Cert (PAC)" - creates it if necessary
     */
    public ST getIn128_PreAdmitCert() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-29: "Verification Date/Time" - creates it if necessary
     */
    public TS getVerificationDateTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-29: "Verification Date/Time" - creates it if necessary
     */
    public TS getIn129_VerificationDateTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-30: "Verification By" - creates it if necessary
     */
    public XPN getVerificationBy() { 
		XPN retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-30: "Verification By" - creates it if necessary
     */
    public XPN getIn130_VerificationBy() { 
		XPN retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-31: "Type of Agreement Code" - creates it if necessary
     */
    public IS getTypeOfAgreementCode() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-31: "Type of Agreement Code" - creates it if necessary
     */
    public IS getIn131_TypeOfAgreementCode() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-32: "Billing Status" - creates it if necessary
     */
    public IS getBillingStatus() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-32: "Billing Status" - creates it if necessary
     */
    public IS getIn132_BillingStatus() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-33: "Lifetime Reserve Days" - creates it if necessary
     */
    public NM getLifetimeReserveDays() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-33: "Lifetime Reserve Days" - creates it if necessary
     */
    public NM getIn133_LifetimeReserveDays() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-34: "Delay before lifetime reserve days" - creates it if necessary
     */
    public NM getDelayBeforeLifetimeReserveDays() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-34: "Delay before lifetime reserve days" - creates it if necessary
     */
    public NM getIn134_DelayBeforeLifetimeReserveDays() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-35: "Company Plan Code" - creates it if necessary
     */
    public IS getCompanyPlanCode() { 
		IS retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-35: "Company Plan Code" - creates it if necessary
     */
    public IS getIn135_CompanyPlanCode() { 
		IS retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-36: "Policy Number" - creates it if necessary
     */
    public ST getPolicyNumber() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-36: "Policy Number" - creates it if necessary
     */
    public ST getIn136_PolicyNumber() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-37: "Policy Deductible" - creates it if necessary
     */
    public CP getPolicyDeductible() { 
		CP retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-37: "Policy Deductible" - creates it if necessary
     */
    public CP getIn137_PolicyDeductible() { 
		CP retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-38: "Policy Limit - Amount" - creates it if necessary
     */
    public CP getPolicyLimitAmount() { 
		CP retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-38: "Policy Limit - Amount" - creates it if necessary
     */
    public CP getIn138_PolicyLimitAmount() { 
		CP retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-39: "Policy Limit - Days" - creates it if necessary
     */
    public NM getPolicyLimitDays() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-39: "Policy Limit - Days" - creates it if necessary
     */
    public NM getIn139_PolicyLimitDays() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-40: "Room Rate - Semi-Private" - creates it if necessary
     */
    public CP getRoomRateSemiPrivate() { 
		CP retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-40: "Room Rate - Semi-Private" - creates it if necessary
     */
    public CP getIn140_RoomRateSemiPrivate() { 
		CP retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-41: "Room Rate - Private" - creates it if necessary
     */
    public CP getRoomRatePrivate() { 
		CP retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-41: "Room Rate - Private" - creates it if necessary
     */
    public CP getIn141_RoomRatePrivate() { 
		CP retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-42: "Insured's Employment Status" - creates it if necessary
     */
    public CE getInsuredSEmploymentStatus() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-42: "Insured's Employment Status" - creates it if necessary
     */
    public CE getIn142_InsuredSEmploymentStatus() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-43: "Insured's Sex" - creates it if necessary
     */
    public IS getInsuredSSex() { 
		IS retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-43: "Insured's Sex" - creates it if necessary
     */
    public IS getIn143_InsuredSSex() { 
		IS retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-44: "Insured's Employer Address" - creates it if necessary
     */
    public XAD getInsuredSEmployerAddress() { 
		XAD retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-44: "Insured's Employer Address" - creates it if necessary
     */
    public XAD getIn144_InsuredSEmployerAddress() { 
		XAD retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-45: "Verification Status" - creates it if necessary
     */
    public ST getVerificationStatus() { 
		ST retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-45: "Verification Status" - creates it if necessary
     */
    public ST getIn145_VerificationStatus() { 
		ST retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-46: "Prior Insurance Plan ID" - creates it if necessary
     */
    public IS getPriorInsurancePlanID() { 
		IS retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-46: "Prior Insurance Plan ID" - creates it if necessary
     */
    public IS getIn146_PriorInsurancePlanID() { 
		IS retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-47: "Coverage Type" - creates it if necessary
     */
    public IS getCoverageType() { 
		IS retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-47: "Coverage Type" - creates it if necessary
     */
    public IS getIn147_CoverageType() { 
		IS retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-48: "Handicap" - creates it if necessary
     */
    public IS getHandicap() { 
		IS retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-48: "Handicap" - creates it if necessary
     */
    public IS getIn148_Handicap() { 
		IS retVal = this.getTypedField(48, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-49: "Insured's ID Number" - creates it if necessary
     */
    public CX getInsuredSIDNumber() { 
		CX retVal = this.getTypedField(49, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-49: "Insured's ID Number" - creates it if necessary
     */
    public CX getIn149_InsuredSIDNumber() { 
		CX retVal = this.getTypedField(49, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CX(getMessage());
          case 3: return new XON(getMessage());
          case 4: return new XAD(getMessage());
          case 5: return new XPN(getMessage());
          case 6: return new XTN(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new XON(getMessage());
          case 9: return new CX(getMessage());
          case 10: return new XON(getMessage());
          case 11: return new DT(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new CM_AUI(getMessage());
          case 14: return new IS(getMessage(), new Integer( 86 ));
          case 15: return new XPN(getMessage());
          case 16: return new IS(getMessage(), new Integer( 63 ));
          case 17: return new TS(getMessage());
          case 18: return new XAD(getMessage());
          case 19: return new IS(getMessage(), new Integer( 135 ));
          case 20: return new IS(getMessage(), new Integer( 173 ));
          case 21: return new ST(getMessage());
          case 22: return new ID(getMessage(), new Integer( 136 ));
          case 23: return new DT(getMessage());
          case 24: return new ID(getMessage(), new Integer( 136 ));
          case 25: return new DT(getMessage());
          case 26: return new IS(getMessage(), new Integer( 93 ));
          case 27: return new ST(getMessage());
          case 28: return new TS(getMessage());
          case 29: return new XPN(getMessage());
          case 30: return new IS(getMessage(), new Integer( 98 ));
          case 31: return new IS(getMessage(), new Integer( 22 ));
          case 32: return new NM(getMessage());
          case 33: return new NM(getMessage());
          case 34: return new IS(getMessage(), new Integer( 42 ));
          case 35: return new ST(getMessage());
          case 36: return new CP(getMessage());
          case 37: return new CP(getMessage());
          case 38: return new NM(getMessage());
          case 39: return new CP(getMessage());
          case 40: return new CP(getMessage());
          case 41: return new CE(getMessage());
          case 42: return new IS(getMessage(), new Integer( 1 ));
          case 43: return new XAD(getMessage());
          case 44: return new ST(getMessage());
          case 45: return new IS(getMessage(), new Integer( 72 ));
          case 46: return new IS(getMessage(), new Integer( 309 ));
          case 47: return new IS(getMessage(), new Integer( 310 ));
          case 48: return new CX(getMessage());
          default: return null;
       }
   }


}

