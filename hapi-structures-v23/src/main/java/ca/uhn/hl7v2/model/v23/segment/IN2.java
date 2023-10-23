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
 *<p>Represents an HL7 IN2 message segment (Insurance additional info). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN2-1: Insured's Employee ID (CX) <b>optional </b>
     * <li>IN2-2: Insured's Social Security Number (ST) <b>optional </b>
     * <li>IN2-3: Insured's Employer Name (XCN) <b>optional </b>
     * <li>IN2-4: Employer Information Data (IS) <b>optional </b>
     * <li>IN2-5: Mail Claim Party (IS) <b>optional </b>
     * <li>IN2-6: Medicare Health Ins Card Number (ST) <b>optional </b>
     * <li>IN2-7: Medicaid Case Name (XPN) <b>optional </b>
     * <li>IN2-8: Medicaid Case Number (ST) <b>optional </b>
     * <li>IN2-9: Champus Sponsor Name (XPN) <b>optional </b>
     * <li>IN2-10: Champus ID Number (ST) <b>optional </b>
     * <li>IN2-11: Dependent of Champus Recipient (CE) <b>optional </b>
     * <li>IN2-12: Champus Organization (ST) <b>optional </b>
     * <li>IN2-13: Champus Station (ST) <b>optional </b>
     * <li>IN2-14: Champus Service (IS) <b>optional </b>
     * <li>IN2-15: Champus Rank/Grade (IS) <b>optional </b>
     * <li>IN2-16: Champus Status (IS) <b>optional </b>
     * <li>IN2-17: Champus Retire Date (DT) <b>optional </b>
     * <li>IN2-18: Champus Non-Avail Cert on File (ID) <b>optional </b>
     * <li>IN2-19: Baby Coverage (ID) <b>optional </b>
     * <li>IN2-20: Combine Baby Bill (ID) <b>optional </b>
     * <li>IN2-21: Blood Deductible (ST) <b>optional </b>
     * <li>IN2-22: Special Coverage Approval Name (XPN) <b>optional </b>
     * <li>IN2-23: Special Coverage Approval Title (ST) <b>optional </b>
     * <li>IN2-24: Non-Covered Insurance Code (ST) <b>optional repeating</b>
     * <li>IN2-25: Payor ID (CX) <b>optional </b>
     * <li>IN2-26: Payor Subscriber ID (CX) <b>optional </b>
     * <li>IN2-27: Eligibility Source (IS) <b>optional </b>
     * <li>IN2-28: Room Coverage Type/Amount (CM_RMC) <b>optional repeating</b>
     * <li>IN2-29: Policy Type/Amount (CM_PTA) <b>optional repeating</b>
     * <li>IN2-30: Daily Deductible (CM_DDI) <b>optional </b>
     * <li>IN2-31: Living Dependency (IS) <b>optional </b>
     * <li>IN2-32: Ambulatory Status (IS) <b>optional </b>
     * <li>IN2-33: Citizenship (IS) <b>optional </b>
     * <li>IN2-34: Primary Language (CE) <b>optional </b>
     * <li>IN2-35: Living Arrangement (IS) <b>optional </b>
     * <li>IN2-36: Publicity Indicator (CE) <b>optional </b>
     * <li>IN2-37: Protection Indicator (ID) <b>optional </b>
     * <li>IN2-38: Student Indicator (IS) <b>optional </b>
     * <li>IN2-39: Religion (IS) <b>optional </b>
     * <li>IN2-40: Mother’s Maiden Name (XPN) <b>optional </b>
     * <li>IN2-41: Nationality Code (CE) <b>optional </b>
     * <li>IN2-42: Ethnic Group (IS) <b>optional </b>
     * <li>IN2-43: Marital Status (IS) <b>optional repeating</b>
     * <li>IN2-44: Employment Start Date (DT) <b>optional </b>
     * <li>IN2-45: Employment Stop Date (DT) <b>optional </b>
     * <li>IN2-46: Job Title (ST) <b>optional </b>
     * <li>IN2-47: Job Code/Class (JCC) <b>optional </b>
     * <li>IN2-48: Job Status (IS) <b>optional </b>
     * <li>IN2-49: Employer Contact Person Name (XPN) <b>optional repeating</b>
     * <li>IN2-50: Employer Contact Person Phone Number (XTN) <b>optional repeating</b>
     * <li>IN2-51: Employer Contact Reason (IS) <b>optional </b>
     * <li>IN2-52: Insured’s Contact Person’s Name (XPN) <b>optional repeating</b>
     * <li>IN2-53: Insured’s Contact Person Telephone Number (XTN) <b>optional repeating</b>
     * <li>IN2-54: Insured’s Contact Person Reason (IS) <b>optional repeating</b>
     * <li>IN2-55: Relationship To The Patient Start Date (DT) <b>optional </b>
     * <li>IN2-56: Relationship To The Patient Stop Date (DT) <b>optional repeating</b>
     * <li>IN2-57: Insurance Co. Contact Reason (IS) <b>optional </b>
     * <li>IN2-58: Insurance Co. Contact Phone Number (XTN) <b>optional </b>
     * <li>IN2-59: Policy Scope (IS) <b>optional </b>
     * <li>IN2-60: Policy Source (IS) <b>optional </b>
     * <li>IN2-61: Patient Member Number (CX) <b>optional </b>
     * <li>IN2-62: Guarantor’s Relationship To Insured (IS) <b>optional </b>
     * <li>IN2-63: Insured’s Telephone Number - Home (XTN) <b>optional repeating</b>
     * <li>IN2-64: Insured’s Employer Telephone Number (XTN) <b>optional repeating</b>
     * <li>IN2-65: Military Handicapped Program (CE) <b>optional </b>
     * <li>IN2-66: Suspend Flag (ID) <b>optional </b>
     * <li>IN2-67: Co-pay Limit Flag (ID) <b>optional </b>
     * <li>IN2-68: Stoploss Limit Flag (ID) <b>optional </b>
     * <li>IN2-69: Insured Organization Name And ID (XON) <b>optional repeating</b>
     * <li>IN2-70: Insured Employer Organization Name And ID (XON) <b>optional repeating</b>
     * <li>IN2-71: Race (IS) <b>optional </b>
     * <li>IN2-72: Patient Relationship to Insured (ID) <b>optional </b>
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
                                  this.add(CX.class, false, 1, 59, new Object[]{ getMessage() }, "Insured's Employee ID");
                                  this.add(ST.class, false, 1, 11, new Object[]{ getMessage() }, "Insured's Social Security Number");
                                  this.add(XCN.class, false, 1, 130, new Object[]{ getMessage() }, "Insured's Employer Name");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(139) }, "Employer Information Data");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(137) }, "Mail Claim Party");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Medicare Health Ins Card Number");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Medicaid Case Name");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Medicaid Case Number");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Champus Sponsor Name");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Champus ID Number");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Dependent of Champus Recipient");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Champus Organization");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Champus Station");
                                              this.add(IS.class, false, 1, 14, new Object[]{ getMessage(), new Integer(140) }, "Champus Service");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(141) }, "Champus Rank/Grade");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(142) }, "Champus Status");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Champus Retire Date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Champus Non-Avail Cert on File");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Baby Coverage");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Combine Baby Bill");
                                  this.add(ST.class, false, 1, 1, new Object[]{ getMessage() }, "Blood Deductible");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Special Coverage Approval Name");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Special Coverage Approval Title");
                                  this.add(ST.class, false, 0, 8, new Object[]{ getMessage() }, "Non-Covered Insurance Code");
                                  this.add(CX.class, false, 1, 59, new Object[]{ getMessage() }, "Payor ID");
                                  this.add(CX.class, false, 1, 59, new Object[]{ getMessage() }, "Payor Subscriber ID");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(144) }, "Eligibility Source");
                                  this.add(CM_RMC.class, false, 0, 25, new Object[]{ getMessage() }, "Room Coverage Type/Amount");
                                  this.add(CM_PTA.class, false, 0, 25, new Object[]{ getMessage() }, "Policy Type/Amount");
                                  this.add(CM_DDI.class, false, 1, 25, new Object[]{ getMessage() }, "Daily Deductible");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(223) }, "Living Dependency");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(9) }, "Ambulatory Status");
                                              this.add(IS.class, false, 1, 4, new Object[]{ getMessage(), new Integer(171) }, "Citizenship");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Primary Language");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(220) }, "Living Arrangement");
                                  this.add(CE.class, false, 1, 1, new Object[]{ getMessage() }, "Publicity Indicator");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Protection Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(231) }, "Student Indicator");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(6) }, "Religion");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Mother’s Maiden Name");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Nationality Code");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(189) }, "Ethnic Group");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(2) }, "Marital Status");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Employment Start Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Employment Stop Date");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Job Title");
                                  this.add(JCC.class, false, 1, 20, new Object[]{ getMessage() }, "Job Code/Class");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(311) }, "Job Status");
                                  this.add(XPN.class, false, 0, 48, new Object[]{ getMessage() }, "Employer Contact Person Name");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Employer Contact Person Phone Number");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(222) }, "Employer Contact Reason");
                                  this.add(XPN.class, false, 0, 48, new Object[]{ getMessage() }, "Insured’s Contact Person’s Name");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Insured’s Contact Person Telephone Number");
                                              this.add(IS.class, false, 0, 2, new Object[]{ getMessage(), new Integer(222) }, "Insured’s Contact Person Reason");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Relationship To The Patient Start Date");
                                  this.add(DT.class, false, 0, 8, new Object[]{ getMessage() }, "Relationship To The Patient Stop Date");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(232) }, "Insurance Co. Contact Reason");
                                  this.add(XTN.class, false, 1, 40, new Object[]{ getMessage() }, "Insurance Co. Contact Phone Number");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(312) }, "Policy Scope");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(313) }, "Policy Source");
                                  this.add(CX.class, false, 1, 60, new Object[]{ getMessage() }, "Patient Member Number");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(63) }, "Guarantor’s Relationship To Insured");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Insured’s Telephone Number - Home");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Insured’s Employer Telephone Number");
                                  this.add(CE.class, false, 1, 2, new Object[]{ getMessage() }, "Military Handicapped Program");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Suspend Flag");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Co-pay Limit Flag");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Stoploss Limit Flag");
                                  this.add(XON.class, false, 0, 130, new Object[]{ getMessage() }, "Insured Organization Name And ID");
                                  this.add(XON.class, false, 0, 130, new Object[]{ getMessage() }, "Insured Employer Organization Name And ID");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(5) }, "Race");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "Patient Relationship to Insured");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN2-1: "Insured's Employee ID" - creates it if necessary
     */
    public CX getInsuredSEmployeeID() { 
		CX retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-1: "Insured's Employee ID" - creates it if necessary
     */
    public CX getIn21_InsuredSEmployeeID() { 
		CX retVal = this.getTypedField(1, 0);
		return retVal;
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
     * Returns
     * IN2-3: "Insured's Employer Name" - creates it if necessary
     */
    public XCN getInsuredSEmployerName() { 
		XCN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-3: "Insured's Employer Name" - creates it if necessary
     */
    public XCN getIn23_InsuredSEmployerName() { 
		XCN retVal = this.getTypedField(3, 0);
		return retVal;
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
     * Returns
     * IN2-5: "Mail Claim Party" - creates it if necessary
     */
    public IS getMailClaimParty() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-5: "Mail Claim Party" - creates it if necessary
     */
    public IS getIn25_MailClaimParty() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
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
     * Returns
     * IN2-7: "Medicaid Case Name" - creates it if necessary
     */
    public XPN getMedicaidCaseName() { 
		XPN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-7: "Medicaid Case Name" - creates it if necessary
     */
    public XPN getIn27_MedicaidCaseName() { 
		XPN retVal = this.getTypedField(7, 0);
		return retVal;
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
     * Returns
     * IN2-9: "Champus Sponsor Name" - creates it if necessary
     */
    public XPN getChampusSponsorName() { 
		XPN retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-9: "Champus Sponsor Name" - creates it if necessary
     */
    public XPN getIn29_ChampusSponsorName() { 
		XPN retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-10: "Champus ID Number" - creates it if necessary
     */
    public ST getChampusIDNumber() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-10: "Champus ID Number" - creates it if necessary
     */
    public ST getIn210_ChampusIDNumber() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-11: "Dependent of Champus Recipient" - creates it if necessary
     */
    public CE getDependentOfChampusRecipient() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-11: "Dependent of Champus Recipient" - creates it if necessary
     */
    public CE getIn211_DependentOfChampusRecipient() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-12: "Champus Organization" - creates it if necessary
     */
    public ST getChampusOrganization() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-12: "Champus Organization" - creates it if necessary
     */
    public ST getIn212_ChampusOrganization() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-13: "Champus Station" - creates it if necessary
     */
    public ST getChampusStation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-13: "Champus Station" - creates it if necessary
     */
    public ST getIn213_ChampusStation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-14: "Champus Service" - creates it if necessary
     */
    public IS getChampusService() { 
		IS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-14: "Champus Service" - creates it if necessary
     */
    public IS getIn214_ChampusService() { 
		IS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-15: "Champus Rank/Grade" - creates it if necessary
     */
    public IS getChampusRankGrade() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-15: "Champus Rank/Grade" - creates it if necessary
     */
    public IS getIn215_ChampusRankGrade() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-16: "Champus Status" - creates it if necessary
     */
    public IS getChampusStatus() { 
		IS retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-16: "Champus Status" - creates it if necessary
     */
    public IS getIn216_ChampusStatus() { 
		IS retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-17: "Champus Retire Date" - creates it if necessary
     */
    public DT getChampusRetireDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-17: "Champus Retire Date" - creates it if necessary
     */
    public DT getIn217_ChampusRetireDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-18: "Champus Non-Avail Cert on File" - creates it if necessary
     */
    public ID getChampusNonAvailCertOnFile() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-18: "Champus Non-Avail Cert on File" - creates it if necessary
     */
    public ID getIn218_ChampusNonAvailCertOnFile() { 
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
     * Returns
     * IN2-22: "Special Coverage Approval Name" - creates it if necessary
     */
    public XPN getSpecialCoverageApprovalName() { 
		XPN retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-22: "Special Coverage Approval Name" - creates it if necessary
     */
    public XPN getIn222_SpecialCoverageApprovalName() { 
		XPN retVal = this.getTypedField(22, 0);
		return retVal;
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
    public ST[] getNonCoveredInsuranceCode() {
    	ST[] retVal = this.getTypedField(24, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Non-Covered Insurance Code (IN2-24).
     */
    public ST[] getIn224_NonCoveredInsuranceCode() {
    	ST[] retVal = this.getTypedField(24, new ST[0]);
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
    public ST getNonCoveredInsuranceCode(int rep) { 
		ST retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-24: "Non-Covered Insurance Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getIn224_NonCoveredInsuranceCode(int rep) { 
		ST retVal = this.getTypedField(24, rep);
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
    public ST insertNonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertIn224_NonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeNonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN2-24: "Non-Covered Insurance Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeIn224_NonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * IN2-25: "Payor ID" - creates it if necessary
     */
    public CX getPayorID() { 
		CX retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-25: "Payor ID" - creates it if necessary
     */
    public CX getIn225_PayorID() { 
		CX retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-26: "Payor Subscriber ID" - creates it if necessary
     */
    public CX getPayorSubscriberID() { 
		CX retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-26: "Payor Subscriber ID" - creates it if necessary
     */
    public CX getIn226_PayorSubscriberID() { 
		CX retVal = this.getTypedField(26, 0);
		return retVal;
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
    public CM_RMC[] getRoomCoverageTypeAmount() {
    	CM_RMC[] retVal = this.getTypedField(28, new CM_RMC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Room Coverage Type/Amount (IN2-28).
     */
    public CM_RMC[] getIn228_RoomCoverageTypeAmount() {
    	CM_RMC[] retVal = this.getTypedField(28, new CM_RMC[0]);
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
    public CM_RMC getRoomCoverageTypeAmount(int rep) { 
		CM_RMC retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-28: "Room Coverage Type/Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_RMC getIn228_RoomCoverageTypeAmount(int rep) { 
		CM_RMC retVal = this.getTypedField(28, rep);
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
    public CM_RMC insertRoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC insertIn228_RoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC removeRoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * IN2-28: "Room Coverage Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC removeIn228_RoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.removeRepetition(28, rep);
    }



    /**
     * Returns all repetitions of Policy Type/Amount (IN2-29).
     */
    public CM_PTA[] getPolicyTypeAmount() {
    	CM_PTA[] retVal = this.getTypedField(29, new CM_PTA[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Policy Type/Amount (IN2-29).
     */
    public CM_PTA[] getIn229_PolicyTypeAmount() {
    	CM_PTA[] retVal = this.getTypedField(29, new CM_PTA[0]);
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
    public CM_PTA getPolicyTypeAmount(int rep) { 
		CM_PTA retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-29: "Policy Type/Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PTA getIn229_PolicyTypeAmount(int rep) { 
		CM_PTA retVal = this.getTypedField(29, rep);
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
    public CM_PTA insertPolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA insertIn229_PolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA removePolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * IN2-29: "Policy Type/Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA removeIn229_PolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.removeRepetition(29, rep);
    }




    /**
     * Returns
     * IN2-30: "Daily Deductible" - creates it if necessary
     */
    public CM_DDI getDailyDeductible() { 
		CM_DDI retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-30: "Daily Deductible" - creates it if necessary
     */
    public CM_DDI getIn230_DailyDeductible() { 
		CM_DDI retVal = this.getTypedField(30, 0);
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
     * Returns
     * IN2-32: "Ambulatory Status" - creates it if necessary
     */
    public IS getAmbulatoryStatus() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-32: "Ambulatory Status" - creates it if necessary
     */
    public IS getIn232_AmbulatoryStatus() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-33: "Citizenship" - creates it if necessary
     */
    public IS getCitizenship() { 
		IS retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-33: "Citizenship" - creates it if necessary
     */
    public IS getIn233_Citizenship() { 
		IS retVal = this.getTypedField(33, 0);
		return retVal;
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
     * IN2-36: "Publicity Indicator" - creates it if necessary
     */
    public CE getPublicityIndicator() { 
		CE retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-36: "Publicity Indicator" - creates it if necessary
     */
    public CE getIn236_PublicityIndicator() { 
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
    public IS getReligion() { 
		IS retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-39: "Religion" - creates it if necessary
     */
    public IS getIn239_Religion() { 
		IS retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-40: "Mother’s Maiden Name" - creates it if necessary
     */
    public XPN getMotherSMaidenName() { 
		XPN retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-40: "Mother’s Maiden Name" - creates it if necessary
     */
    public XPN getIn240_MotherSMaidenName() { 
		XPN retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-41: "Nationality Code" - creates it if necessary
     */
    public CE getNationalityCode() { 
		CE retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-41: "Nationality Code" - creates it if necessary
     */
    public CE getIn241_NationalityCode() { 
		CE retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-42: "Ethnic Group" - creates it if necessary
     */
    public IS getEthnicGroup() { 
		IS retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-42: "Ethnic Group" - creates it if necessary
     */
    public IS getIn242_EthnicGroup() { 
		IS retVal = this.getTypedField(42, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (IN2-43).
     */
    public IS[] getMaritalStatus() {
    	IS[] retVal = this.getTypedField(43, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (IN2-43).
     */
    public IS[] getIn243_MaritalStatus() {
    	IS[] retVal = this.getTypedField(43, new IS[0]);
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
    public IS getMaritalStatus(int rep) { 
		IS retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-43: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getIn243_MaritalStatus(int rep) { 
		IS retVal = this.getTypedField(43, rep);
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
    public IS insertMaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(43, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertIn243_MaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeMaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * IN2-43: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeIn243_MaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(43, rep);
    }




    /**
     * Returns
     * IN2-44: "Employment Start Date" - creates it if necessary
     */
    public DT getEmploymentStartDate() { 
		DT retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-44: "Employment Start Date" - creates it if necessary
     */
    public DT getIn244_EmploymentStartDate() { 
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
     * Returns all repetitions of Insured’s Contact Person’s Name (IN2-52).
     */
    public XPN[] getInsuredSContactPersonSName() {
    	XPN[] retVal = this.getTypedField(52, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured’s Contact Person’s Name (IN2-52).
     */
    public XPN[] getIn252_InsuredSContactPersonSName() {
    	XPN[] retVal = this.getTypedField(52, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured’s Contact Person’s Name (IN2-52).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSContactPersonSNameReps() {
    	return this.getReps(52);
    }


    /**
     * Returns a specific repetition of
     * IN2-52: "Insured’s Contact Person’s Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getInsuredSContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(52, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-52: "Insured’s Contact Person’s Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn252_InsuredSContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(52, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured’s Contact Person’s Name (IN2-52).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn252_InsuredSContactPersonSNameReps() {
    	return this.getReps(52);
    }


    /**
     * Inserts a repetition of
     * IN2-52: "Insured’s Contact Person’s Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertInsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(52, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-52: "Insured’s Contact Person’s Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn252_InsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(52, rep);
    }


    /**
     * Removes a repetition of
     * IN2-52: "Insured’s Contact Person’s Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeInsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(52, rep);
    }


    /**
     * Removes a repetition of
     * IN2-52: "Insured’s Contact Person’s Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn252_InsuredSContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(52, rep);
    }



    /**
     * Returns all repetitions of Insured’s Contact Person Telephone Number (IN2-53).
     */
    public XTN[] getInsuredSContactPersonTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(53, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured’s Contact Person Telephone Number (IN2-53).
     */
    public XTN[] getIn253_InsuredSContactPersonTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(53, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured’s Contact Person Telephone Number (IN2-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSContactPersonTelephoneNumberReps() {
    	return this.getReps(53);
    }


    /**
     * Returns a specific repetition of
     * IN2-53: "Insured’s Contact Person Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuredSContactPersonTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-53: "Insured’s Contact Person Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn253_InsuredSContactPersonTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured’s Contact Person Telephone Number (IN2-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn253_InsuredSContactPersonTelephoneNumberReps() {
    	return this.getReps(53);
    }


    /**
     * Inserts a repetition of
     * IN2-53: "Insured’s Contact Person Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuredSContactPersonTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(53, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-53: "Insured’s Contact Person Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn253_InsuredSContactPersonTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * IN2-53: "Insured’s Contact Person Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuredSContactPersonTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * IN2-53: "Insured’s Contact Person Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn253_InsuredSContactPersonTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(53, rep);
    }



    /**
     * Returns all repetitions of Insured’s Contact Person Reason (IN2-54).
     */
    public IS[] getInsuredSContactPersonReason() {
    	IS[] retVal = this.getTypedField(54, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured’s Contact Person Reason (IN2-54).
     */
    public IS[] getIn254_InsuredSContactPersonReason() {
    	IS[] retVal = this.getTypedField(54, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured’s Contact Person Reason (IN2-54).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSContactPersonReasonReps() {
    	return this.getReps(54);
    }


    /**
     * Returns a specific repetition of
     * IN2-54: "Insured’s Contact Person Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getInsuredSContactPersonReason(int rep) { 
		IS retVal = this.getTypedField(54, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-54: "Insured’s Contact Person Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getIn254_InsuredSContactPersonReason(int rep) { 
		IS retVal = this.getTypedField(54, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured’s Contact Person Reason (IN2-54).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn254_InsuredSContactPersonReasonReps() {
    	return this.getReps(54);
    }


    /**
     * Inserts a repetition of
     * IN2-54: "Insured’s Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertInsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(54, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-54: "Insured’s Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertIn254_InsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(54, rep);
    }


    /**
     * Removes a repetition of
     * IN2-54: "Insured’s Contact Person Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeInsuredSContactPersonReason(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(54, rep);
    }


    /**
     * Removes a repetition of
     * IN2-54: "Insured’s Contact Person Reason" at a specific index
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
     * IN2-58: "Insurance Co. Contact Phone Number" - creates it if necessary
     */
    public XTN getInsuranceCoContactPhoneNumber() { 
		XTN retVal = this.getTypedField(58, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-58: "Insurance Co. Contact Phone Number" - creates it if necessary
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
     * IN2-62: "Guarantor’s Relationship To Insured" - creates it if necessary
     */
    public IS getGuarantorSRelationshipToInsured() { 
		IS retVal = this.getTypedField(62, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-62: "Guarantor’s Relationship To Insured" - creates it if necessary
     */
    public IS getIn262_GuarantorSRelationshipToInsured() { 
		IS retVal = this.getTypedField(62, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured’s Telephone Number - Home (IN2-63).
     */
    public XTN[] getInsuredSTelephoneNumberHome() {
    	XTN[] retVal = this.getTypedField(63, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured’s Telephone Number - Home (IN2-63).
     */
    public XTN[] getIn263_InsuredSTelephoneNumberHome() {
    	XTN[] retVal = this.getTypedField(63, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured’s Telephone Number - Home (IN2-63).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSTelephoneNumberHomeReps() {
    	return this.getReps(63);
    }


    /**
     * Returns a specific repetition of
     * IN2-63: "Insured’s Telephone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuredSTelephoneNumberHome(int rep) { 
		XTN retVal = this.getTypedField(63, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-63: "Insured’s Telephone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn263_InsuredSTelephoneNumberHome(int rep) { 
		XTN retVal = this.getTypedField(63, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured’s Telephone Number - Home (IN2-63).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn263_InsuredSTelephoneNumberHomeReps() {
    	return this.getReps(63);
    }


    /**
     * Inserts a repetition of
     * IN2-63: "Insured’s Telephone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuredSTelephoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(63, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-63: "Insured’s Telephone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn263_InsuredSTelephoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(63, rep);
    }


    /**
     * Removes a repetition of
     * IN2-63: "Insured’s Telephone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuredSTelephoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(63, rep);
    }


    /**
     * Removes a repetition of
     * IN2-63: "Insured’s Telephone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn263_InsuredSTelephoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(63, rep);
    }



    /**
     * Returns all repetitions of Insured’s Employer Telephone Number (IN2-64).
     */
    public XTN[] getInsuredSEmployerTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(64, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured’s Employer Telephone Number (IN2-64).
     */
    public XTN[] getIn264_InsuredSEmployerTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(64, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured’s Employer Telephone Number (IN2-64).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSEmployerTelephoneNumberReps() {
    	return this.getReps(64);
    }


    /**
     * Returns a specific repetition of
     * IN2-64: "Insured’s Employer Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuredSEmployerTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(64, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-64: "Insured’s Employer Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn264_InsuredSEmployerTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(64, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured’s Employer Telephone Number (IN2-64).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn264_InsuredSEmployerTelephoneNumberReps() {
    	return this.getReps(64);
    }


    /**
     * Inserts a repetition of
     * IN2-64: "Insured’s Employer Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuredSEmployerTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(64, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-64: "Insured’s Employer Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn264_InsuredSEmployerTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(64, rep);
    }


    /**
     * Removes a repetition of
     * IN2-64: "Insured’s Employer Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuredSEmployerTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(64, rep);
    }


    /**
     * Removes a repetition of
     * IN2-64: "Insured’s Employer Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn264_InsuredSEmployerTelephoneNumber(int rep) throws HL7Exception { 
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
     * IN2-67: "Co-pay Limit Flag" - creates it if necessary
     */
    public ID getCoPayLimitFlag() { 
		ID retVal = this.getTypedField(67, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-67: "Co-pay Limit Flag" - creates it if necessary
     */
    public ID getIn267_CoPayLimitFlag() { 
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
     * Returns
     * IN2-71: "Race" - creates it if necessary
     */
    public IS getRace() { 
		IS retVal = this.getTypedField(71, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-71: "Race" - creates it if necessary
     */
    public IS getIn271_Race() { 
		IS retVal = this.getTypedField(71, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-72: "Patient Relationship to Insured" - creates it if necessary
     */
    public ID getPatientRelationshipToInsured() { 
		ID retVal = this.getTypedField(72, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-72: "Patient Relationship to Insured" - creates it if necessary
     */
    public ID getIn272_PatientRelationshipToInsured() { 
		ID retVal = this.getTypedField(72, 0);
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
          case 23: return new ST(getMessage());
          case 24: return new CX(getMessage());
          case 25: return new CX(getMessage());
          case 26: return new IS(getMessage(), new Integer( 144 ));
          case 27: return new CM_RMC(getMessage());
          case 28: return new CM_PTA(getMessage());
          case 29: return new CM_DDI(getMessage());
          case 30: return new IS(getMessage(), new Integer( 223 ));
          case 31: return new IS(getMessage(), new Integer( 9 ));
          case 32: return new IS(getMessage(), new Integer( 171 ));
          case 33: return new CE(getMessage());
          case 34: return new IS(getMessage(), new Integer( 220 ));
          case 35: return new CE(getMessage());
          case 36: return new ID(getMessage(), new Integer( 136 ));
          case 37: return new IS(getMessage(), new Integer( 231 ));
          case 38: return new IS(getMessage(), new Integer( 6 ));
          case 39: return new XPN(getMessage());
          case 40: return new CE(getMessage());
          case 41: return new IS(getMessage(), new Integer( 189 ));
          case 42: return new IS(getMessage(), new Integer( 2 ));
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
          case 61: return new IS(getMessage(), new Integer( 63 ));
          case 62: return new XTN(getMessage());
          case 63: return new XTN(getMessage());
          case 64: return new CE(getMessage());
          case 65: return new ID(getMessage(), new Integer( 136 ));
          case 66: return new ID(getMessage(), new Integer( 136 ));
          case 67: return new ID(getMessage(), new Integer( 136 ));
          case 68: return new XON(getMessage());
          case 69: return new XON(getMessage());
          case 70: return new IS(getMessage(), new Integer( 5 ));
          case 71: return new ID(getMessage(), new Integer( 0 ));
          default: return null;
       }
   }


}

