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
 * <p>Represents a CCM_I21_CLINICAL_HISTORY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: CCM_I21_CLINICAL_HISTORY_DETAIL (a Group object) <b>optional repeating </b></li>
                         * <li>3: CCM_I21_ROLE_CLINICAL_HISTORY (a Group object) <b>optional repeating </b></li>
                         * <li>4: CTI (Clinical Trial Identification) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCM_I21_CLINICAL_HISTORY extends AbstractGroup {

    /** 
     * Creates a new CCM_I21_CLINICAL_HISTORY group
     */
    public CCM_I21_CLINICAL_HISTORY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(CCM_I21_CLINICAL_HISTORY_DETAIL.class, false, true, false);
                                  this.add(CCM_I21_ROLE_CLINICAL_HISTORY.class, false, true, false);
                                  this.add(CTI.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCM_I21_CLINICAL_HISTORY - this is probably a bug in the source code generator.", e);
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
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CLINICAL_HISTORY_DETAIL (a Group object) - creates it if necessary
     */
    public CCM_I21_CLINICAL_HISTORY_DETAIL getCLINICAL_HISTORY_DETAIL() { 
       CCM_I21_CLINICAL_HISTORY_DETAIL retVal = getTyped("CLINICAL_HISTORY_DETAIL", CCM_I21_CLINICAL_HISTORY_DETAIL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CLINICAL_HISTORY_DETAIL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCM_I21_CLINICAL_HISTORY_DETAIL getCLINICAL_HISTORY_DETAIL(int rep) { 
       CCM_I21_CLINICAL_HISTORY_DETAIL retVal = getTyped("CLINICAL_HISTORY_DETAIL", rep, CCM_I21_CLINICAL_HISTORY_DETAIL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CLINICAL_HISTORY_DETAIL 
     */ 
    public int getCLINICAL_HISTORY_DETAILReps() {  
        return getReps("CLINICAL_HISTORY_DETAIL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CLINICAL_HISTORY_DETAIL.
     * <p>
     * <p>
     * Note that unlike {@link #getCLINICAL_HISTORY_DETAIL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCM_I21_CLINICAL_HISTORY_DETAIL> getCLINICAL_HISTORY_DETAILAll() throws HL7Exception {
    	return getAllAsList("CLINICAL_HISTORY_DETAIL", CCM_I21_CLINICAL_HISTORY_DETAIL.class);
    } 

    /**
     * Inserts a specific repetition of CLINICAL_HISTORY_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCLINICAL_HISTORY_DETAIL(CCM_I21_CLINICAL_HISTORY_DETAIL structure, int rep) throws HL7Exception { 
       super.insertRepetition("CLINICAL_HISTORY_DETAIL", structure, rep);
    }


    /**
     * Inserts a specific repetition of CLINICAL_HISTORY_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCM_I21_CLINICAL_HISTORY_DETAIL insertCLINICAL_HISTORY_DETAIL(int rep) throws HL7Exception { 
       return (CCM_I21_CLINICAL_HISTORY_DETAIL)super.insertRepetition("CLINICAL_HISTORY_DETAIL", rep);
    }


    /**
     * Removes a specific repetition of CLINICAL_HISTORY_DETAIL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCM_I21_CLINICAL_HISTORY_DETAIL removeCLINICAL_HISTORY_DETAIL(int rep) throws HL7Exception { 
       return (CCM_I21_CLINICAL_HISTORY_DETAIL)super.removeRepetition("CLINICAL_HISTORY_DETAIL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROLE_CLINICAL_HISTORY (a Group object) - creates it if necessary
     */
    public CCM_I21_ROLE_CLINICAL_HISTORY getROLE_CLINICAL_HISTORY() { 
       CCM_I21_ROLE_CLINICAL_HISTORY retVal = getTyped("ROLE_CLINICAL_HISTORY", CCM_I21_ROLE_CLINICAL_HISTORY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROLE_CLINICAL_HISTORY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCM_I21_ROLE_CLINICAL_HISTORY getROLE_CLINICAL_HISTORY(int rep) { 
       CCM_I21_ROLE_CLINICAL_HISTORY retVal = getTyped("ROLE_CLINICAL_HISTORY", rep, CCM_I21_ROLE_CLINICAL_HISTORY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROLE_CLINICAL_HISTORY 
     */ 
    public int getROLE_CLINICAL_HISTORYReps() {  
        return getReps("ROLE_CLINICAL_HISTORY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROLE_CLINICAL_HISTORY.
     * <p>
     * <p>
     * Note that unlike {@link #getROLE_CLINICAL_HISTORY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCM_I21_ROLE_CLINICAL_HISTORY> getROLE_CLINICAL_HISTORYAll() throws HL7Exception {
    	return getAllAsList("ROLE_CLINICAL_HISTORY", CCM_I21_ROLE_CLINICAL_HISTORY.class);
    } 

    /**
     * Inserts a specific repetition of ROLE_CLINICAL_HISTORY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROLE_CLINICAL_HISTORY(CCM_I21_ROLE_CLINICAL_HISTORY structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROLE_CLINICAL_HISTORY", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROLE_CLINICAL_HISTORY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCM_I21_ROLE_CLINICAL_HISTORY insertROLE_CLINICAL_HISTORY(int rep) throws HL7Exception { 
       return (CCM_I21_ROLE_CLINICAL_HISTORY)super.insertRepetition("ROLE_CLINICAL_HISTORY", rep);
    }


    /**
     * Removes a specific repetition of ROLE_CLINICAL_HISTORY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCM_I21_ROLE_CLINICAL_HISTORY removeROLE_CLINICAL_HISTORY(int rep) throws HL7Exception { 
       return (CCM_I21_ROLE_CLINICAL_HISTORY)super.removeRepetition("ROLE_CLINICAL_HISTORY", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CTI (Clinical Trial Identification) - creates it if necessary
     */
    public CTI getCTI() { 
       CTI retVal = getTyped("CTI", CTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CTI (Clinical Trial Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CTI getCTI(int rep) { 
       CTI retVal = getTyped("CTI", rep, CTI.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CTI 
     */ 
    public int getCTIReps() {  
        return getReps("CTI");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CTI.
     * <p>
     * <p>
     * Note that unlike {@link #getCTI()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CTI> getCTIAll() throws HL7Exception {
    	return getAllAsList("CTI", CTI.class);
    } 

    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTI(CTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("CTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTI insertCTI(int rep) throws HL7Exception { 
       return (CTI)super.insertRepetition("CTI", rep);
    }


    /**
     * Removes a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTI removeCTI(int rep) throws HL7Exception { 
       return (CTI)super.removeRepetition("CTI", rep);
    }



}

