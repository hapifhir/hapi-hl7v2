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
 * <p>Represents a RSP_Z90_QUERY_RESPONSE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RSP_Z90_PATIENT (a Group object) <b>optional  </b></li>
                         * <li>2: RSP_Z90_COMMON_ORDER (a Group object) <b> repeating </b></li>
                         * <li>3: RSP_Z90_SPECIMEN (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RSP_Z90_QUERY_RESPONSE extends AbstractGroup {

    /** 
     * Creates a new RSP_Z90_QUERY_RESPONSE group
     */
    public RSP_Z90_QUERY_RESPONSE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RSP_Z90_PATIENT.class, false, false, false);
                                  this.add(RSP_Z90_COMMON_ORDER.class, true, true, false);
                                  this.add(RSP_Z90_SPECIMEN.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RSP_Z90_QUERY_RESPONSE - this is probably a bug in the source code generator.", e);
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
     * PATIENT (a Group object) - creates it if necessary
     */
    public RSP_Z90_PATIENT getPATIENT() { 
       RSP_Z90_PATIENT retVal = getTyped("PATIENT", RSP_Z90_PATIENT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * COMMON_ORDER (a Group object) - creates it if necessary
     */
    public RSP_Z90_COMMON_ORDER getCOMMON_ORDER() { 
       RSP_Z90_COMMON_ORDER retVal = getTyped("COMMON_ORDER", RSP_Z90_COMMON_ORDER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * COMMON_ORDER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RSP_Z90_COMMON_ORDER getCOMMON_ORDER(int rep) { 
       RSP_Z90_COMMON_ORDER retVal = getTyped("COMMON_ORDER", rep, RSP_Z90_COMMON_ORDER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of COMMON_ORDER 
     */ 
    public int getCOMMON_ORDERReps() {  
        return getReps("COMMON_ORDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of COMMON_ORDER.
     * <p>
     * <p>
     * Note that unlike {@link #getCOMMON_ORDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RSP_Z90_COMMON_ORDER> getCOMMON_ORDERAll() throws HL7Exception {
    	return getAllAsList("COMMON_ORDER", RSP_Z90_COMMON_ORDER.class);
    } 

    /**
     * Inserts a specific repetition of COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCOMMON_ORDER(RSP_Z90_COMMON_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition("COMMON_ORDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RSP_Z90_COMMON_ORDER insertCOMMON_ORDER(int rep) throws HL7Exception { 
       return (RSP_Z90_COMMON_ORDER)super.insertRepetition("COMMON_ORDER", rep);
    }


    /**
     * Removes a specific repetition of COMMON_ORDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RSP_Z90_COMMON_ORDER removeCOMMON_ORDER(int rep) throws HL7Exception { 
       return (RSP_Z90_COMMON_ORDER)super.removeRepetition("COMMON_ORDER", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * SPECIMEN (a Group object) - creates it if necessary
     */
    public RSP_Z90_SPECIMEN getSPECIMEN() { 
       RSP_Z90_SPECIMEN retVal = getTyped("SPECIMEN", RSP_Z90_SPECIMEN.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SPECIMEN (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RSP_Z90_SPECIMEN getSPECIMEN(int rep) { 
       RSP_Z90_SPECIMEN retVal = getTyped("SPECIMEN", rep, RSP_Z90_SPECIMEN.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SPECIMEN 
     */ 
    public int getSPECIMENReps() {  
        return getReps("SPECIMEN");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SPECIMEN.
     * <p>
     * <p>
     * Note that unlike {@link #getSPECIMEN()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RSP_Z90_SPECIMEN> getSPECIMENAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN", RSP_Z90_SPECIMEN.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN(RSP_Z90_SPECIMEN structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RSP_Z90_SPECIMEN insertSPECIMEN(int rep) throws HL7Exception { 
       return (RSP_Z90_SPECIMEN)super.insertRepetition("SPECIMEN", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RSP_Z90_SPECIMEN removeSPECIMEN(int rep) throws HL7Exception { 
       return (RSP_Z90_SPECIMEN)super.removeRepetition("SPECIMEN", rep);
    }



}

