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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 SCH message segment (Scheduling Activity Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SCH-1: Placer Appointment ID (EI) <b>optional </b>
     * <li>SCH-2: Filler Appointment ID (EI) <b>optional </b>
     * <li>SCH-3: Occurrence Number (NM) <b>optional </b>
     * <li>SCH-4: Placer Group Number (EI) <b>optional </b>
     * <li>SCH-5: Schedule ID (CWE) <b>optional </b>
     * <li>SCH-6: Event Reason (CWE) <b> </b>
     * <li>SCH-7: Appointment Reason (CWE) <b>optional </b>
     * <li>SCH-8: Appointment Type (CWE) <b>optional </b>
     * <li>SCH-9: Appointment Duration (NM) <b>optional </b>
     * <li>SCH-10: Appointment Duration Units (CNE) <b>optional </b>
     * <li>SCH-11: Appointment Timing Quantity (TQ) <b>optional repeating</b>
     * <li>SCH-12: Placer Contact Person (XCN) <b>optional repeating</b>
     * <li>SCH-13: Placer Contact Phone Number (XTN) <b>optional </b>
     * <li>SCH-14: Placer Contact Address (XAD) <b>optional repeating</b>
     * <li>SCH-15: Placer Contact Location (PL) <b>optional </b>
     * <li>SCH-16: Filler Contact Person (XCN) <b> repeating</b>
     * <li>SCH-17: Filler Contact Phone Number (XTN) <b>optional </b>
     * <li>SCH-18: Filler Contact Address (XAD) <b>optional repeating</b>
     * <li>SCH-19: Filler Contact Location (PL) <b>optional </b>
     * <li>SCH-20: Entered By Person (XCN) <b> repeating</b>
     * <li>SCH-21: Entered By Phone Number (XTN) <b>optional repeating</b>
     * <li>SCH-22: Entered By Location (PL) <b>optional </b>
     * <li>SCH-23: Parent Placer Appointment ID (EI) <b>optional </b>
     * <li>SCH-24: Parent Filler Appointment ID (EI) <b>optional </b>
     * <li>SCH-25: Filler Status Code (CWE) <b>optional </b>
     * <li>SCH-26: Placer Order Number (EI) <b>optional repeating</b>
     * <li>SCH-27: Filler Order Number (EI) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SCH extends AbstractSegment {

    /** 
     * Creates a new SCH segment
     */
    public SCH(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, false, 1, 75, new Object[]{ getMessage() }, "Placer Appointment ID");
                                  this.add(EI.class, false, 1, 75, new Object[]{ getMessage() }, "Filler Appointment ID");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Occurrence Number");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Placer Group Number");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Schedule ID");
                                  this.add(CWE.class, true, 1, 250, new Object[]{ getMessage() }, "Event Reason");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Appointment Reason");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Appointment Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Appointment Duration");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Appointment Duration Units");
                                  this.add(TQ.class, false, 0, 0, new Object[]{ getMessage() }, "Appointment Timing Quantity");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Placer Contact Person");
                                  this.add(XTN.class, false, 1, 250, new Object[]{ getMessage() }, "Placer Contact Phone Number");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Placer Contact Address");
                                  this.add(PL.class, false, 1, 80, new Object[]{ getMessage() }, "Placer Contact Location");
                                  this.add(XCN.class, true, 0, 250, new Object[]{ getMessage() }, "Filler Contact Person");
                                  this.add(XTN.class, false, 1, 250, new Object[]{ getMessage() }, "Filler Contact Phone Number");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Filler Contact Address");
                                  this.add(PL.class, false, 1, 80, new Object[]{ getMessage() }, "Filler Contact Location");
                                  this.add(XCN.class, true, 0, 250, new Object[]{ getMessage() }, "Entered By Person");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Entered By Phone Number");
                                  this.add(PL.class, false, 1, 80, new Object[]{ getMessage() }, "Entered By Location");
                                  this.add(EI.class, false, 1, 75, new Object[]{ getMessage() }, "Parent Placer Appointment ID");
                                  this.add(EI.class, false, 1, 75, new Object[]{ getMessage() }, "Parent Filler Appointment ID");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Filler Status Code");
                                  this.add(EI.class, false, 0, 427, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(EI.class, false, 0, 427, new Object[]{ getMessage() }, "Filler Order Number");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SCH - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SCH-1: "Placer Appointment ID" - creates it if necessary
     */
    public EI getPlacerAppointmentID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-1: "Placer Appointment ID" - creates it if necessary
     */
    public EI getSch1_PlacerAppointmentID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-2: "Filler Appointment ID" - creates it if necessary
     */
    public EI getFillerAppointmentID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-2: "Filler Appointment ID" - creates it if necessary
     */
    public EI getSch2_FillerAppointmentID() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-3: "Occurrence Number" - creates it if necessary
     */
    public NM getOccurrenceNumber() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-3: "Occurrence Number" - creates it if necessary
     */
    public NM getSch3_OccurrenceNumber() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-4: "Placer Group Number" - creates it if necessary
     */
    public EI getPlacerGroupNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-4: "Placer Group Number" - creates it if necessary
     */
    public EI getSch4_PlacerGroupNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-5: "Schedule ID" - creates it if necessary
     */
    public CWE getScheduleID() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-5: "Schedule ID" - creates it if necessary
     */
    public CWE getSch5_ScheduleID() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-6: "Event Reason" - creates it if necessary
     */
    public CWE getEventReason() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-6: "Event Reason" - creates it if necessary
     */
    public CWE getSch6_EventReason() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-7: "Appointment Reason" - creates it if necessary
     */
    public CWE getAppointmentReason() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-7: "Appointment Reason" - creates it if necessary
     */
    public CWE getSch7_AppointmentReason() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-8: "Appointment Type" - creates it if necessary
     */
    public CWE getAppointmentType() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-8: "Appointment Type" - creates it if necessary
     */
    public CWE getSch8_AppointmentType() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-9: "Appointment Duration" - creates it if necessary
     */
    public NM getAppointmentDuration() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-9: "Appointment Duration" - creates it if necessary
     */
    public NM getSch9_AppointmentDuration() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-10: "Appointment Duration Units" - creates it if necessary
     */
    public CNE getAppointmentDurationUnits() { 
		CNE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-10: "Appointment Duration Units" - creates it if necessary
     */
    public CNE getSch10_AppointmentDurationUnits() { 
		CNE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Appointment Timing Quantity (SCH-11).
     */
    public TQ[] getAppointmentTimingQuantity() {
    	TQ[] retVal = this.getTypedField(11, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Appointment Timing Quantity (SCH-11).
     */
    public TQ[] getSch11_AppointmentTimingQuantity() {
    	TQ[] retVal = this.getTypedField(11, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Appointment Timing Quantity (SCH-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAppointmentTimingQuantityReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * SCH-11: "Appointment Timing Quantity" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getAppointmentTimingQuantity(int rep) { 
		TQ retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-11: "Appointment Timing Quantity" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getSch11_AppointmentTimingQuantity(int rep) { 
		TQ retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Appointment Timing Quantity (SCH-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch11_AppointmentTimingQuantityReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * SCH-11: "Appointment Timing Quantity" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertAppointmentTimingQuantity(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-11: "Appointment Timing Quantity" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertSch11_AppointmentTimingQuantity(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * SCH-11: "Appointment Timing Quantity" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeAppointmentTimingQuantity(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * SCH-11: "Appointment Timing Quantity" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeSch11_AppointmentTimingQuantity(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Placer Contact Person (SCH-12).
     */
    public XCN[] getPlacerContactPerson() {
    	XCN[] retVal = this.getTypedField(12, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Contact Person (SCH-12).
     */
    public XCN[] getSch12_PlacerContactPerson() {
    	XCN[] retVal = this.getTypedField(12, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Contact Person (SCH-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerContactPersonReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * SCH-12: "Placer Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPlacerContactPerson(int rep) { 
		XCN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-12: "Placer Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSch12_PlacerContactPerson(int rep) { 
		XCN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Contact Person (SCH-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch12_PlacerContactPersonReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * SCH-12: "Placer Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPlacerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-12: "Placer Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSch12_PlacerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * SCH-12: "Placer Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePlacerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * SCH-12: "Placer Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSch12_PlacerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * SCH-13: "Placer Contact Phone Number" - creates it if necessary
     */
    public XTN getPlacerContactPhoneNumber() { 
		XTN retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-13: "Placer Contact Phone Number" - creates it if necessary
     */
    public XTN getSch13_PlacerContactPhoneNumber() { 
		XTN retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Placer Contact Address (SCH-14).
     */
    public XAD[] getPlacerContactAddress() {
    	XAD[] retVal = this.getTypedField(14, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Contact Address (SCH-14).
     */
    public XAD[] getSch14_PlacerContactAddress() {
    	XAD[] retVal = this.getTypedField(14, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Contact Address (SCH-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerContactAddressReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * SCH-14: "Placer Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPlacerContactAddress(int rep) { 
		XAD retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-14: "Placer Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getSch14_PlacerContactAddress(int rep) { 
		XAD retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Contact Address (SCH-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch14_PlacerContactAddressReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * SCH-14: "Placer Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPlacerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-14: "Placer Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertSch14_PlacerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * SCH-14: "Placer Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePlacerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * SCH-14: "Placer Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeSch14_PlacerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * SCH-15: "Placer Contact Location" - creates it if necessary
     */
    public PL getPlacerContactLocation() { 
		PL retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-15: "Placer Contact Location" - creates it if necessary
     */
    public PL getSch15_PlacerContactLocation() { 
		PL retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Filler Contact Person (SCH-16).
     */
    public XCN[] getFillerContactPerson() {
    	XCN[] retVal = this.getTypedField(16, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Filler Contact Person (SCH-16).
     */
    public XCN[] getSch16_FillerContactPerson() {
    	XCN[] retVal = this.getTypedField(16, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Filler Contact Person (SCH-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFillerContactPersonReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * SCH-16: "Filler Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getFillerContactPerson(int rep) { 
		XCN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-16: "Filler Contact Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSch16_FillerContactPerson(int rep) { 
		XCN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Filler Contact Person (SCH-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch16_FillerContactPersonReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * SCH-16: "Filler Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertFillerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-16: "Filler Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSch16_FillerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * SCH-16: "Filler Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeFillerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * SCH-16: "Filler Contact Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSch16_FillerContactPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * SCH-17: "Filler Contact Phone Number" - creates it if necessary
     */
    public XTN getFillerContactPhoneNumber() { 
		XTN retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-17: "Filler Contact Phone Number" - creates it if necessary
     */
    public XTN getSch17_FillerContactPhoneNumber() { 
		XTN retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Filler Contact Address (SCH-18).
     */
    public XAD[] getFillerContactAddress() {
    	XAD[] retVal = this.getTypedField(18, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Filler Contact Address (SCH-18).
     */
    public XAD[] getSch18_FillerContactAddress() {
    	XAD[] retVal = this.getTypedField(18, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Filler Contact Address (SCH-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFillerContactAddressReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * SCH-18: "Filler Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getFillerContactAddress(int rep) { 
		XAD retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-18: "Filler Contact Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getSch18_FillerContactAddress(int rep) { 
		XAD retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Filler Contact Address (SCH-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch18_FillerContactAddressReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * SCH-18: "Filler Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertFillerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-18: "Filler Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertSch18_FillerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * SCH-18: "Filler Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeFillerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * SCH-18: "Filler Contact Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeSch18_FillerContactAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * SCH-19: "Filler Contact Location" - creates it if necessary
     */
    public PL getFillerContactLocation() { 
		PL retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-19: "Filler Contact Location" - creates it if necessary
     */
    public PL getSch19_FillerContactLocation() { 
		PL retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Entered By Person (SCH-20).
     */
    public XCN[] getEnteredByPerson() {
    	XCN[] retVal = this.getTypedField(20, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Entered By Person (SCH-20).
     */
    public XCN[] getSch20_EnteredByPerson() {
    	XCN[] retVal = this.getTypedField(20, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Entered By Person (SCH-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEnteredByPersonReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * SCH-20: "Entered By Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getEnteredByPerson(int rep) { 
		XCN retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-20: "Entered By Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSch20_EnteredByPerson(int rep) { 
		XCN retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Entered By Person (SCH-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch20_EnteredByPersonReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * SCH-20: "Entered By Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertEnteredByPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-20: "Entered By Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSch20_EnteredByPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * SCH-20: "Entered By Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeEnteredByPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * SCH-20: "Entered By Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSch20_EnteredByPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Entered By Phone Number (SCH-21).
     */
    public XTN[] getEnteredByPhoneNumber() {
    	XTN[] retVal = this.getTypedField(21, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Entered By Phone Number (SCH-21).
     */
    public XTN[] getSch21_EnteredByPhoneNumber() {
    	XTN[] retVal = this.getTypedField(21, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Entered By Phone Number (SCH-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEnteredByPhoneNumberReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * SCH-21: "Entered By Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getEnteredByPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-21: "Entered By Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getSch21_EnteredByPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Entered By Phone Number (SCH-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch21_EnteredByPhoneNumberReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * SCH-21: "Entered By Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertEnteredByPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-21: "Entered By Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertSch21_EnteredByPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * SCH-21: "Entered By Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeEnteredByPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * SCH-21: "Entered By Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeSch21_EnteredByPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * SCH-22: "Entered By Location" - creates it if necessary
     */
    public PL getEnteredByLocation() { 
		PL retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-22: "Entered By Location" - creates it if necessary
     */
    public PL getSch22_EnteredByLocation() { 
		PL retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-23: "Parent Placer Appointment ID" - creates it if necessary
     */
    public EI getParentPlacerAppointmentID() { 
		EI retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-23: "Parent Placer Appointment ID" - creates it if necessary
     */
    public EI getSch23_ParentPlacerAppointmentID() { 
		EI retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-24: "Parent Filler Appointment ID" - creates it if necessary
     */
    public EI getParentFillerAppointmentID() { 
		EI retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-24: "Parent Filler Appointment ID" - creates it if necessary
     */
    public EI getSch24_ParentFillerAppointmentID() { 
		EI retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * SCH-25: "Filler Status Code" - creates it if necessary
     */
    public CWE getFillerStatusCode() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCH-25: "Filler Status Code" - creates it if necessary
     */
    public CWE getSch25_FillerStatusCode() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (SCH-26).
     */
    public EI[] getPlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(26, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (SCH-26).
     */
    public EI[] getSch26_PlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(26, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Order Number (SCH-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerOrderNumberReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * SCH-26: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getPlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-26: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getSch26_PlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Order Number (SCH-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch26_PlacerOrderNumberReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * SCH-26: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertPlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-26: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertSch26_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * SCH-26: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removePlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * SCH-26: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeSch26_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(26, rep);
    }



    /**
     * Returns all repetitions of Filler Order Number (SCH-27).
     */
    public EI[] getFillerOrderNumber() {
    	EI[] retVal = this.getTypedField(27, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Filler Order Number (SCH-27).
     */
    public EI[] getSch27_FillerOrderNumber() {
    	EI[] retVal = this.getTypedField(27, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Filler Order Number (SCH-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFillerOrderNumberReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * SCH-27: "Filler Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getFillerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCH-27: "Filler Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getSch27_FillerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Filler Order Number (SCH-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSch27_FillerOrderNumberReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * SCH-27: "Filler Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertFillerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * SCH-27: "Filler Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertSch27_FillerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * SCH-27: "Filler Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeFillerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * SCH-27: "Filler Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeSch27_FillerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(27, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new CNE(getMessage());
          case 10: return new TQ(getMessage());
          case 11: return new XCN(getMessage());
          case 12: return new XTN(getMessage());
          case 13: return new XAD(getMessage());
          case 14: return new PL(getMessage());
          case 15: return new XCN(getMessage());
          case 16: return new XTN(getMessage());
          case 17: return new XAD(getMessage());
          case 18: return new PL(getMessage());
          case 19: return new XCN(getMessage());
          case 20: return new XTN(getMessage());
          case 21: return new PL(getMessage());
          case 22: return new EI(getMessage());
          case 23: return new EI(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new EI(getMessage());
          case 26: return new EI(getMessage());
          default: return null;
       }
   }


}

