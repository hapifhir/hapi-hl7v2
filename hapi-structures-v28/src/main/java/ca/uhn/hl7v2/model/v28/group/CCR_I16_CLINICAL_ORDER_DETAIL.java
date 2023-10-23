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


package ca.uhn.hl7v2.model.v28.group;

import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a CCR_I16_CLINICAL_ORDER_DETAIL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: OBR (Observation Request) <b>  choice</b></li>
                         * <li>2: RXO (Pharmacy/Treatment Order) <b>  choice</b></li>
                         * <li>3: ODS (Dietary Orders, Supplements, and Preferences) <b>  choice</b></li>
                         * <li>4: PR1 (Procedures) <b>  choice</b></li>
                         * <li>5: CCR_I16_CLINICAL_ORDER_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class CCR_I16_CLINICAL_ORDER_DETAIL extends AbstractGroup {

    /** 
     * Creates a new CCR_I16_CLINICAL_ORDER_DETAIL group
     */
    public CCR_I16_CLINICAL_ORDER_DETAIL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(OBR.class, true, false, true);
                                  this.add(RXO.class, true, false, true);
                                  this.add(ODS.class, true, false, true);
                                  this.add(PR1.class, true, false, true);
                                  this.add(CCR_I16_CLINICAL_ORDER_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCR_I16_CLINICAL_ORDER_DETAIL - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
    }



    /**
     * Returns
     * OBR (Observation Request) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
       return retVal;
    }




    /**
     * Returns
     * RXO (Pharmacy/Treatment Order) - creates it if necessary
     */
    public RXO getRXO() { 
       RXO retVal = getTyped("RXO", RXO.class);
       return retVal;
    }




    /**
     * Returns
     * ODS (Dietary Orders, Supplements, and Preferences) - creates it if necessary
     */
    public ODS getODS() { 
       ODS retVal = getTyped("ODS", ODS.class);
       return retVal;
    }




    /**
     * Returns
     * PR1 (Procedures) - creates it if necessary
     */
    public PR1 getPR1() { 
       PR1 retVal = getTyped("PR1", PR1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CLINICAL_ORDER_OBSERVATION (a Group object) - creates it if necessary
     */
    public CCR_I16_CLINICAL_ORDER_OBSERVATION getCLINICAL_ORDER_OBSERVATION() { 
       CCR_I16_CLINICAL_ORDER_OBSERVATION retVal = getTyped("CLINICAL_ORDER_OBSERVATION", CCR_I16_CLINICAL_ORDER_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CLINICAL_ORDER_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCR_I16_CLINICAL_ORDER_OBSERVATION getCLINICAL_ORDER_OBSERVATION(int rep) { 
       CCR_I16_CLINICAL_ORDER_OBSERVATION retVal = getTyped("CLINICAL_ORDER_OBSERVATION", rep, CCR_I16_CLINICAL_ORDER_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CLINICAL_ORDER_OBSERVATION 
     */ 
    public int getCLINICAL_ORDER_OBSERVATIONReps() {  
        return getReps("CLINICAL_ORDER_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CLINICAL_ORDER_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getCLINICAL_ORDER_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCR_I16_CLINICAL_ORDER_OBSERVATION> getCLINICAL_ORDER_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("CLINICAL_ORDER_OBSERVATION", CCR_I16_CLINICAL_ORDER_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of CLINICAL_ORDER_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCLINICAL_ORDER_OBSERVATION(CCR_I16_CLINICAL_ORDER_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("CLINICAL_ORDER_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of CLINICAL_ORDER_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCR_I16_CLINICAL_ORDER_OBSERVATION insertCLINICAL_ORDER_OBSERVATION(int rep) throws HL7Exception { 
       return (CCR_I16_CLINICAL_ORDER_OBSERVATION)super.insertRepetition("CLINICAL_ORDER_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of CLINICAL_ORDER_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCR_I16_CLINICAL_ORDER_OBSERVATION removeCLINICAL_ORDER_OBSERVATION(int rep) throws HL7Exception { 
       return (CCR_I16_CLINICAL_ORDER_OBSERVATION)super.removeRepetition("CLINICAL_ORDER_OBSERVATION", rep);
    }



}

