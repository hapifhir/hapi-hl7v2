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


package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a MFN_M16_MATERIAL_ITEM_RECORD group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: MFE (Master File Entry) <b>  </b></li>
                         * <li>2: ITM (Material Item) <b>  </b></li>
                         * <li>3: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>4: MFN_M16_STERILIZATION (a Group object) <b>optional repeating </b></li>
                         * <li>5: MFN_M16_PURCHASING_VENDOR (a Group object) <b>optional repeating </b></li>
                         * <li>6: MFN_M16_MATERIAL_LOCATION (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M16_MATERIAL_ITEM_RECORD extends AbstractGroup {

    /** 
     * Creates a new MFN_M16_MATERIAL_ITEM_RECORD group
     */
    public MFN_M16_MATERIAL_ITEM_RECORD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(MFE.class, true, false, false);
                                  this.add(ITM.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(MFN_M16_STERILIZATION.class, false, true, false);
                                  this.add(MFN_M16_PURCHASING_VENDOR.class, false, true, false);
                                  this.add(MFN_M16_MATERIAL_LOCATION.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M16_MATERIAL_ITEM_RECORD - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.6"
     */
    public String getVersion() {
       return "2.6";
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
     * ITM (Material Item) - creates it if necessary
     */
    public ITM getITM() { 
       ITM retVal = getTyped("ITM", ITM.class);
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
     * STERILIZATION (a Group object) - creates it if necessary
     */
    public MFN_M16_STERILIZATION getSTERILIZATION() { 
       MFN_M16_STERILIZATION retVal = getTyped("STERILIZATION", MFN_M16_STERILIZATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * STERILIZATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M16_STERILIZATION getSTERILIZATION(int rep) { 
       MFN_M16_STERILIZATION retVal = getTyped("STERILIZATION", rep, MFN_M16_STERILIZATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of STERILIZATION 
     */ 
    public int getSTERILIZATIONReps() {  
        return getReps("STERILIZATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of STERILIZATION.
     * <p>
     * <p>
     * Note that unlike {@link #getSTERILIZATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<MFN_M16_STERILIZATION> getSTERILIZATIONAll() throws HL7Exception {
    	return getAllAsList("STERILIZATION", MFN_M16_STERILIZATION.class);
    } 

    /**
     * Inserts a specific repetition of STERILIZATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSTERILIZATION(MFN_M16_STERILIZATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("STERILIZATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of STERILIZATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M16_STERILIZATION insertSTERILIZATION(int rep) throws HL7Exception { 
       return (MFN_M16_STERILIZATION)super.insertRepetition("STERILIZATION", rep);
    }


    /**
     * Removes a specific repetition of STERILIZATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M16_STERILIZATION removeSTERILIZATION(int rep) throws HL7Exception { 
       return (MFN_M16_STERILIZATION)super.removeRepetition("STERILIZATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PURCHASING_VENDOR (a Group object) - creates it if necessary
     */
    public MFN_M16_PURCHASING_VENDOR getPURCHASING_VENDOR() { 
       MFN_M16_PURCHASING_VENDOR retVal = getTyped("PURCHASING_VENDOR", MFN_M16_PURCHASING_VENDOR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PURCHASING_VENDOR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M16_PURCHASING_VENDOR getPURCHASING_VENDOR(int rep) { 
       MFN_M16_PURCHASING_VENDOR retVal = getTyped("PURCHASING_VENDOR", rep, MFN_M16_PURCHASING_VENDOR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PURCHASING_VENDOR 
     */ 
    public int getPURCHASING_VENDORReps() {  
        return getReps("PURCHASING_VENDOR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PURCHASING_VENDOR.
     * <p>
     * <p>
     * Note that unlike {@link #getPURCHASING_VENDOR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<MFN_M16_PURCHASING_VENDOR> getPURCHASING_VENDORAll() throws HL7Exception {
    	return getAllAsList("PURCHASING_VENDOR", MFN_M16_PURCHASING_VENDOR.class);
    } 

    /**
     * Inserts a specific repetition of PURCHASING_VENDOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPURCHASING_VENDOR(MFN_M16_PURCHASING_VENDOR structure, int rep) throws HL7Exception { 
       super.insertRepetition("PURCHASING_VENDOR", structure, rep);
    }


    /**
     * Inserts a specific repetition of PURCHASING_VENDOR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M16_PURCHASING_VENDOR insertPURCHASING_VENDOR(int rep) throws HL7Exception { 
       return (MFN_M16_PURCHASING_VENDOR)super.insertRepetition("PURCHASING_VENDOR", rep);
    }


    /**
     * Removes a specific repetition of PURCHASING_VENDOR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M16_PURCHASING_VENDOR removePURCHASING_VENDOR(int rep) throws HL7Exception { 
       return (MFN_M16_PURCHASING_VENDOR)super.removeRepetition("PURCHASING_VENDOR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * MATERIAL_LOCATION (a Group object) - creates it if necessary
     */
    public MFN_M16_MATERIAL_LOCATION getMATERIAL_LOCATION() { 
       MFN_M16_MATERIAL_LOCATION retVal = getTyped("MATERIAL_LOCATION", MFN_M16_MATERIAL_LOCATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * MATERIAL_LOCATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M16_MATERIAL_LOCATION getMATERIAL_LOCATION(int rep) { 
       MFN_M16_MATERIAL_LOCATION retVal = getTyped("MATERIAL_LOCATION", rep, MFN_M16_MATERIAL_LOCATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of MATERIAL_LOCATION 
     */ 
    public int getMATERIAL_LOCATIONReps() {  
        return getReps("MATERIAL_LOCATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MATERIAL_LOCATION.
     * <p>
     * <p>
     * Note that unlike {@link #getMATERIAL_LOCATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<MFN_M16_MATERIAL_LOCATION> getMATERIAL_LOCATIONAll() throws HL7Exception {
    	return getAllAsList("MATERIAL_LOCATION", MFN_M16_MATERIAL_LOCATION.class);
    } 

    /**
     * Inserts a specific repetition of MATERIAL_LOCATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMATERIAL_LOCATION(MFN_M16_MATERIAL_LOCATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("MATERIAL_LOCATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of MATERIAL_LOCATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M16_MATERIAL_LOCATION insertMATERIAL_LOCATION(int rep) throws HL7Exception { 
       return (MFN_M16_MATERIAL_LOCATION)super.insertRepetition("MATERIAL_LOCATION", rep);
    }


    /**
     * Removes a specific repetition of MATERIAL_LOCATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M16_MATERIAL_LOCATION removeMATERIAL_LOCATION(int rep) throws HL7Exception { 
       return (MFN_M16_MATERIAL_LOCATION)super.removeRepetition("MATERIAL_LOCATION", rep);
    }



}

