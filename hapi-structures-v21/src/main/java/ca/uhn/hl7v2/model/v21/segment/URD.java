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
 *<p>Represents an HL7 URD message segment (RESULTS/UPDATE DEFINITION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>URD-1: R/U DATE/TIME (TS) <b>optional </b>
     * <li>URD-2: REPORT PRIORITY (ID) <b>optional </b>
     * <li>URD-3: R/U WHO SUBJECT DEFINITION (ST) <b> repeating</b>
     * <li>URD-4: R/U WHAT SUBJECT DEFINITION (ID) <b>optional repeating</b>
     * <li>URD-5: R/U WHAT DEPARTMENT CODE (ST) <b>optional repeating</b>
     * <li>URD-6: R/U DISPLAY/PRINT LOCATIONS (ST) <b>optional repeating</b>
     * <li>URD-7: R/U RESULTS LEVEL (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class URD extends AbstractSegment {

    /** 
     * Creates a new URD segment
     */
    public URD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "R/U DATE/TIME");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(109) }, "REPORT PRIORITY");
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "R/U WHO SUBJECT DEFINITION");
                                              this.add(ID.class, false, 0, 3, new Object[]{ getMessage(), new Integer(48) }, "R/U WHAT SUBJECT DEFINITION");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U WHAT DEPARTMENT CODE");
                                  this.add(ST.class, false, 0, 20, new Object[]{ getMessage() }, "R/U DISPLAY/PRINT LOCATIONS");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(108) }, "R/U RESULTS LEVEL");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating URD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * URD-1: "R/U DATE/TIME" - creates it if necessary
     */
    public TS getRUDATETIME() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URD-1: "R/U DATE/TIME" - creates it if necessary
     */
    public TS getUrd1_RUDATETIME() { 
		TS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * URD-2: "REPORT PRIORITY" - creates it if necessary
     */
    public ID getREPORTPRIORITY() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URD-2: "REPORT PRIORITY" - creates it if necessary
     */
    public ID getUrd2_REPORTPRIORITY() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of R/U WHO SUBJECT DEFINITION (URD-3).
     */
    public ST[] getRUWHOSUBJECTDEFINITION() {
    	ST[] retVal = this.getTypedField(3, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U WHO SUBJECT DEFINITION (URD-3).
     */
    public ST[] getUrd3_RUWHOSUBJECTDEFINITION() {
    	ST[] retVal = this.getTypedField(3, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U WHO SUBJECT DEFINITION (URD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWHOSUBJECTDEFINITIONReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * URD-3: "R/U WHO SUBJECT DEFINITION" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUWHOSUBJECTDEFINITION(int rep) { 
		ST retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-3: "R/U WHO SUBJECT DEFINITION" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrd3_RUWHOSUBJECTDEFINITION(int rep) { 
		ST retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U WHO SUBJECT DEFINITION (URD-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd3_RUWHOSUBJECTDEFINITIONReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * URD-3: "R/U WHO SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUWHOSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * URD-3: "R/U WHO SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrd3_RUWHOSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * URD-3: "R/U WHO SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUWHOSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * URD-3: "R/U WHO SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrd3_RUWHOSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of R/U WHAT SUBJECT DEFINITION (URD-4).
     */
    public ID[] getRUWHATSUBJECTDEFINITION() {
    	ID[] retVal = this.getTypedField(4, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U WHAT SUBJECT DEFINITION (URD-4).
     */
    public ID[] getUrd4_RUWHATSUBJECTDEFINITION() {
    	ID[] retVal = this.getTypedField(4, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U WHAT SUBJECT DEFINITION (URD-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWHATSUBJECTDEFINITIONReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * URD-4: "R/U WHAT SUBJECT DEFINITION" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getRUWHATSUBJECTDEFINITION(int rep) { 
		ID retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-4: "R/U WHAT SUBJECT DEFINITION" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUrd4_RUWHATSUBJECTDEFINITION(int rep) { 
		ID retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U WHAT SUBJECT DEFINITION (URD-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd4_RUWHATSUBJECTDEFINITIONReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * URD-4: "R/U WHAT SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertRUWHATSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * URD-4: "R/U WHAT SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUrd4_RUWHATSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URD-4: "R/U WHAT SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeRUWHATSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * URD-4: "R/U WHAT SUBJECT DEFINITION" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUrd4_RUWHATSUBJECTDEFINITION(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of R/U WHAT DEPARTMENT CODE (URD-5).
     */
    public ST[] getRUWHATDEPARTMENTCODE() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U WHAT DEPARTMENT CODE (URD-5).
     */
    public ST[] getUrd5_RUWHATDEPARTMENTCODE() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U WHAT DEPARTMENT CODE (URD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUWHATDEPARTMENTCODEReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * URD-5: "R/U WHAT DEPARTMENT CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUWHATDEPARTMENTCODE(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-5: "R/U WHAT DEPARTMENT CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrd5_RUWHATDEPARTMENTCODE(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U WHAT DEPARTMENT CODE (URD-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd5_RUWHATDEPARTMENTCODEReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * URD-5: "R/U WHAT DEPARTMENT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUWHATDEPARTMENTCODE(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * URD-5: "R/U WHAT DEPARTMENT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrd5_RUWHATDEPARTMENTCODE(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URD-5: "R/U WHAT DEPARTMENT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUWHATDEPARTMENTCODE(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * URD-5: "R/U WHAT DEPARTMENT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrd5_RUWHATDEPARTMENTCODE(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of R/U DISPLAY/PRINT LOCATIONS (URD-6).
     */
    public ST[] getRUDISPLAYPRINTLOCATIONS() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of R/U DISPLAY/PRINT LOCATIONS (URD-6).
     */
    public ST[] getUrd6_RUDISPLAYPRINTLOCATIONS() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of R/U DISPLAY/PRINT LOCATIONS (URD-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRUDISPLAYPRINTLOCATIONSReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * URD-6: "R/U DISPLAY/PRINT LOCATIONS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getRUDISPLAYPRINTLOCATIONS(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * URD-6: "R/U DISPLAY/PRINT LOCATIONS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getUrd6_RUDISPLAYPRINTLOCATIONS(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of R/U DISPLAY/PRINT LOCATIONS (URD-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUrd6_RUDISPLAYPRINTLOCATIONSReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * URD-6: "R/U DISPLAY/PRINT LOCATIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertRUDISPLAYPRINTLOCATIONS(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * URD-6: "R/U DISPLAY/PRINT LOCATIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertUrd6_RUDISPLAYPRINTLOCATIONS(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * URD-6: "R/U DISPLAY/PRINT LOCATIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeRUDISPLAYPRINTLOCATIONS(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * URD-6: "R/U DISPLAY/PRINT LOCATIONS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeUrd6_RUDISPLAYPRINTLOCATIONS(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * URD-7: "R/U RESULTS LEVEL" - creates it if necessary
     */
    public ID getRURESULTSLEVEL() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * URD-7: "R/U RESULTS LEVEL" - creates it if necessary
     */
    public ID getUrd7_RURESULTSLEVEL() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new TS(getMessage());
          case 1: return new ID(getMessage(), new Integer( 109 ));
          case 2: return new ST(getMessage());
          case 3: return new ID(getMessage(), new Integer( 48 ));
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new ID(getMessage(), new Integer( 108 ));
          default: return null;
       }
   }


}

