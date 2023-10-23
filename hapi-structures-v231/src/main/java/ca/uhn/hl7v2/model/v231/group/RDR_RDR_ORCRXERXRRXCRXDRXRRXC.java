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
 * <p>Represents a RDR_RDR_ORCRXERXRRXCRXDRXRRXC group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (ORC - common order segment) <b>  </b></li>
                         * <li>2: RDR_RDR_RXERXRRXC (a Group object) <b>optional  </b></li>
                         * <li>3: RDR_RDR_RXDRXRRXC (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RDR_RDR_ORCRXERXRRXCRXDRXRRXC extends AbstractGroup {

    /** 
     * Creates a new RDR_RDR_ORCRXERXRRXCRXDRXRRXC group
     */
    public RDR_RDR_ORCRXERXRRXCRXDRXRRXC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(RDR_RDR_RXERXRRXC.class, false, false, false);
                                  this.add(RDR_RDR_RXDRXRRXC.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RDR_RDR_ORCRXERXRRXCRXDRXRRXC - this is probably a bug in the source code generator.", e);
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
     * ORC (ORC - common order segment) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * RXERXRRXC (a Group object) - creates it if necessary
     */
    public RDR_RDR_RXERXRRXC getRXERXRRXC() { 
       RDR_RDR_RXERXRRXC retVal = getTyped("RXERXRRXC", RDR_RDR_RXERXRRXC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RXDRXRRXC (a Group object) - creates it if necessary
     */
    public RDR_RDR_RXDRXRRXC getRXDRXRRXC() { 
       RDR_RDR_RXDRXRRXC retVal = getTyped("RXDRXRRXC", RDR_RDR_RXDRXRRXC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXDRXRRXC (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDR_RDR_RXDRXRRXC getRXDRXRRXC(int rep) { 
       RDR_RDR_RXDRXRRXC retVal = getTyped("RXDRXRRXC", rep, RDR_RDR_RXDRXRRXC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXDRXRRXC 
     */ 
    public int getRXDRXRRXCReps() {  
        return getReps("RXDRXRRXC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXDRXRRXC.
     * <p>
     * <p>
     * Note that unlike {@link #getRXDRXRRXC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDR_RDR_RXDRXRRXC> getRXDRXRRXCAll() throws HL7Exception {
    	return getAllAsList("RXDRXRRXC", RDR_RDR_RXDRXRRXC.class);
    } 

    /**
     * Inserts a specific repetition of RXDRXRRXC (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXDRXRRXC(RDR_RDR_RXDRXRRXC structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXDRXRRXC", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXDRXRRXC (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDR_RDR_RXDRXRRXC insertRXDRXRRXC(int rep) throws HL7Exception { 
       return (RDR_RDR_RXDRXRRXC)super.insertRepetition("RXDRXRRXC", rep);
    }


    /**
     * Removes a specific repetition of RXDRXRRXC (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDR_RDR_RXDRXRRXC removeRXDRXRRXC(int rep) throws HL7Exception { 
       return (RDR_RDR_RXDRXRRXC)super.removeRepetition("RXDRXRRXC", rep);
    }



}

