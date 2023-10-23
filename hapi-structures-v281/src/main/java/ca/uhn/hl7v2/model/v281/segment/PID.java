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
 *<p>Represents an HL7 PID message segment (Patient Identification). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PID-1: Set ID - PID (SI) <b>optional </b>
     * <li>PID-2: Patient ID (NULLDT) <b>optional </b>
     * <li>PID-3: Patient Identifier List (CX) <b> repeating</b>
     * <li>PID-4: Alternate Patient ID - PID (NULLDT) <b>optional </b>
     * <li>PID-5: Patient Name (XPN) <b> repeating</b>
     * <li>PID-6: Mother's Maiden Name (XPN) <b>optional repeating</b>
     * <li>PID-7: Date/Time of Birth (DTM) <b>optional </b>
     * <li>PID-8: Administrative Sex (CWE) <b>optional </b>
     * <li>PID-9: Patient Alias (NULLDT) <b>optional </b>
     * <li>PID-10: Race (CWE) <b>optional repeating</b>
     * <li>PID-11: Patient Address (XAD) <b>optional repeating</b>
     * <li>PID-12: County Code (NULLDT) <b>optional </b>
     * <li>PID-13: Phone Number - Home (XTN) <b>optional repeating</b>
     * <li>PID-14: Phone Number - Business (XTN) <b>optional repeating</b>
     * <li>PID-15: Primary Language (CWE) <b>optional </b>
     * <li>PID-16: Marital Status (CWE) <b>optional </b>
     * <li>PID-17: Religion (CWE) <b>optional </b>
     * <li>PID-18: Patient Account Number (CX) <b>optional </b>
     * <li>PID-19: SSN Number - Patient (NULLDT) <b>optional </b>
     * <li>PID-20: Driver's License Number - Patient (NULLDT) <b>optional </b>
     * <li>PID-21: Mother's Identifier (CX) <b>optional repeating</b>
     * <li>PID-22: Ethnic Group (CWE) <b>optional repeating</b>
     * <li>PID-23: Birth Place (ST) <b>optional </b>
     * <li>PID-24: Multiple Birth Indicator (ID) <b>optional </b>
     * <li>PID-25: Birth Order (NM) <b>optional </b>
     * <li>PID-26: Citizenship (CWE) <b>optional repeating</b>
     * <li>PID-27: Veterans Military Status (CWE) <b>optional </b>
     * <li>PID-28: Nationality (CWE) <b>optional </b>
     * <li>PID-29: Patient Death Date and Time (DTM) <b>optional </b>
     * <li>PID-30: Patient Death Indicator (ID) <b>optional </b>
     * <li>PID-31: Identity Unknown Indicator (ID) <b>optional </b>
     * <li>PID-32: Identity Reliability Code (CWE) <b>optional repeating</b>
     * <li>PID-33: Last Update Date/Time (DTM) <b>optional </b>
     * <li>PID-34: Last Update Facility (HD) <b>optional </b>
     * <li>PID-35: Taxonomic Classification Code (CWE) <b>optional </b>
     * <li>PID-36: Breed Code (CWE) <b>optional </b>
     * <li>PID-37: Strain (ST) <b>optional </b>
     * <li>PID-38: Production Class Code (CWE) <b>optional </b>
     * <li>PID-39: Tribal Citizenship (CWE) <b>optional repeating</b>
     * <li>PID-40: Patient Telecommunication Information (XTN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PID extends AbstractSegment {

    /** 
     * Creates a new PID segment
     */
    public PID(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - PID");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Patient ID");
                                  this.add(CX.class, true, 0, 0, new Object[]{ getMessage() }, "Patient Identifier List");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Alternate Patient ID - PID");
                                  this.add(XPN.class, true, 0, 0, new Object[]{ getMessage() }, "Patient Name");
                                  this.add(XPN.class, false, 0, 0, new Object[]{ getMessage() }, "Mother's Maiden Name");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date/Time of Birth");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Administrative Sex");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Alias");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Race");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Patient Address");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "County Code");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Phone Number - Home");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Phone Number - Business");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Primary Language");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Marital Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Religion");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Account Number");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "SSN Number - Patient");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Driver's License Number - Patient");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Mother's Identifier");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Ethnic Group");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Birth Place");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Multiple Birth Indicator");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Birth Order");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Citizenship");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Veterans Military Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Nationality");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Death Date and Time");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Patient Death Indicator");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Identity Unknown Indicator");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Identity Reliability Code");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Last Update Date/Time");
                                  this.add(HD.class, false, 1, 0, new Object[]{ getMessage() }, "Last Update Facility");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Taxonomic Classification Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Breed Code");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Strain");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Production Class Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Tribal Citizenship");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Patient Telecommunication Information");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PID - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PID-1: "Set ID - PID" - creates it if necessary
     */
    public SI getSetIDPID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-1: "Set ID - PID" - creates it if necessary
     */
    public SI getPid1_SetIDPID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-2: "Patient ID" - creates it if necessary
     */
    public NULLDT getPatientID() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-2: "Patient ID" - creates it if necessary
     */
    public NULLDT getPid2_PatientID() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Identifier List (PID-3).
     */
    public CX[] getPatientIdentifierList() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Identifier List (PID-3).
     */
    public CX[] getPid3_PatientIdentifierList() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Identifier List (PID-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientIdentifierListReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PID-3: "Patient Identifier List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPatientIdentifierList(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-3: "Patient Identifier List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPid3_PatientIdentifierList(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Identifier List (PID-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid3_PatientIdentifierListReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PID-3: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PID-3: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPid3_PatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PID-3: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PID-3: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePid3_PatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * PID-4: "Alternate Patient ID - PID" - creates it if necessary
     */
    public NULLDT getAlternatePatientIDPID() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-4: "Alternate Patient ID - PID" - creates it if necessary
     */
    public NULLDT getPid4_AlternatePatientIDPID() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Name (PID-5).
     */
    public XPN[] getPatientName() {
    	XPN[] retVal = this.getTypedField(5, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Name (PID-5).
     */
    public XPN[] getPid5_PatientName() {
    	XPN[] retVal = this.getTypedField(5, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Name (PID-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientNameReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PID-5: "Patient Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPatientName(int rep) { 
		XPN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-5: "Patient Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPid5_PatientName(int rep) { 
		XPN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Name (PID-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid5_PatientNameReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PID-5: "Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPatientName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PID-5: "Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPid5_PatientName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PID-5: "Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePatientName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PID-5: "Patient Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePid5_PatientName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Mother's Maiden Name (PID-6).
     */
    public XPN[] getMotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(6, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (PID-6).
     */
    public XPN[] getPid6_MotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(6, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (PID-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMotherSMaidenNameReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * PID-6: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-6: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPid6_MotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (PID-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid6_MotherSMaidenNameReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * PID-6: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * PID-6: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPid6_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PID-6: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PID-6: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePid6_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * PID-7: "Date/Time of Birth" - creates it if necessary
     */
    public DTM getDateTimeOfBirth() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-7: "Date/Time of Birth" - creates it if necessary
     */
    public DTM getPid7_DateTimeOfBirth() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-8: "Administrative Sex" - creates it if necessary
     */
    public CWE getAdministrativeSex() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-8: "Administrative Sex" - creates it if necessary
     */
    public CWE getPid8_AdministrativeSex() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-9: "Patient Alias" - creates it if necessary
     */
    public NULLDT getPatientAlias() { 
		NULLDT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-9: "Patient Alias" - creates it if necessary
     */
    public NULLDT getPid9_PatientAlias() { 
		NULLDT retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Race (PID-10).
     */
    public CWE[] getRace() {
    	CWE[] retVal = this.getTypedField(10, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Race (PID-10).
     */
    public CWE[] getPid10_Race() {
    	CWE[] retVal = this.getTypedField(10, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Race (PID-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRaceReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * PID-10: "Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRace(int rep) { 
		CWE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-10: "Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPid10_Race(int rep) { 
		CWE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Race (PID-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid10_RaceReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * PID-10: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRace(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * PID-10: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPid10_Race(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PID-10: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRace(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PID-10: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePid10_Race(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of Patient Address (PID-11).
     */
    public XAD[] getPatientAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Address (PID-11).
     */
    public XAD[] getPid11_PatientAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Address (PID-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PID-11: "Patient Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPatientAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-11: "Patient Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPid11_PatientAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Address (PID-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid11_PatientAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPatientAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPid11_PatientAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePatientAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePid11_PatientAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PID-12: "County Code" - creates it if necessary
     */
    public NULLDT getCountyCode() { 
		NULLDT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-12: "County Code" - creates it if necessary
     */
    public NULLDT getPid12_CountyCode() { 
		NULLDT retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Phone Number - Home (PID-13).
     */
    public XTN[] getPhoneNumberHome() {
    	XTN[] retVal = this.getTypedField(13, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number - Home (PID-13).
     */
    public XTN[] getPid13_PhoneNumberHome() {
    	XTN[] retVal = this.getTypedField(13, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phone Number - Home (PID-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhoneNumberHomeReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PID-13: "Phone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPhoneNumberHome(int rep) { 
		XTN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-13: "Phone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPid13_PhoneNumberHome(int rep) { 
		XTN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phone Number - Home (PID-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid13_PhoneNumberHomeReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPid13_PhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePid13_PhoneNumberHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Phone Number - Business (PID-14).
     */
    public XTN[] getPhoneNumberBusiness() {
    	XTN[] retVal = this.getTypedField(14, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number - Business (PID-14).
     */
    public XTN[] getPid14_PhoneNumberBusiness() {
    	XTN[] retVal = this.getTypedField(14, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phone Number - Business (PID-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhoneNumberBusinessReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PID-14: "Phone Number - Business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPhoneNumberBusiness(int rep) { 
		XTN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-14: "Phone Number - Business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPid14_PhoneNumberBusiness(int rep) { 
		XTN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phone Number - Business (PID-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid14_PhoneNumberBusinessReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPhoneNumberBusiness(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPid14_PhoneNumberBusiness(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePhoneNumberBusiness(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePid14_PhoneNumberBusiness(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * PID-15: "Primary Language" - creates it if necessary
     */
    public CWE getPrimaryLanguage() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-15: "Primary Language" - creates it if necessary
     */
    public CWE getPid15_PrimaryLanguage() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-16: "Marital Status" - creates it if necessary
     */
    public CWE getMaritalStatus() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-16: "Marital Status" - creates it if necessary
     */
    public CWE getPid16_MaritalStatus() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-17: "Religion" - creates it if necessary
     */
    public CWE getReligion() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-17: "Religion" - creates it if necessary
     */
    public CWE getPid17_Religion() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-18: "Patient Account Number" - creates it if necessary
     */
    public CX getPatientAccountNumber() { 
		CX retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-18: "Patient Account Number" - creates it if necessary
     */
    public CX getPid18_PatientAccountNumber() { 
		CX retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-19: "SSN Number - Patient" - creates it if necessary
     */
    public NULLDT getSSNNumberPatient() { 
		NULLDT retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-19: "SSN Number - Patient" - creates it if necessary
     */
    public NULLDT getPid19_SSNNumberPatient() { 
		NULLDT retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-20: "Driver's License Number - Patient" - creates it if necessary
     */
    public NULLDT getDriverSLicenseNumberPatient() { 
		NULLDT retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-20: "Driver's License Number - Patient" - creates it if necessary
     */
    public NULLDT getPid20_DriverSLicenseNumberPatient() { 
		NULLDT retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Mother's Identifier (PID-21).
     */
    public CX[] getMotherSIdentifier() {
    	CX[] retVal = this.getTypedField(21, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Mother's Identifier (PID-21).
     */
    public CX[] getPid21_MotherSIdentifier() {
    	CX[] retVal = this.getTypedField(21, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Mother's Identifier (PID-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMotherSIdentifierReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * PID-21: "Mother's Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getMotherSIdentifier(int rep) { 
		CX retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-21: "Mother's Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPid21_MotherSIdentifier(int rep) { 
		CX retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Mother's Identifier (PID-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid21_MotherSIdentifierReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * PID-21: "Mother's Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertMotherSIdentifier(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * PID-21: "Mother's Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPid21_MotherSIdentifier(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * PID-21: "Mother's Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeMotherSIdentifier(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * PID-21: "Mother's Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePid21_MotherSIdentifier(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(21, rep);
    }



    /**
     * Returns all repetitions of Ethnic Group (PID-22).
     */
    public CWE[] getEthnicGroup() {
    	CWE[] retVal = this.getTypedField(22, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (PID-22).
     */
    public CWE[] getPid22_EthnicGroup() {
    	CWE[] retVal = this.getTypedField(22, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ethnic Group (PID-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEthnicGroupReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * PID-22: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getEthnicGroup(int rep) { 
		CWE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-22: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPid22_EthnicGroup(int rep) { 
		CWE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ethnic Group (PID-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid22_EthnicGroupReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * PID-22: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertEthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * PID-22: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPid22_EthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * PID-22: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeEthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * PID-22: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePid22_EthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(22, rep);
    }




    /**
     * Returns
     * PID-23: "Birth Place" - creates it if necessary
     */
    public ST getBirthPlace() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-23: "Birth Place" - creates it if necessary
     */
    public ST getPid23_BirthPlace() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-24: "Multiple Birth Indicator" - creates it if necessary
     */
    public ID getMultipleBirthIndicator() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-24: "Multiple Birth Indicator" - creates it if necessary
     */
    public ID getPid24_MultipleBirthIndicator() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-25: "Birth Order" - creates it if necessary
     */
    public NM getBirthOrder() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-25: "Birth Order" - creates it if necessary
     */
    public NM getPid25_BirthOrder() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Citizenship (PID-26).
     */
    public CWE[] getCitizenship() {
    	CWE[] retVal = this.getTypedField(26, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Citizenship (PID-26).
     */
    public CWE[] getPid26_Citizenship() {
    	CWE[] retVal = this.getTypedField(26, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Citizenship (PID-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCitizenshipReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * PID-26: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCitizenship(int rep) { 
		CWE retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-26: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPid26_Citizenship(int rep) { 
		CWE retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Citizenship (PID-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid26_CitizenshipReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPid26_Citizenship(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePid26_Citizenship(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(26, rep);
    }




    /**
     * Returns
     * PID-27: "Veterans Military Status" - creates it if necessary
     */
    public CWE getVeteransMilitaryStatus() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-27: "Veterans Military Status" - creates it if necessary
     */
    public CWE getPid27_VeteransMilitaryStatus() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-28: "Nationality" - creates it if necessary
     */
    public CWE getNationality() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-28: "Nationality" - creates it if necessary
     */
    public CWE getPid28_Nationality() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-29: "Patient Death Date and Time" - creates it if necessary
     */
    public DTM getPatientDeathDateAndTime() { 
		DTM retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-29: "Patient Death Date and Time" - creates it if necessary
     */
    public DTM getPid29_PatientDeathDateAndTime() { 
		DTM retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-30: "Patient Death Indicator" - creates it if necessary
     */
    public ID getPatientDeathIndicator() { 
		ID retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-30: "Patient Death Indicator" - creates it if necessary
     */
    public ID getPid30_PatientDeathIndicator() { 
		ID retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-31: "Identity Unknown Indicator" - creates it if necessary
     */
    public ID getIdentityUnknownIndicator() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-31: "Identity Unknown Indicator" - creates it if necessary
     */
    public ID getPid31_IdentityUnknownIndicator() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Identity Reliability Code (PID-32).
     */
    public CWE[] getIdentityReliabilityCode() {
    	CWE[] retVal = this.getTypedField(32, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Identity Reliability Code (PID-32).
     */
    public CWE[] getPid32_IdentityReliabilityCode() {
    	CWE[] retVal = this.getTypedField(32, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Identity Reliability Code (PID-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIdentityReliabilityCodeReps() {
    	return this.getReps(32);
    }


    /**
     * Returns a specific repetition of
     * PID-32: "Identity Reliability Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getIdentityReliabilityCode(int rep) { 
		CWE retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-32: "Identity Reliability Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPid32_IdentityReliabilityCode(int rep) { 
		CWE retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Identity Reliability Code (PID-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid32_IdentityReliabilityCodeReps() {
    	return this.getReps(32);
    }


    /**
     * Inserts a repetition of
     * PID-32: "Identity Reliability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertIdentityReliabilityCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(32, rep);
    }


    /**
     * Inserts a repetition of
     * PID-32: "Identity Reliability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPid32_IdentityReliabilityCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * PID-32: "Identity Reliability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIdentityReliabilityCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * PID-32: "Identity Reliability Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePid32_IdentityReliabilityCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(32, rep);
    }




    /**
     * Returns
     * PID-33: "Last Update Date/Time" - creates it if necessary
     */
    public DTM getLastUpdateDateTime() { 
		DTM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-33: "Last Update Date/Time" - creates it if necessary
     */
    public DTM getPid33_LastUpdateDateTime() { 
		DTM retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-34: "Last Update Facility" - creates it if necessary
     */
    public HD getLastUpdateFacility() { 
		HD retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-34: "Last Update Facility" - creates it if necessary
     */
    public HD getPid34_LastUpdateFacility() { 
		HD retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-35: "Taxonomic Classification Code" - creates it if necessary
     */
    public CWE getTaxonomicClassificationCode() { 
		CWE retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-35: "Taxonomic Classification Code" - creates it if necessary
     */
    public CWE getPid35_TaxonomicClassificationCode() { 
		CWE retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-36: "Breed Code" - creates it if necessary
     */
    public CWE getBreedCode() { 
		CWE retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-36: "Breed Code" - creates it if necessary
     */
    public CWE getPid36_BreedCode() { 
		CWE retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-37: "Strain" - creates it if necessary
     */
    public ST getStrain() { 
		ST retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-37: "Strain" - creates it if necessary
     */
    public ST getPid37_Strain() { 
		ST retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-38: "Production Class Code" - creates it if necessary
     */
    public CWE getProductionClassCode() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-38: "Production Class Code" - creates it if necessary
     */
    public CWE getPid38_ProductionClassCode() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Tribal Citizenship (PID-39).
     */
    public CWE[] getTribalCitizenship() {
    	CWE[] retVal = this.getTypedField(39, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Tribal Citizenship (PID-39).
     */
    public CWE[] getPid39_TribalCitizenship() {
    	CWE[] retVal = this.getTypedField(39, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Tribal Citizenship (PID-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTribalCitizenshipReps() {
    	return this.getReps(39);
    }


    /**
     * Returns a specific repetition of
     * PID-39: "Tribal Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getTribalCitizenship(int rep) { 
		CWE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-39: "Tribal Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPid39_TribalCitizenship(int rep) { 
		CWE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Tribal Citizenship (PID-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid39_TribalCitizenshipReps() {
    	return this.getReps(39);
    }


    /**
     * Inserts a repetition of
     * PID-39: "Tribal Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertTribalCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(39, rep);
    }


    /**
     * Inserts a repetition of
     * PID-39: "Tribal Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPid39_TribalCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * PID-39: "Tribal Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeTribalCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * PID-39: "Tribal Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePid39_TribalCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(39, rep);
    }



    /**
     * Returns all repetitions of Patient Telecommunication Information (PID-40).
     */
    public XTN[] getPatientTelecommunicationInformation() {
    	XTN[] retVal = this.getTypedField(40, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Telecommunication Information (PID-40).
     */
    public XTN[] getPid40_PatientTelecommunicationInformation() {
    	XTN[] retVal = this.getTypedField(40, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Telecommunication Information (PID-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientTelecommunicationInformationReps() {
    	return this.getReps(40);
    }


    /**
     * Returns a specific repetition of
     * PID-40: "Patient Telecommunication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPatientTelecommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-40: "Patient Telecommunication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPid40_PatientTelecommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Telecommunication Information (PID-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid40_PatientTelecommunicationInformationReps() {
    	return this.getReps(40);
    }


    /**
     * Inserts a repetition of
     * PID-40: "Patient Telecommunication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPatientTelecommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(40, rep);
    }


    /**
     * Inserts a repetition of
     * PID-40: "Patient Telecommunication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPid40_PatientTelecommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * PID-40: "Patient Telecommunication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePatientTelecommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * PID-40: "Patient Telecommunication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePid40_PatientTelecommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(40, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new NULLDT(getMessage());
          case 2: return new CX(getMessage());
          case 3: return new NULLDT(getMessage());
          case 4: return new XPN(getMessage());
          case 5: return new XPN(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new NULLDT(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new XAD(getMessage());
          case 11: return new NULLDT(getMessage());
          case 12: return new XTN(getMessage());
          case 13: return new XTN(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new CWE(getMessage());
          case 17: return new CX(getMessage());
          case 18: return new NULLDT(getMessage());
          case 19: return new NULLDT(getMessage());
          case 20: return new CX(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new ST(getMessage());
          case 23: return new ID(getMessage(), new Integer( 136 ));
          case 24: return new NM(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new DTM(getMessage());
          case 29: return new ID(getMessage(), new Integer( 136 ));
          case 30: return new ID(getMessage(), new Integer( 136 ));
          case 31: return new CWE(getMessage());
          case 32: return new DTM(getMessage());
          case 33: return new HD(getMessage());
          case 34: return new CWE(getMessage());
          case 35: return new CWE(getMessage());
          case 36: return new ST(getMessage());
          case 37: return new CWE(getMessage());
          case 38: return new CWE(getMessage());
          case 39: return new XTN(getMessage());
          default: return null;
       }
   }


}

