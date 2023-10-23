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


package ca.uhn.hl7v2.model.v28.group;

import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a CCI_I22_PROBLEM group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PRB (Problem Details) <b>  </b></li>
                         * <li>2: VAR (Variance) <b>optional repeating </b></li>
                         * <li>3: CCI_I22_ROLE_PROBLEM (a Group object) <b>optional repeating </b></li>
                         * <li>4: CCI_I22_PROBLEM_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCI_I22_PROBLEM extends AbstractGroup {

    /** 
     * Creates a new CCI_I22_PROBLEM group
     */
    public CCI_I22_PROBLEM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PRB.class, true, false, false);
                                  this.add(VAR.class, false, true, false);
                                  this.add(CCI_I22_ROLE_PROBLEM.class, false, true, false);
                                  this.add(CCI_I22_PROBLEM_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCI_I22_PROBLEM - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
    }



    /**
     * Returns
     * PRB (Problem Details) - creates it if necessary
     */
    public PRB getPRB() { 
       PRB retVal = getTyped("PRB", PRB.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * VAR (Variance) - creates it if necessary
     */
    public VAR getVAR() { 
       VAR retVal = getTyped("VAR", VAR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * VAR (Variance) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public VAR getVAR(int rep) { 
       VAR retVal = getTyped("VAR", rep, VAR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of VAR 
     */ 
    public int getVARReps() {  
        return getReps("VAR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of VAR.
     * <p>
     * <p>
     * Note that unlike {@link #getVAR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<VAR> getVARAll() throws HL7Exception {
    	return getAllAsList("VAR", VAR.class);
    } 

    /**
     * Inserts a specific repetition of VAR (Variance)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertVAR(VAR structure, int rep) throws HL7Exception { 
       super.insertRepetition("VAR", structure, rep);
    }


    /**
     * Inserts a specific repetition of VAR (Variance)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public VAR insertVAR(int rep) throws HL7Exception { 
       return (VAR)super.insertRepetition("VAR", rep);
    }


    /**
     * Removes a specific repetition of VAR (Variance)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public VAR removeVAR(int rep) throws HL7Exception { 
       return (VAR)super.removeRepetition("VAR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROLE_PROBLEM (a Group object) - creates it if necessary
     */
    public CCI_I22_ROLE_PROBLEM getROLE_PROBLEM() { 
       CCI_I22_ROLE_PROBLEM retVal = getTyped("ROLE_PROBLEM", CCI_I22_ROLE_PROBLEM.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROLE_PROBLEM (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCI_I22_ROLE_PROBLEM getROLE_PROBLEM(int rep) { 
       CCI_I22_ROLE_PROBLEM retVal = getTyped("ROLE_PROBLEM", rep, CCI_I22_ROLE_PROBLEM.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROLE_PROBLEM 
     */ 
    public int getROLE_PROBLEMReps() {  
        return getReps("ROLE_PROBLEM");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROLE_PROBLEM.
     * <p>
     * <p>
     * Note that unlike {@link #getROLE_PROBLEM()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCI_I22_ROLE_PROBLEM> getROLE_PROBLEMAll() throws HL7Exception {
    	return getAllAsList("ROLE_PROBLEM", CCI_I22_ROLE_PROBLEM.class);
    } 

    /**
     * Inserts a specific repetition of ROLE_PROBLEM (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROLE_PROBLEM(CCI_I22_ROLE_PROBLEM structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROLE_PROBLEM", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROLE_PROBLEM (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCI_I22_ROLE_PROBLEM insertROLE_PROBLEM(int rep) throws HL7Exception { 
       return (CCI_I22_ROLE_PROBLEM)super.insertRepetition("ROLE_PROBLEM", rep);
    }


    /**
     * Removes a specific repetition of ROLE_PROBLEM (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCI_I22_ROLE_PROBLEM removeROLE_PROBLEM(int rep) throws HL7Exception { 
       return (CCI_I22_ROLE_PROBLEM)super.removeRepetition("ROLE_PROBLEM", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PROBLEM_OBSERVATION (a Group object) - creates it if necessary
     */
    public CCI_I22_PROBLEM_OBSERVATION getPROBLEM_OBSERVATION() { 
       CCI_I22_PROBLEM_OBSERVATION retVal = getTyped("PROBLEM_OBSERVATION", CCI_I22_PROBLEM_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PROBLEM_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCI_I22_PROBLEM_OBSERVATION getPROBLEM_OBSERVATION(int rep) { 
       CCI_I22_PROBLEM_OBSERVATION retVal = getTyped("PROBLEM_OBSERVATION", rep, CCI_I22_PROBLEM_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PROBLEM_OBSERVATION 
     */ 
    public int getPROBLEM_OBSERVATIONReps() {  
        return getReps("PROBLEM_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROBLEM_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getPROBLEM_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCI_I22_PROBLEM_OBSERVATION> getPROBLEM_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("PROBLEM_OBSERVATION", CCI_I22_PROBLEM_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of PROBLEM_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROBLEM_OBSERVATION(CCI_I22_PROBLEM_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("PROBLEM_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of PROBLEM_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCI_I22_PROBLEM_OBSERVATION insertPROBLEM_OBSERVATION(int rep) throws HL7Exception { 
       return (CCI_I22_PROBLEM_OBSERVATION)super.insertRepetition("PROBLEM_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of PROBLEM_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCI_I22_PROBLEM_OBSERVATION removePROBLEM_OBSERVATION(int rep) throws HL7Exception { 
       return (CCI_I22_PROBLEM_OBSERVATION)super.removeRepetition("PROBLEM_OBSERVATION", rep);
    }



}

