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
 * <p>Represents a OPL_O37_OBSERVATION_REQUEST group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: OBR (Observation Request) <b>  </b></li>
                         * <li>3: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>4: OPL_O37_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>5: TCD (Test Code Detail) <b>optional  </b></li>
                         * <li>6: DG1 (Diagnosis) <b>optional repeating </b></li>
                         * <li>7: OPL_O37_ORDER_RELATED_OBSERVATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OPL_O37_OBSERVATION_REQUEST extends AbstractGroup {

    /** 
     * Creates a new OPL_O37_OBSERVATION_REQUEST group
     */
    public OPL_O37_OBSERVATION_REQUEST(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(OBR.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(OPL_O37_TIMING.class, false, true, false);
                                  this.add(TCD.class, false, false, false);
                                  this.add(DG1.class, false, true, false);
                                  this.add(OPL_O37_ORDER_RELATED_OBSERVATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OPL_O37_OBSERVATION_REQUEST - this is probably a bug in the source code generator.", e);
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
     * OBR (Observation Request) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
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
    public OPL_O37_TIMING getTIMING() { 
       OPL_O37_TIMING retVal = getTyped("TIMING", OPL_O37_TIMING.class);
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
    public OPL_O37_TIMING getTIMING(int rep) { 
       OPL_O37_TIMING retVal = getTyped("TIMING", rep, OPL_O37_TIMING.class);
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
    public java.util.List<OPL_O37_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", OPL_O37_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(OPL_O37_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (OPL_O37_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (OPL_O37_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * TCD (Test Code Detail) - creates it if necessary
     */
    public TCD getTCD() { 
       TCD retVal = getTyped("TCD", TCD.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * DG1 (Diagnosis) - creates it if necessary
     */
    public DG1 getDG1() { 
       DG1 retVal = getTyped("DG1", DG1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DG1 (Diagnosis) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DG1 getDG1(int rep) { 
       DG1 retVal = getTyped("DG1", rep, DG1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of DG1 
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
     */ 
    public java.util.List<DG1> getDG1All() throws HL7Exception {
    	return getAllAsList("DG1", DG1.class);
    } 

    /**
     * Inserts a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * Removes a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORDER_RELATED_OBSERVATION (a Group object) - creates it if necessary
     */
    public OPL_O37_ORDER_RELATED_OBSERVATION getORDER_RELATED_OBSERVATION() { 
       OPL_O37_ORDER_RELATED_OBSERVATION retVal = getTyped("ORDER_RELATED_OBSERVATION", OPL_O37_ORDER_RELATED_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORDER_RELATED_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPL_O37_ORDER_RELATED_OBSERVATION getORDER_RELATED_OBSERVATION(int rep) { 
       OPL_O37_ORDER_RELATED_OBSERVATION retVal = getTyped("ORDER_RELATED_OBSERVATION", rep, OPL_O37_ORDER_RELATED_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORDER_RELATED_OBSERVATION 
     */ 
    public int getORDER_RELATED_OBSERVATIONReps() {  
        return getReps("ORDER_RELATED_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORDER_RELATED_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getORDER_RELATED_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OPL_O37_ORDER_RELATED_OBSERVATION> getORDER_RELATED_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("ORDER_RELATED_OBSERVATION", OPL_O37_ORDER_RELATED_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of ORDER_RELATED_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORDER_RELATED_OBSERVATION(OPL_O37_ORDER_RELATED_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORDER_RELATED_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORDER_RELATED_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_ORDER_RELATED_OBSERVATION insertORDER_RELATED_OBSERVATION(int rep) throws HL7Exception { 
       return (OPL_O37_ORDER_RELATED_OBSERVATION)super.insertRepetition("ORDER_RELATED_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of ORDER_RELATED_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_ORDER_RELATED_OBSERVATION removeORDER_RELATED_OBSERVATION(int rep) throws HL7Exception { 
       return (OPL_O37_ORDER_RELATED_OBSERVATION)super.removeRepetition("ORDER_RELATED_OBSERVATION", rep);
    }



}

