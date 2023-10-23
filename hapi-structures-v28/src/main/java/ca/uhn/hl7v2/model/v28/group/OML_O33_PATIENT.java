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
 * <p>Represents a OML_O33_PATIENT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PID (Patient Identification) <b>  </b></li>
                         * <li>2: PD1 (Patient Additional Demographic) <b>optional  </b></li>
                         * <li>3: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>4: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>5: NK1 (Next of Kin / Associated Parties) <b>optional repeating </b></li>
                         * <li>6: ARV (Access Restriction) <b>optional repeating </b></li>
                         * <li>7: OML_O33_PATIENT_VISIT (a Group object) <b>optional  </b></li>
                         * <li>8: OML_O33_INSURANCE (a Group object) <b>optional repeating </b></li>
                         * <li>9: GT1 (Guarantor) <b>optional  </b></li>
                         * <li>10: AL1 (Patient Allergy Information) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OML_O33_PATIENT extends AbstractGroup {

    /** 
     * Creates a new OML_O33_PATIENT group
     */
    public OML_O33_PATIENT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PID.class, true, false, false);
                                  this.add(PD1.class, false, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(NK1.class, false, true, false);
                                  this.add(ARV.class, false, true, false);
                                  this.add(OML_O33_PATIENT_VISIT.class, false, false, false);
                                  this.add(OML_O33_INSURANCE.class, false, true, false);
                                  this.add(GT1.class, false, false, false);
                                  this.add(AL1.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OML_O33_PATIENT - this is probably a bug in the source code generator.", e);
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
     * PD1 (Patient Additional Demographic) - creates it if necessary
     */
    public PD1 getPD1() { 
       PD1 retVal = getTyped("PD1", PD1.class);
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
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       NK1 retVal = getTyped("NK1", rep, NK1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NK1 
     */ 
    public int getNK1Reps() {  
        return getReps("NK1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NK1.
     * <p>
     * <p>
     * Note that unlike {@link #getNK1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ARV (Access Restriction) - creates it if necessary
     */
    public ARV getARV() { 
       ARV retVal = getTyped("ARV", ARV.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ARV (Access Restriction) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ARV getARV(int rep) { 
       ARV retVal = getTyped("ARV", rep, ARV.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ARV 
     */ 
    public int getARVReps() {  
        return getReps("ARV");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ARV.
     * <p>
     * <p>
     * Note that unlike {@link #getARV()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ARV> getARVAll() throws HL7Exception {
    	return getAllAsList("ARV", ARV.class);
    } 

    /**
     * Inserts a specific repetition of ARV (Access Restriction)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertARV(ARV structure, int rep) throws HL7Exception { 
       super.insertRepetition("ARV", structure, rep);
    }


    /**
     * Inserts a specific repetition of ARV (Access Restriction)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ARV insertARV(int rep) throws HL7Exception { 
       return (ARV)super.insertRepetition("ARV", rep);
    }


    /**
     * Removes a specific repetition of ARV (Access Restriction)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ARV removeARV(int rep) throws HL7Exception { 
       return (ARV)super.removeRepetition("ARV", rep);
    }



    /**
     * Returns
     * PATIENT_VISIT (a Group object) - creates it if necessary
     */
    public OML_O33_PATIENT_VISIT getPATIENT_VISIT() { 
       OML_O33_PATIENT_VISIT retVal = getTyped("PATIENT_VISIT", OML_O33_PATIENT_VISIT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * INSURANCE (a Group object) - creates it if necessary
     */
    public OML_O33_INSURANCE getINSURANCE() { 
       OML_O33_INSURANCE retVal = getTyped("INSURANCE", OML_O33_INSURANCE.class);
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
    public OML_O33_INSURANCE getINSURANCE(int rep) { 
       OML_O33_INSURANCE retVal = getTyped("INSURANCE", rep, OML_O33_INSURANCE.class);
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
    public java.util.List<OML_O33_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", OML_O33_INSURANCE.class);
    } 

    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(OML_O33_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("INSURANCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OML_O33_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (OML_O33_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * Removes a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OML_O33_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (OML_O33_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }



    /**
     * Returns
     * GT1 (Guarantor) - creates it if necessary
     */
    public GT1 getGT1() { 
       GT1 retVal = getTyped("GT1", GT1.class);
       return retVal;
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

