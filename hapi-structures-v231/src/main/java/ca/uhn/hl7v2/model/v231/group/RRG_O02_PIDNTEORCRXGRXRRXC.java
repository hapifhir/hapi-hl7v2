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
 * <p>Represents a RRG_O02_PIDNTEORCRXGRXRRXC group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RRG_O02_PIDNTE (a Group object) <b>optional  </b></li>
                         * <li>2: RRG_O02_ORCRXGRXRRXC (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RRG_O02_PIDNTEORCRXGRXRRXC extends AbstractGroup {

    /** 
     * Creates a new RRG_O02_PIDNTEORCRXGRXRRXC group
     */
    public RRG_O02_PIDNTEORCRXGRXRRXC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RRG_O02_PIDNTE.class, false, false, false);
                                  this.add(RRG_O02_ORCRXGRXRRXC.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RRG_O02_PIDNTEORCRXGRXRRXC - this is probably a bug in the source code generator.", e);
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
    public RRG_O02_PIDNTE getPIDNTE() { 
       RRG_O02_PIDNTE retVal = getTyped("PIDNTE", RRG_O02_PIDNTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORCRXGRXRRXC (a Group object) - creates it if necessary
     */
    public RRG_O02_ORCRXGRXRRXC getORCRXGRXRRXC() { 
       RRG_O02_ORCRXGRXRRXC retVal = getTyped("ORCRXGRXRRXC", RRG_O02_ORCRXGRXRRXC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCRXGRXRRXC (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRG_O02_ORCRXGRXRRXC getORCRXGRXRRXC(int rep) { 
       RRG_O02_ORCRXGRXRRXC retVal = getTyped("ORCRXGRXRRXC", rep, RRG_O02_ORCRXGRXRRXC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCRXGRXRRXC 
     */ 
    public int getORCRXGRXRRXCReps() {  
        return getReps("ORCRXGRXRRXC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCRXGRXRRXC.
     * <p>
     * <p>
     * Note that unlike {@link #getORCRXGRXRRXC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RRG_O02_ORCRXGRXRRXC> getORCRXGRXRRXCAll() throws HL7Exception {
    	return getAllAsList("ORCRXGRXRRXC", RRG_O02_ORCRXGRXRRXC.class);
    } 

    /**
     * Inserts a specific repetition of ORCRXGRXRRXC (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCRXGRXRRXC(RRG_O02_ORCRXGRXRRXC structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCRXGRXRRXC", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCRXGRXRRXC (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRG_O02_ORCRXGRXRRXC insertORCRXGRXRRXC(int rep) throws HL7Exception { 
       return (RRG_O02_ORCRXGRXRRXC)super.insertRepetition("ORCRXGRXRRXC", rep);
    }


    /**
     * Removes a specific repetition of ORCRXGRXRRXC (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRG_O02_ORCRXGRXRRXC removeORCRXGRXRRXC(int rep) throws HL7Exception { 
       return (RRG_O02_ORCRXGRXRRXC)super.removeRepetition("ORCRXGRXRRXC", rep);
    }



}

