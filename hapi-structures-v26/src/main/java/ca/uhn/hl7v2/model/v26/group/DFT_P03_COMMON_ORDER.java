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
 * <p>Represents a DFT_P03_COMMON_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>optional  </b></li>
                         * <li>2: DFT_P03_TIMING_QUANTITY (a Group object) <b>optional repeating </b></li>
                         * <li>3: DFT_P03_ORDER (a Group object) <b>optional  </b></li>
                         * <li>4: DFT_P03_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class DFT_P03_COMMON_ORDER extends AbstractGroup {

    /** 
     * Creates a new DFT_P03_COMMON_ORDER group
     */
    public DFT_P03_COMMON_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, false, false, false);
                                  this.add(DFT_P03_TIMING_QUANTITY.class, false, true, false);
                                  this.add(DFT_P03_ORDER.class, false, false, false);
                                  this.add(DFT_P03_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DFT_P03_COMMON_ORDER - this is probably a bug in the source code generator.", e);
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
     * TIMING_QUANTITY (a Group object) - creates it if necessary
     */
    public DFT_P03_TIMING_QUANTITY getTIMING_QUANTITY() { 
       DFT_P03_TIMING_QUANTITY retVal = getTyped("TIMING_QUANTITY", DFT_P03_TIMING_QUANTITY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING_QUANTITY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P03_TIMING_QUANTITY getTIMING_QUANTITY(int rep) { 
       DFT_P03_TIMING_QUANTITY retVal = getTyped("TIMING_QUANTITY", rep, DFT_P03_TIMING_QUANTITY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING_QUANTITY 
     */ 
    public int getTIMING_QUANTITYReps() {  
        return getReps("TIMING_QUANTITY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING_QUANTITY.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING_QUANTITY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DFT_P03_TIMING_QUANTITY> getTIMING_QUANTITYAll() throws HL7Exception {
    	return getAllAsList("TIMING_QUANTITY", DFT_P03_TIMING_QUANTITY.class);
    } 

    /**
     * Inserts a specific repetition of TIMING_QUANTITY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING_QUANTITY(DFT_P03_TIMING_QUANTITY structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING_QUANTITY", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING_QUANTITY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_TIMING_QUANTITY insertTIMING_QUANTITY(int rep) throws HL7Exception { 
       return (DFT_P03_TIMING_QUANTITY)super.insertRepetition("TIMING_QUANTITY", rep);
    }


    /**
     * Removes a specific repetition of TIMING_QUANTITY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_TIMING_QUANTITY removeTIMING_QUANTITY(int rep) throws HL7Exception { 
       return (DFT_P03_TIMING_QUANTITY)super.removeRepetition("TIMING_QUANTITY", rep);
    }



    /**
     * Returns
     * ORDER (a Group object) - creates it if necessary
     */
    public DFT_P03_ORDER getORDER() { 
       DFT_P03_ORDER retVal = getTyped("ORDER", DFT_P03_ORDER.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public DFT_P03_OBSERVATION getOBSERVATION() { 
       DFT_P03_OBSERVATION retVal = getTyped("OBSERVATION", DFT_P03_OBSERVATION.class);
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
    public DFT_P03_OBSERVATION getOBSERVATION(int rep) { 
       DFT_P03_OBSERVATION retVal = getTyped("OBSERVATION", rep, DFT_P03_OBSERVATION.class);
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
    public java.util.List<DFT_P03_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", DFT_P03_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(DFT_P03_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (DFT_P03_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (DFT_P03_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
    }



}

