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
 *<p>Represents an HL7 PID message segment (Patient Identification). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PID-1: Set ID - Patient ID (SI) <b>optional </b>
     * <li>PID-2: Patient ID (External ID) (CX) <b>optional </b>
     * <li>PID-3: Patient ID (Internal ID) (CX) <b> repeating</b>
     * <li>PID-4: Alternate Patient ID (CX) <b>optional </b>
     * <li>PID-5: Patient Name (XPN) <b> repeating</b>
     * <li>PID-6: Mother's Maiden Name (XPN) <b>optional </b>
     * <li>PID-7: Date of Birth (TS) <b>optional </b>
     * <li>PID-8: Sex (IS) <b>optional </b>
     * <li>PID-9: Patient Alias (XPN) <b>optional repeating</b>
     * <li>PID-10: Race (IS) <b>optional </b>
     * <li>PID-11: Patient Address (XAD) <b>optional repeating</b>
     * <li>PID-12: County Code (IS) <b>optional </b>
     * <li>PID-13: Phone Number - Home (XTN) <b>optional repeating</b>
     * <li>PID-14: Phone Number - Business (XTN) <b>optional repeating</b>
     * <li>PID-15: Primary Language (CE) <b>optional </b>
     * <li>PID-16: Marital Status (IS) <b>optional repeating</b>
     * <li>PID-17: Religion (IS) <b>optional </b>
     * <li>PID-18: Patient Account Number (CX) <b>optional </b>
     * <li>PID-19: SSN Number - Patient (ST) <b>optional </b>
     * <li>PID-20: Driver's License Number (DLN) <b>optional </b>
     * <li>PID-21: Mother's Identifier (CX) <b>optional </b>
     * <li>PID-22: Ethnic Group (IS) <b>optional </b>
     * <li>PID-23: Birth Place (ST) <b>optional </b>
     * <li>PID-24: Multiple Birth Indicator (ID) <b>optional </b>
     * <li>PID-25: Birth Order (NM) <b>optional </b>
     * <li>PID-26: Citizenship (IS) <b>optional </b>
     * <li>PID-27: Veterans Military Status (CE) <b>optional </b>
     * <li>PID-28: Nationality Code (CE) <b>optional </b>
     * <li>PID-29: Patient Death Date and Time (TS) <b>optional </b>
     * <li>PID-30: Patient Death Indicator (ID) <b>optional </b>
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
                                  this.add(CX.class, false, 1, 16, new Object[]{ getMessage() }, "Patient ID (External ID)");
                                  this.add(CX.class, true, 0, 20, new Object[]{ getMessage() }, "Patient ID (Internal ID)");
                                  this.add(CX.class, false, 1, 12, new Object[]{ getMessage() }, "Alternate Patient ID");
                                  this.add(XPN.class, true, -1, 48, new Object[]{ getMessage() }, "Patient Name");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Mother's Maiden Name");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date of Birth");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Sex");
                                  this.add(XPN.class, false, 0, 48, new Object[]{ getMessage() }, "Patient Alias");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(5) }, "Race");
                                  this.add(XAD.class, false, 0, 106, new Object[]{ getMessage() }, "Patient Address");
                                              this.add(IS.class, false, 1, 4, new Object[]{ getMessage(), new Integer(0) }, "County Code");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Phone Number - Home");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Phone Number - Business");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Primary Language");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(2) }, "Marital Status");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(6) }, "Religion");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Patient Account Number");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "SSN Number - Patient");
                                  this.add(DLN.class, false, 1, 25, new Object[]{ getMessage() }, "Driver's License Number");
                                  this.add(CX.class, false, 1, 20, new Object[]{ getMessage() }, "Mother's Identifier");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(189) }, "Ethnic Group");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Birth Place");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Multiple Birth Indicator");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Birth Order");
                                              this.add(IS.class, false, 1, 4, new Object[]{ getMessage(), new Integer(171) }, "Citizenship");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Veterans Military Status");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Nationality Code");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Patient Death Date and Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Patient Death Indicator");
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
    public CX getPatientIDExternalID() { 
		CX retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-2: "Patient ID (External ID)" - creates it if necessary
     */
    public CX getPid2_PatientIDExternalID() { 
		CX retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient ID (Internal ID) (PID-3).
     */
    public CX[] getPatientIDInternalID() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient ID (Internal ID) (PID-3).
     */
    public CX[] getPid3_PatientIDInternalID() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
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
    public CX getPatientIDInternalID(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-3: "Patient ID (Internal ID)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPid3_PatientIDInternalID(int rep) { 
		CX retVal = this.getTypedField(3, rep);
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
    public CX insertPatientIDInternalID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPid3_PatientIDInternalID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePatientIDInternalID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PID-3: "Patient ID (Internal ID)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePid3_PatientIDInternalID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * PID-4: "Alternate Patient ID" - creates it if necessary
     */
    public CX getAlternatePatientID() { 
		CX retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-4: "Alternate Patient ID" - creates it if necessary
     */
    public CX getPid4_AlternatePatientID() { 
		CX retVal = this.getTypedField(4, 0);
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
     * Returns
     * PID-6: "Mother's Maiden Name" - creates it if necessary
     */
    public XPN getMotherSMaidenName() { 
		XPN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-6: "Mother's Maiden Name" - creates it if necessary
     */
    public XPN getPid6_MotherSMaidenName() { 
		XPN retVal = this.getTypedField(6, 0);
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
    public IS getSex() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-8: "Sex" - creates it if necessary
     */
    public IS getPid8_Sex() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Alias (PID-9).
     */
    public XPN[] getPatientAlias() {
    	XPN[] retVal = this.getTypedField(9, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Alias (PID-9).
     */
    public XPN[] getPid9_PatientAlias() {
    	XPN[] retVal = this.getTypedField(9, new XPN[0]);
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
    public XPN getPatientAlias(int rep) { 
		XPN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-9: "Patient Alias" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPid9_PatientAlias(int rep) { 
		XPN retVal = this.getTypedField(9, rep);
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
    public XPN insertPatientAlias(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPid9_PatientAlias(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePatientAlias(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PID-9: "Patient Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePid9_PatientAlias(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PID-10: "Race" - creates it if necessary
     */
    public IS getRace() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-10: "Race" - creates it if necessary
     */
    public IS getPid10_Race() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
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
    public IS getCountyCode() { 
		IS retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-12: "County Code" - creates it if necessary
     */
    public IS getPid12_CountyCode() { 
		IS retVal = this.getTypedField(12, 0);
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
    public CE getPrimaryLanguage() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-15: "Primary Language" - creates it if necessary
     */
    public CE getPid15_PrimaryLanguage() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (PID-16).
     */
    public IS[] getMaritalStatus() {
    	IS[] retVal = this.getTypedField(16, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (PID-16).
     */
    public IS[] getPid16_MaritalStatus() {
    	IS[] retVal = this.getTypedField(16, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Marital Status (PID-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMaritalStatusReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * PID-16: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getMaritalStatus(int rep) { 
		IS retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-16: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getPid16_MaritalStatus(int rep) { 
		IS retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Marital Status (PID-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid16_MaritalStatusReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * PID-16: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertMaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * PID-16: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertPid16_MaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PID-16: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeMaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PID-16: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removePid16_MaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * PID-17: "Religion" - creates it if necessary
     */
    public IS getReligion() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-17: "Religion" - creates it if necessary
     */
    public IS getPid17_Religion() { 
		IS retVal = this.getTypedField(17, 0);
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
    public ST getSSNNumberPatient() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-19: "SSN Number - Patient" - creates it if necessary
     */
    public ST getPid19_SSNNumberPatient() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-20: "Driver's License Number" - creates it if necessary
     */
    public DLN getDriverSLicenseNumber() { 
		DLN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-20: "Driver's License Number" - creates it if necessary
     */
    public DLN getPid20_DriverSLicenseNumber() { 
		DLN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-21: "Mother's Identifier" - creates it if necessary
     */
    public CX getMotherSIdentifier() { 
		CX retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-21: "Mother's Identifier" - creates it if necessary
     */
    public CX getPid21_MotherSIdentifier() { 
		CX retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-22: "Ethnic Group" - creates it if necessary
     */
    public IS getEthnicGroup() { 
		IS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-22: "Ethnic Group" - creates it if necessary
     */
    public IS getPid22_EthnicGroup() { 
		IS retVal = this.getTypedField(22, 0);
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
     * Returns
     * PID-26: "Citizenship" - creates it if necessary
     */
    public IS getCitizenship() { 
		IS retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-26: "Citizenship" - creates it if necessary
     */
    public IS getPid26_Citizenship() { 
		IS retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-27: "Veterans Military Status" - creates it if necessary
     */
    public CE getVeteransMilitaryStatus() { 
		CE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-27: "Veterans Military Status" - creates it if necessary
     */
    public CE getPid27_VeteransMilitaryStatus() { 
		CE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-28: "Nationality Code" - creates it if necessary
     */
    public CE getNationalityCode() { 
		CE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-28: "Nationality Code" - creates it if necessary
     */
    public CE getPid28_NationalityCode() { 
		CE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-29: "Patient Death Date and Time" - creates it if necessary
     */
    public TS getPatientDeathDateAndTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-29: "Patient Death Date and Time" - creates it if necessary
     */
    public TS getPid29_PatientDeathDateAndTime() { 
		TS retVal = this.getTypedField(29, 0);
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





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CX(getMessage());
          case 2: return new CX(getMessage());
          case 3: return new CX(getMessage());
          case 4: return new XPN(getMessage());
          case 5: return new XPN(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new IS(getMessage(), new Integer( 1 ));
          case 8: return new XPN(getMessage());
          case 9: return new IS(getMessage(), new Integer( 5 ));
          case 10: return new XAD(getMessage());
          case 11: return new IS(getMessage(), new Integer( 0 ));
          case 12: return new XTN(getMessage());
          case 13: return new XTN(getMessage());
          case 14: return new CE(getMessage());
          case 15: return new IS(getMessage(), new Integer( 2 ));
          case 16: return new IS(getMessage(), new Integer( 6 ));
          case 17: return new CX(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new DLN(getMessage());
          case 20: return new CX(getMessage());
          case 21: return new IS(getMessage(), new Integer( 189 ));
          case 22: return new ST(getMessage());
          case 23: return new ID(getMessage(), new Integer( 136 ));
          case 24: return new NM(getMessage());
          case 25: return new IS(getMessage(), new Integer( 171 ));
          case 26: return new CE(getMessage());
          case 27: return new CE(getMessage());
          case 28: return new TS(getMessage());
          case 29: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

