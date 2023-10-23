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
 *<p>Represents an HL7 GT1 message segment (Guarantor). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>GT1-1: Set ID - GT1 (SI) <b> </b>
     * <li>GT1-2: Guarantor Number (CX) <b>optional repeating</b>
     * <li>GT1-3: Guarantor Name (XPN) <b> repeating</b>
     * <li>GT1-4: Guarantor Spouse Name (XPN) <b>optional repeating</b>
     * <li>GT1-5: Guarantor Address (XAD) <b>optional repeating</b>
     * <li>GT1-6: Guarantor Ph Num - Home (XTN) <b>optional repeating</b>
     * <li>GT1-7: Guarantor Ph Num - Business (XTN) <b>optional repeating</b>
     * <li>GT1-8: Guarantor Date/Time Of Birth (DTM) <b>optional </b>
     * <li>GT1-9: Guarantor Administrative Sex (CWE) <b>optional </b>
     * <li>GT1-10: Guarantor Type (CWE) <b>optional </b>
     * <li>GT1-11: Guarantor Relationship (CWE) <b>optional </b>
     * <li>GT1-12: Guarantor SSN (ST) <b>optional </b>
     * <li>GT1-13: Guarantor Date - Begin (DT) <b>optional </b>
     * <li>GT1-14: Guarantor Date - End (DT) <b>optional </b>
     * <li>GT1-15: Guarantor Priority (NM) <b>optional </b>
     * <li>GT1-16: Guarantor Employer Name (XPN) <b>optional repeating</b>
     * <li>GT1-17: Guarantor Employer Address (XAD) <b>optional repeating</b>
     * <li>GT1-18: Guarantor Employer Phone Number (XTN) <b>optional repeating</b>
     * <li>GT1-19: Guarantor Employee ID Number (CX) <b>optional repeating</b>
     * <li>GT1-20: Guarantor Employment Status (CWE) <b>optional </b>
     * <li>GT1-21: Guarantor Organization Name (XON) <b>optional repeating</b>
     * <li>GT1-22: Guarantor Billing Hold Flag (ID) <b>optional </b>
     * <li>GT1-23: Guarantor Credit Rating Code (CWE) <b>optional </b>
     * <li>GT1-24: Guarantor Death Date And Time (DTM) <b>optional </b>
     * <li>GT1-25: Guarantor Death Flag (ID) <b>optional </b>
     * <li>GT1-26: Guarantor Charge Adjustment Code (CWE) <b>optional </b>
     * <li>GT1-27: Guarantor Household Annual Income (CP) <b>optional </b>
     * <li>GT1-28: Guarantor Household Size (NM) <b>optional </b>
     * <li>GT1-29: Guarantor Employer ID Number (CX) <b>optional repeating</b>
     * <li>GT1-30: Guarantor Marital Status Code (CWE) <b>optional </b>
     * <li>GT1-31: Guarantor Hire Effective Date (DT) <b>optional </b>
     * <li>GT1-32: Employment Stop Date (DT) <b>optional </b>
     * <li>GT1-33: Living Dependency (CWE) <b>optional </b>
     * <li>GT1-34: Ambulatory Status (CWE) <b>optional repeating</b>
     * <li>GT1-35: Citizenship (CWE) <b>optional repeating</b>
     * <li>GT1-36: Primary Language (CWE) <b>optional </b>
     * <li>GT1-37: Living Arrangement (CWE) <b>optional </b>
     * <li>GT1-38: Publicity Code (CWE) <b>optional </b>
     * <li>GT1-39: Protection Indicator (ID) <b>optional </b>
     * <li>GT1-40: Student Indicator (CWE) <b>optional </b>
     * <li>GT1-41: Religion (CWE) <b>optional </b>
     * <li>GT1-42: Mother's Maiden Name (XPN) <b>optional repeating</b>
     * <li>GT1-43: Nationality (CWE) <b>optional </b>
     * <li>GT1-44: Ethnic Group (CWE) <b>optional repeating</b>
     * <li>GT1-45: Contact Person's Name (XPN) <b>optional repeating</b>
     * <li>GT1-46: Contact Person's Telephone Number (XTN) <b>optional repeating</b>
     * <li>GT1-47: Contact Reason (CWE) <b>optional </b>
     * <li>GT1-48: Contact Relationship (CWE) <b>optional </b>
     * <li>GT1-49: Job Title (ST) <b>optional </b>
     * <li>GT1-50: Job Code/Class (JCC) <b>optional </b>
     * <li>GT1-51: Guarantor Employer's Organization Name (XON) <b>optional repeating</b>
     * <li>GT1-52: Handicap (CWE) <b>optional </b>
     * <li>GT1-53: Job Status (CWE) <b>optional </b>
     * <li>GT1-54: Guarantor Financial Class (FC) <b>optional </b>
     * <li>GT1-55: Guarantor Race (CWE) <b>optional repeating</b>
     * <li>GT1-56: Guarantor Birth Place (ST) <b>optional </b>
     * <li>GT1-57: VIP Indicator (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class GT1 extends AbstractSegment {

    /** 
     * Creates a new GT1 segment
     */
    public GT1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - GT1");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Number");
                                  this.add(XPN.class, true, 0, 0, new Object[]{ getMessage() }, "Guarantor Name");
                                  this.add(XPN.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Spouse Name");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Address");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Ph Num - Home");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Ph Num - Business");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Date/Time Of Birth");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Administrative Sex");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Relationship");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor SSN");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Date - Begin");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Date - End");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Guarantor Priority");
                                  this.add(XPN.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Employer Name");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Employer Address");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Employer Phone Number");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Employee ID Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Employment Status");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Organization Name");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Guarantor Billing Hold Flag");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Credit Rating Code");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Death Date And Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Guarantor Death Flag");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Charge Adjustment Code");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Household Annual Income");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Household Size");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Employer ID Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Marital Status Code");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Hire Effective Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Employment Stop Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Living Dependency");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Ambulatory Status");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Citizenship");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Primary Language");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Living Arrangement");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Publicity Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Protection Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Student Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Religion");
                                  this.add(XPN.class, false, 0, 0, new Object[]{ getMessage() }, "Mother's Maiden Name");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Nationality");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Ethnic Group");
                                  this.add(XPN.class, false, 0, 0, new Object[]{ getMessage() }, "Contact Person's Name");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Contact Person's Telephone Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Contact Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Contact Relationship");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Job Title");
                                  this.add(JCC.class, false, 1, 0, new Object[]{ getMessage() }, "Job Code/Class");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Employer's Organization Name");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Handicap");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Job Status");
                                  this.add(FC.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Financial Class");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Guarantor Race");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Guarantor Birth Place");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "VIP Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating GT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * GT1-1: "Set ID - GT1" - creates it if necessary
     */
    public SI getSetIDGT1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-1: "Set ID - GT1" - creates it if necessary
     */
    public SI getGt11_SetIDGT1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Number (GT1-2).
     */
    public CX[] getGuarantorNumber() {
    	CX[] retVal = this.getTypedField(2, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Number (GT1-2).
     */
    public CX[] getGt12_GuarantorNumber() {
    	CX[] retVal = this.getTypedField(2, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Number (GT1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorNumberReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * GT1-2: "Guarantor Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getGuarantorNumber(int rep) { 
		CX retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-2: "Guarantor Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getGt12_GuarantorNumber(int rep) { 
		CX retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Number (GT1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt12_GuarantorNumberReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * GT1-2: "Guarantor Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertGuarantorNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-2: "Guarantor Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertGt12_GuarantorNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * GT1-2: "Guarantor Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeGuarantorNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * GT1-2: "Guarantor Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeGt12_GuarantorNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Guarantor Name (GT1-3).
     */
    public XPN[] getGuarantorName() {
    	XPN[] retVal = this.getTypedField(3, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Name (GT1-3).
     */
    public XPN[] getGt13_GuarantorName() {
    	XPN[] retVal = this.getTypedField(3, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Name (GT1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorNameReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * GT1-3: "Guarantor Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGuarantorName(int rep) { 
		XPN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-3: "Guarantor Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGt13_GuarantorName(int rep) { 
		XPN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Name (GT1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt13_GuarantorNameReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * GT1-3: "Guarantor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGuarantorName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-3: "Guarantor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGt13_GuarantorName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * GT1-3: "Guarantor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGuarantorName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * GT1-3: "Guarantor Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGt13_GuarantorName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Guarantor Spouse Name (GT1-4).
     */
    public XPN[] getGuarantorSpouseName() {
    	XPN[] retVal = this.getTypedField(4, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Spouse Name (GT1-4).
     */
    public XPN[] getGt14_GuarantorSpouseName() {
    	XPN[] retVal = this.getTypedField(4, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Spouse Name (GT1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorSpouseNameReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * GT1-4: "Guarantor Spouse Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGuarantorSpouseName(int rep) { 
		XPN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-4: "Guarantor Spouse Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGt14_GuarantorSpouseName(int rep) { 
		XPN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Spouse Name (GT1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt14_GuarantorSpouseNameReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * GT1-4: "Guarantor Spouse Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGuarantorSpouseName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-4: "Guarantor Spouse Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGt14_GuarantorSpouseName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * GT1-4: "Guarantor Spouse Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGuarantorSpouseName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * GT1-4: "Guarantor Spouse Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGt14_GuarantorSpouseName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Guarantor Address (GT1-5).
     */
    public XAD[] getGuarantorAddress() {
    	XAD[] retVal = this.getTypedField(5, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Address (GT1-5).
     */
    public XAD[] getGt15_GuarantorAddress() {
    	XAD[] retVal = this.getTypedField(5, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Address (GT1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorAddressReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * GT1-5: "Guarantor Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getGuarantorAddress(int rep) { 
		XAD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-5: "Guarantor Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getGt15_GuarantorAddress(int rep) { 
		XAD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Address (GT1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt15_GuarantorAddressReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * GT1-5: "Guarantor Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertGuarantorAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-5: "Guarantor Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertGt15_GuarantorAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * GT1-5: "Guarantor Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeGuarantorAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * GT1-5: "Guarantor Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeGt15_GuarantorAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Guarantor Ph Num - Home (GT1-6).
     */
    public XTN[] getGuarantorPhNumHome() {
    	XTN[] retVal = this.getTypedField(6, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Ph Num - Home (GT1-6).
     */
    public XTN[] getGt16_GuarantorPhNumHome() {
    	XTN[] retVal = this.getTypedField(6, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Ph Num - Home (GT1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorPhNumHomeReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * GT1-6: "Guarantor Ph Num - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGuarantorPhNumHome(int rep) { 
		XTN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-6: "Guarantor Ph Num - Home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGt16_GuarantorPhNumHome(int rep) { 
		XTN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Ph Num - Home (GT1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt16_GuarantorPhNumHomeReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * GT1-6: "Guarantor Ph Num - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGuarantorPhNumHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-6: "Guarantor Ph Num - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGt16_GuarantorPhNumHome(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * GT1-6: "Guarantor Ph Num - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGuarantorPhNumHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * GT1-6: "Guarantor Ph Num - Home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGt16_GuarantorPhNumHome(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Guarantor Ph Num - Business (GT1-7).
     */
    public XTN[] getGuarantorPhNumBusiness() {
    	XTN[] retVal = this.getTypedField(7, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Ph Num - Business (GT1-7).
     */
    public XTN[] getGt17_GuarantorPhNumBusiness() {
    	XTN[] retVal = this.getTypedField(7, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Ph Num - Business (GT1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorPhNumBusinessReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * GT1-7: "Guarantor Ph Num - Business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGuarantorPhNumBusiness(int rep) { 
		XTN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-7: "Guarantor Ph Num - Business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGt17_GuarantorPhNumBusiness(int rep) { 
		XTN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Ph Num - Business (GT1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt17_GuarantorPhNumBusinessReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * GT1-7: "Guarantor Ph Num - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGuarantorPhNumBusiness(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-7: "Guarantor Ph Num - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGt17_GuarantorPhNumBusiness(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * GT1-7: "Guarantor Ph Num - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGuarantorPhNumBusiness(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * GT1-7: "Guarantor Ph Num - Business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGt17_GuarantorPhNumBusiness(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * GT1-8: "Guarantor Date/Time Of Birth" - creates it if necessary
     */
    public DTM getGuarantorDateTimeOfBirth() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-8: "Guarantor Date/Time Of Birth" - creates it if necessary
     */
    public DTM getGt18_GuarantorDateTimeOfBirth() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-9: "Guarantor Administrative Sex" - creates it if necessary
     */
    public CWE getGuarantorAdministrativeSex() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-9: "Guarantor Administrative Sex" - creates it if necessary
     */
    public CWE getGt19_GuarantorAdministrativeSex() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-10: "Guarantor Type" - creates it if necessary
     */
    public CWE getGuarantorType() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-10: "Guarantor Type" - creates it if necessary
     */
    public CWE getGt110_GuarantorType() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-11: "Guarantor Relationship" - creates it if necessary
     */
    public CWE getGuarantorRelationship() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-11: "Guarantor Relationship" - creates it if necessary
     */
    public CWE getGt111_GuarantorRelationship() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-12: "Guarantor SSN" - creates it if necessary
     */
    public ST getGuarantorSSN() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-12: "Guarantor SSN" - creates it if necessary
     */
    public ST getGt112_GuarantorSSN() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-13: "Guarantor Date - Begin" - creates it if necessary
     */
    public DT getGuarantorDateBegin() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-13: "Guarantor Date - Begin" - creates it if necessary
     */
    public DT getGt113_GuarantorDateBegin() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-14: "Guarantor Date - End" - creates it if necessary
     */
    public DT getGuarantorDateEnd() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-14: "Guarantor Date - End" - creates it if necessary
     */
    public DT getGt114_GuarantorDateEnd() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-15: "Guarantor Priority" - creates it if necessary
     */
    public NM getGuarantorPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-15: "Guarantor Priority" - creates it if necessary
     */
    public NM getGt115_GuarantorPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer Name (GT1-16).
     */
    public XPN[] getGuarantorEmployerName() {
    	XPN[] retVal = this.getTypedField(16, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer Name (GT1-16).
     */
    public XPN[] getGt116_GuarantorEmployerName() {
    	XPN[] retVal = this.getTypedField(16, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Employer Name (GT1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployerNameReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * GT1-16: "Guarantor Employer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGuarantorEmployerName(int rep) { 
		XPN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-16: "Guarantor Employer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGt116_GuarantorEmployerName(int rep) { 
		XPN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Employer Name (GT1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt116_GuarantorEmployerNameReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * GT1-16: "Guarantor Employer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGuarantorEmployerName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-16: "Guarantor Employer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGt116_GuarantorEmployerName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * GT1-16: "Guarantor Employer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGuarantorEmployerName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * GT1-16: "Guarantor Employer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGt116_GuarantorEmployerName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(16, rep);
    }



    /**
     * Returns all repetitions of Guarantor Employer Address (GT1-17).
     */
    public XAD[] getGuarantorEmployerAddress() {
    	XAD[] retVal = this.getTypedField(17, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer Address (GT1-17).
     */
    public XAD[] getGt117_GuarantorEmployerAddress() {
    	XAD[] retVal = this.getTypedField(17, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Employer Address (GT1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployerAddressReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * GT1-17: "Guarantor Employer Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getGuarantorEmployerAddress(int rep) { 
		XAD retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-17: "Guarantor Employer Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getGt117_GuarantorEmployerAddress(int rep) { 
		XAD retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Employer Address (GT1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt117_GuarantorEmployerAddressReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * GT1-17: "Guarantor Employer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertGuarantorEmployerAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-17: "Guarantor Employer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertGt117_GuarantorEmployerAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * GT1-17: "Guarantor Employer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeGuarantorEmployerAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * GT1-17: "Guarantor Employer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeGt117_GuarantorEmployerAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(17, rep);
    }



    /**
     * Returns all repetitions of Guarantor Employer Phone Number (GT1-18).
     */
    public XTN[] getGuarantorEmployerPhoneNumber() {
    	XTN[] retVal = this.getTypedField(18, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer Phone Number (GT1-18).
     */
    public XTN[] getGt118_GuarantorEmployerPhoneNumber() {
    	XTN[] retVal = this.getTypedField(18, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Employer Phone Number (GT1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployerPhoneNumberReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * GT1-18: "Guarantor Employer Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGuarantorEmployerPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-18: "Guarantor Employer Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGt118_GuarantorEmployerPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Employer Phone Number (GT1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt118_GuarantorEmployerPhoneNumberReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * GT1-18: "Guarantor Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGuarantorEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-18: "Guarantor Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGt118_GuarantorEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * GT1-18: "Guarantor Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGuarantorEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * GT1-18: "Guarantor Employer Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGt118_GuarantorEmployerPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(18, rep);
    }



    /**
     * Returns all repetitions of Guarantor Employee ID Number (GT1-19).
     */
    public CX[] getGuarantorEmployeeIDNumber() {
    	CX[] retVal = this.getTypedField(19, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employee ID Number (GT1-19).
     */
    public CX[] getGt119_GuarantorEmployeeIDNumber() {
    	CX[] retVal = this.getTypedField(19, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Employee ID Number (GT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployeeIDNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * GT1-19: "Guarantor Employee ID Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getGuarantorEmployeeIDNumber(int rep) { 
		CX retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-19: "Guarantor Employee ID Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getGt119_GuarantorEmployeeIDNumber(int rep) { 
		CX retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Employee ID Number (GT1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt119_GuarantorEmployeeIDNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * GT1-19: "Guarantor Employee ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertGuarantorEmployeeIDNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-19: "Guarantor Employee ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertGt119_GuarantorEmployeeIDNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * GT1-19: "Guarantor Employee ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeGuarantorEmployeeIDNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * GT1-19: "Guarantor Employee ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeGt119_GuarantorEmployeeIDNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * GT1-20: "Guarantor Employment Status" - creates it if necessary
     */
    public CWE getGuarantorEmploymentStatus() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-20: "Guarantor Employment Status" - creates it if necessary
     */
    public CWE getGt120_GuarantorEmploymentStatus() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Organization Name (GT1-21).
     */
    public XON[] getGuarantorOrganizationName() {
    	XON[] retVal = this.getTypedField(21, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Organization Name (GT1-21).
     */
    public XON[] getGt121_GuarantorOrganizationName() {
    	XON[] retVal = this.getTypedField(21, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Organization Name (GT1-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorOrganizationNameReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * GT1-21: "Guarantor Organization Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getGuarantorOrganizationName(int rep) { 
		XON retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-21: "Guarantor Organization Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getGt121_GuarantorOrganizationName(int rep) { 
		XON retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Organization Name (GT1-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt121_GuarantorOrganizationNameReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * GT1-21: "Guarantor Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertGuarantorOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-21: "Guarantor Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertGt121_GuarantorOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * GT1-21: "Guarantor Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeGuarantorOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * GT1-21: "Guarantor Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeGt121_GuarantorOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * GT1-22: "Guarantor Billing Hold Flag" - creates it if necessary
     */
    public ID getGuarantorBillingHoldFlag() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-22: "Guarantor Billing Hold Flag" - creates it if necessary
     */
    public ID getGt122_GuarantorBillingHoldFlag() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-23: "Guarantor Credit Rating Code" - creates it if necessary
     */
    public CWE getGuarantorCreditRatingCode() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-23: "Guarantor Credit Rating Code" - creates it if necessary
     */
    public CWE getGt123_GuarantorCreditRatingCode() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-24: "Guarantor Death Date And Time" - creates it if necessary
     */
    public DTM getGuarantorDeathDateAndTime() { 
		DTM retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-24: "Guarantor Death Date And Time" - creates it if necessary
     */
    public DTM getGt124_GuarantorDeathDateAndTime() { 
		DTM retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-25: "Guarantor Death Flag" - creates it if necessary
     */
    public ID getGuarantorDeathFlag() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-25: "Guarantor Death Flag" - creates it if necessary
     */
    public ID getGt125_GuarantorDeathFlag() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-26: "Guarantor Charge Adjustment Code" - creates it if necessary
     */
    public CWE getGuarantorChargeAdjustmentCode() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-26: "Guarantor Charge Adjustment Code" - creates it if necessary
     */
    public CWE getGt126_GuarantorChargeAdjustmentCode() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-27: "Guarantor Household Annual Income" - creates it if necessary
     */
    public CP getGuarantorHouseholdAnnualIncome() { 
		CP retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-27: "Guarantor Household Annual Income" - creates it if necessary
     */
    public CP getGt127_GuarantorHouseholdAnnualIncome() { 
		CP retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-28: "Guarantor Household Size" - creates it if necessary
     */
    public NM getGuarantorHouseholdSize() { 
		NM retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-28: "Guarantor Household Size" - creates it if necessary
     */
    public NM getGt128_GuarantorHouseholdSize() { 
		NM retVal = this.getTypedField(28, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer ID Number (GT1-29).
     */
    public CX[] getGuarantorEmployerIDNumber() {
    	CX[] retVal = this.getTypedField(29, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer ID Number (GT1-29).
     */
    public CX[] getGt129_GuarantorEmployerIDNumber() {
    	CX[] retVal = this.getTypedField(29, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Employer ID Number (GT1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployerIDNumberReps() {
    	return this.getReps(29);
    }


    /**
     * Returns a specific repetition of
     * GT1-29: "Guarantor Employer ID Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getGuarantorEmployerIDNumber(int rep) { 
		CX retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-29: "Guarantor Employer ID Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getGt129_GuarantorEmployerIDNumber(int rep) { 
		CX retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Employer ID Number (GT1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt129_GuarantorEmployerIDNumberReps() {
    	return this.getReps(29);
    }


    /**
     * Inserts a repetition of
     * GT1-29: "Guarantor Employer ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertGuarantorEmployerIDNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-29: "Guarantor Employer ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertGt129_GuarantorEmployerIDNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * GT1-29: "Guarantor Employer ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeGuarantorEmployerIDNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * GT1-29: "Guarantor Employer ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeGt129_GuarantorEmployerIDNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(29, rep);
    }




    /**
     * Returns
     * GT1-30: "Guarantor Marital Status Code" - creates it if necessary
     */
    public CWE getGuarantorMaritalStatusCode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-30: "Guarantor Marital Status Code" - creates it if necessary
     */
    public CWE getGt130_GuarantorMaritalStatusCode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-31: "Guarantor Hire Effective Date" - creates it if necessary
     */
    public DT getGuarantorHireEffectiveDate() { 
		DT retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-31: "Guarantor Hire Effective Date" - creates it if necessary
     */
    public DT getGt131_GuarantorHireEffectiveDate() { 
		DT retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-32: "Employment Stop Date" - creates it if necessary
     */
    public DT getEmploymentStopDate() { 
		DT retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-32: "Employment Stop Date" - creates it if necessary
     */
    public DT getGt132_EmploymentStopDate() { 
		DT retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-33: "Living Dependency" - creates it if necessary
     */
    public CWE getLivingDependency() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-33: "Living Dependency" - creates it if necessary
     */
    public CWE getGt133_LivingDependency() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (GT1-34).
     */
    public CWE[] getAmbulatoryStatus() {
    	CWE[] retVal = this.getTypedField(34, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ambulatory Status (GT1-34).
     */
    public CWE[] getGt134_AmbulatoryStatus() {
    	CWE[] retVal = this.getTypedField(34, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (GT1-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAmbulatoryStatusReps() {
    	return this.getReps(34);
    }


    /**
     * Returns a specific repetition of
     * GT1-34: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAmbulatoryStatus(int rep) { 
		CWE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-34: "Ambulatory Status" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGt134_AmbulatoryStatus(int rep) { 
		CWE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ambulatory Status (GT1-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt134_AmbulatoryStatusReps() {
    	return this.getReps(34);
    }


    /**
     * Inserts a repetition of
     * GT1-34: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(34, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-34: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGt134_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * GT1-34: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * GT1-34: "Ambulatory Status" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGt134_AmbulatoryStatus(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(34, rep);
    }



    /**
     * Returns all repetitions of Citizenship (GT1-35).
     */
    public CWE[] getCitizenship() {
    	CWE[] retVal = this.getTypedField(35, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Citizenship (GT1-35).
     */
    public CWE[] getGt135_Citizenship() {
    	CWE[] retVal = this.getTypedField(35, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Citizenship (GT1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCitizenshipReps() {
    	return this.getReps(35);
    }


    /**
     * Returns a specific repetition of
     * GT1-35: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCitizenship(int rep) { 
		CWE retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-35: "Citizenship" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGt135_Citizenship(int rep) { 
		CWE retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Citizenship (GT1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt135_CitizenshipReps() {
    	return this.getReps(35);
    }


    /**
     * Inserts a repetition of
     * GT1-35: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(35, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-35: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGt135_Citizenship(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * GT1-35: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCitizenship(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * GT1-35: "Citizenship" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGt135_Citizenship(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(35, rep);
    }




    /**
     * Returns
     * GT1-36: "Primary Language" - creates it if necessary
     */
    public CWE getPrimaryLanguage() { 
		CWE retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-36: "Primary Language" - creates it if necessary
     */
    public CWE getGt136_PrimaryLanguage() { 
		CWE retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-37: "Living Arrangement" - creates it if necessary
     */
    public CWE getLivingArrangement() { 
		CWE retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-37: "Living Arrangement" - creates it if necessary
     */
    public CWE getGt137_LivingArrangement() { 
		CWE retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-38: "Publicity Code" - creates it if necessary
     */
    public CWE getPublicityCode() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-38: "Publicity Code" - creates it if necessary
     */
    public CWE getGt138_PublicityCode() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-39: "Protection Indicator" - creates it if necessary
     */
    public ID getProtectionIndicator() { 
		ID retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-39: "Protection Indicator" - creates it if necessary
     */
    public ID getGt139_ProtectionIndicator() { 
		ID retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-40: "Student Indicator" - creates it if necessary
     */
    public CWE getStudentIndicator() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-40: "Student Indicator" - creates it if necessary
     */
    public CWE getGt140_StudentIndicator() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-41: "Religion" - creates it if necessary
     */
    public CWE getReligion() { 
		CWE retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-41: "Religion" - creates it if necessary
     */
    public CWE getGt141_Religion() { 
		CWE retVal = this.getTypedField(41, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (GT1-42).
     */
    public XPN[] getMotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(42, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Mother's Maiden Name (GT1-42).
     */
    public XPN[] getGt142_MotherSMaidenName() {
    	XPN[] retVal = this.getTypedField(42, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (GT1-42).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMotherSMaidenNameReps() {
    	return this.getReps(42);
    }


    /**
     * Returns a specific repetition of
     * GT1-42: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getMotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(42, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-42: "Mother's Maiden Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGt142_MotherSMaidenName(int rep) { 
		XPN retVal = this.getTypedField(42, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Mother's Maiden Name (GT1-42).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt142_MotherSMaidenNameReps() {
    	return this.getReps(42);
    }


    /**
     * Inserts a repetition of
     * GT1-42: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(42, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-42: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGt142_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(42, rep);
    }


    /**
     * Removes a repetition of
     * GT1-42: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeMotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(42, rep);
    }


    /**
     * Removes a repetition of
     * GT1-42: "Mother's Maiden Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGt142_MotherSMaidenName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(42, rep);
    }




    /**
     * Returns
     * GT1-43: "Nationality" - creates it if necessary
     */
    public CWE getNationality() { 
		CWE retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-43: "Nationality" - creates it if necessary
     */
    public CWE getGt143_Nationality() { 
		CWE retVal = this.getTypedField(43, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (GT1-44).
     */
    public CWE[] getEthnicGroup() {
    	CWE[] retVal = this.getTypedField(44, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ethnic Group (GT1-44).
     */
    public CWE[] getGt144_EthnicGroup() {
    	CWE[] retVal = this.getTypedField(44, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ethnic Group (GT1-44).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEthnicGroupReps() {
    	return this.getReps(44);
    }


    /**
     * Returns a specific repetition of
     * GT1-44: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getEthnicGroup(int rep) { 
		CWE retVal = this.getTypedField(44, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-44: "Ethnic Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGt144_EthnicGroup(int rep) { 
		CWE retVal = this.getTypedField(44, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ethnic Group (GT1-44).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt144_EthnicGroupReps() {
    	return this.getReps(44);
    }


    /**
     * Inserts a repetition of
     * GT1-44: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertEthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(44, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-44: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGt144_EthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(44, rep);
    }


    /**
     * Removes a repetition of
     * GT1-44: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeEthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(44, rep);
    }


    /**
     * Removes a repetition of
     * GT1-44: "Ethnic Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGt144_EthnicGroup(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(44, rep);
    }



    /**
     * Returns all repetitions of Contact Person's Name (GT1-45).
     */
    public XPN[] getContactPersonSName() {
    	XPN[] retVal = this.getTypedField(45, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Person's Name (GT1-45).
     */
    public XPN[] getGt145_ContactPersonSName() {
    	XPN[] retVal = this.getTypedField(45, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Person's Name (GT1-45).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactPersonSNameReps() {
    	return this.getReps(45);
    }


    /**
     * Returns a specific repetition of
     * GT1-45: "Contact Person's Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(45, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-45: "Contact Person's Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGt145_ContactPersonSName(int rep) { 
		XPN retVal = this.getTypedField(45, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Person's Name (GT1-45).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt145_ContactPersonSNameReps() {
    	return this.getReps(45);
    }


    /**
     * Inserts a repetition of
     * GT1-45: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(45, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-45: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGt145_ContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(45, rep);
    }


    /**
     * Removes a repetition of
     * GT1-45: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(45, rep);
    }


    /**
     * Removes a repetition of
     * GT1-45: "Contact Person's Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGt145_ContactPersonSName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(45, rep);
    }



    /**
     * Returns all repetitions of Contact Person's Telephone Number (GT1-46).
     */
    public XTN[] getContactPersonSTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(46, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Person's Telephone Number (GT1-46).
     */
    public XTN[] getGt146_ContactPersonSTelephoneNumber() {
    	XTN[] retVal = this.getTypedField(46, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Person's Telephone Number (GT1-46).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactPersonSTelephoneNumberReps() {
    	return this.getReps(46);
    }


    /**
     * Returns a specific repetition of
     * GT1-46: "Contact Person's Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getContactPersonSTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(46, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-46: "Contact Person's Telephone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getGt146_ContactPersonSTelephoneNumber(int rep) { 
		XTN retVal = this.getTypedField(46, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Person's Telephone Number (GT1-46).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt146_ContactPersonSTelephoneNumberReps() {
    	return this.getReps(46);
    }


    /**
     * Inserts a repetition of
     * GT1-46: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(46, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-46: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertGt146_ContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(46, rep);
    }


    /**
     * Removes a repetition of
     * GT1-46: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(46, rep);
    }


    /**
     * Removes a repetition of
     * GT1-46: "Contact Person's Telephone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeGt146_ContactPersonSTelephoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(46, rep);
    }




    /**
     * Returns
     * GT1-47: "Contact Reason" - creates it if necessary
     */
    public CWE getContactReason() { 
		CWE retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-47: "Contact Reason" - creates it if necessary
     */
    public CWE getGt147_ContactReason() { 
		CWE retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-48: "Contact Relationship" - creates it if necessary
     */
    public CWE getContactRelationship() { 
		CWE retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-48: "Contact Relationship" - creates it if necessary
     */
    public CWE getGt148_ContactRelationship() { 
		CWE retVal = this.getTypedField(48, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-49: "Job Title" - creates it if necessary
     */
    public ST getJobTitle() { 
		ST retVal = this.getTypedField(49, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-49: "Job Title" - creates it if necessary
     */
    public ST getGt149_JobTitle() { 
		ST retVal = this.getTypedField(49, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-50: "Job Code/Class" - creates it if necessary
     */
    public JCC getJobCodeClass() { 
		JCC retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-50: "Job Code/Class" - creates it if necessary
     */
    public JCC getGt150_JobCodeClass() { 
		JCC retVal = this.getTypedField(50, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer's Organization Name (GT1-51).
     */
    public XON[] getGuarantorEmployerSOrganizationName() {
    	XON[] retVal = this.getTypedField(51, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Employer's Organization Name (GT1-51).
     */
    public XON[] getGt151_GuarantorEmployerSOrganizationName() {
    	XON[] retVal = this.getTypedField(51, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Employer's Organization Name (GT1-51).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployerSOrganizationNameReps() {
    	return this.getReps(51);
    }


    /**
     * Returns a specific repetition of
     * GT1-51: "Guarantor Employer's Organization Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getGuarantorEmployerSOrganizationName(int rep) { 
		XON retVal = this.getTypedField(51, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-51: "Guarantor Employer's Organization Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getGt151_GuarantorEmployerSOrganizationName(int rep) { 
		XON retVal = this.getTypedField(51, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Employer's Organization Name (GT1-51).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt151_GuarantorEmployerSOrganizationNameReps() {
    	return this.getReps(51);
    }


    /**
     * Inserts a repetition of
     * GT1-51: "Guarantor Employer's Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertGuarantorEmployerSOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(51, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-51: "Guarantor Employer's Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertGt151_GuarantorEmployerSOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(51, rep);
    }


    /**
     * Removes a repetition of
     * GT1-51: "Guarantor Employer's Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeGuarantorEmployerSOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(51, rep);
    }


    /**
     * Removes a repetition of
     * GT1-51: "Guarantor Employer's Organization Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeGt151_GuarantorEmployerSOrganizationName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(51, rep);
    }




    /**
     * Returns
     * GT1-52: "Handicap" - creates it if necessary
     */
    public CWE getHandicap() { 
		CWE retVal = this.getTypedField(52, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-52: "Handicap" - creates it if necessary
     */
    public CWE getGt152_Handicap() { 
		CWE retVal = this.getTypedField(52, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-53: "Job Status" - creates it if necessary
     */
    public CWE getJobStatus() { 
		CWE retVal = this.getTypedField(53, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-53: "Job Status" - creates it if necessary
     */
    public CWE getGt153_JobStatus() { 
		CWE retVal = this.getTypedField(53, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-54: "Guarantor Financial Class" - creates it if necessary
     */
    public FC getGuarantorFinancialClass() { 
		FC retVal = this.getTypedField(54, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-54: "Guarantor Financial Class" - creates it if necessary
     */
    public FC getGt154_GuarantorFinancialClass() { 
		FC retVal = this.getTypedField(54, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Race (GT1-55).
     */
    public CWE[] getGuarantorRace() {
    	CWE[] retVal = this.getTypedField(55, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor Race (GT1-55).
     */
    public CWE[] getGt155_GuarantorRace() {
    	CWE[] retVal = this.getTypedField(55, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor Race (GT1-55).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorRaceReps() {
    	return this.getReps(55);
    }


    /**
     * Returns a specific repetition of
     * GT1-55: "Guarantor Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGuarantorRace(int rep) { 
		CWE retVal = this.getTypedField(55, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-55: "Guarantor Race" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getGt155_GuarantorRace(int rep) { 
		CWE retVal = this.getTypedField(55, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor Race (GT1-55).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt155_GuarantorRaceReps() {
    	return this.getReps(55);
    }


    /**
     * Inserts a repetition of
     * GT1-55: "Guarantor Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGuarantorRace(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(55, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-55: "Guarantor Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertGt155_GuarantorRace(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(55, rep);
    }


    /**
     * Removes a repetition of
     * GT1-55: "Guarantor Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGuarantorRace(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(55, rep);
    }


    /**
     * Removes a repetition of
     * GT1-55: "Guarantor Race" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeGt155_GuarantorRace(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(55, rep);
    }




    /**
     * Returns
     * GT1-56: "Guarantor Birth Place" - creates it if necessary
     */
    public ST getGuarantorBirthPlace() { 
		ST retVal = this.getTypedField(56, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-56: "Guarantor Birth Place" - creates it if necessary
     */
    public ST getGt156_GuarantorBirthPlace() { 
		ST retVal = this.getTypedField(56, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-57: "VIP Indicator" - creates it if necessary
     */
    public CWE getVIPIndicator() { 
		CWE retVal = this.getTypedField(57, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-57: "VIP Indicator" - creates it if necessary
     */
    public CWE getGt157_VIPIndicator() { 
		CWE retVal = this.getTypedField(57, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CX(getMessage());
          case 2: return new XPN(getMessage());
          case 3: return new XPN(getMessage());
          case 4: return new XAD(getMessage());
          case 5: return new XTN(getMessage());
          case 6: return new XTN(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new DT(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new XPN(getMessage());
          case 16: return new XAD(getMessage());
          case 17: return new XTN(getMessage());
          case 18: return new CX(getMessage());
          case 19: return new CWE(getMessage());
          case 20: return new XON(getMessage());
          case 21: return new ID(getMessage(), new Integer( 136 ));
          case 22: return new CWE(getMessage());
          case 23: return new DTM(getMessage());
          case 24: return new ID(getMessage(), new Integer( 136 ));
          case 25: return new CWE(getMessage());
          case 26: return new CP(getMessage());
          case 27: return new NM(getMessage());
          case 28: return new CX(getMessage());
          case 29: return new CWE(getMessage());
          case 30: return new DT(getMessage());
          case 31: return new DT(getMessage());
          case 32: return new CWE(getMessage());
          case 33: return new CWE(getMessage());
          case 34: return new CWE(getMessage());
          case 35: return new CWE(getMessage());
          case 36: return new CWE(getMessage());
          case 37: return new CWE(getMessage());
          case 38: return new ID(getMessage(), new Integer( 136 ));
          case 39: return new CWE(getMessage());
          case 40: return new CWE(getMessage());
          case 41: return new XPN(getMessage());
          case 42: return new CWE(getMessage());
          case 43: return new CWE(getMessage());
          case 44: return new XPN(getMessage());
          case 45: return new XTN(getMessage());
          case 46: return new CWE(getMessage());
          case 47: return new CWE(getMessage());
          case 48: return new ST(getMessage());
          case 49: return new JCC(getMessage());
          case 50: return new XON(getMessage());
          case 51: return new CWE(getMessage());
          case 52: return new CWE(getMessage());
          case 53: return new FC(getMessage());
          case 54: return new CWE(getMessage());
          case 55: return new ST(getMessage());
          case 56: return new CWE(getMessage());
          default: return null;
       }
   }


}

