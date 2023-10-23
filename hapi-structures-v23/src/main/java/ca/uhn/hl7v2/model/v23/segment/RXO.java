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
 *<p>Represents an HL7 RXO message segment (Pharmacy prescription order segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXO-1: Requested Give Code (CE) <b> </b>
     * <li>RXO-2: Requested Give Amount - Minimum (NM) <b> </b>
     * <li>RXO-3: Requested Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXO-4: Requested Give Units (CE) <b> </b>
     * <li>RXO-5: Requested Dosage Form (CE) <b>optional </b>
     * <li>RXO-6: Provider's Pharmacy Instructions (CE) <b>optional repeating</b>
     * <li>RXO-7: Provider's Administration Instructions (CE) <b>optional repeating</b>
     * <li>RXO-8: Deliver To Location (CM_LA1) <b>optional </b>
     * <li>RXO-9: Allow Substitutions (ID) <b>optional </b>
     * <li>RXO-10: Requested Dispense Code (CE) <b>optional </b>
     * <li>RXO-11: Requested Dispense Amount (NM) <b>optional </b>
     * <li>RXO-12: Requested Dispense Units (CE) <b>optional </b>
     * <li>RXO-13: Number of Refills (NM) <b>optional </b>
     * <li>RXO-14: Ordering Provider's DEA Number (CN) <b>optional </b>
     * <li>RXO-15: Pharmacist/Treatment Supplier's Verifier ID (CN) <b>optional </b>
     * <li>RXO-16: Needs Human Review (ID) <b>optional </b>
     * <li>RXO-17: Requested Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXO-18: Requested Give Strength (NM) <b>optional </b>
     * <li>RXO-19: Requested Give Strength Units (CE) <b>optional </b>
     * <li>RXO-20: Indication (CE) <b>optional </b>
     * <li>RXO-21: Requested Give Rate Amount (ST) <b>optional </b>
     * <li>RXO-22: Requested Give Rate Units (CE) <b>optional </b>
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
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Requested Give Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Requested Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Amount - Maximum");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Requested Give Units");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Requested Dosage Form");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Provider's Pharmacy Instructions");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Provider's Administration Instructions");
                                  this.add(CM_LA1.class, false, 1, 200, new Object[]{ getMessage() }, "Deliver To Location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(161) }, "Allow Substitutions");
                                  this.add(CE.class, false, 1, 100, new Object[]{ getMessage() }, "Requested Dispense Code");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Dispense Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Requested Dispense Units");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Number of Refills");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Ordering Provider's DEA Number");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Pharmacist/Treatment Supplier's Verifier ID");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Needs Human Review");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Per (Time Unit)");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Requested Give Strength");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Requested Give Strength Units");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Indication");
                                  this.add(ST.class, false, 1, 6, new Object[]{ getMessage() }, "Requested Give Rate Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Requested Give Rate Units");
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
     * Returns all repetitions of Provider's Pharmacy Instructions (RXO-6).
     */
    public CE[] getProviderSPharmacyInstructions() {
    	CE[] retVal = this.getTypedField(6, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Provider's Pharmacy Instructions (RXO-6).
     */
    public CE[] getRxo6_ProviderSPharmacyInstructions() {
    	CE[] retVal = this.getTypedField(6, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Provider's Pharmacy Instructions (RXO-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProviderSPharmacyInstructionsReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * RXO-6: "Provider's Pharmacy Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getProviderSPharmacyInstructions(int rep) { 
		CE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXO-6: "Provider's Pharmacy Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxo6_ProviderSPharmacyInstructions(int rep) { 
		CE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Provider's Pharmacy Instructions (RXO-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxo6_ProviderSPharmacyInstructionsReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * RXO-6: "Provider's Pharmacy Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertProviderSPharmacyInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * RXO-6: "Provider's Pharmacy Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxo6_ProviderSPharmacyInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RXO-6: "Provider's Pharmacy Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeProviderSPharmacyInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * RXO-6: "Provider's Pharmacy Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxo6_ProviderSPharmacyInstructions(int rep) throws HL7Exception { 
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
     * RXO-8: "Deliver To Location" - creates it if necessary
     */
    public CM_LA1 getDeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-8: "Deliver To Location" - creates it if necessary
     */
    public CM_LA1 getRxo8_DeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(8, 0);
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
     * RXO-13: "Number of Refills" - creates it if necessary
     */
    public NM getNumberOfRefills() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-13: "Number of Refills" - creates it if necessary
     */
    public NM getRxo13_NumberOfRefills() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-14: "Ordering Provider's DEA Number" - creates it if necessary
     */
    public CN getOrderingProviderSDEANumber() { 
		CN retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-14: "Ordering Provider's DEA Number" - creates it if necessary
     */
    public CN getRxo14_OrderingProviderSDEANumber() { 
		CN retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" - creates it if necessary
     */
    public CN getPharmacistTreatmentSupplierSVerifierID() { 
		CN retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-15: "Pharmacist/Treatment Supplier's Verifier ID" - creates it if necessary
     */
    public CN getRxo15_PharmacistTreatmentSupplierSVerifierID() { 
		CN retVal = this.getTypedField(15, 0);
		return retVal;
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
     * Returns
     * RXO-20: "Indication" - creates it if necessary
     */
    public CE getIndication() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXO-20: "Indication" - creates it if necessary
     */
    public CE getRxo20_Indication() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
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
          case 7: return new CM_LA1(getMessage());
          case 8: return new ID(getMessage(), new Integer( 161 ));
          case 9: return new CE(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new CE(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new CN(getMessage());
          case 14: return new CN(getMessage());
          case 15: return new ID(getMessage(), new Integer( 136 ));
          case 16: return new ST(getMessage());
          case 17: return new NM(getMessage());
          case 18: return new CE(getMessage());
          case 19: return new CE(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new CE(getMessage());
          default: return null;
       }
   }


}

