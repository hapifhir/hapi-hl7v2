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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RXG message segment (Pharmacy/Treatment Give). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXG-1: Give Sub-ID Counter (NM) <b> </b>
     * <li>RXG-2: Dispense Sub-ID Counter (NM) <b>optional </b>
     * <li>RXG-3: Quantity/Timing (TQ) <b>optional </b>
     * <li>RXG-4: Give Code (CE) <b> </b>
     * <li>RXG-5: Give Amount - Minimum (NM) <b> </b>
     * <li>RXG-6: Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXG-7: Give Units (CE) <b> </b>
     * <li>RXG-8: Give Dosage Form (CE) <b>optional </b>
     * <li>RXG-9: Administration Notes (CE) <b>optional repeating</b>
     * <li>RXG-10: Substitution Status (ID) <b>optional </b>
     * <li>RXG-11: Dispense-to Location (LA2) <b>optional </b>
     * <li>RXG-12: Needs Human Review (ID) <b>optional </b>
     * <li>RXG-13: Pharmacy/Treatment Supplier's Special Administration Instructions (CE) <b>optional repeating</b>
     * <li>RXG-14: Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXG-15: Give Rate Amount (ST) <b>optional </b>
     * <li>RXG-16: Give Rate Units (CE) <b>optional </b>
     * <li>RXG-17: Give Strength (NM) <b>optional </b>
     * <li>RXG-18: Give Strength Units (CE) <b>optional </b>
     * <li>RXG-19: Substance Lot Number (ST) <b>optional repeating</b>
     * <li>RXG-20: Substance Expiration Date (TS) <b>optional repeating</b>
     * <li>RXG-21: Substance Manufacturer Name (CE) <b>optional repeating</b>
     * <li>RXG-22: Indication (CE) <b>optional repeating</b>
     * <li>RXG-23: Give Drug Strength Volume (NM) <b>optional </b>
     * <li>RXG-24: Give Drug Strength Volume Units (CWE) <b>optional </b>
     * <li>RXG-25: Give Barcode Identifier (CWE) <b>optional </b>
     * <li>RXG-26: Pharmacy Order Type (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXG extends AbstractSegment {

    /** 
     * Creates a new RXG segment
     */
    public RXG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Give Sub-ID Counter");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Dispense Sub-ID Counter");
                                  this.add(TQ.class, false, 1, 200, new Object[]{ getMessage() }, "Quantity/Timing");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Give Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Give Amount - Maximum");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Give Units");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Give Dosage Form");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Administration Notes");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(167) }, "Substitution Status");
                                  this.add(LA2.class, false, 1, 200, new Object[]{ getMessage() }, "Dispense-to Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Needs Human Review");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Pharmacy/Treatment Supplier's Special Administration Instructions");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Give Per (Time Unit)");
                                  this.add(ST.class, false, 1, 6, new Object[]{ getMessage() }, "Give Rate Amount");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Give Rate Units");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Give Strength");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Give Strength Units");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "Substance Lot Number");
                                  this.add(TS.class, false, 0, 26, new Object[]{ getMessage() }, "Substance Expiration Date");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Substance Manufacturer Name");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Indication");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Give Drug Strength Volume");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Give Drug Strength Volume Units");
                                  this.add(CWE.class, false, 1, 60, new Object[]{ getMessage() }, "Give Barcode Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(480) }, "Pharmacy Order Type");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXG-1: "Give Sub-ID Counter" - creates it if necessary
     */
    public NM getGiveSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-1: "Give Sub-ID Counter" - creates it if necessary
     */
    public NM getRxg1_GiveSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-2: "Dispense Sub-ID Counter" - creates it if necessary
     */
    public NM getDispenseSubIDCounter() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-2: "Dispense Sub-ID Counter" - creates it if necessary
     */
    public NM getRxg2_DispenseSubIDCounter() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-3: "Quantity/Timing" - creates it if necessary
     */
    public TQ getQuantityTiming() { 
		TQ retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-3: "Quantity/Timing" - creates it if necessary
     */
    public TQ getRxg3_QuantityTiming() { 
		TQ retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-4: "Give Code" - creates it if necessary
     */
    public CE getGiveCode() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-4: "Give Code" - creates it if necessary
     */
    public CE getRxg4_GiveCode() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-5: "Give Amount - Minimum" - creates it if necessary
     */
    public NM getGiveAmountMinimum() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-5: "Give Amount - Minimum" - creates it if necessary
     */
    public NM getRxg5_GiveAmountMinimum() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-6: "Give Amount - Maximum" - creates it if necessary
     */
    public NM getGiveAmountMaximum() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-6: "Give Amount - Maximum" - creates it if necessary
     */
    public NM getRxg6_GiveAmountMaximum() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-7: "Give Units" - creates it if necessary
     */
    public CE getGiveUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-7: "Give Units" - creates it if necessary
     */
    public CE getRxg7_GiveUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-8: "Give Dosage Form" - creates it if necessary
     */
    public CE getGiveDosageForm() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-8: "Give Dosage Form" - creates it if necessary
     */
    public CE getRxg8_GiveDosageForm() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Administration Notes (RXG-9).
     */
    public CE[] getAdministrationNotes() {
    	CE[] retVal = this.getTypedField(9, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Administration Notes (RXG-9).
     */
    public CE[] getRxg9_AdministrationNotes() {
    	CE[] retVal = this.getTypedField(9, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Administration Notes (RXG-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdministrationNotesReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * RXG-9: "Administration Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getAdministrationNotes(int rep) { 
		CE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-9: "Administration Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxg9_AdministrationNotes(int rep) { 
		CE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Administration Notes (RXG-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg9_AdministrationNotesReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertAdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxg9_AdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeAdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxg9_AdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * RXG-10: "Substitution Status" - creates it if necessary
     */
    public ID getSubstitutionStatus() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-10: "Substitution Status" - creates it if necessary
     */
    public ID getRxg10_SubstitutionStatus() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-11: "Dispense-to Location" - creates it if necessary
     */
    public LA2 getDispenseToLocation() { 
		LA2 retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-11: "Dispense-to Location" - creates it if necessary
     */
    public LA2 getRxg11_DispenseToLocation() { 
		LA2 retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-12: "Needs Human Review" - creates it if necessary
     */
    public ID getNeedsHumanReview() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-12: "Needs Human Review" - creates it if necessary
     */
    public ID getRxg12_NeedsHumanReview() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy/Treatment Supplier's Special Administration Instructions (RXG-13).
     */
    public CE[] getPharmacyTreatmentSupplierSSpecialAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(13, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy/Treatment Supplier's Special Administration Instructions (RXG-13).
     */
    public CE[] getRxg13_PharmacyTreatmentSupplierSSpecialAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(13, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pharmacy/Treatment Supplier's Special Administration Instructions (RXG-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPharmacyTreatmentSupplierSSpecialAdministrationInstructionsReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * RXG-13: "Pharmacy/Treatment Supplier's Special Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-13: "Pharmacy/Treatment Supplier's Special Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxg13_PharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pharmacy/Treatment Supplier's Special Administration Instructions (RXG-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg13_PharmacyTreatmentSupplierSSpecialAdministrationInstructionsReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * RXG-13: "Pharmacy/Treatment Supplier's Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-13: "Pharmacy/Treatment Supplier's Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxg13_PharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * RXG-13: "Pharmacy/Treatment Supplier's Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * RXG-13: "Pharmacy/Treatment Supplier's Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxg13_PharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(13, rep);
    }




    /**
     * Returns
     * RXG-14: "Give Per (Time Unit)" - creates it if necessary
     */
    public ST getGivePerTimeUnit() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-14: "Give Per (Time Unit)" - creates it if necessary
     */
    public ST getRxg14_GivePerTimeUnit() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-15: "Give Rate Amount" - creates it if necessary
     */
    public ST getGiveRateAmount() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-15: "Give Rate Amount" - creates it if necessary
     */
    public ST getRxg15_GiveRateAmount() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-16: "Give Rate Units" - creates it if necessary
     */
    public CE getGiveRateUnits() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-16: "Give Rate Units" - creates it if necessary
     */
    public CE getRxg16_GiveRateUnits() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-17: "Give Strength" - creates it if necessary
     */
    public NM getGiveStrength() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-17: "Give Strength" - creates it if necessary
     */
    public NM getRxg17_GiveStrength() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-18: "Give Strength Units" - creates it if necessary
     */
    public CE getGiveStrengthUnits() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-18: "Give Strength Units" - creates it if necessary
     */
    public CE getRxg18_GiveStrengthUnits() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Substance Lot Number (RXG-19).
     */
    public ST[] getSubstanceLotNumber() {
    	ST[] retVal = this.getTypedField(19, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Lot Number (RXG-19).
     */
    public ST[] getRxg19_SubstanceLotNumber() {
    	ST[] retVal = this.getTypedField(19, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Lot Number (RXG-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceLotNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * RXG-19: "Substance Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getSubstanceLotNumber(int rep) { 
		ST retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-19: "Substance Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRxg19_SubstanceLotNumber(int rep) { 
		ST retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Lot Number (RXG-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg19_SubstanceLotNumberReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * RXG-19: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertSubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-19: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRxg19_SubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * RXG-19: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeSubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * RXG-19: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRxg19_SubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(19, rep);
    }



    /**
     * Returns all repetitions of Substance Expiration Date (RXG-20).
     */
    public TS[] getSubstanceExpirationDate() {
    	TS[] retVal = this.getTypedField(20, new TS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Expiration Date (RXG-20).
     */
    public TS[] getRxg20_SubstanceExpirationDate() {
    	TS[] retVal = this.getTypedField(20, new TS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Expiration Date (RXG-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceExpirationDateReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * RXG-20: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TS getSubstanceExpirationDate(int rep) { 
		TS retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-20: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TS getRxg20_SubstanceExpirationDate(int rep) { 
		TS retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Expiration Date (RXG-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg20_SubstanceExpirationDateReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS insertSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS insertRxg20_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS removeSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS removeRxg20_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Substance Manufacturer Name (RXG-21).
     */
    public CE[] getSubstanceManufacturerName() {
    	CE[] retVal = this.getTypedField(21, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Manufacturer Name (RXG-21).
     */
    public CE[] getRxg21_SubstanceManufacturerName() {
    	CE[] retVal = this.getTypedField(21, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Manufacturer Name (RXG-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceManufacturerNameReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * RXG-21: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getSubstanceManufacturerName(int rep) { 
		CE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-21: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxg21_SubstanceManufacturerName(int rep) { 
		CE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Manufacturer Name (RXG-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg21_SubstanceManufacturerNameReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxg21_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxg21_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(21, rep);
    }



    /**
     * Returns all repetitions of Indication (RXG-22).
     */
    public CE[] getIndication() {
    	CE[] retVal = this.getTypedField(22, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXG-22).
     */
    public CE[] getRxg22_Indication() {
    	CE[] retVal = this.getTypedField(22, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Indication (RXG-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIndicationReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * RXG-22: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIndication(int rep) { 
		CE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-22: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxg22_Indication(int rep) { 
		CE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Indication (RXG-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg22_IndicationReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIndication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxg22_Indication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIndication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxg22_Indication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(22, rep);
    }




    /**
     * Returns
     * RXG-23: "Give Drug Strength Volume" - creates it if necessary
     */
    public NM getGiveDrugStrengthVolume() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-23: "Give Drug Strength Volume" - creates it if necessary
     */
    public NM getRxg23_GiveDrugStrengthVolume() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-24: "Give Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getGiveDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-24: "Give Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getRxg24_GiveDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-25: "Give Barcode Identifier" - creates it if necessary
     */
    public CWE getGiveBarcodeIdentifier() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-25: "Give Barcode Identifier" - creates it if necessary
     */
    public CWE getRxg25_GiveBarcodeIdentifier() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-26: "Pharmacy Order Type" - creates it if necessary
     */
    public ID getPharmacyOrderType() { 
		ID retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-26: "Pharmacy Order Type" - creates it if necessary
     */
    public ID getRxg26_PharmacyOrderType() { 
		ID retVal = this.getTypedField(26, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new TQ(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new CE(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new ID(getMessage(), new Integer( 167 ));
          case 10: return new LA2(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          case 12: return new CE(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new NM(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new TS(getMessage());
          case 20: return new CE(getMessage());
          case 21: return new CE(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new ID(getMessage(), new Integer( 480 ));
          default: return null;
       }
   }


}

