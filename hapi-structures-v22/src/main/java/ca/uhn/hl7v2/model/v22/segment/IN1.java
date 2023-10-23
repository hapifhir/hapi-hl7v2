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
 *<p>Represents an HL7 IN1 message segment (INSURANCE). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN1-1: Set ID - insurance (SI) <b> </b>
     * <li>IN1-2: Insurance plan ID (ID) <b> </b>
     * <li>IN1-3: Insurance company ID (ST) <b> </b>
     * <li>IN1-4: Insurance company name (ST) <b>optional </b>
     * <li>IN1-5: Insurance company address (AD) <b>optional </b>
     * <li>IN1-6: Insurance company contact pers (PN) <b>optional </b>
     * <li>IN1-7: Insurance company phone number (TN) <b>optional repeating</b>
     * <li>IN1-8: Group number (ST) <b>optional </b>
     * <li>IN1-9: Group name (ST) <b>optional </b>
     * <li>IN1-10: Insured's group employer ID (ST) <b>optional </b>
     * <li>IN1-11: Insured's group employer name (ST) <b>optional </b>
     * <li>IN1-12: Plan effective date (DT) <b>optional </b>
     * <li>IN1-13: Plan expiration date (DT) <b>optional </b>
     * <li>IN1-14: Authorization information (CM_AUI) <b>optional </b>
     * <li>IN1-15: Plan type (ID) <b>optional </b>
     * <li>IN1-16: Name of insured (PN) <b>optional </b>
     * <li>IN1-17: Insured's relationship to patient (ID) <b>optional </b>
     * <li>IN1-18: Insured's date of birth (DT) <b>optional </b>
     * <li>IN1-19: Insured's address (AD) <b>optional </b>
     * <li>IN1-20: Assignment of benefits (ID) <b>optional </b>
     * <li>IN1-21: Coordination of benefits (ID) <b>optional </b>
     * <li>IN1-22: Coordination of benefits - priority (ST) <b>optional </b>
     * <li>IN1-23: Notice of admission code (ID) <b>optional </b>
     * <li>IN1-24: Notice of admission date (DT) <b>optional </b>
     * <li>IN1-25: Report of eligibility code (ID) <b>optional </b>
     * <li>IN1-26: Report of eligibility date (DT) <b>optional </b>
     * <li>IN1-27: Release information code (ID) <b>optional </b>
     * <li>IN1-28: Pre-admit certification (PAC) (ST) <b>optional </b>
     * <li>IN1-29: Verification date / time (TS) <b>optional </b>
     * <li>IN1-30: Verification by (CN) <b>optional </b>
     * <li>IN1-31: Type of agreement code (ID) <b>optional </b>
     * <li>IN1-32: Billing status (ID) <b>optional </b>
     * <li>IN1-33: Lifetime reserve days (NM) <b>optional </b>
     * <li>IN1-34: Delay before lifetime reserve days (NM) <b>optional </b>
     * <li>IN1-35: Company plan code (ID) <b>optional </b>
     * <li>IN1-36: Policy number (ST) <b>optional </b>
     * <li>IN1-37: Policy deductible (NM) <b>optional </b>
     * <li>IN1-38: Policy limit - amount (NM) <b>optional </b>
     * <li>IN1-39: Policy limit - days (NM) <b>optional </b>
     * <li>IN1-40: Room rate - semi-private (NM) <b>optional </b>
     * <li>IN1-41: Room rate - private (NM) <b>optional </b>
     * <li>IN1-42: Insured's employment status (CE) <b>optional </b>
     * <li>IN1-43: Insured's sex (ID) <b>optional </b>
     * <li>IN1-44: Insured's employer address (AD) <b>optional </b>
     * <li>IN1-45: Verification status (ST) <b>optional </b>
     * <li>IN1-46: Prior insurance plan ID (ID) <b>optional </b>
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
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - insurance");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "Insurance plan ID");
                                  this.add(ST.class, true, 1, 9, new Object[]{ getMessage() }, "Insurance company ID");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "Insurance company name");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "Insurance company address");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "Insurance company contact pers");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Insurance company phone number");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Group number");
                                  this.add(ST.class, false, 1, 35, new Object[]{ getMessage() }, "Group name");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Insured's group employer ID");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "Insured's group employer name");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Plan effective date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Plan expiration date");
                                  this.add(CM_AUI.class, false, 1, 55, new Object[]{ getMessage() }, "Authorization information");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(86) }, "Plan type");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "Name of insured");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(63) }, "Insured's relationship to patient");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Insured's date of birth");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "Insured's address");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(135) }, "Assignment of benefits");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(173) }, "Coordination of benefits");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "Coordination of benefits - priority");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Notice of admission code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Notice of admission date");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(0) }, "Report of eligibility code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Report of eligibility date");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(93) }, "Release information code");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Pre-admit certification (PAC)");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Verification date / time");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Verification by");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(98) }, "Type of agreement code");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(22) }, "Billing status");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Lifetime reserve days");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Delay before lifetime reserve days");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(42) }, "Company plan code");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Policy number");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Policy deductible");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Policy limit - amount");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Policy limit - days");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Room rate - semi-private");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Room rate - private");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Insured's employment status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Insured's sex");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "Insured's employer address");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "Verification status");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "Prior insurance plan ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN1-1: "Set ID - insurance" - creates it if necessary
     */
    public SI getSetIDInsurance() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-1: "Set ID - insurance" - creates it if necessary
     */
    public SI getIn11_SetIDInsurance() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-2: "Insurance plan ID" - creates it if necessary
     */
    public ID getInsurancePlanID() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-2: "Insurance plan ID" - creates it if necessary
     */
    public ID getIn12_InsurancePlanID() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-3: "Insurance company ID" - creates it if necessary
     */
    public ST getInsuranceCompanyID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-3: "Insurance company ID" - creates it if necessary
     */
    public ST getIn13_InsuranceCompanyID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-4: "Insurance company name" - creates it if necessary
     */
    public ST getInsuranceCompanyName() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-4: "Insurance company name" - creates it if necessary
     */
    public ST getIn14_InsuranceCompanyName() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-5: "Insurance company address" - creates it if necessary
     */
    public AD getInsuranceCompanyAddress() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-5: "Insurance company address" - creates it if necessary
     */
    public AD getIn15_InsuranceCompanyAddress() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-6: "Insurance company contact pers" - creates it if necessary
     */
    public PN getInsuranceCompanyContactPers() { 
		PN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-6: "Insurance company contact pers" - creates it if necessary
     */
    public PN getIn16_InsuranceCompanyContactPers() { 
		PN retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insurance company phone number (IN1-7).
     */
    public TN[] getInsuranceCompanyPhoneNumber() {
    	TN[] retVal = this.getTypedField(7, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance company phone number (IN1-7).
     */
    public TN[] getIn17_InsuranceCompanyPhoneNumber() {
    	TN[] retVal = this.getTypedField(7, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance company phone number (IN1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCompanyPhoneNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * IN1-7: "Insurance company phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getInsuranceCompanyPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-7: "Insurance company phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getIn17_InsuranceCompanyPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance company phone number (IN1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn17_InsuranceCompanyPhoneNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * IN1-7: "Insurance company phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertInsuranceCompanyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-7: "Insurance company phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertIn17_InsuranceCompanyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN1-7: "Insurance company phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeInsuranceCompanyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN1-7: "Insurance company phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeIn17_InsuranceCompanyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * IN1-8: "Group number" - creates it if necessary
     */
    public ST getGroupNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-8: "Group number" - creates it if necessary
     */
    public ST getIn18_GroupNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-9: "Group name" - creates it if necessary
     */
    public ST getGroupName() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-9: "Group name" - creates it if necessary
     */
    public ST getIn19_GroupName() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-10: "Insured's group employer ID" - creates it if necessary
     */
    public ST getInsuredSGroupEmployerID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-10: "Insured's group employer ID" - creates it if necessary
     */
    public ST getIn110_InsuredSGroupEmployerID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-11: "Insured's group employer name" - creates it if necessary
     */
    public ST getInsuredSGroupEmployerName() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-11: "Insured's group employer name" - creates it if necessary
     */
    public ST getIn111_InsuredSGroupEmployerName() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-12: "Plan effective date" - creates it if necessary
     */
    public DT getPlanEffectiveDate() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-12: "Plan effective date" - creates it if necessary
     */
    public DT getIn112_PlanEffectiveDate() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-13: "Plan expiration date" - creates it if necessary
     */
    public DT getPlanExpirationDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-13: "Plan expiration date" - creates it if necessary
     */
    public DT getIn113_PlanExpirationDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-14: "Authorization information" - creates it if necessary
     */
    public CM_AUI getAuthorizationInformation() { 
		CM_AUI retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-14: "Authorization information" - creates it if necessary
     */
    public CM_AUI getIn114_AuthorizationInformation() { 
		CM_AUI retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-15: "Plan type" - creates it if necessary
     */
    public ID getPlanType() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-15: "Plan type" - creates it if necessary
     */
    public ID getIn115_PlanType() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-16: "Name of insured" - creates it if necessary
     */
    public PN getNameOfInsured() { 
		PN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-16: "Name of insured" - creates it if necessary
     */
    public PN getIn116_NameOfInsured() { 
		PN retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-17: "Insured's relationship to patient" - creates it if necessary
     */
    public ID getInsuredSRelationshipToPatient() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-17: "Insured's relationship to patient" - creates it if necessary
     */
    public ID getIn117_InsuredSRelationshipToPatient() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-18: "Insured's date of birth" - creates it if necessary
     */
    public DT getInsuredSDateOfBirth() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-18: "Insured's date of birth" - creates it if necessary
     */
    public DT getIn118_InsuredSDateOfBirth() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-19: "Insured's address" - creates it if necessary
     */
    public AD getInsuredSAddress() { 
		AD retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-19: "Insured's address" - creates it if necessary
     */
    public AD getIn119_InsuredSAddress() { 
		AD retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-20: "Assignment of benefits" - creates it if necessary
     */
    public ID getAssignmentOfBenefits() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-20: "Assignment of benefits" - creates it if necessary
     */
    public ID getIn120_AssignmentOfBenefits() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-21: "Coordination of benefits" - creates it if necessary
     */
    public ID getCoordinationOfBenefits() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-21: "Coordination of benefits" - creates it if necessary
     */
    public ID getIn121_CoordinationOfBenefits() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-22: "Coordination of benefits - priority" - creates it if necessary
     */
    public ST getCoordinationOfBenefitsPriority() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-22: "Coordination of benefits - priority" - creates it if necessary
     */
    public ST getIn122_CoordinationOfBenefitsPriority() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-23: "Notice of admission code" - creates it if necessary
     */
    public ID getNoticeOfAdmissionCode() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-23: "Notice of admission code" - creates it if necessary
     */
    public ID getIn123_NoticeOfAdmissionCode() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-24: "Notice of admission date" - creates it if necessary
     */
    public DT getNoticeOfAdmissionDate() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-24: "Notice of admission date" - creates it if necessary
     */
    public DT getIn124_NoticeOfAdmissionDate() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-25: "Report of eligibility code" - creates it if necessary
     */
    public ID getReportOfEligibilityCode() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-25: "Report of eligibility code" - creates it if necessary
     */
    public ID getIn125_ReportOfEligibilityCode() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-26: "Report of eligibility date" - creates it if necessary
     */
    public DT getReportOfEligibilityDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-26: "Report of eligibility date" - creates it if necessary
     */
    public DT getIn126_ReportOfEligibilityDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-27: "Release information code" - creates it if necessary
     */
    public ID getReleaseInformationCode() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-27: "Release information code" - creates it if necessary
     */
    public ID getIn127_ReleaseInformationCode() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-28: "Pre-admit certification (PAC)" - creates it if necessary
     */
    public ST getPreAdmitCertification() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-28: "Pre-admit certification (PAC)" - creates it if necessary
     */
    public ST getIn128_PreAdmitCertification() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-29: "Verification date / time" - creates it if necessary
     */
    public TS getVerificationDateTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-29: "Verification date / time" - creates it if necessary
     */
    public TS getIn129_VerificationDateTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-30: "Verification by" - creates it if necessary
     */
    public CN getVerificationBy() { 
		CN retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-30: "Verification by" - creates it if necessary
     */
    public CN getIn130_VerificationBy() { 
		CN retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-31: "Type of agreement code" - creates it if necessary
     */
    public ID getTypeOfAgreementCode() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-31: "Type of agreement code" - creates it if necessary
     */
    public ID getIn131_TypeOfAgreementCode() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-32: "Billing status" - creates it if necessary
     */
    public ID getBillingStatus() { 
		ID retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-32: "Billing status" - creates it if necessary
     */
    public ID getIn132_BillingStatus() { 
		ID retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-33: "Lifetime reserve days" - creates it if necessary
     */
    public NM getLifetimeReserveDays() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-33: "Lifetime reserve days" - creates it if necessary
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
     * IN1-35: "Company plan code" - creates it if necessary
     */
    public ID getCompanyPlanCode() { 
		ID retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-35: "Company plan code" - creates it if necessary
     */
    public ID getIn135_CompanyPlanCode() { 
		ID retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-36: "Policy number" - creates it if necessary
     */
    public ST getPolicyNumber() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-36: "Policy number" - creates it if necessary
     */
    public ST getIn136_PolicyNumber() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-37: "Policy deductible" - creates it if necessary
     */
    public NM getPolicyDeductible() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-37: "Policy deductible" - creates it if necessary
     */
    public NM getIn137_PolicyDeductible() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-38: "Policy limit - amount" - creates it if necessary
     */
    public NM getPolicyLimitAmount() { 
		NM retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-38: "Policy limit - amount" - creates it if necessary
     */
    public NM getIn138_PolicyLimitAmount() { 
		NM retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-39: "Policy limit - days" - creates it if necessary
     */
    public NM getPolicyLimitDays() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-39: "Policy limit - days" - creates it if necessary
     */
    public NM getIn139_PolicyLimitDays() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-40: "Room rate - semi-private" - creates it if necessary
     */
    public NM getRoomRateSemiPrivate() { 
		NM retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-40: "Room rate - semi-private" - creates it if necessary
     */
    public NM getIn140_RoomRateSemiPrivate() { 
		NM retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-41: "Room rate - private" - creates it if necessary
     */
    public NM getRoomRatePrivate() { 
		NM retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-41: "Room rate - private" - creates it if necessary
     */
    public NM getIn141_RoomRatePrivate() { 
		NM retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-42: "Insured's employment status" - creates it if necessary
     */
    public CE getInsuredSEmploymentStatus() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-42: "Insured's employment status" - creates it if necessary
     */
    public CE getIn142_InsuredSEmploymentStatus() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-43: "Insured's sex" - creates it if necessary
     */
    public ID getInsuredSSex() { 
		ID retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-43: "Insured's sex" - creates it if necessary
     */
    public ID getIn143_InsuredSSex() { 
		ID retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-44: "Insured's employer address" - creates it if necessary
     */
    public AD getInsuredSEmployerAddress() { 
		AD retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-44: "Insured's employer address" - creates it if necessary
     */
    public AD getIn144_InsuredSEmployerAddress() { 
		AD retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-45: "Verification status" - creates it if necessary
     */
    public ST getVerificationStatus() { 
		ST retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-45: "Verification status" - creates it if necessary
     */
    public ST getIn145_VerificationStatus() { 
		ST retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-46: "Prior insurance plan ID" - creates it if necessary
     */
    public ID getPriorInsurancePlanID() { 
		ID retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-46: "Prior insurance plan ID" - creates it if necessary
     */
    public ID getIn146_PriorInsurancePlanID() { 
		ID retVal = this.getTypedField(46, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 72 ));
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new AD(getMessage());
          case 5: return new PN(getMessage());
          case 6: return new TN(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new DT(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new CM_AUI(getMessage());
          case 14: return new ID(getMessage(), new Integer( 86 ));
          case 15: return new PN(getMessage());
          case 16: return new ID(getMessage(), new Integer( 63 ));
          case 17: return new DT(getMessage());
          case 18: return new AD(getMessage());
          case 19: return new ID(getMessage(), new Integer( 135 ));
          case 20: return new ID(getMessage(), new Integer( 173 ));
          case 21: return new ST(getMessage());
          case 22: return new ID(getMessage(), new Integer( 136 ));
          case 23: return new DT(getMessage());
          case 24: return new ID(getMessage(), new Integer( 0 ));
          case 25: return new DT(getMessage());
          case 26: return new ID(getMessage(), new Integer( 93 ));
          case 27: return new ST(getMessage());
          case 28: return new TS(getMessage());
          case 29: return new CN(getMessage());
          case 30: return new ID(getMessage(), new Integer( 98 ));
          case 31: return new ID(getMessage(), new Integer( 22 ));
          case 32: return new NM(getMessage());
          case 33: return new NM(getMessage());
          case 34: return new ID(getMessage(), new Integer( 42 ));
          case 35: return new ST(getMessage());
          case 36: return new NM(getMessage());
          case 37: return new NM(getMessage());
          case 38: return new NM(getMessage());
          case 39: return new NM(getMessage());
          case 40: return new NM(getMessage());
          case 41: return new CE(getMessage());
          case 42: return new ID(getMessage(), new Integer( 1 ));
          case 43: return new AD(getMessage());
          case 44: return new ST(getMessage());
          case 45: return new ID(getMessage(), new Integer( 72 ));
          default: return null;
       }
   }


}

