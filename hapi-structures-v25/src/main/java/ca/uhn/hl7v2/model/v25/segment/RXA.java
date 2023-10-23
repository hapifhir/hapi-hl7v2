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
 *<p>Represents an HL7 RXA message segment (Pharmacy/Treatment Administration). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RXA-1: Give Sub-ID Counter (NM) <b> </b>
     * <li>RXA-2: Administration Sub-ID Counter (NM) <b> </b>
     * <li>RXA-3: Date/Time Start of Administration (TS) <b> </b>
     * <li>RXA-4: Date/Time End of Administration (TS) <b> </b>
     * <li>RXA-5: Administered Code (CE) <b> </b>
     * <li>RXA-6: Administered Amount (NM) <b> </b>
     * <li>RXA-7: Administered Units (CE) <b>optional </b>
     * <li>RXA-8: Administered Dosage Form (CE) <b>optional </b>
     * <li>RXA-9: Administration Notes (CE) <b>optional repeating</b>
     * <li>RXA-10: Administering Provider (XCN) <b>optional repeating</b>
     * <li>RXA-11: Administered-at Location (LA2) <b>optional </b>
     * <li>RXA-12: Administered Per (Time Unit) (ST) <b>optional </b>
     * <li>RXA-13: Administered Strength (NM) <b>optional </b>
     * <li>RXA-14: Administered Strength Units (CE) <b>optional </b>
     * <li>RXA-15: Substance Lot Number (ST) <b>optional repeating</b>
     * <li>RXA-16: Substance Expiration Date (TS) <b>optional repeating</b>
     * <li>RXA-17: Substance Manufacturer Name (CE) <b>optional repeating</b>
     * <li>RXA-18: Substance/Treatment Refusal Reason (CE) <b>optional repeating</b>
     * <li>RXA-19: Indication (CE) <b>optional repeating</b>
     * <li>RXA-20: Completion Status (ID) <b>optional </b>
     * <li>RXA-21: Action Code - RXA (ID) <b>optional </b>
     * <li>RXA-22: System Entry Date/Time (TS) <b>optional </b>
     * <li>RXA-23: Administered Drug Strength Volume (NM) <b>optional </b>
     * <li>RXA-24: Administered Drug Strength Volume Units (CWE) <b>optional </b>
     * <li>RXA-25: Administered Barcode Identifier (CWE) <b>optional </b>
     * <li>RXA-26: Pharmacy Order Type (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RXA extends AbstractSegment {

    /** 
     * Creates a new RXA segment
     */
    public RXA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Give Sub-ID Counter");
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Administration Sub-ID Counter");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date/Time Start of Administration");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date/Time End of Administration");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Administered Code");
                                  this.add(NM.class, true, 1, 20, new Object[]{ getMessage() }, "Administered Amount");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Administered Units");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Administered Dosage Form");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Administration Notes");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Administering Provider");
                                  this.add(LA2.class, false, 1, 200, new Object[]{ getMessage() }, "Administered-at Location");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Administered Per (Time Unit)");
                                  this.add(NM.class, false, 1, 20, new Object[]{ getMessage() }, "Administered Strength");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Administered Strength Units");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "Substance Lot Number");
                                  this.add(TS.class, false, 0, 26, new Object[]{ getMessage() }, "Substance Expiration Date");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Substance Manufacturer Name");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Substance/Treatment Refusal Reason");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Indication");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(322) }, "Completion Status");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(323) }, "Action Code - RXA");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "System Entry Date/Time");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Administered Drug Strength Volume");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Administered Drug Strength Volume Units");
                                  this.add(CWE.class, false, 1, 60, new Object[]{ getMessage() }, "Administered Barcode Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(480) }, "Pharmacy Order Type");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RXA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RXA-1: "Give Sub-ID Counter" - creates it if necessary
     */
    public NM getGiveSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-1: "Give Sub-ID Counter" - creates it if necessary
     */
    public NM getRxa1_GiveSubIDCounter() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-2: "Administration Sub-ID Counter" - creates it if necessary
     */
    public NM getAdministrationSubIDCounter() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-2: "Administration Sub-ID Counter" - creates it if necessary
     */
    public NM getRxa2_AdministrationSubIDCounter() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-3: "Date/Time Start of Administration" - creates it if necessary
     */
    public TS getDateTimeStartOfAdministration() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-3: "Date/Time Start of Administration" - creates it if necessary
     */
    public TS getRxa3_DateTimeStartOfAdministration() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-4: "Date/Time End of Administration" - creates it if necessary
     */
    public TS getDateTimeEndOfAdministration() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-4: "Date/Time End of Administration" - creates it if necessary
     */
    public TS getRxa4_DateTimeEndOfAdministration() { 
		TS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-5: "Administered Code" - creates it if necessary
     */
    public CE getAdministeredCode() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-5: "Administered Code" - creates it if necessary
     */
    public CE getRxa5_AdministeredCode() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-6: "Administered Amount" - creates it if necessary
     */
    public NM getAdministeredAmount() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-6: "Administered Amount" - creates it if necessary
     */
    public NM getRxa6_AdministeredAmount() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-7: "Administered Units" - creates it if necessary
     */
    public CE getAdministeredUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-7: "Administered Units" - creates it if necessary
     */
    public CE getRxa7_AdministeredUnits() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-8: "Administered Dosage Form" - creates it if necessary
     */
    public CE getAdministeredDosageForm() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-8: "Administered Dosage Form" - creates it if necessary
     */
    public CE getRxa8_AdministeredDosageForm() { 
		CE retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Administration Notes (RXA-9).
     */
    public CE[] getAdministrationNotes() {
    	CE[] retVal = this.getTypedField(9, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Administration Notes (RXA-9).
     */
    public CE[] getRxa9_AdministrationNotes() {
    	CE[] retVal = this.getTypedField(9, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Administration Notes (RXA-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdministrationNotesReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * RXA-9: "Administration Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getAdministrationNotes(int rep) { 
		CE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-9: "Administration Notes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxa9_AdministrationNotes(int rep) { 
		CE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Administration Notes (RXA-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa9_AdministrationNotesReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * RXA-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertAdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxa9_AdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXA-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeAdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * RXA-9: "Administration Notes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxa9_AdministrationNotes(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Administering Provider (RXA-10).
     */
    public XCN[] getAdministeringProvider() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Administering Provider (RXA-10).
     */
    public XCN[] getRxa10_AdministeringProvider() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Administering Provider (RXA-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAdministeringProviderReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * RXA-10: "Administering Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getAdministeringProvider(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-10: "Administering Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getRxa10_AdministeringProvider(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Administering Provider (RXA-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa10_AdministeringProviderReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * RXA-10: "Administering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertAdministeringProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-10: "Administering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertRxa10_AdministeringProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RXA-10: "Administering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeAdministeringProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * RXA-10: "Administering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeRxa10_AdministeringProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * RXA-11: "Administered-at Location" - creates it if necessary
     */
    public LA2 getAdministeredAtLocation() { 
		LA2 retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-11: "Administered-at Location" - creates it if necessary
     */
    public LA2 getRxa11_AdministeredAtLocation() { 
		LA2 retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-12: "Administered Per (Time Unit)" - creates it if necessary
     */
    public ST getAdministeredPerTimeUnit() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-12: "Administered Per (Time Unit)" - creates it if necessary
     */
    public ST getRxa12_AdministeredPerTimeUnit() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-13: "Administered Strength" - creates it if necessary
     */
    public NM getAdministeredStrength() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-13: "Administered Strength" - creates it if necessary
     */
    public NM getRxa13_AdministeredStrength() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-14: "Administered Strength Units" - creates it if necessary
     */
    public CE getAdministeredStrengthUnits() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-14: "Administered Strength Units" - creates it if necessary
     */
    public CE getRxa14_AdministeredStrengthUnits() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Substance Lot Number (RXA-15).
     */
    public ST[] getSubstanceLotNumber() {
    	ST[] retVal = this.getTypedField(15, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Lot Number (RXA-15).
     */
    public ST[] getRxa15_SubstanceLotNumber() {
    	ST[] retVal = this.getTypedField(15, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Lot Number (RXA-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceLotNumberReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * RXA-15: "Substance Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getSubstanceLotNumber(int rep) { 
		ST retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-15: "Substance Lot Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRxa15_SubstanceLotNumber(int rep) { 
		ST retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Lot Number (RXA-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa15_SubstanceLotNumberReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * RXA-15: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertSubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-15: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRxa15_SubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RXA-15: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeSubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * RXA-15: "Substance Lot Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRxa15_SubstanceLotNumber(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(15, rep);
    }



    /**
     * Returns all repetitions of Substance Expiration Date (RXA-16).
     */
    public TS[] getSubstanceExpirationDate() {
    	TS[] retVal = this.getTypedField(16, new TS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Expiration Date (RXA-16).
     */
    public TS[] getRxa16_SubstanceExpirationDate() {
    	TS[] retVal = this.getTypedField(16, new TS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Expiration Date (RXA-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceExpirationDateReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * RXA-16: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TS getSubstanceExpirationDate(int rep) { 
		TS retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-16: "Substance Expiration Date" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TS getRxa16_SubstanceExpirationDate(int rep) { 
		TS retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Expiration Date (RXA-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa16_SubstanceExpirationDateReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * RXA-16: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS insertSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-16: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS insertRxa16_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * RXA-16: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS removeSubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * RXA-16: "Substance Expiration Date" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TS removeRxa16_SubstanceExpirationDate(int rep) throws HL7Exception { 
        return (TS) super.removeRepetition(16, rep);
    }



    /**
     * Returns all repetitions of Substance Manufacturer Name (RXA-17).
     */
    public CE[] getSubstanceManufacturerName() {
    	CE[] retVal = this.getTypedField(17, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance Manufacturer Name (RXA-17).
     */
    public CE[] getRxa17_SubstanceManufacturerName() {
    	CE[] retVal = this.getTypedField(17, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance Manufacturer Name (RXA-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceManufacturerNameReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * RXA-17: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getSubstanceManufacturerName(int rep) { 
		CE retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-17: "Substance Manufacturer Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxa17_SubstanceManufacturerName(int rep) { 
		CE retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance Manufacturer Name (RXA-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa17_SubstanceManufacturerNameReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * RXA-17: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-17: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxa17_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * RXA-17: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeSubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * RXA-17: "Substance Manufacturer Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxa17_SubstanceManufacturerName(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(17, rep);
    }



    /**
     * Returns all repetitions of Substance/Treatment Refusal Reason (RXA-18).
     */
    public CE[] getSubstanceTreatmentRefusalReason() {
    	CE[] retVal = this.getTypedField(18, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substance/Treatment Refusal Reason (RXA-18).
     */
    public CE[] getRxa18_SubstanceTreatmentRefusalReason() {
    	CE[] retVal = this.getTypedField(18, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substance/Treatment Refusal Reason (RXA-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstanceTreatmentRefusalReasonReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * RXA-18: "Substance/Treatment Refusal Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getSubstanceTreatmentRefusalReason(int rep) { 
		CE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-18: "Substance/Treatment Refusal Reason" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxa18_SubstanceTreatmentRefusalReason(int rep) { 
		CE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substance/Treatment Refusal Reason (RXA-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa18_SubstanceTreatmentRefusalReasonReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * RXA-18: "Substance/Treatment Refusal Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertSubstanceTreatmentRefusalReason(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-18: "Substance/Treatment Refusal Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxa18_SubstanceTreatmentRefusalReason(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * RXA-18: "Substance/Treatment Refusal Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeSubstanceTreatmentRefusalReason(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * RXA-18: "Substance/Treatment Refusal Reason" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxa18_SubstanceTreatmentRefusalReason(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(18, rep);
    }



    /**
     * Returns all repetitions of Indication (RXA-19).
     */
    public CE[] getIndication() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Indication (RXA-19).
     */
    public CE[] getRxa19_Indication() {
    	CE[] retVal = this.getTypedField(19, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Indication (RXA-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIndicationReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * RXA-19: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getIndication(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * RXA-19: "Indication" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getRxa19_Indication(int rep) { 
		CE retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Indication (RXA-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRxa19_IndicationReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * RXA-19: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertIndication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * RXA-19: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertRxa19_Indication(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * RXA-19: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeIndication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * RXA-19: "Indication" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeRxa19_Indication(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * RXA-20: "Completion Status" - creates it if necessary
     */
    public ID getCompletionStatus() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-20: "Completion Status" - creates it if necessary
     */
    public ID getRxa20_CompletionStatus() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-21: "Action Code - RXA" - creates it if necessary
     */
    public ID getActionCodeRXA() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-21: "Action Code - RXA" - creates it if necessary
     */
    public ID getRxa21_ActionCodeRXA() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-22: "System Entry Date/Time" - creates it if necessary
     */
    public TS getSystemEntryDateTime() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-22: "System Entry Date/Time" - creates it if necessary
     */
    public TS getRxa22_SystemEntryDateTime() { 
		TS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-23: "Administered Drug Strength Volume" - creates it if necessary
     */
    public NM getAdministeredDrugStrengthVolume() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-23: "Administered Drug Strength Volume" - creates it if necessary
     */
    public NM getRxa23_AdministeredDrugStrengthVolume() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-24: "Administered Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getAdministeredDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-24: "Administered Drug Strength Volume Units" - creates it if necessary
     */
    public CWE getRxa24_AdministeredDrugStrengthVolumeUnits() { 
		CWE retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-25: "Administered Barcode Identifier" - creates it if necessary
     */
    public CWE getAdministeredBarcodeIdentifier() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-25: "Administered Barcode Identifier" - creates it if necessary
     */
    public CWE getRxa25_AdministeredBarcodeIdentifier() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * RXA-26: "Pharmacy Order Type" - creates it if necessary
     */
    public ID getPharmacyOrderType() { 
		ID retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RXA-26: "Pharmacy Order Type" - creates it if necessary
     */
    public ID getRxa26_PharmacyOrderType() { 
		ID retVal = this.getTypedField(26, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new TS(getMessage());
          case 4: return new CE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new CE(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new XCN(getMessage());
          case 10: return new LA2(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new TS(getMessage());
          case 16: return new CE(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new CE(getMessage());
          case 19: return new ID(getMessage(), new Integer( 322 ));
          case 20: return new ID(getMessage(), new Integer( 323 ));
          case 21: return new TS(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new CWE(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new ID(getMessage(), new Integer( 480 ));
          default: return null;
       }
   }


}

