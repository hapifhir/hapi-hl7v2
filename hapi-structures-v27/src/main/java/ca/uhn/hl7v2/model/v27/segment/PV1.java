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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PV1 message segment (Patient Visit). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PV1-1: Set ID - PV1 (SI) <b>optional </b>
     * <li>PV1-2: Patient Class (CWE) <b> </b>
     * <li>PV1-3: Assigned Patient Location (PL) <b>optional </b>
     * <li>PV1-4: Admission Type (CWE) <b>optional </b>
     * <li>PV1-5: Preadmit Number (CX) <b>optional </b>
     * <li>PV1-6: Prior Patient Location (PL) <b>optional </b>
     * <li>PV1-7: Attending Doctor (XCN) <b>optional repeating</b>
     * <li>PV1-8: Referring Doctor (XCN) <b>optional repeating</b>
     * <li>PV1-9: Consulting Doctor (XCN) <b>optional repeating</b>
     * <li>PV1-10: Hospital Service (CWE) <b>optional </b>
     * <li>PV1-11: Temporary Location (PL) <b>optional </b>
     * <li>PV1-12: Preadmit Test Indicator (CWE) <b>optional </b>
     * <li>PV1-13: Re-admission Indicator (CWE) <b>optional </b>
     * <li>PV1-14: Admit Source (CWE) <b>optional </b>
     * <li>PV1-15: Ambulatory Status (CWE) <b>optional repeating</b>
     * <li>PV1-16: VIP Indicator (CWE) <b>optional </b>
     * <li>PV1-17: Admitting Doctor (XCN) <b>optional repeating</b>
     * <li>PV1-18: Patient Type (CWE) <b>optional </b>
     * <li>PV1-19: Visit Number (CX) <b>optional </b>
     * <li>PV1-20: Financial Class (FC) <b>optional repeating</b>
     * <li>PV1-21: Charge Price Indicator (CWE) <b>optional </b>
     * <li>PV1-22: Courtesy Code (CWE) <b>optional </b>
     * <li>PV1-23: Credit Rating (CWE) <b>optional </b>
     * <li>PV1-24: Contract Code (CWE) <b>optional repeating</b>
     * <li>PV1-25: Contract Effective Date (DT) <b>optional repeating</b>
     * <li>PV1-26: Contract Amount (NM) <b>optional repeating</b>
     * <li>PV1-27: Contract Period (NM) <b>optional repeating</b>
     * <li>PV1-28: Interest Code (CWE) <b>optional </b>
     * <li>PV1-29: Transfer to Bad Debt Code (CWE) <b>optional </b>
     * <li>PV1-30: Transfer to Bad Debt Date (DT) <b>optional </b>
     * <li>PV1-31: Bad Debt Agency Code (CWE) <b>optional </b>
     * <li>PV1-32: Bad Debt Transfer Amount (NM) <b>optional </b>
     * <li>PV1-33: Bad Debt Recovery Amount (NM) <b>optional </b>
     * <li>PV1-34: Delete Account Indicator (CWE) <b>optional </b>
     * <li>PV1-35: Delete Account Date (DT) <b>optional </b>
     * <li>PV1-36: Discharge Disposition (CWE) <b>optional </b>
     * <li>PV1-37: Discharged to Location (DLD) <b>optional </b>
     * <li>PV1-38: Diet Type (CWE) <b>optional </b>
     * <li>PV1-39: Servicing Facility (CWE) <b>optional </b>
     * <li>PV1-40: Bed Status (CWE) <b>optional </b>
     * <li>PV1-41: Account Status (CWE) <b>optional </b>
     * <li>PV1-42: Pending Location (PL) <b>optional </b>
     * <li>PV1-43: Prior Temporary Location (PL) <b>optional </b>
     * <li>PV1-44: Admit Date/Time (DTM) <b>optional </b>
     * <li>PV1-45: Discharge Date/Time (DTM) <b>optional </b>
     * <li>PV1-46: Current Patient Balance (NM) <b>optional </b>
     * <li>PV1-47: Total Charges (NM) <b>optional </b>
     * <li>PV1-48: Total Adjustments (NM) <b>optional </b>
     * <li>PV1-49: Total Payments (NM) <b>optional </b>
     * <li>PV1-50: Alternate Visit ID (CX) <b>optional </b>
     * <li>PV1-51: Visit Indicator (CWE) <b>optional </b>
     * <li>PV1-52: Other Healthcare Provider (NULLDT) <b>optional </b>
     * <li>PV1-53: Service Episode Description (ST) <b>optional </b>
     * <li>PV1-54: Service Episode Identifier (CX) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PV1 extends AbstractSegment {

    /** 
     * Creates a new PV1 segment
     */
    public PV1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - PV1");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Patient Class");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Assigned Patient Location");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Admission Type");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Preadmit Number");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Prior Patient Location");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Attending Doctor");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Referring Doctor");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Consulting Doctor");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Hospital Service");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Temporary Location");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Preadmit Test Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Re-admission Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Admit Source");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Ambulatory Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "VIP Indicator");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Admitting Doctor");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Type");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Visit Number");
                                  this.add(FC.class, false, 0, 0, new Object[]{ getMessage() }, "Financial Class");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Charge Price Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Courtesy Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Credit Rating");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Contract Code");
                                  this.add(DT.class, false, 0, 0, new Object[]{ getMessage() }, "Contract Effective Date");
                                  this.add(NM.class, false, 0, 0, new Object[]{ getMessage() }, "Contract Amount");
                                  this.add(NM.class, false, 0, 0, new Object[]{ getMessage() }, "Contract Period");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Interest Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Transfer to Bad Debt Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Transfer to Bad Debt Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Bad Debt Agency Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Bad Debt Transfer Amount");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Bad Debt Recovery Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Delete Account Indicator");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Delete Account Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Discharge Disposition");
                                  this.add(DLD.class, false, 1, 0, new Object[]{ getMessage() }, "Discharged to Location");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Diet Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Servicing Facility");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Bed Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Account Status");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Pending Location");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Prior Temporary Location");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Admit Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Discharge Date/Time");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Current Patient Balance");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Total Charges");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Total Adjustments");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Total Payments");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Alternate Visit ID");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Visit Indicator");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Other Healthcare Provider");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Service Episode Description");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Service Episode Identifier");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PV1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PV1-1: "Set ID - PV1" - creates it if necessary
     */
    public SI getSetIDPV1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-1: "Set ID - PV1" - creates it if necessary
     */
    public SI getPv11_SetIDPV1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-2: "Patient Class" - creates it if necessary
     */
    public CWE getPatientClass() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-2: "Patient Class" - creates it if necessary
     */
    public CWE getPv12_PatientClass() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-3: "Assigned Patient Location" - creates it if necessary
     */
    public PL getAssignedPatientLocation() { 
		PL retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-3: "Assigned Patient Location" - creates it if necessary
     */
    public PL getPv13_AssignedPatientLocation() { 
		PL retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-4: "Admission Type" - creates it if necessary
     */
    public CWE getAdmissionType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-4: "Admission Type" - creates it if necessary
     */
    public CWE getPv14_AdmissionType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-5: "Preadmit Number" - creates it if necessary
     */
    public CX getPreadmitNumber() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-5: "Preadmit Number" - creates it if necessary
     */
    public CX getPv15_PreadmitNumber() { 
		CX retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-6: "Prior Patient Location" - creates it if necessary
     */
    public PL getPriorPatientLocation() { 
		PL retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-6: "Prior Patient Location" - creates it if necessary
     */
    public PL getPv16_PriorPatientLocation() { 
		PL retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Attending Doctor (PV1-7).
     */
    public XCN[] getAttendingDoctor() {
    	XCN[] retVal = this.getTypedField(7, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Attending Doctor (PV1-7).
     */
    public XCN[] getPv17_AttendingDoctor() {
    	XCN[] retVal = this.getTypedField(7, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Attending Doctor (PV1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAttendingDoctorReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PV1-7: "Attending Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getAttendingDoctor(int rep) { 
		XCN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-7: "Attending Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPv17_AttendingDoctor(int rep) { 
		XCN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Attending Doctor (PV1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv17_AttendingDoctorReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PV1-7: "Attending Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertAttendingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-7: "Attending Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPv17_AttendingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PV1-7: "Attending Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeAttendingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PV1-7: "Attending Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePv17_AttendingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Referring Doctor (PV1-8).
     */
    public XCN[] getReferringDoctor() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Referring Doctor (PV1-8).
     */
    public XCN[] getPv18_ReferringDoctor() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Referring Doctor (PV1-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReferringDoctorReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * PV1-8: "Referring Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getReferringDoctor(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-8: "Referring Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPv18_ReferringDoctor(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Referring Doctor (PV1-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv18_ReferringDoctorReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * PV1-8: "Referring Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertReferringDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-8: "Referring Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPv18_ReferringDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PV1-8: "Referring Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeReferringDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PV1-8: "Referring Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePv18_ReferringDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of Consulting Doctor (PV1-9).
     */
    public XCN[] getConsultingDoctor() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Consulting Doctor (PV1-9).
     */
    public XCN[] getPv19_ConsultingDoctor() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Consulting Doctor (PV1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getConsultingDoctorReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * PV1-9: "Consulting Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getConsultingDoctor(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-9: "Consulting Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPv19_ConsultingDoctor(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Consulting Doctor (PV1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv19_ConsultingDoctorReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertConsultingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPv19_ConsultingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeConsultingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePv19_ConsultingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PV1-10: "Hospital Service" - creates it if necessary
     */
    public CWE getHospitalService() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-10: "Hospital Service" - creates it if necessary
     */
    public CWE getPv110_HospitalService() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-11: "Temporary Location" - creates it if necessary
     */
    public PL getTemporaryLocation() { 
		PL retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-11: "Temporary Location" - creates it if necessary
     */
    public PL getPv111_TemporaryLocation() { 
		PL retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-12: "Preadmit Test Indicator" - creates it if necessary
     */
    public CWE getPreadmitTestIndicator() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-12: "Preadmit Test Indicator" - creates it if necessary
     */
    public CWE getPv112_PreadmitTestIndicator() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-13: "Re-admission Indicator" - creates it if necessary
     */
    public CWE getReAdmissionIndicator() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-13: "Re-admission Indicator" - creates it if necessary
     */
    public CWE getPv113_ReAdmissionIndicator() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-14: "Admit Source" - creates it if necessary
     */
    public CWE getAdmitSource() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-14: "Admit Source" - creates it if necessary
     */
    public CWE getPv114_AdmitSource() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (PV1-15).
     */
    public CWE[] getAmbulatoryStatus() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (PV1-15).
     */
    public CWE[] getPv115_AmbulatoryStatus() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (PV1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAmbulatoryStatusReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * PV1-15: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAmbulatoryStatus(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-15: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv115_AmbulatoryStatus(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (PV1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv115_AmbulatoryStatusReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv115_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv115_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * PV1-16: "VIP Indicator" - creates it if necessary
     */
    public CWE getVIPIndicator() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-16: "VIP Indicator" - creates it if necessary
     */
    public CWE getPv116_VIPIndicator() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Admitting Doctor (PV1-17).
     */
    public XCN[] getAdmittingDoctor() {
    	XCN[] retVal = this.getTypedField(17, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Admitting Doctor (PV1-17).
     */
    public XCN[] getPv117_AdmittingDoctor() {
    	XCN[] retVal = this.getTypedField(17, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Admitting Doctor (PV1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdmittingDoctorReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * PV1-17: "Admitting Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getAdmittingDoctor(int rep) { 
		XCN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-17: "Admitting Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPv117_AdmittingDoctor(int rep) { 
		XCN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Admitting Doctor (PV1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv117_AdmittingDoctorReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * PV1-17: "Admitting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertAdmittingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-17: "Admitting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPv117_AdmittingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * PV1-17: "Admitting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeAdmittingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * PV1-17: "Admitting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePv117_AdmittingDoctor(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * PV1-18: "Patient Type" - creates it if necessary
     */
    public CWE getPatientType() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-18: "Patient Type" - creates it if necessary
     */
    public CWE getPv118_PatientType() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-19: "Visit Number" - creates it if necessary
     */
    public CX getVisitNumber() { 
		CX retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-19: "Visit Number" - creates it if necessary
     */
    public CX getPv119_VisitNumber() { 
		CX retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Financial Class (PV1-20).
     */
    public FC[] getFinancialClass() {
    	FC[] retVal = this.getTypedField(20, new FC[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Financial Class (PV1-20).
     */
    public FC[] getPv120_FinancialClass() {
    	FC[] retVal = this.getTypedField(20, new FC[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Financial Class (PV1-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFinancialClassReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * PV1-20: "Financial Class" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FC getFinancialClass(int rep) { 
		FC retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-20: "Financial Class" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FC getPv120_FinancialClass(int rep) { 
		FC retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Financial Class (PV1-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv120_FinancialClassReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FC insertFinancialClass(int rep) throws HL7Exception { 
        return (FC) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FC insertPv120_FinancialClass(int rep) throws HL7Exception { 
        return (FC) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FC removeFinancialClass(int rep) throws HL7Exception { 
        return (FC) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FC removePv120_FinancialClass(int rep) throws HL7Exception { 
        return (FC) super.removeRepetition(20, rep);
    }




    /**
     * Returns
     * PV1-21: "Charge Price Indicator" - creates it if necessary
     */
    public CWE getChargePriceIndicator() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-21: "Charge Price Indicator" - creates it if necessary
     */
    public CWE getPv121_ChargePriceIndicator() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-22: "Courtesy Code" - creates it if necessary
     */
    public CWE getCourtesyCode() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-22: "Courtesy Code" - creates it if necessary
     */
    public CWE getPv122_CourtesyCode() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-23: "Credit Rating" - creates it if necessary
     */
    public CWE getCreditRating() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-23: "Credit Rating" - creates it if necessary
     */
    public CWE getPv123_CreditRating() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contract Code (PV1-24).
     */
    public CWE[] getContractCode() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Code (PV1-24).
     */
    public CWE[] getPv124_ContractCode() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contract Code (PV1-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContractCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * PV1-24: "Contract Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getContractCode(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-24: "Contract Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPv124_ContractCode(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contract Code (PV1-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv124_ContractCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertContractCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPv124_ContractCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeContractCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePv124_ContractCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }



    /**
     * Returns all repetitions of Contract Effective Date (PV1-25).
     */
    public DT[] getContractEffectiveDate() {
    	DT[] retVal = this.getTypedField(25, new DT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Effective Date (PV1-25).
     */
    public DT[] getPv125_ContractEffectiveDate() {
    	DT[] retVal = this.getTypedField(25, new DT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contract Effective Date (PV1-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContractEffectiveDateReps() {
    	return this.getReps(25);
    }


    /**
     * Returns a specific repetition of
     * PV1-25: "Contract Effective Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DT getContractEffectiveDate(int rep) { 
		DT retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-25: "Contract Effective Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DT getPv125_ContractEffectiveDate(int rep) { 
		DT retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contract Effective Date (PV1-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv125_ContractEffectiveDateReps() {
    	return this.getReps(25);
    }


    /**
     * Inserts a repetition of
     * PV1-25: "Contract Effective Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT insertContractEffectiveDate(int rep) throws HL7Exception { 
        return (DT) super.insertRepetition(25, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-25: "Contract Effective Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT insertPv125_ContractEffectiveDate(int rep) throws HL7Exception { 
        return (DT) super.insertRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * PV1-25: "Contract Effective Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT removeContractEffectiveDate(int rep) throws HL7Exception { 
        return (DT) super.removeRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * PV1-25: "Contract Effective Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT removePv125_ContractEffectiveDate(int rep) throws HL7Exception { 
        return (DT) super.removeRepetition(25, rep);
    }



    /**
     * Returns all repetitions of Contract Amount (PV1-26).
     */
    public NM[] getContractAmount() {
    	NM[] retVal = this.getTypedField(26, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Amount (PV1-26).
     */
    public NM[] getPv126_ContractAmount() {
    	NM[] retVal = this.getTypedField(26, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contract Amount (PV1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContractAmountReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * PV1-26: "Contract Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getContractAmount(int rep) { 
		NM retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-26: "Contract Amount" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getPv126_ContractAmount(int rep) { 
		NM retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contract Amount (PV1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv126_ContractAmountReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * PV1-26: "Contract Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertContractAmount(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-26: "Contract Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertPv126_ContractAmount(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PV1-26: "Contract Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeContractAmount(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PV1-26: "Contract Amount" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removePv126_ContractAmount(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(26, rep);
    }



    /**
     * Returns all repetitions of Contract Period (PV1-27).
     */
    public NM[] getContractPeriod() {
    	NM[] retVal = this.getTypedField(27, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Period (PV1-27).
     */
    public NM[] getPv127_ContractPeriod() {
    	NM[] retVal = this.getTypedField(27, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contract Period (PV1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContractPeriodReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * PV1-27: "Contract Period" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getContractPeriod(int rep) { 
		NM retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-27: "Contract Period" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getPv127_ContractPeriod(int rep) { 
		NM retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contract Period (PV1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv127_ContractPeriodReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * PV1-27: "Contract Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertContractPeriod(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-27: "Contract Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertPv127_ContractPeriod(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * PV1-27: "Contract Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeContractPeriod(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * PV1-27: "Contract Period" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removePv127_ContractPeriod(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(27, rep);
    }




    /**
     * Returns
     * PV1-28: "Interest Code" - creates it if necessary
     */
    public CWE getInterestCode() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-28: "Interest Code" - creates it if necessary
     */
    public CWE getPv128_InterestCode() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-29: "Transfer to Bad Debt Code" - creates it if necessary
     */
    public CWE getTransferToBadDebtCode() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-29: "Transfer to Bad Debt Code" - creates it if necessary
     */
    public CWE getPv129_TransferToBadDebtCode() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-30: "Transfer to Bad Debt Date" - creates it if necessary
     */
    public DT getTransferToBadDebtDate() { 
		DT retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-30: "Transfer to Bad Debt Date" - creates it if necessary
     */
    public DT getPv130_TransferToBadDebtDate() { 
		DT retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-31: "Bad Debt Agency Code" - creates it if necessary
     */
    public CWE getBadDebtAgencyCode() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-31: "Bad Debt Agency Code" - creates it if necessary
     */
    public CWE getPv131_BadDebtAgencyCode() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-32: "Bad Debt Transfer Amount" - creates it if necessary
     */
    public NM getBadDebtTransferAmount() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-32: "Bad Debt Transfer Amount" - creates it if necessary
     */
    public NM getPv132_BadDebtTransferAmount() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-33: "Bad Debt Recovery Amount" - creates it if necessary
     */
    public NM getBadDebtRecoveryAmount() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-33: "Bad Debt Recovery Amount" - creates it if necessary
     */
    public NM getPv133_BadDebtRecoveryAmount() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-34: "Delete Account Indicator" - creates it if necessary
     */
    public CWE getDeleteAccountIndicator() { 
		CWE retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-34: "Delete Account Indicator" - creates it if necessary
     */
    public CWE getPv134_DeleteAccountIndicator() { 
		CWE retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-35: "Delete Account Date" - creates it if necessary
     */
    public DT getDeleteAccountDate() { 
		DT retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-35: "Delete Account Date" - creates it if necessary
     */
    public DT getPv135_DeleteAccountDate() { 
		DT retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-36: "Discharge Disposition" - creates it if necessary
     */
    public CWE getDischargeDisposition() { 
		CWE retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-36: "Discharge Disposition" - creates it if necessary
     */
    public CWE getPv136_DischargeDisposition() { 
		CWE retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-37: "Discharged to Location" - creates it if necessary
     */
    public DLD getDischargedToLocation() { 
		DLD retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-37: "Discharged to Location" - creates it if necessary
     */
    public DLD getPv137_DischargedToLocation() { 
		DLD retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-38: "Diet Type" - creates it if necessary
     */
    public CWE getDietType() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-38: "Diet Type" - creates it if necessary
     */
    public CWE getPv138_DietType() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-39: "Servicing Facility" - creates it if necessary
     */
    public CWE getServicingFacility() { 
		CWE retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-39: "Servicing Facility" - creates it if necessary
     */
    public CWE getPv139_ServicingFacility() { 
		CWE retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-40: "Bed Status" - creates it if necessary
     */
    public CWE getBedStatus() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-40: "Bed Status" - creates it if necessary
     */
    public CWE getPv140_BedStatus() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-41: "Account Status" - creates it if necessary
     */
    public CWE getAccountStatus() { 
		CWE retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-41: "Account Status" - creates it if necessary
     */
    public CWE getPv141_AccountStatus() { 
		CWE retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-42: "Pending Location" - creates it if necessary
     */
    public PL getPendingLocation() { 
		PL retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-42: "Pending Location" - creates it if necessary
     */
    public PL getPv142_PendingLocation() { 
		PL retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-43: "Prior Temporary Location" - creates it if necessary
     */
    public PL getPriorTemporaryLocation() { 
		PL retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-43: "Prior Temporary Location" - creates it if necessary
     */
    public PL getPv143_PriorTemporaryLocation() { 
		PL retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-44: "Admit Date/Time" - creates it if necessary
     */
    public DTM getAdmitDateTime() { 
		DTM retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-44: "Admit Date/Time" - creates it if necessary
     */
    public DTM getPv144_AdmitDateTime() { 
		DTM retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-45: "Discharge Date/Time" - creates it if necessary
     */
    public DTM getDischargeDateTime() { 
		DTM retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-45: "Discharge Date/Time" - creates it if necessary
     */
    public DTM getPv145_DischargeDateTime() { 
		DTM retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-46: "Current Patient Balance" - creates it if necessary
     */
    public NM getCurrentPatientBalance() { 
		NM retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-46: "Current Patient Balance" - creates it if necessary
     */
    public NM getPv146_CurrentPatientBalance() { 
		NM retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-47: "Total Charges" - creates it if necessary
     */
    public NM getTotalCharges() { 
		NM retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-47: "Total Charges" - creates it if necessary
     */
    public NM getPv147_TotalCharges() { 
		NM retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-48: "Total Adjustments" - creates it if necessary
     */
    public NM getTotalAdjustments() { 
		NM retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-48: "Total Adjustments" - creates it if necessary
     */
    public NM getPv148_TotalAdjustments() { 
		NM retVal = this.getTypedField(48, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-49: "Total Payments" - creates it if necessary
     */
    public NM getTotalPayments() { 
		NM retVal = this.getTypedField(49, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-49: "Total Payments" - creates it if necessary
     */
    public NM getPv149_TotalPayments() { 
		NM retVal = this.getTypedField(49, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-50: "Alternate Visit ID" - creates it if necessary
     */
    public CX getAlternateVisitID() { 
		CX retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-50: "Alternate Visit ID" - creates it if necessary
     */
    public CX getPv150_AlternateVisitID() { 
		CX retVal = this.getTypedField(50, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-51: "Visit Indicator" - creates it if necessary
     */
    public CWE getVisitIndicator() { 
		CWE retVal = this.getTypedField(51, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-51: "Visit Indicator" - creates it if necessary
     */
    public CWE getPv151_VisitIndicator() { 
		CWE retVal = this.getTypedField(51, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-52: "Other Healthcare Provider" - creates it if necessary
     */
    public NULLDT getOtherHealthcareProvider() { 
		NULLDT retVal = this.getTypedField(52, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-52: "Other Healthcare Provider" - creates it if necessary
     */
    public NULLDT getPv152_OtherHealthcareProvider() { 
		NULLDT retVal = this.getTypedField(52, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-53: "Service Episode Description" - creates it if necessary
     */
    public ST getServiceEpisodeDescription() { 
		ST retVal = this.getTypedField(53, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-53: "Service Episode Description" - creates it if necessary
     */
    public ST getPv153_ServiceEpisodeDescription() { 
		ST retVal = this.getTypedField(53, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-54: "Service Episode Identifier" - creates it if necessary
     */
    public CX getServiceEpisodeIdentifier() { 
		CX retVal = this.getTypedField(54, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-54: "Service Episode Identifier" - creates it if necessary
     */
    public CX getPv154_ServiceEpisodeIdentifier() { 
		CX retVal = this.getTypedField(54, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new PL(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CX(getMessage());
          case 5: return new PL(getMessage());
          case 6: return new XCN(getMessage());
          case 7: return new XCN(getMessage());
          case 8: return new XCN(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new PL(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new XCN(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new CX(getMessage());
          case 19: return new FC(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new CWE(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new DT(getMessage());
          case 25: return new NM(getMessage());
          case 26: return new NM(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new CWE(getMessage());
          case 29: return new DT(getMessage());
          case 30: return new CWE(getMessage());
          case 31: return new NM(getMessage());
          case 32: return new NM(getMessage());
          case 33: return new CWE(getMessage());
          case 34: return new DT(getMessage());
          case 35: return new CWE(getMessage());
          case 36: return new DLD(getMessage());
          case 37: return new CWE(getMessage());
          case 38: return new CWE(getMessage());
          case 39: return new CWE(getMessage());
          case 40: return new CWE(getMessage());
          case 41: return new PL(getMessage());
          case 42: return new PL(getMessage());
          case 43: return new DTM(getMessage());
          case 44: return new DTM(getMessage());
          case 45: return new NM(getMessage());
          case 46: return new NM(getMessage());
          case 47: return new NM(getMessage());
          case 48: return new NM(getMessage());
          case 49: return new CX(getMessage());
          case 50: return new CWE(getMessage());
          case 51: return new NULLDT(getMessage());
          case 52: return new ST(getMessage());
          case 53: return new CX(getMessage());
          default: return null;
       }
   }


}

