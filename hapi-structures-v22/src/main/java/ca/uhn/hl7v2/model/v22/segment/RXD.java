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
 *<p>Represents an HL7 RXD message segment (PHARMACY DISPENSE). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXD-1: Dispense Sub-ID Counter (NM) <b>optional </b>
     * <li>RXD-2: Dispense / give code (CE) <b> </b>
     * <li>RXD-3: Date / time dispensed (TS) <b>optional </b>
     * <li>RXD-4: Actual Dispense Amount (NM) <b> </b>
     * <li>RXD-5: Actual Dispense Units (CE) <b>optional </b>
     * <li>RXD-6: Actual Dosage Form (CE) <b>optional </b>
     * <li>RXD-7: Prescription Number (ST) <b> </b>
     * <li>RXD-8: Number of Refills Remaining (NM) <b>optional </b>
     * <li>RXD-9: Dispense Notes (ST) <b>optional repeating</b>
     * <li>RXD-10: Dispensing Provider (CN) <b>optional </b>
     * <li>RXD-11: Substitution Status (ID) <b>optional </b>
     * <li>RXD-12: Total Daily Dose (CQ_QUANTITY) <b>optional </b>
     * <li>RXD-13: Deliver-to location (CM_LA1) <b>optional </b>
     * <li>RXD-14: Needs Human Review (ID) <b>optional </b>
     * <li>RXD-15: Pharmacy Special Dispensing Instructions (CE) <b>optional </b>
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
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Dispense Sub-ID Counter");
                                  this.add(CE.class, true, 1, 100, new Object[]{ getMessage() }, "Dispense / give code");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date / time dispensed");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Actual Dispense Amount");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Actual Dispense Units");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Actual Dosage Form");
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "Prescription Number");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Number of Refills Remaining");
                                  this.add(ST.class, false, 0, 200, new Object[]{ getMessage() }, "Dispense Notes");
                                  this.add(CN.class, false, 1, 200, new Object[]{ getMessage() }, "Dispensing Provider");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(167) }, "Substitution Status");
                                  this.add(CQ_QUANTITY.class, false, 1, 10, new Object[]{ getMessage() }, "Total Daily Dose");
                                  this.add(CM_LA1.class, false, 1, 12, new Object[]{ getMessage() }, "Deliver-to location");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "Needs Human Review");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Pharmacy Special Dispensing Instructions");
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
     * RXD-2: "Dispense / give code" - creates it if necessary
     */
    public CE getDispenseGiveCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-2: "Dispense / give code" - creates it if necessary
     */
    public CE getRxd2_DispenseGiveCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-3: "Date / time dispensed" - creates it if necessary
     */
    public TS getDateTimeDispensed() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-3: "Date / time dispensed" - creates it if necessary
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
     * Returns
     * RXD-10: "Dispensing Provider" - creates it if necessary
     */
    public CN getDispensingProvider() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-10: "Dispensing Provider" - creates it if necessary
     */
    public CN getRxd10_DispensingProvider() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
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
    public CQ_QUANTITY getTotalDailyDose() { 
		CQ_QUANTITY retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-12: "Total Daily Dose" - creates it if necessary
     */
    public CQ_QUANTITY getRxd12_TotalDailyDose() { 
		CQ_QUANTITY retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RXD-13: "Deliver-to location" - creates it if necessary
     */
    public CM_LA1 getDeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-13: "Deliver-to location" - creates it if necessary
     */
    public CM_LA1 getRxd13_DeliverToLocation() { 
		CM_LA1 retVal = this.getTypedField(13, 0);
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
     * Returns
     * RXD-15: "Pharmacy Special Dispensing Instructions" - creates it if necessary
     */
    public CE getPharmacySpecialDispensingInstructions() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXD-15: "Pharmacy Special Dispensing Instructions" - creates it if necessary
     */
    public CE getRxd15_PharmacySpecialDispensingInstructions() { 
		CE retVal = this.getTypedField(15, 0);
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
          case 9: return new CN(getMessage());
          case 10: return new ID(getMessage(), new Integer( 167 ));
          case 11: return new CQ_QUANTITY(getMessage());
          case 12: return new CM_LA1(getMessage());
          case 13: return new ID(getMessage(), new Integer( 0 ));
          case 14: return new CE(getMessage());
          default: return null;
       }
   }


}

