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
 *<p>Represents an HL7 PID message segment (PATIENT IDENTIFICATION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PID-1: Set ID - Patient ID (SI) <b>optional </b>
     * <li>PID-2: Patient ID (External ID) (CK) <b>optional </b>
     * <li>PID-3: Patient ID (Internal ID) (CM_PAT_ID) <b> repeating</b>
     * <li>PID-4: Alternate Patient ID (ST) <b>optional </b>
     * <li>PID-5: Patient Name (PN) <b> </b>
     * <li>PID-6: Mother's Maiden Name (ST) <b>optional </b>
     * <li>PID-7: Date of Birth (TS) <b>optional </b>
     * <li>PID-8: Sex (ID) <b>optional </b>
     * <li>PID-9: Patient Alias (PN) <b>optional repeating</b>
     * <li>PID-10: Race (ID) <b>optional </b>
     * <li>PID-11: Patient Address (AD) <b>optional repeating</b>
     * <li>PID-12: County code (ID) <b>optional </b>
     * <li>PID-13: Phone Number - Home (TN) <b>optional repeating</b>
     * <li>PID-14: Phone Number - Business (TN) <b>optional repeating</b>
     * <li>PID-15: Language - Patient (ST) <b>optional </b>
     * <li>PID-16: Marital Status (ID) <b>optional </b>
     * <li>PID-17: Religion (ID) <b>optional </b>
     * <li>PID-18: Patient Account Number (CK) <b>optional </b>
     * <li>PID-19: Social security number - patient (ST) <b>optional </b>
     * <li>PID-20: Driver's license number - patient (CM_LICENSE_NO) <b>optional </b>
     * <li>PID-21: Mother's Identifier (CK) <b>optional </b>
     * <li>PID-22: Ethnic Group (ID) <b>optional </b>
     * <li>PID-23: Birth Place (ST) <b>optional </b>
     * <li>PID-24: Multiple Birth Indicator (ID) <b>optional </b>
     * <li>PID-25: Birth Order (NM) <b>optional </b>
     * <li>PID-26: Citizenship (ID) <b>optional repeating</b>
     * <li>PID-27: Veterans Military Status (ST) <b>optional </b>
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
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - Patient ID");
                                  this.add(CK.class, false, 1, 16, new Object[]{ getMessage() }, "Patient ID (External ID)");
                                  this.add(CM_PAT_ID.class, true, 0, 20, new Object[]{ getMessage() }, "Patient ID (Internal ID)");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Alternate Patient ID");
                                  this.add(PN.class, true, 1, 48, new Object[]{ getMessage() }, "Patient Name");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Mother's Maiden Name");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date of Birth");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Sex");
                                  this.add(PN.class, false, 0, 48, new Object[]{ getMessage() }, "Patient Alias");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(5) }, "Race");
                                  this.add(AD.class, false, 3, 106, new Object[]{ getMessage() }, "Patient Address");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(0) }, "County code");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Phone Number - Home");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Phone Number - Business");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Language - Patient");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(2) }, "Marital Status");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(6) }, "Religion");
                                  this.add(CK.class, false, 1, 20, new Object[]{ getMessage() }, "Patient Account Number");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "Social security number - patient");
                                  this.add(CM_LICENSE_NO.class, false, 1, 25, new Object[]{ getMessage() }, "Driver's license number - patient");
                                  this.add(CK.class, false, 1, 20, new Object[]{ getMessage() }, "Mother's Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(189) }, "Ethnic Group");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Birth Place");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "Multiple Birth Indicator");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Birth Order");
                                              this.add(ID.class, false, 0, 3, new Object[]{ getMessage(), new Integer(171) }, "Citizenship");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Veterans Military Status");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PID - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PID-1: "Set ID - Patient ID" - creates it if necessary
     */
    public SI getSetIDPatientID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-1: "Set ID - Patient ID" - creates it if necessary
     */
    public SI getPid1_SetIDPatientID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-2: "Patient ID (External ID)" - creates it if necessary
     */
    public CK getPatientIDExternalID() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-2: "Patient ID (External ID)" - creates it if necessary
     */
    public CK getPid2_PatientIDExternalID() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient ID (Internal ID) (PID-3).
     */
    public CM_PAT_ID[] getPatientIDInternalID() {
    	CM_PAT_ID[] retVal = this.getTypedField(3, new CM_PAT_ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient ID (Internal ID) (PID-3).
     */
    public CM_PAT_ID[] getPid3_PatientIDInternalID() {
    	CM_PAT_ID[] retVal = this.getTypedField(3, new CM_PAT_ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient ID (Internal ID) (PID-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientIDInternalIDReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PID-3: "Patient ID (Internal ID)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PAT_ID getPatientIDInternalID(int rep) { 
		CM_PAT_ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-3: "Patient ID (Internal ID)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PAT_ID getPid3_PatientIDInternalID(int rep) { 
		CM_PAT_ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient ID (Internal ID) (PID-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid3_PatientIDInternalIDReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PAT_ID insertPatientIDInternalID(int rep) throws HL7Exception { 
        return (CM_PAT_ID) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PAT_ID insertPid3_PatientIDInternalID(int rep) throws HL7Exception { 
        return (CM_PAT_ID) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PAT_ID removePatientIDInternalID(int rep) throws HL7Exception { 
        return (CM_PAT_ID) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PAT_ID removePid3_PatientIDInternalID(int rep) throws HL7Exception { 
        return (CM_PAT_ID) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * PID-4: "Alternate Patient ID" - creates it if necessary
     */
    public ST getAlternatePatientID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-4: "Alternate Patient ID" - creates it if necessary
     */
    public ST getPid4_AlternatePatientID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-5: "Patient Name" - creates it if necessary
     */
    public PN getPatientName() { 
		PN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-5: "Patient Name" - creates it if necessary
     */
    public PN getPid5_PatientName() { 
		PN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-6: "Mother's Maiden Name" - creates it if necessary
     */
    public ST getMotherSMaidenName() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-6: "Mother's Maiden Name" - creates it if necessary
     */
    public ST getPid6_MotherSMaidenName() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-7: "Date of Birth" - creates it if necessary
     */
    public TS getDateOfBirth() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-7: "Date of Birth" - creates it if necessary
     */
    public TS getPid7_DateOfBirth() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-8: "Sex" - creates it if necessary
     */
    public ID getSex() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-8: "Sex" - creates it if necessary
     */
    public ID getPid8_Sex() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Alias (PID-9).
     */
    public PN[] getPatientAlias() {
    	PN[] retVal = this.getTypedField(9, new PN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Alias (PID-9).
     */
    public PN[] getPid9_PatientAlias() {
    	PN[] retVal = this.getTypedField(9, new PN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Alias (PID-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientAliasReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * PID-9: "Patient Alias" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PN getPatientAlias(int rep) { 
		PN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-9: "Patient Alias" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PN getPid9_PatientAlias(int rep) { 
		PN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Alias (PID-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid9_PatientAliasReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN insertPatientAlias(int rep) throws HL7Exception { 
        return (PN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN insertPid9_PatientAlias(int rep) throws HL7Exception { 
        return (PN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN removePatientAlias(int rep) throws HL7Exception { 
        return (PN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN removePid9_PatientAlias(int rep) throws HL7Exception { 
        return (PN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PID-10: "Race" - creates it if necessary
     */
    public ID getRace() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-10: "Race" - creates it if necessary
     */
    public ID getPid10_Race() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Address (PID-11).
     */
    public AD[] getPatientAddress() {
    	AD[] retVal = this.getTypedField(11, new AD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Address (PID-11).
     */
    public AD[] getPid11_PatientAddress() {
    	AD[] retVal = this.getTypedField(11, new AD[0]);
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
    public AD getPatientAddress(int rep) { 
		AD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-11: "Patient Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public AD getPid11_PatientAddress(int rep) { 
		AD retVal = this.getTypedField(11, rep);
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
    public AD insertPatientAddress(int rep) throws HL7Exception { 
        return (AD) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD insertPid11_PatientAddress(int rep) throws HL7Exception { 
        return (AD) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD removePatientAddress(int rep) throws HL7Exception { 
        return (AD) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PID-11: "Patient Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD removePid11_PatientAddress(int rep) throws HL7Exception { 
        return (AD) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PID-12: "County code" - creates it if necessary
     */
    public ID getCountyCode() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-12: "County code" - creates it if necessary
     */
    public ID getPid12_CountyCode() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Phone Number - Home (PID-13).
     */
    public TN[] getPhoneNumberHome() {
    	TN[] retVal = this.getTypedField(13, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number - Home (PID-13).
     */
    public TN[] getPid13_PhoneNumberHome() {
    	TN[] retVal = this.getTypedField(13, new TN[0]);
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
    public TN getPhoneNumberHome(int rep) { 
		TN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-13: "Phone Number - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPid13_PhoneNumberHome(int rep) { 
		TN retVal = this.getTypedField(13, rep);
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
    public TN insertPhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPid13_PhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PID-13: "Phone Number - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePid13_PhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Phone Number - Business (PID-14).
     */
    public TN[] getPhoneNumberBusiness() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number - Business (PID-14).
     */
    public TN[] getPid14_PhoneNumberBusiness() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
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
    public TN getPhoneNumberBusiness(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-14: "Phone Number - Business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPid14_PhoneNumberBusiness(int rep) { 
		TN retVal = this.getTypedField(14, rep);
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
    public TN insertPhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPid14_PhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PID-14: "Phone Number - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePid14_PhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * PID-15: "Language - Patient" - creates it if necessary
     */
    public ST getLanguagePatient() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-15: "Language - Patient" - creates it if necessary
     */
    public ST getPid15_LanguagePatient() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-16: "Marital Status" - creates it if necessary
     */
    public ID getMaritalStatus() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-16: "Marital Status" - creates it if necessary
     */
    public ID getPid16_MaritalStatus() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-17: "Religion" - creates it if necessary
     */
    public ID getReligion() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-17: "Religion" - creates it if necessary
     */
    public ID getPid17_Religion() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-18: "Patient Account Number" - creates it if necessary
     */
    public CK getPatientAccountNumber() { 
		CK retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-18: "Patient Account Number" - creates it if necessary
     */
    public CK getPid18_PatientAccountNumber() { 
		CK retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-19: "Social security number - patient" - creates it if necessary
     */
    public ST getSocialSecurityNumberPatient() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-19: "Social security number - patient" - creates it if necessary
     */
    public ST getPid19_SocialSecurityNumberPatient() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-20: "Driver's license number - patient" - creates it if necessary
     */
    public CM_LICENSE_NO getDriverSLicenseNumberPatient() { 
		CM_LICENSE_NO retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-20: "Driver's license number - patient" - creates it if necessary
     */
    public CM_LICENSE_NO getPid20_DriverSLicenseNumberPatient() { 
		CM_LICENSE_NO retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-21: "Mother's Identifier" - creates it if necessary
     */
    public CK getMotherSIdentifier() { 
		CK retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-21: "Mother's Identifier" - creates it if necessary
     */
    public CK getPid21_MotherSIdentifier() { 
		CK retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-22: "Ethnic Group" - creates it if necessary
     */
    public ID getEthnicGroup() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-22: "Ethnic Group" - creates it if necessary
     */
    public ID getPid22_EthnicGroup() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
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
    public ID[] getCitizenship() {
    	ID[] retVal = this.getTypedField(26, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Citizenship (PID-26).
     */
    public ID[] getPid26_Citizenship() {
    	ID[] retVal = this.getTypedField(26, new ID[0]);
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
    public ID getCitizenship(int rep) { 
		ID retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-26: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPid26_Citizenship(int rep) { 
		ID retVal = this.getTypedField(26, rep);
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
    public ID insertCitizenship(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPid26_Citizenship(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeCitizenship(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PID-26: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePid26_Citizenship(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(26, rep);
    }




    /**
     * Returns
     * PID-27: "Veterans Military Status" - creates it if necessary
     */
    public ST getVeteransMilitaryStatus() { 
		ST retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-27: "Veterans Military Status" - creates it if necessary
     */
    public ST getPid27_VeteransMilitaryStatus() { 
		ST retVal = this.getTypedField(27, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CK(getMessage());
          case 2: return new CM_PAT_ID(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new PN(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new ID(getMessage(), new Integer( 1 ));
          case 8: return new PN(getMessage());
          case 9: return new ID(getMessage(), new Integer( 5 ));
          case 10: return new AD(getMessage());
          case 11: return new ID(getMessage(), new Integer( 0 ));
          case 12: return new TN(getMessage());
          case 13: return new TN(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new ID(getMessage(), new Integer( 2 ));
          case 16: return new ID(getMessage(), new Integer( 6 ));
          case 17: return new CK(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new CM_LICENSE_NO(getMessage());
          case 20: return new CK(getMessage());
          case 21: return new ID(getMessage(), new Integer( 189 ));
          case 22: return new ST(getMessage());
          case 23: return new ID(getMessage(), new Integer( 0 ));
          case 24: return new NM(getMessage());
          case 25: return new ID(getMessage(), new Integer( 171 ));
          case 26: return new ST(getMessage());
          default: return null;
       }
   }


}

