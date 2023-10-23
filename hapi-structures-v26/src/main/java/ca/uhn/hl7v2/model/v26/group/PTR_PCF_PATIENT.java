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
 * <p>Represents a PTR_PCF_PATIENT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PID (Patient Identification) <b>  </b></li>
                         * <li>2: PTR_PCF_PATIENT_VISIT (a Group object) <b>optional  </b></li>
                         * <li>3: PTR_PCF_PATHWAY (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PTR_PCF_PATIENT extends AbstractGroup {

    /** 
     * Creates a new PTR_PCF_PATIENT group
     */
    public PTR_PCF_PATIENT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PID.class, true, false, false);
                                  this.add(PTR_PCF_PATIENT_VISIT.class, false, false, false);
                                  this.add(PTR_PCF_PATHWAY.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PTR_PCF_PATIENT - this is probably a bug in the source code generator.", e);
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
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       PID retVal = getTyped("PID", PID.class);
       return retVal;
    }




    /**
     * Returns
     * PATIENT_VISIT (a Group object) - creates it if necessary
     */
    public PTR_PCF_PATIENT_VISIT getPATIENT_VISIT() { 
       PTR_PCF_PATIENT_VISIT retVal = getTyped("PATIENT_VISIT", PTR_PCF_PATIENT_VISIT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PATHWAY (a Group object) - creates it if necessary
     */
    public PTR_PCF_PATHWAY getPATHWAY() { 
       PTR_PCF_PATHWAY retVal = getTyped("PATHWAY", PTR_PCF_PATHWAY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PATHWAY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PTR_PCF_PATHWAY getPATHWAY(int rep) { 
       PTR_PCF_PATHWAY retVal = getTyped("PATHWAY", rep, PTR_PCF_PATHWAY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PATHWAY 
     */ 
    public int getPATHWAYReps() {  
        return getReps("PATHWAY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATHWAY.
     * <p>
     * <p>
     * Note that unlike {@link #getPATHWAY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PTR_PCF_PATHWAY> getPATHWAYAll() throws HL7Exception {
    	return getAllAsList("PATHWAY", PTR_PCF_PATHWAY.class);
    } 

    /**
     * Inserts a specific repetition of PATHWAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATHWAY(PTR_PCF_PATHWAY structure, int rep) throws HL7Exception { 
       super.insertRepetition("PATHWAY", structure, rep);
    }


    /**
     * Inserts a specific repetition of PATHWAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PTR_PCF_PATHWAY insertPATHWAY(int rep) throws HL7Exception { 
       return (PTR_PCF_PATHWAY)super.insertRepetition("PATHWAY", rep);
    }


    /**
     * Removes a specific repetition of PATHWAY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PTR_PCF_PATHWAY removePATHWAY(int rep) throws HL7Exception { 
       return (PTR_PCF_PATHWAY)super.removeRepetition("PATHWAY", rep);
    }



}

