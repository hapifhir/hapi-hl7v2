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


package ca.uhn.hl7v2.model.v27.group;

import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a MFN_M06_MF_PHASE_SCHED_DETAIL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: CM1 (Clinical Study Phase Master) <b>  </b></li>
                         * <li>2: CM2 (Clinical Study Schedule Master) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M06_MF_PHASE_SCHED_DETAIL extends AbstractGroup {

    /** 
     * Creates a new MFN_M06_MF_PHASE_SCHED_DETAIL group
     */
    public MFN_M06_MF_PHASE_SCHED_DETAIL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CM1.class, true, false, false);
                                  this.add(CM2.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M06_MF_PHASE_SCHED_DETAIL - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
    }



    /**
     * Returns
     * CM1 (Clinical Study Phase Master) - creates it if necessary
     */
    public CM1 getCM1() { 
       CM1 retVal = getTyped("CM1", CM1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CM2 (Clinical Study Schedule Master) - creates it if necessary
     */
    public CM2 getCM2() { 
       CM2 retVal = getTyped("CM2", CM2.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CM2 (Clinical Study Schedule Master) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CM2 getCM2(int rep) { 
       CM2 retVal = getTyped("CM2", rep, CM2.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CM2 
     */ 
    public int getCM2Reps() {  
        return getReps("CM2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CM2.
     * <p>
     * <p>
     * Note that unlike {@link #getCM2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CM2> getCM2All() throws HL7Exception {
    	return getAllAsList("CM2", CM2.class);
    } 

    /**
     * Inserts a specific repetition of CM2 (Clinical Study Schedule Master)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCM2(CM2 structure, int rep) throws HL7Exception { 
       super.insertRepetition("CM2", structure, rep);
    }


    /**
     * Inserts a specific repetition of CM2 (Clinical Study Schedule Master)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CM2 insertCM2(int rep) throws HL7Exception { 
       return (CM2)super.insertRepetition("CM2", rep);
    }


    /**
     * Removes a specific repetition of CM2 (Clinical Study Schedule Master)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CM2 removeCM2(int rep) throws HL7Exception { 
       return (CM2)super.removeRepetition("CM2", rep);
    }



}

