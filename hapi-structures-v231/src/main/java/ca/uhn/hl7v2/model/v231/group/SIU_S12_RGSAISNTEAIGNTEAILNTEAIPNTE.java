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
 * <p>Represents a SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RGS (RGS - resource group segment) <b>  </b></li>
                         * <li>2: SIU_S12_AISNTE (a Group object) <b>optional repeating </b></li>
                         * <li>3: SIU_S12_AIGNTE (a Group object) <b>optional repeating </b></li>
                         * <li>4: SIU_S12_AILNTE (a Group object) <b>optional repeating </b></li>
                         * <li>5: SIU_S12_AIPNTE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE extends AbstractGroup {

    /** 
     * Creates a new SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE group
     */
    public SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RGS.class, true, false, false);
                                  this.add(SIU_S12_AISNTE.class, false, true, false);
                                  this.add(SIU_S12_AIGNTE.class, false, true, false);
                                  this.add(SIU_S12_AILNTE.class, false, true, false);
                                  this.add(SIU_S12_AIPNTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE - this is probably a bug in the source code generator.", e);
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
     * RGS (RGS - resource group segment) - creates it if necessary
     */
    public RGS getRGS() { 
       RGS retVal = getTyped("RGS", RGS.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * AISNTE (a Group object) - creates it if necessary
     */
    public SIU_S12_AISNTE getAISNTE() { 
       SIU_S12_AISNTE retVal = getTyped("AISNTE", SIU_S12_AISNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AISNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S12_AISNTE getAISNTE(int rep) { 
       SIU_S12_AISNTE retVal = getTyped("AISNTE", rep, SIU_S12_AISNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AISNTE 
     */ 
    public int getAISNTEReps() {  
        return getReps("AISNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AISNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAISNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SIU_S12_AISNTE> getAISNTEAll() throws HL7Exception {
    	return getAllAsList("AISNTE", SIU_S12_AISNTE.class);
    } 

    /**
     * Inserts a specific repetition of AISNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAISNTE(SIU_S12_AISNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AISNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AISNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S12_AISNTE insertAISNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AISNTE)super.insertRepetition("AISNTE", rep);
    }


    /**
     * Removes a specific repetition of AISNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S12_AISNTE removeAISNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AISNTE)super.removeRepetition("AISNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AIGNTE (a Group object) - creates it if necessary
     */
    public SIU_S12_AIGNTE getAIGNTE() { 
       SIU_S12_AIGNTE retVal = getTyped("AIGNTE", SIU_S12_AIGNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AIGNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S12_AIGNTE getAIGNTE(int rep) { 
       SIU_S12_AIGNTE retVal = getTyped("AIGNTE", rep, SIU_S12_AIGNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AIGNTE 
     */ 
    public int getAIGNTEReps() {  
        return getReps("AIGNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AIGNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAIGNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SIU_S12_AIGNTE> getAIGNTEAll() throws HL7Exception {
    	return getAllAsList("AIGNTE", SIU_S12_AIGNTE.class);
    } 

    /**
     * Inserts a specific repetition of AIGNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAIGNTE(SIU_S12_AIGNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AIGNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AIGNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S12_AIGNTE insertAIGNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AIGNTE)super.insertRepetition("AIGNTE", rep);
    }


    /**
     * Removes a specific repetition of AIGNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S12_AIGNTE removeAIGNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AIGNTE)super.removeRepetition("AIGNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AILNTE (a Group object) - creates it if necessary
     */
    public SIU_S12_AILNTE getAILNTE() { 
       SIU_S12_AILNTE retVal = getTyped("AILNTE", SIU_S12_AILNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AILNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S12_AILNTE getAILNTE(int rep) { 
       SIU_S12_AILNTE retVal = getTyped("AILNTE", rep, SIU_S12_AILNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AILNTE 
     */ 
    public int getAILNTEReps() {  
        return getReps("AILNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AILNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAILNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SIU_S12_AILNTE> getAILNTEAll() throws HL7Exception {
    	return getAllAsList("AILNTE", SIU_S12_AILNTE.class);
    } 

    /**
     * Inserts a specific repetition of AILNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAILNTE(SIU_S12_AILNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AILNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AILNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S12_AILNTE insertAILNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AILNTE)super.insertRepetition("AILNTE", rep);
    }


    /**
     * Removes a specific repetition of AILNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S12_AILNTE removeAILNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AILNTE)super.removeRepetition("AILNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AIPNTE (a Group object) - creates it if necessary
     */
    public SIU_S12_AIPNTE getAIPNTE() { 
       SIU_S12_AIPNTE retVal = getTyped("AIPNTE", SIU_S12_AIPNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AIPNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S12_AIPNTE getAIPNTE(int rep) { 
       SIU_S12_AIPNTE retVal = getTyped("AIPNTE", rep, SIU_S12_AIPNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AIPNTE 
     */ 
    public int getAIPNTEReps() {  
        return getReps("AIPNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AIPNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAIPNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SIU_S12_AIPNTE> getAIPNTEAll() throws HL7Exception {
    	return getAllAsList("AIPNTE", SIU_S12_AIPNTE.class);
    } 

    /**
     * Inserts a specific repetition of AIPNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAIPNTE(SIU_S12_AIPNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AIPNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AIPNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S12_AIPNTE insertAIPNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AIPNTE)super.insertRepetition("AIPNTE", rep);
    }


    /**
     * Removes a specific repetition of AIPNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S12_AIPNTE removeAIPNTE(int rep) throws HL7Exception { 
       return (SIU_S12_AIPNTE)super.removeRepetition("AIPNTE", rep);
    }



}

