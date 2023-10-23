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


package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ORU_R01_ORDER_OBSERVATION group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>optional  </b></li>
                         * <li>2: OBR (Observation Request) <b>  </b></li>
                         * <li>3: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>4: CTD (Contact Data) <b>optional  </b></li>
                         * <li>5: ORU_R01_OBSERVATION (a Group object) <b> repeating </b></li>
                         * <li>6: FT1 (Financial Transaction) <b>optional repeating </b></li>
                         * <li>7: CTI (Clinical Trial Identification) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORU_R01_ORDER_OBSERVATION extends AbstractGroup {

    /** 
     * Creates a new ORU_R01_ORDER_OBSERVATION group
     */
    public ORU_R01_ORDER_OBSERVATION(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, false, false, false);
                                  this.add(OBR.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(CTD.class, false, false, false);
                                  this.add(ORU_R01_OBSERVATION.class, true, true, false);
                                  this.add(FT1.class, false, true, false);
                                  this.add(CTI.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORU_R01_ORDER_OBSERVATION - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.4"
     */
    public String getVersion() {
       return "2.4";
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
     * CTD (Contact Data) - creates it if necessary
     */
    public CTD getCTD() { 
       CTD retVal = getTyped("CTD", CTD.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public ORU_R01_OBSERVATION getOBSERVATION() { 
       ORU_R01_OBSERVATION retVal = getTyped("OBSERVATION", ORU_R01_OBSERVATION.class);
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
    public ORU_R01_OBSERVATION getOBSERVATION(int rep) { 
       ORU_R01_OBSERVATION retVal = getTyped("OBSERVATION", rep, ORU_R01_OBSERVATION.class);
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
    public java.util.List<ORU_R01_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", ORU_R01_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(ORU_R01_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R01_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R01_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R01_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (ORU_R01_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
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

