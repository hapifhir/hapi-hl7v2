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
 *<p>Represents an HL7 OM4 message segment (Observations that Require Specimens). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM4-1: Sequence Number - Test/Observation Master File (NM) <b>optional </b>
     * <li>OM4-2: Derived Specimen (ID) <b>optional </b>
     * <li>OM4-3: Container Description (TX) <b>optional repeating</b>
     * <li>OM4-4: Container Volume (NM) <b>optional repeating</b>
     * <li>OM4-5: Container Units (CWE) <b>optional repeating</b>
     * <li>OM4-6: Specimen (CWE) <b>optional </b>
     * <li>OM4-7: Additive (CWE) <b>optional </b>
     * <li>OM4-8: Preparation (TX) <b>optional </b>
     * <li>OM4-9: Special Handling Requirements (TX) <b>optional </b>
     * <li>OM4-10: Normal Collection Volume (CQ) <b>optional </b>
     * <li>OM4-11: Minimum Collection Volume (CQ) <b>optional </b>
     * <li>OM4-12: Specimen Requirements (TX) <b>optional </b>
     * <li>OM4-13: Specimen Priorities (ID) <b>optional repeating</b>
     * <li>OM4-14: Specimen Retention Time (CQ) <b>optional </b>
     * <li>OM4-15: Specimen Handling Code (CWE) <b>optional repeating</b>
     * <li>OM4-16: Specimen Preference (ID) <b>optional </b>
     * <li>OM4-17: Preferred Specimen/Attribture Sequence ID (NM) <b>optional </b>
     * <li>OM4-18: Taxonomic Classification Code (CWE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OM4 extends AbstractSegment {

    /** 
     * Creates a new OM4 segment
     */
    public OM4(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Sequence Number - Test/Observation Master File");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(170) }, "Derived Specimen");
                                  this.add(TX.class, false, 0, 60, new Object[]{ getMessage() }, "Container Description");
                                  this.add(NM.class, false, 0, 0, new Object[]{ getMessage() }, "Container Volume");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Container Units");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Additive");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Preparation");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Special Handling Requirements");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Normal Collection Volume");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Minimum Collection Volume");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Requirements");
                                              this.add(ID.class, false, 0, 1, new Object[]{ getMessage(), new Integer(27) }, "Specimen Priorities");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Specimen Retention Time");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Specimen Handling Code");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(920) }, "Specimen Preference");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Preferred Specimen/Attribture Sequence ID");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Taxonomic Classification Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM4 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM4-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getOm41_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-2: "Derived Specimen" - creates it if necessary
     */
    public ID getDerivedSpecimen() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-2: "Derived Specimen" - creates it if necessary
     */
    public ID getOm42_DerivedSpecimen() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Container Description (OM4-3).
     */
    public TX[] getContainerDescription() {
    	TX[] retVal = this.getTypedField(3, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Container Description (OM4-3).
     */
    public TX[] getOm43_ContainerDescription() {
    	TX[] retVal = this.getTypedField(3, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Container Description (OM4-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContainerDescriptionReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * OM4-3: "Container Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getContainerDescription(int rep) { 
		TX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM4-3: "Container Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getOm43_ContainerDescription(int rep) { 
		TX retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Container Description (OM4-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm43_ContainerDescriptionReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * OM4-3: "Container Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertContainerDescription(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * OM4-3: "Container Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertOm43_ContainerDescription(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM4-3: "Container Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeContainerDescription(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM4-3: "Container Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeOm43_ContainerDescription(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Container Volume (OM4-4).
     */
    public NM[] getContainerVolume() {
    	NM[] retVal = this.getTypedField(4, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Container Volume (OM4-4).
     */
    public NM[] getOm44_ContainerVolume() {
    	NM[] retVal = this.getTypedField(4, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Container Volume (OM4-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContainerVolumeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * OM4-4: "Container Volume" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getContainerVolume(int rep) { 
		NM retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM4-4: "Container Volume" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getOm44_ContainerVolume(int rep) { 
		NM retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Container Volume (OM4-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm44_ContainerVolumeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * OM4-4: "Container Volume" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertContainerVolume(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * OM4-4: "Container Volume" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertOm44_ContainerVolume(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM4-4: "Container Volume" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeContainerVolume(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM4-4: "Container Volume" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeOm44_ContainerVolume(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Container Units (OM4-5).
     */
    public CWE[] getContainerUnits() {
    	CWE[] retVal = this.getTypedField(5, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Container Units (OM4-5).
     */
    public CWE[] getOm45_ContainerUnits() {
    	CWE[] retVal = this.getTypedField(5, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Container Units (OM4-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContainerUnitsReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * OM4-5: "Container Units" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getContainerUnits(int rep) { 
		CWE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM4-5: "Container Units" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm45_ContainerUnits(int rep) { 
		CWE retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Container Units (OM4-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm45_ContainerUnitsReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * OM4-5: "Container Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertContainerUnits(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * OM4-5: "Container Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm45_ContainerUnits(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM4-5: "Container Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeContainerUnits(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM4-5: "Container Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm45_ContainerUnits(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * OM4-6: "Specimen" - creates it if necessary
     */
    public CWE getSpecimen() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-6: "Specimen" - creates it if necessary
     */
    public CWE getOm46_Specimen() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-7: "Additive" - creates it if necessary
     */
    public CWE getAdditive() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-7: "Additive" - creates it if necessary
     */
    public CWE getOm47_Additive() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-8: "Preparation" - creates it if necessary
     */
    public TX getPreparation() { 
		TX retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-8: "Preparation" - creates it if necessary
     */
    public TX getOm48_Preparation() { 
		TX retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-9: "Special Handling Requirements" - creates it if necessary
     */
    public TX getSpecialHandlingRequirements() { 
		TX retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-9: "Special Handling Requirements" - creates it if necessary
     */
    public TX getOm49_SpecialHandlingRequirements() { 
		TX retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-10: "Normal Collection Volume" - creates it if necessary
     */
    public CQ getNormalCollectionVolume() { 
		CQ retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-10: "Normal Collection Volume" - creates it if necessary
     */
    public CQ getOm410_NormalCollectionVolume() { 
		CQ retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-11: "Minimum Collection Volume" - creates it if necessary
     */
    public CQ getMinimumCollectionVolume() { 
		CQ retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-11: "Minimum Collection Volume" - creates it if necessary
     */
    public CQ getOm411_MinimumCollectionVolume() { 
		CQ retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-12: "Specimen Requirements" - creates it if necessary
     */
    public TX getSpecimenRequirements() { 
		TX retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-12: "Specimen Requirements" - creates it if necessary
     */
    public TX getOm412_SpecimenRequirements() { 
		TX retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Priorities (OM4-13).
     */
    public ID[] getSpecimenPriorities() {
    	ID[] retVal = this.getTypedField(13, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Priorities (OM4-13).
     */
    public ID[] getOm413_SpecimenPriorities() {
    	ID[] retVal = this.getTypedField(13, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Priorities (OM4-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenPrioritiesReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * OM4-13: "Specimen Priorities" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getSpecimenPriorities(int rep) { 
		ID retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM4-13: "Specimen Priorities" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOm413_SpecimenPriorities(int rep) { 
		ID retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Priorities (OM4-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm413_SpecimenPrioritiesReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * OM4-13: "Specimen Priorities" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertSpecimenPriorities(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * OM4-13: "Specimen Priorities" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOm413_SpecimenPriorities(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OM4-13: "Specimen Priorities" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeSpecimenPriorities(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OM4-13: "Specimen Priorities" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOm413_SpecimenPriorities(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * OM4-14: "Specimen Retention Time" - creates it if necessary
     */
    public CQ getSpecimenRetentionTime() { 
		CQ retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-14: "Specimen Retention Time" - creates it if necessary
     */
    public CQ getOm414_SpecimenRetentionTime() { 
		CQ retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specimen Handling Code (OM4-15).
     */
    public CWE[] getSpecimenHandlingCode() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specimen Handling Code (OM4-15).
     */
    public CWE[] getOm415_SpecimenHandlingCode() {
    	CWE[] retVal = this.getTypedField(15, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specimen Handling Code (OM4-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecimenHandlingCodeReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * OM4-15: "Specimen Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecimenHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM4-15: "Specimen Handling Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm415_SpecimenHandlingCode(int rep) { 
		CWE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specimen Handling Code (OM4-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm415_SpecimenHandlingCodeReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * OM4-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * OM4-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm415_SpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * OM4-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * OM4-15: "Specimen Handling Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm415_SpecimenHandlingCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * OM4-16: "Specimen Preference" - creates it if necessary
     */
    public ID getSpecimenPreference() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-16: "Specimen Preference" - creates it if necessary
     */
    public ID getOm416_SpecimenPreference() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * OM4-17: "Preferred Specimen/Attribture Sequence ID" - creates it if necessary
     */
    public NM getPreferredSpecimenAttribtureSequenceID() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM4-17: "Preferred Specimen/Attribture Sequence ID" - creates it if necessary
     */
    public NM getOm417_PreferredSpecimenAttribtureSequenceID() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Taxonomic Classification Code (OM4-18).
     */
    public CWE[] getTaxonomicClassificationCode() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Taxonomic Classification Code (OM4-18).
     */
    public CWE[] getOm418_TaxonomicClassificationCode() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Taxonomic Classification Code (OM4-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTaxonomicClassificationCodeReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * OM4-18: "Taxonomic Classification Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getTaxonomicClassificationCode(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM4-18: "Taxonomic Classification Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm418_TaxonomicClassificationCode(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Taxonomic Classification Code (OM4-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm418_TaxonomicClassificationCodeReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * OM4-18: "Taxonomic Classification Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertTaxonomicClassificationCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * OM4-18: "Taxonomic Classification Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm418_TaxonomicClassificationCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * OM4-18: "Taxonomic Classification Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeTaxonomicClassificationCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * OM4-18: "Taxonomic Classification Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm418_TaxonomicClassificationCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new ID(getMessage(), new Integer( 170 ));
          case 2: return new TX(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new TX(getMessage());
          case 8: return new TX(getMessage());
          case 9: return new CQ(getMessage());
          case 10: return new CQ(getMessage());
          case 11: return new TX(getMessage());
          case 12: return new ID(getMessage(), new Integer( 27 ));
          case 13: return new CQ(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new ID(getMessage(), new Integer( 920 ));
          case 16: return new NM(getMessage());
          case 17: return new CWE(getMessage());
          default: return null;
       }
   }


}

