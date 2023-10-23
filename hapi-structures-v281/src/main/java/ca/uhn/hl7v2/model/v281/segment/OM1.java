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
 *<p>Represents an HL7 OM1 message segment (General Segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM1-1: Sequence Number - Test/Observation Master File (NM) <b> </b>
     * <li>OM1-2: Producer's Service/Test/Observation ID (CWE) <b> </b>
     * <li>OM1-3: Permitted Data Types (ID) <b>optional repeating</b>
     * <li>OM1-4: Specimen Required (ID) <b> </b>
     * <li>OM1-5: Producer ID (CWE) <b> </b>
     * <li>OM1-6: Observation Description (TX) <b>optional </b>
     * <li>OM1-7: Other Service/Test/Observation IDs for the Observation (CWE) <b>optional repeating</b>
     * <li>OM1-8: Other Names (ST) <b>optional repeating</b>
     * <li>OM1-9: Preferred Report Name for the Observation (ST) <b>optional </b>
     * <li>OM1-10: Preferred Short Name or Mnemonic for the Observation (ST) <b>optional </b>
     * <li>OM1-11: Preferred Long Name for the Observation (ST) <b>optional </b>
     * <li>OM1-12: Orderability (ID) <b>optional </b>
     * <li>OM1-13: Identity of Instrument Used to Perform this Study (CWE) <b>optional repeating</b>
     * <li>OM1-14: Coded Representation of Method (CWE) <b>optional repeating</b>
     * <li>OM1-15: Portable Device Indicator (ID) <b>optional </b>
     * <li>OM1-16: Observation Producing Department/Section (CWE) <b>optional repeating</b>
     * <li>OM1-17: Telephone Number of Section (XTN) <b>optional </b>
     * <li>OM1-18: Nature of Service/Test/Observation (CWE) <b> </b>
     * <li>OM1-19: Report Subheader (CWE) <b>optional </b>
     * <li>OM1-20: Report Display Order (ST) <b>optional </b>
     * <li>OM1-21: Date/Time Stamp for Any Change in Definition for the Observation (DTM) <b>optional </b>
     * <li>OM1-22: Effective Date/Time of Change (DTM) <b>optional </b>
     * <li>OM1-23: Typical Turn-Around Time (NM) <b>optional </b>
     * <li>OM1-24: Processing Time (NM) <b>optional </b>
     * <li>OM1-25: Processing Priority (ID) <b>optional repeating</b>
     * <li>OM1-26: Reporting Priority (ID) <b>optional </b>
     * <li>OM1-27: Outside Site(s) Where Observation May Be Performed (CWE) <b>optional repeating</b>
     * <li>OM1-28: Address of Outside Site(s) (XAD) <b>optional repeating</b>
     * <li>OM1-29: Phone Number of Outside Site (XTN) <b>optional </b>
     * <li>OM1-30: Confidentiality Code (CWE) <b>optional </b>
     * <li>OM1-31: Observations Required to Interpret this Observation (CWE) <b>optional repeating</b>
     * <li>OM1-32: Interpretation of Observations (TX) <b>optional </b>
     * <li>OM1-33: Contraindications to Observations (CWE) <b>optional repeating</b>
     * <li>OM1-34: Reflex Tests/Observations (CWE) <b>optional repeating</b>
     * <li>OM1-35: Rules that Trigger Reflex Testing (TX) <b>optional repeating</b>
     * <li>OM1-36: Fixed Canned Message (CWE) <b>optional repeating</b>
     * <li>OM1-37: Patient Preparation (TX) <b>optional repeating</b>
     * <li>OM1-38: Procedure Medication (CWE) <b>optional </b>
     * <li>OM1-39: Factors that may Affect the Observation (TX) <b>optional </b>
     * <li>OM1-40: Service/Test/Observation Performance Schedule (ST) <b>optional repeating</b>
     * <li>OM1-41: Description of Test Methods (TX) <b>optional </b>
     * <li>OM1-42: Kind of Quantity Observed (CWE) <b>optional </b>
     * <li>OM1-43: Point Versus Interval (CWE) <b>optional </b>
     * <li>OM1-44: Challenge Information (TX) <b>optional </b>
     * <li>OM1-45: Relationship Modifier (CWE) <b>optional </b>
     * <li>OM1-46: Target Anatomic Site Of Test (CWE) <b>optional </b>
     * <li>OM1-47: Modality of Imaging Measurement (CWE) <b>optional </b>
     * <li>OM1-48: Exclusive Test (ID) <b>optional </b>
     * <li>OM1-49: Diagnostic Serv Sect ID (ID) <b>optional </b>
     * <li>OM1-50: Taxonomic Classification Code (CWE) <b>optional </b>
     * <li>OM1-51: Other Names Number 2 (ST) <b>optional repeating</b>
     * <li>OM1-52: Replacement Producer's Service/Test/Observation ID (CWE) <b>optional repeating</b>
     * <li>OM1-53: Prior Resuts Instructions (TX) <b>optional repeating</b>
     * <li>OM1-54: Special Instructions (TX) <b>optional </b>
     * <li>OM1-55: Test Category (CWE) <b>optional repeating</b>
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
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Sequence Number - Test/Observation Master File");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Producer's Service/Test/Observation ID");
                                              this.add(ID.class, false, 0, 0, new Object[]{ getMessage(), new Integer(125) }, "Permitted Data Types");
                                              this.add(ID.class, true, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Specimen Required");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Producer ID");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Observation Description");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Other Service/Test/Observation IDs for the Observation");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Other Names");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Preferred Report Name for the Observation");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Preferred Short Name or Mnemonic for the Observation");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Preferred Long Name for the Observation");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Orderability");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Identity of Instrument Used to Perform this Study");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Coded Representation of Method");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Portable Device Indicator");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Observation Producing Department/Section");
                                  this.add(XTN.class, false, 1, 0, new Object[]{ getMessage() }, "Telephone Number of Section");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Nature of Service/Test/Observation");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Report Subheader");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Report Display Order");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date/Time Stamp for Any Change in Definition for the Observation");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Effective Date/Time of Change");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Typical Turn-Around Time");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Processing Time");
                                              this.add(ID.class, false, 0, 0, new Object[]{ getMessage(), new Integer(168) }, "Processing Priority");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(169) }, "Reporting Priority");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Outside Site(s) Where Observation May Be Performed");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Address of Outside Site(s)");
                                  this.add(XTN.class, false, 1, 0, new Object[]{ getMessage() }, "Phone Number of Outside Site");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Confidentiality Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Observations Required to Interpret this Observation");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Interpretation of Observations");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Contraindications to Observations");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Reflex Tests/Observations");
                                  this.add(TX.class, false, 0, 0, new Object[]{ getMessage() }, "Rules that Trigger Reflex Testing");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Fixed Canned Message");
                                  this.add(TX.class, false, 0, 0, new Object[]{ getMessage() }, "Patient Preparation");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Medication");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Factors that may Affect the Observation");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Service/Test/Observation Performance Schedule");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Description of Test Methods");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Kind of Quantity Observed");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Point Versus Interval");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Challenge Information");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Relationship Modifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Target Anatomic Site Of Test");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Modality of Imaging Measurement");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(919) }, "Exclusive Test");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(74) }, "Diagnostic Serv Sect ID");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Taxonomic Classification Code");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Other Names Number 2");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Replacement Producer's Service/Test/Observation ID");
                                  this.add(TX.class, false, 0, 0, new Object[]{ getMessage() }, "Prior Resuts Instructions");
                                  this.add(TX.class, false, 1, 0, new Object[]{ getMessage() }, "Special Instructions");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Test Category");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM1-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getOm11_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-2: "Producer's Service/Test/Observation ID" - creates it if necessary
     */
    public CWE getProducerSServiceTestObservationID() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-2: "Producer's Service/Test/Observation ID" - creates it if necessary
     */
    public CWE getOm12_ProducerSServiceTestObservationID() { 
		CWE retVal = this.getTypedField(2, 0);
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
    public CWE getProducerID() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-5: "Producer ID" - creates it if necessary
     */
    public CWE getOm15_ProducerID() { 
		CWE retVal = this.getTypedField(5, 0);
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
     * Returns all repetitions of Other Service/Test/Observation IDs for the Observation (OM1-7).
     */
    public CWE[] getOtherServiceTestObservationIDsForTheObservation() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Service/Test/Observation IDs for the Observation (OM1-7).
     */
    public CWE[] getOm17_OtherServiceTestObservationIDsForTheObservation() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Service/Test/Observation IDs for the Observation (OM1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherServiceTestObservationIDsForTheObservationReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOtherServiceTestObservationIDsForTheObservation(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm17_OtherServiceTestObservationIDsForTheObservation(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Service/Test/Observation IDs for the Observation (OM1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm17_OtherServiceTestObservationIDsForTheObservationReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOtherServiceTestObservationIDsForTheObservation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm17_OtherServiceTestObservationIDsForTheObservation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOtherServiceTestObservationIDsForTheObservation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * OM1-7: "Other Service/Test/Observation IDs for the Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm17_OtherServiceTestObservationIDsForTheObservation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
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
     * OM1-10: "Preferred Short Name or Mnemonic for the Observation" - creates it if necessary
     */
    public ST getPreferredShortNameOrMnemonicForTheObservation() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-10: "Preferred Short Name or Mnemonic for the Observation" - creates it if necessary
     */
    public ST getOm110_PreferredShortNameOrMnemonicForTheObservation() { 
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
    public CWE[] getIdentityOfInstrumentUsedToPerformThisStudy() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Identity of Instrument Used to Perform this Study (OM1-13).
     */
    public CWE[] getOm113_IdentityOfInstrumentUsedToPerformThisStudy() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
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
    public CWE getIdentityOfInstrumentUsedToPerformThisStudy(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm113_IdentityOfInstrumentUsedToPerformThisStudy(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
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
    public CWE insertIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm113_IdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OM1-13: "Identity of Instrument Used to Perform this Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm113_IdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Coded Representation of Method (OM1-14).
     */
    public CWE[] getCodedRepresentationOfMethod() {
    	CWE[] retVal = this.getTypedField(14, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Coded Representation of Method (OM1-14).
     */
    public CWE[] getOm114_CodedRepresentationOfMethod() {
    	CWE[] retVal = this.getTypedField(14, new CWE[0]);
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
    public CWE getCodedRepresentationOfMethod(int rep) { 
		CWE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-14: "Coded Representation of Method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm114_CodedRepresentationOfMethod(int rep) { 
		CWE retVal = this.getTypedField(14, rep);
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
    public CWE insertCodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm114_CodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * OM1-14: "Coded Representation of Method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm114_CodedRepresentationOfMethod(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(14, rep);
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
    public CWE[] getObservationProducingDepartmentSection() {
    	CWE[] retVal = this.getTypedField(16, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Observation Producing Department/Section (OM1-16).
     */
    public CWE[] getOm116_ObservationProducingDepartmentSection() {
    	CWE[] retVal = this.getTypedField(16, new CWE[0]);
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
    public CWE getObservationProducingDepartmentSection(int rep) { 
		CWE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-16: "Observation Producing Department/Section" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm116_ObservationProducingDepartmentSection(int rep) { 
		CWE retVal = this.getTypedField(16, rep);
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
    public CWE insertObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm116_ObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OM1-16: "Observation Producing Department/Section" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm116_ObservationProducingDepartmentSection(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(16, rep);
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
    public CWE getNatureOfServiceTestObservation() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-18: "Nature of Service/Test/Observation" - creates it if necessary
     */
    public CWE getOm118_NatureOfServiceTestObservation() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-19: "Report Subheader" - creates it if necessary
     */
    public CWE getReportSubheader() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-19: "Report Subheader" - creates it if necessary
     */
    public CWE getOm119_ReportSubheader() { 
		CWE retVal = this.getTypedField(19, 0);
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
     * OM1-21: "Date/Time Stamp for Any Change in Definition for the Observation" - creates it if necessary
     */
    public DTM getDateTimeStampForAnyChangeInDefinitionForTheObservation() { 
		DTM retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-21: "Date/Time Stamp for Any Change in Definition for the Observation" - creates it if necessary
     */
    public DTM getOm121_DateTimeStampForAnyChangeInDefinitionForTheObservation() { 
		DTM retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-22: "Effective Date/Time of Change" - creates it if necessary
     */
    public DTM getEffectiveDateTimeOfChange() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-22: "Effective Date/Time of Change" - creates it if necessary
     */
    public DTM getOm122_EffectiveDateTimeOfChange() { 
		DTM retVal = this.getTypedField(22, 0);
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
     * Returns all repetitions of Outside Site(s) Where Observation May Be Performed (OM1-27).
     */
    public CWE[] getOutsideSiteSWhereObservationMayBePerformed() {
    	CWE[] retVal = this.getTypedField(27, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Outside Site(s) Where Observation May Be Performed (OM1-27).
     */
    public CWE[] getOm127_OutsideSiteSWhereObservationMayBePerformed() {
    	CWE[] retVal = this.getTypedField(27, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Outside Site(s) Where Observation May Be Performed (OM1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOutsideSiteSWhereObservationMayBePerformedReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * OM1-27: "Outside Site(s) Where Observation May Be Performed" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOutsideSiteSWhereObservationMayBePerformed(int rep) { 
		CWE retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-27: "Outside Site(s) Where Observation May Be Performed" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm127_OutsideSiteSWhereObservationMayBePerformed(int rep) { 
		CWE retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Outside Site(s) Where Observation May Be Performed (OM1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm127_OutsideSiteSWhereObservationMayBePerformedReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * OM1-27: "Outside Site(s) Where Observation May Be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-27: "Outside Site(s) Where Observation May Be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm127_OutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OM1-27: "Outside Site(s) Where Observation May Be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OM1-27: "Outside Site(s) Where Observation May Be Performed" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm127_OutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(27, rep);
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
    public CWE getConfidentialityCode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-30: "Confidentiality Code" - creates it if necessary
     */
    public CWE getOm130_ConfidentialityCode() { 
		CWE retVal = this.getTypedField(30, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Observations Required to Interpret this Observation (OM1-31).
     */
    public CWE[] getObservationsRequiredToInterpretThisObservation() {
    	CWE[] retVal = this.getTypedField(31, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Observations Required to Interpret this Observation (OM1-31).
     */
    public CWE[] getOm131_ObservationsRequiredToInterpretThisObservation() {
    	CWE[] retVal = this.getTypedField(31, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Observations Required to Interpret this Observation (OM1-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObservationsRequiredToInterpretThisObservationReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * OM1-31: "Observations Required to Interpret this Observation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObservationsRequiredToInterpretThisObservation(int rep) { 
		CWE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-31: "Observations Required to Interpret this Observation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm131_ObservationsRequiredToInterpretThisObservation(int rep) { 
		CWE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Observations Required to Interpret this Observation (OM1-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm131_ObservationsRequiredToInterpretThisObservationReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * OM1-31: "Observations Required to Interpret this Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObservationsRequiredToInterpretThisObservation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-31: "Observations Required to Interpret this Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm131_ObservationsRequiredToInterpretThisObservation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OM1-31: "Observations Required to Interpret this Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObservationsRequiredToInterpretThisObservation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OM1-31: "Observations Required to Interpret this Observation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm131_ObservationsRequiredToInterpretThisObservation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(31, rep);
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
     * Returns all repetitions of Contraindications to Observations (OM1-33).
     */
    public CWE[] getContraindicationsToObservations() {
    	CWE[] retVal = this.getTypedField(33, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contraindications to Observations (OM1-33).
     */
    public CWE[] getOm133_ContraindicationsToObservations() {
    	CWE[] retVal = this.getTypedField(33, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contraindications to Observations (OM1-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContraindicationsToObservationsReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * OM1-33: "Contraindications to Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getContraindicationsToObservations(int rep) { 
		CWE retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-33: "Contraindications to Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm133_ContraindicationsToObservations(int rep) { 
		CWE retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contraindications to Observations (OM1-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm133_ContraindicationsToObservationsReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * OM1-33: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-33: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm133_ContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * OM1-33: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * OM1-33: "Contraindications to Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm133_ContraindicationsToObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(33, rep);
    }



    /**
     * Returns all repetitions of Reflex Tests/Observations (OM1-34).
     */
    public CWE[] getReflexTestsObservations() {
    	CWE[] retVal = this.getTypedField(34, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reflex Tests/Observations (OM1-34).
     */
    public CWE[] getOm134_ReflexTestsObservations() {
    	CWE[] retVal = this.getTypedField(34, new CWE[0]);
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
    public CWE getReflexTestsObservations(int rep) { 
		CWE retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-34: "Reflex Tests/Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm134_ReflexTestsObservations(int rep) { 
		CWE retVal = this.getTypedField(34, rep);
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
    public CWE insertReflexTestsObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(34, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm134_ReflexTestsObservations(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeReflexTestsObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OM1-34: "Reflex Tests/Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm134_ReflexTestsObservations(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(34, rep);
    }



    /**
     * Returns all repetitions of Rules that Trigger Reflex Testing (OM1-35).
     */
    public TX[] getRulesThatTriggerReflexTesting() {
    	TX[] retVal = this.getTypedField(35, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Rules that Trigger Reflex Testing (OM1-35).
     */
    public TX[] getOm135_RulesThatTriggerReflexTesting() {
    	TX[] retVal = this.getTypedField(35, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Rules that Trigger Reflex Testing (OM1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRulesThatTriggerReflexTestingReps() {
    	return this.getReps(35);
    }


    /**
     * Returns a specific repetition of
     * OM1-35: "Rules that Trigger Reflex Testing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getRulesThatTriggerReflexTesting(int rep) { 
		TX retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-35: "Rules that Trigger Reflex Testing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getOm135_RulesThatTriggerReflexTesting(int rep) { 
		TX retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Rules that Trigger Reflex Testing (OM1-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm135_RulesThatTriggerReflexTestingReps() {
    	return this.getReps(35);
    }


    /**
     * Inserts a repetition of
     * OM1-35: "Rules that Trigger Reflex Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertRulesThatTriggerReflexTesting(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(35, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-35: "Rules that Trigger Reflex Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertOm135_RulesThatTriggerReflexTesting(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OM1-35: "Rules that Trigger Reflex Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeRulesThatTriggerReflexTesting(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OM1-35: "Rules that Trigger Reflex Testing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeOm135_RulesThatTriggerReflexTesting(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(35, rep);
    }



    /**
     * Returns all repetitions of Fixed Canned Message (OM1-36).
     */
    public CWE[] getFixedCannedMessage() {
    	CWE[] retVal = this.getTypedField(36, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Fixed Canned Message (OM1-36).
     */
    public CWE[] getOm136_FixedCannedMessage() {
    	CWE[] retVal = this.getTypedField(36, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Fixed Canned Message (OM1-36).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFixedCannedMessageReps() {
    	return this.getReps(36);
    }


    /**
     * Returns a specific repetition of
     * OM1-36: "Fixed Canned Message" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getFixedCannedMessage(int rep) { 
		CWE retVal = this.getTypedField(36, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-36: "Fixed Canned Message" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm136_FixedCannedMessage(int rep) { 
		CWE retVal = this.getTypedField(36, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Fixed Canned Message (OM1-36).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm136_FixedCannedMessageReps() {
    	return this.getReps(36);
    }


    /**
     * Inserts a repetition of
     * OM1-36: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertFixedCannedMessage(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(36, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-36: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm136_FixedCannedMessage(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(36, rep);
    }


    /**
     * Removes a repetition of
     * OM1-36: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeFixedCannedMessage(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(36, rep);
    }


    /**
     * Removes a repetition of
     * OM1-36: "Fixed Canned Message" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm136_FixedCannedMessage(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(36, rep);
    }



    /**
     * Returns all repetitions of Patient Preparation (OM1-37).
     */
    public TX[] getPatientPreparation() {
    	TX[] retVal = this.getTypedField(37, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Preparation (OM1-37).
     */
    public TX[] getOm137_PatientPreparation() {
    	TX[] retVal = this.getTypedField(37, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Preparation (OM1-37).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientPreparationReps() {
    	return this.getReps(37);
    }


    /**
     * Returns a specific repetition of
     * OM1-37: "Patient Preparation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getPatientPreparation(int rep) { 
		TX retVal = this.getTypedField(37, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-37: "Patient Preparation" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getOm137_PatientPreparation(int rep) { 
		TX retVal = this.getTypedField(37, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Preparation (OM1-37).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm137_PatientPreparationReps() {
    	return this.getReps(37);
    }


    /**
     * Inserts a repetition of
     * OM1-37: "Patient Preparation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertPatientPreparation(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(37, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-37: "Patient Preparation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertOm137_PatientPreparation(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(37, rep);
    }


    /**
     * Removes a repetition of
     * OM1-37: "Patient Preparation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removePatientPreparation(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(37, rep);
    }


    /**
     * Removes a repetition of
     * OM1-37: "Patient Preparation" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeOm137_PatientPreparation(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(37, rep);
    }




    /**
     * Returns
     * OM1-38: "Procedure Medication" - creates it if necessary
     */
    public CWE getProcedureMedication() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-38: "Procedure Medication" - creates it if necessary
     */
    public CWE getOm138_ProcedureMedication() { 
		CWE retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-39: "Factors that may Affect the Observation" - creates it if necessary
     */
    public TX getFactorsThatMayAffectTheObservation() { 
		TX retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-39: "Factors that may Affect the Observation" - creates it if necessary
     */
    public TX getOm139_FactorsThatMayAffectTheObservation() { 
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
    public CWE getKindOfQuantityObserved() { 
		CWE retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-42: "Kind of Quantity Observed" - creates it if necessary
     */
    public CWE getOm142_KindOfQuantityObserved() { 
		CWE retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-43: "Point Versus Interval" - creates it if necessary
     */
    public CWE getPointVersusInterval() { 
		CWE retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-43: "Point Versus Interval" - creates it if necessary
     */
    public CWE getOm143_PointVersusInterval() { 
		CWE retVal = this.getTypedField(43, 0);
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
    public CWE getRelationshipModifier() { 
		CWE retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-45: "Relationship Modifier" - creates it if necessary
     */
    public CWE getOm145_RelationshipModifier() { 
		CWE retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-46: "Target Anatomic Site Of Test" - creates it if necessary
     */
    public CWE getTargetAnatomicSiteOfTest() { 
		CWE retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-46: "Target Anatomic Site Of Test" - creates it if necessary
     */
    public CWE getOm146_TargetAnatomicSiteOfTest() { 
		CWE retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-47: "Modality of Imaging Measurement" - creates it if necessary
     */
    public CWE getModalityOfImagingMeasurement() { 
		CWE retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-47: "Modality of Imaging Measurement" - creates it if necessary
     */
    public CWE getOm147_ModalityOfImagingMeasurement() { 
		CWE retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-48: "Exclusive Test" - creates it if necessary
     */
    public ID getExclusiveTest() { 
		ID retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-48: "Exclusive Test" - creates it if necessary
     */
    public ID getOm148_ExclusiveTest() { 
		ID retVal = this.getTypedField(48, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-49: "Diagnostic Serv Sect ID" - creates it if necessary
     */
    public ID getDiagnosticServSectID() { 
		ID retVal = this.getTypedField(49, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-49: "Diagnostic Serv Sect ID" - creates it if necessary
     */
    public ID getOm149_DiagnosticServSectID() { 
		ID retVal = this.getTypedField(49, 0);
		return retVal;
    }



    /**
     * Returns
     * OM1-50: "Taxonomic Classification Code" - creates it if necessary
     */
    public CWE getTaxonomicClassificationCode() { 
		CWE retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-50: "Taxonomic Classification Code" - creates it if necessary
     */
    public CWE getOm150_TaxonomicClassificationCode() { 
		CWE retVal = this.getTypedField(50, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Other Names Number 2 (OM1-51).
     */
    public ST[] getOtherNamesNumber2() {
    	ST[] retVal = this.getTypedField(51, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other Names Number 2 (OM1-51).
     */
    public ST[] getOm151_OtherNamesNumber2() {
    	ST[] retVal = this.getTypedField(51, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other Names Number 2 (OM1-51).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherNamesNumber2Reps() {
    	return this.getReps(51);
    }


    /**
     * Returns a specific repetition of
     * OM1-51: "Other Names Number 2" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOtherNamesNumber2(int rep) { 
		ST retVal = this.getTypedField(51, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-51: "Other Names Number 2" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOm151_OtherNamesNumber2(int rep) { 
		ST retVal = this.getTypedField(51, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other Names Number 2 (OM1-51).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm151_OtherNamesNumber2Reps() {
    	return this.getReps(51);
    }


    /**
     * Inserts a repetition of
     * OM1-51: "Other Names Number 2" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOtherNamesNumber2(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(51, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-51: "Other Names Number 2" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOm151_OtherNamesNumber2(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(51, rep);
    }


    /**
     * Removes a repetition of
     * OM1-51: "Other Names Number 2" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOtherNamesNumber2(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(51, rep);
    }


    /**
     * Removes a repetition of
     * OM1-51: "Other Names Number 2" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOm151_OtherNamesNumber2(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(51, rep);
    }



    /**
     * Returns all repetitions of Replacement Producer's Service/Test/Observation ID (OM1-52).
     */
    public CWE[] getReplacementProducerSServiceTestObservationID() {
    	CWE[] retVal = this.getTypedField(52, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Replacement Producer's Service/Test/Observation ID (OM1-52).
     */
    public CWE[] getOm152_ReplacementProducerSServiceTestObservationID() {
    	CWE[] retVal = this.getTypedField(52, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Replacement Producer's Service/Test/Observation ID (OM1-52).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReplacementProducerSServiceTestObservationIDReps() {
    	return this.getReps(52);
    }


    /**
     * Returns a specific repetition of
     * OM1-52: "Replacement Producer's Service/Test/Observation ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getReplacementProducerSServiceTestObservationID(int rep) { 
		CWE retVal = this.getTypedField(52, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-52: "Replacement Producer's Service/Test/Observation ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm152_ReplacementProducerSServiceTestObservationID(int rep) { 
		CWE retVal = this.getTypedField(52, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Replacement Producer's Service/Test/Observation ID (OM1-52).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm152_ReplacementProducerSServiceTestObservationIDReps() {
    	return this.getReps(52);
    }


    /**
     * Inserts a repetition of
     * OM1-52: "Replacement Producer's Service/Test/Observation ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertReplacementProducerSServiceTestObservationID(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(52, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-52: "Replacement Producer's Service/Test/Observation ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm152_ReplacementProducerSServiceTestObservationID(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(52, rep);
    }


    /**
     * Removes a repetition of
     * OM1-52: "Replacement Producer's Service/Test/Observation ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeReplacementProducerSServiceTestObservationID(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(52, rep);
    }


    /**
     * Removes a repetition of
     * OM1-52: "Replacement Producer's Service/Test/Observation ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm152_ReplacementProducerSServiceTestObservationID(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(52, rep);
    }



    /**
     * Returns all repetitions of Prior Resuts Instructions (OM1-53).
     */
    public TX[] getPriorResutsInstructions() {
    	TX[] retVal = this.getTypedField(53, new TX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Prior Resuts Instructions (OM1-53).
     */
    public TX[] getOm153_PriorResutsInstructions() {
    	TX[] retVal = this.getTypedField(53, new TX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Prior Resuts Instructions (OM1-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriorResutsInstructionsReps() {
    	return this.getReps(53);
    }


    /**
     * Returns a specific repetition of
     * OM1-53: "Prior Resuts Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getPriorResutsInstructions(int rep) { 
		TX retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-53: "Prior Resuts Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TX getOm153_PriorResutsInstructions(int rep) { 
		TX retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Prior Resuts Instructions (OM1-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm153_PriorResutsInstructionsReps() {
    	return this.getReps(53);
    }


    /**
     * Inserts a repetition of
     * OM1-53: "Prior Resuts Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertPriorResutsInstructions(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(53, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-53: "Prior Resuts Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX insertOm153_PriorResutsInstructions(int rep) throws HL7Exception { 
        return (TX) super.insertRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * OM1-53: "Prior Resuts Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removePriorResutsInstructions(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * OM1-53: "Prior Resuts Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TX removeOm153_PriorResutsInstructions(int rep) throws HL7Exception { 
        return (TX) super.removeRepetition(53, rep);
    }




    /**
     * Returns
     * OM1-54: "Special Instructions" - creates it if necessary
     */
    public TX getSpecialInstructions() { 
		TX retVal = this.getTypedField(54, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM1-54: "Special Instructions" - creates it if necessary
     */
    public TX getOm154_SpecialInstructions() { 
		TX retVal = this.getTypedField(54, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Test Category (OM1-55).
     */
    public CWE[] getTestCategory() {
    	CWE[] retVal = this.getTypedField(55, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Test Category (OM1-55).
     */
    public CWE[] getOm155_TestCategory() {
    	CWE[] retVal = this.getTypedField(55, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Test Category (OM1-55).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTestCategoryReps() {
    	return this.getReps(55);
    }


    /**
     * Returns a specific repetition of
     * OM1-55: "Test Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getTestCategory(int rep) { 
		CWE retVal = this.getTypedField(55, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM1-55: "Test Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getOm155_TestCategory(int rep) { 
		CWE retVal = this.getTypedField(55, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Test Category (OM1-55).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm155_TestCategoryReps() {
    	return this.getReps(55);
    }


    /**
     * Inserts a repetition of
     * OM1-55: "Test Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertTestCategory(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(55, rep);
    }


    /**
     * Inserts a repetition of
     * OM1-55: "Test Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertOm155_TestCategory(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(55, rep);
    }


    /**
     * Removes a repetition of
     * OM1-55: "Test Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeTestCategory(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(55, rep);
    }


    /**
     * Removes a repetition of
     * OM1-55: "Test Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeOm155_TestCategory(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(55, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ID(getMessage(), new Integer( 125 ));
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new CWE(getMessage());
          case 5: return new TX(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new ID(getMessage(), new Integer( 136 ));
          case 15: return new CWE(getMessage());
          case 16: return new XTN(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new CWE(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new DTM(getMessage());
          case 21: return new DTM(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new NM(getMessage());
          case 24: return new ID(getMessage(), new Integer( 168 ));
          case 25: return new ID(getMessage(), new Integer( 169 ));
          case 26: return new CWE(getMessage());
          case 27: return new XAD(getMessage());
          case 28: return new XTN(getMessage());
          case 29: return new CWE(getMessage());
          case 30: return new CWE(getMessage());
          case 31: return new TX(getMessage());
          case 32: return new CWE(getMessage());
          case 33: return new CWE(getMessage());
          case 34: return new TX(getMessage());
          case 35: return new CWE(getMessage());
          case 36: return new TX(getMessage());
          case 37: return new CWE(getMessage());
          case 38: return new TX(getMessage());
          case 39: return new ST(getMessage());
          case 40: return new TX(getMessage());
          case 41: return new CWE(getMessage());
          case 42: return new CWE(getMessage());
          case 43: return new TX(getMessage());
          case 44: return new CWE(getMessage());
          case 45: return new CWE(getMessage());
          case 46: return new CWE(getMessage());
          case 47: return new ID(getMessage(), new Integer( 919 ));
          case 48: return new ID(getMessage(), new Integer( 74 ));
          case 49: return new CWE(getMessage());
          case 50: return new ST(getMessage());
          case 51: return new CWE(getMessage());
          case 52: return new TX(getMessage());
          case 53: return new TX(getMessage());
          case 54: return new CWE(getMessage());
          default: return null;
       }
   }


}

