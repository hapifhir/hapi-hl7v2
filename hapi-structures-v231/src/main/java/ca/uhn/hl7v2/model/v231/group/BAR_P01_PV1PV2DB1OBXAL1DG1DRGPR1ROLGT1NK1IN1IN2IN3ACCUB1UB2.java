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


package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a BAR_P01_PV1PV2DB1OBXAL1DG1DRGPR1ROLGT1NK1IN1IN2IN3ACCUB1UB2 group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PV1 (PV1 - patient visit segment-) <b>optional  </b></li>
                         * <li>2: PV2 (PV2 - patient visit - additional information segment) <b>optional  </b></li>
                         * <li>3: DB1 (DB1 - Disability segment) <b>optional repeating </b></li>
                         * <li>4: OBX (OBX - observation/result segment) <b>optional repeating </b></li>
                         * <li>5: AL1 (AL1 - patient allergy information segment) <b>optional repeating </b></li>
                         * <li>6: DG1 (DG1 - diagnosis segment) <b>optional repeating </b></li>
                         * <li>7: DRG (DRG - diagnosis related group segment) <b>optional  </b></li>
                         * <li>8: BAR_P01_PR1ROL (a Group object) <b>optional repeating </b></li>
                         * <li>9: GT1 (GT1 - guarantor segment) <b>optional repeating </b></li>
                         * <li>10: NK1 (NK1 - next of kin / associated parties segment-) <b>optional repeating </b></li>
                         * <li>11: BAR_P01_IN1IN2IN3 (a Group object) <b>optional repeating </b></li>
                         * <li>12: ACC (ACC - accident segment) <b>optional  </b></li>
                         * <li>13: UB1 (UB1 - UB82 data segment) <b>optional  </b></li>
                         * <li>14: UB2 (UB2 - UB92 data segment) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class BAR_P01_PV1PV2DB1OBXAL1DG1DRGPR1ROLGT1NK1IN1IN2IN3ACCUB1UB2 extends AbstractGroup {

    /** 
     * Creates a new BAR_P01_PV1PV2DB1OBXAL1DG1DRGPR1ROLGT1NK1IN1IN2IN3ACCUB1UB2 group
     */
    public BAR_P01_PV1PV2DB1OBXAL1DG1DRGPR1ROLGT1NK1IN1IN2IN3ACCUB1UB2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PV1.class, false, false, false);
                                  this.add(PV2.class, false, false, false);
                                  this.add(DB1.class, false, true, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(AL1.class, false, true, false);
                                  this.add(DG1.class, false, true, false);
                                  this.add(DRG.class, false, false, false);
                                  this.add(BAR_P01_PR1ROL.class, false, true, false);
                                  this.add(GT1.class, false, true, false);
                                  this.add(NK1.class, false, true, false);
                                  this.add(BAR_P01_IN1IN2IN3.class, false, true, false);
                                  this.add(ACC.class, false, false, false);
                                  this.add(UB1.class, false, false, false);
                                  this.add(UB2.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BAR_P01_PV1PV2DB1OBXAL1DG1DRGPR1ROLGT1NK1IN1IN2IN3ACCUB1UB2 - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }



    /**
     * Returns
     * PV1 (PV1 - patient visit segment-) - creates it if necessary
     */
    public PV1 getPV1() { 
       PV1 retVal = getTyped("PV1", PV1.class);
       return retVal;
    }




    /**
     * Returns
     * PV2 (PV2 - patient visit - additional information segment) - creates it if necessary
     */
    public PV2 getPV2() { 
       PV2 retVal = getTyped("PV2", PV2.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * DB1 (DB1 - Disability segment) - creates it if necessary
     */
    public DB1 getDB1() { 
       DB1 retVal = getTyped("DB1", DB1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DB1 (DB1 - Disability segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DB1 getDB1(int rep) { 
       DB1 retVal = getTyped("DB1", rep, DB1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of DB1 
     */ 
    public int getDB1Reps() {  
        return getReps("DB1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DB1.
     * <p>
     * <p>
     * Note that unlike {@link #getDB1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DB1> getDB1All() throws HL7Exception {
    	return getAllAsList("DB1", DB1.class);
    } 

    /**
     * Inserts a specific repetition of DB1 (DB1 - Disability segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB1(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DB1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DB1 (DB1 - Disability segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB1(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB1", rep);
    }


    /**
     * Removes a specific repetition of DB1 (DB1 - Disability segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB1(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBX (OBX - observation/result segment) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (OBX - observation/result segment) - creates it if necessary
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
     * Inserts a specific repetition of OBX (OBX - observation/result segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (OBX - observation/result segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (OBX - observation/result segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AL1 (AL1 - patient allergy information segment) - creates it if necessary
     */
    public AL1 getAL1() { 
       AL1 retVal = getTyped("AL1", AL1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AL1 (AL1 - patient allergy information segment) - creates it if necessary
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
     * Inserts a specific repetition of AL1 (AL1 - patient allergy information segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("AL1", structure, rep);
    }


    /**
     * Inserts a specific repetition of AL1 (AL1 - patient allergy information segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * Removes a specific repetition of AL1 (AL1 - patient allergy information segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * DG1 (DG1 - diagnosis segment) - creates it if necessary
     */
    public DG1 getDG1() { 
       DG1 retVal = getTyped("DG1", DG1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DG1 (DG1 - diagnosis segment) - creates it if necessary
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
     * Inserts a specific repetition of DG1 (DG1 - diagnosis segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DG1 (DG1 - diagnosis segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * Removes a specific repetition of DG1 (DG1 - diagnosis segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }



    /**
     * Returns
     * DRG (DRG - diagnosis related group segment) - creates it if necessary
     */
    public DRG getDRG() { 
       DRG retVal = getTyped("DRG", DRG.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PR1ROL (a Group object) - creates it if necessary
     */
    public BAR_P01_PR1ROL getPR1ROL() { 
       BAR_P01_PR1ROL retVal = getTyped("PR1ROL", BAR_P01_PR1ROL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PR1ROL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public BAR_P01_PR1ROL getPR1ROL(int rep) { 
       BAR_P01_PR1ROL retVal = getTyped("PR1ROL", rep, BAR_P01_PR1ROL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PR1ROL 
     */ 
    public int getPR1ROLReps() {  
        return getReps("PR1ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PR1ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getPR1ROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<BAR_P01_PR1ROL> getPR1ROLAll() throws HL7Exception {
    	return getAllAsList("PR1ROL", BAR_P01_PR1ROL.class);
    } 

    /**
     * Inserts a specific repetition of PR1ROL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPR1ROL(BAR_P01_PR1ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition("PR1ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of PR1ROL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public BAR_P01_PR1ROL insertPR1ROL(int rep) throws HL7Exception { 
       return (BAR_P01_PR1ROL)super.insertRepetition("PR1ROL", rep);
    }


    /**
     * Removes a specific repetition of PR1ROL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public BAR_P01_PR1ROL removePR1ROL(int rep) throws HL7Exception { 
       return (BAR_P01_PR1ROL)super.removeRepetition("PR1ROL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GT1 (GT1 - guarantor segment) - creates it if necessary
     */
    public GT1 getGT1() { 
       GT1 retVal = getTyped("GT1", GT1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GT1 (GT1 - guarantor segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public GT1 getGT1(int rep) { 
       GT1 retVal = getTyped("GT1", rep, GT1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of GT1 
     */ 
    public int getGT1Reps() {  
        return getReps("GT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GT1.
     * <p>
     * <p>
     * Note that unlike {@link #getGT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<GT1> getGT1All() throws HL7Exception {
    	return getAllAsList("GT1", GT1.class);
    } 

    /**
     * Inserts a specific repetition of GT1 (GT1 - guarantor segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("GT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of GT1 (GT1 - guarantor segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * Removes a specific repetition of GT1 (GT1 - guarantor segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NK1 (NK1 - next of kin / associated parties segment-) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (NK1 - next of kin / associated parties segment-) - creates it if necessary
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
     * Inserts a specific repetition of NK1 (NK1 - next of kin / associated parties segment-)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (NK1 - next of kin / associated parties segment-)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (NK1 - next of kin / associated parties segment-)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * IN1IN2IN3 (a Group object) - creates it if necessary
     */
    public BAR_P01_IN1IN2IN3 getIN1IN2IN3() { 
       BAR_P01_IN1IN2IN3 retVal = getTyped("IN1IN2IN3", BAR_P01_IN1IN2IN3.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * IN1IN2IN3 (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public BAR_P01_IN1IN2IN3 getIN1IN2IN3(int rep) { 
       BAR_P01_IN1IN2IN3 retVal = getTyped("IN1IN2IN3", rep, BAR_P01_IN1IN2IN3.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of IN1IN2IN3 
     */ 
    public int getIN1IN2IN3Reps() {  
        return getReps("IN1IN2IN3");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of IN1IN2IN3.
     * <p>
     * <p>
     * Note that unlike {@link #getIN1IN2IN3()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<BAR_P01_IN1IN2IN3> getIN1IN2IN3All() throws HL7Exception {
    	return getAllAsList("IN1IN2IN3", BAR_P01_IN1IN2IN3.class);
    } 

    /**
     * Inserts a specific repetition of IN1IN2IN3 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertIN1IN2IN3(BAR_P01_IN1IN2IN3 structure, int rep) throws HL7Exception { 
       super.insertRepetition("IN1IN2IN3", structure, rep);
    }


    /**
     * Inserts a specific repetition of IN1IN2IN3 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public BAR_P01_IN1IN2IN3 insertIN1IN2IN3(int rep) throws HL7Exception { 
       return (BAR_P01_IN1IN2IN3)super.insertRepetition("IN1IN2IN3", rep);
    }


    /**
     * Removes a specific repetition of IN1IN2IN3 (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public BAR_P01_IN1IN2IN3 removeIN1IN2IN3(int rep) throws HL7Exception { 
       return (BAR_P01_IN1IN2IN3)super.removeRepetition("IN1IN2IN3", rep);
    }



    /**
     * Returns
     * ACC (ACC - accident segment) - creates it if necessary
     */
    public ACC getACC() { 
       ACC retVal = getTyped("ACC", ACC.class);
       return retVal;
    }




    /**
     * Returns
     * UB1 (UB1 - UB82 data segment) - creates it if necessary
     */
    public UB1 getUB1() { 
       UB1 retVal = getTyped("UB1", UB1.class);
       return retVal;
    }




    /**
     * Returns
     * UB2 (UB2 - UB92 data segment) - creates it if necessary
     */
    public UB2 getUB2() { 
       UB2 retVal = getTyped("UB2", UB2.class);
       return retVal;
    }




}

