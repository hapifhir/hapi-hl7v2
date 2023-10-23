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
 *<p>Represents an HL7 PRA message segment (Practitioner Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRA-1: Primary Key Value - PRA (CE) <b>optional </b>
     * <li>PRA-2: Practitioner Group (CE) <b>optional repeating</b>
     * <li>PRA-3: Practitioner Category (IS) <b>optional repeating</b>
     * <li>PRA-4: Provider Billing (ID) <b>optional </b>
     * <li>PRA-5: Specialty (SPD) <b>optional repeating</b>
     * <li>PRA-6: Practitioner ID Numbers (PLN) <b>optional repeating</b>
     * <li>PRA-7: Privileges (PIP) <b>optional repeating</b>
     * <li>PRA-8: Date Entered Practice (DT) <b>optional </b>
     * <li>PRA-9: Institution (CE) <b>optional </b>
     * <li>PRA-10: Date Left Practice (DT) <b>optional </b>
     * <li>PRA-11: Government Reimbursement Billing Eligibility (CE) <b>optional repeating</b>
     * <li>PRA-12: Set ID - PRA (SI) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PRA extends AbstractSegment {

    /** 
     * Creates a new PRA segment
     */
    public PRA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Primary Key Value - PRA");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Practitioner Group");
                                              this.add(IS.class, false, 0, 3, new Object[]{ getMessage(), new Integer(186) }, "Practitioner Category");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(187) }, "Provider Billing");
                                  this.add(SPD.class, false, 0, 112, new Object[]{ getMessage() }, "Specialty");
                                  this.add(PLN.class, false, 0, 99, new Object[]{ getMessage() }, "Practitioner ID Numbers");
                                  this.add(PIP.class, false, 0, 770, new Object[]{ getMessage() }, "Privileges");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Date Entered Practice");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Institution");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Date Left Practice");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Government Reimbursement Billing Eligibility");
                                  this.add(SI.class, false, 1, 60, new Object[]{ getMessage() }, "Set ID - PRA");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PRA-1: "Primary Key Value - PRA" - creates it if necessary
     */
    public CE getPrimaryKeyValuePRA() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-1: "Primary Key Value - PRA" - creates it if necessary
     */
    public CE getPra1_PrimaryKeyValuePRA() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Practitioner Group (PRA-2).
     */
    public CE[] getPractitionerGroup() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Practitioner Group (PRA-2).
     */
    public CE[] getPra2_PractitionerGroup() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Practitioner Group (PRA-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPractitionerGroupReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PRA-2: "Practitioner Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPractitionerGroup(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-2: "Practitioner Group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPra2_PractitionerGroup(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Practitioner Group (PRA-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra2_PractitionerGroupReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PRA-2: "Practitioner Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-2: "Practitioner Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPra2_PractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRA-2: "Practitioner Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRA-2: "Practitioner Group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePra2_PractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Practitioner Category (PRA-3).
     */
    public IS[] getPractitionerCategory() {
    	IS[] retVal = this.getTypedField(3, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Practitioner Category (PRA-3).
     */
    public IS[] getPra3_PractitionerCategory() {
    	IS[] retVal = this.getTypedField(3, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Practitioner Category (PRA-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPractitionerCategoryReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PRA-3: "Practitioner Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getPractitionerCategory(int rep) { 
		IS retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-3: "Practitioner Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getPra3_PractitionerCategory(int rep) { 
		IS retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Practitioner Category (PRA-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra3_PractitionerCategoryReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertPractitionerCategory(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertPra3_PractitionerCategory(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removePractitionerCategory(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removePra3_PractitionerCategory(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * PRA-4: "Provider Billing" - creates it if necessary
     */
    public ID getProviderBilling() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-4: "Provider Billing" - creates it if necessary
     */
    public ID getPra4_ProviderBilling() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Specialty (PRA-5).
     */
    public SPD[] getSpecialty() {
    	SPD[] retVal = this.getTypedField(5, new SPD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specialty (PRA-5).
     */
    public SPD[] getPra5_Specialty() {
    	SPD[] retVal = this.getTypedField(5, new SPD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Specialty (PRA-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSpecialtyReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PRA-5: "Specialty" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SPD getSpecialty(int rep) { 
		SPD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-5: "Specialty" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public SPD getPra5_Specialty(int rep) { 
		SPD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Specialty (PRA-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra5_SpecialtyReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SPD insertSpecialty(int rep) throws HL7Exception { 
        return (SPD) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SPD insertPra5_Specialty(int rep) throws HL7Exception { 
        return (SPD) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SPD removeSpecialty(int rep) throws HL7Exception { 
        return (SPD) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public SPD removePra5_Specialty(int rep) throws HL7Exception { 
        return (SPD) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Practitioner ID Numbers (PRA-6).
     */
    public PLN[] getPractitionerIDNumbers() {
    	PLN[] retVal = this.getTypedField(6, new PLN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Practitioner ID Numbers (PRA-6).
     */
    public PLN[] getPra6_PractitionerIDNumbers() {
    	PLN[] retVal = this.getTypedField(6, new PLN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Practitioner ID Numbers (PRA-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPractitionerIDNumbersReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * PRA-6: "Practitioner ID Numbers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PLN getPractitionerIDNumbers(int rep) { 
		PLN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-6: "Practitioner ID Numbers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PLN getPra6_PractitionerIDNumbers(int rep) { 
		PLN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Practitioner ID Numbers (PRA-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra6_PractitionerIDNumbersReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN insertPractitionerIDNumbers(int rep) throws HL7Exception { 
        return (PLN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN insertPra6_PractitionerIDNumbers(int rep) throws HL7Exception { 
        return (PLN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN removePractitionerIDNumbers(int rep) throws HL7Exception { 
        return (PLN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PLN removePra6_PractitionerIDNumbers(int rep) throws HL7Exception { 
        return (PLN) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Privileges (PRA-7).
     */
    public PIP[] getPrivileges() {
    	PIP[] retVal = this.getTypedField(7, new PIP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Privileges (PRA-7).
     */
    public PIP[] getPra7_Privileges() {
    	PIP[] retVal = this.getTypedField(7, new PIP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Privileges (PRA-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrivilegesReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PRA-7: "Privileges" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PIP getPrivileges(int rep) { 
		PIP retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-7: "Privileges" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PIP getPra7_Privileges(int rep) { 
		PIP retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Privileges (PRA-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra7_PrivilegesReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PIP insertPrivileges(int rep) throws HL7Exception { 
        return (PIP) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PIP insertPra7_Privileges(int rep) throws HL7Exception { 
        return (PIP) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PIP removePrivileges(int rep) throws HL7Exception { 
        return (PIP) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PIP removePra7_Privileges(int rep) throws HL7Exception { 
        return (PIP) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * PRA-8: "Date Entered Practice" - creates it if necessary
     */
    public DT getDateEnteredPractice() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-8: "Date Entered Practice" - creates it if necessary
     */
    public DT getPra8_DateEnteredPractice() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PRA-9: "Institution" - creates it if necessary
     */
    public CE getInstitution() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-9: "Institution" - creates it if necessary
     */
    public CE getPra9_Institution() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PRA-10: "Date Left Practice" - creates it if necessary
     */
    public DT getDateLeftPractice() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-10: "Date Left Practice" - creates it if necessary
     */
    public DT getPra10_DateLeftPractice() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Government Reimbursement Billing Eligibility (PRA-11).
     */
    public CE[] getGovernmentReimbursementBillingEligibility() {
    	CE[] retVal = this.getTypedField(11, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Government Reimbursement Billing Eligibility (PRA-11).
     */
    public CE[] getPra11_GovernmentReimbursementBillingEligibility() {
    	CE[] retVal = this.getTypedField(11, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Government Reimbursement Billing Eligibility (PRA-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGovernmentReimbursementBillingEligibilityReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PRA-11: "Government Reimbursement Billing Eligibility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getGovernmentReimbursementBillingEligibility(int rep) { 
		CE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-11: "Government Reimbursement Billing Eligibility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPra11_GovernmentReimbursementBillingEligibility(int rep) { 
		CE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Government Reimbursement Billing Eligibility (PRA-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra11_GovernmentReimbursementBillingEligibilityReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PRA-11: "Government Reimbursement Billing Eligibility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertGovernmentReimbursementBillingEligibility(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-11: "Government Reimbursement Billing Eligibility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPra11_GovernmentReimbursementBillingEligibility(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRA-11: "Government Reimbursement Billing Eligibility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeGovernmentReimbursementBillingEligibility(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRA-11: "Government Reimbursement Billing Eligibility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePra11_GovernmentReimbursementBillingEligibility(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PRA-12: "Set ID - PRA" - creates it if necessary
     */
    public SI getSetIDPRA() { 
		SI retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-12: "Set ID - PRA" - creates it if necessary
     */
    public SI getPra12_SetIDPRA() { 
		SI retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new IS(getMessage(), new Integer( 186 ));
          case 3: return new ID(getMessage(), new Integer( 187 ));
          case 4: return new SPD(getMessage());
          case 5: return new PLN(getMessage());
          case 6: return new PIP(getMessage());
          case 7: return new DT(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new DT(getMessage());
          case 10: return new CE(getMessage());
          case 11: return new SI(getMessage());
          default: return null;
       }
   }


}

