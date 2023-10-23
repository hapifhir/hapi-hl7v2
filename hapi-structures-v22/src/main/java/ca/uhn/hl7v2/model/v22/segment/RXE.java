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
 *<p>Represents an HL7 RXE message segment (PHARMACY ENCODED ORDER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXE-1: Quantity / timing (TQ) <b>optional repeating</b>
     * <li>RXE-2: Give Code (CE) <b> </b>
     * <li>RXE-3: Give Amount - Minimum (NM) <b> </b>
     * <li>RXE-4: Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXE-5: Give Units (CE) <b> </b>
     * <li>RXE-6: Give Dosage Form (CE) <b>optional </b>
     * <li>RXE-7: Provider's Administration Instructions (CE) <b>optional repeating</b>
     * <li>RXE-8: Deliver-to location (CM_LA1) <b>optional </b>
     * <li>RXE-9: Substitution Status (ID) <b>optional </b>
     * <li>RXE-10: Dispense Amount (NM) <b>optional </b>
     * <li>RXE-11: Dispense Units (CE) <b>optional </b>
     * <li>RXE-12: Number of Refills (NM) <b>optional </b>
     * <li>RXE-13: Ordering Provider's DEA Number (CN) <b>optional </b>
     * <li>RXE-14: Pharmacist Verifier ID (CN) <b>optional </b>
     * <li>RXE-15: Prescription Number (ST) <b> </b>
     * <li>RXE-16: Number of Refills Remaining (NM) <b>optional </b>
     * <li>RXE-17: Number of refills / doses dispensed (NM) <b>optional </b>
     * <li>RXE-18: Date / time of most recent refill or dose dispensed (TS) <b>optional </b>
     * <li>RXE-19: Total Daily Dose (CQ_QUANTITY) <b>optional </b>
     * <li>RXE-20: Needs Human Review (ID) <b>optional </b>
     * <li>RXE-21: Pharmacy Special Dispensing Instructions (CE) <b>optional </b>
     * <li>RXE-22: Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXE-23: Give Rate Amount (CE) <b>optional </b>
     * <li>RXE-24: Give Rate Units (CE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXE extends AbstractSegment {

    /** 
     * Creates a new RXE segment
     */
    public RXE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TQ.class, false, 0, 200, new Object[]{ getMessage() }, "Quantity / timing");
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Give Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Give Amount - Maximum");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Give Units");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Give Dosage Form");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Provider's Administration Instructions");
                                  this.add(CM_LA1.class, false, 1, 12, new Object[]{ getMessage() }, "Deliver-to location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(167) }, "Substitution Status");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Dispense Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Dispense Units");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Number of Refills");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Ordering Provider's DEA Number");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Pharmacist Verifier ID");
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "Prescription Number");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Number of Refills Remaining");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Number of refills / doses dispensed");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date / time of most recent refill or dose dispensed");
                                  this.add(CQ_QUANTITY.class, false, 1, 10, new Object[]{ getMessage() }, "Total Daily Dose");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "Needs Human Review");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Pharmacy Special Dispensing Instructions");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Give Per (Time Unit)");
                                  this.add(CE.class, false, 1, 6, new Object[]{ getMessage() }, "Give Rate Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Give Rate Units");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXE - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Quantity / timing (RXE-1).
     */
    public TQ[] getQuantityTiming() {
    	TQ[] retVal = this.getTypedField(1, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Quantity / timing (RXE-1).
     */
    public TQ[] getRxe1_QuantityTiming() {
    	TQ[] retVal = this.getTypedField(1, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Quantity / timing (RXE-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQuantityTimingReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * RXE-1: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getQuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXE-1: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getRxe1_QuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Quantity / timing (RXE-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxe1_QuantityTimingReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * RXE-1: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * RXE-1: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertRxe1_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * RXE-1: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * RXE-1: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeRxe1_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * RXE-2: "Give Code" - creates it if necessary
     */
    public CE getGiveCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-2: "Give Code" - creates it if necessary
     */
    public CE getRxe2_GiveCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-3: "Give Amount - Minimum" - creates it if necessary
     */
    public NM getGiveAmountMinimum() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-3: "Give Amount - Minimum" - creates it if necessary
     */
    public NM getRxe3_GiveAmountMinimum() { 
		NM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-4: "Give Amount - Maximum" - creates it if necessary
     */
    public NM getGiveAmountMaximum() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-4: "Give Amount - Maximum" - creates it if necessary
     */
    public NM getRxe4_GiveAmountMaximum() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-5: "Give Units" - creates it if necessary
     */
    public CE getGiveUnits() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-5: "Give Units" - creates it if necessary
     */
    public CE getRxe5_GiveUnits() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-6: "Give Dosage Form" - creates it if necessary
     */
    public CE getGiveDosageForm() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-6: "Give Dosage Form" - creates it if necessary
     */
    public CE getRxe6_GiveDosageForm() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Provider's Administration Instructions (RXE-7).
     */
    public CE[] getProviderSAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(7, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider's Administration Instructions (RXE-7).
     */
    public CE[] getRxe7_ProviderSAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(7, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider's Administration Instructions (RXE-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderSAdministrationInstructionsReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * RXE-7: "Provider's Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getProviderSAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXE-7: "Provider's Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxe7_ProviderSAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider's Administration Instructions (RXE-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxe7_ProviderSAdministrationInstructionsReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * RXE-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * RXE-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxe7_ProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXE-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * RXE-7: "Provider's Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxe7_ProviderSAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * RXE-8: "Deliver-to location" - creates it if necessary
     */
    public CM_LA1 getDeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-8: "Deliver-to location" - creates it if necessary
     */
    public CM_LA1 getRxe8_DeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-9: "Substitution Status" - creates it if necessary
     */
    public ID getSubstitutionStatus() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-9: "Substitution Status" - creates it if necessary
     */
    public ID getRxe9_SubstitutionStatus() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-10: "Dispense Amount" - creates it if necessary
     */
    public NM getDispenseAmount() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-10: "Dispense Amount" - creates it if necessary
     */
    public NM getRxe10_DispenseAmount() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-11: "Dispense Units" - creates it if necessary
     */
    public CE getDispenseUnits() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-11: "Dispense Units" - creates it if necessary
     */
    public CE getRxe11_DispenseUnits() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-12: "Number of Refills" - creates it if necessary
     */
    public NM getNumberOfRefills() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-12: "Number of Refills" - creates it if necessary
     */
    public NM getRxe12_NumberOfRefills() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-13: "Ordering Provider's DEA Number" - creates it if necessary
     */
    public CN getOrderingProviderSDEANumber() { 
		CN retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-13: "Ordering Provider's DEA Number" - creates it if necessary
     */
    public CN getRxe13_OrderingProviderSDEANumber() { 
		CN retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-14: "Pharmacist Verifier ID" - creates it if necessary
     */
    public CN getPharmacistVerifierID() { 
		CN retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-14: "Pharmacist Verifier ID" - creates it if necessary
     */
    public CN getRxe14_PharmacistVerifierID() { 
		CN retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-15: "Prescription Number" - creates it if necessary
     */
    public ST getPrescriptionNumber() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-15: "Prescription Number" - creates it if necessary
     */
    public ST getRxe15_PrescriptionNumber() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-16: "Number of Refills Remaining" - creates it if necessary
     */
    public NM getNumberOfRefillsRemaining() { 
		NM retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-16: "Number of Refills Remaining" - creates it if necessary
     */
    public NM getRxe16_NumberOfRefillsRemaining() { 
		NM retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-17: "Number of refills / doses dispensed" - creates it if necessary
     */
    public NM getNumberOfRefillsDosesDispensed() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-17: "Number of refills / doses dispensed" - creates it if necessary
     */
    public NM getRxe17_NumberOfRefillsDosesDispensed() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-18: "Date / time of most recent refill or dose dispensed" - creates it if necessary
     */
    public TS getDateTimeOfMostRecentRefillOrDoseDispensed() { 
		TS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-18: "Date / time of most recent refill or dose dispensed" - creates it if necessary
     */
    public TS getRxe18_DateTimeOfMostRecentRefillOrDoseDispensed() { 
		TS retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-19: "Total Daily Dose" - creates it if necessary
     */
    public CQ_QUANTITY getTotalDailyDose() { 
		CQ_QUANTITY retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-19: "Total Daily Dose" - creates it if necessary
     */
    public CQ_QUANTITY getRxe19_TotalDailyDose() { 
		CQ_QUANTITY retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-20: "Needs Human Review" - creates it if necessary
     */
    public ID getNeedsHumanReview() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-20: "Needs Human Review" - creates it if necessary
     */
    public ID getRxe20_NeedsHumanReview() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-21: "Pharmacy Special Dispensing Instructions" - creates it if necessary
     */
    public CE getPharmacySpecialDispensingInstructions() { 
		CE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-21: "Pharmacy Special Dispensing Instructions" - creates it if necessary
     */
    public CE getRxe21_PharmacySpecialDispensingInstructions() { 
		CE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-22: "Give Per (Time Unit)" - creates it if necessary
     */
    public ST getGivePerTimeUnit() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-22: "Give Per (Time Unit)" - creates it if necessary
     */
    public ST getRxe22_GivePerTimeUnit() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-23: "Give Rate Amount" - creates it if necessary
     */
    public CE getGiveRateAmount() { 
		CE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-23: "Give Rate Amount" - creates it if necessary
     */
    public CE getRxe23_GiveRateAmount() { 
		CE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * RXE-24: "Give Rate Units" - creates it if necessary
     */
    public CE getGiveRateUnits() { 
		CE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXE-24: "Give Rate Units" - creates it if necessary
     */
    public CE getRxe24_GiveRateUnits() { 
		CE retVal = this.getTypedField(24, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new TQ(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new NM(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new CM_LA1(getMessage());
          case 8: return new ID(getMessage(), new Integer( 167 ));
          case 9: return new NM(getMessage());
          case 10: return new CE(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CN(getMessage());
          case 13: return new CN(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new NM(getMessage());
          case 16: return new NM(getMessage());
          case 17: return new TS(getMessage());
          case 18: return new CQ_QUANTITY(getMessage());
          case 19: return new ID(getMessage(), new Integer( 0 ));
          case 20: return new CE(getMessage());
          case 21: return new ST(getMessage());
          case 22: return new CE(getMessage());
          case 23: return new CE(getMessage());
          default: return null;
       }
   }


}

