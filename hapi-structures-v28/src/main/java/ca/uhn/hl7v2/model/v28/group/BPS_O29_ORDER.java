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


package ca.uhn.hl7v2.model.v28.group;

import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a BPS_O29_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>3: BPS_O29_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>4: BPO (Blood product order) <b>  </b></li>
                         * <li>5: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>6: BPS_O29_PRODUCT (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class BPS_O29_ORDER extends AbstractGroup {

    /** 
     * Creates a new BPS_O29_ORDER group
     */
    public BPS_O29_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(BPS_O29_TIMING.class, false, true, false);
                                  this.add(BPO.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(BPS_O29_PRODUCT.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BPS_O29_ORDER - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
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
     * PRT (Participation Information) - creates it if necessary
     */
    public PRT getPRT() { 
       PRT retVal = getTyped("PRT", PRT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRT (Participation Information) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRT getPRT(int rep) { 
       PRT retVal = getTyped("PRT", rep, PRT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRT 
     */ 
    public int getPRTReps() {  
        return getReps("PRT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRT.
     * <p>
     * <p>
     * Note that unlike {@link #getPRT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRT> getPRTAll() throws HL7Exception {
    	return getAllAsList("PRT", PRT.class);
    } 

    /**
     * Inserts a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT", rep);
    }


    /**
     * Removes a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * TIMING (a Group object) - creates it if necessary
     */
    public BPS_O29_TIMING getTIMING() { 
       BPS_O29_TIMING retVal = getTyped("TIMING", BPS_O29_TIMING.class);
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
    public BPS_O29_TIMING getTIMING(int rep) { 
       BPS_O29_TIMING retVal = getTyped("TIMING", rep, BPS_O29_TIMING.class);
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
    public java.util.List<BPS_O29_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", BPS_O29_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(BPS_O29_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public BPS_O29_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (BPS_O29_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public BPS_O29_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (BPS_O29_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * BPO (Blood product order) - creates it if necessary
     */
    public BPO getBPO() { 
       BPO retVal = getTyped("BPO", BPO.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (Notes and Comments) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       NTE retVal = getTyped("NTE", rep, NTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NTE 
     */ 
    public int getNTEReps() {  
        return getReps("NTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NTE.
     * <p>
     * <p>
     * Note that unlike {@link #getNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PRODUCT (a Group object) - creates it if necessary
     */
    public BPS_O29_PRODUCT getPRODUCT() { 
       BPS_O29_PRODUCT retVal = getTyped("PRODUCT", BPS_O29_PRODUCT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRODUCT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public BPS_O29_PRODUCT getPRODUCT(int rep) { 
       BPS_O29_PRODUCT retVal = getTyped("PRODUCT", rep, BPS_O29_PRODUCT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRODUCT 
     */ 
    public int getPRODUCTReps() {  
        return getReps("PRODUCT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRODUCT.
     * <p>
     * <p>
     * Note that unlike {@link #getPRODUCT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<BPS_O29_PRODUCT> getPRODUCTAll() throws HL7Exception {
    	return getAllAsList("PRODUCT", BPS_O29_PRODUCT.class);
    } 

    /**
     * Inserts a specific repetition of PRODUCT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRODUCT(BPS_O29_PRODUCT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRODUCT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRODUCT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public BPS_O29_PRODUCT insertPRODUCT(int rep) throws HL7Exception { 
       return (BPS_O29_PRODUCT)super.insertRepetition("PRODUCT", rep);
    }


    /**
     * Removes a specific repetition of PRODUCT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public BPS_O29_PRODUCT removePRODUCT(int rep) throws HL7Exception { 
       return (BPS_O29_PRODUCT)super.removeRepetition("PRODUCT", rep);
    }



}

