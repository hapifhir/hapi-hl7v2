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


package ca.uhn.hl7v2.model.v27.group;

import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a CSU_C09_STUDY_SCHEDULE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: CSS (Clinical Study Data Schedule Segment) <b>optional  </b></li>
                         * <li>2: CSU_C09_STUDY_OBSERVATION (a Group object) <b> repeating </b></li>
                         * <li>3: CSU_C09_STUDY_PHARM (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CSU_C09_STUDY_SCHEDULE extends AbstractGroup {

    /** 
     * Creates a new CSU_C09_STUDY_SCHEDULE group
     */
    public CSU_C09_STUDY_SCHEDULE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CSS.class, false, false, false);
                                  this.add(CSU_C09_STUDY_OBSERVATION.class, true, true, false);
                                  this.add(CSU_C09_STUDY_PHARM.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CSU_C09_STUDY_SCHEDULE - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
    }



    /**
     * Returns
     * CSS (Clinical Study Data Schedule Segment) - creates it if necessary
     */
    public CSS getCSS() { 
       CSS retVal = getTyped("CSS", CSS.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * STUDY_OBSERVATION (a Group object) - creates it if necessary
     */
    public CSU_C09_STUDY_OBSERVATION getSTUDY_OBSERVATION() { 
       CSU_C09_STUDY_OBSERVATION retVal = getTyped("STUDY_OBSERVATION", CSU_C09_STUDY_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * STUDY_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CSU_C09_STUDY_OBSERVATION getSTUDY_OBSERVATION(int rep) { 
       CSU_C09_STUDY_OBSERVATION retVal = getTyped("STUDY_OBSERVATION", rep, CSU_C09_STUDY_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of STUDY_OBSERVATION 
     */ 
    public int getSTUDY_OBSERVATIONReps() {  
        return getReps("STUDY_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of STUDY_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getSTUDY_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CSU_C09_STUDY_OBSERVATION> getSTUDY_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("STUDY_OBSERVATION", CSU_C09_STUDY_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of STUDY_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSTUDY_OBSERVATION(CSU_C09_STUDY_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("STUDY_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of STUDY_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CSU_C09_STUDY_OBSERVATION insertSTUDY_OBSERVATION(int rep) throws HL7Exception { 
       return (CSU_C09_STUDY_OBSERVATION)super.insertRepetition("STUDY_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of STUDY_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CSU_C09_STUDY_OBSERVATION removeSTUDY_OBSERVATION(int rep) throws HL7Exception { 
       return (CSU_C09_STUDY_OBSERVATION)super.removeRepetition("STUDY_OBSERVATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * STUDY_PHARM (a Group object) - creates it if necessary
     */
    public CSU_C09_STUDY_PHARM getSTUDY_PHARM() { 
       CSU_C09_STUDY_PHARM retVal = getTyped("STUDY_PHARM", CSU_C09_STUDY_PHARM.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * STUDY_PHARM (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CSU_C09_STUDY_PHARM getSTUDY_PHARM(int rep) { 
       CSU_C09_STUDY_PHARM retVal = getTyped("STUDY_PHARM", rep, CSU_C09_STUDY_PHARM.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of STUDY_PHARM 
     */ 
    public int getSTUDY_PHARMReps() {  
        return getReps("STUDY_PHARM");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of STUDY_PHARM.
     * <p>
     * <p>
     * Note that unlike {@link #getSTUDY_PHARM()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CSU_C09_STUDY_PHARM> getSTUDY_PHARMAll() throws HL7Exception {
    	return getAllAsList("STUDY_PHARM", CSU_C09_STUDY_PHARM.class);
    } 

    /**
     * Inserts a specific repetition of STUDY_PHARM (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSTUDY_PHARM(CSU_C09_STUDY_PHARM structure, int rep) throws HL7Exception { 
       super.insertRepetition("STUDY_PHARM", structure, rep);
    }


    /**
     * Inserts a specific repetition of STUDY_PHARM (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CSU_C09_STUDY_PHARM insertSTUDY_PHARM(int rep) throws HL7Exception { 
       return (CSU_C09_STUDY_PHARM)super.insertRepetition("STUDY_PHARM", rep);
    }


    /**
     * Removes a specific repetition of STUDY_PHARM (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CSU_C09_STUDY_PHARM removeSTUDY_PHARM(int rep) throws HL7Exception { 
       return (CSU_C09_STUDY_PHARM)super.removeRepetition("STUDY_PHARM", rep);
    }



}

