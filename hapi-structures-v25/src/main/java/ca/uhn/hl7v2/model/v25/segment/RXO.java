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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RXO message segment (Pharmacy/Treatment Order). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXO-1: Requested Give Code (CE) <b>optional </b>
     * <li>RXO-2: Requested Give Amount - Minimum (NM) <b>optional </b>
     * <li>RXO-3: Requested Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXO-4: Requested Give Units (CE) <b>optional </b>
     * <li>RXO-5: Requested Dosage Form (CE) <b>optional </b>
     * <li>RXO-6: Provider's Pharmacy/Treatment Instructions (CE) <b>optional repeating</b>
     * <li>RXO-7: Provider's Administration Instructions (CE) <b>optional repeating</b>
     * <li>RXO-8: Deliver-To Location (LA1) <b>optional </b>
     * <li>RXO-9: Allow Substitutions (ID) <b>optional </b>
     * <li>RXO-10: Requested Dispense Code (CE) <b>optional </b>
     * <li>RXO-11: Requested Dispense Amount (NM) <b>optional </b>
     * <li>RXO-12: Requested Dispense Units (CE) <b>optional </b>
     * <li>RXO-13: Number Of Refills (NM) <b>optional </b>
     * <li>RXO-14: Ordering Provider's DEA Number (XCN) <b>optional repeating</b>
     * <li>RXO-15: Pharmacist/Treatment Supplier's Verifier ID (XCN) <b>optional repeating</b>
     * <li>RXO-16: Needs Human Review (ID) <b>optional </b>
     * <li>RXO-17: Requested Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXO-18: Requested Give Strength (NM) <b>optional </b>
     * <li>RXO-19: Requested Give Strength Units (CE) <b>optional </b>
     * <li>RXO-20: Indication (CE) <b>optional repeating</b>
     * <li>RXO-21: Requested Give Rate Amount (ST) <b>optional </b>
     * <li>RXO-22: Requested Give Rate Units (CE) <b>optional </b>
     * <li>RXO-23: Total Daily Dose (CQ) <b>optional </b>
     * <li>RXO-24: Supplementary Code (CE) <b>optional repeating</b>
     * <li>RXO-25: Requested Drug Strength Volume (NM) <b>optional </b>
     * <li>RXO-26: Requested Drug Strength Volume Units (CWE) <b>optional </b>
     * <li>RXO-27: Pharmacy Order Type (ID) <b>optional </b>
     * <li>RXO-28: Dispensing Interval (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXO extends AbstractSegment {

    /** 
     * Creates a new RXO segment
     */
    public RXO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Give Code");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Amount - Maximum");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Give Units");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Dosage Form");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Provider's Pharmacy/Treatment Instructions");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Provider's Administration Instructions");
                                  this.add(LA1.class, false, 1, 200, new Object[]{ getMessage() }, "Deliver-To Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(161) }, "Allow Substitutions");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Dispense Code");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Dispense Amount");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Dispense Units");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Number Of Refills");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Ordering Provider's DEA Number");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Pharmacist/Treatment Supplier's Verifier ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Needs Human Review");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Per (Time Unit)");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Strength");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Give Strength Units");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Indication");
                                  this.add(ST.class, false, 1, 6, new Object[]{ getMessage() }, "Requested Give Rate Amount");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Give Rate Units");
                                  this.add(CQ.class, false, 1, 10, new Object[]{ getMessage() }, "Total Daily Dose");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Supplementary Code");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Requested Drug Strength Volume");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Requested Drug Strength Volume Units");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(480) }, "Pharmacy Order Type");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Dispensing Interval");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXO - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXO-1: "Requested Give Code" - creates it if necessary
     */
    public CE getRequestedGiveCode() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-1: "Requested Give Code" - creates it if necessary
     */
    public CE getRxo1_RequestedGiveCode() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-2: "Requested Give Amount - Minimum" - creates it if necessary
     */
    public NM getRequestedGiveAmountMinimum() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-2: "Requested Give Amount - Minimum" - creates it if necessary
     */
    public NM getRxo2_RequestedGiveAmountMinimum() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-3: "Requested Give Amount - Maximum" - creates it if necessary
     */
    public NM getRequestedGiveAmountMaximum() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-3: "Requested Give Amount - Maximum" - creates it if necessary
     */
    public NM getRxo3_RequestedGiveAmountMaximum() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-4: "Requested Give Units" - creates it if necessary
     */
    public CE getRequestedGiveUnits() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-4: "Requested Give Units" - creates it if necessary
     */
    public CE getRxo4_RequestedGiveUnits() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-5: "Requested Dosage Form" - creates it if necessary
     */
    public CE getRequestedDosageForm() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-5: "Requested Dosage Form" - creates it if necessary
     */
    public CE getRxo5_RequestedDosageForm() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Provider's Pharmacy/Treatment Instructions (RXO-6).
     */
    public CE[] getProviderSPharmacyTreatmentInstructions() {
    	CE[] retVal = this.getTypedField(6, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider's Pharmacy/Treatment Instructions (RXO-6).
     */
    public CE[] getRxo6_ProviderSPharmacyTreatmentInstructions() {
    	CE[] retVal = this.getTypedField(6, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider's Pharmacy/Treatment Instructions (RXO-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderSPharmacyTreatmentInstructionsReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getProviderSPharmacyTreatmentInstructions(int rep) { 
		CE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxo6_ProviderSPharmacyTreatmentInstructions(int rep) { 
		CE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider's Pharmacy/Treatment Instructions (RXO-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo6_ProviderSPharmacyTreatmentInstructionsReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxo6_ProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxo6_ProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Provider's Administration Instructions (RXO-7).
     */
    public CE[] getProviderSAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(7, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider's Administration Instructions (RXO-7).
     */
    public CE[] getRxo7_ProviderSAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(7, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider's Administration Instructions (RXO-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderSAdministrationInstructionsReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * RXO-7: "Provider's Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getProviderSAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-7: "Provider's Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxo7_ProviderSAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider's Administration Instructions (RXO-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo7_ProviderSAdministrationInstructionsReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxo7_ProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxo7_ProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * RXO-8: "Deliver-To Location" - creates it if necessary
     */
    public LA1 getDeliverToLocation() { 
		LA1 retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-8: "Deliver-To Location" - creates it if necessary
     */
    public LA1 getRxo8_DeliverToLocation() { 
		LA1 retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-9: "Allow Substitutions" - creates it if necessary
     */
    public ID getAllowSubstitutions() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-9: "Allow Substitutions" - creates it if necessary
     */
    public ID getRxo9_AllowSubstitutions() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-10: "Requested Dispense Code" - creates it if necessary
     */
    public CE getRequestedDispenseCode() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-10: "Requested Dispense Code" - creates it if necessary
     */
    public CE getRxo10_RequestedDispenseCode() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-11: "Requested Dispense Amount" - creates it if necessary
     */
    public NM getRequestedDispenseAmount() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-11: "Requested Dispense Amount" - creates it if necessary
     */
    public NM getRxo11_RequestedDispenseAmount() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-12: "Requested Dispense Units" - creates it if necessary
     */
    public CE getRequestedDispenseUnits() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-12: "Requested Dispense Units" - creates it if necessary
     */
    public CE getRxo12_RequestedDispenseUnits() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-13: "Number Of Refills" - creates it if necessary
     */
    public NM getNumberOfRefills() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-13: "Number Of Refills" - creates it if necessary
     */
    public NM getRxo13_NumberOfRefills() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider's DEA Number (RXO-14).
     */
    public XCN[] getOrderingProviderSDEANumber() {
    	XCN[] retVal = this.getTypedField(14, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider's DEA Number (RXO-14).
     */
    public XCN[] getRxo14_OrderingProviderSDEANumber() {
    	XCN[] retVal = this.getTypedField(14, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Provider's DEA Number (RXO-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingProviderSDEANumberReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * RXO-14: "Ordering Provider's DEA Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrderingProviderSDEANumber(int rep) { 
		XCN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-14: "Ordering Provider's DEA Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRxo14_OrderingProviderSDEANumber(int rep) { 
		XCN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Provider's DEA Number (RXO-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo14_OrderingProviderSDEANumberReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * RXO-14: "Ordering Provider's DEA Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrderingProviderSDEANumber(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-14: "Ordering Provider's DEA Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRxo14_OrderingProviderSDEANumber(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * RXO-14: "Ordering Provider's DEA Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrderingProviderSDEANumber(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * RXO-14: "Ordering Provider's DEA Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRxo14_OrderingProviderSDEANumber(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(14, rep);
    }



    /**
     * Returns all repetitions of Pharmacist/Treatment Supplier's Verifier ID (RXO-15).
     */
    public XCN[] getPharmacistTreatmentSupplierSVerifierID() {
    	XCN[] retVal = this.getTypedField(15, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pharmacist/Treatment Supplier's Verifier ID (RXO-15).
     */
    public XCN[] getRxo15_PharmacistTreatmentSupplierSVerifierID() {
    	XCN[] retVal = this.getTypedField(15, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pharmacist/Treatment Supplier's Verifier ID (RXO-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPharmacistTreatmentSupplierSVerifierIDReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPharmacistTreatmentSupplierSVerifierID(int rep) { 
		XCN retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRxo15_PharmacistTreatmentSupplierSVerifierID(int rep) { 
		XCN retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pharmacist/Treatment Supplier's Verifier ID (RXO-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo15_PharmacistTreatmentSupplierSVerifierIDReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPharmacistTreatmentSupplierSVerifierID(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRxo15_PharmacistTreatmentSupplierSVerifierID(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePharmacistTreatmentSupplierSVerifierID(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRxo15_PharmacistTreatmentSupplierSVerifierID(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * RXO-16: "Needs Human Review" - creates it if necessary
     */
    public ID getNeedsHumanReview() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-16: "Needs Human Review" - creates it if necessary
     */
    public ID getRxo16_NeedsHumanReview() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-17: "Requested Give Per (Time Unit)" - creates it if necessary
     */
    public ST getRequestedGivePerTimeUnit() { 
		ST retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-17: "Requested Give Per (Time Unit)" - creates it if necessary
     */
    public ST getRxo17_RequestedGivePerTimeUnit() { 
		ST retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-18: "Requested Give Strength" - creates it if necessary
     */
    public NM getRequestedGiveStrength() { 
		NM retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-18: "Requested Give Strength" - creates it if necessary
     */
    public NM getRxo18_RequestedGiveStrength() { 
		NM retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-19: "Requested Give Strength Units" - creates it if necessary
     */
    public CE getRequestedGiveStrengthUnits() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-19: "Requested Give Strength Units" - creates it if necessary
     */
    public CE getRxo19_RequestedGiveStrengthUnits() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXO-20).
     */
    public CE[] getIndication() {
    	CE[] retVal = this.getTypedField(20, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXO-20).
     */
    public CE[] getRxo20_Indication() {
    	CE[] retVal = this.getTypedField(20, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Indication (RXO-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIndicationReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * RXO-20: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIndication(int rep) { 
		CE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-20: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxo20_Indication(int rep) { 
		CE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Indication (RXO-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo20_IndicationReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIndication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxo20_Indication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIndication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxo20_Indication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(20, rep);
    }




    /**
     * Returns
     * RXO-21: "Requested Give Rate Amount" - creates it if necessary
     */
    public ST getRequestedGiveRateAmount() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-21: "Requested Give Rate Amount" - creates it if necessary
     */
    public ST getRxo21_RequestedGiveRateAmount() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-22: "Requested Give Rate Units" - creates it if necessary
     */
    public CE getRequestedGiveRateUnits() { 
		CE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-22: "Requested Give Rate Units" - creates it if necessary
     */
    public CE getRxo22_RequestedGiveRateUnits() { 
		CE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-23: "Total Daily Dose" - creates it if necessary
     */
    public CQ getTotalDailyDose() { 
		CQ retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-23: "Total Daily Dose" - creates it if necessary
     */
    public CQ getRxo23_TotalDailyDose() { 
		CQ retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Supplementary Code (RXO-24).
     */
    public CE[] getSupplementaryCode() {
    	CE[] retVal = this.getTypedField(24, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Supplementary Code (RXO-24).
     */
    public CE[] getRxo24_SupplementaryCode() {
    	CE[] retVal = this.getTypedField(24, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Supplementary Code (RXO-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSupplementaryCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * RXO-24: "Supplementary Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getSupplementaryCode(int rep) { 
		CE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-24: "Supplementary Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxo24_SupplementaryCode(int rep) { 
		CE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Supplementary Code (RXO-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo24_SupplementaryCodeReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertSupplementaryCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxo24_SupplementaryCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeSupplementaryCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxo24_SupplementaryCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * RXO-25: "Requested Drug Strength Volume" - creates it if necessary
     */
    public NM getRequestedDrugStrengthVolume() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-25: "Requested Drug Strength Volume" - creates it if necessary
     */
    public NM getRxo25_RequestedDrugStrengthVolume() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-26: "Requested Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getRequestedDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-26: "Requested Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getRxo26_RequestedDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-27: "Pharmacy Order Type" - creates it if necessary
     */
    public ID getPharmacyOrderType() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-27: "Pharmacy Order Type" - creates it if necessary
     */
    public ID getRxo27_PharmacyOrderType() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-28: "Dispensing Interval" - creates it if necessary
     */
    public NM getDispensingInterval() { 
		NM retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-28: "Dispensing Interval" - creates it if necessary
     */
    public NM getRxo28_DispensingInterval() { 
		NM retVal = this.getTypedField(28, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new LA1(getMessage());
          case 8: return new ID(getMessage(), new Integer( 161 ));
          case 9: return new CE(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new CE(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new XCN(getMessage());
          case 14: return new XCN(getMessage());
          case 15: return new ID(getMessage(), new Integer( 136 ));
          case 16: return new ST(getMessage());
          case 17: return new NM(getMessage());
          case 18: return new CE(getMessage());
          case 19: return new CE(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new CE(getMessage());
          case 22: return new CQ(getMessage());
          case 23: return new CE(getMessage());
          case 24: return new NM(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new ID(getMessage(), new Integer( 480 ));
          case 27: return new NM(getMessage());
          default: return null;
       }
   }


}

