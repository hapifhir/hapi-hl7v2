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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PEO message segment (PEO - product experience observation segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PEO-1: Event Identifiers Used (CE) <b>optional repeating</b>
     * <li>PEO-2: Event Symptom/Diagnosis Code (CE) <b>optional repeating</b>
     * <li>PEO-3: Event Onset Date/Time (TS) <b> </b>
     * <li>PEO-4: Event Exacerbation Date/Time (TS) <b>optional </b>
     * <li>PEO-5: Event Improved Date/Time (TS) <b>optional </b>
     * <li>PEO-6: Event Ended Data/Time (TS) <b>optional </b>
     * <li>PEO-7: Event Location Occurred Address (XAD) <b>optional repeating</b>
     * <li>PEO-8: Event Qualification (ID) <b>optional repeating</b>
     * <li>PEO-9: Event Serious (ID) <b>optional </b>
     * <li>PEO-10: Event Expected (ID) <b>optional </b>
     * <li>PEO-11: Event Outcome (ID) <b>optional repeating</b>
     * <li>PEO-12: Patient Outcome (ID) <b>optional </b>
     * <li>PEO-13: Event Description From Others (FT) <b>optional repeating</b>
     * <li>PEO-14: Event From Original Reporter (FT) <b>optional repeating</b>
     * <li>PEO-15: Event Description From Patient (FT) <b>optional repeating</b>
     * <li>PEO-16: Event Description From Practitioner (FT) <b>optional repeating</b>
     * <li>PEO-17: Event Description From Autopsy (FT) <b>optional repeating</b>
     * <li>PEO-18: Cause Of Death (CE) <b>optional repeating</b>
     * <li>PEO-19: Primary Observer Name (XPN) <b>optional repeating</b>
     * <li>PEO-20: Primary Observer Address (XAD) <b>optional repeating</b>
     * <li>PEO-21: Primary Observer Telephone (XTN) <b>optional repeating</b>
     * <li>PEO-22: Primary Observer’s Qualification (ID) <b>optional </b>
     * <li>PEO-23: Confirmation Provided By (ID) <b>optional </b>
     * <li>PEO-24: Primary Observer Aware Date/Time (TS) <b>optional </b>
     * <li>PEO-25: Primary Observer’s identity May Be Divulged (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PEO extends AbstractSegment {

    /** 
     * Creates a new PEO segment
     */
    public PEO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Event Identifiers Used");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Event Symptom/Diagnosis Code");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Event Onset Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Event Exacerbation Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Event Improved Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Event Ended Data/Time");
                                  this.add(XAD.class, false, 0, 106, new Object[]{ getMessage() }, "Event Location Occurred Address");
                                              this.add(ID.class, false, 0, 1, new Object[]{ getMessage(), new Integer(237) }, "Event Qualification");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(238) }, "Event Serious");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(239) }, "Event Expected");
                                              this.add(ID.class, false, 0, 1, new Object[]{ getMessage(), new Integer(240) }, "Event Outcome");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(241) }, "Patient Outcome");
                                  this.add(FT.class, false, 0, 600, new Object[]{ getMessage() }, "Event Description From Others");
                                  this.add(FT.class, false, 0, 600, new Object[]{ getMessage() }, "Event From Original Reporter");
                                  this.add(FT.class, false, 0, 600, new Object[]{ getMessage() }, "Event Description From Patient");
                                  this.add(FT.class, false, 0, 600, new Object[]{ getMessage() }, "Event Description From Practitioner");
                                  this.add(FT.class, false, 0, 600, new Object[]{ getMessage() }, "Event Description From Autopsy");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Cause Of Death");
                                  this.add(XPN.class, false, 0, 46, new Object[]{ getMessage() }, "Primary Observer Name");
                                  this.add(XAD.class, false, 0, 106, new Object[]{ getMessage() }, "Primary Observer Address");
                                  this.add(XTN.class, false, 0, 40, new Object[]{ getMessage() }, "Primary Observer Telephone");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(242) }, "Primary Observer’s Qualification");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(242) }, "Confirmation Provided By");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Primary Observer Aware Date/Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(243) }, "Primary Observer’s identity May Be Divulged");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PEO - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Event Identifiers Used (PEO-1).
     */
    public CE[] getEventIdentifiersUsed() {
    	CE[] retVal = this.getTypedField(1, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Identifiers Used (PEO-1).
     */
    public CE[] getPeo1_EventIdentifiersUsed() {
    	CE[] retVal = this.getTypedField(1, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Identifiers Used (PEO-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventIdentifiersUsedReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * PEO-1: "Event Identifiers Used" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getEventIdentifiersUsed(int rep) { 
		CE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-1: "Event Identifiers Used" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPeo1_EventIdentifiersUsed(int rep) { 
		CE retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Identifiers Used (PEO-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo1_EventIdentifiersUsedReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * PEO-1: "Event Identifiers Used" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertEventIdentifiersUsed(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-1: "Event Identifiers Used" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPeo1_EventIdentifiersUsed(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PEO-1: "Event Identifiers Used" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeEventIdentifiersUsed(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * PEO-1: "Event Identifiers Used" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePeo1_EventIdentifiersUsed(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(1, rep);
    }



    /**
     * Returns all repetitions of Event Symptom/Diagnosis Code (PEO-2).
     */
    public CE[] getEventSymptomDiagnosisCode() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Symptom/Diagnosis Code (PEO-2).
     */
    public CE[] getPeo2_EventSymptomDiagnosisCode() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Symptom/Diagnosis Code (PEO-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventSymptomDiagnosisCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PEO-2: "Event Symptom/Diagnosis Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getEventSymptomDiagnosisCode(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-2: "Event Symptom/Diagnosis Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPeo2_EventSymptomDiagnosisCode(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Symptom/Diagnosis Code (PEO-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo2_EventSymptomDiagnosisCodeReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PEO-2: "Event Symptom/Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertEventSymptomDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-2: "Event Symptom/Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPeo2_EventSymptomDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PEO-2: "Event Symptom/Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeEventSymptomDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PEO-2: "Event Symptom/Diagnosis Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePeo2_EventSymptomDiagnosisCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * PEO-3: "Event Onset Date/Time" - creates it if necessary
     */
    public TS getEventOnsetDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-3: "Event Onset Date/Time" - creates it if necessary
     */
    public TS getPeo3_EventOnsetDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-4: "Event Exacerbation Date/Time" - creates it if necessary
     */
    public TS getEventExacerbationDateTime() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-4: "Event Exacerbation Date/Time" - creates it if necessary
     */
    public TS getPeo4_EventExacerbationDateTime() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-5: "Event Improved Date/Time" - creates it if necessary
     */
    public TS getEventImprovedDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-5: "Event Improved Date/Time" - creates it if necessary
     */
    public TS getPeo5_EventImprovedDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-6: "Event Ended Data/Time" - creates it if necessary
     */
    public TS getEventEndedDataTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-6: "Event Ended Data/Time" - creates it if necessary
     */
    public TS getPeo6_EventEndedDataTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Event Location Occurred Address (PEO-7).
     */
    public XAD[] getEventLocationOccurredAddress() {
    	XAD[] retVal = this.getTypedField(7, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Location Occurred Address (PEO-7).
     */
    public XAD[] getPeo7_EventLocationOccurredAddress() {
    	XAD[] retVal = this.getTypedField(7, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Location Occurred Address (PEO-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventLocationOccurredAddressReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PEO-7: "Event Location Occurred Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getEventLocationOccurredAddress(int rep) { 
		XAD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-7: "Event Location Occurred Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPeo7_EventLocationOccurredAddress(int rep) { 
		XAD retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Location Occurred Address (PEO-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo7_EventLocationOccurredAddressReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PEO-7: "Event Location Occurred Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertEventLocationOccurredAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-7: "Event Location Occurred Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPeo7_EventLocationOccurredAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PEO-7: "Event Location Occurred Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeEventLocationOccurredAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PEO-7: "Event Location Occurred Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePeo7_EventLocationOccurredAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Event Qualification (PEO-8).
     */
    public ID[] getEventQualification() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Qualification (PEO-8).
     */
    public ID[] getPeo8_EventQualification() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Qualification (PEO-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventQualificationReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * PEO-8: "Event Qualification" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getEventQualification(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-8: "Event Qualification" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPeo8_EventQualification(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Qualification (PEO-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo8_EventQualificationReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * PEO-8: "Event Qualification" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertEventQualification(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-8: "Event Qualification" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPeo8_EventQualification(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PEO-8: "Event Qualification" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeEventQualification(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PEO-8: "Event Qualification" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePeo8_EventQualification(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * PEO-9: "Event Serious" - creates it if necessary
     */
    public ID getEventSerious() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-9: "Event Serious" - creates it if necessary
     */
    public ID getPeo9_EventSerious() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-10: "Event Expected" - creates it if necessary
     */
    public ID getEventExpected() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-10: "Event Expected" - creates it if necessary
     */
    public ID getPeo10_EventExpected() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Event Outcome (PEO-11).
     */
    public ID[] getEventOutcome() {
    	ID[] retVal = this.getTypedField(11, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Outcome (PEO-11).
     */
    public ID[] getPeo11_EventOutcome() {
    	ID[] retVal = this.getTypedField(11, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Outcome (PEO-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventOutcomeReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PEO-11: "Event Outcome" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getEventOutcome(int rep) { 
		ID retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-11: "Event Outcome" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPeo11_EventOutcome(int rep) { 
		ID retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Outcome (PEO-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo11_EventOutcomeReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PEO-11: "Event Outcome" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertEventOutcome(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-11: "Event Outcome" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPeo11_EventOutcome(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PEO-11: "Event Outcome" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeEventOutcome(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PEO-11: "Event Outcome" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePeo11_EventOutcome(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PEO-12: "Patient Outcome" - creates it if necessary
     */
    public ID getPatientOutcome() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-12: "Patient Outcome" - creates it if necessary
     */
    public ID getPeo12_PatientOutcome() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Event Description From Others (PEO-13).
     */
    public FT[] getEventDescriptionFromOthers() {
    	FT[] retVal = this.getTypedField(13, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Description From Others (PEO-13).
     */
    public FT[] getPeo13_EventDescriptionFromOthers() {
    	FT[] retVal = this.getTypedField(13, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Description From Others (PEO-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventDescriptionFromOthersReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PEO-13: "Event Description From Others" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getEventDescriptionFromOthers(int rep) { 
		FT retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-13: "Event Description From Others" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getPeo13_EventDescriptionFromOthers(int rep) { 
		FT retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Description From Others (PEO-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo13_EventDescriptionFromOthersReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PEO-13: "Event Description From Others" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertEventDescriptionFromOthers(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-13: "Event Description From Others" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertPeo13_EventDescriptionFromOthers(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PEO-13: "Event Description From Others" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeEventDescriptionFromOthers(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PEO-13: "Event Description From Others" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removePeo13_EventDescriptionFromOthers(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of Event From Original Reporter (PEO-14).
     */
    public FT[] getEventFromOriginalReporter() {
    	FT[] retVal = this.getTypedField(14, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event From Original Reporter (PEO-14).
     */
    public FT[] getPeo14_EventFromOriginalReporter() {
    	FT[] retVal = this.getTypedField(14, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event From Original Reporter (PEO-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventFromOriginalReporterReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PEO-14: "Event From Original Reporter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getEventFromOriginalReporter(int rep) { 
		FT retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-14: "Event From Original Reporter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getPeo14_EventFromOriginalReporter(int rep) { 
		FT retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event From Original Reporter (PEO-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo14_EventFromOriginalReporterReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PEO-14: "Event From Original Reporter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertEventFromOriginalReporter(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-14: "Event From Original Reporter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertPeo14_EventFromOriginalReporter(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PEO-14: "Event From Original Reporter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeEventFromOriginalReporter(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PEO-14: "Event From Original Reporter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removePeo14_EventFromOriginalReporter(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of Event Description From Patient (PEO-15).
     */
    public FT[] getEventDescriptionFromPatient() {
    	FT[] retVal = this.getTypedField(15, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Description From Patient (PEO-15).
     */
    public FT[] getPeo15_EventDescriptionFromPatient() {
    	FT[] retVal = this.getTypedField(15, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Description From Patient (PEO-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventDescriptionFromPatientReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * PEO-15: "Event Description From Patient" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getEventDescriptionFromPatient(int rep) { 
		FT retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-15: "Event Description From Patient" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getPeo15_EventDescriptionFromPatient(int rep) { 
		FT retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Description From Patient (PEO-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo15_EventDescriptionFromPatientReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * PEO-15: "Event Description From Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertEventDescriptionFromPatient(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-15: "Event Description From Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertPeo15_EventDescriptionFromPatient(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PEO-15: "Event Description From Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeEventDescriptionFromPatient(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PEO-15: "Event Description From Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removePeo15_EventDescriptionFromPatient(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(15, rep);
    }



    /**
     * Returns all repetitions of Event Description From Practitioner (PEO-16).
     */
    public FT[] getEventDescriptionFromPractitioner() {
    	FT[] retVal = this.getTypedField(16, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Description From Practitioner (PEO-16).
     */
    public FT[] getPeo16_EventDescriptionFromPractitioner() {
    	FT[] retVal = this.getTypedField(16, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Description From Practitioner (PEO-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventDescriptionFromPractitionerReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * PEO-16: "Event Description From Practitioner" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getEventDescriptionFromPractitioner(int rep) { 
		FT retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-16: "Event Description From Practitioner" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getPeo16_EventDescriptionFromPractitioner(int rep) { 
		FT retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Description From Practitioner (PEO-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo16_EventDescriptionFromPractitionerReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * PEO-16: "Event Description From Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertEventDescriptionFromPractitioner(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-16: "Event Description From Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertPeo16_EventDescriptionFromPractitioner(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PEO-16: "Event Description From Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeEventDescriptionFromPractitioner(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PEO-16: "Event Description From Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removePeo16_EventDescriptionFromPractitioner(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(16, rep);
    }



    /**
     * Returns all repetitions of Event Description From Autopsy (PEO-17).
     */
    public FT[] getEventDescriptionFromAutopsy() {
    	FT[] retVal = this.getTypedField(17, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Description From Autopsy (PEO-17).
     */
    public FT[] getPeo17_EventDescriptionFromAutopsy() {
    	FT[] retVal = this.getTypedField(17, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Description From Autopsy (PEO-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventDescriptionFromAutopsyReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * PEO-17: "Event Description From Autopsy" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getEventDescriptionFromAutopsy(int rep) { 
		FT retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-17: "Event Description From Autopsy" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getPeo17_EventDescriptionFromAutopsy(int rep) { 
		FT retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Description From Autopsy (PEO-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo17_EventDescriptionFromAutopsyReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * PEO-17: "Event Description From Autopsy" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertEventDescriptionFromAutopsy(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-17: "Event Description From Autopsy" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertPeo17_EventDescriptionFromAutopsy(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * PEO-17: "Event Description From Autopsy" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeEventDescriptionFromAutopsy(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * PEO-17: "Event Description From Autopsy" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removePeo17_EventDescriptionFromAutopsy(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(17, rep);
    }



    /**
     * Returns all repetitions of Cause Of Death (PEO-18).
     */
    public CE[] getCauseOfDeath() {
    	CE[] retVal = this.getTypedField(18, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Cause Of Death (PEO-18).
     */
    public CE[] getPeo18_CauseOfDeath() {
    	CE[] retVal = this.getTypedField(18, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Cause Of Death (PEO-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCauseOfDeathReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * PEO-18: "Cause Of Death" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCauseOfDeath(int rep) { 
		CE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-18: "Cause Of Death" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPeo18_CauseOfDeath(int rep) { 
		CE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Cause Of Death (PEO-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo18_CauseOfDeathReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * PEO-18: "Cause Of Death" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCauseOfDeath(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-18: "Cause Of Death" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPeo18_CauseOfDeath(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * PEO-18: "Cause Of Death" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCauseOfDeath(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * PEO-18: "Cause Of Death" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePeo18_CauseOfDeath(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(18, rep);
    }



    /**
     * Returns all repetitions of Primary Observer Name (PEO-19).
     */
    public XPN[] getPrimaryObserverName() {
    	XPN[] retVal = this.getTypedField(19, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Observer Name (PEO-19).
     */
    public XPN[] getPeo19_PrimaryObserverName() {
    	XPN[] retVal = this.getTypedField(19, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Observer Name (PEO-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryObserverNameReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * PEO-19: "Primary Observer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPrimaryObserverName(int rep) { 
		XPN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-19: "Primary Observer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getPeo19_PrimaryObserverName(int rep) { 
		XPN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Observer Name (PEO-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo19_PrimaryObserverNameReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * PEO-19: "Primary Observer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPrimaryObserverName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-19: "Primary Observer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertPeo19_PrimaryObserverName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * PEO-19: "Primary Observer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePrimaryObserverName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * PEO-19: "Primary Observer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removePeo19_PrimaryObserverName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(19, rep);
    }



    /**
     * Returns all repetitions of Primary Observer Address (PEO-20).
     */
    public XAD[] getPrimaryObserverAddress() {
    	XAD[] retVal = this.getTypedField(20, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Observer Address (PEO-20).
     */
    public XAD[] getPeo20_PrimaryObserverAddress() {
    	XAD[] retVal = this.getTypedField(20, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Observer Address (PEO-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryObserverAddressReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * PEO-20: "Primary Observer Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPrimaryObserverAddress(int rep) { 
		XAD retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-20: "Primary Observer Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPeo20_PrimaryObserverAddress(int rep) { 
		XAD retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Observer Address (PEO-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo20_PrimaryObserverAddressReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * PEO-20: "Primary Observer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPrimaryObserverAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-20: "Primary Observer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPeo20_PrimaryObserverAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PEO-20: "Primary Observer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePrimaryObserverAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PEO-20: "Primary Observer Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePeo20_PrimaryObserverAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Primary Observer Telephone (PEO-21).
     */
    public XTN[] getPrimaryObserverTelephone() {
    	XTN[] retVal = this.getTypedField(21, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Observer Telephone (PEO-21).
     */
    public XTN[] getPeo21_PrimaryObserverTelephone() {
    	XTN[] retVal = this.getTypedField(21, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Observer Telephone (PEO-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryObserverTelephoneReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * PEO-21: "Primary Observer Telephone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPrimaryObserverTelephone(int rep) { 
		XTN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PEO-21: "Primary Observer Telephone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPeo21_PrimaryObserverTelephone(int rep) { 
		XTN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Observer Telephone (PEO-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPeo21_PrimaryObserverTelephoneReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * PEO-21: "Primary Observer Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPrimaryObserverTelephone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * PEO-21: "Primary Observer Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPeo21_PrimaryObserverTelephone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * PEO-21: "Primary Observer Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePrimaryObserverTelephone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * PEO-21: "Primary Observer Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePeo21_PrimaryObserverTelephone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * PEO-22: "Primary Observer’s Qualification" - creates it if necessary
     */
    public ID getPrimaryObserverSQualification() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-22: "Primary Observer’s Qualification" - creates it if necessary
     */
    public ID getPeo22_PrimaryObserverSQualification() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-23: "Confirmation Provided By" - creates it if necessary
     */
    public ID getConfirmationProvidedBy() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-23: "Confirmation Provided By" - creates it if necessary
     */
    public ID getPeo23_ConfirmationProvidedBy() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-24: "Primary Observer Aware Date/Time" - creates it if necessary
     */
    public TS getPrimaryObserverAwareDateTime() { 
		TS retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-24: "Primary Observer Aware Date/Time" - creates it if necessary
     */
    public TS getPeo24_PrimaryObserverAwareDateTime() { 
		TS retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * PEO-25: "Primary Observer’s identity May Be Divulged" - creates it if necessary
     */
    public ID getPrimaryObserverSIdentityMayBeDivulged() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PEO-25: "Primary Observer’s identity May Be Divulged" - creates it if necessary
     */
    public ID getPeo25_PrimaryObserverSIdentityMayBeDivulged() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new TS(getMessage());
          case 6: return new XAD(getMessage());
          case 7: return new ID(getMessage(), new Integer( 237 ));
          case 8: return new ID(getMessage(), new Integer( 238 ));
          case 9: return new ID(getMessage(), new Integer( 239 ));
          case 10: return new ID(getMessage(), new Integer( 240 ));
          case 11: return new ID(getMessage(), new Integer( 241 ));
          case 12: return new FT(getMessage());
          case 13: return new FT(getMessage());
          case 14: return new FT(getMessage());
          case 15: return new FT(getMessage());
          case 16: return new FT(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new XPN(getMessage());
          case 19: return new XAD(getMessage());
          case 20: return new XTN(getMessage());
          case 21: return new ID(getMessage(), new Integer( 242 ));
          case 22: return new ID(getMessage(), new Integer( 242 ));
          case 23: return new TS(getMessage());
          case 24: return new ID(getMessage(), new Integer( 243 ));
          default: return null;
       }
   }


}

