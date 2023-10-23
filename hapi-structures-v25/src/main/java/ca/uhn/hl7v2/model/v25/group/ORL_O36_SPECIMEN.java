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


package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ORL_O36_SPECIMEN group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SPM (Specimen) <b>  </b></li>
                         * <li>2: OBX (Observation/Result) <b>optional repeating </b></li>
                         * <li>3: ORL_O36_SPECIMEN_CONTAINER (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORL_O36_SPECIMEN extends AbstractGroup {

    /** 
     * Creates a new ORL_O36_SPECIMEN group
     */
    public ORL_O36_SPECIMEN(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SPM.class, true, false, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(ORL_O36_SPECIMEN_CONTAINER.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORL_O36_SPECIMEN - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5"
     */
    public String getVersion() {
       return "2.5";
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
     * OBX (Observation/Result) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (Observation/Result) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       OBX retVal = getTyped("OBX", rep, OBX.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBX 
     */ 
    public int getOBXReps() {  
        return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * SPECIMEN_CONTAINER (a Group object) - creates it if necessary
     */
    public ORL_O36_SPECIMEN_CONTAINER getSPECIMEN_CONTAINER() { 
       ORL_O36_SPECIMEN_CONTAINER retVal = getTyped("SPECIMEN_CONTAINER", ORL_O36_SPECIMEN_CONTAINER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SPECIMEN_CONTAINER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORL_O36_SPECIMEN_CONTAINER getSPECIMEN_CONTAINER(int rep) { 
       ORL_O36_SPECIMEN_CONTAINER retVal = getTyped("SPECIMEN_CONTAINER", rep, ORL_O36_SPECIMEN_CONTAINER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SPECIMEN_CONTAINER 
     */ 
    public int getSPECIMEN_CONTAINERReps() {  
        return getReps("SPECIMEN_CONTAINER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SPECIMEN_CONTAINER.
     * <p>
     * <p>
     * Note that unlike {@link #getSPECIMEN_CONTAINER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORL_O36_SPECIMEN_CONTAINER> getSPECIMEN_CONTAINERAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN_CONTAINER", ORL_O36_SPECIMEN_CONTAINER.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN_CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN_CONTAINER(ORL_O36_SPECIMEN_CONTAINER structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN_CONTAINER", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN_CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORL_O36_SPECIMEN_CONTAINER insertSPECIMEN_CONTAINER(int rep) throws HL7Exception { 
       return (ORL_O36_SPECIMEN_CONTAINER)super.insertRepetition("SPECIMEN_CONTAINER", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN_CONTAINER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORL_O36_SPECIMEN_CONTAINER removeSPECIMEN_CONTAINER(int rep) throws HL7Exception { 
       return (ORL_O36_SPECIMEN_CONTAINER)super.removeRepetition("SPECIMEN_CONTAINER", rep);
    }



}

