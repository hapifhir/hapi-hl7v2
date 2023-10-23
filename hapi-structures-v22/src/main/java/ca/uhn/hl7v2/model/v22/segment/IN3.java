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
 *<p>Represents an HL7 IN3 message segment (INSURANCE ADDITIONAL INFO-CERTIFICATION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN3-1: Set ID - insurance certification (SI) <b> </b>
     * <li>IN3-2: Certification number (ST) <b>optional </b>
     * <li>IN3-3: Certified by (CN) <b>optional </b>
     * <li>IN3-4: Certification required (ID) <b>optional </b>
     * <li>IN3-5: Penalty (CM_PEN) <b>optional </b>
     * <li>IN3-6: Certification date / time (TS) <b>optional </b>
     * <li>IN3-7: Certification modify date / time (TS) <b>optional </b>
     * <li>IN3-8: Operator (CN) <b>optional </b>
     * <li>IN3-9: Certification begin date (DT) <b>optional </b>
     * <li>IN3-10: Certification end date (DT) <b>optional </b>
     * <li>IN3-11: Days (CM_DTN) <b>optional </b>
     * <li>IN3-12: Non-concur code / description (CE) <b>optional </b>
     * <li>IN3-13: Non-concur effective date / time (TS) <b>optional </b>
     * <li>IN3-14: Physician reviewer (CN) <b>optional </b>
     * <li>IN3-15: Certification contact (ST) <b>optional </b>
     * <li>IN3-16: Certification contact phone number (TN) <b>optional repeating</b>
     * <li>IN3-17: Appeal reason (CE) <b>optional </b>
     * <li>IN3-18: Certification agency (CE) <b>optional </b>
     * <li>IN3-19: Certification agency phone number (TN) <b>optional repeating</b>
     * <li>IN3-20: Pre-certification required / window (CM_PCF) <b>optional repeating</b>
     * <li>IN3-21: Case manager (ST) <b>optional </b>
     * <li>IN3-22: Second opinion date (DT) <b>optional </b>
     * <li>IN3-23: Second opinion status (ID) <b>optional </b>
     * <li>IN3-24: Second opinion documentation received (ID) <b>optional </b>
     * <li>IN3-25: Second opinion practitioner (CN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IN3 extends AbstractSegment {

    /** 
     * Creates a new IN3 segment
     */
    public IN3(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - insurance certification");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Certification number");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Certified by");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Certification required");
                                  this.add(CM_PEN.class, false, 1, 10, new Object[]{ getMessage() }, "Penalty");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Certification date / time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Certification modify date / time");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Operator");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Certification begin date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Certification end date");
                                  this.add(CM_DTN.class, false, 1, 3, new Object[]{ getMessage() }, "Days");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Non-concur code / description");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Non-concur effective date / time");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Physician reviewer");
                                  this.add(ST.class, false, 1, 48, new Object[]{ getMessage() }, "Certification contact");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Certification contact phone number");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Appeal reason");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Certification agency");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Certification agency phone number");
                                  this.add(CM_PCF.class, false, 0, 40, new Object[]{ getMessage() }, "Pre-certification required / window");
                                  this.add(ST.class, false, 1, 48, new Object[]{ getMessage() }, "Case manager");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Second opinion date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(151) }, "Second opinion status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(152) }, "Second opinion documentation received");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Second opinion practitioner");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN3 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN3-1: "Set ID - insurance certification" - creates it if necessary
     */
    public SI getSetIDInsuranceCertification() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-1: "Set ID - insurance certification" - creates it if necessary
     */
    public SI getIn31_SetIDInsuranceCertification() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-2: "Certification number" - creates it if necessary
     */
    public ST getCertificationNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-2: "Certification number" - creates it if necessary
     */
    public ST getIn32_CertificationNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-3: "Certified by" - creates it if necessary
     */
    public CN getCertifiedBy() { 
		CN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-3: "Certified by" - creates it if necessary
     */
    public CN getIn33_CertifiedBy() { 
		CN retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-4: "Certification required" - creates it if necessary
     */
    public ID getCertificationRequired() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-4: "Certification required" - creates it if necessary
     */
    public ID getIn34_CertificationRequired() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-5: "Penalty" - creates it if necessary
     */
    public CM_PEN getPenalty() { 
		CM_PEN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-5: "Penalty" - creates it if necessary
     */
    public CM_PEN getIn35_Penalty() { 
		CM_PEN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-6: "Certification date / time" - creates it if necessary
     */
    public TS getCertificationDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-6: "Certification date / time" - creates it if necessary
     */
    public TS getIn36_CertificationDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-7: "Certification modify date / time" - creates it if necessary
     */
    public TS getCertificationModifyDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-7: "Certification modify date / time" - creates it if necessary
     */
    public TS getIn37_CertificationModifyDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-8: "Operator" - creates it if necessary
     */
    public CN getOperator() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-8: "Operator" - creates it if necessary
     */
    public CN getIn38_Operator() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-9: "Certification begin date" - creates it if necessary
     */
    public DT getCertificationBeginDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-9: "Certification begin date" - creates it if necessary
     */
    public DT getIn39_CertificationBeginDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-10: "Certification end date" - creates it if necessary
     */
    public DT getCertificationEndDate() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-10: "Certification end date" - creates it if necessary
     */
    public DT getIn310_CertificationEndDate() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-11: "Days" - creates it if necessary
     */
    public CM_DTN getDays() { 
		CM_DTN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-11: "Days" - creates it if necessary
     */
    public CM_DTN getIn311_Days() { 
		CM_DTN retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-12: "Non-concur code / description" - creates it if necessary
     */
    public CE getNonConcurCodeDescription() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-12: "Non-concur code / description" - creates it if necessary
     */
    public CE getIn312_NonConcurCodeDescription() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-13: "Non-concur effective date / time" - creates it if necessary
     */
    public TS getNonConcurEffectiveDateTime() { 
		TS retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-13: "Non-concur effective date / time" - creates it if necessary
     */
    public TS getIn313_NonConcurEffectiveDateTime() { 
		TS retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-14: "Physician reviewer" - creates it if necessary
     */
    public CN getPhysicianReviewer() { 
		CN retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-14: "Physician reviewer" - creates it if necessary
     */
    public CN getIn314_PhysicianReviewer() { 
		CN retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-15: "Certification contact" - creates it if necessary
     */
    public ST getCertificationContact() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-15: "Certification contact" - creates it if necessary
     */
    public ST getIn315_CertificationContact() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Certification contact phone number (IN3-16).
     */
    public TN[] getCertificationContactPhoneNumber() {
    	TN[] retVal = this.getTypedField(16, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Certification contact phone number (IN3-16).
     */
    public TN[] getIn316_CertificationContactPhoneNumber() {
    	TN[] retVal = this.getTypedField(16, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Certification contact phone number (IN3-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCertificationContactPhoneNumberReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * IN3-16: "Certification contact phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getCertificationContactPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-16: "Certification contact phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getIn316_CertificationContactPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Certification contact phone number (IN3-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn316_CertificationContactPhoneNumberReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * IN3-16: "Certification contact phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertCertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-16: "Certification contact phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertIn316_CertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * IN3-16: "Certification contact phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeCertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * IN3-16: "Certification contact phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeIn316_CertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * IN3-17: "Appeal reason" - creates it if necessary
     */
    public CE getAppealReason() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-17: "Appeal reason" - creates it if necessary
     */
    public CE getIn317_AppealReason() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-18: "Certification agency" - creates it if necessary
     */
    public CE getCertificationAgency() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-18: "Certification agency" - creates it if necessary
     */
    public CE getIn318_CertificationAgency() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Certification agency phone number (IN3-19).
     */
    public TN[] getCertificationAgencyPhoneNumber() {
    	TN[] retVal = this.getTypedField(19, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Certification agency phone number (IN3-19).
     */
    public TN[] getIn319_CertificationAgencyPhoneNumber() {
    	TN[] retVal = this.getTypedField(19, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Certification agency phone number (IN3-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCertificationAgencyPhoneNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * IN3-19: "Certification agency phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getCertificationAgencyPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-19: "Certification agency phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getIn319_CertificationAgencyPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Certification agency phone number (IN3-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn319_CertificationAgencyPhoneNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * IN3-19: "Certification agency phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertCertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-19: "Certification agency phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertIn319_CertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IN3-19: "Certification agency phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeCertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IN3-19: "Certification agency phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeIn319_CertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(19, rep);
    }



    /**
     * Returns all repetitions of Pre-certification required / window (IN3-20).
     */
    public CM_PCF[] getPreCertificationRequiredWindow() {
    	CM_PCF[] retVal = this.getTypedField(20, new CM_PCF[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pre-certification required / window (IN3-20).
     */
    public CM_PCF[] getIn320_PreCertificationRequiredWindow() {
    	CM_PCF[] retVal = this.getTypedField(20, new CM_PCF[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pre-certification required / window (IN3-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPreCertificationRequiredWindowReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * IN3-20: "Pre-certification required / window" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PCF getPreCertificationRequiredWindow(int rep) { 
		CM_PCF retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-20: "Pre-certification required / window" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PCF getIn320_PreCertificationRequiredWindow(int rep) { 
		CM_PCF retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pre-certification required / window (IN3-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn320_PreCertificationRequiredWindowReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * IN3-20: "Pre-certification required / window" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PCF insertPreCertificationRequiredWindow(int rep) throws HL7Exception { 
        return (CM_PCF) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-20: "Pre-certification required / window" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PCF insertIn320_PreCertificationRequiredWindow(int rep) throws HL7Exception { 
        return (CM_PCF) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * IN3-20: "Pre-certification required / window" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PCF removePreCertificationRequiredWindow(int rep) throws HL7Exception { 
        return (CM_PCF) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * IN3-20: "Pre-certification required / window" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PCF removeIn320_PreCertificationRequiredWindow(int rep) throws HL7Exception { 
        return (CM_PCF) super.removeRepetition(20, rep);
    }




    /**
     * Returns
     * IN3-21: "Case manager" - creates it if necessary
     */
    public ST getCaseManager() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-21: "Case manager" - creates it if necessary
     */
    public ST getIn321_CaseManager() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-22: "Second opinion date" - creates it if necessary
     */
    public DT getSecondOpinionDate() { 
		DT retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-22: "Second opinion date" - creates it if necessary
     */
    public DT getIn322_SecondOpinionDate() { 
		DT retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-23: "Second opinion status" - creates it if necessary
     */
    public ID getSecondOpinionStatus() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-23: "Second opinion status" - creates it if necessary
     */
    public ID getIn323_SecondOpinionStatus() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-24: "Second opinion documentation received" - creates it if necessary
     */
    public ID getSecondOpinionDocumentationReceived() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-24: "Second opinion documentation received" - creates it if necessary
     */
    public ID getIn324_SecondOpinionDocumentationReceived() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-25: "Second opinion practitioner" - creates it if necessary
     */
    public CN getSecondOpinionPractitioner() { 
		CN retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-25: "Second opinion practitioner" - creates it if necessary
     */
    public CN getIn325_SecondOpinionPractitioner() { 
		CN retVal = this.getTypedField(25, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new CN(getMessage());
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new CM_PEN(getMessage());
          case 5: return new TS(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new CN(getMessage());
          case 8: return new DT(getMessage());
          case 9: return new DT(getMessage());
          case 10: return new CM_DTN(getMessage());
          case 11: return new CE(getMessage());
          case 12: return new TS(getMessage());
          case 13: return new CN(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new TN(getMessage());
          case 16: return new CE(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new TN(getMessage());
          case 19: return new CM_PCF(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new DT(getMessage());
          case 22: return new ID(getMessage(), new Integer( 151 ));
          case 23: return new ID(getMessage(), new Integer( 152 ));
          case 24: return new CN(getMessage());
          default: return null;
       }
   }


}

