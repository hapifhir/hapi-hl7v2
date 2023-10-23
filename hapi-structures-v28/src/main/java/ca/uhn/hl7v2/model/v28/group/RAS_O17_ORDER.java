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
 * <p>Represents a RAS_O17_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>3: RAS_O17_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>4: RAS_O17_ORDER_DETAIL (a Group object) <b>optional  </b></li>
                         * <li>5: RAS_O17_ENCODING (a Group object) <b>optional  </b></li>
                         * <li>6: RAS_O17_ADMINISTRATION (a Group object) <b> repeating </b></li>
                         * <li>7: CTI (Clinical Trial Identification) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RAS_O17_ORDER extends AbstractGroup {

    /** 
     * Creates a new RAS_O17_ORDER group
     */
    public RAS_O17_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(RAS_O17_TIMING.class, false, true, false);
                                  this.add(RAS_O17_ORDER_DETAIL.class, false, false, false);
                                  this.add(RAS_O17_ENCODING.class, false, false, false);
                                  this.add(RAS_O17_ADMINISTRATION.class, true, true, false);
                                  this.add(CTI.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RAS_O17_ORDER - this is probably a bug in the source code generator.", e);
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
    public RAS_O17_TIMING getTIMING() { 
       RAS_O17_TIMING retVal = getTyped("TIMING", RAS_O17_TIMING.class);
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
    public RAS_O17_TIMING getTIMING(int rep) { 
       RAS_O17_TIMING retVal = getTyped("TIMING", rep, RAS_O17_TIMING.class);
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
    public java.util.List<RAS_O17_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", RAS_O17_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(RAS_O17_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RAS_O17_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (RAS_O17_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RAS_O17_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (RAS_O17_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * ORDER_DETAIL (a Group object) - creates it if necessary
     */
    public RAS_O17_ORDER_DETAIL getORDER_DETAIL() { 
       RAS_O17_ORDER_DETAIL retVal = getTyped("ORDER_DETAIL", RAS_O17_ORDER_DETAIL.class);
       return retVal;
    }




    /**
     * Returns
     * ENCODING (a Group object) - creates it if necessary
     */
    public RAS_O17_ENCODING getENCODING() { 
       RAS_O17_ENCODING retVal = getTyped("ENCODING", RAS_O17_ENCODING.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ADMINISTRATION (a Group object) - creates it if necessary
     */
    public RAS_O17_ADMINISTRATION getADMINISTRATION() { 
       RAS_O17_ADMINISTRATION retVal = getTyped("ADMINISTRATION", RAS_O17_ADMINISTRATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ADMINISTRATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RAS_O17_ADMINISTRATION getADMINISTRATION(int rep) { 
       RAS_O17_ADMINISTRATION retVal = getTyped("ADMINISTRATION", rep, RAS_O17_ADMINISTRATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ADMINISTRATION 
     */ 
    public int getADMINISTRATIONReps() {  
        return getReps("ADMINISTRATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ADMINISTRATION.
     * <p>
     * <p>
     * Note that unlike {@link #getADMINISTRATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RAS_O17_ADMINISTRATION> getADMINISTRATIONAll() throws HL7Exception {
    	return getAllAsList("ADMINISTRATION", RAS_O17_ADMINISTRATION.class);
    } 

    /**
     * Inserts a specific repetition of ADMINISTRATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertADMINISTRATION(RAS_O17_ADMINISTRATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("ADMINISTRATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of ADMINISTRATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RAS_O17_ADMINISTRATION insertADMINISTRATION(int rep) throws HL7Exception { 
       return (RAS_O17_ADMINISTRATION)super.insertRepetition("ADMINISTRATION", rep);
    }


    /**
     * Removes a specific repetition of ADMINISTRATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RAS_O17_ADMINISTRATION removeADMINISTRATION(int rep) throws HL7Exception { 
       return (RAS_O17_ADMINISTRATION)super.removeRepetition("ADMINISTRATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CTI (Clinical Trial Identification) - creates it if necessary
     */
    public CTI getCTI() { 
       CTI retVal = getTyped("CTI", CTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CTI (Clinical Trial Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CTI getCTI(int rep) { 
       CTI retVal = getTyped("CTI", rep, CTI.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CTI 
     */ 
    public int getCTIReps() {  
        return getReps("CTI");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CTI.
     * <p>
     * <p>
     * Note that unlike {@link #getCTI()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CTI> getCTIAll() throws HL7Exception {
    	return getAllAsList("CTI", CTI.class);
    } 

    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTI(CTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("CTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTI insertCTI(int rep) throws HL7Exception { 
       return (CTI)super.insertRepetition("CTI", rep);
    }


    /**
     * Removes a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTI removeCTI(int rep) throws HL7Exception { 
       return (CTI)super.removeRepetition("CTI", rep);
    }



}

