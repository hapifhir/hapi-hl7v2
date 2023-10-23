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
 * <p>Represents a RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (ORC - common order segment) <b>  </b></li>
                         * <li>2: RDS_O01_RXONTERXRRXCNTE (a Group object) <b>optional  </b></li>
                         * <li>3: RDS_O01_RXERXRRXC (a Group object) <b>optional  </b></li>
                         * <li>4: RXD (RXD - pharmacy/treatment dispense segment) <b>  </b></li>
                         * <li>5: RXR (RXR - pharmacy/treatment route segment) <b> repeating </b></li>
                         * <li>6: RXC (RXC - pharmacy/treatment component order segment) <b>optional repeating </b></li>
                         * <li>7: RDS_O01_OBXNTE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE extends AbstractGroup {

    /** 
     * Creates a new RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE group
     */
    public RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(RDS_O01_RXONTERXRRXCNTE.class, false, false, false);
                                  this.add(RDS_O01_RXERXRRXC.class, false, false, false);
                                  this.add(RXD.class, true, false, false);
                                  this.add(RXR.class, true, true, false);
                                  this.add(RXC.class, false, true, false);
                                  this.add(RDS_O01_OBXNTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE - this is probably a bug in the source code generator.", e);
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
    public RDS_O01_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
       RDS_O01_RXONTERXRRXCNTE retVal = getTyped("RXONTERXRRXCNTE", RDS_O01_RXONTERXRRXCNTE.class);
       return retVal;
    }




    /**
     * Returns
     * RXERXRRXC (a Group object) - creates it if necessary
     */
    public RDS_O01_RXERXRRXC getRXERXRRXC() { 
       RDS_O01_RXERXRRXC retVal = getTyped("RXERXRRXC", RDS_O01_RXERXRRXC.class);
       return retVal;
    }




    /**
     * Returns
     * RXD (RXD - pharmacy/treatment dispense segment) - creates it if necessary
     */
    public RXD getRXD() { 
       RXD retVal = getTyped("RXD", RXD.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
     */
    public RXR getRXR() { 
       RXR retVal = getTyped("RXR", RXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXR getRXR(int rep) { 
       RXR retVal = getTyped("RXR", rep, RXR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXR 
     */ 
    public int getRXRReps() {  
        return getReps("RXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXR.
     * <p>
     * <p>
     * Note that unlike {@link #getRXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RXR> getRXRAll() throws HL7Exception {
    	return getAllAsList("RXR", RXR.class);
    } 

    /**
     * Inserts a specific repetition of RXR (RXR - pharmacy/treatment route segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXR(RXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXR (RXR - pharmacy/treatment route segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXR insertRXR(int rep) throws HL7Exception { 
       return (RXR)super.insertRepetition("RXR", rep);
    }


    /**
     * Removes a specific repetition of RXR (RXR - pharmacy/treatment route segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXR removeRXR(int rep) throws HL7Exception { 
       return (RXR)super.removeRepetition("RXR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RXC (RXC - pharmacy/treatment component order segment) - creates it if necessary
     */
    public RXC getRXC() { 
       RXC retVal = getTyped("RXC", RXC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXC (RXC - pharmacy/treatment component order segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXC getRXC(int rep) { 
       RXC retVal = getTyped("RXC", rep, RXC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXC 
     */ 
    public int getRXCReps() {  
        return getReps("RXC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXC.
     * <p>
     * <p>
     * Note that unlike {@link #getRXC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RXC> getRXCAll() throws HL7Exception {
    	return getAllAsList("RXC", RXC.class);
    } 

    /**
     * Inserts a specific repetition of RXC (RXC - pharmacy/treatment component order segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXC(RXC structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXC", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXC (RXC - pharmacy/treatment component order segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXC insertRXC(int rep) throws HL7Exception { 
       return (RXC)super.insertRepetition("RXC", rep);
    }


    /**
     * Removes a specific repetition of RXC (RXC - pharmacy/treatment component order segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXC removeRXC(int rep) throws HL7Exception { 
       return (RXC)super.removeRepetition("RXC", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBXNTE (a Group object) - creates it if necessary
     */
    public RDS_O01_OBXNTE getOBXNTE() { 
       RDS_O01_OBXNTE retVal = getTyped("OBXNTE", RDS_O01_OBXNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBXNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDS_O01_OBXNTE getOBXNTE(int rep) { 
       RDS_O01_OBXNTE retVal = getTyped("OBXNTE", rep, RDS_O01_OBXNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBXNTE 
     */ 
    public int getOBXNTEReps() {  
        return getReps("OBXNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBXNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getOBXNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDS_O01_OBXNTE> getOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBXNTE", RDS_O01_OBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBXNTE(RDS_O01_OBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDS_O01_OBXNTE insertOBXNTE(int rep) throws HL7Exception { 
       return (RDS_O01_OBXNTE)super.insertRepetition("OBXNTE", rep);
    }


    /**
     * Removes a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDS_O01_OBXNTE removeOBXNTE(int rep) throws HL7Exception { 
       return (RDS_O01_OBXNTE)super.removeRepetition("OBXNTE", rep);
    }



}

