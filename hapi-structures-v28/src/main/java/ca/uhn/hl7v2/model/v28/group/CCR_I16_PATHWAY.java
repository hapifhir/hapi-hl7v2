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
 * <p>Represents a CCR_I16_PATHWAY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PTH (Pathway) <b>  </b></li>
                         * <li>2: VAR (Variance) <b>optional repeating </b></li>
                         * <li>3: CCR_I16_ROLE_PATHWAY (a Group object) <b>optional repeating </b></li>
                         * <li>4: CCR_I16_PATHWAY_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCR_I16_PATHWAY extends AbstractGroup {

    /** 
     * Creates a new CCR_I16_PATHWAY group
     */
    public CCR_I16_PATHWAY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PTH.class, true, false, false);
                                  this.add(VAR.class, false, true, false);
                                  this.add(CCR_I16_ROLE_PATHWAY.class, false, true, false);
                                  this.add(CCR_I16_PATHWAY_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCR_I16_PATHWAY - this is probably a bug in the source code generator.", e);
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
     * PTH (Pathway) - creates it if necessary
     */
    public PTH getPTH() { 
       PTH retVal = getTyped("PTH", PTH.class);
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
     * ROLE_PATHWAY (a Group object) - creates it if necessary
     */
    public CCR_I16_ROLE_PATHWAY getROLE_PATHWAY() { 
       CCR_I16_ROLE_PATHWAY retVal = getTyped("ROLE_PATHWAY", CCR_I16_ROLE_PATHWAY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROLE_PATHWAY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCR_I16_ROLE_PATHWAY getROLE_PATHWAY(int rep) { 
       CCR_I16_ROLE_PATHWAY retVal = getTyped("ROLE_PATHWAY", rep, CCR_I16_ROLE_PATHWAY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROLE_PATHWAY 
     */ 
    public int getROLE_PATHWAYReps() {  
        return getReps("ROLE_PATHWAY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROLE_PATHWAY.
     * <p>
     * <p>
     * Note that unlike {@link #getROLE_PATHWAY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCR_I16_ROLE_PATHWAY> getROLE_PATHWAYAll() throws HL7Exception {
    	return getAllAsList("ROLE_PATHWAY", CCR_I16_ROLE_PATHWAY.class);
    } 

    /**
     * Inserts a specific repetition of ROLE_PATHWAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROLE_PATHWAY(CCR_I16_ROLE_PATHWAY structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROLE_PATHWAY", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROLE_PATHWAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCR_I16_ROLE_PATHWAY insertROLE_PATHWAY(int rep) throws HL7Exception { 
       return (CCR_I16_ROLE_PATHWAY)super.insertRepetition("ROLE_PATHWAY", rep);
    }


    /**
     * Removes a specific repetition of ROLE_PATHWAY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCR_I16_ROLE_PATHWAY removeROLE_PATHWAY(int rep) throws HL7Exception { 
       return (CCR_I16_ROLE_PATHWAY)super.removeRepetition("ROLE_PATHWAY", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PATHWAY_OBSERVATION (a Group object) - creates it if necessary
     */
    public CCR_I16_PATHWAY_OBSERVATION getPATHWAY_OBSERVATION() { 
       CCR_I16_PATHWAY_OBSERVATION retVal = getTyped("PATHWAY_OBSERVATION", CCR_I16_PATHWAY_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PATHWAY_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCR_I16_PATHWAY_OBSERVATION getPATHWAY_OBSERVATION(int rep) { 
       CCR_I16_PATHWAY_OBSERVATION retVal = getTyped("PATHWAY_OBSERVATION", rep, CCR_I16_PATHWAY_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PATHWAY_OBSERVATION 
     */ 
    public int getPATHWAY_OBSERVATIONReps() {  
        return getReps("PATHWAY_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATHWAY_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getPATHWAY_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCR_I16_PATHWAY_OBSERVATION> getPATHWAY_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("PATHWAY_OBSERVATION", CCR_I16_PATHWAY_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of PATHWAY_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATHWAY_OBSERVATION(CCR_I16_PATHWAY_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("PATHWAY_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of PATHWAY_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCR_I16_PATHWAY_OBSERVATION insertPATHWAY_OBSERVATION(int rep) throws HL7Exception { 
       return (CCR_I16_PATHWAY_OBSERVATION)super.insertRepetition("PATHWAY_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of PATHWAY_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCR_I16_PATHWAY_OBSERVATION removePATHWAY_OBSERVATION(int rep) throws HL7Exception { 
       return (CCR_I16_PATHWAY_OBSERVATION)super.removeRepetition("PATHWAY_OBSERVATION", rep);
    }



}

