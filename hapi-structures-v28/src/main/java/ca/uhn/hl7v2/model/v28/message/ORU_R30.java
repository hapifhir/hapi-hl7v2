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


package ca.uhn.hl7v2.model.v28.message;

import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a ORU_R30 message structure (see chapter 7.3.4). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b> </li>
		                 * <li>4: PID (Patient Identification) <b> </b> </li>
		                 * <li>5: PD1 (Patient Additional Demographic) <b>optional </b> </li>
		                 * <li>6: PRT (Participation Information) <b>optional repeating</b> </li>
		                 * <li>7: ARV (Access Restriction) <b>optional repeating</b> </li>
		                 * <li>8: ORU_R30_PATIENT_OBSERVATION (a Group object) <b>optional repeating</b> </li>
		                 * <li>9: ORU_R30_VISIT (a Group object) <b>optional </b> </li>
		                 * <li>10: ORC (Common Order) <b> </b> </li>
		                 * <li>11: PRT (Participation Information) <b>optional repeating</b> </li>
		                 * <li>12: OBR (Observation Request) <b> </b> </li>
		                 * <li>13: NTE (Notes and Comments) <b>optional repeating</b> </li>
		                 * <li>14: PRT (Participation Information) <b>optional repeating</b> </li>
		                 * <li>15: ORU_R30_TIMING_QTY (a Group object) <b>optional repeating</b> </li>
		                 * <li>16: ORU_R30_OBSERVATION (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORU_R30 extends AbstractMessage  {

    /**
     * Creates a new ORU_R30 message with DefaultModelClassFactory. 
     */ 
    public ORU_R30() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new ORU_R30 message with custom ModelClassFactory.
     */
    public ORU_R30(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(UAC.class, false, false);
	                          this.add(PID.class, true, false);
	                          this.add(PD1.class, false, false);
	                          this.add(PRT.class, false, true);
	                          this.add(ARV.class, false, true);
	                          this.add(ORU_R30_PATIENT_OBSERVATION.class, false, true);
	                          this.add(ORU_R30_VISIT.class, false, false);
	                          this.add(ORC.class, true, false);
	                          this.add(PRT.class, false, true);
	                          this.add(OBR.class, true, false);
	                          this.add(NTE.class, false, true);
	                          this.add(PRT.class, false, true);
	                          this.add(ORU_R30_TIMING_QTY.class, false, true);
	                          this.add(ORU_R30_OBSERVATION.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORU_R30 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
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
     * PID (Patient Identification) - creates it if necessary
     * </p>
     * 
     *
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }





    /**
     * <p>
     * Returns
     * PD1 (Patient Additional Demographic) - creates it if necessary
     * </p>
     * 
     *
     */
    public PD1 getPD1() { 
       return getTyped("PD1", PD1.class);
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
     * ARV (Access Restriction) - creates it if necessary
     * </p>
     * 
     *
     */
    public ARV getARV() { 
       return getTyped("ARV", ARV.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ARV (Access Restriction) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ARV getARV(int rep) { 
       return getTyped("ARV", rep, ARV.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ARV 
     * </p>
     * 
     */ 
    public int getARVReps() { 
    	return getReps("ARV");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ARV.
     * <p>
     * <p>
     * Note that unlike {@link #getARV()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ARV> getARVAll() throws HL7Exception {
    	return getAllAsList("ARV", ARV.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ARV (Access Restriction)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertARV(ARV structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ARV", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ARV (Access Restriction)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ARV insertARV(int rep) throws HL7Exception { 
       return (ARV)super.insertRepetition("ARV", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ARV (Access Restriction)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ARV removeARV(int rep) throws HL7Exception { 
       return (ARV)super.removeRepetition("ARV", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PATIENT_OBSERVATION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORU_R30_PATIENT_OBSERVATION getPATIENT_OBSERVATION() { 
       return getTyped("PATIENT_OBSERVATION", ORU_R30_PATIENT_OBSERVATION.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATIENT_OBSERVATION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORU_R30_PATIENT_OBSERVATION getPATIENT_OBSERVATION(int rep) { 
       return getTyped("PATIENT_OBSERVATION", rep, ORU_R30_PATIENT_OBSERVATION.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATIENT_OBSERVATION 
     * </p>
     * 
     */ 
    public int getPATIENT_OBSERVATIONReps() { 
    	return getReps("PATIENT_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ORU_R30_PATIENT_OBSERVATION> getPATIENT_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("PATIENT_OBSERVATION", ORU_R30_PATIENT_OBSERVATION.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT_OBSERVATION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT_OBSERVATION(ORU_R30_PATIENT_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATIENT_OBSERVATION", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATIENT_OBSERVATION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R30_PATIENT_OBSERVATION insertPATIENT_OBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R30_PATIENT_OBSERVATION)super.insertRepetition("PATIENT_OBSERVATION", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATIENT_OBSERVATION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R30_PATIENT_OBSERVATION removePATIENT_OBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R30_PATIENT_OBSERVATION)super.removeRepetition("PATIENT_OBSERVATION", rep);
    }




    /**
     * <p>
     * Returns
     * VISIT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORU_R30_VISIT getVISIT() { 
       return getTyped("VISIT", ORU_R30_VISIT.class);
    }





    /**
     * <p>
     * Returns
     * ORC (Common Order) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORC getORC() { 
       return getTyped("ORC", ORC.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PRT2 (Participation Information) - creates it if necessary
     * </p>
     * 
     *
     */
    public PRT getPRT2() { 
       return getTyped("PRT2", PRT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PRT2 (Participation Information) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRT getPRT2(int rep) { 
       return getTyped("PRT2", rep, PRT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PRT2 
     * </p>
     * 
     */ 
    public int getPRT2Reps() { 
    	return getReps("PRT2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRT2.
     * <p>
     * <p>
     * Note that unlike {@link #getPRT2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<PRT> getPRT2All() throws HL7Exception {
    	return getAllAsList("PRT2", PRT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PRT2 (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT2(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRT2", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PRT2 (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT2(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT2", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PRT2 (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT2(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT2", rep);
    }




    /**
     * <p>
     * Returns
     * OBR (Observation Request) - creates it if necessary
     * </p>
     * 
     *
     */
    public OBR getOBR() { 
       return getTyped("OBR", OBR.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     * </p>
     * 
     *
     */
    public NTE getNTE() { 
       return getTyped("NTE", NTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NTE (Notes and Comments) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       return getTyped("NTE", rep, NTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NTE 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NTE (Notes and Comments)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NTE (Notes and Comments)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NTE (Notes and Comments)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PRT3 (Participation Information) - creates it if necessary
     * </p>
     * 
     *
     */
    public PRT getPRT3() { 
       return getTyped("PRT3", PRT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PRT3 (Participation Information) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRT getPRT3(int rep) { 
       return getTyped("PRT3", rep, PRT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PRT3 
     * </p>
     * 
     */ 
    public int getPRT3Reps() { 
    	return getReps("PRT3");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRT3.
     * <p>
     * <p>
     * Note that unlike {@link #getPRT3()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<PRT> getPRT3All() throws HL7Exception {
    	return getAllAsList("PRT3", PRT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PRT3 (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT3(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRT3", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PRT3 (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT3(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT3", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PRT3 (Participation Information)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT3(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT3", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * TIMING_QTY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORU_R30_TIMING_QTY getTIMING_QTY() { 
       return getTyped("TIMING_QTY", ORU_R30_TIMING_QTY.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * TIMING_QTY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORU_R30_TIMING_QTY getTIMING_QTY(int rep) { 
       return getTyped("TIMING_QTY", rep, ORU_R30_TIMING_QTY.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of TIMING_QTY 
     * </p>
     * 
     */ 
    public int getTIMING_QTYReps() { 
    	return getReps("TIMING_QTY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING_QTY.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING_QTY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ORU_R30_TIMING_QTY> getTIMING_QTYAll() throws HL7Exception {
    	return getAllAsList("TIMING_QTY", ORU_R30_TIMING_QTY.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of TIMING_QTY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING_QTY(ORU_R30_TIMING_QTY structure, int rep) throws HL7Exception { 
       super.insertRepetition( "TIMING_QTY", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of TIMING_QTY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R30_TIMING_QTY insertTIMING_QTY(int rep) throws HL7Exception { 
       return (ORU_R30_TIMING_QTY)super.insertRepetition("TIMING_QTY", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of TIMING_QTY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R30_TIMING_QTY removeTIMING_QTY(int rep) throws HL7Exception { 
       return (ORU_R30_TIMING_QTY)super.removeRepetition("TIMING_QTY", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORU_R30_OBSERVATION getOBSERVATION() { 
       return getTyped("OBSERVATION", ORU_R30_OBSERVATION.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBSERVATION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORU_R30_OBSERVATION getOBSERVATION(int rep) { 
       return getTyped("OBSERVATION", rep, ORU_R30_OBSERVATION.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBSERVATION 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<ORU_R30_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", ORU_R30_OBSERVATION.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(ORU_R30_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBSERVATION", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R30_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R30_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBSERVATION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R30_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R30_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
    }



}

