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
 *<p>Represents an HL7 STF message segment (Staff identification segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>STF-1: STF - Primary Key Value (CE) <b> </b>
     * <li>STF-2: Staff ID Code (CE) <b>optional repeating</b>
     * <li>STF-3: Staff Name (XPN) <b>optional </b>
     * <li>STF-4: Staff Type (ID) <b>optional repeating</b>
     * <li>STF-5: Sex (IS) <b>optional </b>
     * <li>STF-6: Date of Birth (TS) <b>optional </b>
     * <li>STF-7: Active/Inactive Flag (ID) <b>optional </b>
     * <li>STF-8: Department (CE) <b>optional repeating</b>
     * <li>STF-9: Service (CE) <b>optional repeating</b>
     * <li>STF-10: Phone (XTN) <b>optional repeating</b>
     * <li>STF-11: Office/Home Address (AD) <b>optional repeating</b>
     * <li>STF-12: Activation Date (CM_DIN) <b>optional repeating</b>
     * <li>STF-13: Inactivation Date (CM_DIN) <b>optional repeating</b>
     * <li>STF-14: Backup Person ID (CE) <b>optional repeating</b>
     * <li>STF-15: E-mail Address (ST) <b>optional repeating</b>
     * <li>STF-16: Preferred Method of Contact (CE) <b>optional </b>
     * <li>STF-17: Marital Status (IS) <b>optional repeating</b>
     * <li>STF-18: Job Title (ST) <b>optional </b>
     * <li>STF-19: Job Code/Class (JCC) <b>optional </b>
     * <li>STF-20: Employment Status (IS) <b>optional </b>
     * <li>STF-21: Additional Insured on Auto (ID) <b>optional </b>
     * <li>STF-22: Driver's License Number (DLN) <b>optional </b>
     * <li>STF-23: Copy Auto Ins (ID) <b>optional </b>
     * <li>STF-24: Auto Ins. Expires (DT) <b>optional </b>
     * <li>STF-25: Date Last DMV Review (DT) <b>optional </b>
     * <li>STF-26: Date Next DMV Review (DT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class STF extends AbstractSegment {

    /** 
     * Creates a new STF segment
     */
    public STF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "STF - Primary Key Value");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Staff ID Code");
                                  this.add(XPN.class, false, 1, 48, new Object[]{ getMessage() }, "Staff Name");
                                              this.add(ID.class, false, 0, 2, new Object[]{ getMessage(), new Integer(182) }, "Staff Type");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Sex");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date of Birth");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(183) }, "Active/Inactive Flag");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Department");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Service");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Phone");
                                  this.add(AD.class, false, 2, 106, new Object[]{ getMessage() }, "Office/Home Address");
                                  this.add(CM_DIN.class, false, 0, 26, new Object[]{ getMessage() }, "Activation Date");
                                  this.add(CM_DIN.class, false, 0, 26, new Object[]{ getMessage() }, "Inactivation Date");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Backup Person ID");
                                  this.add(ST.class, false, 0, 40, new Object[]{ getMessage() }, "E-mail Address");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Preferred Method of Contact");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(2) }, "Marital Status");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Job Title");
                                  this.add(JCC.class, false, 1, 20, new Object[]{ getMessage() }, "Job Code/Class");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(66) }, "Employment Status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Additional Insured on Auto");
                                  this.add(DLN.class, false, 1, 25, new Object[]{ getMessage() }, "Driver's License Number");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Copy Auto Ins");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Auto Ins. Expires");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Date Last DMV Review");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Date Next DMV Review");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating STF - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * STF-1: "STF - Primary Key Value" - creates it if necessary
     */
    public CE getSTFPrimaryKeyValue() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-1: "STF - Primary Key Value" - creates it if necessary
     */
    public CE getStf1_STFPrimaryKeyValue() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Staff ID Code (STF-2).
     */
    public CE[] getStaffIDCode() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Staff ID Code (STF-2).
     */
    public CE[] getStf2_StaffIDCode() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Staff ID Code (STF-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStaffIDCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * STF-2: "Staff ID Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getStaffIDCode(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-2: "Staff ID Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getStf2_StaffIDCode(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Staff ID Code (STF-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf2_StaffIDCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * STF-2: "Staff ID Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertStaffIDCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * STF-2: "Staff ID Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertStf2_StaffIDCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * STF-2: "Staff ID Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeStaffIDCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * STF-2: "Staff ID Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeStf2_StaffIDCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * STF-3: "Staff Name" - creates it if necessary
     */
    public XPN getStaffName() { 
		XPN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-3: "Staff Name" - creates it if necessary
     */
    public XPN getStf3_StaffName() { 
		XPN retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Staff Type (STF-4).
     */
    public ID[] getStaffType() {
    	ID[] retVal = this.getTypedField(4, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Staff Type (STF-4).
     */
    public ID[] getStf4_StaffType() {
    	ID[] retVal = this.getTypedField(4, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Staff Type (STF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStaffTypeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * STF-4: "Staff Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getStaffType(int rep) { 
		ID retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-4: "Staff Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getStf4_StaffType(int rep) { 
		ID retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Staff Type (STF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf4_StaffTypeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * STF-4: "Staff Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertStaffType(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * STF-4: "Staff Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertStf4_StaffType(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * STF-4: "Staff Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeStaffType(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * STF-4: "Staff Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeStf4_StaffType(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * STF-5: "Sex" - creates it if necessary
     */
    public IS getSex() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-5: "Sex" - creates it if necessary
     */
    public IS getStf5_Sex() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-6: "Date of Birth" - creates it if necessary
     */
    public TS getDateOfBirth() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-6: "Date of Birth" - creates it if necessary
     */
    public TS getStf6_DateOfBirth() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-7: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getActiveInactiveFlag() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-7: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getStf7_ActiveInactiveFlag() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Department (STF-8).
     */
    public CE[] getDepartment() {
    	CE[] retVal = this.getTypedField(8, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Department (STF-8).
     */
    public CE[] getStf8_Department() {
    	CE[] retVal = this.getTypedField(8, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Department (STF-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDepartmentReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * STF-8: "Department" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getDepartment(int rep) { 
		CE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-8: "Department" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getStf8_Department(int rep) { 
		CE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Department (STF-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf8_DepartmentReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * STF-8: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertDepartment(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * STF-8: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertStf8_Department(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * STF-8: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeDepartment(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * STF-8: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeStf8_Department(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of Service (STF-9).
     */
    public CE[] getService() {
    	CE[] retVal = this.getTypedField(9, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Service (STF-9).
     */
    public CE[] getStf9_Service() {
    	CE[] retVal = this.getTypedField(9, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Service (STF-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getServiceReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * STF-9: "Service" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getService(int rep) { 
		CE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-9: "Service" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getStf9_Service(int rep) { 
		CE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Service (STF-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf9_ServiceReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * STF-9: "Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertService(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * STF-9: "Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertStf9_Service(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * STF-9: "Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeService(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * STF-9: "Service" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeStf9_Service(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Phone (STF-10).
     */
    public XTN[] getPhone() {
    	XTN[] retVal = this.getTypedField(10, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone (STF-10).
     */
    public XTN[] getStf10_Phone() {
    	XTN[] retVal = this.getTypedField(10, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phone (STF-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhoneReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * STF-10: "Phone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPhone(int rep) { 
		XTN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-10: "Phone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getStf10_Phone(int rep) { 
		XTN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phone (STF-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf10_PhoneReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * STF-10: "Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPhone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * STF-10: "Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertStf10_Phone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * STF-10: "Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePhone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * STF-10: "Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeStf10_Phone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of Office/Home Address (STF-11).
     */
    public AD[] getOfficeHomeAddress() {
    	AD[] retVal = this.getTypedField(11, new AD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Office/Home Address (STF-11).
     */
    public AD[] getStf11_OfficeHomeAddress() {
    	AD[] retVal = this.getTypedField(11, new AD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Office/Home Address (STF-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOfficeHomeAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * STF-11: "Office/Home Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public AD getOfficeHomeAddress(int rep) { 
		AD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-11: "Office/Home Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public AD getStf11_OfficeHomeAddress(int rep) { 
		AD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Office/Home Address (STF-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf11_OfficeHomeAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * STF-11: "Office/Home Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD insertOfficeHomeAddress(int rep) throws HL7Exception { 
        return (AD) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * STF-11: "Office/Home Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD insertStf11_OfficeHomeAddress(int rep) throws HL7Exception { 
        return (AD) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * STF-11: "Office/Home Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD removeOfficeHomeAddress(int rep) throws HL7Exception { 
        return (AD) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * STF-11: "Office/Home Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD removeStf11_OfficeHomeAddress(int rep) throws HL7Exception { 
        return (AD) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Activation Date (STF-12).
     */
    public CM_DIN[] getActivationDate() {
    	CM_DIN[] retVal = this.getTypedField(12, new CM_DIN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Activation Date (STF-12).
     */
    public CM_DIN[] getStf12_ActivationDate() {
    	CM_DIN[] retVal = this.getTypedField(12, new CM_DIN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Activation Date (STF-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getActivationDateReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * STF-12: "Activation Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_DIN getActivationDate(int rep) { 
		CM_DIN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-12: "Activation Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_DIN getStf12_ActivationDate(int rep) { 
		CM_DIN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Activation Date (STF-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf12_ActivationDateReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * STF-12: "Activation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN insertActivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * STF-12: "Activation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN insertStf12_ActivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * STF-12: "Activation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN removeActivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * STF-12: "Activation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN removeStf12_ActivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.removeRepetition(12, rep);
    }



    /**
     * Returns all repetitions of Inactivation Date (STF-13).
     */
    public CM_DIN[] getInactivationDate() {
    	CM_DIN[] retVal = this.getTypedField(13, new CM_DIN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Inactivation Date (STF-13).
     */
    public CM_DIN[] getStf13_InactivationDate() {
    	CM_DIN[] retVal = this.getTypedField(13, new CM_DIN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Inactivation Date (STF-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInactivationDateReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * STF-13: "Inactivation Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_DIN getInactivationDate(int rep) { 
		CM_DIN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-13: "Inactivation Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_DIN getStf13_InactivationDate(int rep) { 
		CM_DIN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Inactivation Date (STF-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf13_InactivationDateReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * STF-13: "Inactivation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN insertInactivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * STF-13: "Inactivation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN insertStf13_InactivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * STF-13: "Inactivation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN removeInactivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * STF-13: "Inactivation Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_DIN removeStf13_InactivationDate(int rep) throws HL7Exception { 
        return (CM_DIN) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Backup Person ID (STF-14).
     */
    public CE[] getBackupPersonID() {
    	CE[] retVal = this.getTypedField(14, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Backup Person ID (STF-14).
     */
    public CE[] getStf14_BackupPersonID() {
    	CE[] retVal = this.getTypedField(14, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Backup Person ID (STF-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBackupPersonIDReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * STF-14: "Backup Person ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getBackupPersonID(int rep) { 
		CE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-14: "Backup Person ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getStf14_BackupPersonID(int rep) { 
		CE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Backup Person ID (STF-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf14_BackupPersonIDReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * STF-14: "Backup Person ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertBackupPersonID(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * STF-14: "Backup Person ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertStf14_BackupPersonID(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * STF-14: "Backup Person ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeBackupPersonID(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * STF-14: "Backup Person ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeStf14_BackupPersonID(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of E-mail Address (STF-15).
     */
    public ST[] getEMailAddress() {
    	ST[] retVal = this.getTypedField(15, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of E-mail Address (STF-15).
     */
    public ST[] getStf15_EMailAddress() {
    	ST[] retVal = this.getTypedField(15, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of E-mail Address (STF-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEMailAddressReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * STF-15: "E-mail Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getEMailAddress(int rep) { 
		ST retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-15: "E-mail Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getStf15_EMailAddress(int rep) { 
		ST retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of E-mail Address (STF-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf15_EMailAddressReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * STF-15: "E-mail Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertEMailAddress(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * STF-15: "E-mail Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertStf15_EMailAddress(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * STF-15: "E-mail Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeEMailAddress(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * STF-15: "E-mail Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeStf15_EMailAddress(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * STF-16: "Preferred Method of Contact" - creates it if necessary
     */
    public CE getPreferredMethodOfContact() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-16: "Preferred Method of Contact" - creates it if necessary
     */
    public CE getStf16_PreferredMethodOfContact() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (STF-17).
     */
    public IS[] getMaritalStatus() {
    	IS[] retVal = this.getTypedField(17, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Marital Status (STF-17).
     */
    public IS[] getStf17_MaritalStatus() {
    	IS[] retVal = this.getTypedField(17, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Marital Status (STF-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMaritalStatusReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * STF-17: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getMaritalStatus(int rep) { 
		IS retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * STF-17: "Marital Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getStf17_MaritalStatus(int rep) { 
		IS retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Marital Status (STF-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getStf17_MaritalStatusReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * STF-17: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertMaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * STF-17: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertStf17_MaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * STF-17: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeMaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * STF-17: "Marital Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeStf17_MaritalStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * STF-18: "Job Title" - creates it if necessary
     */
    public ST getJobTitle() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-18: "Job Title" - creates it if necessary
     */
    public ST getStf18_JobTitle() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-19: "Job Code/Class" - creates it if necessary
     */
    public JCC getJobCodeClass() { 
		JCC retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-19: "Job Code/Class" - creates it if necessary
     */
    public JCC getStf19_JobCodeClass() { 
		JCC retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-20: "Employment Status" - creates it if necessary
     */
    public IS getEmploymentStatus() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-20: "Employment Status" - creates it if necessary
     */
    public IS getStf20_EmploymentStatus() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-21: "Additional Insured on Auto" - creates it if necessary
     */
    public ID getAdditionalInsuredOnAuto() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-21: "Additional Insured on Auto" - creates it if necessary
     */
    public ID getStf21_AdditionalInsuredOnAuto() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-22: "Driver's License Number" - creates it if necessary
     */
    public DLN getDriverSLicenseNumber() { 
		DLN retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-22: "Driver's License Number" - creates it if necessary
     */
    public DLN getStf22_DriverSLicenseNumber() { 
		DLN retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-23: "Copy Auto Ins" - creates it if necessary
     */
    public ID getCopyAutoIns() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-23: "Copy Auto Ins" - creates it if necessary
     */
    public ID getStf23_CopyAutoIns() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-24: "Auto Ins. Expires" - creates it if necessary
     */
    public DT getAutoInsExpires() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-24: "Auto Ins. Expires" - creates it if necessary
     */
    public DT getStf24_AutoInsExpires() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-25: "Date Last DMV Review" - creates it if necessary
     */
    public DT getDateLastDMVReview() { 
		DT retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-25: "Date Last DMV Review" - creates it if necessary
     */
    public DT getStf25_DateLastDMVReview() { 
		DT retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * STF-26: "Date Next DMV Review" - creates it if necessary
     */
    public DT getDateNextDMVReview() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * STF-26: "Date Next DMV Review" - creates it if necessary
     */
    public DT getStf26_DateNextDMVReview() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new XPN(getMessage());
          case 3: return new ID(getMessage(), new Integer( 182 ));
          case 4: return new IS(getMessage(), new Integer( 1 ));
          case 5: return new TS(getMessage());
          case 6: return new ID(getMessage(), new Integer( 183 ));
          case 7: return new CE(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new XTN(getMessage());
          case 10: return new AD(getMessage());
          case 11: return new CM_DIN(getMessage());
          case 12: return new CM_DIN(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new IS(getMessage(), new Integer( 2 ));
          case 17: return new ST(getMessage());
          case 18: return new JCC(getMessage());
          case 19: return new IS(getMessage(), new Integer( 66 ));
          case 20: return new ID(getMessage(), new Integer( 136 ));
          case 21: return new DLN(getMessage());
          case 22: return new ID(getMessage(), new Integer( 136 ));
          case 23: return new DT(getMessage());
          case 24: return new DT(getMessage());
          case 25: return new DT(getMessage());
          default: return null;
       }
   }


}

