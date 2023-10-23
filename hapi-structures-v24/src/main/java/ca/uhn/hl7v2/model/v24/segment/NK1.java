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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 NK1 message segment (Next of kin / associated parties). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NK1-1: Set ID - NK1 (SI) <b> </b>
     * <li>NK1-2: NK Name (XPN) <b>optional repeating</b>
     * <li>NK1-3: Relationship (CE) <b>optional </b>
     * <li>NK1-4: Address (XAD) <b>optional repeating</b>
     * <li>NK1-5: Phone Number (XTN) <b>optional repeating</b>
     * <li>NK1-6: Business Phone Number (XTN) <b>optional repeating</b>
     * <li>NK1-7: Contact Role (CE) <b>optional </b>
     * <li>NK1-8: Start Date (DT) <b>optional </b>
     * <li>NK1-9: End Date (DT) <b>optional </b>
     * <li>NK1-10: Next of Kin / Associated Parties Job Title (ST) <b>optional </b>
     * <li>NK1-11: Next of Kin / Associated Parties Job Code/Class (JCC) <b>optional </b>
     * <li>NK1-12: Next of Kin / Associated Parties Employee Number (CX) <b>optional </b>
     * <li>NK1-13: Organization Name - NK1 (XON) <b>optional repeating</b>
     * <li>NK1-14: Marital Status (CE) <b>optional </b>
     * <li>NK1-15: Administrative Sex (IS) <b>optional </b>
     * <li>NK1-16: Date/Time Of Birth (TS) <b>optional </b>
     * <li>NK1-17: Living Dependency (IS) <b>optional repeating</b>
     * <li>NK1-18: Ambulatory Status (IS) <b>optional repeating</b>
     * <li>NK1-19: Citizenship (CE) <b>optional repeating</b>
     * <li>NK1-20: Primary Language (CE) <b>optional </b>
     * <li>NK1-21: Living Arrangement (IS) <b>optional </b>
     * <li>NK1-22: Publicity Code (CE) <b>optional </b>
     * <li>NK1-23: Protection Indicator (ID) <b>optional </b>
     * <li>NK1-24: Student Indicator (IS) <b>optional </b>
     * <li>NK1-25: Religion (CE) <b>optional </b>
     * <li>NK1-26: Mother's Maiden Name (XPN) <b>optional repeating</b>
     * <li>NK1-27: Nationality (CE) <b>optional </b>
     * <li>NK1-28: Ethnic Group (CE) <b>optional repeating</b>
     * <li>NK1-29: Contact Reason (CE) <b>optional repeating</b>
     * <li>NK1-30: Contact Person's Name (XPN) <b>optional repeating</b>
     * <li>NK1-31: Contact Person's Telephone Number (XTN) <b>optional repeating</b>
     * <li>NK1-32: Contact Person's Address (XAD) <b>optional repeating</b>
     * <li>NK1-33: Next of Kin/Associated Party's Identifiers (CX) <b>optional repeating</b>
     * <li>NK1-34: Job Status (IS) <b>optional </b>
     * <li>NK1-35: Race (CE) <b>optional repeating</b>
     * <li>NK1-36: Handicap (IS) <b>optional </b>
     * <li>NK1-37: Contact Person Social Security Number (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NK1 extends AbstractSegment {

    /** 
     * Creates a new NK1 segment
     */
    public NK1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - NK1");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "NK Name");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Relationship");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Address");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Phone Number");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Business Phone Number");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Contact Role");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Start Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "End Date");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Next of Kin / Associated Parties Job Title");
                                  this.add(JCC.class, false, 1, 20, new Object[]{ getMessage() }, "Next of Kin / Associated Parties Job Code/Class");
                                  this.add(CX.class, false, 1, 250, new Object[]{ getMessage() }, "Next of Kin / Associated Parties Employee Number");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Organization Name - NK1");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Marital Status");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Administrative Sex");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date/Time Of Birth");
                                              this.add(IS.class, false, 0, 2, new Object[]{ getMessage(), new Integer(223) }, "Living Dependency");
                                              this.add(IS.class, false, 0, 2, new Object[]{ getMessage(), new Integer(9) }, "Ambulatory Status");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Citizenship");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Primary Language");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(220) }, "Living Arrangement");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Publicity Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Protection Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(231) }, "Student Indicator");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Religion");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Mother's Maiden Name");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Nationality");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Ethnic Group");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Reason");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Person's Name");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Person's Telephone Number");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Person's Address");
                                  this.add(CX.class, false, 0, 250, new Object[]{ getMessage() }, "Next of Kin/Associated Party's Identifiers");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(311) }, "Job Status");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Race");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(295) }, "Handicap");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "Contact Person Social Security Number");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NK1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NK1-1: "Set ID - NK1" - creates it if necessary
     */
    public SI getSetIDNK1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-1: "Set ID - NK1" - creates it if necessary
     */
    public SI getNk11_SetIDNK1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of NK Name (NK1-2).
     */
    public XPN[] getNKName() {
    	XPN[] retVal = this.getTypedField(2, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of NK Name (NK1-2).
     */
    public XPN[] getNk12_NKName() {
    	XPN[] retVal = this.getTypedField(2, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of NK Name (NK1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNKNameReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * NK1-2: "NK Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getNKName(int rep) { 
		XPN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-2: "NK Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getNk12_NKName(int rep) { 
		XPN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of NK Name (NK1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk12_NKNameReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * NK1-2: "NK Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertNKName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-2: "NK Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertNk12_NKName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * NK1-2: "NK Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeNKName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * NK1-2: "NK Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeNk12_NKName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * NK1-3: "Relationship" - creates it if necessary
     */
    public CE getRelationship() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-3: "Relationship" - creates it if necessary
     */
    public CE getNk13_Relationship() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Address (NK1-4).
     */
    public XAD[] getAddress() {
    	XAD[] retVal = this.getTypedField(4, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Address (NK1-4).
     */
    public XAD[] getNk14_Address() {
    	XAD[] retVal = this.getTypedField(4, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Address (NK1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAddressReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * NK1-4: "Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getAddress(int rep) { 
		XAD retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-4: "Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getNk14_Address(int rep) { 
		XAD retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Address (NK1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk14_AddressReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * NK1-4: "Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-4: "Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertNk14_Address(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * NK1-4: "Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * NK1-4: "Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeNk14_Address(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Phone Number (NK1-5).
     */
    public XTN[] getPhoneNumber() {
    	XTN[] retVal = this.getTypedField(5, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number (NK1-5).
     */
    public XTN[] getNk15_PhoneNumber() {
    	XTN[] retVal = this.getTypedField(5, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phone Number (NK1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhoneNumberReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * NK1-5: "Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-5: "Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getNk15_PhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phone Number (NK1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk15_PhoneNumberReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertNk15_PhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * NK1-5: "Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeNk15_PhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Business Phone Number (NK1-6).
     */
    public XTN[] getBusinessPhoneNumber() {
    	XTN[] retVal = this.getTypedField(6, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Business Phone Number (NK1-6).
     */
    public XTN[] getNk16_BusinessPhoneNumber() {
    	XTN[] retVal = this.getTypedField(6, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Business Phone Number (NK1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBusinessPhoneNumberReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * NK1-6: "Business Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getBusinessPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-6: "Business Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getNk16_BusinessPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Business Phone Number (NK1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk16_BusinessPhoneNumberReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * NK1-6: "Business Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertBusinessPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-6: "Business Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertNk16_BusinessPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * NK1-6: "Business Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeBusinessPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * NK1-6: "Business Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeNk16_BusinessPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * NK1-7: "Contact Role" - creates it if necessary
     */
    public CE getContactRole() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-7: "Contact Role" - creates it if necessary
     */
    public CE getNk17_ContactRole() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-8: "Start Date" - creates it if necessary
     */
    public DT getStartDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-8: "Start Date" - creates it if necessary
     */
    public DT getNk18_StartDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-9: "End Date" - creates it if necessary
     */
    public DT getEndDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-9: "End Date" - creates it if necessary
     */
    public DT getNk19_EndDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-10: "Next of Kin / Associated Parties Job Title" - creates it if necessary
     */
    public ST getNextOfKinAssociatedPartiesJobTitle() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-10: "Next of Kin / Associated Parties Job Title" - creates it if necessary
     */
    public ST getNk110_NextOfKinAssociatedPartiesJobTitle() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-11: "Next of Kin / Associated Parties Job Code/Class" - creates it if necessary
     */
    public JCC getNextOfKinAssociatedPartiesJobCodeClass() { 
		JCC retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-11: "Next of Kin / Associated Parties Job Code/Class" - creates it if necessary
     */
    public JCC getNk111_NextOfKinAssociatedPartiesJobCodeClass() { 
		JCC retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-12: "Next of Kin / Associated Parties Employee Number" - creates it if necessary
     */
    public CX getNextOfKinAssociatedPartiesEmployeeNumber() { 
		CX retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-12: "Next of Kin / Associated Parties Employee Number" - creates it if necessary
     */
    public CX getNk112_NextOfKinAssociatedPartiesEmployeeNumber() { 
		CX retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Organization Name - NK1 (NK1-13).
     */
    public XON[] getOrganizationNameNK1() {
    	XON[] retVal = this.getTypedField(13, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Organization Name - NK1 (NK1-13).
     */
    public XON[] getNk113_OrganizationNameNK1() {
    	XON[] retVal = this.getTypedField(13, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Organization Name - NK1 (NK1-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrganizationNameNK1Reps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * NK1-13: "Organization Name - NK1" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getOrganizationNameNK1(int rep) { 
		XON retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-13: "Organization Name - NK1" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getNk113_OrganizationNameNK1(int rep) { 
		XON retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Organization Name - NK1 (NK1-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk113_OrganizationNameNK1Reps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * NK1-13: "Organization Name - NK1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertOrganizationNameNK1(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-13: "Organization Name - NK1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertNk113_OrganizationNameNK1(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * NK1-13: "Organization Name - NK1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeOrganizationNameNK1(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * NK1-13: "Organization Name - NK1" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeNk113_OrganizationNameNK1(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * NK1-14: "Marital Status" - creates it if necessary
     */
    public CE getMaritalStatus() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-14: "Marital Status" - creates it if necessary
     */
    public CE getNk114_MaritalStatus() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-15: "Administrative Sex" - creates it if necessary
     */
    public IS getAdministrativeSex() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-15: "Administrative Sex" - creates it if necessary
     */
    public IS getNk115_AdministrativeSex() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-16: "Date/Time Of Birth" - creates it if necessary
     */
    public TS getDateTimeOfBirth() { 
		TS retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-16: "Date/Time Of Birth" - creates it if necessary
     */
    public TS getNk116_DateTimeOfBirth() { 
		TS retVal = this.getTypedField(16, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Living Dependency (NK1-17).
     */
    public IS[] getLivingDependency() {
    	IS[] retVal = this.getTypedField(17, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Living Dependency (NK1-17).
     */
    public IS[] getNk117_LivingDependency() {
    	IS[] retVal = this.getTypedField(17, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Living Dependency (NK1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLivingDependencyReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * NK1-17: "Living Dependency" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLivingDependency(int rep) { 
		IS retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-17: "Living Dependency" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getNk117_LivingDependency(int rep) { 
		IS retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Living Dependency (NK1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk117_LivingDependencyReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * NK1-17: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLivingDependency(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-17: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertNk117_LivingDependency(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * NK1-17: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLivingDependency(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * NK1-17: "Living Dependency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeNk117_LivingDependency(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(17, rep);
    }



    /**
     * Returns all repetitions of Ambulatory Status (NK1-18).
     */
    public IS[] getAmbulatoryStatus() {
    	IS[] retVal = this.getTypedField(18, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (NK1-18).
     */
    public IS[] getNk118_AmbulatoryStatus() {
    	IS[] retVal = this.getTypedField(18, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (NK1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAmbulatoryStatusReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * NK1-18: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getAmbulatoryStatus(int rep) { 
		IS retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-18: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getNk118_AmbulatoryStatus(int rep) { 
		IS retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (NK1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk118_AmbulatoryStatusReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * NK1-18: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertAmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-18: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertNk118_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * NK1-18: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeAmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * NK1-18: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeNk118_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(18, rep);
    }



    /**
     * Returns all repetitions of Citizenship (NK1-19).
     */
    public CE[] getCitizenship() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Citizenship (NK1-19).
     */
    public CE[] getNk119_Citizenship() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Citizenship (NK1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCitizenshipReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * NK1-19: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCitizenship(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-19: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getNk119_Citizenship(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Citizenship (NK1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk119_CitizenshipReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * NK1-19: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCitizenship(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-19: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertNk119_Citizenship(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * NK1-19: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCitizenship(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * NK1-19: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeNk119_Citizenship(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * NK1-20: "Primary Language" - creates it if necessary
     */
    public CE getPrimaryLanguage() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-20: "Primary Language" - creates it if necessary
     */
    public CE getNk120_PrimaryLanguage() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-21: "Living Arrangement" - creates it if necessary
     */
    public IS getLivingArrangement() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-21: "Living Arrangement" - creates it if necessary
     */
    public IS getNk121_LivingArrangement() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-22: "Publicity Code" - creates it if necessary
     */
    public CE getPublicityCode() { 
		CE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-22: "Publicity Code" - creates it if necessary
     */
    public CE getNk122_PublicityCode() { 
		CE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-23: "Protection Indicator" - creates it if necessary
     */
    public ID getProtectionIndicator() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-23: "Protection Indicator" - creates it if necessary
     */
    public ID getNk123_ProtectionIndicator() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-24: "Student Indicator" - creates it if necessary
     */
    public IS getStudentIndicator() { 
		IS retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-24: "Student Indicator" - creates it if necessary
     */
    public IS getNk124_StudentIndicator() { 
		IS retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-25: "Religion" - creates it if necessary
     */
    public CE getReligion() { 
		CE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-25: "Religion" - creates it if necessary
     */
    public CE getNk125_Religion() { 
		CE retVal = this.getTypedField(25, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (NK1-26).
     */
    public XPN[] getMotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(26, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (NK1-26).
     */
    public XPN[] getNk126_MotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(26, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (NK1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMotherSMaidenNameReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * NK1-26: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-26: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getNk126_MotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (NK1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk126_MotherSMaidenNameReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * NK1-26: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-26: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertNk126_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * NK1-26: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * NK1-26: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeNk126_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(26, rep);
    }




    /**
     * Returns
     * NK1-27: "Nationality" - creates it if necessary
     */
    public CE getNationality() { 
		CE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-27: "Nationality" - creates it if necessary
     */
    public CE getNk127_Nationality() { 
		CE retVal = this.getTypedField(27, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (NK1-28).
     */
    public CE[] getEthnicGroup() {
    	CE[] retVal = this.getTypedField(28, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (NK1-28).
     */
    public CE[] getNk128_EthnicGroup() {
    	CE[] retVal = this.getTypedField(28, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ethnic Group (NK1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEthnicGroupReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * NK1-28: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getEthnicGroup(int rep) { 
		CE retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-28: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getNk128_EthnicGroup(int rep) { 
		CE retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ethnic Group (NK1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk128_EthnicGroupReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * NK1-28: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertEthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-28: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertNk128_EthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * NK1-28: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeEthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * NK1-28: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeNk128_EthnicGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(28, rep);
    }



    /**
     * Returns all repetitions of Contact Reason (NK1-29).
     */
    public CE[] getContactReason() {
    	CE[] retVal = this.getTypedField(29, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Reason (NK1-29).
     */
    public CE[] getNk129_ContactReason() {
    	CE[] retVal = this.getTypedField(29, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Reason (NK1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactReasonReps() {
    	return this.getReps(29);
    }


    /**
     * Returns a specific repetition of
     * NK1-29: "Contact Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getContactReason(int rep) { 
		CE retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-29: "Contact Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getNk129_ContactReason(int rep) { 
		CE retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Reason (NK1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk129_ContactReasonReps() {
    	return this.getReps(29);
    }


    /**
     * Inserts a repetition of
     * NK1-29: "Contact Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertContactReason(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-29: "Contact Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertNk129_ContactReason(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * NK1-29: "Contact Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeContactReason(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * NK1-29: "Contact Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeNk129_ContactReason(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(29, rep);
    }



    /**
     * Returns all repetitions of Contact Person's Name (NK1-30).
     */
    public XPN[] getContactPersonSName() {
    	XPN[] retVal = this.getTypedField(30, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Person's Name (NK1-30).
     */
    public XPN[] getNk130_ContactPersonSName() {
    	XPN[] retVal = this.getTypedField(30, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Person's Name (NK1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactPersonSNameReps() {
    	return this.getReps(30);
    }


    /**
     * Returns a specific repetition of
     * NK1-30: "Contact Person's Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-30: "Contact Person's Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getNk130_ContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Person's Name (NK1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk130_ContactPersonSNameReps() {
    	return this.getReps(30);
    }


    /**
     * Inserts a repetition of
     * NK1-30: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(30, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-30: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertNk130_ContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * NK1-30: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * NK1-30: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeNk130_ContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(30, rep);
    }



    /**
     * Returns all repetitions of Contact Person's Telephone Number (NK1-31).
     */
    public XTN[] getContactPersonSTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(31, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Person's Telephone Number (NK1-31).
     */
    public XTN[] getNk131_ContactPersonSTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(31, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Person's Telephone Number (NK1-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactPersonSTelephoneNumberReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * NK1-31: "Contact Person's Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getContactPersonSTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-31: "Contact Person's Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getNk131_ContactPersonSTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Person's Telephone Number (NK1-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk131_ContactPersonSTelephoneNumberReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * NK1-31: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-31: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertNk131_ContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * NK1-31: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * NK1-31: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeNk131_ContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(31, rep);
    }



    /**
     * Returns all repetitions of Contact Person's Address (NK1-32).
     */
    public XAD[] getContactPersonSAddress() {
    	XAD[] retVal = this.getTypedField(32, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Person's Address (NK1-32).
     */
    public XAD[] getNk132_ContactPersonSAddress() {
    	XAD[] retVal = this.getTypedField(32, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Person's Address (NK1-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactPersonSAddressReps() {
    	return this.getReps(32);
    }


    /**
     * Returns a specific repetition of
     * NK1-32: "Contact Person's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getContactPersonSAddress(int rep) { 
		XAD retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-32: "Contact Person's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getNk132_ContactPersonSAddress(int rep) { 
		XAD retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Person's Address (NK1-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk132_ContactPersonSAddressReps() {
    	return this.getReps(32);
    }


    /**
     * Inserts a repetition of
     * NK1-32: "Contact Person's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertContactPersonSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(32, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-32: "Contact Person's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertNk132_ContactPersonSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * NK1-32: "Contact Person's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeContactPersonSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * NK1-32: "Contact Person's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeNk132_ContactPersonSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(32, rep);
    }



    /**
     * Returns all repetitions of Next of Kin/Associated Party's Identifiers (NK1-33).
     */
    public CX[] getNextOfKinAssociatedPartySIdentifiers() {
    	CX[] retVal = this.getTypedField(33, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Next of Kin/Associated Party's Identifiers (NK1-33).
     */
    public CX[] getNk133_NextOfKinAssociatedPartySIdentifiers() {
    	CX[] retVal = this.getTypedField(33, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Next of Kin/Associated Party's Identifiers (NK1-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNextOfKinAssociatedPartySIdentifiersReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * NK1-33: "Next of Kin/Associated Party's Identifiers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getNextOfKinAssociatedPartySIdentifiers(int rep) { 
		CX retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-33: "Next of Kin/Associated Party's Identifiers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getNk133_NextOfKinAssociatedPartySIdentifiers(int rep) { 
		CX retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Next of Kin/Associated Party's Identifiers (NK1-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk133_NextOfKinAssociatedPartySIdentifiersReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * NK1-33: "Next of Kin/Associated Party's Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertNextOfKinAssociatedPartySIdentifiers(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-33: "Next of Kin/Associated Party's Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertNk133_NextOfKinAssociatedPartySIdentifiers(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * NK1-33: "Next of Kin/Associated Party's Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeNextOfKinAssociatedPartySIdentifiers(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * NK1-33: "Next of Kin/Associated Party's Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeNk133_NextOfKinAssociatedPartySIdentifiers(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(33, rep);
    }




    /**
     * Returns
     * NK1-34: "Job Status" - creates it if necessary
     */
    public IS getJobStatus() { 
		IS retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-34: "Job Status" - creates it if necessary
     */
    public IS getNk134_JobStatus() { 
		IS retVal = this.getTypedField(34, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Race (NK1-35).
     */
    public CE[] getRace() {
    	CE[] retVal = this.getTypedField(35, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Race (NK1-35).
     */
    public CE[] getNk135_Race() {
    	CE[] retVal = this.getTypedField(35, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Race (NK1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRaceReps() {
    	return this.getReps(35);
    }


    /**
     * Returns a specific repetition of
     * NK1-35: "Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRace(int rep) { 
		CE retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * NK1-35: "Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getNk135_Race(int rep) { 
		CE retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Race (NK1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNk135_RaceReps() {
    	return this.getReps(35);
    }


    /**
     * Inserts a repetition of
     * NK1-35: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRace(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(35, rep);
    }


    /**
     * Inserts a repetition of
     * NK1-35: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertNk135_Race(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * NK1-35: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRace(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * NK1-35: "Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeNk135_Race(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(35, rep);
    }




    /**
     * Returns
     * NK1-36: "Handicap" - creates it if necessary
     */
    public IS getHandicap() { 
		IS retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-36: "Handicap" - creates it if necessary
     */
    public IS getNk136_Handicap() { 
		IS retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * NK1-37: "Contact Person Social Security Number" - creates it if necessary
     */
    public ST getContactPersonSocialSecurityNumber() { 
		ST retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NK1-37: "Contact Person Social Security Number" - creates it if necessary
     */
    public ST getNk137_ContactPersonSocialSecurityNumber() { 
		ST retVal = this.getTypedField(37, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new XPN(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new XAD(getMessage());
          case 4: return new XTN(getMessage());
          case 5: return new XTN(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new DT(getMessage());
          case 8: return new DT(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new JCC(getMessage());
          case 11: return new CX(getMessage());
          case 12: return new XON(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new IS(getMessage(), new Integer( 1 ));
          case 15: return new TS(getMessage());
          case 16: return new IS(getMessage(), new Integer( 223 ));
          case 17: return new IS(getMessage(), new Integer( 9 ));
          case 18: return new CE(getMessage());
          case 19: return new CE(getMessage());
          case 20: return new IS(getMessage(), new Integer( 220 ));
          case 21: return new CE(getMessage());
          case 22: return new ID(getMessage(), new Integer( 136 ));
          case 23: return new IS(getMessage(), new Integer( 231 ));
          case 24: return new CE(getMessage());
          case 25: return new XPN(getMessage());
          case 26: return new CE(getMessage());
          case 27: return new CE(getMessage());
          case 28: return new CE(getMessage());
          case 29: return new XPN(getMessage());
          case 30: return new XTN(getMessage());
          case 31: return new XAD(getMessage());
          case 32: return new CX(getMessage());
          case 33: return new IS(getMessage(), new Integer( 311 ));
          case 34: return new CE(getMessage());
          case 35: return new IS(getMessage(), new Integer( 295 ));
          case 36: return new ST(getMessage());
          default: return null;
       }
   }


}

