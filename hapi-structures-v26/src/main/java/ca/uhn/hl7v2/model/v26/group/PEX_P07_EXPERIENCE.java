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
 * <p>Represents a PEX_P07_EXPERIENCE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PES (Product Experience Sender) <b>  </b></li>
                         * <li>2: PEX_P07_PEX_OBSERVATION (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PEX_P07_EXPERIENCE extends AbstractGroup {

    /** 
     * Creates a new PEX_P07_EXPERIENCE group
     */
    public PEX_P07_EXPERIENCE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PES.class, true, false, false);
                                  this.add(PEX_P07_PEX_OBSERVATION.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PEX_P07_EXPERIENCE - this is probably a bug in the source code generator.", e);
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
     * PES (Product Experience Sender) - creates it if necessary
     */
    public PES getPES() { 
       PES retVal = getTyped("PES", PES.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PEX_OBSERVATION (a Group object) - creates it if necessary
     */
    public PEX_P07_PEX_OBSERVATION getPEX_OBSERVATION() { 
       PEX_P07_PEX_OBSERVATION retVal = getTyped("PEX_OBSERVATION", PEX_P07_PEX_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PEX_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PEX_P07_PEX_OBSERVATION getPEX_OBSERVATION(int rep) { 
       PEX_P07_PEX_OBSERVATION retVal = getTyped("PEX_OBSERVATION", rep, PEX_P07_PEX_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PEX_OBSERVATION 
     */ 
    public int getPEX_OBSERVATIONReps() {  
        return getReps("PEX_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PEX_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getPEX_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PEX_P07_PEX_OBSERVATION> getPEX_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("PEX_OBSERVATION", PEX_P07_PEX_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of PEX_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPEX_OBSERVATION(PEX_P07_PEX_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("PEX_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of PEX_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PEX_P07_PEX_OBSERVATION insertPEX_OBSERVATION(int rep) throws HL7Exception { 
       return (PEX_P07_PEX_OBSERVATION)super.insertRepetition("PEX_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of PEX_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PEX_P07_PEX_OBSERVATION removePEX_OBSERVATION(int rep) throws HL7Exception { 
       return (PEX_P07_PEX_OBSERVATION)super.removeRepetition("PEX_OBSERVATION", rep);
    }



}

