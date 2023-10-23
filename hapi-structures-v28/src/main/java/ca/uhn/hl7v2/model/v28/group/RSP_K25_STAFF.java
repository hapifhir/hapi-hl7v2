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
 * <p>Represents a RSP_K25_STAFF group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: STF (Staff Identification) <b>  </b></li>
                         * <li>2: PRA (Practitioner Detail) <b>optional repeating </b></li>
                         * <li>3: ORG (Practitioner Organization Unit) <b>optional repeating </b></li>
                         * <li>4: AFF (Professional Affiliation) <b>optional repeating </b></li>
                         * <li>5: LAN (Language Detail) <b>optional repeating </b></li>
                         * <li>6: EDU (Educational Detail) <b>optional repeating </b></li>
                         * <li>7: CER (Certificate Detail) <b>optional repeating </b></li>
                         * <li>8: NK1 (Next of Kin / Associated Parties) <b>optional repeating </b></li>
                         * <li>9: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>10: ROL (Role) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RSP_K25_STAFF extends AbstractGroup {

    /** 
     * Creates a new RSP_K25_STAFF group
     */
    public RSP_K25_STAFF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(STF.class, true, false, false);
                                  this.add(PRA.class, false, true, false);
                                  this.add(ORG.class, false, true, false);
                                  this.add(AFF.class, false, true, false);
                                  this.add(LAN.class, false, true, false);
                                  this.add(EDU.class, false, true, false);
                                  this.add(CER.class, false, true, false);
                                  this.add(NK1.class, false, true, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(ROL.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RSP_K25_STAFF - this is probably a bug in the source code generator.", e);
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
     * ORG (Practitioner Organization Unit) - creates it if necessary
     */
    public ORG getORG() { 
       ORG retVal = getTyped("ORG", ORG.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORG (Practitioner Organization Unit) - creates it if necessary
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
     * Inserts a specific repetition of ORG (Practitioner Organization Unit)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORG(ORG structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORG", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORG (Practitioner Organization Unit)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORG insertORG(int rep) throws HL7Exception { 
       return (ORG)super.insertRepetition("ORG", rep);
    }


    /**
     * Removes a specific repetition of ORG (Practitioner Organization Unit)
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
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       NK1 retVal = getTyped("NK1", rep, NK1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NK1 
     */ 
    public int getNK1Reps() {  
        return getReps("NK1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NK1.
     * <p>
     * <p>
     * Note that unlike {@link #getNK1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
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
     * ROL (Role) - creates it if necessary
     */
    public ROL getROL() { 
       ROL retVal = getTyped("ROL", ROL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       ROL retVal = getTyped("ROL", rep, ROL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROL 
     */ 
    public int getROLReps() {  
        return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * Removes a specific repetition of ROL (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



}

