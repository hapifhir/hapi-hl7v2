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
 *<p>Represents an HL7 AUT message segment (Authorization Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>AUT-1: Authorizing Payor, Plan ID (CWE) <b>optional </b>
     * <li>AUT-2: Authorizing Payor, Company ID (CWE) <b> </b>
     * <li>AUT-3: Authorizing Payor, Company Name (ST) <b>optional </b>
     * <li>AUT-4: Authorization Effective Date (DTM) <b>optional </b>
     * <li>AUT-5: Authorization Expiration Date (DTM) <b>optional </b>
     * <li>AUT-6: Authorization Identifier (EI) <b>optional </b>
     * <li>AUT-7: Reimbursement Limit (CP) <b>optional </b>
     * <li>AUT-8: Requested Number of Treatments (CQ) <b>optional </b>
     * <li>AUT-9: Authorized Number of Treatments (CQ) <b>optional </b>
     * <li>AUT-10: Process Date (DTM) <b>optional </b>
     * <li>AUT-11: Requested Discipline(s) (CWE) <b>optional repeating</b>
     * <li>AUT-12: Authorized Discipline(s) (CWE) <b>optional repeating</b>
     * <li>AUT-13: Authorization Referral Type (CWE) <b> </b>
     * <li>AUT-14: Approval Status (CWE) <b>optional </b>
     * <li>AUT-15: Planned Treatment Stop Date (DTM) <b>optional </b>
     * <li>AUT-16: Clinical Service (CWE) <b>optional </b>
     * <li>AUT-17: Reason Text (ST) <b>optional </b>
     * <li>AUT-18: Number of Authorized Treatments/Units (CQ) <b>optional </b>
     * <li>AUT-19: Number of Used Treatments/Units (CQ) <b>optional </b>
     * <li>AUT-20: Number of Schedule Treatments/Units (CQ) <b>optional </b>
     * <li>AUT-21: Encounter Type (CWE) <b>optional </b>
     * <li>AUT-22: Remaining Benefit Amount (MO) <b>optional </b>
     * <li>AUT-23: Authorized Provider (XON) <b>optional </b>
     * <li>AUT-24: Authorized Health Professional (XCN) <b>optional </b>
     * <li>AUT-25: Source Text (ST) <b>optional </b>
     * <li>AUT-26: Source Date (DTM) <b>optional </b>
     * <li>AUT-27: Source Phone (XTN) <b>optional </b>
     * <li>AUT-28: Comment (ST) <b>optional </b>
     * <li>AUT-29: Action Code (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class AUT extends AbstractSegment {

    /** 
     * Creates a new AUT segment
     */
    public AUT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Authorizing Payor, Plan ID");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Authorizing Payor, Company ID");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Authorizing Payor, Company Name");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Authorization Effective Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Authorization Expiration Date");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Authorization Identifier");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Reimbursement Limit");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Number of Treatments");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Authorized Number of Treatments");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Process Date");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Requested Discipline(s)");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Authorized Discipline(s)");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Authorization Referral Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Approval Status");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Planned Treatment Stop Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Clinical Service");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Reason Text");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Authorized Treatments/Units");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Used Treatments/Units");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Schedule Treatments/Units");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Encounter Type");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Remaining Benefit Amount");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Authorized Provider");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Authorized Health Professional");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Source Text");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Source Date");
                                  this.add(XTN.class, false, 1, 0, new Object[]{ getMessage() }, "Source Phone");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Comment");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(206) }, "Action Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating AUT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * AUT-1: "Authorizing Payor, Plan ID" - creates it if necessary
     */
    public CWE getAuthorizingPayorPlanID() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-1: "Authorizing Payor, Plan ID" - creates it if necessary
     */
    public CWE getAut1_AuthorizingPayorPlanID() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-2: "Authorizing Payor, Company ID" - creates it if necessary
     */
    public CWE getAuthorizingPayorCompanyID() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-2: "Authorizing Payor, Company ID" - creates it if necessary
     */
    public CWE getAut2_AuthorizingPayorCompanyID() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-3: "Authorizing Payor, Company Name" - creates it if necessary
     */
    public ST getAuthorizingPayorCompanyName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-3: "Authorizing Payor, Company Name" - creates it if necessary
     */
    public ST getAut3_AuthorizingPayorCompanyName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-4: "Authorization Effective Date" - creates it if necessary
     */
    public DTM getAuthorizationEffectiveDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-4: "Authorization Effective Date" - creates it if necessary
     */
    public DTM getAut4_AuthorizationEffectiveDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-5: "Authorization Expiration Date" - creates it if necessary
     */
    public DTM getAuthorizationExpirationDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-5: "Authorization Expiration Date" - creates it if necessary
     */
    public DTM getAut5_AuthorizationExpirationDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-6: "Authorization Identifier" - creates it if necessary
     */
    public EI getAuthorizationIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-6: "Authorization Identifier" - creates it if necessary
     */
    public EI getAut6_AuthorizationIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-7: "Reimbursement Limit" - creates it if necessary
     */
    public CP getReimbursementLimit() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-7: "Reimbursement Limit" - creates it if necessary
     */
    public CP getAut7_ReimbursementLimit() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-8: "Requested Number of Treatments" - creates it if necessary
     */
    public CQ getRequestedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-8: "Requested Number of Treatments" - creates it if necessary
     */
    public CQ getAut8_RequestedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-9: "Authorized Number of Treatments" - creates it if necessary
     */
    public CQ getAuthorizedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-9: "Authorized Number of Treatments" - creates it if necessary
     */
    public CQ getAut9_AuthorizedNumberOfTreatments() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-10: "Process Date" - creates it if necessary
     */
    public DTM getProcessDate() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-10: "Process Date" - creates it if necessary
     */
    public DTM getAut10_ProcessDate() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Requested Discipline(s) (AUT-11).
     */
    public CWE[] getRequestedDisciplineS() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Requested Discipline(s) (AUT-11).
     */
    public CWE[] getAut11_RequestedDisciplineS() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Requested Discipline(s) (AUT-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRequestedDisciplineSReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * AUT-11: "Requested Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRequestedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AUT-11: "Requested Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAut11_RequestedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Requested Discipline(s) (AUT-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAut11_RequestedDisciplineSReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAut11_RequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * AUT-11: "Requested Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAut11_RequestedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Authorized Discipline(s) (AUT-12).
     */
    public CWE[] getAuthorizedDisciplineS() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Authorized Discipline(s) (AUT-12).
     */
    public CWE[] getAut12_AuthorizedDisciplineS() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Authorized Discipline(s) (AUT-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAuthorizedDisciplineSReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * AUT-12: "Authorized Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAuthorizedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * AUT-12: "Authorized Discipline(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAut12_AuthorizedDisciplineS(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Authorized Discipline(s) (AUT-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAut12_AuthorizedDisciplineSReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAut12_AuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * AUT-12: "Authorized Discipline(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAut12_AuthorizedDisciplineS(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * AUT-13: "Authorization Referral Type" - creates it if necessary
     */
    public CWE getAuthorizationReferralType() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-13: "Authorization Referral Type" - creates it if necessary
     */
    public CWE getAut13_AuthorizationReferralType() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-14: "Approval Status" - creates it if necessary
     */
    public CWE getApprovalStatus() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-14: "Approval Status" - creates it if necessary
     */
    public CWE getAut14_ApprovalStatus() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-15: "Planned Treatment Stop Date" - creates it if necessary
     */
    public DTM getPlannedTreatmentStopDate() { 
		DTM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-15: "Planned Treatment Stop Date" - creates it if necessary
     */
    public DTM getAut15_PlannedTreatmentStopDate() { 
		DTM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-16: "Clinical Service" - creates it if necessary
     */
    public CWE getClinicalService() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-16: "Clinical Service" - creates it if necessary
     */
    public CWE getAut16_ClinicalService() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-17: "Reason Text" - creates it if necessary
     */
    public ST getReasonText() { 
		ST retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-17: "Reason Text" - creates it if necessary
     */
    public ST getAut17_ReasonText() { 
		ST retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-18: "Number of Authorized Treatments/Units" - creates it if necessary
     */
    public CQ getNumberOfAuthorizedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-18: "Number of Authorized Treatments/Units" - creates it if necessary
     */
    public CQ getAut18_NumberOfAuthorizedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-19: "Number of Used Treatments/Units" - creates it if necessary
     */
    public CQ getNumberOfUsedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-19: "Number of Used Treatments/Units" - creates it if necessary
     */
    public CQ getAut19_NumberOfUsedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-20: "Number of Schedule Treatments/Units" - creates it if necessary
     */
    public CQ getNumberOfScheduleTreatmentsUnits() { 
		CQ retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-20: "Number of Schedule Treatments/Units" - creates it if necessary
     */
    public CQ getAut20_NumberOfScheduleTreatmentsUnits() { 
		CQ retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-21: "Encounter Type" - creates it if necessary
     */
    public CWE getEncounterType() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-21: "Encounter Type" - creates it if necessary
     */
    public CWE getAut21_EncounterType() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-22: "Remaining Benefit Amount" - creates it if necessary
     */
    public MO getRemainingBenefitAmount() { 
		MO retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-22: "Remaining Benefit Amount" - creates it if necessary
     */
    public MO getAut22_RemainingBenefitAmount() { 
		MO retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-23: "Authorized Provider" - creates it if necessary
     */
    public XON getAuthorizedProvider() { 
		XON retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-23: "Authorized Provider" - creates it if necessary
     */
    public XON getAut23_AuthorizedProvider() { 
		XON retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-24: "Authorized Health Professional" - creates it if necessary
     */
    public XCN getAuthorizedHealthProfessional() { 
		XCN retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-24: "Authorized Health Professional" - creates it if necessary
     */
    public XCN getAut24_AuthorizedHealthProfessional() { 
		XCN retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-25: "Source Text" - creates it if necessary
     */
    public ST getSourceText() { 
		ST retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-25: "Source Text" - creates it if necessary
     */
    public ST getAut25_SourceText() { 
		ST retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-26: "Source Date" - creates it if necessary
     */
    public DTM getSourceDate() { 
		DTM retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-26: "Source Date" - creates it if necessary
     */
    public DTM getAut26_SourceDate() { 
		DTM retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-27: "Source Phone" - creates it if necessary
     */
    public XTN getSourcePhone() { 
		XTN retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-27: "Source Phone" - creates it if necessary
     */
    public XTN getAut27_SourcePhone() { 
		XTN retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-28: "Comment" - creates it if necessary
     */
    public ST getComment() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-28: "Comment" - creates it if necessary
     */
    public ST getAut28_Comment() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * AUT-29: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * AUT-29: "Action Code" - creates it if necessary
     */
    public ID getAut29_ActionCode() { 
		ID retVal = this.getTypedField(29, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new EI(getMessage());
          case 6: return new CP(getMessage());
          case 7: return new CQ(getMessage());
          case 8: return new CQ(getMessage());
          case 9: return new DTM(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new DTM(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new ST(getMessage());
          case 17: return new CQ(getMessage());
          case 18: return new CQ(getMessage());
          case 19: return new CQ(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new MO(getMessage());
          case 22: return new XON(getMessage());
          case 23: return new XCN(getMessage());
          case 24: return new ST(getMessage());
          case 25: return new DTM(getMessage());
          case 26: return new XTN(getMessage());
          case 27: return new ST(getMessage());
          case 28: return new ID(getMessage(), new Integer( 206 ));
          default: return null;
       }
   }


}

