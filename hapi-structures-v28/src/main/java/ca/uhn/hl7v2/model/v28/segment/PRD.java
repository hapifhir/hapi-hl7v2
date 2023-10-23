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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PRD message segment (Provider Data). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRD-1: Provider Role (CWE) <b> repeating</b>
     * <li>PRD-2: Provider Name (XPN) <b>optional repeating</b>
     * <li>PRD-3: Provider Address (XAD) <b>optional repeating</b>
     * <li>PRD-4: Provider Location (PL) <b>optional </b>
     * <li>PRD-5: Provider Communication Information (XTN) <b>optional repeating</b>
     * <li>PRD-6: Preferred Method of Contact (CWE) <b>optional </b>
     * <li>PRD-7: Provider Identifiers (PLN) <b>optional repeating</b>
     * <li>PRD-8: Effective Start Date of Provider Role (DTM) <b>optional </b>
     * <li>PRD-9: Effective End Date of Provider Role (DTM) <b>optional repeating</b>
     * <li>PRD-10: Provider Organization Name and Identifier (XON) <b>optional </b>
     * <li>PRD-11: Provider Organization Address (XAD) <b>optional repeating</b>
     * <li>PRD-12: Provider Organization Location Information (PL) <b>optional repeating</b>
     * <li>PRD-13: Provider Organization Communication Information (XTN) <b>optional repeating</b>
     * <li>PRD-14: Provider Organization Method of Contact (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PRD extends AbstractSegment {

    /** 
     * Creates a new PRD segment
     */
    public PRD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 0, 0, new Object[]{ getMessage() }, "Provider Role");
                                  this.add(XPN.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Name");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Address");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Provider Location");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Communication Information");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Preferred Method of Contact");
                                  this.add(PLN.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Identifiers");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Effective Start Date of Provider Role");
                                  this.add(DTM.class, false, 0, 0, new Object[]{ getMessage() }, "Effective End Date of Provider Role");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Provider Organization Name and Identifier");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Organization Address");
                                  this.add(PL.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Organization Location Information");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Provider Organization Communication Information");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Provider Organization Method of Contact");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRD - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Provider Role (PRD-1).
     */
    public CWE[] getProviderRole() {
    	CWE[] retVal = this.getTypedField(1, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Role (PRD-1).
     */
    public CWE[] getPrd1_ProviderRole() {
    	CWE[] retVal = this.getTypedField(1, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Role (PRD-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderRoleReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * PRD-1: "Provider Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getProviderRole(int rep) { 
		CWE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-1: "Provider Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPrd1_ProviderRole(int rep) { 
		CWE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Role (PRD-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd1_ProviderRoleReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * PRD-1: "Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertProviderRole(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-1: "Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPrd1_ProviderRole(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PRD-1: "Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeProviderRole(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PRD-1: "Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePrd1_ProviderRole(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(1, rep);
    }



    /**
     * Returns all repetitions of Provider Name (PRD-2).
     */
    public XPN[] getProviderName() {
    	XPN[] retVal = this.getTypedField(2, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Name (PRD-2).
     */
    public XPN[] getPrd2_ProviderName() {
    	XPN[] retVal = this.getTypedField(2, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Name (PRD-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderNameReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PRD-2: "Provider Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getProviderName(int rep) { 
		XPN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-2: "Provider Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPrd2_ProviderName(int rep) { 
		XPN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Name (PRD-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd2_ProviderNameReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PRD-2: "Provider Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertProviderName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-2: "Provider Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPrd2_ProviderName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRD-2: "Provider Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeProviderName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRD-2: "Provider Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePrd2_ProviderName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Provider Address (PRD-3).
     */
    public XAD[] getProviderAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Address (PRD-3).
     */
    public XAD[] getPrd3_ProviderAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Address (PRD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PRD-3: "Provider Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getProviderAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-3: "Provider Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPrd3_ProviderAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Address (PRD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd3_ProviderAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PRD-3: "Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-3: "Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPrd3_ProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRD-3: "Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRD-3: "Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePrd3_ProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * PRD-4: "Provider Location" - creates it if necessary
     */
    public PL getProviderLocation() { 
		PL retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRD-4: "Provider Location" - creates it if necessary
     */
    public PL getPrd4_ProviderLocation() { 
		PL retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Provider Communication Information (PRD-5).
     */
    public XTN[] getProviderCommunicationInformation() {
    	XTN[] retVal = this.getTypedField(5, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Communication Information (PRD-5).
     */
    public XTN[] getPrd5_ProviderCommunicationInformation() {
    	XTN[] retVal = this.getTypedField(5, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Communication Information (PRD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderCommunicationInformationReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PRD-5: "Provider Communication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getProviderCommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-5: "Provider Communication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPrd5_ProviderCommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Communication Information (PRD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd5_ProviderCommunicationInformationReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PRD-5: "Provider Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertProviderCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-5: "Provider Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPrd5_ProviderCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRD-5: "Provider Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeProviderCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRD-5: "Provider Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePrd5_ProviderCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * PRD-6: "Preferred Method of Contact" - creates it if necessary
     */
    public CWE getPreferredMethodOfContact() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRD-6: "Preferred Method of Contact" - creates it if necessary
     */
    public CWE getPrd6_PreferredMethodOfContact() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Provider Identifiers (PRD-7).
     */
    public PLN[] getProviderIdentifiers() {
    	PLN[] retVal = this.getTypedField(7, new PLN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Identifiers (PRD-7).
     */
    public PLN[] getPrd7_ProviderIdentifiers() {
    	PLN[] retVal = this.getTypedField(7, new PLN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Identifiers (PRD-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderIdentifiersReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PRD-7: "Provider Identifiers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PLN getProviderIdentifiers(int rep) { 
		PLN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-7: "Provider Identifiers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PLN getPrd7_ProviderIdentifiers(int rep) { 
		PLN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Identifiers (PRD-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd7_ProviderIdentifiersReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PRD-7: "Provider Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN insertProviderIdentifiers(int rep) throws HL7Exception { 
        return (PLN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-7: "Provider Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN insertPrd7_ProviderIdentifiers(int rep) throws HL7Exception { 
        return (PLN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PRD-7: "Provider Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN removeProviderIdentifiers(int rep) throws HL7Exception { 
        return (PLN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PRD-7: "Provider Identifiers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN removePrd7_ProviderIdentifiers(int rep) throws HL7Exception { 
        return (PLN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * PRD-8: "Effective Start Date of Provider Role" - creates it if necessary
     */
    public DTM getEffectiveStartDateOfProviderRole() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRD-8: "Effective Start Date of Provider Role" - creates it if necessary
     */
    public DTM getPrd8_EffectiveStartDateOfProviderRole() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Effective End Date of Provider Role (PRD-9).
     */
    public DTM[] getEffectiveEndDateOfProviderRole() {
    	DTM[] retVal = this.getTypedField(9, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Effective End Date of Provider Role (PRD-9).
     */
    public DTM[] getPrd9_EffectiveEndDateOfProviderRole() {
    	DTM[] retVal = this.getTypedField(9, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Effective End Date of Provider Role (PRD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEffectiveEndDateOfProviderRoleReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * PRD-9: "Effective End Date of Provider Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getEffectiveEndDateOfProviderRole(int rep) { 
		DTM retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-9: "Effective End Date of Provider Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getPrd9_EffectiveEndDateOfProviderRole(int rep) { 
		DTM retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Effective End Date of Provider Role (PRD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd9_EffectiveEndDateOfProviderRoleReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * PRD-9: "Effective End Date of Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertEffectiveEndDateOfProviderRole(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-9: "Effective End Date of Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertPrd9_EffectiveEndDateOfProviderRole(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PRD-9: "Effective End Date of Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeEffectiveEndDateOfProviderRole(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PRD-9: "Effective End Date of Provider Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removePrd9_EffectiveEndDateOfProviderRole(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PRD-10: "Provider Organization Name and Identifier" - creates it if necessary
     */
    public XON getProviderOrganizationNameAndIdentifier() { 
		XON retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRD-10: "Provider Organization Name and Identifier" - creates it if necessary
     */
    public XON getPrd10_ProviderOrganizationNameAndIdentifier() { 
		XON retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Provider Organization Address (PRD-11).
     */
    public XAD[] getProviderOrganizationAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Organization Address (PRD-11).
     */
    public XAD[] getPrd11_ProviderOrganizationAddress() {
    	XAD[] retVal = this.getTypedField(11, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Organization Address (PRD-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderOrganizationAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PRD-11: "Provider Organization Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getProviderOrganizationAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-11: "Provider Organization Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPrd11_ProviderOrganizationAddress(int rep) { 
		XAD retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Organization Address (PRD-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd11_ProviderOrganizationAddressReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PRD-11: "Provider Organization Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertProviderOrganizationAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-11: "Provider Organization Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPrd11_ProviderOrganizationAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRD-11: "Provider Organization Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeProviderOrganizationAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRD-11: "Provider Organization Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePrd11_ProviderOrganizationAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Provider Organization Location Information (PRD-12).
     */
    public PL[] getProviderOrganizationLocationInformation() {
    	PL[] retVal = this.getTypedField(12, new PL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Organization Location Information (PRD-12).
     */
    public PL[] getPrd12_ProviderOrganizationLocationInformation() {
    	PL[] retVal = this.getTypedField(12, new PL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Organization Location Information (PRD-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderOrganizationLocationInformationReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * PRD-12: "Provider Organization Location Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getProviderOrganizationLocationInformation(int rep) { 
		PL retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-12: "Provider Organization Location Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getPrd12_ProviderOrganizationLocationInformation(int rep) { 
		PL retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Organization Location Information (PRD-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd12_ProviderOrganizationLocationInformationReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * PRD-12: "Provider Organization Location Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertProviderOrganizationLocationInformation(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-12: "Provider Organization Location Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertPrd12_ProviderOrganizationLocationInformation(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PRD-12: "Provider Organization Location Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removeProviderOrganizationLocationInformation(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PRD-12: "Provider Organization Location Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removePrd12_ProviderOrganizationLocationInformation(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(12, rep);
    }



    /**
     * Returns all repetitions of Provider Organization Communication Information (PRD-13).
     */
    public XTN[] getProviderOrganizationCommunicationInformation() {
    	XTN[] retVal = this.getTypedField(13, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider Organization Communication Information (PRD-13).
     */
    public XTN[] getPrd13_ProviderOrganizationCommunicationInformation() {
    	XTN[] retVal = this.getTypedField(13, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider Organization Communication Information (PRD-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderOrganizationCommunicationInformationReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PRD-13: "Provider Organization Communication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getProviderOrganizationCommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRD-13: "Provider Organization Communication Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPrd13_ProviderOrganizationCommunicationInformation(int rep) { 
		XTN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider Organization Communication Information (PRD-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrd13_ProviderOrganizationCommunicationInformationReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PRD-13: "Provider Organization Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertProviderOrganizationCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PRD-13: "Provider Organization Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPrd13_ProviderOrganizationCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PRD-13: "Provider Organization Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeProviderOrganizationCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PRD-13: "Provider Organization Communication Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePrd13_ProviderOrganizationCommunicationInformation(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * PRD-14: "Provider Organization Method of Contact" - creates it if necessary
     */
    public CWE getProviderOrganizationMethodOfContact() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRD-14: "Provider Organization Method of Contact" - creates it if necessary
     */
    public CWE getPrd14_ProviderOrganizationMethodOfContact() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new XPN(getMessage());
          case 2: return new XAD(getMessage());
          case 3: return new PL(getMessage());
          case 4: return new XTN(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new PLN(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new DTM(getMessage());
          case 9: return new XON(getMessage());
          case 10: return new XAD(getMessage());
          case 11: return new PL(getMessage());
          case 12: return new XTN(getMessage());
          case 13: return new CWE(getMessage());
          default: return null;
       }
   }


}

