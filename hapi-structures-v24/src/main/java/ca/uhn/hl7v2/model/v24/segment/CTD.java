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
 *<p>Represents an HL7 CTD message segment (Contact Data). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CTD-1: Contact Role (CE) <b> repeating</b>
     * <li>CTD-2: Contact Name (XPN) <b>optional repeating</b>
     * <li>CTD-3: Contact Address (XAD) <b>optional repeating</b>
     * <li>CTD-4: Contact Location (PL) <b>optional </b>
     * <li>CTD-5: Contact Communication Information (XTN) <b>optional repeating</b>
     * <li>CTD-6: Preferred Method of Contact (CE) <b>optional </b>
     * <li>CTD-7: Contact Identifiers (PI) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CTD extends AbstractSegment {

    /** 
     * Creates a new CTD segment
     */
    public CTD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, true, 0, 250, new Object[]{ getMessage() }, "Contact Role");
                                  this.add(XPN.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Name");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Address");
                                  this.add(PL.class, false, 1, 60, new Object[]{ getMessage() }, "Contact Location");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Contact Communication Information");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Preferred Method of Contact");
                                  this.add(PI.class, false, 0, 100, new Object[]{ getMessage() }, "Contact Identifiers");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CTD - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Contact Role (CTD-1).
     */
    public CE[] getContactRole() {
    	CE[] retVal = this.getTypedField(1, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Role (CTD-1).
     */
    public CE[] getCtd1_ContactRole() {
    	CE[] retVal = this.getTypedField(1, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Role (CTD-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactRoleReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * CTD-1: "Contact Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getContactRole(int rep) { 
		CE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CTD-1: "Contact Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCtd1_ContactRole(int rep) { 
		CE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Role (CTD-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCtd1_ContactRoleReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * CTD-1: "Contact Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertContactRole(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * CTD-1: "Contact Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCtd1_ContactRole(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * CTD-1: "Contact Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeContactRole(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * CTD-1: "Contact Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCtd1_ContactRole(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(1, rep);
    }



    /**
     * Returns all repetitions of Contact Name (CTD-2).
     */
    public XPN[] getContactName() {
    	XPN[] retVal = this.getTypedField(2, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Name (CTD-2).
     */
    public XPN[] getCtd2_ContactName() {
    	XPN[] retVal = this.getTypedField(2, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Name (CTD-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactNameReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * CTD-2: "Contact Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getContactName(int rep) { 
		XPN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CTD-2: "Contact Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getCtd2_ContactName(int rep) { 
		XPN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Name (CTD-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCtd2_ContactNameReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * CTD-2: "Contact Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertContactName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * CTD-2: "Contact Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertCtd2_ContactName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * CTD-2: "Contact Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeContactName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * CTD-2: "Contact Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeCtd2_ContactName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Contact Address (CTD-3).
     */
    public XAD[] getContactAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Address (CTD-3).
     */
    public XAD[] getCtd3_ContactAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Address (CTD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * CTD-3: "Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getContactAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CTD-3: "Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getCtd3_ContactAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Address (CTD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCtd3_ContactAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * CTD-3: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * CTD-3: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertCtd3_ContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * CTD-3: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * CTD-3: "Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeCtd3_ContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * CTD-4: "Contact Location" - creates it if necessary
     */
    public PL getContactLocation() { 
		PL retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CTD-4: "Contact Location" - creates it if necessary
     */
    public PL getCtd4_ContactLocation() { 
		PL retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contact Communication Information (CTD-5).
     */
    public XTN[] getContactCommunicationInformation() {
    	XTN[] retVal = this.getTypedField(5, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Communication Information (CTD-5).
     */
    public XTN[] getCtd5_ContactCommunicationInformation() {
    	XTN[] retVal = this.getTypedField(5, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Communication Information (CTD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactCommunicationInformationReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * CTD-5: "Contact Communication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getContactCommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CTD-5: "Contact Communication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getCtd5_ContactCommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Communication Information (CTD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCtd5_ContactCommunicationInformationReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * CTD-5: "Contact Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertContactCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * CTD-5: "Contact Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertCtd5_ContactCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * CTD-5: "Contact Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeContactCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * CTD-5: "Contact Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeCtd5_ContactCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * CTD-6: "Preferred Method of Contact" - creates it if necessary
     */
    public CE getPreferredMethodOfContact() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CTD-6: "Preferred Method of Contact" - creates it if necessary
     */
    public CE getCtd6_PreferredMethodOfContact() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contact Identifiers (CTD-7).
     */
    public PI[] getContactIdentifiers() {
    	PI[] retVal = this.getTypedField(7, new PI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contact Identifiers (CTD-7).
     */
    public PI[] getCtd7_ContactIdentifiers() {
    	PI[] retVal = this.getTypedField(7, new PI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contact Identifiers (CTD-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContactIdentifiersReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * CTD-7: "Contact Identifiers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PI getContactIdentifiers(int rep) { 
		PI retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CTD-7: "Contact Identifiers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PI getCtd7_ContactIdentifiers(int rep) { 
		PI retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contact Identifiers (CTD-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCtd7_ContactIdentifiersReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * CTD-7: "Contact Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PI insertContactIdentifiers(int rep) throws HL7Exception { 
        return (PI) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * CTD-7: "Contact Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PI insertCtd7_ContactIdentifiers(int rep) throws HL7Exception { 
        return (PI) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * CTD-7: "Contact Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PI removeContactIdentifiers(int rep) throws HL7Exception { 
        return (PI) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * CTD-7: "Contact Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PI removeCtd7_ContactIdentifiers(int rep) throws HL7Exception { 
        return (PI) super.removeRepetition(7, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new XPN(getMessage());
          case 2: return new XAD(getMessage());
          case 3: return new PL(getMessage());
          case 4: return new XTN(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new PI(getMessage());
          default: return null;
       }
   }


}

