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
 *<p>Represents an HL7 OBR message segment (OBSERVATION REQUEST). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OBR-1: Set ID - Observation Request (SI) <b>optional </b>
     * <li>OBR-2: Placer Order Number (CM_PLACER) <b>optional </b>
     * <li>OBR-3: Filler Order Number (CM_FILLER) <b>optional </b>
     * <li>OBR-4: Universal Service ID (CE) <b> </b>
     * <li>OBR-5: Priority (not used) (ID) <b>optional </b>
     * <li>OBR-6: Requested date / time (not used) (TS) <b>optional </b>
     * <li>OBR-7: Observation date / time (TS) <b>optional </b>
     * <li>OBR-8: Observation end date / time (TS) <b>optional </b>
     * <li>OBR-9: Collection Volume (CQ_QUANTITY) <b>optional </b>
     * <li>OBR-10: Collector Identifier (CN) <b>optional repeating</b>
     * <li>OBR-11: Specimen action code (ID) <b>optional </b>
     * <li>OBR-12: Danger Code (CE) <b>optional </b>
     * <li>OBR-13: Relevant clinical information (ST) <b>optional </b>
     * <li>OBR-14: Specimen received date / time (TS) <b>optional </b>
     * <li>OBR-15: Specimen source (CM_SPS) <b>optional </b>
     * <li>OBR-16: Ordering Provider (CN) <b>optional </b>
     * <li>OBR-17: Order Callback Phone Number (TN) <b>optional repeating</b>
     * <li>OBR-18: Placer field 1 (ST) <b>optional </b>
     * <li>OBR-19: Placer field 2 (ST) <b>optional </b>
     * <li>OBR-20: Filler Field 1 (ST) <b>optional </b>
     * <li>OBR-21: Filler Field 2 (ST) <b>optional </b>
     * <li>OBR-22: Results report / status change - date / time (TS) <b>optional </b>
     * <li>OBR-23: Charge to Practice (CM_MOC) <b>optional </b>
     * <li>OBR-24: Diagnostic service section ID (ID) <b>optional </b>
     * <li>OBR-25: Result Status (ID) <b>optional </b>
     * <li>OBR-26: Parent Result (CM_PARENT_RESULT) <b>optional </b>
     * <li>OBR-27: Quantity / timing (TQ) <b>optional repeating</b>
     * <li>OBR-28: Result Copies To (CN) <b>optional repeating</b>
     * <li>OBR-29: Parent Number (CM_EIP) <b>optional </b>
     * <li>OBR-30: Transportation Mode (ID) <b>optional </b>
     * <li>OBR-31: Reason for Study (CE) <b>optional repeating</b>
     * <li>OBR-32: Principal Result Interpreter (CM_NDL) <b>optional </b>
     * <li>OBR-33: Assistant Result Interpreter (CM_NDL) <b>optional repeating</b>
     * <li>OBR-34: Technician (CM_NDL) <b>optional repeating</b>
     * <li>OBR-35: Transcriptionist (CM_NDL) <b>optional repeating</b>
     * <li>OBR-36: Scheduled date / time (TS) <b>optional </b>
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
                                  this.add(CM_PLACER.class, false, 1, 75, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(CM_FILLER.class, false, 1, 75, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(CE.class, true, 1, 200, new Object[]{ getMessage() }, "Universal Service ID");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "Priority (not used)");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Requested date / time (not used)");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Observation date / time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Observation end date / time");
                                  this.add(CQ_QUANTITY.class, false, 1, 20, new Object[]{ getMessage() }, "Collection Volume");
                                  this.add(CN.class, false, 0, 60, new Object[]{ getMessage() }, "Collector Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(65) }, "Specimen action code");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Danger Code");
                                  this.add(ST.class, false, 1, 300, new Object[]{ getMessage() }, "Relevant clinical information");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Specimen received date / time");
                                  this.add(CM_SPS.class, false, 1, 300, new Object[]{ getMessage() }, "Specimen source");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "Ordering Provider");
                                  this.add(TN.class, false, 2, 40, new Object[]{ getMessage() }, "Order Callback Phone Number");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Placer field 1");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Placer field 2");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Filler Field 1");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Filler Field 2");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Results report / status change - date / time");
                                  this.add(CM_MOC.class, false, 1, 40, new Object[]{ getMessage() }, "Charge to Practice");
                                              this.add(ID.class, false, 1, 10, new Object[]{ getMessage(), new Integer(74) }, "Diagnostic service section ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(123) }, "Result Status");
                                  this.add(CM_PARENT_RESULT.class, false, 1, 200, new Object[]{ getMessage() }, "Parent Result");
                                  this.add(TQ.class, false, 0, 200, new Object[]{ getMessage() }, "Quantity / timing");
                                  this.add(CN.class, false, 5, 150, new Object[]{ getMessage() }, "Result Copies To");
                                  this.add(CM_EIP.class, false, 1, 150, new Object[]{ getMessage() }, "Parent Number");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(124) }, "Transportation Mode");
                                  this.add(CE.class, false, 0, 300, new Object[]{ getMessage() }, "Reason for Study");
                                  this.add(CM_NDL.class, false, 1, 60, new Object[]{ getMessage() }, "Principal Result Interpreter");
                                  this.add(CM_NDL.class, false, 0, 60, new Object[]{ getMessage() }, "Assistant Result Interpreter");
                                  this.add(CM_NDL.class, false, 0, 60, new Object[]{ getMessage() }, "Technician");
                                  this.add(CM_NDL.class, false, 0, 60, new Object[]{ getMessage() }, "Transcriptionist");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Scheduled date / time");
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
     * Returns
     * OBR-2: "Placer Order Number" - creates it if necessary
     */
    public CM_PLACER getPlacerOrderNumber() { 
		CM_PLACER retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-2: "Placer Order Number" - creates it if necessary
     */
    public CM_PLACER getObr2_PlacerOrderNumber() { 
		CM_PLACER retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-3: "Filler Order Number" - creates it if necessary
     */
    public CM_FILLER getFillerOrderNumber() { 
		CM_FILLER retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-3: "Filler Order Number" - creates it if necessary
     */
    public CM_FILLER getObr3_FillerOrderNumber() { 
		CM_FILLER retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-4: "Universal Service ID" - creates it if necessary
     */
    public CE getUniversalServiceID() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-4: "Universal Service ID" - creates it if necessary
     */
    public CE getObr4_UniversalServiceID() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-5: "Priority (not used)" - creates it if necessary
     */
    public ID getPriorityNotused() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-5: "Priority (not used)" - creates it if necessary
     */
    public ID getObr5_PriorityNotused() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-6: "Requested date / time (not used)" - creates it if necessary
     */
    public TS getRequestedDateTimeNotused() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-6: "Requested date / time (not used)" - creates it if necessary
     */
    public TS getObr6_RequestedDateTimeNotused() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-7: "Observation date / time" - creates it if necessary
     */
    public TS getObservationDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-7: "Observation date / time" - creates it if necessary
     */
    public TS getObr7_ObservationDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-8: "Observation end date / time" - creates it if necessary
     */
    public TS getObservationEndDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-8: "Observation end date / time" - creates it if necessary
     */
    public TS getObr8_ObservationEndDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-9: "Collection Volume" - creates it if necessary
     */
    public CQ_QUANTITY getCollectionVolume() { 
		CQ_QUANTITY retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-9: "Collection Volume" - creates it if necessary
     */
    public CQ_QUANTITY getObr9_CollectionVolume() { 
		CQ_QUANTITY retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Collector Identifier (OBR-10).
     */
    public CN[] getCollectorIdentifier() {
    	CN[] retVal = this.getTypedField(10, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Collector Identifier (OBR-10).
     */
    public CN[] getObr10_CollectorIdentifier() {
    	CN[] retVal = this.getTypedField(10, new CN[0]);
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
    public CN getCollectorIdentifier(int rep) { 
		CN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-10: "Collector Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getObr10_CollectorIdentifier(int rep) { 
		CN retVal = this.getTypedField(10, rep);
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
    public CN insertCollectorIdentifier(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertObr10_CollectorIdentifier(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeCollectorIdentifier(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * OBR-10: "Collector Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeObr10_CollectorIdentifier(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * OBR-11: "Specimen action code" - creates it if necessary
     */
    public ID getSpecimenActionCode() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-11: "Specimen action code" - creates it if necessary
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
     * OBR-13: "Relevant clinical information" - creates it if necessary
     */
    public ST getRelevantClinicalInformation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-13: "Relevant clinical information" - creates it if necessary
     */
    public ST getObr13_RelevantClinicalInformation() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-14: "Specimen received date / time" - creates it if necessary
     */
    public TS getSpecimenReceivedDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-14: "Specimen received date / time" - creates it if necessary
     */
    public TS getObr14_SpecimenReceivedDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-15: "Specimen source" - creates it if necessary
     */
    public CM_SPS getSpecimenSource() { 
		CM_SPS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-15: "Specimen source" - creates it if necessary
     */
    public CM_SPS getObr15_SpecimenSource() { 
		CM_SPS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-16: "Ordering Provider" - creates it if necessary
     */
    public CN getOrderingProvider() { 
		CN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-16: "Ordering Provider" - creates it if necessary
     */
    public CN getObr16_OrderingProvider() { 
		CN retVal = this.getTypedField(16, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Order Callback Phone Number (OBR-17).
     */
    public TN[] getOrderCallbackPhoneNumber() {
    	TN[] retVal = this.getTypedField(17, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Order Callback Phone Number (OBR-17).
     */
    public TN[] getObr17_OrderCallbackPhoneNumber() {
    	TN[] retVal = this.getTypedField(17, new TN[0]);
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
    public TN getOrderCallbackPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-17: "Order Callback Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getObr17_OrderCallbackPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(17, rep);
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
    public TN insertOrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertObr17_OrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeOrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * OBR-17: "Order Callback Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeObr17_OrderCallbackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * OBR-18: "Placer field 1" - creates it if necessary
     */
    public ST getPlacerField1() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-18: "Placer field 1" - creates it if necessary
     */
    public ST getObr18_PlacerField1() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-19: "Placer field 2" - creates it if necessary
     */
    public ST getPlacerField2() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-19: "Placer field 2" - creates it if necessary
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
     * OBR-22: "Results report / status change - date / time" - creates it if necessary
     */
    public TS getResultsReportStatusChangeDateTime() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-22: "Results report / status change - date / time" - creates it if necessary
     */
    public TS getObr22_ResultsReportStatusChangeDateTime() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-23: "Charge to Practice" - creates it if necessary
     */
    public CM_MOC getChargeToPractice() { 
		CM_MOC retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-23: "Charge to Practice" - creates it if necessary
     */
    public CM_MOC getObr23_ChargeToPractice() { 
		CM_MOC retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * OBR-24: "Diagnostic service section ID" - creates it if necessary
     */
    public ID getDiagnosticServiceSectionID() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-24: "Diagnostic service section ID" - creates it if necessary
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
    public CM_PARENT_RESULT getParentResult() { 
		CM_PARENT_RESULT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-26: "Parent Result" - creates it if necessary
     */
    public CM_PARENT_RESULT getObr26_ParentResult() { 
		CM_PARENT_RESULT retVal = this.getTypedField(26, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Quantity / timing (OBR-27).
     */
    public TQ[] getQuantityTiming() {
    	TQ[] retVal = this.getTypedField(27, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Quantity / timing (OBR-27).
     */
    public TQ[] getObr27_QuantityTiming() {
    	TQ[] retVal = this.getTypedField(27, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Quantity / timing (OBR-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQuantityTimingReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * OBR-27: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getQuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-27: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getObr27_QuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Quantity / timing (OBR-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObr27_QuantityTimingReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * OBR-27: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-27: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertObr27_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OBR-27: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * OBR-27: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeObr27_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(27, rep);
    }



    /**
     * Returns all repetitions of Result Copies To (OBR-28).
     */
    public CN[] getResultCopiesTo() {
    	CN[] retVal = this.getTypedField(28, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Result Copies To (OBR-28).
     */
    public CN[] getObr28_ResultCopiesTo() {
    	CN[] retVal = this.getTypedField(28, new CN[0]);
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
    public CN getResultCopiesTo(int rep) { 
		CN retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-28: "Result Copies To" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getObr28_ResultCopiesTo(int rep) { 
		CN retVal = this.getTypedField(28, rep);
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
    public CN insertResultCopiesTo(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertObr28_ResultCopiesTo(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeResultCopiesTo(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * OBR-28: "Result Copies To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeObr28_ResultCopiesTo(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(28, rep);
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
     * Returns all repetitions of Reason for Study (OBR-31).
     */
    public CE[] getReasonForStudy() {
    	CE[] retVal = this.getTypedField(31, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Reason for Study (OBR-31).
     */
    public CE[] getObr31_ReasonForStudy() {
    	CE[] retVal = this.getTypedField(31, new CE[0]);
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
    public CE getReasonForStudy(int rep) { 
		CE retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBR-31: "Reason for Study" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getObr31_ReasonForStudy(int rep) { 
		CE retVal = this.getTypedField(31, rep);
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
    public CE insertReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * OBR-31: "Reason for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertObr31_ReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "Reason for Study" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeReasonForStudy(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * OBR-31: "Reason for Study" at a specific index
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
     * OBR-36: "Scheduled date / time" - creates it if necessary
     */
    public TS getScheduledDateTime() { 
		TS retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBR-36: "Scheduled date / time" - creates it if necessary
     */
    public TS getObr36_ScheduledDateTime() { 
		TS retVal = this.getTypedField(36, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CM_PLACER(getMessage());
          case 2: return new CM_FILLER(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ID(getMessage(), new Integer( 0 ));
          case 5: return new TS(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new CQ_QUANTITY(getMessage());
          case 9: return new CN(getMessage());
          case 10: return new ID(getMessage(), new Integer( 65 ));
          case 11: return new CE(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new CM_SPS(getMessage());
          case 15: return new CN(getMessage());
          case 16: return new TN(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new TS(getMessage());
          case 22: return new CM_MOC(getMessage());
          case 23: return new ID(getMessage(), new Integer( 74 ));
          case 24: return new ID(getMessage(), new Integer( 123 ));
          case 25: return new CM_PARENT_RESULT(getMessage());
          case 26: return new TQ(getMessage());
          case 27: return new CN(getMessage());
          case 28: return new CM_EIP(getMessage());
          case 29: return new ID(getMessage(), new Integer( 124 ));
          case 30: return new CE(getMessage());
          case 31: return new CM_NDL(getMessage());
          case 32: return new CM_NDL(getMessage());
          case 33: return new CM_NDL(getMessage());
          case 34: return new CM_NDL(getMessage());
          case 35: return new TS(getMessage());
          default: return null;
       }
   }


}

