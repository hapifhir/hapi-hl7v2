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
 * <p>Represents a RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (ORC - common order segment) <b>  </b></li>
                         * <li>2: RAS_O01_RXONTERXRRXCNTE (a Group object) <b>optional  </b></li>
                         * <li>3: RAS_O01_RXERXRRXC (a Group object) <b>optional  </b></li>
                         * <li>4: RXA (RXA - pharmacy/treatment administration segment) <b> repeating </b></li>
                         * <li>5: RXR (RXR - pharmacy/treatment route segment) <b>  </b></li>
                         * <li>6: RAS_O01_OBXNTE (a Group object) <b>optional repeating </b></li>
                         * <li>7: CTI (CTI - clinical trial identification segment) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI extends AbstractGroup {

    /** 
     * Creates a new RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI group
     */
    public RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(RAS_O01_RXONTERXRRXCNTE.class, false, false, false);
                                  this.add(RAS_O01_RXERXRRXC.class, false, false, false);
                                  this.add(RXA.class, true, true, false);
                                  this.add(RXR.class, true, false, false);
                                  this.add(RAS_O01_OBXNTE.class, false, true, false);
                                  this.add(CTI.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI - this is probably a bug in the source code generator.", e);
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
    public RAS_O01_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
       RAS_O01_RXONTERXRRXCNTE retVal = getTyped("RXONTERXRRXCNTE", RAS_O01_RXONTERXRRXCNTE.class);
       return retVal;
    }




    /**
     * Returns
     * RXERXRRXC (a Group object) - creates it if necessary
     */
    public RAS_O01_RXERXRRXC getRXERXRRXC() { 
       RAS_O01_RXERXRRXC retVal = getTyped("RXERXRRXC", RAS_O01_RXERXRRXC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RXA (RXA - pharmacy/treatment administration segment) - creates it if necessary
     */
    public RXA getRXA() { 
       RXA retVal = getTyped("RXA", RXA.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXA (RXA - pharmacy/treatment administration segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXA getRXA(int rep) { 
       RXA retVal = getTyped("RXA", rep, RXA.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXA 
     */ 
    public int getRXAReps() {  
        return getReps("RXA");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXA.
     * <p>
     * <p>
     * Note that unlike {@link #getRXA()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RXA> getRXAAll() throws HL7Exception {
    	return getAllAsList("RXA", RXA.class);
    } 

    /**
     * Inserts a specific repetition of RXA (RXA - pharmacy/treatment administration segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXA(RXA structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXA", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXA (RXA - pharmacy/treatment administration segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXA insertRXA(int rep) throws HL7Exception { 
       return (RXA)super.insertRepetition("RXA", rep);
    }


    /**
     * Removes a specific repetition of RXA (RXA - pharmacy/treatment administration segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXA removeRXA(int rep) throws HL7Exception { 
       return (RXA)super.removeRepetition("RXA", rep);
    }



    /**
     * Returns
     * RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
     */
    public RXR getRXR() { 
       RXR retVal = getTyped("RXR", RXR.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBXNTE (a Group object) - creates it if necessary
     */
    public RAS_O01_OBXNTE getOBXNTE() { 
       RAS_O01_OBXNTE retVal = getTyped("OBXNTE", RAS_O01_OBXNTE.class);
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
    public RAS_O01_OBXNTE getOBXNTE(int rep) { 
       RAS_O01_OBXNTE retVal = getTyped("OBXNTE", rep, RAS_O01_OBXNTE.class);
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
    public java.util.List<RAS_O01_OBXNTE> getOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBXNTE", RAS_O01_OBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBXNTE(RAS_O01_OBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RAS_O01_OBXNTE insertOBXNTE(int rep) throws HL7Exception { 
       return (RAS_O01_OBXNTE)super.insertRepetition("OBXNTE", rep);
    }


    /**
     * Removes a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RAS_O01_OBXNTE removeOBXNTE(int rep) throws HL7Exception { 
       return (RAS_O01_OBXNTE)super.removeRepetition("OBXNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CTI (CTI - clinical trial identification segment) - creates it if necessary
     */
    public CTI getCTI() { 
       CTI retVal = getTyped("CTI", CTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CTI (CTI - clinical trial identification segment) - creates it if necessary
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
     * Inserts a specific repetition of CTI (CTI - clinical trial identification segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTI(CTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("CTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of CTI (CTI - clinical trial identification segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTI insertCTI(int rep) throws HL7Exception { 
       return (CTI)super.insertRepetition("CTI", rep);
    }


    /**
     * Removes a specific repetition of CTI (CTI - clinical trial identification segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTI removeCTI(int rep) throws HL7Exception { 
       return (CTI)super.removeRepetition("CTI", rep);
    }



}

