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
 * <p>Represents a OPL_O37_ORDER_PRIOR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: OBR (Observation Request) <b>  </b></li>
                         * <li>2: ORC (Common Order) <b>optional  </b></li>
                         * <li>3: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>4: OPL_O37_TIMING (a Group object) <b>optional  </b></li>
                         * <li>5: OPL_O37_OBSERVATION_RESULT_GROUP (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OPL_O37_ORDER_PRIOR extends AbstractGroup {

    /** 
     * Creates a new OPL_O37_ORDER_PRIOR group
     */
    public OPL_O37_ORDER_PRIOR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(OBR.class, true, false, false);
                                  this.add(ORC.class, false, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(OPL_O37_TIMING.class, false, false, false);
                                  this.add(OPL_O37_OBSERVATION_RESULT_GROUP.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OPL_O37_ORDER_PRIOR - this is probably a bug in the source code generator.", e);
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
     * OBR (Observation Request) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
       return retVal;
    }




    /**
     * Returns
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PRT (Participation Information) - creates it if necessary
     */
    public PRT getPRT() { 
       PRT retVal = getTyped("PRT", PRT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRT (Participation Information) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRT getPRT(int rep) { 
       PRT retVal = getTyped("PRT", rep, PRT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRT 
     */ 
    public int getPRTReps() {  
        return getReps("PRT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRT.
     * <p>
     * <p>
     * Note that unlike {@link #getPRT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRT> getPRTAll() throws HL7Exception {
    	return getAllAsList("PRT", PRT.class);
    } 

    /**
     * Inserts a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT", rep);
    }


    /**
     * Removes a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT", rep);
    }



    /**
     * Returns
     * TIMING (a Group object) - creates it if necessary
     */
    public OPL_O37_TIMING getTIMING() { 
       OPL_O37_TIMING retVal = getTyped("TIMING", OPL_O37_TIMING.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBSERVATION_RESULT_GROUP (a Group object) - creates it if necessary
     */
    public OPL_O37_OBSERVATION_RESULT_GROUP getOBSERVATION_RESULT_GROUP() { 
       OPL_O37_OBSERVATION_RESULT_GROUP retVal = getTyped("OBSERVATION_RESULT_GROUP", OPL_O37_OBSERVATION_RESULT_GROUP.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION_RESULT_GROUP (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPL_O37_OBSERVATION_RESULT_GROUP getOBSERVATION_RESULT_GROUP(int rep) { 
       OPL_O37_OBSERVATION_RESULT_GROUP retVal = getTyped("OBSERVATION_RESULT_GROUP", rep, OPL_O37_OBSERVATION_RESULT_GROUP.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION_RESULT_GROUP 
     */ 
    public int getOBSERVATION_RESULT_GROUPReps() {  
        return getReps("OBSERVATION_RESULT_GROUP");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION_RESULT_GROUP.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION_RESULT_GROUP()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OPL_O37_OBSERVATION_RESULT_GROUP> getOBSERVATION_RESULT_GROUPAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION_RESULT_GROUP", OPL_O37_OBSERVATION_RESULT_GROUP.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION_RESULT_GROUP (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION_RESULT_GROUP(OPL_O37_OBSERVATION_RESULT_GROUP structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION_RESULT_GROUP", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION_RESULT_GROUP (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_OBSERVATION_RESULT_GROUP insertOBSERVATION_RESULT_GROUP(int rep) throws HL7Exception { 
       return (OPL_O37_OBSERVATION_RESULT_GROUP)super.insertRepetition("OBSERVATION_RESULT_GROUP", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION_RESULT_GROUP (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_OBSERVATION_RESULT_GROUP removeOBSERVATION_RESULT_GROUP(int rep) throws HL7Exception { 
       return (OPL_O37_OBSERVATION_RESULT_GROUP)super.removeRepetition("OBSERVATION_RESULT_GROUP", rep);
    }



}

