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
 * <p>Represents a DFT_P03_FINANCIAL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: FT1 (Financial Transaction) <b>  </b></li>
                         * <li>2: NTE (Notes and Comments) <b>optional  </b></li>
                         * <li>3: DFT_P03_FINANCIAL_PROCEDURE (a Group object) <b>optional repeating </b></li>
                         * <li>4: DFT_P03_FINANCIAL_COMMON_ORDER (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class DFT_P03_FINANCIAL extends AbstractGroup {

    /** 
     * Creates a new DFT_P03_FINANCIAL group
     */
    public DFT_P03_FINANCIAL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(FT1.class, true, false, false);
                                  this.add(NTE.class, false, false, false);
                                  this.add(DFT_P03_FINANCIAL_PROCEDURE.class, false, true, false);
                                  this.add(DFT_P03_FINANCIAL_COMMON_ORDER.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DFT_P03_FINANCIAL - this is probably a bug in the source code generator.", e);
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
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * FINANCIAL_PROCEDURE (a Group object) - creates it if necessary
     */
    public DFT_P03_FINANCIAL_PROCEDURE getFINANCIAL_PROCEDURE() { 
       DFT_P03_FINANCIAL_PROCEDURE retVal = getTyped("FINANCIAL_PROCEDURE", DFT_P03_FINANCIAL_PROCEDURE.class);
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
    public DFT_P03_FINANCIAL_PROCEDURE getFINANCIAL_PROCEDURE(int rep) { 
       DFT_P03_FINANCIAL_PROCEDURE retVal = getTyped("FINANCIAL_PROCEDURE", rep, DFT_P03_FINANCIAL_PROCEDURE.class);
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
    public java.util.List<DFT_P03_FINANCIAL_PROCEDURE> getFINANCIAL_PROCEDUREAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_PROCEDURE", DFT_P03_FINANCIAL_PROCEDURE.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_PROCEDURE(DFT_P03_FINANCIAL_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_PROCEDURE", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_FINANCIAL_PROCEDURE insertFINANCIAL_PROCEDURE(int rep) throws HL7Exception { 
       return (DFT_P03_FINANCIAL_PROCEDURE)super.insertRepetition("FINANCIAL_PROCEDURE", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_PROCEDURE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_FINANCIAL_PROCEDURE removeFINANCIAL_PROCEDURE(int rep) throws HL7Exception { 
       return (DFT_P03_FINANCIAL_PROCEDURE)super.removeRepetition("FINANCIAL_PROCEDURE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * FINANCIAL_COMMON_ORDER (a Group object) - creates it if necessary
     */
    public DFT_P03_FINANCIAL_COMMON_ORDER getFINANCIAL_COMMON_ORDER() { 
       DFT_P03_FINANCIAL_COMMON_ORDER retVal = getTyped("FINANCIAL_COMMON_ORDER", DFT_P03_FINANCIAL_COMMON_ORDER.class);
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
    public DFT_P03_FINANCIAL_COMMON_ORDER getFINANCIAL_COMMON_ORDER(int rep) { 
       DFT_P03_FINANCIAL_COMMON_ORDER retVal = getTyped("FINANCIAL_COMMON_ORDER", rep, DFT_P03_FINANCIAL_COMMON_ORDER.class);
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
    public java.util.List<DFT_P03_FINANCIAL_COMMON_ORDER> getFINANCIAL_COMMON_ORDERAll() throws HL7Exception {
    	return getAllAsList("FINANCIAL_COMMON_ORDER", DFT_P03_FINANCIAL_COMMON_ORDER.class);
    } 

    /**
     * Inserts a specific repetition of FINANCIAL_COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFINANCIAL_COMMON_ORDER(DFT_P03_FINANCIAL_COMMON_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition("FINANCIAL_COMMON_ORDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of FINANCIAL_COMMON_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DFT_P03_FINANCIAL_COMMON_ORDER insertFINANCIAL_COMMON_ORDER(int rep) throws HL7Exception { 
       return (DFT_P03_FINANCIAL_COMMON_ORDER)super.insertRepetition("FINANCIAL_COMMON_ORDER", rep);
    }


    /**
     * Removes a specific repetition of FINANCIAL_COMMON_ORDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DFT_P03_FINANCIAL_COMMON_ORDER removeFINANCIAL_COMMON_ORDER(int rep) throws HL7Exception { 
       return (DFT_P03_FINANCIAL_COMMON_ORDER)super.removeRepetition("FINANCIAL_COMMON_ORDER", rep);
    }



}

