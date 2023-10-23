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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 IN1 message segment (Insurance). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN1-1: Set ID - IN1 (SI) <b> </b>
     * <li>IN1-2: Insurance Plan ID (CE) <b> </b>
     * <li>IN1-3: Insurance Company ID (CX) <b> repeating</b>
     * <li>IN1-4: Insurance Company Name (XON) <b>optional repeating</b>
     * <li>IN1-5: Insurance Company Address (XAD) <b>optional repeating</b>
     * <li>IN1-6: Insurance Co Contact Person (XPN) <b>optional repeating</b>
     * <li>IN1-7: Insurance Co Phone Number (XTN) <b>optional repeating</b>
     * <li>IN1-8: Group Number (ST) <b>optional </b>
     * <li>IN1-9: Group Name (XON) <b>optional repeating</b>
     * <li>IN1-10: Insured's Group Emp ID (CX) <b>optional repeating</b>
     * <li>IN1-11: Insured's Group Emp Name (XON) <b>optional repeating</b>
     * <li>IN1-12: Plan Effective Date (DT) <b>optional </b>
     * <li>IN1-13: Plan Expiration Date (DT) <b>optional </b>
     * <li>IN1-14: Authorization Information (AUI) <b>optional </b>
     * <li>IN1-15: Plan Type (IS) <b>optional </b>
     * <li>IN1-16: Name Of Insured (XPN) <b>optional repeating</b>
     * <li>IN1-17: Insured's Relationship To Patient (CE) <b>optional </b>
     * <li>IN1-18: Insured's Date Of Birth (TS) <b>optional </b>
     * <li>IN1-19: Insured's Address (XAD) <b>optional repeating</b>
     * <li>IN1-20: Assignment Of Benefits (IS) <b>optional </b>
     * <li>IN1-21: Coordination Of Benefits (IS) <b>optional </b>
     * <li>IN1-22: Coord Of Ben. Priority (ST) <b>optional </b>
     * <li>IN1-23: Notice Of Admission Flag (ID) <b>optional </b>
     * <li>IN1-24: Notice Of Admission Date (DT) <b>optional </b>
     * <li>IN1-25: Report Of Eligibility Flag (ID) <b>optional </b>
     * <li>IN1-26: Report Of Eligibility Date (DT) <b>optional </b>
     * <li>IN1-27: Release Information Code (IS) <b>optional </b>
     * <li>IN1-28: Pre-Admit Cert (PAC) (ST) <b>optional </b>
     * <li>IN1-29: Verification Date/Time (TS) <b>optional </b>
     * <li>IN1-30: Verification By (XCN) <b>optional repeating</b>
     * <li>IN1-31: Type Of Agreement Code (IS) <b>optional </b>
     * <li>IN1-32: Billing Status (IS) <b>optional </b>
     * <li>IN1-33: Lifetime Reserve Days (NM) <b>optional </b>
     * <li>IN1-34: Delay Before L.R. Day (NM) <b>optional </b>
     * <li>IN1-35: Company Plan Code (IS) <b>optional </b>
     * <li>IN1-36: Policy Number (ST) <b>optional </b>
     * <li>IN1-37: Policy Deductible (CP) <b>optional </b>
     * <li>IN1-38: Policy Limit - Amount (CP) <b>optional </b>
     * <li>IN1-39: Policy Limit - Days (NM) <b>optional </b>
     * <li>IN1-40: Room Rate - Semi-Private (CP) <b>optional </b>
     * <li>IN1-41: Room Rate - Private (CP) <b>optional </b>
     * <li>IN1-42: Insured's Employment Status (CE) <b>optional </b>
     * <li>IN1-43: Insured's Administrative Sex (IS) <b>optional </b>
     * <li>IN1-44: Insured's Employer's Address (XAD) <b>optional repeating</b>
     * <li>IN1-45: Verification Status (ST) <b>optional </b>
     * <li>IN1-46: Prior Insurance Plan ID (IS) <b>optional </b>
     * <li>IN1-47: Coverage Type (IS) <b>optional </b>
     * <li>IN1-48: Handicap (IS) <b>optional </b>
     * <li>IN1-49: Insured's ID Number (CX) <b>optional repeating</b>
     * <li>IN1-50: Signature Code (IS) <b>optional </b>
     * <li>IN1-51: Signature Code Date (DT) <b>optional </b>
     * <li>IN1-52: Insured's Birth Place (ST) <b>optional </b>
     * <li>IN1-53: VIP Indicator (IS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IN1 extends AbstractSegment {

    /** 
     * Creates a new IN1 segment
     */
    public IN1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - IN1");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Insurance Plan ID");
                                  this.add(CX.class, true, 0, 250, new Object[]{ getMessage() }, "Insurance Company ID");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Insurance Company Name");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Insurance Company Address");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Insurance Co Contact Person");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Insurance Co Phone Number");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "Group Number");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Group Name");
                                  this.add(CX.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Group Emp ID");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Group Emp Name");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Plan Effective Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Plan Expiration Date");
                                  this.add(AUI.class, false, 1, 239, new Object[]{ getMessage() }, "Authorization Information");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(86) }, "Plan Type");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Name Of Insured");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Insured's Relationship To Patient");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Insured's Date Of Birth");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Address");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(135) }, "Assignment Of Benefits");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(173) }, "Coordination Of Benefits");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "Coord Of Ben. Priority");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Notice Of Admission Flag");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Notice Of Admission Date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Report Of Eligibility Flag");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Report Of Eligibility Date");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(93) }, "Release Information Code");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Pre-Admit Cert (PAC)");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Verification Date/Time");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Verification By");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(98) }, "Type Of Agreement Code");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(22) }, "Billing Status");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Lifetime Reserve Days");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Delay Before L.R. Day");
                                              this.add(IS.class, false, 1, 8, new Object[]{ getMessage(), new Integer(42) }, "Company Plan Code");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "Policy Number");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Policy Deductible");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Policy Limit - Amount");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Policy Limit - Days");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Room Rate - Semi-Private");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Room Rate - Private");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Insured's Employment Status");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Insured's Administrative Sex");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's Employer's Address");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "Verification Status");
                                              this.add(IS.class, false, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "Prior Insurance Plan ID");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(309) }, "Coverage Type");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(295) }, "Handicap");
                                  this.add(CX.class, false, 0, 250, new Object[]{ getMessage() }, "Insured's ID Number");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(535) }, "Signature Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Signature Code Date");
                                  this.add(ST.class, false, 1, 250, new Object[]{ getMessage() }, "Insured's Birth Place");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(99) }, "VIP Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN1-1: "Set ID - IN1" - creates it if necessary
     */
    public SI getSetIDIN1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-1: "Set ID - IN1" - creates it if necessary
     */
    public SI getIn11_SetIDIN1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-2: "Insurance Plan ID" - creates it if necessary
     */
    public CE getInsurancePlanID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-2: "Insurance Plan ID" - creates it if necessary
     */
    public CE getIn12_InsurancePlanID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insurance Company ID (IN1-3).
     */
    public CX[] getInsuranceCompanyID() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance Company ID (IN1-3).
     */
    public CX[] getIn13_InsuranceCompanyID() {
    	CX[] retVal = this.getTypedField(3, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance Company ID (IN1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCompanyIDReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * IN1-3: "Insurance Company ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getInsuranceCompanyID(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-3: "Insurance Company ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getIn13_InsuranceCompanyID(int rep) { 
		CX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance Company ID (IN1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn13_InsuranceCompanyIDReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * IN1-3: "Insurance Company ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertInsuranceCompanyID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-3: "Insurance Company ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertIn13_InsuranceCompanyID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * IN1-3: "Insurance Company ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeInsuranceCompanyID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * IN1-3: "Insurance Company ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeIn13_InsuranceCompanyID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Insurance Company Name (IN1-4).
     */
    public XON[] getInsuranceCompanyName() {
    	XON[] retVal = this.getTypedField(4, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance Company Name (IN1-4).
     */
    public XON[] getIn14_InsuranceCompanyName() {
    	XON[] retVal = this.getTypedField(4, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance Company Name (IN1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCompanyNameReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * IN1-4: "Insurance Company Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getInsuranceCompanyName(int rep) { 
		XON retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-4: "Insurance Company Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getIn14_InsuranceCompanyName(int rep) { 
		XON retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance Company Name (IN1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn14_InsuranceCompanyNameReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * IN1-4: "Insurance Company Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertInsuranceCompanyName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-4: "Insurance Company Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertIn14_InsuranceCompanyName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * IN1-4: "Insurance Company Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeInsuranceCompanyName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * IN1-4: "Insurance Company Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeIn14_InsuranceCompanyName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Insurance Company Address (IN1-5).
     */
    public XAD[] getInsuranceCompanyAddress() {
    	XAD[] retVal = this.getTypedField(5, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance Company Address (IN1-5).
     */
    public XAD[] getIn15_InsuranceCompanyAddress() {
    	XAD[] retVal = this.getTypedField(5, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance Company Address (IN1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCompanyAddressReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * IN1-5: "Insurance Company Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getInsuranceCompanyAddress(int rep) { 
		XAD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-5: "Insurance Company Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getIn15_InsuranceCompanyAddress(int rep) { 
		XAD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance Company Address (IN1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn15_InsuranceCompanyAddressReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * IN1-5: "Insurance Company Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertInsuranceCompanyAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-5: "Insurance Company Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertIn15_InsuranceCompanyAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * IN1-5: "Insurance Company Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeInsuranceCompanyAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * IN1-5: "Insurance Company Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeIn15_InsuranceCompanyAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Insurance Co Contact Person (IN1-6).
     */
    public XPN[] getInsuranceCoContactPerson() {
    	XPN[] retVal = this.getTypedField(6, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance Co Contact Person (IN1-6).
     */
    public XPN[] getIn16_InsuranceCoContactPerson() {
    	XPN[] retVal = this.getTypedField(6, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance Co Contact Person (IN1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCoContactPersonReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * IN1-6: "Insurance Co Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getInsuranceCoContactPerson(int rep) { 
		XPN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-6: "Insurance Co Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn16_InsuranceCoContactPerson(int rep) { 
		XPN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance Co Contact Person (IN1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn16_InsuranceCoContactPersonReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * IN1-6: "Insurance Co Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertInsuranceCoContactPerson(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-6: "Insurance Co Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn16_InsuranceCoContactPerson(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * IN1-6: "Insurance Co Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeInsuranceCoContactPerson(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * IN1-6: "Insurance Co Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn16_InsuranceCoContactPerson(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Insurance Co Phone Number (IN1-7).
     */
    public XTN[] getInsuranceCoPhoneNumber() {
    	XTN[] retVal = this.getTypedField(7, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insurance Co Phone Number (IN1-7).
     */
    public XTN[] getIn17_InsuranceCoPhoneNumber() {
    	XTN[] retVal = this.getTypedField(7, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insurance Co Phone Number (IN1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuranceCoPhoneNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * IN1-7: "Insurance Co Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getInsuranceCoPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-7: "Insurance Co Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn17_InsuranceCoPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insurance Co Phone Number (IN1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn17_InsuranceCoPhoneNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertInsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn17_InsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeInsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IN1-7: "Insurance Co Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn17_InsuranceCoPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * IN1-8: "Group Number" - creates it if necessary
     */
    public ST getGroupNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-8: "Group Number" - creates it if necessary
     */
    public ST getIn18_GroupNumber() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Group Name (IN1-9).
     */
    public XON[] getGroupName() {
    	XON[] retVal = this.getTypedField(9, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Group Name (IN1-9).
     */
    public XON[] getIn19_GroupName() {
    	XON[] retVal = this.getTypedField(9, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Group Name (IN1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGroupNameReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * IN1-9: "Group Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getGroupName(int rep) { 
		XON retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-9: "Group Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getIn19_GroupName(int rep) { 
		XON retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Group Name (IN1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn19_GroupNameReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * IN1-9: "Group Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertGroupName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-9: "Group Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertIn19_GroupName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * IN1-9: "Group Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeGroupName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * IN1-9: "Group Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeIn19_GroupName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Insured's Group Emp ID (IN1-10).
     */
    public CX[] getInsuredSGroupEmpID() {
    	CX[] retVal = this.getTypedField(10, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Group Emp ID (IN1-10).
     */
    public CX[] getIn110_InsuredSGroupEmpID() {
    	CX[] retVal = this.getTypedField(10, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Group Emp ID (IN1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSGroupEmpIDReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * IN1-10: "Insured's Group Emp ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getInsuredSGroupEmpID(int rep) { 
		CX retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-10: "Insured's Group Emp ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getIn110_InsuredSGroupEmpID(int rep) { 
		CX retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Group Emp ID (IN1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn110_InsuredSGroupEmpIDReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * IN1-10: "Insured's Group Emp ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertInsuredSGroupEmpID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-10: "Insured's Group Emp ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertIn110_InsuredSGroupEmpID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * IN1-10: "Insured's Group Emp ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeInsuredSGroupEmpID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * IN1-10: "Insured's Group Emp ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeIn110_InsuredSGroupEmpID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of Insured's Group Emp Name (IN1-11).
     */
    public XON[] getInsuredSGroupEmpName() {
    	XON[] retVal = this.getTypedField(11, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Group Emp Name (IN1-11).
     */
    public XON[] getIn111_InsuredSGroupEmpName() {
    	XON[] retVal = this.getTypedField(11, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Group Emp Name (IN1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSGroupEmpNameReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * IN1-11: "Insured's Group Emp Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getInsuredSGroupEmpName(int rep) { 
		XON retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-11: "Insured's Group Emp Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getIn111_InsuredSGroupEmpName(int rep) { 
		XON retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Group Emp Name (IN1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn111_InsuredSGroupEmpNameReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * IN1-11: "Insured's Group Emp Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertInsuredSGroupEmpName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-11: "Insured's Group Emp Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertIn111_InsuredSGroupEmpName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * IN1-11: "Insured's Group Emp Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeInsuredSGroupEmpName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * IN1-11: "Insured's Group Emp Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeIn111_InsuredSGroupEmpName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * IN1-12: "Plan Effective Date" - creates it if necessary
     */
    public DT getPlanEffectiveDate() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-12: "Plan Effective Date" - creates it if necessary
     */
    public DT getIn112_PlanEffectiveDate() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-13: "Plan Expiration Date" - creates it if necessary
     */
    public DT getPlanExpirationDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-13: "Plan Expiration Date" - creates it if necessary
     */
    public DT getIn113_PlanExpirationDate() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-14: "Authorization Information" - creates it if necessary
     */
    public AUI getAuthorizationInformation() { 
		AUI retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-14: "Authorization Information" - creates it if necessary
     */
    public AUI getIn114_AuthorizationInformation() { 
		AUI retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-15: "Plan Type" - creates it if necessary
     */
    public IS getPlanType() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-15: "Plan Type" - creates it if necessary
     */
    public IS getIn115_PlanType() { 
		IS retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Name Of Insured (IN1-16).
     */
    public XPN[] getNameOfInsured() {
    	XPN[] retVal = this.getTypedField(16, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Name Of Insured (IN1-16).
     */
    public XPN[] getIn116_NameOfInsured() {
    	XPN[] retVal = this.getTypedField(16, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Name Of Insured (IN1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getNameOfInsuredReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * IN1-16: "Name Of Insured" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getNameOfInsured(int rep) { 
		XPN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-16: "Name Of Insured" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getIn116_NameOfInsured(int rep) { 
		XPN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Name Of Insured (IN1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn116_NameOfInsuredReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * IN1-16: "Name Of Insured" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertNameOfInsured(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-16: "Name Of Insured" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertIn116_NameOfInsured(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * IN1-16: "Name Of Insured" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeNameOfInsured(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * IN1-16: "Name Of Insured" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeIn116_NameOfInsured(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * IN1-17: "Insured's Relationship To Patient" - creates it if necessary
     */
    public CE getInsuredSRelationshipToPatient() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-17: "Insured's Relationship To Patient" - creates it if necessary
     */
    public CE getIn117_InsuredSRelationshipToPatient() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-18: "Insured's Date Of Birth" - creates it if necessary
     */
    public TS getInsuredSDateOfBirth() { 
		TS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-18: "Insured's Date Of Birth" - creates it if necessary
     */
    public TS getIn118_InsuredSDateOfBirth() { 
		TS retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured's Address (IN1-19).
     */
    public XAD[] getInsuredSAddress() {
    	XAD[] retVal = this.getTypedField(19, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Address (IN1-19).
     */
    public XAD[] getIn119_InsuredSAddress() {
    	XAD[] retVal = this.getTypedField(19, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Address (IN1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSAddressReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * IN1-19: "Insured's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getInsuredSAddress(int rep) { 
		XAD retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-19: "Insured's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getIn119_InsuredSAddress(int rep) { 
		XAD retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Address (IN1-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn119_InsuredSAddressReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * IN1-19: "Insured's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertInsuredSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-19: "Insured's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertIn119_InsuredSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IN1-19: "Insured's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeInsuredSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IN1-19: "Insured's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeIn119_InsuredSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * IN1-20: "Assignment Of Benefits" - creates it if necessary
     */
    public IS getAssignmentOfBenefits() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-20: "Assignment Of Benefits" - creates it if necessary
     */
    public IS getIn120_AssignmentOfBenefits() { 
		IS retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-21: "Coordination Of Benefits" - creates it if necessary
     */
    public IS getCoordinationOfBenefits() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-21: "Coordination Of Benefits" - creates it if necessary
     */
    public IS getIn121_CoordinationOfBenefits() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-22: "Coord Of Ben. Priority" - creates it if necessary
     */
    public ST getCoordOfBenPriority() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-22: "Coord Of Ben. Priority" - creates it if necessary
     */
    public ST getIn122_CoordOfBenPriority() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-23: "Notice Of Admission Flag" - creates it if necessary
     */
    public ID getNoticeOfAdmissionFlag() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-23: "Notice Of Admission Flag" - creates it if necessary
     */
    public ID getIn123_NoticeOfAdmissionFlag() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-24: "Notice Of Admission Date" - creates it if necessary
     */
    public DT getNoticeOfAdmissionDate() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-24: "Notice Of Admission Date" - creates it if necessary
     */
    public DT getIn124_NoticeOfAdmissionDate() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-25: "Report Of Eligibility Flag" - creates it if necessary
     */
    public ID getReportOfEligibilityFlag() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-25: "Report Of Eligibility Flag" - creates it if necessary
     */
    public ID getIn125_ReportOfEligibilityFlag() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-26: "Report Of Eligibility Date" - creates it if necessary
     */
    public DT getReportOfEligibilityDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-26: "Report Of Eligibility Date" - creates it if necessary
     */
    public DT getIn126_ReportOfEligibilityDate() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-27: "Release Information Code" - creates it if necessary
     */
    public IS getReleaseInformationCode() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-27: "Release Information Code" - creates it if necessary
     */
    public IS getIn127_ReleaseInformationCode() { 
		IS retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-28: "Pre-Admit Cert (PAC)" - creates it if necessary
     */
    public ST getPreAdmitCert() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-28: "Pre-Admit Cert (PAC)" - creates it if necessary
     */
    public ST getIn128_PreAdmitCert() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-29: "Verification Date/Time" - creates it if necessary
     */
    public TS getVerificationDateTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-29: "Verification Date/Time" - creates it if necessary
     */
    public TS getIn129_VerificationDateTime() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Verification By (IN1-30).
     */
    public XCN[] getVerificationBy() {
    	XCN[] retVal = this.getTypedField(30, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Verification By (IN1-30).
     */
    public XCN[] getIn130_VerificationBy() {
    	XCN[] retVal = this.getTypedField(30, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Verification By (IN1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVerificationByReps() {
    	return this.getReps(30);
    }


    /**
     * Returns a specific repetition of
     * IN1-30: "Verification By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getVerificationBy(int rep) { 
		XCN retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-30: "Verification By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getIn130_VerificationBy(int rep) { 
		XCN retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Verification By (IN1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn130_VerificationByReps() {
    	return this.getReps(30);
    }


    /**
     * Inserts a repetition of
     * IN1-30: "Verification By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertVerificationBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(30, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-30: "Verification By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertIn130_VerificationBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * IN1-30: "Verification By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeVerificationBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * IN1-30: "Verification By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeIn130_VerificationBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(30, rep);
    }




    /**
     * Returns
     * IN1-31: "Type Of Agreement Code" - creates it if necessary
     */
    public IS getTypeOfAgreementCode() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-31: "Type Of Agreement Code" - creates it if necessary
     */
    public IS getIn131_TypeOfAgreementCode() { 
		IS retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-32: "Billing Status" - creates it if necessary
     */
    public IS getBillingStatus() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-32: "Billing Status" - creates it if necessary
     */
    public IS getIn132_BillingStatus() { 
		IS retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-33: "Lifetime Reserve Days" - creates it if necessary
     */
    public NM getLifetimeReserveDays() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-33: "Lifetime Reserve Days" - creates it if necessary
     */
    public NM getIn133_LifetimeReserveDays() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-34: "Delay Before L.R. Day" - creates it if necessary
     */
    public NM getDelayBeforeLRDay() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-34: "Delay Before L.R. Day" - creates it if necessary
     */
    public NM getIn134_DelayBeforeLRDay() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-35: "Company Plan Code" - creates it if necessary
     */
    public IS getCompanyPlanCode() { 
		IS retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-35: "Company Plan Code" - creates it if necessary
     */
    public IS getIn135_CompanyPlanCode() { 
		IS retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-36: "Policy Number" - creates it if necessary
     */
    public ST getPolicyNumber() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-36: "Policy Number" - creates it if necessary
     */
    public ST getIn136_PolicyNumber() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-37: "Policy Deductible" - creates it if necessary
     */
    public CP getPolicyDeductible() { 
		CP retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-37: "Policy Deductible" - creates it if necessary
     */
    public CP getIn137_PolicyDeductible() { 
		CP retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-38: "Policy Limit - Amount" - creates it if necessary
     */
    public CP getPolicyLimitAmount() { 
		CP retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-38: "Policy Limit - Amount" - creates it if necessary
     */
    public CP getIn138_PolicyLimitAmount() { 
		CP retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-39: "Policy Limit - Days" - creates it if necessary
     */
    public NM getPolicyLimitDays() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-39: "Policy Limit - Days" - creates it if necessary
     */
    public NM getIn139_PolicyLimitDays() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-40: "Room Rate - Semi-Private" - creates it if necessary
     */
    public CP getRoomRateSemiPrivate() { 
		CP retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-40: "Room Rate - Semi-Private" - creates it if necessary
     */
    public CP getIn140_RoomRateSemiPrivate() { 
		CP retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-41: "Room Rate - Private" - creates it if necessary
     */
    public CP getRoomRatePrivate() { 
		CP retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-41: "Room Rate - Private" - creates it if necessary
     */
    public CP getIn141_RoomRatePrivate() { 
		CP retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-42: "Insured's Employment Status" - creates it if necessary
     */
    public CE getInsuredSEmploymentStatus() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-42: "Insured's Employment Status" - creates it if necessary
     */
    public CE getIn142_InsuredSEmploymentStatus() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-43: "Insured's Administrative Sex" - creates it if necessary
     */
    public IS getInsuredSAdministrativeSex() { 
		IS retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-43: "Insured's Administrative Sex" - creates it if necessary
     */
    public IS getIn143_InsuredSAdministrativeSex() { 
		IS retVal = this.getTypedField(43, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured's Employer's Address (IN1-44).
     */
    public XAD[] getInsuredSEmployerSAddress() {
    	XAD[] retVal = this.getTypedField(44, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's Employer's Address (IN1-44).
     */
    public XAD[] getIn144_InsuredSEmployerSAddress() {
    	XAD[] retVal = this.getTypedField(44, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's Employer's Address (IN1-44).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSEmployerSAddressReps() {
    	return this.getReps(44);
    }


    /**
     * Returns a specific repetition of
     * IN1-44: "Insured's Employer's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getInsuredSEmployerSAddress(int rep) { 
		XAD retVal = this.getTypedField(44, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-44: "Insured's Employer's Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getIn144_InsuredSEmployerSAddress(int rep) { 
		XAD retVal = this.getTypedField(44, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's Employer's Address (IN1-44).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn144_InsuredSEmployerSAddressReps() {
    	return this.getReps(44);
    }


    /**
     * Inserts a repetition of
     * IN1-44: "Insured's Employer's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertInsuredSEmployerSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(44, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-44: "Insured's Employer's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertIn144_InsuredSEmployerSAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(44, rep);
    }


    /**
     * Removes a repetition of
     * IN1-44: "Insured's Employer's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeInsuredSEmployerSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(44, rep);
    }


    /**
     * Removes a repetition of
     * IN1-44: "Insured's Employer's Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeIn144_InsuredSEmployerSAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(44, rep);
    }




    /**
     * Returns
     * IN1-45: "Verification Status" - creates it if necessary
     */
    public ST getVerificationStatus() { 
		ST retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-45: "Verification Status" - creates it if necessary
     */
    public ST getIn145_VerificationStatus() { 
		ST retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-46: "Prior Insurance Plan ID" - creates it if necessary
     */
    public IS getPriorInsurancePlanID() { 
		IS retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-46: "Prior Insurance Plan ID" - creates it if necessary
     */
    public IS getIn146_PriorInsurancePlanID() { 
		IS retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-47: "Coverage Type" - creates it if necessary
     */
    public IS getCoverageType() { 
		IS retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-47: "Coverage Type" - creates it if necessary
     */
    public IS getIn147_CoverageType() { 
		IS retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-48: "Handicap" - creates it if necessary
     */
    public IS getHandicap() { 
		IS retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-48: "Handicap" - creates it if necessary
     */
    public IS getIn148_Handicap() { 
		IS retVal = this.getTypedField(48, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Insured's ID Number (IN1-49).
     */
    public CX[] getInsuredSIDNumber() {
    	CX[] retVal = this.getTypedField(49, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Insured's ID Number (IN1-49).
     */
    public CX[] getIn149_InsuredSIDNumber() {
    	CX[] retVal = this.getTypedField(49, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Insured's ID Number (IN1-49).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInsuredSIDNumberReps() {
    	return this.getReps(49);
    }


    /**
     * Returns a specific repetition of
     * IN1-49: "Insured's ID Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getInsuredSIDNumber(int rep) { 
		CX retVal = this.getTypedField(49, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN1-49: "Insured's ID Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getIn149_InsuredSIDNumber(int rep) { 
		CX retVal = this.getTypedField(49, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Insured's ID Number (IN1-49).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn149_InsuredSIDNumberReps() {
    	return this.getReps(49);
    }


    /**
     * Inserts a repetition of
     * IN1-49: "Insured's ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertInsuredSIDNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(49, rep);
    }


    /**
     * Inserts a repetition of
     * IN1-49: "Insured's ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertIn149_InsuredSIDNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(49, rep);
    }


    /**
     * Removes a repetition of
     * IN1-49: "Insured's ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeInsuredSIDNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(49, rep);
    }


    /**
     * Removes a repetition of
     * IN1-49: "Insured's ID Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeIn149_InsuredSIDNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(49, rep);
    }




    /**
     * Returns
     * IN1-50: "Signature Code" - creates it if necessary
     */
    public IS getSignatureCode() { 
		IS retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-50: "Signature Code" - creates it if necessary
     */
    public IS getIn150_SignatureCode() { 
		IS retVal = this.getTypedField(50, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-51: "Signature Code Date" - creates it if necessary
     */
    public DT getSignatureCodeDate() { 
		DT retVal = this.getTypedField(51, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-51: "Signature Code Date" - creates it if necessary
     */
    public DT getIn151_SignatureCodeDate() { 
		DT retVal = this.getTypedField(51, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-52: "Insured's Birth Place" - creates it if necessary
     */
    public ST getInsuredSBirthPlace() { 
		ST retVal = this.getTypedField(52, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-52: "Insured's Birth Place" - creates it if necessary
     */
    public ST getIn152_InsuredSBirthPlace() { 
		ST retVal = this.getTypedField(52, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-53: "VIP Indicator" - creates it if necessary
     */
    public IS getVIPIndicator() { 
		IS retVal = this.getTypedField(53, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-53: "VIP Indicator" - creates it if necessary
     */
    public IS getIn153_VIPIndicator() { 
		IS retVal = this.getTypedField(53, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CX(getMessage());
          case 3: return new XON(getMessage());
          case 4: return new XAD(getMessage());
          case 5: return new XPN(getMessage());
          case 6: return new XTN(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new XON(getMessage());
          case 9: return new CX(getMessage());
          case 10: return new XON(getMessage());
          case 11: return new DT(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new AUI(getMessage());
          case 14: return new IS(getMessage(), new Integer( 86 ));
          case 15: return new XPN(getMessage());
          case 16: return new CE(getMessage());
          case 17: return new TS(getMessage());
          case 18: return new XAD(getMessage());
          case 19: return new IS(getMessage(), new Integer( 135 ));
          case 20: return new IS(getMessage(), new Integer( 173 ));
          case 21: return new ST(getMessage());
          case 22: return new ID(getMessage(), new Integer( 136 ));
          case 23: return new DT(getMessage());
          case 24: return new ID(getMessage(), new Integer( 136 ));
          case 25: return new DT(getMessage());
          case 26: return new IS(getMessage(), new Integer( 93 ));
          case 27: return new ST(getMessage());
          case 28: return new TS(getMessage());
          case 29: return new XCN(getMessage());
          case 30: return new IS(getMessage(), new Integer( 98 ));
          case 31: return new IS(getMessage(), new Integer( 22 ));
          case 32: return new NM(getMessage());
          case 33: return new NM(getMessage());
          case 34: return new IS(getMessage(), new Integer( 42 ));
          case 35: return new ST(getMessage());
          case 36: return new CP(getMessage());
          case 37: return new CP(getMessage());
          case 38: return new NM(getMessage());
          case 39: return new CP(getMessage());
          case 40: return new CP(getMessage());
          case 41: return new CE(getMessage());
          case 42: return new IS(getMessage(), new Integer( 1 ));
          case 43: return new XAD(getMessage());
          case 44: return new ST(getMessage());
          case 45: return new IS(getMessage(), new Integer( 72 ));
          case 46: return new IS(getMessage(), new Integer( 309 ));
          case 47: return new IS(getMessage(), new Integer( 295 ));
          case 48: return new CX(getMessage());
          case 49: return new IS(getMessage(), new Integer( 535 ));
          case 50: return new DT(getMessage());
          case 51: return new ST(getMessage());
          case 52: return new IS(getMessage(), new Integer( 99 ));
          default: return null;
       }
   }


}

