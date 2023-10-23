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
 * <p>Represents a MFR_M05_MF_QUERY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: MFE (Master File Entry) <b>  </b></li>
                         * <li>2: LOC (Location Identification) <b>  </b></li>
                         * <li>3: LCH (Location Characteristic) <b>optional repeating </b></li>
                         * <li>4: LRL (Location Relationship) <b>optional repeating </b></li>
                         * <li>5: LDP (Location Department) <b> repeating </b></li>
                         * <li>6: LCH (Location Characteristic) <b>optional repeating </b></li>
                         * <li>7: LCC (Location Charge Code) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFR_M05_MF_QUERY extends AbstractGroup {

    /** 
     * Creates a new MFR_M05_MF_QUERY group
     */
    public MFR_M05_MF_QUERY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(MFE.class, true, false, false);
                                  this.add(LOC.class, true, false, false);
                                  this.add(LCH.class, false, true, false);
                                  this.add(LRL.class, false, true, false);
                                  this.add(LDP.class, true, true, false);
                                  this.add(LCH.class, false, true, false);
                                  this.add(LCC.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFR_M05_MF_QUERY - this is probably a bug in the source code generator.", e);
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
     * MFE (Master File Entry) - creates it if necessary
     */
    public MFE getMFE() { 
       MFE retVal = getTyped("MFE", MFE.class);
       return retVal;
    }




    /**
     * Returns
     * LOC (Location Identification) - creates it if necessary
     */
    public LOC getLOC() { 
       LOC retVal = getTyped("LOC", LOC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * LCH (Location Characteristic) - creates it if necessary
     */
    public LCH getLCH() { 
       LCH retVal = getTyped("LCH", LCH.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LCH (Location Characteristic) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LCH getLCH(int rep) { 
       LCH retVal = getTyped("LCH", rep, LCH.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LCH 
     */ 
    public int getLCHReps() {  
        return getReps("LCH");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LCH.
     * <p>
     * <p>
     * Note that unlike {@link #getLCH()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LCH> getLCHAll() throws HL7Exception {
    	return getAllAsList("LCH", LCH.class);
    } 

    /**
     * Inserts a specific repetition of LCH (Location Characteristic)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLCH(LCH structure, int rep) throws HL7Exception { 
       super.insertRepetition("LCH", structure, rep);
    }


    /**
     * Inserts a specific repetition of LCH (Location Characteristic)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LCH insertLCH(int rep) throws HL7Exception { 
       return (LCH)super.insertRepetition("LCH", rep);
    }


    /**
     * Removes a specific repetition of LCH (Location Characteristic)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LCH removeLCH(int rep) throws HL7Exception { 
       return (LCH)super.removeRepetition("LCH", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LRL (Location Relationship) - creates it if necessary
     */
    public LRL getLRL() { 
       LRL retVal = getTyped("LRL", LRL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LRL (Location Relationship) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LRL getLRL(int rep) { 
       LRL retVal = getTyped("LRL", rep, LRL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LRL 
     */ 
    public int getLRLReps() {  
        return getReps("LRL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LRL.
     * <p>
     * <p>
     * Note that unlike {@link #getLRL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LRL> getLRLAll() throws HL7Exception {
    	return getAllAsList("LRL", LRL.class);
    } 

    /**
     * Inserts a specific repetition of LRL (Location Relationship)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLRL(LRL structure, int rep) throws HL7Exception { 
       super.insertRepetition("LRL", structure, rep);
    }


    /**
     * Inserts a specific repetition of LRL (Location Relationship)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LRL insertLRL(int rep) throws HL7Exception { 
       return (LRL)super.insertRepetition("LRL", rep);
    }


    /**
     * Removes a specific repetition of LRL (Location Relationship)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LRL removeLRL(int rep) throws HL7Exception { 
       return (LRL)super.removeRepetition("LRL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LDP (Location Department) - creates it if necessary
     */
    public LDP getLDP() { 
       LDP retVal = getTyped("LDP", LDP.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LDP (Location Department) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LDP getLDP(int rep) { 
       LDP retVal = getTyped("LDP", rep, LDP.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LDP 
     */ 
    public int getLDPReps() {  
        return getReps("LDP");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LDP.
     * <p>
     * <p>
     * Note that unlike {@link #getLDP()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LDP> getLDPAll() throws HL7Exception {
    	return getAllAsList("LDP", LDP.class);
    } 

    /**
     * Inserts a specific repetition of LDP (Location Department)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLDP(LDP structure, int rep) throws HL7Exception { 
       super.insertRepetition("LDP", structure, rep);
    }


    /**
     * Inserts a specific repetition of LDP (Location Department)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LDP insertLDP(int rep) throws HL7Exception { 
       return (LDP)super.insertRepetition("LDP", rep);
    }


    /**
     * Removes a specific repetition of LDP (Location Department)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LDP removeLDP(int rep) throws HL7Exception { 
       return (LDP)super.removeRepetition("LDP", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LCH2 (Location Characteristic) - creates it if necessary
     */
    public LCH getLCH2() { 
       LCH retVal = getTyped("LCH2", LCH.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LCH (Location Characteristic) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LCH getLCH2(int rep) { 
       LCH retVal = getTyped("LCH2", rep, LCH.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LCH2 
     */ 
    public int getLCH2Reps() {  
        return getReps("LCH2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LCH2.
     * <p>
     * <p>
     * Note that unlike {@link #getLCH2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LCH> getLCH2All() throws HL7Exception {
    	return getAllAsList("LCH2", LCH.class);
    } 

    /**
     * Inserts a specific repetition of LCH2 (Location Characteristic)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLCH2(LCH structure, int rep) throws HL7Exception { 
       super.insertRepetition("LCH2", structure, rep);
    }


    /**
     * Inserts a specific repetition of LCH2 (Location Characteristic)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LCH insertLCH2(int rep) throws HL7Exception { 
       return (LCH)super.insertRepetition("LCH2", rep);
    }


    /**
     * Removes a specific repetition of LCH2 (Location Characteristic)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LCH removeLCH2(int rep) throws HL7Exception { 
       return (LCH)super.removeRepetition("LCH2", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LCC (Location Charge Code) - creates it if necessary
     */
    public LCC getLCC() { 
       LCC retVal = getTyped("LCC", LCC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LCC (Location Charge Code) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LCC getLCC(int rep) { 
       LCC retVal = getTyped("LCC", rep, LCC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LCC 
     */ 
    public int getLCCReps() {  
        return getReps("LCC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LCC.
     * <p>
     * <p>
     * Note that unlike {@link #getLCC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LCC> getLCCAll() throws HL7Exception {
    	return getAllAsList("LCC", LCC.class);
    } 

    /**
     * Inserts a specific repetition of LCC (Location Charge Code)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLCC(LCC structure, int rep) throws HL7Exception { 
       super.insertRepetition("LCC", structure, rep);
    }


    /**
     * Inserts a specific repetition of LCC (Location Charge Code)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LCC insertLCC(int rep) throws HL7Exception { 
       return (LCC)super.insertRepetition("LCC", rep);
    }


    /**
     * Removes a specific repetition of LCC (Location Charge Code)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LCC removeLCC(int rep) throws HL7Exception { 
       return (LCC)super.removeRepetition("LCC", rep);
    }



}

