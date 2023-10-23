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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 IN2 message segment (Insurance Additional Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN2-1: Insured's Employee ID (CX) <b>optional repeating</b>
     * <li>IN2-2: Insured's Social Security Number (ST) <b>optional </b>
     * <li>IN2-3: Insured's Employer's Name and ID (XCN) <b>optional repeating</b>
     * <li>IN2-4: Employer Information Data (IS) <b>optional </b>
     * <li>IN2-5: Mail Claim Party (IS) <b>optional repeating</b>
     * <li>IN2-6: Medicare Health Ins Card Number (ST) <b>optional </b>
     * <li>IN2-7: Medicaid Case Name (XPN) <b>optional repeating</b>
     * <li>IN2-8: Medicaid Case Number (ST) <b>optional </b>
     * <li>IN2-9: Military Sponsor Name (XPN) <b>optional repeating</b>
     * <li>IN2-10: Military ID Number (ST) <b>optional </b>
     * <li>IN2-11: Dependent Of Military Recipient (CE) <b>optional </b>
     * <li>IN2-12: Military Organization (ST) <b>optional </b>
     * <li>IN2-13: Military Station (ST) <b>optional </b>
     * <li>IN2-14: Military Service (IS) <b>optional </b>
     * <li>IN2-15: Military Rank/Grade (IS) <b>optional </b>
     * <li>IN2-16: Military Status (IS) <b>optional </b>
     * <li>IN2-17: Military Retire Date (DT) <b>optional </b>
     * <li>IN2-18: Military Non-Avail Cert On File (ID) <b>optional </b>
     * <li>IN2-19: Baby Coverage (ID) <b>optional </b>
     * <li>IN2-20: Combine Baby Bill (ID) <b>optional </b>
     * <li>IN2-21: Blood Deductible (ST) <b>optional </b>
     * <li>IN2-22: Special Coverage Approval Name (XPN) <b>optional repeating</b>
     * <li>IN2-23: Special Coverage Approval Title (ST) <b>optional </b>
     * <li>IN2-24: Non-Covered Insurance Code (IS) <b>optional repeating</b>
     * <li>IN2-25: Payor ID (CX) <b>optional repeating</b>
     * <li>IN2-26: Payor Subscriber ID (CX) <b>optional repeating</b>
     * <li>IN2-27: Eligibility Source (IS) <b>optional </b>
     * <li>IN2-28: Room Coverage Type/Amount (RMC) <b>optional repeating</b>
     * <li>IN2-29: Policy Type/Amount (PTA) <b>optional repeating</b>
     * <li>IN2-30: Daily Deductible (DDI) <b>optional </b>
     * <li>IN2-31: Living Dependency (IS) <b>optional </b>
     * <li>IN2-32: Ambulatory Status (IS) <b>optional repeating</b>
     * <li>IN2-33: Citizenship (CE) <b>optional repeating</b>
     * <li>IN2-34: Primary Language (CE) <b>optional </b>
     * <li>IN2-35: Living Arrangement (IS) <b>optional </b>
     * <li>IN2-36: Publicity Code (CE) <b>optional </b>
     * <li>IN2-37: Protection Indicator (ID) <b>optional </b>
     * <li>IN2-38: Student Indicator (IS) <b>optional </b>
     * <li>IN2-39: Religion (CE) <b>optional </b>
     * <li>IN2-40: Mother's Maiden Name (XPN) <b>optional repeating</b>
     * <li>IN2-41: Nationality (CE) <b>optional </b>
     * <li>IN2-42: Ethnic Group (CE) <b>optional repeating</b>
     * <li>IN2-43: Marital Status (CE) <b>optional repeating</b>
     * <li>IN2-44: Insured's Employment Start Date (DT) <b>optional </b>
     * <li>IN2-45: Employment Stop Date (DT) <b>optional </b>
     * <li>IN2-46: Job Title (ST) <b>optional </b>
     * <li>IN2-47: Job Code/Class (JCC) <b>optional </b>
     * <li>IN2-48: Job Status (IS) <b>optional </b>
     * <li>IN2-49: Employer Contact Person Name (XPN) <b>optional repeating</b>
     * <li>IN2-50: Employer Contact Person Phone Number (XTN) <b>optional repeating</b>
     * <li>IN2-51: Employer Contact Reason (IS) <b>optional </b>
     * <li>IN2-52: Insured's Contact Person's Name (XPN) <b>optional repeating</b>
     * <li>IN2-53: Insured's Contact Person Phone Number (XTN) <b>optional repeating</b>
     * <li>IN2-54: Insured's Contact Person Reason (IS) <b>optional repeating</b>
     * <li>IN2-55: Relationship To The Patient Start Date (DT) <b>optional </b>
     * <li>IN2-56: Relationship To The Patient Stop Date (DT) <b>optional repeating</b>
     * <li>IN2-57: Insurance Co. Contact Reason (IS) <b>optional </b>
     * <li>IN2-58: Insurance Co Contact Phone Number (XTN) <b>optional </b>
     * <li>IN2-59: Policy Scope (IS) <b>optional </b>
     * <li>IN2-60: Policy Source (IS) <b>optional </b>
     * <li>IN2-61: Patient Member Number (CX) <b>optional </b>
     * <li>IN2-62: Guarantor's Relationship To Insured (CE) <b>optional </b>
     * <li>IN2-63: Insured's Phone Number - Home (XTN) <b>optional repeating</b>
     * <li>IN2-64: Insured's Employer Phone Number (XTN) <b>optional repeating</b>
     * <li>IN2-65: Military Handicapped Program (CE) <b>optional </b>
     * <li>IN2-66: Suspend Flag (ID) <b>optional </b>
     * <li>IN2-67: Copay Limit Flag (ID) <b>optional </b>
     * <li>IN2-68: Stoploss Limit Flag (ID) <b>optional </b>
     * <li>IN2-69: Insured Organization Name And ID (XON) <b>optional repeating</b>
     * <li>IN2-70: Insured Employer Organization Name And ID (XON) <b>optional repeating</b>
     * <li>IN2-71: Race (CE) <b>optional repeating</b>
     * <li>IN2-72: HCFA Patient's Relationship to Insured (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IN2 extends AbstractSegment {

    /** 
     * Creates a new IN2 segment
     */
    public IN2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CX.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Employee ID");
                                  this.add(ST.class, false, 1, 11, new Object[]{ getMessage() }, "Insured's Social Security Number");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Employer's Name and ID");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(139) }, "Employer Information Data");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(137) }, "Mail Claim Party");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Medicare Health Ins Card Number");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Medicaid Case Name");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Medicaid Case Number");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Military Sponsor Name");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Military ID Number");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Dependent Of Military Recipient");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Military Organization");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Military Station");
                                              this.add(IS.class, false, 1, 14, new Object[]{ getMessage(), new Integer(140) }, "Military Service");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(141) }, "Military Rank/Grade");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(142) }, "Military Status");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Military Retire Date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Military Non-Avail Cert On File");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Baby Coverage");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Combine Baby Bill");
                                  this.add(ST.class, false, 1, 1, new Object[]{ getMessage() }, "Blood Deductible");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Special Coverage Approval Name");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Special Coverage Approval Title");
                                              this.add(IS.class, false, 0, 8, new Object[]{ getMessage(), new Integer(143) }, "Non-Covered Insurance Code");
                                  this.add(CX.class, false, 0, 250, new Object[]{ getMessage() }, "Payor ID");
                                  this.add(CX.class, false, 0, 250, new Object[]{ getMessage() }, "Payor Subscriber ID");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(144) }, "Eligibility Source");
                                  this.add(RMC.class, false, 0, 250, new Object[]{ getMessage() }, "Room Coverage Type/Amount");
                                  this.add(PTA.class, false, 0, 250, new Object[]{ getMessage() }, "Policy Type/Amount");
                                  this.add(DDI.class, false, 1, 250, new Object[]{ getMessage() }, "Daily Deductible");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(223) }, "Living Dependency");
                                              this.add(IS.class, false, 0, 2, new Object[]{ getMessage(), new Integer(9) }, "Ambulatory Status");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Citizenship");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Primary Language");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(220) }, "Living Arrangement");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Publicity Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Protection Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(231) }, "Student Indicator");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Religion");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Mother's Maiden Name");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Nationality");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Ethnic Group");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Marital Status");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Insured's Employment Start Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Employment Stop Date");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Job Title");
                                  this.add(JCC.class, false, 1, 20, new Object[]{ getMessage() }, "Job Code/Class");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(311) }, "Job Status");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Employer Contact Person Name");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Employer Contact Person Phone Number");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(222) }, "Employer Contact Reason");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Contact Person's Name");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Contact Person Phone Number");
                                              this.add(IS.class, false, 0, 2, new Object[]{ getMessage(), new Integer(222) }, "Insured's Contact Person Reason");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Relationship To The Patient Start Date");
                                  this.add(DT.class, false, 0, 8, new Object[]{ getMessage() }, "Relationship To The Patient Stop Date");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(232) }, "Insurance Co. Contact Reason");
                                  this.add(XTN.class, false, 1, 250, new Object[]{ getMessage() }, "Insurance Co Contact Phone Number");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(312) }, "Policy Scope");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(313) }, "Policy Source");
                                  this.add(CX.class, false, 1, 250, new Object[]{ getMessage() }, "Patient Member Number");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Guarantor's Relationship To Insured");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Phone Number - Home");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Employer Phone Number");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Military Handicapped Program");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Suspend Flag");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Copay Limit Flag");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Stoploss Limit Flag");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Insured Organization Name And ID");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Insured Employer Organization Name And ID");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Race");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "HCFA Patient's Relationship to Insured");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN2 - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Insured's Employee ID (IN2-1).
     */
    public CX[] getInsuredSEmployeeID() {
    	CX[] retVal = this.getTypedField(1, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Employee ID (IN2-1).
     */
    public CX[] getIn21_InsuredSEmployeeID() {
    	CX[] retVal = this.getTypedField(1, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Employee ID (IN2-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSEmployeeIDReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * IN2-1: "Insured's Employee ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getInsuredSEmployeeID(int rep) { 
		CX retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-1: "Insured's Employee ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getIn21_InsuredSEmployeeID(int rep) { 
		CX retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Employee ID (IN2-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn21_InsuredSEmployeeIDReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * IN2-1: "Insured's Employee ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertInsuredSEmployeeID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-1: "Insured's Employee ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertIn21_InsuredSEmployeeID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * IN2-1: "Insured's Employee ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeInsuredSEmployeeID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * IN2-1: "Insured's Employee ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeIn21_InsuredSEmployeeID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * IN2-2: "Insured's Social Security Number" - creates it if necessary
     */
    public ST getInsuredSSocialSecurityNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-2: "Insured's Social Security Number" - creates it if necessary
     */
    public ST getIn22_InsuredSSocialSecurityNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured's Employer's Name and ID (IN2-3).
     */
    public XCN[] getInsuredSEmployerSNameAndID() {
    	XCN[] retVal = this.getTypedField(3, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Employer's Name and ID (IN2-3).
     */
    public XCN[] getIn23_InsuredSEmployerSNameAndID() {
    	XCN[] retVal = this.getTypedField(3, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Employer's Name and ID (IN2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSEmployerSNameAndIDReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * IN2-3: "Insured's Employer's Name and ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getInsuredSEmployerSNameAndID(int rep) { 
		XCN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-3: "Insured's Employer's Name and ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getIn23_InsuredSEmployerSNameAndID(int rep) { 
		XCN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Employer's Name and ID (IN2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn23_InsuredSEmployerSNameAndIDReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * IN2-3: "Insured's Employer's Name and ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertInsuredSEmployerSNameAndID(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-3: "Insured's Employer's Name and ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertIn23_InsuredSEmployerSNameAndID(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * IN2-3: "Insured's Employer's Name and ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeInsuredSEmployerSNameAndID(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * IN2-3: "Insured's Employer's Name and ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeIn23_InsuredSEmployerSNameAndID(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * IN2-4: "Employer Information Data" - creates it if necessary
     */
    public IS getEmployerInformationData() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-4: "Employer Information Data" - creates it if necessary
     */
    public IS getIn24_EmployerInformationData() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Mail Claim Party (IN2-5).
     */
    public IS[] getMailClaimParty() {
    	IS[] retVal = this.getTypedField(5, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Mail Claim Party (IN2-5).
     */
    public IS[] getIn25_MailClaimParty() {
    	IS[] retVal = this.getTypedField(5, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Mail Claim Party (IN2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMailClaimPartyReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * IN2-5: "Mail Claim Party" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getMailClaimParty(int rep) { 
		IS retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-5: "Mail Claim Party" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getIn25_MailClaimParty(int rep) { 
		IS retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Mail Claim Party (IN2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn25_MailClaimPartyReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * IN2-5: "Mail Claim Party" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertMailClaimParty(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-5: "Mail Claim Party" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertIn25_MailClaimParty(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * IN2-5: "Mail Claim Party" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeMailClaimParty(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * IN2-5: "Mail Claim Party" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeIn25_MailClaimParty(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * IN2-6: "Medicare Health Ins Card Number" - creates it if necessary
     */
    public ST getMedicareHealthInsCardNumber() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-6: "Medicare Health Ins Card Number" - creates it if necessary
     */
    public ST getIn26_MedicareHealthInsCardNumber() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Medicaid Case Name (IN2-7).
     */
    public XPN[] getMedicaidCaseName() {
    	XPN[] retVal = this.getTypedField(7, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Medicaid Case Name (IN2-7).
     */
    public XPN[] getIn27_MedicaidCaseName() {
    	XPN[] retVal = this.getTypedField(7, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Medicaid Case Name (IN2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMedicaidCaseNameReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * IN2-7: "Medicaid Case Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMedicaidCaseName(int rep) { 
		XPN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-7: "Medicaid Case Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn27_MedicaidCaseName(int rep) { 
		XPN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Medicaid Case Name (IN2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn27_MedicaidCaseNameReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * IN2-7: "Medicaid Case Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMedicaidCaseName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-7: "Medicaid Case Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn27_MedicaidCaseName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN2-7: "Medicaid Case Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMedicaidCaseName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN2-7: "Medicaid Case Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn27_MedicaidCaseName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * IN2-8: "Medicaid Case Number" - creates it if necessary
     */
    public ST getMedicaidCaseNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-8: "Medicaid Case Number" - creates it if necessary
     */
    public ST getIn28_MedicaidCaseNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Military Sponsor Name (IN2-9).
     */
    public XPN[] getMilitarySponsorName() {
    	XPN[] retVal = this.getTypedField(9, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Military Sponsor Name (IN2-9).
     */
    public XPN[] getIn29_MilitarySponsorName() {
    	XPN[] retVal = this.getTypedField(9, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Military Sponsor Name (IN2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMilitarySponsorNameReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * IN2-9: "Military Sponsor Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMilitarySponsorName(int rep) { 
		XPN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-9: "Military Sponsor Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn29_MilitarySponsorName(int rep) { 
		XPN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Military Sponsor Name (IN2-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn29_MilitarySponsorNameReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * IN2-9: "Military Sponsor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMilitarySponsorName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-9: "Military Sponsor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn29_MilitarySponsorName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * IN2-9: "Military Sponsor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMilitarySponsorName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * IN2-9: "Military Sponsor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn29_MilitarySponsorName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * IN2-10: "Military ID Number" - creates it if necessary
     */
    public ST getMilitaryIDNumber() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-10: "Military ID Number" - creates it if necessary
     */
    public ST getIn210_MilitaryIDNumber() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-11: "Dependent Of Military Recipient" - creates it if necessary
     */
    public CE getDependentOfMilitaryRecipient() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-11: "Dependent Of Military Recipient" - creates it if necessary
     */
    public CE getIn211_DependentOfMilitaryRecipient() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-12: "Military Organization" - creates it if necessary
     */
    public ST getMilitaryOrganization() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-12: "Military Organization" - creates it if necessary
     */
    public ST getIn212_MilitaryOrganization() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-13: "Military Station" - creates it if necessary
     */
    public ST getMilitaryStation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-13: "Military Station" - creates it if necessary
     */
    public ST getIn213_MilitaryStation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-14: "Military Service" - creates it if necessary
     */
    public IS getMilitaryService() { 
		IS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-14: "Military Service" - creates it if necessary
     */
    public IS getIn214_MilitaryService() { 
		IS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-15: "Military Rank/Grade" - creates it if necessary
     */
    public IS getMilitaryRankGrade() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-15: "Military Rank/Grade" - creates it if necessary
     */
    public IS getIn215_MilitaryRankGrade() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-16: "Military Status" - creates it if necessary
     */
    public IS getMilitaryStatus() { 
		IS retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-16: "Military Status" - creates it if necessary
     */
    public IS getIn216_MilitaryStatus() { 
		IS retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-17: "Military Retire Date" - creates it if necessary
     */
    public DT getMilitaryRetireDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-17: "Military Retire Date" - creates it if necessary
     */
    public DT getIn217_MilitaryRetireDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-18: "Military Non-Avail Cert On File" - creates it if necessary
     */
    public ID getMilitaryNonAvailCertOnFile() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-18: "Military Non-Avail Cert On File" - creates it if necessary
     */
    public ID getIn218_MilitaryNonAvailCertOnFile() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-19: "Baby Coverage" - creates it if necessary
     */
    public ID getBabyCoverage() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-19: "Baby Coverage" - creates it if necessary
     */
    public ID getIn219_BabyCoverage() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-20: "Combine Baby Bill" - creates it if necessary
     */
    public ID getCombineBabyBill() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-20: "Combine Baby Bill" - creates it if necessary
     */
    public ID getIn220_CombineBabyBill() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-21: "Blood Deductible" - creates it if necessary
     */
    public ST getBloodDeductible() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-21: "Blood Deductible" - creates it if necessary
     */
    public ST getIn221_BloodDeductible() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Special Coverage Approval Name (IN2-22).
     */
    public XPN[] getSpecialCoverageApprovalName() {
    	XPN[] retVal = this.getTypedField(22, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Special Coverage Approval Name (IN2-22).
     */
    public XPN[] getIn222_SpecialCoverageApprovalName() {
    	XPN[] retVal = this.getTypedField(22, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Special Coverage Approval Name (IN2-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecialCoverageApprovalNameReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * IN2-22: "Special Coverage Approval Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getSpecialCoverageApprovalName(int rep) { 
		XPN retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-22: "Special Coverage Approval Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn222_SpecialCoverageApprovalName(int rep) { 
		XPN retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Special Coverage Approval Name (IN2-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn222_SpecialCoverageApprovalNameReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * IN2-22: "Special Coverage Approval Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertSpecialCoverageApprovalName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-22: "Special Coverage Approval Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn222_SpecialCoverageApprovalName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * IN2-22: "Special Coverage Approval Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeSpecialCoverageApprovalName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * IN2-22: "Special Coverage Approval Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn222_SpecialCoverageApprovalName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(22, rep);
    }




    /**
     * Returns
     * IN2-23: "Special Coverage Approval Title" - creates it if necessary
     */
    public ST getSpecialCoverageApprovalTitle() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-23: "Special Coverage Approval Title" - creates it if necessary
     */
    public ST getIn223_SpecialCoverageApprovalTitle() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Non-Covered Insurance Code (IN2-24).
     */
    public IS[] getNonCoveredInsuranceCode() {
    	IS[] retVal = this.getTypedField(24, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Non-Covered Insurance Code (IN2-24).
     */
    public IS[] getIn224_NonCoveredInsuranceCode() {
    	IS[] retVal = this.getTypedField(24, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Non-Covered Insurance Code (IN2-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNonCoveredInsuranceCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * IN2-24: "Non-Covered Insurance Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getNonCoveredInsuranceCode(int rep) { 
		IS retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-24: "Non-Covered Insurance Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getIn224_NonCoveredInsuranceCode(int rep) { 
		IS retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Non-Covered Insurance Code (IN2-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn224_NonCoveredInsuranceCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertNonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertIn224_NonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeNonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeIn224_NonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(24, rep);
    }



    /**
     * Returns all repetitions of Payor ID (IN2-25).
     */
    public CX[] getPayorID() {
    	CX[] retVal = this.getTypedField(25, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Payor ID (IN2-25).
     */
    public CX[] getIn225_PayorID() {
    	CX[] retVal = this.getTypedField(25, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Payor ID (IN2-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPayorIDReps() {
    	return this.getReps(25);
    }


    /**
     * Returns a specific repetition of
     * IN2-25: "Payor ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPayorID(int rep) { 
		CX retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-25: "Payor ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getIn225_PayorID(int rep) { 
		CX retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Payor ID (IN2-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn225_PayorIDReps() {
    	return this.getReps(25);
    }


    /**
     * Inserts a repetition of
     * IN2-25: "Payor ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPayorID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(25, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-25: "Payor ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertIn225_PayorID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * IN2-25: "Payor ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePayorID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * IN2-25: "Payor ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeIn225_PayorID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(25, rep);
    }



    /**
     * Returns all repetitions of Payor Subscriber ID (IN2-26).
     */
    public CX[] getPayorSubscriberID() {
    	CX[] retVal = this.getTypedField(26, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Payor Subscriber ID (IN2-26).
     */
    public CX[] getIn226_PayorSubscriberID() {
    	CX[] retVal = this.getTypedField(26, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Payor Subscriber ID (IN2-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPayorSubscriberIDReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * IN2-26: "Payor Subscriber ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPayorSubscriberID(int rep) { 
		CX retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-26: "Payor Subscriber ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getIn226_PayorSubscriberID(int rep) { 
		CX retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Payor Subscriber ID (IN2-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn226_PayorSubscriberIDReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * IN2-26: "Payor Subscriber ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPayorSubscriberID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-26: "Payor Subscriber ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertIn226_PayorSubscriberID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * IN2-26: "Payor Subscriber ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePayorSubscriberID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * IN2-26: "Payor Subscriber ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeIn226_PayorSubscriberID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(26, rep);
    }




    /**
     * Returns
     * IN2-27: "Eligibility Source" - creates it if necessary
     */
    public IS getEligibilitySource() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-27: "Eligibility Source" - creates it if necessary
     */
    public IS getIn227_EligibilitySource() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Room Coverage Type/Amount (IN2-28).
     */
    public RMC[] getRoomCoverageTypeAmount() {
    	RMC[] retVal = this.getTypedField(28, new RMC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Room Coverage Type/Amount (IN2-28).
     */
    public RMC[] getIn228_RoomCoverageTypeAmount() {
    	RMC[] retVal = this.getTypedField(28, new RMC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Room Coverage Type/Amount (IN2-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRoomCoverageTypeAmountReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * IN2-28: "Room Coverage Type/Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public RMC getRoomCoverageTypeAmount(int rep) { 
		RMC retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-28: "Room Coverage Type/Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public RMC getIn228_RoomCoverageTypeAmount(int rep) { 
		RMC retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Room Coverage Type/Amount (IN2-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn228_RoomCoverageTypeAmountReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RMC insertRoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (RMC) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RMC insertIn228_RoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (RMC) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RMC removeRoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (RMC) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RMC removeIn228_RoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (RMC) super.removeRepetition(28, rep);
    }



    /**
     * Returns all repetitions of Policy Type/Amount (IN2-29).
     */
    public PTA[] getPolicyTypeAmount() {
    	PTA[] retVal = this.getTypedField(29, new PTA[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Policy Type/Amount (IN2-29).
     */
    public PTA[] getIn229_PolicyTypeAmount() {
    	PTA[] retVal = this.getTypedField(29, new PTA[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Policy Type/Amount (IN2-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPolicyTypeAmountReps() {
    	return this.getReps(29);
    }


    /**
     * Returns a specific repetition of
     * IN2-29: "Policy Type/Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PTA getPolicyTypeAmount(int rep) { 
		PTA retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-29: "Policy Type/Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PTA getIn229_PolicyTypeAmount(int rep) { 
		PTA retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Policy Type/Amount (IN2-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn229_PolicyTypeAmountReps() {
    	return this.getReps(29);
    }


    /**
     * Inserts a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PTA insertPolicyTypeAmount(int rep) throws HL7Exception { 
        return (PTA) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PTA insertIn229_PolicyTypeAmount(int rep) throws HL7Exception { 
        return (PTA) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PTA removePolicyTypeAmount(int rep) throws HL7Exception { 
        return (PTA) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PTA removeIn229_PolicyTypeAmount(int rep) throws HL7Exception { 
        return (PTA) super.removeRepetition(29, rep);
    }




    /**
     * Returns
     * IN2-30: "Daily Deductible" - creates it if necessary
     */
    public DDI getDailyDeductible() { 
		DDI retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-30: "Daily Deductible" - creates it if necessary
     */
    public DDI getIn230_DailyDeductible() { 
		DDI retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-31: "Living Dependency" - creates it if necessary
     */
    public IS getLivingDependency() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-31: "Living Dependency" - creates it if necessary
     */
    public IS getIn231_LivingDependency() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (IN2-32).
     */
    public IS[] getAmbulatoryStatus() {
    	IS[] retVal = this.getTypedField(32, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (IN2-32).
     */
    public IS[] getIn232_AmbulatoryStatus() {
    	IS[] retVal = this.getTypedField(32, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (IN2-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAmbulatoryStatusReps() {
    	return this.getReps(32);
    }


    /**
     * Returns a specific repetition of
     * IN2-32: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getAmbulatoryStatus(int rep) { 
		IS retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-32: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getIn232_AmbulatoryStatus(int rep) { 
		IS retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (IN2-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn232_AmbulatoryStatusReps() {
    	return this.getReps(32);
    }


    /**
     * Inserts a repetition of
     * IN2-32: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertAmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(32, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-32: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertIn232_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * IN2-32: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeAmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * IN2-32: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeIn232_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(32, rep);
    }



    /**
     * Returns all repetitions of Citizenship (IN2-33).
     */
    public CE[] getCitizenship() {
    	CE[] retVal = this.getTypedField(33, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Citizenship (IN2-33).
     */
    public CE[] getIn233_Citizenship() {
    	CE[] retVal = this.getTypedField(33, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Citizenship (IN2-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCitizenshipReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * IN2-33: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCitizenship(int rep) { 
		CE retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-33: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIn233_Citizenship(int rep) { 
		CE retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Citizenship (IN2-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn233_CitizenshipReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * IN2-33: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCitizenship(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-33: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIn233_Citizenship(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * IN2-33: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCitizenship(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * IN2-33: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIn233_Citizenship(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(33, rep);
    }




    /**
     * Returns
     * IN2-34: "Primary Language" - creates it if necessary
     */
    public CE getPrimaryLanguage() { 
		CE retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-34: "Primary Language" - creates it if necessary
     */
    public CE getIn234_PrimaryLanguage() { 
		CE retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-35: "Living Arrangement" - creates it if necessary
     */
    public IS getLivingArrangement() { 
		IS retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-35: "Living Arrangement" - creates it if necessary
     */
    public IS getIn235_LivingArrangement() { 
		IS retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-36: "Publicity Code" - creates it if necessary
     */
    public CE getPublicityCode() { 
		CE retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-36: "Publicity Code" - creates it if necessary
     */
    public CE getIn236_PublicityCode() { 
		CE retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-37: "Protection Indicator" - creates it if necessary
     */
    public ID getProtectionIndicator() { 
		ID retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-37: "Protection Indicator" - creates it if necessary
     */
    public ID getIn237_ProtectionIndicator() { 
		ID retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-38: "Student Indicator" - creates it if necessary
     */
    public IS getStudentIndicator() { 
		IS retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-38: "Student Indicator" - creates it if necessary
     */
    public IS getIn238_StudentIndicator() { 
		IS retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-39: "Religion" - creates it if necessary
     */
    public CE getReligion() { 
		CE retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-39: "Religion" - creates it if necessary
     */
    public CE getIn239_Religion() { 
		CE retVal = this.getTypedField(39, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (IN2-40).
     */
    public XPN[] getMotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(40, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (IN2-40).
     */
    public XPN[] getIn240_MotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(40, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (IN2-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMotherSMaidenNameReps() {
    	return this.getReps(40);
    }


    /**
     * Returns a specific repetition of
     * IN2-40: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-40: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn240_MotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (IN2-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn240_MotherSMaidenNameReps() {
    	return this.getReps(40);
    }


    /**
     * Inserts a repetition of
     * IN2-40: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(40, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-40: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn240_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * IN2-40: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * IN2-40: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn240_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(40, rep);
    }




    /**
     * Returns
     * IN2-41: "Nationality" - creates it if necessary
     */
    public CE getNationality() { 
		CE retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-41: "Nationality" - creates it if necessary
     */
    public CE getIn241_Nationality() { 
		CE retVal = this.getTypedField(41, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (IN2-42).
     */
    public CE[] getEthnicGroup() {
    	CE[] retVal = this.getTypedField(42, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (IN2-42).
     */
    public CE[] getIn242_EthnicGroup() {
    	CE[] retVal = this.getTypedField(42, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ethnic Group (IN2-42).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEthnicGroupReps() {
    	return this.getReps(42);
    }


    /**
     * Returns a specific repetition of
     * IN2-42: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getEthnicGroup(int rep) { 
		CE retVal = this.getTypedField(42, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-42: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIn242_EthnicGroup(int rep) { 
		CE retVal = this.getTypedField(42, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ethnic Group (IN2-42).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn242_EthnicGroupReps() {
    	return this.getReps(42);
    }


    /**
     * Inserts a repetition of
     * IN2-42: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertEthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(42, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-42: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIn242_EthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(42, rep);
    }


    /**
     * Removes a repetition of
     * IN2-42: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeEthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(42, rep);
    }


    /**
     * Removes a repetition of
     * IN2-42: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIn242_EthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(42, rep);
    }



    /**
     * Returns all repetitions of Marital Status (IN2-43).
     */
    public CE[] getMaritalStatus() {
    	CE[] retVal = this.getTypedField(43, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (IN2-43).
     */
    public CE[] getIn243_MaritalStatus() {
    	CE[] retVal = this.getTypedField(43, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Marital Status (IN2-43).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMaritalStatusReps() {
    	return this.getReps(43);
    }


    /**
     * Returns a specific repetition of
     * IN2-43: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getMaritalStatus(int rep) { 
		CE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-43: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIn243_MaritalStatus(int rep) { 
		CE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Marital Status (IN2-43).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn243_MaritalStatusReps() {
    	return this.getReps(43);
    }


    /**
     * Inserts a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertMaritalStatus(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(43, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIn243_MaritalStatus(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeMaritalStatus(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIn243_MaritalStatus(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(43, rep);
    }




    /**
     * Returns
     * IN2-44: "Insured's Employment Start Date" - creates it if necessary
     */
    public DT getInsuredSEmploymentStartDate() { 
		DT retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-44: "Insured's Employment Start Date" - creates it if necessary
     */
    public DT getIn244_InsuredSEmploymentStartDate() { 
		DT retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-45: "Employment Stop Date" - creates it if necessary
     */
    public DT getEmploymentStopDate() { 
		DT retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-45: "Employment Stop Date" - creates it if necessary
     */
    public DT getIn245_EmploymentStopDate() { 
		DT retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-46: "Job Title" - creates it if necessary
     */
    public ST getJobTitle() { 
		ST retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-46: "Job Title" - creates it if necessary
     */
    public ST getIn246_JobTitle() { 
		ST retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-47: "Job Code/Class" - creates it if necessary
     */
    public JCC getJobCodeClass() { 
		JCC retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-47: "Job Code/Class" - creates it if necessary
     */
    public JCC getIn247_JobCodeClass() { 
		JCC retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-48: "Job Status" - creates it if necessary
     */
    public IS getJobStatus() { 
		IS retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-48: "Job Status" - creates it if necessary
     */
    public IS getIn248_JobStatus() { 
		IS retVal = this.getTypedField(48, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Employer Contact Person Name (IN2-49).
     */
    public XPN[] getEmployerContactPersonName() {
    	XPN[] retVal = this.getTypedField(49, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Employer Contact Person Name (IN2-49).
     */
    public XPN[] getIn249_EmployerContactPersonName() {
    	XPN[] retVal = this.getTypedField(49, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Employer Contact Person Name (IN2-49).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEmployerContactPersonNameReps() {
    	return this.getReps(49);
    }


    /**
     * Returns a specific repetition of
     * IN2-49: "Employer Contact Person Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getEmployerContactPersonName(int rep) { 
		XPN retVal = this.getTypedField(49, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-49: "Employer Contact Person Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn249_EmployerContactPersonName(int rep) { 
		XPN retVal = this.getTypedField(49, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Employer Contact Person Name (IN2-49).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn249_EmployerContactPersonNameReps() {
    	return this.getReps(49);
    }


    /**
     * Inserts a repetition of
     * IN2-49: "Employer Contact Person Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertEmployerContactPersonName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(49, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-49: "Employer Contact Person Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn249_EmployerContactPersonName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(49, rep);
    }


    /**
     * Removes a repetition of
     * IN2-49: "Employer Contact Person Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeEmployerContactPersonName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(49, rep);
    }


    /**
     * Removes a repetition of
     * IN2-49: "Employer Contact Person Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn249_EmployerContactPersonName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(49, rep);
    }



    /**
     * Returns all repetitions of Employer Contact Person Phone Number (IN2-50).
     */
    public XTN[] getEmployerContactPersonPhoneNumber() {
    	XTN[] retVal = this.getTypedField(50, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Employer Contact Person Phone Number (IN2-50).
     */
    public XTN[] getIn250_EmployerContactPersonPhoneNumber() {
    	XTN[] retVal = this.getTypedField(50, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Employer Contact Person Phone Number (IN2-50).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEmployerContactPersonPhoneNumberReps() {
    	return this.getReps(50);
    }


    /**
     * Returns a specific repetition of
     * IN2-50: "Employer Contact Person Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getEmployerContactPersonPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(50, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-50: "Employer Contact Person Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn250_EmployerContactPersonPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(50, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Employer Contact Person Phone Number (IN2-50).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn250_EmployerContactPersonPhoneNumberReps() {
    	return this.getReps(50);
    }


    /**
     * Inserts a repetition of
     * IN2-50: "Employer Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertEmployerContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(50, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-50: "Employer Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn250_EmployerContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(50, rep);
    }


    /**
     * Removes a repetition of
     * IN2-50: "Employer Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeEmployerContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(50, rep);
    }


    /**
     * Removes a repetition of
     * IN2-50: "Employer Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn250_EmployerContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(50, rep);
    }




    /**
     * Returns
     * IN2-51: "Employer Contact Reason" - creates it if necessary
     */
    public IS getEmployerContactReason() { 
		IS retVal = this.getTypedField(51, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-51: "Employer Contact Reason" - creates it if necessary
     */
    public IS getIn251_EmployerContactReason() { 
		IS retVal = this.getTypedField(51, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured's Contact Person's Name (IN2-52).
     */
    public XPN[] getInsuredSContactPersonSName() {
    	XPN[] retVal = this.getTypedField(52, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Contact Person's Name (IN2-52).
     */
    public XPN[] getIn252_InsuredSContactPersonSName() {
    	XPN[] retVal = this.getTypedField(52, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Contact Person's Name (IN2-52).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSContactPersonSNameReps() {
    	return this.getReps(52);
    }


    /**
     * Returns a specific repetition of
     * IN2-52: "Insured's Contact Person's Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getInsuredSContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(52, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-52: "Insured's Contact Person's Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn252_InsuredSContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(52, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Contact Person's Name (IN2-52).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn252_InsuredSContactPersonSNameReps() {
    	return this.getReps(52);
    }


    /**
     * Inserts a repetition of
     * IN2-52: "Insured's Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertInsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(52, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-52: "Insured's Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn252_InsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(52, rep);
    }


    /**
     * Removes a repetition of
     * IN2-52: "Insured's Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeInsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(52, rep);
    }


    /**
     * Removes a repetition of
     * IN2-52: "Insured's Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn252_InsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(52, rep);
    }



    /**
     * Returns all repetitions of Insured's Contact Person Phone Number (IN2-53).
     */
    public XTN[] getInsuredSContactPersonPhoneNumber() {
    	XTN[] retVal = this.getTypedField(53, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Contact Person Phone Number (IN2-53).
     */
    public XTN[] getIn253_InsuredSContactPersonPhoneNumber() {
    	XTN[] retVal = this.getTypedField(53, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Contact Person Phone Number (IN2-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSContactPersonPhoneNumberReps() {
    	return this.getReps(53);
    }


    /**
     * Returns a specific repetition of
     * IN2-53: "Insured's Contact Person Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuredSContactPersonPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-53: "Insured's Contact Person Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn253_InsuredSContactPersonPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Contact Person Phone Number (IN2-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn253_InsuredSContactPersonPhoneNumberReps() {
    	return this.getReps(53);
    }


    /**
     * Inserts a repetition of
     * IN2-53: "Insured's Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuredSContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(53, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-53: "Insured's Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn253_InsuredSContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * IN2-53: "Insured's Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuredSContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * IN2-53: "Insured's Contact Person Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn253_InsuredSContactPersonPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(53, rep);
    }



    /**
     * Returns all repetitions of Insured's Contact Person Reason (IN2-54).
     */
    public IS[] getInsuredSContactPersonReason() {
    	IS[] retVal = this.getTypedField(54, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Contact Person Reason (IN2-54).
     */
    public IS[] getIn254_InsuredSContactPersonReason() {
    	IS[] retVal = this.getTypedField(54, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Contact Person Reason (IN2-54).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSContactPersonReasonReps() {
    	return this.getReps(54);
    }


    /**
     * Returns a specific repetition of
     * IN2-54: "Insured's Contact Person Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getInsuredSContactPersonReason(int rep) { 
		IS retVal = this.getTypedField(54, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-54: "Insured's Contact Person Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getIn254_InsuredSContactPersonReason(int rep) { 
		IS retVal = this.getTypedField(54, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Contact Person Reason (IN2-54).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn254_InsuredSContactPersonReasonReps() {
    	return this.getReps(54);
    }


    /**
     * Inserts a repetition of
     * IN2-54: "Insured's Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertInsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(54, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-54: "Insured's Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertIn254_InsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(54, rep);
    }


    /**
     * Removes a repetition of
     * IN2-54: "Insured's Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeInsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(54, rep);
    }


    /**
     * Removes a repetition of
     * IN2-54: "Insured's Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeIn254_InsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(54, rep);
    }




    /**
     * Returns
     * IN2-55: "Relationship To The Patient Start Date" - creates it if necessary
     */
    public DT getRelationshipToThePatientStartDate() { 
		DT retVal = this.getTypedField(55, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-55: "Relationship To The Patient Start Date" - creates it if necessary
     */
    public DT getIn255_RelationshipToThePatientStartDate() { 
		DT retVal = this.getTypedField(55, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Relationship To The Patient Stop Date (IN2-56).
     */
    public DT[] getRelationshipToThePatientStopDate() {
    	DT[] retVal = this.getTypedField(56, new DT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Relationship To The Patient Stop Date (IN2-56).
     */
    public DT[] getIn256_RelationshipToThePatientStopDate() {
    	DT[] retVal = this.getTypedField(56, new DT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Relationship To The Patient Stop Date (IN2-56).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRelationshipToThePatientStopDateReps() {
    	return this.getReps(56);
    }


    /**
     * Returns a specific repetition of
     * IN2-56: "Relationship To The Patient Stop Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DT getRelationshipToThePatientStopDate(int rep) { 
		DT retVal = this.getTypedField(56, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-56: "Relationship To The Patient Stop Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DT getIn256_RelationshipToThePatientStopDate(int rep) { 
		DT retVal = this.getTypedField(56, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Relationship To The Patient Stop Date (IN2-56).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn256_RelationshipToThePatientStopDateReps() {
    	return this.getReps(56);
    }


    /**
     * Inserts a repetition of
     * IN2-56: "Relationship To The Patient Stop Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT insertRelationshipToThePatientStopDate(int rep) throws HL7Exception { 
        return (DT) super.insertRepetition(56, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-56: "Relationship To The Patient Stop Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT insertIn256_RelationshipToThePatientStopDate(int rep) throws HL7Exception { 
        return (DT) super.insertRepetition(56, rep);
    }


    /**
     * Removes a repetition of
     * IN2-56: "Relationship To The Patient Stop Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT removeRelationshipToThePatientStopDate(int rep) throws HL7Exception { 
        return (DT) super.removeRepetition(56, rep);
    }


    /**
     * Removes a repetition of
     * IN2-56: "Relationship To The Patient Stop Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT removeIn256_RelationshipToThePatientStopDate(int rep) throws HL7Exception { 
        return (DT) super.removeRepetition(56, rep);
    }




    /**
     * Returns
     * IN2-57: "Insurance Co. Contact Reason" - creates it if necessary
     */
    public IS getInsuranceCoContactReason() { 
		IS retVal = this.getTypedField(57, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-57: "Insurance Co. Contact Reason" - creates it if necessary
     */
    public IS getIn257_InsuranceCoContactReason() { 
		IS retVal = this.getTypedField(57, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-58: "Insurance Co Contact Phone Number" - creates it if necessary
     */
    public XTN getInsuranceCoContactPhoneNumber() { 
		XTN retVal = this.getTypedField(58, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-58: "Insurance Co Contact Phone Number" - creates it if necessary
     */
    public XTN getIn258_InsuranceCoContactPhoneNumber() { 
		XTN retVal = this.getTypedField(58, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-59: "Policy Scope" - creates it if necessary
     */
    public IS getPolicyScope() { 
		IS retVal = this.getTypedField(59, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-59: "Policy Scope" - creates it if necessary
     */
    public IS getIn259_PolicyScope() { 
		IS retVal = this.getTypedField(59, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-60: "Policy Source" - creates it if necessary
     */
    public IS getPolicySource() { 
		IS retVal = this.getTypedField(60, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-60: "Policy Source" - creates it if necessary
     */
    public IS getIn260_PolicySource() { 
		IS retVal = this.getTypedField(60, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-61: "Patient Member Number" - creates it if necessary
     */
    public CX getPatientMemberNumber() { 
		CX retVal = this.getTypedField(61, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-61: "Patient Member Number" - creates it if necessary
     */
    public CX getIn261_PatientMemberNumber() { 
		CX retVal = this.getTypedField(61, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-62: "Guarantor's Relationship To Insured" - creates it if necessary
     */
    public CE getGuarantorSRelationshipToInsured() { 
		CE retVal = this.getTypedField(62, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-62: "Guarantor's Relationship To Insured" - creates it if necessary
     */
    public CE getIn262_GuarantorSRelationshipToInsured() { 
		CE retVal = this.getTypedField(62, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured's Phone Number - Home (IN2-63).
     */
    public XTN[] getInsuredSPhoneNumberHome() {
    	XTN[] retVal = this.getTypedField(63, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Phone Number - Home (IN2-63).
     */
    public XTN[] getIn263_InsuredSPhoneNumberHome() {
    	XTN[] retVal = this.getTypedField(63, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Phone Number - Home (IN2-63).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSPhoneNumberHomeReps() {
    	return this.getReps(63);
    }


    /**
     * Returns a specific repetition of
     * IN2-63: "Insured's Phone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuredSPhoneNumberHome(int rep) { 
		XTN retVal = this.getTypedField(63, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-63: "Insured's Phone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn263_InsuredSPhoneNumberHome(int rep) { 
		XTN retVal = this.getTypedField(63, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Phone Number - Home (IN2-63).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn263_InsuredSPhoneNumberHomeReps() {
    	return this.getReps(63);
    }


    /**
     * Inserts a repetition of
     * IN2-63: "Insured's Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuredSPhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(63, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-63: "Insured's Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn263_InsuredSPhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(63, rep);
    }


    /**
     * Removes a repetition of
     * IN2-63: "Insured's Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuredSPhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(63, rep);
    }


    /**
     * Removes a repetition of
     * IN2-63: "Insured's Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn263_InsuredSPhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(63, rep);
    }



    /**
     * Returns all repetitions of Insured's Employer Phone Number (IN2-64).
     */
    public XTN[] getInsuredSEmployerPhoneNumber() {
    	XTN[] retVal = this.getTypedField(64, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Employer Phone Number (IN2-64).
     */
    public XTN[] getIn264_InsuredSEmployerPhoneNumber() {
    	XTN[] retVal = this.getTypedField(64, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Employer Phone Number (IN2-64).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSEmployerPhoneNumberReps() {
    	return this.getReps(64);
    }


    /**
     * Returns a specific repetition of
     * IN2-64: "Insured's Employer Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuredSEmployerPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(64, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-64: "Insured's Employer Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn264_InsuredSEmployerPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(64, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Employer Phone Number (IN2-64).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn264_InsuredSEmployerPhoneNumberReps() {
    	return this.getReps(64);
    }


    /**
     * Inserts a repetition of
     * IN2-64: "Insured's Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuredSEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(64, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-64: "Insured's Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn264_InsuredSEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(64, rep);
    }


    /**
     * Removes a repetition of
     * IN2-64: "Insured's Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuredSEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(64, rep);
    }


    /**
     * Removes a repetition of
     * IN2-64: "Insured's Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn264_InsuredSEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(64, rep);
    }




    /**
     * Returns
     * IN2-65: "Military Handicapped Program" - creates it if necessary
     */
    public CE getMilitaryHandicappedProgram() { 
		CE retVal = this.getTypedField(65, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-65: "Military Handicapped Program" - creates it if necessary
     */
    public CE getIn265_MilitaryHandicappedProgram() { 
		CE retVal = this.getTypedField(65, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-66: "Suspend Flag" - creates it if necessary
     */
    public ID getSuspendFlag() { 
		ID retVal = this.getTypedField(66, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-66: "Suspend Flag" - creates it if necessary
     */
    public ID getIn266_SuspendFlag() { 
		ID retVal = this.getTypedField(66, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-67: "Copay Limit Flag" - creates it if necessary
     */
    public ID getCopayLimitFlag() { 
		ID retVal = this.getTypedField(67, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-67: "Copay Limit Flag" - creates it if necessary
     */
    public ID getIn267_CopayLimitFlag() { 
		ID retVal = this.getTypedField(67, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-68: "Stoploss Limit Flag" - creates it if necessary
     */
    public ID getStoplossLimitFlag() { 
		ID retVal = this.getTypedField(68, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-68: "Stoploss Limit Flag" - creates it if necessary
     */
    public ID getIn268_StoplossLimitFlag() { 
		ID retVal = this.getTypedField(68, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured Organization Name And ID (IN2-69).
     */
    public XON[] getInsuredOrganizationNameAndID() {
    	XON[] retVal = this.getTypedField(69, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured Organization Name And ID (IN2-69).
     */
    public XON[] getIn269_InsuredOrganizationNameAndID() {
    	XON[] retVal = this.getTypedField(69, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured Organization Name And ID (IN2-69).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredOrganizationNameAndIDReps() {
    	return this.getReps(69);
    }


    /**
     * Returns a specific repetition of
     * IN2-69: "Insured Organization Name And ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getInsuredOrganizationNameAndID(int rep) { 
		XON retVal = this.getTypedField(69, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-69: "Insured Organization Name And ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getIn269_InsuredOrganizationNameAndID(int rep) { 
		XON retVal = this.getTypedField(69, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured Organization Name And ID (IN2-69).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn269_InsuredOrganizationNameAndIDReps() {
    	return this.getReps(69);
    }


    /**
     * Inserts a repetition of
     * IN2-69: "Insured Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertInsuredOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(69, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-69: "Insured Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertIn269_InsuredOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(69, rep);
    }


    /**
     * Removes a repetition of
     * IN2-69: "Insured Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeInsuredOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(69, rep);
    }


    /**
     * Removes a repetition of
     * IN2-69: "Insured Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeIn269_InsuredOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(69, rep);
    }



    /**
     * Returns all repetitions of Insured Employer Organization Name And ID (IN2-70).
     */
    public XON[] getInsuredEmployerOrganizationNameAndID() {
    	XON[] retVal = this.getTypedField(70, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured Employer Organization Name And ID (IN2-70).
     */
    public XON[] getIn270_InsuredEmployerOrganizationNameAndID() {
    	XON[] retVal = this.getTypedField(70, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured Employer Organization Name And ID (IN2-70).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredEmployerOrganizationNameAndIDReps() {
    	return this.getReps(70);
    }


    /**
     * Returns a specific repetition of
     * IN2-70: "Insured Employer Organization Name And ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getInsuredEmployerOrganizationNameAndID(int rep) { 
		XON retVal = this.getTypedField(70, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-70: "Insured Employer Organization Name And ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getIn270_InsuredEmployerOrganizationNameAndID(int rep) { 
		XON retVal = this.getTypedField(70, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured Employer Organization Name And ID (IN2-70).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn270_InsuredEmployerOrganizationNameAndIDReps() {
    	return this.getReps(70);
    }


    /**
     * Inserts a repetition of
     * IN2-70: "Insured Employer Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertInsuredEmployerOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(70, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-70: "Insured Employer Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertIn270_InsuredEmployerOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(70, rep);
    }


    /**
     * Removes a repetition of
     * IN2-70: "Insured Employer Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeInsuredEmployerOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(70, rep);
    }


    /**
     * Removes a repetition of
     * IN2-70: "Insured Employer Organization Name And ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeIn270_InsuredEmployerOrganizationNameAndID(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(70, rep);
    }



    /**
     * Returns all repetitions of Race (IN2-71).
     */
    public CE[] getRace() {
    	CE[] retVal = this.getTypedField(71, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Race (IN2-71).
     */
    public CE[] getIn271_Race() {
    	CE[] retVal = this.getTypedField(71, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Race (IN2-71).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRaceReps() {
    	return this.getReps(71);
    }


    /**
     * Returns a specific repetition of
     * IN2-71: "Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRace(int rep) { 
		CE retVal = this.getTypedField(71, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-71: "Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIn271_Race(int rep) { 
		CE retVal = this.getTypedField(71, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Race (IN2-71).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn271_RaceReps() {
    	return this.getReps(71);
    }


    /**
     * Inserts a repetition of
     * IN2-71: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRace(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(71, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-71: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIn271_Race(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(71, rep);
    }


    /**
     * Removes a repetition of
     * IN2-71: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRace(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(71, rep);
    }


    /**
     * Removes a repetition of
     * IN2-71: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIn271_Race(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(71, rep);
    }




    /**
     * Returns
     * IN2-72: "HCFA Patient's Relationship to Insured" - creates it if necessary
     */
    public CE getHCFAPatientSRelationshipToInsured() { 
		CE retVal = this.getTypedField(72, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-72: "HCFA Patient's Relationship to Insured" - creates it if necessary
     */
    public CE getIn272_HCFAPatientSRelationshipToInsured() { 
		CE retVal = this.getTypedField(72, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CX(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new XCN(getMessage());
          case 3: return new IS(getMessage(), new Integer( 139 ));
          case 4: return new IS(getMessage(), new Integer( 137 ));
          case 5: return new ST(getMessage());
          case 6: return new XPN(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new XPN(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new CE(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new IS(getMessage(), new Integer( 140 ));
          case 14: return new IS(getMessage(), new Integer( 141 ));
          case 15: return new IS(getMessage(), new Integer( 142 ));
          case 16: return new DT(getMessage());
          case 17: return new ID(getMessage(), new Integer( 136 ));
          case 18: return new ID(getMessage(), new Integer( 136 ));
          case 19: return new ID(getMessage(), new Integer( 136 ));
          case 20: return new ST(getMessage());
          case 21: return new XPN(getMessage());
          case 22: return new ST(getMessage());
          case 23: return new IS(getMessage(), new Integer( 143 ));
          case 24: return new CX(getMessage());
          case 25: return new CX(getMessage());
          case 26: return new IS(getMessage(), new Integer( 144 ));
          case 27: return new RMC(getMessage());
          case 28: return new PTA(getMessage());
          case 29: return new DDI(getMessage());
          case 30: return new IS(getMessage(), new Integer( 223 ));
          case 31: return new IS(getMessage(), new Integer( 9 ));
          case 32: return new CE(getMessage());
          case 33: return new CE(getMessage());
          case 34: return new IS(getMessage(), new Integer( 220 ));
          case 35: return new CE(getMessage());
          case 36: return new ID(getMessage(), new Integer( 136 ));
          case 37: return new IS(getMessage(), new Integer( 231 ));
          case 38: return new CE(getMessage());
          case 39: return new XPN(getMessage());
          case 40: return new CE(getMessage());
          case 41: return new CE(getMessage());
          case 42: return new CE(getMessage());
          case 43: return new DT(getMessage());
          case 44: return new DT(getMessage());
          case 45: return new ST(getMessage());
          case 46: return new JCC(getMessage());
          case 47: return new IS(getMessage(), new Integer( 311 ));
          case 48: return new XPN(getMessage());
          case 49: return new XTN(getMessage());
          case 50: return new IS(getMessage(), new Integer( 222 ));
          case 51: return new XPN(getMessage());
          case 52: return new XTN(getMessage());
          case 53: return new IS(getMessage(), new Integer( 222 ));
          case 54: return new DT(getMessage());
          case 55: return new DT(getMessage());
          case 56: return new IS(getMessage(), new Integer( 232 ));
          case 57: return new XTN(getMessage());
          case 58: return new IS(getMessage(), new Integer( 312 ));
          case 59: return new IS(getMessage(), new Integer( 313 ));
          case 60: return new CX(getMessage());
          case 61: return new CE(getMessage());
          case 62: return new XTN(getMessage());
          case 63: return new XTN(getMessage());
          case 64: return new CE(getMessage());
          case 65: return new ID(getMessage(), new Integer( 136 ));
          case 66: return new ID(getMessage(), new Integer( 136 ));
          case 67: return new ID(getMessage(), new Integer( 136 ));
          case 68: return new XON(getMessage());
          case 69: return new XON(getMessage());
          case 70: return new CE(getMessage());
          case 71: return new CE(getMessage());
          default: return null;
       }
   }


}

