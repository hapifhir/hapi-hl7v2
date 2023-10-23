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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 OBR message segment (Observation request segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OBR-1: Set ID - Observation Request (SI) <b>optional </b>
     * <li>OBR-2: Placer Order Number (EI) <b>optional repeating</b>
     * <li>OBR-3: Filler Order Number (EI) <b>optional </b>
     * <li>OBR-4: Universal Service Identifier (CE) <b> </b>
     * <li>OBR-5: Priority (ID) <b>optional </b>
     * <li>OBR-6: Requested Date/Time (TS) <b>optional </b>
     * <li>OBR-7: Observation Date/Time (TS) <b>optional </b>
     * <li>OBR-8: Observation End Date/Time (TS) <b>optional </b>
     * <li>OBR-9: Collection Volume (CQ) <b>optional </b>
     * <li>OBR-10: Collector Identifier (XCN) <b>optional repeating</b>
     * <li>OBR-11: Specimen Action Code (ID) <b>optional </b>
     * <li>OBR-12: Danger Code (CE) <b>optional </b>
     * <li>OBR-13: Relevant Clinical Information (ST) <b>optional </b>
     * <li>OBR-14: Specimen Received Date/Time (TS) <b>optional </b>
     * <li>OBR-15: Specimen Source (CM_SPS) <b>optional </b>
     * <li>OBR-16: Ordering Provider (XCN) <b>optional repeating</b>
     * <li>OBR-17: Order Callback Phone Number (XTN) <b>optional repeating</b>
     * <li>OBR-18: Placer Field 1 (ST) <b>optional </b>
     * <li>OBR-19: Placer Field 2 (ST) <b>optional </b>
     * <li>OBR-20: Filler Field 1 (ST) <b>optional </b>
     * <li>OBR-21: Filler Field 2 (ST) <b>optional </b>
     * <li>OBR-22: Results Rpt/Status Chng - Date/Time (TS) <b>optional </b>
     * <li>OBR-23: Charge To Practice (CM_MOC) <b>optional </b>
     * <li>OBR-24: Diagnostic Service Section ID (ID) <b>optional </b>
     * <li>OBR-25: Result Status (ID) <b>optional </b>
     * <li>OBR-26: Parent Result (CM_PRL) <b>optional </b>
     * <li>OBR-27: Quantity/Timing (TQ) <b> </b>
     * <li>OBR-28: Result Copies To (XCN) <b>optional repeating</b>
     * <li>OBR-29: Parent Number (CM_EIP) <b>optional </b>
     * <li>OBR-30: Transportation Mode (ID) <b>optional </b>
     * <li>OBR-31: Reason For Study (CE) <b>optional repeating</b>
     * <li>OBR-32: Principal Result Interpreter (CM_NDL) <b>optional </b>
     * <li>OBR-33: Assistant Result Interpreter (CM_NDL) <b>optional repeating</b>
     * <li>OBR-34: Technician (CM_NDL) <b>optional repeating</b>
     * <li>OBR-35: Transcriptionist (CM_NDL) <b>optional repeating</b>
     * <li>OBR-36: Scheduled Date/Time (TS) <b>optional </b>
     * <li>OBR-37: Number Of Sample Containers (NM) <b>optional </b>
     * <li>OBR-38: Transport Logistics Of Collected Sample (CE) <b>optional repeating</b>
     * <li>OBR-39: Collector’s Comment (CE) <b>optional repeating</b>
     * <li>OBR-40: Transport Arrangement Responsibility (CE) <b>optional </b>
     * <li>OBR-41: Transport Arranged (ID) <b>optional </b>
     * <li>OBR-42: Escort Required (ID) <b>optional </b>
     * <li>OBR-43: Planned Patient Transport Comment (CE) <b>optional repeating</b>
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
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - Observation Request");
                                  this.add(EI.class, false, 0, 22, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(CE.class, true, 1, 200, new Object[]{ getMessage() }, "Universal Service Identifier");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "Priority");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Requested Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Observation Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Observation End Date/Time");
                                  this.add(CQ.class, false, 1, 20, new Object[]{ getMessage() }, "Collection Volume");
                                  this.add(XCN.class, false, 0, 60, new Object[]{ getMessage() }, "Collector Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(65) }, "Specimen Action Code");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Danger Code");
                                  this.add(ST.class, false, 1, 300, new Object[]{ getMessage() }, "Relevant Clinical Information");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Specimen Received Date/Time");
                                  this.add(CM_SPS.class, false, 1, 300, new Object[]{ getMessage() }, "Specimen Source");
                                  this.add(XCN.class, false, 0, 120, new Object[]{ getMessage() }, "Ordering Provider");
                                  this.add(XTN.class, false, 2, 40, new Object[]{ getMessage() }, "Order Callback Phone Number");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Placer Field 1");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Placer Field 2");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Filler Field 1");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Filler Field 2");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Results Rpt/Status Chng - Date/Time");
                                  this.add(CM_MOC.class, false, 1, 40, new Object[]{ getMessage() }, "Charge To Practice");
                                              this.add(ID.class, false, 1, 10, new Object[]{ getMessage(), new Integer(74) }, "Diagnostic Service Section ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(123) }, "Result Status");
                                  this.add(CM_PRL.class, false, 1, 200, new Object[]{ getMessage() }, "Parent Result");
                                  this.add(TQ.class, true, 1, 200, new Object[]{ getMessage() }, "Quantity/Timing");
                                  this.add(XCN.class, false, 5, 150, new Object[]{ getMessage() }, "Result Copies To");
                                  this.add(CM_EIP.class, false, 1, 150, new Object[]{ getMessage() }, "Parent Number");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(124) }, "Transportation Mode");
                                  this.add(CE.class, false, 0, 300, new Object[]{ getMessage() }, "Reason For Study");
                                  this.add(CM_NDL.class, false, 1, 200, new Object[]{ getMessage() }, "Principal Result Interpreter");
                                  this.add(CM_NDL.class, false, 0, 200, new Object[]{ getMessage() }, "Assistant Result Interpreter");
                                  this.add(CM_NDL.class, false, 0, 200, new Object[]{ getMessage() }, "Technician");
                                  this.add(CM_NDL.class, false, 0, 200, new Object[]{ getMessage() }, "Transcriptionist");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Scheduled Date/Time");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Number Of Sample Containers");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Transport Logistics Of Collected Sample");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Collector’s Comment");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Transport Arrangement Responsibility");
                                              this.add(ID.class, false, 1, 30, new Object[]{ getMessage(), new Integer(224) }, "Transport Arranged");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(225) }, "Escort Required");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Planned Patient Transport Comment");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OBR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OBR-1: "Set ID - Observation Request" - creates it if necessary
     */
    public SI getSetIDObservationRequest() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-1: "Set ID - Observation Request" - creates it if necessary
     */
    public SI getObr1_SetIDObservationRequest() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (OBR-2).
     */
    public EI[] getPlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(2, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (OBR-2).
     */
    public EI[] getObr2_PlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(2, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Order Number (OBR-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerOrderNumberReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * OBR-2: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getPlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-2: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getObr2_PlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Order Number (OBR-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr2_PlacerOrderNumberReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * OBR-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertPlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertObr2_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * OBR-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removePlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * OBR-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeObr2_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(2, rep);
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
    public CE getUniversalServiceIdentifier() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-4: "Universal Service Identifier" - creates it if necessary
     */
    public CE getObr4_UniversalServiceIdentifier() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-5: "Priority" - creates it if necessary
     */
    public ID getPriority() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-5: "Priority" - creates it if necessary
     */
    public ID getObr5_Priority() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-6: "Requested Date/Time" - creates it if necessary
     */
    public TS getRequestedDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-6: "Requested Date/Time" - creates it if necessary
     */
    public TS getObr6_RequestedDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-7: "Observation Date/Time" - creates it if necessary
     */
    public TS getObservationDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-7: "Observation Date/Time" - creates it if necessary
     */
    public TS getObr7_ObservationDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-8: "Observation End Date/Time" - creates it if necessary
     */
    public TS getObservationEndDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-8: "Observation End Date/Time" - creates it if necessary
     */
    public TS getObr8_ObservationEndDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-9: "Collection Volume" - creates it if necessary
     */
    public CQ getCollectionVolume() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-9: "Collection Volume" - creates it if necessary
     */
    public CQ getObr9_CollectionVolume() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Collector Identifier (OBR-10).
     */
    public XCN[] getCollectorIdentifier() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Collector Identifier (OBR-10).
     */
    public XCN[] getObr10_CollectorIdentifier() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Collector Identifier (OBR-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCollectorIdentifierReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * OBR-10: "Collector Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getCollectorIdentifier(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-10: "Collector Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getObr10_CollectorIdentifier(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Collector Identifier (OBR-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr10_CollectorIdentifierReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertCollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertObr10_CollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeCollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeObr10_CollectorIdentifier(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * OBR-11: "Specimen Action Code" - creates it if necessary
     */
    public ID getSpecimenActionCode() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-11: "Specimen Action Code" - creates it if necessary
     */
    public ID getObr11_SpecimenActionCode() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-12: "Danger Code" - creates it if necessary
     */
    public CE getDangerCode() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-12: "Danger Code" - creates it if necessary
     */
    public CE getObr12_DangerCode() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-13: "Relevant Clinical Information" - creates it if necessary
     */
    public ST getRelevantClinicalInformation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-13: "Relevant Clinical Information" - creates it if necessary
     */
    public ST getObr13_RelevantClinicalInformation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-14: "Specimen Received Date/Time" - creates it if necessary
     */
    public TS getSpecimenReceivedDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-14: "Specimen Received Date/Time" - creates it if necessary
     */
    public TS getObr14_SpecimenReceivedDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-15: "Specimen Source" - creates it if necessary
     */
    public CM_SPS getSpecimenSource() { 
		CM_SPS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-15: "Specimen Source" - creates it if necessary
     */
    public CM_SPS getObr15_SpecimenSource() { 
		CM_SPS retVal = this.getTypedField(15, 0);
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
     * OBR-20: "Filler Field 1" - creates it if necessary
     */
    public ST getFillerField1() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-20: "Filler Field 1" - creates it if necessary
     */
    public ST getObr20_FillerField1() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-21: "Filler Field 2" - creates it if necessary
     */
    public ST getFillerField2() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-21: "Filler Field 2" - creates it if necessary
     */
    public ST getObr21_FillerField2() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-22: "Results Rpt/Status Chng - Date/Time" - creates it if necessary
     */
    public TS getResultsRptStatusChngDateTime() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-22: "Results Rpt/Status Chng - Date/Time" - creates it if necessary
     */
    public TS getObr22_ResultsRptStatusChngDateTime() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-23: "Charge To Practice" - creates it if necessary
     */
    public CM_MOC getChargeToPractice() { 
		CM_MOC retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-23: "Charge To Practice" - creates it if necessary
     */
    public CM_MOC getObr23_ChargeToPractice() { 
		CM_MOC retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-24: "Diagnostic Service Section ID" - creates it if necessary
     */
    public ID getDiagnosticServiceSectionID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-24: "Diagnostic Service Section ID" - creates it if necessary
     */
    public ID getObr24_DiagnosticServiceSectionID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-25: "Result Status" - creates it if necessary
     */
    public ID getResultStatus() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-25: "Result Status" - creates it if necessary
     */
    public ID getObr25_ResultStatus() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-26: "Parent Result" - creates it if necessary
     */
    public CM_PRL getParentResult() { 
		CM_PRL retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-26: "Parent Result" - creates it if necessary
     */
    public CM_PRL getObr26_ParentResult() { 
		CM_PRL retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-27: "Quantity/Timing" - creates it if necessary
     */
    public TQ getQuantityTiming() { 
		TQ retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-27: "Quantity/Timing" - creates it if necessary
     */
    public TQ getObr27_QuantityTiming() { 
		TQ retVal = this.getTypedField(27, 0);
		return retVal;
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
     * OBR-29: "Parent Number" - creates it if necessary
     */
    public CM_EIP getParentNumber() { 
		CM_EIP retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-29: "Parent Number" - creates it if necessary
     */
    public CM_EIP getObr29_ParentNumber() { 
		CM_EIP retVal = this.getTypedField(29, 0);
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
     * Returns all repetitions of Reason For Study (OBR-31).
     */
    public CE[] getReasonForStudy() {
    	CE[] retVal = this.getTypedField(31, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reason For Study (OBR-31).
     */
    public CE[] getObr31_ReasonForStudy() {
    	CE[] retVal = this.getTypedField(31, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Reason For Study (OBR-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getReasonForStudyReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * OBR-31: "Reason For Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getReasonForStudy(int rep) { 
		CE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-31: "Reason For Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObr31_ReasonForStudy(int rep) { 
		CE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Reason For Study (OBR-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr31_ReasonForStudyReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "Reason For Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "Reason For Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObr31_ReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "Reason For Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "Reason For Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObr31_ReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(31, rep);
    }




    /**
     * Returns
     * OBR-32: "Principal Result Interpreter" - creates it if necessary
     */
    public CM_NDL getPrincipalResultInterpreter() { 
		CM_NDL retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-32: "Principal Result Interpreter" - creates it if necessary
     */
    public CM_NDL getObr32_PrincipalResultInterpreter() { 
		CM_NDL retVal = this.getTypedField(32, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Assistant Result Interpreter (OBR-33).
     */
    public CM_NDL[] getAssistantResultInterpreter() {
    	CM_NDL[] retVal = this.getTypedField(33, new CM_NDL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Assistant Result Interpreter (OBR-33).
     */
    public CM_NDL[] getObr33_AssistantResultInterpreter() {
    	CM_NDL[] retVal = this.getTypedField(33, new CM_NDL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Assistant Result Interpreter (OBR-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAssistantResultInterpreterReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * OBR-33: "Assistant Result Interpreter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_NDL getAssistantResultInterpreter(int rep) { 
		CM_NDL retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-33: "Assistant Result Interpreter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_NDL getObr33_AssistantResultInterpreter(int rep) { 
		CM_NDL retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Assistant Result Interpreter (OBR-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr33_AssistantResultInterpreterReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * OBR-33: "Assistant Result Interpreter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL insertAssistantResultInterpreter(int rep) throws HL7Exception { 
        return (CM_NDL) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-33: "Assistant Result Interpreter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL insertObr33_AssistantResultInterpreter(int rep) throws HL7Exception { 
        return (CM_NDL) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * OBR-33: "Assistant Result Interpreter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL removeAssistantResultInterpreter(int rep) throws HL7Exception { 
        return (CM_NDL) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * OBR-33: "Assistant Result Interpreter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL removeObr33_AssistantResultInterpreter(int rep) throws HL7Exception { 
        return (CM_NDL) super.removeRepetition(33, rep);
    }



    /**
     * Returns all repetitions of Technician (OBR-34).
     */
    public CM_NDL[] getTechnician() {
    	CM_NDL[] retVal = this.getTypedField(34, new CM_NDL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Technician (OBR-34).
     */
    public CM_NDL[] getObr34_Technician() {
    	CM_NDL[] retVal = this.getTypedField(34, new CM_NDL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Technician (OBR-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTechnicianReps() {
    	return this.getReps(34);
    }


    /**
     * Returns a specific repetition of
     * OBR-34: "Technician" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_NDL getTechnician(int rep) { 
		CM_NDL retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-34: "Technician" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_NDL getObr34_Technician(int rep) { 
		CM_NDL retVal = this.getTypedField(34, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Technician (OBR-34).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr34_TechnicianReps() {
    	return this.getReps(34);
    }


    /**
     * Inserts a repetition of
     * OBR-34: "Technician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL insertTechnician(int rep) throws HL7Exception { 
        return (CM_NDL) super.insertRepetition(34, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-34: "Technician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL insertObr34_Technician(int rep) throws HL7Exception { 
        return (CM_NDL) super.insertRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OBR-34: "Technician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL removeTechnician(int rep) throws HL7Exception { 
        return (CM_NDL) super.removeRepetition(34, rep);
    }


    /**
     * Removes a repetition of
     * OBR-34: "Technician" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL removeObr34_Technician(int rep) throws HL7Exception { 
        return (CM_NDL) super.removeRepetition(34, rep);
    }



    /**
     * Returns all repetitions of Transcriptionist (OBR-35).
     */
    public CM_NDL[] getTranscriptionist() {
    	CM_NDL[] retVal = this.getTypedField(35, new CM_NDL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Transcriptionist (OBR-35).
     */
    public CM_NDL[] getObr35_Transcriptionist() {
    	CM_NDL[] retVal = this.getTypedField(35, new CM_NDL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Transcriptionist (OBR-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTranscriptionistReps() {
    	return this.getReps(35);
    }


    /**
     * Returns a specific repetition of
     * OBR-35: "Transcriptionist" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_NDL getTranscriptionist(int rep) { 
		CM_NDL retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-35: "Transcriptionist" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_NDL getObr35_Transcriptionist(int rep) { 
		CM_NDL retVal = this.getTypedField(35, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Transcriptionist (OBR-35).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr35_TranscriptionistReps() {
    	return this.getReps(35);
    }


    /**
     * Inserts a repetition of
     * OBR-35: "Transcriptionist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL insertTranscriptionist(int rep) throws HL7Exception { 
        return (CM_NDL) super.insertRepetition(35, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-35: "Transcriptionist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL insertObr35_Transcriptionist(int rep) throws HL7Exception { 
        return (CM_NDL) super.insertRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OBR-35: "Transcriptionist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL removeTranscriptionist(int rep) throws HL7Exception { 
        return (CM_NDL) super.removeRepetition(35, rep);
    }


    /**
     * Removes a repetition of
     * OBR-35: "Transcriptionist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_NDL removeObr35_Transcriptionist(int rep) throws HL7Exception { 
        return (CM_NDL) super.removeRepetition(35, rep);
    }




    /**
     * Returns
     * OBR-36: "Scheduled Date/Time" - creates it if necessary
     */
    public TS getScheduledDateTime() { 
		TS retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-36: "Scheduled Date/Time" - creates it if necessary
     */
    public TS getObr36_ScheduledDateTime() { 
		TS retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-37: "Number Of Sample Containers" - creates it if necessary
     */
    public NM getNumberOfSampleContainers() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-37: "Number Of Sample Containers" - creates it if necessary
     */
    public NM getObr37_NumberOfSampleContainers() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Transport Logistics Of Collected Sample (OBR-38).
     */
    public CE[] getTransportLogisticsOfCollectedSample() {
    	CE[] retVal = this.getTypedField(38, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Transport Logistics Of Collected Sample (OBR-38).
     */
    public CE[] getObr38_TransportLogisticsOfCollectedSample() {
    	CE[] retVal = this.getTypedField(38, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Transport Logistics Of Collected Sample (OBR-38).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTransportLogisticsOfCollectedSampleReps() {
    	return this.getReps(38);
    }


    /**
     * Returns a specific repetition of
     * OBR-38: "Transport Logistics Of Collected Sample" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getTransportLogisticsOfCollectedSample(int rep) { 
		CE retVal = this.getTypedField(38, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-38: "Transport Logistics Of Collected Sample" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObr38_TransportLogisticsOfCollectedSample(int rep) { 
		CE retVal = this.getTypedField(38, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Transport Logistics Of Collected Sample (OBR-38).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr38_TransportLogisticsOfCollectedSampleReps() {
    	return this.getReps(38);
    }


    /**
     * Inserts a repetition of
     * OBR-38: "Transport Logistics Of Collected Sample" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertTransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(38, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-38: "Transport Logistics Of Collected Sample" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObr38_TransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(38, rep);
    }


    /**
     * Removes a repetition of
     * OBR-38: "Transport Logistics Of Collected Sample" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeTransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(38, rep);
    }


    /**
     * Removes a repetition of
     * OBR-38: "Transport Logistics Of Collected Sample" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObr38_TransportLogisticsOfCollectedSample(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(38, rep);
    }



    /**
     * Returns all repetitions of Collector’s Comment (OBR-39).
     */
    public CE[] getCollectorSComment() {
    	CE[] retVal = this.getTypedField(39, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Collector’s Comment (OBR-39).
     */
    public CE[] getObr39_CollectorSComment() {
    	CE[] retVal = this.getTypedField(39, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Collector’s Comment (OBR-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCollectorSCommentReps() {
    	return this.getReps(39);
    }


    /**
     * Returns a specific repetition of
     * OBR-39: "Collector’s Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCollectorSComment(int rep) { 
		CE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-39: "Collector’s Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObr39_CollectorSComment(int rep) { 
		CE retVal = this.getTypedField(39, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Collector’s Comment (OBR-39).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr39_CollectorSCommentReps() {
    	return this.getReps(39);
    }


    /**
     * Inserts a repetition of
     * OBR-39: "Collector’s Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCollectorSComment(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(39, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-39: "Collector’s Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObr39_CollectorSComment(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * OBR-39: "Collector’s Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCollectorSComment(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(39, rep);
    }


    /**
     * Removes a repetition of
     * OBR-39: "Collector’s Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObr39_CollectorSComment(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(39, rep);
    }




    /**
     * Returns
     * OBR-40: "Transport Arrangement Responsibility" - creates it if necessary
     */
    public CE getTransportArrangementResponsibility() { 
		CE retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-40: "Transport Arrangement Responsibility" - creates it if necessary
     */
    public CE getObr40_TransportArrangementResponsibility() { 
		CE retVal = this.getTypedField(40, 0);
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
    public CE[] getPlannedPatientTransportComment() {
    	CE[] retVal = this.getTypedField(43, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Planned Patient Transport Comment (OBR-43).
     */
    public CE[] getObr43_PlannedPatientTransportComment() {
    	CE[] retVal = this.getTypedField(43, new CE[0]);
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
    public CE getPlannedPatientTransportComment(int rep) { 
		CE retVal = this.getTypedField(43, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-43: "Planned Patient Transport Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObr43_PlannedPatientTransportComment(int rep) { 
		CE retVal = this.getTypedField(43, rep);
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
    public CE insertPlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(43, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObr43_PlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(43, rep);
    }


    /**
     * Removes a repetition of
     * OBR-43: "Planned Patient Transport Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeObr43_PlannedPatientTransportComment(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(43, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ID(getMessage(), new Integer( 0 ));
          case 5: return new TS(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new CQ(getMessage());
          case 9: return new XCN(getMessage());
          case 10: return new ID(getMessage(), new Integer( 65 ));
          case 11: return new CE(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new CM_SPS(getMessage());
          case 15: return new XCN(getMessage());
          case 16: return new XTN(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new TS(getMessage());
          case 22: return new CM_MOC(getMessage());
          case 23: return new ID(getMessage(), new Integer( 74 ));
          case 24: return new ID(getMessage(), new Integer( 123 ));
          case 25: return new CM_PRL(getMessage());
          case 26: return new TQ(getMessage());
          case 27: return new XCN(getMessage());
          case 28: return new CM_EIP(getMessage());
          case 29: return new ID(getMessage(), new Integer( 124 ));
          case 30: return new CE(getMessage());
          case 31: return new CM_NDL(getMessage());
          case 32: return new CM_NDL(getMessage());
          case 33: return new CM_NDL(getMessage());
          case 34: return new CM_NDL(getMessage());
          case 35: return new TS(getMessage());
          case 36: return new NM(getMessage());
          case 37: return new CE(getMessage());
          case 38: return new CE(getMessage());
          case 39: return new CE(getMessage());
          case 40: return new ID(getMessage(), new Integer( 224 ));
          case 41: return new ID(getMessage(), new Integer( 225 ));
          case 42: return new CE(getMessage());
          default: return null;
       }
   }


}

