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
 *<p>Represents an HL7 URS message segment (Unsolicited Selection). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>URS-1: R/U Where Subject Definition (ST) <b> repeating</b>
     * <li>URS-2: R/U When Data Start Date/Time (TS) <b>optional </b>
     * <li>URS-3: R/U When Data End Date/Time (TS) <b>optional </b>
     * <li>URS-4: R/U What User Qualifier (ST) <b>optional repeating</b>
     * <li>URS-5: R/U Other Results Subject Definition (ST) <b>optional repeating</b>
     * <li>URS-6: R/U Which Date/Time Qualifier (ID) <b>optional repeating</b>
     * <li>URS-7: R/U Which Date/Time Status Qualifier (ID) <b>optional repeating</b>
     * <li>URS-8: R/U Date/Time Selection Qualifier (ID) <b>optional repeating</b>
     * <li>URS-9: R/U Quantity/Timing Qualifier (TQ) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class URS extends AbstractSegment {

    /** 
     * Creates a new URS segment
     */
    public URS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "R/U Where Subject Definition");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "R/U When Data Start Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "R/U When Data End Date/Time");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U What User Qualifier");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U Other Results Subject Definition");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(156) }, "R/U Which Date/Time Qualifier");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(157) }, "R/U Which Date/Time Status Qualifier");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(158) }, "R/U Date/Time Selection Qualifier");
                                  this.add(TQ.class, false, 1, 60, new Object[]{ getMessage() }, "R/U Quantity/Timing Qualifier");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating URS - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of R/U Where Subject Definition (URS-1).
     */
    public ST[] getRUWhereSubjectDefinition() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Where Subject Definition (URS-1).
     */
    public ST[] getUrs1_RUWhereSubjectDefinition() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Where Subject Definition (URS-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhereSubjectDefinitionReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * URS-1: "R/U Where Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUWhereSubjectDefinition(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-1: "R/U Where Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrs1_RUWhereSubjectDefinition(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Where Subject Definition (URS-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs1_RUWhereSubjectDefinitionReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * URS-1: "R/U Where Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUWhereSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * URS-1: "R/U Where Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrs1_RUWhereSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * URS-1: "R/U Where Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUWhereSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * URS-1: "R/U Where Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrs1_RUWhereSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * URS-2: "R/U When Data Start Date/Time" - creates it if necessary
     */
    public TS getRUWhenDataStartDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URS-2: "R/U When Data Start Date/Time" - creates it if necessary
     */
    public TS getUrs2_RUWhenDataStartDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * URS-3: "R/U When Data End Date/Time" - creates it if necessary
     */
    public TS getRUWhenDataEndDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URS-3: "R/U When Data End Date/Time" - creates it if necessary
     */
    public TS getUrs3_RUWhenDataEndDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of R/U What User Qualifier (URS-4).
     */
    public ST[] getRUWhatUserQualifier() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U What User Qualifier (URS-4).
     */
    public ST[] getUrs4_RUWhatUserQualifier() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U What User Qualifier (URS-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhatUserQualifierReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * URS-4: "R/U What User Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUWhatUserQualifier(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-4: "R/U What User Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrs4_RUWhatUserQualifier(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U What User Qualifier (URS-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs4_RUWhatUserQualifierReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * URS-4: "R/U What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUWhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * URS-4: "R/U What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrs4_RUWhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URS-4: "R/U What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUWhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URS-4: "R/U What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrs4_RUWhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of R/U Other Results Subject Definition (URS-5).
     */
    public ST[] getRUOtherResultsSubjectDefinition() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Other Results Subject Definition (URS-5).
     */
    public ST[] getUrs5_RUOtherResultsSubjectDefinition() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Other Results Subject Definition (URS-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUOtherResultsSubjectDefinitionReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * URS-5: "R/U Other Results Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUOtherResultsSubjectDefinition(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-5: "R/U Other Results Subject Definition" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrs5_RUOtherResultsSubjectDefinition(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Other Results Subject Definition (URS-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs5_RUOtherResultsSubjectDefinitionReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * URS-5: "R/U Other Results Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUOtherResultsSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * URS-5: "R/U Other Results Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrs5_RUOtherResultsSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URS-5: "R/U Other Results Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUOtherResultsSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URS-5: "R/U Other Results Subject Definition" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrs5_RUOtherResultsSubjectDefinition(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of R/U Which Date/Time Qualifier (URS-6).
     */
    public ID[] getRUWhichDateTimeQualifier() {
    	ID[] retVal = this.getTypedField(6, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Which Date/Time Qualifier (URS-6).
     */
    public ID[] getUrs6_RUWhichDateTimeQualifier() {
    	ID[] retVal = this.getTypedField(6, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Which Date/Time Qualifier (URS-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhichDateTimeQualifierReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * URS-6: "R/U Which Date/Time Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getRUWhichDateTimeQualifier(int rep) { 
		ID retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-6: "R/U Which Date/Time Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUrs6_RUWhichDateTimeQualifier(int rep) { 
		ID retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Which Date/Time Qualifier (URS-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs6_RUWhichDateTimeQualifierReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * URS-6: "R/U Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertRUWhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * URS-6: "R/U Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUrs6_RUWhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * URS-6: "R/U Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeRUWhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * URS-6: "R/U Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUrs6_RUWhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of R/U Which Date/Time Status Qualifier (URS-7).
     */
    public ID[] getRUWhichDateTimeStatusQualifier() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Which Date/Time Status Qualifier (URS-7).
     */
    public ID[] getUrs7_RUWhichDateTimeStatusQualifier() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Which Date/Time Status Qualifier (URS-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWhichDateTimeStatusQualifierReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * URS-7: "R/U Which Date/Time Status Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getRUWhichDateTimeStatusQualifier(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-7: "R/U Which Date/Time Status Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUrs7_RUWhichDateTimeStatusQualifier(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Which Date/Time Status Qualifier (URS-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs7_RUWhichDateTimeStatusQualifierReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * URS-7: "R/U Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertRUWhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * URS-7: "R/U Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUrs7_RUWhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * URS-7: "R/U Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeRUWhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * URS-7: "R/U Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUrs7_RUWhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of R/U Date/Time Selection Qualifier (URS-8).
     */
    public ID[] getRUDateTimeSelectionQualifier() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U Date/Time Selection Qualifier (URS-8).
     */
    public ID[] getUrs8_RUDateTimeSelectionQualifier() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U Date/Time Selection Qualifier (URS-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUDateTimeSelectionQualifierReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * URS-8: "R/U Date/Time Selection Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getRUDateTimeSelectionQualifier(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-8: "R/U Date/Time Selection Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUrs8_RUDateTimeSelectionQualifier(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U Date/Time Selection Qualifier (URS-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs8_RUDateTimeSelectionQualifierReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * URS-8: "R/U Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertRUDateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * URS-8: "R/U Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUrs8_RUDateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * URS-8: "R/U Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeRUDateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * URS-8: "R/U Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUrs8_RUDateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * URS-9: "R/U Quantity/Timing Qualifier" - creates it if necessary
     */
    public TQ getRUQuantityTimingQualifier() { 
		TQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URS-9: "R/U Quantity/Timing Qualifier" - creates it if necessary
     */
    public TQ getUrs9_RUQuantityTimingQualifier() { 
		TQ retVal = this.getTypedField(9, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new TS(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ID(getMessage(), new Integer( 156 ));
          case 6: return new ID(getMessage(), new Integer( 157 ));
          case 7: return new ID(getMessage(), new Integer( 158 ));
          case 8: return new TQ(getMessage());
          default: return null;
       }
   }


}

