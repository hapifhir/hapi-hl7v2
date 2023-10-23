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
 * <p>Represents a VXU_V04_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: VXU_V04_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>3: RXA (Pharmacy/Treatment Administration) <b>  </b></li>
                         * <li>4: RXR (Pharmacy/Treatment Route) <b>optional  </b></li>
                         * <li>5: VXU_V04_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class VXU_V04_ORDER extends AbstractGroup {

    /** 
     * Creates a new VXU_V04_ORDER group
     */
    public VXU_V04_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(VXU_V04_TIMING.class, false, true, false);
                                  this.add(RXA.class, true, false, false);
                                  this.add(RXR.class, false, false, false);
                                  this.add(VXU_V04_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating VXU_V04_ORDER - this is probably a bug in the source code generator.", e);
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
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * TIMING (a Group object) - creates it if necessary
     */
    public VXU_V04_TIMING getTIMING() { 
       VXU_V04_TIMING retVal = getTyped("TIMING", VXU_V04_TIMING.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public VXU_V04_TIMING getTIMING(int rep) { 
       VXU_V04_TIMING retVal = getTyped("TIMING", rep, VXU_V04_TIMING.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING 
     */ 
    public int getTIMINGReps() {  
        return getReps("TIMING");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<VXU_V04_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", VXU_V04_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(VXU_V04_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public VXU_V04_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (VXU_V04_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public VXU_V04_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (VXU_V04_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * RXA (Pharmacy/Treatment Administration) - creates it if necessary
     */
    public RXA getRXA() { 
       RXA retVal = getTyped("RXA", RXA.class);
       return retVal;
    }




    /**
     * Returns
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
     */
    public RXR getRXR() { 
       RXR retVal = getTyped("RXR", RXR.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public VXU_V04_OBSERVATION getOBSERVATION() { 
       VXU_V04_OBSERVATION retVal = getTyped("OBSERVATION", VXU_V04_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public VXU_V04_OBSERVATION getOBSERVATION(int rep) { 
       VXU_V04_OBSERVATION retVal = getTyped("OBSERVATION", rep, VXU_V04_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION 
     */ 
    public int getOBSERVATIONReps() {  
        return getReps("OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<VXU_V04_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", VXU_V04_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(VXU_V04_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public VXU_V04_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (VXU_V04_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public VXU_V04_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (VXU_V04_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
    }



}

