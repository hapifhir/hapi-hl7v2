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
 *<p>Represents an HL7 RXG message segment (PHARMACY GIVE). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXG-1: Give Sub-ID Counter (NM) <b> </b>
     * <li>RXG-2: Dispense Sub-ID Counter (NM) <b>optional </b>
     * <li>RXG-3: Quantity / timing (TQ) <b>optional repeating</b>
     * <li>RXG-4: Give Code (CE) <b> </b>
     * <li>RXG-5: Give Amount - Minimum (NM) <b> </b>
     * <li>RXG-6: Give Amount - Maximum (NM) <b>optional </b>
     * <li>RXG-7: Give Units (CE) <b> </b>
     * <li>RXG-8: Give Dosage Form (CE) <b>optional </b>
     * <li>RXG-9: Administration Notes (ST) <b>optional </b>
     * <li>RXG-10: Substitution Status (ID) <b>optional </b>
     * <li>RXG-11: Deliver-to location (CM_LA1) <b>optional </b>
     * <li>RXG-12: Needs Human Review (ID) <b>optional </b>
     * <li>RXG-13: Pharmacy Special Administration Instructions (CE) <b>optional repeating</b>
     * <li>RXG-14: Give Per (Time Unit) (ST) <b>optional </b>
     * <li>RXG-15: Give Rate Amount (CE) <b>optional </b>
     * <li>RXG-16: Give Rate Units (CE) <b>optional </b>
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
                                  this.add(TQ.class, false, 0, 200, new Object[]{ getMessage() }, "Quantity / timing");
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Give Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Give Amount - Minimum");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Give Amount - Maximum");
                                  this.add(CE.class, true, 1, 60, new Object[]{ getMessage() }, "Give Units");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Give Dosage Form");
                                  this.add(ST.class, false, 1, 200, new Object[]{ getMessage() }, "Administration Notes");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(167) }, "Substitution Status");
                                  this.add(CM_LA1.class, false, 1, 12, new Object[]{ getMessage() }, "Deliver-to location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "Needs Human Review");
                                  this.add(CE.class, false, 0, 200, new Object[]{ getMessage() }, "Pharmacy Special Administration Instructions");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Give Per (Time Unit)");
                                  this.add(CE.class, false, 1, 6, new Object[]{ getMessage() }, "Give Rate Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Give Rate Units");
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
     * Returns all repetitions of Quantity / timing (RXG-3).
     */
    public TQ[] getQuantityTiming() {
    	TQ[] retVal = this.getTypedField(3, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Quantity / timing (RXG-3).
     */
    public TQ[] getRxg3_QuantityTiming() {
    	TQ[] retVal = this.getTypedField(3, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Quantity / timing (RXG-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQuantityTimingReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * RXG-3: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getQuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-3: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getRxg3_QuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Quantity / timing (RXG-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg3_QuantityTimingReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * RXG-3: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-3: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertRxg3_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * RXG-3: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * RXG-3: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeRxg3_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(3, rep);
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
     * Returns
     * RXG-9: "Administration Notes" - creates it if necessary
     */
    public ST getAdministrationNotes() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-9: "Administration Notes" - creates it if necessary
     */
    public ST getRxg9_AdministrationNotes() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
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
     * RXG-11: "Deliver-to location" - creates it if necessary
     */
    public CM_LA1 getDeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-11: "Deliver-to location" - creates it if necessary
     */
    public CM_LA1 getRxg11_DeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(11, 0);
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
     * Returns all repetitions of Pharmacy Special Administration Instructions (RXG-13).
     */
    public CE[] getPharmacySpecialAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(13, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Pharmacy Special Administration Instructions (RXG-13).
     */
    public CE[] getRxg13_PharmacySpecialAdministrationInstructions() {
    	CE[] retVal = this.getTypedField(13, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Pharmacy Special Administration Instructions (RXG-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPharmacySpecialAdministrationInstructionsReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * RXG-13: "Pharmacy Special Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPharmacySpecialAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXG-13: "Pharmacy Special Administration Instructions" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxg13_PharmacySpecialAdministrationInstructions(int rep) { 
		CE retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Pharmacy Special Administration Instructions (RXG-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxg13_PharmacySpecialAdministrationInstructionsReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * RXG-13: "Pharmacy Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPharmacySpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * RXG-13: "Pharmacy Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxg13_PharmacySpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * RXG-13: "Pharmacy Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePharmacySpecialAdministrationInstructions(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * RXG-13: "Pharmacy Special Administration Instructions" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxg13_PharmacySpecialAdministrationInstructions(int rep) throws HL7Exception { 
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
    public CE getGiveRateAmount() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXG-15: "Give Rate Amount" - creates it if necessary
     */
    public CE getRxg15_GiveRateAmount() { 
		CE retVal = this.getTypedField(15, 0);
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
          case 8: return new ST(getMessage());
          case 9: return new ID(getMessage(), new Integer( 167 ));
          case 10: return new CM_LA1(getMessage());
          case 11: return new ID(getMessage(), new Integer( 0 ));
          case 12: return new CE(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new CE(getMessage());
          case 15: return new CE(getMessage());
          default: return null;
       }
   }


}

