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
 * <p>Represents a CCM_I21_MEDICATION_ADMINISTRATION_DETAIL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RXA (Pharmacy/Treatment Administration) <b> repeating </b></li>
                         * <li>2: RXR (Pharmacy/Treatment Route) <b>  </b></li>
                         * <li>3: CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCM_I21_MEDICATION_ADMINISTRATION_DETAIL extends AbstractGroup {

    /** 
     * Creates a new CCM_I21_MEDICATION_ADMINISTRATION_DETAIL group
     */
    public CCM_I21_MEDICATION_ADMINISTRATION_DETAIL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RXA.class, true, true, false);
                                  this.add(RXR.class, true, false, false);
                                  this.add(CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCM_I21_MEDICATION_ADMINISTRATION_DETAIL - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * RXA (Pharmacy/Treatment Administration) - creates it if necessary
     */
    public RXA getRXA() { 
       RXA retVal = getTyped("RXA", RXA.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXA (Pharmacy/Treatment Administration) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXA getRXA(int rep) { 
       RXA retVal = getTyped("RXA", rep, RXA.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXA 
     */ 
    public int getRXAReps() {  
        return getReps("RXA");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXA.
     * <p>
     * <p>
     * Note that unlike {@link #getRXA()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RXA> getRXAAll() throws HL7Exception {
    	return getAllAsList("RXA", RXA.class);
    } 

    /**
     * Inserts a specific repetition of RXA (Pharmacy/Treatment Administration)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXA(RXA structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXA", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXA (Pharmacy/Treatment Administration)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXA insertRXA(int rep) throws HL7Exception { 
       return (RXA)super.insertRepetition("RXA", rep);
    }


    /**
     * Removes a specific repetition of RXA (Pharmacy/Treatment Administration)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXA removeRXA(int rep) throws HL7Exception { 
       return (RXA)super.removeRepetition("RXA", rep);
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
     * MEDICATION_ADMINISTRATION_OBSERVATION (a Group object) - creates it if necessary
     */
    public CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION getMEDICATION_ADMINISTRATION_OBSERVATION() { 
       CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION retVal = getTyped("MEDICATION_ADMINISTRATION_OBSERVATION", CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * MEDICATION_ADMINISTRATION_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION getMEDICATION_ADMINISTRATION_OBSERVATION(int rep) { 
       CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION retVal = getTyped("MEDICATION_ADMINISTRATION_OBSERVATION", rep, CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of MEDICATION_ADMINISTRATION_OBSERVATION 
     */ 
    public int getMEDICATION_ADMINISTRATION_OBSERVATIONReps() {  
        return getReps("MEDICATION_ADMINISTRATION_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MEDICATION_ADMINISTRATION_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getMEDICATION_ADMINISTRATION_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION> getMEDICATION_ADMINISTRATION_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("MEDICATION_ADMINISTRATION_OBSERVATION", CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of MEDICATION_ADMINISTRATION_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMEDICATION_ADMINISTRATION_OBSERVATION(CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("MEDICATION_ADMINISTRATION_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of MEDICATION_ADMINISTRATION_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION insertMEDICATION_ADMINISTRATION_OBSERVATION(int rep) throws HL7Exception { 
       return (CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION)super.insertRepetition("MEDICATION_ADMINISTRATION_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of MEDICATION_ADMINISTRATION_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION removeMEDICATION_ADMINISTRATION_OBSERVATION(int rep) throws HL7Exception { 
       return (CCM_I21_MEDICATION_ADMINISTRATION_OBSERVATION)super.removeRepetition("MEDICATION_ADMINISTRATION_OBSERVATION", rep);
    }



}

