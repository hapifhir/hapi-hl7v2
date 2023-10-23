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


package ca.uhn.hl7v2.model.v21.group;

import ca.uhn.hl7v2.model.v21.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a BAR_P01_VISIT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PV1 (PATIENT VISIT) <b>optional  </b></li>
                         * <li>2: DG1 (DIAGNOSIS) <b>optional repeating </b></li>
                         * <li>3: PR1 (PROCEDURES) <b>optional repeating </b></li>
                         * <li>4: GT1 (GUARANTOR) <b>optional repeating </b></li>
                         * <li>5: NK1 (NEXT OF KIN) <b>optional repeating </b></li>
                         * <li>6: IN1 (INSURANCE) <b>optional repeating </b></li>
                         * <li>7: ACC (ACCIDENT) <b>optional  </b></li>
                         * <li>8: UB1 (UB82 DATA) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class BAR_P01_VISIT extends AbstractGroup {

    /** 
     * Creates a new BAR_P01_VISIT group
     */
    public BAR_P01_VISIT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PV1.class, false, false, false);
                                  this.add(DG1.class, false, true, false);
                                  this.add(PR1.class, false, true, false);
                                  this.add(GT1.class, false, true, false);
                                  this.add(NK1.class, false, true, false);
                                  this.add(IN1.class, false, true, false);
                                  this.add(ACC.class, false, false, false);
                                  this.add(UB1.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating BAR_P01_VISIT - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.1"
     */
    public String getVersion() {
       return "2.1";
    }



    /**
     * Returns
     * PV1 (PATIENT VISIT) - creates it if necessary
     */
    public PV1 getPV1() { 
       PV1 retVal = getTyped("PV1", PV1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * DG1 (DIAGNOSIS) - creates it if necessary
     */
    public DG1 getDG1() { 
       DG1 retVal = getTyped("DG1", DG1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DG1 (DIAGNOSIS) - creates it if necessary
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
     * Inserts a specific repetition of DG1 (DIAGNOSIS)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DG1 (DIAGNOSIS)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * Removes a specific repetition of DG1 (DIAGNOSIS)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PR1 (PROCEDURES) - creates it if necessary
     */
    public PR1 getPR1() { 
       PR1 retVal = getTyped("PR1", PR1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PR1 (PROCEDURES) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PR1 getPR1(int rep) { 
       PR1 retVal = getTyped("PR1", rep, PR1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PR1 
     */ 
    public int getPR1Reps() {  
        return getReps("PR1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PR1.
     * <p>
     * <p>
     * Note that unlike {@link #getPR1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PR1> getPR1All() throws HL7Exception {
    	return getAllAsList("PR1", PR1.class);
    } 

    /**
     * Inserts a specific repetition of PR1 (PROCEDURES)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPR1(PR1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("PR1", structure, rep);
    }


    /**
     * Inserts a specific repetition of PR1 (PROCEDURES)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PR1 insertPR1(int rep) throws HL7Exception { 
       return (PR1)super.insertRepetition("PR1", rep);
    }


    /**
     * Removes a specific repetition of PR1 (PROCEDURES)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PR1 removePR1(int rep) throws HL7Exception { 
       return (PR1)super.removeRepetition("PR1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GT1 (GUARANTOR) - creates it if necessary
     */
    public GT1 getGT1() { 
       GT1 retVal = getTyped("GT1", GT1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GT1 (GUARANTOR) - creates it if necessary
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
     * Inserts a specific repetition of GT1 (GUARANTOR)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("GT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of GT1 (GUARANTOR)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * Removes a specific repetition of GT1 (GUARANTOR)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NK1 (NEXT OF KIN) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (NEXT OF KIN) - creates it if necessary
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
     * Inserts a specific repetition of NK1 (NEXT OF KIN)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (NEXT OF KIN)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (NEXT OF KIN)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * IN1 (INSURANCE) - creates it if necessary
     */
    public IN1 getIN1() { 
       IN1 retVal = getTyped("IN1", IN1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * IN1 (INSURANCE) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public IN1 getIN1(int rep) { 
       IN1 retVal = getTyped("IN1", rep, IN1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of IN1 
     */ 
    public int getIN1Reps() {  
        return getReps("IN1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of IN1.
     * <p>
     * <p>
     * Note that unlike {@link #getIN1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<IN1> getIN1All() throws HL7Exception {
    	return getAllAsList("IN1", IN1.class);
    } 

    /**
     * Inserts a specific repetition of IN1 (INSURANCE)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertIN1(IN1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("IN1", structure, rep);
    }


    /**
     * Inserts a specific repetition of IN1 (INSURANCE)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public IN1 insertIN1(int rep) throws HL7Exception { 
       return (IN1)super.insertRepetition("IN1", rep);
    }


    /**
     * Removes a specific repetition of IN1 (INSURANCE)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public IN1 removeIN1(int rep) throws HL7Exception { 
       return (IN1)super.removeRepetition("IN1", rep);
    }



    /**
     * Returns
     * ACC (ACCIDENT) - creates it if necessary
     */
    public ACC getACC() { 
       ACC retVal = getTyped("ACC", ACC.class);
       return retVal;
    }




    /**
     * Returns
     * UB1 (UB82 DATA) - creates it if necessary
     */
    public UB1 getUB1() { 
       UB1 retVal = getTyped("UB1", UB1.class);
       return retVal;
    }




}

