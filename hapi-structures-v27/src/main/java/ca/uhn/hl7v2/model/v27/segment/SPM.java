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
 *<p>Represents an HL7 SPM message segment (Specimen). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SPM-1: Set ID - SPM (SI) <b>optional </b>
     * <li>SPM-2: Specimen ID (EIP) <b>optional </b>
     * <li>SPM-3: Specimen Parent IDs (EIP) <b>optional repeating</b>
     * <li>SPM-4: Specimen Type (CWE) <b> </b>
     * <li>SPM-5: Specimen Type Modifier (CWE) <b>optional repeating</b>
     * <li>SPM-6: Specimen Additives (CWE) <b>optional repeating</b>
     * <li>SPM-7: Specimen Collection Method (CWE) <b>optional </b>
     * <li>SPM-8: Specimen Source Site (CWE) <b>optional </b>
     * <li>SPM-9: Specimen Source Site Modifier (CWE) <b>optional repeating</b>
     * <li>SPM-10: Specimen Collection Site (CWE) <b>optional </b>
     * <li>SPM-11: Specimen Role (CWE) <b>optional repeating</b>
     * <li>SPM-12: Specimen Collection Amount (CQ) <b>optional </b>
     * <li>SPM-13: Grouped Specimen Count (NM) <b>optional </b>
     * <li>SPM-14: Specimen Description (ST) <b>optional repeating</b>
     * <li>SPM-15: Specimen Handling Code (CWE) <b>optional repeating</b>
     * <li>SPM-16: Specimen Risk Code (CWE) <b>optional repeating</b>
     * <li>SPM-17: Specimen Collection Date/Time (DR) <b>optional </b>
     * <li>SPM-18: Specimen Received Date/Time (DTM) <b>optional </b>
     * <li>SPM-19: Specimen Expiration Date/Time (DTM) <b>optional </b>
     * <li>SPM-20: Specimen Availability (ID) <b>optional </b>
     * <li>SPM-21: Specimen Reject Reason (CWE) <b>optional repeating</b>
     * <li>SPM-22: Specimen Quality (CWE) <b>optional </b>
     * <li>SPM-23: Specimen Appropriateness (CWE) <b>optional </b>
     * <li>SPM-24: Specimen Condition (CWE) <b>optional repeating</b>
     * <li>SPM-25: Specimen Current Quantity (CQ) <b>optional </b>
     * <li>SPM-26: Number of Specimen Containers (NM) <b>optional </b>
     * <li>SPM-27: Container Type (CWE) <b>optional </b>
     * <li>SPM-28: Container Condition (CWE) <b>optional </b>
     * <li>SPM-29: Specimen Child Role (CWE) <b>optional </b>
     * <li>SPM-30: Accession ID (CX) <b>optional repeating</b>
     * <li>SPM-31: Other Specimen ID (CX) <b>optional repeating</b>
     * <li>SPM-32: Shipment ID (EI) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SPM extends AbstractSegment {

    /** 
     * Creates a new SPM segment
     */
    public SPM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - SPM");
                                  this.add(EIP.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen ID");
                                  this.add(EIP.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Parent IDs");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Specimen Type");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Type Modifier");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Additives");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Collection Method");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Source Site");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Source Site Modifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Collection Site");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Role");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Collection Amount");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Grouped Specimen Count");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Description");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Handling Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Risk Code");
                                  this.add(DR.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Collection Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Received Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Expiration Date/Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Specimen Availability");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Reject Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Quality");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Appropriateness");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Condition");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Current Quantity");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Specimen Containers");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Container Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Container Condition");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Child Role");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Accession ID");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Other Specimen ID");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Shipment ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SPM - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SPM-1: "Set ID - SPM" - creates it if necessary
     */
    public SI getSetIDSPM() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-1: "Set ID - SPM" - creates it if necessary
     */
    public SI getSpm1_SetIDSPM() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-2: "Specimen ID" - creates it if necessary
     */
    public EIP getSpecimenID() { 
		EIP retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-2: "Specimen ID" - creates it if necessary
     */
    public EIP getSpm2_SpecimenID() { 
		EIP retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Parent IDs (SPM-3).
     */
    public EIP[] getSpecimenParentIDs() {
    	EIP[] retVal = this.getTypedField(3, new EIP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Parent IDs (SPM-3).
     */
    public EIP[] getSpm3_SpecimenParentIDs() {
    	EIP[] retVal = this.getTypedField(3, new EIP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Parent IDs (SPM-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenParentIDsReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * SPM-3: "Specimen Parent IDs" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EIP getSpecimenParentIDs(int rep) { 
		EIP retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-3: "Specimen Parent IDs" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EIP getSpm3_SpecimenParentIDs(int rep) { 
		EIP retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Parent IDs (SPM-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm3_SpecimenParentIDsReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * SPM-3: "Specimen Parent IDs" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EIP insertSpecimenParentIDs(int rep) throws HL7Exception { 
        return (EIP) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-3: "Specimen Parent IDs" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EIP insertSpm3_SpecimenParentIDs(int rep) throws HL7Exception { 
        return (EIP) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * SPM-3: "Specimen Parent IDs" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EIP removeSpecimenParentIDs(int rep) throws HL7Exception { 
        return (EIP) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * SPM-3: "Specimen Parent IDs" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EIP removeSpm3_SpecimenParentIDs(int rep) throws HL7Exception { 
        return (EIP) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * SPM-4: "Specimen Type" - creates it if necessary
     */
    public CWE getSpecimenType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-4: "Specimen Type" - creates it if necessary
     */
    public CWE getSpm4_SpecimenType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Type Modifier (SPM-5).
     */
    public CWE[] getSpecimenTypeModifier() {
    	CWE[] retVal = this.getTypedField(5, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Type Modifier (SPM-5).
     */
    public CWE[] getSpm5_SpecimenTypeModifier() {
    	CWE[] retVal = this.getTypedField(5, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Type Modifier (SPM-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenTypeModifierReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * SPM-5: "Specimen Type Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenTypeModifier(int rep) { 
		CWE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-5: "Specimen Type Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm5_SpecimenTypeModifier(int rep) { 
		CWE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Type Modifier (SPM-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm5_SpecimenTypeModifierReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * SPM-5: "Specimen Type Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenTypeModifier(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-5: "Specimen Type Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm5_SpecimenTypeModifier(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * SPM-5: "Specimen Type Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenTypeModifier(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * SPM-5: "Specimen Type Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm5_SpecimenTypeModifier(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Specimen Additives (SPM-6).
     */
    public CWE[] getSpecimenAdditives() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Additives (SPM-6).
     */
    public CWE[] getSpm6_SpecimenAdditives() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Additives (SPM-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenAdditivesReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * SPM-6: "Specimen Additives" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenAdditives(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-6: "Specimen Additives" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm6_SpecimenAdditives(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Additives (SPM-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm6_SpecimenAdditivesReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * SPM-6: "Specimen Additives" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenAdditives(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-6: "Specimen Additives" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm6_SpecimenAdditives(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * SPM-6: "Specimen Additives" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenAdditives(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * SPM-6: "Specimen Additives" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm6_SpecimenAdditives(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * SPM-7: "Specimen Collection Method" - creates it if necessary
     */
    public CWE getSpecimenCollectionMethod() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-7: "Specimen Collection Method" - creates it if necessary
     */
    public CWE getSpm7_SpecimenCollectionMethod() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-8: "Specimen Source Site" - creates it if necessary
     */
    public CWE getSpecimenSourceSite() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-8: "Specimen Source Site" - creates it if necessary
     */
    public CWE getSpm8_SpecimenSourceSite() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Source Site Modifier (SPM-9).
     */
    public CWE[] getSpecimenSourceSiteModifier() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Source Site Modifier (SPM-9).
     */
    public CWE[] getSpm9_SpecimenSourceSiteModifier() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Source Site Modifier (SPM-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenSourceSiteModifierReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * SPM-9: "Specimen Source Site Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenSourceSiteModifier(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-9: "Specimen Source Site Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm9_SpecimenSourceSiteModifier(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Source Site Modifier (SPM-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm9_SpecimenSourceSiteModifierReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * SPM-9: "Specimen Source Site Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenSourceSiteModifier(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-9: "Specimen Source Site Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm9_SpecimenSourceSiteModifier(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * SPM-9: "Specimen Source Site Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenSourceSiteModifier(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * SPM-9: "Specimen Source Site Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm9_SpecimenSourceSiteModifier(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * SPM-10: "Specimen Collection Site" - creates it if necessary
     */
    public CWE getSpecimenCollectionSite() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-10: "Specimen Collection Site" - creates it if necessary
     */
    public CWE getSpm10_SpecimenCollectionSite() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Role (SPM-11).
     */
    public CWE[] getSpecimenRole() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Role (SPM-11).
     */
    public CWE[] getSpm11_SpecimenRole() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Role (SPM-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenRoleReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * SPM-11: "Specimen Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenRole(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-11: "Specimen Role" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm11_SpecimenRole(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Role (SPM-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm11_SpecimenRoleReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * SPM-11: "Specimen Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenRole(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-11: "Specimen Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm11_SpecimenRole(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * SPM-11: "Specimen Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenRole(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * SPM-11: "Specimen Role" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm11_SpecimenRole(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * SPM-12: "Specimen Collection Amount" - creates it if necessary
     */
    public CQ getSpecimenCollectionAmount() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-12: "Specimen Collection Amount" - creates it if necessary
     */
    public CQ getSpm12_SpecimenCollectionAmount() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-13: "Grouped Specimen Count" - creates it if necessary
     */
    public NM getGroupedSpecimenCount() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-13: "Grouped Specimen Count" - creates it if necessary
     */
    public NM getSpm13_GroupedSpecimenCount() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Description (SPM-14).
     */
    public ST[] getSpecimenDescription() {
    	ST[] retVal = this.getTypedField(14, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Description (SPM-14).
     */
    public ST[] getSpm14_SpecimenDescription() {
    	ST[] retVal = this.getTypedField(14, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Description (SPM-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenDescriptionReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * SPM-14: "Specimen Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getSpecimenDescription(int rep) { 
		ST retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-14: "Specimen Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getSpm14_SpecimenDescription(int rep) { 
		ST retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Description (SPM-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm14_SpecimenDescriptionReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * SPM-14: "Specimen Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertSpecimenDescription(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-14: "Specimen Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertSpm14_SpecimenDescription(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * SPM-14: "Specimen Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeSpecimenDescription(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * SPM-14: "Specimen Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeSpm14_SpecimenDescription(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of Specimen Handling Code (SPM-15).
     */
    public CWE[] getSpecimenHandlingCode() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Handling Code (SPM-15).
     */
    public CWE[] getSpm15_SpecimenHandlingCode() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Handling Code (SPM-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenHandlingCodeReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * SPM-15: "Specimen Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-15: "Specimen Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm15_SpecimenHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Handling Code (SPM-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm15_SpecimenHandlingCodeReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * SPM-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm15_SpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * SPM-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * SPM-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm15_SpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }



    /**
     * Returns all repetitions of Specimen Risk Code (SPM-16).
     */
    public CWE[] getSpecimenRiskCode() {
    	CWE[] retVal = this.getTypedField(16, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Risk Code (SPM-16).
     */
    public CWE[] getSpm16_SpecimenRiskCode() {
    	CWE[] retVal = this.getTypedField(16, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Risk Code (SPM-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenRiskCodeReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * SPM-16: "Specimen Risk Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenRiskCode(int rep) { 
		CWE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-16: "Specimen Risk Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm16_SpecimenRiskCode(int rep) { 
		CWE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Risk Code (SPM-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm16_SpecimenRiskCodeReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * SPM-16: "Specimen Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-16: "Specimen Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm16_SpecimenRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * SPM-16: "Specimen Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * SPM-16: "Specimen Risk Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm16_SpecimenRiskCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * SPM-17: "Specimen Collection Date/Time" - creates it if necessary
     */
    public DR getSpecimenCollectionDateTime() { 
		DR retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-17: "Specimen Collection Date/Time" - creates it if necessary
     */
    public DR getSpm17_SpecimenCollectionDateTime() { 
		DR retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-18: "Specimen Received Date/Time" - creates it if necessary
     */
    public DTM getSpecimenReceivedDateTime() { 
		DTM retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-18: "Specimen Received Date/Time" - creates it if necessary
     */
    public DTM getSpm18_SpecimenReceivedDateTime() { 
		DTM retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-19: "Specimen Expiration Date/Time" - creates it if necessary
     */
    public DTM getSpecimenExpirationDateTime() { 
		DTM retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-19: "Specimen Expiration Date/Time" - creates it if necessary
     */
    public DTM getSpm19_SpecimenExpirationDateTime() { 
		DTM retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-20: "Specimen Availability" - creates it if necessary
     */
    public ID getSpecimenAvailability() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-20: "Specimen Availability" - creates it if necessary
     */
    public ID getSpm20_SpecimenAvailability() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Reject Reason (SPM-21).
     */
    public CWE[] getSpecimenRejectReason() {
    	CWE[] retVal = this.getTypedField(21, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Reject Reason (SPM-21).
     */
    public CWE[] getSpm21_SpecimenRejectReason() {
    	CWE[] retVal = this.getTypedField(21, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Reject Reason (SPM-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenRejectReasonReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * SPM-21: "Specimen Reject Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenRejectReason(int rep) { 
		CWE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-21: "Specimen Reject Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm21_SpecimenRejectReason(int rep) { 
		CWE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Reject Reason (SPM-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm21_SpecimenRejectReasonReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * SPM-21: "Specimen Reject Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenRejectReason(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-21: "Specimen Reject Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm21_SpecimenRejectReason(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * SPM-21: "Specimen Reject Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenRejectReason(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * SPM-21: "Specimen Reject Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm21_SpecimenRejectReason(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * SPM-22: "Specimen Quality" - creates it if necessary
     */
    public CWE getSpecimenQuality() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-22: "Specimen Quality" - creates it if necessary
     */
    public CWE getSpm22_SpecimenQuality() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-23: "Specimen Appropriateness" - creates it if necessary
     */
    public CWE getSpecimenAppropriateness() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-23: "Specimen Appropriateness" - creates it if necessary
     */
    public CWE getSpm23_SpecimenAppropriateness() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Condition (SPM-24).
     */
    public CWE[] getSpecimenCondition() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Condition (SPM-24).
     */
    public CWE[] getSpm24_SpecimenCondition() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Condition (SPM-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenConditionReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * SPM-24: "Specimen Condition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenCondition(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-24: "Specimen Condition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpm24_SpecimenCondition(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Condition (SPM-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm24_SpecimenConditionReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * SPM-24: "Specimen Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenCondition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-24: "Specimen Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpm24_SpecimenCondition(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * SPM-24: "Specimen Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenCondition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * SPM-24: "Specimen Condition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpm24_SpecimenCondition(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * SPM-25: "Specimen Current Quantity" - creates it if necessary
     */
    public CQ getSpecimenCurrentQuantity() { 
		CQ retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-25: "Specimen Current Quantity" - creates it if necessary
     */
    public CQ getSpm25_SpecimenCurrentQuantity() { 
		CQ retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-26: "Number of Specimen Containers" - creates it if necessary
     */
    public NM getNumberOfSpecimenContainers() { 
		NM retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-26: "Number of Specimen Containers" - creates it if necessary
     */
    public NM getSpm26_NumberOfSpecimenContainers() { 
		NM retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-27: "Container Type" - creates it if necessary
     */
    public CWE getContainerType() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-27: "Container Type" - creates it if necessary
     */
    public CWE getSpm27_ContainerType() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-28: "Container Condition" - creates it if necessary
     */
    public CWE getContainerCondition() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-28: "Container Condition" - creates it if necessary
     */
    public CWE getSpm28_ContainerCondition() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * SPM-29: "Specimen Child Role" - creates it if necessary
     */
    public CWE getSpecimenChildRole() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-29: "Specimen Child Role" - creates it if necessary
     */
    public CWE getSpm29_SpecimenChildRole() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Accession ID (SPM-30).
     */
    public CX[] getAccessionID() {
    	CX[] retVal = this.getTypedField(30, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Accession ID (SPM-30).
     */
    public CX[] getSpm30_AccessionID() {
    	CX[] retVal = this.getTypedField(30, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Accession ID (SPM-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAccessionIDReps() {
    	return this.getReps(30);
    }


    /**
     * Returns a specific repetition of
     * SPM-30: "Accession ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getAccessionID(int rep) { 
		CX retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-30: "Accession ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getSpm30_AccessionID(int rep) { 
		CX retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Accession ID (SPM-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm30_AccessionIDReps() {
    	return this.getReps(30);
    }


    /**
     * Inserts a repetition of
     * SPM-30: "Accession ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertAccessionID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(30, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-30: "Accession ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertSpm30_AccessionID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * SPM-30: "Accession ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeAccessionID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * SPM-30: "Accession ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeSpm30_AccessionID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(30, rep);
    }



    /**
     * Returns all repetitions of Other Specimen ID (SPM-31).
     */
    public CX[] getOtherSpecimenID() {
    	CX[] retVal = this.getTypedField(31, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Specimen ID (SPM-31).
     */
    public CX[] getSpm31_OtherSpecimenID() {
    	CX[] retVal = this.getTypedField(31, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Specimen ID (SPM-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherSpecimenIDReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * SPM-31: "Other Specimen ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getOtherSpecimenID(int rep) { 
		CX retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SPM-31: "Other Specimen ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getSpm31_OtherSpecimenID(int rep) { 
		CX retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Specimen ID (SPM-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpm31_OtherSpecimenIDReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * SPM-31: "Other Specimen ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertOtherSpecimenID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * SPM-31: "Other Specimen ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertSpm31_OtherSpecimenID(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * SPM-31: "Other Specimen ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeOtherSpecimenID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * SPM-31: "Other Specimen ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeSpm31_OtherSpecimenID(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(31, rep);
    }




    /**
     * Returns
     * SPM-32: "Shipment ID" - creates it if necessary
     */
    public EI getShipmentID() { 
		EI retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SPM-32: "Shipment ID" - creates it if necessary
     */
    public EI getSpm32_ShipmentID() { 
		EI retVal = this.getTypedField(32, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EIP(getMessage());
          case 2: return new EIP(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new CQ(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new DR(getMessage());
          case 17: return new DTM(getMessage());
          case 18: return new DTM(getMessage());
          case 19: return new ID(getMessage(), new Integer( 136 ));
          case 20: return new CWE(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new CWE(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new CQ(getMessage());
          case 25: return new NM(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new CWE(getMessage());
          case 29: return new CX(getMessage());
          case 30: return new CX(getMessage());
          case 31: return new EI(getMessage());
          default: return null;
       }
   }


}

