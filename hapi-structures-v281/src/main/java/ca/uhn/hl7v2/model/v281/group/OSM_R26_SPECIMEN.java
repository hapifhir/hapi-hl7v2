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
 * <p>Represents a OSM_R26_SPECIMEN group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SPM (Specimen) <b>  </b></li>
                         * <li>2: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>3: OSM_R26_SPECIMEN_OBSERVATION (a Group object) <b>optional repeating </b></li>
                         * <li>4: OSM_R26_CONTAINER (a Group object) <b>optional repeating </b></li>
                         * <li>5: OSM_R26_SUBJECT_PERSON_ANIMAL_IDENTIFICATION (a Group object) <b>optional  </b></li>
                         * <li>6: OSM_R26_SUBJECT_POPULATION_LOCATION_IDENTIFICATION (a Group object) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OSM_R26_SPECIMEN extends AbstractGroup {

    /** 
     * Creates a new OSM_R26_SPECIMEN group
     */
    public OSM_R26_SPECIMEN(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SPM.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(OSM_R26_SPECIMEN_OBSERVATION.class, false, true, false);
                                  this.add(OSM_R26_CONTAINER.class, false, true, false);
                                  this.add(OSM_R26_SUBJECT_PERSON_ANIMAL_IDENTIFICATION.class, false, false, false);
                                  this.add(OSM_R26_SUBJECT_POPULATION_LOCATION_IDENTIFICATION.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OSM_R26_SPECIMEN - this is probably a bug in the source code generator.", e);
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
     * SPM (Specimen) - creates it if necessary
     */
    public SPM getSPM() { 
       SPM retVal = getTyped("SPM", SPM.class);
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
     * the first repetition of 
     * SPECIMEN_OBSERVATION (a Group object) - creates it if necessary
     */
    public OSM_R26_SPECIMEN_OBSERVATION getSPECIMEN_OBSERVATION() { 
       OSM_R26_SPECIMEN_OBSERVATION retVal = getTyped("SPECIMEN_OBSERVATION", OSM_R26_SPECIMEN_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SPECIMEN_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OSM_R26_SPECIMEN_OBSERVATION getSPECIMEN_OBSERVATION(int rep) { 
       OSM_R26_SPECIMEN_OBSERVATION retVal = getTyped("SPECIMEN_OBSERVATION", rep, OSM_R26_SPECIMEN_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SPECIMEN_OBSERVATION 
     */ 
    public int getSPECIMEN_OBSERVATIONReps() {  
        return getReps("SPECIMEN_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SPECIMEN_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getSPECIMEN_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OSM_R26_SPECIMEN_OBSERVATION> getSPECIMEN_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN_OBSERVATION", OSM_R26_SPECIMEN_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN_OBSERVATION(OSM_R26_SPECIMEN_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OSM_R26_SPECIMEN_OBSERVATION insertSPECIMEN_OBSERVATION(int rep) throws HL7Exception { 
       return (OSM_R26_SPECIMEN_OBSERVATION)super.insertRepetition("SPECIMEN_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OSM_R26_SPECIMEN_OBSERVATION removeSPECIMEN_OBSERVATION(int rep) throws HL7Exception { 
       return (OSM_R26_SPECIMEN_OBSERVATION)super.removeRepetition("SPECIMEN_OBSERVATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CONTAINER (a Group object) - creates it if necessary
     */
    public OSM_R26_CONTAINER getCONTAINER() { 
       OSM_R26_CONTAINER retVal = getTyped("CONTAINER", OSM_R26_CONTAINER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CONTAINER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OSM_R26_CONTAINER getCONTAINER(int rep) { 
       OSM_R26_CONTAINER retVal = getTyped("CONTAINER", rep, OSM_R26_CONTAINER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CONTAINER 
     */ 
    public int getCONTAINERReps() {  
        return getReps("CONTAINER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CONTAINER.
     * <p>
     * <p>
     * Note that unlike {@link #getCONTAINER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OSM_R26_CONTAINER> getCONTAINERAll() throws HL7Exception {
    	return getAllAsList("CONTAINER", OSM_R26_CONTAINER.class);
    } 

    /**
     * Inserts a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCONTAINER(OSM_R26_CONTAINER structure, int rep) throws HL7Exception { 
       super.insertRepetition("CONTAINER", structure, rep);
    }


    /**
     * Inserts a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OSM_R26_CONTAINER insertCONTAINER(int rep) throws HL7Exception { 
       return (OSM_R26_CONTAINER)super.insertRepetition("CONTAINER", rep);
    }


    /**
     * Removes a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OSM_R26_CONTAINER removeCONTAINER(int rep) throws HL7Exception { 
       return (OSM_R26_CONTAINER)super.removeRepetition("CONTAINER", rep);
    }



    /**
     * Returns
     * SUBJECT_PERSON_ANIMAL_IDENTIFICATION (a Group object) - creates it if necessary
     */
    public OSM_R26_SUBJECT_PERSON_ANIMAL_IDENTIFICATION getSUBJECT_PERSON_ANIMAL_IDENTIFICATION() { 
       OSM_R26_SUBJECT_PERSON_ANIMAL_IDENTIFICATION retVal = getTyped("SUBJECT_PERSON_ANIMAL_IDENTIFICATION", OSM_R26_SUBJECT_PERSON_ANIMAL_IDENTIFICATION.class);
       return retVal;
    }




    /**
     * Returns
     * SUBJECT_POPULATION_LOCATION_IDENTIFICATION (a Group object) - creates it if necessary
     */
    public OSM_R26_SUBJECT_POPULATION_LOCATION_IDENTIFICATION getSUBJECT_POPULATION_LOCATION_IDENTIFICATION() { 
       OSM_R26_SUBJECT_POPULATION_LOCATION_IDENTIFICATION retVal = getTyped("SUBJECT_POPULATION_LOCATION_IDENTIFICATION", OSM_R26_SUBJECT_POPULATION_LOCATION_IDENTIFICATION.class);
       return retVal;
    }




}

