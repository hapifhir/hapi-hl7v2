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


package ca.uhn.hl7v2.model.v251.group;

import ca.uhn.hl7v2.model.v251.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a DFT_P11_FINANCIAL_COMMON_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>optional  </b></li>
                         * <li>2: DFT_P11_FINANCIAL_TIMING_QUANTITY (a Group object) <b>optional repeating </b></li>
                         * <li>3: DFT_P11_FINANCIAL_ORDER (a Group object) <b>optional  </b></li>
                         * <li>4: DFT_P11_FINANCIAL_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class DFT_P11_FINANCIAL_COMMON_ORDER extends AbstractGroup {

    /** 
     * Creates a new DFT_P11_FINANCIAL_COMMON_ORDER group
     */
    public DFT_P11_FINANCIAL_COMMON_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, false, false, false);
                                  this.add(DFT_P11_FINANCIAL_TIMING_QUANTITY.class, false, true, false);
                                  this.add(DFT_P11_FINANCIAL_ORDER.class, false, false, false);
                                  this.add(DFT_P11_FINANCIAL_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DFT_P11_FINANCIAL_COMMON_ORDER - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5.1"
     */
    public String getVersion() {
       return "2.5.1";
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
     * FINANCIAL_TIMING_QUANTITY (a Group object) - creates it if necessary
     */
    public DFT_P11_FINANCIAL_TIMING_QUANTITY getFINANCIAL_TIMING_QUANTITY() { 
       DFT_P11_FINANCIAL_TIMING_QUANTITY retVal = getTyped("FINANCIAL_TIMING_QUANTITY", DFT_P11_FINANCIAL_TIMING_QUANTITY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FINANCIAL_TIMING_QUANTITY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P11_FINANCIAL_TIMING_QUANTITY getFINANCIAL_TIMING_QUANTITY(int rep) { 
       DFT_P11_FINANCIAL_TIMING_QUANTITY retVal = getTyped("FINANCIAL_TIMING_QUANTITY", rep, DFT_P11_FINANCIAL_TIMING_QUANTITY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FINANCIAL_TIMING_QUANTITY 
     */ 
    public int getFINANCIAL_TIMING_QUANTITYReps() {  
        return getReps("FINANCIAL_TIMING_QUANTITY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FINANCIAL_TIMING_QUANTITY.
     * <p>
     * <p>
     * Note that unlike {@link #getFINANCIAL_TIMING_QUANTITY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DFT_P11_FINANCIAL_TIMING_QUANTITY> getFINANCIAL_TIMING_QUANTITYAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_TIMING_QUANTITY", DFT_P11_FINANCIAL_TIMING_QUANTITY.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_TIMING_QUANTITY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_TIMING_QUANTITY(DFT_P11_FINANCIAL_TIMING_QUANTITY structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_TIMING_QUANTITY", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_TIMING_QUANTITY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P11_FINANCIAL_TIMING_QUANTITY insertFINANCIAL_TIMING_QUANTITY(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_TIMING_QUANTITY)super.insertRepetition("FINANCIAL_TIMING_QUANTITY", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_TIMING_QUANTITY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P11_FINANCIAL_TIMING_QUANTITY removeFINANCIAL_TIMING_QUANTITY(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_TIMING_QUANTITY)super.removeRepetition("FINANCIAL_TIMING_QUANTITY", rep);
    }



    /**
     * Returns
     * FINANCIAL_ORDER (a Group object) - creates it if necessary
     */
    public DFT_P11_FINANCIAL_ORDER getFINANCIAL_ORDER() { 
       DFT_P11_FINANCIAL_ORDER retVal = getTyped("FINANCIAL_ORDER", DFT_P11_FINANCIAL_ORDER.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * FINANCIAL_OBSERVATION (a Group object) - creates it if necessary
     */
    public DFT_P11_FINANCIAL_OBSERVATION getFINANCIAL_OBSERVATION() { 
       DFT_P11_FINANCIAL_OBSERVATION retVal = getTyped("FINANCIAL_OBSERVATION", DFT_P11_FINANCIAL_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FINANCIAL_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P11_FINANCIAL_OBSERVATION getFINANCIAL_OBSERVATION(int rep) { 
       DFT_P11_FINANCIAL_OBSERVATION retVal = getTyped("FINANCIAL_OBSERVATION", rep, DFT_P11_FINANCIAL_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FINANCIAL_OBSERVATION 
     */ 
    public int getFINANCIAL_OBSERVATIONReps() {  
        return getReps("FINANCIAL_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FINANCIAL_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getFINANCIAL_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DFT_P11_FINANCIAL_OBSERVATION> getFINANCIAL_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_OBSERVATION", DFT_P11_FINANCIAL_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_OBSERVATION(DFT_P11_FINANCIAL_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P11_FINANCIAL_OBSERVATION insertFINANCIAL_OBSERVATION(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_OBSERVATION)super.insertRepetition("FINANCIAL_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P11_FINANCIAL_OBSERVATION removeFINANCIAL_OBSERVATION(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_OBSERVATION)super.removeRepetition("FINANCIAL_OBSERVATION", rep);
    }



}

