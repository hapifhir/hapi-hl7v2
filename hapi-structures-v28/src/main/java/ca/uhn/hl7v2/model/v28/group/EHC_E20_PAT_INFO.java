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
 * <p>Represents a EHC_E20_PAT_INFO group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PID (Patient Identification) <b>  choice</b></li>
                         * <li>2: ACC (Accident) <b>optional repeating choice</b></li>
                         * <li>3: EHC_E20_INSURANCE (a Group object) <b> repeating </b></li>
                         * <li>4: EHC_E20_DIAGNOSIS (a Group object) <b>optional repeating </b></li>
                         * <li>5: OBX (Observation/Result) <b>optional repeating choice</b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class EHC_E20_PAT_INFO extends AbstractGroup {

    /** 
     * Creates a new EHC_E20_PAT_INFO group
     */
    public EHC_E20_PAT_INFO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PID.class, true, false, true);
                                  this.add(ACC.class, false, true, true);
                                  this.add(EHC_E20_INSURANCE.class, true, true, false);
                                  this.add(EHC_E20_DIAGNOSIS.class, false, true, false);
                                  this.add(OBX.class, false, true, true);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E20_PAT_INFO - this is probably a bug in the source code generator.", e);
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
     * PID (Patient Identification) - creates it if necessary
     */
    public PID getPID() { 
       PID retVal = getTyped("PID", PID.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ACC (Accident) - creates it if necessary
     */
    public ACC getACC() { 
       ACC retVal = getTyped("ACC", ACC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ACC (Accident) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ACC getACC(int rep) { 
       ACC retVal = getTyped("ACC", rep, ACC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ACC 
     */ 
    public int getACCReps() {  
        return getReps("ACC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ACC.
     * <p>
     * <p>
     * Note that unlike {@link #getACC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ACC> getACCAll() throws HL7Exception {
    	return getAllAsList("ACC", ACC.class);
    } 

    /**
     * Inserts a specific repetition of ACC (Accident)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertACC(ACC structure, int rep) throws HL7Exception { 
       super.insertRepetition("ACC", structure, rep);
    }


    /**
     * Inserts a specific repetition of ACC (Accident)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ACC insertACC(int rep) throws HL7Exception { 
       return (ACC)super.insertRepetition("ACC", rep);
    }


    /**
     * Removes a specific repetition of ACC (Accident)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ACC removeACC(int rep) throws HL7Exception { 
       return (ACC)super.removeRepetition("ACC", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * INSURANCE (a Group object) - creates it if necessary
     */
    public EHC_E20_INSURANCE getINSURANCE() { 
       EHC_E20_INSURANCE retVal = getTyped("INSURANCE", EHC_E20_INSURANCE.class);
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
    public EHC_E20_INSURANCE getINSURANCE(int rep) { 
       EHC_E20_INSURANCE retVal = getTyped("INSURANCE", rep, EHC_E20_INSURANCE.class);
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
    public java.util.List<EHC_E20_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", EHC_E20_INSURANCE.class);
    } 

    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(EHC_E20_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("INSURANCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E20_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (EHC_E20_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * Removes a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E20_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (EHC_E20_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * DIAGNOSIS (a Group object) - creates it if necessary
     */
    public EHC_E20_DIAGNOSIS getDIAGNOSIS() { 
       EHC_E20_DIAGNOSIS retVal = getTyped("DIAGNOSIS", EHC_E20_DIAGNOSIS.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DIAGNOSIS (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E20_DIAGNOSIS getDIAGNOSIS(int rep) { 
       EHC_E20_DIAGNOSIS retVal = getTyped("DIAGNOSIS", rep, EHC_E20_DIAGNOSIS.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of DIAGNOSIS 
     */ 
    public int getDIAGNOSISReps() {  
        return getReps("DIAGNOSIS");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DIAGNOSIS.
     * <p>
     * <p>
     * Note that unlike {@link #getDIAGNOSIS()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E20_DIAGNOSIS> getDIAGNOSISAll() throws HL7Exception {
    	return getAllAsList("DIAGNOSIS", EHC_E20_DIAGNOSIS.class);
    } 

    /**
     * Inserts a specific repetition of DIAGNOSIS (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDIAGNOSIS(EHC_E20_DIAGNOSIS structure, int rep) throws HL7Exception { 
       super.insertRepetition("DIAGNOSIS", structure, rep);
    }


    /**
     * Inserts a specific repetition of DIAGNOSIS (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E20_DIAGNOSIS insertDIAGNOSIS(int rep) throws HL7Exception { 
       return (EHC_E20_DIAGNOSIS)super.insertRepetition("DIAGNOSIS", rep);
    }


    /**
     * Removes a specific repetition of DIAGNOSIS (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E20_DIAGNOSIS removeDIAGNOSIS(int rep) throws HL7Exception { 
       return (EHC_E20_DIAGNOSIS)super.removeRepetition("DIAGNOSIS", rep);
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



}

