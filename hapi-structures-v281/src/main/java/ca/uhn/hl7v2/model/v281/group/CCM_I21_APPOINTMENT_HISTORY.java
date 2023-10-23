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
 * <p>Represents a CCM_I21_APPOINTMENT_HISTORY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SCH (Scheduling Activity Information) <b>  </b></li>
                         * <li>2: CCM_I21_RESOURCES (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCM_I21_APPOINTMENT_HISTORY extends AbstractGroup {

    /** 
     * Creates a new CCM_I21_APPOINTMENT_HISTORY group
     */
    public CCM_I21_APPOINTMENT_HISTORY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SCH.class, true, false, false);
                                  this.add(CCM_I21_RESOURCES.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCM_I21_APPOINTMENT_HISTORY - this is probably a bug in the source code generator.", e);
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
     * SCH (Scheduling Activity Information) - creates it if necessary
     */
    public SCH getSCH() { 
       SCH retVal = getTyped("SCH", SCH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RESOURCES (a Group object) - creates it if necessary
     */
    public CCM_I21_RESOURCES getRESOURCES() { 
       CCM_I21_RESOURCES retVal = getTyped("RESOURCES", CCM_I21_RESOURCES.class);
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
    public CCM_I21_RESOURCES getRESOURCES(int rep) { 
       CCM_I21_RESOURCES retVal = getTyped("RESOURCES", rep, CCM_I21_RESOURCES.class);
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
    public java.util.List<CCM_I21_RESOURCES> getRESOURCESAll() throws HL7Exception {
    	return getAllAsList("RESOURCES", CCM_I21_RESOURCES.class);
    } 

    /**
     * Inserts a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESOURCES(CCM_I21_RESOURCES structure, int rep) throws HL7Exception { 
       super.insertRepetition("RESOURCES", structure, rep);
    }


    /**
     * Inserts a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCM_I21_RESOURCES insertRESOURCES(int rep) throws HL7Exception { 
       return (CCM_I21_RESOURCES)super.insertRepetition("RESOURCES", rep);
    }


    /**
     * Removes a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCM_I21_RESOURCES removeRESOURCES(int rep) throws HL7Exception { 
       return (CCM_I21_RESOURCES)super.removeRepetition("RESOURCES", rep);
    }



}

