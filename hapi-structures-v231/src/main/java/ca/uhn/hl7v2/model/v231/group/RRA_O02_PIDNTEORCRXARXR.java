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
 * <p>Represents a RRA_O02_PIDNTEORCRXARXR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RRA_O02_PIDNTE (a Group object) <b>optional  </b></li>
                         * <li>2: RRA_O02_ORCRXARXR (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RRA_O02_PIDNTEORCRXARXR extends AbstractGroup {

    /** 
     * Creates a new RRA_O02_PIDNTEORCRXARXR group
     */
    public RRA_O02_PIDNTEORCRXARXR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RRA_O02_PIDNTE.class, false, false, false);
                                  this.add(RRA_O02_ORCRXARXR.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RRA_O02_PIDNTEORCRXARXR - this is probably a bug in the source code generator.", e);
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
     * PIDNTE (a Group object) - creates it if necessary
     */
    public RRA_O02_PIDNTE getPIDNTE() { 
       RRA_O02_PIDNTE retVal = getTyped("PIDNTE", RRA_O02_PIDNTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORCRXARXR (a Group object) - creates it if necessary
     */
    public RRA_O02_ORCRXARXR getORCRXARXR() { 
       RRA_O02_ORCRXARXR retVal = getTyped("ORCRXARXR", RRA_O02_ORCRXARXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCRXARXR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRA_O02_ORCRXARXR getORCRXARXR(int rep) { 
       RRA_O02_ORCRXARXR retVal = getTyped("ORCRXARXR", rep, RRA_O02_ORCRXARXR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCRXARXR 
     */ 
    public int getORCRXARXRReps() {  
        return getReps("ORCRXARXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCRXARXR.
     * <p>
     * <p>
     * Note that unlike {@link #getORCRXARXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RRA_O02_ORCRXARXR> getORCRXARXRAll() throws HL7Exception {
    	return getAllAsList("ORCRXARXR", RRA_O02_ORCRXARXR.class);
    } 

    /**
     * Inserts a specific repetition of ORCRXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCRXARXR(RRA_O02_ORCRXARXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCRXARXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCRXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRA_O02_ORCRXARXR insertORCRXARXR(int rep) throws HL7Exception { 
       return (RRA_O02_ORCRXARXR)super.insertRepetition("ORCRXARXR", rep);
    }


    /**
     * Removes a specific repetition of ORCRXARXR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRA_O02_ORCRXARXR removeORCRXARXR(int rep) throws HL7Exception { 
       return (RRA_O02_ORCRXARXR)super.removeRepetition("ORCRXARXR", rep);
    }



}

