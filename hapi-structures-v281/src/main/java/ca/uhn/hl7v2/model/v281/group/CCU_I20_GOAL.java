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


package ca.uhn.hl7v2.model.v281.group;

import ca.uhn.hl7v2.model.v281.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a CCU_I20_GOAL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: GOL (Goal Detail) <b>  </b></li>
                         * <li>2: VAR (Variance) <b>optional repeating </b></li>
                         * <li>3: CCU_I20_ROLE_GOAL (a Group object) <b>optional repeating </b></li>
                         * <li>4: CCU_I20_GOAL_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCU_I20_GOAL extends AbstractGroup {

    /** 
     * Creates a new CCU_I20_GOAL group
     */
    public CCU_I20_GOAL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(GOL.class, true, false, false);
                                  this.add(VAR.class, false, true, false);
                                  this.add(CCU_I20_ROLE_GOAL.class, false, true, false);
                                  this.add(CCU_I20_GOAL_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCU_I20_GOAL - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8.1"
     */
    public String getVersion() {
       return "2.8.1";
    }



    /**
     * Returns
     * GOL (Goal Detail) - creates it if necessary
     */
    public GOL getGOL() { 
       GOL retVal = getTyped("GOL", GOL.class);
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
     * ROLE_GOAL (a Group object) - creates it if necessary
     */
    public CCU_I20_ROLE_GOAL getROLE_GOAL() { 
       CCU_I20_ROLE_GOAL retVal = getTyped("ROLE_GOAL", CCU_I20_ROLE_GOAL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROLE_GOAL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCU_I20_ROLE_GOAL getROLE_GOAL(int rep) { 
       CCU_I20_ROLE_GOAL retVal = getTyped("ROLE_GOAL", rep, CCU_I20_ROLE_GOAL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROLE_GOAL 
     */ 
    public int getROLE_GOALReps() {  
        return getReps("ROLE_GOAL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROLE_GOAL.
     * <p>
     * <p>
     * Note that unlike {@link #getROLE_GOAL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCU_I20_ROLE_GOAL> getROLE_GOALAll() throws HL7Exception {
    	return getAllAsList("ROLE_GOAL", CCU_I20_ROLE_GOAL.class);
    } 

    /**
     * Inserts a specific repetition of ROLE_GOAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROLE_GOAL(CCU_I20_ROLE_GOAL structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROLE_GOAL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROLE_GOAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCU_I20_ROLE_GOAL insertROLE_GOAL(int rep) throws HL7Exception { 
       return (CCU_I20_ROLE_GOAL)super.insertRepetition("ROLE_GOAL", rep);
    }


    /**
     * Removes a specific repetition of ROLE_GOAL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCU_I20_ROLE_GOAL removeROLE_GOAL(int rep) throws HL7Exception { 
       return (CCU_I20_ROLE_GOAL)super.removeRepetition("ROLE_GOAL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GOAL_OBSERVATION (a Group object) - creates it if necessary
     */
    public CCU_I20_GOAL_OBSERVATION getGOAL_OBSERVATION() { 
       CCU_I20_GOAL_OBSERVATION retVal = getTyped("GOAL_OBSERVATION", CCU_I20_GOAL_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GOAL_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCU_I20_GOAL_OBSERVATION getGOAL_OBSERVATION(int rep) { 
       CCU_I20_GOAL_OBSERVATION retVal = getTyped("GOAL_OBSERVATION", rep, CCU_I20_GOAL_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of GOAL_OBSERVATION 
     */ 
    public int getGOAL_OBSERVATIONReps() {  
        return getReps("GOAL_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GOAL_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getGOAL_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCU_I20_GOAL_OBSERVATION> getGOAL_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("GOAL_OBSERVATION", CCU_I20_GOAL_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of GOAL_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGOAL_OBSERVATION(CCU_I20_GOAL_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("GOAL_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of GOAL_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCU_I20_GOAL_OBSERVATION insertGOAL_OBSERVATION(int rep) throws HL7Exception { 
       return (CCU_I20_GOAL_OBSERVATION)super.insertRepetition("GOAL_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of GOAL_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCU_I20_GOAL_OBSERVATION removeGOAL_OBSERVATION(int rep) throws HL7Exception { 
       return (CCU_I20_GOAL_OBSERVATION)super.removeRepetition("GOAL_OBSERVATION", rep);
    }



}

