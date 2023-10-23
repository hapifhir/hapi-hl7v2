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
 *<p>Represents an HL7 RXG message segment (Pharmacy/Treatment Give). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXG-1: Give Sub-ID Counter (NM) <b> </b>
     * <li>RXG-2: Dispense Sub-ID Counter (NM) <b>optional </b>
     * <li>RXG-3: Quantity/Timing (NULLDT) <b>optional </b>
     * <li>RXG-4: Give Code (CWE) <b> </b>
     * <li>RXG-5: Give Amount - Minimum (NM) <b> </b>
     * <li>RXG-6: Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXG-7: Give Units (CWE) <b> </b>
     * <li>RXG-8: Give Dosage Form (CWE) <b>optional </b>
     * <li>RXG-9: Administration Notes (CWE) <b>optional repeating</b>
     * <li>RXG-10: Substitution Status (ID) <b>optional </b>
     * <li>RXG-11: Dispense-to Location (NULLDT) <b>optional </b>
     * <li>RXG-12: Needs Human Review (ID) <b>optional </b>
     * <li>RXG-13: Special Administration Instructions (CWE) <b>optional repeating</b>
     * <li>RXG-14: Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXG-15: Give Rate Amount (ST) <b>optional </b>
     * <li>RXG-16: Give Rate Units (CWE) <b>optional </b>
     * <li>RXG-17: Give Strength (NM) <b>optional </b>
     * <li>RXG-18: Give Strength Units (CWE) <b>optional </b>
     * <li>RXG-19: Substance Lot Number (ST) <b>optional repeating</b>
     * <li>RXG-20: Substance Expiration Date (DTM) <b>optional repeating</b>
     * <li>RXG-21: Substance Manufacturer Name (CWE) <b>optional repeating</b>
     * <li>RXG-22: Indication (CWE) <b>optional repeating</b>
     * <li>RXG-23: Give Drug Strength Volume (NM) <b>optional </b>
     * <li>RXG-24: Give Drug Strength Volume Units (CWE) <b>optional </b>
     * <li>RXG-25: Give Barcode Identifier (CWE) <b>optional </b>
     * <li>RXG-26: Pharmacy Order Type (ID) <b>optional </b>
     * <li>RXG-27: Dispense to Pharmacy (CWE) <b>optional </b>
     * <li>RXG-28: Dispense to Pharmacy Address (XAD) <b>optional </b>
     * <li>RXG-29: Deliver-to Patient Location (PL) <b>optional </b>
     * <li>RXG-30: Deliver-to Address (XAD) <b>optional </b>
     * <li>RXG-31: Give Tag Identifier (EI) <b>optional repeating</b>
     * <li>RXG-32: Dispense Amount (NM) <b>optional </b>
     * <li>RXG-33: Dispense Units (CWE) <b>optional </b>
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
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Give Sub-ID Counter");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense Sub-ID Counter");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Quantity/Timing");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Give Code");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Give Amount - Maximum");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Give Units");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Give Dosage Form");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Administration Notes");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(167) }, "Substitution Status");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense-to Location");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Needs Human Review");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Special Administration Instructions");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Give Per (Time Unit)");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Give Rate Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Give Rate Units");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Give Strength");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Give Strength Units");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Substance Lot Number");
                                  this.add(DTM.class, false, 0, 0, new Object[]{ getMessage() }, "Substance Expiration Date");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Substance Manufacturer Name");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Indication");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Give Drug Strength Volume");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Give Drug Strength Volume Units");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Give Barcode Identifier");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(480) }, "Pharmacy Order Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense to Pharmacy");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense to Pharmacy Address");
                                  this.add(PL.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-to Patient Location");
                                  this.add(XAD.class, false, 1, 0, new Object[]{ getMessage() }, "Deliver-to Address");
                                  this.add(EI.class, false, 0, 0, new Object[]{ getMessage() }, "Give Tag Identifier");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Dispense Units");
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
    public NULLDT getQuantityTiming() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-3: "Quantity/Timing" - creates it if necessary
     */
    public NULLDT getRxg3_QuantityTiming() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-4: "Give Code" - creates it if necessary
     */
    public CWE getGiveCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-4: "Give Code" - creates it if necessary
     */
    public CWE getRxg4_GiveCode() { 
		CWE retVal = this.getTypedField(4, 0);
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
    public CWE getGiveUnits() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-7: "Give Units" - creates it if necessary
     */
    public CWE getRxg7_GiveUnits() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-8: "Give Dosage Form" - creates it if necessary
     */
    public CWE getGiveDosageForm() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-8: "Give Dosage Form" - creates it if necessary
     */
    public CWE getRxg8_GiveDosageForm() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Administration Notes (RXG-9).
     */
    public CWE[] getAdministrationNotes() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Administration Notes (RXG-9).
     */
    public CWE[] getRxg9_AdministrationNotes() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
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
    public CWE getAdministrationNotes(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-9: "Administration Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxg9_AdministrationNotes(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
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
    public CWE insertAdministrationNotes(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxg9_AdministrationNotes(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAdministrationNotes(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXG-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxg9_AdministrationNotes(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
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
    public NULLDT getDispenseToLocation() { 
		NULLDT retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-11: "Dispense-to Location" - creates it if necessary
     */
    public NULLDT getRxg11_DispenseToLocation() { 
		NULLDT retVal = this.getTypedField(11, 0);
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
     * Returns all repetitions of Special Administration Instructions (RXG-13).
     */
    public CWE[] getSpecialAdministrationInstructions() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Special Administration Instructions (RXG-13).
     */
    public CWE[] getRxg13_SpecialAdministrationInstructions() {
    	CWE[] retVal = this.getTypedField(13, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Special Administration Instructions (RXG-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecialAdministrationInstructionsReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * RXG-13: "Special Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSpecialAdministrationInstructions(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-13: "Special Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxg13_SpecialAdministrationInstructions(int rep) { 
		CWE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Special Administration Instructions (RXG-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg13_SpecialAdministrationInstructionsReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * RXG-13: "Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-13: "Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxg13_SpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * RXG-13: "Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * RXG-13: "Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxg13_SpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(13, rep);
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
    public CWE getGiveRateUnits() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-16: "Give Rate Units" - creates it if necessary
     */
    public CWE getRxg16_GiveRateUnits() { 
		CWE retVal = this.getTypedField(16, 0);
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
    public CWE getGiveStrengthUnits() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-18: "Give Strength Units" - creates it if necessary
     */
    public CWE getRxg18_GiveStrengthUnits() { 
		CWE retVal = this.getTypedField(18, 0);
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
    public DTM[] getSubstanceExpirationDate() {
    	DTM[] retVal = this.getTypedField(20, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Expiration Date (RXG-20).
     */
    public DTM[] getRxg20_SubstanceExpirationDate() {
    	DTM[] retVal = this.getTypedField(20, new DTM[0]);
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
    public DTM getSubstanceExpirationDate(int rep) { 
		DTM retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-20: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getRxg20_SubstanceExpirationDate(int rep) { 
		DTM retVal = this.getTypedField(20, rep);
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
    public DTM insertSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertRxg20_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * RXG-20: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeRxg20_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Substance Manufacturer Name (RXG-21).
     */
    public CWE[] getSubstanceManufacturerName() {
    	CWE[] retVal = this.getTypedField(21, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Manufacturer Name (RXG-21).
     */
    public CWE[] getRxg21_SubstanceManufacturerName() {
    	CWE[] retVal = this.getTypedField(21, new CWE[0]);
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
    public CWE getSubstanceManufacturerName(int rep) { 
		CWE retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-21: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxg21_SubstanceManufacturerName(int rep) { 
		CWE retVal = this.getTypedField(21, rep);
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
    public CWE insertSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxg21_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * RXG-21: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxg21_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(21, rep);
    }



    /**
     * Returns all repetitions of Indication (RXG-22).
     */
    public CWE[] getIndication() {
    	CWE[] retVal = this.getTypedField(22, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXG-22).
     */
    public CWE[] getRxg22_Indication() {
    	CWE[] retVal = this.getTypedField(22, new CWE[0]);
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
    public CWE getIndication(int rep) { 
		CWE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-22: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRxg22_Indication(int rep) { 
		CWE retVal = this.getTypedField(22, rep);
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
    public CWE insertIndication(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRxg22_Indication(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeIndication(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * RXG-22: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRxg22_Indication(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(22, rep);
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



    /**
     * Returns
     * RXG-27: "Dispense to Pharmacy" - creates it if necessary
     */
    public CWE getDispenseToPharmacy() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-27: "Dispense to Pharmacy" - creates it if necessary
     */
    public CWE getRxg27_DispenseToPharmacy() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-28: "Dispense to Pharmacy Address" - creates it if necessary
     */
    public XAD getDispenseToPharmacyAddress() { 
		XAD retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-28: "Dispense to Pharmacy Address" - creates it if necessary
     */
    public XAD getRxg28_DispenseToPharmacyAddress() { 
		XAD retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-29: "Deliver-to Patient Location" - creates it if necessary
     */
    public PL getDeliverToPatientLocation() { 
		PL retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-29: "Deliver-to Patient Location" - creates it if necessary
     */
    public PL getRxg29_DeliverToPatientLocation() { 
		PL retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-30: "Deliver-to Address" - creates it if necessary
     */
    public XAD getDeliverToAddress() { 
		XAD retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-30: "Deliver-to Address" - creates it if necessary
     */
    public XAD getRxg30_DeliverToAddress() { 
		XAD retVal = this.getTypedField(30, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Give Tag Identifier (RXG-31).
     */
    public EI[] getGiveTagIdentifier() {
    	EI[] retVal = this.getTypedField(31, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Give Tag Identifier (RXG-31).
     */
    public EI[] getRxg31_GiveTagIdentifier() {
    	EI[] retVal = this.getTypedField(31, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Give Tag Identifier (RXG-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGiveTagIdentifierReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * RXG-31: "Give Tag Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getGiveTagIdentifier(int rep) { 
		EI retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-31: "Give Tag Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getRxg31_GiveTagIdentifier(int rep) { 
		EI retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Give Tag Identifier (RXG-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg31_GiveTagIdentifierReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * RXG-31: "Give Tag Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertGiveTagIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-31: "Give Tag Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertRxg31_GiveTagIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * RXG-31: "Give Tag Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeGiveTagIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * RXG-31: "Give Tag Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeRxg31_GiveTagIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(31, rep);
    }




    /**
     * Returns
     * RXG-32: "Dispense Amount" - creates it if necessary
     */
    public NM getDispenseAmount() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-32: "Dispense Amount" - creates it if necessary
     */
    public NM getRxg32_DispenseAmount() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * RXG-33: "Dispense Units" - creates it if necessary
     */
    public CWE getDispenseUnits() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-33: "Dispense Units" - creates it if necessary
     */
    public CWE getRxg33_DispenseUnits() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new NULLDT(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new ID(getMessage(), new Integer( 167 ));
          case 10: return new NULLDT(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          case 12: return new CWE(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new NM(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new DTM(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new ID(getMessage(), new Integer( 480 ));
          case 26: return new CWE(getMessage());
          case 27: return new XAD(getMessage());
          case 28: return new PL(getMessage());
          case 29: return new XAD(getMessage());
          case 30: return new EI(getMessage());
          case 31: return new NM(getMessage());
          case 32: return new CWE(getMessage());
          default: return null;
       }
   }


}

