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
 * <p>Represents a SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SCH (SCH - schedule activity information segment) <b>  </b></li>
                         * <li>2: NTE (NTE - notes and comments segment) <b>optional repeating </b></li>
                         * <li>3: SRR_S01_PIDPV1PV2DG1 (a Group object) <b>optional repeating </b></li>
                         * <li>4: SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE extends AbstractGroup {

    /** 
     * Creates a new SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE group
     */
    public SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SCH.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(SRR_S01_PIDPV1PV2DG1.class, false, true, false);
                                  this.add(SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE - this is probably a bug in the source code generator.", e);
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
     * SCH (SCH - schedule activity information segment) - creates it if necessary
     */
    public SCH getSCH() { 
       SCH retVal = getTyped("SCH", SCH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (NTE - notes and comments segment) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (NTE - notes and comments segment) - creates it if necessary
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
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (NTE - notes and comments segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PIDPV1PV2DG1 (a Group object) - creates it if necessary
     */
    public SRR_S01_PIDPV1PV2DG1 getPIDPV1PV2DG1() { 
       SRR_S01_PIDPV1PV2DG1 retVal = getTyped("PIDPV1PV2DG1", SRR_S01_PIDPV1PV2DG1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PIDPV1PV2DG1 (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S01_PIDPV1PV2DG1 getPIDPV1PV2DG1(int rep) { 
       SRR_S01_PIDPV1PV2DG1 retVal = getTyped("PIDPV1PV2DG1", rep, SRR_S01_PIDPV1PV2DG1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PIDPV1PV2DG1 
     */ 
    public int getPIDPV1PV2DG1Reps() {  
        return getReps("PIDPV1PV2DG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PIDPV1PV2DG1.
     * <p>
     * <p>
     * Note that unlike {@link #getPIDPV1PV2DG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S01_PIDPV1PV2DG1> getPIDPV1PV2DG1All() throws HL7Exception {
    	return getAllAsList("PIDPV1PV2DG1", SRR_S01_PIDPV1PV2DG1.class);
    } 

    /**
     * Inserts a specific repetition of PIDPV1PV2DG1 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPIDPV1PV2DG1(SRR_S01_PIDPV1PV2DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("PIDPV1PV2DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of PIDPV1PV2DG1 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S01_PIDPV1PV2DG1 insertPIDPV1PV2DG1(int rep) throws HL7Exception { 
       return (SRR_S01_PIDPV1PV2DG1)super.insertRepetition("PIDPV1PV2DG1", rep);
    }


    /**
     * Removes a specific repetition of PIDPV1PV2DG1 (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S01_PIDPV1PV2DG1 removePIDPV1PV2DG1(int rep) throws HL7Exception { 
       return (SRR_S01_PIDPV1PV2DG1)super.removeRepetition("PIDPV1PV2DG1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) - creates it if necessary
     */
    public SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE getRGSAISNTEAIGNTEAILNTEAIPNTE() { 
       SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE retVal = getTyped("RGSAISNTEAIGNTEAILNTEAIPNTE", SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE getRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) { 
       SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE retVal = getTyped("RGSAISNTEAIGNTEAILNTEAIPNTE", rep, SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RGSAISNTEAIGNTEAILNTEAIPNTE 
     */ 
    public int getRGSAISNTEAIGNTEAILNTEAIPNTEReps() {  
        return getReps("RGSAISNTEAIGNTEAILNTEAIPNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RGSAISNTEAIGNTEAILNTEAIPNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getRGSAISNTEAIGNTEAILNTEAIPNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE> getRGSAISNTEAIGNTEAILNTEAIPNTEAll() throws HL7Exception {
    	return getAllAsList("RGSAISNTEAIGNTEAILNTEAIPNTE", SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE.class);
    } 

    /**
     * Inserts a specific repetition of RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRGSAISNTEAIGNTEAILNTEAIPNTE(SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("RGSAISNTEAIGNTEAILNTEAIPNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE insertRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) throws HL7Exception { 
       return (SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE)super.insertRepetition("RGSAISNTEAIGNTEAILNTEAIPNTE", rep);
    }


    /**
     * Removes a specific repetition of RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE removeRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) throws HL7Exception { 
       return (SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE)super.removeRepetition("RGSAISNTEAIGNTEAILNTEAIPNTE", rep);
    }



}

