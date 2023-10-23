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


package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a MFN_M06_MFECM0CM1CM2 group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: MFE (MFE - master file entry segment) <b>  </b></li>
                         * <li>2: CM0 (CM0 - clinical study master segment) <b>  </b></li>
                         * <li>3: MFN_M06_CM1CM2 (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M06_MFECM0CM1CM2 extends AbstractGroup {

    /** 
     * Creates a new MFN_M06_MFECM0CM1CM2 group
     */
    public MFN_M06_MFECM0CM1CM2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(MFE.class, true, false, false);
                                  this.add(CM0.class, true, false, false);
                                  this.add(MFN_M06_CM1CM2.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M06_MFECM0CM1CM2 - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }



    /**
     * Returns
     * MFE (MFE - master file entry segment) - creates it if necessary
     */
    public MFE getMFE() { 
       MFE retVal = getTyped("MFE", MFE.class);
       return retVal;
    }




    /**
     * Returns
     * CM0 (CM0 - clinical study master segment) - creates it if necessary
     */
    public CM0 getCM0() { 
       CM0 retVal = getTyped("CM0", CM0.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CM1CM2 (a Group object) - creates it if necessary
     */
    public MFN_M06_CM1CM2 getCM1CM2() { 
       MFN_M06_CM1CM2 retVal = getTyped("CM1CM2", MFN_M06_CM1CM2.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CM1CM2 (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M06_CM1CM2 getCM1CM2(int rep) { 
       MFN_M06_CM1CM2 retVal = getTyped("CM1CM2", rep, MFN_M06_CM1CM2.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CM1CM2 
     */ 
    public int getCM1CM2Reps() {  
        return getReps("CM1CM2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CM1CM2.
     * <p>
     * <p>
     * Note that unlike {@link #getCM1CM2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<MFN_M06_CM1CM2> getCM1CM2All() throws HL7Exception {
    	return getAllAsList("CM1CM2", MFN_M06_CM1CM2.class);
    } 

    /**
     * Inserts a specific repetition of CM1CM2 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCM1CM2(MFN_M06_CM1CM2 structure, int rep) throws HL7Exception { 
       super.insertRepetition("CM1CM2", structure, rep);
    }


    /**
     * Inserts a specific repetition of CM1CM2 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M06_CM1CM2 insertCM1CM2(int rep) throws HL7Exception { 
       return (MFN_M06_CM1CM2)super.insertRepetition("CM1CM2", rep);
    }


    /**
     * Removes a specific repetition of CM1CM2 (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M06_CM1CM2 removeCM1CM2(int rep) throws HL7Exception { 
       return (MFN_M06_CM1CM2)super.removeRepetition("CM1CM2", rep);
    }



}

