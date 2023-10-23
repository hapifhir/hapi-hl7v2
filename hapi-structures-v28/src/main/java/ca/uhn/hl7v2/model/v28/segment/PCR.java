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
 *<p>Represents an HL7 PCR message segment (Possible Causal Relationship). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PCR-1: Implicated Product (CWE) <b> </b>
     * <li>PCR-2: Generic Product (IS) <b>optional </b>
     * <li>PCR-3: Product Class (CWE) <b>optional </b>
     * <li>PCR-4: Total Duration Of Therapy (CQ) <b>optional </b>
     * <li>PCR-5: Product Manufacture Date (DTM) <b>optional </b>
     * <li>PCR-6: Product Expiration Date (DTM) <b>optional </b>
     * <li>PCR-7: Product Implantation Date (DTM) <b>optional </b>
     * <li>PCR-8: Product Explantation Date (DTM) <b>optional </b>
     * <li>PCR-9: Single Use Device (CWE) <b>optional </b>
     * <li>PCR-10: Indication For Product Use (CWE) <b>optional </b>
     * <li>PCR-11: Product Problem (CWE) <b>optional </b>
     * <li>PCR-12: Product Serial/Lot Number (ST) <b>optional repeating</b>
     * <li>PCR-13: Product Available For Inspection (CWE) <b>optional </b>
     * <li>PCR-14: Product Evaluation Performed (CWE) <b>optional </b>
     * <li>PCR-15: Product Evaluation Status (CWE) <b>optional </b>
     * <li>PCR-16: Product Evaluation Results (CWE) <b>optional </b>
     * <li>PCR-17: Evaluated Product Source (ID) <b>optional </b>
     * <li>PCR-18: Date Product Returned To Manufacturer (DTM) <b>optional </b>
     * <li>PCR-19: Device Operator Qualifications (ID) <b>optional </b>
     * <li>PCR-20: Relatedness Assessment (ID) <b>optional </b>
     * <li>PCR-21: Action Taken In Response To The Event (ID) <b>optional repeating</b>
     * <li>PCR-22: Event Causality Observations (ID) <b>optional repeating</b>
     * <li>PCR-23: Indirect Exposure Mechanism (ID) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PCR extends AbstractSegment {

    /** 
     * Creates a new PCR segment
     */
    public PCR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Implicated Product");
                                              this.add(IS.class, false, 1, 0, new Object[]{ getMessage(), new Integer(249) }, "Generic Product");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product Class");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Total Duration Of Therapy");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Product Manufacture Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Product Expiration Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Product Implantation Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Product Explantation Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Single Use Device");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Indication For Product Use");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product Problem");
                                  this.add(ST.class, false, 3, 0, new Object[]{ getMessage() }, "Product Serial/Lot Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product Available For Inspection");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product Evaluation Performed");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product Evaluation Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product Evaluation Results");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(248) }, "Evaluated Product Source");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date Product Returned To Manufacturer");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(242) }, "Device Operator Qualifications");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(250) }, "Relatedness Assessment");
                                              this.add(ID.class, false, 6, 2, new Object[]{ getMessage(), new Integer(251) }, "Action Taken In Response To The Event");
                                              this.add(ID.class, false, 6, 2, new Object[]{ getMessage(), new Integer(252) }, "Event Causality Observations");
                                              this.add(ID.class, false, 3, 1, new Object[]{ getMessage(), new Integer(253) }, "Indirect Exposure Mechanism");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PCR - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PCR-1: "Implicated Product" - creates it if necessary
     */
    public CWE getImplicatedProduct() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-1: "Implicated Product" - creates it if necessary
     */
    public CWE getPcr1_ImplicatedProduct() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-2: "Generic Product" - creates it if necessary
     */
    public IS getGenericProduct() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-2: "Generic Product" - creates it if necessary
     */
    public IS getPcr2_GenericProduct() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-3: "Product Class" - creates it if necessary
     */
    public CWE getProductClass() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-3: "Product Class" - creates it if necessary
     */
    public CWE getPcr3_ProductClass() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-4: "Total Duration Of Therapy" - creates it if necessary
     */
    public CQ getTotalDurationOfTherapy() { 
		CQ retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-4: "Total Duration Of Therapy" - creates it if necessary
     */
    public CQ getPcr4_TotalDurationOfTherapy() { 
		CQ retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-5: "Product Manufacture Date" - creates it if necessary
     */
    public DTM getProductManufactureDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-5: "Product Manufacture Date" - creates it if necessary
     */
    public DTM getPcr5_ProductManufactureDate() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-6: "Product Expiration Date" - creates it if necessary
     */
    public DTM getProductExpirationDate() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-6: "Product Expiration Date" - creates it if necessary
     */
    public DTM getPcr6_ProductExpirationDate() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-7: "Product Implantation Date" - creates it if necessary
     */
    public DTM getProductImplantationDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-7: "Product Implantation Date" - creates it if necessary
     */
    public DTM getPcr7_ProductImplantationDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-8: "Product Explantation Date" - creates it if necessary
     */
    public DTM getProductExplantationDate() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-8: "Product Explantation Date" - creates it if necessary
     */
    public DTM getPcr8_ProductExplantationDate() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-9: "Single Use Device" - creates it if necessary
     */
    public CWE getSingleUseDevice() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-9: "Single Use Device" - creates it if necessary
     */
    public CWE getPcr9_SingleUseDevice() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-10: "Indication For Product Use" - creates it if necessary
     */
    public CWE getIndicationForProductUse() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-10: "Indication For Product Use" - creates it if necessary
     */
    public CWE getPcr10_IndicationForProductUse() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-11: "Product Problem" - creates it if necessary
     */
    public CWE getProductProblem() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-11: "Product Problem" - creates it if necessary
     */
    public CWE getPcr11_ProductProblem() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Product Serial/Lot Number (PCR-12).
     */
    public ST[] getProductSerialLotNumber() {
    	ST[] retVal = this.getTypedField(12, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Product Serial/Lot Number (PCR-12).
     */
    public ST[] getPcr12_ProductSerialLotNumber() {
    	ST[] retVal = this.getTypedField(12, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Product Serial/Lot Number (PCR-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProductSerialLotNumberReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * PCR-12: "Product Serial/Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getProductSerialLotNumber(int rep) { 
		ST retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PCR-12: "Product Serial/Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPcr12_ProductSerialLotNumber(int rep) { 
		ST retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Product Serial/Lot Number (PCR-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPcr12_ProductSerialLotNumberReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * PCR-12: "Product Serial/Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertProductSerialLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * PCR-12: "Product Serial/Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPcr12_ProductSerialLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PCR-12: "Product Serial/Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeProductSerialLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PCR-12: "Product Serial/Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePcr12_ProductSerialLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * PCR-13: "Product Available For Inspection" - creates it if necessary
     */
    public CWE getProductAvailableForInspection() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-13: "Product Available For Inspection" - creates it if necessary
     */
    public CWE getPcr13_ProductAvailableForInspection() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-14: "Product Evaluation Performed" - creates it if necessary
     */
    public CWE getProductEvaluationPerformed() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-14: "Product Evaluation Performed" - creates it if necessary
     */
    public CWE getPcr14_ProductEvaluationPerformed() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-15: "Product Evaluation Status" - creates it if necessary
     */
    public CWE getProductEvaluationStatus() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-15: "Product Evaluation Status" - creates it if necessary
     */
    public CWE getPcr15_ProductEvaluationStatus() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-16: "Product Evaluation Results" - creates it if necessary
     */
    public CWE getProductEvaluationResults() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-16: "Product Evaluation Results" - creates it if necessary
     */
    public CWE getPcr16_ProductEvaluationResults() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-17: "Evaluated Product Source" - creates it if necessary
     */
    public ID getEvaluatedProductSource() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-17: "Evaluated Product Source" - creates it if necessary
     */
    public ID getPcr17_EvaluatedProductSource() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-18: "Date Product Returned To Manufacturer" - creates it if necessary
     */
    public DTM getDateProductReturnedToManufacturer() { 
		DTM retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-18: "Date Product Returned To Manufacturer" - creates it if necessary
     */
    public DTM getPcr18_DateProductReturnedToManufacturer() { 
		DTM retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-19: "Device Operator Qualifications" - creates it if necessary
     */
    public ID getDeviceOperatorQualifications() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-19: "Device Operator Qualifications" - creates it if necessary
     */
    public ID getPcr19_DeviceOperatorQualifications() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PCR-20: "Relatedness Assessment" - creates it if necessary
     */
    public ID getRelatednessAssessment() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PCR-20: "Relatedness Assessment" - creates it if necessary
     */
    public ID getPcr20_RelatednessAssessment() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Action Taken In Response To The Event (PCR-21).
     */
    public ID[] getActionTakenInResponseToTheEvent() {
    	ID[] retVal = this.getTypedField(21, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Action Taken In Response To The Event (PCR-21).
     */
    public ID[] getPcr21_ActionTakenInResponseToTheEvent() {
    	ID[] retVal = this.getTypedField(21, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Action Taken In Response To The Event (PCR-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getActionTakenInResponseToTheEventReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * PCR-21: "Action Taken In Response To The Event" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getActionTakenInResponseToTheEvent(int rep) { 
		ID retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PCR-21: "Action Taken In Response To The Event" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPcr21_ActionTakenInResponseToTheEvent(int rep) { 
		ID retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Action Taken In Response To The Event (PCR-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPcr21_ActionTakenInResponseToTheEventReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * PCR-21: "Action Taken In Response To The Event" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertActionTakenInResponseToTheEvent(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * PCR-21: "Action Taken In Response To The Event" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPcr21_ActionTakenInResponseToTheEvent(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * PCR-21: "Action Taken In Response To The Event" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeActionTakenInResponseToTheEvent(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * PCR-21: "Action Taken In Response To The Event" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePcr21_ActionTakenInResponseToTheEvent(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(21, rep);
    }



    /**
     * Returns all repetitions of Event Causality Observations (PCR-22).
     */
    public ID[] getEventCausalityObservations() {
    	ID[] retVal = this.getTypedField(22, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Causality Observations (PCR-22).
     */
    public ID[] getPcr22_EventCausalityObservations() {
    	ID[] retVal = this.getTypedField(22, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Causality Observations (PCR-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventCausalityObservationsReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * PCR-22: "Event Causality Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getEventCausalityObservations(int rep) { 
		ID retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PCR-22: "Event Causality Observations" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPcr22_EventCausalityObservations(int rep) { 
		ID retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Causality Observations (PCR-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPcr22_EventCausalityObservationsReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * PCR-22: "Event Causality Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertEventCausalityObservations(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * PCR-22: "Event Causality Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPcr22_EventCausalityObservations(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * PCR-22: "Event Causality Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeEventCausalityObservations(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * PCR-22: "Event Causality Observations" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePcr22_EventCausalityObservations(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(22, rep);
    }



    /**
     * Returns all repetitions of Indirect Exposure Mechanism (PCR-23).
     */
    public ID[] getIndirectExposureMechanism() {
    	ID[] retVal = this.getTypedField(23, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indirect Exposure Mechanism (PCR-23).
     */
    public ID[] getPcr23_IndirectExposureMechanism() {
    	ID[] retVal = this.getTypedField(23, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Indirect Exposure Mechanism (PCR-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIndirectExposureMechanismReps() {
    	return this.getReps(23);
    }


    /**
     * Returns a specific repetition of
     * PCR-23: "Indirect Exposure Mechanism" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getIndirectExposureMechanism(int rep) { 
		ID retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PCR-23: "Indirect Exposure Mechanism" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPcr23_IndirectExposureMechanism(int rep) { 
		ID retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Indirect Exposure Mechanism (PCR-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPcr23_IndirectExposureMechanismReps() {
    	return this.getReps(23);
    }


    /**
     * Inserts a repetition of
     * PCR-23: "Indirect Exposure Mechanism" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertIndirectExposureMechanism(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(23, rep);
    }


    /**
     * Inserts a repetition of
     * PCR-23: "Indirect Exposure Mechanism" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPcr23_IndirectExposureMechanism(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * PCR-23: "Indirect Exposure Mechanism" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeIndirectExposureMechanism(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * PCR-23: "Indirect Exposure Mechanism" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePcr23_IndirectExposureMechanism(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(23, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new IS(getMessage(), new Integer( 249 ));
          case 2: return new CWE(getMessage());
          case 3: return new CQ(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new DTM(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new ID(getMessage(), new Integer( 248 ));
          case 17: return new DTM(getMessage());
          case 18: return new ID(getMessage(), new Integer( 242 ));
          case 19: return new ID(getMessage(), new Integer( 250 ));
          case 20: return new ID(getMessage(), new Integer( 251 ));
          case 21: return new ID(getMessage(), new Integer( 252 ));
          case 22: return new ID(getMessage(), new Integer( 253 ));
          default: return null;
       }
   }


}

