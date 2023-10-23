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
 *<p>Represents an HL7 PV1 message segment (PATIENT VISIT). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PV1-1: Set ID - Patient Visit (SI) <b>optional </b>
     * <li>PV1-2: Patient Class (ID) <b> </b>
     * <li>PV1-3: Assigned Patient Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>PV1-4: Admission Type (ID) <b>optional </b>
     * <li>PV1-5: Preadmit Number (ST) <b>optional </b>
     * <li>PV1-6: Prior Patient Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>PV1-7: Attending Doctor (CN) <b>optional </b>
     * <li>PV1-8: Referring Doctor (CN) <b>optional </b>
     * <li>PV1-9: Consulting Doctor (CN) <b>optional repeating</b>
     * <li>PV1-10: Hospital Service (ID) <b>optional </b>
     * <li>PV1-11: Temporary Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>PV1-12: Preadmit Test Indicator (ID) <b>optional </b>
     * <li>PV1-13: Readmission indicator (ID) <b>optional </b>
     * <li>PV1-14: Admit Source (ID) <b>optional </b>
     * <li>PV1-15: Ambulatory Status (ID) <b>optional repeating</b>
     * <li>PV1-16: VIP Indicator (ID) <b>optional </b>
     * <li>PV1-17: Admitting Doctor (CN) <b>optional </b>
     * <li>PV1-18: Patient type (ID) <b>optional </b>
     * <li>PV1-19: Visit Number (CM_PAT_ID) <b>optional </b>
     * <li>PV1-20: Financial Class (CM_FINANCE) <b>optional repeating</b>
     * <li>PV1-21: Charge Price Indicator (ID) <b>optional </b>
     * <li>PV1-22: Courtesy Code (ID) <b>optional </b>
     * <li>PV1-23: Credit Rating (ID) <b>optional </b>
     * <li>PV1-24: Contract Code (ID) <b>optional repeating</b>
     * <li>PV1-25: Contract Effective Date (DT) <b>optional repeating</b>
     * <li>PV1-26: Contract Amount (NM) <b>optional repeating</b>
     * <li>PV1-27: Contract Period (NM) <b>optional repeating</b>
     * <li>PV1-28: Interest Code (ID) <b>optional </b>
     * <li>PV1-29: Transfer to bad debt - code (ID) <b>optional </b>
     * <li>PV1-30: Transfer to bad debt - date (DT) <b>optional </b>
     * <li>PV1-31: Bad Debt Agency Code (ID) <b>optional </b>
     * <li>PV1-32: Bad Debt Transfer Amount (NM) <b>optional </b>
     * <li>PV1-33: Bad Debt Recovery Amount (NM) <b>optional </b>
     * <li>PV1-34: Delete Account Indicator (ID) <b>optional </b>
     * <li>PV1-35: Delete Account Date (DT) <b>optional </b>
     * <li>PV1-36: Discharge Disposition (ID) <b>optional </b>
     * <li>PV1-37: Discharged to Location (CM_DLD) <b>optional </b>
     * <li>PV1-38: Diet Type (ID) <b>optional </b>
     * <li>PV1-39: Servicing Facility (ID) <b>optional </b>
     * <li>PV1-40: Bed Status (ID) <b>optional </b>
     * <li>PV1-41: Account Status (ID) <b>optional </b>
     * <li>PV1-42: Pending Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>PV1-43: Prior Temporary Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>PV1-44: Admit date / time (TS) <b>optional </b>
     * <li>PV1-45: Discharge date / time (TS) <b>optional </b>
     * <li>PV1-46: Current Patient Balance (NM) <b>optional </b>
     * <li>PV1-47: Total Charges (NM) <b>optional </b>
     * <li>PV1-48: Total Adjustments (NM) <b>optional </b>
     * <li>PV1-49: Total Payments (NM) <b>optional </b>
     * <li>PV1-50: Alternate Visit ID (CM_PAT_ID_0192) <b>optional </b>
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
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - Patient Visit");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(4) }, "Patient Class");
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Assigned Patient Location");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(7) }, "Admission Type");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Preadmit Number");
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Prior Patient Location");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Attending Doctor");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Referring Doctor");
                                  this.add(CN.class, false, 0, 60, new Object[]{ getMessage() }, "Consulting Doctor");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(69) }, "Hospital Service");
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Temporary Location");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(87) }, "Preadmit Test Indicator");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(92) }, "Readmission indicator");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(23) }, "Admit Source");
                                              this.add(ID.class, false, 0, 2, new Object[]{ getMessage(), new Integer(9) }, "Ambulatory Status");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(99) }, "VIP Indicator");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Admitting Doctor");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(18) }, "Patient type");
                                  this.add(CM_PAT_ID.class, false, 1, 15, new Object[]{ getMessage() }, "Visit Number");
                                  this.add(CM_FINANCE.class, false, 4, 50, new Object[]{ getMessage() }, "Financial Class");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(32) }, "Charge Price Indicator");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(45) }, "Courtesy Code");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(46) }, "Credit Rating");
                                              this.add(ID.class, false, 0, 2, new Object[]{ getMessage(), new Integer(44) }, "Contract Code");
                                  this.add(DT.class, false, 0, 8, new Object[]{ getMessage() }, "Contract Effective Date");
                                  this.add(NM.class, false, 0, 12, new Object[]{ getMessage() }, "Contract Amount");
                                  this.add(NM.class, false, 0, 3, new Object[]{ getMessage() }, "Contract Period");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(73) }, "Interest Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(110) }, "Transfer to bad debt - code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Transfer to bad debt - date");
                                              this.add(ID.class, false, 1, 10, new Object[]{ getMessage(), new Integer(21) }, "Bad Debt Agency Code");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Bad Debt Transfer Amount");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Bad Debt Recovery Amount");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(111) }, "Delete Account Indicator");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Delete Account Date");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(112) }, "Discharge Disposition");
                                  this.add(CM_DLD.class, false, 1, 25, new Object[]{ getMessage() }, "Discharged to Location");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(114) }, "Diet Type");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(115) }, "Servicing Facility");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(116) }, "Bed Status");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(117) }, "Account Status");
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Pending Location");
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Prior Temporary Location");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Admit date / time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Discharge date / time");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Current Patient Balance");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Total Charges");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Total Adjustments");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "Total Payments");
                                  this.add(CM_PAT_ID_0192.class, false, 1, 20, new Object[]{ getMessage() }, "Alternate Visit ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PV1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PV1-1: "Set ID - Patient Visit" - creates it if necessary
     */
    public SI getSetIDPatientVisit() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-1: "Set ID - Patient Visit" - creates it if necessary
     */
    public SI getPv11_SetIDPatientVisit() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-2: "Patient Class" - creates it if necessary
     */
    public ID getPatientClass() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-2: "Patient Class" - creates it if necessary
     */
    public ID getPv12_PatientClass() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-3: "Assigned Patient Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getAssignedPatientLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-3: "Assigned Patient Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPv13_AssignedPatientLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-4: "Admission Type" - creates it if necessary
     */
    public ID getAdmissionType() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-4: "Admission Type" - creates it if necessary
     */
    public ID getPv14_AdmissionType() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-5: "Preadmit Number" - creates it if necessary
     */
    public ST getPreadmitNumber() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-5: "Preadmit Number" - creates it if necessary
     */
    public ST getPv15_PreadmitNumber() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-6: "Prior Patient Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPriorPatientLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-6: "Prior Patient Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPv16_PriorPatientLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-7: "Attending Doctor" - creates it if necessary
     */
    public CN getAttendingDoctor() { 
		CN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-7: "Attending Doctor" - creates it if necessary
     */
    public CN getPv17_AttendingDoctor() { 
		CN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-8: "Referring Doctor" - creates it if necessary
     */
    public CN getReferringDoctor() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-8: "Referring Doctor" - creates it if necessary
     */
    public CN getPv18_ReferringDoctor() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Consulting Doctor (PV1-9).
     */
    public CN[] getConsultingDoctor() {
    	CN[] retVal = this.getTypedField(9, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Consulting Doctor (PV1-9).
     */
    public CN[] getPv19_ConsultingDoctor() {
    	CN[] retVal = this.getTypedField(9, new CN[0]);
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
    public CN getConsultingDoctor(int rep) { 
		CN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-9: "Consulting Doctor" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getPv19_ConsultingDoctor(int rep) { 
		CN retVal = this.getTypedField(9, rep);
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
    public CN insertConsultingDoctor(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertPv19_ConsultingDoctor(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeConsultingDoctor(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PV1-9: "Consulting Doctor" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removePv19_ConsultingDoctor(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PV1-10: "Hospital Service" - creates it if necessary
     */
    public ID getHospitalService() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-10: "Hospital Service" - creates it if necessary
     */
    public ID getPv110_HospitalService() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-11: "Temporary Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getTemporaryLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-11: "Temporary Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPv111_TemporaryLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-12: "Preadmit Test Indicator" - creates it if necessary
     */
    public ID getPreadmitTestIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-12: "Preadmit Test Indicator" - creates it if necessary
     */
    public ID getPv112_PreadmitTestIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-13: "Readmission indicator" - creates it if necessary
     */
    public ID getReadmissionIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-13: "Readmission indicator" - creates it if necessary
     */
    public ID getPv113_ReadmissionIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-14: "Admit Source" - creates it if necessary
     */
    public ID getAdmitSource() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-14: "Admit Source" - creates it if necessary
     */
    public ID getPv114_AdmitSource() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (PV1-15).
     */
    public ID[] getAmbulatoryStatus() {
    	ID[] retVal = this.getTypedField(15, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (PV1-15).
     */
    public ID[] getPv115_AmbulatoryStatus() {
    	ID[] retVal = this.getTypedField(15, new ID[0]);
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
    public ID getAmbulatoryStatus(int rep) { 
		ID retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-15: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPv115_AmbulatoryStatus(int rep) { 
		ID retVal = this.getTypedField(15, rep);
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
    public ID insertAmbulatoryStatus(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPv115_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeAmbulatoryStatus(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PV1-15: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePv115_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * PV1-16: "VIP Indicator" - creates it if necessary
     */
    public ID getVIPIndicator() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-16: "VIP Indicator" - creates it if necessary
     */
    public ID getPv116_VIPIndicator() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-17: "Admitting Doctor" - creates it if necessary
     */
    public CN getAdmittingDoctor() { 
		CN retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-17: "Admitting Doctor" - creates it if necessary
     */
    public CN getPv117_AdmittingDoctor() { 
		CN retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-18: "Patient type" - creates it if necessary
     */
    public ID getPatientType() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-18: "Patient type" - creates it if necessary
     */
    public ID getPv118_PatientType() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-19: "Visit Number" - creates it if necessary
     */
    public CM_PAT_ID getVisitNumber() { 
		CM_PAT_ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-19: "Visit Number" - creates it if necessary
     */
    public CM_PAT_ID getPv119_VisitNumber() { 
		CM_PAT_ID retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Financial Class (PV1-20).
     */
    public CM_FINANCE[] getFinancialClass() {
    	CM_FINANCE[] retVal = this.getTypedField(20, new CM_FINANCE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Financial Class (PV1-20).
     */
    public CM_FINANCE[] getPv120_FinancialClass() {
    	CM_FINANCE[] retVal = this.getTypedField(20, new CM_FINANCE[0]);
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
    public CM_FINANCE getFinancialClass(int rep) { 
		CM_FINANCE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-20: "Financial Class" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_FINANCE getPv120_FinancialClass(int rep) { 
		CM_FINANCE retVal = this.getTypedField(20, rep);
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
    public CM_FINANCE insertFinancialClass(int rep) throws HL7Exception { 
        return (CM_FINANCE) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_FINANCE insertPv120_FinancialClass(int rep) throws HL7Exception { 
        return (CM_FINANCE) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_FINANCE removeFinancialClass(int rep) throws HL7Exception { 
        return (CM_FINANCE) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PV1-20: "Financial Class" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_FINANCE removePv120_FinancialClass(int rep) throws HL7Exception { 
        return (CM_FINANCE) super.removeRepetition(20, rep);
    }




    /**
     * Returns
     * PV1-21: "Charge Price Indicator" - creates it if necessary
     */
    public ID getChargePriceIndicator() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-21: "Charge Price Indicator" - creates it if necessary
     */
    public ID getPv121_ChargePriceIndicator() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-22: "Courtesy Code" - creates it if necessary
     */
    public ID getCourtesyCode() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-22: "Courtesy Code" - creates it if necessary
     */
    public ID getPv122_CourtesyCode() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-23: "Credit Rating" - creates it if necessary
     */
    public ID getCreditRating() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-23: "Credit Rating" - creates it if necessary
     */
    public ID getPv123_CreditRating() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contract Code (PV1-24).
     */
    public ID[] getContractCode() {
    	ID[] retVal = this.getTypedField(24, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Code (PV1-24).
     */
    public ID[] getPv124_ContractCode() {
    	ID[] retVal = this.getTypedField(24, new ID[0]);
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
    public ID getContractCode(int rep) { 
		ID retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-24: "Contract Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPv124_ContractCode(int rep) { 
		ID retVal = this.getTypedField(24, rep);
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
    public ID insertContractCode(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPv124_ContractCode(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeContractCode(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * PV1-24: "Contract Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePv124_ContractCode(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(24, rep);
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
    public ID getInterestCode() { 
		ID retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-28: "Interest Code" - creates it if necessary
     */
    public ID getPv128_InterestCode() { 
		ID retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-29: "Transfer to bad debt - code" - creates it if necessary
     */
    public ID getTransferToBadDebtCode() { 
		ID retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-29: "Transfer to bad debt - code" - creates it if necessary
     */
    public ID getPv129_TransferToBadDebtCode() { 
		ID retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-30: "Transfer to bad debt - date" - creates it if necessary
     */
    public DT getTransferToBadDebtDate() { 
		DT retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-30: "Transfer to bad debt - date" - creates it if necessary
     */
    public DT getPv130_TransferToBadDebtDate() { 
		DT retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-31: "Bad Debt Agency Code" - creates it if necessary
     */
    public ID getBadDebtAgencyCode() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-31: "Bad Debt Agency Code" - creates it if necessary
     */
    public ID getPv131_BadDebtAgencyCode() { 
		ID retVal = this.getTypedField(31, 0);
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
    public ID getDeleteAccountIndicator() { 
		ID retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-34: "Delete Account Indicator" - creates it if necessary
     */
    public ID getPv134_DeleteAccountIndicator() { 
		ID retVal = this.getTypedField(34, 0);
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
    public ID getDischargeDisposition() { 
		ID retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-36: "Discharge Disposition" - creates it if necessary
     */
    public ID getPv136_DischargeDisposition() { 
		ID retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-37: "Discharged to Location" - creates it if necessary
     */
    public CM_DLD getDischargedToLocation() { 
		CM_DLD retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-37: "Discharged to Location" - creates it if necessary
     */
    public CM_DLD getPv137_DischargedToLocation() { 
		CM_DLD retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-38: "Diet Type" - creates it if necessary
     */
    public ID getDietType() { 
		ID retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-38: "Diet Type" - creates it if necessary
     */
    public ID getPv138_DietType() { 
		ID retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-39: "Servicing Facility" - creates it if necessary
     */
    public ID getServicingFacility() { 
		ID retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-39: "Servicing Facility" - creates it if necessary
     */
    public ID getPv139_ServicingFacility() { 
		ID retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-40: "Bed Status" - creates it if necessary
     */
    public ID getBedStatus() { 
		ID retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-40: "Bed Status" - creates it if necessary
     */
    public ID getPv140_BedStatus() { 
		ID retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-41: "Account Status" - creates it if necessary
     */
    public ID getAccountStatus() { 
		ID retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-41: "Account Status" - creates it if necessary
     */
    public ID getPv141_AccountStatus() { 
		ID retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-42: "Pending Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPendingLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-42: "Pending Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPv142_PendingLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-43: "Prior Temporary Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPriorTemporaryLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-43: "Prior Temporary Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPv143_PriorTemporaryLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-44: "Admit date / time" - creates it if necessary
     */
    public TS getAdmitDateTime() { 
		TS retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-44: "Admit date / time" - creates it if necessary
     */
    public TS getPv144_AdmitDateTime() { 
		TS retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-45: "Discharge date / time" - creates it if necessary
     */
    public TS getDischargeDateTime() { 
		TS retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-45: "Discharge date / time" - creates it if necessary
     */
    public TS getPv145_DischargeDateTime() { 
		TS retVal = this.getTypedField(45, 0);
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
    public CM_PAT_ID_0192 getAlternateVisitID() { 
		CM_PAT_ID_0192 retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-50: "Alternate Visit ID" - creates it if necessary
     */
    public CM_PAT_ID_0192 getPv150_AlternateVisitID() { 
		CM_PAT_ID_0192 retVal = this.getTypedField(50, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 4 ));
          case 2: return new CM_INTERNAL_LOCATION(getMessage());
          case 3: return new ID(getMessage(), new Integer( 7 ));
          case 4: return new ST(getMessage());
          case 5: return new CM_INTERNAL_LOCATION(getMessage());
          case 6: return new CN(getMessage());
          case 7: return new CN(getMessage());
          case 8: return new CN(getMessage());
          case 9: return new ID(getMessage(), new Integer( 69 ));
          case 10: return new CM_INTERNAL_LOCATION(getMessage());
          case 11: return new ID(getMessage(), new Integer( 87 ));
          case 12: return new ID(getMessage(), new Integer( 92 ));
          case 13: return new ID(getMessage(), new Integer( 23 ));
          case 14: return new ID(getMessage(), new Integer( 9 ));
          case 15: return new ID(getMessage(), new Integer( 99 ));
          case 16: return new CN(getMessage());
          case 17: return new ID(getMessage(), new Integer( 18 ));
          case 18: return new CM_PAT_ID(getMessage());
          case 19: return new CM_FINANCE(getMessage());
          case 20: return new ID(getMessage(), new Integer( 32 ));
          case 21: return new ID(getMessage(), new Integer( 45 ));
          case 22: return new ID(getMessage(), new Integer( 46 ));
          case 23: return new ID(getMessage(), new Integer( 44 ));
          case 24: return new DT(getMessage());
          case 25: return new NM(getMessage());
          case 26: return new NM(getMessage());
          case 27: return new ID(getMessage(), new Integer( 73 ));
          case 28: return new ID(getMessage(), new Integer( 110 ));
          case 29: return new DT(getMessage());
          case 30: return new ID(getMessage(), new Integer( 21 ));
          case 31: return new NM(getMessage());
          case 32: return new NM(getMessage());
          case 33: return new ID(getMessage(), new Integer( 111 ));
          case 34: return new DT(getMessage());
          case 35: return new ID(getMessage(), new Integer( 112 ));
          case 36: return new CM_DLD(getMessage());
          case 37: return new ID(getMessage(), new Integer( 114 ));
          case 38: return new ID(getMessage(), new Integer( 115 ));
          case 39: return new ID(getMessage(), new Integer( 116 ));
          case 40: return new ID(getMessage(), new Integer( 117 ));
          case 41: return new CM_INTERNAL_LOCATION(getMessage());
          case 42: return new CM_INTERNAL_LOCATION(getMessage());
          case 43: return new TS(getMessage());
          case 44: return new TS(getMessage());
          case 45: return new NM(getMessage());
          case 46: return new NM(getMessage());
          case 47: return new NM(getMessage());
          case 48: return new NM(getMessage());
          case 49: return new CM_PAT_ID_0192(getMessage());
          default: return null;
       }
   }


}

