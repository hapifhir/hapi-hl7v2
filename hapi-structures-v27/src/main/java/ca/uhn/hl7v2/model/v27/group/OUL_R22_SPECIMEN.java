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
 * <p>Represents a OUL_R22_SPECIMEN group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SPM (Specimen) <b>  </b></li>
                         * <li>2: OUL_R22_SPECIMEN_OBSERVATION (a Group object) <b>optional repeating </b></li>
                         * <li>3: OUL_R22_CONTAINER (a Group object) <b>optional repeating </b></li>
                         * <li>4: OUL_R22_ORDER (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OUL_R22_SPECIMEN extends AbstractGroup {

    /** 
     * Creates a new OUL_R22_SPECIMEN group
     */
    public OUL_R22_SPECIMEN(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SPM.class, true, false, false);
                                  this.add(OUL_R22_SPECIMEN_OBSERVATION.class, false, true, false);
                                  this.add(OUL_R22_CONTAINER.class, false, true, false);
                                  this.add(OUL_R22_ORDER.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OUL_R22_SPECIMEN - this is probably a bug in the source code generator.", e);
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
     * SPM (Specimen) - creates it if necessary
     */
    public SPM getSPM() { 
       SPM retVal = getTyped("SPM", SPM.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * SPECIMEN_OBSERVATION (a Group object) - creates it if necessary
     */
    public OUL_R22_SPECIMEN_OBSERVATION getSPECIMEN_OBSERVATION() { 
       OUL_R22_SPECIMEN_OBSERVATION retVal = getTyped("SPECIMEN_OBSERVATION", OUL_R22_SPECIMEN_OBSERVATION.class);
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
    public OUL_R22_SPECIMEN_OBSERVATION getSPECIMEN_OBSERVATION(int rep) { 
       OUL_R22_SPECIMEN_OBSERVATION retVal = getTyped("SPECIMEN_OBSERVATION", rep, OUL_R22_SPECIMEN_OBSERVATION.class);
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
    public java.util.List<OUL_R22_SPECIMEN_OBSERVATION> getSPECIMEN_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN_OBSERVATION", OUL_R22_SPECIMEN_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN_OBSERVATION(OUL_R22_SPECIMEN_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OUL_R22_SPECIMEN_OBSERVATION insertSPECIMEN_OBSERVATION(int rep) throws HL7Exception { 
       return (OUL_R22_SPECIMEN_OBSERVATION)super.insertRepetition("SPECIMEN_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OUL_R22_SPECIMEN_OBSERVATION removeSPECIMEN_OBSERVATION(int rep) throws HL7Exception { 
       return (OUL_R22_SPECIMEN_OBSERVATION)super.removeRepetition("SPECIMEN_OBSERVATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CONTAINER (a Group object) - creates it if necessary
     */
    public OUL_R22_CONTAINER getCONTAINER() { 
       OUL_R22_CONTAINER retVal = getTyped("CONTAINER", OUL_R22_CONTAINER.class);
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
    public OUL_R22_CONTAINER getCONTAINER(int rep) { 
       OUL_R22_CONTAINER retVal = getTyped("CONTAINER", rep, OUL_R22_CONTAINER.class);
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
    public java.util.List<OUL_R22_CONTAINER> getCONTAINERAll() throws HL7Exception {
    	return getAllAsList("CONTAINER", OUL_R22_CONTAINER.class);
    } 

    /**
     * Inserts a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCONTAINER(OUL_R22_CONTAINER structure, int rep) throws HL7Exception { 
       super.insertRepetition("CONTAINER", structure, rep);
    }


    /**
     * Inserts a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OUL_R22_CONTAINER insertCONTAINER(int rep) throws HL7Exception { 
       return (OUL_R22_CONTAINER)super.insertRepetition("CONTAINER", rep);
    }


    /**
     * Removes a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OUL_R22_CONTAINER removeCONTAINER(int rep) throws HL7Exception { 
       return (OUL_R22_CONTAINER)super.removeRepetition("CONTAINER", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORDER (a Group object) - creates it if necessary
     */
    public OUL_R22_ORDER getORDER() { 
       OUL_R22_ORDER retVal = getTyped("ORDER", OUL_R22_ORDER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORDER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OUL_R22_ORDER getORDER(int rep) { 
       OUL_R22_ORDER retVal = getTyped("ORDER", rep, OUL_R22_ORDER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORDER 
     */ 
    public int getORDERReps() {  
        return getReps("ORDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORDER.
     * <p>
     * <p>
     * Note that unlike {@link #getORDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OUL_R22_ORDER> getORDERAll() throws HL7Exception {
    	return getAllAsList("ORDER", OUL_R22_ORDER.class);
    } 

    /**
     * Inserts a specific repetition of ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORDER(OUL_R22_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OUL_R22_ORDER insertORDER(int rep) throws HL7Exception { 
       return (OUL_R22_ORDER)super.insertRepetition("ORDER", rep);
    }


    /**
     * Removes a specific repetition of ORDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OUL_R22_ORDER removeORDER(int rep) throws HL7Exception { 
       return (OUL_R22_ORDER)super.removeRepetition("ORDER", rep);
    }



}

