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
 *<p>Represents an HL7 RXO message segment (Pharmacy/Treatment Order). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXO-1: Requested Give Code (CWE) <b>optional </b>
     * <li>RXO-2: Requested Give Amount - Minimum (NM) <b>optional </b>
     * <li>RXO-3: Requested Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXO-4: Requested Give Units (CWE) <b>optional </b>
     * <li>RXO-5: Requested Dosage Form (CWE) <b>optional </b>
     * <li>RXO-6: Provider's Pharmacy/Treatment Instructions (CWE) <b>optional repeating</b>
     * <li>RXO-7: Provider's Administration Instructions (CWE) <b>optional repeating</b>
     * <li>RXO-8: Deliver-To Location (NULLDT) <b>optional </b>
     * <li>RXO-9: Allow Substitutions (ID) <b>optional </b>
     * <li>RXO-10: Requested Dispense Code (CWE) <b>optional </b>
     * <li>RXO-11: Requested Dispense Amount (NM) <b>optional </b>
     * <li>RXO-12: Requested Dispense Units (CWE) <b>optional </b>
     * <li>RXO-13: Number Of Refills (NM) <b>optional </b>
     * <li>RXO-14: Ordering Provider's DEA Number (XCN) <b>optional repeating</b>
     * <li>RXO-15: Pharmacist/Treatment Supplier's Verifier ID (XCN) <b>optional repeating</b>
     * <li>RXO-16: Needs Human Review (ID) <b>optional </b>
     * <li>RXO-17: Requested Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXO-18: Requested Give Strength (NM) <b>optional </b>
     * <li>RXO-19: Requested Give Strength Units (CWE) <b>optional </b>
     * <li>RXO-20: Indication (CWE) <b>optional repeating</b>
     * <li>RXO-21: Requested Give Rate Amount (ST) <b>optional </b>
     * <li>RXO-22: Requested Give Rate Units (CWE) <b>optional </b>
     * <li>RXO-23: Total Daily Dose (CQ) <b>optional </b>
     * <li>RXO-24: Supplementary Code (CWE) <b>optional repeating</b>
     * <li>RXO-25: Requested Drug Strength Volume (NM) <b>optional </b>
     * <li>RXO-26: Requested Drug Strength Volume Units (CWE) <b>optional </b>
     * <li>RXO-27: Pharmacy Order Type (ID) <b>optional </b>
     * <li>RXO-28: Dispensing Interval (NM) <b>optional </b>
     * <li>RXO-29: Medication Instance Identifier (EI) <b>optional </b>
     * <li>RXO-30: Segment Instance Identifier (EI) <b>optional </b>
     * <li>RXO-31: Mood Code (CNE) <b>optional </b>
     * <li>RXO-32: Dispensing Pharmacy (CWE) <b>optional </b>
     * <li>RXO-33: Dispensing Pharmacy Address (XAD) <b>optional </b>
     * <li>RXO-34: Deliver-to Patient Location (PL) <b>optional </b>
     * <li>RXO-35: Deliver-to Address (XAD) <b>optional </b>
     * <li>RXO-36: Pharmacy Phone Number (XTN) <b>optional repeating</b>
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
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Amount - Maximum");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Units");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Dosage Form");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Provider's Pharmacy/Treatment Instructions");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Provider's Administration Instructions");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-To Location");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(161) }, "Allow Substitutions");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Dispense Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Dispense Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Dispense Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number Of Refills");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Ordering Provider's DEA Number");
                                  this.add(XCN.class, false, 0, 0, new Object[]{ getMessage() }, "Pharmacist/Treatment Supplier's Verifier ID");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Needs Human Review");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Per (Time Unit)");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Strength");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Strength Units");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Indication");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Rate Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Give Rate Units");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Total Daily Dose");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Supplementary Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Drug Strength Volume");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Requested Drug Strength Volume Units");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(480) }, "Pharmacy Order Type");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Dispensing Interval");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Medication Instance Identifier");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Segment Instance Identifier");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Mood Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Dispensing Pharmacy");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "Dispensing Pharmacy Address");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-to Patient Location");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-to Address");
                                  this.add(XTN.class, false, 0, 0, new Object[]{ getMessage() }, "Pharmacy Phone Number");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXO - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXO-1: "Requested Give Code" - creates it if necessary
     */
    public CWE getRequestedGiveCode() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-1: "Requested Give Code" - creates it if necessary
     */
    public CWE getRxo1_RequestedGiveCode() { 
		CWE retVal = this.getTypedField(1, 0);
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
    public CWE getRequestedGiveUnits() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-4: "Requested Give Units" - creates it if necessary
     */
    public CWE getRxo4_RequestedGiveUnits() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-5: "Requested Dosage Form" - creates it if necessary
     */
    public CWE getRequestedDosageForm() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-5: "Requested Dosage Form" - creates it if necessary
     */
    public CWE getRxo5_RequestedDosageForm() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Provider's Pharmacy/Treatment Instructions (RXO-6).
     */
    public CWE[] getProviderSPharmacyTreatmentInstructions() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider's Pharmacy/Treatment Instructions (RXO-6).
     */
    public CWE[] getRxo6_ProviderSPharmacyTreatmentInstructions() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
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
    public CWE getProviderSPharmacyTreatmentInstructions(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxo6_ProviderSPharmacyTreatmentInstructions(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
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
    public CWE insertProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxo6_ProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RXO-6: "Provider's Pharmacy/Treatment Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxo6_ProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Provider's Administration Instructions (RXO-7).
     */
    public CWE[] getProviderSAdministrationInstructions() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider's Administration Instructions (RXO-7).
     */
    public CWE[] getRxo7_ProviderSAdministrationInstructions() {
    	CWE[] retVal = this.getTypedField(7, new CWE[0]);
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
    public CWE getProviderSAdministrationInstructions(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-7: "Provider's Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxo7_ProviderSAdministrationInstructions(int rep) { 
		CWE retVal = this.getTypedField(7, rep);
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
    public CWE insertProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxo7_ProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXO-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxo7_ProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * RXO-8: "Deliver-To Location" - creates it if necessary
     */
    public NULLDT getDeliverToLocation() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-8: "Deliver-To Location" - creates it if necessary
     */
    public NULLDT getRxo8_DeliverToLocation() { 
		NULLDT retVal = this.getTypedField(8, 0);
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
    public CWE getRequestedDispenseCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-10: "Requested Dispense Code" - creates it if necessary
     */
    public CWE getRxo10_RequestedDispenseCode() { 
		CWE retVal = this.getTypedField(10, 0);
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
    public CWE getRequestedDispenseUnits() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-12: "Requested Dispense Units" - creates it if necessary
     */
    public CWE getRxo12_RequestedDispenseUnits() { 
		CWE retVal = this.getTypedField(12, 0);
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
    public CWE getRequestedGiveStrengthUnits() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-19: "Requested Give Strength Units" - creates it if necessary
     */
    public CWE getRxo19_RequestedGiveStrengthUnits() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXO-20).
     */
    public CWE[] getIndication() {
    	CWE[] retVal = this.getTypedField(20, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXO-20).
     */
    public CWE[] getRxo20_Indication() {
    	CWE[] retVal = this.getTypedField(20, new CWE[0]);
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
    public CWE getIndication(int rep) { 
		CWE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-20: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxo20_Indication(int rep) { 
		CWE retVal = this.getTypedField(20, rep);
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
    public CWE insertIndication(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxo20_Indication(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIndication(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXO-20: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxo20_Indication(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(20, rep);
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
    public CWE getRequestedGiveRateUnits() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-22: "Requested Give Rate Units" - creates it if necessary
     */
    public CWE getRxo22_RequestedGiveRateUnits() { 
		CWE retVal = this.getTypedField(22, 0);
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
    public CWE[] getSupplementaryCode() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Supplementary Code (RXO-24).
     */
    public CWE[] getRxo24_SupplementaryCode() {
    	CWE[] retVal = this.getTypedField(24, new CWE[0]);
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
    public CWE getSupplementaryCode(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-24: "Supplementary Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxo24_SupplementaryCode(int rep) { 
		CWE retVal = this.getTypedField(24, rep);
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
    public CWE insertSupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxo24_SupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * RXO-24: "Supplementary Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxo24_SupplementaryCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(24, rep);
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



    /**
     * Returns
     * RXO-29: "Medication Instance Identifier" - creates it if necessary
     */
    public EI getMedicationInstanceIdentifier() { 
		EI retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-29: "Medication Instance Identifier" - creates it if necessary
     */
    public EI getRxo29_MedicationInstanceIdentifier() { 
		EI retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-30: "Segment Instance Identifier" - creates it if necessary
     */
    public EI getSegmentInstanceIdentifier() { 
		EI retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-30: "Segment Instance Identifier" - creates it if necessary
     */
    public EI getRxo30_SegmentInstanceIdentifier() { 
		EI retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-31: "Mood Code" - creates it if necessary
     */
    public CNE getMoodCode() { 
		CNE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-31: "Mood Code" - creates it if necessary
     */
    public CNE getRxo31_MoodCode() { 
		CNE retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-32: "Dispensing Pharmacy" - creates it if necessary
     */
    public CWE getDispensingPharmacy() { 
		CWE retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-32: "Dispensing Pharmacy" - creates it if necessary
     */
    public CWE getRxo32_DispensingPharmacy() { 
		CWE retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-33: "Dispensing Pharmacy Address" - creates it if necessary
     */
    public XAD getDispensingPharmacyAddress() { 
		XAD retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-33: "Dispensing Pharmacy Address" - creates it if necessary
     */
    public XAD getRxo33_DispensingPharmacyAddress() { 
		XAD retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-34: "Deliver-to Patient Location" - creates it if necessary
     */
    public PL getDeliverToPatientLocation() { 
		PL retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-34: "Deliver-to Patient Location" - creates it if necessary
     */
    public PL getRxo34_DeliverToPatientLocation() { 
		PL retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-35: "Deliver-to Address" - creates it if necessary
     */
    public XAD getDeliverToAddress() { 
		XAD retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-35: "Deliver-to Address" - creates it if necessary
     */
    public XAD getRxo35_DeliverToAddress() { 
		XAD retVal = this.getTypedField(35, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy Phone Number (RXO-36).
     */
    public XTN[] getPharmacyPhoneNumber() {
    	XTN[] retVal = this.getTypedField(36, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy Phone Number (RXO-36).
     */
    public XTN[] getRxo36_PharmacyPhoneNumber() {
    	XTN[] retVal = this.getTypedField(36, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pharmacy Phone Number (RXO-36).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPharmacyPhoneNumberReps() {
    	return this.getReps(36);
    }


    /**
     * Returns a specific repetition of
     * RXO-36: "Pharmacy Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPharmacyPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(36, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-36: "Pharmacy Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getRxo36_PharmacyPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(36, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pharmacy Phone Number (RXO-36).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo36_PharmacyPhoneNumberReps() {
    	return this.getReps(36);
    }


    /**
     * Inserts a repetition of
     * RXO-36: "Pharmacy Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPharmacyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(36, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-36: "Pharmacy Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertRxo36_PharmacyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(36, rep);
    }


    /**
     * Removes a repetition of
     * RXO-36: "Pharmacy Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePharmacyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(36, rep);
    }


    /**
     * Removes a repetition of
     * RXO-36: "Pharmacy Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeRxo36_PharmacyPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(36, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new NULLDT(getMessage());
          case 8: return new ID(getMessage(), new Integer( 161 ));
          case 9: return new CWE(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new XCN(getMessage());
          case 14: return new XCN(getMessage());
          case 15: return new ID(getMessage(), new Integer( 136 ));
          case 16: return new ST(getMessage());
          case 17: return new NM(getMessage());
          case 18: return new CWE(getMessage());
          case 19: return new CWE(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new CQ(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new NM(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new ID(getMessage(), new Integer( 480 ));
          case 27: return new NM(getMessage());
          case 28: return new EI(getMessage());
          case 29: return new EI(getMessage());
          case 30: return new CNE(getMessage());
          case 31: return new CWE(getMessage());
          case 32: return new XAD(getMessage());
          case 33: return new PL(getMessage());
          case 34: return new XAD(getMessage());
          case 35: return new XTN(getMessage());
          default: return null;
       }
   }


}

