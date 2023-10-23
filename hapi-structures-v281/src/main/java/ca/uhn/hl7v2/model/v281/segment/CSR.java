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
 *<p>Represents an HL7 CSR message segment (Clinical Study Registration). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CSR-1: Sponsor Study ID (EI) <b> </b>
     * <li>CSR-2: Alternate Study ID (EI) <b>optional </b>
     * <li>CSR-3: Institution Registering the Patient (CWE) <b>optional </b>
     * <li>CSR-4: Sponsor Patient ID (CX) <b> </b>
     * <li>CSR-5: Alternate Patient ID - CSR (CX) <b>optional </b>
     * <li>CSR-6: Date/Time of Patient Study Registration (DTM) <b> </b>
     * <li>CSR-7: Person Performing Study Registration (XCN) <b>optional repeating</b>
     * <li>CSR-8: Study Authorizing Provider (XCN) <b> repeating</b>
     * <li>CSR-9: Date/Time Patient Study Consent Signed (DTM) <b>optional </b>
     * <li>CSR-10: Patient Study Eligibility Status (CWE) <b>optional </b>
     * <li>CSR-11: Study Randomization Date/time (DTM) <b>optional repeating</b>
     * <li>CSR-12: Randomized Study Arm (CWE) <b>optional repeating</b>
     * <li>CSR-13: Stratum for Study Randomization (CWE) <b>optional repeating</b>
     * <li>CSR-14: Patient Evaluability Status (CWE) <b>optional </b>
     * <li>CSR-15: Date/Time Ended Study (DTM) <b>optional </b>
     * <li>CSR-16: Reason Ended Study (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CSR extends AbstractSegment {

    /** 
     * Creates a new CSR segment
     */
    public CSR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Sponsor Study ID");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Alternate Study ID");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Institution Registering the Patient");
                                  this.add(CX.class, true, 1, 0, new Object[]{ getMessage() }, "Sponsor Patient ID");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Alternate Patient ID - CSR");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Date/Time of Patient Study Registration");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Person Performing Study Registration");
                                  this.add(XCN.class, true, 0, 0, new Object[]{ getMessage() }, "Study Authorizing Provider");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date/Time Patient Study Consent Signed");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Study Eligibility Status");
                                  this.add(DTM.class, false, 3, 0, new Object[]{ getMessage() }, "Study Randomization Date/time");
                                  this.add(CWE.class, false, 3, 0, new Object[]{ getMessage() }, "Randomized Study Arm");
                                  this.add(CWE.class, false, 3, 0, new Object[]{ getMessage() }, "Stratum for Study Randomization");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Evaluability Status");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date/Time Ended Study");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Reason Ended Study");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CSR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CSR-1: "Sponsor Study ID" - creates it if necessary
     */
    public EI getSponsorStudyID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-1: "Sponsor Study ID" - creates it if necessary
     */
    public EI getCsr1_SponsorStudyID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-2: "Alternate Study ID" - creates it if necessary
     */
    public EI getAlternateStudyID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-2: "Alternate Study ID" - creates it if necessary
     */
    public EI getCsr2_AlternateStudyID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-3: "Institution Registering the Patient" - creates it if necessary
     */
    public CWE getInstitutionRegisteringThePatient() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-3: "Institution Registering the Patient" - creates it if necessary
     */
    public CWE getCsr3_InstitutionRegisteringThePatient() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-4: "Sponsor Patient ID" - creates it if necessary
     */
    public CX getSponsorPatientID() { 
		CX retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-4: "Sponsor Patient ID" - creates it if necessary
     */
    public CX getCsr4_SponsorPatientID() { 
		CX retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-5: "Alternate Patient ID - CSR" - creates it if necessary
     */
    public CX getAlternatePatientIDCSR() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-5: "Alternate Patient ID - CSR" - creates it if necessary
     */
    public CX getCsr5_AlternatePatientIDCSR() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-6: "Date/Time of Patient Study Registration" - creates it if necessary
     */
    public DTM getDateTimeOfPatientStudyRegistration() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-6: "Date/Time of Patient Study Registration" - creates it if necessary
     */
    public DTM getCsr6_DateTimeOfPatientStudyRegistration() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Person Performing Study Registration (CSR-7).
     */
    public XCN[] getPersonPerformingStudyRegistration() {
    	XCN[] retVal = this.getTypedField(7, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Person Performing Study Registration (CSR-7).
     */
    public XCN[] getCsr7_PersonPerformingStudyRegistration() {
    	XCN[] retVal = this.getTypedField(7, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Person Performing Study Registration (CSR-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPersonPerformingStudyRegistrationReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * CSR-7: "Person Performing Study Registration" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPersonPerformingStudyRegistration(int rep) { 
		XCN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CSR-7: "Person Performing Study Registration" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCsr7_PersonPerformingStudyRegistration(int rep) { 
		XCN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Person Performing Study Registration (CSR-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCsr7_PersonPerformingStudyRegistrationReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * CSR-7: "Person Performing Study Registration" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPersonPerformingStudyRegistration(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * CSR-7: "Person Performing Study Registration" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCsr7_PersonPerformingStudyRegistration(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * CSR-7: "Person Performing Study Registration" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePersonPerformingStudyRegistration(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * CSR-7: "Person Performing Study Registration" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCsr7_PersonPerformingStudyRegistration(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Study Authorizing Provider (CSR-8).
     */
    public XCN[] getStudyAuthorizingProvider() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Study Authorizing Provider (CSR-8).
     */
    public XCN[] getCsr8_StudyAuthorizingProvider() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Study Authorizing Provider (CSR-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStudyAuthorizingProviderReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * CSR-8: "Study Authorizing Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getStudyAuthorizingProvider(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CSR-8: "Study Authorizing Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCsr8_StudyAuthorizingProvider(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Study Authorizing Provider (CSR-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCsr8_StudyAuthorizingProviderReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * CSR-8: "Study Authorizing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertStudyAuthorizingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * CSR-8: "Study Authorizing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCsr8_StudyAuthorizingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * CSR-8: "Study Authorizing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeStudyAuthorizingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * CSR-8: "Study Authorizing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCsr8_StudyAuthorizingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * CSR-9: "Date/Time Patient Study Consent Signed" - creates it if necessary
     */
    public DTM getDateTimePatientStudyConsentSigned() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-9: "Date/Time Patient Study Consent Signed" - creates it if necessary
     */
    public DTM getCsr9_DateTimePatientStudyConsentSigned() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-10: "Patient Study Eligibility Status" - creates it if necessary
     */
    public CWE getPatientStudyEligibilityStatus() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-10: "Patient Study Eligibility Status" - creates it if necessary
     */
    public CWE getCsr10_PatientStudyEligibilityStatus() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Study Randomization Date/time (CSR-11).
     */
    public DTM[] getStudyRandomizationDateTime() {
    	DTM[] retVal = this.getTypedField(11, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Study Randomization Date/time (CSR-11).
     */
    public DTM[] getCsr11_StudyRandomizationDateTime() {
    	DTM[] retVal = this.getTypedField(11, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Study Randomization Date/time (CSR-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStudyRandomizationDateTimeReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * CSR-11: "Study Randomization Date/time" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getStudyRandomizationDateTime(int rep) { 
		DTM retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CSR-11: "Study Randomization Date/time" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getCsr11_StudyRandomizationDateTime(int rep) { 
		DTM retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Study Randomization Date/time (CSR-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCsr11_StudyRandomizationDateTimeReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * CSR-11: "Study Randomization Date/time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertStudyRandomizationDateTime(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * CSR-11: "Study Randomization Date/time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertCsr11_StudyRandomizationDateTime(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * CSR-11: "Study Randomization Date/time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeStudyRandomizationDateTime(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * CSR-11: "Study Randomization Date/time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeCsr11_StudyRandomizationDateTime(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Randomized Study Arm (CSR-12).
     */
    public CWE[] getRandomizedStudyArm() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Randomized Study Arm (CSR-12).
     */
    public CWE[] getCsr12_RandomizedStudyArm() {
    	CWE[] retVal = this.getTypedField(12, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Randomized Study Arm (CSR-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRandomizedStudyArmReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * CSR-12: "Randomized Study Arm" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRandomizedStudyArm(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CSR-12: "Randomized Study Arm" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCsr12_RandomizedStudyArm(int rep) { 
		CWE retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Randomized Study Arm (CSR-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCsr12_RandomizedStudyArmReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * CSR-12: "Randomized Study Arm" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRandomizedStudyArm(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * CSR-12: "Randomized Study Arm" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCsr12_RandomizedStudyArm(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * CSR-12: "Randomized Study Arm" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRandomizedStudyArm(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * CSR-12: "Randomized Study Arm" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCsr12_RandomizedStudyArm(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(12, rep);
    }



    /**
     * Returns all repetitions of Stratum for Study Randomization (CSR-13).
     */
    public CWE[] getStratumForStudyRandomization() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Stratum for Study Randomization (CSR-13).
     */
    public CWE[] getCsr13_StratumForStudyRandomization() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Stratum for Study Randomization (CSR-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStratumForStudyRandomizationReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * CSR-13: "Stratum for Study Randomization" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getStratumForStudyRandomization(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CSR-13: "Stratum for Study Randomization" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCsr13_StratumForStudyRandomization(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Stratum for Study Randomization (CSR-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCsr13_StratumForStudyRandomizationReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * CSR-13: "Stratum for Study Randomization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertStratumForStudyRandomization(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * CSR-13: "Stratum for Study Randomization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCsr13_StratumForStudyRandomization(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * CSR-13: "Stratum for Study Randomization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeStratumForStudyRandomization(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * CSR-13: "Stratum for Study Randomization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCsr13_StratumForStudyRandomization(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * CSR-14: "Patient Evaluability Status" - creates it if necessary
     */
    public CWE getPatientEvaluabilityStatus() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-14: "Patient Evaluability Status" - creates it if necessary
     */
    public CWE getCsr14_PatientEvaluabilityStatus() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-15: "Date/Time Ended Study" - creates it if necessary
     */
    public DTM getDateTimeEndedStudy() { 
		DTM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-15: "Date/Time Ended Study" - creates it if necessary
     */
    public DTM getCsr15_DateTimeEndedStudy() { 
		DTM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * CSR-16: "Reason Ended Study" - creates it if necessary
     */
    public CWE getReasonEndedStudy() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CSR-16: "Reason Ended Study" - creates it if necessary
     */
    public CWE getCsr16_ReasonEndedStudy() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CX(getMessage());
          case 4: return new CX(getMessage());
          case 5: return new DTM(getMessage());
          case 6: return new XCN(getMessage());
          case 7: return new XCN(getMessage());
          case 8: return new DTM(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new DTM(getMessage());
          case 15: return new CWE(getMessage());
          default: return null;
       }
   }


}

