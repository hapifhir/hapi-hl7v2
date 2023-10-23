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
 *<p>Represents an HL7 PD1 message segment (Patient Additional Demographic). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PD1-1: Living Dependency (CWE) <b>optional repeating</b>
     * <li>PD1-2: Living Arrangement (CWE) <b>optional </b>
     * <li>PD1-3: Patient Primary Facility (XON) <b>optional repeating</b>
     * <li>PD1-4: Patient Primary Care Provider Name & ID No. (NULLDT) <b>optional </b>
     * <li>PD1-5: Student Indicator (CWE) <b>optional </b>
     * <li>PD1-6: Handicap (CWE) <b>optional </b>
     * <li>PD1-7: Living Will Code (CWE) <b>optional </b>
     * <li>PD1-8: Organ Donor Code (CWE) <b>optional </b>
     * <li>PD1-9: Separate Bill (ID) <b>optional </b>
     * <li>PD1-10: Duplicate Patient (CX) <b>optional repeating</b>
     * <li>PD1-11: Publicity Code (CWE) <b>optional </b>
     * <li>PD1-12: Protection Indicator (ID) <b>optional </b>
     * <li>PD1-13: Protection Indicator Effective Date (DT) <b>optional </b>
     * <li>PD1-14: Place of Worship (XON) <b>optional repeating</b>
     * <li>PD1-15: Advance Directive Code (CWE) <b>optional repeating</b>
     * <li>PD1-16: Immunization Registry Status (CWE) <b>optional </b>
     * <li>PD1-17: Immunization Registry Status Effective Date (DT) <b>optional </b>
     * <li>PD1-18: Publicity Code Effective Date (DT) <b>optional </b>
     * <li>PD1-19: Military Branch (CWE) <b>optional </b>
     * <li>PD1-20: Military Rank/Grade (CWE) <b>optional </b>
     * <li>PD1-21: Military Status (CWE) <b>optional </b>
     * <li>PD1-22: Advance Directive Last Verified Date (DT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PD1 extends AbstractSegment {

    /** 
     * Creates a new PD1 segment
     */
    public PD1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Living Dependency");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Living Arrangement");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Patient Primary Facility");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Primary Care Provider Name & ID No.");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Student Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Handicap");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Living Will Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Organ Donor Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Separate Bill");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Duplicate Patient");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Publicity Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Protection Indicator");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Protection Indicator Effective Date");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Place of Worship");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Advance Directive Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Immunization Registry Status");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Immunization Registry Status Effective Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Publicity Code Effective Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Military Branch");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Military Rank/Grade");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Military Status");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Advance Directive Last Verified Date");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PD1 - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Living Dependency (PD1-1).
     */
    public CWE[] getLivingDependency() {
    	CWE[] retVal = this.getTypedField(1, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Living Dependency (PD1-1).
     */
    public CWE[] getPd11_LivingDependency() {
    	CWE[] retVal = this.getTypedField(1, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Living Dependency (PD1-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLivingDependencyReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * PD1-1: "Living Dependency" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getLivingDependency(int rep) { 
		CWE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-1: "Living Dependency" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPd11_LivingDependency(int rep) { 
		CWE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Living Dependency (PD1-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd11_LivingDependencyReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * PD1-1: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertLivingDependency(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-1: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPd11_LivingDependency(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PD1-1: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeLivingDependency(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PD1-1: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePd11_LivingDependency(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * PD1-2: "Living Arrangement" - creates it if necessary
     */
    public CWE getLivingArrangement() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-2: "Living Arrangement" - creates it if necessary
     */
    public CWE getPd12_LivingArrangement() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Primary Facility (PD1-3).
     */
    public XON[] getPatientPrimaryFacility() {
    	XON[] retVal = this.getTypedField(3, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Primary Facility (PD1-3).
     */
    public XON[] getPd13_PatientPrimaryFacility() {
    	XON[] retVal = this.getTypedField(3, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Primary Facility (PD1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientPrimaryFacilityReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PD1-3: "Patient Primary Facility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPatientPrimaryFacility(int rep) { 
		XON retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-3: "Patient Primary Facility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPd13_PatientPrimaryFacility(int rep) { 
		XON retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Primary Facility (PD1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd13_PatientPrimaryFacilityReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPd13_PatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePd13_PatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * PD1-4: "Patient Primary Care Provider Name & ID No." - creates it if necessary
     */
    public NULLDT getPatientPrimaryCareProviderNameIDNo() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-4: "Patient Primary Care Provider Name & ID No." - creates it if necessary
     */
    public NULLDT getPd14_PatientPrimaryCareProviderNameIDNo() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-5: "Student Indicator" - creates it if necessary
     */
    public CWE getStudentIndicator() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-5: "Student Indicator" - creates it if necessary
     */
    public CWE getPd15_StudentIndicator() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-6: "Handicap" - creates it if necessary
     */
    public CWE getHandicap() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-6: "Handicap" - creates it if necessary
     */
    public CWE getPd16_Handicap() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-7: "Living Will Code" - creates it if necessary
     */
    public CWE getLivingWillCode() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-7: "Living Will Code" - creates it if necessary
     */
    public CWE getPd17_LivingWillCode() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-8: "Organ Donor Code" - creates it if necessary
     */
    public CWE getOrganDonorCode() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-8: "Organ Donor Code" - creates it if necessary
     */
    public CWE getPd18_OrganDonorCode() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-9: "Separate Bill" - creates it if necessary
     */
    public ID getSeparateBill() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-9: "Separate Bill" - creates it if necessary
     */
    public ID getPd19_SeparateBill() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Duplicate Patient (PD1-10).
     */
    public CX[] getDuplicatePatient() {
    	CX[] retVal = this.getTypedField(10, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Duplicate Patient (PD1-10).
     */
    public CX[] getPd110_DuplicatePatient() {
    	CX[] retVal = this.getTypedField(10, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Duplicate Patient (PD1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDuplicatePatientReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * PD1-10: "Duplicate Patient" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getDuplicatePatient(int rep) { 
		CX retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-10: "Duplicate Patient" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPd110_DuplicatePatient(int rep) { 
		CX retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Duplicate Patient (PD1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd110_DuplicatePatientReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertDuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPd110_DuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeDuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePd110_DuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * PD1-11: "Publicity Code" - creates it if necessary
     */
    public CWE getPublicityCode() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-11: "Publicity Code" - creates it if necessary
     */
    public CWE getPd111_PublicityCode() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-12: "Protection Indicator" - creates it if necessary
     */
    public ID getProtectionIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-12: "Protection Indicator" - creates it if necessary
     */
    public ID getPd112_ProtectionIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-13: "Protection Indicator Effective Date" - creates it if necessary
     */
    public DT getProtectionIndicatorEffectiveDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-13: "Protection Indicator Effective Date" - creates it if necessary
     */
    public DT getPd113_ProtectionIndicatorEffectiveDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Place of Worship (PD1-14).
     */
    public XON[] getPlaceOfWorship() {
    	XON[] retVal = this.getTypedField(14, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Place of Worship (PD1-14).
     */
    public XON[] getPd114_PlaceOfWorship() {
    	XON[] retVal = this.getTypedField(14, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Place of Worship (PD1-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlaceOfWorshipReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PD1-14: "Place of Worship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPlaceOfWorship(int rep) { 
		XON retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-14: "Place of Worship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPd114_PlaceOfWorship(int rep) { 
		XON retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Place of Worship (PD1-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd114_PlaceOfWorshipReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PD1-14: "Place of Worship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPlaceOfWorship(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-14: "Place of Worship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPd114_PlaceOfWorship(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PD1-14: "Place of Worship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePlaceOfWorship(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PD1-14: "Place of Worship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePd114_PlaceOfWorship(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of Advance Directive Code (PD1-15).
     */
    public CWE[] getAdvanceDirectiveCode() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Advance Directive Code (PD1-15).
     */
    public CWE[] getPd115_AdvanceDirectiveCode() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Advance Directive Code (PD1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdvanceDirectiveCodeReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * PD1-15: "Advance Directive Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAdvanceDirectiveCode(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-15: "Advance Directive Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPd115_AdvanceDirectiveCode(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Advance Directive Code (PD1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd115_AdvanceDirectiveCodeReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * PD1-15: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-15: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPd115_AdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PD1-15: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PD1-15: "Advance Directive Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePd115_AdvanceDirectiveCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * PD1-16: "Immunization Registry Status" - creates it if necessary
     */
    public CWE getImmunizationRegistryStatus() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-16: "Immunization Registry Status" - creates it if necessary
     */
    public CWE getPd116_ImmunizationRegistryStatus() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-17: "Immunization Registry Status Effective Date" - creates it if necessary
     */
    public DT getImmunizationRegistryStatusEffectiveDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-17: "Immunization Registry Status Effective Date" - creates it if necessary
     */
    public DT getPd117_ImmunizationRegistryStatusEffectiveDate() { 
		DT retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-18: "Publicity Code Effective Date" - creates it if necessary
     */
    public DT getPublicityCodeEffectiveDate() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-18: "Publicity Code Effective Date" - creates it if necessary
     */
    public DT getPd118_PublicityCodeEffectiveDate() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-19: "Military Branch" - creates it if necessary
     */
    public CWE getMilitaryBranch() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-19: "Military Branch" - creates it if necessary
     */
    public CWE getPd119_MilitaryBranch() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-20: "Military Rank/Grade" - creates it if necessary
     */
    public CWE getMilitaryRankGrade() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-20: "Military Rank/Grade" - creates it if necessary
     */
    public CWE getPd120_MilitaryRankGrade() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-21: "Military Status" - creates it if necessary
     */
    public CWE getMilitaryStatus() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-21: "Military Status" - creates it if necessary
     */
    public CWE getPd121_MilitaryStatus() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-22: "Advance Directive Last Verified Date" - creates it if necessary
     */
    public DT getAdvanceDirectiveLastVerifiedDate() { 
		DT retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-22: "Advance Directive Last Verified Date" - creates it if necessary
     */
    public DT getPd122_AdvanceDirectiveLastVerifiedDate() { 
		DT retVal = this.getTypedField(22, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new XON(getMessage());
          case 3: return new NULLDT(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new ID(getMessage(), new Integer( 136 ));
          case 9: return new CX(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          case 12: return new DT(getMessage());
          case 13: return new XON(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new DT(getMessage());
          case 17: return new DT(getMessage());
          case 18: return new CWE(getMessage());
          case 19: return new CWE(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new DT(getMessage());
          default: return null;
       }
   }


}

