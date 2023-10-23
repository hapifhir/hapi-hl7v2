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
 * <p>Represents a OMG_O19_PRIOR_RESULT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: OMG_O19_PATIENT_PRIOR (a Group object) <b>optional  </b></li>
                         * <li>2: OMG_O19_PATIENT_VISIT_PRIOR (a Group object) <b>optional  </b></li>
                         * <li>3: AL1 (Patient Allergy Information) <b>optional repeating </b></li>
                         * <li>4: OMG_O19_ORDER_PRIOR (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OMG_O19_PRIOR_RESULT extends AbstractGroup {

    /** 
     * Creates a new OMG_O19_PRIOR_RESULT group
     */
    public OMG_O19_PRIOR_RESULT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(OMG_O19_PATIENT_PRIOR.class, false, false, false);
                                  this.add(OMG_O19_PATIENT_VISIT_PRIOR.class, false, false, false);
                                  this.add(AL1.class, false, true, false);
                                  this.add(OMG_O19_ORDER_PRIOR.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OMG_O19_PRIOR_RESULT - this is probably a bug in the source code generator.", e);
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
     * PATIENT_PRIOR (a Group object) - creates it if necessary
     */
    public OMG_O19_PATIENT_PRIOR getPATIENT_PRIOR() { 
       OMG_O19_PATIENT_PRIOR retVal = getTyped("PATIENT_PRIOR", OMG_O19_PATIENT_PRIOR.class);
       return retVal;
    }




    /**
     * Returns
     * PATIENT_VISIT_PRIOR (a Group object) - creates it if necessary
     */
    public OMG_O19_PATIENT_VISIT_PRIOR getPATIENT_VISIT_PRIOR() { 
       OMG_O19_PATIENT_VISIT_PRIOR retVal = getTyped("PATIENT_VISIT_PRIOR", OMG_O19_PATIENT_VISIT_PRIOR.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * AL1 (Patient Allergy Information) - creates it if necessary
     */
    public AL1 getAL1() { 
       AL1 retVal = getTyped("AL1", AL1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AL1 (Patient Allergy Information) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AL1 getAL1(int rep) { 
       AL1 retVal = getTyped("AL1", rep, AL1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AL1 
     */ 
    public int getAL1Reps() {  
        return getReps("AL1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AL1.
     * <p>
     * <p>
     * Note that unlike {@link #getAL1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<AL1> getAL1All() throws HL7Exception {
    	return getAllAsList("AL1", AL1.class);
    } 

    /**
     * Inserts a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("AL1", structure, rep);
    }


    /**
     * Inserts a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * Removes a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORDER_PRIOR (a Group object) - creates it if necessary
     */
    public OMG_O19_ORDER_PRIOR getORDER_PRIOR() { 
       OMG_O19_ORDER_PRIOR retVal = getTyped("ORDER_PRIOR", OMG_O19_ORDER_PRIOR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORDER_PRIOR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OMG_O19_ORDER_PRIOR getORDER_PRIOR(int rep) { 
       OMG_O19_ORDER_PRIOR retVal = getTyped("ORDER_PRIOR", rep, OMG_O19_ORDER_PRIOR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORDER_PRIOR 
     */ 
    public int getORDER_PRIORReps() {  
        return getReps("ORDER_PRIOR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORDER_PRIOR.
     * <p>
     * <p>
     * Note that unlike {@link #getORDER_PRIOR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OMG_O19_ORDER_PRIOR> getORDER_PRIORAll() throws HL7Exception {
    	return getAllAsList("ORDER_PRIOR", OMG_O19_ORDER_PRIOR.class);
    } 

    /**
     * Inserts a specific repetition of ORDER_PRIOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORDER_PRIOR(OMG_O19_ORDER_PRIOR structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORDER_PRIOR", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORDER_PRIOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMG_O19_ORDER_PRIOR insertORDER_PRIOR(int rep) throws HL7Exception { 
       return (OMG_O19_ORDER_PRIOR)super.insertRepetition("ORDER_PRIOR", rep);
    }


    /**
     * Removes a specific repetition of ORDER_PRIOR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMG_O19_ORDER_PRIOR removeORDER_PRIOR(int rep) throws HL7Exception { 
       return (OMG_O19_ORDER_PRIOR)super.removeRepetition("ORDER_PRIOR", rep);
    }



}

