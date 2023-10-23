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
 * <p>Represents a MFN_M05_MF_LOCATION group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: MFE (Master File Entry) <b>  </b></li>
                         * <li>2: LOC (Location Identification) <b>  </b></li>
                         * <li>3: LCH (Location Characteristic) <b>optional repeating </b></li>
                         * <li>4: LRL (Location Relationship) <b>optional repeating </b></li>
                         * <li>5: MFN_M05_MF_LOC_DEPT (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M05_MF_LOCATION extends AbstractGroup {

    /** 
     * Creates a new MFN_M05_MF_LOCATION group
     */
    public MFN_M05_MF_LOCATION(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(MFE.class, true, false, false);
                                  this.add(LOC.class, true, false, false);
                                  this.add(LCH.class, false, true, false);
                                  this.add(LRL.class, false, true, false);
                                  this.add(MFN_M05_MF_LOC_DEPT.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M05_MF_LOCATION - this is probably a bug in the source code generator.", e);
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
     * MF_LOC_DEPT (a Group object) - creates it if necessary
     */
    public MFN_M05_MF_LOC_DEPT getMF_LOC_DEPT() { 
       MFN_M05_MF_LOC_DEPT retVal = getTyped("MF_LOC_DEPT", MFN_M05_MF_LOC_DEPT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * MF_LOC_DEPT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M05_MF_LOC_DEPT getMF_LOC_DEPT(int rep) { 
       MFN_M05_MF_LOC_DEPT retVal = getTyped("MF_LOC_DEPT", rep, MFN_M05_MF_LOC_DEPT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of MF_LOC_DEPT 
     */ 
    public int getMF_LOC_DEPTReps() {  
        return getReps("MF_LOC_DEPT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MF_LOC_DEPT.
     * <p>
     * <p>
     * Note that unlike {@link #getMF_LOC_DEPT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<MFN_M05_MF_LOC_DEPT> getMF_LOC_DEPTAll() throws HL7Exception {
    	return getAllAsList("MF_LOC_DEPT", MFN_M05_MF_LOC_DEPT.class);
    } 

    /**
     * Inserts a specific repetition of MF_LOC_DEPT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMF_LOC_DEPT(MFN_M05_MF_LOC_DEPT structure, int rep) throws HL7Exception { 
       super.insertRepetition("MF_LOC_DEPT", structure, rep);
    }


    /**
     * Inserts a specific repetition of MF_LOC_DEPT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M05_MF_LOC_DEPT insertMF_LOC_DEPT(int rep) throws HL7Exception { 
       return (MFN_M05_MF_LOC_DEPT)super.insertRepetition("MF_LOC_DEPT", rep);
    }


    /**
     * Removes a specific repetition of MF_LOC_DEPT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M05_MF_LOC_DEPT removeMF_LOC_DEPT(int rep) throws HL7Exception { 
       return (MFN_M05_MF_LOC_DEPT)super.removeRepetition("MF_LOC_DEPT", rep);
    }



}

