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
 *<p>Represents an HL7 RF1 message segment (Referral Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RF1-1: Referral Status (CWE) <b>optional </b>
     * <li>RF1-2: Referral Priority (CWE) <b>optional </b>
     * <li>RF1-3: Referral Type (CWE) <b>optional </b>
     * <li>RF1-4: Referral Disposition (CWE) <b>optional repeating</b>
     * <li>RF1-5: Referral Category (CWE) <b>optional </b>
     * <li>RF1-6: Originating Referral Identifier (EI) <b> </b>
     * <li>RF1-7: Effective Date (DTM) <b>optional </b>
     * <li>RF1-8: Expiration Date (DTM) <b>optional </b>
     * <li>RF1-9: Process Date (DTM) <b>optional </b>
     * <li>RF1-10: Referral Reason (CWE) <b>optional repeating</b>
     * <li>RF1-11: External Referral Identifier (EI) <b>optional repeating</b>
     * <li>RF1-12: Referral Documentation Completion Status (CWE) <b>optional </b>
     * <li>RF1-13: Planned Treatment Stop Date (DTM) <b>optional </b>
     * <li>RF1-14: Referral Reason Text (ST) <b>optional </b>
     * <li>RF1-15: Number of Authorized Treatments/Units (CQ) <b>optional </b>
     * <li>RF1-16: Number of Used Treatments/Units (CQ) <b>optional </b>
     * <li>RF1-17: Number of Schedule Treatments/Units (CQ) <b>optional </b>
     * <li>RF1-18: Remaining Benefit Amount (MO) <b>optional </b>
     * <li>RF1-19: Authorized Provider (XON) <b>optional </b>
     * <li>RF1-20: Authorized Health Professional (XCN) <b>optional </b>
     * <li>RF1-21: Source Text (ST) <b>optional </b>
     * <li>RF1-22: Source Date (DTM) <b>optional </b>
     * <li>RF1-23: Source Phone (XTN) <b>optional </b>
     * <li>RF1-24: Comment (ST) <b>optional </b>
     * <li>RF1-25: Action Code (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RF1 extends AbstractSegment {

    /** 
     * Creates a new RF1 segment
     */
    public RF1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Referral Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Referral Priority");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Referral Type");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Referral Disposition");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Referral Category");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Originating Referral Identifier");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Effective Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Expiration Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Process Date");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Referral Reason");
                                  this.add(EI.class, false, 0, 0, new Object[]{ getMessage() }, "External Referral Identifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Referral Documentation Completion Status");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Planned Treatment Stop Date");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Referral Reason Text");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Authorized Treatments/Units");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Used Treatments/Units");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Schedule Treatments/Units");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Remaining Benefit Amount");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Authorized Provider");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Authorized Health Professional");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Source Text");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Source Date");
                                  this.add(XTN.class, false, 1, 0, new Object[]{ getMessage() }, "Source Phone");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Comment");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(206) }, "Action Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RF1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RF1-1: "Referral Status" - creates it if necessary
     */
    public CWE getReferralStatus() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-1: "Referral Status" - creates it if necessary
     */
    public CWE getRf11_ReferralStatus() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-2: "Referral Priority" - creates it if necessary
     */
    public CWE getReferralPriority() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-2: "Referral Priority" - creates it if necessary
     */
    public CWE getRf12_ReferralPriority() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-3: "Referral Type" - creates it if necessary
     */
    public CWE getReferralType() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-3: "Referral Type" - creates it if necessary
     */
    public CWE getRf13_ReferralType() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Referral Disposition (RF1-4).
     */
    public CWE[] getReferralDisposition() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Referral Disposition (RF1-4).
     */
    public CWE[] getRf14_ReferralDisposition() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Referral Disposition (RF1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferralDispositionReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * RF1-4: "Referral Disposition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getReferralDisposition(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RF1-4: "Referral Disposition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRf14_ReferralDisposition(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Referral Disposition (RF1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRf14_ReferralDispositionReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertReferralDisposition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRf14_ReferralDisposition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeReferralDisposition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * RF1-4: "Referral Disposition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRf14_ReferralDisposition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * RF1-5: "Referral Category" - creates it if necessary
     */
    public CWE getReferralCategory() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-5: "Referral Category" - creates it if necessary
     */
    public CWE getRf15_ReferralCategory() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-6: "Originating Referral Identifier" - creates it if necessary
     */
    public EI getOriginatingReferralIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-6: "Originating Referral Identifier" - creates it if necessary
     */
    public EI getRf16_OriginatingReferralIdentifier() { 
		EI retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-7: "Effective Date" - creates it if necessary
     */
    public DTM getEffectiveDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-7: "Effective Date" - creates it if necessary
     */
    public DTM getRf17_EffectiveDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-8: "Expiration Date" - creates it if necessary
     */
    public DTM getExpirationDate() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-8: "Expiration Date" - creates it if necessary
     */
    public DTM getRf18_ExpirationDate() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-9: "Process Date" - creates it if necessary
     */
    public DTM getProcessDate() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-9: "Process Date" - creates it if necessary
     */
    public DTM getRf19_ProcessDate() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Referral Reason (RF1-10).
     */
    public CWE[] getReferralReason() {
    	CWE[] retVal = this.getTypedField(10, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Referral Reason (RF1-10).
     */
    public CWE[] getRf110_ReferralReason() {
    	CWE[] retVal = this.getTypedField(10, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Referral Reason (RF1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferralReasonReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * RF1-10: "Referral Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getReferralReason(int rep) { 
		CWE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RF1-10: "Referral Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRf110_ReferralReason(int rep) { 
		CWE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Referral Reason (RF1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRf110_ReferralReasonReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertReferralReason(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRf110_ReferralReason(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeReferralReason(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RF1-10: "Referral Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRf110_ReferralReason(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of External Referral Identifier (RF1-11).
     */
    public EI[] getExternalReferralIdentifier() {
    	EI[] retVal = this.getTypedField(11, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of External Referral Identifier (RF1-11).
     */
    public EI[] getRf111_ExternalReferralIdentifier() {
    	EI[] retVal = this.getTypedField(11, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of External Referral Identifier (RF1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getExternalReferralIdentifierReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * RF1-11: "External Referral Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getExternalReferralIdentifier(int rep) { 
		EI retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RF1-11: "External Referral Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getRf111_ExternalReferralIdentifier(int rep) { 
		EI retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of External Referral Identifier (RF1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRf111_ExternalReferralIdentifierReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertRf111_ExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * RF1-11: "External Referral Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeRf111_ExternalReferralIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * RF1-12: "Referral Documentation Completion Status" - creates it if necessary
     */
    public CWE getReferralDocumentationCompletionStatus() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-12: "Referral Documentation Completion Status" - creates it if necessary
     */
    public CWE getRf112_ReferralDocumentationCompletionStatus() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-13: "Planned Treatment Stop Date" - creates it if necessary
     */
    public DTM getPlannedTreatmentStopDate() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-13: "Planned Treatment Stop Date" - creates it if necessary
     */
    public DTM getRf113_PlannedTreatmentStopDate() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-14: "Referral Reason Text" - creates it if necessary
     */
    public ST getReferralReasonText() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-14: "Referral Reason Text" - creates it if necessary
     */
    public ST getRf114_ReferralReasonText() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-15: "Number of Authorized Treatments/Units" - creates it if necessary
     */
    public CQ getNumberOfAuthorizedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-15: "Number of Authorized Treatments/Units" - creates it if necessary
     */
    public CQ getRf115_NumberOfAuthorizedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-16: "Number of Used Treatments/Units" - creates it if necessary
     */
    public CQ getNumberOfUsedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-16: "Number of Used Treatments/Units" - creates it if necessary
     */
    public CQ getRf116_NumberOfUsedTreatmentsUnits() { 
		CQ retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-17: "Number of Schedule Treatments/Units" - creates it if necessary
     */
    public CQ getNumberOfScheduleTreatmentsUnits() { 
		CQ retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-17: "Number of Schedule Treatments/Units" - creates it if necessary
     */
    public CQ getRf117_NumberOfScheduleTreatmentsUnits() { 
		CQ retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-18: "Remaining Benefit Amount" - creates it if necessary
     */
    public MO getRemainingBenefitAmount() { 
		MO retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-18: "Remaining Benefit Amount" - creates it if necessary
     */
    public MO getRf118_RemainingBenefitAmount() { 
		MO retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-19: "Authorized Provider" - creates it if necessary
     */
    public XON getAuthorizedProvider() { 
		XON retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-19: "Authorized Provider" - creates it if necessary
     */
    public XON getRf119_AuthorizedProvider() { 
		XON retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-20: "Authorized Health Professional" - creates it if necessary
     */
    public XCN getAuthorizedHealthProfessional() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-20: "Authorized Health Professional" - creates it if necessary
     */
    public XCN getRf120_AuthorizedHealthProfessional() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-21: "Source Text" - creates it if necessary
     */
    public ST getSourceText() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-21: "Source Text" - creates it if necessary
     */
    public ST getRf121_SourceText() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-22: "Source Date" - creates it if necessary
     */
    public DTM getSourceDate() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-22: "Source Date" - creates it if necessary
     */
    public DTM getRf122_SourceDate() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-23: "Source Phone" - creates it if necessary
     */
    public XTN getSourcePhone() { 
		XTN retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-23: "Source Phone" - creates it if necessary
     */
    public XTN getRf123_SourcePhone() { 
		XTN retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-24: "Comment" - creates it if necessary
     */
    public ST getComment() { 
		ST retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-24: "Comment" - creates it if necessary
     */
    public ST getRf124_Comment() { 
		ST retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * RF1-25: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RF1-25: "Action Code" - creates it if necessary
     */
    public ID getRf125_ActionCode() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new EI(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new DTM(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new EI(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new DTM(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new CQ(getMessage());
          case 15: return new CQ(getMessage());
          case 16: return new CQ(getMessage());
          case 17: return new MO(getMessage());
          case 18: return new XON(getMessage());
          case 19: return new XCN(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new DTM(getMessage());
          case 22: return new XTN(getMessage());
          case 23: return new ST(getMessage());
          case 24: return new ID(getMessage(), new Integer( 206 ));
          default: return null;
       }
   }


}

