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
 *<p>Represents an HL7 RXD message segment (RXD - pharmacy/treatment dispense segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXD-1: Dispense Sub-ID Counter (NM) <b> </b>
     * <li>RXD-2: Dispense/Give Code (CE) <b> </b>
     * <li>RXD-3: Date/Time Dispensed (TS) <b> </b>
     * <li>RXD-4: Actual Dispense Amount (NM) <b> </b>
     * <li>RXD-5: Actual Dispense Units (CE) <b>optional </b>
     * <li>RXD-6: Actual Dosage Form (CE) <b>optional </b>
     * <li>RXD-7: Prescription Number (ST) <b> </b>
     * <li>RXD-8: Number of Refills Remaining (NM) <b>optional </b>
     * <li>RXD-9: Dispense Notes (ST) <b>optional repeating</b>
     * <li>RXD-10: Dispensing Provider (XCN) <b>optional repeating</b>
     * <li>RXD-11: Substitution Status (ID) <b>optional </b>
     * <li>RXD-12: Total Daily Dose (CQ) <b>optional </b>
     * <li>RXD-13: Dispense-To Location (LA2) <b>optional </b>
     * <li>RXD-14: Needs Human Review (ID) <b>optional </b>
     * <li>RXD-15: Pharmacy/Treatment Supplier’s Special Dispensing Instructions (CE) <b>optional repeating</b>
     * <li>RXD-16: Actual Strength (NM) <b>optional </b>
     * <li>RXD-17: Actual Strength Unit (CE) <b>optional </b>
     * <li>RXD-18: Substance Lot Number (ST) <b>optional repeating</b>
     * <li>RXD-19: Substance Expiration Date (TS) <b>optional repeating</b>
     * <li>RXD-20: Substance Manufacturer Name (CE) <b>optional repeating</b>
     * <li>RXD-21: Indication (CE) <b>optional repeating</b>
     * <li>RXD-22: Dispense Package Size (NM) <b>optional </b>
     * <li>RXD-23: Dispense Package Size Unit (CE) <b>optional </b>
     * <li>RXD-24: Dispense Package Method (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXD extends AbstractSegment {

    /** 
     * Creates a new RXD segment
     */
    public RXD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Dispense Sub-ID Counter");
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Dispense/Give Code");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date/Time Dispensed");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Actual Dispense Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Actual Dispense Units");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Actual Dosage Form");
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "Prescription Number");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Number of Refills Remaining");
                                  this.add(ST.class, false, 0, 200, new Object[]{ getMessage() }, "Dispense Notes");
                                  this.add(XCN.class, false, 0, 200, new Object[]{ getMessage() }, "Dispensing Provider");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(167) }, "Substitution Status");
                                  this.add(CQ.class, false, 1, 10, new Object[]{ getMessage() }, "Total Daily Dose");
                                  this.add(LA2.class, false, 1, 200, new Object[]{ getMessage() }, "Dispense-To Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Needs Human Review");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Pharmacy/Treatment Supplier’s Special Dispensing Instructions");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Actual Strength");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Actual Strength Unit");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "Substance Lot Number");
                                  this.add(TS.class, false, 0, 26, new Object[]{ getMessage() }, "Substance Expiration Date");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Substance Manufacturer Name");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Indication");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Dispense Package Size");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Dispense Package Size Unit");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(321) }, "Dispense Package Method");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXD-1: "Dispense Sub-ID Counter" - creates it if necessary
     */
    public NM getDispenseSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-1: "Dispense Sub-ID Counter" - creates it if necessary
     */
    public NM getRxd1_DispenseSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-2: "Dispense/Give Code" - creates it if necessary
     */
    public CE getDispenseGiveCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-2: "Dispense/Give Code" - creates it if necessary
     */
    public CE getRxd2_DispenseGiveCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-3: "Date/Time Dispensed" - creates it if necessary
     */
    public TS getDateTimeDispensed() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-3: "Date/Time Dispensed" - creates it if necessary
     */
    public TS getRxd3_DateTimeDispensed() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-4: "Actual Dispense Amount" - creates it if necessary
     */
    public NM getActualDispenseAmount() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-4: "Actual Dispense Amount" - creates it if necessary
     */
    public NM getRxd4_ActualDispenseAmount() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-5: "Actual Dispense Units" - creates it if necessary
     */
    public CE getActualDispenseUnits() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-5: "Actual Dispense Units" - creates it if necessary
     */
    public CE getRxd5_ActualDispenseUnits() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-6: "Actual Dosage Form" - creates it if necessary
     */
    public CE getActualDosageForm() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-6: "Actual Dosage Form" - creates it if necessary
     */
    public CE getRxd6_ActualDosageForm() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-7: "Prescription Number" - creates it if necessary
     */
    public ST getPrescriptionNumber() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-7: "Prescription Number" - creates it if necessary
     */
    public ST getRxd7_PrescriptionNumber() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-8: "Number of Refills Remaining" - creates it if necessary
     */
    public NM getNumberOfRefillsRemaining() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-8: "Number of Refills Remaining" - creates it if necessary
     */
    public NM getRxd8_NumberOfRefillsRemaining() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Dispense Notes (RXD-9).
     */
    public ST[] getDispenseNotes() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Dispense Notes (RXD-9).
     */
    public ST[] getRxd9_DispenseNotes() {
    	ST[] retVal = this.getTypedField(9, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Dispense Notes (RXD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDispenseNotesReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * RXD-9: "Dispense Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getDispenseNotes(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-9: "Dispense Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRxd9_DispenseNotes(int rep) { 
		ST retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Dispense Notes (RXD-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd9_DispenseNotesReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * RXD-9: "Dispense Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertDispenseNotes(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-9: "Dispense Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRxd9_DispenseNotes(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXD-9: "Dispense Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeDispenseNotes(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXD-9: "Dispense Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRxd9_DispenseNotes(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Dispensing Provider (RXD-10).
     */
    public XCN[] getDispensingProvider() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Dispensing Provider (RXD-10).
     */
    public XCN[] getRxd10_DispensingProvider() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Dispensing Provider (RXD-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDispensingProviderReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * RXD-10: "Dispensing Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getDispensingProvider(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-10: "Dispensing Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRxd10_DispensingProvider(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Dispensing Provider (RXD-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd10_DispensingProviderReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * RXD-10: "Dispensing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertDispensingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-10: "Dispensing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRxd10_DispensingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RXD-10: "Dispensing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeDispensingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RXD-10: "Dispensing Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRxd10_DispensingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * RXD-11: "Substitution Status" - creates it if necessary
     */
    public ID getSubstitutionStatus() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-11: "Substitution Status" - creates it if necessary
     */
    public ID getRxd11_SubstitutionStatus() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-12: "Total Daily Dose" - creates it if necessary
     */
    public CQ getTotalDailyDose() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-12: "Total Daily Dose" - creates it if necessary
     */
    public CQ getRxd12_TotalDailyDose() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-13: "Dispense-To Location" - creates it if necessary
     */
    public LA2 getDispenseToLocation() { 
		LA2 retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-13: "Dispense-To Location" - creates it if necessary
     */
    public LA2 getRxd13_DispenseToLocation() { 
		LA2 retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-14: "Needs Human Review" - creates it if necessary
     */
    public ID getNeedsHumanReview() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-14: "Needs Human Review" - creates it if necessary
     */
    public ID getRxd14_NeedsHumanReview() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy/Treatment Supplier’s Special Dispensing Instructions (RXD-15).
     */
    public CE[] getPharmacyTreatmentSupplierSSpecialDispensingInstructions() {
    	CE[] retVal = this.getTypedField(15, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy/Treatment Supplier’s Special Dispensing Instructions (RXD-15).
     */
    public CE[] getRxd15_PharmacyTreatmentSupplierSSpecialDispensingInstructions() {
    	CE[] retVal = this.getTypedField(15, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pharmacy/Treatment Supplier’s Special Dispensing Instructions (RXD-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPharmacyTreatmentSupplierSSpecialDispensingInstructionsReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * RXD-15: "Pharmacy/Treatment Supplier’s Special Dispensing Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPharmacyTreatmentSupplierSSpecialDispensingInstructions(int rep) { 
		CE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-15: "Pharmacy/Treatment Supplier’s Special Dispensing Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxd15_PharmacyTreatmentSupplierSSpecialDispensingInstructions(int rep) { 
		CE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pharmacy/Treatment Supplier’s Special Dispensing Instructions (RXD-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd15_PharmacyTreatmentSupplierSSpecialDispensingInstructionsReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * RXD-15: "Pharmacy/Treatment Supplier’s Special Dispensing Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPharmacyTreatmentSupplierSSpecialDispensingInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-15: "Pharmacy/Treatment Supplier’s Special Dispensing Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxd15_PharmacyTreatmentSupplierSSpecialDispensingInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RXD-15: "Pharmacy/Treatment Supplier’s Special Dispensing Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePharmacyTreatmentSupplierSSpecialDispensingInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RXD-15: "Pharmacy/Treatment Supplier’s Special Dispensing Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxd15_PharmacyTreatmentSupplierSSpecialDispensingInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(15, rep);
    }




    /**
     * Returns
     * RXD-16: "Actual Strength" - creates it if necessary
     */
    public NM getActualStrength() { 
		NM retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-16: "Actual Strength" - creates it if necessary
     */
    public NM getRxd16_ActualStrength() { 
		NM retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-17: "Actual Strength Unit" - creates it if necessary
     */
    public CE getActualStrengthUnit() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-17: "Actual Strength Unit" - creates it if necessary
     */
    public CE getRxd17_ActualStrengthUnit() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Substance Lot Number (RXD-18).
     */
    public ST[] getSubstanceLotNumber() {
    	ST[] retVal = this.getTypedField(18, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Lot Number (RXD-18).
     */
    public ST[] getRxd18_SubstanceLotNumber() {
    	ST[] retVal = this.getTypedField(18, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Lot Number (RXD-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceLotNumberReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * RXD-18: "Substance Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getSubstanceLotNumber(int rep) { 
		ST retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-18: "Substance Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRxd18_SubstanceLotNumber(int rep) { 
		ST retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Lot Number (RXD-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd18_SubstanceLotNumberReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * RXD-18: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertSubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-18: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRxd18_SubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * RXD-18: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeSubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * RXD-18: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRxd18_SubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(18, rep);
    }



    /**
     * Returns all repetitions of Substance Expiration Date (RXD-19).
     */
    public TS[] getSubstanceExpirationDate() {
    	TS[] retVal = this.getTypedField(19, new TS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Expiration Date (RXD-19).
     */
    public TS[] getRxd19_SubstanceExpirationDate() {
    	TS[] retVal = this.getTypedField(19, new TS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Expiration Date (RXD-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceExpirationDateReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * RXD-19: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TS getSubstanceExpirationDate(int rep) { 
		TS retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-19: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TS getRxd19_SubstanceExpirationDate(int rep) { 
		TS retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Expiration Date (RXD-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd19_SubstanceExpirationDateReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * RXD-19: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS insertSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-19: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS insertRxd19_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * RXD-19: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS removeSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * RXD-19: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS removeRxd19_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.removeRepetition(19, rep);
    }



    /**
     * Returns all repetitions of Substance Manufacturer Name (RXD-20).
     */
    public CE[] getSubstanceManufacturerName() {
    	CE[] retVal = this.getTypedField(20, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Manufacturer Name (RXD-20).
     */
    public CE[] getRxd20_SubstanceManufacturerName() {
    	CE[] retVal = this.getTypedField(20, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Manufacturer Name (RXD-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceManufacturerNameReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * RXD-20: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getSubstanceManufacturerName(int rep) { 
		CE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-20: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxd20_SubstanceManufacturerName(int rep) { 
		CE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Manufacturer Name (RXD-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd20_SubstanceManufacturerNameReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * RXD-20: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-20: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxd20_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXD-20: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXD-20: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxd20_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Indication (RXD-21).
     */
    public CE[] getIndication() {
    	CE[] retVal = this.getTypedField(21, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXD-21).
     */
    public CE[] getRxd21_Indication() {
    	CE[] retVal = this.getTypedField(21, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Indication (RXD-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIndicationReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * RXD-21: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIndication(int rep) { 
		CE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXD-21: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxd21_Indication(int rep) { 
		CE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Indication (RXD-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxd21_IndicationReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * RXD-21: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIndication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * RXD-21: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxd21_Indication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * RXD-21: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIndication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * RXD-21: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxd21_Indication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * RXD-22: "Dispense Package Size" - creates it if necessary
     */
    public NM getDispensePackageSize() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-22: "Dispense Package Size" - creates it if necessary
     */
    public NM getRxd22_DispensePackageSize() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-23: "Dispense Package Size Unit" - creates it if necessary
     */
    public CE getDispensePackageSizeUnit() { 
		CE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-23: "Dispense Package Size Unit" - creates it if necessary
     */
    public CE getRxd23_DispensePackageSizeUnit() { 
		CE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-24: "Dispense Package Method" - creates it if necessary
     */
    public ID getDispensePackageMethod() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-24: "Dispense Package Method" - creates it if necessary
     */
    public ID getRxd24_DispensePackageMethod() { 
		ID retVal = this.getTypedField(24, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new ST(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new XCN(getMessage());
          case 10: return new ID(getMessage(), new Integer( 167 ));
          case 11: return new CQ(getMessage());
          case 12: return new LA2(getMessage());
          case 13: return new ID(getMessage(), new Integer( 136 ));
          case 14: return new CE(getMessage());
          case 15: return new NM(getMessage());
          case 16: return new CE(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new TS(getMessage());
          case 19: return new CE(getMessage());
          case 20: return new CE(getMessage());
          case 21: return new NM(getMessage());
          case 22: return new CE(getMessage());
          case 23: return new ID(getMessage(), new Integer( 321 ));
          default: return null;
       }
   }


}

