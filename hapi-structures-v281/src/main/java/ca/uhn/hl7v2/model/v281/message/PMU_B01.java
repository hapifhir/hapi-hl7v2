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


package ca.uhn.hl7v2.model.v281.message;

import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a PMU_B01 message structure (see chapter 15.3.1). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b> </li>
		                 * <li>4: EVN (Event Type) <b> </b> </li>
		                 * <li>5: STF (Staff Identification) <b> </b> </li>
		                 * <li>6: PRA (Practitioner Detail) <b>optional repeating</b> </li>
		                 * <li>7: ORG (Practitioner Organization Unit) <b>optional repeating</b> </li>
		                 * <li>8: AFF (Professional Affiliation) <b>optional repeating</b> </li>
		                 * <li>9: LAN (Language Detail) <b>optional repeating</b> </li>
		                 * <li>10: EDU (Educational Detail) <b>optional repeating</b> </li>
		                 * <li>11: CER (Certificate Detail) <b>optional repeating</b> </li>
		                 * <li>12: NK1 (Next of Kin / Associated Parties) <b>optional repeating</b> </li>
		                 * <li>13: PRT (Participation Information) <b>optional repeating</b> </li>
		                 * <li>14: ROL (Role) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PMU_B01 extends AbstractMessage  {

    /**
     * Creates a new PMU_B01 message with DefaultModelClassFactory. 
     */ 
    public PMU_B01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new PMU_B01 message with custom ModelClassFactory.
     */
    public PMU_B01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(UAC.class, false, false);
	                          this.add(EVN.class, true, false);
	                          this.add(STF.class, true, false);
	                          this.add(PRA.class, false, true);
	                          this.add(ORG.class, false, true);
	                          this.add(AFF.class, false, true);
	                          this.add(LAN.class, false, true);
	                          this.add(EDU.class, false, true);
	                          this.add(CER.class, false, true);
	                          this.add(NK1.class, false, true);
	                          this.add(PRT.class, false, true);
	                          this.add(ROL.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating PMU_B01 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.8.1"
     */
    public String getVersion() {
       return "2.8.1";
    }




    /**
     * <p>
     * Returns
     * MSH (Message Header) - creates it if necessary
     * </p>
     * 
     *
     */
    public MSH getMSH() { 
       return getTyped("MSH", MSH.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * SFT (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public SFT getSFT() { 
       return getTyped("SFT", SFT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * SFT (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SFT getSFT(int rep) { 
       return getTyped("SFT", rep, SFT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of SFT 
     * </p>
     * 
     */ 
    public int getSFTReps() { 
    	return getReps("SFT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SFT.
     * <p>
     * <p>
     * Note that unlike {@link #getSFT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SFT> getSFTAll() throws HL7Exception {
    	return getAllAsList("SFT", SFT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSFT(SFT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SFT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SFT insertSFT(int rep) throws HL7Exception { 
       return (SFT)super.insertRepetition("SFT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SFT removeSFT(int rep) throws HL7Exception { 
       return (SFT)super.removeRepetition("SFT", rep);
    }




    /**
     * <p>
     * Returns
     * UAC (User Authentication Credential Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public UAC getUAC() { 
       return getTyped("UAC", UAC.class);
    }





    /**
     * <p>
     * Returns
     * EVN (Event Type) - creates it if necessary
     * </p>
     * 
     *
     */
    public EVN getEVN() { 
       return getTyped("EVN", EVN.class);
    }





    /**
     * <p>
     * Returns
     * STF (Staff Identification) - creates it if necessary
     * </p>
     * 
     *
     */
    public STF getSTF() { 
       return getTyped("STF", STF.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PRA (Practitioner Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public PRA getPRA() { 
       return getTyped("PRA", PRA.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PRA (Practitioner Detail) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRA getPRA(int rep) { 
       return getTyped("PRA", rep, PRA.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PRA 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<PRA> getPRAAll() throws HL7Exception {
    	return getAllAsList("PRA", PRA.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRA(PRA structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRA", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRA insertPRA(int rep) throws HL7Exception { 
       return (PRA)super.insertRepetition("PRA", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PRA (Practitioner Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRA removePRA(int rep) throws HL7Exception { 
       return (PRA)super.removeRepetition("PRA", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * ORG (Practitioner Organization Unit) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORG getORG() { 
       return getTyped("ORG", ORG.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ORG (Practitioner Organization Unit) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORG getORG(int rep) { 
       return getTyped("ORG", rep, ORG.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ORG 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<ORG> getORGAll() throws HL7Exception {
    	return getAllAsList("ORG", ORG.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ORG (Practitioner Organization Unit)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORG(ORG structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ORG", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ORG (Practitioner Organization Unit)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORG insertORG(int rep) throws HL7Exception { 
       return (ORG)super.insertRepetition("ORG", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ORG (Practitioner Organization Unit)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORG removeORG(int rep) throws HL7Exception { 
       return (ORG)super.removeRepetition("ORG", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * AFF (Professional Affiliation) - creates it if necessary
     * </p>
     * 
     *
     */
    public AFF getAFF() { 
       return getTyped("AFF", AFF.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * AFF (Professional Affiliation) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AFF getAFF(int rep) { 
       return getTyped("AFF", rep, AFF.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of AFF 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<AFF> getAFFAll() throws HL7Exception {
    	return getAllAsList("AFF", AFF.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of AFF (Professional Affiliation)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAFF(AFF structure, int rep) throws HL7Exception { 
       super.insertRepetition( "AFF", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of AFF (Professional Affiliation)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AFF insertAFF(int rep) throws HL7Exception { 
       return (AFF)super.insertRepetition("AFF", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of AFF (Professional Affiliation)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AFF removeAFF(int rep) throws HL7Exception { 
       return (AFF)super.removeRepetition("AFF", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * LAN (Language Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public LAN getLAN() { 
       return getTyped("LAN", LAN.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * LAN (Language Detail) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LAN getLAN(int rep) { 
       return getTyped("LAN", rep, LAN.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of LAN 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<LAN> getLANAll() throws HL7Exception {
    	return getAllAsList("LAN", LAN.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of LAN (Language Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLAN(LAN structure, int rep) throws HL7Exception { 
       super.insertRepetition( "LAN", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of LAN (Language Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LAN insertLAN(int rep) throws HL7Exception { 
       return (LAN)super.insertRepetition("LAN", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of LAN (Language Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LAN removeLAN(int rep) throws HL7Exception { 
       return (LAN)super.removeRepetition("LAN", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * EDU (Educational Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public EDU getEDU() { 
       return getTyped("EDU", EDU.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * EDU (Educational Detail) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EDU getEDU(int rep) { 
       return getTyped("EDU", rep, EDU.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of EDU 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<EDU> getEDUAll() throws HL7Exception {
    	return getAllAsList("EDU", EDU.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of EDU (Educational Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertEDU(EDU structure, int rep) throws HL7Exception { 
       super.insertRepetition( "EDU", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of EDU (Educational Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EDU insertEDU(int rep) throws HL7Exception { 
       return (EDU)super.insertRepetition("EDU", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of EDU (Educational Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EDU removeEDU(int rep) throws HL7Exception { 
       return (EDU)super.removeRepetition("EDU", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * CER (Certificate Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public CER getCER() { 
       return getTyped("CER", CER.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * CER (Certificate Detail) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CER getCER(int rep) { 
       return getTyped("CER", rep, CER.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of CER 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<CER> getCERAll() throws HL7Exception {
    	return getAllAsList("CER", CER.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of CER (Certificate Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCER(CER structure, int rep) throws HL7Exception { 
       super.insertRepetition( "CER", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of CER (Certificate Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CER insertCER(int rep) throws HL7Exception { 
       return (CER)super.insertRepetition("CER", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of CER (Certificate Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CER removeCER(int rep) throws HL7Exception { 
       return (CER)super.removeRepetition("CER", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     * </p>
     * 
     *
     */
    public NK1 getNK1() { 
       return getTyped("NK1", NK1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       return getTyped("NK1", rep, NK1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NK1 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NK1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NK1 (Next of Kin / Associated Parties)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PRT (Participation Information) - creates it if necessary
     * </p>
     * 
     *
     */
    public PRT getPRT() { 
       return getTyped("PRT", PRT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PRT (Participation Information) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRT getPRT(int rep) { 
       return getTyped("PRT", rep, PRT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PRT 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<PRT> getPRTAll() throws HL7Exception {
    	return getAllAsList("PRT", PRT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PRT (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PRT (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PRT (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     * </p>
     * 
     *
     */
    public ROL getROL() { 
       return getTyped("ROL", ROL.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       return getTyped("ROL", rep, ROL.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ROL 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ROL (Role)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ROL", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ROL (Role)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ROL (Role)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



}

