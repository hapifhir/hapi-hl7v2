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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 URS message segment (UNSOLICITED SELECTION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>URS-1: R/U WHERE SUBJECT DEFINITION (ST) <b> repeating</b>
     * <li>URS-2: R/U WHEN DATA START DATE/TIME (TS) <b>optional </b>
     * <li>URS-3: R/U WHEN DATA END DATE/TIME (TS) <b>optional </b>
     * <li>URS-4: R/U WHAT USER QUALIFIER (ST) <b>optional repeating</b>
     * <li>URS-5: R/U OTHER RESULTS SUBJECT DEFINI (ST) <b>optional repeating</b>
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
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "R/U WHERE SUBJECT DEFINITION");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "R/U WHEN DATA START DATE/TIME");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "R/U WHEN DATA END DATE/TIME");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U WHAT USER QUALIFIER");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U OTHER RESULTS SUBJECT DEFINI");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating URS - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of R/U WHERE SUBJECT DEFINITION (URS-1).
     */
    public ST[] getRUWHERESUBJECTDEFINITION() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U WHERE SUBJECT DEFINITION (URS-1).
     */
    public ST[] getUrs1_RUWHERESUBJECTDEFINITION() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U WHERE SUBJECT DEFINITION (URS-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWHERESUBJECTDEFINITIONReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * URS-1: "R/U WHERE SUBJECT DEFINITION" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUWHERESUBJECTDEFINITION(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-1: "R/U WHERE SUBJECT DEFINITION" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrs1_RUWHERESUBJECTDEFINITION(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U WHERE SUBJECT DEFINITION (URS-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs1_RUWHERESUBJECTDEFINITIONReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * URS-1: "R/U WHERE SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUWHERESUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * URS-1: "R/U WHERE SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrs1_RUWHERESUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * URS-1: "R/U WHERE SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUWHERESUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * URS-1: "R/U WHERE SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrs1_RUWHERESUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * URS-2: "R/U WHEN DATA START DATE/TIME" - creates it if necessary
     */
    public TS getRUWHENDATASTARTDATETIME() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URS-2: "R/U WHEN DATA START DATE/TIME" - creates it if necessary
     */
    public TS getUrs2_RUWHENDATASTARTDATETIME() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * URS-3: "R/U WHEN DATA END DATE/TIME" - creates it if necessary
     */
    public TS getRUWHENDATAENDDATETIME() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URS-3: "R/U WHEN DATA END DATE/TIME" - creates it if necessary
     */
    public TS getUrs3_RUWHENDATAENDDATETIME() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of R/U WHAT USER QUALIFIER (URS-4).
     */
    public ST[] getRUWHATUSERQUALIFIER() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U WHAT USER QUALIFIER (URS-4).
     */
    public ST[] getUrs4_RUWHATUSERQUALIFIER() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U WHAT USER QUALIFIER (URS-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWHATUSERQUALIFIERReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * URS-4: "R/U WHAT USER QUALIFIER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUWHATUSERQUALIFIER(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-4: "R/U WHAT USER QUALIFIER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrs4_RUWHATUSERQUALIFIER(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U WHAT USER QUALIFIER (URS-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs4_RUWHATUSERQUALIFIERReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * URS-4: "R/U WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUWHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * URS-4: "R/U WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrs4_RUWHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URS-4: "R/U WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUWHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URS-4: "R/U WHAT USER QUALIFIER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrs4_RUWHATUSERQUALIFIER(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of R/U OTHER RESULTS SUBJECT DEFINI (URS-5).
     */
    public ST[] getRUOTHERRESULTSSUBJECTDEFINI() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U OTHER RESULTS SUBJECT DEFINI (URS-5).
     */
    public ST[] getUrs5_RUOTHERRESULTSSUBJECTDEFINI() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U OTHER RESULTS SUBJECT DEFINI (URS-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUOTHERRESULTSSUBJECTDEFINIReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * URS-5: "R/U OTHER RESULTS SUBJECT DEFINI" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUOTHERRESULTSSUBJECTDEFINI(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URS-5: "R/U OTHER RESULTS SUBJECT DEFINI" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrs5_RUOTHERRESULTSSUBJECTDEFINI(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U OTHER RESULTS SUBJECT DEFINI (URS-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrs5_RUOTHERRESULTSSUBJECTDEFINIReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * URS-5: "R/U OTHER RESULTS SUBJECT DEFINI" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUOTHERRESULTSSUBJECTDEFINI(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * URS-5: "R/U OTHER RESULTS SUBJECT DEFINI" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrs5_RUOTHERRESULTSSUBJECTDEFINI(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URS-5: "R/U OTHER RESULTS SUBJECT DEFINI" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUOTHERRESULTSSUBJECTDEFINI(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URS-5: "R/U OTHER RESULTS SUBJECT DEFINI" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrs5_RUOTHERRESULTSSUBJECTDEFINI(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new TS(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          default: return null;
       }
   }


}

