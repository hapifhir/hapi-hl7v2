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
 * <p>Represents a RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (ORC - common order segment) <b>  </b></li>
                         * <li>2: RGV_O01_RXONTERXRRXCNTE (a Group object) <b>optional  </b></li>
                         * <li>3: RGV_O01_RXERXRRXC (a Group object) <b>optional  </b></li>
                         * <li>4: RGV_O01_RXGRXRRXCOBXNTE (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE extends AbstractGroup {

    /** 
     * Creates a new RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE group
     */
    public RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(RGV_O01_RXONTERXRRXCNTE.class, false, false, false);
                                  this.add(RGV_O01_RXERXRRXC.class, false, false, false);
                                  this.add(RGV_O01_RXGRXRRXCOBXNTE.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE - this is probably a bug in the source code generator.", e);
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
     * RXONTERXRRXCNTE (a Group object) - creates it if necessary
     */
    public RGV_O01_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
       RGV_O01_RXONTERXRRXCNTE retVal = getTyped("RXONTERXRRXCNTE", RGV_O01_RXONTERXRRXCNTE.class);
       return retVal;
    }




    /**
     * Returns
     * RXERXRRXC (a Group object) - creates it if necessary
     */
    public RGV_O01_RXERXRRXC getRXERXRRXC() { 
       RGV_O01_RXERXRRXC retVal = getTyped("RXERXRRXC", RGV_O01_RXERXRRXC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RXGRXRRXCOBXNTE (a Group object) - creates it if necessary
     */
    public RGV_O01_RXGRXRRXCOBXNTE getRXGRXRRXCOBXNTE() { 
       RGV_O01_RXGRXRRXCOBXNTE retVal = getTyped("RXGRXRRXCOBXNTE", RGV_O01_RXGRXRRXCOBXNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXGRXRRXCOBXNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RGV_O01_RXGRXRRXCOBXNTE getRXGRXRRXCOBXNTE(int rep) { 
       RGV_O01_RXGRXRRXCOBXNTE retVal = getTyped("RXGRXRRXCOBXNTE", rep, RGV_O01_RXGRXRRXCOBXNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXGRXRRXCOBXNTE 
     */ 
    public int getRXGRXRRXCOBXNTEReps() {  
        return getReps("RXGRXRRXCOBXNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXGRXRRXCOBXNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getRXGRXRRXCOBXNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RGV_O01_RXGRXRRXCOBXNTE> getRXGRXRRXCOBXNTEAll() throws HL7Exception {
    	return getAllAsList("RXGRXRRXCOBXNTE", RGV_O01_RXGRXRRXCOBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of RXGRXRRXCOBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXGRXRRXCOBXNTE(RGV_O01_RXGRXRRXCOBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXGRXRRXCOBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXGRXRRXCOBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RGV_O01_RXGRXRRXCOBXNTE insertRXGRXRRXCOBXNTE(int rep) throws HL7Exception { 
       return (RGV_O01_RXGRXRRXCOBXNTE)super.insertRepetition("RXGRXRRXCOBXNTE", rep);
    }


    /**
     * Removes a specific repetition of RXGRXRRXCOBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RGV_O01_RXGRXRRXCOBXNTE removeRXGRXRRXCOBXNTE(int rep) throws HL7Exception { 
       return (RGV_O01_RXGRXRRXCOBXNTE)super.removeRepetition("RXGRXRRXCOBXNTE", rep);
    }



}

