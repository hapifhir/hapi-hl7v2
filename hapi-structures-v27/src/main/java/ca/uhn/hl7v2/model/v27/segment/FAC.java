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
 *<p>Represents an HL7 FAC message segment (Facility). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FAC-1: Facility ID-FAC (EI) <b> </b>
     * <li>FAC-2: Facility Type (ID) <b>optional </b>
     * <li>FAC-3: Facility Address (XAD) <b> repeating</b>
     * <li>FAC-4: Facility Telecommunication (XTN) <b> </b>
     * <li>FAC-5: Contact Person (XCN) <b>optional repeating</b>
     * <li>FAC-6: Contact Title (ST) <b>optional repeating</b>
     * <li>FAC-7: Contact Address (XAD) <b>optional repeating</b>
     * <li>FAC-8: Contact Telecommunication (XTN) <b>optional repeating</b>
     * <li>FAC-9: Signature Authority (XCN) <b> repeating</b>
     * <li>FAC-10: Signature Authority Title (ST) <b>optional </b>
     * <li>FAC-11: Signature Authority Address (XAD) <b>optional repeating</b>
     * <li>FAC-12: Signature Authority Telecommunication (XTN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class FAC extends AbstractSegment {

    /** 
     * Creates a new FAC segment
     */
    public FAC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Facility ID-FAC");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(331) }, "Facility Type");
                                  this.add(XAD.class, true, 0, 0, new Object[]{ getMessage() }, "Facility Address");
                                  this.add(XTN.class, true, 1, 0, new Object[]{ getMessage() }, "Facility Telecommunication");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Contact Person");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Contact Title");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Contact Address");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Contact Telecommunication");
                                  this.add(XCN.class, true, 0, 0, new Object[]{ getMessage() }, "Signature Authority");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Signature Authority Title");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Signature Authority Address");
                                  this.add(XTN.class, false, 1, 0, new Object[]{ getMessage() }, "Signature Authority Telecommunication");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FAC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FAC-1: "Facility ID-FAC" - creates it if necessary
     */
    public EI getFacilityIDFAC() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FAC-1: "Facility ID-FAC" - creates it if necessary
     */
    public EI getFac1_FacilityIDFAC() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * FAC-2: "Facility Type" - creates it if necessary
     */
    public ID getFacilityType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FAC-2: "Facility Type" - creates it if necessary
     */
    public ID getFac2_FacilityType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Facility Address (FAC-3).
     */
    public XAD[] getFacilityAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Facility Address (FAC-3).
     */
    public XAD[] getFac3_FacilityAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Facility Address (FAC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFacilityAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * FAC-3: "Facility Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getFacilityAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-3: "Facility Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getFac3_FacilityAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Facility Address (FAC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac3_FacilityAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * FAC-3: "Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertFacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-3: "Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertFac3_FacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * FAC-3: "Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeFacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * FAC-3: "Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeFac3_FacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * FAC-4: "Facility Telecommunication" - creates it if necessary
     */
    public XTN getFacilityTelecommunication() { 
		XTN retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FAC-4: "Facility Telecommunication" - creates it if necessary
     */
    public XTN getFac4_FacilityTelecommunication() { 
		XTN retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contact Person (FAC-5).
     */
    public XCN[] getContactPerson() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Person (FAC-5).
     */
    public XCN[] getFac5_ContactPerson() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Person (FAC-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactPersonReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * FAC-5: "Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getContactPerson(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-5: "Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getFac5_ContactPerson(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Person (FAC-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac5_ContactPersonReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * FAC-5: "Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-5: "Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertFac5_ContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * FAC-5: "Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * FAC-5: "Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeFac5_ContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Contact Title (FAC-6).
     */
    public ST[] getContactTitle() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Title (FAC-6).
     */
    public ST[] getFac6_ContactTitle() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Title (FAC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactTitleReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * FAC-6: "Contact Title" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getContactTitle(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-6: "Contact Title" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getFac6_ContactTitle(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Title (FAC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac6_ContactTitleReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * FAC-6: "Contact Title" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertContactTitle(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-6: "Contact Title" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertFac6_ContactTitle(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * FAC-6: "Contact Title" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeContactTitle(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * FAC-6: "Contact Title" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeFac6_ContactTitle(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Contact Address (FAC-7).
     */
    public XAD[] getContactAddress() {
    	XAD[] retVal = this.getTypedField(7, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Address (FAC-7).
     */
    public XAD[] getFac7_ContactAddress() {
    	XAD[] retVal = this.getTypedField(7, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Address (FAC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactAddressReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * FAC-7: "Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getContactAddress(int rep) { 
		XAD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-7: "Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getFac7_ContactAddress(int rep) { 
		XAD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Address (FAC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac7_ContactAddressReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * FAC-7: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-7: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertFac7_ContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * FAC-7: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * FAC-7: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeFac7_ContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Contact Telecommunication (FAC-8).
     */
    public XTN[] getContactTelecommunication() {
    	XTN[] retVal = this.getTypedField(8, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Telecommunication (FAC-8).
     */
    public XTN[] getFac8_ContactTelecommunication() {
    	XTN[] retVal = this.getTypedField(8, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Telecommunication (FAC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactTelecommunicationReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * FAC-8: "Contact Telecommunication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getContactTelecommunication(int rep) { 
		XTN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-8: "Contact Telecommunication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getFac8_ContactTelecommunication(int rep) { 
		XTN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Telecommunication (FAC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac8_ContactTelecommunicationReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * FAC-8: "Contact Telecommunication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertContactTelecommunication(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-8: "Contact Telecommunication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertFac8_ContactTelecommunication(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * FAC-8: "Contact Telecommunication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeContactTelecommunication(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * FAC-8: "Contact Telecommunication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeFac8_ContactTelecommunication(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of Signature Authority (FAC-9).
     */
    public XCN[] getSignatureAuthority() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Signature Authority (FAC-9).
     */
    public XCN[] getFac9_SignatureAuthority() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Signature Authority (FAC-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSignatureAuthorityReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * FAC-9: "Signature Authority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSignatureAuthority(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-9: "Signature Authority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getFac9_SignatureAuthority(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Signature Authority (FAC-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac9_SignatureAuthorityReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * FAC-9: "Signature Authority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSignatureAuthority(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-9: "Signature Authority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertFac9_SignatureAuthority(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * FAC-9: "Signature Authority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSignatureAuthority(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * FAC-9: "Signature Authority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeFac9_SignatureAuthority(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * FAC-10: "Signature Authority Title" - creates it if necessary
     */
    public ST getSignatureAuthorityTitle() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FAC-10: "Signature Authority Title" - creates it if necessary
     */
    public ST getFac10_SignatureAuthorityTitle() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Signature Authority Address (FAC-11).
     */
    public XAD[] getSignatureAuthorityAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Signature Authority Address (FAC-11).
     */
    public XAD[] getFac11_SignatureAuthorityAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Signature Authority Address (FAC-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSignatureAuthorityAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * FAC-11: "Signature Authority Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getSignatureAuthorityAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * FAC-11: "Signature Authority Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getFac11_SignatureAuthorityAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Signature Authority Address (FAC-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFac11_SignatureAuthorityAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * FAC-11: "Signature Authority Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertSignatureAuthorityAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * FAC-11: "Signature Authority Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertFac11_SignatureAuthorityAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * FAC-11: "Signature Authority Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeSignatureAuthorityAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * FAC-11: "Signature Authority Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeFac11_SignatureAuthorityAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * FAC-12: "Signature Authority Telecommunication" - creates it if necessary
     */
    public XTN getSignatureAuthorityTelecommunication() { 
		XTN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FAC-12: "Signature Authority Telecommunication" - creates it if necessary
     */
    public XTN getFac12_SignatureAuthorityTelecommunication() { 
		XTN retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 331 ));
          case 2: return new XAD(getMessage());
          case 3: return new XTN(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new XAD(getMessage());
          case 7: return new XTN(getMessage());
          case 8: return new XCN(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new XAD(getMessage());
          case 11: return new XTN(getMessage());
          default: return null;
       }
   }


}

