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
 *<p>Represents an HL7 IN3 message segment (Insurance Additional Information, Certification). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN3-1: Set ID - IN3 (SI) <b> </b>
     * <li>IN3-2: Certification Number (CX) <b>optional </b>
     * <li>IN3-3: Certified By (XCN) <b>optional repeating</b>
     * <li>IN3-4: Certification Required (ID) <b>optional </b>
     * <li>IN3-5: Penalty (MOP) <b>optional </b>
     * <li>IN3-6: Certification Date/Time (DTM) <b>optional </b>
     * <li>IN3-7: Certification Modify Date/Time (DTM) <b>optional </b>
     * <li>IN3-8: Operator (XCN) <b>optional repeating</b>
     * <li>IN3-9: Certification Begin Date (DT) <b>optional </b>
     * <li>IN3-10: Certification End Date (DT) <b>optional </b>
     * <li>IN3-11: Days (DTN) <b>optional </b>
     * <li>IN3-12: Non-Concur Code/Description (CWE) <b>optional </b>
     * <li>IN3-13: Non-Concur Effective Date/Time (DTM) <b>optional </b>
     * <li>IN3-14: Physician Reviewer (XCN) <b>optional repeating</b>
     * <li>IN3-15: Certification Contact (ST) <b>optional </b>
     * <li>IN3-16: Certification Contact Phone Number (XTN) <b>optional repeating</b>
     * <li>IN3-17: Appeal Reason (CWE) <b>optional </b>
     * <li>IN3-18: Certification Agency (CWE) <b>optional </b>
     * <li>IN3-19: Certification Agency Phone Number (XTN) <b>optional repeating</b>
     * <li>IN3-20: Pre-Certification Requirement (ICD) <b>optional repeating</b>
     * <li>IN3-21: Case Manager (ST) <b>optional </b>
     * <li>IN3-22: Second Opinion Date (DT) <b>optional </b>
     * <li>IN3-23: Second Opinion Status (CWE) <b>optional </b>
     * <li>IN3-24: Second Opinion Documentation Received (CWE) <b>optional repeating</b>
     * <li>IN3-25: Second Opinion Physician (XCN) <b>optional repeating</b>
     * <li>IN3-26: Certification Type (CWE) <b>optional </b>
     * <li>IN3-27: Certification Category (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IN3 extends AbstractSegment {

    /** 
     * Creates a new IN3 segment
     */
    public IN3(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 0, new Object[]{ getMessage() }, "Set ID - IN3");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Number");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Certified By");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Certification Required");
                                  this.add(MOP.class, false, 1, 0, new Object[]{ getMessage() }, "Penalty");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Modify Date/Time");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Operator");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Begin Date");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Certification End Date");
                                  this.add(DTN.class, false, 1, 0, new Object[]{ getMessage() }, "Days");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Non-Concur Code/Description");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Non-Concur Effective Date/Time");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Physician Reviewer");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Contact");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Certification Contact Phone Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Appeal Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Agency");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Certification Agency Phone Number");
                                  this.add(ICD.class, false, 0, 0, new Object[]{ getMessage() }, "Pre-Certification Requirement");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Case Manager");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Second Opinion Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Second Opinion Status");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Second Opinion Documentation Received");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Second Opinion Physician");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Certification Category");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN3 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN3-1: "Set ID - IN3" - creates it if necessary
     */
    public SI getSetIDIN3() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-1: "Set ID - IN3" - creates it if necessary
     */
    public SI getIn31_SetIDIN3() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-2: "Certification Number" - creates it if necessary
     */
    public CX getCertificationNumber() { 
		CX retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-2: "Certification Number" - creates it if necessary
     */
    public CX getIn32_CertificationNumber() { 
		CX retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Certified By (IN3-3).
     */
    public XCN[] getCertifiedBy() {
    	XCN[] retVal = this.getTypedField(3, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Certified By (IN3-3).
     */
    public XCN[] getIn33_CertifiedBy() {
    	XCN[] retVal = this.getTypedField(3, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Certified By (IN3-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCertifiedByReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * IN3-3: "Certified By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCertifiedBy(int rep) { 
		XCN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-3: "Certified By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getIn33_CertifiedBy(int rep) { 
		XCN retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Certified By (IN3-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn33_CertifiedByReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * IN3-3: "Certified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCertifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-3: "Certified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertIn33_CertifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * IN3-3: "Certified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCertifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * IN3-3: "Certified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeIn33_CertifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * IN3-4: "Certification Required" - creates it if necessary
     */
    public ID getCertificationRequired() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-4: "Certification Required" - creates it if necessary
     */
    public ID getIn34_CertificationRequired() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-5: "Penalty" - creates it if necessary
     */
    public MOP getPenalty() { 
		MOP retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-5: "Penalty" - creates it if necessary
     */
    public MOP getIn35_Penalty() { 
		MOP retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-6: "Certification Date/Time" - creates it if necessary
     */
    public DTM getCertificationDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-6: "Certification Date/Time" - creates it if necessary
     */
    public DTM getIn36_CertificationDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-7: "Certification Modify Date/Time" - creates it if necessary
     */
    public DTM getCertificationModifyDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-7: "Certification Modify Date/Time" - creates it if necessary
     */
    public DTM getIn37_CertificationModifyDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Operator (IN3-8).
     */
    public XCN[] getOperator() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Operator (IN3-8).
     */
    public XCN[] getIn38_Operator() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Operator (IN3-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOperatorReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * IN3-8: "Operator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOperator(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-8: "Operator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getIn38_Operator(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Operator (IN3-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn38_OperatorReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * IN3-8: "Operator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOperator(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-8: "Operator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertIn38_Operator(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * IN3-8: "Operator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOperator(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * IN3-8: "Operator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeIn38_Operator(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * IN3-9: "Certification Begin Date" - creates it if necessary
     */
    public DT getCertificationBeginDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-9: "Certification Begin Date" - creates it if necessary
     */
    public DT getIn39_CertificationBeginDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-10: "Certification End Date" - creates it if necessary
     */
    public DT getCertificationEndDate() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-10: "Certification End Date" - creates it if necessary
     */
    public DT getIn310_CertificationEndDate() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-11: "Days" - creates it if necessary
     */
    public DTN getDays() { 
		DTN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-11: "Days" - creates it if necessary
     */
    public DTN getIn311_Days() { 
		DTN retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-12: "Non-Concur Code/Description" - creates it if necessary
     */
    public CWE getNonConcurCodeDescription() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-12: "Non-Concur Code/Description" - creates it if necessary
     */
    public CWE getIn312_NonConcurCodeDescription() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-13: "Non-Concur Effective Date/Time" - creates it if necessary
     */
    public DTM getNonConcurEffectiveDateTime() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-13: "Non-Concur Effective Date/Time" - creates it if necessary
     */
    public DTM getIn313_NonConcurEffectiveDateTime() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Physician Reviewer (IN3-14).
     */
    public XCN[] getPhysicianReviewer() {
    	XCN[] retVal = this.getTypedField(14, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Physician Reviewer (IN3-14).
     */
    public XCN[] getIn314_PhysicianReviewer() {
    	XCN[] retVal = this.getTypedField(14, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Physician Reviewer (IN3-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhysicianReviewerReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * IN3-14: "Physician Reviewer" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPhysicianReviewer(int rep) { 
		XCN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-14: "Physician Reviewer" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getIn314_PhysicianReviewer(int rep) { 
		XCN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Physician Reviewer (IN3-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn314_PhysicianReviewerReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * IN3-14: "Physician Reviewer" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPhysicianReviewer(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-14: "Physician Reviewer" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertIn314_PhysicianReviewer(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * IN3-14: "Physician Reviewer" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePhysicianReviewer(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * IN3-14: "Physician Reviewer" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeIn314_PhysicianReviewer(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * IN3-15: "Certification Contact" - creates it if necessary
     */
    public ST getCertificationContact() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-15: "Certification Contact" - creates it if necessary
     */
    public ST getIn315_CertificationContact() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Certification Contact Phone Number (IN3-16).
     */
    public XTN[] getCertificationContactPhoneNumber() {
    	XTN[] retVal = this.getTypedField(16, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Certification Contact Phone Number (IN3-16).
     */
    public XTN[] getIn316_CertificationContactPhoneNumber() {
    	XTN[] retVal = this.getTypedField(16, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Certification Contact Phone Number (IN3-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCertificationContactPhoneNumberReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * IN3-16: "Certification Contact Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getCertificationContactPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-16: "Certification Contact Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn316_CertificationContactPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Certification Contact Phone Number (IN3-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn316_CertificationContactPhoneNumberReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * IN3-16: "Certification Contact Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertCertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-16: "Certification Contact Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn316_CertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * IN3-16: "Certification Contact Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeCertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * IN3-16: "Certification Contact Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn316_CertificationContactPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * IN3-17: "Appeal Reason" - creates it if necessary
     */
    public CWE getAppealReason() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-17: "Appeal Reason" - creates it if necessary
     */
    public CWE getIn317_AppealReason() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-18: "Certification Agency" - creates it if necessary
     */
    public CWE getCertificationAgency() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-18: "Certification Agency" - creates it if necessary
     */
    public CWE getIn318_CertificationAgency() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Certification Agency Phone Number (IN3-19).
     */
    public XTN[] getCertificationAgencyPhoneNumber() {
    	XTN[] retVal = this.getTypedField(19, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Certification Agency Phone Number (IN3-19).
     */
    public XTN[] getIn319_CertificationAgencyPhoneNumber() {
    	XTN[] retVal = this.getTypedField(19, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Certification Agency Phone Number (IN3-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCertificationAgencyPhoneNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * IN3-19: "Certification Agency Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getCertificationAgencyPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-19: "Certification Agency Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getIn319_CertificationAgencyPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Certification Agency Phone Number (IN3-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn319_CertificationAgencyPhoneNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * IN3-19: "Certification Agency Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertCertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-19: "Certification Agency Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertIn319_CertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IN3-19: "Certification Agency Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeCertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IN3-19: "Certification Agency Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeIn319_CertificationAgencyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(19, rep);
    }



    /**
     * Returns all repetitions of Pre-Certification Requirement (IN3-20).
     */
    public ICD[] getPreCertificationRequirement() {
    	ICD[] retVal = this.getTypedField(20, new ICD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pre-Certification Requirement (IN3-20).
     */
    public ICD[] getIn320_PreCertificationRequirement() {
    	ICD[] retVal = this.getTypedField(20, new ICD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pre-Certification Requirement (IN3-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPreCertificationRequirementReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * IN3-20: "Pre-Certification Requirement" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ICD getPreCertificationRequirement(int rep) { 
		ICD retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-20: "Pre-Certification Requirement" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ICD getIn320_PreCertificationRequirement(int rep) { 
		ICD retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pre-Certification Requirement (IN3-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn320_PreCertificationRequirementReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * IN3-20: "Pre-Certification Requirement" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ICD insertPreCertificationRequirement(int rep) throws HL7Exception { 
        return (ICD) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-20: "Pre-Certification Requirement" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ICD insertIn320_PreCertificationRequirement(int rep) throws HL7Exception { 
        return (ICD) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * IN3-20: "Pre-Certification Requirement" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ICD removePreCertificationRequirement(int rep) throws HL7Exception { 
        return (ICD) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * IN3-20: "Pre-Certification Requirement" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ICD removeIn320_PreCertificationRequirement(int rep) throws HL7Exception { 
        return (ICD) super.removeRepetition(20, rep);
    }




    /**
     * Returns
     * IN3-21: "Case Manager" - creates it if necessary
     */
    public ST getCaseManager() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-21: "Case Manager" - creates it if necessary
     */
    public ST getIn321_CaseManager() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-22: "Second Opinion Date" - creates it if necessary
     */
    public DT getSecondOpinionDate() { 
		DT retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-22: "Second Opinion Date" - creates it if necessary
     */
    public DT getIn322_SecondOpinionDate() { 
		DT retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-23: "Second Opinion Status" - creates it if necessary
     */
    public CWE getSecondOpinionStatus() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-23: "Second Opinion Status" - creates it if necessary
     */
    public CWE getIn323_SecondOpinionStatus() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Second Opinion Documentation Received (IN3-24).
     */
    public CWE[] getSecondOpinionDocumentationReceived() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Second Opinion Documentation Received (IN3-24).
     */
    public CWE[] getIn324_SecondOpinionDocumentationReceived() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Second Opinion Documentation Received (IN3-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSecondOpinionDocumentationReceivedReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * IN3-24: "Second Opinion Documentation Received" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSecondOpinionDocumentationReceived(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-24: "Second Opinion Documentation Received" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getIn324_SecondOpinionDocumentationReceived(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Second Opinion Documentation Received (IN3-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn324_SecondOpinionDocumentationReceivedReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * IN3-24: "Second Opinion Documentation Received" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSecondOpinionDocumentationReceived(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-24: "Second Opinion Documentation Received" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertIn324_SecondOpinionDocumentationReceived(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN3-24: "Second Opinion Documentation Received" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSecondOpinionDocumentationReceived(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * IN3-24: "Second Opinion Documentation Received" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIn324_SecondOpinionDocumentationReceived(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }



    /**
     * Returns all repetitions of Second Opinion Physician (IN3-25).
     */
    public XCN[] getSecondOpinionPhysician() {
    	XCN[] retVal = this.getTypedField(25, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Second Opinion Physician (IN3-25).
     */
    public XCN[] getIn325_SecondOpinionPhysician() {
    	XCN[] retVal = this.getTypedField(25, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Second Opinion Physician (IN3-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSecondOpinionPhysicianReps() {
    	return this.getReps(25);
    }


    /**
     * Returns a specific repetition of
     * IN3-25: "Second Opinion Physician" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSecondOpinionPhysician(int rep) { 
		XCN retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IN3-25: "Second Opinion Physician" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getIn325_SecondOpinionPhysician(int rep) { 
		XCN retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Second Opinion Physician (IN3-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIn325_SecondOpinionPhysicianReps() {
    	return this.getReps(25);
    }


    /**
     * Inserts a repetition of
     * IN3-25: "Second Opinion Physician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSecondOpinionPhysician(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(25, rep);
    }


    /**
     * Inserts a repetition of
     * IN3-25: "Second Opinion Physician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertIn325_SecondOpinionPhysician(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * IN3-25: "Second Opinion Physician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSecondOpinionPhysician(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * IN3-25: "Second Opinion Physician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeIn325_SecondOpinionPhysician(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(25, rep);
    }




    /**
     * Returns
     * IN3-26: "Certification Type" - creates it if necessary
     */
    public CWE getCertificationType() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-26: "Certification Type" - creates it if necessary
     */
    public CWE getIn326_CertificationType() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IN3-27: "Certification Category" - creates it if necessary
     */
    public CWE getCertificationCategory() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN3-27: "Certification Category" - creates it if necessary
     */
    public CWE getIn327_CertificationCategory() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CX(getMessage());
          case 2: return new XCN(getMessage());
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new MOP(getMessage());
          case 5: return new DTM(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new XCN(getMessage());
          case 8: return new DT(getMessage());
          case 9: return new DT(getMessage());
          case 10: return new DTN(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new DTM(getMessage());
          case 13: return new XCN(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new XTN(getMessage());
          case 16: return new CWE(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new XTN(getMessage());
          case 19: return new ICD(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new DT(getMessage());
          case 22: return new CWE(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new XCN(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new CWE(getMessage());
          default: return null;
       }
   }


}

