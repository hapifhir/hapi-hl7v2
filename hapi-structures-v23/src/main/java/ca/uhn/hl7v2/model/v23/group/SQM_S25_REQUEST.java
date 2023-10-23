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


package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a SQM_S25_REQUEST group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ARQ (Appointment Request) <b>  </b></li>
                         * <li>2: APR (Appointment Preferences) <b>optional  </b></li>
                         * <li>3: PID (Patient Identification) <b>optional  </b></li>
                         * <li>4: SQM_S25_RESOURCES (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SQM_S25_REQUEST extends AbstractGroup {

    /** 
     * Creates a new SQM_S25_REQUEST group
     */
    public SQM_S25_REQUEST(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ARQ.class, true, false, false);
                                  this.add(APR.class, false, false, false);
                                  this.add(PID.class, false, false, false);
                                  this.add(SQM_S25_RESOURCES.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SQM_S25_REQUEST - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3"
     */
    public String getVersion() {
       return "2.3";
    }



    /**
     * Returns
     * ARQ (Appointment Request) - creates it if necessary
     */
    public ARQ getARQ() { 
       ARQ retVal = getTyped("ARQ", ARQ.class);
       return retVal;
    }




    /**
     * Returns
     * APR (Appointment Preferences) - creates it if necessary
     */
    public APR getAPR() { 
       APR retVal = getTyped("APR", APR.class);
       return retVal;
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
     * the first repetition of 
     * RESOURCES (a Group object) - creates it if necessary
     */
    public SQM_S25_RESOURCES getRESOURCES() { 
       SQM_S25_RESOURCES retVal = getTyped("RESOURCES", SQM_S25_RESOURCES.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RESOURCES (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SQM_S25_RESOURCES getRESOURCES(int rep) { 
       SQM_S25_RESOURCES retVal = getTyped("RESOURCES", rep, SQM_S25_RESOURCES.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RESOURCES 
     */ 
    public int getRESOURCESReps() {  
        return getReps("RESOURCES");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RESOURCES.
     * <p>
     * <p>
     * Note that unlike {@link #getRESOURCES()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SQM_S25_RESOURCES> getRESOURCESAll() throws HL7Exception {
    	return getAllAsList("RESOURCES", SQM_S25_RESOURCES.class);
    } 

    /**
     * Inserts a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESOURCES(SQM_S25_RESOURCES structure, int rep) throws HL7Exception { 
       super.insertRepetition("RESOURCES", structure, rep);
    }


    /**
     * Inserts a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SQM_S25_RESOURCES insertRESOURCES(int rep) throws HL7Exception { 
       return (SQM_S25_RESOURCES)super.insertRepetition("RESOURCES", rep);
    }


    /**
     * Removes a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SQM_S25_RESOURCES removeRESOURCES(int rep) throws HL7Exception { 
       return (SQM_S25_RESOURCES)super.removeRepetition("RESOURCES", rep);
    }



}

