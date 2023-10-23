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


package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a OPL_O37_SPECIMEN group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SPM (Specimen) <b>  </b></li>
                         * <li>2: OBX (Observation/Result) <b>optional repeating </b></li>
                         * <li>3: OPL_O37_CONTAINER (a Group object) <b>optional repeating </b></li>
                         * <li>4: OPL_O37_OBSERVATION_REQUEST (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OPL_O37_SPECIMEN extends AbstractGroup {

    /** 
     * Creates a new OPL_O37_SPECIMEN group
     */
    public OPL_O37_SPECIMEN(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SPM.class, true, false, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(OPL_O37_CONTAINER.class, false, true, false);
                                  this.add(OPL_O37_OBSERVATION_REQUEST.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OPL_O37_SPECIMEN - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.6"
     */
    public String getVersion() {
       return "2.6";
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
     * CONTAINER (a Group object) - creates it if necessary
     */
    public OPL_O37_CONTAINER getCONTAINER() { 
       OPL_O37_CONTAINER retVal = getTyped("CONTAINER", OPL_O37_CONTAINER.class);
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
    public OPL_O37_CONTAINER getCONTAINER(int rep) { 
       OPL_O37_CONTAINER retVal = getTyped("CONTAINER", rep, OPL_O37_CONTAINER.class);
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
    public java.util.List<OPL_O37_CONTAINER> getCONTAINERAll() throws HL7Exception {
    	return getAllAsList("CONTAINER", OPL_O37_CONTAINER.class);
    } 

    /**
     * Inserts a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCONTAINER(OPL_O37_CONTAINER structure, int rep) throws HL7Exception { 
       super.insertRepetition("CONTAINER", structure, rep);
    }


    /**
     * Inserts a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_CONTAINER insertCONTAINER(int rep) throws HL7Exception { 
       return (OPL_O37_CONTAINER)super.insertRepetition("CONTAINER", rep);
    }


    /**
     * Removes a specific repetition of CONTAINER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_CONTAINER removeCONTAINER(int rep) throws HL7Exception { 
       return (OPL_O37_CONTAINER)super.removeRepetition("CONTAINER", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBSERVATION_REQUEST (a Group object) - creates it if necessary
     */
    public OPL_O37_OBSERVATION_REQUEST getOBSERVATION_REQUEST() { 
       OPL_O37_OBSERVATION_REQUEST retVal = getTyped("OBSERVATION_REQUEST", OPL_O37_OBSERVATION_REQUEST.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION_REQUEST (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPL_O37_OBSERVATION_REQUEST getOBSERVATION_REQUEST(int rep) { 
       OPL_O37_OBSERVATION_REQUEST retVal = getTyped("OBSERVATION_REQUEST", rep, OPL_O37_OBSERVATION_REQUEST.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION_REQUEST 
     */ 
    public int getOBSERVATION_REQUESTReps() {  
        return getReps("OBSERVATION_REQUEST");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION_REQUEST.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION_REQUEST()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OPL_O37_OBSERVATION_REQUEST> getOBSERVATION_REQUESTAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION_REQUEST", OPL_O37_OBSERVATION_REQUEST.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION_REQUEST (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION_REQUEST(OPL_O37_OBSERVATION_REQUEST structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION_REQUEST", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION_REQUEST (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_OBSERVATION_REQUEST insertOBSERVATION_REQUEST(int rep) throws HL7Exception { 
       return (OPL_O37_OBSERVATION_REQUEST)super.insertRepetition("OBSERVATION_REQUEST", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION_REQUEST (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_OBSERVATION_REQUEST removeOBSERVATION_REQUEST(int rep) throws HL7Exception { 
       return (OPL_O37_OBSERVATION_REQUEST)super.removeRepetition("OBSERVATION_REQUEST", rep);
    }



}

