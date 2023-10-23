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
 * <p>Represents a DFT_P11_FINANCIAL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: FT1 (Financial Transaction) <b>  </b></li>
                         * <li>2: DFT_P11_FINANCIAL_PROCEDURE (a Group object) <b>optional repeating </b></li>
                         * <li>3: DFT_P11_FINANCIAL_COMMON_ORDER (a Group object) <b>optional repeating </b></li>
                         * <li>4: DG1 (Diagnosis) <b>optional repeating </b></li>
                         * <li>5: DRG (Diagnosis Related Group) <b>optional  </b></li>
                         * <li>6: GT1 (Guarantor) <b>optional repeating </b></li>
                         * <li>7: DFT_P11_FINANCIAL_INSURANCE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class DFT_P11_FINANCIAL extends AbstractGroup {

    /** 
     * Creates a new DFT_P11_FINANCIAL group
     */
    public DFT_P11_FINANCIAL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(FT1.class, true, false, false);
                                  this.add(DFT_P11_FINANCIAL_PROCEDURE.class, false, true, false);
                                  this.add(DFT_P11_FINANCIAL_COMMON_ORDER.class, false, true, false);
                                  this.add(DG1.class, false, true, false);
                                  this.add(DRG.class, false, false, false);
                                  this.add(GT1.class, false, true, false);
                                  this.add(DFT_P11_FINANCIAL_INSURANCE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DFT_P11_FINANCIAL - this is probably a bug in the source code generator.", e);
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
     * FT1 (Financial Transaction) - creates it if necessary
     */
    public FT1 getFT1() { 
       FT1 retVal = getTyped("FT1", FT1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * FINANCIAL_PROCEDURE (a Group object) - creates it if necessary
     */
    public DFT_P11_FINANCIAL_PROCEDURE getFINANCIAL_PROCEDURE() { 
       DFT_P11_FINANCIAL_PROCEDURE retVal = getTyped("FINANCIAL_PROCEDURE", DFT_P11_FINANCIAL_PROCEDURE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FINANCIAL_PROCEDURE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P11_FINANCIAL_PROCEDURE getFINANCIAL_PROCEDURE(int rep) { 
       DFT_P11_FINANCIAL_PROCEDURE retVal = getTyped("FINANCIAL_PROCEDURE", rep, DFT_P11_FINANCIAL_PROCEDURE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FINANCIAL_PROCEDURE 
     */ 
    public int getFINANCIAL_PROCEDUREReps() {  
        return getReps("FINANCIAL_PROCEDURE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FINANCIAL_PROCEDURE.
     * <p>
     * <p>
     * Note that unlike {@link #getFINANCIAL_PROCEDURE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DFT_P11_FINANCIAL_PROCEDURE> getFINANCIAL_PROCEDUREAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_PROCEDURE", DFT_P11_FINANCIAL_PROCEDURE.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_PROCEDURE(DFT_P11_FINANCIAL_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_PROCEDURE", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P11_FINANCIAL_PROCEDURE insertFINANCIAL_PROCEDURE(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_PROCEDURE)super.insertRepetition("FINANCIAL_PROCEDURE", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_PROCEDURE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P11_FINANCIAL_PROCEDURE removeFINANCIAL_PROCEDURE(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_PROCEDURE)super.removeRepetition("FINANCIAL_PROCEDURE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * FINANCIAL_COMMON_ORDER (a Group object) - creates it if necessary
     */
    public DFT_P11_FINANCIAL_COMMON_ORDER getFINANCIAL_COMMON_ORDER() { 
       DFT_P11_FINANCIAL_COMMON_ORDER retVal = getTyped("FINANCIAL_COMMON_ORDER", DFT_P11_FINANCIAL_COMMON_ORDER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FINANCIAL_COMMON_ORDER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P11_FINANCIAL_COMMON_ORDER getFINANCIAL_COMMON_ORDER(int rep) { 
       DFT_P11_FINANCIAL_COMMON_ORDER retVal = getTyped("FINANCIAL_COMMON_ORDER", rep, DFT_P11_FINANCIAL_COMMON_ORDER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FINANCIAL_COMMON_ORDER 
     */ 
    public int getFINANCIAL_COMMON_ORDERReps() {  
        return getReps("FINANCIAL_COMMON_ORDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FINANCIAL_COMMON_ORDER.
     * <p>
     * <p>
     * Note that unlike {@link #getFINANCIAL_COMMON_ORDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DFT_P11_FINANCIAL_COMMON_ORDER> getFINANCIAL_COMMON_ORDERAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_COMMON_ORDER", DFT_P11_FINANCIAL_COMMON_ORDER.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_COMMON_ORDER(DFT_P11_FINANCIAL_COMMON_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_COMMON_ORDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P11_FINANCIAL_COMMON_ORDER insertFINANCIAL_COMMON_ORDER(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_COMMON_ORDER)super.insertRepetition("FINANCIAL_COMMON_ORDER", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_COMMON_ORDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P11_FINANCIAL_COMMON_ORDER removeFINANCIAL_COMMON_ORDER(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_COMMON_ORDER)super.removeRepetition("FINANCIAL_COMMON_ORDER", rep);
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
     * FINANCIAL_INSURANCE (a Group object) - creates it if necessary
     */
    public DFT_P11_FINANCIAL_INSURANCE getFINANCIAL_INSURANCE() { 
       DFT_P11_FINANCIAL_INSURANCE retVal = getTyped("FINANCIAL_INSURANCE", DFT_P11_FINANCIAL_INSURANCE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FINANCIAL_INSURANCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DFT_P11_FINANCIAL_INSURANCE getFINANCIAL_INSURANCE(int rep) { 
       DFT_P11_FINANCIAL_INSURANCE retVal = getTyped("FINANCIAL_INSURANCE", rep, DFT_P11_FINANCIAL_INSURANCE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FINANCIAL_INSURANCE 
     */ 
    public int getFINANCIAL_INSURANCEReps() {  
        return getReps("FINANCIAL_INSURANCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FINANCIAL_INSURANCE.
     * <p>
     * <p>
     * Note that unlike {@link #getFINANCIAL_INSURANCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DFT_P11_FINANCIAL_INSURANCE> getFINANCIAL_INSURANCEAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_INSURANCE", DFT_P11_FINANCIAL_INSURANCE.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_INSURANCE(DFT_P11_FINANCIAL_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_INSURANCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_INSURANCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P11_FINANCIAL_INSURANCE insertFINANCIAL_INSURANCE(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_INSURANCE)super.insertRepetition("FINANCIAL_INSURANCE", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_INSURANCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P11_FINANCIAL_INSURANCE removeFINANCIAL_INSURANCE(int rep) throws HL7Exception { 
       return (DFT_P11_FINANCIAL_INSURANCE)super.removeRepetition("FINANCIAL_INSURANCE", rep);
    }



}

