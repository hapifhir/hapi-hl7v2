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


package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a OML_O21_ORDER_PRIOR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>optional  </b></li>
                         * <li>2: OBR (Observation Request) <b>  </b></li>
                         * <li>3: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>4: OML_O21_TIMING_PRIOR (a Group object) <b>optional repeating </b></li>
                         * <li>5: OML_O21_OBSERVATION_PRIOR (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OML_O21_ORDER_PRIOR extends AbstractGroup {

    /** 
     * Creates a new OML_O21_ORDER_PRIOR group
     */
    public OML_O21_ORDER_PRIOR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, false, false, false);
                                  this.add(OBR.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(OML_O21_TIMING_PRIOR.class, false, true, false);
                                  this.add(OML_O21_OBSERVATION_PRIOR.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OML_O21_ORDER_PRIOR - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5"
     */
    public String getVersion() {
       return "2.5";
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
     * TIMING_PRIOR (a Group object) - creates it if necessary
     */
    public OML_O21_TIMING_PRIOR getTIMING_PRIOR() { 
       OML_O21_TIMING_PRIOR retVal = getTyped("TIMING_PRIOR", OML_O21_TIMING_PRIOR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING_PRIOR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OML_O21_TIMING_PRIOR getTIMING_PRIOR(int rep) { 
       OML_O21_TIMING_PRIOR retVal = getTyped("TIMING_PRIOR", rep, OML_O21_TIMING_PRIOR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING_PRIOR 
     */ 
    public int getTIMING_PRIORReps() {  
        return getReps("TIMING_PRIOR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING_PRIOR.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING_PRIOR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OML_O21_TIMING_PRIOR> getTIMING_PRIORAll() throws HL7Exception {
    	return getAllAsList("TIMING_PRIOR", OML_O21_TIMING_PRIOR.class);
    } 

    /**
     * Inserts a specific repetition of TIMING_PRIOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING_PRIOR(OML_O21_TIMING_PRIOR structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING_PRIOR", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING_PRIOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OML_O21_TIMING_PRIOR insertTIMING_PRIOR(int rep) throws HL7Exception { 
       return (OML_O21_TIMING_PRIOR)super.insertRepetition("TIMING_PRIOR", rep);
    }


    /**
     * Removes a specific repetition of TIMING_PRIOR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OML_O21_TIMING_PRIOR removeTIMING_PRIOR(int rep) throws HL7Exception { 
       return (OML_O21_TIMING_PRIOR)super.removeRepetition("TIMING_PRIOR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBSERVATION_PRIOR (a Group object) - creates it if necessary
     */
    public OML_O21_OBSERVATION_PRIOR getOBSERVATION_PRIOR() { 
       OML_O21_OBSERVATION_PRIOR retVal = getTyped("OBSERVATION_PRIOR", OML_O21_OBSERVATION_PRIOR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION_PRIOR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OML_O21_OBSERVATION_PRIOR getOBSERVATION_PRIOR(int rep) { 
       OML_O21_OBSERVATION_PRIOR retVal = getTyped("OBSERVATION_PRIOR", rep, OML_O21_OBSERVATION_PRIOR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION_PRIOR 
     */ 
    public int getOBSERVATION_PRIORReps() {  
        return getReps("OBSERVATION_PRIOR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION_PRIOR.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION_PRIOR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OML_O21_OBSERVATION_PRIOR> getOBSERVATION_PRIORAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION_PRIOR", OML_O21_OBSERVATION_PRIOR.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION_PRIOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION_PRIOR(OML_O21_OBSERVATION_PRIOR structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION_PRIOR", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION_PRIOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OML_O21_OBSERVATION_PRIOR insertOBSERVATION_PRIOR(int rep) throws HL7Exception { 
       return (OML_O21_OBSERVATION_PRIOR)super.insertRepetition("OBSERVATION_PRIOR", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION_PRIOR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OML_O21_OBSERVATION_PRIOR removeOBSERVATION_PRIOR(int rep) throws HL7Exception { 
       return (OML_O21_OBSERVATION_PRIOR)super.removeRepetition("OBSERVATION_PRIOR", rep);
    }



}

