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
 *<p>Represents an HL7 OM1 message segment (General Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM1-1: Sequence Number - Test/ Observation Master File (NM) <b> </b>
     * <li>OM1-2: Producer's Service/Test/Observation ID (CE) <b> </b>
     * <li>OM1-3: Permitted Data Types (ID) <b>optional repeating</b>
     * <li>OM1-4: Specimen Required (ID) <b> </b>
     * <li>OM1-5: Producer ID (CE) <b> </b>
     * <li>OM1-6: Observation Description (TX) <b>optional </b>
     * <li>OM1-7: Other Service/Test/Observation IDs for the Observation (CE) <b>optional </b>
     * <li>OM1-8: Other Names (ST) <b> repeating</b>
     * <li>OM1-9: Preferred Report Name for the Observation (ST) <b>optional </b>
     * <li>OM1-10: Preferred Short Name or Mnemonic for Observation (ST) <b>optional </b>
     * <li>OM1-11: Preferred Long Name for the Observation (ST) <b>optional </b>
     * <li>OM1-12: Orderability (ID) <b>optional </b>
     * <li>OM1-13: Identity of Instrument Used to Perform this Study (CE) <b>optional repeating</b>
     * <li>OM1-14: Coded Representation of Method (CE) <b>optional repeating</b>
     * <li>OM1-15: Portable Device Indicator (ID) <b>optional </b>
     * <li>OM1-16: Observation Producing Department/Section (CE) <b>optional repeating</b>
     * <li>OM1-17: Telephone Number of Section (XTN) <b>optional </b>
     * <li>OM1-18: Nature of Service/Test/Observation (IS) <b> </b>
     * <li>OM1-19: Report Subheader (CE) <b>optional </b>
     * <li>OM1-20: Report Display Order (ST) <b>optional </b>
     * <li>OM1-21: Date/Time Stamp for any change in Definition for the Observation (TS) <b>optional </b>
     * <li>OM1-22: Effective Date/Time of Change (TS) <b>optional </b>
     * <li>OM1-23: Typical Turn-Around Time (NM) <b>optional </b>
     * <li>OM1-24: Processing Time (NM) <b>optional </b>
     * <li>OM1-25: Processing Priority (ID) <b>optional repeating</b>
     * <li>OM1-26: Reporting Priority (ID) <b>optional </b>
     * <li>OM1-27: Outside Site(s) Where Observation may be Performed (CE) <b>optional repeating</b>
     * <li>OM1-28: Address of Outside Site(s) (XAD) <b>optional repeating</b>
     * <li>OM1-29: Phone Number of Outside Site (XTN) <b>optional </b>
     * <li>OM1-30: Confidentiality Code (IS) <b>optional </b>
     * <li>OM1-31: Observations Required to Interpret the Observation (CE) <b>optional </b>
     * <li>OM1-32: Interpretation of Observations (TX) <b>optional </b>
     * <li>OM1-33: Contraindications to Observations (CE) <b>optional </b>
     * <li>OM1-34: Reflex Tests/Observations (CE) <b>optional repeating</b>
     * <li>OM1-35: Rules that Trigger Reflex Testing (TX) <b>optional </b>
     * <li>OM1-36: Fixed Canned Message (CE) <b>optional </b>
     * <li>OM1-37: Patient Preparation (TX) <b>optional </b>
     * <li>OM1-38: Procedure Medication (CE) <b>optional </b>
     * <li>OM1-39: Factors that may Affect Affect the Observation (TX) <b>optional </b>
     * <li>OM1-40: Service/Test/Observation Performance Schedule (ST) <b>optional repeating</b>
     * <li>OM1-41: Description of Test Methods (TX) <b>optional </b>
     * <li>OM1-42: Kind of Quantity Observed (CE) <b>optional </b>
     * <li>OM1-43: Point Versus Interval (CE) <b>optional </b>
     * <li>OM1-44: Challenge Information (TX) <b>optional </b>
     * <li>OM1-45: Relationship Modifier (CE) <b>optional </b>
     * <li>OM1-46: Target Anatomic Site Of Test (CE) <b>optional </b>
     * <li>OM1-47: Modality Of Imaging Measurement (CE) <b>optional </b>
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
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/ Observation Master File");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Producer's Service/Test/Observation ID");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(125) }, "Permitted Data Types");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Specimen Required");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Producer ID");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Observation Description");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Other Service/Test/Observation IDs for the Observation");
                                  this.add(ST.class, true, 0, 200, new Object[]{ getMessage() }, "Other Names");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Preferred Report Name for the Observation");
                                  this.add(ST.class, false, 1, 8, new Object[]{ getMessage() }, "Preferred Short Name or Mnemonic for Observation");
                                  this.add(ST.class, false, 1, 200, new Object[]{ getMessage() }, "Preferred Long Name for the Observation");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Orderability");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Identity of Instrument Used to Perform this Study");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Coded Representation of Method");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Portable Device Indicator");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Observation Producing Department/Section");
                                  this.add(XTN.class, false, 1, 250, new Object[]{ getMessage() }, "Telephone Number of Section");
                                              this.add(IS.class, true, 1, 1, new Object[]{ getMessage(), new Integer(174) }, "Nature of Service/Test/Observation");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Report Subheader");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Report Display Order");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date/Time Stamp for any change in Definition for the Observation");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective Date/Time of Change");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Typical Turn-Around Time");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Processing Time");
                                              this.add(ID.class, false, 0, 40, new Object[]{ getMessage(), new Integer(168) }, "Processing Priority");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(169) }, "Reporting Priority");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Outside Site(s) Where Observation may be Performed");
                                  this.add(XAD.class, false, 0, 1000, new Object[]{ getMessage() }, "Address of Outside Site(s)");
                                  this.add(XTN.class, false, 1, 400, new Object[]{ getMessage() }, "Phone Number of Outside Site");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(177) }, "Confidentiality Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Observations Required to Interpret the Observation");
                                  this.add(TX.class, false, 1, 65536, new Object[]{ getMessage() }, "Interpretation of Observations");
                                  this.add(CE.class, false, 1, 65536, new Object[]{ getMessage() }, "Contraindications to Observations");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Reflex Tests/Observations");
                                  this.add(TX.class, false, 1, 80, new Object[]{ getMessage() }, "Rules that Trigger Reflex Testing");
                                  this.add(CE.class, false, 1, 65536, new Object[]{ getMessage() }, "Fixed Canned Message");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Patient Preparation");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Procedure Medication");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Factors that may Affect Affect the Observation");
                                  this.add(ST.class, false, 0, 60, new Object[]{ getMessage() }, "Service/Test/Observation Performance Schedule");
                                  this.add(TX.class, false, 1, 65536, new Object[]{ getMessage() }, "Description of Test Methods");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Kind of Quantity Observed");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Point Versus Interval");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Challenge Information");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Relationship Modifier");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Target Anatomic Site Of Test");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Modality Of Imaging Measurement");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM1-1: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-1: "Sequence Number - Test/ Observation Master File" - creates it if necessary
     */
    public NM getOm11_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-2: "Producer's Service/Test/Observation ID" - creates it if necessary
     */
    public CE getProducerSServiceTestObservationID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-2: "Producer's Service/Test/Observation ID" - creates it if necessary
     */
    public CE getOm12_ProducerSServiceTestObservationID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Permitted Data Types (OM1-3).
     */
    public ID[] getPermittedDataTypes() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Permitted Data Types (OM1-3).
     */
    public ID[] getOm13_PermittedDataTypes() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Permitted Data Types (OM1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPermittedDataTypesReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * OM1-3: "Permitted Data Types" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPermittedDataTypes(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-3: "Permitted Data Types" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOm13_PermittedDataTypes(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Permitted Data Types (OM1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm13_PermittedDataTypesReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * OM1-3: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-3: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOm13_PermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM1-3: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM1-3: "Permitted Data Types" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOm13_PermittedDataTypes(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * OM1-4: "Specimen Required" - creates it if necessary
     */
    public ID getSpecimenRequired() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-4: "Specimen Required" - creates it if necessary
     */
    public ID getOm14_SpecimenRequired() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-5: "Producer ID" - creates it if necessary
     */
    public CE getProducerID() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-5: "Producer ID" - creates it if necessary
     */
    public CE getOm15_ProducerID() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-6: "Observation Description" - creates it if necessary
     */
    public TX getObservationDescription() { 
		TX retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-6: "Observation Description" - creates it if necessary
     */
    public TX getOm16_ObservationDescription() { 
		TX retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" - creates it if necessary
     */
    public CE getOtherServiceTestObservationIDsForTheObservation() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" - creates it if necessary
     */
    public CE getOm17_OtherServiceTestObservationIDsForTheObservation() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Other Names (OM1-8).
     */
    public ST[] getOtherNames() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Names (OM1-8).
     */
    public ST[] getOm18_OtherNames() {
    	ST[] retVal = this.getTypedField(8, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Names (OM1-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherNamesReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * OM1-8: "Other Names" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOtherNames(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-8: "Other Names" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOm18_OtherNames(int rep) { 
		ST retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Names (OM1-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm18_OtherNamesReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * OM1-8: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOtherNames(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-8: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOm18_OtherNames(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * OM1-8: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOtherNames(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * OM1-8: "Other Names" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOm18_OtherNames(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * OM1-9: "Preferred Report Name for the Observation" - creates it if necessary
     */
    public ST getPreferredReportNameForTheObservation() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-9: "Preferred Report Name for the Observation" - creates it if necessary
     */
    public ST getOm19_PreferredReportNameForTheObservation() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-10: "Preferred Short Name or Mnemonic for Observation" - creates it if necessary
     */
    public ST getPreferredShortNameOrMnemonicForObservation() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-10: "Preferred Short Name or Mnemonic for Observation" - creates it if necessary
     */
    public ST getOm110_PreferredShortNameOrMnemonicForObservation() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-11: "Preferred Long Name for the Observation" - creates it if necessary
     */
    public ST getPreferredLongNameForTheObservation() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-11: "Preferred Long Name for the Observation" - creates it if necessary
     */
    public ST getOm111_PreferredLongNameForTheObservation() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-12: "Orderability" - creates it if necessary
     */
    public ID getOrderability() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-12: "Orderability" - creates it if necessary
     */
    public ID getOm112_Orderability() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Identity of Instrument Used to Perform this Study (OM1-13).
     */
    public CE[] getIdentityOfInstrumentUsedToPerformThisStudy() {
    	CE[] retVal = this.getTypedField(13, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Identity of Instrument Used to Perform this Study (OM1-13).
     */
    public CE[] getOm113_IdentityOfInstrumentUsedToPerformThisStudy() {
    	CE[] retVal = this.getTypedField(13, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Identity of Instrument Used to Perform this Study (OM1-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIdentityOfInstrumentUsedToPerformThisStudyReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIdentityOfInstrumentUsedToPerformThisStudy(int rep) { 
		CE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm113_IdentityOfInstrumentUsedToPerformThisStudy(int rep) { 
		CE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Identity of Instrument Used to Perform this Study (OM1-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm113_IdentityOfInstrumentUsedToPerformThisStudyReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm113_IdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm113_IdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Coded Representation of Method (OM1-14).
     */
    public CE[] getCodedRepresentationOfMethod() {
    	CE[] retVal = this.getTypedField(14, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Coded Representation of Method (OM1-14).
     */
    public CE[] getOm114_CodedRepresentationOfMethod() {
    	CE[] retVal = this.getTypedField(14, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Coded Representation of Method (OM1-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCodedRepresentationOfMethodReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * OM1-14: "Coded Representation of Method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCodedRepresentationOfMethod(int rep) { 
		CE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-14: "Coded Representation of Method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm114_CodedRepresentationOfMethod(int rep) { 
		CE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Coded Representation of Method (OM1-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm114_CodedRepresentationOfMethodReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm114_CodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm114_CodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * OM1-15: "Portable Device Indicator" - creates it if necessary
     */
    public ID getPortableDeviceIndicator() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-15: "Portable Device Indicator" - creates it if necessary
     */
    public ID getOm115_PortableDeviceIndicator() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Observation Producing Department/Section (OM1-16).
     */
    public CE[] getObservationProducingDepartmentSection() {
    	CE[] retVal = this.getTypedField(16, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Observation Producing Department/Section (OM1-16).
     */
    public CE[] getOm116_ObservationProducingDepartmentSection() {
    	CE[] retVal = this.getTypedField(16, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Observation Producing Department/Section (OM1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObservationProducingDepartmentSectionReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * OM1-16: "Observation Producing Department/Section" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObservationProducingDepartmentSection(int rep) { 
		CE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-16: "Observation Producing Department/Section" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm116_ObservationProducingDepartmentSection(int rep) { 
		CE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Observation Producing Department/Section (OM1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm116_ObservationProducingDepartmentSectionReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm116_ObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm116_ObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * OM1-17: "Telephone Number of Section" - creates it if necessary
     */
    public XTN getTelephoneNumberOfSection() { 
		XTN retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-17: "Telephone Number of Section" - creates it if necessary
     */
    public XTN getOm117_TelephoneNumberOfSection() { 
		XTN retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-18: "Nature of Service/Test/Observation" - creates it if necessary
     */
    public IS getNatureOfServiceTestObservation() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-18: "Nature of Service/Test/Observation" - creates it if necessary
     */
    public IS getOm118_NatureOfServiceTestObservation() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-19: "Report Subheader" - creates it if necessary
     */
    public CE getReportSubheader() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-19: "Report Subheader" - creates it if necessary
     */
    public CE getOm119_ReportSubheader() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-20: "Report Display Order" - creates it if necessary
     */
    public ST getReportDisplayOrder() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-20: "Report Display Order" - creates it if necessary
     */
    public ST getOm120_ReportDisplayOrder() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-21: "Date/Time Stamp for any change in Definition for the Observation" - creates it if necessary
     */
    public TS getDateTimeStampForAnyChangeInDefinitionForTheObservation() { 
		TS retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-21: "Date/Time Stamp for any change in Definition for the Observation" - creates it if necessary
     */
    public TS getOm121_DateTimeStampForAnyChangeInDefinitionForTheObservation() { 
		TS retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-22: "Effective Date/Time of Change" - creates it if necessary
     */
    public TS getEffectiveDateTimeOfChange() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-22: "Effective Date/Time of Change" - creates it if necessary
     */
    public TS getOm122_EffectiveDateTimeOfChange() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-23: "Typical Turn-Around Time" - creates it if necessary
     */
    public NM getTypicalTurnAroundTime() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-23: "Typical Turn-Around Time" - creates it if necessary
     */
    public NM getOm123_TypicalTurnAroundTime() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-24: "Processing Time" - creates it if necessary
     */
    public NM getProcessingTime() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-24: "Processing Time" - creates it if necessary
     */
    public NM getOm124_ProcessingTime() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Processing Priority (OM1-25).
     */
    public ID[] getProcessingPriority() {
    	ID[] retVal = this.getTypedField(25, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Processing Priority (OM1-25).
     */
    public ID[] getOm125_ProcessingPriority() {
    	ID[] retVal = this.getTypedField(25, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Processing Priority (OM1-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcessingPriorityReps() {
    	return this.getReps(25);
    }


    /**
     * Returns a specific repetition of
     * OM1-25: "Processing Priority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getProcessingPriority(int rep) { 
		ID retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-25: "Processing Priority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOm125_ProcessingPriority(int rep) { 
		ID retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Processing Priority (OM1-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm125_ProcessingPriorityReps() {
    	return this.getReps(25);
    }


    /**
     * Inserts a repetition of
     * OM1-25: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(25, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-25: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOm125_ProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * OM1-25: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * OM1-25: "Processing Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOm125_ProcessingPriority(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(25, rep);
    }




    /**
     * Returns
     * OM1-26: "Reporting Priority" - creates it if necessary
     */
    public ID getReportingPriority() { 
		ID retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-26: "Reporting Priority" - creates it if necessary
     */
    public ID getOm126_ReportingPriority() { 
		ID retVal = this.getTypedField(26, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Outside Site(s) Where Observation may be Performed (OM1-27).
     */
    public CE[] getOutsideSiteSWhereObservationMayBePerformed() {
    	CE[] retVal = this.getTypedField(27, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Outside Site(s) Where Observation may be Performed (OM1-27).
     */
    public CE[] getOm127_OutsideSiteSWhereObservationMayBePerformed() {
    	CE[] retVal = this.getTypedField(27, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Outside Site(s) Where Observation may be Performed (OM1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOutsideSiteSWhereObservationMayBePerformedReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * OM1-27: "Outside Site(s) Where Observation may be Performed" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOutsideSiteSWhereObservationMayBePerformed(int rep) { 
		CE retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-27: "Outside Site(s) Where Observation may be Performed" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm127_OutsideSiteSWhereObservationMayBePerformed(int rep) { 
		CE retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Outside Site(s) Where Observation may be Performed (OM1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm127_OutsideSiteSWhereObservationMayBePerformedReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * OM1-27: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-27: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm127_OutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OM1-27: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OM1-27: "Outside Site(s) Where Observation may be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm127_OutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(27, rep);
    }



    /**
     * Returns all repetitions of Address of Outside Site(s) (OM1-28).
     */
    public XAD[] getAddressOfOutsideSiteS() {
    	XAD[] retVal = this.getTypedField(28, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Address of Outside Site(s) (OM1-28).
     */
    public XAD[] getOm128_AddressOfOutsideSiteS() {
    	XAD[] retVal = this.getTypedField(28, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Address of Outside Site(s) (OM1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAddressOfOutsideSiteSReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * OM1-28: "Address of Outside Site(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getAddressOfOutsideSiteS(int rep) { 
		XAD retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-28: "Address of Outside Site(s)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getOm128_AddressOfOutsideSiteS(int rep) { 
		XAD retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Address of Outside Site(s) (OM1-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm128_AddressOfOutsideSiteSReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * OM1-28: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertAddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-28: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertOm128_AddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OM1-28: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeAddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OM1-28: "Address of Outside Site(s)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeOm128_AddressOfOutsideSiteS(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(28, rep);
    }




    /**
     * Returns
     * OM1-29: "Phone Number of Outside Site" - creates it if necessary
     */
    public XTN getPhoneNumberOfOutsideSite() { 
		XTN retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-29: "Phone Number of Outside Site" - creates it if necessary
     */
    public XTN getOm129_PhoneNumberOfOutsideSite() { 
		XTN retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-30: "Confidentiality Code" - creates it if necessary
     */
    public IS getConfidentialityCode() { 
		IS retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-30: "Confidentiality Code" - creates it if necessary
     */
    public IS getOm130_ConfidentialityCode() { 
		IS retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-31: "Observations Required to Interpret the Observation" - creates it if necessary
     */
    public CE getObservationsRequiredToInterpretTheObservation() { 
		CE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-31: "Observations Required to Interpret the Observation" - creates it if necessary
     */
    public CE getOm131_ObservationsRequiredToInterpretTheObservation() { 
		CE retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-32: "Interpretation of Observations" - creates it if necessary
     */
    public TX getInterpretationOfObservations() { 
		TX retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-32: "Interpretation of Observations" - creates it if necessary
     */
    public TX getOm132_InterpretationOfObservations() { 
		TX retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-33: "Contraindications to Observations" - creates it if necessary
     */
    public CE getContraindicationsToObservations() { 
		CE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-33: "Contraindications to Observations" - creates it if necessary
     */
    public CE getOm133_ContraindicationsToObservations() { 
		CE retVal = this.getTypedField(33, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Reflex Tests/Observations (OM1-34).
     */
    public CE[] getReflexTestsObservations() {
    	CE[] retVal = this.getTypedField(34, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reflex Tests/Observations (OM1-34).
     */
    public CE[] getOm134_ReflexTestsObservations() {
    	CE[] retVal = this.getTypedField(34, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Reflex Tests/Observations (OM1-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReflexTestsObservationsReps() {
    	return this.getReps(34);
    }


    /**
     * Returns a specific repetition of
     * OM1-34: "Reflex Tests/Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getReflexTestsObservations(int rep) { 
		CE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-34: "Reflex Tests/Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm134_ReflexTestsObservations(int rep) { 
		CE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Reflex Tests/Observations (OM1-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm134_ReflexTestsObservationsReps() {
    	return this.getReps(34);
    }


    /**
     * Inserts a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(34, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm134_ReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm134_ReflexTestsObservations(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(34, rep);
    }




    /**
     * Returns
     * OM1-35: "Rules that Trigger Reflex Testing" - creates it if necessary
     */
    public TX getRulesThatTriggerReflexTesting() { 
		TX retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-35: "Rules that Trigger Reflex Testing" - creates it if necessary
     */
    public TX getOm135_RulesThatTriggerReflexTesting() { 
		TX retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-36: "Fixed Canned Message" - creates it if necessary
     */
    public CE getFixedCannedMessage() { 
		CE retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-36: "Fixed Canned Message" - creates it if necessary
     */
    public CE getOm136_FixedCannedMessage() { 
		CE retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-37: "Patient Preparation" - creates it if necessary
     */
    public TX getPatientPreparation() { 
		TX retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-37: "Patient Preparation" - creates it if necessary
     */
    public TX getOm137_PatientPreparation() { 
		TX retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-38: "Procedure Medication" - creates it if necessary
     */
    public CE getProcedureMedication() { 
		CE retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-38: "Procedure Medication" - creates it if necessary
     */
    public CE getOm138_ProcedureMedication() { 
		CE retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-39: "Factors that may Affect Affect the Observation" - creates it if necessary
     */
    public TX getFactorsThatMayAffectAffectTheObservation() { 
		TX retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-39: "Factors that may Affect Affect the Observation" - creates it if necessary
     */
    public TX getOm139_FactorsThatMayAffectAffectTheObservation() { 
		TX retVal = this.getTypedField(39, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Service/Test/Observation Performance Schedule (OM1-40).
     */
    public ST[] getServiceTestObservationPerformanceSchedule() {
    	ST[] retVal = this.getTypedField(40, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Service/Test/Observation Performance Schedule (OM1-40).
     */
    public ST[] getOm140_ServiceTestObservationPerformanceSchedule() {
    	ST[] retVal = this.getTypedField(40, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Service/Test/Observation Performance Schedule (OM1-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getServiceTestObservationPerformanceScheduleReps() {
    	return this.getReps(40);
    }


    /**
     * Returns a specific repetition of
     * OM1-40: "Service/Test/Observation Performance Schedule" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getServiceTestObservationPerformanceSchedule(int rep) { 
		ST retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-40: "Service/Test/Observation Performance Schedule" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOm140_ServiceTestObservationPerformanceSchedule(int rep) { 
		ST retVal = this.getTypedField(40, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Service/Test/Observation Performance Schedule (OM1-40).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm140_ServiceTestObservationPerformanceScheduleReps() {
    	return this.getReps(40);
    }


    /**
     * Inserts a repetition of
     * OM1-40: "Service/Test/Observation Performance Schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertServiceTestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(40, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-40: "Service/Test/Observation Performance Schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOm140_ServiceTestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * OM1-40: "Service/Test/Observation Performance Schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeServiceTestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(40, rep);
    }


    /**
     * Removes a repetition of
     * OM1-40: "Service/Test/Observation Performance Schedule" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOm140_ServiceTestObservationPerformanceSchedule(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(40, rep);
    }




    /**
     * Returns
     * OM1-41: "Description of Test Methods" - creates it if necessary
     */
    public TX getDescriptionOfTestMethods() { 
		TX retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-41: "Description of Test Methods" - creates it if necessary
     */
    public TX getOm141_DescriptionOfTestMethods() { 
		TX retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-42: "Kind of Quantity Observed" - creates it if necessary
     */
    public CE getKindOfQuantityObserved() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-42: "Kind of Quantity Observed" - creates it if necessary
     */
    public CE getOm142_KindOfQuantityObserved() { 
		CE retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-43: "Point Versus Interval" - creates it if necessary
     */
    public CE getPointVersusInterval() { 
		CE retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-43: "Point Versus Interval" - creates it if necessary
     */
    public CE getOm143_PointVersusInterval() { 
		CE retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-44: "Challenge Information" - creates it if necessary
     */
    public TX getChallengeInformation() { 
		TX retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-44: "Challenge Information" - creates it if necessary
     */
    public TX getOm144_ChallengeInformation() { 
		TX retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-45: "Relationship Modifier" - creates it if necessary
     */
    public CE getRelationshipModifier() { 
		CE retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-45: "Relationship Modifier" - creates it if necessary
     */
    public CE getOm145_RelationshipModifier() { 
		CE retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-46: "Target Anatomic Site Of Test" - creates it if necessary
     */
    public CE getTargetAnatomicSiteOfTest() { 
		CE retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-46: "Target Anatomic Site Of Test" - creates it if necessary
     */
    public CE getOm146_TargetAnatomicSiteOfTest() { 
		CE retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-47: "Modality Of Imaging Measurement" - creates it if necessary
     */
    public CE getModalityOfImagingMeasurement() { 
		CE retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-47: "Modality Of Imaging Measurement" - creates it if necessary
     */
    public CE getOm147_ModalityOfImagingMeasurement() { 
		CE retVal = this.getTypedField(47, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ID(getMessage(), new Integer( 125 ));
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new CE(getMessage());
          case 5: return new TX(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          case 12: return new CE(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new ID(getMessage(), new Integer( 136 ));
          case 15: return new CE(getMessage());
          case 16: return new XTN(getMessage());
          case 17: return new IS(getMessage(), new Integer( 174 ));
          case 18: return new CE(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new TS(getMessage());
          case 21: return new TS(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new NM(getMessage());
          case 24: return new ID(getMessage(), new Integer( 168 ));
          case 25: return new ID(getMessage(), new Integer( 169 ));
          case 26: return new CE(getMessage());
          case 27: return new XAD(getMessage());
          case 28: return new XTN(getMessage());
          case 29: return new IS(getMessage(), new Integer( 177 ));
          case 30: return new CE(getMessage());
          case 31: return new TX(getMessage());
          case 32: return new CE(getMessage());
          case 33: return new CE(getMessage());
          case 34: return new TX(getMessage());
          case 35: return new CE(getMessage());
          case 36: return new TX(getMessage());
          case 37: return new CE(getMessage());
          case 38: return new TX(getMessage());
          case 39: return new ST(getMessage());
          case 40: return new TX(getMessage());
          case 41: return new CE(getMessage());
          case 42: return new CE(getMessage());
          case 43: return new TX(getMessage());
          case 44: return new CE(getMessage());
          case 45: return new CE(getMessage());
          case 46: return new CE(getMessage());
          default: return null;
       }
   }


}

