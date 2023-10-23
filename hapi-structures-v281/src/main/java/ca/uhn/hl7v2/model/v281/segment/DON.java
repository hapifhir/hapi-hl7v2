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
 *<p>Represents an HL7 DON message segment (Donation). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DON-1: Donation Identification Number - DIN (EI) <b>optional </b>
     * <li>DON-2: Donation Type (CNE) <b>optional </b>
     * <li>DON-3: Phlebotomy Start Date/Time (DTM) <b> </b>
     * <li>DON-4: Phlebotomy End Date/Time (DTM) <b> </b>
     * <li>DON-5: Donation Duration (NM) <b> </b>
     * <li>DON-6: Donation Duration Units (CNE) <b> </b>
     * <li>DON-7: Intended Procedure Type (CNE) <b> repeating</b>
     * <li>DON-8: Actual Procedure Type (CNE) <b> repeating</b>
     * <li>DON-9: Donor Eligibility Flag (ID) <b> </b>
     * <li>DON-10: Donor Eligibility Procedure Type (CNE) <b> repeating</b>
     * <li>DON-11: Donor Eligibility Date (DTM) <b> </b>
     * <li>DON-12: Process Interruption (CNE) <b> </b>
     * <li>DON-13: Process Interruption Reason (CNE) <b> </b>
     * <li>DON-14: Phlebotomy Issue (CNE) <b> repeating</b>
     * <li>DON-15: Intended Recipient Blood Relative (ID) <b> </b>
     * <li>DON-16: Intended Recipient Name (XPN) <b> </b>
     * <li>DON-17: Intended Recipient DOB (DTM) <b> </b>
     * <li>DON-18: Intended Recipient Facility (XON) <b> </b>
     * <li>DON-19: Intended Recipient Procedure Date (DTM) <b> </b>
     * <li>DON-20: Intended Recipient Ordering Provider (XPN) <b> </b>
     * <li>DON-21: Phlebotomy Status (CNE) <b> </b>
     * <li>DON-22: Arm Stick (CNE) <b> </b>
     * <li>DON-23: Bleed Start Phlebotomist (XPN) <b> </b>
     * <li>DON-24: Bleed End Phlebotomist (XPN) <b> </b>
     * <li>DON-25: Aphaeresis Type Machine (ST) <b> </b>
     * <li>DON-26: Aphaeresis Machine Serial Number (ST) <b> </b>
     * <li>DON-27: Donor Reaction (ID) <b> </b>
     * <li>DON-28: Final Review Staff ID (XPN) <b> </b>
     * <li>DON-29: Final Review Date/Time (DTM) <b> </b>
     * <li>DON-30: Number of Tubes Collected (NM) <b> </b>
     * <li>DON-31: Donation Sample Identifier (EI) <b> repeating</b>
     * <li>DON-32: Donation Accept Staff (XCN) <b> </b>
     * <li>DON-33: Donation Material Review Staff (XCN) <b> repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DON extends AbstractSegment {

    /** 
     * Creates a new DON segment
     */
    public DON(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Donation Identification Number - DIN");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Donation Type");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Phlebotomy Start Date/Time");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Phlebotomy End Date/Time");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Donation Duration");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Donation Duration Units");
                                  this.add(CNE.class, true, 0, 0, new Object[]{ getMessage() }, "Intended Procedure Type");
                                  this.add(CNE.class, true, 0, 0, new Object[]{ getMessage() }, "Actual Procedure Type");
                                              this.add(ID.class, true, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Donor Eligibility Flag");
                                  this.add(CNE.class, true, 0, 0, new Object[]{ getMessage() }, "Donor Eligibility Procedure Type");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Donor Eligibility Date");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Process Interruption");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Process Interruption Reason");
                                  this.add(CNE.class, true, 0, 0, new Object[]{ getMessage() }, "Phlebotomy Issue");
                                              this.add(ID.class, true, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Intended Recipient Blood Relative");
                                  this.add(XPN.class, true, 1, 0, new Object[]{ getMessage() }, "Intended Recipient Name");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Intended Recipient DOB");
                                  this.add(XON.class, true, 1, 0, new Object[]{ getMessage() }, "Intended Recipient Facility");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Intended Recipient Procedure Date");
                                  this.add(XPN.class, true, 1, 0, new Object[]{ getMessage() }, "Intended Recipient Ordering Provider");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Phlebotomy Status");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Arm Stick");
                                  this.add(XPN.class, true, 1, 0, new Object[]{ getMessage() }, "Bleed Start Phlebotomist");
                                  this.add(XPN.class, true, 1, 0, new Object[]{ getMessage() }, "Bleed End Phlebotomist");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Aphaeresis Type Machine");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Aphaeresis Machine Serial Number");
                                              this.add(ID.class, true, 1, 0, new Object[]{ getMessage(), new Integer(136) }, "Donor Reaction");
                                  this.add(XPN.class, true, 1, 0, new Object[]{ getMessage() }, "Final Review Staff ID");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Final Review Date/Time");
                                  this.add(NM.class, true, 1, 0, new Object[]{ getMessage() }, "Number of Tubes Collected");
                                  this.add(EI.class, true, 0, 0, new Object[]{ getMessage() }, "Donation Sample Identifier");
                                  this.add(XCN.class, true, 1, 0, new Object[]{ getMessage() }, "Donation Accept Staff");
                                  this.add(XCN.class, true, 0, 0, new Object[]{ getMessage() }, "Donation Material Review Staff");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DON - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DON-1: "Donation Identification Number - DIN" - creates it if necessary
     */
    public EI getDonationIdentificationNumberDIN() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-1: "Donation Identification Number - DIN" - creates it if necessary
     */
    public EI getDon1_DonationIdentificationNumberDIN() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-2: "Donation Type" - creates it if necessary
     */
    public CNE getDonationType() { 
		CNE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-2: "Donation Type" - creates it if necessary
     */
    public CNE getDon2_DonationType() { 
		CNE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-3: "Phlebotomy Start Date/Time" - creates it if necessary
     */
    public DTM getPhlebotomyStartDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-3: "Phlebotomy Start Date/Time" - creates it if necessary
     */
    public DTM getDon3_PhlebotomyStartDateTime() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-4: "Phlebotomy End Date/Time" - creates it if necessary
     */
    public DTM getPhlebotomyEndDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-4: "Phlebotomy End Date/Time" - creates it if necessary
     */
    public DTM getDon4_PhlebotomyEndDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-5: "Donation Duration" - creates it if necessary
     */
    public NM getDonationDuration() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-5: "Donation Duration" - creates it if necessary
     */
    public NM getDon5_DonationDuration() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-6: "Donation Duration Units" - creates it if necessary
     */
    public CNE getDonationDurationUnits() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-6: "Donation Duration Units" - creates it if necessary
     */
    public CNE getDon6_DonationDurationUnits() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Intended Procedure Type (DON-7).
     */
    public CNE[] getIntendedProcedureType() {
    	CNE[] retVal = this.getTypedField(7, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Intended Procedure Type (DON-7).
     */
    public CNE[] getDon7_IntendedProcedureType() {
    	CNE[] retVal = this.getTypedField(7, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Intended Procedure Type (DON-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIntendedProcedureTypeReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * DON-7: "Intended Procedure Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getIntendedProcedureType(int rep) { 
		CNE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DON-7: "Intended Procedure Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getDon7_IntendedProcedureType(int rep) { 
		CNE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Intended Procedure Type (DON-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDon7_IntendedProcedureTypeReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * DON-7: "Intended Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertIntendedProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * DON-7: "Intended Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertDon7_IntendedProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * DON-7: "Intended Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeIntendedProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * DON-7: "Intended Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeDon7_IntendedProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Actual Procedure Type (DON-8).
     */
    public CNE[] getActualProcedureType() {
    	CNE[] retVal = this.getTypedField(8, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Actual Procedure Type (DON-8).
     */
    public CNE[] getDon8_ActualProcedureType() {
    	CNE[] retVal = this.getTypedField(8, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Actual Procedure Type (DON-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getActualProcedureTypeReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * DON-8: "Actual Procedure Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getActualProcedureType(int rep) { 
		CNE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DON-8: "Actual Procedure Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getDon8_ActualProcedureType(int rep) { 
		CNE retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Actual Procedure Type (DON-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDon8_ActualProcedureTypeReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * DON-8: "Actual Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertActualProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * DON-8: "Actual Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertDon8_ActualProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * DON-8: "Actual Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeActualProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * DON-8: "Actual Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeDon8_ActualProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * DON-9: "Donor Eligibility Flag" - creates it if necessary
     */
    public ID getDonorEligibilityFlag() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-9: "Donor Eligibility Flag" - creates it if necessary
     */
    public ID getDon9_DonorEligibilityFlag() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Donor Eligibility Procedure Type (DON-10).
     */
    public CNE[] getDonorEligibilityProcedureType() {
    	CNE[] retVal = this.getTypedField(10, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Donor Eligibility Procedure Type (DON-10).
     */
    public CNE[] getDon10_DonorEligibilityProcedureType() {
    	CNE[] retVal = this.getTypedField(10, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Donor Eligibility Procedure Type (DON-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDonorEligibilityProcedureTypeReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * DON-10: "Donor Eligibility Procedure Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getDonorEligibilityProcedureType(int rep) { 
		CNE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DON-10: "Donor Eligibility Procedure Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getDon10_DonorEligibilityProcedureType(int rep) { 
		CNE retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Donor Eligibility Procedure Type (DON-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDon10_DonorEligibilityProcedureTypeReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * DON-10: "Donor Eligibility Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertDonorEligibilityProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * DON-10: "Donor Eligibility Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertDon10_DonorEligibilityProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * DON-10: "Donor Eligibility Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeDonorEligibilityProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * DON-10: "Donor Eligibility Procedure Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeDon10_DonorEligibilityProcedureType(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * DON-11: "Donor Eligibility Date" - creates it if necessary
     */
    public DTM getDonorEligibilityDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-11: "Donor Eligibility Date" - creates it if necessary
     */
    public DTM getDon11_DonorEligibilityDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-12: "Process Interruption" - creates it if necessary
     */
    public CNE getProcessInterruption() { 
		CNE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-12: "Process Interruption" - creates it if necessary
     */
    public CNE getDon12_ProcessInterruption() { 
		CNE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-13: "Process Interruption Reason" - creates it if necessary
     */
    public CNE getProcessInterruptionReason() { 
		CNE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-13: "Process Interruption Reason" - creates it if necessary
     */
    public CNE getDon13_ProcessInterruptionReason() { 
		CNE retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Phlebotomy Issue (DON-14).
     */
    public CNE[] getPhlebotomyIssue() {
    	CNE[] retVal = this.getTypedField(14, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Phlebotomy Issue (DON-14).
     */
    public CNE[] getDon14_PhlebotomyIssue() {
    	CNE[] retVal = this.getTypedField(14, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Phlebotomy Issue (DON-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPhlebotomyIssueReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * DON-14: "Phlebotomy Issue" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getPhlebotomyIssue(int rep) { 
		CNE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DON-14: "Phlebotomy Issue" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getDon14_PhlebotomyIssue(int rep) { 
		CNE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Phlebotomy Issue (DON-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDon14_PhlebotomyIssueReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * DON-14: "Phlebotomy Issue" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertPhlebotomyIssue(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * DON-14: "Phlebotomy Issue" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertDon14_PhlebotomyIssue(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * DON-14: "Phlebotomy Issue" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removePhlebotomyIssue(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * DON-14: "Phlebotomy Issue" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeDon14_PhlebotomyIssue(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * DON-15: "Intended Recipient Blood Relative" - creates it if necessary
     */
    public ID getIntendedRecipientBloodRelative() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-15: "Intended Recipient Blood Relative" - creates it if necessary
     */
    public ID getDon15_IntendedRecipientBloodRelative() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-16: "Intended Recipient Name" - creates it if necessary
     */
    public XPN getIntendedRecipientName() { 
		XPN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-16: "Intended Recipient Name" - creates it if necessary
     */
    public XPN getDon16_IntendedRecipientName() { 
		XPN retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-17: "Intended Recipient DOB" - creates it if necessary
     */
    public DTM getIntendedRecipientDOB() { 
		DTM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-17: "Intended Recipient DOB" - creates it if necessary
     */
    public DTM getDon17_IntendedRecipientDOB() { 
		DTM retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-18: "Intended Recipient Facility" - creates it if necessary
     */
    public XON getIntendedRecipientFacility() { 
		XON retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-18: "Intended Recipient Facility" - creates it if necessary
     */
    public XON getDon18_IntendedRecipientFacility() { 
		XON retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-19: "Intended Recipient Procedure Date" - creates it if necessary
     */
    public DTM getIntendedRecipientProcedureDate() { 
		DTM retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-19: "Intended Recipient Procedure Date" - creates it if necessary
     */
    public DTM getDon19_IntendedRecipientProcedureDate() { 
		DTM retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-20: "Intended Recipient Ordering Provider" - creates it if necessary
     */
    public XPN getIntendedRecipientOrderingProvider() { 
		XPN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-20: "Intended Recipient Ordering Provider" - creates it if necessary
     */
    public XPN getDon20_IntendedRecipientOrderingProvider() { 
		XPN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-21: "Phlebotomy Status" - creates it if necessary
     */
    public CNE getPhlebotomyStatus() { 
		CNE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-21: "Phlebotomy Status" - creates it if necessary
     */
    public CNE getDon21_PhlebotomyStatus() { 
		CNE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-22: "Arm Stick" - creates it if necessary
     */
    public CNE getArmStick() { 
		CNE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-22: "Arm Stick" - creates it if necessary
     */
    public CNE getDon22_ArmStick() { 
		CNE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-23: "Bleed Start Phlebotomist" - creates it if necessary
     */
    public XPN getBleedStartPhlebotomist() { 
		XPN retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-23: "Bleed Start Phlebotomist" - creates it if necessary
     */
    public XPN getDon23_BleedStartPhlebotomist() { 
		XPN retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-24: "Bleed End Phlebotomist" - creates it if necessary
     */
    public XPN getBleedEndPhlebotomist() { 
		XPN retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-24: "Bleed End Phlebotomist" - creates it if necessary
     */
    public XPN getDon24_BleedEndPhlebotomist() { 
		XPN retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-25: "Aphaeresis Type Machine" - creates it if necessary
     */
    public ST getAphaeresisTypeMachine() { 
		ST retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-25: "Aphaeresis Type Machine" - creates it if necessary
     */
    public ST getDon25_AphaeresisTypeMachine() { 
		ST retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-26: "Aphaeresis Machine Serial Number" - creates it if necessary
     */
    public ST getAphaeresisMachineSerialNumber() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-26: "Aphaeresis Machine Serial Number" - creates it if necessary
     */
    public ST getDon26_AphaeresisMachineSerialNumber() { 
		ST retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-27: "Donor Reaction" - creates it if necessary
     */
    public ID getDonorReaction() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-27: "Donor Reaction" - creates it if necessary
     */
    public ID getDon27_DonorReaction() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-28: "Final Review Staff ID" - creates it if necessary
     */
    public XPN getFinalReviewStaffID() { 
		XPN retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-28: "Final Review Staff ID" - creates it if necessary
     */
    public XPN getDon28_FinalReviewStaffID() { 
		XPN retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-29: "Final Review Date/Time" - creates it if necessary
     */
    public DTM getFinalReviewDateTime() { 
		DTM retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-29: "Final Review Date/Time" - creates it if necessary
     */
    public DTM getDon29_FinalReviewDateTime() { 
		DTM retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * DON-30: "Number of Tubes Collected" - creates it if necessary
     */
    public NM getNumberOfTubesCollected() { 
		NM retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-30: "Number of Tubes Collected" - creates it if necessary
     */
    public NM getDon30_NumberOfTubesCollected() { 
		NM retVal = this.getTypedField(30, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Donation Sample Identifier (DON-31).
     */
    public EI[] getDonationSampleIdentifier() {
    	EI[] retVal = this.getTypedField(31, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Donation Sample Identifier (DON-31).
     */
    public EI[] getDon31_DonationSampleIdentifier() {
    	EI[] retVal = this.getTypedField(31, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Donation Sample Identifier (DON-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDonationSampleIdentifierReps() {
    	return this.getReps(31);
    }


    /**
     * Returns a specific repetition of
     * DON-31: "Donation Sample Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getDonationSampleIdentifier(int rep) { 
		EI retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DON-31: "Donation Sample Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getDon31_DonationSampleIdentifier(int rep) { 
		EI retVal = this.getTypedField(31, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Donation Sample Identifier (DON-31).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDon31_DonationSampleIdentifierReps() {
    	return this.getReps(31);
    }


    /**
     * Inserts a repetition of
     * DON-31: "Donation Sample Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertDonationSampleIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(31, rep);
    }


    /**
     * Inserts a repetition of
     * DON-31: "Donation Sample Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertDon31_DonationSampleIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * DON-31: "Donation Sample Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeDonationSampleIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(31, rep);
    }


    /**
     * Removes a repetition of
     * DON-31: "Donation Sample Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeDon31_DonationSampleIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(31, rep);
    }




    /**
     * Returns
     * DON-32: "Donation Accept Staff" - creates it if necessary
     */
    public XCN getDonationAcceptStaff() { 
		XCN retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DON-32: "Donation Accept Staff" - creates it if necessary
     */
    public XCN getDon32_DonationAcceptStaff() { 
		XCN retVal = this.getTypedField(32, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Donation Material Review Staff (DON-33).
     */
    public XCN[] getDonationMaterialReviewStaff() {
    	XCN[] retVal = this.getTypedField(33, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Donation Material Review Staff (DON-33).
     */
    public XCN[] getDon33_DonationMaterialReviewStaff() {
    	XCN[] retVal = this.getTypedField(33, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Donation Material Review Staff (DON-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDonationMaterialReviewStaffReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * DON-33: "Donation Material Review Staff" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getDonationMaterialReviewStaff(int rep) { 
		XCN retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * DON-33: "Donation Material Review Staff" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getDon33_DonationMaterialReviewStaff(int rep) { 
		XCN retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Donation Material Review Staff (DON-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDon33_DonationMaterialReviewStaffReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * DON-33: "Donation Material Review Staff" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertDonationMaterialReviewStaff(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * DON-33: "Donation Material Review Staff" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertDon33_DonationMaterialReviewStaff(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * DON-33: "Donation Material Review Staff" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeDonationMaterialReviewStaff(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * DON-33: "Donation Material Review Staff" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeDon33_DonationMaterialReviewStaff(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(33, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new CNE(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CNE(getMessage());
          case 6: return new CNE(getMessage());
          case 7: return new CNE(getMessage());
          case 8: return new ID(getMessage(), new Integer( 136 ));
          case 9: return new CNE(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new CNE(getMessage());
          case 12: return new CNE(getMessage());
          case 13: return new CNE(getMessage());
          case 14: return new ID(getMessage(), new Integer( 136 ));
          case 15: return new XPN(getMessage());
          case 16: return new DTM(getMessage());
          case 17: return new XON(getMessage());
          case 18: return new DTM(getMessage());
          case 19: return new XPN(getMessage());
          case 20: return new CNE(getMessage());
          case 21: return new CNE(getMessage());
          case 22: return new XPN(getMessage());
          case 23: return new XPN(getMessage());
          case 24: return new ST(getMessage());
          case 25: return new ST(getMessage());
          case 26: return new ID(getMessage(), new Integer( 136 ));
          case 27: return new XPN(getMessage());
          case 28: return new DTM(getMessage());
          case 29: return new NM(getMessage());
          case 30: return new EI(getMessage());
          case 31: return new XCN(getMessage());
          case 32: return new XCN(getMessage());
          default: return null;
       }
   }


}

