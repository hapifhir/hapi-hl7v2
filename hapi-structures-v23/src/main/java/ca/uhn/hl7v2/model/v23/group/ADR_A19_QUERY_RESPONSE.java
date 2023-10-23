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


package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ADR_A19_QUERY_RESPONSE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: EVN (Event type) <b>optional  </b></li>
                         * <li>2: PID (Patient Identification) <b>  </b></li>
                         * <li>3: PD1 (Patient Demographic) <b>optional  </b></li>
                         * <li>4: NK1 (Next of kin) <b>optional repeating </b></li>
                         * <li>5: PV1 (Patient visit) <b>  </b></li>
                         * <li>6: PV2 (Patient visit - additional information) <b>optional  </b></li>
                         * <li>7: DB1 (Disability Segment) <b>optional repeating </b></li>
                         * <li>8: OBX (Observation segment) <b>optional repeating </b></li>
                         * <li>9: AL1 (Patient allergy information) <b>optional repeating </b></li>
                         * <li>10: DG1 (Diagnosis) <b>optional repeating </b></li>
                         * <li>11: DRG (Diagnosis Related Group) <b>optional  </b></li>
                         * <li>12: ADR_A19_PROCEDURE (a Group object) <b>optional repeating </b></li>
                         * <li>13: GT1 (Guarantor) <b>optional repeating </b></li>
                         * <li>14: ADR_A19_INSURANCE (a Group object) <b>optional repeating </b></li>
                         * <li>15: ACC (Accident) <b>optional  </b></li>
                         * <li>16: UB1 (UB82  data) <b>optional  </b></li>
                         * <li>17: UB2 (UB92 data) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ADR_A19_QUERY_RESPONSE extends AbstractGroup {

    /** 
     * Creates a new ADR_A19_QUERY_RESPONSE group
     */
    public ADR_A19_QUERY_RESPONSE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EVN.class, false, false, false);
                                  this.add(PID.class, true, false, false);
                                  this.add(PD1.class, false, false, false);
                                  this.add(NK1.class, false, true, false);
                                  this.add(PV1.class, true, false, false);
                                  this.add(PV2.class, false, false, false);
                                  this.add(DB1.class, false, true, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(AL1.class, false, true, false);
                                  this.add(DG1.class, false, true, false);
                                  this.add(DRG.class, false, false, false);
                                  this.add(ADR_A19_PROCEDURE.class, false, true, false);
                                  this.add(GT1.class, false, true, false);
                                  this.add(ADR_A19_INSURANCE.class, false, true, false);
                                  this.add(ACC.class, false, false, false);
                                  this.add(UB1.class, false, false, false);
                                  this.add(UB2.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ADR_A19_QUERY_RESPONSE - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3"
     */
    public String getVersion() {
       return "2.3";
    }



    /**
     * Returns
     * EVN (Event type) - creates it if necessary
     */
    public EVN getEVN() { 
       EVN retVal = getTyped("EVN", EVN.class);
       return retVal;
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
     * PD1 (Patient Demographic) - creates it if necessary
     */
    public PD1 getPD1() { 
       PD1 retVal = getTyped("PD1", PD1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NK1 (Next of kin) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (Next of kin) - creates it if necessary
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
     * Inserts a specific repetition of NK1 (Next of kin)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (Next of kin)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (Next of kin)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }



    /**
     * Returns
     * PV1 (Patient visit) - creates it if necessary
     */
    public PV1 getPV1() { 
       PV1 retVal = getTyped("PV1", PV1.class);
       return retVal;
    }




    /**
     * Returns
     * PV2 (Patient visit - additional information) - creates it if necessary
     */
    public PV2 getPV2() { 
       PV2 retVal = getTyped("PV2", PV2.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * DB1 (Disability Segment) - creates it if necessary
     */
    public DB1 getDB1() { 
       DB1 retVal = getTyped("DB1", DB1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DB1 (Disability Segment) - creates it if necessary
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
     * Inserts a specific repetition of DB1 (Disability Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB1(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DB1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DB1 (Disability Segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB1(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB1", rep);
    }


    /**
     * Removes a specific repetition of DB1 (Disability Segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB1(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBX (Observation segment) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (Observation segment) - creates it if necessary
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
     * Inserts a specific repetition of OBX (Observation segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (Observation segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (Observation segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AL1 (Patient allergy information) - creates it if necessary
     */
    public AL1 getAL1() { 
       AL1 retVal = getTyped("AL1", AL1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AL1 (Patient allergy information) - creates it if necessary
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
     * Inserts a specific repetition of AL1 (Patient allergy information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("AL1", structure, rep);
    }


    /**
     * Inserts a specific repetition of AL1 (Patient allergy information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * Removes a specific repetition of AL1 (Patient allergy information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * DG1 (Diagnosis) - creates it if necessary
     */
    public DG1 getDG1() { 
       DG1 retVal = getTyped("DG1", DG1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DG1 (Diagnosis) - creates it if necessary
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
     * Inserts a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * Removes a specific repetition of DG1 (Diagnosis)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }



    /**
     * Returns
     * DRG (Diagnosis Related Group) - creates it if necessary
     */
    public DRG getDRG() { 
       DRG retVal = getTyped("DRG", DRG.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PROCEDURE (a Group object) - creates it if necessary
     */
    public ADR_A19_PROCEDURE getPROCEDURE() { 
       ADR_A19_PROCEDURE retVal = getTyped("PROCEDURE", ADR_A19_PROCEDURE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PROCEDURE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ADR_A19_PROCEDURE getPROCEDURE(int rep) { 
       ADR_A19_PROCEDURE retVal = getTyped("PROCEDURE", rep, ADR_A19_PROCEDURE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PROCEDURE 
     */ 
    public int getPROCEDUREReps() {  
        return getReps("PROCEDURE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROCEDURE.
     * <p>
     * <p>
     * Note that unlike {@link #getPROCEDURE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ADR_A19_PROCEDURE> getPROCEDUREAll() throws HL7Exception {
    	return getAllAsList("PROCEDURE", ADR_A19_PROCEDURE.class);
    } 

    /**
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROCEDURE(ADR_A19_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition("PROCEDURE", structure, rep);
    }


    /**
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADR_A19_PROCEDURE insertPROCEDURE(int rep) throws HL7Exception { 
       return (ADR_A19_PROCEDURE)super.insertRepetition("PROCEDURE", rep);
    }


    /**
     * Removes a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADR_A19_PROCEDURE removePROCEDURE(int rep) throws HL7Exception { 
       return (ADR_A19_PROCEDURE)super.removeRepetition("PROCEDURE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GT1 (Guarantor) - creates it if necessary
     */
    public GT1 getGT1() { 
       GT1 retVal = getTyped("GT1", GT1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GT1 (Guarantor) - creates it if necessary
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
     * Inserts a specific repetition of GT1 (Guarantor)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("GT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of GT1 (Guarantor)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * Removes a specific repetition of GT1 (Guarantor)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * INSURANCE (a Group object) - creates it if necessary
     */
    public ADR_A19_INSURANCE getINSURANCE() { 
       ADR_A19_INSURANCE retVal = getTyped("INSURANCE", ADR_A19_INSURANCE.class);
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
    public ADR_A19_INSURANCE getINSURANCE(int rep) { 
       ADR_A19_INSURANCE retVal = getTyped("INSURANCE", rep, ADR_A19_INSURANCE.class);
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
    public java.util.List<ADR_A19_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", ADR_A19_INSURANCE.class);
    } 

    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(ADR_A19_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("INSURANCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADR_A19_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (ADR_A19_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * Removes a specific repetition of INSURANCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADR_A19_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (ADR_A19_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }



    /**
     * Returns
     * ACC (Accident) - creates it if necessary
     */
    public ACC getACC() { 
       ACC retVal = getTyped("ACC", ACC.class);
       return retVal;
    }




    /**
     * Returns
     * UB1 (UB82  data) - creates it if necessary
     */
    public UB1 getUB1() { 
       UB1 retVal = getTyped("UB1", UB1.class);
       return retVal;
    }




    /**
     * Returns
     * UB2 (UB92 data) - creates it if necessary
     */
    public UB2 getUB2() { 
       UB2 retVal = getTyped("UB2", UB2.class);
       return retVal;
    }




}

