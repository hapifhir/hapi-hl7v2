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


package ca.uhn.hl7v2.model.v251.group;

import ca.uhn.hl7v2.model.v251.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a PEX_P07_ASSOCIATED_PERSON group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: NK1 (Next of Kin / Associated Parties) <b>  </b></li>
                         * <li>2: PEX_P07_ASSOCIATED_RX_ORDER (a Group object) <b>optional  </b></li>
                         * <li>3: PEX_P07_ASSOCIATED_RX_ADMIN (a Group object) <b>optional repeating </b></li>
                         * <li>4: PRB (Problem Details) <b>optional repeating </b></li>
                         * <li>5: OBX (Observation/Result) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PEX_P07_ASSOCIATED_PERSON extends AbstractGroup {

    /** 
     * Creates a new PEX_P07_ASSOCIATED_PERSON group
     */
    public PEX_P07_ASSOCIATED_PERSON(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NK1.class, true, false, false);
                                  this.add(PEX_P07_ASSOCIATED_RX_ORDER.class, false, false, false);
                                  this.add(PEX_P07_ASSOCIATED_RX_ADMIN.class, false, true, false);
                                  this.add(PRB.class, false, true, false);
                                  this.add(OBX.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PEX_P07_ASSOCIATED_PERSON - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5.1"
     */
    public String getVersion() {
       return "2.5.1";
    }



    /**
     * Returns
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }




    /**
     * Returns
     * ASSOCIATED_RX_ORDER (a Group object) - creates it if necessary
     */
    public PEX_P07_ASSOCIATED_RX_ORDER getASSOCIATED_RX_ORDER() { 
       PEX_P07_ASSOCIATED_RX_ORDER retVal = getTyped("ASSOCIATED_RX_ORDER", PEX_P07_ASSOCIATED_RX_ORDER.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ASSOCIATED_RX_ADMIN (a Group object) - creates it if necessary
     */
    public PEX_P07_ASSOCIATED_RX_ADMIN getASSOCIATED_RX_ADMIN() { 
       PEX_P07_ASSOCIATED_RX_ADMIN retVal = getTyped("ASSOCIATED_RX_ADMIN", PEX_P07_ASSOCIATED_RX_ADMIN.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ASSOCIATED_RX_ADMIN (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PEX_P07_ASSOCIATED_RX_ADMIN getASSOCIATED_RX_ADMIN(int rep) { 
       PEX_P07_ASSOCIATED_RX_ADMIN retVal = getTyped("ASSOCIATED_RX_ADMIN", rep, PEX_P07_ASSOCIATED_RX_ADMIN.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ASSOCIATED_RX_ADMIN 
     */ 
    public int getASSOCIATED_RX_ADMINReps() {  
        return getReps("ASSOCIATED_RX_ADMIN");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ASSOCIATED_RX_ADMIN.
     * <p>
     * <p>
     * Note that unlike {@link #getASSOCIATED_RX_ADMIN()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PEX_P07_ASSOCIATED_RX_ADMIN> getASSOCIATED_RX_ADMINAll() throws HL7Exception {
    	return getAllAsList("ASSOCIATED_RX_ADMIN", PEX_P07_ASSOCIATED_RX_ADMIN.class);
    } 

    /**
     * Inserts a specific repetition of ASSOCIATED_RX_ADMIN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertASSOCIATED_RX_ADMIN(PEX_P07_ASSOCIATED_RX_ADMIN structure, int rep) throws HL7Exception { 
       super.insertRepetition("ASSOCIATED_RX_ADMIN", structure, rep);
    }


    /**
     * Inserts a specific repetition of ASSOCIATED_RX_ADMIN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PEX_P07_ASSOCIATED_RX_ADMIN insertASSOCIATED_RX_ADMIN(int rep) throws HL7Exception { 
       return (PEX_P07_ASSOCIATED_RX_ADMIN)super.insertRepetition("ASSOCIATED_RX_ADMIN", rep);
    }


    /**
     * Removes a specific repetition of ASSOCIATED_RX_ADMIN (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PEX_P07_ASSOCIATED_RX_ADMIN removeASSOCIATED_RX_ADMIN(int rep) throws HL7Exception { 
       return (PEX_P07_ASSOCIATED_RX_ADMIN)super.removeRepetition("ASSOCIATED_RX_ADMIN", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PRB (Problem Details) - creates it if necessary
     */
    public PRB getPRB() { 
       PRB retVal = getTyped("PRB", PRB.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRB (Problem Details) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRB getPRB(int rep) { 
       PRB retVal = getTyped("PRB", rep, PRB.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRB 
     */ 
    public int getPRBReps() {  
        return getReps("PRB");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRB.
     * <p>
     * <p>
     * Note that unlike {@link #getPRB()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRB> getPRBAll() throws HL7Exception {
    	return getAllAsList("PRB", PRB.class);
    } 

    /**
     * Inserts a specific repetition of PRB (Problem Details)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRB(PRB structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRB", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRB (Problem Details)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRB insertPRB(int rep) throws HL7Exception { 
       return (PRB)super.insertRepetition("PRB", rep);
    }


    /**
     * Removes a specific repetition of PRB (Problem Details)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRB removePRB(int rep) throws HL7Exception { 
       return (PRB)super.removeRepetition("PRB", rep);
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

