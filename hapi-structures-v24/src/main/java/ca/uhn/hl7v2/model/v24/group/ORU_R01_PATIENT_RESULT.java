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


package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ORU_R01_PATIENT_RESULT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORU_R01_PATIENT (a Group object) <b>optional  </b></li>
                         * <li>2: ORU_R01_ORDER_OBSERVATION (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORU_R01_PATIENT_RESULT extends AbstractGroup {

    /** 
     * Creates a new ORU_R01_PATIENT_RESULT group
     */
    public ORU_R01_PATIENT_RESULT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORU_R01_PATIENT.class, false, false, false);
                                  this.add(ORU_R01_ORDER_OBSERVATION.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORU_R01_PATIENT_RESULT - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.4"
     */
    public String getVersion() {
       return "2.4";
    }



    /**
     * Returns
     * PATIENT (a Group object) - creates it if necessary
     */
    public ORU_R01_PATIENT getPATIENT() { 
       ORU_R01_PATIENT retVal = getTyped("PATIENT", ORU_R01_PATIENT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORDER_OBSERVATION (a Group object) - creates it if necessary
     */
    public ORU_R01_ORDER_OBSERVATION getORDER_OBSERVATION() { 
       ORU_R01_ORDER_OBSERVATION retVal = getTyped("ORDER_OBSERVATION", ORU_R01_ORDER_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORDER_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORU_R01_ORDER_OBSERVATION getORDER_OBSERVATION(int rep) { 
       ORU_R01_ORDER_OBSERVATION retVal = getTyped("ORDER_OBSERVATION", rep, ORU_R01_ORDER_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORDER_OBSERVATION 
     */ 
    public int getORDER_OBSERVATIONReps() {  
        return getReps("ORDER_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORDER_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getORDER_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORU_R01_ORDER_OBSERVATION> getORDER_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("ORDER_OBSERVATION", ORU_R01_ORDER_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of ORDER_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORDER_OBSERVATION(ORU_R01_ORDER_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORDER_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORDER_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R01_ORDER_OBSERVATION insertORDER_OBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R01_ORDER_OBSERVATION)super.insertRepetition("ORDER_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of ORDER_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R01_ORDER_OBSERVATION removeORDER_OBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R01_ORDER_OBSERVATION)super.removeRepetition("ORDER_OBSERVATION", rep);
    }



}

