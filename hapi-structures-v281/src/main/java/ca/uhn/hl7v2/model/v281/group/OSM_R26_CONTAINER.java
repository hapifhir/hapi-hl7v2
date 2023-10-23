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
 * <p>Represents a OSM_R26_CONTAINER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SAC (Specimen Container detail) <b>  </b></li>
                         * <li>2: OSM_R26_CONTAINER_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OSM_R26_CONTAINER extends AbstractGroup {

    /** 
     * Creates a new OSM_R26_CONTAINER group
     */
    public OSM_R26_CONTAINER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SAC.class, true, false, false);
                                  this.add(OSM_R26_CONTAINER_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OSM_R26_CONTAINER - this is probably a bug in the source code generator.", e);
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
     * SAC (Specimen Container detail) - creates it if necessary
     */
    public SAC getSAC() { 
       SAC retVal = getTyped("SAC", SAC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CONTAINER_OBSERVATION (a Group object) - creates it if necessary
     */
    public OSM_R26_CONTAINER_OBSERVATION getCONTAINER_OBSERVATION() { 
       OSM_R26_CONTAINER_OBSERVATION retVal = getTyped("CONTAINER_OBSERVATION", OSM_R26_CONTAINER_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CONTAINER_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OSM_R26_CONTAINER_OBSERVATION getCONTAINER_OBSERVATION(int rep) { 
       OSM_R26_CONTAINER_OBSERVATION retVal = getTyped("CONTAINER_OBSERVATION", rep, OSM_R26_CONTAINER_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CONTAINER_OBSERVATION 
     */ 
    public int getCONTAINER_OBSERVATIONReps() {  
        return getReps("CONTAINER_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CONTAINER_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getCONTAINER_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OSM_R26_CONTAINER_OBSERVATION> getCONTAINER_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("CONTAINER_OBSERVATION", OSM_R26_CONTAINER_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of CONTAINER_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCONTAINER_OBSERVATION(OSM_R26_CONTAINER_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("CONTAINER_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of CONTAINER_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OSM_R26_CONTAINER_OBSERVATION insertCONTAINER_OBSERVATION(int rep) throws HL7Exception { 
       return (OSM_R26_CONTAINER_OBSERVATION)super.insertRepetition("CONTAINER_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of CONTAINER_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OSM_R26_CONTAINER_OBSERVATION removeCONTAINER_OBSERVATION(int rep) throws HL7Exception { 
       return (OSM_R26_CONTAINER_OBSERVATION)super.removeRepetition("CONTAINER_OBSERVATION", rep);
    }



}

