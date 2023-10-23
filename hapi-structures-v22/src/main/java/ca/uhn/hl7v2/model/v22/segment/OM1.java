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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 OM1 message segment (GENERAL - fields that apply to most observations). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM1-1: Segment Type ID (ST) <b>optional </b>
     * <li>OM1-2: Sequence Number - Test/ Observation Master File (NM) <b>optional </b>
     * <li>OM1-3: Producer's test / observation ID (CE) <b> </b>
     * <li>OM1-4: Permitted Data Types (ID) <b>optional repeating</b>
     * <li>OM1-5: Specimen Required (ID) <b> </b>
     * <li>OM1-6: Producer ID (CE) <b> </b>
     * <li>OM1-7: Observation Description (TX) <b>optional </b>
     * <li>OM1-8: Other test / observation IDs for the observation (CE) <b>optional </b>
     * <li>OM1-9: Other Names (ST) <b> repeating</b>
     * <li>OM1-10: Preferred Report Name for the Observation (ST) <b>optional </b>
     * <li>OM1-11: Preferred Short Name or Mnemonic for Observation (ST) <b>optional </b>
     * <li>OM1-12: Preferred Long Name for the Observation (ST) <b>optional </b>
     * <li>OM1-13: Orderability (ID) <b>optional </b>
     * <li>OM1-14: Identity of instrument used to perform this study (CE) <b>optional repeating</b>
     * <li>OM1-15: Coded Representation of Method (CE) <b>optional repeating</b>
     * <li>OM1-16: Portable (ID) <b>optional </b>
     * <li>OM1-17: Observation producing department / section (ID) <b>optional repeating</b>
     * <li>OM1-18: Telephone Number of Section (TN) <b>optional </b>
     * <li>OM1-19: Nature of test / observation (ID) <b> </b>
     * <li>OM1-20: Report Subheader (CE) <b>optional </b>
     * <li>OM1-21: Report Display Order (ST) <b>optional </b>
     * <li>OM1-22: Date / time stamp for any change in definition for obs (TS) <b> </b>
     * <li>OM1-23: Effective date / time of change (TS) <b>optional </b>
     * <li>OM1-24: Typical Turn-around Time (NM) <b>optional </b>
     * <li>OM1-25: Processing Time (NM) <b>optional </b>
     * <li>OM1-26: Processing Priority (ID) <b>optional repeating</b>
     * <li>OM1-27: Reporting Priority (ID) <b>optional </b>
     * <li>OM1-28: Outside Site(s) Where Observation may be Performed (CE) <b>optional repeating</b>
     * <li>OM1-29: Address of Outside Site(s) (AD) <b>optional repeating</b>
     * <li>OM1-30: Phone Number of Outside Site (TN) <b>optional repeating</b>
     * <li>OM1-31: Confidentiality Code (ID) <b>optional </b>
     * <li>OM1-32: Observations required to interpret the observation (CE) <b>optional repeating</b>
     * <li>OM1-33: Interpretation of Observations (TX) <b>optional </b>
     * <li>OM1-34: Contraindications to Observations (CE) <b>optional repeating</b>
     * <li>OM1-35: Reflex tests / observations (CE) <b>optional repeating</b>
     * <li>OM1-36: Rules that Trigger Reflex Testing (ST) <b>optional </b>
     * <li>OM1-37: Fixed Canned Message (CE) <b>optional repeating</b>
     * <li>OM1-38: Patient Preparation (TX) <b>optional </b>
     * <li>OM1-39: Procedure Medication (CE) <b>optional </b>
     * <li>OM1-40: Factors that may affect the observation (TX) <b>optional </b>
     * <li>OM1-41: Test / observation performance schedule (ST) <b>optional repeating</b>
     * <li>OM1-42: Description of Test Methods (TX) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OM1 extends AbstractSegment {

    /** 
     * Creates a new OM1 segment
     */
    public OM1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "Segment Type ID");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/ Observation Master File");
                                  this.add(CE.class, true, 1, 200, new Object[]{ getMessage() }, "Producer's test / observation ID");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(125) }, "Permitted Data Types");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Specimen Required");
                                  this.add(CE.class, true, 1, 200, new Object[]{ getMessage() }, "Producer ID");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Observation Description");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Other test / observation IDs for the observation");
                                  this.add(ST.class, true, 0, 200, new Object[]{ getMessage() }, "Other Names");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Preferred Report Name for the Observation");
                                  this.add(ST.class, false, 1, 8, new Object[]{ getMessage() }, "Preferred Short Name or Mnemonic for Observation");
                                  this.add(ST.class, false, 1, 200, new Object[]{ getMessage() }, "Preferred Long Name for the Observation");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Orderability");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Identity of instrument used to perform this study");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Coded Representation of Method");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Portable");
                                              this.add(ID.class, false, 0, 1, new Object[]{ getMessage(), new Integer(0) }, "Observation producing department / section");
                                  this.add(TN.class, false, 1, 40, new Object[]{ getMessage() }, "Telephone Number of Section");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(174) }, "Nature of test / observation");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Report Subheader");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Report Display Order");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date / time stamp for any change in definition for obs");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective date / time of change");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Typical Turn-around Time");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Processing Time");
                                              this.add(ID.class, false, 0, 40, new Object[]{ getMessage(), new Integer(168) }, "Processing Priority");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(169) }, "Reporting Priority");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Outside Site(s) Where Observation may be Performed");
                                  this.add(AD.class, false, 0, 1000, new Object[]{ getMessage() }, "Address of Outside Site(s)");
                                  this.add(TN.class, false, 0, 400, new Object[]{ getMessage() }, "Phone Number of Outside Site");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(177) }, "Confidentiality Code");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Observations required to interpret the observation");
                                  this.add(TX.class, false, 1, 65536, new Object[]{ getMessage() }, "Interpretation of Observations");
                                  this.add(CE.class, false, 0, 65536, new Object[]{ getMessage() }, "Contraindications to Observations");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Reflex tests / observations");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Rules that Trigger Reflex Testing");
                                  this.add(CE.class, false, 0, 65536, new Object[]{ getMessage() }, "Fixed Canned Message");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Patient Preparation");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Procedure Medication");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Factors that may affect the observation");
                                  this.add(ST.class, false, 0, 60, new Object[]{ getMessage() }, "Test / observation performance schedule");
                                  this.add(TX.class, false, 1, 65536, new Object[]{ getMessage() }, "Description of Test Methods");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM1-1: "Segment Type ID" - creates it if necessary
     */
    public ST getSegmentTypeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-1: "Segment Type ID" - creates it if necessary
     */
    public ST getOm11_SegmentTypeID() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-2: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-2: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getOm12_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-3: "Producer's test / observation ID" - creates it if necessary
     */
    public CE getProducerSTestObservationID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-3: "Producer's test / observation ID" - creates it if necessary
     */
    public CE getOm13_ProducerSTestObservationID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Permitted Data Types (OM1-4).
     */
    public ID[] getPermittedDataTypes() {
    	ID[] retVal = this.getTypedField(4, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Permitted Data Types (OM1-4).
     */
    public ID[] getOm14_PermittedDataTypes() {
    	ID[] retVal = this.getTypedField(4, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Permitted Data Types (OM1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPermittedDataTypesReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * OM1-4: "Permitted Data Types" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPermittedDataTypes(int rep) { 
		ID retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-4: "Permitted Data Types" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOm14_PermittedDataTypes(int rep) { 
		ID retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Permitted Data Types (OM1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm14_PermittedDataTypesReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * OM1-4: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-4: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOm14_PermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM1-4: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * OM1-4: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOm14_PermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * OM1-5: "Specimen Required" - creates it if necessary
     */
    public ID getSpecimenRequired() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-5: "Specimen Required" - creates it if necessary
     */
    public ID getOm15_SpecimenRequired() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-6: "Producer ID" - creates it if necessary
     */
    public CE getProducerID() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-6: "Producer ID" - creates it if necessary
     */
    public CE getOm16_ProducerID() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-7: "Observation Description" - creates it if necessary
     */
    public TX getObservationDescription() { 
		TX retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-7: "Observation Description" - creates it if necessary
     */
    public TX getOm17_ObservationDescription() { 
		TX retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-8: "Other test / observation IDs for the observation" - creates it if necessary
     */
    public CE getOtherTestObservationIDsForTheObservation() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-8: "Other test / observation IDs for the observation" - creates it if necessary
     */
    public CE getOm18_OtherTestObservationIDsForTheObservation() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Other Names (OM1-9).
     */
    public ST[] getOtherNames() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Names (OM1-9).
     */
    public ST[] getOm19_OtherNames() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Names (OM1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherNamesReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * OM1-9: "Other Names" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOtherNames(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-9: "Other Names" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOm19_OtherNames(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Names (OM1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm19_OtherNamesReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * OM1-9: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOtherNames(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-9: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOm19_OtherNames(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * OM1-9: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOtherNames(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * OM1-9: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOm19_OtherNames(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * OM1-10: "Preferred Report Name for the Observation" - creates it if necessary
     */
    public ST getPreferredReportNameForTheObservation() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-10: "Preferred Report Name for the Observation" - creates it if necessary
     */
    public ST getOm110_PreferredReportNameForTheObservation() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-11: "Preferred Short Name or Mnemonic for Observation" - creates it if necessary
     */
    public ST getPreferredShortNameOrMnemonicForObservation() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-11: "Preferred Short Name or Mnemonic for Observation" - creates it if necessary
     */
    public ST getOm111_PreferredShortNameOrMnemonicForObservation() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-12: "Preferred Long Name for the Observation" - creates it if necessary
     */
    public ST getPreferredLongNameForTheObservation() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-12: "Preferred Long Name for the Observation" - creates it if necessary
     */
    public ST getOm112_PreferredLongNameForTheObservation() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-13: "Orderability" - creates it if necessary
     */
    public ID getOrderability() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-13: "Orderability" - creates it if necessary
     */
    public ID getOm113_Orderability() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Identity of instrument used to perform this study (OM1-14).
     */
    public CE[] getIdentityOfInstrumentUsedToPerformThisStudy() {
    	CE[] retVal = this.getTypedField(14, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Identity of instrument used to perform this study (OM1-14).
     */
    public CE[] getOm114_IdentityOfInstrumentUsedToPerformThisStudy() {
    	CE[] retVal = this.getTypedField(14, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Identity of instrument used to perform this study (OM1-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIdentityOfInstrumentUsedToPerformThisStudyReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * OM1-14: "Identity of instrument used to perform this study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIdentityOfInstrumentUsedToPerformThisStudy(int rep) { 
		CE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-14: "Identity of instrument used to perform this study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm114_IdentityOfInstrumentUsedToPerformThisStudy(int rep) { 
		CE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Identity of instrument used to perform this study (OM1-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm114_IdentityOfInstrumentUsedToPerformThisStudyReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * OM1-14: "Identity of instrument used to perform this study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-14: "Identity of instrument used to perform this study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm114_IdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * OM1-14: "Identity of instrument used to perform this study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * OM1-14: "Identity of instrument used to perform this study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm114_IdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of Coded Representation of Method (OM1-15).
     */
    public CE[] getCodedRepresentationOfMethod() {
    	CE[] retVal = this.getTypedField(15, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Coded Representation of Method (OM1-15).
     */
    public CE[] getOm115_CodedRepresentationOfMethod() {
    	CE[] retVal = this.getTypedField(15, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Coded Representation of Method (OM1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCodedRepresentationOfMethodReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * OM1-15: "Coded Representation of Method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCodedRepresentationOfMethod(int rep) { 
		CE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-15: "Coded Representation of Method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm115_CodedRepresentationOfMethod(int rep) { 
		CE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Coded Representation of Method (OM1-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm115_CodedRepresentationOfMethodReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * OM1-15: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-15: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm115_CodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * OM1-15: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * OM1-15: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm115_CodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * OM1-16: "Portable" - creates it if necessary
     */
    public ID getPortable() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-16: "Portable" - creates it if necessary
     */
    public ID getOm116_Portable() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Observation producing department / section (OM1-17).
     */
    public ID[] getObservationProducingDepartmentSection() {
    	ID[] retVal = this.getTypedField(17, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Observation producing department / section (OM1-17).
     */
    public ID[] getOm117_ObservationProducingDepartmentSection() {
    	ID[] retVal = this.getTypedField(17, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Observation producing department / section (OM1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObservationProducingDepartmentSectionReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * OM1-17: "Observation producing department / section" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getObservationProducingDepartmentSection(int rep) { 
		ID retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-17: "Observation producing department / section" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOm117_ObservationProducingDepartmentSection(int rep) { 
		ID retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Observation producing department / section (OM1-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm117_ObservationProducingDepartmentSectionReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * OM1-17: "Observation producing department / section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-17: "Observation producing department / section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOm117_ObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OM1-17: "Observation producing department / section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OM1-17: "Observation producing department / section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOm117_ObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * OM1-18: "Telephone Number of Section" - creates it if necessary
     */
    public TN getTelephoneNumberOfSection() { 
		TN retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-18: "Telephone Number of Section" - creates it if necessary
     */
    public TN getOm118_TelephoneNumberOfSection() { 
		TN retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-19: "Nature of test / observation" - creates it if necessary
     */
    public ID getNatureOfTestObservation() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-19: "Nature of test / observation" - creates it if necessary
     */
    public ID getOm119_NatureOfTestObservation() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-20: "Report Subheader" - creates it if necessary
     */
    public CE getReportSubheader() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-20: "Report Subheader" - creates it if necessary
     */
    public CE getOm120_ReportSubheader() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-21: "Report Display Order" - creates it if necessary
     */
    public ST getReportDisplayOrder() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-21: "Report Display Order" - creates it if necessary
     */
    public ST getOm121_ReportDisplayOrder() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-22: "Date / time stamp for any change in definition for obs" - creates it if necessary
     */
    public TS getDateTimeStampForAnyChangeInDefinitionForObs() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-22: "Date / time stamp for any change in definition for obs" - creates it if necessary
     */
    public TS getOm122_DateTimeStampForAnyChangeInDefinitionForObs() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-23: "Effective date / time of change" - creates it if necessary
     */
    public TS getEffectiveDateTimeOfChange() { 
		TS retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-23: "Effective date / time of change" - creates it if necessary
     */
    public TS getOm123_EffectiveDateTimeOfChange() { 
		TS retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-24: "Typical Turn-around Time" - creates it if necessary
     */
    public NM getTypicalTurnAroundTime() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-24: "Typical Turn-around Time" - creates it if necessary
     */
    public NM getOm124_TypicalTurnAroundTime() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-25: "Processing Time" - creates it if necessary
     */
    public NM getProcessingTime() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-25: "Processing Time" - creates it if necessary
     */
    public NM getOm125_ProcessingTime() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Processing Priority (OM1-26).
     */
    public ID[] getProcessingPriority() {
    	ID[] retVal = this.getTypedField(26, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Processing Priority (OM1-26).
     */
    public ID[] getOm126_ProcessingPriority() {
    	ID[] retVal = this.getTypedField(26, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Processing Priority (OM1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcessingPriorityReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * OM1-26: "Processing Priority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getProcessingPriority(int rep) { 
		ID retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-26: "Processing Priority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOm126_ProcessingPriority(int rep) { 
		ID retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Processing Priority (OM1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm126_ProcessingPriorityReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * OM1-26: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-26: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOm126_ProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * OM1-26: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * OM1-26: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOm126_ProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(26, rep);
    }




    /**
     * Returns
     * OM1-27: "Reporting Priority" - creates it if necessary
     */
    public ID getReportingPriority() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-27: "Reporting Priority" - creates it if necessary
     */
    public ID getOm127_ReportingPriority() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Outside Site(s) Where Observation may be Performed (OM1-28).
     */
    public CE[] getOutsideSiteSWhereObservationMayBePerformed() {
    	CE[] retVal = this.getTypedField(28, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Outside Site(s) Where Observation may be Performed (OM1-28).
     */
    public CE[] getOm128_OutsideSiteSWhereObservationMayBePerformed() {
    	CE[] retVal = this.getTypedField(28, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Outside Site(s) Where Observation may be Performed (OM1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOutsideSiteSWhereObservationMayBePerformedReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * OM1-28: "Outside Site(s) Where Observation may be Performed" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOutsideSiteSWhereObservationMayBePerformed(int rep) { 
		CE retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-28: "Outside Site(s) Where Observation may be Performed" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm128_OutsideSiteSWhereObservationMayBePerformed(int rep) { 
		CE retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Outside Site(s) Where Observation may be Performed (OM1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm128_OutsideSiteSWhereObservationMayBePerformedReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * OM1-28: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-28: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm128_OutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OM1-28: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OM1-28: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm128_OutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(28, rep);
    }



    /**
     * Returns all repetitions of Address of Outside Site(s) (OM1-29).
     */
    public AD[] getAddressOfOutsideSiteS() {
    	AD[] retVal = this.getTypedField(29, new AD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Address of Outside Site(s) (OM1-29).
     */
    public AD[] getOm129_AddressOfOutsideSiteS() {
    	AD[] retVal = this.getTypedField(29, new AD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Address of Outside Site(s) (OM1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAddressOfOutsideSiteSReps() {
    	return this.getReps(29);
    }


    /**
     * Returns a specific repetition of
     * OM1-29: "Address of Outside Site(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public AD getAddressOfOutsideSiteS(int rep) { 
		AD retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-29: "Address of Outside Site(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public AD getOm129_AddressOfOutsideSiteS(int rep) { 
		AD retVal = this.getTypedField(29, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Address of Outside Site(s) (OM1-29).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm129_AddressOfOutsideSiteSReps() {
    	return this.getReps(29);
    }


    /**
     * Inserts a repetition of
     * OM1-29: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD insertAddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (AD) super.insertRepetition(29, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-29: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD insertOm129_AddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (AD) super.insertRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * OM1-29: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD removeAddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (AD) super.removeRepetition(29, rep);
    }


    /**
     * Removes a repetition of
     * OM1-29: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public AD removeOm129_AddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (AD) super.removeRepetition(29, rep);
    }



    /**
     * Returns all repetitions of Phone Number of Outside Site (OM1-30).
     */
    public TN[] getPhoneNumberOfOutsideSite() {
    	TN[] retVal = this.getTypedField(30, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phone Number of Outside Site (OM1-30).
     */
    public TN[] getOm130_PhoneNumberOfOutsideSite() {
    	TN[] retVal = this.getTypedField(30, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phone Number of Outside Site (OM1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhoneNumberOfOutsideSiteReps() {
    	return this.getReps(30);
    }


    /**
     * Returns a specific repetition of
     * OM1-30: "Phone Number of Outside Site" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPhoneNumberOfOutsideSite(int rep) { 
		TN retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-30: "Phone Number of Outside Site" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getOm130_PhoneNumberOfOutsideSite(int rep) { 
		TN retVal = this.getTypedField(30, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phone Number of Outside Site (OM1-30).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm130_PhoneNumberOfOutsideSiteReps() {
    	return this.getReps(30);
    }


    /**
     * Inserts a repetition of
     * OM1-30: "Phone Number of Outside Site" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPhoneNumberOfOutsideSite(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(30, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-30: "Phone Number of Outside Site" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertOm130_PhoneNumberOfOutsideSite(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * OM1-30: "Phone Number of Outside Site" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePhoneNumberOfOutsideSite(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(30, rep);
    }


    /**
     * Removes a repetition of
     * OM1-30: "Phone Number of Outside Site" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeOm130_PhoneNumberOfOutsideSite(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(30, rep);
    }




    /**
     * Returns
     * OM1-31: "Confidentiality Code" - creates it if necessary
     */
    public ID getConfidentialityCode() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-31: "Confidentiality Code" - creates it if necessary
     */
    public ID getOm131_ConfidentialityCode() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Observations required to interpret the observation (OM1-32).
     */
    public CE[] getObservationsRequiredToInterpretTheObservation() {
    	CE[] retVal = this.getTypedField(32, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Observations required to interpret the observation (OM1-32).
     */
    public CE[] getOm132_ObservationsRequiredToInterpretTheObservation() {
    	CE[] retVal = this.getTypedField(32, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Observations required to interpret the observation (OM1-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObservationsRequiredToInterpretTheObservationReps() {
    	return this.getReps(32);
    }


    /**
     * Returns a specific repetition of
     * OM1-32: "Observations required to interpret the observation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObservationsRequiredToInterpretTheObservation(int rep) { 
		CE retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-32: "Observations required to interpret the observation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm132_ObservationsRequiredToInterpretTheObservation(int rep) { 
		CE retVal = this.getTypedField(32, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Observations required to interpret the observation (OM1-32).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm132_ObservationsRequiredToInterpretTheObservationReps() {
    	return this.getReps(32);
    }


    /**
     * Inserts a repetition of
     * OM1-32: "Observations required to interpret the observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObservationsRequiredToInterpretTheObservation(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(32, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-32: "Observations required to interpret the observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm132_ObservationsRequiredToInterpretTheObservation(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * OM1-32: "Observations required to interpret the observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObservationsRequiredToInterpretTheObservation(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(32, rep);
    }


    /**
     * Removes a repetition of
     * OM1-32: "Observations required to interpret the observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm132_ObservationsRequiredToInterpretTheObservation(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(32, rep);
    }




    /**
     * Returns
     * OM1-33: "Interpretation of Observations" - creates it if necessary
     */
    public TX getInterpretationOfObservations() { 
		TX retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-33: "Interpretation of Observations" - creates it if necessary
     */
    public TX getOm133_InterpretationOfObservations() { 
		TX retVal = this.getTypedField(33, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contraindications to Observations (OM1-34).
     */
    public CE[] getContraindicationsToObservations() {
    	CE[] retVal = this.getTypedField(34, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contraindications to Observations (OM1-34).
     */
    public CE[] getOm134_ContraindicationsToObservations() {
    	CE[] retVal = this.getTypedField(34, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contraindications to Observations (OM1-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContraindicationsToObservationsReps() {
    	return this.getReps(34);
    }


    /**
     * Returns a specific repetition of
     * OM1-34: "Contraindications to Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getContraindicationsToObservations(int rep) { 
		CE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-34: "Contraindications to Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm134_ContraindicationsToObservations(int rep) { 
		CE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contraindications to Observations (OM1-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm134_ContraindicationsToObservationsReps() {
    	return this.getReps(34);
    }


    /**
     * Inserts a repetition of
     * OM1-34: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(34, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-34: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm134_ContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OM1-34: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OM1-34: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm134_ContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(34, rep);
    }



    /**
     * Returns all repetitions of Reflex tests / observations (OM1-35).
     */
    public CE[] getReflexTestsObservations() {
    	CE[] retVal = this.getTypedField(35, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reflex tests / observations (OM1-35).
     */
    public CE[] getOm135_ReflexTestsObservations() {
    	CE[] retVal = this.getTypedField(35, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Reflex tests / observations (OM1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReflexTestsObservationsReps() {
    	return this.getReps(35);
    }


    /**
     * Returns a specific repetition of
     * OM1-35: "Reflex tests / observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getReflexTestsObservations(int rep) { 
		CE retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-35: "Reflex tests / observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm135_ReflexTestsObservations(int rep) { 
		CE retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Reflex tests / observations (OM1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm135_ReflexTestsObservationsReps() {
    	return this.getReps(35);
    }


    /**
     * Inserts a repetition of
     * OM1-35: "Reflex tests / observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(35, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-35: "Reflex tests / observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm135_ReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OM1-35: "Reflex tests / observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OM1-35: "Reflex tests / observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm135_ReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(35, rep);
    }




    /**
     * Returns
     * OM1-36: "Rules that Trigger Reflex Testing" - creates it if necessary
     */
    public ST getRulesThatTriggerReflexTesting() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-36: "Rules that Trigger Reflex Testing" - creates it if necessary
     */
    public ST getOm136_RulesThatTriggerReflexTesting() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Fixed Canned Message (OM1-37).
     */
    public CE[] getFixedCannedMessage() {
    	CE[] retVal = this.getTypedField(37, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Fixed Canned Message (OM1-37).
     */
    public CE[] getOm137_FixedCannedMessage() {
    	CE[] retVal = this.getTypedField(37, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Fixed Canned Message (OM1-37).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFixedCannedMessageReps() {
    	return this.getReps(37);
    }


    /**
     * Returns a specific repetition of
     * OM1-37: "Fixed Canned Message" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getFixedCannedMessage(int rep) { 
		CE retVal = this.getTypedField(37, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-37: "Fixed Canned Message" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm137_FixedCannedMessage(int rep) { 
		CE retVal = this.getTypedField(37, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Fixed Canned Message (OM1-37).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm137_FixedCannedMessageReps() {
    	return this.getReps(37);
    }


    /**
     * Inserts a repetition of
     * OM1-37: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertFixedCannedMessage(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(37, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-37: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm137_FixedCannedMessage(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(37, rep);
    }


    /**
     * Removes a repetition of
     * OM1-37: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeFixedCannedMessage(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(37, rep);
    }


    /**
     * Removes a repetition of
     * OM1-37: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm137_FixedCannedMessage(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(37, rep);
    }




    /**
     * Returns
     * OM1-38: "Patient Preparation" - creates it if necessary
     */
    public TX getPatientPreparation() { 
		TX retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-38: "Patient Preparation" - creates it if necessary
     */
    public TX getOm138_PatientPreparation() { 
		TX retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-39: "Procedure Medication" - creates it if necessary
     */
    public CE getProcedureMedication() { 
		CE retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-39: "Procedure Medication" - creates it if necessary
     */
    public CE getOm139_ProcedureMedication() { 
		CE retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-40: "Factors that may affect the observation" - creates it if necessary
     */
    public TX getFactorsThatMayAffectTheObservation() { 
		TX retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-40: "Factors that may affect the observation" - creates it if necessary
     */
    public TX getOm140_FactorsThatMayAffectTheObservation() { 
		TX retVal = this.getTypedField(40, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Test / observation performance schedule (OM1-41).
     */
    public ST[] getTestObservationPerformanceSchedule() {
    	ST[] retVal = this.getTypedField(41, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Test / observation performance schedule (OM1-41).
     */
    public ST[] getOm141_TestObservationPerformanceSchedule() {
    	ST[] retVal = this.getTypedField(41, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Test / observation performance schedule (OM1-41).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTestObservationPerformanceScheduleReps() {
    	return this.getReps(41);
    }


    /**
     * Returns a specific repetition of
     * OM1-41: "Test / observation performance schedule" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getTestObservationPerformanceSchedule(int rep) { 
		ST retVal = this.getTypedField(41, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-41: "Test / observation performance schedule" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOm141_TestObservationPerformanceSchedule(int rep) { 
		ST retVal = this.getTypedField(41, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Test / observation performance schedule (OM1-41).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm141_TestObservationPerformanceScheduleReps() {
    	return this.getReps(41);
    }


    /**
     * Inserts a repetition of
     * OM1-41: "Test / observation performance schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertTestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(41, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-41: "Test / observation performance schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOm141_TestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(41, rep);
    }


    /**
     * Removes a repetition of
     * OM1-41: "Test / observation performance schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeTestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(41, rep);
    }


    /**
     * Removes a repetition of
     * OM1-41: "Test / observation performance schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOm141_TestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(41, rep);
    }




    /**
     * Returns
     * OM1-42: "Description of Test Methods" - creates it if necessary
     */
    public TX getDescriptionOfTestMethods() { 
		TX retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-42: "Description of Test Methods" - creates it if necessary
     */
    public TX getOm142_DescriptionOfTestMethods() { 
		TX retVal = this.getTypedField(42, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new ID(getMessage(), new Integer( 125 ));
          case 4: return new ID(getMessage(), new Integer( 136 ));
          case 5: return new CE(getMessage());
          case 6: return new TX(getMessage());
          case 7: return new CE(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new ID(getMessage(), new Integer( 136 ));
          case 13: return new CE(getMessage());
          case 14: return new CE(getMessage());
          case 15: return new ID(getMessage(), new Integer( 136 ));
          case 16: return new ID(getMessage(), new Integer( 0 ));
          case 17: return new TN(getMessage());
          case 18: return new ID(getMessage(), new Integer( 174 ));
          case 19: return new CE(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new TS(getMessage());
          case 22: return new TS(getMessage());
          case 23: return new NM(getMessage());
          case 24: return new NM(getMessage());
          case 25: return new ID(getMessage(), new Integer( 168 ));
          case 26: return new ID(getMessage(), new Integer( 169 ));
          case 27: return new CE(getMessage());
          case 28: return new AD(getMessage());
          case 29: return new TN(getMessage());
          case 30: return new ID(getMessage(), new Integer( 177 ));
          case 31: return new CE(getMessage());
          case 32: return new TX(getMessage());
          case 33: return new CE(getMessage());
          case 34: return new CE(getMessage());
          case 35: return new ST(getMessage());
          case 36: return new CE(getMessage());
          case 37: return new TX(getMessage());
          case 38: return new CE(getMessage());
          case 39: return new TX(getMessage());
          case 40: return new ST(getMessage());
          case 41: return new TX(getMessage());
          default: return null;
       }
   }


}

