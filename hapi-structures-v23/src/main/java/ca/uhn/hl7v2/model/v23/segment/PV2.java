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
 *<p>Represents an HL7 PV2 message segment (Patient visit - additional information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PV2-1: Prior Pending Location (PL) <b>optional </b>
     * <li>PV2-2: Accommodation Code (CE) <b>optional </b>
     * <li>PV2-3: Admit Reason (CE) <b>optional </b>
     * <li>PV2-4: Transfer Reason (CE) <b>optional </b>
     * <li>PV2-5: Patient Valuables (ST) <b>optional repeating</b>
     * <li>PV2-6: Patient Valuables Location (ST) <b>optional </b>
     * <li>PV2-7: Visit User Code (IS) <b>optional </b>
     * <li>PV2-8: Expected Admit Date (TS) <b>optional </b>
     * <li>PV2-9: Expected Discharge Date (TS) <b>optional </b>
     * <li>PV2-10: Estimated Length of Inpatient Stay (NM) <b>optional </b>
     * <li>PV2-11: Actual Length of Inpatient Stay (NM) <b>optional </b>
     * <li>PV2-12: Visit Description (ST) <b>optional </b>
     * <li>PV2-13: Referral Source Code (XCN) <b>optional </b>
     * <li>PV2-14: Previous Service Date (DT) <b>optional </b>
     * <li>PV2-15: Employment Illness Related Indicator (ID) <b>optional </b>
     * <li>PV2-16: Purge Status Code (IS) <b>optional </b>
     * <li>PV2-17: Purge Status Date (DT) <b>optional </b>
     * <li>PV2-18: Special Program Code (IS) <b>optional </b>
     * <li>PV2-19: Retention Indicator (ID) <b>optional </b>
     * <li>PV2-20: Expected Number of Insurance Plans (NM) <b>optional </b>
     * <li>PV2-21: Visit Publicity Code (IS) <b>optional </b>
     * <li>PV2-22: Visit Protection Indicator (ID) <b>optional </b>
     * <li>PV2-23: Clinic Organization Name (XON) <b>optional repeating</b>
     * <li>PV2-24: Patient Status Code (IS) <b>optional </b>
     * <li>PV2-25: Visit Priority Code (IS) <b>optional </b>
     * <li>PV2-26: Previous Treatment Date (DT) <b>optional </b>
     * <li>PV2-27: Expected Discharge Disposition (IS) <b>optional </b>
     * <li>PV2-28: Signature on File Date (DT) <b>optional </b>
     * <li>PV2-29: First Similar Illness Date (DT) <b>optional </b>
     * <li>PV2-30: Patient Charge Adjustment Code (IS) <b>optional </b>
     * <li>PV2-31: Recurring Service Code (IS) <b>optional </b>
     * <li>PV2-32: Billing Media Code (ID) <b>optional </b>
     * <li>PV2-33: Expected Surgery Date & Time (TS) <b>optional </b>
     * <li>PV2-34: Military Partnership Code (ID) <b>optional </b>
     * <li>PV2-35: Military Non-Availabiltiy Code (ID) <b>optional </b>
     * <li>PV2-36: Newborn Baby Indicator (ID) <b>optional </b>
     * <li>PV2-37: Baby Detained Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PV2 extends AbstractSegment {

    /** 
     * Creates a new PV2 segment
     */
    public PV2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PL.class, false, 1, 12, new Object[]{ getMessage() }, "Prior Pending Location");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Accommodation Code");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Admit Reason");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Transfer Reason");
                                  this.add(ST.class, false, 0, 25, new Object[]{ getMessage() }, "Patient Valuables");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Patient Valuables Location");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(130) }, "Visit User Code");
                                  this.add(TS.class, false, 1, 8, new Object[]{ getMessage() }, "Expected Admit Date");
                                  this.add(TS.class, false, 1, 8, new Object[]{ getMessage() }, "Expected Discharge Date");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Estimated Length of Inpatient Stay");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Actual Length of Inpatient Stay");
                                  this.add(ST.class, false, 1, 50, new Object[]{ getMessage() }, "Visit Description");
                                  this.add(XCN.class, false, 1, 90, new Object[]{ getMessage() }, "Referral Source Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Previous Service Date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Employment Illness Related Indicator");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(213) }, "Purge Status Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Purge Status Date");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(214) }, "Special Program Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Retention Indicator");
                                  this.add(NM.class, false, 1, 1, new Object[]{ getMessage() }, "Expected Number of Insurance Plans");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(215) }, "Visit Publicity Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Visit Protection Indicator");
                                  this.add(XON.class, false, 0, 90, new Object[]{ getMessage() }, "Clinic Organization Name");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(216) }, "Patient Status Code");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(217) }, "Visit Priority Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Previous Treatment Date");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(112) }, "Expected Discharge Disposition");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Signature on File Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "First Similar Illness Date");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(218) }, "Patient Charge Adjustment Code");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(219) }, "Recurring Service Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Billing Media Code");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Expected Surgery Date & Time");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Military Partnership Code");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Military Non-Availabiltiy Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Newborn Baby Indicator");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Baby Detained Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PV2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PV2-1: "Prior Pending Location" - creates it if necessary
     */
    public PL getPriorPendingLocation() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-1: "Prior Pending Location" - creates it if necessary
     */
    public PL getPv21_PriorPendingLocation() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-2: "Accommodation Code" - creates it if necessary
     */
    public CE getAccommodationCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-2: "Accommodation Code" - creates it if necessary
     */
    public CE getPv22_AccommodationCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-3: "Admit Reason" - creates it if necessary
     */
    public CE getAdmitReason() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-3: "Admit Reason" - creates it if necessary
     */
    public CE getPv23_AdmitReason() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-4: "Transfer Reason" - creates it if necessary
     */
    public CE getTransferReason() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-4: "Transfer Reason" - creates it if necessary
     */
    public CE getPv24_TransferReason() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Valuables (PV2-5).
     */
    public ST[] getPatientValuables() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Valuables (PV2-5).
     */
    public ST[] getPv25_PatientValuables() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Valuables (PV2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientValuablesReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PV2-5: "Patient Valuables" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPatientValuables(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-5: "Patient Valuables" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPv25_PatientValuables(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Valuables (PV2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv25_PatientValuablesReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPatientValuables(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPv25_PatientValuables(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePatientValuables(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePv25_PatientValuables(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * PV2-6: "Patient Valuables Location" - creates it if necessary
     */
    public ST getPatientValuablesLocation() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-6: "Patient Valuables Location" - creates it if necessary
     */
    public ST getPv26_PatientValuablesLocation() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-7: "Visit User Code" - creates it if necessary
     */
    public IS getVisitUserCode() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-7: "Visit User Code" - creates it if necessary
     */
    public IS getPv27_VisitUserCode() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-8: "Expected Admit Date" - creates it if necessary
     */
    public TS getExpectedAdmitDate() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-8: "Expected Admit Date" - creates it if necessary
     */
    public TS getPv28_ExpectedAdmitDate() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-9: "Expected Discharge Date" - creates it if necessary
     */
    public TS getExpectedDischargeDate() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-9: "Expected Discharge Date" - creates it if necessary
     */
    public TS getPv29_ExpectedDischargeDate() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-10: "Estimated Length of Inpatient Stay" - creates it if necessary
     */
    public NM getEstimatedLengthOfInpatientStay() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-10: "Estimated Length of Inpatient Stay" - creates it if necessary
     */
    public NM getPv210_EstimatedLengthOfInpatientStay() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-11: "Actual Length of Inpatient Stay" - creates it if necessary
     */
    public NM getActualLengthOfInpatientStay() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-11: "Actual Length of Inpatient Stay" - creates it if necessary
     */
    public NM getPv211_ActualLengthOfInpatientStay() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-12: "Visit Description" - creates it if necessary
     */
    public ST getVisitDescription() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-12: "Visit Description" - creates it if necessary
     */
    public ST getPv212_VisitDescription() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-13: "Referral Source Code" - creates it if necessary
     */
    public XCN getReferralSourceCode() { 
		XCN retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-13: "Referral Source Code" - creates it if necessary
     */
    public XCN getPv213_ReferralSourceCode() { 
		XCN retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-14: "Previous Service Date" - creates it if necessary
     */
    public DT getPreviousServiceDate() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-14: "Previous Service Date" - creates it if necessary
     */
    public DT getPv214_PreviousServiceDate() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-15: "Employment Illness Related Indicator" - creates it if necessary
     */
    public ID getEmploymentIllnessRelatedIndicator() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-15: "Employment Illness Related Indicator" - creates it if necessary
     */
    public ID getPv215_EmploymentIllnessRelatedIndicator() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-16: "Purge Status Code" - creates it if necessary
     */
    public IS getPurgeStatusCode() { 
		IS retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-16: "Purge Status Code" - creates it if necessary
     */
    public IS getPv216_PurgeStatusCode() { 
		IS retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-17: "Purge Status Date" - creates it if necessary
     */
    public DT getPurgeStatusDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-17: "Purge Status Date" - creates it if necessary
     */
    public DT getPv217_PurgeStatusDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-18: "Special Program Code" - creates it if necessary
     */
    public IS getSpecialProgramCode() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-18: "Special Program Code" - creates it if necessary
     */
    public IS getPv218_SpecialProgramCode() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-19: "Retention Indicator" - creates it if necessary
     */
    public ID getRetentionIndicator() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-19: "Retention Indicator" - creates it if necessary
     */
    public ID getPv219_RetentionIndicator() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-20: "Expected Number of Insurance Plans" - creates it if necessary
     */
    public NM getExpectedNumberOfInsurancePlans() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-20: "Expected Number of Insurance Plans" - creates it if necessary
     */
    public NM getPv220_ExpectedNumberOfInsurancePlans() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-21: "Visit Publicity Code" - creates it if necessary
     */
    public IS getVisitPublicityCode() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-21: "Visit Publicity Code" - creates it if necessary
     */
    public IS getPv221_VisitPublicityCode() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-22: "Visit Protection Indicator" - creates it if necessary
     */
    public ID getVisitProtectionIndicator() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-22: "Visit Protection Indicator" - creates it if necessary
     */
    public ID getPv222_VisitProtectionIndicator() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Clinic Organization Name (PV2-23).
     */
    public XON[] getClinicOrganizationName() {
    	XON[] retVal = this.getTypedField(23, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Clinic Organization Name (PV2-23).
     */
    public XON[] getPv223_ClinicOrganizationName() {
    	XON[] retVal = this.getTypedField(23, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Clinic Organization Name (PV2-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getClinicOrganizationNameReps() {
    	return this.getReps(23);
    }


    /**
     * Returns a specific repetition of
     * PV2-23: "Clinic Organization Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getClinicOrganizationName(int rep) { 
		XON retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-23: "Clinic Organization Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPv223_ClinicOrganizationName(int rep) { 
		XON retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Clinic Organization Name (PV2-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv223_ClinicOrganizationNameReps() {
    	return this.getReps(23);
    }


    /**
     * Inserts a repetition of
     * PV2-23: "Clinic Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertClinicOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(23, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-23: "Clinic Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPv223_ClinicOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * PV2-23: "Clinic Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeClinicOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * PV2-23: "Clinic Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePv223_ClinicOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(23, rep);
    }




    /**
     * Returns
     * PV2-24: "Patient Status Code" - creates it if necessary
     */
    public IS getPatientStatusCode() { 
		IS retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-24: "Patient Status Code" - creates it if necessary
     */
    public IS getPv224_PatientStatusCode() { 
		IS retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-25: "Visit Priority Code" - creates it if necessary
     */
    public IS getVisitPriorityCode() { 
		IS retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-25: "Visit Priority Code" - creates it if necessary
     */
    public IS getPv225_VisitPriorityCode() { 
		IS retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-26: "Previous Treatment Date" - creates it if necessary
     */
    public DT getPreviousTreatmentDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-26: "Previous Treatment Date" - creates it if necessary
     */
    public DT getPv226_PreviousTreatmentDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-27: "Expected Discharge Disposition" - creates it if necessary
     */
    public IS getExpectedDischargeDisposition() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-27: "Expected Discharge Disposition" - creates it if necessary
     */
    public IS getPv227_ExpectedDischargeDisposition() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-28: "Signature on File Date" - creates it if necessary
     */
    public DT getSignatureOnFileDate() { 
		DT retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-28: "Signature on File Date" - creates it if necessary
     */
    public DT getPv228_SignatureOnFileDate() { 
		DT retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-29: "First Similar Illness Date" - creates it if necessary
     */
    public DT getFirstSimilarIllnessDate() { 
		DT retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-29: "First Similar Illness Date" - creates it if necessary
     */
    public DT getPv229_FirstSimilarIllnessDate() { 
		DT retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-30: "Patient Charge Adjustment Code" - creates it if necessary
     */
    public IS getPatientChargeAdjustmentCode() { 
		IS retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-30: "Patient Charge Adjustment Code" - creates it if necessary
     */
    public IS getPv230_PatientChargeAdjustmentCode() { 
		IS retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-31: "Recurring Service Code" - creates it if necessary
     */
    public IS getRecurringServiceCode() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-31: "Recurring Service Code" - creates it if necessary
     */
    public IS getPv231_RecurringServiceCode() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-32: "Billing Media Code" - creates it if necessary
     */
    public ID getBillingMediaCode() { 
		ID retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-32: "Billing Media Code" - creates it if necessary
     */
    public ID getPv232_BillingMediaCode() { 
		ID retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-33: "Expected Surgery Date & Time" - creates it if necessary
     */
    public TS getExpectedSurgeryDateTime() { 
		TS retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-33: "Expected Surgery Date & Time" - creates it if necessary
     */
    public TS getPv233_ExpectedSurgeryDateTime() { 
		TS retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-34: "Military Partnership Code" - creates it if necessary
     */
    public ID getMilitaryPartnershipCode() { 
		ID retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-34: "Military Partnership Code" - creates it if necessary
     */
    public ID getPv234_MilitaryPartnershipCode() { 
		ID retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-35: "Military Non-Availabiltiy Code" - creates it if necessary
     */
    public ID getMilitaryNonAvailabiltiyCode() { 
		ID retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-35: "Military Non-Availabiltiy Code" - creates it if necessary
     */
    public ID getPv235_MilitaryNonAvailabiltiyCode() { 
		ID retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-36: "Newborn Baby Indicator" - creates it if necessary
     */
    public ID getNewbornBabyIndicator() { 
		ID retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-36: "Newborn Baby Indicator" - creates it if necessary
     */
    public ID getPv236_NewbornBabyIndicator() { 
		ID retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-37: "Baby Detained Indicator" - creates it if necessary
     */
    public ID getBabyDetainedIndicator() { 
		ID retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-37: "Baby Detained Indicator" - creates it if necessary
     */
    public ID getPv237_BabyDetainedIndicator() { 
		ID retVal = this.getTypedField(37, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new IS(getMessage(), new Integer( 130 ));
          case 7: return new TS(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new XCN(getMessage());
          case 13: return new DT(getMessage());
          case 14: return new ID(getMessage(), new Integer( 136 ));
          case 15: return new IS(getMessage(), new Integer( 213 ));
          case 16: return new DT(getMessage());
          case 17: return new IS(getMessage(), new Integer( 214 ));
          case 18: return new ID(getMessage(), new Integer( 136 ));
          case 19: return new NM(getMessage());
          case 20: return new IS(getMessage(), new Integer( 215 ));
          case 21: return new ID(getMessage(), new Integer( 136 ));
          case 22: return new XON(getMessage());
          case 23: return new IS(getMessage(), new Integer( 216 ));
          case 24: return new IS(getMessage(), new Integer( 217 ));
          case 25: return new DT(getMessage());
          case 26: return new IS(getMessage(), new Integer( 112 ));
          case 27: return new DT(getMessage());
          case 28: return new DT(getMessage());
          case 29: return new IS(getMessage(), new Integer( 218 ));
          case 30: return new IS(getMessage(), new Integer( 219 ));
          case 31: return new ID(getMessage(), new Integer( 136 ));
          case 32: return new TS(getMessage());
          case 33: return new ID(getMessage(), new Integer( 136 ));
          case 34: return new ID(getMessage(), new Integer( 136 ));
          case 35: return new ID(getMessage(), new Integer( 136 ));
          case 36: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

