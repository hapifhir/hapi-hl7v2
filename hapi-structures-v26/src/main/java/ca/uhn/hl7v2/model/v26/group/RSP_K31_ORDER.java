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
 * <p>Represents a RSP_K31_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: RSP_K31_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>3: RSP_K31_ORDER_DETAIL (a Group object) <b>optional  </b></li>
                         * <li>4: RSP_K31_ENCODING (a Group object) <b>optional  </b></li>
                         * <li>5: RXD (Pharmacy/Treatment Dispense) <b>  </b></li>
                         * <li>6: RXR (Pharmacy/Treatment Route) <b> repeating </b></li>
                         * <li>7: RXC (Pharmacy/Treatment Component Order) <b>optional repeating </b></li>
                         * <li>8: RSP_K31_OBSERVATION (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RSP_K31_ORDER extends AbstractGroup {

    /** 
     * Creates a new RSP_K31_ORDER group
     */
    public RSP_K31_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(RSP_K31_TIMING.class, false, true, false);
                                  this.add(RSP_K31_ORDER_DETAIL.class, false, false, false);
                                  this.add(RSP_K31_ENCODING.class, false, false, false);
                                  this.add(RXD.class, true, false, false);
                                  this.add(RXR.class, true, true, false);
                                  this.add(RXC.class, false, true, false);
                                  this.add(RSP_K31_OBSERVATION.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RSP_K31_ORDER - this is probably a bug in the source code generator.", e);
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
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * TIMING (a Group object) - creates it if necessary
     */
    public RSP_K31_TIMING getTIMING() { 
       RSP_K31_TIMING retVal = getTyped("TIMING", RSP_K31_TIMING.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RSP_K31_TIMING getTIMING(int rep) { 
       RSP_K31_TIMING retVal = getTyped("TIMING", rep, RSP_K31_TIMING.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING 
     */ 
    public int getTIMINGReps() {  
        return getReps("TIMING");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RSP_K31_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", RSP_K31_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(RSP_K31_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RSP_K31_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (RSP_K31_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RSP_K31_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (RSP_K31_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * ORDER_DETAIL (a Group object) - creates it if necessary
     */
    public RSP_K31_ORDER_DETAIL getORDER_DETAIL() { 
       RSP_K31_ORDER_DETAIL retVal = getTyped("ORDER_DETAIL", RSP_K31_ORDER_DETAIL.class);
       return retVal;
    }




    /**
     * Returns
     * ENCODING (a Group object) - creates it if necessary
     */
    public RSP_K31_ENCODING getENCODING() { 
       RSP_K31_ENCODING retVal = getTyped("ENCODING", RSP_K31_ENCODING.class);
       return retVal;
    }




    /**
     * Returns
     * RXD (Pharmacy/Treatment Dispense) - creates it if necessary
     */
    public RXD getRXD() { 
       RXD retVal = getTyped("RXD", RXD.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
     */
    public RXR getRXR() { 
       RXR retVal = getTyped("RXR", RXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
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
     * Inserts a specific repetition of RXR (Pharmacy/Treatment Route)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXR(RXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXR (Pharmacy/Treatment Route)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXR insertRXR(int rep) throws HL7Exception { 
       return (RXR)super.insertRepetition("RXR", rep);
    }


    /**
     * Removes a specific repetition of RXR (Pharmacy/Treatment Route)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXR removeRXR(int rep) throws HL7Exception { 
       return (RXR)super.removeRepetition("RXR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RXC (Pharmacy/Treatment Component Order) - creates it if necessary
     */
    public RXC getRXC() { 
       RXC retVal = getTyped("RXC", RXC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXC (Pharmacy/Treatment Component Order) - creates it if necessary
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
     * Inserts a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXC(RXC structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXC", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXC insertRXC(int rep) throws HL7Exception { 
       return (RXC)super.insertRepetition("RXC", rep);
    }


    /**
     * Removes a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXC removeRXC(int rep) throws HL7Exception { 
       return (RXC)super.removeRepetition("RXC", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public RSP_K31_OBSERVATION getOBSERVATION() { 
       RSP_K31_OBSERVATION retVal = getTyped("OBSERVATION", RSP_K31_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RSP_K31_OBSERVATION getOBSERVATION(int rep) { 
       RSP_K31_OBSERVATION retVal = getTyped("OBSERVATION", rep, RSP_K31_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION 
     */ 
    public int getOBSERVATIONReps() {  
        return getReps("OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RSP_K31_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", RSP_K31_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(RSP_K31_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RSP_K31_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (RSP_K31_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RSP_K31_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (RSP_K31_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
    }



}

