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


package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a RRI_I12 message structure. This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: MSA (MSA - message acknowledgment segment) <b>optional </b> </li>
		                 * <li>3: RF1 (Referral Infomation) <b>optional </b> </li>
		                 * <li>4: RRI_I12_AUTCTD (a Group object) <b>optional </b> </li>
		                 * <li>5: RRI_I12_PRDCTD (a Group object) <b> repeating</b> </li>
		                 * <li>6: PID (PID - patient identification segment) <b> </b> </li>
		                 * <li>7: ACC (ACC - accident segment) <b>optional </b> </li>
		                 * <li>8: DG1 (DG1 - diagnosis segment) <b>optional repeating</b> </li>
		                 * <li>9: DRG (DRG - diagnosis related group segment) <b>optional repeating</b> </li>
		                 * <li>10: AL1 (AL1 - patient allergy information segment) <b>optional repeating</b> </li>
		                 * <li>11: RRI_I12_PR1AUTCTD (a Group object) <b>optional repeating</b> </li>
		                 * <li>12: RRI_I12_OBRNTEOBXNTE (a Group object) <b>optional repeating</b> </li>
		                 * <li>13: RRI_I12_PV1PV2 (a Group object) <b>optional </b> </li>
		                 * <li>14: NTE (NTE - notes and comments segment) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RRI_I12 extends AbstractMessage  {

    /**
     * Creates a new RRI_I12 message with DefaultModelClassFactory. 
     */ 
    public RRI_I12() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RRI_I12 message with custom ModelClassFactory.
     */
    public RRI_I12(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, false, false);
	                          this.add(RF1.class, false, false);
	                          this.add(RRI_I12_AUTCTD.class, false, false);
	                          this.add(RRI_I12_PRDCTD.class, true, true);
	                          this.add(PID.class, true, false);
	                          this.add(ACC.class, false, false);
	                          this.add(DG1.class, false, true);
	                          this.add(DRG.class, false, true);
	                          this.add(AL1.class, false, true);
	                          this.add(RRI_I12_PR1AUTCTD.class, false, true);
	                          this.add(RRI_I12_OBRNTEOBXNTE.class, false, true);
	                          this.add(RRI_I12_PV1PV2.class, false, false);
	                          this.add(NTE.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating RRI_I12 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }




    /**
     * <p>
     * Returns
     * MSH (MSH - message header segment) - creates it if necessary
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
     * MSA (MSA - message acknowledgment segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public MSA getMSA() { 
       return getTyped("MSA", MSA.class);
    }





    /**
     * <p>
     * Returns
     * RF1 (Referral Infomation) - creates it if necessary
     * </p>
     * 
     *
     */
    public RF1 getRF1() { 
       return getTyped("RF1", RF1.class);
    }





    /**
     * <p>
     * Returns
     * AUTCTD (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RRI_I12_AUTCTD getAUTCTD() { 
       return getTyped("AUTCTD", RRI_I12_AUTCTD.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PRDCTD (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RRI_I12_PRDCTD getPRDCTD() { 
       return getTyped("PRDCTD", RRI_I12_PRDCTD.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PRDCTD (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRI_I12_PRDCTD getPRDCTD(int rep) { 
       return getTyped("PRDCTD", rep, RRI_I12_PRDCTD.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PRDCTD 
     * </p>
     * 
     */ 
    public int getPRDCTDReps() { 
    	return getReps("PRDCTD");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRDCTD.
     * <p>
     * <p>
     * Note that unlike {@link #getPRDCTD()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RRI_I12_PRDCTD> getPRDCTDAll() throws HL7Exception {
    	return getAllAsList("PRDCTD", RRI_I12_PRDCTD.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PRDCTD (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRDCTD(RRI_I12_PRDCTD structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRDCTD", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PRDCTD (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRI_I12_PRDCTD insertPRDCTD(int rep) throws HL7Exception { 
       return (RRI_I12_PRDCTD)super.insertRepetition("PRDCTD", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PRDCTD (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRI_I12_PRDCTD removePRDCTD(int rep) throws HL7Exception { 
       return (RRI_I12_PRDCTD)super.removeRepetition("PRDCTD", rep);
    }




    /**
     * <p>
     * Returns
     * PID (PID - patient identification segment) - creates it if necessary
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
     * ACC (ACC - accident segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public ACC getACC() { 
       return getTyped("ACC", ACC.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * DG1 (DG1 - diagnosis segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public DG1 getDG1() { 
       return getTyped("DG1", DG1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DG1 (DG1 - diagnosis segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DG1 getDG1(int rep) { 
       return getTyped("DG1", rep, DG1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DG1 
     * </p>
     * 
     */ 
    public int getDG1Reps() { 
    	return getReps("DG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DG1.
     * <p>
     * <p>
     * Note that unlike {@link #getDG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<DG1> getDG1All() throws HL7Exception {
    	return getAllAsList("DG1", DG1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DG1 (DG1 - diagnosis segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DG1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DG1 (DG1 - diagnosis segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DG1 (DG1 - diagnosis segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * DRG (DRG - diagnosis related group segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public DRG getDRG() { 
       return getTyped("DRG", DRG.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DRG (DRG - diagnosis related group segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DRG getDRG(int rep) { 
       return getTyped("DRG", rep, DRG.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DRG 
     * </p>
     * 
     */ 
    public int getDRGReps() { 
    	return getReps("DRG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DRG.
     * <p>
     * <p>
     * Note that unlike {@link #getDRG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<DRG> getDRGAll() throws HL7Exception {
    	return getAllAsList("DRG", DRG.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DRG (DRG - diagnosis related group segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDRG(DRG structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DRG", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DRG (DRG - diagnosis related group segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DRG insertDRG(int rep) throws HL7Exception { 
       return (DRG)super.insertRepetition("DRG", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DRG (DRG - diagnosis related group segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DRG removeDRG(int rep) throws HL7Exception { 
       return (DRG)super.removeRepetition("DRG", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * AL1 (AL1 - patient allergy information segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public AL1 getAL1() { 
       return getTyped("AL1", AL1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * AL1 (AL1 - patient allergy information segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AL1 getAL1(int rep) { 
       return getTyped("AL1", rep, AL1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of AL1 
     * </p>
     * 
     */ 
    public int getAL1Reps() { 
    	return getReps("AL1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AL1.
     * <p>
     * <p>
     * Note that unlike {@link #getAL1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<AL1> getAL1All() throws HL7Exception {
    	return getAllAsList("AL1", AL1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of AL1 (AL1 - patient allergy information segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "AL1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of AL1 (AL1 - patient allergy information segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of AL1 (AL1 - patient allergy information segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PR1AUTCTD (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RRI_I12_PR1AUTCTD getPR1AUTCTD() { 
       return getTyped("PR1AUTCTD", RRI_I12_PR1AUTCTD.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PR1AUTCTD (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRI_I12_PR1AUTCTD getPR1AUTCTD(int rep) { 
       return getTyped("PR1AUTCTD", rep, RRI_I12_PR1AUTCTD.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PR1AUTCTD 
     * </p>
     * 
     */ 
    public int getPR1AUTCTDReps() { 
    	return getReps("PR1AUTCTD");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PR1AUTCTD.
     * <p>
     * <p>
     * Note that unlike {@link #getPR1AUTCTD()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RRI_I12_PR1AUTCTD> getPR1AUTCTDAll() throws HL7Exception {
    	return getAllAsList("PR1AUTCTD", RRI_I12_PR1AUTCTD.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PR1AUTCTD (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPR1AUTCTD(RRI_I12_PR1AUTCTD structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PR1AUTCTD", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PR1AUTCTD (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRI_I12_PR1AUTCTD insertPR1AUTCTD(int rep) throws HL7Exception { 
       return (RRI_I12_PR1AUTCTD)super.insertRepetition("PR1AUTCTD", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PR1AUTCTD (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRI_I12_PR1AUTCTD removePR1AUTCTD(int rep) throws HL7Exception { 
       return (RRI_I12_PR1AUTCTD)super.removeRepetition("PR1AUTCTD", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBRNTEOBXNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RRI_I12_OBRNTEOBXNTE getOBRNTEOBXNTE() { 
       return getTyped("OBRNTEOBXNTE", RRI_I12_OBRNTEOBXNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBRNTEOBXNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RRI_I12_OBRNTEOBXNTE getOBRNTEOBXNTE(int rep) { 
       return getTyped("OBRNTEOBXNTE", rep, RRI_I12_OBRNTEOBXNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBRNTEOBXNTE 
     * </p>
     * 
     */ 
    public int getOBRNTEOBXNTEReps() { 
    	return getReps("OBRNTEOBXNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBRNTEOBXNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getOBRNTEOBXNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RRI_I12_OBRNTEOBXNTE> getOBRNTEOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBRNTEOBXNTE", RRI_I12_OBRNTEOBXNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBRNTEOBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBRNTEOBXNTE(RRI_I12_OBRNTEOBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBRNTEOBXNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBRNTEOBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RRI_I12_OBRNTEOBXNTE insertOBRNTEOBXNTE(int rep) throws HL7Exception { 
       return (RRI_I12_OBRNTEOBXNTE)super.insertRepetition("OBRNTEOBXNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBRNTEOBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RRI_I12_OBRNTEOBXNTE removeOBRNTEOBXNTE(int rep) throws HL7Exception { 
       return (RRI_I12_OBRNTEOBXNTE)super.removeRepetition("OBRNTEOBXNTE", rep);
    }




    /**
     * <p>
     * Returns
     * PV1PV2 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RRI_I12_PV1PV2 getPV1PV2() { 
       return getTyped("PV1PV2", RRI_I12_PV1PV2.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NTE (NTE - notes and comments segment) - creates it if necessary
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
     * NTE (NTE - notes and comments segment) - creates it if necessary
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
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
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
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
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
     * Removes a specific repetition of NTE (NTE - notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



}

