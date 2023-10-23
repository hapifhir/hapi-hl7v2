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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PV2 message segment (Patient Visit - Additional Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PV2-1: Prior Pending Location (PL) <b>optional </b>
     * <li>PV2-2: Accommodation Code (CWE) <b>optional </b>
     * <li>PV2-3: Admit Reason (CWE) <b>optional </b>
     * <li>PV2-4: Transfer Reason (CWE) <b>optional </b>
     * <li>PV2-5: Patient Valuables (ST) <b>optional repeating</b>
     * <li>PV2-6: Patient Valuables Location (ST) <b>optional </b>
     * <li>PV2-7: Visit User Code (CWE) <b>optional repeating</b>
     * <li>PV2-8: Expected Admit Date/Time (DTM) <b>optional </b>
     * <li>PV2-9: Expected Discharge Date/Time (DTM) <b>optional </b>
     * <li>PV2-10: Estimated Length of Inpatient Stay (NM) <b>optional </b>
     * <li>PV2-11: Actual Length of Inpatient Stay (NM) <b>optional </b>
     * <li>PV2-12: Visit Description (ST) <b>optional </b>
     * <li>PV2-13: Referral Source Code (XCN) <b>optional repeating</b>
     * <li>PV2-14: Previous Service Date (DT) <b>optional </b>
     * <li>PV2-15: Employment Illness Related Indicator (ID) <b>optional </b>
     * <li>PV2-16: Purge Status Code (CWE) <b>optional </b>
     * <li>PV2-17: Purge Status Date (DT) <b>optional </b>
     * <li>PV2-18: Special Program Code (CWE) <b>optional </b>
     * <li>PV2-19: Retention Indicator (ID) <b>optional </b>
     * <li>PV2-20: Expected Number of Insurance Plans (NM) <b>optional </b>
     * <li>PV2-21: Visit Publicity Code (CWE) <b>optional </b>
     * <li>PV2-22: Visit Protection Indicator (ID) <b>optional </b>
     * <li>PV2-23: Clinic Organization Name (XON) <b>optional repeating</b>
     * <li>PV2-24: Patient Status Code (CWE) <b>optional </b>
     * <li>PV2-25: Visit Priority Code (CWE) <b>optional </b>
     * <li>PV2-26: Previous Treatment Date (DT) <b>optional </b>
     * <li>PV2-27: Expected Discharge Disposition (CWE) <b>optional </b>
     * <li>PV2-28: Signature on File Date (DT) <b>optional </b>
     * <li>PV2-29: First Similar Illness Date (DT) <b>optional </b>
     * <li>PV2-30: Patient Charge Adjustment Code (CWE) <b>optional </b>
     * <li>PV2-31: Recurring Service Code (CWE) <b>optional </b>
     * <li>PV2-32: Billing Media Code (ID) <b>optional </b>
     * <li>PV2-33: Expected Surgery Date and Time (DTM) <b>optional </b>
     * <li>PV2-34: Military Partnership Code (ID) <b>optional </b>
     * <li>PV2-35: Military Non-Availability Code (ID) <b>optional </b>
     * <li>PV2-36: Newborn Baby Indicator (ID) <b>optional </b>
     * <li>PV2-37: Baby Detained Indicator (ID) <b>optional </b>
     * <li>PV2-38: Mode of Arrival Code (CWE) <b>optional </b>
     * <li>PV2-39: Recreational Drug Use Code (CWE) <b>optional repeating</b>
     * <li>PV2-40: Admission Level of Care Code (CWE) <b>optional </b>
     * <li>PV2-41: Precaution Code (CWE) <b>optional repeating</b>
     * <li>PV2-42: Patient Condition Code (CWE) <b>optional </b>
     * <li>PV2-43: Living Will Code (CWE) <b>optional </b>
     * <li>PV2-44: Organ Donor Code (CWE) <b>optional </b>
     * <li>PV2-45: Advance Directive Code (CWE) <b>optional repeating</b>
     * <li>PV2-46: Patient Status Effective Date (DT) <b>optional </b>
     * <li>PV2-47: Expected LOA Return Date/Time (DTM) <b>optional </b>
     * <li>PV2-48: Expected Pre-admission Testing Date/Time (DTM) <b>optional </b>
     * <li>PV2-49: Notify Clergy Code (CWE) <b>optional repeating</b>
     * <li>PV2-50: Advance Directive Last Verified Date (DT) <b>optional </b>
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
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Prior Pending Location");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Accommodation Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Admit Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Transfer Reason");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Patient Valuables");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Valuables Location");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Visit User Code");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Admit Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Discharge Date/Time");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Estimated Length of Inpatient Stay");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Actual Length of Inpatient Stay");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Visit Description");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Referral Source Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Previous Service Date");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Employment Illness Related Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Purge Status Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Purge Status Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Special Program Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Retention Indicator");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Number of Insurance Plans");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Visit Publicity Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Visit Protection Indicator");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Clinic Organization Name");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Status Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Visit Priority Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Previous Treatment Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Discharge Disposition");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Signature on File Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "First Similar Illness Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Charge Adjustment Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Recurring Service Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Billing Media Code");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Surgery Date and Time");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Military Partnership Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Military Non-Availability Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Newborn Baby Indicator");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Baby Detained Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Mode of Arrival Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Recreational Drug Use Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Admission Level of Care Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Precaution Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Condition Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Living Will Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Organ Donor Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Advance Directive Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Status Effective Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected LOA Return Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Pre-admission Testing Date/Time");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Notify Clergy Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Advance Directive Last Verified Date");
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
    public CWE getAccommodationCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-2: "Accommodation Code" - creates it if necessary
     */
    public CWE getPv22_AccommodationCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-3: "Admit Reason" - creates it if necessary
     */
    public CWE getAdmitReason() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-3: "Admit Reason" - creates it if necessary
     */
    public CWE getPv23_AdmitReason() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-4: "Transfer Reason" - creates it if necessary
     */
    public CWE getTransferReason() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-4: "Transfer Reason" - creates it if necessary
     */
    public CWE getPv24_TransferReason() { 
		CWE retVal = this.getTypedField(4, 0);
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
     * Returns all repetitions of Visit User Code (PV2-7).
     */
    public CWE[] getVisitUserCode() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Visit User Code (PV2-7).
     */
    public CWE[] getPv27_VisitUserCode() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Visit User Code (PV2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVisitUserCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PV2-7: "Visit User Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getVisitUserCode(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-7: "Visit User Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv27_VisitUserCode(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Visit User Code (PV2-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv27_VisitUserCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PV2-7: "Visit User Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertVisitUserCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-7: "Visit User Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv27_VisitUserCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PV2-7: "Visit User Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeVisitUserCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PV2-7: "Visit User Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv27_VisitUserCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * PV2-8: "Expected Admit Date/Time" - creates it if necessary
     */
    public DTM getExpectedAdmitDateTime() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-8: "Expected Admit Date/Time" - creates it if necessary
     */
    public DTM getPv28_ExpectedAdmitDateTime() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-9: "Expected Discharge Date/Time" - creates it if necessary
     */
    public DTM getExpectedDischargeDateTime() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-9: "Expected Discharge Date/Time" - creates it if necessary
     */
    public DTM getPv29_ExpectedDischargeDateTime() { 
		DTM retVal = this.getTypedField(9, 0);
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
     * Returns all repetitions of Referral Source Code (PV2-13).
     */
    public XCN[] getReferralSourceCode() {
    	XCN[] retVal = this.getTypedField(13, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Referral Source Code (PV2-13).
     */
    public XCN[] getPv213_ReferralSourceCode() {
    	XCN[] retVal = this.getTypedField(13, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Referral Source Code (PV2-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferralSourceCodeReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PV2-13: "Referral Source Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getReferralSourceCode(int rep) { 
		XCN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-13: "Referral Source Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPv213_ReferralSourceCode(int rep) { 
		XCN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Referral Source Code (PV2-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv213_ReferralSourceCodeReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PV2-13: "Referral Source Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertReferralSourceCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-13: "Referral Source Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPv213_ReferralSourceCode(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PV2-13: "Referral Source Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeReferralSourceCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PV2-13: "Referral Source Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePv213_ReferralSourceCode(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(13, rep);
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
    public CWE getPurgeStatusCode() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-16: "Purge Status Code" - creates it if necessary
     */
    public CWE getPv216_PurgeStatusCode() { 
		CWE retVal = this.getTypedField(16, 0);
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
    public CWE getSpecialProgramCode() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-18: "Special Program Code" - creates it if necessary
     */
    public CWE getPv218_SpecialProgramCode() { 
		CWE retVal = this.getTypedField(18, 0);
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
    public CWE getVisitPublicityCode() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-21: "Visit Publicity Code" - creates it if necessary
     */
    public CWE getPv221_VisitPublicityCode() { 
		CWE retVal = this.getTypedField(21, 0);
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
    public CWE getPatientStatusCode() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-24: "Patient Status Code" - creates it if necessary
     */
    public CWE getPv224_PatientStatusCode() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-25: "Visit Priority Code" - creates it if necessary
     */
    public CWE getVisitPriorityCode() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-25: "Visit Priority Code" - creates it if necessary
     */
    public CWE getPv225_VisitPriorityCode() { 
		CWE retVal = this.getTypedField(25, 0);
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
    public CWE getExpectedDischargeDisposition() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-27: "Expected Discharge Disposition" - creates it if necessary
     */
    public CWE getPv227_ExpectedDischargeDisposition() { 
		CWE retVal = this.getTypedField(27, 0);
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
    public CWE getPatientChargeAdjustmentCode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-30: "Patient Charge Adjustment Code" - creates it if necessary
     */
    public CWE getPv230_PatientChargeAdjustmentCode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-31: "Recurring Service Code" - creates it if necessary
     */
    public CWE getRecurringServiceCode() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-31: "Recurring Service Code" - creates it if necessary
     */
    public CWE getPv231_RecurringServiceCode() { 
		CWE retVal = this.getTypedField(31, 0);
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
     * PV2-33: "Expected Surgery Date and Time" - creates it if necessary
     */
    public DTM getExpectedSurgeryDateAndTime() { 
		DTM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-33: "Expected Surgery Date and Time" - creates it if necessary
     */
    public DTM getPv233_ExpectedSurgeryDateAndTime() { 
		DTM retVal = this.getTypedField(33, 0);
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
     * PV2-35: "Military Non-Availability Code" - creates it if necessary
     */
    public ID getMilitaryNonAvailabilityCode() { 
		ID retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-35: "Military Non-Availability Code" - creates it if necessary
     */
    public ID getPv235_MilitaryNonAvailabilityCode() { 
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



    /**
     * Returns
     * PV2-38: "Mode of Arrival Code" - creates it if necessary
     */
    public CWE getModeOfArrivalCode() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-38: "Mode of Arrival Code" - creates it if necessary
     */
    public CWE getPv238_ModeOfArrivalCode() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Recreational Drug Use Code (PV2-39).
     */
    public CWE[] getRecreationalDrugUseCode() {
    	CWE[] retVal = this.getTypedField(39, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Recreational Drug Use Code (PV2-39).
     */
    public CWE[] getPv239_RecreationalDrugUseCode() {
    	CWE[] retVal = this.getTypedField(39, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Recreational Drug Use Code (PV2-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRecreationalDrugUseCodeReps() {
    	return this.getReps(39);
    }


    /**
     * Returns a specific repetition of
     * PV2-39: "Recreational Drug Use Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRecreationalDrugUseCode(int rep) { 
		CWE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-39: "Recreational Drug Use Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv239_RecreationalDrugUseCode(int rep) { 
		CWE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Recreational Drug Use Code (PV2-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv239_RecreationalDrugUseCodeReps() {
    	return this.getReps(39);
    }


    /**
     * Inserts a repetition of
     * PV2-39: "Recreational Drug Use Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRecreationalDrugUseCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(39, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-39: "Recreational Drug Use Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv239_RecreationalDrugUseCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * PV2-39: "Recreational Drug Use Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRecreationalDrugUseCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * PV2-39: "Recreational Drug Use Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv239_RecreationalDrugUseCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(39, rep);
    }




    /**
     * Returns
     * PV2-40: "Admission Level of Care Code" - creates it if necessary
     */
    public CWE getAdmissionLevelOfCareCode() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-40: "Admission Level of Care Code" - creates it if necessary
     */
    public CWE getPv240_AdmissionLevelOfCareCode() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Precaution Code (PV2-41).
     */
    public CWE[] getPrecautionCode() {
    	CWE[] retVal = this.getTypedField(41, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Precaution Code (PV2-41).
     */
    public CWE[] getPv241_PrecautionCode() {
    	CWE[] retVal = this.getTypedField(41, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Precaution Code (PV2-41).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrecautionCodeReps() {
    	return this.getReps(41);
    }


    /**
     * Returns a specific repetition of
     * PV2-41: "Precaution Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPrecautionCode(int rep) { 
		CWE retVal = this.getTypedField(41, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-41: "Precaution Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv241_PrecautionCode(int rep) { 
		CWE retVal = this.getTypedField(41, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Precaution Code (PV2-41).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv241_PrecautionCodeReps() {
    	return this.getReps(41);
    }


    /**
     * Inserts a repetition of
     * PV2-41: "Precaution Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPrecautionCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(41, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-41: "Precaution Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv241_PrecautionCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(41, rep);
    }


    /**
     * Removes a repetition of
     * PV2-41: "Precaution Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePrecautionCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(41, rep);
    }


    /**
     * Removes a repetition of
     * PV2-41: "Precaution Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv241_PrecautionCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(41, rep);
    }




    /**
     * Returns
     * PV2-42: "Patient Condition Code" - creates it if necessary
     */
    public CWE getPatientConditionCode() { 
		CWE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-42: "Patient Condition Code" - creates it if necessary
     */
    public CWE getPv242_PatientConditionCode() { 
		CWE retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-43: "Living Will Code" - creates it if necessary
     */
    public CWE getLivingWillCode() { 
		CWE retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-43: "Living Will Code" - creates it if necessary
     */
    public CWE getPv243_LivingWillCode() { 
		CWE retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-44: "Organ Donor Code" - creates it if necessary
     */
    public CWE getOrganDonorCode() { 
		CWE retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-44: "Organ Donor Code" - creates it if necessary
     */
    public CWE getPv244_OrganDonorCode() { 
		CWE retVal = this.getTypedField(44, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Advance Directive Code (PV2-45).
     */
    public CWE[] getAdvanceDirectiveCode() {
    	CWE[] retVal = this.getTypedField(45, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Advance Directive Code (PV2-45).
     */
    public CWE[] getPv245_AdvanceDirectiveCode() {
    	CWE[] retVal = this.getTypedField(45, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Advance Directive Code (PV2-45).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdvanceDirectiveCodeReps() {
    	return this.getReps(45);
    }


    /**
     * Returns a specific repetition of
     * PV2-45: "Advance Directive Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAdvanceDirectiveCode(int rep) { 
		CWE retVal = this.getTypedField(45, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-45: "Advance Directive Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv245_AdvanceDirectiveCode(int rep) { 
		CWE retVal = this.getTypedField(45, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Advance Directive Code (PV2-45).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv245_AdvanceDirectiveCodeReps() {
    	return this.getReps(45);
    }


    /**
     * Inserts a repetition of
     * PV2-45: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(45, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-45: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv245_AdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(45, rep);
    }


    /**
     * Removes a repetition of
     * PV2-45: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(45, rep);
    }


    /**
     * Removes a repetition of
     * PV2-45: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv245_AdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(45, rep);
    }




    /**
     * Returns
     * PV2-46: "Patient Status Effective Date" - creates it if necessary
     */
    public DT getPatientStatusEffectiveDate() { 
		DT retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-46: "Patient Status Effective Date" - creates it if necessary
     */
    public DT getPv246_PatientStatusEffectiveDate() { 
		DT retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-47: "Expected LOA Return Date/Time" - creates it if necessary
     */
    public DTM getExpectedLOAReturnDateTime() { 
		DTM retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-47: "Expected LOA Return Date/Time" - creates it if necessary
     */
    public DTM getPv247_ExpectedLOAReturnDateTime() { 
		DTM retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-48: "Expected Pre-admission Testing Date/Time" - creates it if necessary
     */
    public DTM getExpectedPreAdmissionTestingDateTime() { 
		DTM retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-48: "Expected Pre-admission Testing Date/Time" - creates it if necessary
     */
    public DTM getPv248_ExpectedPreAdmissionTestingDateTime() { 
		DTM retVal = this.getTypedField(48, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Notify Clergy Code (PV2-49).
     */
    public CWE[] getNotifyClergyCode() {
    	CWE[] retVal = this.getTypedField(49, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Notify Clergy Code (PV2-49).
     */
    public CWE[] getPv249_NotifyClergyCode() {
    	CWE[] retVal = this.getTypedField(49, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Notify Clergy Code (PV2-49).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNotifyClergyCodeReps() {
    	return this.getReps(49);
    }


    /**
     * Returns a specific repetition of
     * PV2-49: "Notify Clergy Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getNotifyClergyCode(int rep) { 
		CWE retVal = this.getTypedField(49, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-49: "Notify Clergy Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv249_NotifyClergyCode(int rep) { 
		CWE retVal = this.getTypedField(49, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Notify Clergy Code (PV2-49).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv249_NotifyClergyCodeReps() {
    	return this.getReps(49);
    }


    /**
     * Inserts a repetition of
     * PV2-49: "Notify Clergy Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertNotifyClergyCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(49, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-49: "Notify Clergy Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv249_NotifyClergyCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(49, rep);
    }


    /**
     * Removes a repetition of
     * PV2-49: "Notify Clergy Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeNotifyClergyCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(49, rep);
    }


    /**
     * Removes a repetition of
     * PV2-49: "Notify Clergy Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv249_NotifyClergyCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(49, rep);
    }




    /**
     * Returns
     * PV2-50: "Advance Directive Last Verified Date" - creates it if necessary
     */
    public DT getAdvanceDirectiveLastVerifiedDate() { 
		DT retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-50: "Advance Directive Last Verified Date" - creates it if necessary
     */
    public DT getPv250_AdvanceDirectiveLastVerifiedDate() { 
		DT retVal = this.getTypedField(50, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new DTM(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new XCN(getMessage());
          case 13: return new DT(getMessage());
          case 14: return new ID(getMessage(), new Integer( 136 ));
          case 15: return new CWE(getMessage());
          case 16: return new DT(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new ID(getMessage(), new Integer( 136 ));
          case 19: return new NM(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new ID(getMessage(), new Integer( 136 ));
          case 22: return new XON(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new DT(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new DT(getMessage());
          case 28: return new DT(getMessage());
          case 29: return new CWE(getMessage());
          case 30: return new CWE(getMessage());
          case 31: return new ID(getMessage(), new Integer( 136 ));
          case 32: return new DTM(getMessage());
          case 33: return new ID(getMessage(), new Integer( 136 ));
          case 34: return new ID(getMessage(), new Integer( 136 ));
          case 35: return new ID(getMessage(), new Integer( 136 ));
          case 36: return new ID(getMessage(), new Integer( 136 ));
          case 37: return new CWE(getMessage());
          case 38: return new CWE(getMessage());
          case 39: return new CWE(getMessage());
          case 40: return new CWE(getMessage());
          case 41: return new CWE(getMessage());
          case 42: return new CWE(getMessage());
          case 43: return new CWE(getMessage());
          case 44: return new CWE(getMessage());
          case 45: return new DT(getMessage());
          case 46: return new DTM(getMessage());
          case 47: return new DTM(getMessage());
          case 48: return new CWE(getMessage());
          case 49: return new DT(getMessage());
          default: return null;
       }
   }


}

