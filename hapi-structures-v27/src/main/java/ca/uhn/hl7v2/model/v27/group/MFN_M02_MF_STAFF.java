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
 * <p>Represents a MFN_M02_MF_STAFF group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: MFE (Master File Entry) <b>  </b></li>
                         * <li>2: STF (Staff Identification) <b>  </b></li>
                         * <li>3: PRA (Practitioner Detail) <b>optional repeating </b></li>
                         * <li>4: ORG (Practitioner Organization Unit s) <b>optional repeating </b></li>
                         * <li>5: AFF (Professional Affiliation) <b>optional repeating </b></li>
                         * <li>6: LAN (Language Detail) <b>optional repeating </b></li>
                         * <li>7: EDU (Educational Detail) <b>optional repeating </b></li>
                         * <li>8: CER (Certificate Detail) <b>optional repeating </b></li>
                         * <li>9: NTE (Notes and Comments) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M02_MF_STAFF extends AbstractGroup {

    /** 
     * Creates a new MFN_M02_MF_STAFF group
     */
    public MFN_M02_MF_STAFF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(MFE.class, true, false, false);
                                  this.add(STF.class, true, false, false);
                                  this.add(PRA.class, false, true, false);
                                  this.add(ORG.class, false, true, false);
                                  this.add(AFF.class, false, true, false);
                                  this.add(LAN.class, false, true, false);
                                  this.add(EDU.class, false, true, false);
                                  this.add(CER.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M02_MF_STAFF - this is probably a bug in the source code generator.", e);
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
     * MFE (Master File Entry) - creates it if necessary
     */
    public MFE getMFE() { 
       MFE retVal = getTyped("MFE", MFE.class);
       return retVal;
    }




    /**
     * Returns
     * STF (Staff Identification) - creates it if necessary
     */
    public STF getSTF() { 
       STF retVal = getTyped("STF", STF.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PRA (Practitioner Detail) - creates it if necessary
     */
    public PRA getPRA() { 
       PRA retVal = getTyped("PRA", PRA.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRA (Practitioner Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRA getPRA(int rep) { 
       PRA retVal = getTyped("PRA", rep, PRA.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRA 
     */ 
    public int getPRAReps() {  
        return getReps("PRA");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRA.
     * <p>
     * <p>
     * Note that unlike {@link #getPRA()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRA> getPRAAll() throws HL7Exception {
    	return getAllAsList("PRA", PRA.class);
    } 

    /**
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRA(PRA structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRA", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRA insertPRA(int rep) throws HL7Exception { 
       return (PRA)super.insertRepetition("PRA", rep);
    }


    /**
     * Removes a specific repetition of PRA (Practitioner Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRA removePRA(int rep) throws HL7Exception { 
       return (PRA)super.removeRepetition("PRA", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORG (Practitioner Organization Unit s) - creates it if necessary
     */
    public ORG getORG() { 
       ORG retVal = getTyped("ORG", ORG.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORG (Practitioner Organization Unit s) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORG getORG(int rep) { 
       ORG retVal = getTyped("ORG", rep, ORG.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORG 
     */ 
    public int getORGReps() {  
        return getReps("ORG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORG.
     * <p>
     * <p>
     * Note that unlike {@link #getORG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORG> getORGAll() throws HL7Exception {
    	return getAllAsList("ORG", ORG.class);
    } 

    /**
     * Inserts a specific repetition of ORG (Practitioner Organization Unit s)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORG(ORG structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORG", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORG (Practitioner Organization Unit s)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORG insertORG(int rep) throws HL7Exception { 
       return (ORG)super.insertRepetition("ORG", rep);
    }


    /**
     * Removes a specific repetition of ORG (Practitioner Organization Unit s)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORG removeORG(int rep) throws HL7Exception { 
       return (ORG)super.removeRepetition("ORG", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AFF (Professional Affiliation) - creates it if necessary
     */
    public AFF getAFF() { 
       AFF retVal = getTyped("AFF", AFF.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AFF (Professional Affiliation) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AFF getAFF(int rep) { 
       AFF retVal = getTyped("AFF", rep, AFF.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AFF 
     */ 
    public int getAFFReps() {  
        return getReps("AFF");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AFF.
     * <p>
     * <p>
     * Note that unlike {@link #getAFF()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<AFF> getAFFAll() throws HL7Exception {
    	return getAllAsList("AFF", AFF.class);
    } 

    /**
     * Inserts a specific repetition of AFF (Professional Affiliation)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAFF(AFF structure, int rep) throws HL7Exception { 
       super.insertRepetition("AFF", structure, rep);
    }


    /**
     * Inserts a specific repetition of AFF (Professional Affiliation)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AFF insertAFF(int rep) throws HL7Exception { 
       return (AFF)super.insertRepetition("AFF", rep);
    }


    /**
     * Removes a specific repetition of AFF (Professional Affiliation)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AFF removeAFF(int rep) throws HL7Exception { 
       return (AFF)super.removeRepetition("AFF", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LAN (Language Detail) - creates it if necessary
     */
    public LAN getLAN() { 
       LAN retVal = getTyped("LAN", LAN.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LAN (Language Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LAN getLAN(int rep) { 
       LAN retVal = getTyped("LAN", rep, LAN.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LAN 
     */ 
    public int getLANReps() {  
        return getReps("LAN");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LAN.
     * <p>
     * <p>
     * Note that unlike {@link #getLAN()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LAN> getLANAll() throws HL7Exception {
    	return getAllAsList("LAN", LAN.class);
    } 

    /**
     * Inserts a specific repetition of LAN (Language Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLAN(LAN structure, int rep) throws HL7Exception { 
       super.insertRepetition("LAN", structure, rep);
    }


    /**
     * Inserts a specific repetition of LAN (Language Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LAN insertLAN(int rep) throws HL7Exception { 
       return (LAN)super.insertRepetition("LAN", rep);
    }


    /**
     * Removes a specific repetition of LAN (Language Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LAN removeLAN(int rep) throws HL7Exception { 
       return (LAN)super.removeRepetition("LAN", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * EDU (Educational Detail) - creates it if necessary
     */
    public EDU getEDU() { 
       EDU retVal = getTyped("EDU", EDU.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * EDU (Educational Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EDU getEDU(int rep) { 
       EDU retVal = getTyped("EDU", rep, EDU.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of EDU 
     */ 
    public int getEDUReps() {  
        return getReps("EDU");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of EDU.
     * <p>
     * <p>
     * Note that unlike {@link #getEDU()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EDU> getEDUAll() throws HL7Exception {
    	return getAllAsList("EDU", EDU.class);
    } 

    /**
     * Inserts a specific repetition of EDU (Educational Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertEDU(EDU structure, int rep) throws HL7Exception { 
       super.insertRepetition("EDU", structure, rep);
    }


    /**
     * Inserts a specific repetition of EDU (Educational Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EDU insertEDU(int rep) throws HL7Exception { 
       return (EDU)super.insertRepetition("EDU", rep);
    }


    /**
     * Removes a specific repetition of EDU (Educational Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EDU removeEDU(int rep) throws HL7Exception { 
       return (EDU)super.removeRepetition("EDU", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CER (Certificate Detail) - creates it if necessary
     */
    public CER getCER() { 
       CER retVal = getTyped("CER", CER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CER (Certificate Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CER getCER(int rep) { 
       CER retVal = getTyped("CER", rep, CER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CER 
     */ 
    public int getCERReps() {  
        return getReps("CER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CER.
     * <p>
     * <p>
     * Note that unlike {@link #getCER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CER> getCERAll() throws HL7Exception {
    	return getAllAsList("CER", CER.class);
    } 

    /**
     * Inserts a specific repetition of CER (Certificate Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCER(CER structure, int rep) throws HL7Exception { 
       super.insertRepetition("CER", structure, rep);
    }


    /**
     * Inserts a specific repetition of CER (Certificate Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CER insertCER(int rep) throws HL7Exception { 
       return (CER)super.insertRepetition("CER", rep);
    }


    /**
     * Removes a specific repetition of CER (Certificate Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CER removeCER(int rep) throws HL7Exception { 
       return (CER)super.removeRepetition("CER", rep);
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



}

