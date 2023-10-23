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
 *<p>Represents an HL7 PRT message segment (Participation Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRT-1: Participation Instance ID (EI) <b>optional </b>
     * <li>PRT-2: Action Code (ID) <b> </b>
     * <li>PRT-3: Action Reason (CWE) <b>optional </b>
     * <li>PRT-4: Participation (CWE) <b> </b>
     * <li>PRT-5: Participation Person (XCN) <b>optional repeating</b>
     * <li>PRT-6: Participation Person Provider Type (CWE) <b>optional </b>
     * <li>PRT-7: Participant Organization Unit Type (CWE) <b>optional </b>
     * <li>PRT-8: Participation Organization (XON) <b>optional repeating</b>
     * <li>PRT-9: Participant Location (PL) <b>optional repeating</b>
     * <li>PRT-10: Participation Device (EI) <b>optional repeating</b>
     * <li>PRT-11: Participation Begin Date/Time (arrival time) (DTM) <b>optional </b>
     * <li>PRT-12: Participation End Date/Time (departure time) (DTM) <b>optional </b>
     * <li>PRT-13: Participation Qualitative Duration (CWE) <b>optional </b>
     * <li>PRT-14: Participation Address (XAD) <b>optional repeating</b>
     * <li>PRT-15: Participant Telecommunication Address (XTN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PRT extends AbstractSegment {

    /** 
     * Creates a new PRT segment
     */
    public PRT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, false, 1, 4, new Object[]{ getMessage() }, "Participation Instance ID");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(206) }, "Action Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Action Reason");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Participation");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Participation Person");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Participation Person Provider Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Participant Organization Unit Type");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Participation Organization");
                                  this.add(PL.class, false, 0, 0, new Object[]{ getMessage() }, "Participant Location");
                                  this.add(EI.class, false, 0, 0, new Object[]{ getMessage() }, "Participation Device");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Participation Begin Date/Time (arrival time)");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Participation End Date/Time (departure time)");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Participation Qualitative Duration");
                                  this.add(XAD.class, false, 0, 0, new Object[]{ getMessage() }, "Participation Address");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Participant Telecommunication Address");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PRT-1: "Participation Instance ID" - creates it if necessary
     */
    public EI getParticipationInstanceID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-1: "Participation Instance ID" - creates it if necessary
     */
    public EI getPrt1_ParticipationInstanceID() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PRT-2: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-2: "Action Code" - creates it if necessary
     */
    public ID getPrt2_ActionCode() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PRT-3: "Action Reason" - creates it if necessary
     */
    public CWE getActionReason() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-3: "Action Reason" - creates it if necessary
     */
    public CWE getPrt3_ActionReason() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PRT-4: "Participation" - creates it if necessary
     */
    public CWE getParticipation() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-4: "Participation" - creates it if necessary
     */
    public CWE getPrt4_Participation() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Participation Person (PRT-5).
     */
    public XCN[] getParticipationPerson() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Participation Person (PRT-5).
     */
    public XCN[] getPrt5_ParticipationPerson() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Participation Person (PRT-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParticipationPersonReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PRT-5: "Participation Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getParticipationPerson(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRT-5: "Participation Person" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPrt5_ParticipationPerson(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Participation Person (PRT-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrt5_ParticipationPersonReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PRT-5: "Participation Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertParticipationPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PRT-5: "Participation Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPrt5_ParticipationPerson(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRT-5: "Participation Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeParticipationPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRT-5: "Participation Person" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePrt5_ParticipationPerson(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * PRT-6: "Participation Person Provider Type" - creates it if necessary
     */
    public CWE getParticipationPersonProviderType() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-6: "Participation Person Provider Type" - creates it if necessary
     */
    public CWE getPrt6_ParticipationPersonProviderType() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PRT-7: "Participant Organization Unit Type" - creates it if necessary
     */
    public CWE getParticipantOrganizationUnitType() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-7: "Participant Organization Unit Type" - creates it if necessary
     */
    public CWE getPrt7_ParticipantOrganizationUnitType() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Participation Organization (PRT-8).
     */
    public XON[] getParticipationOrganization() {
    	XON[] retVal = this.getTypedField(8, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Participation Organization (PRT-8).
     */
    public XON[] getPrt8_ParticipationOrganization() {
    	XON[] retVal = this.getTypedField(8, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Participation Organization (PRT-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParticipationOrganizationReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * PRT-8: "Participation Organization" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getParticipationOrganization(int rep) { 
		XON retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRT-8: "Participation Organization" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPrt8_ParticipationOrganization(int rep) { 
		XON retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Participation Organization (PRT-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrt8_ParticipationOrganizationReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * PRT-8: "Participation Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertParticipationOrganization(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * PRT-8: "Participation Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPrt8_ParticipationOrganization(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PRT-8: "Participation Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeParticipationOrganization(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PRT-8: "Participation Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePrt8_ParticipationOrganization(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of Participant Location (PRT-9).
     */
    public PL[] getParticipantLocation() {
    	PL[] retVal = this.getTypedField(9, new PL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Participant Location (PRT-9).
     */
    public PL[] getPrt9_ParticipantLocation() {
    	PL[] retVal = this.getTypedField(9, new PL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Participant Location (PRT-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParticipantLocationReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * PRT-9: "Participant Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getParticipantLocation(int rep) { 
		PL retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRT-9: "Participant Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getPrt9_ParticipantLocation(int rep) { 
		PL retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Participant Location (PRT-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrt9_ParticipantLocationReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * PRT-9: "Participant Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertParticipantLocation(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PRT-9: "Participant Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertPrt9_ParticipantLocation(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PRT-9: "Participant Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removeParticipantLocation(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PRT-9: "Participant Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removePrt9_ParticipantLocation(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Participation Device (PRT-10).
     */
    public EI[] getParticipationDevice() {
    	EI[] retVal = this.getTypedField(10, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Participation Device (PRT-10).
     */
    public EI[] getPrt10_ParticipationDevice() {
    	EI[] retVal = this.getTypedField(10, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Participation Device (PRT-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParticipationDeviceReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * PRT-10: "Participation Device" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getParticipationDevice(int rep) { 
		EI retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRT-10: "Participation Device" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getPrt10_ParticipationDevice(int rep) { 
		EI retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Participation Device (PRT-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrt10_ParticipationDeviceReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * PRT-10: "Participation Device" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertParticipationDevice(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * PRT-10: "Participation Device" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertPrt10_ParticipationDevice(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PRT-10: "Participation Device" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeParticipationDevice(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PRT-10: "Participation Device" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removePrt10_ParticipationDevice(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * PRT-11: "Participation Begin Date/Time (arrival time)" - creates it if necessary
     */
    public DTM getParticipationBeginDateTimeArrivaltime() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-11: "Participation Begin Date/Time (arrival time)" - creates it if necessary
     */
    public DTM getPrt11_ParticipationBeginDateTimeArrivaltime() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PRT-12: "Participation End Date/Time (departure time)" - creates it if necessary
     */
    public DTM getParticipationEndDateTimeDeparturetime() { 
		DTM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-12: "Participation End Date/Time (departure time)" - creates it if necessary
     */
    public DTM getPrt12_ParticipationEndDateTimeDeparturetime() { 
		DTM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PRT-13: "Participation Qualitative Duration" - creates it if necessary
     */
    public CWE getParticipationQualitativeDuration() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRT-13: "Participation Qualitative Duration" - creates it if necessary
     */
    public CWE getPrt13_ParticipationQualitativeDuration() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Participation Address (PRT-14).
     */
    public XAD[] getParticipationAddress() {
    	XAD[] retVal = this.getTypedField(14, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Participation Address (PRT-14).
     */
    public XAD[] getPrt14_ParticipationAddress() {
    	XAD[] retVal = this.getTypedField(14, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Participation Address (PRT-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParticipationAddressReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PRT-14: "Participation Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getParticipationAddress(int rep) { 
		XAD retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRT-14: "Participation Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPrt14_ParticipationAddress(int rep) { 
		XAD retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Participation Address (PRT-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrt14_ParticipationAddressReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PRT-14: "Participation Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertParticipationAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PRT-14: "Participation Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPrt14_ParticipationAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PRT-14: "Participation Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeParticipationAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PRT-14: "Participation Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePrt14_ParticipationAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of Participant Telecommunication Address (PRT-15).
     */
    public XTN[] getParticipantTelecommunicationAddress() {
    	XTN[] retVal = this.getTypedField(15, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Participant Telecommunication Address (PRT-15).
     */
    public XTN[] getPrt15_ParticipantTelecommunicationAddress() {
    	XTN[] retVal = this.getTypedField(15, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Participant Telecommunication Address (PRT-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getParticipantTelecommunicationAddressReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * PRT-15: "Participant Telecommunication Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getParticipantTelecommunicationAddress(int rep) { 
		XTN retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRT-15: "Participant Telecommunication Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPrt15_ParticipantTelecommunicationAddress(int rep) { 
		XTN retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Participant Telecommunication Address (PRT-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrt15_ParticipantTelecommunicationAddressReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * PRT-15: "Participant Telecommunication Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertParticipantTelecommunicationAddress(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * PRT-15: "Participant Telecommunication Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPrt15_ParticipantTelecommunicationAddress(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PRT-15: "Participant Telecommunication Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeParticipantTelecommunicationAddress(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * PRT-15: "Participant Telecommunication Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePrt15_ParticipantTelecommunicationAddress(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(15, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 206 ));
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new XON(getMessage());
          case 8: return new PL(getMessage());
          case 9: return new EI(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new DTM(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new XAD(getMessage());
          case 14: return new XTN(getMessage());
          default: return null;
       }
   }


}

