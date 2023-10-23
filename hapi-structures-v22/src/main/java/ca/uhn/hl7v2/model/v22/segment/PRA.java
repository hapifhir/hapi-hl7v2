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
 *<p>Represents an HL7 PRA message segment (practitioner detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRA-1: PRA - primary key value (ST) <b> </b>
     * <li>PRA-2: Practitioner group (CE) <b>optional repeating</b>
     * <li>PRA-3: Practitioner Category (ID) <b>optional repeating</b>
     * <li>PRA-4: Provider Billing (ID) <b>optional </b>
     * <li>PRA-5: Specialty (CM_SPD) <b>optional repeating</b>
     * <li>PRA-6: Practitioner ID Numbers (CM_PLN) <b>optional repeating</b>
     * <li>PRA-7: Privileges (CM_PIP) <b>optional repeating</b>
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
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "PRA - primary key value");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Practitioner group");
                                              this.add(ID.class, false, 0, 3, new Object[]{ getMessage(), new Integer(186) }, "Practitioner Category");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(187) }, "Provider Billing");
                                  this.add(CM_SPD.class, false, 0, 100, new Object[]{ getMessage() }, "Specialty");
                                  this.add(CM_PLN.class, false, 0, 100, new Object[]{ getMessage() }, "Practitioner ID Numbers");
                                  this.add(CM_PIP.class, false, 0, 20, new Object[]{ getMessage() }, "Privileges");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PRA-1: "PRA - primary key value" - creates it if necessary
     */
    public ST getPRAPrimaryKeyValue() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRA-1: "PRA - primary key value" - creates it if necessary
     */
    public ST getPra1_PRAPrimaryKeyValue() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Practitioner group (PRA-2).
     */
    public CE[] getPractitionerGroup() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Practitioner group (PRA-2).
     */
    public CE[] getPra2_PractitionerGroup() {
    	CE[] retVal = this.getTypedField(2, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Practitioner group (PRA-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPractitionerGroupReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PRA-2: "Practitioner group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPractitionerGroup(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-2: "Practitioner group" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPra2_PractitionerGroup(int rep) { 
		CE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Practitioner group (PRA-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPra2_PractitionerGroupReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PRA-2: "Practitioner group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-2: "Practitioner group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPra2_PractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRA-2: "Practitioner group" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePractitionerGroup(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRA-2: "Practitioner group" at a specific index
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
    public ID[] getPractitionerCategory() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Practitioner Category (PRA-3).
     */
    public ID[] getPra3_PractitionerCategory() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
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
    public ID getPractitionerCategory(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-3: "Practitioner Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPra3_PractitionerCategory(int rep) { 
		ID retVal = this.getTypedField(3, rep);
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
    public ID insertPractitionerCategory(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPra3_PractitionerCategory(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePractitionerCategory(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRA-3: "Practitioner Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePra3_PractitionerCategory(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
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
    public CM_SPD[] getSpecialty() {
    	CM_SPD[] retVal = this.getTypedField(5, new CM_SPD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Specialty (PRA-5).
     */
    public CM_SPD[] getPra5_Specialty() {
    	CM_SPD[] retVal = this.getTypedField(5, new CM_SPD[0]);
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
    public CM_SPD getSpecialty(int rep) { 
		CM_SPD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-5: "Specialty" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_SPD getPra5_Specialty(int rep) { 
		CM_SPD retVal = this.getTypedField(5, rep);
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
    public CM_SPD insertSpecialty(int rep) throws HL7Exception { 
        return (CM_SPD) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_SPD insertPra5_Specialty(int rep) throws HL7Exception { 
        return (CM_SPD) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_SPD removeSpecialty(int rep) throws HL7Exception { 
        return (CM_SPD) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRA-5: "Specialty" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_SPD removePra5_Specialty(int rep) throws HL7Exception { 
        return (CM_SPD) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Practitioner ID Numbers (PRA-6).
     */
    public CM_PLN[] getPractitionerIDNumbers() {
    	CM_PLN[] retVal = this.getTypedField(6, new CM_PLN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Practitioner ID Numbers (PRA-6).
     */
    public CM_PLN[] getPra6_PractitionerIDNumbers() {
    	CM_PLN[] retVal = this.getTypedField(6, new CM_PLN[0]);
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
    public CM_PLN getPractitionerIDNumbers(int rep) { 
		CM_PLN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-6: "Practitioner ID Numbers" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PLN getPra6_PractitionerIDNumbers(int rep) { 
		CM_PLN retVal = this.getTypedField(6, rep);
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
    public CM_PLN insertPractitionerIDNumbers(int rep) throws HL7Exception { 
        return (CM_PLN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PLN insertPra6_PractitionerIDNumbers(int rep) throws HL7Exception { 
        return (CM_PLN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PLN removePractitionerIDNumbers(int rep) throws HL7Exception { 
        return (CM_PLN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PRA-6: "Practitioner ID Numbers" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PLN removePra6_PractitionerIDNumbers(int rep) throws HL7Exception { 
        return (CM_PLN) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Privileges (PRA-7).
     */
    public CM_PIP[] getPrivileges() {
    	CM_PIP[] retVal = this.getTypedField(7, new CM_PIP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Privileges (PRA-7).
     */
    public CM_PIP[] getPra7_Privileges() {
    	CM_PIP[] retVal = this.getTypedField(7, new CM_PIP[0]);
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
    public CM_PIP getPrivileges(int rep) { 
		CM_PIP retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRA-7: "Privileges" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PIP getPra7_Privileges(int rep) { 
		CM_PIP retVal = this.getTypedField(7, rep);
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
    public CM_PIP insertPrivileges(int rep) throws HL7Exception { 
        return (CM_PIP) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PIP insertPra7_Privileges(int rep) throws HL7Exception { 
        return (CM_PIP) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PIP removePrivileges(int rep) throws HL7Exception { 
        return (CM_PIP) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PRA-7: "Privileges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PIP removePra7_Privileges(int rep) throws HL7Exception { 
        return (CM_PIP) super.removeRepetition(7, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ID(getMessage(), new Integer( 186 ));
          case 3: return new ID(getMessage(), new Integer( 187 ));
          case 4: return new CM_SPD(getMessage());
          case 5: return new CM_PLN(getMessage());
          case 6: return new CM_PIP(getMessage());
          default: return null;
       }
   }


}

