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
 *<p>Represents an HL7 IN2 message segment (INSURANCE ADDITIONAL INFO). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN2-1: Insured's employee ID (ST) <b>optional </b>
     * <li>IN2-2: Insured's social security number (ST) <b>optional </b>
     * <li>IN2-3: Insured's employer name (CN) <b>optional </b>
     * <li>IN2-4: Employer information data (ID) <b>optional </b>
     * <li>IN2-5: Mail claim party (ID) <b>optional </b>
     * <li>IN2-6: Medicare health insurance card number (NM) <b>optional </b>
     * <li>IN2-7: Medicaid case name (PN) <b>optional </b>
     * <li>IN2-8: Medicaid case number (NM) <b>optional </b>
     * <li>IN2-9: Champus sponsor name (PN) <b>optional </b>
     * <li>IN2-10: Champus ID number (NM) <b>optional </b>
     * <li>IN2-11: Dependent of champus recipient (ID) <b>optional </b>
     * <li>IN2-12: Champus organization (ST) <b>optional </b>
     * <li>IN2-13: Champus station (ST) <b>optional </b>
     * <li>IN2-14: Champus service (ID) <b>optional </b>
     * <li>IN2-15: Champus rank / grade (ID) <b>optional </b>
     * <li>IN2-16: Champus status (ID) <b>optional </b>
     * <li>IN2-17: Champus retire date (DT) <b>optional </b>
     * <li>IN2-18: Champus non-availability certification on file (ID) <b>optional </b>
     * <li>IN2-19: Baby coverage (ID) <b>optional </b>
     * <li>IN2-20: Combine baby bill (ID) <b>optional </b>
     * <li>IN2-21: Blood deductible (NM) <b>optional </b>
     * <li>IN2-22: Special coverage approval name (PN) <b>optional </b>
     * <li>IN2-23: Special coverage approval title (ST) <b>optional </b>
     * <li>IN2-24: Non-covered insurance code (ID) <b>optional repeating</b>
     * <li>IN2-25: Payor ID (ST) <b>optional </b>
     * <li>IN2-26: Payor subscriber ID (ST) <b>optional </b>
     * <li>IN2-27: Eligibility source (ID) <b>optional </b>
     * <li>IN2-28: Room coverage type / amount (CM_RMC) <b>optional repeating</b>
     * <li>IN2-29: Policy type / amount (CM_PTA) <b>optional repeating</b>
     * <li>IN2-30: Daily deductible (CM_DDI) <b>optional </b>
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
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Insured's employee ID");
                                  this.add(ST.class, false, 1, 9, new Object[]{ getMessage() }, "Insured's social security number");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Insured's employer name");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(139) }, "Employer information data");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(137) }, "Mail claim party");
                                  this.add(NM.class, false, 1, 15, new Object[]{ getMessage() }, "Medicare health insurance card number");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "Medicaid case name");
                                  this.add(NM.class, false, 1, 15, new Object[]{ getMessage() }, "Medicaid case number");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "Champus sponsor name");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Champus ID number");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "Dependent of champus recipient");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Champus organization");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Champus station");
                                              this.add(ID.class, false, 1, 14, new Object[]{ getMessage(), new Integer(140) }, "Champus service");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(141) }, "Champus rank / grade");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(142) }, "Champus status");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Champus retire date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Champus non-availability certification on file");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Baby coverage");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Combine baby bill");
                                  this.add(NM.class, false, 1, 1, new Object[]{ getMessage() }, "Blood deductible");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "Special coverage approval name");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Special coverage approval title");
                                              this.add(ID.class, false, 0, 8, new Object[]{ getMessage(), new Integer(143) }, "Non-covered insurance code");
                                  this.add(ST.class, false, 1, 6, new Object[]{ getMessage() }, "Payor ID");
                                  this.add(ST.class, false, 1, 6, new Object[]{ getMessage() }, "Payor subscriber ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(144) }, "Eligibility source");
                                  this.add(CM_RMC.class, false, 0, 25, new Object[]{ getMessage() }, "Room coverage type / amount");
                                  this.add(CM_PTA.class, false, 0, 25, new Object[]{ getMessage() }, "Policy type / amount");
                                  this.add(CM_DDI.class, false, 1, 25, new Object[]{ getMessage() }, "Daily deductible");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN2-1: "Insured's employee ID" - creates it if necessary
     */
    public ST getInsuredSEmployeeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-1: "Insured's employee ID" - creates it if necessary
     */
    public ST getIn21_InsuredSEmployeeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-2: "Insured's social security number" - creates it if necessary
     */
    public ST getInsuredSSocialSecurityNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-2: "Insured's social security number" - creates it if necessary
     */
    public ST getIn22_InsuredSSocialSecurityNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-3: "Insured's employer name" - creates it if necessary
     */
    public CN getInsuredSEmployerName() { 
		CN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-3: "Insured's employer name" - creates it if necessary
     */
    public CN getIn23_InsuredSEmployerName() { 
		CN retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-4: "Employer information data" - creates it if necessary
     */
    public ID getEmployerInformationData() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-4: "Employer information data" - creates it if necessary
     */
    public ID getIn24_EmployerInformationData() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-5: "Mail claim party" - creates it if necessary
     */
    public ID getMailClaimParty() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-5: "Mail claim party" - creates it if necessary
     */
    public ID getIn25_MailClaimParty() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-6: "Medicare health insurance card number" - creates it if necessary
     */
    public NM getMedicareHealthInsuranceCardNumber() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-6: "Medicare health insurance card number" - creates it if necessary
     */
    public NM getIn26_MedicareHealthInsuranceCardNumber() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-7: "Medicaid case name" - creates it if necessary
     */
    public PN getMedicaidCaseName() { 
		PN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-7: "Medicaid case name" - creates it if necessary
     */
    public PN getIn27_MedicaidCaseName() { 
		PN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-8: "Medicaid case number" - creates it if necessary
     */
    public NM getMedicaidCaseNumber() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-8: "Medicaid case number" - creates it if necessary
     */
    public NM getIn28_MedicaidCaseNumber() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-9: "Champus sponsor name" - creates it if necessary
     */
    public PN getChampusSponsorName() { 
		PN retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-9: "Champus sponsor name" - creates it if necessary
     */
    public PN getIn29_ChampusSponsorName() { 
		PN retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-10: "Champus ID number" - creates it if necessary
     */
    public NM getChampusIDNumber() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-10: "Champus ID number" - creates it if necessary
     */
    public NM getIn210_ChampusIDNumber() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-11: "Dependent of champus recipient" - creates it if necessary
     */
    public ID getDependentOfChampusRecipient() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-11: "Dependent of champus recipient" - creates it if necessary
     */
    public ID getIn211_DependentOfChampusRecipient() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-12: "Champus organization" - creates it if necessary
     */
    public ST getChampusOrganization() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-12: "Champus organization" - creates it if necessary
     */
    public ST getIn212_ChampusOrganization() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-13: "Champus station" - creates it if necessary
     */
    public ST getChampusStation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-13: "Champus station" - creates it if necessary
     */
    public ST getIn213_ChampusStation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-14: "Champus service" - creates it if necessary
     */
    public ID getChampusService() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-14: "Champus service" - creates it if necessary
     */
    public ID getIn214_ChampusService() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-15: "Champus rank / grade" - creates it if necessary
     */
    public ID getChampusRankGrade() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-15: "Champus rank / grade" - creates it if necessary
     */
    public ID getIn215_ChampusRankGrade() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-16: "Champus status" - creates it if necessary
     */
    public ID getChampusStatus() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-16: "Champus status" - creates it if necessary
     */
    public ID getIn216_ChampusStatus() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-17: "Champus retire date" - creates it if necessary
     */
    public DT getChampusRetireDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-17: "Champus retire date" - creates it if necessary
     */
    public DT getIn217_ChampusRetireDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-18: "Champus non-availability certification on file" - creates it if necessary
     */
    public ID getChampusNonAvailabilityCertificationOnFile() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-18: "Champus non-availability certification on file" - creates it if necessary
     */
    public ID getIn218_ChampusNonAvailabilityCertificationOnFile() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-19: "Baby coverage" - creates it if necessary
     */
    public ID getBabyCoverage() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-19: "Baby coverage" - creates it if necessary
     */
    public ID getIn219_BabyCoverage() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-20: "Combine baby bill" - creates it if necessary
     */
    public ID getCombineBabyBill() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-20: "Combine baby bill" - creates it if necessary
     */
    public ID getIn220_CombineBabyBill() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-21: "Blood deductible" - creates it if necessary
     */
    public NM getBloodDeductible() { 
		NM retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-21: "Blood deductible" - creates it if necessary
     */
    public NM getIn221_BloodDeductible() { 
		NM retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-22: "Special coverage approval name" - creates it if necessary
     */
    public PN getSpecialCoverageApprovalName() { 
		PN retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-22: "Special coverage approval name" - creates it if necessary
     */
    public PN getIn222_SpecialCoverageApprovalName() { 
		PN retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-23: "Special coverage approval title" - creates it if necessary
     */
    public ST getSpecialCoverageApprovalTitle() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-23: "Special coverage approval title" - creates it if necessary
     */
    public ST getIn223_SpecialCoverageApprovalTitle() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Non-covered insurance code (IN2-24).
     */
    public ID[] getNonCoveredInsuranceCode() {
    	ID[] retVal = this.getTypedField(24, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Non-covered insurance code (IN2-24).
     */
    public ID[] getIn224_NonCoveredInsuranceCode() {
    	ID[] retVal = this.getTypedField(24, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Non-covered insurance code (IN2-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNonCoveredInsuranceCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * IN2-24: "Non-covered insurance code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getNonCoveredInsuranceCode(int rep) { 
		ID retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-24: "Non-covered insurance code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getIn224_NonCoveredInsuranceCode(int rep) { 
		ID retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Non-covered insurance code (IN2-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn224_NonCoveredInsuranceCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * IN2-24: "Non-covered insurance code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertNonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-24: "Non-covered insurance code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertIn224_NonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN2-24: "Non-covered insurance code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeNonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN2-24: "Non-covered insurance code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeIn224_NonCoveredInsuranceCode(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * IN2-25: "Payor ID" - creates it if necessary
     */
    public ST getPayorID() { 
		ST retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-25: "Payor ID" - creates it if necessary
     */
    public ST getIn225_PayorID() { 
		ST retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-26: "Payor subscriber ID" - creates it if necessary
     */
    public ST getPayorSubscriberID() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-26: "Payor subscriber ID" - creates it if necessary
     */
    public ST getIn226_PayorSubscriberID() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IN2-27: "Eligibility source" - creates it if necessary
     */
    public ID getEligibilitySource() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-27: "Eligibility source" - creates it if necessary
     */
    public ID getIn227_EligibilitySource() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Room coverage type / amount (IN2-28).
     */
    public CM_RMC[] getRoomCoverageTypeAmount() {
    	CM_RMC[] retVal = this.getTypedField(28, new CM_RMC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Room coverage type / amount (IN2-28).
     */
    public CM_RMC[] getIn228_RoomCoverageTypeAmount() {
    	CM_RMC[] retVal = this.getTypedField(28, new CM_RMC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Room coverage type / amount (IN2-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRoomCoverageTypeAmountReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * IN2-28: "Room coverage type / amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_RMC getRoomCoverageTypeAmount(int rep) { 
		CM_RMC retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-28: "Room coverage type / amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_RMC getIn228_RoomCoverageTypeAmount(int rep) { 
		CM_RMC retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Room coverage type / amount (IN2-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn228_RoomCoverageTypeAmountReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * IN2-28: "Room coverage type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC insertRoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-28: "Room coverage type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC insertIn228_RoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * IN2-28: "Room coverage type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC removeRoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * IN2-28: "Room coverage type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_RMC removeIn228_RoomCoverageTypeAmount(int rep) throws HL7Exception { 
        return (CM_RMC) super.removeRepetition(28, rep);
    }



    /**
     * Returns all repetitions of Policy type / amount (IN2-29).
     */
    public CM_PTA[] getPolicyTypeAmount() {
    	CM_PTA[] retVal = this.getTypedField(29, new CM_PTA[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Policy type / amount (IN2-29).
     */
    public CM_PTA[] getIn229_PolicyTypeAmount() {
    	CM_PTA[] retVal = this.getTypedField(29, new CM_PTA[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Policy type / amount (IN2-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPolicyTypeAmountReps() {
    	return this.getReps(29);
    }


    /**
     * Returns a specific repetition of
     * IN2-29: "Policy type / amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PTA getPolicyTypeAmount(int rep) { 
		CM_PTA retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN2-29: "Policy type / amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PTA getIn229_PolicyTypeAmount(int rep) { 
		CM_PTA retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Policy type / amount (IN2-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn229_PolicyTypeAmountReps() {
    	return this.getReps(29);
    }


    /**
     * Inserts a repetition of
     * IN2-29: "Policy type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA insertPolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * IN2-29: "Policy type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA insertIn229_PolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * IN2-29: "Policy type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA removePolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * IN2-29: "Policy type / amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PTA removeIn229_PolicyTypeAmount(int rep) throws HL7Exception { 
        return (CM_PTA) super.removeRepetition(29, rep);
    }




    /**
     * Returns
     * IN2-30: "Daily deductible" - creates it if necessary
     */
    public CM_DDI getDailyDeductible() { 
		CM_DDI retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN2-30: "Daily deductible" - creates it if necessary
     */
    public CM_DDI getIn230_DailyDeductible() { 
		CM_DDI retVal = this.getTypedField(30, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new CN(getMessage());
          case 3: return new ID(getMessage(), new Integer( 139 ));
          case 4: return new ID(getMessage(), new Integer( 137 ));
          case 5: return new NM(getMessage());
          case 6: return new PN(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new PN(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new ID(getMessage(), new Integer( 0 ));
          case 11: return new ST(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new ID(getMessage(), new Integer( 140 ));
          case 14: return new ID(getMessage(), new Integer( 141 ));
          case 15: return new ID(getMessage(), new Integer( 142 ));
          case 16: return new DT(getMessage());
          case 17: return new ID(getMessage(), new Integer( 136 ));
          case 18: return new ID(getMessage(), new Integer( 136 ));
          case 19: return new ID(getMessage(), new Integer( 136 ));
          case 20: return new NM(getMessage());
          case 21: return new PN(getMessage());
          case 22: return new ST(getMessage());
          case 23: return new ID(getMessage(), new Integer( 143 ));
          case 24: return new ST(getMessage());
          case 25: return new ST(getMessage());
          case 26: return new ID(getMessage(), new Integer( 144 ));
          case 27: return new CM_RMC(getMessage());
          case 28: return new CM_PTA(getMessage());
          case 29: return new CM_DDI(getMessage());
          default: return null;
       }
   }


}

