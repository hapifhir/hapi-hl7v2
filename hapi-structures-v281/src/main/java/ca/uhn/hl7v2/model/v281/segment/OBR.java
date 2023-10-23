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
 *<p>Represents an HL7 OBR message segment (Observation Request). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OBR-1: Set ID - OBR (SI) <b>optional </b>
     * <li>OBR-2: Placer Order Number (EI) <b>optional </b>
     * <li>OBR-3: Filler Order Number (EI) <b>optional </b>
     * <li>OBR-4: Universal Service Identifier (CWE) <b> </b>
     * <li>OBR-5: Deliver-To Location (NULLDT) <b>optional </b>
     * <li>OBR-6: Deliver-To Location Number 2 (NULLDT) <b>optional </b>
     * <li>OBR-7: Observation Date/Time # (DTM) <b>optional </b>
     * <li>OBR-8: Observation End Date/Time # (DTM) <b>optional </b>
     * <li>OBR-9: Collection Volume * (CQ) <b>optional </b>
     * <li>OBR-10: Collector Identifier * (XCN) <b>optional repeating</b>
     * <li>OBR-11: Specimen Action Code * (ID) <b>optional </b>
     * <li>OBR-12: Danger Code (CWE) <b>optional </b>
     * <li>OBR-13: Relevant Clinical Information (CWE) <b>optional repeating</b>
     * <li>OBR-14: Deliver-To Location Number 3 (NULLDT) <b>optional </b>
     * <li>OBR-15: Deliver-To Location Number 4 (NULLDT) <b>optional </b>
     * <li>OBR-16: Ordering Provider (XCN) <b>optional repeating</b>
     * <li>OBR-17: Order Callback Phone Number (XTN) <b>optional repeating</b>
     * <li>OBR-18: Placer Field 1 (ST) <b>optional </b>
     * <li>OBR-19: Placer Field 2 (ST) <b>optional </b>
     * <li>OBR-20: Filler Field 1 + (ST) <b>optional </b>
     * <li>OBR-21: Filler Field 2 + (ST) <b>optional </b>
     * <li>OBR-22: Results Rpt/Status Chng - Date/Time + (DTM) <b>optional </b>
     * <li>OBR-23: Charge to Practice + (MOC) <b>optional </b>
     * <li>OBR-24: Diagnostic Serv Sect ID (ID) <b>optional </b>
     * <li>OBR-25: Result Status + (ID) <b>optional </b>
     * <li>OBR-26: Parent Result + (PRL) <b>optional </b>
     * <li>OBR-27: Deliver-To Location Number 5 (NULLDT) <b>optional repeating</b>
     * <li>OBR-28: Result Copies To (XCN) <b>optional repeating</b>
     * <li>OBR-29: Parent  Results Observation Identifier (EIP) <b>optional </b>
     * <li>OBR-30: Transportation Mode (ID) <b>optional </b>
     * <li>OBR-31: Reason for Study (CWE) <b>optional repeating</b>
     * <li>OBR-32: Principal Result Interpreter + (NDL) <b>optional </b>
     * <li>OBR-33: Assistant Result Interpreter + (NDL) <b>optional repeating</b>
     * <li>OBR-34: Technician + (NDL) <b>optional repeating</b>
     * <li>OBR-35: Transcriptionist + (NDL) <b>optional repeating</b>
     * <li>OBR-36: Scheduled Date/Time + (DTM) <b>optional </b>
     * <li>OBR-37: Number of Sample Containers * (NM) <b>optional </b>
     * <li>OBR-38: Transport Logistics of Collected Sample * (CWE) <b>optional repeating</b>
     * <li>OBR-39: Collector's Comment * (CWE) <b>optional repeating</b>
     * <li>OBR-40: Transport Arrangement Responsibility (CWE) <b>optional </b>
     * <li>OBR-41: Transport Arranged (ID) <b>optional </b>
     * <li>OBR-42: Escort Required (ID) <b>optional </b>
     * <li>OBR-43: Planned Patient Transport Comment (CWE) <b>optional repeating</b>
     * <li>OBR-44: Procedure Code (CNE) <b>optional </b>
     * <li>OBR-45: Procedure Code Modifier (CNE) <b>optional repeating</b>
     * <li>OBR-46: Placer Supplemental Service Information (CWE) <b>optional repeating</b>
     * <li>OBR-47: Filler Supplemental Service Information (CWE) <b>optional repeating</b>
     * <li>OBR-48: Medically Necessary Duplicate Procedure Reason (CWE) <b>optional </b>
     * <li>OBR-49: Result Handling (CWE) <b>optional </b>
     * <li>OBR-50: Parent Universal Service Identifier (CWE) <b>optional </b>
     * <li>OBR-51: Observation Group ID (EI) <b>optional </b>
     * <li>OBR-52: Parent Observation Group ID (EI) <b>optional </b>
     * <li>OBR-53: Alternate Placer Order Number (CX) <b>optional repeating</b>
     * <li>OBR-54: Parent Order (EIP) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OBR extends AbstractSegment {

    /** 
     * Creates a new OBR segment
     */
    public OBR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 0, new Object[]{ getMessage() }, "Set ID - OBR");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Universal Service Identifier");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-To Location");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-To Location Number 2");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Observation Date/Time #");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Observation End Date/Time #");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Collection Volume *");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Collector Identifier *");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(65) }, "Specimen Action Code *");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Danger Code");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Relevant Clinical Information");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-To Location Number 3");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-To Location Number 4");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Ordering Provider");
                                  this.add(XTN.class, false, 2, 0, new Object[]{ getMessage() }, "Order Callback Phone Number");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Placer Field 1");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Placer Field 2");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Filler Field 1 +");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Filler Field 2 +");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Results Rpt/Status Chng - Date/Time +");
                                  this.add(MOC.class, false, 1, 0, new Object[]{ getMessage() }, "Charge to Practice +");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(74) }, "Diagnostic Serv Sect ID");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(123) }, "Result Status +");
                                  this.add(PRL.class, false, 1, 0, new Object[]{ getMessage() }, "Parent Result +");
                                  this.add(NULLDT.class, false, 0, 0, new Object[]{ getMessage() }, "Deliver-To Location Number 5");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Result Copies To");
                                  this.add(EIP.class, false, 1, 0, new Object[]{ getMessage() }, "Parent  Results Observation Identifier");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(124) }, "Transportation Mode");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Reason for Study");
                                  this.add(NDL.class, false, 1, 0, new Object[]{ getMessage() }, "Principal Result Interpreter +");
                                  this.add(NDL.class, false, 0, 0, new Object[]{ getMessage() }, "Assistant Result Interpreter +");
                                  this.add(NDL.class, false, 0, 0, new Object[]{ getMessage() }, "Technician +");
                                  this.add(NDL.class, false, 0, 0, new Object[]{ getMessage() }, "Transcriptionist +");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Scheduled Date/Time +");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Sample Containers *");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Transport Logistics of Collected Sample *");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Collector's Comment *");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Transport Arrangement Responsibility");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(224) }, "Transport Arranged");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(225) }, "Escort Required");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Planned Patient Transport Comment");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(CNE.class, false, 0, 0, new Object[]{ getMessage() }, "Procedure Code Modifier");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Placer Supplemental Service Information");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Filler Supplemental Service Information");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Medically Necessary Duplicate Procedure Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Result Handling");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Parent Universal Service Identifier");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Observation Group ID");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Parent Observation Group ID");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Alternate Placer Order Number");
                                  this.add(EIP.class, false, 1, 0, new Object[]{ getMessage() }, "Parent Order");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OBR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OBR-1: "Set ID - OBR" - creates it if necessary
     */
    public SI getSetIDOBR() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-1: "Set ID - OBR" - creates it if necessary
     */
    public SI getObr1_SetIDOBR() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-2: "Placer Order Number" - creates it if necessary
     */
    public EI getPlacerOrderNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-2: "Placer Order Number" - creates it if necessary
     */
    public EI getObr2_PlacerOrderNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-3: "Filler Order Number" - creates it if necessary
     */
    public EI getFillerOrderNumber() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-3: "Filler Order Number" - creates it if necessary
     */
    public EI getObr3_FillerOrderNumber() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-4: "Universal Service Identifier" - creates it if necessary
     */
    public CWE getUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-4: "Universal Service Identifier" - creates it if necessary
     */
    public CWE getObr4_UniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-5: "Deliver-To Location" - creates it if necessary
     */
    public NULLDT getDeliverToLocation() { 
		NULLDT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-5: "Deliver-To Location" - creates it if necessary
     */
    public NULLDT getObr5_DeliverToLocation() { 
		NULLDT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-6: "Deliver-To Location Number 2" - creates it if necessary
     */
    public NULLDT getDeliverToLocationNumber2() { 
		NULLDT retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-6: "Deliver-To Location Number 2" - creates it if necessary
     */
    public NULLDT getObr6_DeliverToLocationNumber2() { 
		NULLDT retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-7: "Observation Date/Time #" - creates it if necessary
     */
    public DTM getObservationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-7: "Observation Date/Time #" - creates it if necessary
     */
    public DTM getObr7_ObservationDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-8: "Observation End Date/Time #" - creates it if necessary
     */
    public DTM getObservationEndDateTime() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-8: "Observation End Date/Time #" - creates it if necessary
     */
    public DTM getObr8_ObservationEndDateTime() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-9: "Collection Volume *" - creates it if necessary
     */
    public CQ getCollectionVolume() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-9: "Collection Volume *" - creates it if necessary
     */
    public CQ getObr9_CollectionVolume() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Collector Identifier * (OBR-10).
     */
    public XCN[] getCollectorIdentifier() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Collector Identifier * (OBR-10).
     */
    public XCN[] getObr10_CollectorIdentifier() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Collector Identifier * (OBR-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCollectorIdentifierReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * OBR-10: "Collector Identifier *" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCollectorIdentifier(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-10: "Collector Identifier *" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getObr10_CollectorIdentifier(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Collector Identifier * (OBR-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr10_CollectorIdentifierReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "Collector Identifier *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "Collector Identifier *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertObr10_CollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "Collector Identifier *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "Collector Identifier *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeObr10_CollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * OBR-11: "Specimen Action Code *" - creates it if necessary
     */
    public ID getSpecimenActionCode() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-11: "Specimen Action Code *" - creates it if necessary
     */
    public ID getObr11_SpecimenActionCode() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-12: "Danger Code" - creates it if necessary
     */
    public CWE getDangerCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-12: "Danger Code" - creates it if necessary
     */
    public CWE getObr12_DangerCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Relevant Clinical Information (OBR-13).
     */
    public CWE[] getRelevantClinicalInformation() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Relevant Clinical Information (OBR-13).
     */
    public CWE[] getObr13_RelevantClinicalInformation() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Relevant Clinical Information (OBR-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRelevantClinicalInformationReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * OBR-13: "Relevant Clinical Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRelevantClinicalInformation(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-13: "Relevant Clinical Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr13_RelevantClinicalInformation(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Relevant Clinical Information (OBR-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr13_RelevantClinicalInformationReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * OBR-13: "Relevant Clinical Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRelevantClinicalInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-13: "Relevant Clinical Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr13_RelevantClinicalInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OBR-13: "Relevant Clinical Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRelevantClinicalInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * OBR-13: "Relevant Clinical Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr13_RelevantClinicalInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * OBR-14: "Deliver-To Location Number 3" - creates it if necessary
     */
    public NULLDT getDeliverToLocationNumber3() { 
		NULLDT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-14: "Deliver-To Location Number 3" - creates it if necessary
     */
    public NULLDT getObr14_DeliverToLocationNumber3() { 
		NULLDT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-15: "Deliver-To Location Number 4" - creates it if necessary
     */
    public NULLDT getDeliverToLocationNumber4() { 
		NULLDT retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-15: "Deliver-To Location Number 4" - creates it if necessary
     */
    public NULLDT getObr15_DeliverToLocationNumber4() { 
		NULLDT retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider (OBR-16).
     */
    public XCN[] getOrderingProvider() {
    	XCN[] retVal = this.getTypedField(16, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider (OBR-16).
     */
    public XCN[] getObr16_OrderingProvider() {
    	XCN[] retVal = this.getTypedField(16, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Provider (OBR-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingProviderReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * OBR-16: "Ordering Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrderingProvider(int rep) { 
		XCN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-16: "Ordering Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getObr16_OrderingProvider(int rep) { 
		XCN retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Provider (OBR-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr16_OrderingProviderReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * OBR-16: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-16: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertObr16_OrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OBR-16: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * OBR-16: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeObr16_OrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(16, rep);
    }



    /**
     * Returns all repetitions of Order Callback Phone Number (OBR-17).
     */
    public XTN[] getOrderCallbackPhoneNumber() {
    	XTN[] retVal = this.getTypedField(17, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Order Callback Phone Number (OBR-17).
     */
    public XTN[] getObr17_OrderCallbackPhoneNumber() {
    	XTN[] retVal = this.getTypedField(17, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Order Callback Phone Number (OBR-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderCallbackPhoneNumberReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * OBR-17: "Order Callback Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getOrderCallbackPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-17: "Order Callback Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getObr17_OrderCallbackPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Order Callback Phone Number (OBR-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr17_OrderCallbackPhoneNumberReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertOrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertObr17_OrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeOrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeObr17_OrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * OBR-18: "Placer Field 1" - creates it if necessary
     */
    public ST getPlacerField1() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-18: "Placer Field 1" - creates it if necessary
     */
    public ST getObr18_PlacerField1() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-19: "Placer Field 2" - creates it if necessary
     */
    public ST getPlacerField2() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-19: "Placer Field 2" - creates it if necessary
     */
    public ST getObr19_PlacerField2() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-20: "Filler Field 1 +" - creates it if necessary
     */
    public ST getFillerField1() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-20: "Filler Field 1 +" - creates it if necessary
     */
    public ST getObr20_FillerField1() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-21: "Filler Field 2 +" - creates it if necessary
     */
    public ST getFillerField2() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-21: "Filler Field 2 +" - creates it if necessary
     */
    public ST getObr21_FillerField2() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-22: "Results Rpt/Status Chng - Date/Time +" - creates it if necessary
     */
    public DTM getResultsRptStatusChngDateTime() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-22: "Results Rpt/Status Chng - Date/Time +" - creates it if necessary
     */
    public DTM getObr22_ResultsRptStatusChngDateTime() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-23: "Charge to Practice +" - creates it if necessary
     */
    public MOC getChargeToPractice() { 
		MOC retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-23: "Charge to Practice +" - creates it if necessary
     */
    public MOC getObr23_ChargeToPractice() { 
		MOC retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-24: "Diagnostic Serv Sect ID" - creates it if necessary
     */
    public ID getDiagnosticServSectID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-24: "Diagnostic Serv Sect ID" - creates it if necessary
     */
    public ID getObr24_DiagnosticServSectID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-25: "Result Status +" - creates it if necessary
     */
    public ID getResultStatus() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-25: "Result Status +" - creates it if necessary
     */
    public ID getObr25_ResultStatus() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-26: "Parent Result +" - creates it if necessary
     */
    public PRL getParentResult() { 
		PRL retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-26: "Parent Result +" - creates it if necessary
     */
    public PRL getObr26_ParentResult() { 
		PRL retVal = this.getTypedField(26, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Deliver-To Location Number 5 (OBR-27).
     */
    public NULLDT[] getDeliverToLocationNumber5() {
    	NULLDT[] retVal = this.getTypedField(27, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Deliver-To Location Number 5 (OBR-27).
     */
    public NULLDT[] getObr27_DeliverToLocationNumber5() {
    	NULLDT[] retVal = this.getTypedField(27, new NULLDT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Deliver-To Location Number 5 (OBR-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDeliverToLocationNumber5Reps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * OBR-27: "Deliver-To Location Number 5" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getDeliverToLocationNumber5(int rep) { 
		NULLDT retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-27: "Deliver-To Location Number 5" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NULLDT getObr27_DeliverToLocationNumber5(int rep) { 
		NULLDT retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Deliver-To Location Number 5 (OBR-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr27_DeliverToLocationNumber5Reps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * OBR-27: "Deliver-To Location Number 5" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertDeliverToLocationNumber5(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-27: "Deliver-To Location Number 5" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT insertObr27_DeliverToLocationNumber5(int rep) throws HL7Exception { 
        return (NULLDT) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OBR-27: "Deliver-To Location Number 5" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeDeliverToLocationNumber5(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OBR-27: "Deliver-To Location Number 5" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NULLDT removeObr27_DeliverToLocationNumber5(int rep) throws HL7Exception { 
        return (NULLDT) super.removeRepetition(27, rep);
    }



    /**
     * Returns all repetitions of Result Copies To (OBR-28).
     */
    public XCN[] getResultCopiesTo() {
    	XCN[] retVal = this.getTypedField(28, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Result Copies To (OBR-28).
     */
    public XCN[] getObr28_ResultCopiesTo() {
    	XCN[] retVal = this.getTypedField(28, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Result Copies To (OBR-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getResultCopiesToReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * OBR-28: "Result Copies To" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getResultCopiesTo(int rep) { 
		XCN retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-28: "Result Copies To" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getObr28_ResultCopiesTo(int rep) { 
		XCN retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Result Copies To (OBR-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr28_ResultCopiesToReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertResultCopiesTo(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertObr28_ResultCopiesTo(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeResultCopiesTo(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeObr28_ResultCopiesTo(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(28, rep);
    }




    /**
     * Returns
     * OBR-29: "Parent  Results Observation Identifier" - creates it if necessary
     */
    public EIP getParentResultsObservationIdentifier() { 
		EIP retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-29: "Parent  Results Observation Identifier" - creates it if necessary
     */
    public EIP getObr29_ParentResultsObservationIdentifier() { 
		EIP retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-30: "Transportation Mode" - creates it if necessary
     */
    public ID getTransportationMode() { 
		ID retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-30: "Transportation Mode" - creates it if necessary
     */
    public ID getObr30_TransportationMode() { 
		ID retVal = this.getTypedField(30, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Reason for Study (OBR-31).
     */
    public CWE[] getReasonForStudy() {
    	CWE[] retVal = this.getTypedField(31, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reason for Study (OBR-31).
     */
    public CWE[] getObr31_ReasonForStudy() {
    	CWE[] retVal = this.getTypedField(31, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Reason for Study (OBR-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReasonForStudyReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * OBR-31: "Reason for Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getReasonForStudy(int rep) { 
		CWE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-31: "Reason for Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr31_ReasonForStudy(int rep) { 
		CWE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Reason for Study (OBR-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr31_ReasonForStudyReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "Reason for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertReasonForStudy(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "Reason for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr31_ReasonForStudy(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "Reason for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeReasonForStudy(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "Reason for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr31_ReasonForStudy(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(31, rep);
    }




    /**
     * Returns
     * OBR-32: "Principal Result Interpreter +" - creates it if necessary
     */
    public NDL getPrincipalResultInterpreter() { 
		NDL retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-32: "Principal Result Interpreter +" - creates it if necessary
     */
    public NDL getObr32_PrincipalResultInterpreter() { 
		NDL retVal = this.getTypedField(32, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Assistant Result Interpreter + (OBR-33).
     */
    public NDL[] getAssistantResultInterpreter() {
    	NDL[] retVal = this.getTypedField(33, new NDL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Assistant Result Interpreter + (OBR-33).
     */
    public NDL[] getObr33_AssistantResultInterpreter() {
    	NDL[] retVal = this.getTypedField(33, new NDL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Assistant Result Interpreter + (OBR-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAssistantResultInterpreterReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * OBR-33: "Assistant Result Interpreter +" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NDL getAssistantResultInterpreter(int rep) { 
		NDL retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-33: "Assistant Result Interpreter +" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NDL getObr33_AssistantResultInterpreter(int rep) { 
		NDL retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Assistant Result Interpreter + (OBR-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr33_AssistantResultInterpreterReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * OBR-33: "Assistant Result Interpreter +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL insertAssistantResultInterpreter(int rep) throws HL7Exception { 
        return (NDL) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-33: "Assistant Result Interpreter +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL insertObr33_AssistantResultInterpreter(int rep) throws HL7Exception { 
        return (NDL) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * OBR-33: "Assistant Result Interpreter +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL removeAssistantResultInterpreter(int rep) throws HL7Exception { 
        return (NDL) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * OBR-33: "Assistant Result Interpreter +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL removeObr33_AssistantResultInterpreter(int rep) throws HL7Exception { 
        return (NDL) super.removeRepetition(33, rep);
    }



    /**
     * Returns all repetitions of Technician + (OBR-34).
     */
    public NDL[] getTechnician() {
    	NDL[] retVal = this.getTypedField(34, new NDL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Technician + (OBR-34).
     */
    public NDL[] getObr34_Technician() {
    	NDL[] retVal = this.getTypedField(34, new NDL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Technician + (OBR-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTechnicianReps() {
    	return this.getReps(34);
    }


    /**
     * Returns a specific repetition of
     * OBR-34: "Technician +" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NDL getTechnician(int rep) { 
		NDL retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-34: "Technician +" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NDL getObr34_Technician(int rep) { 
		NDL retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Technician + (OBR-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr34_TechnicianReps() {
    	return this.getReps(34);
    }


    /**
     * Inserts a repetition of
     * OBR-34: "Technician +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL insertTechnician(int rep) throws HL7Exception { 
        return (NDL) super.insertRepetition(34, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-34: "Technician +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL insertObr34_Technician(int rep) throws HL7Exception { 
        return (NDL) super.insertRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OBR-34: "Technician +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL removeTechnician(int rep) throws HL7Exception { 
        return (NDL) super.removeRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OBR-34: "Technician +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL removeObr34_Technician(int rep) throws HL7Exception { 
        return (NDL) super.removeRepetition(34, rep);
    }



    /**
     * Returns all repetitions of Transcriptionist + (OBR-35).
     */
    public NDL[] getTranscriptionist() {
    	NDL[] retVal = this.getTypedField(35, new NDL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Transcriptionist + (OBR-35).
     */
    public NDL[] getObr35_Transcriptionist() {
    	NDL[] retVal = this.getTypedField(35, new NDL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Transcriptionist + (OBR-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTranscriptionistReps() {
    	return this.getReps(35);
    }


    /**
     * Returns a specific repetition of
     * OBR-35: "Transcriptionist +" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NDL getTranscriptionist(int rep) { 
		NDL retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-35: "Transcriptionist +" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NDL getObr35_Transcriptionist(int rep) { 
		NDL retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Transcriptionist + (OBR-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr35_TranscriptionistReps() {
    	return this.getReps(35);
    }


    /**
     * Inserts a repetition of
     * OBR-35: "Transcriptionist +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL insertTranscriptionist(int rep) throws HL7Exception { 
        return (NDL) super.insertRepetition(35, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-35: "Transcriptionist +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL insertObr35_Transcriptionist(int rep) throws HL7Exception { 
        return (NDL) super.insertRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OBR-35: "Transcriptionist +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL removeTranscriptionist(int rep) throws HL7Exception { 
        return (NDL) super.removeRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OBR-35: "Transcriptionist +" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NDL removeObr35_Transcriptionist(int rep) throws HL7Exception { 
        return (NDL) super.removeRepetition(35, rep);
    }




    /**
     * Returns
     * OBR-36: "Scheduled Date/Time +" - creates it if necessary
     */
    public DTM getScheduledDateTime() { 
		DTM retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-36: "Scheduled Date/Time +" - creates it if necessary
     */
    public DTM getObr36_ScheduledDateTime() { 
		DTM retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-37: "Number of Sample Containers *" - creates it if necessary
     */
    public NM getNumberOfSampleContainers() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-37: "Number of Sample Containers *" - creates it if necessary
     */
    public NM getObr37_NumberOfSampleContainers() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Transport Logistics of Collected Sample * (OBR-38).
     */
    public CWE[] getTransportLogisticsOfCollectedSample() {
    	CWE[] retVal = this.getTypedField(38, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Transport Logistics of Collected Sample * (OBR-38).
     */
    public CWE[] getObr38_TransportLogisticsOfCollectedSample() {
    	CWE[] retVal = this.getTypedField(38, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Transport Logistics of Collected Sample * (OBR-38).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTransportLogisticsOfCollectedSampleReps() {
    	return this.getReps(38);
    }


    /**
     * Returns a specific repetition of
     * OBR-38: "Transport Logistics of Collected Sample *" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getTransportLogisticsOfCollectedSample(int rep) { 
		CWE retVal = this.getTypedField(38, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-38: "Transport Logistics of Collected Sample *" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr38_TransportLogisticsOfCollectedSample(int rep) { 
		CWE retVal = this.getTypedField(38, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Transport Logistics of Collected Sample * (OBR-38).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr38_TransportLogisticsOfCollectedSampleReps() {
    	return this.getReps(38);
    }


    /**
     * Inserts a repetition of
     * OBR-38: "Transport Logistics of Collected Sample *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertTransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(38, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-38: "Transport Logistics of Collected Sample *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr38_TransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(38, rep);
    }


    /**
     * Removes a repetition of
     * OBR-38: "Transport Logistics of Collected Sample *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeTransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(38, rep);
    }


    /**
     * Removes a repetition of
     * OBR-38: "Transport Logistics of Collected Sample *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr38_TransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(38, rep);
    }



    /**
     * Returns all repetitions of Collector's Comment * (OBR-39).
     */
    public CWE[] getCollectorSComment() {
    	CWE[] retVal = this.getTypedField(39, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Collector's Comment * (OBR-39).
     */
    public CWE[] getObr39_CollectorSComment() {
    	CWE[] retVal = this.getTypedField(39, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Collector's Comment * (OBR-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCollectorSCommentReps() {
    	return this.getReps(39);
    }


    /**
     * Returns a specific repetition of
     * OBR-39: "Collector's Comment *" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCollectorSComment(int rep) { 
		CWE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-39: "Collector's Comment *" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr39_CollectorSComment(int rep) { 
		CWE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Collector's Comment * (OBR-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr39_CollectorSCommentReps() {
    	return this.getReps(39);
    }


    /**
     * Inserts a repetition of
     * OBR-39: "Collector's Comment *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCollectorSComment(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(39, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-39: "Collector's Comment *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr39_CollectorSComment(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * OBR-39: "Collector's Comment *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCollectorSComment(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * OBR-39: "Collector's Comment *" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr39_CollectorSComment(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(39, rep);
    }




    /**
     * Returns
     * OBR-40: "Transport Arrangement Responsibility" - creates it if necessary
     */
    public CWE getTransportArrangementResponsibility() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-40: "Transport Arrangement Responsibility" - creates it if necessary
     */
    public CWE getObr40_TransportArrangementResponsibility() { 
		CWE retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-41: "Transport Arranged" - creates it if necessary
     */
    public ID getTransportArranged() { 
		ID retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-41: "Transport Arranged" - creates it if necessary
     */
    public ID getObr41_TransportArranged() { 
		ID retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-42: "Escort Required" - creates it if necessary
     */
    public ID getEscortRequired() { 
		ID retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-42: "Escort Required" - creates it if necessary
     */
    public ID getObr42_EscortRequired() { 
		ID retVal = this.getTypedField(42, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Planned Patient Transport Comment (OBR-43).
     */
    public CWE[] getPlannedPatientTransportComment() {
    	CWE[] retVal = this.getTypedField(43, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Planned Patient Transport Comment (OBR-43).
     */
    public CWE[] getObr43_PlannedPatientTransportComment() {
    	CWE[] retVal = this.getTypedField(43, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Planned Patient Transport Comment (OBR-43).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlannedPatientTransportCommentReps() {
    	return this.getReps(43);
    }


    /**
     * Returns a specific repetition of
     * OBR-43: "Planned Patient Transport Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPlannedPatientTransportComment(int rep) { 
		CWE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-43: "Planned Patient Transport Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr43_PlannedPatientTransportComment(int rep) { 
		CWE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Planned Patient Transport Comment (OBR-43).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr43_PlannedPatientTransportCommentReps() {
    	return this.getReps(43);
    }


    /**
     * Inserts a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(43, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr43_PlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr43_PlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(43, rep);
    }




    /**
     * Returns
     * OBR-44: "Procedure Code" - creates it if necessary
     */
    public CNE getProcedureCode() { 
		CNE retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-44: "Procedure Code" - creates it if necessary
     */
    public CNE getObr44_ProcedureCode() { 
		CNE retVal = this.getTypedField(44, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (OBR-45).
     */
    public CNE[] getProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(45, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (OBR-45).
     */
    public CNE[] getObr45_ProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(45, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (OBR-45).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeModifierReps() {
    	return this.getReps(45);
    }


    /**
     * Returns a specific repetition of
     * OBR-45: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(45, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-45: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getObr45_ProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(45, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (OBR-45).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr45_ProcedureCodeModifierReps() {
    	return this.getReps(45);
    }


    /**
     * Inserts a repetition of
     * OBR-45: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(45, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-45: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertObr45_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(45, rep);
    }


    /**
     * Removes a repetition of
     * OBR-45: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(45, rep);
    }


    /**
     * Removes a repetition of
     * OBR-45: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeObr45_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(45, rep);
    }



    /**
     * Returns all repetitions of Placer Supplemental Service Information (OBR-46).
     */
    public CWE[] getPlacerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(46, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Supplemental Service Information (OBR-46).
     */
    public CWE[] getObr46_PlacerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(46, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Supplemental Service Information (OBR-46).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerSupplementalServiceInformationReps() {
    	return this.getReps(46);
    }


    /**
     * Returns a specific repetition of
     * OBR-46: "Placer Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPlacerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(46, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-46: "Placer Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr46_PlacerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(46, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Supplemental Service Information (OBR-46).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr46_PlacerSupplementalServiceInformationReps() {
    	return this.getReps(46);
    }


    /**
     * Inserts a repetition of
     * OBR-46: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(46, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-46: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr46_PlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(46, rep);
    }


    /**
     * Removes a repetition of
     * OBR-46: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(46, rep);
    }


    /**
     * Removes a repetition of
     * OBR-46: "Placer Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr46_PlacerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(46, rep);
    }



    /**
     * Returns all repetitions of Filler Supplemental Service Information (OBR-47).
     */
    public CWE[] getFillerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(47, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Filler Supplemental Service Information (OBR-47).
     */
    public CWE[] getObr47_FillerSupplementalServiceInformation() {
    	CWE[] retVal = this.getTypedField(47, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Filler Supplemental Service Information (OBR-47).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFillerSupplementalServiceInformationReps() {
    	return this.getReps(47);
    }


    /**
     * Returns a specific repetition of
     * OBR-47: "Filler Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getFillerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(47, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-47: "Filler Supplemental Service Information" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getObr47_FillerSupplementalServiceInformation(int rep) { 
		CWE retVal = this.getTypedField(47, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Filler Supplemental Service Information (OBR-47).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr47_FillerSupplementalServiceInformationReps() {
    	return this.getReps(47);
    }


    /**
     * Inserts a repetition of
     * OBR-47: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertFillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(47, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-47: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertObr47_FillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(47, rep);
    }


    /**
     * Removes a repetition of
     * OBR-47: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeFillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(47, rep);
    }


    /**
     * Removes a repetition of
     * OBR-47: "Filler Supplemental Service Information" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeObr47_FillerSupplementalServiceInformation(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(47, rep);
    }




    /**
     * Returns
     * OBR-48: "Medically Necessary Duplicate Procedure Reason" - creates it if necessary
     */
    public CWE getMedicallyNecessaryDuplicateProcedureReason() { 
		CWE retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-48: "Medically Necessary Duplicate Procedure Reason" - creates it if necessary
     */
    public CWE getObr48_MedicallyNecessaryDuplicateProcedureReason() { 
		CWE retVal = this.getTypedField(48, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-49: "Result Handling" - creates it if necessary
     */
    public CWE getResultHandling() { 
		CWE retVal = this.getTypedField(49, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-49: "Result Handling" - creates it if necessary
     */
    public CWE getObr49_ResultHandling() { 
		CWE retVal = this.getTypedField(49, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-50: "Parent Universal Service Identifier" - creates it if necessary
     */
    public CWE getParentUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(50, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-50: "Parent Universal Service Identifier" - creates it if necessary
     */
    public CWE getObr50_ParentUniversalServiceIdentifier() { 
		CWE retVal = this.getTypedField(50, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-51: "Observation Group ID" - creates it if necessary
     */
    public EI getObservationGroupID() { 
		EI retVal = this.getTypedField(51, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-51: "Observation Group ID" - creates it if necessary
     */
    public EI getObr51_ObservationGroupID() { 
		EI retVal = this.getTypedField(51, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-52: "Parent Observation Group ID" - creates it if necessary
     */
    public EI getParentObservationGroupID() { 
		EI retVal = this.getTypedField(52, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-52: "Parent Observation Group ID" - creates it if necessary
     */
    public EI getObr52_ParentObservationGroupID() { 
		EI retVal = this.getTypedField(52, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Alternate Placer Order Number (OBR-53).
     */
    public CX[] getAlternatePlacerOrderNumber() {
    	CX[] retVal = this.getTypedField(53, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Alternate Placer Order Number (OBR-53).
     */
    public CX[] getObr53_AlternatePlacerOrderNumber() {
    	CX[] retVal = this.getTypedField(53, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Alternate Placer Order Number (OBR-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAlternatePlacerOrderNumberReps() {
    	return this.getReps(53);
    }


    /**
     * Returns a specific repetition of
     * OBR-53: "Alternate Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getAlternatePlacerOrderNumber(int rep) { 
		CX retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-53: "Alternate Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getObr53_AlternatePlacerOrderNumber(int rep) { 
		CX retVal = this.getTypedField(53, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Alternate Placer Order Number (OBR-53).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr53_AlternatePlacerOrderNumberReps() {
    	return this.getReps(53);
    }


    /**
     * Inserts a repetition of
     * OBR-53: "Alternate Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertAlternatePlacerOrderNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(53, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-53: "Alternate Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertObr53_AlternatePlacerOrderNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * OBR-53: "Alternate Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeAlternatePlacerOrderNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(53, rep);
    }


    /**
     * Removes a repetition of
     * OBR-53: "Alternate Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeObr53_AlternatePlacerOrderNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(53, rep);
    }




    /**
     * Returns
     * OBR-54: "Parent Order" - creates it if necessary
     */
    public EIP getParentOrder() { 
		EIP retVal = this.getTypedField(54, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-54: "Parent Order" - creates it if necessary
     */
    public EIP getObr54_ParentOrder() { 
		EIP retVal = this.getTypedField(54, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new NULLDT(getMessage());
          case 5: return new NULLDT(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new CQ(getMessage());
          case 9: return new XCN(getMessage());
          case 10: return new ID(getMessage(), new Integer( 65 ));
          case 11: return new CWE(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new NULLDT(getMessage());
          case 14: return new NULLDT(getMessage());
          case 15: return new XCN(getMessage());
          case 16: return new XTN(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new DTM(getMessage());
          case 22: return new MOC(getMessage());
          case 23: return new ID(getMessage(), new Integer( 74 ));
          case 24: return new ID(getMessage(), new Integer( 123 ));
          case 25: return new PRL(getMessage());
          case 26: return new NULLDT(getMessage());
          case 27: return new XCN(getMessage());
          case 28: return new EIP(getMessage());
          case 29: return new ID(getMessage(), new Integer( 124 ));
          case 30: return new CWE(getMessage());
          case 31: return new NDL(getMessage());
          case 32: return new NDL(getMessage());
          case 33: return new NDL(getMessage());
          case 34: return new NDL(getMessage());
          case 35: return new DTM(getMessage());
          case 36: return new NM(getMessage());
          case 37: return new CWE(getMessage());
          case 38: return new CWE(getMessage());
          case 39: return new CWE(getMessage());
          case 40: return new ID(getMessage(), new Integer( 224 ));
          case 41: return new ID(getMessage(), new Integer( 225 ));
          case 42: return new CWE(getMessage());
          case 43: return new CNE(getMessage());
          case 44: return new CNE(getMessage());
          case 45: return new CWE(getMessage());
          case 46: return new CWE(getMessage());
          case 47: return new CWE(getMessage());
          case 48: return new CWE(getMessage());
          case 49: return new CWE(getMessage());
          case 50: return new EI(getMessage());
          case 51: return new EI(getMessage());
          case 52: return new CX(getMessage());
          case 53: return new EIP(getMessage());
          default: return null;
       }
   }


}

