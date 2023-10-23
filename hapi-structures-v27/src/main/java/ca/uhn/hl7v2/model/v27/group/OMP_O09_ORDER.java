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


package ca.uhn.hl7v2.model.v27.group;

import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a OMP_O09_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: OMP_O09_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>3: RXO (Pharmacy/Treatment Order) <b>  </b></li>
                         * <li>4: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>5: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>6: RXR (Pharmacy/Treatment Route) <b> repeating </b></li>
                         * <li>7: OMP_O09_COMPONENT (a Group object) <b>optional repeating </b></li>
                         * <li>8: OMP_O09_OBSERVATION (a Group object) <b>optional repeating </b></li>
                         * <li>9: FT1 (Financial Transaction) <b>optional repeating </b></li>
                         * <li>10: BLG (Billing) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OMP_O09_ORDER extends AbstractGroup {

    /** 
     * Creates a new OMP_O09_ORDER group
     */
    public OMP_O09_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(OMP_O09_TIMING.class, false, true, false);
                                  this.add(RXO.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(RXR.class, true, true, false);
                                  this.add(OMP_O09_COMPONENT.class, false, true, false);
                                  this.add(OMP_O09_OBSERVATION.class, false, true, false);
                                  this.add(FT1.class, false, true, false);
                                  this.add(BLG.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OMP_O09_ORDER - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
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
    public OMP_O09_TIMING getTIMING() { 
       OMP_O09_TIMING retVal = getTyped("TIMING", OMP_O09_TIMING.class);
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
    public OMP_O09_TIMING getTIMING(int rep) { 
       OMP_O09_TIMING retVal = getTyped("TIMING", rep, OMP_O09_TIMING.class);
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
    public java.util.List<OMP_O09_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", OMP_O09_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(OMP_O09_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMP_O09_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (OMP_O09_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMP_O09_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (OMP_O09_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * RXO (Pharmacy/Treatment Order) - creates it if necessary
     */
    public RXO getRXO() { 
       RXO retVal = getTyped("RXO", RXO.class);
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
     * COMPONENT (a Group object) - creates it if necessary
     */
    public OMP_O09_COMPONENT getCOMPONENT() { 
       OMP_O09_COMPONENT retVal = getTyped("COMPONENT", OMP_O09_COMPONENT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * COMPONENT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OMP_O09_COMPONENT getCOMPONENT(int rep) { 
       OMP_O09_COMPONENT retVal = getTyped("COMPONENT", rep, OMP_O09_COMPONENT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of COMPONENT 
     */ 
    public int getCOMPONENTReps() {  
        return getReps("COMPONENT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of COMPONENT.
     * <p>
     * <p>
     * Note that unlike {@link #getCOMPONENT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OMP_O09_COMPONENT> getCOMPONENTAll() throws HL7Exception {
    	return getAllAsList("COMPONENT", OMP_O09_COMPONENT.class);
    } 

    /**
     * Inserts a specific repetition of COMPONENT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCOMPONENT(OMP_O09_COMPONENT structure, int rep) throws HL7Exception { 
       super.insertRepetition("COMPONENT", structure, rep);
    }


    /**
     * Inserts a specific repetition of COMPONENT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMP_O09_COMPONENT insertCOMPONENT(int rep) throws HL7Exception { 
       return (OMP_O09_COMPONENT)super.insertRepetition("COMPONENT", rep);
    }


    /**
     * Removes a specific repetition of COMPONENT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMP_O09_COMPONENT removeCOMPONENT(int rep) throws HL7Exception { 
       return (OMP_O09_COMPONENT)super.removeRepetition("COMPONENT", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public OMP_O09_OBSERVATION getOBSERVATION() { 
       OMP_O09_OBSERVATION retVal = getTyped("OBSERVATION", OMP_O09_OBSERVATION.class);
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
    public OMP_O09_OBSERVATION getOBSERVATION(int rep) { 
       OMP_O09_OBSERVATION retVal = getTyped("OBSERVATION", rep, OMP_O09_OBSERVATION.class);
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
    public java.util.List<OMP_O09_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", OMP_O09_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(OMP_O09_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMP_O09_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (OMP_O09_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMP_O09_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (OMP_O09_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * FT1 (Financial Transaction) - creates it if necessary
     */
    public FT1 getFT1() { 
       FT1 retVal = getTyped("FT1", FT1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FT1 (Financial Transaction) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public FT1 getFT1(int rep) { 
       FT1 retVal = getTyped("FT1", rep, FT1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FT1 
     */ 
    public int getFT1Reps() {  
        return getReps("FT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FT1.
     * <p>
     * <p>
     * Note that unlike {@link #getFT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<FT1> getFT1All() throws HL7Exception {
    	return getAllAsList("FT1", FT1.class);
    } 

    /**
     * Inserts a specific repetition of FT1 (Financial Transaction)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFT1(FT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("FT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of FT1 (Financial Transaction)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public FT1 insertFT1(int rep) throws HL7Exception { 
       return (FT1)super.insertRepetition("FT1", rep);
    }


    /**
     * Removes a specific repetition of FT1 (Financial Transaction)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public FT1 removeFT1(int rep) throws HL7Exception { 
       return (FT1)super.removeRepetition("FT1", rep);
    }



    /**
     * Returns
     * BLG (Billing) - creates it if necessary
     */
    public BLG getBLG() { 
       BLG retVal = getTyped("BLG", BLG.class);
       return retVal;
    }




}

