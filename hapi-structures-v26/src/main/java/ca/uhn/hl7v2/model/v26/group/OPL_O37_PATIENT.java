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
 * <p>Represents a OPL_O37_PATIENT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PID (Patient Identification) <b>  </b></li>
                         * <li>2: PD1 (Patient Additional Demographic) <b>optional  </b></li>
                         * <li>3: OBX (Observation/Result) <b>optional repeating </b></li>
                         * <li>4: OPL_O37_INSURANCE (a Group object) <b>optional repeating </b></li>
                         * <li>5: AL1 (Patient Allergy Information) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OPL_O37_PATIENT extends AbstractGroup {

    /** 
     * Creates a new OPL_O37_PATIENT group
     */
    public OPL_O37_PATIENT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PID.class, true, false, false);
                                  this.add(PD1.class, false, false, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(OPL_O37_INSURANCE.class, false, true, false);
                                  this.add(AL1.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OPL_O37_PATIENT - this is probably a bug in the source code generator.", e);
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
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       PID retVal = getTyped("PID", PID.class);
       return retVal;
    }




    /**
     * Returns
     * PD1 (Patient Additional Demographic) - creates it if necessary
     */
    public PD1 getPD1() { 
       PD1 retVal = getTyped("PD1", PD1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBX (Observation/Result) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (Observation/Result) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       OBX retVal = getTyped("OBX", rep, OBX.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBX 
     */ 
    public int getOBXReps() {  
        return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * INSURANCE (a Group object) - creates it if necessary
     */
    public OPL_O37_INSURANCE getINSURANCE() { 
       OPL_O37_INSURANCE retVal = getTyped("INSURANCE", OPL_O37_INSURANCE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * INSURANCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPL_O37_INSURANCE getINSURANCE(int rep) { 
       OPL_O37_INSURANCE retVal = getTyped("INSURANCE", rep, OPL_O37_INSURANCE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of INSURANCE 
     */ 
    public int getINSURANCEReps() {  
        return getReps("INSURANCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of INSURANCE.
     * <p>
     * <p>
     * Note that unlike {@link #getINSURANCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OPL_O37_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", OPL_O37_INSURANCE.class);
    } 

    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(OPL_O37_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("INSURANCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (OPL_O37_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * Removes a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (OPL_O37_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AL1 (Patient Allergy Information) - creates it if necessary
     */
    public AL1 getAL1() { 
       AL1 retVal = getTyped("AL1", AL1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AL1 (Patient Allergy Information) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AL1 getAL1(int rep) { 
       AL1 retVal = getTyped("AL1", rep, AL1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AL1 
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
     */ 
    public java.util.List<AL1> getAL1All() throws HL7Exception {
    	return getAllAsList("AL1", AL1.class);
    } 

    /**
     * Inserts a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("AL1", structure, rep);
    }


    /**
     * Inserts a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * Removes a specific repetition of AL1 (Patient Allergy Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }



}

